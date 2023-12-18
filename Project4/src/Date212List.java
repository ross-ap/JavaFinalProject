import java.util.ArrayList;
import java.util.Collections;

public class Date212List {
    private ArrayList<Date212> sortedDateList;
    private ArrayList<Date212> unsortedDateList;

    public Date212List() {
        sortedDateList = new ArrayList<>();
        unsortedDateList = new ArrayList<>();
    }

    public void add(Date212 newDate) {
        sortedDateList.add(newDate);
        unsortedDateList.add(newDate);
        Collections.sort(sortedDateList);
    }

    public ArrayList<Date212> getSortedDateList() {
        return sortedDateList;
    }

    public ArrayList<Date212> getUnsortedDateList() {
        return unsortedDateList;
    }

    public void addDates(String[] dates) {
        for (String dateString : dates) {
            try {
                Date212 date = new Date212(dateString);
                if (date.validDate(date)) {
                    add(date);
                }
            } catch (IllegalDate212Exception e) {
                e.printStackTrace();  // Handle exception as needed
            }
        }
    }

}