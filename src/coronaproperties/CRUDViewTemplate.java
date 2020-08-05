/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaproperties;

import static coronaproperties.Auth.createSomeProp;
import static coronaproperties.Auth.deleteSomeProp;
import static coronaproperties.Auth.readPropAll;
import static coronaproperties.Auth.updateSomeProp;
import static coronaproperties.Auth.user_id;
import static coronaproperties.ComparativeViewsMenu.compareByCity;
import static coronaproperties.ComparativeViewsMenu.compareByType;
import static coronaproperties.ComparativeViewsMenu.compareByUse;
import static coronaproperties.ComputationMenu.computeAppre;
import static coronaproperties.ComputationMenu.computeDep;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.Timer;

/**
 *
 * @author Melvin K
 */
public class CRUDViewTemplate extends javax.swing.JFrame {
    // fields
    private int xMouse;
    private int yMouse;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    // private int curRow = 0;
    private String propertyPrimaryKey;
    private String propertyType;
    private String addressNum;
    private String addressStreet;
    private String addressCity;
    private String addressCode;
    private double value;
    private String constructionStatus;
    private String useOfProperty;
    private int room;
    private int garage;
    private int bath;
    private double floorArea;
    private double landArea;
    private double rates;
    private String description;
    private String telephone;
    private String email;
    private ArrayList searchField = new ArrayList();
    /**
     * Creates new form UpdatePropMenu
     */
    public CRUDViewTemplate() {
        initComponents();

        actionChecker();
        showDate();
        showTime();
    }

