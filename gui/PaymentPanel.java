package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

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
    private JLabel creditCardLabel;
    protected static JTextField creditCardTextField;
    private JButton payButton;


    public PaymentPanel() {

        paymentLabel = new JLabel();
        payTypeComboBox = new JComboBox();
        amountLabel = new JLabel();
        amountTextField = new JTextField();
        creditCardLabel = new JLabel();
        creditCardTextField = new JTextField();
        payButton = new JButton();

        creditCardLabel.setVisible(false);
        creditCardTextField.setVisible(false);

        payTypeComboBox.addActionListener(new ActionListener() {

                                              @Override
                                              public void actionPerformed(ActionEvent ae) {
                                                  // check whether there is any selection
                                                  if (payTypeComboBox.getSelectedIndex() == 1) {
                                                      creditCardLabel.setVisible(true);
                                                      creditCardTextField.setVisible(true);
                                                      PaymentPanel.this.revalidate();
                                                      PaymentPanel.this.repaint();
                                                  } else {
                                                      creditCardLabel.setVisible(false);
                                                      creditCardTextField.setVisible(false);
                                                      PaymentPanel.this.revalidate();
                                                      PaymentPanel.this.repaint();
                                                  }
                                              }
            });


        setBorder(BorderFactory.createTitledBorder("Payment"));
        paymentLabel.setText("Payment type");

        payTypeComboBox.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Credit", "Check"}));
        payTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payTypeComboBoxActionPerformed(evt);
            }
        });

        amountLabel.setText(" Amount");
        creditCardLabel.setText("Credit Card Number: ");


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
                                                //.addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(creditCardLabel)
                                                .addPreferredGap(RELATED)
                                                .addComponent(creditCardTextField, PREFERRED_SIZE, 120, PREFERRED_SIZE)
                                                .addComponent(payButton)))
                                .addContainerGap())
        );
        paymentPanelLayout.linkSize(SwingConstants.HORIZONTAL, creditCardLabel, creditCardTextField);
        paymentPanelLayout.setVerticalGroup(
                paymentPanelLayout.createParallelGroup(LEADING)
                        .addGroup(paymentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paymentPanelLayout.createParallelGroup(BASELINE)
                                        .addComponent(paymentLabel)
                                        .addComponent(payTypeComboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(amountLabel)
                                        .addComponent(amountTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGroup(paymentPanelLayout.createParallelGroup(BASELINE)
                                        .addComponent(creditCardLabel)
                                        .addComponent(creditCardTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(payButton))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );


    }


    private static void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // clear all fields and send data to REST API database
        clearFields();
    }

    private void payTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // send to REST endpoint
    }
}
