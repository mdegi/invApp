/*
 * DepartmentsPanel.java
 *
 * Created on April 3, 2008, 4:38 PM
 */

package com.md.invapp;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import stdClasses.ScanWindowPanel;

import stdClasses.StatusBar;

/**
 *
 * @author  nla
 */
public class ItemPanel extends InvAppMaintPanel {
    
    /**
     * Creates a new instance of ItemPanel
     *
     * @param itemRecord
     * @param listDet
     * @param itemCategoriesList
     * @param itemGroupsList
     */

    public ItemPanel(ItemRecord itemRecord, Vector<Vector> listDet, 
            ArrayList<ItemCategoryRecord> itemCategoriesList, ArrayList<ItemGroupRecord> itemGroupsList, RuntimeArgs runTimeArgs) {

        initComponents();
        
        basicPanel = new ItemsBasicPanel(itemRecord);
        extendedPanel = new ItemsExtendedPanel(itemRecord, itemCategoriesList, itemGroupsList, runTimeArgs);
        scanWindowPanel = new ScanWindowPanel();
        
        initPanels();
        setEditable(false);
    }
    
    private void initPanels() {

        setLayout(new BorderLayout());
        
        add(scanWindowPanel,BorderLayout.WEST);
        add(basicPanel,BorderLayout.NORTH);
        add(extendedPanel,BorderLayout.CENTER);
        
        repaint();

    }
    
    public void initScanPanel(Vector<Vector> listDet) {

        clearForm();
        
        setSelectedIndex(CATEGORY_COMBO, 0);
        setSelectedIndex(GROUP_COMBO, 0);

        scanWindowPanel.deleteAllEntries();
        scanWindowPanel.removeAllCols();
        scanWindowPanel.initEntries(listDet);
        scanWindowPanel.initSearchPanel(JOptionPane.getFrameForComponent(this), "Search Employee");
    }

    public void requestFocus(int table) {
        scanWindowPanel.requestFocus();
    }
    
    public void deleteSelectedEntry() {
        scanWindowPanel.deleteSelectedEntry();
    }
    
    public void updateEntry(Object[] entry) {
        scanWindowPanel.setRowDetailsValue(scanWindowPanel.getSelectedIndex(),
            entry);
    }

    public void addEntry(Object[] entry) {
        scanWindowPanel.addListEntry(entry);

    }    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder("Maintain Stock Items"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void addListListener(ListSelectionListener listListener) {
        scanWindowPanel.addListSelectionListener(listListener);        
    }

    public void fillPanel(HashMap<Integer,String> combosValues) {
        basicPanel.fillPanel();
        extendedPanel.fillPanel(combosValues);
    }
    
    @Override
    public void fillRecord() {
        basicPanel.fillRecord();
        extendedPanel.fillRecord();
    }
    
    @Override
    public void clearForm() {
        basicPanel.clearForm();
        extendedPanel.clearForm();
    }
    
    @Override
    public void setEditable(boolean editRec) {
        basicPanel.setEditable(editRec) ;
        extendedPanel.setEditable(editRec);
    }
    
    public void setCodeEditable(boolean editRec) {
        basicPanel.setCodeEditable(editRec);
    }

    public void requestFocusWindow(int mode) {
        basicPanel.requestFocusWindow(mode);
    }
            
    @Override
    public void setStatusBar(StatusBar statusBar) {

        basicPanel.setStatusBar(statusBar);
        extendedPanel.setStatusBar(statusBar);
        
    }
    
    public void addListSelectionListener(ActionListener listener) {
        //jComboBox1.addActionListener(listener);
    }

    public int getSelectedIndex(int listComponent) {
        int index = 0;
        switch (listComponent) {
            case ITEM_TABLE:
                index = scanWindowPanel.getSelectedIndex();
                break;
            case CATEGORY_COMBO:
                index = extendedPanel.getSelectedIndex(CATEGORY_COMBO);
                break;
            case GROUP_COMBO:
                index = extendedPanel.getSelectedIndex(GROUP_COMBO);
                break;
        }

        return index;

    }

    public String getSelectedItem(int listComponent) {                      
        String selectedStr = null;
                
        switch (listComponent) {
            case ITEM_TABLE:
                selectedStr = scanWindowPanel.getSelectedValue(0);
                break;
            case CATEGORY_COMBO:
                selectedStr = (String)extendedPanel.getSelectedItem(CATEGORY_COMBO);
                break;
            case GROUP_COMBO:
                selectedStr = (String)extendedPanel.getSelectedItem(GROUP_COMBO);
                break;
        }

        return selectedStr;
    }

    public void setSelectedIndex(String itemCode) {
        if (scanWindowPanel.getRowCount() > 0) {
            scanWindowPanel.setSelectedIndex(itemCode, 1);
        }
    }


    public void setSelectedIndex(int combo, String value) {

        switch (combo) {
            case CATEGORY_COMBO:
                extendedPanel.setSelectedIndex(CATEGORY_COMBO, value);
                break;
            case GROUP_COMBO:
                extendedPanel.setSelectedIndex(GROUP_COMBO, value);
                break;
        }        
    }
    
    public void setSelectedIndex(int combo, int index) {
        switch (combo) {
            case CATEGORY_COMBO:
                extendedPanel.setSelectedIndex(CATEGORY_COMBO, index);
                break;
            case GROUP_COMBO:
                extendedPanel.setSelectedIndex(GROUP_COMBO, index);
                break;
        }
    }

    @Override
    public void setEnableSearchList(boolean mode) {
        scanWindowPanel.setEnabled(mode);
    }


    public static final int ITEM_TABLE = 0;
    
    public static final int CATEGORY_COMBO = ItemsExtendedPanel.CATEGORY_COMBO;
    public static final int GROUP_COMBO = ItemsExtendedPanel.GROUP_COMBO;

    private final ScanWindowPanel scanWindowPanel;
    private final ItemsBasicPanel basicPanel;
    private final ItemsExtendedPanel extendedPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}