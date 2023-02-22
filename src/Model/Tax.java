package Model;

public abstract class Tax {

    public enum Type {
        HIGH, LOW
    }

    private double percentage;
    private double fixedValue;
    private String description;
    private Type type;

    public Tax(int percentage, double fixedValue, String description, Type type) {
        this.percentage = percentage;
        this.fixedValue = fixedValue;
        this.description = description;
        this.type = type;
    }

    public abstract double value(double costo);

    public double getPercentage() {
        return this.percentage;
    }

    public double getFixedValue() {
        return this.fixedValue;
    }

    public String getDescription() {
        return this.description;
    }

    public Type getType() {
        return this.type;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setFixedValue(double fixedValue) {
        this.fixedValue = fixedValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
