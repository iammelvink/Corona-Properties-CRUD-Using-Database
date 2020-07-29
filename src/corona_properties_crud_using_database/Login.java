/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona_properties_crud_using_database;

import static java.awt.EventQueue.invokeLater;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.isWhitespace;
import static java.lang.String.valueOf;
import static java.lang.System.exit;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static java.util.regex.Pattern.matches;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

public class Login extends javax.swing.JFrame {
    public Menu Menu;
    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    public Login() {
        initComponents();
        DoConnect();
    }

    public void DoConnect() {
        try {
            String host = "jdbc:mysql://localhost:3306/corona_properties";
            String uName = "root";
            String uPass = "";
            con = getConnection(host, uName, uPass);

            String SQL = "SELECT * FROM Admin where username =? and password = ?";
            stm = con.prepareStatement(SQL);

            stm.setString(1, txtUsername.getText());
            stm.setString(2, txtPassword.getText());
        } catch (SQLException e) {
            showMessageDialog(null, "\n" + "Could not connect to database");
            exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_Register = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Customer_96px.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 80));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Help_24px.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 80));

        kGradientPanel1.setkEndColor(new java.awt.Color(63, 81, 181));
        kGradientPanel1.setkStartColor(new java.awt.Color(144, 202, 249));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Admin Login");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(0, 31, 63));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setkEndColor(new java.awt.Color(144, 202, 249));
        kGradientPanel2.setkStartColor(new java.awt.Color(88, 119, 202));

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(88, 119, 202));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtUsername.setBackground(new java.awt.Color(240, 240, 240));
        txtUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(0, 31, 63)));
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(240, 240, 240));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(0, 31, 63)));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel8.setText("Password:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel9.setText("Username:");

        lbl_Register.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_Register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_24px.png"))); // NOI18N
        lbl_Register.setText("Forgot password?");
        lbl_Register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_RegisterMousePressed(evt);
            }
        });

        lblUser.setForeground(java.awt.Color.red);

        lblPass.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(kGradientPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap(77, Short.MAX_VALUE)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(kGradientPanel2Layout.createSequentialGroup().addComponent(lbl_Register)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLogin))
                                .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addGap(95, 95, 95)));
        kGradientPanel2Layout.setVerticalGroup(kGradientPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel2Layout.createSequentialGroup().addContainerGap().addGroup(kGradientPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel9)
                        .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLogin).addComponent(lbl_Register))
                        .addGap(25, 25, 25)));

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 200));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(kGradientPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(210, 210, 210).addComponent(jLabel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(30, 30, 30).addComponent(jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)));
        kGradientPanel1Layout
                .setVerticalGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(80, 80, 80)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        setSize(new java.awt.Dimension(667, 395));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed
        try {
            String sql = "select * from admin where username = '" + txtUsername.getText() + "' and password = '"
                    + valueOf(txtPassword.getPassword()) + "'";
            rs = stm.executeQuery(sql);

            String pass = valueOf(txtPassword.getPassword());
            String bString = valueOf(valPassword(pass));

            String user = txtUsername.getText();

            if (!"false".equals(bString) && (isWord(user))) {
                if (rs.next()) {
                    Menu = new Menu();
                    Menu.setVisible(true);
                    this.dispose();
                } else {
                    showMessageDialog(null, "Incorrect username / password");
                }
            } else {
                // Set labels if there are any errors
                if ("false".equals(bString)) {
                    lblPass.setText("*No space. Include Number, uppercase, and lowercase");
                } else {
                    lblPass.setText(null);
                }
                if (!isWord(user)) {
                    lblUser.setText("*Should not include numbers or special characters");
                } else {
                    lblUser.setText(null);
                }
            }
        } catch (SQLException e) {

        }
    }// GEN-LAST:event_btnLoginActionPerformed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
        int p = showConfirmDialog(null, "Do you really want to Close?", "EXIT", YES_NO_OPTION);
        if (p == 0) {
            exit(0);
        }
    }// GEN-LAST:event_jLabel5MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }// GEN-LAST:event_jLabel10MousePressed

    private void lbl_RegisterMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lbl_RegisterMousePressed
        // TODO add your handling code here:
        new Register().setVisible(true);
        this.dispose();
    }// GEN-LAST:event_lbl_RegisterMousePressed

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtUsernameKeyReleased
        try {
            String user = txtUsername.getText();

            if (isWord(user)) {
                lblUser.setText(null);
            } else {
                // Set labels if there are any errors

                if (!isWord(user)) {
                    lblUser.setText("*Should not include numbers or special characters");
                }
            }
        } catch (Exception e) {

        }
    }// GEN-LAST:event_txtUsernameKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtPasswordKeyReleased

    }// GEN-LAST:event_txtPasswordKeyReleased

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == VK_ENTER) {
            try {
                String sql = "select * from admin where username = '" + txtUsername.getText() + "' and password = '"
                        + valueOf(txtPassword.getPassword()) + "'";
                rs = stm.executeQuery(sql);

                String pass = valueOf(txtPassword.getPassword());
                String bString = valueOf(valPassword(pass));

                String user = txtUsername.getText();

                if (!"false".equals(bString) && (isWord(user))) {
                    if (rs.next()) {
                        Menu = new Menu();
                        Menu.setVisible(true);
                        this.dispose();
                    } else {
                        showMessageDialog(null, "Incorrect username / password");
                    }
                } else {
                    // Set labels if there are any errors
                    if ("false".equals(bString)) {
                        lblPass.setText("*No space. Include Number, uppercase, and lowercase");
                    } else {
                        lblPass.setText(null);
                    }
                    if (!isWord(user)) {
                        lblUser.setText("*Should not include numbers or special characters");
                    } else {
                        lblUser.setText(null);
                    }
                }
            } catch (SQLException e) {

            }
        }
    }// GEN-LAST:event_txtPasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            getLogger(Login.class.getName()).log(SEVERE, null, ex);
        }
        // </editor-fold>

        // </editor-fold>

        /* Create and display the form */
        invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    public static boolean isWord(String username) {
        return matches("[a-zA-Z]+", username);
    }

    public static boolean valPassword(String password) {
        if (password.length() > 7) {
            return checkPass(password);
        } else {

            return false;
        }
    }

    public static boolean checkPass(String password) {
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (isDigit(c)) {
                hasNum = true;
            } else if (isUpperCase(c)) {
                hasCap = true;
            } else if (isLowerCase(c)) {
                hasLow = true;
            }
            for (char currentChar : password.toCharArray()) {
                if (isWhitespace(currentChar)) {
                    return true;
                }
            }
            if (hasNum && hasCap && hasLow) {
                return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lbl_Register;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
