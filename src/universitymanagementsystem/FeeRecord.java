/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sadia
 */
public class FeeRecord extends javax.swing.JFrame {

    /**
     * Creates new form FeeRecord
     */
    public FeeRecord() {
        initComponents();
        getdata();
        this.setLocationRelativeTo(null);
    }
    sqlcom.SelectData sd = new sqlcom.SelectData();
    private void getdata()
    {
        DefaultTableModel model=(DefaultTableModel) jtable.getmodel();
        model.setRowCount(0);
        try{
            String query="select * from fee";
            ResultSet rs=sd.getsdata(query);
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString("Admission"),rs.getString("Name"),rs.getString("intake"),rs.getString("section"),rs.getString("yr"),rs.getString("month"),rs.getString("amount")});
            }
        }
        catch(Exception e)
        {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 int f=0;
 private void cbintakeItemStateChanged(java.awt.event.ItemEvent evt){
     DefaultTableModel model=(DefaultTableModel) jTable.getmodel();
     model.setRowCount(0);
     section.removeAllItems();
     f=0;
     
     try{
         String query="select * from fee where intake='"+cbintake.getSelectedItem().toString()+"'";
         ResultSet rs=sd.getsdata(query);
         while(rs.next())
         {
             model.addRow(new Object[]{rs.getString("Admission"),rs.getString("Name"),rs.getString("intake"),rs.getString("section"),rs.getString("yr"),rs.getString("month"),rs.getString("amount")});
         }
     }
     catch(Exception e)
        {
            
        }
     try{
         String query="select section from intake where intake='"+cbintake.getSelectedItem().toString()+"'";
         ResultSet rs=sd.getdata(query);
         while(rs.next())
         {
             section.addItem(rs.getString("section"));
         }
         f=1;
     }
     catch(Exception e)
        {
            
        }
     
 }
 private void sectionItemStateChanged(java.awt.event.ItemEvent evt){
     if(f!=0)
     {
 
     DefaultTableModel model=(DefaultTableModel) jTable.getmodel();
     model.setRowCount(0);
     try{
         String query="select*from fee where intake='"+cbintake.getSelectedItem().toString()+"' and section='"+section.getSelelctedItem()+"'";
         ResultSet rs=sd.getsdata(query);
         while(rs.next())
         {
             model.addRow(new Object[]{rs.getString("Admission"),rs.getString("Name"),rs.getString("intake"),rs.getString("section"),rs.getString("yr"),rs.getString("month"),rs.getString("amount")});
         }
     }
     catch(Exception e)
        {
            
        }
     }
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FeeRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeeRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeeRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeeRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeeRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}