/**
 * @author Ross Emile Aparece
 * @section 212-121B
 * Program that obtains the dates read through a text file
 * formats the dates and shows them to the user through a GUI
 */

import javax.swing.*;
import java.awt.*;

public class Date212GUI extends JFrame{
    private static Date212List dateList;
    private static final long serialVersionUID = 1L;

	/**
     * 
     * @param dateGUI our GUI to display the dates to the user in sorted and unsorted order
     * 
     */

    public static Date212GUI initialize(Date212GUI dateGUI) {
        // initiate an empty gui with a menu bar that will let the user
        // choose a file to read dates from
        dateList = new Date212List();
        dateGUI = new Date212GUI();
        dateGUI.setSize(500, 300);
        dateGUI.setLocation(660, 340);
        dateGUI.setLayout(new GridLayout(1, 2));
        dateGUI.setTitle("Dates");
        dateGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create new text areas for our sorted and unsorted lists
        Container myContentPane = dateGUI.getContentPane();
        TextArea sorted = new TextArea();
        TextArea unsorted = new TextArea();

        myContentPane.add(unsorted);
        myContentPane.add(sorted);

        //append the sorted and unsorted to their respective columns
        sorted.append("Sorted Dates:" +"\n\n");
        unsorted.append("Unsorted Dates:" + "\n\n");
        
        JMenuBar menuBar = new JMenuBar();
        dateGUI.createFMB(menuBar, sorted, unsorted);
        dateGUI.createEMB(menuBar, sorted, unsorted, dateList);
        dateGUI.setVisible(true);
        return dateGUI;
    }//initalize

    /**
     * 
     * @param menuBar menuBar to let the user select a file
     * @param sorted text area for our sorted list
     * @param unsorted text area for our unsorted list
     */
    public void createFMB(JMenuBar menuBar, TextArea sorted, TextArea unsorted) {

        JMenuItem openItem;
        JMenu fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this, sorted, unsorted);

        //open
        openItem = new JMenuItem("Open");
        openItem.addActionListener(fmh);
        fileMenu.add(openItem);
        fileMenu.addSeparator();

        //close
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(fmh);
        fileMenu.add(quitItem);

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
    }//createFMB

    private void createEMB(JMenuBar editMenuBar, TextArea sorted, TextArea unsorted, Date212List dateList) {
        JMenuItem editItem;
        JMenu editMenu = new JMenu("Edit");
        EditMenuHandler emh = new EditMenuHandler(this, sorted, unsorted, dateList);
        
        //Search
        editItem = new JMenuItem("Search");    
        editItem.addActionListener(emh);
        editMenu.add(editItem);

        //reset
        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.addActionListener(emh);
        editMenu.add(resetItem);

        setJMenuBar(editMenuBar);
        editMenuBar.add(editMenu);
  
    }//createEMB

    //return the populated dateList
    public Date212List getDateList() {
        return dateList;
    }//getDateList

    /**
    * Validates a list of date strings, displaying the valid dates in both the sorted and unsorted TextAreas
    * and showing the user the invalid dates in a JOptionPane message.
    *
    * @param list      Array of date strings to be validated.
    * @param dateGUI   The Date212GUI instance.
    * @param sorted    TextArea for displaying the sorted list of valid dates.
    * @param unsorted  TextArea for displaying the unsorted list of valid dates.
    */

    public static void printToGUI(String[] list, Date212GUI dateGUI, TextArea sorted, TextArea unsorted) {
            
    //Create an instance of Date212List
    Date212List dateList = new Date212List();

    //Validate each date and prepare the results
    String validationResults = "Invalid Dates:\n";

    for (String dateString : list) {
        try {
            Date212 date = new Date212(dateString);

            if (date.validDate(date)) {
                //Appends to both sorted and unsorted lists for valid dates
                dateList.add(date);
            } else {
                //Appends to validation results for invalid dates
                validationResults += dateString + "\n";
            }

        } catch (IllegalDate212Exception e) {
            //Append to validation results for invalid dates
            validationResults += dateString + "\n";
        }
    }

    //Clears existing content in TextAreas
    sorted.setText("Sorted Dates:\n");
    unsorted.setText("Unsorted Dates:\n");

    //Appends valid dates to sorted TextArea
    for (Date212 date : dateList.getSortedDateList()) {
        sorted.setText(sorted.getText() + date.toString() + "\n");
    }

    //Appends valid dates to unsorted TextArea
    for (Date212 date : dateList.getUnsortedDateList()) {
        unsorted.setText(unsorted.getText() + date.toString() + "\n");
    }

    //Prints invalid dates to the console
    if (!validationResults.equals("Invalid Dates:\n")) {
        System.out.println(validationResults);
    }
    }//printToGUI
}//Date212GUI