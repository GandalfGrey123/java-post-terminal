package gui;

import system.*;
import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import java.util.HashMap;
import java.util.ArrayList;

import static gui.PostView.*;
import static gui.InvoicePanel.*; // products get sent to the invoice panel

public class ProductsPanel extends JPanel {

    private JLabel upcLabel;
    protected static JComboBox<Item> productsComboBox;
    private JLabel qtyLabel;
    protected static JComboBox qtyComboBox;
    private JButton enterButton;
    private HashMap<String, Item> dropdownMenuItems;
    private ArrayList<SaleItem> shoppingCart = new ArrayList<SaleItem>();

    public ProductsPanel(HashMap<String, Item> dropdownMenuItems) {
        this.dropdownMenuItems = dropdownMenuItems;

        upcLabel = new JLabel();
        productsComboBox = new JComboBox<Item>();
        dropdownMenuItems.forEach((upc,item) -> productsComboBox.addItem(item));
        qtyLabel = new JLabel();
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

        qtyComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

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
        System.out.println(productsComboBox.getSelectedItem());
        if(cartSize < 17) {
            addToCart((Item)productsComboBox.getSelectedItem(),Integer.parseInt(qtyComboBox.getSelectedItem().toString()));
        } else {
            dtm.addRow(new Item[] {null, null, null, null, null, null});
            addToCart((Item)productsComboBox.getSelectedItem(),Integer.parseInt(qtyComboBox.getSelectedItem().toString()));
            System.out.println("Cart full, made more space..");
        }
    }

    private void addToCart(Item item, int quantity) {
        float extendedPrice = item.getPrice()*quantity;
        invoiceScrollPane.setValueAt(item.getDescription(), cartSize, 0);
        invoiceScrollPane.setValueAt(quantity, cartSize, 1);
        invoiceScrollPane.setValueAt(item.getPrice(), cartSize, 2);
        invoiceScrollPane.setValueAt(extendedPrice, cartSize, 3);
        shoppingCart.add(new SaleItem(item.getUpc(),quantity,extendedPrice));
        cartSize++;
    }

    public ArrayList<SaleItem> getShoppingCart(){
        return shoppingCart;
    }
}
