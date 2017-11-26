public class Date {
    private int month, day, year;

    private static final int days_in_month[] = 
       {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // add month names outside method in case other methods will use it later
    private static final String monthNames[] = 
       {"", "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"};

    // Date default constructor
    // post: initalizes Date object to first date of Gregorian calendar
    public Date() {
	this(1,1,1601);
    }

    // Date general constructor
    // post: initalizes Date object to values given
    public Date(int m, int d, int y) {
	this.month = m;
	this.day   = d;
	this.year  = y;
	validDate();
    }

    // validDate
    // post: throws an exception is date is invalid
    protected void validDate() {
	// month must be in range 1 - 12
	boolean valid = (month >= 1 && month <= 12);
	valid = valid && (year > 1601);
	// figure out last day in month
	int last_day = days_in_month[month];
	if (month == 2 && isLeapYear()) last_day++;
	valid = valid && (day > 0 && day <= last_day);
	if (!valid) 
	    throw new IllegalArgumentException("Invalid Date");
    }

    // toString
    // pre: date is valid
    // post: returns date in format "mm/dd/yyyy"
    public String toString() {
	String s = "" + month + "/" + day + "/" + year;
	return s;
    }

    // daysInMonth
    // pre:  month > 0 && month < 13
    // post: returns number of days in the month, accounting for leap years
    public int daysInMonth() {
	int days = days_in_month[month];
	if (isLeapYear()) days++;
	return days;
    }

    // isLeapYear
    // post: returns true if year is a leap year
     public boolean isLeapYear() {
	 return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
     }

    // getMonthName
    // pre:  month > 0 && month < 13
    // post: returns name corresponding to month
    public String getMonthName() {
	return monthNames[month];
    } 

    // julianDate
    // pre:  month and day are valid
    // post: returns the Julian date (number of days since Jan. 1st)
    public int julianDate() {
	int jd = 0;

	// sum up the days in months prior to current month
	for (int i = 1; i < month; i++)
	    jd += days_in_month[i];

	// add to this the number of current day in current month
	jd += day;

	// adjust for leap year (add 1 day if leap year and AFTER 2/29)
	if (isLeapYear() && month > 2)
	    jd++;

	return jd;
    }
    
}