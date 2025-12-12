/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gymapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.File;
import java.awt.Desktop;

public class Finance extends javax.swing.JFrame {

    /**
     * Creates new form Finance
     */
    public Finance() {
        initComponents();
        DisplayPayment();
        GetMember();
    }
    
    
    Connection con=null;
    PreparedStatement pst  =null;
    ResultSet rs = null, rs1=null;
    Statement st=null , st1=null;

    private void DisplayPayment(){
            {
        try{
           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", "");
           st = con.createStatement();
           rs = st.executeQuery("select * from FinanceTbl");
           PaymentTable.setModel(DbUtils.resultSetToTableModel(rs));
                   }catch (Exception e){
        
        }
    }
  }
    
    private void GetMember()
    {
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", "");
            st = con.createStatement();
            String Query = "Select * from MemberTbl";
            rs = st.executeQuery(Query);
            while(rs.next())
            {
                String MemberName = rs.getNString("MName");
                MemberCb.addItem(MemberName);
                
            }
        }catch (Exception e){
            
        }
    }

    
    private void generateReceipt(String member, String date, String amount) {
        try {
        Document doc = new Document(PageSize.A4);
        String filePath = "Receipt_" + member + "_" + System.currentTimeMillis() + ".pdf";
        PdfWriter.getInstance(doc, new FileOutputStream(filePath));
        doc.open();
        try {
            Image logo = Image.getInstance("D:/Gym Project/logo.png"); // change path to your logo file
            logo.scaleAbsolute(80, 80); // resize
            logo.setAlignment(Image.ALIGN_LEFT);
            doc.add(logo);
        } catch (Exception ex) {
            // logo optional, ignore if not found
        }
         Font gymFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.BLACK);
        Paragraph gymName = new Paragraph("FITNESS SPOT GYM", gymFont);
        gymName.setAlignment(Element.ALIGN_CENTER);
        doc.add(gymName);
        Font infoFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
        Paragraph address = new Paragraph("123 Fitness Street, Mumbai, Maharashtra\nPhone: +123 456 7890 | Email: info@fitnessspot.com\n\n", infoFont);
        address.setAlignment(Element.ALIGN_CENTER);
        doc.add(address);

        doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------\n\n"));

        // ===== RECEIPT TITLE =====
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
        Paragraph title = new Paragraph("Payment Receipt", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);
        doc.add(new Paragraph("\n"));

        // ===== TABLE WITH DETAILS =====
        PdfPTable table = new PdfPTable(2); // 2 columns
        table.setWidthPercentage(80);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Table font
        Font tableFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
        

        table.addCell(new PdfPCell(new Phrase("Member Name", tableFont)));
        table.addCell(new PdfPCell(new Phrase(member, tableFont)));

        table.addCell(new PdfPCell(new Phrase("Date", tableFont)));
        table.addCell(new PdfPCell(new Phrase(date, tableFont)));

        table.addCell(new PdfPCell(new Phrase("Amount Paid", tableFont)));
        table.addCell(new PdfPCell(new Phrase(amount, tableFont)));

        doc.add(table);

        // ===== FOOTER =====
        Paragraph thanks = new Paragraph("\nThank you for staying fit with us!\n", infoFont);
        thanks.setAlignment(Element.ALIGN_CENTER);
        doc.add(thanks);

        doc.close();

        JOptionPane.showMessageDialog(this, "Receipt generated successfully!");

        // ✅ Open the PDF automatically
        File pdfFile = new File(filePath);
        if (pdfFile.exists() && Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(pdfFile);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error generating receipt: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AmountTb = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        MemberCb = new javax.swing.JComboBox<>();
        Savebtn = new javax.swing.JButton();
        Resetbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PaymentTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        PhoneTb = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        MonthTb = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Couches");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Logout");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\couch.jpg")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\logouy.png")); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\gymicon.png")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Members");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\couch.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2)))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Manage Finance");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 15, -1, -1));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 112, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Member Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 140, -1));

        AmountTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountTbActionPerformed(evt);
            }
        });
        jPanel1.add(AmountTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 132, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Amount");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 110, -1));

        MemberCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemberCbActionPerformed(evt);
            }
        });
        jPanel1.add(MemberCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 132, -1));

        Savebtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Savebtn.setForeground(new java.awt.Color(51, 153, 0));
        Savebtn.setText("Save");
        Savebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SavebtnMouseClicked(evt);
            }
        });
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });
        jPanel1.add(Savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        Resetbtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Resetbtn.setForeground(new java.awt.Color(204, 51, 0));
        Resetbtn.setText("Reset");
        Resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Resetbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        PaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(PaymentTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 192, 492, 350));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Phone Number");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        PhoneTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTbActionPerformed(evt);
            }
        });
        jPanel1.add(PhoneTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 146, 134, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 153, 0));
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 51, 0));
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Month");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 80, -1));
        jPanel1.add(MonthTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\mem2.jpg")); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new Members().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       new Coachs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void AmountTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountTbActionPerformed
        
    }//GEN-LAST:event_AmountTbActionPerformed

    private void PhoneTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTbActionPerformed

    private void MemberCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemberCbActionPerformed
         try {
        String selectedName = MemberCb.getSelectedItem().toString();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
        
        String query = "SELECT MAmount FROM MemberTbl WHERE MName = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, selectedName);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            // Assuming your MemberTbl has a column called MAmount
            int amount = rs.getInt("MAmount");
            AmountTb.setText(String.valueOf(amount));
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }                     
    }//GEN-LAST:event_MemberCbActionPerformed

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SavebtnActionPerformed
     
    
    private void SavebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SavebtnMouseClicked
        java.util.Date selectedDate = MonthTb.getDate();
        
        if(MonthTb.getDate()== null || AmountTb.getText().isEmpty() || MemberCb.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }else{
                try{
                    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", "");
                    PreparedStatement add = con.prepareStatement(
                "INSERT INTO FinanceTbl(PPeriod, PMember, PAmount) VALUES (?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );
                     add.setDate(1, sqlDate);
                     add.setString(2, MemberCb.getSelectedItem().toString());
                     add.setInt(3,Integer.valueOf(AmountTb.getText()));
                     
                     int row = add.executeUpdate();
                     JOptionPane.showMessageDialog(this, "Payment Saved Successfully");
                     DisplayPayment();
                     
                     
                     int choice = JOptionPane.showConfirmDialog(this, 
                    "Do you want to generate a receipt?", 
                    "Receipt", 
                    JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                      String member = MemberCb.getSelectedItem().toString();
                      String amount = AmountTb.getText();
                       generateReceipt(member, sqlDate.toString(), amount);
                    }
                    Reset();
               }catch(Exception e){
                    JOptionPane.showMessageDialog(this, e);
                }
                }
        
    }//GEN-LAST:event_SavebtnMouseClicked

    private void ResetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetbtnActionPerformed
                Reset();
    }//GEN-LAST:event_ResetbtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           String phone = PhoneTb.getText().trim();
           if (phone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter Phone Number to Search");
    } else{
               try{
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb", "root", "");
                    String query = "SELECT f.PID, f.PPeriod, f.PMember, f.PAmount " +
                           "FROM FinanceTbl f " +
                           "JOIN MemberTbl m ON f.PMember = m.MName " +
                           "WHERE m.MPhone = ?";
            
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, phone);
            
                    ResultSet rs = pst.executeQuery();
                    DefaultTableModel model = (DefaultTableModel) PaymentTable.getModel();
            model.setRowCount(0); // clear existing rows
            
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("PID"),
                    rs.getDate("PPeriod"),
                    rs.getString("PMember"),
                    rs.getInt("PAmount")
                };
                model.addRow(row);
            }
            
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found for phone: " + phone);
            }    
               }catch (Exception e){
                   JOptionPane.showMessageDialog(this, e);
               }
           }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PhoneTb.setText("");   // clear phone number search box
         DisplayPayment(); 
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void Reset() {
    
      MonthTb.setDate(null);   // ✅ clears JCalendar
     AmountTb.setText("");
     MemberCb.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(Finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Finance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Finance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountTb;
    private javax.swing.JComboBox<String> MemberCb;
    private com.toedter.calendar.JDateChooser MonthTb;
    private javax.swing.JTable PaymentTable;
    private javax.swing.JTextField PhoneTb;
    private javax.swing.JButton Resetbtn;
    private javax.swing.JButton Savebtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
