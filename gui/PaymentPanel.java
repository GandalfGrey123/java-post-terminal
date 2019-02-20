package gui;

import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static gui.PostView.clearFields;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class PaymentPanel extends JPanel {

    private JLabel paymentLabel = new JLabel();
    protected static JComboBox payTypeComboBox = new JComboBox();
    private JLabel amountLabel = new JLabel();
    protected static JTextField amountTextField = new JTextField();
    private JButton payButton = new JButton();
    private JLabel creditCardLabel = new JLabel();
    private JTextField creditCardTxt = new JTextField();
    private PostView postView;

    public PaymentPanel(PostView postView) {
        this.postView=postView; 
        setBorder(BorderFactory.createTitledBorder("Payment"));
        paymentLabel.setText("Payment type");
        payTypeComboBox.setModel(new DefaultComboBoxModel(new String[] { "CASH", "CREDIT", "CHECK"}));
        creditCardLabel.setText("Credit card #");
        creditCardLabel.setVisible(false);
        creditCardTxt.setText("123456789");
        creditCardTxt.setVisible(false);
        amountLabel.setText(" Amount");
        payButton.setText("Pay");

        payTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payTypeComboBoxActionPerformed(evt);
            }
        });

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
                .addGroup(paymentPanelLayout.createParallelGroup(TRAILING)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(paymentLabel)
                        .addPreferredGap(RELATED)
                        .addComponent(payTypeComboBox, PREFERRED_SIZE, 96, PREFERRED_SIZE)
                        .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(creditCardLabel)
                        .addPreferredGap(UNRELATED)
                        .addComponent(creditCardTxt, PREFERRED_SIZE, 104, PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(paymentPanelLayout.createParallelGroup(LEADING)
                    .addGroup(TRAILING, paymentPanelLayout.createSequentialGroup()
                        .addComponent(amountLabel)
                        .addPreferredGap(RELATED)
                        .addComponent(amountTextField, PREFERRED_SIZE, 95, PREFERRED_SIZE))
                    .addComponent(payButton))
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
                .addGroup(paymentPanelLayout.createParallelGroup(LEADING)
                    .addComponent(payButton)
                    .addGroup(paymentPanelLayout.createParallelGroup(BASELINE)
                        .addComponent(creditCardLabel)
                        .addComponent(creditCardTxt, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
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
        private void payTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) { 
        if (payTypeComboBox.getSelectedItem() == "CREDIT"){
            creditCardLabel.setVisible(true);
            creditCardTxt.setVisible(true);
        }else{
            creditCardLabel.setVisible(false);
            creditCardTxt.setVisible(false);
        }                                               
    }  
}
