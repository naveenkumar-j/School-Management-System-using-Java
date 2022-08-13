/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolmanagementsystem;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Name
 */
public class Exam extends javax.swing.JFrame {

    /**
     * Creates new form Exam
     */
    public Exam() {
        initComponents();
        Connect();
        Class_Load();
        Section_Load();
        Subject_Load();
        Exam_Load();
        setIconImage();
        setTitle("Exam details");
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

    }

    int id;
    String uname;
    String usertype;

    public Exam(int id, String username, String utype) {
        setIconImage();
        setTitle("Exam details");
        initComponents();
        Connect();
        Class_Load();
        Section_Load();
        Subject_Load();
        this.uname = username;
        jLabel20.setText(uname);
        this.usertype = utype;
        jLabel30.setText(usertype);
        this.id = id;

        if (utype.equals("Student")) {
            savebutton.setEnabled(false);
            editbutton.setEnabled(false);
            deletebutton.setEnabled(false);
            clearbutton.setEnabled(false);
        }

        if (utype.equals("Guest")) {
            savebutton.setEnabled(false);
            editbutton.setEnabled(false);
            deletebutton.setEnabled(false);
            clearbutton.setEnabled(false);

        } else {
            savebutton.setEnabled(true);
            editbutton.setEnabled(true);
            deletebutton.setEnabled(true);
            clearbutton.setEnabled(true);
        }

    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/school_management_system", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Class_Load() {

        try {
            pst = con.prepareStatement("select Distinct classname from class");
            rs = pst.executeQuery();

            //txtclass.removeAllItems();
            while (rs.next()) {
                txtclass.addItem(rs.getString("classname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Section_Load() {

        try {
            pst = con.prepareStatement("select Distinct section from class");
            rs = pst.executeQuery();

            //txtclass.removeAllItems();
            while (rs.next()) {
                txtsection.addItem(rs.getString("section"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Subject_Load() {

        try {
            pst = con.prepareStatement("select Distinct subjectname from subject");
            rs = pst.executeQuery();

            //txtclass.removeAllItems();
            while (rs.next()) {
                txtsubject.addItem(rs.getString("subjectname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Exam_Load() {
        int c;
        try {
            pst = con.prepareStatement("select * from exam");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("examid"));
                    v2.add(rs.getString("examname"));
                    v2.add(rs.getString("examterm"));
                    v2.add(rs.getString("examdate"));
                    v2.add(rs.getString("examclass"));
                    v2.add(rs.getString("examsection"));
                    v2.add(rs.getString("examsubject"));

                }
                d.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        txtename = new javax.swing.JTextField();
        txtterm = new javax.swing.JComboBox<>();
        txtdate = new com.toedter.calendar.JDateChooser();
        txtclass = new javax.swing.JComboBox<>();
        txtsection = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtsubject = new javax.swing.JComboBox<>();
        savebutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Exam Details:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 233, 47));

        txtename.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtename.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtenameActionPerformed(evt);
            }
        });
        jPanel2.add(txtename, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 111, 235, 23));

        txtterm.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtterm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "First Term", "Second Term", "Third Term", "Fourth Term", "Fifth Term" }));
        txtterm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtterm, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 172, 235, 27));
        jPanel2.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 249, 235, 25));

