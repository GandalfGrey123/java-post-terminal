package gui;

import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

import static gui.PostView.clearFields;

public class PaymentPanel extends JPanel {

    private JLabel paymentLabel = new JLabel();
    protected static JComboBox payTypeComboBox = new JComboBox();
    private JLabel amountLabel = new JLabel();
    protected static JTextField amountTextField = new JTextField();
    private JButton payButton = new JButton();
    private PostView postView;


    public PaymentPanel(PostView postView) {
        this.postView=postView; 

        setBorder(BorderFactory.createTitledBorder("Payment"));
        paymentLabel.setText("Payment type");

        payTypeComboBox.setModel(new DefaultComboBoxModel(new String[] { "CASH", "CREDIT", "CHECK"}));

        amountLabel.setText(" Amount");

        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        GroupLayout paymentPanelLayout = new GroupLayout(this);

        setLayout(paymentPanelLayout);
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
    }

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
        postView.createSale();
        clearFields();
    }

    public static String getPaymentMethod(){
        return String.valueOf(payTypeComboBox.getSelectedItem());
    }

    public static float getAmountTendered(){
        return Float.parseFloat(amountTextField.getText());
    }
}
