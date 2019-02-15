package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.geom.RoundRectangle2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
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
    private int cartSize = 0;
    private int totalPrice = 0;
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JLabel custNameLabel;
    private JTextField custNameTextField;
    private JPanel customerPanel;
    private JPanel invoicePanel;
    private JTable invoiceScrollPane;
    private JLabel totalLabel;
    private JLabel totalPriceLabel;
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
    private DefaultTableModel dtm;
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
        totalLabel = new JLabel();
        totalPriceLabel = new JLabel();
        paymentPanel = new JPanel();
        paymentLabel = new JLabel();
        payTypeComboBox = new JComboBox();
        amountLabel = new JLabel();
        amountTextField = new JTextField();
        payButton = new JButton();
        dtm = new DefaultTableModel(0,0);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("POST");

        Date date = new Date();
        String strDateFormat = "hh:mm:ss aaa, EEEEE, MMMMM d, yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);

        timeTextField.setText(formattedDate);

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

        String tableHeader[] = new String[] { "ITEM", "QUANTITY", "UNIT PRICE", "EXTENDED PRICE"};
        dtm.setColumnIdentifiers(tableHeader);
        invoiceScrollPane.setModel(dtm);
        for(int count = 1; count <= 17; count++) {
            dtm.addRow(new Object[] {null, null, null, null, null, null});
        }
        invoiceScrollPanel.setViewportView(invoiceScrollPane);

        totalLabel.setFont(new Font("Lucida Grande", 1, 13)); 
        totalLabel.setText("TOTAL");
        totalPriceLabel.setFont(new Font("Lucida Grande", 1, 13)); 
        totalPriceLabel.setText("0.00");

        GroupLayout invoicePanelLayout = new GroupLayout(invoicePanel);
        invoicePanel.setLayout(invoicePanelLayout);
        invoicePanelLayout.setHorizontalGroup(
            invoicePanelLayout.createParallelGroup(LEADING)
            .addGroup(invoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invoiceScrollPanel, PREFERRED_SIZE, 730, PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(TRAILING, invoicePanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalLabel)
                .addGap(29, 29, 29)
                .addComponent(totalPriceLabel)
                .addGap(145, 145, 145))
        );
        invoicePanelLayout.setVerticalGroup(
            invoicePanelLayout.createParallelGroup(LEADING)
            .addGroup(invoicePanelLayout.createSequentialGroup()
                .addComponent(invoiceScrollPanel, PREFERRED_SIZE, 305, PREFERRED_SIZE)
                .addGroup(invoicePanelLayout.createParallelGroup(BASELINE)
                .addComponent(totalLabel)
                .addComponent(totalPriceLabel)))
        );
        
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment"));
        paymentLabel.setText("Payment type");

        payTypeComboBox.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Credit", "Check"}));
        payTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payTypeComboBoxActionPerformed(evt);
            }
        });

        amountLabel.setText(" Amount");

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
        //insert and store data into Jtable
        if(cartSize < 17) {
            addToCart(productsComboBox.getSelectedItem(),qtyComboBox.getSelectedItem());
        } else {
            dtm.addRow(new Object[] {null, null, null, null, null, null});
            addToCart(productsComboBox.getSelectedItem(),qtyComboBox.getSelectedItem());
            System.out.println("Cart full, made more space..");
        }

    }

    private void addToCart(Object upc, Object quantity) {
        String price = "get from REST";
        String extPrice = "qty*price";
        invoiceScrollPane.setValueAt(productsComboBox.getSelectedItem(), cartSize, 0);
        invoiceScrollPane.setValueAt(qtyComboBox.getSelectedItem(), cartSize, 1);
        invoiceScrollPane.setValueAt(price, cartSize, 2);
        invoiceScrollPane.setValueAt(extPrice, cartSize, 3);
        cartSize++;

    }

    private void addToCart(Object upc, Object quantity, Object price, Object extPrice) {
        //use this one with the REST data
    }

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // clear all fields and send data to REST API database
        clearFields();
    }                                         

    private void payTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // send to REST endpoint
    }

    private void clearFields() {
        amountTextField.setText(null);
        custNameTextField.setText(null);
        dtm.setRowCount(0);
        productsComboBox.setSelectedIndex(0);
        qtyComboBox.setSelectedIndex(0);
        payTypeComboBox.setSelectedIndex(0);
        cartSize = 0;
        for(int count = 1; count <= 17; count++) {
            dtm.addRow(new Object[] {null, null, null, null, null, null});
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (UnsupportedLookAndFeelException e) {
                    // handle exception
                } catch (ClassNotFoundException e) {
                    // handle exception
                } catch (InstantiationException e) {
                    // handle exception
                } catch (IllegalAccessException e) {
                    // handle exception
                }
                PostView POST = new PostView();

                Rectangle test = POST.getBounds();
                POST.setMaximizedBounds(test); // making the window resizable without disabling the button

                POST.setVisible(true);
            }
        });
    }                
    
}
