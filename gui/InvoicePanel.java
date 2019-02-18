package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

import static gui.PostView.totalPrice;
import static gui.PostView.df;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.PREFERRED_SIZE;

class InvoicePanel extends JPanel {

    static DefaultTableModel dtm;
    static JTable invoiceScrollPane;
    static JLabel totalPriceLabel;

    InvoicePanel() {
        setBorder(BorderFactory.createTitledBorder("Invoice"));

        dtm = new DefaultTableModel(0,0);
        invoiceScrollPane = new JTable();
        totalPriceLabel = new JLabel();

        totalPriceLabel.setFont(new Font("Lucida Grande", 1, 13));
        totalPrice = 0.00;
        df = new DecimalFormat("#0.00");
        totalPriceLabel.setText("$ "+df.format(totalPrice));



        String[] tableHeader = new String[]{"ITEM", "QUANTITY", "UNIT PRICE", "EXTENDED PRICE"};
        dtm.setColumnIdentifiers(tableHeader);
        invoiceScrollPane.setModel(dtm);
        for(int count = 1; count <= 17; count++) {
            addRow();
        }

        JScrollPane invoiceScrollPanel = new JScrollPane();
        invoiceScrollPanel.setViewportView(invoiceScrollPane);

        JLabel totalLabel = new JLabel();
        totalLabel.setFont(new Font("Lucida Grande", 1, 13));
        totalLabel.setText("TOTAL");


        GroupLayout invoicePanelLayout = new GroupLayout(this);
        setLayout(invoicePanelLayout);

        invoicePanelLayout.setHorizontalGroup(
                invoicePanelLayout.createParallelGroup(LEADING)
                        .addGroup(invoicePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(invoiceScrollPanel, PREFERRED_SIZE, 730, PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
                        .addGroup(TRAILING, invoicePanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalLabel)
                                .addGap(29, 29, 29)
                                .addComponent(totalPriceLabel)
                                .addGap(145, 145, 145))
        );
        invoicePanelLayout.setVerticalGroup(
                invoicePanelLayout.createParallelGroup(LEADING)
                        .addGroup(invoicePanelLayout.createSequentialGroup()
                                .addComponent(invoiceScrollPanel, PREFERRED_SIZE, 305, PREFERRED_SIZE)
                                .addGroup(invoicePanelLayout.createParallelGroup(BASELINE)
                                        .addComponent(totalLabel)
                                        .addComponent(totalPriceLabel)))
        );

    }

    static void addRow() {
        dtm.addRow(new Object[] {null, null, null, null});
    }

}
