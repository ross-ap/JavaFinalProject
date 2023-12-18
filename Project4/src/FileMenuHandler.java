/**
 * @author Ross Emile Aparece
 * @section 212-121B
 * Program that obtains the dates read through a text file
 * formats the dates and shows them to the user through a GUI
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FileMenuHandler implements ActionListener {
    Date212GUI dategui;
    TextArea sorted;
    TextArea unsorted;
    static Date212 object;
    
    /**
     * 
     * @param dateGUI GUI to display to user
     * @param sort sorted text area for date that are sorted from the file first then displayed
     * @param unsort unsorted text area for dates as they are read in from the file
     */
    public FileMenuHandler (Date212GUI dateGUI, TextArea sort, TextArea unsort) { 
        dategui = dateGUI;
        sorted = sort;
        unsorted = unsort;
    }//FileMenuHandler

    /**
     * Determines the action performed and lets the user open a file menu to select the file or entirely exits the program
     */
    public void actionPerformed(ActionEvent event) {
        String menuItem = event.getActionCommand();
        if (menuItem.equals("Open")) {
            openFile(dategui);
        } else if (menuItem.equals("Quit")) {
            System.exit(0);
        }    
    }//actionPerformed

    /**
     * @param dateGUI GUI to display to user
     * Reads from the file the user has chosen and displays it to the gui
     */
    public void openFile(Date212GUI dateGUI) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        //absolutepath to ensure that the file will always open
        String filename = (chooser.getSelectedFile()).getAbsolutePath();
        
        String[] dates = readFile(filename);
        Date212GUI.printToGUI(dates, dateGUI, sorted, unsorted);  
        dateGUI.getDateList().addDates(dates); 
    }//openFile

    /**
     * @param filename file that the user wants to read the dates from
     * @return returns the dates read
     * Uses StringTokenizer to read the dates from the file 
     */
    public static String[] readFile(String filename) {
        int index = 0;
        int tokenCounter = 0;
        TextFileInput input = new TextFileInput(filename);
        String countLine = input.readLine();

        //counts our tokens
        while (countLine != null) { 
            StringTokenizer token = new StringTokenizer(countLine, ",");
            tokenCounter += token.countTokens();
            countLine = input.readLine();
        }
        
        //creates a new String array using tokenCounter to obtain the size
        String[] date = new String[tokenCounter];
        TextFileInput file = new TextFileInput(filename);
        String readLine = file.readLine();
        
        
        //reads each token and stores it into a string array
        while (readLine != null) { 
            StringTokenizer readToken = new StringTokenizer(readLine, ",");
            /**
             * adds each date to the respective index of the array
             */
            while (readToken.hasMoreTokens()) {
                date[index++] = readToken.nextToken();
            }
            readLine = file.readLine();
        }
        return date;
    }//readFile

}//FileMenuHandler
