/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aaaa;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ajith reddy
 */
public class pdfgenerator extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst1 = null;
    ResultSet rst1 = null;
    PreparedStatement pst = null;
    PreparedStatement pstadmin = null;
    PreparedStatement pstreg = null;
    ResultSet rstadmin = null;
    ResultSet rstreg = null;
   

    /**
     * Creates new form pdfgenerator
     */
    public pdfgenerator() {
        initComponents();
        jLabel2.setVisible(false);
        
        getid();
    }
    String patient_id;
public void getid(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");   
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosdb", "root", "Ajith@123");
            
            String query = ("select patient_id from patient");
            
            Statement stmt = con.createStatement();
            rstreg = stmt.executeQuery(query);
            
            while(rstreg.next()){
                patient_id = rstreg.getString("patient_id");
                jComboBox1.addItem(patient_id);
            }  
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

public void getDetails(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");   
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosdb", "root", "Ajith@123");
            
            String query = ("select * from patient where patient_id =?  ");
            
            Statement stmt = con.createStatement();
            rstreg = stmt.executeQuery(query);
            
            while(rstreg.next()){
                String patient_id = rstreg.getString("patient_id");
                String name = rstreg.getString("name");
                String age= rstreg.getString("age");
                String dob = rstreg.getString("dob");
                String gender = rstreg.getString("gender");
                String blood_group = rstreg.getString("blood_group");
                String contact_no = rstreg.getString("contact_no");
                String alternative_contact_no = rstreg.getString("alternative_contact_no");
                String address = rstreg.getString("address");
                String disease_suffered_earlier = rstreg.getString("disease_suffered_earlier");
                jComboBox1.addItem(patient_id);
            }  
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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

        btnPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPDF.setBackground(new java.awt.Color(204, 204, 204));
        btnPDF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPDF.setText("Generate Bill");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        getContentPane().add(btnPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 254, -1, 44));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "patient_id", "name", "age", "dob", "gender", "blood_group", "contact_no", "alternative_contact_no", "address", "disease_suffered_earlier"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 107, 713, 117));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Patient ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 26, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\java project images\\search.png")); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 23, -1, -1));

        jLabel2.setText("Patient ID does not exist!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 55, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 23, 126, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\java project images\\back.png")); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 254, 127, 44));

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\java project images\\Poly_BG_Grad (1)_0_1.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
        
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosdb", "root", "Ajith@123");
            System.out.println("Downloading PDF...");
            
//            String fileName = "C:\\Users\\mdamm\\OneDrive\\Documents\\generatePDF\\first_pdf.pdf";
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(".pdf"));
            doc.open();
            
            String query1 = ("SELECT * FROM patient_report where patient_id =?");
            pst1 = con.prepareStatement(query1);
            pst1.setString(1, patient_id);
            rst1 = pst1.executeQuery();
                
            if(rst1.next()){
                
                String patient_id = rst1.getString("patient_id");
                
                String symptoms = rst1.getString("symptoms");
                String diagnosis = rst1.getString("diagnosis");
                String diagnosed_by = rst1.getString("diagnosed_by");
                String medicines = rst1.getString("medicines");
                String price = rst1.getString("price");
                String ward_required = rst1.getString("ward_required");
                String ward = rst1.getString("ward");
                
                    
                Paragraph para = new Paragraph("Your Patient ID is: "+patient_id+ "\nSymptoms are: " +symptoms+ "\nDiagnosis : " +diagnosis+ "\nDiagnosed By : " +diagnosed_by+ "\nMedicines : " +medicines+ "\n Total Amount to Pay: " +price+ "\nWard Required : " +ward_required+ "\n Ward Type: " +ward);
                doc.add(para);
                doc.add(new Paragraph(" "));
                
            }
                
            
            con.close();
            pst1.close();
            
            rst1.close();
            
            System.out.println("Connection is closed...");
            
            doc.close();
            JOptionPane.showMessageDialog(this, "PDF Downloaded Succesfully");
            System.out.println("Succesfully Downloaded"); 
        }

        catch (Exception e){
            System.out.println("Exception occured " +e);
        }finally{
            
        }
        
    }//GEN-LAST:event_btnPDFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String user = jComboBox1.getSelectedItem().toString();
        
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosdb", "root", "Ajith@123");
            System.out.println("Connection established......");
        
            String query = ("SELECT * FROM patient where patient_id = ?");
        
            pstadmin = con.prepareStatement(query);
            pstadmin.setString(1, patient_id);
            rstadmin = pstadmin.executeQuery();
    
            while(rstadmin.next()){
                String patient_id = rstadmin.getString("patient_id");
                String name = rstadmin.getString("name");
                String age = rstadmin.getString("age");
                String dob = rstadmin.getString("dob");
                String gender = rstadmin.getString("gender");
                String blood_group = rstadmin.getString("blood_group");
                String contact_no = rstadmin.getString("contact_no");
                String alternative_contact_no = rstadmin.getString("alternative_contact_no");
                String address = rstadmin.getString("address");
                String disease_suffered_earlier = rstadmin.getString("disease_suffered_earlier");

                model.addRow(new Object [] {patient_id, name, age, dob, gender, blood_group, contact_no, alternative_contact_no, address, disease_suffered_earlier, null});
             }

        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new pdfgenerator().setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(pdfgenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pdfgenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pdfgenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pdfgenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pdfgenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
