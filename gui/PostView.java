package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class PostView extends javax.swing.JFrame {
    
    public PostView() {
        initComponents();
    }
                           
    private void initComponents() {

        custNameLabel = new javax.swing.JLabel();
        custNameTextField = new javax.swing.JTextField();
        productsLabel = new javax.swing.JLabel();
        upcLabel = new javax.swing.JLabel();
        invoiceScrollPane = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        qtyLabel = new javax.swing.JLabel();
        productsComboBox = new javax.swing.JComboBox();
        qtyComboBox = new javax.swing.JComboBox();
        enterButton = new javax.swing.JButton();
        paymentLabel = new javax.swing.JLabel();
        invoiceLabel = new javax.swing.JLabel();
        paymentTypeLabel = new javax.swing.JLabel();
        payTypeComboBox = new javax.swing.JComboBox();
        amountLabel = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();
        timeTextField = new javax.swing.JTextField();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PostView");

        custNameLabel.setText("Customer name :");

        custNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameTextFieldActionPerformed(evt);
            }
        });

        productsLabel.setText("Products");

        upcLabel.setText("UPC");

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ITEM", "QTY", "UNIT PRICE", "EXTENDED PRICE"
            }
        ));
        invoiceScrollPane.setViewportView(invoiceTable);

        qtyLabel.setText("Qty");

        productsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        qtyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        paymentLabel.setText("Payment");

        invoiceLabel.setText("Invoice");

        paymentTypeLabel.setText("Payment type");

        payTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Credit", "Check", "Item 4" }));

        amountLabel.setText("Amount");

        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        timeTextField.setText("Tuesday, February 12, 2019 (PST) Time in San Francisco, CA");
        timeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTextFieldActionPerformed(evt);
            }
        });


    }// </editor-fold> 

    private void custNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                                                

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void timeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton enterButton;
    private javax.swing.JButton payButton;
    private javax.swing.JComboBox productsComboBox;
    private javax.swing.JComboBox qtyComboBox;
    private javax.swing.JComboBox payTypeComboBox;
    private javax.swing.JLabel paymentTypeLabel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel custNameLabel;
    private javax.swing.JLabel productsLabel;
    private javax.swing.JLabel upcLabel;
    private javax.swing.JLabel qtyLabel;
    private javax.swing.JLabel paymentLabel;
    private javax.swing.JLabel invoiceLabel;
    private javax.swing.JScrollPane invoiceScrollPane;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JTextField custNameTextField;
    private javax.swing.JTextField timeTextField;
    // End of variables declaration                   
    
}
