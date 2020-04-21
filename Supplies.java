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
public class Supplies extends Account {

    private int numberOfItems;
    private double pricePerItem;

    public Supplies(int id, int numberOfItems, double pricePerItem) {
        super(id);
        this.numberOfItems = numberOfItems;
        this.pricePerItem = pricePerItem;
    }

    public Supplies(int id) {
        super(id);
        numberOfItems = 0;
        pricePerItem = 0;
    }

    public double getPricePerItem() // Getter method
    {
        return pricePerItem;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) // Setter method
    {
        this.numberOfItems = numberOfItems;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double calculateSales() {
        return getNumberOfItems() * getPricePerItem();
    }

    // toString() method
    @Override
    public String toString() {
        return super.toString() + "\nPrice per item: $" + getPricePerItem()
                + "\nItems sold : " + getNumberOfItems()
                + "\nTotal Sales : $" + calculateSales();
    }
}