        txtclass.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtclass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        txtclass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclassActionPerformed(evt);
            }
        });
        jPanel2.add(txtclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 318, 235, 27));

        txtsection.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtsection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        txtsection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtsection, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 383, 235, 27));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 217, 235, 26));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Exam Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 79, 235, 26));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Term");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 140, 235, 26));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Section");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 351, 235, 26));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Class");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 286, 235, 26));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Subject");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 422, 235, 26));

        txtsubject.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtsubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        txtsubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtsubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 454, 235, 27));

        savebutton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        savebutton.setText("SAVE");
        savebutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(savebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 499, -1, 42));

        editbutton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        editbutton.setText("EDIT");
        editbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 499, -1, 42));

        deletebutton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        deletebutton.setText("DELETE");
        deletebutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 499, -1, 42));

        clearbutton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        clearbutton.setText("CLEAR");
        clearbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(clearbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 499, -1, 42));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exam.png"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 557));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Term", "Date", "Class", "Section", "Subject"
            }
        ));
        jTable1.setColorBackgoundHead(new java.awt.Color(51, 153, 255));
        jTable1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 96, 595, 154));

        jLabel8.setText("Developed by:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 530, 88, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Naveenkumar J");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 97, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 6, -1, 36));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("LOGOUT");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 16, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("USER TYPE:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 50, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("USERNAME");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 25, 81, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("USERNAME:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 25, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("USER TYPE");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 50, 81, -1));

        jMenu1.setText("Main Menu");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("About Project");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclassActionPerformed

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String examname = txtename.getText();
            String term = txtterm.getSelectedItem().toString();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(txtdate.getDate());
            String classname = txtclass.getSelectedItem().toString();
            String section = txtsection.getSelectedItem().toString();
            String subject = txtsubject.getSelectedItem().toString();

            pst = con.prepareStatement("insert into exam(examname,examterm,examdate,examclass,examsection,examsubject)values(?,?,?,?,?,?)");
            pst.setString(1, examname);
            pst.setString(2, term);
            pst.setString(3, date);
            pst.setString(4, classname);
            pst.setString(5, section);
            pst.setString(6, subject);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Exam details added successfully...");
            Exam_Load();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_savebuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            d = (DefaultTableModel) jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();

            String id = d.getValueAt(selectIndex, 0).toString();

            pst = con.prepareStatement("delete from exam where examid=?");
            pst.setString(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Exam details deleted successfully...");
            savebutton.setEnabled(true);

            txtename.setText("");
            txtdate.setDate(null);
            txtclass.setSelectedIndex(0);
            txtsection.setSelectedIndex(0);
            txtsubject.setSelectedIndex(0);
            txtterm.setSelectedIndex(0);

            Exam_Load();
            savebutton.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            d = (DefaultTableModel) jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();

            String id = d.getValueAt(selectIndex, 0).toString();

            String examname = txtename.getText();
            String term = txtterm.getSelectedItem().toString();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(txtdate.getDate());
            String classname = txtclass.getSelectedItem().toString();
            String section = txtsection.getSelectedItem().toString();
            String subjectname = txtsubject.getSelectedItem().toString();

            pst = con.prepareStatement("update exam set examname=?,examterm=?,examdate=?,examclass=?,examsection=?,examsubject=? where examid=?");

            pst.setString(1, examname);
            pst.setString(2, term);
            pst.setString(3, date);
            pst.setString(4, classname);
            pst.setString(5, section);
            pst.setString(6, subjectname);
            pst.setString(7, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Exam details edited successfully...");
            savebutton.setEnabled(true);

            txtename.setText("");
            txtdate.setDate(null);
            txtclass.setSelectedIndex(0);
            txtsection.setSelectedIndex(0);
            txtsubject.setSelectedIndex(0);
            txtterm.setSelectedIndex(0);

            Exam_Load();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editbuttonActionPerformed

    private void txtenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtenameActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        // TODO add your handling code here:
        txtename.setText("");
        txtdate.setDate(null);
        txtclass.setSelectedIndex(0);
        txtsection.setSelectedIndex(0);
        txtsubject.setSelectedIndex(0);
        txtterm.setSelectedIndex(0);
        savebutton.setEnabled(true);
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        Main m = new Main(id, uname, usertype);
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        About a = new About();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            d = (DefaultTableModel) jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();

            String id = d.getValueAt(selectIndex, 0).toString();
            txtename.setText(d.getValueAt(selectIndex, 1).toString());
            txtterm.setSelectedItem(d.getValueAt(selectIndex, 2).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) d.getValueAt(selectIndex, 3));
            txtdate.setDate(date);
            txtclass.setSelectedItem(d.getValueAt(selectIndex, 4).toString());
            txtsection.setSelectedItem(d.getValueAt(selectIndex, 5).toString());
            txtsubject.setSelectedItem(d.getValueAt(selectIndex, 6).toString());

            savebutton.setEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().browse(new URI("https://github.com/naveenkumar-j"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton editbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro jTable1;
    private javax.swing.JButton savebutton;
    private javax.swing.JComboBox<String> txtclass;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtename;
    private javax.swing.JComboBox<String> txtsection;
    private javax.swing.JComboBox<String> txtsubject;
    private javax.swing.JComboBox<String> txtterm;
    // End of variables declaration//GEN-END:variables
}
