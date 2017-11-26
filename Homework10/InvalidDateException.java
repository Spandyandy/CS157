/**
 * This class will check for errors and extends Date (this class is inherited from Date).
 *
 * @author Andy Kim
 * @version 4.27.16
 */
public class InvalidDateException extends Date{
    public void InvalidDateException() {
        // month must be in range 1 - 12
        int last_day = days_in_month[month];
        boolean validDay = true;
        boolean validMonth = true;
        boolean validYear = true;
        //valid = valid && (year > 1601);
        // figure out last day in month

        if (month == 2 && isLeapYear()) {
            last_day++;
        }
        if (!(month >= 1 && month <= 12)){
            validMonth = false;
            throw new IllegalArgumentException ("Please enter a valid month value from 1 to 12.");
        }
        else if (!(day >= 1 && day <= last_day)) {
            validDay = false;
            throw new IllegalArgumentException ("Please enter a valid day for this particular month.");
        }
        else if (!(year > 1601)) {
            validYear = false;
            throw new IllegalArgumentException("Please enter any year after 1601.");
        }
    }
}
