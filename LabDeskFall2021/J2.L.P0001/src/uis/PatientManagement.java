/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis;

import dtos.PantientDTO;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import validation.checkValue;
import daos.PatientDAO;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class PatientManagement extends javax.swing.JFrame {

    private ArrayList<PantientDTO> listPatient = new ArrayList<>();
    int index = -1;
    boolean createNew = false;
    Vector<String> header = new Vector<>();
    Vector data = new Vector();
    int pos = -1;
    PatientDAO daos = new PatientDAO();
    boolean checkFind = false;
    private DefaultTableModel dtm;

    public PatientManagement() {
        initComponents();
        getData();
        header.add("ID");
        header.add("Fullname");
        header.add("Age");
        header.add("Gender");
        header.add("Phone");
        header.add("Address");

        dtm = (DefaultTableModel) tbl.getModel();
        dtm.setDataVector(data, header);
        
        
        
        txtId.setEnabled(false);
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        txtGender.setEnabled(false);
        txtOccupation.setEnabled(false);
        txtWorkplace.setEnabled(false);
        txtPhone.setEnabled(false);
        txtAddress.setEnabled(false);
        txtHeathNum.setEnabled(false);
        txtSymton.setEnabled(false);

    }

    private void getData() {
        if (listPatient == null) {
            listPatient = new ArrayList<>();
        }
        listPatient = daos.getPantientDTOs();
    }

    boolean checkUpdateStatus() {

        try {
            if (index >= 0) {
                String patientID = txtId.getText().trim();
                String patientName = txtName.getText().trim();
                String age = txtAge.getText().trim();
                String gender = txtGender.getText().trim();
                String occupation = txtOccupation.getText().trim();
                String workwplace = txtWorkplace.getText().trim();
                String phone = txtPhone.getText().trim();
                String address = txtAddress.getText().trim();
                String healthInsuranceNumber = txtHeathNum.getText().trim();
                String symton = txtSymton.getText().trim();

                for (PantientDTO pantient : listPatient) {
                    if (patientID.equals(pantient.getPatientID())) {
                        if (!patientName.equals(pantient.getPatientName())
                                || !age.equals(pantient.getAge())
                                || !gender.equals(pantient.getGender())
                                || !occupation.equals(pantient.getOccupation())
                                || !workwplace.equals(pantient.getWorkplace())
                                || !phone.equals(pantient.getPhone())
                                || !address.equals(pantient.getAddress())
                                || !healthInsuranceNumber.equals(pantient.getHealthInsuranceNumber())
                                || !symton.equals(pantient.getSymptom())) {
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    int checkIDTR(String patientID) {
        int checkID = -1;
        for (int i = 0; i < listPatient.size(); i++) {
            if (patientID.equals(listPatient.get(i).getPatientID())) {
                checkID = i;
            }
        }
        return checkID;
    }

    void whenAddNew() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtGender.setText("");
        txtOccupation.setText("");
        txtWorkplace.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtHeathNum.setText("");
        txtSymton.setText("");

        txtId.setEnabled(true);
        txtName.setEnabled(true);
        txtAge.setEnabled(true);
        txtGender.setEnabled(true);
        txtOccupation.setEnabled(true);
        txtWorkplace.setEnabled(true);
        txtPhone.setEnabled(true);
        txtAddress.setEnabled(true);
        txtHeathNum.setEnabled(true);
        txtSymton.setEnabled(true);

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
        btnGetAllData.setEnabled(true);

    }

    void whenClick() {
        txtId.setEnabled(false);
        txtName.setEnabled(true);
        txtAge.setEnabled(true);
        txtGender.setEnabled(true);
        txtPhone.setEnabled(true);
        txtAddress.setEnabled(true);
        txtOccupation.setEnabled(true);
        txtWorkplace.setEnabled(true);
        txtHeathNum.setEnabled(true);
        txtSymton.setEnabled(true);
        btnAddNew.setEnabled(true);
        btnGetAllData.setEnabled(true);
        btnSave.setEnabled(true);
        btnSearchByName.setEnabled(true);
        tbl.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
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
        jLabel8 = new javax.swing.JLabel();
        txtOccupation = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtWorkplace = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHeathNum = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btnAddNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txtAge = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSymton = new javax.swing.JTextArea();
        txtGender = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient  GUI");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient Information Management Software");

        mainPart.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Main part", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 255))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Phone", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.getTableHeader().setReorderingAllowed(false);
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
                .addGap(0, 60, Short.MAX_VALUE))
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
        jLabel4.setText("Patient ID:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Patient name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Age:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Gender:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Occupation:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Workplace:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Phone:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Heath insurance number:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Address:");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Symton:");

        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnSave.setText("Update");
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

        txtSymton.setColumns(20);
        txtSymton.setRows(5);
        jScrollPane3.setViewportView(txtSymton);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtWorkplace))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtId)
                                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSearch)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(34, 34, 34))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(btnRemove)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHeathNum, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHeathNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
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

    private void cbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSortActionPerformed
        // TODO add your handling code here:
        int pos1 = cbSort.getSelectedIndex();
       

        if (listPatient.isEmpty()) {
            JOptionPane.showMessageDialog(null, "List is empty");
        } else {

            try {
                Collections.sort(listPatient, new Comparator<PantientDTO>() {
                    @Override
                    public int compare(PantientDTO sv1, PantientDTO sv2) {
                        return (sv2.getPatientName().compareTo(sv1.getPatientName()));

                    }
                });

                if (pos1 == 0) {
                    Collections.reverse(listPatient);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            data = null;
            data = load((ArrayList<PantientDTO>) listPatient);
            dtm = new DefaultTableModel(data, header);
            tbl.setModel(dtm);

        }


    }//GEN-LAST:event_cbSortActionPerformed
    private Vector load(ArrayList<PantientDTO> listPatient) {

        Vector list = new Vector();
        Vector<String> obj = null;

        for (PantientDTO dto : listPatient) {
            obj = new Vector<>();

            obj.add(dto.getPatientID());
            obj.add(dto.getPatientName());
            obj.add(dto.getAge());
            obj.add(dto.getGender());
            obj.add(dto.getOccupation());
            obj.add(dto.getWorkplace());
            obj.add(dto.getPhone());
            obj.add(dto.getAddress());
            obj.add(dto.getHealthInsuranceNumber());
            obj.add(dto.getSymptom());
            list.add(obj);
        }
        return list;
    }


    private void btnGetAllDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllDataActionPerformed
        //TODO add your handling code here:
        if (!checkUpdateStatus()) {
            JOptionPane.showMessageDialog(null, "don't finish UPDATE");
            return;
        } else {
            index = -1;
            tbl.clearSelection();
            DefaultTableModel model = (DefaultTableModel) tbl.getModel();
            model.getDataVector().removeAllElements();
            for (PantientDTO patient : listPatient) {
                Vector row = new Vector();
                row.add(patient.getPatientID());
                row.add(patient.getPatientName());
                row.add(patient.getAge());
                row.add(patient.getGender());
                row.add(patient.getPhone());
                row.add(patient.getAddress());

                model.addRow(row);
            }
            txtId.setText("");
            txtName.setText("");
            txtAge.setText("");
            txtGender.setText("");
            txtOccupation.setText("");
            txtWorkplace.setText("");
            txtPhone.setText("");
            txtAddress.setText("");
            txtHeathNum.setText("");
            txtSymton.setText("");

            txtId.setEnabled(true);
            txtAge.setEnabled(false);
            txtGender.setEnabled(false);
            txtOccupation.setEnabled(false);
            txtWorkplace.setEnabled(false);
            txtPhone.setEnabled(false);
            txtAddress.setEnabled(false);
            txtHeathNum.setEnabled(false);
            txtHeathNum.setEnabled(false);

            btnAddNew.setEnabled(true);
            btnSearch.setEnabled(true);
            btnGetAllData.setEnabled(true);
            btnRemove.setEnabled(true);
            btnSave.setEnabled(true);
            btnSearchByName.setEnabled(true);
            tbl.setEnabled(true);
            tbl.updateUI();

        }


    }//GEN-LAST:event_btnGetAllDataActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
       index = tbl.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "have not selected a row to delete");
        }
        else{
            try {
                        String patientID = txtId.getText().trim();
                        String patientName = txtName.getText().trim();
                        String age = txtAge.getText().trim();
                        String gender = txtGender.getText().trim();
                        String occupation = txtOccupation.getText().trim();
                        String workplace = txtWorkplace.getText().trim();
                        String phone = txtPhone.getText().trim();
                        String address = txtAddress.getText().trim();
                        String healthInsuranceNumber = txtHeathNum.getText().trim();
                        String symptom = txtSymton.getText().trim();

                        boolean check = checkValue.checkPatientID(patientID)
                                && checkValue.checkfullName(patientName)
                                && checkValue.checkAge(age)
                                && checkValue.checkPhone(phone);

                        if (patientID.isEmpty() || patientName.isEmpty()
                                || age.isEmpty() || gender.isEmpty() || occupation.isEmpty()
                                || workplace.isEmpty() || phone.isEmpty() || address.isEmpty()
                                || healthInsuranceNumber.isEmpty() || symptom.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "have not entered enough information");
                            return;
                        } else if (!check) {
                            if (!checkValue.checkPatientID(patientID)) {
                                JOptionPane.showMessageDialog(null, "patientID: max length is 10 and not contains special characters (@, #, $)");
                                txtId.setText("");
                                txtId.requestFocus();
                            } else if (!checkValue.checkfullName(patientName)) {
                                JOptionPane.showMessageDialog(null, "FullName: max length is 30");
                                txtName.setText("");
                                txtName.requestFocus();
                            } else if (!checkValue.checkAge(age)) {
                                JOptionPane.showMessageDialog(null, "Age: number > 0");
                                txtAge.setText("");
                                txtAge.requestFocus();
                            } else if (!checkValue.checkPhone(phone)) {
                                JOptionPane.showMessageDialog(null, "Phone: max length 15, contain numeric characters only (0 – 9)");
                                txtPhone.setText("");
                                txtPhone.requestFocus();
                            }

                            return;
                        } 
                         else {
                           for (PantientDTO pantient : listPatient) {
                        if (patientID.equals(pantient.getPatientID())) {
                            pantient.setPatientName(patientName);
                            pantient.setAge(age);
                            pantient.setGender(gender);
                            pantient.setOccupation(occupation);
                            pantient.setWorkplace(workplace);
                            pantient.setPhone(phone);
                            pantient.setAddress(address);
                            pantient.setHealthInsuranceNumber(healthInsuranceNumber);
                            pantient.setSymptom(symptom);
                          
                        }
                    }
                    JOptionPane.showMessageDialog(null, "update successfully");
                    btnGetAllDataActionPerformed(null);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        if (!checkUpdateStatus() && createNew == false) {
            JOptionPane.showMessageDialog(null, " don't finish UPDATE");
            index = tbl.getSelectedRow();
            return;
        } else {
            cbSort.setEnabled(true);
            if (createNew == false) {
                createNew = true;
                whenAddNew();
                btnAddNew.setText("Save");
            } else if (createNew) {
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to SAVE?", "SAVE", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    try {
                        String patientID = txtId.getText().trim();
                        String patientName = txtName.getText().trim();
                        String age = txtAge.getText().trim();
                        String gender = txtGender.getText().trim();
                        String occupation = txtOccupation.getText().trim();
                        String workplace = txtWorkplace.getText().trim();
                        String phone = txtPhone.getText().trim();
                        String address = txtAddress.getText().trim();
                        String healthInsuranceNumber = txtHeathNum.getText().trim();
                        String symptom = txtSymton.getText().trim();

                        boolean check = checkValue.checkPatientID(patientID)
                                && checkValue.checkfullName(patientName)
                                && checkValue.checkAge(age)
                                && checkValue.checkPhone(phone);

                        if (patientID.isEmpty() || patientName.isEmpty()
                                || age.isEmpty() || gender.isEmpty() || occupation.isEmpty()
                                || workplace.isEmpty() || phone.isEmpty() || address.isEmpty()
                                || healthInsuranceNumber.isEmpty() || symptom.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "have not entered enough information");
                            return;
                        } else if (!check) {
                            if (!checkValue.checkPatientID(patientID)) {
                                JOptionPane.showMessageDialog(null, "patientID: max length is 10 and not contains special characters (@, #, $)");
                                txtId.setText("");
                                txtId.requestFocus();
                            } else if (!checkValue.checkfullName(patientName)) {
                                JOptionPane.showMessageDialog(null, "FullName: max length is 30");
                                txtName.setText("");
                                txtName.requestFocus();
                            } else if (!checkValue.checkAge(age)) {
                                JOptionPane.showMessageDialog(null, "Age: number > 0");
                                txtAge.setText("");
                                txtAge.requestFocus();
                            } else if (!checkValue.checkPhone(phone)) {
                                JOptionPane.showMessageDialog(null, "Phone: max length 15, contain numeric characters only (0 – 9)");
                                txtPhone.setText("");
                                txtPhone.requestFocus();
                            }

                            return;
                        } else if (checkIDTR(patientID) != -1) {
                            JOptionPane.showMessageDialog(null, "id already exists");
                        } else {
                            PantientDTO patient = new PantientDTO(patientID, patientName, age, gender, occupation, workplace, phone, address, healthInsuranceNumber, symptom);
                            listPatient.add(patient);
                            JOptionPane.showMessageDialog(null, "created successfully");

                            btnAddNew.setText("Create New");
                            createNew = false;
                            btnGetAllDataActionPerformed(null);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (ans == JOptionPane.NO_OPTION) {
                    btnAddNew.setText("Create New");
                    createNew = false;
                    btnGetAllDataActionPerformed(null);
                }

            }

        }


    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String id = txtId.getText();

        if (listPatient.isEmpty()) {
            JOptionPane.showMessageDialog(null, "List is empty");
        } else {
            pos = daos.findID(id);
            if (pos < 0) {
                JOptionPane.showMessageDialog(null, "Patient is not exist");
            } else {
                PantientDTO pan = listPatient.get(pos);
                txtId.setText(pan.getPatientID());
                txtName.setText(pan.getPatientName());
                txtAge.setText(pan.getAge());
                txtGender.setText(pan.getGender());
                txtOccupation.setText(pan.getOccupation());
                txtWorkplace.setText(pan.getWorkplace());
                txtPhone.setText(pan.getPhone());
                txtAddress.setText(pan.getAddress());
                txtHeathNum.setText(pan.getHealthInsuranceNumber());
                txtSymton.setText(pan.getSymptom());
                data.removeAllElements();
                Vector<String> v = new Vector();
                v.add(pan.getPatientID());
                v.add(pan.getPatientName());
                v.add(pan.getAge());
                v.add(pan.getGender());
                v.add(pan.getPhone());
                v.add(pan.getAddress());

                data.add(v);
                tbl.updateUI();
                checkFind = true;
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        // TODO add your handling code here:
        String name = txtSearchByName.getText();

        if (listPatient.isEmpty()) {
            JOptionPane.showMessageDialog(null, "List is empty");
        } else {
            pos = daos.findByName(name);
            if (pos < 0) {
                JOptionPane.showMessageDialog(null, "Patient is not exist");
            } else {
                PantientDTO pan = listPatient.get(pos);
                txtId.setText(pan.getPatientID());
                txtName.setText(pan.getPatientName());
                txtAge.setText(pan.getAge());
                txtGender.setText(pan.getGender());
                txtOccupation.setText(pan.getOccupation());
                txtWorkplace.setText(pan.getWorkplace());
                txtPhone.setText(pan.getPhone());
                txtAddress.setText(pan.getAddress());
                txtHeathNum.setText(pan.getHealthInsuranceNumber());
                txtSymton.setText(pan.getSymptom());
                data.removeAllElements();
                Vector<String> v = new Vector();
                v.add(pan.getPatientID());
                v.add(pan.getPatientName());
                v.add(pan.getAge());
                v.add(pan.getGender());
                v.add(pan.getPhone());
                v.add(pan.getAddress());

                data.add(v);
                tbl.updateUI();
                checkFind = true;
            }
        }


    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int indexDel = tbl.getSelectedRow();
        if (indexDel < 0) {
            JOptionPane.showMessageDialog(null, "have not selected a row to delete");
        } else if (!checkUpdateStatus()) {
            JOptionPane.showMessageDialog(null, " don't finish UPDATE");
            return;
        } else {
            try {
                String idGet = txtId.getText();
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to REMOVE?", "REMOVE ARMOR", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    if (checkIDTR(idGet) != -1) {
                        listPatient.remove(checkIDTR(idGet));
                        JOptionPane.showMessageDialog(null, "deleted successfully");
                        btnGetAllDataActionPerformed(null);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        // TODO add your handling code here:
        if (!checkUpdateStatus() && !createNew) {
            JOptionPane.showMessageDialog(null, "don't finish UPDATE");
            return;
        } else {
            index = tbl.getSelectedRow();
            if (index >= 0) {
                whenClick();
                try {
                    txtId.setText(listPatient.get(index).getPatientID());
                    txtName.setText(listPatient.get(index).getPatientName());
                    txtAge.setText(listPatient.get(index).getAge() + " ");
                    txtGender.setText(listPatient.get(index).getGender());
                    txtPhone.setText(listPatient.get(index).getPhone());
                    txtAddress.setText(listPatient.get(index).getAddress());
                    txtWorkplace.setText(listPatient.get(index).getWorkplace());
                    txtSymton.setText(listPatient.get(index).getSymptom());
                    txtOccupation.setText(listPatient.get(index).getOccupation());
                    txtHeathNum.setText(listPatient.get(index).getHealthInsuranceNumber());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientManagement().setVisible(true);
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
    private javax.swing.JComboBox<String> cbSort;
    private javax.swing.JPanel detailedPart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPart;
    private javax.swing.JTable tbl;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtHeathNum;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearchByName;
    private javax.swing.JTextArea txtSymton;
    private javax.swing.JTextField txtWorkplace;
    // End of variables declaration//GEN-END:variables
}
