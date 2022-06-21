/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | lates
 * and open the template in the editor.
 */
package com.iammelvink.corona.properties.crud.using.database.coronaproperties;

import static com.iammelvink.corona.properties.crud.using.database.coronaproperties.Auth.user_name;
import static com.iammelvink.corona.properties.crud.using.database.coronaproperties.Auth.user_surname;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Melvin K
 */
public class MainMenu extends javax.swing.JFrame {
    private int xMouse;
    private int yMouse;
    /**
     * Creates new form Menu
     */
    public MainMenu() {
        initComponents();
        customStuff();
        showDate();
        showTime();
    }

    private void customStuff() {
        jLabel1.setText("Hello, " + user_name + " " + user_surname);
    }

    private void showDate() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        lblDate.setText(dateFormat.format(date));
    }

    private void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date date = new java.util.Date();
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
                lblTime.setText(timeFormat.format(date));
            }

        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        kGradientPanel5 = new keeptoo.KGradientPanel();
        Header2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnLogout2 = new javax.swing.JButton();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        btnHome2 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnComparativeViews = new javax.swing.JButton();
        btnComputation = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                formMouseReleased(evt);
            }
        });

        kGradientPanel5.setkEndColor(new java.awt.Color(63, 81, 181));
        kGradientPanel5.setkStartColor(new java.awt.Color(144, 202, 249));

        Header2.setBackground(new java.awt.Color(0, 31, 63));
        Header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Under Authority", 1, 36)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("Corona properties");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        Header2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Multiplication_24px_2.png"))); // NOI18N
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel28MousePressed(evt);
            }
        });
        Header2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Minus_24px.png"))); // NOI18N
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel29MousePressed(evt);
            }
        });
        Header2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Menu_96px_2.png"))); // NOI18N
        Header2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 80));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Help_24px.png"))); // NOI18N
        Header2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        lblTime.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        Header2.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        lblDate.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        Header2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        btnLogout2.setBackground(java.awt.Color.lightGray);
        btnLogout2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogout2.setText("Logout");
        btnLogout2.setToolTipText("");
        btnLogout2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLogout2ActionPerformed(evt);
            }
        });
        Header2.add(btnLogout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 80, -1));

        kGradientPanel6.setkEndColor(new java.awt.Color(144, 202, 249));
        kGradientPanel6.setkStartColor(new java.awt.Color(88, 119, 202));

        btnHome2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHome2.setForeground(new java.awt.Color(88, 119, 202));
        btnHome2.setText("Home");
        btnHome2.setAlignmentX(5.0F);
        btnHome2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHome2ActionPerformed(evt);
            }
        });

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Home_24px_1.png"))); // NOI18N

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        btnAdd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(88, 119, 202));
        btnAdd.setText("Add Property");
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        btnDisplay.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnDisplay.setForeground(new java.awt.Color(88, 119, 202));
        btnDisplay.setText("View Property");
        btnDisplay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDisplay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDisplayActionPerformed(evt);
            }
        });

        btnComparativeViews.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnComparativeViews.setForeground(new java.awt.Color(88, 119, 202));
        btnComparativeViews.setText("Comparative Views");
        btnComparativeViews.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnComparativeViews.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnComparativeViewsActionPerformed(evt);
            }
        });

        btnComputation.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnComputation.setForeground(new java.awt.Color(88, 119, 202));
        btnComputation.setText("Computations");
        btnComputation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnComputation.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnComputationActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(88, 119, 202));
        btnUpdate.setText("Update Property");
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(88, 119, 202));
        btnDelete.setText("Delete Property");
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel35)
                            .addComponent(jLabel33))
                        .addComponent(jLabel34)
                        .addComponent(jLabel37)
                        .addComponent(jLabel36))
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnComparativeViews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnComputation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDisplay)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComparativeViews)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComputation)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(jLabel36))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Menu");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(0, 0, 0)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/house_PNG63.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addComponent(Header2, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                .addComponent(Header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(86, 86, 86))
        );

        Footer.setBackground(new java.awt.Color(0, 31, 63));
        Footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel39.setForeground(java.awt.Color.white);
        jLabel39.setText("All rights reserved: ©CP");
        jLabel39.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        Footer.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Footer, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel28MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel28MousePressed
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Are you sure",
                JOptionPane.YES_NO_OPTION);
        /*
         * 0 = yes 1 = no
         */
        if (option == 0) {
            Auth.signOut();
            System.exit(0);
        }
    }// GEN-LAST:event_jLabel28MousePressed

    private void jLabel29MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel29MousePressed
        this.setState(Login.ICONIFIED);
    }// GEN-LAST:event_jLabel29MousePressed

    private void btnLogout2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogout2ActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to log out?", "Are you sure",
                JOptionPane.YES_NO_OPTION);
        /*
         * 0 = yes 1 = no
         */
        if (option == 0) {
            Auth.signOut();
            System.exit(0);
        }
    }// GEN-LAST:event_btnLogout2ActionPerformed

    private void btnHome2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHome2ActionPerformed
        // new MainMenu().setVisible(true);
        // this.dispose();
    }// GEN-LAST:event_btnHome2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        Auth.houseCleaning();
        Auth.createSomeProp = true;
        this.dispose();
        CRUDViewTemplate aCrudViewTemplate = new CRUDViewTemplate();
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(aCrudViewTemplate);

    }

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDisplayActionPerformed
//        this.dispose();
//        ReadPropAll.readAll();
        Auth.houseCleaning();
        Auth.readPropAll = true;
        this.dispose();
        CRUDViewTemplate aCrudViewTemplate = new CRUDViewTemplate();
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(aCrudViewTemplate);

    }// GEN-LAST:event_btnDisplayActionPerformed

    private void btnComparativeViewsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnComparativeViewsActionPerformed
        this.dispose();

        // Open ComparativeViewsMenu
        ComparativeViewsMenu aComparativeViewsMenu = new ComparativeViewsMenu();

        aComparativeViewsMenu.setTitle("Corona Comparative View");
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(aComparativeViewsMenu);

    }// GEN-LAST:event_btnComparativeViewsActionPerformed

    private void btnComputationActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnComputationActionPerformed
        this.dispose();

        // Open ComputationMenu
        ComputationMenu aComputationMenu = new ComputationMenu();

        aComputationMenu.setTitle("Corona Computation Menu");
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(aComputationMenu);

    }// GEN-LAST:event_btnComputationActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
//        this.dispose();
//        UpdateProp.updateSome();
        Auth.houseCleaning();
        Auth.updateSomeProp = true;
        this.dispose();
        CRUDViewTemplate aCrudViewTemplate = new CRUDViewTemplate();
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(aCrudViewTemplate);

    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
//        this.dispose();
//        DeleteProp.deleteSome();
        Auth.houseCleaning();
        Auth.deleteSomeProp = true;
        this.dispose();
        CRUDViewTemplate aCrudViewTemplate = new CRUDViewTemplate();
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(aCrudViewTemplate);

    }// GEN-LAST:event_btnDeleteActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt)// GEN-FIRST:event_formMouseDragged
    {// GEN-HEADEREND:event_formMouseDragged
        setOpacity((float) 0.7);
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt)// GEN-FIRST:event_formMousePressed
    {// GEN-HEADEREND:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt)// GEN-FIRST:event_formMouseReleased
    {// GEN-HEADEREND:event_formMouseReleased
        setOpacity((float) 0.9);
    }// GEN-LAST:event_formMouseReleased

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
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header2;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnComparativeViews;
    private javax.swing.JButton btnComputation;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnHome2;
    private javax.swing.JButton btnLogout2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}