package gui;

import javax.swing.*;
import java.text.*;
import java.util.Date;

import static gui.CustomerPanel.custNameTextField;
import static gui.InvoicePanel.*; // when resetting the fields PostView needs access to dtms
import static gui.PaymentPanel.amountTextField;
import static gui.PaymentPanel.creditCardTextField;
import static gui.PaymentPanel.payTypeComboBox;
import static gui.ProductsPanel.productsComboBox;
import static gui.ProductsPanel.qtyComboBox;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;


public class PostView extends javax.swing.JFrame {
    
    /** Creates new form PostView */
    private PostView() {
        initComponents();
    }

    static int cartSize = 0;

    static double totalPrice;
    static DecimalFormat df;
    // End of variables declaration
    
    /** This method is called from within the constructor to
     * initialize the form.
     */                       
    private void initComponents() {

        //new
        ProductsPanel productsPanel = new ProductsPanel();
        // Variables declaration
        //new
        CustomerPanel customerPanel = new CustomerPanel();
        //new
        InvoicePanel invoicePanel = new InvoicePanel();
        //new
        PaymentPanel paymentPanel = new PaymentPanel();

        JLabel timeTextField = new JLabel();

        //totalPrice = 0.00;
        //df = new DecimalFormat("#.00");

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


    static void clearFields() {
        amountTextField.setText(null);
        custNameTextField.setText(null);
        creditCardTextField.setText(null);
        dtm.setRowCount(0);
        productsComboBox.setSelectedIndex(0);
        qtyComboBox.setSelectedIndex(0);
        payTypeComboBox.setSelectedIndex(0);
        totalPrice = 0.00;
        totalPriceLabel.setText("$ "+df.format(totalPrice));
        cartSize = 0;
        for(int count = 1; count <= 17; count++) {
            addRow();
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
                } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    // handle exception
                }
                PostView post = new PostView();

                post.setResizable(false);

                post.setVisible(true);
            }
        });
    }                
    
}
