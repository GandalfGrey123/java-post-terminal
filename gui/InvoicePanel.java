package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.PREFERRED_SIZE;

public class InvoicePanel extends JPanel {

    protected static DefaultTableModel dtm;
    protected static JTable invoiceScrollPane;
    private JScrollPane invoiceScrollPanel;
    protected static JLabel totalLabel;
    private JLabel totalPriceLabel;
    private String tableHeader[] = new String[] { "ITEM", "QUANTITY", "UNIT PRICE", "EXTENDED PRICE"};

    public InvoicePanel() {
        dtm = new DefaultTableModel(0,0);
        invoiceScrollPane = new JTable();
        invoiceScrollPanel = new JScrollPane();
        totalLabel = new JLabel();
        totalPriceLabel = new JLabel();

        setBorder(BorderFactory.createTitledBorder("Invoice"));

        dtm.setColumnIdentifiers(tableHeader);
        invoiceScrollPane.setModel(dtm);
        for(int count = 1; count <= 17; count++) {
            dtm.addRow(new Object[] {null, null, null, null, null, null});
        }
        invoiceScrollPanel.setViewportView(invoiceScrollPane);

        totalLabel.setFont(new Font("Lucida Grande", 1, 13));
        totalLabel.setText("TOTAL");
        totalPriceLabel.setFont(new Font("Lucida Grande", 1, 13));
        resetTotal();

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

    protected static void resetTotal() {
        totalLabel.setText("0.00");
    }

}
