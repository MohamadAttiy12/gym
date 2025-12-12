/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gymapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class Members extends javax.swing.JFrame {

    /**
     * Creates new form Members
     */
    public Members() {
        initComponents();
        DisplayMembers();
        GetCoach();
       
    }
    
     Connection con=null;
    PreparedStatement pst  =null;
    ResultSet rs = null, rs1=null;
    Statement st=null , st1=null;
    private void DisplayMembers()
    {
        try{
           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", "");
           st = con.createStatement();
           rs = st.executeQuery("select * from MemberTbl");
           MemberTable.setModel(DbUtils.resultSetToTableModel(rs));
             
        }catch (Exception e){
        
        }
    }
    
    private void GetCoach()
    {
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", "");
            st = con.createStatement();
            String Query = "Select * from CoachTbl";
            rs = st.executeQuery(Query);
            while(rs.next())
            {
                String CoachName = rs.getNString("CName");
                CoachCb.addItem(CoachName);
                
            }
        }catch (Exception e){
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MNameTb = new java.awt.TextField();
        PhoneTb = new java.awt.TextField();
        jLabel10 = new javax.swing.JLabel();
        AgeTb = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        AmountTb = new java.awt.TextField();
        CoachCb = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TimingCb = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        GenCb = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MemberTable = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1253, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Coaches");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Payments");
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

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\income.png")); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\gymicon.png")); // NOI18N

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
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Manage Members");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jLabel3)
                .addContainerGap(575, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Member Name");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 86, 98, -1));

        MNameTb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        MNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNameTbActionPerformed(evt);
            }
        });
        jPanel3.add(MNameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 105, 132, -1));

        PhoneTb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        PhoneTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTbActionPerformed(evt);
            }
        });
        jPanel3.add(PhoneTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 101, 116, 25));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Member List");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 273, 129, -1));

        AgeTb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        AgeTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeTbActionPerformed(evt);
            }
        });
        jPanel3.add(AgeTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 105, 90, -1));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Age");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 86, 36, -1));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Amount");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 157, -1, -1));

        AmountTb.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        AmountTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountTbActionPerformed(evt);
            }
        });
        jPanel3.add(AmountTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 175, 102, 29));

        CoachCb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        CoachCb.setForeground(new java.awt.Color(0, 102, 102));
        jPanel3.add(CoachCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 175, 99, 29));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Couch");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 157, 71, -1));

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Timing");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 157, 71, -1));

        TimingCb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TimingCb.setForeground(new java.awt.Color(0, 102, 102));
        TimingCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6AM-8AM", "8AM-10AM", "10AM-12AM", "4AM-6AM", "6AM-8AM", "8AM-10AM" }));
        jPanel3.add(TimingCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 175, 99, 29));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Gender");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 157, 71, -1));

        GenCb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        GenCb.setForeground(new java.awt.Color(0, 102, 102));
        GenCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel3.add(GenCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 175, 99, 29));

        AddBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(51, 153, 0));
        AddBtn.setText("Add");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        jPanel3.add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        EditBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(51, 204, 0));
        EditBtn.setText("Edit");
        EditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBtnMouseClicked(evt);
            }
        });
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        jPanel3.add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));

        DeleteBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(204, 0, 0));
        DeleteBtn.setText("Delete");
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });
        jPanel3.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, -1, -1));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Phone Number");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 82, 98, -1));

        MemberTable.setModel(new javax.swing.table.DefaultTableModel(
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
        MemberTable.setRowHeight(25);
        MemberTable.setShowGrid(true);
        MemberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MemberTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 760, 290));

        jLabel18.setIcon(new javax.swing.ImageIcon("D:\\Gym Project\\coach2.jpg")); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MNameTbActionPerformed

    private void PhoneTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTbActionPerformed

    private void AgeTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeTbActionPerformed

    private void AmountTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountTbActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new Coachs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new Finance().setVisible(true);
        this.dispose();         
    }//GEN-LAST:event_jLabel5MouseClicked

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditBtnActionPerformed
 int MNum = 0;
    private void CountMember()
    {
       try{
           st1 = con.createStatement();
           rs1 = st1.executeQuery("select MAX(MId) from MemberTbl");
           rs1.next();
           MNum = rs1.getInt(1)+1;
       }catch( Exception e) {
           
       }
    }
    
    
    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
       if(MNameTb.getText().isEmpty() || PhoneTb.getText().isEmpty() || AgeTb.getText().isEmpty() || AmountTb.getText().isEmpty() || GenCb.getSelectedIndex() == -1 || CoachCb.getSelectedIndex() == -1 || TimingCb.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }else{
            try{
                CountMember();
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", "");
                PreparedStatement Add;
                Add = con.prepareStatement("insert into MemberTbl values(?,?,?,?,?,?,?,?)");
                Add.setInt(1,MNum);
                Add.setString(2, MNameTb.getText());
                Add.setString(3, PhoneTb.getText());
                Add.setInt(4,Integer.valueOf(AgeTb.getText()));
                Add.setInt(5,Integer.valueOf(AmountTb.getText()));
                Add.setString(6,TimingCb.getSelectedItem().toString());
                Add.setString(7,CoachCb.getSelectedItem().toString());
                Add.setString(8,GenCb.getSelectedItem().toString());
                int row= Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Member Saved");
                con.close();
                DisplayMembers();
                
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_AddBtnMouseClicked
        int Key = 0;
    private void MemberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)MemberTable.getModel();
        int MyIndex = MemberTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        MNameTb.setText(model.getValueAt(MyIndex, 1).toString());
        PhoneTb.setText(model.getValueAt(MyIndex, 2).toString());
        AgeTb.setText(model.getValueAt(MyIndex, 3).toString());
        AmountTb.setText(model.getValueAt(MyIndex, 4).toString());
        TimingCb.setSelectedItem(model.getValueAt(MyIndex, 5).toString());
        CoachCb.setSelectedItem(model.getValueAt(MyIndex, 6).toString()); 
        GenCb.setSelectedItem(model.getValueAt(MyIndex, 7).toString());
    }//GEN-LAST:event_MemberTableMouseClicked

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        if(Key == 0)
        {
           JOptionPane.showMessageDialog(this, "select the Member to Delete");
        }else{
            try{
               con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", ""); 
               String Query = "Delete from MemberTbl where MId="+Key;
               Statement Del = con.createStatement();
               Del.executeUpdate(Query);
               JOptionPane.showMessageDialog(this, "Member Deleted");
               DisplayMembers();   
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked
       if(Key  == 0){
           JOptionPane.showMessageDialog(this,"Please Select the Member to Edit");
       }else{
           try{
              con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gymdb" ,"root", "");
               String Query = "Update MemberTbl set MName=?,MPhone=?,MAge=?,MAmount=?,MTiming=?,MCoach=?,MGen=? Where MId=?";
               PreparedStatement Add = con.prepareStatement(Query);
                Add.setInt(8,Key);
                Add.setString(1, MNameTb.getText());
                Add.setString(2, PhoneTb.getText());
                Add.setInt(3,Integer.valueOf(AgeTb.getText()));
                Add.setInt(4,Integer.valueOf(AmountTb.getText()));
                Add.setString(5,TimingCb.getSelectedItem().toString());
                Add.setString(6,CoachCb.getSelectedItem().toString());
                Add.setString(7,GenCb.getSelectedItem().toString());
                int row= Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Member Updated");
                con.close();
                DisplayMembers();
               
           }catch(Exception e){
               
           }
       }
    }//GEN-LAST:event_EditBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Members().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private java.awt.TextField AgeTb;
    private java.awt.TextField AmountTb;
    private javax.swing.JComboBox<String> CoachCb;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JComboBox<String> GenCb;
    private java.awt.TextField MNameTb;
    private javax.swing.JTable MemberTable;
    private java.awt.TextField PhoneTb;
    private javax.swing.JComboBox<String> TimingCb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
