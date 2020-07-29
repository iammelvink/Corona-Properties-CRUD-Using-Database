/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona_properties_crud_using_database;

import static java.awt.EventQueue.invokeLater;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.CONCUR_UPDATABLE;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author MightyBeatz
 */
public class Tenant extends javax.swing.JFrame {
    Connection con;
    Statement stm;
    ResultSet rs;
    int curRow = 0;

    public Tenant() {
        initComponents();
        DoConnect();
    }

    public void DoConnect() {
        try {
            String host = "jdbc:mysql://localhost:3306/corona_properties";
            String uName = "root";
            String uPass = "";
            con = getConnection(host, uName, uPass);

            stm = con.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM Tenant";
            rs = stm.executeQuery(SQL);
        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage() + "\n" + "Could not connect to database");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        btnTenants = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnMaintenance = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnHouse = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btnArrears = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtHouse1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtHouse = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtDateAdm = new com.toedter.calendar.JDateChooser();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 31, 63));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Under Authority", 1, 36)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("CP System");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Menu_96px_2.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 80));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Help_24px.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Multiplication_24px_2.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Minus_24px.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        btnLogout.setBackground(java.awt.Color.lightGray);
        btnLogout.setText("Logout");
        btnLogout.setToolTipText("");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 80, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 80));

        kGradientPanel1.setkEndColor(new java.awt.Color(63, 81, 181));
        kGradientPanel1.setkStartColor(new java.awt.Color(144, 202, 249));

        jPanel1.setBackground(new java.awt.Color(0, 31, 63));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel4.setkEndColor(new java.awt.Color(144, 202, 249));
        kGradientPanel4.setkStartColor(new java.awt.Color(88, 119, 202));

        btnTenants.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTenants.setForeground(new java.awt.Color(88, 119, 202));
        btnTenants.setText("Tenant registration");
        btnTenants.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTenants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenantsActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHome.setForeground(new java.awt.Color(88, 119, 202));
        btnHome.setText("Home");
        btnHome.setAlignmentX(5.0F);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnMaintenance.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMaintenance.setForeground(new java.awt.Color(88, 119, 202));
        btnMaintenance.setText("Maintenance");
        btnMaintenance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaintenanceActionPerformed(evt);
            }
        });

        btnPayment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPayment.setForeground(new java.awt.Color(88, 119, 202));
        btnPayment.setText("Rent payment ");
        btnPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        btnHouse.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHouse.setForeground(new java.awt.Color(88, 119, 202));
        btnHouse.setText("House records");
        btnHouse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHouseActionPerformed(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Home_24px_1.png"))); // NOI18N

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        btnArrears.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnArrears.setForeground(new java.awt.Color(88, 119, 202));
        btnArrears.setText("Rent arrears");
        btnArrears.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnArrears.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrearsActionPerformed(evt);
            }
        });

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        txtHouse1.setBackground(new java.awt.Color(88, 119, 202));
        txtHouse1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_24px.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(kGradientPanel4Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel4Layout.createSequentialGroup().addContainerGap().addGroup(kGradientPanel4Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel4Layout.createSequentialGroup().addGroup(kGradientPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel4Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel25).addComponent(jLabel27))
                                .addComponent(jLabel28).addComponent(jLabel29).addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel4Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnMaintenance, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPayment, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnTenants, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHouse, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(kGradientPanel4Layout.createSequentialGroup().addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnArrears, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(kGradientPanel4Layout.createSequentialGroup().addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHouse1)))));
        kGradientPanel4Layout.setVerticalGroup(kGradientPanel4Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel4Layout.createSequentialGroup().addGap(17, 17, 17)
                        .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHouse1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(kGradientPanel4Layout.createSequentialGroup().addGroup(kGradientPanel4Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(kGradientPanel4Layout.createSequentialGroup()
                                                .addGroup(kGradientPanel4Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(kGradientPanel4Layout.createSequentialGroup()
                                                                .addGroup(kGradientPanel4Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnHome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel25))
                                                                .addGap(18, 18, 18).addComponent(btnHouse,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel27))
                                                .addGap(18, 18, 18).addComponent(btnTenants,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel28)).addGap(18, 18, 18).addComponent(btnPayment,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel31).addComponent(btnArrears, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30))
                        .addGap(23, 23, 23)));

        jPanel1.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 370));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Tenant registration");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(0, 31, 63));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("All rights reserved: ©Corona Properties");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(119, 166, 228));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("First Name:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Last Name:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("ID Num:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Phone Num:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("House number:");

        txtID.setBackground(new java.awt.Color(119, 166, 228));
        txtID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(0, 0, 0)));

        txtFirstname.setBackground(new java.awt.Color(119, 166, 228));
        txtFirstname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(0, 0, 0)));

        txtPhone.setBackground(new java.awt.Color(119, 166, 228));
        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(0, 0, 0)));

        txtLastname.setBackground(new java.awt.Color(119, 166, 228));
        txtLastname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(0, 0, 0)));

        txtHouse.setBackground(new java.awt.Color(119, 166, 228));
        txtHouse.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Date admitted:");

        txtDateAdm.setDateFormatString("yyyy-MM-dd");

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNext.setForeground(new java.awt.Color(88, 119, 202));
        btnNext.setText("Next");
        btnNext.setAlignmentX(5.0F);
        btnNext.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(88, 119, 202));
        btnPrevious.setText("Previous");
        btnPrevious.setAlignmentX(5.0F);
        btnPrevious.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(88, 119, 202));
        btnDelete.setText("Delete");
        btnDelete.setAlignmentX(5.0F);
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(88, 119, 202));
        btnUpdate.setText("Update");
        btnUpdate.setAlignmentX(5.0F);
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNew.setForeground(new java.awt.Color(88, 119, 202));
        btnNew.setText("Clear");
        btnNew.setAlignmentX(5.0F);
        btnNew.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setForeground(new java.awt.Color(88, 119, 202));
        btnSave.setText("Save");
        btnSave.setAlignmentX(5.0F);
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14).addComponent(jLabel20).addComponent(jLabel22)
                                        .addComponent(jLabel23).addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtHouse, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLastname, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFirstname, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel26).addGap(18, 18, 18)
                                .addComponent(txtDateAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnNext)
                        .addGap(0, 0, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel20)
                                        .addGap(18, 18, 18).addComponent(jLabel22))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18).addComponent(txtPhone,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23).addComponent(txtHouse, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel26).addComponent(txtDateAdm, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSave).addComponent(btnNew).addComponent(btnUpdate)
                                .addComponent(btnDelete).addComponent(btnPrevious).addComponent(btnNext))
                        .addContainerGap()));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(kGradientPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGroup(kGradientPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 659,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap()));
        kGradientPanel1Layout.setVerticalGroup(kGradientPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(80, 80, 80)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(61, 61, 61).addComponent(
                                        jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel4,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 520));

        setSize(new java.awt.Dimension(665, 518));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MousePressed
        int p = showConfirmDialog(null, "Do you really want to Close?", "EXIT", YES_NO_OPTION);
        if (p == 0) {
            exit(0);
        }
    }// GEN-LAST:event_jLabel5MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }// GEN-LAST:event_jLabel10MousePressed

    private void btnTenantsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTenantsActionPerformed
        // TODO add your handling code here:
        new Tenant().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnTenantsActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHomeActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnHomeActionPerformed

    private void btnMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMaintenanceActionPerformed
        new Maintenance().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnMaintenanceActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPaymentActionPerformed
        new Rent().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnPaymentActionPerformed

    private void btnHouseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHouseActionPerformed
        // TODO add your handling code here:
        new House().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnHouseActionPerformed

    private void btnArrearsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnArrearsActionPerformed
        new Rent_arrears().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_btnArrearsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogoutActionPerformed
        int p = showConfirmDialog(null, "Do you really want to logout?", "Logout", YES_NO_OPTION);
        if (p == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }// GEN-LAST:event_btnLogoutActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
        try {
            if (rs.next()) {

                int newId = rs.getInt("Id_no");
                String id = Integer.toString(newId);
                String name = rs.getString("Firstname");
                String lName = rs.getString("lastname");
                String phone = rs.getString("phone_no");
                String house = rs.getString("House_no");
                Date dAdm = rs.getDate("date_admitted");

                txtID.setText(id);
                txtFirstname.setText(name);
                txtLastname.setText(lName);
                txtPhone.setText(phone);
                txtHouse.setText(house);
                txtDateAdm.setDate(dAdm);

            } else {
                rs.previous();
                showMessageDialog(this, "End of File");
            }
        } catch (SQLException err) {
            showMessageDialog(this, err.getMessage());

        }
    }// GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPreviousActionPerformed
        try {
            if (rs.previous()) {
                int newId = rs.getInt("Id_no");
                String id = Integer.toString(newId);
                String name = rs.getString("Firstname");
                String lName = rs.getString("lastname");
                String phone = rs.getString("phone_no");
                String house = rs.getString("House_no");
                Date dAdm = rs.getDate("date_admitted");

                txtID.setText(id);
                txtFirstname.setText(name);
                txtLastname.setText(lName);
                txtPhone.setText(phone);
                txtHouse.setText(house);
                txtDateAdm.setDate(dAdm);

            } else {
                rs.next();
                showMessageDialog(this, "Start of File");
            }
        } catch (SQLException err) {
            showMessageDialog(this, err.getMessage());

        }
    }// GEN-LAST:event_btnPreviousActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        int p = showConfirmDialog(null, "Do you really want to Delete?", "Delete", YES_NO_OPTION);
        if (p == 0) {
            try {
                rs.deleteRow();

                stm = con.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE);
                String SQL = "SELECT * FROM Tenant";
                rs = stm.executeQuery(SQL);

                rs.next();
                String id = txtID.getText();
                int newId = parseInt(id);
                String name = txtFirstname.getText();
                String lName = txtLastname.getText();
                String phone = txtPhone.getText();
                String house = txtHouse.getText();
                String dAdm = ((JTextComponent) txtDateAdm.getDateEditor().getUiComponent()).getText();

                txtID.setText(id);
                txtFirstname.setText(name);
                txtLastname.setText(lName);
                txtPhone.setText(phone);
                txtHouse.setText(house);
                txtDateAdm.setDateFormatString(dAdm);

                showMessageDialog(this, "Record Deleted");
            } catch (SQLException err) {
                showMessageDialog(this, err.getMessage());

            }
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        String id = txtID.getText();
        int newId = parseInt(id);
        String name = txtFirstname.getText();
        String lName = txtLastname.getText();
        String phone = txtPhone.getText();
        String house = txtHouse.getText();
        String dAdm = ((JTextComponent) txtDateAdm.getDateEditor().getUiComponent()).getText();

        try {
            rs.updateInt("Id_no", newId);
            rs.updateString("Firstname", name);
            rs.updateString("Lastname", lName);
            rs.updateString("Phone_no", phone);
            rs.updateString("House_no", house);
            rs.updateString("date_admitted", dAdm);
            rs.updateRow();

            showMessageDialog(this, "Updated");
        } catch (SQLException err) {
            showMessageDialog(this, err.getMessage());
        }
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNewActionPerformed
        try {
            curRow = rs.getRow();

            txtID.setText("");
            txtFirstname.setText("");
            txtLastname.setText("");
            txtPhone.setText("");
            txtHouse.setText("");
            txtDateAdm.setDate(null);

        } catch (SQLException err) {
            showMessageDialog(this, err.getMessage());
        }
    }// GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed

        try {
            String id = txtID.getText();
            int newId = parseInt(id);
            String name = txtFirstname.getText();
            String lName = txtLastname.getText();
            String phone = txtPhone.getText();
            String house = txtHouse.getText();
            String date = ((JTextComponent) txtDateAdm.getDateEditor().getUiComponent()).getText();

            rs.moveToInsertRow();
            rs.updateInt("Id_no", newId);
            rs.updateString("Firstname", name);
            rs.updateString("Lastname", lName);
            rs.updateString("Phone_no", phone);
            rs.updateString("House_no", house);
            rs.updateString("date_admitted", date);
            rs.insertRow();

            stm.close();
            rs.close();

            stm = con.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM Tenant";
            rs = stm.executeQuery(SQL);

            rs.next();
            int newId1 = rs.getInt("Id_no");
            String id1 = Integer.toString(newId1);
            String name1 = rs.getString("Firstname");
            String lName1 = rs.getString("lastname");
            String phone1 = rs.getString("phone_no");
            String house1 = rs.getString("House_no");
            Date dAdm1 = rs.getDate("date_admitted");

            txtID.setText(id1);
            txtFirstname.setText(name1);
            txtLastname.setText(lName1);
            txtPhone.setText(phone1);
            txtHouse.setText(house1);
            txtDateAdm.setDate(dAdm1);
            showMessageDialog(this, "Successfully Saved!!!");
        } catch (SQLException err) {
            showMessageDialog(this, err.getMessage());
        }
    }// GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(Tenant.class.getName()).log(SEVERE, null, ex);
        }
        // </editor-fold>

        // </editor-fold>
        /*
         * Create and display the form
         */
        invokeLater(() -> {
            new Tenant().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArrears;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHouse;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMaintenance;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTenants;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel4;
    private com.toedter.calendar.JDateChooser txtDateAdm;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtHouse;
    private javax.swing.JTextField txtHouse1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
