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
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CompanySales extends JFrame {

    private static final long serialVersionUID = 1L;
    // declare controls
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private List<Account> list = new ArrayList<>();

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // create object of CompanySales class
                CompanySales frame = new CompanySales();
                frame.setVisible(true); // make fframe visible
            } catch (Exception e) {
            }
        });
    }

    /**
     * Create the frame.
     */
    public CompanySales() {
        setTitle("Company Sales"); // set title of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 307, 341);
        // set no layout
        getContentPane().setLayout(null);
        // generate screen in middle of screen
        setLocationRelativeTo(null);
        // create labels
        JLabel lblNewLabel = new JLabel("Account ID:");
        lblNewLabel.setBounds(41, 91, 109, 28);
        getContentPane().add(lblNewLabel);

        JLabel lblNumberOfItem = new JLabel("Number of Item:");
        lblNumberOfItem.setBounds(40, 131, 110, 28);
        getContentPane().add(lblNumberOfItem);

        JLabel lblPricePerItem = new JLabel("Price per Item:");
        lblPricePerItem.setBounds(41, 171, 109, 28);
        getContentPane().add(lblPricePerItem);
        // instantiate text fields
        textField = new JTextField();
        textField.setBounds(151, 95, 123, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(151, 135, 123, 20);
        getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(151, 175, 123, 20);
        getContentPane().add(textField_2);

        // create radio buttons
        JRadioButton rdbbtnSupply = new JRadioButton("Supply");
        rdbbtnSupply.addActionListener((ActionEvent e) -> {
            lblNumberOfItem.setText("Number of items:");
            lblPricePerItem.setText("Price per items:");
        });
        rdbbtnSupply.setForeground(Color.RED);
        rdbbtnSupply.setFont(new Font("Verdana", Font.BOLD, 14));
        rdbbtnSupply.setBounds(41, 39, 87, 23);
        getContentPane().add(rdbbtnSupply);
        rdbbtnSupply.setSelected(true);

        JRadioButton rdbtnService = new JRadioButton("Service");
        rdbtnService.addActionListener((ActionEvent e) -> {
            lblNumberOfItem.setText("Number of hours:");
            lblPricePerItem.setText("Rate per hour:");
        });
        rdbtnService.setForeground(Color.RED);
        rdbtnService.setFont(new Font("Verdana", Font.BOLD, 12));
        rdbtnService.setBounds(151, 39, 109, 23);
        getContentPane().add(rdbtnService);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbbtnSupply);
        bg.add(rdbtnService);

        JButton btnCalculateSales = new JButton("Calculate Sales");
        btnCalculateSales.addActionListener((ActionEvent e) -> {
            try {
                // get input from text fields
                int accountNo = Integer.parseInt(textField.getText());
                int noOfSales = Integer.parseInt(textField_1.getText());
                double ratePerSale = Double.parseDouble(textField_2.getText());
                // check which radio button is selected
                if (rdbbtnSupply.isSelected()) {
                    // create object of Supplies class using parameterized constructor
                    Supplies supplies = new Supplies(accountNo, noOfSales, ratePerSale);
                    list.add(supplies); // add to list
                    // show result
                    JOptionPane.showMessageDialog(null, supplies + "\n\nSupply added in list Successfully.!", "Result", 1);
                } else {
                    // create object of Services class using parameterized constructor
                    Services service = new Services(accountNo, noOfSales, ratePerSale);
                    list.add(service);
                    JOptionPane.showMessageDialog(null, service + "\n\nService added in list Successfully.!", "Result", 1);
                }
            } catch (NumberFormatException | HeadlessException e2) {
                // if user enters any wrong input
                JOptionPane.showMessageDialog(null, "Wrong input.Please try again...!!!", "Error", 0);
            }
            // clearing all text fields
            textField.setText("");
            textField_1.setText("");
            textField_2.setText("");
        });
        btnCalculateSales.setBounds(10, 231, 126, 23);
        getContentPane().add(btnCalculateSales);

        // show all sales
        JButton btnShowAllSales = new JButton("Show All Sales");
        btnShowAllSales.addActionListener((ActionEvent arg0) -> {
            String allSales = "";
            allSales = list.stream().map((account) -> account + "\n\n").reduce(allSales, String::concat);
            JOptionPane.showMessageDialog(null, "All Sales: \n\n" + allSales, "Result", 1);
        });
        btnShowAllSales.setBounds(151, 231, 123, 23);
        getContentPane().add(btnShowAllSales);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        btnExit.setBounds(102, 268, 89, 23);
        getContentPane().add(btnExit);
    }
}