    public void actionChecker() throws HeadlessException {
        if (createSomeProp) {
            lblTitle.setText("Add New Property");
            btnOK.setText("Save");
            lblSearch.setVisible(false);
            txtSearch.setVisible(false);
            btnPrevious.setVisible(false);
            btnNext.setVisible(false);
            undoReadOnlyhouseCleaning();
        }
        if (readPropAll) {
            lblTitle.setText("View All Property");
            lblSearch.setVisible(true);
            txtSearch.setVisible(true);
            readOnlyhouseCleaning();
        }
        if (updateSomeProp) {
            lblTitle.setText("Update Property");
            btnOK.setText("Update");
            lblSearch.setVisible(true);
            txtSearch.setVisible(true);
            undoReadOnlyhouseCleaning();
        }
        if (deleteSomeProp) {
            lblTitle.setText("Delete Property");
            btnOK.setText("Delete");
            lblSearch.setVisible(true);
            txtSearch.setVisible(true);
            undoReadOnlyhouseCleaning();
        }
        if (getData() && readPropAll || updateSomeProp || deleteSomeProp && !createSomeProp) {
            if (loadData(rs)) {
                displayData();
            } else {
                JOptionPane.showMessageDialog(null, "No records in the database!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
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

    public CRUDViewTemplate(String searchString, String searchWhere) {
        initComponents();

        if (compareByCity || compareByType || compareByUse) {
            lblTitle.setText("Compare Property");
            btnOK.setText("Save");
            lblSearch.setVisible(false);
            txtSearch.setVisible(false);
            btnPrevious.setVisible(false);
            btnNext.setVisible(false);
            readOnlyhouseCleaning();
            getData(searchString, searchWhere);
            if (loadData(rs)) {
                displayData();
            } else {
                JOptionPane.showMessageDialog(null, "No results found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Close connection to db before leaving this form
        try {
            if (conn != null || pstmt != null || rs != null) {
                conn.close();
                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void readOnlyhouseCleaning() {
        // Set invisible
        btnOK.setVisible(false);

        // Set to read only
        jComboBoxpropertyType.setEnabled(false);
        jComboBoxconstructionStatus.setEnabled(false);
        jComboBoxuseOfProperty.setEnabled(false);
        txtaddressNum.setEditable(false);
        txtaddressStreet.setEditable(false);
        txtaddressCity.setEditable(false);
        txtaddressCode.setEditable(false);
        txttelephone.setEditable(false);
        txtemail.setEditable(false);
        txtemail.setEditable(false);

        // Disable
        jSpinnerroom.setEnabled(false);
        jSpinnergarage.setEnabled(false);
        jSpinnerbath.setEnabled(false);

        // Set more to read only
        txtfloorArea.setEditable(false);
        txtlandArea.setEditable(false);
        txtvalue.setEditable(false);
        txtrates.setEditable(false);
        jTextAreadescription.setEditable(false);

        if (readPropAll) {
            btnPrevious.setVisible(true);
            btnNext.setVisible(true);
        }

    }

    private void undoReadOnlyhouseCleaning() {
        // Set invisible
        btnOK.setVisible(true);

        // Set to read only
        jComboBoxpropertyType.setEnabled(true);
        jComboBoxconstructionStatus.setEnabled(true);
        jComboBoxuseOfProperty.setEnabled(true);
        txtaddressNum.setEditable(true);
        txtaddressStreet.setEditable(true);
        txtaddressCity.setEditable(true);
        txtaddressCode.setEditable(true);
        txttelephone.setEditable(true);
        txtemail.setEditable(true);
        txtemail.setEditable(true);

        // Disable
        jSpinnerroom.setEnabled(true);
        jSpinnergarage.setEnabled(true);
        jSpinnerbath.setEnabled(true);

        // Set more to read only
        txtfloorArea.setEditable(true);
        txtlandArea.setEditable(true);
        txtvalue.setEditable(true);
        txtrates.setEditable(true);
        jTextAreadescription.setEditable(true);

        if (updateSomeProp || deleteSomeProp) {
            btnPrevious.setVisible(true);
            btnNext.setVisible(true);
        }
    }

    private boolean getData() throws HeadlessException {
        boolean isData = false;
        String sql = "SELECT * FROM property ";
        // Connecting using TempConnectUtil
        // Standard try without resources
        // so that connection to db does not close automatically
        try {
            conn = ConnectUtil.getConnection();
            // Creating query
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
                    Statement.RETURN_GENERATED_KEYS);
            // Executing query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // loadData(rs);
                isData = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isData;
    }

    private boolean getData(String searchString, String searchWhere) throws HeadlessException {
        boolean isData = false;
        String sql = "SELECT * FROM property WHERE" + " UPPER(" + searchWhere + ") LIKE ?";
        // Connecting using TempConnectUtil
        // Standard try without resources
        // so that connection to db does not close automatically
        try {
            conn = ConnectUtil.getConnection();
            // Creating query
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, "%" + searchString + "%");

            // Executing query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // loadData(rs);
                isData = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isData;
    }

    private boolean loadData(ResultSet rs) throws HeadlessException {
        boolean dataLoaded = false;
        try {
            propertyPrimaryKey = rs.getString("propertyPrimaryKey");
            propertyType = rs.getString("propertyType");
            addressNum = rs.getString("addressNum");
            addressStreet = rs.getString("addressStreet");
            addressCity = rs.getString("addressCity");
            addressCode = rs.getString("addressCode");
            value = rs.getDouble("value");
            constructionStatus = rs.getString("constructionStatus");
            useOfProperty = rs.getString("useOfProperty");
            room = rs.getInt("room");
            garage = rs.getInt("garage");
            bath = rs.getInt("bath");
            floorArea = rs.getDouble("floorArea");
            landArea = rs.getDouble("landArea");
            rates = rs.getDouble("rates");
            description = rs.getString("description");
            telephone = rs.getString("telephone");
            email = rs.getString("email");

            dataLoaded = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dataLoaded;
    }

    private void displayData() {
        txtpropertyPrimaryKey.setText(propertyPrimaryKey);
        jComboBoxpropertyType.setSelectedItem(propertyType);
        txtaddressNum.setText(addressNum);
        txtaddressStreet.setText(addressStreet);
        txtaddressCity.setText(addressCity);
        txtaddressCode.setText(addressCode);
        txtvalue.setText(String.valueOf(value));
        jComboBoxconstructionStatus.setSelectedItem(constructionStatus);
        jComboBoxuseOfProperty.setSelectedItem(useOfProperty);
        jSpinnerroom.setValue(room);
        jSpinnergarage.setValue(garage);
        jSpinnerbath.setValue(bath);
        txtfloorArea.setText(String.valueOf(floorArea));
        txtlandArea.setText(String.valueOf(landArea));
        txtrates.setText(String.valueOf(rates));
        jTextAreadescription.setText(description);
        txttelephone.setText(telephone);
        txtemail.setText(email);
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        Header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        btnHome = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnComparativeViews = new javax.swing.JButton();
        btnComputation = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblpropertyPrimaryKey = new javax.swing.JLabel();
        lblpropertyType = new javax.swing.JLabel();
        lbladdress = new javax.swing.JLabel();
        lbladdressNum = new javax.swing.JLabel();
        lbladdressStreet = new javax.swing.JLabel();
        lbladdressCity = new javax.swing.JLabel();
        lbladdressCode = new javax.swing.JLabel();
        lblvalue = new javax.swing.JLabel();
        lblconstructionStatus = new javax.swing.JLabel();
        lbluseOfProperty = new javax.swing.JLabel();
        txtaddressStreet = new javax.swing.JTextField();
        txtpropertyPrimaryKey = new javax.swing.JTextField();
        txtaddressCity = new javax.swing.JTextField();
        txtaddressNum = new javax.swing.JTextField();
        txtaddressCode = new javax.swing.JTextField();
        txttelephone = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        lblpropertyPrimaryKey1 = new javax.swing.JLabel();
        lblpropertyType1 = new javax.swing.JLabel();
        lbladdressNum1 = new javax.swing.JLabel();
        lbladdressStreet1 = new javax.swing.JLabel();
        lbladdressCity1 = new javax.swing.JLabel();
        lbladdressCode1 = new javax.swing.JLabel();
        lblvalue1 = new javax.swing.JLabel();
        lblconstructionStatus1 = new javax.swing.JLabel();
        lbluseOfProperty1 = new javax.swing.JLabel();
        txtlandArea = new javax.swing.JTextField();
        txtfloorArea = new javax.swing.JTextField();
        txtvalue = new javax.swing.JTextField();
        lbluseOfProperty2 = new javax.swing.JLabel();
        txtrates = new javax.swing.JTextField();
        lblpropertyPrimaryKey2 = new javax.swing.JLabel();
        lblconstructionStatus2 = new javax.swing.JLabel();
        lbluseOfProperty3 = new javax.swing.JLabel();
        lbluseOfProperty4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreadescription = new javax.swing.JTextArea();
        jSpinnergarage = new javax.swing.JSpinner();
        jSpinnerroom = new javax.swing.JSpinner();
        jSpinnerbath = new javax.swing.JSpinner();
        jComboBoxconstructionStatus = new javax.swing.JComboBox<>();
        jComboBoxuseOfProperty = new javax.swing.JComboBox<>();
        jComboBoxpropertyType = new javax.swing.JComboBox<>();
        btnOK = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

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

        kGradientPanel1.setkEndColor(new java.awt.Color(63, 81, 181));
        kGradientPanel1.setkStartColor(new java.awt.Color(144, 202, 249));

        Header.setBackground(new java.awt.Color(0, 31, 63));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Under Authority", 1, 36)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Corona properties");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        Header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Multiplication_24px_2.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel5MousePressed(evt);
            }
        });
        Header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Minus_24px.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLabel10MousePressed(evt);
            }
        });
        Header.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Menu_96px_2.png"))); // NOI18N
        Header.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 80));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Help_24px.png"))); // NOI18N
        Header.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        lblTime.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        Header.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        lblDate.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        Header.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, -1, -1));

        btnLogout.setBackground(java.awt.Color.lightGray);
        btnLogout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setToolTipText("");
        btnLogout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLogoutActionPerformed(evt);
            }
        });
        Header.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 80, -1));

        kGradientPanel3.setkEndColor(new java.awt.Color(144, 202, 249));
        kGradientPanel3.setkStartColor(new java.awt.Color(88, 119, 202));

        btnHome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(88, 119, 202));
        btnHome.setText("Home");
        btnHome.setAlignmentX(5.0F);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Home_24px_1.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

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

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Login_24px_1.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addComponent(jLabel16)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18))
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnComparativeViews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnComputation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDisplay)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComparativeViews)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComputation)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle.setForeground(java.awt.Color.white);
        lblTitle.setText("Menu");
        lblTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(0, 0, 0)));

        lblpropertyPrimaryKey.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblpropertyPrimaryKey.setForeground(new java.awt.Color(255, 255, 255));
        lblpropertyPrimaryKey.setText("Property Primary Key");

        lblpropertyType.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblpropertyType.setForeground(new java.awt.Color(255, 255, 255));
        lblpropertyType.setText("Property Type");

        lbladdress.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbladdress.setForeground(new java.awt.Color(255, 255, 255));
        lbladdress.setText("Address");

        lbladdressNum.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressNum.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressNum.setText("Number");

        lbladdressStreet.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressStreet.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressStreet.setText("Street");

        lbladdressCity.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressCity.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressCity.setText("City");

        lbladdressCode.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressCode.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressCode.setText("Code");

        lblvalue.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblvalue.setForeground(new java.awt.Color(255, 255, 255));
        lblvalue.setText("Contact");

        lblconstructionStatus.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblconstructionStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblconstructionStatus.setText("Telephone");

        lbluseOfProperty.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty.setForeground(new java.awt.Color(255, 255, 255));
        lbluseOfProperty.setText("Email");

        txtaddressStreet.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtpropertyPrimaryKey.setEditable(false);
        txtpropertyPrimaryKey.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtaddressCity.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtaddressNum.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtaddressCode.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txttelephone.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txttelephone.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txttelephoneKeyTyped(evt);
            }
        });

        txtemail.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lblpropertyPrimaryKey1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblpropertyPrimaryKey1.setForeground(new java.awt.Color(255, 255, 255));
        lblpropertyPrimaryKey1.setText("Quantities");

        lblpropertyType1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblpropertyType1.setForeground(new java.awt.Color(255, 255, 255));
        lblpropertyType1.setText("Room");

        lbladdressNum1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressNum1.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressNum1.setText("Garage");

        lbladdressStreet1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressStreet1.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressStreet1.setText("Bath");

        lbladdressCity1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbladdressCity1.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressCity1.setText("Size");

        lbladdressCode1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressCode1.setForeground(new java.awt.Color(255, 255, 255));
        lbladdressCode1.setText("Floor area");

        lblvalue1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblvalue1.setForeground(new java.awt.Color(255, 255, 255));
        lblvalue1.setText("Land area");

        lblconstructionStatus1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblconstructionStatus1.setForeground(new java.awt.Color(255, 255, 255));
        lblconstructionStatus1.setText("Costs");

        lbluseOfProperty1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty1.setForeground(new java.awt.Color(255, 255, 255));
        lbluseOfProperty1.setText("Value");

        txtlandArea.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtlandArea.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtlandAreaKeyTyped(evt);
            }
        });

        txtfloorArea.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtfloorArea.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtfloorAreaKeyTyped(evt);
            }
        });

        txtvalue.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtvalue.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtvalueKeyTyped(evt);
            }
        });

        lbluseOfProperty2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty2.setForeground(new java.awt.Color(255, 255, 255));
        lbluseOfProperty2.setText("Rates");

        txtrates.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtrates.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtratesKeyTyped(evt);
            }
        });

        lblpropertyPrimaryKey2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblpropertyPrimaryKey2.setForeground(new java.awt.Color(255, 255, 255));
        lblpropertyPrimaryKey2.setText("Info");

        lblconstructionStatus2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblconstructionStatus2.setForeground(new java.awt.Color(255, 255, 255));
        lblconstructionStatus2.setText("Construction Status");

        lbluseOfProperty3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty3.setForeground(new java.awt.Color(255, 255, 255));
        lbluseOfProperty3.setText("Use of Property");

        lbluseOfProperty4.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbluseOfProperty4.setForeground(new java.awt.Color(255, 255, 255));
        lbluseOfProperty4.setText("Description");

        jTextAreadescription.setColumns(20);
        jTextAreadescription.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextAreadescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreadescription);

        jSpinnergarage.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jSpinnergarage.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSpinnergarageStateChanged(evt);
            }
        });

        jSpinnerroom.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jSpinnerroom.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSpinnerroomStateChanged(evt);
            }
        });

        jSpinnerbath.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jSpinnerbath.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSpinnerbathStateChanged(evt);
            }
        });

        jComboBoxconstructionStatus.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxconstructionStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completed", "Not Complete" }));

        jComboBoxuseOfProperty.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxuseOfProperty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rented", "Idle", "Dr Shaun's Home" }));

        jComboBoxpropertyType.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBoxpropertyType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "House", "Flat", "Business" }));

        btnOK.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOKActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        btnPrevious.setText("<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPreviousActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtSearchKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtSearchKeyPressed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        lblSearch.setText("Search");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblpropertyType)
                                        .addComponent(lblpropertyPrimaryKey))
                                    .addGap(46, 46, 46)
                                    .addComponent(txtpropertyPrimaryKey, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblpropertyPrimaryKey2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblconstructionStatus2)
                                        .addComponent(lbluseOfProperty3)
                                        .addComponent(lblvalue)
                                        .addComponent(lbluseOfProperty)
                                        .addComponent(lblconstructionStatus)
                                        .addComponent(lbladdressNum)
                                        .addComponent(lbladdressStreet)
                                        .addComponent(lbladdressCity)
                                        .addComponent(lbladdressCode))
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addGap(67, 67, 67)
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txttelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtaddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtaddressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtaddressNum, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtaddressCode, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                                    .addGap(31, 31, 31)
                                                    .addComponent(btnPrevious)
                                                    .addGap(58, 58, 58)
                                                    .addComponent(btnNext))))
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(jComboBoxpropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jComboBoxconstructionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jComboBoxuseOfProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addComponent(lbladdress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladdressStreet1)
                            .addComponent(lbladdressNum1)
                            .addComponent(lbladdressCity1)
                            .addComponent(lblconstructionStatus1)
                            .addComponent(lbluseOfProperty1)
                            .addComponent(lblpropertyType1)
                            .addComponent(lblpropertyPrimaryKey1)
                            .addComponent(lblvalue1)
                            .addComponent(lbladdressCode1)
                            .addComponent(lbluseOfProperty2)
                            .addComponent(lbluseOfProperty4)
                            .addComponent(btnOK))
                        .addGap(46, 46, 46)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtlandArea, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfloorArea, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrates, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerroom, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnergarage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerbath, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)
                        .addGap(65, 65, 65))))
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearch))
                        .addGap(15, 15, 15)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(lblpropertyType1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbladdressNum1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbladdressStreet1))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jSpinnerroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinnergarage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinnerbath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbladdressCity1)
                                .addGap(5, 5, 5)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfloorArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbladdressCode1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtlandArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblvalue1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblconstructionStatus1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbluseOfProperty1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtrates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbluseOfProperty2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbluseOfProperty4)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblpropertyPrimaryKey2)
                                        .addComponent(lblpropertyPrimaryKey1))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(lblpropertyPrimaryKey)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblpropertyType)
                                                    .addComponent(jComboBoxpropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txtpropertyPrimaryKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblconstructionStatus2)
                                            .addComponent(jComboBoxconstructionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbluseOfProperty3)
                                            .addComponent(jComboBoxuseOfProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(lbladdress)
                                .addGap(12, 12, 12)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbladdressNum)
                                    .addComponent(txtaddressNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtaddressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtaddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtaddressCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(lbladdressStreet)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbladdressCity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbladdressCode)
                                        .addGap(18, 18, 18)))
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(lblvalue)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblconstructionStatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbluseOfProperty))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(txttelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOK)
                            .addComponent(btnNext)
                            .addComponent(btnPrevious))
                        .addContainerGap())
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Footer.setBackground(new java.awt.Color(0, 31, 63));
        Footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("All rights reserved: ©CP");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        Footer.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Footer, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MousePressed

        if (compareByCity || compareByType || compareByUse) {
            Auth.houseCleaning();
            this.dispose();
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Are you sure",
                    JOptionPane.YES_NO_OPTION);
            /*
             * 0 = yes 1 = no
             */
            if (option == 0) {
                Auth.signOut();
                System.exit(0);
            }
        }
    }// GEN-LAST:event_jLabel5MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel10MousePressed

        this.setState(Login.ICONIFIED);
    }// GEN-LAST:event_jLabel10MousePressed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogoutActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to log out?", "Are you sure",
                JOptionPane.YES_NO_OPTION);
        /*
         * 0 = yes 1 = no
         */
        if (option == 0) {
            Auth.signOut();
            System.exit(0);
        }
    }// GEN-LAST:event_btnLogoutActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHomeActionPerformed
        Auth.houseCleaning();
        // Close connection to db before leaving this form
        try {
            if (conn != null || pstmt != null || rs != null) {
                conn.close();
                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Close this menu
        this.dispose();

        // Back to main menu
        MainMenu menu = new MainMenu();

        menu.setTitle("Corona Main Menu");
        SetJFrameIcon setJFrameIcon = new SetJFrameIcon(menu);

    }// GEN-LAST:event_btnHomeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        Auth.houseCleaning();
        createSomeProp = true;
        actionChecker();
        prepareToAdd();

    }

    private void prepareToAdd() {
        txtpropertyPrimaryKey.setText("");
        jComboBoxpropertyType.setSelectedItem("");
        txtaddressNum.setText("");
        txtaddressStreet.setText("");
        txtaddressCity.setText("");
        txtaddressCode.setText("");
        txtvalue.setText(String.valueOf(""));
        jComboBoxconstructionStatus.setSelectedItem("");
        jComboBoxuseOfProperty.setSelectedItem("");
        jSpinnerroom.setValue(0);
        jSpinnergarage.setValue(0);
        jSpinnerbath.setValue(0);
        txtfloorArea.setText(String.valueOf(""));
        txtlandArea.setText(String.valueOf(""));
        txtrates.setText(String.valueOf(""));
        jTextAreadescription.setText("");
        txttelephone.setText("");
        txtemail.setText("");
    }

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDisplayActionPerformed
//        this.dispose();
//        ReadPropAll.readAll();
        Auth.houseCleaning();
        readPropAll = true;
        actionChecker();

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
        updateSomeProp = true;
        actionChecker();

    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
