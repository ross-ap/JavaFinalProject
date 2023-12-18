/**
 * @author Ross Emile Aparece
 * @section 212-121B
 * Program that obtains the dates read through a text file
 * formats the dates and shows them to the user through a GUI
 */

import java.util.ArrayList;
import java.util.Collections;

public class Date212List {
    private ArrayList<Date212> sortedDateList;
    private ArrayList<Date212> unsortedDateList;

    public Date212List() {
        sortedDateList = new ArrayList<>();
        unsortedDateList = new ArrayList<>();
    }//Date212List

    /**
     * 
     * @param newDate date that is added to both the unsorted and sorted lists
     */
    public void add(Date212 newDate) {
        sortedDateList.add(newDate);
        unsortedDateList.add(newDate);
        Collections.sort(sortedDateList);
    }//add

    public ArrayList<Date212> getSortedDateList() {
        return sortedDateList;
    }//getSortedDateList

    public ArrayList<Date212> getUnsortedDateList() {
        return unsortedDateList;
    }//getUnsortedDateList

    /**
     * 
     * @param dates to be added into the array list 
     */
    public void addDates(String[] dates) {
        for (String dateString : dates) {
            try {
                Date212 date = new Date212(dateString);
                if (date.validDate(date)) {
                    add(date);
                }
            } catch (IllegalDate212Exception e) {
                e.printStackTrace(); 
            }
        }
    }//add dates

}//Date212List