/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.invapp.reports;

import com.md.invapp.RuntimeArgs;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import stdClasses.StdFun;

/**
 *
 * @author user
 */
public class DatesRepInternalFrame extends ReportsFrame {

    /**
     * Creates new form DatesRepInternalFrame
     * @param desktopDimension
     * @param repName
     * @param dimension
     * @param daArgs
     */
    public DatesRepInternalFrame(Dimension desktopDimension, String repName, Dimension dimension, RuntimeArgs daArgs) {
        
        super(daArgs);
        
        this.repName = repName;
        this.daArgs = daArgs;
       
        initComponents();
        emlChkBox.setSelected(false);
        emlTextField.setText("");
        emlTextField.setEditable(false);
                
        dateFrom.addMouseListener((new MouseAdapter() { // Arrival Date
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    StdFun.chooseDate(dateFrom, jPanel1);
                }
            }
        }));

        dateTo.addMouseListener((new MouseAdapter() { // Arrival Date
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    StdFun.chooseDate(dateTo, jPanel1);
                }
            }
        }));

        setLocation(desktopDimension);
        
        if ((!repName.equals(PURCHASE_XL_REPORT)) && (!repName.equals(SALES_XL_REPORT))) {
            remove(jPanel2);
            remove(jPanel3);
        } else {
            destPathField.setText(daArgs.getInvAppConfig().getReportsPath());
        }
        
        pack();
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateFrom = new JFormattedTextField() {

            @Override
            public void paintComponent(Graphics g) {

                if (isEditable()) {
                    setOpaque(false);
                    g.setColor(StdFun.LIGHT_YELLOW);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(Color.BLACK);
                    g.drawString("*", (getWidth() - 10), 12);
                } else {
                    setOpaque(true);
                    setBackground(StdFun.LIGHT_GREY);
                }
                super.paintComponent(g);
            }
        };
        dateTo = new JFormattedTextField() {

            @Override
            public void paintComponent(Graphics g) {

                if (isEditable()) {
                    setOpaque(false);
                    g.setColor(StdFun.LIGHT_YELLOW);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(Color.BLACK);
                    g.drawString("*", (getWidth() - 10), 12);
                } else {
                    setOpaque(true);
                    setBackground(StdFun.LIGHT_GREY);
                }
                super.paintComponent(g);
            }
        };
        processButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        destPathField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        emlTextField = new javax.swing.JTextField();
        emlChkBox = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle(repName);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Date From:");

        jLabel2.setText("Date To:");

        dateFrom.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(StdFun.STANDARD_DATE_FORMAT))));
        dateFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFromFocusLost(evt);
            }
        });
        dateFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFromActionPerformed(evt);
            }
        });

        dateTo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(StdFun.STANDARD_DATE_FORMAT))));
        dateTo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateToFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        processButton.setText("Process report");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(destPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(browseButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        emlChkBox.setText("Send Email");
        emlChkBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                emlChkBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emlChkBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emlChkBox))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(processButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName(repName);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateFromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFromFocusLost
        StdFun.easyDate(dateFrom, false);
    }//GEN-LAST:event_dateFromFocusLost

    private void dateToFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateToFocusLost
        StdFun.easyDate(dateTo, false);
    }//GEN-LAST:event_dateToFocusLost

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed

        if (validSelections()) {              
            if (repName.equals(VAT_REPORT) || (repName.equals(PROFIT_REPORT)))  {
                HashMap<String, Object> reportParameters = new HashMap<>();        
            
                String reportName = null;
                reportParameters.put("repHeader", StdFun.SYSTEM_TITLE + " - " + StdFun.getStandardDate(StdFun.getToday()));
                reportParameters.put("compName", "Brincat Auto Dealer");
                reportParameters.put("dateFrom", dateFrom.getText());
                reportParameters.put("dateTo", dateTo.getText());
                reportParameters.put("dateFromSQL", StdFun.getSQLDate(dateFrom.getText()));
                reportParameters.put("dateToSQL", StdFun.getSQLDate(dateTo.getText()));            

                String usrGrpFilter = "";
                reportParameters.put("usrGrpFilter", usrGrpFilter);

                if (repName.equals(VAT_REPORT)) {                
                    reportName = "VatReport.jasper";
                }
                if (repName.equals(PROFIT_REPORT)) {                
                    reportName = "ProfitReport.jasper";
                }

                DocBuilder docBuilder = null;
                try {
                    docBuilder = new DocBuilder(reportName, daArgs);
                    docBuilder.fill(reportParameters);
                    docBuilder.view();
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this),
                        "Error initialising report:\n" + ex.getMessage(),
                        StdFun.SYSTEM_TITLE,JOptionPane.ERROR_MESSAGE) ;
                }
            }
            if ((repName.equals(PURCHASE_XL_REPORT)) || (repName.equals(SALES_XL_REPORT))) {
                try {
                    daArgs.saveOutpuPath(destPathField.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this),
                        "IO Exception saving report path:\n" + ex.getMessage(),
                        StdFun.SYSTEM_TITLE,JOptionPane.ERROR_MESSAGE) ;                    
                }
                
                
            
                if (repName.equals(PURCHASE_XL_REPORT)) {
                    processPurchaseXLRep();
                }
                if (repName.equals(SALES_XL_REPORT)) {
                    processSalesXLRep();
                }
            }
        }
       
    }//GEN-LAST:event_processButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            destPathField.setText(chooser.getSelectedFile().getPath());
        }

    }//GEN-LAST:event_browseButtonActionPerformed

    private void emlChkBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_emlChkBoxItemStateChanged

        if (emlChkBox.isSelected()) {
            emlTextField.setEditable(true);
            if ((emlTextField.getText() == null) || (emlTextField.getText().equals(""))) {
                emlTextField.setText(daArgs.getInvAppConfig().getReportsPath());
            }
        } else {
            emlTextField.setText("");
            emlTextField.setEditable(false);
        }

    }//GEN-LAST:event_emlChkBoxItemStateChanged

    private void dateFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFromActionPerformed

    private boolean validSelections() {
    
        boolean validRec = true;
    
        if ((dateFrom.getText() != null) && (dateTo.getText() != null)) {
            if ((StdFun.convStandardDate(dateFrom.getText()) == null) ||
                (StdFun.convStandardDate(dateTo.getText()) == null)) {

                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this),
                    "Please enter valid dates",
                    StdFun.SYSTEM_TITLE,JOptionPane.ERROR_MESSAGE) ;
                validRec = false;
            }

            if (validRec) {
                if (StdFun.convStandardDate(dateFrom.getText()).after(StdFun.convStandardDate(dateTo.getText()))) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this),
                        "Date From must be before Date To",
                        StdFun.SYSTEM_TITLE,JOptionPane.ERROR_MESSAGE) ;
                    validRec = false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this),
                "Dates cannot be left null",
                StdFun.SYSTEM_TITLE,JOptionPane.ERROR_MESSAGE) ;

            validRec = false;
        }
        
        if ((repName.equals(PURCHASE_XL_REPORT)) || (repName.equals(SALES_XL_REPORT))) {
            if ((destPathField.getText() == null) || (destPathField.getText().equals(""))) {
                validRec = false;    
                
                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this),
                    "Please select a valid destination for XL file",
                    StdFun.SYSTEM_TITLE,JOptionPane.ERROR_MESSAGE) ;
            }
        }
        return validRec;
    }

    private void processPurchaseXLRep() {        
    }
             
    private void processSalesXLRep() {
    }
    
    private void outputXLFile(ArrayList<ArrayList<Object>> allGoTrans, String workSheetName, String fileName) 
        throws FileNotFoundException, IOException {
        
        HSSFWorkbook outBook = new HSSFWorkbook();
        HSSFSheet outSheet = outBook.createSheet(workSheetName);
        
        HSSFCellStyle cellHeaderStyle = outBook.createCellStyle();
        cellHeaderStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));        
        
        HSSFFont headerFont= outBook.createFont();
        headerFont.setBold(true);
        cellHeaderStyle.setFont(headerFont);
        //cellHeaderStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        //cellHeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        
        HSSFCellStyle cellNumStyle = outBook.createCellStyle();
        cellNumStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));        
                
        HSSFCellStyle cellIntStyle = outBook.createCellStyle();
        cellIntStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));        
        
        int outRowNo=0;
        int numOfCols = 0;
        
        Row outRow;

        outRowNo++;
        
        boolean headerPrinted= false;
        
        outRow = outSheet.createRow(outRowNo);        
        for (Iterator<ArrayList<Object>> outIter = allGoTrans.iterator(); outIter.hasNext();) {
            ArrayList<Object> arrayList = outIter.next();

            if (numOfCols < arrayList.size()) {
                numOfCols = arrayList.size();
            }
            
            for (int x = 0; x < arrayList.size(); x ++) {
                Object toPrint = arrayList.get(x);
                HSSFCell cell = (HSSFCell)outRow.createCell(x) ;

                if (toPrint instanceof String) {
                    if (!headerPrinted) {
                        cell.setCellStyle(cellHeaderStyle);
                    }
                    cell.setCellValue((String)toPrint);
                }
                if (toPrint instanceof Integer) {
                    cell.setCellStyle(cellIntStyle);
                    cell.setCellValue((Integer)toPrint);
                }
                if (toPrint instanceof Float) {
                    cell.setCellStyle(cellNumStyle);                    
                    double dblVal = StdFun.roundVal(((Float)toPrint).floatValue(),2); 
                    
                    cell.setCellValue((Math.round(dblVal * 100d)) / 100d);
                }
                if (toPrint instanceof Double) {    
                    cell.setCellStyle(cellNumStyle);
                    cell.setCellValue((Double)toPrint);
                }                
            }
            
            outRowNo++;
            outRow = outSheet.createRow(outRowNo);
            
            headerPrinted = true;
        }

        for (int x = 0; x < numOfCols; x ++){
            outSheet.autoSizeColumn(x);
        }
                
        FileOutputStream out;
        String outputFile = destPathField.getText() + StdFun.osFs() + fileName;
        out = new FileOutputStream(outputFile);
        outBook.write(out);
        out.flush();
        out.close();

        Desktop.getDesktop().open(new File(outputFile));

    }

    
    public static String VAT_REPORT = "VAT Report";
    public static String PROFIT_REPORT = "Profit Report";
    public static String PURCHASE_XL_REPORT = "Purchase XL Report";    
    public static String SALES_XL_REPORT = "Sales XL Report";    
    
    private RuntimeArgs daArgs;
    private String repName;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JFormattedTextField dateFrom;
    private javax.swing.JFormattedTextField dateTo;
    private javax.swing.JTextField destPathField;
    private javax.swing.JCheckBox emlChkBox;
    private javax.swing.JTextField emlTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton processButton;
    // End of variables declaration//GEN-END:variables
}
