/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.gui;


import loc.dao.CategoryDAO;
import loc.dao.FoodDAO;
import loc.dto.Category;
import loc.dto.Food;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FoodManagement extends javax.swing.JDialog {

    /**
     * Creates new form FoodManagement
     */
    
    ArrayList<Category> listCategory;
    ArrayList<Food> listFood;
    boolean addNewCategory = false;
    boolean addNewFood = false;
    int indexCategory = -1;
    int indexFood = -1;
    DefaultComboBoxModel comboBoxCategoryName = new DefaultComboBoxModel();
    UsersLogin ul;    
    

    
    public FoodManagement(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ul = (UsersLogin) parent;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        loadCategory();
        resetStatusCategory();
        loadFood();
        resetStatusFood();
    }

    
     void loadCategory() {
        indexCategory = -1;
        try {
            listCategory = CategoryDAO.getsCategory();
            DefaultTableModel modelCategory = (DefaultTableModel) tblCategory.getModel();
            modelCategory.getDataVector().removeAllElements();
            for (Category category : listCategory) {
                Vector row = new Vector();
                row.add(category.getCategoryID());
                row.add(category.getCategoryName());
                row.add(category.getDescription());
                modelCategory.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load Category");
        }
    }
     
   void loadFood() {
        indexFood = -1;
        listFood = new ArrayList<>();
        listCategory = new ArrayList<>();
        comboBoxCategoryName.removeAllElements();
        comboBoxCategoryName.addElement("--Seletion Category Name--");
        try {
            listCategory = CategoryDAO.getsCategory();
            for (Category category : listCategory) {
                comboBoxCategoryName.addElement(category.getCategoryName());
            }
            cbxCategoryName.setModel(comboBoxCategoryName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load food");
        }
        try {
            listFood = FoodDAO.getsFood();
            DefaultTableModel modelFood = (DefaultTableModel) tblFood.getModel();
            modelFood.getDataVector().removeAllElements();
            for (Food food : listFood) {
                Vector row = new Vector();
                row.add(food.getFoodID());
                row.add(food.getFoodName());
                row.add(food.getUnit());
                row.add(food.getPrice());
                row.add(food.getQuantity());
                row.add(food.getCategoryID());
                modelFood.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error load Food");
        }
    }  
     
   void whenClickCategory() {
        txtCategoryName.setEnabled(true);
        txtDescription.setEnabled(true);
        btnSaveCategory.setEnabled(true);
        btnDeleteCategory.setEnabled(true);
    }  
     
     void whenClickFood() {
        txtFoodName.setEnabled(true);
        cbxCategoryName.setEnabled(true);
        txtUnit.setEnabled(true);
        txtQuantity.setEnabled(true);
        txtPrice.setEnabled(true);
        btnSaveFood.setEnabled(true);
        btnDeleteFood.setEnabled(true);
    }
    
     
    void whenAddNewCategory() {
        txtCategoryID.setText("");
        txtCategoryName.setText("");
        txtDescription.setText("");
        txtCategoryID.setEnabled(true);
        txtCategoryName.setEnabled(true);
        txtDescription.setEnabled(true);
        btnSaveCategory.setEnabled(true);
        btnDeleteCategory.setEnabled(false);
        tblCategory.setEnabled(false);
        tblCategory.clearSelection();
    } 
     
    void whenAddNewFood() {
        txtFoodID.setText("");
        txtFoodName.setText("");
        cbxCategoryName.setSelectedIndex(0);
        txtUnit.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
        txtFoodID.setEnabled(true);
        txtFoodName.setEnabled(true);
        cbxCategoryName.setEnabled(true);
        txtUnit.setEnabled(true);
        txtQuantity.setEnabled(true);
        txtPrice.setEnabled(true);
        btnSaveFood.setEnabled(true);
        btnDeleteFood.setEnabled(false);
        tblFood.setEnabled(false);
        tblFood.clearSelection();
    } 
     
    void resetStatusCategory() {
        txtCategoryID.setText("");
        txtCategoryName.setText("");
        txtDescription.setText("");
        tblCategory.clearSelection();
        txtCategoryID.setEnabled(false);
        txtCategoryName.setEnabled(false);
        txtDescription.setEnabled(false);
        btnAddNewCategory.setEnabled(true);
        btnSaveCategory.setEnabled(false);
        btnDeleteCategory.setEnabled(false);
        tblCategory.setEnabled(true);
        loadCategory();
    }
    
    void resetStatusFood() {
        txtFoodID.setText("");
        txtFoodName.setText("");
        cbxCategoryName.setSelectedIndex(0);
        txtUnit.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
        txtFoodID.setEnabled(false);
        txtFoodName.setEnabled(false);
        cbxCategoryName.setEnabled(false);
        txtUnit.setEnabled(false);
        txtQuantity.setEnabled(false);
        txtPrice.setEnabled(false);
        btnAddNewFood.setEnabled(true);
        btnSaveFood.setEnabled(false);
        btnDeleteFood.setEnabled(false);
        tblFood.setEnabled(true);
        loadFood();
    }
    
    void saveNewCategory() {
        if (txtCategoryID.getText().trim().isEmpty()
                || txtCategoryName.getText().trim().isEmpty()
                || txtDescription.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Have not entered enough information");
            return;
        } else {
            boolean categoryIDCheck = txtCategoryID.getText().matches("[a-z0-9_-]{1,10}");
            if (categoryIDCheck) {
                String categoryID = txtCategoryID.getText().trim();
                boolean checkCategoryID = true;
                for (int i = 0; i < listCategory.size(); i++) {
                    if (categoryID.equals(listCategory.get(i).getCategoryID())) {
                        checkCategoryID = false;
                    }
                }
                if (checkCategoryID) {
                    String categoryName = txtCategoryName.getText().trim();
                    boolean checkCategoryName = true;
                    for (int i = 0; i < listCategory.size(); i++) {
                        if (categoryName.equals(listCategory.get(i).getCategoryName())) {
                            checkCategoryName = false;
                        }
                    }
                    if (checkCategoryName) {
                        String description = txtDescription.getText().trim();
                        try {
                            if (categoryID.length() > 10 || categoryName.length() > 50 || description.length() > 50) {
                                if (categoryID.length() > 10) {
                                    JOptionPane.showMessageDialog(null, "CategoryID max length is 10 ");
                                } else if (categoryName.length() > 50) {
                                    JOptionPane.showMessageDialog(null, "CategoryName max length is 50");
                                } else if (description.length() > 50) {
                                    JOptionPane.showMessageDialog(null, "Description max length is 50");
                                }
                            } else {
                                CategoryDAO.insertCategory(categoryID, categoryName, description);
                                addNewCategory = false;
                                btnAddNewCategory.setText("Add New");
                                resetStatusCategory();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, " Error save data");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Category Name already exists");
                        txtCategoryName.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID already exists");
                    txtCategoryID.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The ID cannot contain special characters");
                txtCategoryID.setText("");
            }
        }
    }
    
    void saveNewFood() {
        if (txtFoodID.getText().trim().isEmpty()
                || txtFoodName.getText().trim().isEmpty()
                || cbxCategoryName.getSelectedIndex() == 0
                || txtUnit.getText().trim().isEmpty()
                || txtQuantity.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Have not entered enough information");
            return;
        } else {
            boolean foodIDCheck = txtFoodID.getText().matches("[a-z0-9_-]{1,10}");
            if (foodIDCheck) {
                String foodID = txtFoodID.getText().trim();
                boolean checkFoodID = true;
                for (int i = 0; i < listFood.size(); i++) {
                    if (foodID.equals(listFood.get(i).getFoodID())) {
                        checkFoodID = false;
                    }
                }
                if (checkFoodID) {
                    String foodName = txtFoodName.getText().trim();
                    String unit = txtUnit.getText().trim();
                    boolean matchQuantity = txtQuantity.getText().matches("\\d{1,2}");
                    if (matchQuantity && Integer.parseInt(txtQuantity.getText()) > 0) {
                        int quantity = Integer.parseInt(txtQuantity.getText());
                        boolean matchPrice = txtPrice.getText().matches("\\d+(\\.\\d+)?");
                        if (matchPrice && Float.parseFloat(txtPrice.getText()) > 0) {
                            float price = Float.parseFloat(txtPrice.getText());
                            String categoryID = null;
                            for (int i = 0; i < listCategory.size(); i++) {
                                String checkCBX = listCategory.get(i).getCategoryName();
                                if (checkCBX.equals(cbxCategoryName.getSelectedItem())) {
                                    categoryID = listCategory.get(i).getCategoryID();
                                }
                            }
                            try {
                                if (foodID.length() > 10
                                        || foodName.length() > 50
                                        || unit.length() > 50) {
                                    if (foodID.length() > 10) {
                                        JOptionPane.showMessageDialog(null, "FoodID max length is 10 ");
                                    } else if (foodName.length() > 50) {
                                        JOptionPane.showMessageDialog(null, "FoodName max length is 50");
                                    } else if (unit.length() > 50) {
                                        JOptionPane.showMessageDialog(null, "Unit max length is 50");
                                    }

                                } else {
                                    FoodDAO.insertFood(foodID, foodName, unit, price, quantity, categoryID);
                                    addNewFood = false;
                                    btnAddNewFood.setText("Add New");
                                    resetStatusFood();
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, " Error add new");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Price incorrect value entered");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantity incorrect value entered");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID already exists");
                    txtFoodID.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The ID cannot contain special characters");
                txtFoodID.setText("");
            }
        }
     
    }
    
   void updateDataCategory() {
        if (txtCategoryName.getText().trim().isEmpty()
                || txtDescription.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Have not entered enough information");
            return;
        } else {
            String categoryID = txtCategoryID.getText().trim();
            String categoryName = txtCategoryName.getText().trim();
            String description = txtDescription.getText().trim();
            try {
                if (categoryID.length() > 10 || categoryName.length() > 50 || description.length() > 50) {
                    if (categoryID.length() > 10) {
                        JOptionPane.showMessageDialog(null, "CategoryID max length is 10 ");
                    } else if (categoryName.length() > 50) {
                        JOptionPane.showMessageDialog(null, "CategoryName max length is 50");
                    } else if (description.length() > 50) {
                        JOptionPane.showMessageDialog(null, "Description max length is 50");
                    }
                } else {
                    if (CategoryDAO.updateCategory(categoryID, categoryName, description) != 0) {
                        JOptionPane.showMessageDialog(null, "Fixed category");
                        if (CategoryDAO.findUseSP(categoryID) != null) {
                            loadFood();
                            resetStatusFood();
                        }
                        resetStatusCategory();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, " Error update data");
            }
        }
    } 
    
   void updateDataFood() {
        if (txtFoodName.getText().trim().isEmpty()
                || cbxCategoryName.getSelectedIndex() == 0
                || txtUnit.getText().trim().isEmpty()
                || txtQuantity.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Have not entered enough information");
            return;
        } else {
            String foodID = txtFoodID.getText().trim();
            String foodName = txtFoodName.getText().trim();
            String unit = txtUnit.getText().trim();
            boolean matchQuantity = txtQuantity.getText().matches("\\d{1,2}");
            if (matchQuantity && Integer.parseInt(txtQuantity.getText()) > 0) {
                int quantity = Integer.parseInt(txtQuantity.getText());
                boolean matchPrice = txtPrice.getText().matches("\\d+(\\.\\d+)?");
                if (matchPrice && Float.parseFloat(txtPrice.getText()) > 0) {
                    float price = Float.parseFloat(txtPrice.getText());
                    String categoryID = null;
                    for (int i = 0; i < listCategory.size(); i++) {
                        String checkCBX = listCategory.get(i).getCategoryName();
                        if (checkCBX.equals(cbxCategoryName.getSelectedItem())) {
                            categoryID = listCategory.get(i).getCategoryID();
                        }
                    }
                    try {
                        if (foodID.length() > 10
                                || foodName.length() > 50
                                || unit.length() > 50) {
                            if (foodID.length() > 10) {
                                JOptionPane.showMessageDialog(null, "FoodID max length is 10 ");
                            } else if (foodName.length() > 50) {
                                JOptionPane.showMessageDialog(null, "FoodName max length is 50");
                            } else if (unit.length() > 50) {
                                JOptionPane.showMessageDialog(null, "Unit max length is 50");
                            }
                        } else {
                            FoodDAO.updateFood(foodID, foodName, unit, price, quantity, categoryID);
                            resetStatusFood();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, " Error update");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Price incorrect value entered");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Quantity incorrect value entered");
                return;
            }
        }
    }
   
   boolean checkUpdateStatusCategory() {
        boolean result = true;
        if (indexCategory >= 0) {
            String categoryNameCheck = txtCategoryName.getText();
            String descriptionCheck = txtDescription.getText();
            if (!categoryNameCheck.equals(listCategory.get(indexCategory).getCategoryName())
                    || !descriptionCheck.equals(listCategory.get(indexCategory).getDescription())) {
                result = false;
            }
        } else {
            result = true;
        }
        return result;
    }

    boolean checkUpdateStatusFood() {
        boolean result = true;
        if (indexFood >= 0) {
            String foodNameCheck = txtFoodName.getText();
            String cbxCategoryNameCheck = cbxCategoryName.getSelectedItem() + "";
            String unitCheck = txtUnit.getText();
            boolean matchQuantity = txtQuantity.getText().matches("\\d{1,2}");
            if (!txtQuantity.getText().isEmpty() && matchQuantity && Integer.parseInt(txtQuantity.getText()) > 0) {
                int quantityCheck = Integer.parseInt(txtQuantity.getText());
                boolean matchPrice = txtPrice.getText().matches("\\d+(\\.\\d+)?");
                if (!txtPrice.getText().isEmpty() && matchPrice && Float.parseFloat(txtPrice.getText()) > 0) {
                    float priceCheck = Float.parseFloat(txtPrice.getText());
                    if (!foodNameCheck.equals(listFood.get(indexFood).getFoodName())
                            || !cbxCategoryNameCheck.equals(listFood.get(indexFood).getCategoryName())
                            || !unitCheck.equals(listFood.get(indexFood).getUnit())
                            || !(quantityCheck == listFood.get(indexFood).getQuantity())
                            || !(priceCheck == listFood.get(indexFood).getPrice())) {
                        result = false;
                    }
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } else {
            result = true;
        }
        return result;
    }  
   
   
    
    
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        CategoryTab = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCategoryID = new javax.swing.JTextField();
        txtCategoryName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        btnAddNewCategory = new javax.swing.JButton();
        btnSaveCategory = new javax.swing.JButton();
        btnDeleteCategory = new javax.swing.JButton();
        FoodTab = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFood = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFoodID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxCategoryName = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnAddNewFood = new javax.swing.JButton();
        btnSaveFood = new javax.swing.JButton();
        btnDeleteFood = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Food Management");
        setPreferredSize(new java.awt.Dimension(975, 620));
        getContentPane().setLayout(null);

        jTabbedPane1.setForeground(new java.awt.Color(51, 102, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Main Part", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 255))); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category ID", "Category Name", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detailed part", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 255))); // NOI18N
        jPanel2.setLayout(null);

        jLabel2.setText("Category ID:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(18, 55, 114, 30);

        jLabel3.setText("Category Name:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(18, 107, 114, 27);

        jLabel4.setText("Description:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(18, 153, 114, 32);
        jPanel2.add(txtCategoryID);
        txtCategoryID.setBounds(137, 55, 216, 30);
        jPanel2.add(txtCategoryName);
        txtCategoryName.setBounds(137, 105, 216, 30);
        jPanel2.add(txtDescription);
        txtDescription.setBounds(137, 153, 216, 32);

        btnAddNewCategory.setText("Add New");
        btnAddNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCategoryActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddNewCategory);
        btnAddNewCategory.setBounds(28, 220, 83, 25);

        btnSaveCategory.setText("Save");
        btnSaveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCategoryActionPerformed(evt);
            }
        });
        jPanel2.add(btnSaveCategory);
        btnSaveCategory.setBounds(152, 220, 61, 25);

        btnDeleteCategory.setText("Delete");
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteCategory);
        btnDeleteCategory.setBounds(260, 220, 69, 25);

        javax.swing.GroupLayout CategoryTabLayout = new javax.swing.GroupLayout(CategoryTab);
        CategoryTab.setLayout(CategoryTabLayout);
        CategoryTabLayout.setHorizontalGroup(
            CategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        CategoryTabLayout.setVerticalGroup(
            CategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoryTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Category", CategoryTab);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Main Part:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(51, 102, 255))); // NOI18N

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        tblFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food ID", "Food Name", "Unit", "Price", "Quantity", "Category ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFoodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFood);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detailied Part", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(51, 102, 255))); // NOI18N
        jPanel4.setLayout(null);

        jLabel5.setText("Food ID:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(18, 46, 60, 25);
        jPanel4.add(txtFoodID);
        txtFoodID.setBounds(120, 47, 190, 22);

        jLabel6.setText("Food Name:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(18, 97, 70, 16);
        jPanel4.add(txtFoodName);
        txtFoodName.setBounds(120, 94, 187, 22);

        jLabel7.setText("Category Name:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(18, 137, 93, 16);

        cbxCategoryName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbxCategoryName);
        cbxCategoryName.setBounds(123, 134, 184, 22);

        jLabel8.setText("Unit:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(18, 174, 27, 16);
        jPanel4.add(txtUnit);
        txtUnit.setBounds(123, 174, 184, 22);

        jLabel9.setText("Quantity:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(18, 214, 52, 16);
        jPanel4.add(txtQuantity);
        txtQuantity.setBounds(123, 214, 184, 22);

        jLabel10.setText("Price:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(18, 256, 33, 16);
        jPanel4.add(txtPrice);
        txtPrice.setBounds(123, 256, 184, 22);

        btnAddNewFood.setText("Add New");
        btnAddNewFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewFoodActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddNewFood);
        btnAddNewFood.setBounds(18, 296, 83, 25);

        btnSaveFood.setText("Save");
        btnSaveFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFoodActionPerformed(evt);
            }
        });
        jPanel4.add(btnSaveFood);
        btnSaveFood.setBounds(145, 296, 61, 25);

        btnDeleteFood.setText("Delete");
        btnDeleteFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFoodActionPerformed(evt);
            }
        });
        jPanel4.add(btnDeleteFood);
        btnDeleteFood.setBounds(276, 296, 69, 25);

        javax.swing.GroupLayout FoodTabLayout = new javax.swing.GroupLayout(FoodTab);
        FoodTab.setLayout(FoodTabLayout);
        FoodTabLayout.setHorizontalGroup(
            FoodTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        FoodTabLayout.setVerticalGroup(
            FoodTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FoodTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FoodTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Food", FoodTab);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 85, 994, 527);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Food Management Software");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 20, 350, 40);

        btnLogOut.setForeground(new java.awt.Color(255, 0, 0));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogOut);
        btnLogOut.setBounds(790, 50, 77, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
        // TODO add your handling code here:
       if (addNewCategory) {
            JOptionPane.showMessageDialog(null, "Please complete the add new function");
            return;
        } else if (!checkUpdateStatusCategory()) {
            tblCategory.setRowSelectionInterval(indexCategory, indexCategory);
            JOptionPane.showMessageDialog(null, "Please complete the update function");
            return;
        } else {
            whenClickCategory();
            indexCategory = tblCategory.getSelectedRow();
            if (indexCategory >= 0) {
                txtCategoryID.setText(listCategory.get(indexCategory).getCategoryID());
                txtCategoryName.setText(listCategory.get(indexCategory).getCategoryName());
                txtDescription.setText(listCategory.get(indexCategory).getDescription());
            } else {
                return;
            }
        }   
           
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void btnAddNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCategoryActionPerformed
        // TODO add your handling code here:
         if (!checkUpdateStatusCategory() && addNewCategory == false) {
            JOptionPane.showMessageDialog(null, "Please complete the update function");
            return;
        } else {
            if (addNewCategory == false) {
                addNewCategory = true;
                whenAddNewCategory();
                btnAddNewCategory.setText("Cancel");
            } else if (addNewCategory) {
                addNewCategory = false;
                btnAddNewCategory.setText("Add New");
                resetStatusCategory();
            }
        }
      
    }//GEN-LAST:event_btnAddNewCategoryActionPerformed

    private void btnSaveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCategoryActionPerformed
        // TODO add your handling code here:
      if (addNewCategory) {
            saveNewCategory();
            loadFood();
        } else if (!addNewCategory) {
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(null, "Do you want to UPDATE data?", "UPDATE DATA", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                updateDataCategory();
                loadFood();
            } else if (n == JOptionPane.NO_OPTION) {
                resetStatusCategory();
            }
        }   
        
        
        
        
    }//GEN-LAST:event_btnSaveCategoryActionPerformed

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        // TODO add your handling code here:
        if (!checkUpdateStatusCategory()) {
            JOptionPane.showMessageDialog(null, "Please complete the update function");
            return;
        } else {
            indexCategory = tblCategory.getSelectedRow();
            try {
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to DELETE data?", "DELETE DATA", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (n == JOptionPane.YES_OPTION) {
                    if (CategoryDAO.findUseSP(listCategory.get(indexCategory).getCategoryID()) == null) {
                        CategoryDAO.deleteCategory(listCategory.get(indexCategory).getCategoryID());
                        resetStatusCategory();
                        tblCategory.updateUI();
                        resetStatusFood();
                        loadFood();
                    } else {
                        JOptionPane.showMessageDialog(null, "the used category cannot be deleted");
                        resetStatusCategory();
                    }
                } else if (n == JOptionPane.NO_OPTION) {
                    resetStatusCategory();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "error delete data");
            }
        }
        
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

    private void btnAddNewFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewFoodActionPerformed
        // TODO add your handling code here:
        loadFood();
        if (!checkUpdateStatusFood() && addNewFood == false) {
            JOptionPane.showMessageDialog(null, "finish UPDATE");
            return;
        } else {
            if (addNewFood == false) {
                addNewFood = true;
                whenAddNewFood();
                btnAddNewFood.setText("Cancel");
            } else if (addNewFood) {
                addNewFood = false;
                btnAddNewFood.setText("Add New");
                resetStatusFood();
            }
        }
           
    }//GEN-LAST:event_btnAddNewFoodActionPerformed

    private void btnSaveFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFoodActionPerformed
        // TODO add your handling code here:
        
         if (addNewFood) {
            saveNewFood();
        } else if (!addNewFood) {
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(null, "Do you want to UPDATE data?", "UPDATE DATA", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                updateDataFood();
            } else if (n == JOptionPane.NO_OPTION) {
                resetStatusFood();
            }
        } 
        
    }//GEN-LAST:event_btnSaveFoodActionPerformed

    private void btnDeleteFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFoodActionPerformed
        // TODO add your handling code here:
        
      if (!checkUpdateStatusFood()) {
            JOptionPane.showMessageDialog(null, "finish UPDATE");
            return;
        } else {
            indexFood = tblFood.getSelectedRow();
            try {
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to DELETE data?", "DELETE DATA", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (n == JOptionPane.YES_OPTION) {
                    FoodDAO.deleteFood(listFood.get(indexFood).getFoodID());
                    resetStatusFood();
                    tblFood.updateUI();
                } else if (n == JOptionPane.NO_OPTION) {
                    resetStatusFood();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "error delete data");
            }
        }  
        
    }//GEN-LAST:event_btnDeleteFoodActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        ul.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void tblFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFoodMouseClicked
        // TODO add your handling code here:
          if (addNewFood) {
            JOptionPane.showMessageDialog(null, "Add New function is not completed");
            return;
        } else if (!checkUpdateStatusFood()) {
            tblFood.setRowSelectionInterval(indexFood, indexFood);
            JOptionPane.showMessageDialog(null, "UPDATE function is not completed");
            return;
        } else {
            whenClickFood();
            indexFood = tblFood.getSelectedRow();
            if (indexFood >= 0) {
                txtFoodID.setText(listFood.get(indexFood).getFoodID());
                txtFoodName.setText(listFood.get(indexFood).getFoodName());
                txtUnit.setText(listFood.get(indexFood).getUnit());
                txtQuantity.setText("" + listFood.get(indexFood).getQuantity());
                txtPrice.setText("" + listFood.get(indexFood).getPrice());
                comboBoxCategoryName.setSelectedItem(listFood.get(indexFood).getCategoryName());
            } else {
                return;
            }
        }
    }//GEN-LAST:event_tblFoodMouseClicked

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
            java.util.logging.Logger.getLogger(FoodManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FoodManagement dialog = new FoodManagement(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CategoryTab;
    private javax.swing.JPanel FoodTab;
    private javax.swing.JButton btnAddNewCategory;
    private javax.swing.JButton btnAddNewFood;
    private javax.swing.JButton btnDeleteCategory;
    private javax.swing.JButton btnDeleteFood;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSaveCategory;
    private javax.swing.JButton btnSaveFood;
    private javax.swing.JComboBox<String> cbxCategoryName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCategory;
    private javax.swing.JTable tblFood;
    private javax.swing.JTextField txtCategoryID;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtFoodID;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
