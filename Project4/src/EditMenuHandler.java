/**
 * @author Ross Emile Aparece
 * @section 212-121B
 * Program that obtains the dates read through a text file
 * formats the dates and shows them to the user through a GUI
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EditMenuHandler implements ActionListener {

    private JFrame jframe;
    private TextArea sortedTextArea;
    private TextArea unsortedTextArea;
    private Date212List dateList;

    /**
     * 
     * @param jf our JFrames for the GUI
     * @param sorted text area for displaying the dates in an unsorted order
     * @param unsorted text area for displaying dates in a sorted order
     * @param list list that contains the dates
     */
    public EditMenuHandler(JFrame jf, TextArea sorted, TextArea unsorted, Date212List list) {
        jframe = jf;
        sortedTextArea = sorted;
        unsortedTextArea = unsorted;
        dateList = list;
    }//editMenyHandler
    
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Search")) {
            performSearch();
        }
        if (menuName.equals("Reset")) {
            resetGUI();
        }
    } //actionPerformed

    /*
     * performs the search for dates that have the corressponding year
     */
    private void performSearch() {
        try{
            String yearInput = JOptionPane.showInputDialog(jframe, "Enter a year (YYYY):");
            if (yearInput.length() == 4) {
                int searchYear = Integer.parseInt(yearInput);
                displayDatesWithYear(searchYear);
            } else {
                throw new IllegalArgumentException("Entered year was invalid.");
            }
        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(jframe, "Please enter a valid year using digits (YYYY).");
        }
    }//performSearch

    /*
     * displays the dates that have the matching year to the GUI
     */
    private void displayDatesWithYear(int searchYear) {
        sortedTextArea.setText("Sorted Dates:\n");
        unsortedTextArea.setText("Unsorted Dates:\n");

        for (Date212 date : dateList.getSortedDateList()) {
            if (date.getYear() == searchYear) {
                sortedTextArea.append(date.toString() + "\n");
            }
        }

        for (Date212 date : dateList.getUnsortedDateList()) {
            if (date.getYear() == searchYear) {
                unsortedTextArea.append(date.toString() + "\n");
            }
        }

    }//displayDatesWithYear

    /*
     * resets the GUI to show the entire list of dates both sorted and unsorted
     */
    private void resetGUI() {
        // Clear the TextAreas and display all dates
        sortedTextArea.setText("Sorted Dates:\n");
        unsortedTextArea.setText("Unsorted Dates:\n");

        for (Date212 date : dateList.getSortedDateList()) {
            sortedTextArea.append(date.toString() + "\n");
        }

        for (Date212 date : dateList.getUnsortedDateList()) {
            unsortedTextArea.append(date.toString() + "\n");
        }
    }//resetGUI
}//EditMenuHandler
