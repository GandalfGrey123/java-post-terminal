package gui;

import system.Item;

import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import java.util.HashMap;

import static gui.PostView.*;
import static gui.InvoicePanel.*; // products get sent to the invoice panel

class ProductsPanel extends JPanel {

    static JComboBox<String> productsComboBox;
    static JComboBox<String> qtyComboBox;
    static JLabel upcLabel;
    static JButton enterButton;


    public ProductsPanel(HashMap<String, Item> items) {

        upcLabel = new JLabel();
        JComboBox<Item> productsComboBox = new JComboBox<Item>();
        items.forEach((upc,item) -> productsComboBox.addItem(item));
        JLabel qtyLabel = new JLabel();
        qtyComboBox = new JComboBox();
        enterButton = new JButton();

        setBorder(BorderFactory.createTitledBorder("Products"));
        upcLabel.setText("UPC");
        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        qtyLabel.setText("Qty");

        qtyComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        GroupLayout productsPanelLayout = new GroupLayout(this);
        setLayout(productsPanelLayout);

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


    }

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //insert and store data into Jtable
        if(cartSize < 17) {
            //addToCart(productsComboBox.getSelectedItem(),qtyComboBox.getSelectedItem());
        } else {
            dtm.addRow(new Object[] {null, null, null, null, null, null});
            addToCart(productsComboBox.getSelectedItem(), Float.parseFloat((String)qtyComboBox.getSelectedItem()));
            System.out.println("Cart full, made more space..");
        }

    }

    private void addToCart(Object item, Object quantity) {
        String price = Float.toString(item.getPrice());
        String extPrice = Float.toString(item.getPrice());
        invoiceScrollPane.setValueAt(productsComboBox.getSelectedItem(), cartSize, 0);
        invoiceScrollPane.setValueAt(qtyComboBox.getSelectedItem(), cartSize, 1);
        invoiceScrollPane.setValueAt(price, cartSize, 2);
        invoiceScrollPane.setValueAt(extPrice, cartSize, 3);
        cartSize++;

    }

    private void addToCart(Object upc, Object quantity, Object price, Object extPrice) {
        //use this one with the REST data
    }
}
