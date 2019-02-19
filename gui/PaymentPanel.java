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

    private JLabel paymentLabel;
    protected static JComboBox payTypeComboBox;
    private JLabel amountLabel;
    protected static JTextField amountTextField;
    private JButton payButton;
    private PostView postView;


    public PaymentPanel(PostView postView) {
        this.postView=postView;

        paymentLabel = new JLabel();
        payTypeComboBox = new JComboBox();
        amountLabel = new JLabel();
        amountTextField = new JTextField();
        payButton = new JButton();


        setBorder(BorderFactory.createTitledBorder("Payment"));
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

    private void payTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // send to REST endpoint
    }
}
