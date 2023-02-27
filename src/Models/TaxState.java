package Models;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TaxState extends Tax {

    public TaxState(int percentage, double fixedValue, String description, Tax.Type type) {
        super(percentage, fixedValue, description, type);
    }

    @Override
    public double value(double price) {
        Calendar date = Calendar.getInstance();
        double value = 0;
        if (super.getType().equals(Tax.Type.LOW)) {
            value = (price * (super.getPercentage() / 100)) + super.getFixedValue();
        }

        if (super.getType().equals(Tax.Type.HIGH)) {
            if (getDayOfTheWeek(date.getTime()) == 1) {
                value = (price * (super.getPercentage() / 100)) + super.getFixedValue();
            } else {
                value = price * (super.getPercentage() / 100);
            }
        }
        return value;
    }

    private static int getDayOfTheWeek(Date d) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
}
