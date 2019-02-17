package gui;

import system.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.geom.RoundRectangle2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static gui.PaymentPanel.amountTextField;
import static gui.PaymentPanel.payTypeComboBox;
import static gui.ProductsPanel.productsComboBox;
import static gui.ProductsPanel.qtyComboBox;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;


public class PostView extends javax.swing.JFrame {
    
    /** Creates new form PostView */
    public PostView(String[] items) {
        initComponents(items);
    }
    
    // Variables declaration
    private static CustomerPanel customerPanel; //new
    private static InvoicePanel invoicePanel; //new
    private static PaymentPanel paymentPanel; //new
    private static ProductsPanel productsPanel; //new

    protected static int cartSize = 0;

    protected static int totalPrice = 0;

    private JLabel timeTextField;
    // End of variables declaration   
    
    /** This method is called from within the constructor to
     * initialize the form.
     */                       
    private void initComponents(String[] items) {

        productsPanel = new ProductsPanel(items); //new
        customerPanel = new CustomerPanel(); //new
        invoicePanel = new InvoicePanel(); //new
        paymentPanel = new PaymentPanel(); //new

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
    
    /**
     * @param args the command line arguments
     */
    public static void start(String[] items) {
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
                PostView post = new PostView(items);

                post.setResizable(false);

                post.setVisible(true);
            }
        });
    }                
    
}
