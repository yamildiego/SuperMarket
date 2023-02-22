package Model;

import java.util.Calendar;

public class TaxNational extends Tax {

    public TaxNational(int percentage, double fixedValue, String description, Type type) {
        super(percentage, fixedValue, description, type);
    }

    @Override
    public double value(double price) {
        Calendar date = Calendar.getInstance();
        double value = 0;
        if (super.getType().equals(Type.HIGH)) {
            value = (price * (super.getPercentage() / 100)) + super.getFixedValue();
        }
        if (super.getType().equals(Type.LOW)) {
            if (date.get(Calendar.YEAR) % 2 == 2) {
                value = (price * (super.getPercentage() / 100)) + super.getFixedValue();
            } else {
                value = price * (super.getPercentage() / 100);
            }
        }
        return value;
    }
}