//        this.dispose();
//        DeleteProp.deleteSome();
        Auth.houseCleaning();
        deleteSomeProp = true;
        actionChecker();

    }// GEN-LAST:event_btnDeleteActionPerformed

    private void txttelephoneKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txttelephoneKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }// GEN-LAST:event_txttelephoneKeyTyped

    private void txtlandAreaKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtlandAreaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }// GEN-LAST:event_txtlandAreaKeyTyped

    private void txtfloorAreaKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtfloorAreaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }// GEN-LAST:event_txtfloorAreaKeyTyped

    private void txtvalueKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtvalueKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }// GEN-LAST:event_txtvalueKeyTyped

    private void txtratesKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtratesKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }// GEN-LAST:event_txtratesKeyTyped

    private void jSpinnergarageStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_jSpinnergarageStateChanged
        if ((int) jSpinnergarage.getValue() < 0) {
            jSpinnergarage.setValue(0);
        }
    }// GEN-LAST:event_jSpinnergarageStateChanged

    private void jSpinnerroomStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_jSpinnerroomStateChanged
        if ((int) jSpinnerroom.getValue() < 0) {
            jSpinnerroom.setValue(0);
        }
    }// GEN-LAST:event_jSpinnerroomStateChanged

    private void jSpinnerbathStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_jSpinnerbathStateChanged
        if ((int) jSpinnerbath.getValue() < 0) {
            jSpinnerbath.setValue(0);
        }
    }// GEN-LAST:event_jSpinnerbathStateChanged

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {

        int option = JOptionPane.showConfirmDialog(null, "Do you really want to?", "Are you sure",
                JOptionPane.YES_NO_OPTION);
        /*
         * 0 = yes 1 = no
         */
        if (option == 0) {
            // Clear search field
            txtSearch.setText("");
            if (createSomeProp) {
                if (captureInput()) {
                    create();
                }
                createSomeProp = false;
            } else if (updateSomeProp) {
                if (captureInput()) {
                    update();
                }
                updateSomeProp = false;
            } else if (deleteSomeProp) {
                delete();
                deleteSomeProp = false;
            }

        }
    }

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
        try {
            if (rs.next()) {
                loadData(rs);
                displayData();

            } else {
                rs.previous();
                showMessageDialog(null, "No more records!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPreviousActionPerformed
        try {
            if (rs.previous()) {
                loadData(rs);
                displayData();
            } else {
                rs.next();
                showMessageDialog(null, "No previous records!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_btnPreviousActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSearchKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                break;
            case KeyEvent.VK_ENTER:
                txtSearch.setText(txtSearch.getText().toUpperCase());
                break;
            default:
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String txt = txtSearch.getText().toUpperCase();
                        autoComp(txt);
                    }

                });
        }
    }// GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSearchKeyTyped
        // if (!Character.isLetterOrDigit(evt.getKeyChar())) {
        // evt.consume();
        // }
        search();
    }// GEN-LAST:event_txtSearchKeyTyped

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

    private boolean captureInput() throws HeadlessException {

        boolean captured = false;
        // Capture input into variables
        try {
            propertyPrimaryKey = txtpropertyPrimaryKey.getText();
            propertyType = valueOf(jComboBoxpropertyType.getSelectedItem());
            addressNum = txtaddressNum.getText();
            addressStreet = txtaddressStreet.getText();
            addressCity = txtaddressCity.getText();
            addressCode = txtaddressCode.getText();
            value = Double.parseDouble(txtvalue.getText());
            constructionStatus = valueOf(jComboBoxconstructionStatus.getSelectedItem());
            useOfProperty = valueOf(jComboBoxuseOfProperty.getSelectedItem());
            room = (int) jSpinnerroom.getValue();
            garage = (int) jSpinnergarage.getValue();
            bath = (int) jSpinnerbath.getValue();
            floorArea = Double.parseDouble(txtfloorArea.getText());
            landArea = Double.parseDouble(txtlandArea.getText());
            rates = Double.parseDouble(txtrates.getText());
            description = jTextAreadescription.getText();
            telephone = txttelephone.getText();
            email = txtemail.getText();

            // Validate email
            if (Validate.isEmail(email)) {
                captured = true;
            } else {
                JOptionPane.showMessageDialog(null, "Email does NOT meet minimum requirements!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "One or more empty fields", "Empty field(s)",
                    JOptionPane.ERROR_MESSAGE);
        }
        return captured;
    }

    void create() throws HeadlessException {
        int housePKey = 0;

        String sql = "INSERT INTO property(propertyType,addressNum,addressStreet,addressCity,addressCode,value,constructionStatus,useOfProperty,room,garage,bath,floorArea,landArea,rates,description,telephone,email) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        // Connecting using ConnectUtil
        try {
            // Creating query
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // set parameters for statement
            pstmt.setString(1, propertyType);
            pstmt.setString(2, addressNum);
            pstmt.setString(3, addressStreet);
            pstmt.setString(4, addressCity);
            pstmt.setString(5, addressCode);
            pstmt.setDouble(6, value);
            pstmt.setString(7, constructionStatus);
            pstmt.setString(8, useOfProperty);
            pstmt.setInt(9, room);
            pstmt.setInt(10, garage);
            pstmt.setDouble(11, bath);
            pstmt.setDouble(12, floorArea);
            pstmt.setDouble(13, landArea);
            pstmt.setDouble(14, rates);
            pstmt.setString(15, description);
            pstmt.setString(16, telephone);
            pstmt.setString(17, email);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                // get housePKey id
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    housePKey = rs.getInt(1);
                    // Audit log
                    // 3 means new
                    int action = 3;
                    auditLog(action);
                }
            }
            JOptionPane.showMessageDialog(null,
                    "A new Property with Property Primary Key " + housePKey + " has been inserted.");

            // Close this menu
            this.dispose();

            // Open menu
            MainMenu menu = new MainMenu();

            menu.setTitle("Corona Properties Main Menu");
            SetJFrameIcon setJFrameIcon = new SetJFrameIcon(menu);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void update() throws HeadlessException {
        String sql = "UPDATE property SET propertyType = ? , " + "addressNum = ? , " + "addressStreet = ? , "
                + "addressCity = ? , " + "addressCode = ? , " + "value = ? , " + "constructionStatus = ? , "
                + "useOfProperty = ? , " + "room = ? ," + "garage = ? , " + "bath = ? ," + "floorArea = ? , "
                + "landArea = ? , " + "rates = ? , " + "description = ? , " + "telephone = ? , " + "email = ? "
                + "WHERE propertyPrimaryKey = ?";
        try {
            // Creating query
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, propertyType);
            pstmt.setString(2, addressNum);
            pstmt.setString(3, addressStreet);
            pstmt.setString(4, addressCity);
            pstmt.setString(5, addressCode);
            pstmt.setDouble(6, value);
            pstmt.setString(7, constructionStatus);
            pstmt.setString(8, useOfProperty);
            pstmt.setInt(9, room);
            pstmt.setInt(10, garage);
            pstmt.setDouble(11, bath);
            pstmt.setDouble(12, floorArea);
            pstmt.setDouble(13, landArea);
            pstmt.setDouble(14, rates);
            pstmt.setString(15, description);
            pstmt.setString(16, telephone);
            pstmt.setString(17, email);
            pstmt.setString(18, propertyPrimaryKey);

            pstmt.executeUpdate();

            // Audit log
            // 4 means update
            int action = 4;
            auditLog(action);

            // Refreshing data
            getData();
            loadData(rs);
            displayData();

            JOptionPane.showMessageDialog(null, "Property has been updated successfully!.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void delete() throws HeadlessException {
        String sql = "DELETE FROM property WHERE propertyPrimaryKey = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, Integer.parseInt(propertyPrimaryKey));
            // execute the delete statement
            pstmt.executeUpdate();

            // Audit log
            // 5 means delete
            int action = 5;
            auditLog(action);

            // Refreshing data
            getData();
            loadData(rs);
            displayData();

            JOptionPane.showMessageDialog(null, "Record deleted successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void auditLog(int action) throws HeadlessException {
        /**
         * Audit log 0=default 1=SIGNED IN 2=SIGNED OUT 3=NEW 4=EDIT 5=DELETE
         */
        String sql = "UPDATE user SET action = ? " + "WHERE user_id = ?";
        try {
            // Creating query
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            {
                pstmt.setInt(1, action);
                pstmt.setInt(2, user_id);

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            // System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void search() throws HeadlessException {
        String sql = "SELECT * FROM property WHERE UPPER(propertyType) LIKE ?" + " OR UPPER(addressNum) LIKE ?"
                + " OR UPPER(addressStreet) LIKE ?" + " OR UPPER(addressCity) LIKE ?" + " OR UPPER(addressCode) LIKE ?"
                + " OR UPPER(value) LIKE ?" + " OR UPPER(constructionStatus) LIKE ?" + " OR UPPER(useOfProperty) LIKE ?"
                + " OR UPPER(room) LIKE ?" + " OR UPPER(garage) LIKE ?" + " OR UPPER(bath) LIKE ?"
                + " OR UPPER(floorArea) LIKE ?" + " OR UPPER(landArea) LIKE ?" + " OR UPPER(rates) LIKE ?"
                + " OR UPPER(telephone) LIKE ?" + " OR UPPER(email) LIKE ?";
        // Connecting using TempConnectUtil
        try {
            // Creating query
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
                    Statement.RETURN_GENERATED_KEYS);

            for (int i = 1; i <= 16; i++) {
                pstmt.setString(i, "%" + txtSearch.getText().toUpperCase() + "%");
            }

            // Executing query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                loadData(rs);
                displayData();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double search(String searchString) throws HeadlessException {
        if (computeDep || computeAppre) {
            String sql = "SELECT * FROM property WHERE UPPER(propertyType) LIKE ?" + " OR UPPER(addressNum) LIKE ?"
                    + " OR UPPER(addressStreet) LIKE ?" + " OR UPPER(addressCity) LIKE ?"
                    + " OR UPPER(addressCode) LIKE ?" + " OR UPPER(value) LIKE ?"
                    + " OR UPPER(constructionStatus) LIKE ?" + " OR UPPER(useOfProperty) LIKE ?"
                    + " OR UPPER(room) LIKE ?" + " OR UPPER(garage) LIKE ?" + " OR UPPER(bath) LIKE ?"
                    + " OR UPPER(floorArea) LIKE ?" + " OR UPPER(landArea) LIKE ?" + " OR UPPER(rates) LIKE ?"
                    + " OR UPPER(telephone) LIKE ?" + " OR UPPER(email) LIKE ?";
            // Connecting using ConnectUtil
            try {
                // Creating query
                pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
                        Statement.RETURN_GENERATED_KEYS);

                for (int i = 1; i <= 16; i++) {
                    pstmt.setString(i, "%" + searchString + "%");
                }

                // Executing query
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    value = rs.getDouble("value");
                }

                computeDep = false;
                computeAppre = false;
            } catch (SQLException e) {
                // System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                System.out.println(e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (loadData(rs)) {
                displayData();
            } else {
                JOptionPane.showMessageDialog(null, "No results found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        return value;
    }

    public void autoComp(String searchKeyword) {
        String comp = "";
        int start = searchKeyword.length();
        int last = searchKeyword.length();

        for (int i = 0; i < searchField.size(); i++) {
            if (searchField.get(i).toString().startsWith(searchKeyword)) {
                comp = searchField.get(i).toString();
                last = comp.length();
                break;
            }
        }
        if (last > start) {
            txtSearch.setText(comp);
            txtSearch.setCaretPosition(last);
            txtSearch.moveCaretPosition(start);
        }

    }

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
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDViewTemplate().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnComparativeViews;
    private javax.swing.JButton btnComputation;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jComboBoxconstructionStatus;
    private javax.swing.JComboBox<String> jComboBoxpropertyType;
    private javax.swing.JComboBox<String> jComboBoxuseOfProperty;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerbath;
    private javax.swing.JSpinner jSpinnergarage;
    private javax.swing.JSpinner jSpinnerroom;
    private javax.swing.JTextArea jTextAreadescription;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbladdress;
    private javax.swing.JLabel lbladdressCity;
    private javax.swing.JLabel lbladdressCity1;
    private javax.swing.JLabel lbladdressCode;
    private javax.swing.JLabel lbladdressCode1;
    private javax.swing.JLabel lbladdressNum;
    private javax.swing.JLabel lbladdressNum1;
    private javax.swing.JLabel lbladdressStreet;
    private javax.swing.JLabel lbladdressStreet1;
    private javax.swing.JLabel lblconstructionStatus;
    private javax.swing.JLabel lblconstructionStatus1;
    private javax.swing.JLabel lblconstructionStatus2;
    private javax.swing.JLabel lblpropertyPrimaryKey;
    private javax.swing.JLabel lblpropertyPrimaryKey1;
    private javax.swing.JLabel lblpropertyPrimaryKey2;
    private javax.swing.JLabel lblpropertyType;
    private javax.swing.JLabel lblpropertyType1;
    private javax.swing.JLabel lbluseOfProperty;
    private javax.swing.JLabel lbluseOfProperty1;
    private javax.swing.JLabel lbluseOfProperty2;
    private javax.swing.JLabel lbluseOfProperty3;
    private javax.swing.JLabel lbluseOfProperty4;
    private javax.swing.JLabel lblvalue;
    private javax.swing.JLabel lblvalue1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtaddressCity;
    private javax.swing.JTextField txtaddressCode;
    private javax.swing.JTextField txtaddressNum;
    private javax.swing.JTextField txtaddressStreet;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfloorArea;
    private javax.swing.JTextField txtlandArea;
    private javax.swing.JTextField txtpropertyPrimaryKey;
    private javax.swing.JTextField txtrates;
    private javax.swing.JTextField txttelephone;
    private javax.swing.JTextField txtvalue;
    // End of variables declaration//GEN-END:variables
}
