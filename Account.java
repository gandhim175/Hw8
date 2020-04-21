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
public abstract class Account {

    private int accountID;

    public Account(int id) {
        this.accountID = id;
    }

    public int getAccountId() {
        return accountID;
    }

    public void setAccountId(int accountId) {
        this.accountID = accountId;
    }

    // Abstract method
    public abstract double calculateSales();

    @Override
    public String toString() {
        return "Account ID: " + getAccountId();
    }
}
