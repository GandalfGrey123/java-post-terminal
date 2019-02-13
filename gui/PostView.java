package gui;

import static java.awt.FlowLayout.LEADING;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.*;



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
        amountTextField = new javax.swing.JTextField();


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
        
        amountTextField.setText("Tuesday, February 12, 2019 (PST) Time in San Francisco, CA");
        amountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTextFieldActionPerformed(evt);
            }
        });

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

        GroupLayout layout = new GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

 
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup()
                    .add(layout.createSequentialGroup()
                        .add(65, 65, 65)
                        .add(layout.createParallelGroup()
                            .add(layout.createSequentialGroup()
                                .add(custNameLabel)
                                .addPreferredGap(RELATED)
                                .add(custNameTextField, PREFERRED_SIZE, 92, PREFERRED_SIZE)
                                .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(enterButton))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup()
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(TRAILING)
                                            .add(layout.createSequentialGroup()
                                                .add(paymentTypeLabel)
                                                .addPreferredGap( RELATED)
                                                .add(payTypeComboBox, PREFERRED_SIZE, 96, PREFERRED_SIZE))
                                            .add(productsComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                            .add(layout.createParallelGroup()
                                                .add(layout.createSequentialGroup()
                                                    .add(timeTextField, PREFERRED_SIZE, 182, PREFERRED_SIZE)
                                                    .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .add(paymentLabel)
                                                    .add(118, 118, 118))
                                                .add(invoiceScrollPane, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                        .addPreferredGap( RELATED)
                                        .add(amountLabel)
                                        .addPreferredGap( RELATED)
                                        .add(amountTextField, PREFERRED_SIZE, 57, PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(358, 358, 358)
                                        .add(payButton)))
                                .add(0, 27, Short.MAX_VALUE)))))
                .addContainerGap())
            .add(TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(invoiceLabel)
                .add(72, 72, 72)
                .add(layout.createParallelGroup(LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(productsLabel)
                        .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(qtyLabel)
                        .addPreferredGap( UNRELATED)
                        .add(qtyComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                    .add(TRAILING, layout.createSequentialGroup()
                        .add(upcLabel)
                        .add(265, 265, 265))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup()
                    .add(qtyLabel)
                    .add(layout.createParallelGroup(BASELINE)
                        .add(productsLabel)
                        .add(productsComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .add(qtyComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                .addPreferredGap( RELATED)
                .add(layout.createParallelGroup(BASELINE)
                    .add(custNameLabel)
                    .add(custNameTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .add(enterButton))
                .add(layout.createParallelGroup()
                    .add(layout.createSequentialGroup()
                        .add(42, 42, 42)
                        .add(upcLabel)
                        .addPreferredGap( RELATED, 21, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(invoiceLabel)
                        .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(invoiceScrollPane, PREFERRED_SIZE, 258, PREFERRED_SIZE)
                .add(31, 31, 31)
                .add(layout.createParallelGroup()
                    .add(paymentLabel)
                    .add(timeTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addPreferredGap( RELATED)
                .add(layout.createParallelGroup(BASELINE)
                    .add(paymentTypeLabel)
                    .add(payTypeComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .add(amountLabel)
                    .add(amountTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addPreferredGap( UNRELATED)
                .add(payButton)
                .add(39, 39, 39))
        );

        pack();

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
    
    private void amountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
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
    private javax.swing.JTextField amountTextField;
    // End of variables declaration                   
    
}
