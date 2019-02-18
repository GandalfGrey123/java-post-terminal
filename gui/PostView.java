package gui;

import system.*;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import static gui.PaymentPanel.amountTextField;
import static gui.PaymentPanel.payTypeComboBox;
import static gui.ProductsPanel.productsComboBox;
import static gui.ProductsPanel.qtyComboBox;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;


public class PostView extends javax.swing.JFrame {
    
    private static CustomerPanel customerPanel; //new
    private static InvoicePanel invoicePanel; //new
    private static PaymentPanel paymentPanel; //new
    private static ProductsPanel productsPanel; //new
    protected static int cartSize = 0;
    protected static int totalPrice = 0;
    private Cashier cashier;
    private JLabel timeTextField;

    public PostView(HashMap<String, Item> items,Cashier cashier) {
        this.cashier = cashier;
        initComponents(items);
    }  

    protected void createSale() {
        //Sale sale = cashier.createSale(CustomerPanel.getCustomerName());
        //System.out.println(cashier.createJson(sale));
    }

    protected static void clearFields() {
        amountTextField.setText(null);
        CustomerPanel.custNameTextField.setText(null);
        InvoicePanel.dtm.setRowCount(0);
        productsComboBox.setSelectedIndex(0);
        qtyComboBox.setSelectedIndex(0);
        payTypeComboBox.setSelectedIndex(0);
        invoicePanel.resetTotal(); // resets total price (idk if this should be in InvoicePanel)
        cartSize = 0;
        for(int count = 1; count <= 17; count++) {
            InvoicePanel.dtm.addRow(new Object[] {null, null, null, null, null, null});
        }
    }

    private void initComponents(HashMap<String, Item> items) {
        productsPanel = new ProductsPanel(items); 
        customerPanel = new CustomerPanel(); 
        invoicePanel = new InvoicePanel(); 
        paymentPanel = new PaymentPanel(); 
        timeTextField = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("POST");

        Date date = new Date();
        String strDateFormat = "hh:mm:ss aaa, EEEEE, MMMMM d, yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);

        timeTextField.setText(formattedDate);

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
    
}
