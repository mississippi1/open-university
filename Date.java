
 
/**
 * This class represents a Date object
 *
 * @author TomerPeker
 * @version 1.0.0
 */
public class Date
{
    private int _day;
    private int _month;
    private int _year;
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;
    /**If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
       @param day the day in the month (1-31)
       @param month the month in the year (1-12)
       @param year the year (4 digits)
       */
    public Date(int day, int month, int year)
    {
        if (isDateValid(day, month, year)){
            _day = day;
            _month = month;
            _year = year;    
        }
        else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
        
    }  
    /**Copy constructor
       @param the date to be copied*/
    public Date (Date other){
        _day = other.getDay();
        _month = other.getMonth();
        _year = other.getYear();
    }
    /**Gets the day
       @return the day*/
    public int getDay(){
        return _day;
    }
    /**Gets the month
       @return the month*/
    public int getMonth(){
        return _month;
    }
    /**Gets the year
       @return the year*/
    public int getYear(){
        return _year;
    }
    /**Sets the day, only if date remains valid
       @param day the day value to be set*/
    public void setDay(int dayToSet){
        _day = isDateValid(dayToSet, getMonth(), getYear()) ? dayToSet : _day;
    }
    /**Sets the month, only if date remains valid
       @param month the month value to be set*/
    public void setMonth(int monthToSet){
        _month = isDateValid(getDay(), monthToSet, getYear()) ? monthToSet : _month;
    }
    /**Sets the year, only if date remains valid
       @param year the year value to be set*/
    public void setYear(int yearToSet){
        _year = isDateValid(getDay(), getMonth(), yearToSet) ? yearToSet : _year;
    }
    /**Checks if a given day is valid
       @param day the day value to be checked
       @param month the month value to be checked
       @param year the year value to be checked
       @return is day valid
       */
    private boolean isDayValid(int day, int month, int year){
        if (isLeapYear(year) && (month == 2) && (day < 30) && (day > 0))
            return true;
        
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return ((1 <= day) && (day <= 31));
            case 2:
            case 4:
            case 6:
            case 9:
            case 11:
                return ((1 <= day) && (day <= 30));
            default:
                return false;
        }
        
    }
    /**Checks if a given month is valid
       @param int month
       @return is month valid*/
    private boolean isMonthValid(int month){
        return ((0 < month) && (month < 13));
    }
    /**Checks if a given year is valid
       @param int year
       @return is year valid*/
    private boolean isYearValid(int year){
        return ((0 <= year) && (year < 10000));
    }
    /**Checks if a given year is leap year
       @param year
       @return is year leap year*/
    private boolean isLeapYear(int year){
        return ((year % 400 == 0) 
                || ((year % 4 == 0) && (year % 100 != 0)));
    }
    /**Combines checking if whole date is valid
     * @param day day to check
     * @param month month to check
     * @param year year to check
     * @return is date valid
       */
    private boolean isDateValid(int day, int month, int year){
        return isYearValid(year)&&isMonthValid(month)&&isDayValid(day, month, year);
    }
    /**
     * Check if 2 dates are the same
     *
     * @param  other the date to compare this date to
     * @return  true if the dates are the same, otherwise false
     */
    public boolean equals (Date other)
    {
        return ((_day == other.getDay()) &&
            (_month == other.getMonth()) &&
            (_year == other.getYear()));
    }
    /**
     * Check if this date is before other date
     * @param  other date to compare this date to
     * @return true if this date is before other date, otherwise false
     */
    public boolean before (Date other){
        return (calculateDate(this) - calculateDate(other)) < 0;
    }
    /**
     * Check if this date is after other date
     * @param  other date to compare this date to
     * @return true if this date is after other date, otherwise false
     */
    public boolean after (Date other){
        return other.before(this);
    }
    /**
     * Calculates the difference between two dates
     * @param  other the date to calculate the difference between 
     * @return the number of days between the dates (non negative number)
     */
    public int difference (Date other){
        if (this.equals(other))
            return 0;
        if (this.before(other)){
            return diffDates(other, this);
        }
        return diffDates(this, other);
    }
    /**
     * Calculates the number of days between two dates, assist method for the difference
     * @param  other the date to calculate the difference between 
     * @return the number of days between the dates (non negative number)
     */
    private int diffDates(Date afterDate, Date beforeDate){
        return calculateDate(afterDate) - calculateDate(beforeDate);
    }
     // computes the day number since the beginning of the Christian counting of years 
    private int calculateDate(int day, int month, int year)
    {
     if (month < 3) {
         year--;
         month = month + 12;
     }
     return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
     } 
      // computes the day number since the beginning of the Christian counting of years, for a date object
     private int calculateDate(Date date)
    {
     return calculateDate(date.getDay(), date.getMonth(), date.getYear());
     } 
     /**
     * Returns a string that represents this date
     * @return String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998
     */
    public String toString(){
        String dayToPrint = String.valueOf(getDay());
        if (getDay() < 10)
            dayToPrint = "0" + dayToPrint;
        String monthToPrint = String.valueOf(getMonth());
        if (getMonth() < 10)
            monthToPrint = "0" + monthToPrint;
        return dayToPrint + "/" + monthToPrint + "/" + getYear();
    }
    /**
     * Calculates the date of tomorrow
     * @return the date of tomorrow
     */
    public Date tomorrow(){
        if (!isDateValid(getDay() + 1, getMonth(), getYear())){
            if (!isDateValid(getDay(), getMonth() + 1, getYear()))
                return new Date(1, 1, getYear() + 1);
            return new Date(1, getMonth() + 1, getYear());
        }
        return new Date(getDay() + 1, getMonth(), getYear());
    }
    
    public static void main(String[] args){
        Date d1 = new Date(1,1,2019);
        Date d2 = new Date(30,2,2020);
        System.out.println(d2.tomorrow().toString() + d2.tomorrow().tomorrow().tomorrow().toString() );
        System.out.println(d2.tomorrow().difference(d1.tomorrow().tomorrow()));
    }
    
}
