/**
 * @author Ross Emile Aparece
 * @section 212-121B
 * Program that obtains the dates read through a text file
 * formats the dates and shows them to the user through a GUI
 */
public class Date212 implements Comparable<Date212> {
    
    //initialize our variables for dates
    private int day;
    private int month;
    private int year;
    private String metaDate;    

    /**
     * @param date the string from out input file so we can substring it
     */

    public Date212(String date) throws IllegalDate212Exception {

        //substring to split the date and read each part
        //beginning of the index of substring is inclusive the ending is exclusive
        String dateYear = date.substring(0, 4);
        String dateMonth = date.substring(4, 6);
        String dateDay = date.substring(6, 8);
        String meta = date;

        //assign our sections of these strings their respective category
        year = Integer.parseInt(dateYear);
        month = Integer.parseInt(dateMonth);
        day = Integer.parseInt(dateDay);
        metaDate = meta;

    }//Date212

    @Override
    public int compareTo(Date212 otherDate) {
        return Integer.compare(Integer.parseInt(this.getMeta()), Integer.parseInt(otherDate.getMeta()));
    }//compareTo

    //set and gets for each part of the date
    public void setYear(int y){
        year = y;
    }//setYear

    public int getYear(){
        return year;
    }//getYear

    public void setMonth(int m){
        month = m;
    }//setMonth

    public int getMonth(){
        return month;
    }//getMonth

    public void setDay(int d){
        day = d;
    }//setDay

    public int getDay(){
        return day;
    }//getDay

    public String getMeta(){
        return metaDate;
    }//getMeta

    /**
     * formats the dates 
     * @param year obtained from first 4 digits from the input string
     * @param month obtained from middle 2 digits from the input string
     * @param day obtained from last 2 digits from the input string
     */
    public String toString(){
        return month + "/" + day + "/" + year;
    }//toString

    /**
     * checks if the class types are the same
     */
    public boolean equals(Object other){
        if(this == other){
            return true;
        }

        if(other != null && this.getClass().equals(other.getClass())){
            Date212 d = (Date212) other;
            if (year == d.year && month == d.month && day == d.day){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }//equals

    /*
     * compares two objects by subtracting them and converting to check if there is an ealier date 
     */
    public boolean compareTo(Object other){
        int dif;

        Date212 d = (Date212) other;

        dif = (this.year - d.year) * 365;
        dif += (this.month - d.month) * 30;
        dif += (this.day - d.day);

        if (dif > 0) {
            return false;
        } else {
            return true;
        }
    }//compareTo

    public boolean validDate(Date212 d) {
        //ensures date has 8 digits
        if(d.getMeta().length() != 8){
            return false;
        }

        //ensures the month and day for each string is within the proper range
        if((d.getMonth() >= 13 || d.getMonth() <= 0) || (d.getDay() >= 32 || d.getDay() <= 0)) {
            return false;
        }

        return true;
    }

}//Date212

