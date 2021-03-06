/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.invapp;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import stdClasses.StdFun;

/**
 *
 * @author Martin.Degiorgio
 */
public class ItemSalesFooterPanel extends javax.swing.JPanel implements ItemSalesFooterInterface {

    /**
     * Creates new form ItemSalesFooterPanel
     * @param headerRord
     */
    public ItemSalesFooterPanel(ItemTransHeaderRecord headerRecord) {
        this.headerRecord = headerRecord;
        
        initComponents();
        initTextFields();
    }

    private void initTextFields() {
        jFormattedTextField2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),"enterKey");
        jFormattedTextField2.getActionMap().put("enterKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalcTotal();
                jTextField1.requestFocusInWindow();
            }            
        });       
    }
    
    /**
     * Show Transaction total before any global discounts
     * 
     * @param transTotal
     */
    @Override
    public void populateTransTotal(float transTotal) {        
        jFormattedTextField1.setText(DEC_FORMAT.format(transTotal));        
    }
    
    private void recalcTotal() {        
        float transTotal = StdFun.getFloatValue(jFormattedTextField1.getText());        
        float subTotal = transTotal - ((StdFun.getFloatValue(jFormattedTextField2.getText()) / 100f)  * transTotal);
        jFormattedTextField3.setText(DEC_FORMAT.format(subTotal));        
        jFormattedTextField4.setText(DEC_FORMAT.format(subTotal * 0.18));        
        jFormattedTextField5.setText(DEC_FORMAT.format(subTotal + StdFun.getFloatValue(jFormattedTextField4.getText())) + "");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Total:");

        jLabel2.setText("% Discount:");

        jLabel3.setText("S/Total:");

        jLabel4.setText("18% VAT:");

        jLabel5.setText("Total:");

        jLabel6.setText("Comments:");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(StdFun.DECIMAL_FORMAT))));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(StdFun.DECIMAL_FORMAT))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(StdFun.DECIMAL_FORMAT))));
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(StdFun.DECIMAL_FORMAT))));
        jFormattedTextField4.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jFormattedTextField5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(StdFun.DECIMAL_FORMAT))));
        jFormattedTextField5.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jFormattedTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFormattedTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void clearForm() {
        jTextField1.setText("");        
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
        jFormattedTextField3.setText("");
        jFormattedTextField4.setText("");
        jFormattedTextField5.setText("");
    }

    @Override
    public void setEditable(boolean editable) {
        jTextField1.setEditable(editable);
        jFormattedTextField1.setEditable(false);
        jFormattedTextField2.setEditable(editable);
        jFormattedTextField3.setEditable(false);
        jFormattedTextField4.setEditable(false);
        jFormattedTextField5.setEditable(false);
    }

    public boolean entriesComplete() {        
        boolean entriesComplete = true;
        
        if (jFormattedTextField1.getText() == null ||
            jFormattedTextField3.getText() == null ||
                jFormattedTextField4.getText() == null ||
                jFormattedTextField5.getText() == null
                ) {
            entriesComplete = false;
        }

        if (jFormattedTextField2.getText() == null) {
            jFormattedTextField2.setText(DEC_FORMAT.format(0.00f));
        }
        return entriesComplete;
    }

    public void fillRecord() {
        headerRecord.setComments(jTextField1.getText());
        headerRecord.setPercentageDisc(StdFun.getFloatValue(jFormattedTextField2.getText()));
    }


    private ItemTransHeaderRecord headerRecord;
    private final DecimalFormat DEC_FORMAT = new DecimalFormat(StdFun.DECIMAL_FORMAT);    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean setFocusOnDiscountField() {
        return jFormattedTextField2.requestFocusInWindow();
    }
}
