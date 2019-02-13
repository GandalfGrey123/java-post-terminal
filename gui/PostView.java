package gui;

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
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(custNameLabel)
                                .addPreferredGap(RELATED)
                                .addComponent(custNameTextField, PREFERRED_SIZE, 92, PREFERRED_SIZE)
                                .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enterButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(paymentTypeLabel)
                                                .addPreferredGap( RELATED)
                                                .addComponent(payTypeComboBox, PREFERRED_SIZE, 96, PREFERRED_SIZE))
                                            .addComponent(productsComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup()
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(timeTextField, PREFERRED_SIZE, 182, PREFERRED_SIZE)
                                                    .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(paymentLabel)
                                                    .addGap(118, 118, 118))
                                                .addComponent(invoiceScrollPane, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                        .addPreferredGap( RELATED)
                                        .addComponent(amountLabel)
                                        .addPreferredGap( RELATED)
                                        .addComponent(amountTextField, PREFERRED_SIZE, 57, PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(358, 358, 358)
                                        .addComponent(payButton)))
                                .addGap(0, 27, Short.MAX_VALUE)))))
                .addContainerGap()
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(invoiceLabel)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productsLabel)
                        .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(qtyLabel)
                        .addPreferredGap( UNRELATED)
                        .addComponent(qtyComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                    .addGroup(TRAILING, layout.createSequentialGroup()
                        .addComponent(upcLabel)
                                   .addGap(265, 265, 265)
        )))));
        layout.setVerticalGroup(
            layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup()
                    .addComponent(qtyLabel)
                    .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(productsLabel)
                        .addComponent(productsComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(qtyComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                .addPreferredGap( RELATED)
                .addGroup(layout.createParallelGroup(BASELINE)
                    .addComponent(custNameLabel)
                    .addComponent(custNameTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(enterButton))
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(upcLabel)
                        .addPreferredGap( RELATED, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceLabel)
                        .addPreferredGap( RELATED, DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(invoiceScrollPane, PREFERRED_SIZE, 258, PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup()
                    .addComponent(paymentLabel)
                    .addComponent(timeTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addPreferredGap( RELATED)
                .addGroup(layout.createParallelGroup(BASELINE)
                    .addComponent(paymentTypeLabel)
                    .addComponent(payTypeComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(amountLabel)
                    .addComponent(amountTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addPreferredGap( UNRELATED)
                .addComponent(payButton)
                .addGap(39, 39, 39)
        ));

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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostView().setVisible(true);
            }
        });
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
