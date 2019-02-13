package gui;

import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;


public class PostView extends javax.swing.JFrame {
    
    /** Creates new form PostView */
    public PostView() {
        initComponents();
    }
    
    // Variables declaration                    
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JLabel custNameLabel;
    private JTextField custNameTextField;
    private JPanel customerPanel;
    private JPanel invoicePanel;
    private JTable invoiceScrollPane;
    private JButton enterButton;
    private JScrollPane invoiceScrollPanel;
    private JButton payButton;
    private JComboBox payTypeComboBox;
    private JLabel paymentLabel;
    private JPanel paymentPanel;
    private JComboBox productsComboBox;
    private JPanel productsPanel;
    private JComboBox qtyComboBox;
    private JLabel qtyLabel;
    private JLabel timeTextField;
    private JLabel upcLabel;
    // End of variables declaration   
    
    /** This method is called from within the constructor to
     * initialize the form.
     */                       
    private void initComponents() {

        timeTextField = new JLabel();
        productsPanel = new JPanel();
        upcLabel = new JLabel();
        productsComboBox = new JComboBox();        
        enterButton = new JButton();
        qtyLabel = new JLabel();
        qtyComboBox = new JComboBox();
        customerPanel = new JPanel();
        custNameLabel = new JLabel();
        custNameTextField = new JTextField();
        invoicePanel = new JPanel();
        invoiceScrollPanel = new JScrollPane();
        invoiceScrollPane = new JTable();
        paymentPanel = new JPanel();
        paymentLabel = new JLabel();
        payTypeComboBox = new JComboBox();
        amountLabel = new JLabel();
        amountTextField = new JTextField();
        payButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("POST");

        timeTextField.setText("9:34 AM Wednesday, February 13, 2019 (PST)");

        productsPanel.setBorder(BorderFactory.createTitledBorder("Products"));

        upcLabel.setText("UPC");

        productsComboBox.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        qtyLabel.setText("Qty");

        qtyComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        GroupLayout productsPanelLayout = new GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(LEADING)
            .addGroup(productsPanelLayout.createSequentialGroup()
                .addComponent(upcLabel)
                .addComponent(productsComboBox, PREFERRED_SIZE, 154, PREFERRED_SIZE)
                .addComponent(qtyLabel)
                .addComponent(qtyComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addComponent(enterButton)
                .addContainerGap())
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(LEADING)
            .addGroup(productsPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(productsPanelLayout.createParallelGroup(BASELINE)
                    .addComponent(upcLabel)
                    .addComponent(productsComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(qtyLabel)
                    .addComponent(qtyComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(enterButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer"));

        custNameLabel.setText("Name ");

        custNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameTextFieldActionPerformed(evt);
            }
        });

        GroupLayout customerPanelLayout = new GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custNameLabel)
                .addPreferredGap(RELATED)
                .addComponent(custNameTextField, DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(BASELINE)
                    .addComponent(custNameLabel)
                    .addComponent(custNameTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        invoicePanel.setBorder(BorderFactory.createTitledBorder("Invoice"));

        invoiceScrollPane.setModel(new javax.swing.table.DefaultTableModel(
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
        invoiceScrollPanel.setViewportView(invoiceScrollPane);

        GroupLayout invoicePanelLayout = new GroupLayout(invoicePanel);
        invoicePanel.setLayout(invoicePanelLayout);
        invoicePanelLayout.setHorizontalGroup(
            invoicePanelLayout.createParallelGroup(LEADING)
            .addGroup(invoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invoiceScrollPanel, PREFERRED_SIZE, 730, PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        invoicePanelLayout.setVerticalGroup(
            invoicePanelLayout.createParallelGroup(LEADING)
            .addGroup(invoicePanelLayout.createSequentialGroup()
                .addComponent(invoiceScrollPanel, PREFERRED_SIZE, 305, PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment"));

        paymentLabel.setText("Payment type");

        payTypeComboBox.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Credit", "Check"}));
        payTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payTypeComboBoxActionPerformed(evt);
            }
        });

        amountLabel.setText("Amount");

        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        GroupLayout paymentPanelLayout = new GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGroup(paymentPanelLayout.createParallelGroup(LEADING)
                    .addGroup(TRAILING, paymentPanelLayout.createSequentialGroup()
                        .addComponent(paymentLabel)
                        .addPreferredGap(RELATED)
                        .addComponent(payTypeComboBox, PREFERRED_SIZE, 96, PREFERRED_SIZE)
                        .addComponent(amountLabel)
                        .addPreferredGap(RELATED)
                        .addComponent(amountTextField, PREFERRED_SIZE, 95, PREFERRED_SIZE))
                    .addGroup(TRAILING, paymentPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(payButton)))
                .addContainerGap())
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentPanelLayout.createParallelGroup(BASELINE)
                    .addComponent(paymentLabel)
                    .addComponent(payTypeComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(amountLabel)
                    .addComponent(amountTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(payButton)
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(LEADING, false)
                            .addComponent(invoicePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(timeTextField)
                                .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(paymentPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE))                      
                            .addComponent(customerPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                        .addPreferredGap(RELATED)
                        .addComponent(productsPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING, false)
                    .addComponent(productsPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap())
                    .addComponent(customerPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(RELATED)
                .addComponent(invoicePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addPreferredGap(RELATED)
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(timeTextField)
                    .addComponent(paymentPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                    

    private void custNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void payTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostView().setVisible(true);
            }
        });
    }                
    
}
