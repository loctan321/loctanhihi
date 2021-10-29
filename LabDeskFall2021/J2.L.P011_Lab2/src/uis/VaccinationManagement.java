/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis;

import dtos.RegistrationDTO;
import implement.RegistrationInterface;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import validation.checkValue;

/**
 *
 * @author ADMIN
 */
public class VaccinationManagement extends javax.swing.JFrame {

    private final String serviceName = "rmi://127.0.0.1:1080/RegistrationVaccinationService";
    private RegistrationInterface stub;
    private DefaultTableModel model;
    private Vector<String> header;
    private Vector<Vector> data = null;
    private boolean addNew = false;

    public VaccinationManagement() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        header = new Vector<>();
        header.add("ID");
        header.add("Full Name");
        header.add("Age");
        header.add("Gender");
        header.add("Phone");
        header.add("Address");
        model = new DefaultTableModel(data, header);
        tbl.setModel(model);
        beforeGet();
    }

    void beforeGet() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
        txtOccupation.setText("");
        txtPhone.setText("");
        txtIdCardNumber.setText("");
        txtHeathNum.setText("");
        txtAddress.setText("");
        txtWorkplace.setText("");
        rbYes.setSelected(true);
        rbNo.setSelected(false);
        txtObjectGroup.setText("");
        rbAgree.setSelected(true);
        rbDisagree.setSelected(false);

        txtId.setEnabled(false);
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        rbMale.setEnabled(false);
        rbFemale.setEnabled(false);
        txtOccupation.setEnabled(false);
        txtPhone.setEnabled(false);
        txtIdCardNumber.setEnabled(false);
        txtHeathNum.setEnabled(false);
        txtAddress.setEnabled(false);
        txtWorkplace.setEnabled(false);
        rbYes.setEnabled(false);
        rbNo.setEnabled(false);
        txtObjectGroup.setEnabled(false);
        rbAgree.setEnabled(false);
        rbDisagree.setEnabled(false);

        tbl.setEnabled(false);
        btnSearch.setEnabled(false);
        btnGetAllData.setEnabled(true);
        cbSort.setEnabled(false);
        btnSearchByName.setEnabled(false);
        txtSearchByName.setEnabled(false);
        btnAddNew.setEnabled(true);
        btnSave.setEnabled(false);
        btnRemove.setEnabled(false);
    }

    void afterGet() {

        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
        txtOccupation.setText("");
        txtPhone.setText("");
        txtIdCardNumber.setText("");
        txtHeathNum.setText("");
        txtAddress.setText("");
        txtWorkplace.setText("");
        rbYes.setSelected(true);
        rbNo.setSelected(false);
        txtObjectGroup.setText("");
        rbAgree.setSelected(true);
        rbDisagree.setSelected(false);

        txtId.setEnabled(true);
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        rbMale.setEnabled(false);
        rbFemale.setEnabled(false);
        txtOccupation.setEnabled(false);
        txtWorkplace.setEnabled(false);
        txtPhone.setEnabled(false);
        txtIdCardNumber.setEnabled(false);
        txtHeathNum.setEnabled(false);
        txtAddress.setEnabled(false);
        rbYes.setEnabled(false);
        rbNo.setEnabled(false);
        txtObjectGroup.setEnabled(false);
        rbAgree.setEnabled(false);
        rbDisagree.setEnabled(false);

        tbl.setEnabled(true);
        btnSearch.setEnabled(true);
        btnGetAllData.setEnabled(true);
        cbSort.setEnabled(true);
        btnSearchByName.setEnabled(true);
        txtSearchByName.setEnabled(true);
        btnAddNew.setEnabled(true);
        btnSave.setEnabled(false);
        btnRemove.setEnabled(false);

    }

    void whenAddNew() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
        txtOccupation.setText("");
        txtWorkplace.setText("");
        txtPhone.setText("");
        txtIdCardNumber.setText("");
        txtHeathNum.setText("");
        txtAddress.setText("");
        rbYes.setSelected(true);
        rbNo.setSelected(false);
        txtObjectGroup.setText("");
        rbAgree.setSelected(true);
        rbDisagree.setSelected(false);

        txtId.setEnabled(true);
        txtName.setEnabled(true);
        txtAge.setEnabled(true);
        rbMale.setEnabled(true);
        rbFemale.setEnabled(true);
        txtOccupation.setEnabled(true);
        txtWorkplace.setEnabled(true);
        txtPhone.setEnabled(true);
        txtIdCardNumber.setEnabled(true);
        txtHeathNum.setEnabled(true);
        txtAddress.setEnabled(true);
        rbYes.setEnabled(true);
        rbNo.setEnabled(true);
        txtObjectGroup.setEnabled(true);
        rbAgree.setEnabled(true);
        rbDisagree.setEnabled(true);

        tbl.setEnabled(false);
        tbl.clearSelection();
        btnSearch.setEnabled(false);
        btnGetAllData.setEnabled(false);
        cbSort.setEnabled(false);
        btnSave.setEnabled(true);
        btnRemove.setEnabled(false);
        btnSearchByName.setEnabled(true);
        txtSearchByName.setEnabled(true);
        btnAddNew.setEnabled(true);
       
    }

    void closeAddNew() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
        txtOccupation.setText("");
        txtWorkplace.setText("");
        txtPhone.setText("");
        txtIdCardNumber.setText("");
        txtHeathNum.setText("");
        txtAddress.setText("");
        rbYes.setSelected(true);
        rbNo.setSelected(false);
        txtObjectGroup.setText("");
        rbAgree.setSelected(true);
        rbDisagree.setSelected(false);
        btnAddNew.setText("Add new");
        addNew = false;

        txtId.setEnabled(true);
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        rbMale.setEnabled(false);
        rbFemale.setEnabled(false);
        txtOccupation.setEnabled(false);
        txtWorkplace.setEnabled(false);
        txtPhone.setEnabled(false);
        txtIdCardNumber.setEnabled(false);
        txtHeathNum.setEnabled(false);
        txtAddress.setEnabled(false);
        rbYes.setEnabled(false);
        rbNo.setEnabled(false);
        txtObjectGroup.setEnabled(false);
        rbAgree.setEnabled(false);
        rbDisagree.setEnabled(false);

        tbl.setEnabled(true);
        tbl.clearSelection();
        btnSearch.setEnabled(true);
        btnGetAllData.setEnabled(true);
        cbSort.setEnabled(true);
        btnSearchByName.setEnabled(true);
        txtSearchByName.setEnabled(true);
        btnAddNew.setEnabled(true);
        btnSave.setEnabled(true);
        btnRemove.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngGender = new javax.swing.ButtonGroup();
        btngConsent = new javax.swing.ButtonGroup();
        btngPermanent = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mainPart = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbSort = new javax.swing.JComboBox<>();
        txtSearchByName = new javax.swing.JTextField();
        btnGetAllData = new javax.swing.JButton();
        btnSearchByName = new javax.swing.JButton();
        detailedPart = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtOccupation = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtWorkplace = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIdCardNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHeathNum = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtObjectGroup = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        rbAgree = new javax.swing.JRadioButton();
        rbDisagree = new javax.swing.JRadioButton();
        btnAddNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        rbYes = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        txtAge = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vaccin Registration GUI");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vaccinnation Registration Information Management Software");

        mainPart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Main part", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 255))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        jLabel2.setText("Sort by name:");

        cbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        cbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSortActionPerformed(evt);
            }
        });

        btnGetAllData.setText("Get All Data");
        btnGetAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllDataActionPerformed(evt);
            }
        });

        btnSearchByName.setText("Search by name:");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGetAllData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSearchByName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbSort, 0, 170, Short.MAX_VALUE)
                    .addComponent(txtSearchByName))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchByName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGetAllData)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPartLayout = new javax.swing.GroupLayout(mainPart);
        mainPart.setLayout(mainPartLayout);
        mainPartLayout.setHorizontalGroup(
            mainPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPartLayout.setVerticalGroup(
            mainPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        detailedPart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detailed part\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 255))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Registration ID:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Full name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Age:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Gender:");

        btngGender.add(rbMale);
        rbMale.setText("Male");

        btngGender.add(rbFemale);
        rbFemale.setText("Female");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Occupation:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Workplace:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Phone:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("ID card number:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Heath insurance number:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Address:");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Pemanent residence:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Object group:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Consent to vaccintation:");

        btngConsent.add(rbAgree);
        rbAgree.setText("Agree");

        btngConsent.add(rbDisagree);
        rbDisagree.setText("Disagree");

        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btngPermanent.add(rbYes);
        rbYes.setText("Yes");

        btngPermanent.add(rbNo);
        rbNo.setText("No");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtId)
                                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSearch)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtWorkplace)))
                                .addGap(34, 34, 34))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone)
                                    .addComponent(txtIdCardNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddNew))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rbAgree)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbDisagree))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rbYes)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbNo)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtHeathNum, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtObjectGroup, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(btnRemove)
                                .addGap(110, 110, 110))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(rbMale)
                        .addComponent(rbFemale)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWorkplace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHeathNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rbYes)
                    .addComponent(rbNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtObjectGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAgree)
                    .addComponent(rbDisagree))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNew)
                    .addComponent(btnSave)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout detailedPartLayout = new javax.swing.GroupLayout(detailedPart);
        detailedPart.setLayout(detailedPartLayout);
        detailedPartLayout.setHorizontalGroup(
            detailedPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        detailedPartLayout.setVerticalGroup(
            detailedPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(mainPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailedPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mainPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(detailedPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private boolean connectToServer() {
        try {
            stub = (RegistrationInterface) Naming.lookup(serviceName);
            if (stub == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private void cbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSortActionPerformed
        // TODO add your handling code here:
        int pos = cbSort.getSelectedIndex();
        if (connectToServer()) {
            ArrayList<RegistrationDTO> listArr = null;
            try {
                listArr = stub.findAllRegistrations();
                Collections.sort(listArr);
                if (pos == 0) {
                    Collections.reverse(listArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            data = null;
            data = loadData(listArr);
            model = new DefaultTableModel(data, header);
            tbl.setModel(model);
        } else {
            JOptionPane.showMessageDialog(this, "Can not connect to server");
        }

    }//GEN-LAST:event_cbSortActionPerformed

    private Vector loadData(ArrayList<RegistrationDTO> listArr) {

        Vector list = new Vector();
        Vector<String> obj = null;

        for (RegistrationDTO dto : listArr) {
            obj = new Vector<>();
            String gender = dto.isGender() ? "Male" : "Female";
            obj.add(dto.getRegistrationID());
            obj.add(dto.getFullName());
            obj.add(dto.getAge() + "");
            obj.add(gender);
            obj.add(dto.getPhone());
            obj.add(dto.getAddress());
            list.add(obj);
        }
        return list;
    }
    private void btnGetAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllDataActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.getDataVector().removeAllElements();
        if (connectToServer()) {
            ArrayList<RegistrationDTO> listArr = null;
            try {
                listArr = stub.findAllRegistrations();
                if (listArr.isEmpty() || listArr == null) {
                    tbl.updateUI();
                    JOptionPane.showMessageDialog(null, "FILE 'RegistrationData.txt' has no data");
                    beforeGet();
                } else {
                    data = loadData(listArr);
                    model = new DefaultTableModel(data, header);
                    tbl.setModel(model);
                    afterGet();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Can not connect to server");
        }

    }//GEN-LAST:event_btnGetAllDataActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (!connectToServer()) {
            JOptionPane.showMessageDialog(this, "Can not connect to server");
        }
        String registrationID = txtId.getText().trim(),
                fullName = txtName.getText().trim(),
                age = txtAge.getText().trim(),
                occupation = txtOccupation.getText().trim(),
                phone = txtPhone.getText().trim(),
                idCardNumber = txtIdCardNumber.getText().trim(),
                healthInsuranceNumber = txtHeathNum.getText().trim(),
                address = txtAddress.getText().replaceAll("\\s\\s+", " ").trim(),
                workwplace = txtWorkplace.getText().trim(),
                objectGroup = txtObjectGroup.getText().trim();
        boolean gender = rbMale.isSelected() ? true : false;
        boolean permanentResidence = rbYes.isSelected() ? true : false;
        boolean consentToVaccination = rbAgree.isSelected() ? true : false;

        boolean check = checkValue.checkRegistrationID(registrationID)
                && checkValue.checkfullName(fullName)
                && checkValue.checkAge(age)
                && checkValue.checkPhone(phone)
                && checkValue.checkNumber(idCardNumber)
                && checkValue.checkNumber(healthInsuranceNumber);
        if (addNew) {
            try {
                if (registrationID.isEmpty() || fullName.isEmpty() || age.isEmpty() || occupation.isEmpty() || phone.isEmpty() || idCardNumber.isEmpty() || healthInsuranceNumber.isEmpty() || address.isEmpty() || workwplace.isEmpty() || objectGroup.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "have not entered enough information");
                    return;
                } else if (!check) {
                    if (!checkValue.checkRegistrationID(registrationID)) {
                        JOptionPane.showMessageDialog(null, "RegistrationID max length is 10, not contains special characters");
                        txtId.setText("");
                    } else if (!checkValue.checkfullName(fullName)) {
                        JOptionPane.showMessageDialog(null, "FullName max length is 50 and not a number");
                        txtName.setText("");
                    } else if (!checkValue.checkAge(age)) {
                        JOptionPane.showMessageDialog(null, "Age must be >= 18");
                        txtAge.setText("");
                    } else if (!checkValue.checkPhone(phone)) {
                        JOptionPane.showMessageDialog(null, "Phone max length is 15, contain numeric characters only (0-9)");
                        txtPhone.setText("");
                    } else if (!checkValue.checkNumber(idCardNumber)) {
                        JOptionPane.showMessageDialog(null, "Number of idcard must be >= 0");
                        txtIdCardNumber.setText("");
                    } else if (!checkValue.checkNumber(healthInsuranceNumber)) {
                        JOptionPane.showMessageDialog(null, "Number of healthNum must be >= 0");
                        txtIdCardNumber.setText("");
                    }
                    return;
                } else if (stub.findByRegistrationID(registrationID) != null) {
                    JOptionPane.showMessageDialog(null, "id already exists");
                    txtId.setText("");
                    return;
                } else {
                    stub.createRegistration(new RegistrationDTO(registrationID, fullName, occupation, phone, idCardNumber, healthInsuranceNumber, address, workwplace, objectGroup, Integer.parseInt(age), gender, permanentResidence, consentToVaccination));
                    JOptionPane.showMessageDialog(null, "Add new successfully");

                    txtId.setEnabled(true);
                    txtId.setText("");
                    txtName.setText("");
                    txtAge.setText("");
                    rbMale.setSelected(true);
                    rbFemale.setSelected(false);
                    txtOccupation.setText("");
                    txtWorkplace.setText("");
                    txtPhone.setText("");
                    txtIdCardNumber.setText("");
                    txtHeathNum.setText("");
                    txtAddress.setText("");
                    rbYes.setSelected(true);
                    rbNo.setSelected(false);
                    txtObjectGroup.setText("");
                    rbAgree.setSelected(true);
                    rbDisagree.setSelected(false);
                    btnAddNew.setText("Add new");

                }

            } catch (RemoteException ex) {
                Logger.getLogger(VaccinationManagement.class.getName()).log(Level.SEVERE, null, ex);

            }
            closeAddNew();
            btnGetAllDataActionPerformed(null);
        } else {
            try {
                if (fullName.isEmpty() || age.isEmpty() || occupation.isEmpty() || phone.isEmpty() || idCardNumber.isEmpty() || healthInsuranceNumber.isEmpty() || address.isEmpty() || workwplace.isEmpty() || objectGroup.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "have not entered enough information");
                    return;
                } else if (!check) {
                    if (!checkValue.checkRegistrationID(registrationID)) {
                        JOptionPane.showMessageDialog(null, "RegistrationID max length is 10, not contains special characters");
                        txtId.setText("");
                    } else if (!checkValue.checkfullName(fullName)) {
                        JOptionPane.showMessageDialog(null, "FullName max length is 50 and not a number");
                        txtName.setText("");
                    } else if (!checkValue.checkAge(age)) {
                        JOptionPane.showMessageDialog(null, "Age must be >= 18");
                        txtAge.setText("");
                    } else if (!checkValue.checkPhone(phone)) {
                        JOptionPane.showMessageDialog(null, "Phone max length is 15, contain numeric characters only (0-9)");
                        txtPhone.setText("");
                    } else if (!checkValue.checkNumber(idCardNumber)) {
                        JOptionPane.showMessageDialog(null, "Number of idcard must be >= 0");
                        txtIdCardNumber.setText("");
                    } else if (!checkValue.checkNumber(healthInsuranceNumber)) {
                        JOptionPane.showMessageDialog(null, "Number of healthNum must be >= 0");
                        txtIdCardNumber.setText("");
                    }
                    return;
                } else {
                    stub.updateRegistration(new RegistrationDTO(registrationID, fullName, occupation, phone, idCardNumber, healthInsuranceNumber, address, workwplace, objectGroup, Integer.parseInt(age), gender, permanentResidence, consentToVaccination));
                    JOptionPane.showMessageDialog(null, "Update successfully");
                    btnGetAllDataActionPerformed(null);

                    tbl.clearSelection();
                    txtId.setText("");
                    txtName.setText("");
                    txtAge.setText("");
                    rbMale.setSelected(true);
                    rbFemale.setSelected(false);
                    txtOccupation.setText("");
                    txtWorkplace.setText("");
                    txtPhone.setText("");
                    txtIdCardNumber.setText("");
                    txtHeathNum.setText("");
                    txtAddress.setText("");
                    rbYes.setSelected(true);
                    rbNo.setSelected(false);
                    txtObjectGroup.setText("");
                    rbAgree.setSelected(true);
                    rbDisagree.setSelected(false);

                    txtId.setEnabled(true);
                    txtName.setEnabled(false);
                    txtAge.setEnabled(false);
                    rbMale.setEnabled(false);
                    rbFemale.setEnabled(false);
                    txtOccupation.setEnabled(false);
                    txtWorkplace.setEnabled(false);
                    txtPhone.setEnabled(false);
                    txtIdCardNumber.setEnabled(false);
                    txtHeathNum.setEnabled(false);
                    txtAddress.setEnabled(false);
                    rbYes.setEnabled(false);
                    rbNo.setEnabled(false);
                    txtObjectGroup.setEnabled(false);
                    rbAgree.setEnabled(false);
                    rbDisagree.setEnabled(false);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        
        if (addNew == false) {
            addNew = true;
            tbl.setModel(model);
            whenAddNew();
            
            btnAddNew.setText("Cancel");
           
        } else if (addNew) {
            addNew = false;
            btnGetAllDataActionPerformed(evt);
            closeAddNew();
        }

    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (!connectToServer()) {
            JOptionPane.showMessageDialog(this, "Can not connect to server");
        }
        try {
            String registrationID = txtId.getText();
            if (checkValue.checkRegistrationID(registrationID)) {
                RegistrationDTO dto = stub.findByRegistrationID(registrationID);
                if (dto == null) {
                    JOptionPane.showMessageDialog(null, "id does not exist");
                    txtId.setText("");
                    txtId.requestFocus();
                } else {
                    System.out.println(dto.isGender());
                    System.out.println(dto.isPermanentResidence());
                    System.out.println(dto.isConsentToVaccination());
                    addNew = false;
                    txtId.setEditable(true);
                    txtName.setText(dto.getFullName());
                    txtAge.setText(dto.getAge() + "");
                    if (dto.isGender()) {
                        rbMale.setSelected(true);
                        rbFemale.setSelected(false);
                    } else {
                        rbMale.setSelected(false);
                        rbFemale.setSelected(true);
                    }
                    txtOccupation.setText(dto.getOccupation());
                    txtPhone.setText(dto.getPhone());
                    txtIdCardNumber.setText(dto.getIdCardNumber());
                    txtHeathNum.setText(dto.getHealthInsuranceNumber());
                    txtAddress.setText(dto.getAddress());
                    txtWorkplace.setText(dto.getWorkplace());
                    if (dto.isPermanentResidence()) {
                        rbYes.setSelected(true);
                        rbNo.setSelected(false);
                    } else {
                        rbYes.setSelected(false);
                        rbNo.setSelected(true);
                    }
                    txtObjectGroup.setText(dto.getObjectGroup());
                    if (dto.isConsentToVaccination()) {
                        rbAgree.setSelected(true);
                        rbDisagree.setSelected(false);
                    } else {
                        rbAgree.setSelected(false);
                        rbDisagree.setSelected(true);
                    }

                    txtId.setEnabled(false);
                    txtName.setEnabled(true);
                    txtAge.setEnabled(true);
                    rbMale.setEnabled(true);
                    rbFemale.setEnabled(true);
                    txtOccupation.setEnabled(true);
                    txtPhone.setEnabled(true);
                    txtIdCardNumber.setEnabled(true);
                    txtHeathNum.setEnabled(true);
                    txtAddress.setEnabled(true);
                    txtWorkplace.setEnabled(true);
                    rbYes.setEnabled(true);
                    rbNo.setEnabled(true);
                    txtObjectGroup.setEnabled(true);
                    rbAgree.setEnabled(true);
                    rbDisagree.setEnabled(true);
                    btnSave.setEnabled(true);
                    btnRemove.setEnabled(true);

                }

            } else {
                JOptionPane.showMessageDialog(null, " max length is 10 and not contains special characters (@, #, $)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        // TODO add your handling code here:
        String name = txtSearchByName.getText();
        if (connectToServer()) {
            ArrayList<RegistrationDTO> listArr = new ArrayList();
            try {
                for (RegistrationDTO obj : stub.findAllRegistrations()) {
                    if (obj.getFullName().indexOf(name) >= 0) {
                        listArr.add(obj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (listArr.size() == 0) {
                JOptionPane.showMessageDialog(this, "Not found");
                txtSearchByName.setText("");
                return;
            }
            Vector<Vector> list = new Vector<>();
            Vector obj = null;
            for (RegistrationDTO dto : listArr) {
                obj = new Vector<>();
                String gender = dto.isGender() ? "Male" : "Female";
                obj.add(dto.getRegistrationID());
                obj.add(dto.getFullName());
                obj.add(dto.getAge() + "");
                obj.add(gender);
                obj.add(dto.getPhone());
                obj.add(dto.getAddress());
                list.add(obj);
            }

            model = new DefaultTableModel(list, header);
            tbl.setModel(model);
            txtSearchByName.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Can not connect to server");
        }


    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if (connectToServer()) {
            try {
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to REMOVE?", "REMOVE ARMOR", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    stub.removeRegistration(txtId.getText());
                    btnGetAllDataActionPerformed(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Can not connect to server");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        // TODO add your handling code here:
        int row = tbl.getSelectedRow();
        if (!connectToServer()) {
            JOptionPane.showMessageDialog(this, "Can not connect to server");
        }
        try {
            RegistrationDTO dto;
            if ((dto = stub.findByRegistrationID(tbl.getValueAt(row, 0).toString())) != null) {
                addNew = false;
                txtId.setEnabled(false);
                txtId.setText(dto.getRegistrationID());
                txtName.setText(dto.getFullName());
                if (dto.isGender()) {
                    rbMale.setSelected(true);
                    rbFemale.setSelected(false);
                } else {
                    rbMale.setSelected(false);
                    rbFemale.setSelected(true);
                }
                txtAge.setText(dto.getAge()+"");
                txtOccupation.setText(dto.getOccupation());
                txtPhone.setText(dto.getPhone());
                txtIdCardNumber.setText(dto.getIdCardNumber());
                txtHeathNum.setText(dto.getHealthInsuranceNumber());
                txtAddress.setText(dto.getAddress());
                txtWorkplace.setText(dto.getWorkplace());
                if (dto.isPermanentResidence()) {
                    rbYes.setSelected(true);
                    rbNo.setSelected(false);
                } else {
                    rbYes.setSelected(false);
                    rbNo.setSelected(true);
                }
                txtObjectGroup.setText(dto.getObjectGroup());
                if (dto.isConsentToVaccination()) {
                    rbAgree.setSelected(true);
                    rbDisagree.setSelected(false);
                } else {
                    rbAgree.setSelected(false);
                    rbDisagree.setSelected(true);
                }
                
                txtId.setEnabled(false);
                txtName.setEnabled(true);
                txtAge.setEnabled(true);
                rbMale.setEnabled(true);
                rbFemale.setEnabled(true);
                txtOccupation.setEditable(true);
                txtPhone.setEnabled(true);
                txtIdCardNumber.setEnabled(true);
                txtHeathNum.setEnabled(true);
                txtAddress.setEnabled(true);
                txtWorkplace.setEnabled(true);
                rbYes.setEnabled(true);
                rbNo.setEnabled(true);
                txtObjectGroup.setEnabled(true);
                rbAgree.setEnabled(true);
                rbDisagree.setEnabled(true);
                btnSave.setEnabled(true);
                btnRemove.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "Not find id, maybe data is changed");
                btnSearchActionPerformed(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblMouseClicked

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
            java.util.logging.Logger.getLogger(VaccinationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VaccinationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VaccinationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VaccinationManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VaccinationManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnGetAllData;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.ButtonGroup btngConsent;
    private javax.swing.ButtonGroup btngGender;
    private javax.swing.ButtonGroup btngPermanent;
    private javax.swing.JComboBox<String> cbSort;
    private javax.swing.JPanel detailedPart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPart;
    private javax.swing.JRadioButton rbAgree;
    private javax.swing.JRadioButton rbDisagree;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbYes;
    private javax.swing.JTable tbl;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtHeathNum;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCardNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtObjectGroup;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearchByName;
    private javax.swing.JTextField txtWorkplace;
    // End of variables declaration//GEN-END:variables
}
