/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaproperties;

import static coronaproperties.CreateProp.createSomeProp;
import static coronaproperties.DeleteProp.deleteSomeProp;
import static coronaproperties.ReadPropAll.readPropAll;
import static coronaproperties.UpdateProp.updateSomeProp;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.lang.String.valueOf;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

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
//    private int curRow = 0;
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
    /**
     * Creates new form UpdatePropMenu
     */
    public CRUDViewTemplate() {
        initComponents();
        txtpropertyPrimaryKey.setEditable(false);
        if (createSomeProp) {
            lblTitle.setText("Add New Property");
            btnOK.setText("Save");
            lblSearch.setVisible(false);
            txtSearch.setVisible(false);
            btnPrevious.setVisible(false);
            btnNext.setVisible(false);
        }
        if (readPropAll) {
            lblTitle.setText("View All Property");
            readOnlyhouseCleaning();
        }
        if (updateSomeProp) {
            lblTitle.setText("Update Property");
            btnOK.setText("Update");
        }
        if (deleteSomeProp) {
            lblTitle.setText("Delete Property");
            btnOK.setText("Delete");
        }
        if (getData() && readPropAll || updateSomeProp || deleteSomeProp && !createSomeProp) {
            if (loadData(rs)) {
                displayData();
            } else {
                JOptionPane.showMessageDialog(null, "No records in the database!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void readOnlyhouseCleaning() {
        //Set invisible
        btnOK.setVisible(false);

        //Set to read only
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

        //Disable
        jSpinnerroom.setEnabled(false);
        jSpinnergarage.setEnabled(false);
        jSpinnerbath.setEnabled(false);

        //Set more to read only
        txtfloorArea.setEditable(false);
        txtlandArea.setEditable(false);
        txtvalue.setEditable(false);
        txtrates.setEditable(false);
        jTextAreadescription.setEditable(false);
    }

    private boolean getData() throws HeadlessException {
        boolean isData = false;
        String sql = "SELECT * FROM property ";
        //Connecting using ConnectUtil
        //Standard try without resources
        //so that connection to db does not close automatically
        try {
            conn = ConnectUtil.getConnection();
            //Creating query
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE, Statement.RETURN_GENERATED_KEYS);
            //Executing query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                loadData(rs);
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
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
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
        btnCancel = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        lblHeading.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        lblHeading.setText("Corona Properties");

        lblTitle.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        lblTitle.setText("Property");

        lblpropertyPrimaryKey.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblpropertyPrimaryKey.setText("Property Primary Key");

        lblpropertyType.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblpropertyType.setText("Property Type");

        lbladdress.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbladdress.setText("Address");

        lbladdressNum.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressNum.setText("Number");

        lbladdressStreet.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressStreet.setText("Street");

        lbladdressCity.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressCity.setText("City");

        lbladdressCode.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressCode.setText("Code");

        lblvalue.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblvalue.setText("Contact");

        lblconstructionStatus.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblconstructionStatus.setText("Telephone");

        lbluseOfProperty.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty.setText("Email");

        txtaddressStreet.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtpropertyPrimaryKey.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtaddressCity.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtaddressNum.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtaddressCode.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txttelephone.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txttelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelephoneKeyTyped(evt);
            }
        });

        txtemail.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lblpropertyPrimaryKey1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblpropertyPrimaryKey1.setText("Quantities");

        lblpropertyType1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblpropertyType1.setText("Room");

        lbladdressNum1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressNum1.setText("Garage");

        lbladdressStreet1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressStreet1.setText("Bath");

        lbladdressCity1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbladdressCity1.setText("Size");

        lbladdressCode1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbladdressCode1.setText("Floor area");

        lblvalue1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblvalue1.setText("Land area");

        lblconstructionStatus1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblconstructionStatus1.setText("Costs");

        lbluseOfProperty1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty1.setText("Value");

        txtlandArea.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtlandArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlandAreaKeyTyped(evt);
            }
        });

        txtfloorArea.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtfloorArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfloorAreaKeyTyped(evt);
            }
        });

        txtvalue.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtvalue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalueKeyTyped(evt);
            }
        });

        lbluseOfProperty2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty2.setText("Rates");

        txtrates.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtrates.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtratesKeyTyped(evt);
            }
        });

        lblpropertyPrimaryKey2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblpropertyPrimaryKey2.setText("Info");

        lblconstructionStatus2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lblconstructionStatus2.setText("Construction Status");

        lbluseOfProperty3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbluseOfProperty3.setText("Use of Property");

        lbluseOfProperty4.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbluseOfProperty4.setText("Description");

        jTextAreadescription.setColumns(20);
        jTextAreadescription.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextAreadescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreadescription);

        jSpinnergarage.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jSpinnergarage.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnergarageStateChanged(evt);
            }
        });

        jSpinnerroom.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jSpinnerroom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerroomStateChanged(evt);
            }
        });

        jSpinnerbath.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jSpinnerbath.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
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
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        btnCancel.setText("Main Menu");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        btnPrevious.setText("<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        lblSearch.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(lblHeading)
                .addGap(387, 387, 387))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblpropertyType)
                                .addComponent(lblpropertyPrimaryKey))
                            .addGap(46, 46, 46)
                            .addComponent(txtpropertyPrimaryKey, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblpropertyPrimaryKey2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblconstructionStatus2)
                                .addComponent(lbluseOfProperty3)
                                .addComponent(lblvalue)
                                .addComponent(lbluseOfProperty)
                                .addComponent(lblconstructionStatus)
                                .addComponent(lbladdressNum)
                                .addComponent(lbladdressStreet)
                                .addComponent(lbladdressCity)
                                .addComponent(lbladdressCode))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txttelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtaddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtaddressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtaddressNum, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtaddressCode, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(31, 31, 31)
                                            .addComponent(btnPrevious)
                                            .addGap(58, 58, 58)
                                            .addComponent(btnNext))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jComboBoxpropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jComboBoxconstructionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxuseOfProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(lbladdress)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtlandArea, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfloorArea, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtrates, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnerroom, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnergarage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnerbath, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCancel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblpropertyPrimaryKey2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblpropertyPrimaryKey)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblpropertyType)
                                            .addComponent(jComboBoxpropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtpropertyPrimaryKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblconstructionStatus2)
                                    .addComponent(jComboBoxconstructionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbluseOfProperty3)
                                    .addComponent(jComboBoxuseOfProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(lbladdress)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbladdressNum)
                            .addComponent(txtaddressNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtaddressStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtaddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtaddressCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lbladdressStreet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbladdressCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbladdressCode)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblvalue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblconstructionStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbluseOfProperty))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txttelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblpropertyPrimaryKey1)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblpropertyType1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbladdressNum1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbladdressStreet1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSpinnerroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnergarage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerbath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbladdressCity1)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfloorArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladdressCode1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlandArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblvalue1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblconstructionStatus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbluseOfProperty1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtrates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbluseOfProperty2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbluseOfProperty4)
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancel)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addGap(25, 25, 25))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelephoneKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txttelephoneKeyTyped

    private void txtlandAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlandAreaKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtlandAreaKeyTyped

    private void txtfloorAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfloorAreaKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfloorAreaKeyTyped

    private void txtvalueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalueKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtvalueKeyTyped

    private void txtratesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtratesKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtratesKeyTyped

    private void jSpinnergarageStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnergarageStateChanged
        if ((int) jSpinnergarage.getValue() < 0) {
            jSpinnergarage.setValue(0);
        }
    }//GEN-LAST:event_jSpinnergarageStateChanged

    private void jSpinnerroomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerroomStateChanged
        if ((int) jSpinnerroom.getValue() < 0) {
            jSpinnerroom.setValue(0);
        }
    }//GEN-LAST:event_jSpinnerroomStateChanged

    private void jSpinnerbathStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerbathStateChanged
        if ((int) jSpinnerbath.getValue() < 0) {
            jSpinnerbath.setValue(0);
        }
    }//GEN-LAST:event_jSpinnerbathStateChanged

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

        int option = JOptionPane.showConfirmDialog(null, "Do you really want to?", "Are you sure", JOptionPane.YES_NO_OPTION);
        /*
         * 0 = yes
         * 1 = no
         */
        if (option == 0) {
            //Clear search field
            txtSearch.setText("");
            if (createSomeProp) {
                if (captureInput()) {
                    create();
                }
            } else if (updateSomeProp) {
                if (captureInput()) {
                    update();
                }
            } else if (deleteSomeProp) {
                delete();
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private boolean captureInput() throws HeadlessException {

        boolean captured = false;
//Capture input into variables
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

            //Validate email
            if (Validate.isEmail(email)) {
                captured = true;
            } else {
                JOptionPane.showMessageDialog(null, "Email does NOT meet minimum requirements!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "One or more empty fields",
                    "Empty field(s)", JOptionPane.ERROR_MESSAGE);
        }
        return captured;
    }

    private void create() throws HeadlessException {
        int housePKey = 0;

        String sql = "INSERT INTO property(propertyType,addressNum,addressStreet,addressCity,addressCode,value,constructionStatus,useOfProperty,room,garage,bath,floorArea,landArea,rates,description,telephone,email) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //Connecting using ConnectUtil
        try {
            //Creating query
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
                }
            }
            //Refresh
//            getData();
//            loadData(rs);
//            displayData();

            JOptionPane.showMessageDialog(null, "A new Property with Property Primary Key " + housePKey + " has been inserted.");

            //Close this menu
            this.dispose();

            // Open menu
            MainMenu menu = new MainMenu();

            menu.setTitle("Corona Properties Main Menu");
            menu.setOpacity((float) 0.9);
            menu.setBackground(new Color(0, 0, 0, 0));
            menu.setIconImage(Toolkit.getDefaultToolkit()
                    .getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);

            System.gc();
//            JOptionPane.showMessageDialog(null, "Record created successfully!");
        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void update() throws HeadlessException {
//        int housePKey = 0;

        String sql = "UPDATE property SET propertyType = ? , "
                + "addressNum = ? , "
                + "addressStreet = ? , "
                + "addressCity = ? , "
                + "addressCode = ? , "
                + "value = ? , "
                + "constructionStatus = ? , "
                + "useOfProperty = ? , "
                + "room = ? ,"
                + "garage = ? , "
                + "bath = ? ,"
                + "floorArea = ? , "
                + "landArea = ? , "
                + "rates = ? , "
                + "description = ? , "
                + "telephone = ? , "
                + "email = ? "
                + "WHERE propertyPrimaryKey = ?";
        try {
            //Creating query
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
//            int rowAffected = pstmt.executeUpdate();
//            if (rowAffected == 1) {
//                // get housePKey id
//                rs = pstmt.getGeneratedKeys();
//                if (rs.next()) {
//                    housePKey = rs.getInt(1);
//                }
//            }
            //Refresh
//            curRow = rs.getRow();
            getData();
            loadData(rs);
            displayData();

            JOptionPane.showMessageDialog(null, "Property has been updated successfully!.");
        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void delete() throws HeadlessException {
        String sql = "DELETE FROM property WHERE propertyPrimaryKey = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, Integer.parseInt(propertyPrimaryKey));
            // execute the delete statement
            pstmt.executeUpdate();

            //Refresh
            getData();
            loadData(rs);
            displayData();

            JOptionPane.showMessageDialog(null, "Record deleted successfully!");
        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to cancel?", "Are you sure", JOptionPane.YES_NO_OPTION);
        /*
         * 0 = yes
         * 1 = no
         */
        if (option == 0) {
            //House cleaning
            createSomeProp = false;
            readPropAll = false;
            updateSomeProp = false;
            deleteSomeProp = false;

            //Close connection to db before leaving this form
            try {
                if (conn != null || pstmt != null || rs != null) {
                    conn.close();
                    pstmt.close();
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            //Close this menu
            this.dispose();

            //Back to main menu
            MainMenu menu = new MainMenu();

            menu.setTitle("Corona Main Menu");
            menu.setOpacity((float) 0.9);
            menu.setBackground(new Color(0, 0, 0, 0));
            menu.setIconImage(Toolkit.getDefaultToolkit().
                    getImage(SetJFrame_Icon.class.getResource("/icons/icons8_House_100px.png")));
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);

            System.gc();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
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
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
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
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        setOpacity((float) 0.7);
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        setOpacity((float) 0.9);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
//        if (!Character.isLetterOrDigit(evt.getKeyChar())) {
//            evt.consume();
//        }
        search();
    }//GEN-LAST:event_txtSearchKeyTyped

    private void search() throws HeadlessException {
        String sql = "SELECT * FROM property WHERE UPPER(propertyType) LIKE ?"
                + " OR UPPER(addressNum) LIKE ?"
                + " OR UPPER(addressStreet) LIKE ?"
                + " OR UPPER(addressCity) LIKE ?"
                + " OR UPPER(addressCode) LIKE ?"
                + " OR UPPER(value) LIKE ?"
                + " OR UPPER(constructionStatus) LIKE ?"
                + " OR UPPER(useOfProperty) LIKE ?"
                + " OR UPPER(room) LIKE ?"
                + " OR UPPER(garage) LIKE ?"
                + " OR UPPER(bath) LIKE ?"
                + " OR UPPER(floorArea) LIKE ?"
                + " OR UPPER(landArea) LIKE ?"
                + " OR UPPER(rates) LIKE ?"
                //                + " OR UPPER(description) LIKE ?"
                + " OR UPPER(telephone) LIKE ?"
                + " OR UPPER(email) LIKE ?";
        //Connecting using ConnectUtil
        try {
            //Creating query
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE, Statement.RETURN_GENERATED_KEYS);

            for (int i = 1; i <= 16; i++) {
                pstmt.setString(i, "%" + txtSearch.getText().toUpperCase() + "%");
            }

            //Executing query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                loadData(rs);
                displayData();
            }
        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ocurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
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

    }//GEN-LAST:event_txtSearchKeyPressed

    public void autoComp(String searchKeyword) {
        String comp = "";
        ArrayList searchField = new ArrayList();
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
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel.
         * For details see
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
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDViewTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox<String> jComboBoxconstructionStatus;
    private javax.swing.JComboBox<String> jComboBoxpropertyType;
    private javax.swing.JComboBox<String> jComboBoxuseOfProperty;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerbath;
    private javax.swing.JSpinner jSpinnergarage;
    private javax.swing.JSpinner jSpinnerroom;
    private javax.swing.JTextArea jTextAreadescription;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblSearch;
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
