/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolmanagementsystem;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Name
 */
public class Student extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    public Student() {
        initComponents();
        Connect();
        Class_Load();
        Section_Load();
        Student_Load();
        setIconImage();
        setTitle("Student page");
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

    }

    int id;
    String uname;
    String usertype;

    public Student(int id, String username, String utype) {
        initComponents();
        Connect();
        Class_Load();
        Section_Load();
        Student_Load();
        setIconImage();
        setTitle("Student page");
        this.uname = username;
        jLabel20.setText(uname);

        this.usertype = utype;
        jLabel21.setText(utype);

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

        this.id = id;

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

    public void Student_Load() {
        int c;
        try {
            pst = con.prepareStatement("select * from student");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            d = (DefaultTableModel) rSTableMetro1.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("studentid"));
                    v2.add(rs.getString("studentname"));
                    v2.add(rs.getString("parentname"));
                    v2.add(rs.getString("dateofbirth"));
                    v2.add(rs.getString("gender"));
                    v2.add(rs.getString("studentmobileno"));
                    v2.add(rs.getString("studentaddress"));
                    v2.add(rs.getString("studentclass"));
                    v2.add(rs.getString("studentsection"));
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
        txtstudentname = new javax.swing.JTextField();
        txtparentname = new javax.swing.JTextField();
        txtdateofbirth = new com.toedter.calendar.JDateChooser();
        txtgender = new javax.swing.JComboBox<>();
        txtmobile = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtclass = new javax.swing.JComboBox<>();
        txtsection = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        savebutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Details:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 295, -1));

        txtstudentname.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel2.add(txtstudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 85, 225, 32));

        txtparentname.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel2.add(txtparentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 158, 225, 32));

        txtdateofbirth.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel2.add(txtdateofbirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 225, 225, 32));

        txtgender.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel2.add(txtgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 298, 225, 32));

        txtmobile.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtmobile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 371, 225, 32));

        txtaddress.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel2.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 444, 223, 32));

        txtclass.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtclass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        txtclass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 517, 225, 32));

        txtsection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        txtsection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtsection, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 596, 225, 32));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 415, 295, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 56, 225, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Parent Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 129, 225, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date Of Birth");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 196, 225, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gender");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 269, 225, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mobile No");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 342, 295, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Class");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 488, 295, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Section");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 567, 225, -1));

        savebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        savebutton.setText("SAVE");
        savebutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(savebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 655, 95, -1));

        editbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editbutton.setText("EDIT");
        editbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 655, 92, -1));

        deletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletebutton.setText("DELETE");
        deletebutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 699, 95, -1));

        clearbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearbutton.setText("CLEAR");
        clearbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(clearbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 699, 92, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/student.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Parent", "Mobile", "DOB", "Gender", "Address", "Class", "Section"
            }
        ));
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(51, 153, 255));
        rSTableMetro1.setFuenteFilas(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        rSTableMetro1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                rSTableMetro1AncestorRemoved(evt);
            }
        });
        rSTableMetro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(rSTableMetro1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 77, 745, 189));

        jLabel10.setText("Developed by:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 709, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Naveenkumar J");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 709, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("USER NAME:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 6, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("USER TYPE:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 29, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("USER NAME");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 6, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("USER TYPE");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 29, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 6, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("LOGOUT");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(994, 8, -1, 25));

        jMenu1.setText("Main Menu");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String sname = txtstudentname.getText();
            String parentname = txtparentname.getText();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(txtdateofbirth.getDate());
            String gender = txtgender.getSelectedItem().toString();
            String studentmobileno = txtmobile.getText();
            String studnetaddress = txtaddress.getText();
            String studentclass = txtclass.getSelectedItem().toString();
            String studentsection = txtsection.getSelectedItem().toString();

            pst = con.prepareStatement("insert into student(studentname,parentname,dateofbirth,gender,studentmobileno,studentaddress,studentclass,studentsection)values(?,?,?,?,?,?,?,?)");
            pst.setString(1, sname);
            pst.setString(2, parentname);
            pst.setString(3, date);
            pst.setString(4, gender);
            pst.setString(5, studentmobileno);
            pst.setString(6, studnetaddress);
            pst.setString(7, studentclass);
            pst.setString(8, studentsection);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student details added successfully...");
            Student_Load();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_savebuttonActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            d = (DefaultTableModel) rSTableMetro1.getModel();
            int selectIndex = rSTableMetro1.getSelectedRow();

            String id = d.getValueAt(selectIndex, 0).toString();

            String sname = txtstudentname.getText();
            String parentname = txtparentname.getText();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(txtdateofbirth.getDate());
            String gender = txtgender.getSelectedItem().toString();
            String studentmobileno = txtmobile.getText();
            String studnetaddress = txtaddress.getText();
            String studentclass = txtclass.getSelectedItem().toString();
            String studentsection = txtsection.getSelectedItem().toString();

            pst = con.prepareStatement("update student set studentname=?,parentname=?,dateofbirth=?,gender=?,studentmobileno=?,studentaddress=?,studentclass=?,studentsection=? where studentid=?");

            pst.setString(1, sname);
            pst.setString(2, parentname);
            pst.setString(3, date);
            pst.setString(4, gender);
            pst.setString(5, studentmobileno);
            pst.setString(6, studnetaddress);
            pst.setString(7, studentclass);
            pst.setString(8, studentsection);
            pst.setString(9, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student details edited successfully...");
            savebutton.setEnabled(true);

            txtstudentname.setText("");
            txtparentname.setText("");
            txtdateofbirth.setDate(null);
            txtgender.setSelectedIndex(0);
            txtmobile.setText("");
            txtaddress.setText("");
            txtsection.setSelectedIndex(0);
            txtclass.setSelectedIndex(0);

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editbuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            d = (DefaultTableModel) rSTableMetro1.getModel();
            int selectIndex = rSTableMetro1.getSelectedRow();

            String id = d.getValueAt(selectIndex, 0).toString();

            pst = con.prepareStatement("delete from student where studentid=?");
            pst.setString(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "student details deleted successfully...");
            savebutton.setEnabled(true);

            txtstudentname.setText("");
            txtparentname.setText("");
            txtdateofbirth.setDate(null);
            txtgender.setSelectedIndex(0);
            txtmobile.setText("");
            txtaddress.setText("");
            txtsection.setSelectedIndex(0);
            txtclass.setSelectedIndex(0);

            Student_Load();
            savebutton.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_deletebuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        // TODO add your handling code here:
        txtstudentname.setText("");
        txtparentname.setText("");
        txtdateofbirth.setDate(null);
        txtgender.setSelectedIndex(0);
        txtmobile.setText("");
        txtaddress.setText("");
        txtsection.setSelectedIndex(0);
        txtclass.setSelectedIndex(0);

        Student_Load();
        savebutton.setEnabled(true);

    }//GEN-LAST:event_clearbuttonActionPerformed

    private void rSTableMetro1AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_rSTableMetro1AncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_rSTableMetro1AncestorRemoved

    private void rSTableMetro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro1MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            d = (DefaultTableModel) rSTableMetro1.getModel();
            int selectIndex = rSTableMetro1.getSelectedRow();

            String id = d.getValueAt(selectIndex, 0).toString();
            txtstudentname.setText(d.getValueAt(selectIndex, 1).toString());
            txtparentname.setText(d.getValueAt(selectIndex, 2).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) d.getValueAt(selectIndex, 3));
            txtdateofbirth.setDate(date);
            txtgender.setSelectedItem(d.getValueAt(selectIndex, 4).toString());
            txtmobile.setText(d.getValueAt(selectIndex, 5).toString());
            txtaddress.setText(d.getValueAt(selectIndex, 6).toString());
            txtclass.setSelectedItem(d.getValueAt(selectIndex, 7).toString());
            txtsection.setSelectedItem(d.getValueAt(selectIndex, 8).toString());
            savebutton.setEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rSTableMetro1MouseClicked

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

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1ActionPerformed

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
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
    private rojerusan.RSTableMetro rSTableMetro1;
    private javax.swing.JButton savebutton;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JComboBox<String> txtclass;
    private com.toedter.calendar.JDateChooser txtdateofbirth;
    private javax.swing.JComboBox<String> txtgender;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtparentname;
    private javax.swing.JComboBox<String> txtsection;
    private javax.swing.JTextField txtstudentname;
    // End of variables declaration//GEN-END:variables
}
