package gui;

import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class CustomerPanel extends JPanel {

    private JLabel custNameLabel;
    protected static JTextField custNameTextField;

    public CustomerPanel()  {
        custNameLabel = new JLabel();
        custNameTextField = new JTextField();

        setBorder(BorderFactory.createTitledBorder("Customer"));
        custNameLabel.setText("Name ");

        custNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameTextFieldActionPerformed(evt);
            }
        });

        GroupLayout customerPanelLayout = new GroupLayout(this);
        setLayout(customerPanelLayout);
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

    }

    public static String getCustomerName(){
        return custNameTextField.getText();
    }

    private void custNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

}
