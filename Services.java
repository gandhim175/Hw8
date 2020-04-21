/*
 * Name: Milind Gandhi
 * Date: 04/01/2020
 * Class: ObjectOreiented
 * Assignment: Homework - GUI
 * Dispcription: In this program is about the calculate services and sale calculating by java GUI program
 */
package javaapplication52;

/**
 *
 * @author Gandhi
 */
public class Services extends Account {

    private int numberOfHours;
    private double ratePerHour;

    public Services(int id, int numberOfHours, double ratePerHour) {
        super(id);
        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;
    }

    public Services(int id) {
        super(id);
        numberOfHours = 0;
        ratePerHour = 0;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateSales() {
        return getNumberOfHours() * getRatePerHour();
    }

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "\nRate per hour: $" + getRatePerHour()
                + "\nNumber of hours : " + getNumberOfHours()
                + "\nTotal Sales : $" + calculateSales();
    }
}
