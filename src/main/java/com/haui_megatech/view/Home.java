/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.haui_megatech.view;

import com.haui_megatech.ApplicationContext;
import com.haui_megatech.constant.ErrorMessage;
import com.haui_megatech.constant.SuccessMessage;
import com.haui_megatech.controller.ProductController;
import com.haui_megatech.controller.UserController;
import com.haui_megatech.dto.CommonResponseDTO;
import com.haui_megatech.dto.UserDTO;
import com.haui_megatech.model.Product;
import com.haui_megatech.model.User;
import com.haui_megatech.repository.impl.ProductRepositoryImpl;
import com.haui_megatech.repository.impl.UserRepositoryImpl;
import com.haui_megatech.service.impl.ProductServiceImpl;
import com.haui_megatech.service.impl.UserServiceImpl;
import com.haui_megatech.util.ExcelUtil;
import com.haui_megatech.util.InputValidator;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vieth
 */
public class Home extends javax.swing.JFrame {
    
    private final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    private final Font tableHeaderFont = new Font("Segoe UI", Font.BOLD, 14);
    
    private final int ID_COL_INDEX = 0;
    
    private final int USERNAME_COL_INDEX = 1;
    private final int FIRSTNAME_COL_INDEX = 2;
    private final int LASTNAME_COL_INDEX = 3;
    private final int PHONENUMBER_COL_INDEX = 4;
    private final int EMAIL_COL_INDEX = 5;
    
    private final int PRODUCT_NAME_COL_INDEX = 1;
    private final int PRODUCT_PROCESSOR_COL_INDEX = 2;
    private final int PRODUCT_MEMORY_COL_INDEX = 3;
    private final int PRODUCT_STORAGE_COL_INDEX = 4;
    private final int PRODUCT_DISPLAY_COL_INDEX = 5;
    private final int PRODUCT_BATTERY_COL_INDEX = 6;
    private final int PRODUCT_CARD_COL_INDEX = 7;
    
    private final UserController userController = new UserController(
            new UserServiceImpl(
                    new UserRepositoryImpl()
            )
    );
    
    private final ProductController productController = new ProductController(
            new ProductServiceImpl(
                    new ProductRepositoryImpl()
            )
    );

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setActiveTab("product");
        this.setDisplayedPanel("product");
        loadDataToTableProducts(null);
        this.setBackground(Color.WHITE);
        this.loginedUsername.setText(ApplicationContext.getLoginedUser().getUsername());
        
        usersTable.getTableHeader().setFont(tableHeaderFont);
        productsTable.getTableHeader().setFont(tableHeaderFont);
    }

    private void loadDataToTableUsers(String keyword) {
        String[] tableHeader = {
            "ID",
            "Tên đăng nhập",
            "Tên",
            "Họ đệm",
            "Số điện thoại",
            "Email",
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, tableHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        List<User> users = keyword != null && !keyword.isEmpty() && !keyword.isBlank()
                ? userController.searchList(keyword).data()
                : userController.getList().data();
        
        users.forEach(item -> {
            tableModel.addRow(
                    new Object[]{
                        item.getId() != null ? item.getId() : "",
                        item.getUsername() != null ? item.getUsername() : "",
                        item.getFirstName() != null ? item.getFirstName() : "",
                        item.getLastName() != null ? item.getLastName() : "",
                        item.getPhoneNumber() != null ? item.getPhoneNumber() : "",
                        item.getEmail() != null ? item.getEmail() : "",
                    }
            );
        });
        usersTable.setModel(tableModel);
    }
    
    private void loadDataToTableProducts(String keyword) {
        String[] tableHeader  = {
            "ID",
            "Tên sản phẩm",
            "CPU",
            "RAM",
            "Bộ nhớ trong",
            "Màn hình",
            "Dung lượng pin",
            "Card màn hình"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(null, tableHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        List<Product> products = keyword != null && !keyword.isEmpty() && !keyword.isBlank()
                ? productController.searchList(keyword).data()
                : productController.getList().data();
        
        products.forEach(item -> {
            tableModel.addRow(
                    new Object[] {
                        item.getId() != null ? item.getId() : "",
                        item.getName() != null ? item.getName() : "",
                        item.getProcessor() != null ? item.getProcessor() : "",
                        item.getMemory() != null ? item.getMemory() : "",
                        item.getStorage() != null ? item.getStorage() : "",
                        item.getDisplay() != null ? item.getDisplay() : "",
                        item.getBattery() != null ? item.getBattery() : "",
                        item.getCard() != null ? item.getCard() : ""
                    }
            );
        });
        productsTable.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutDiaglog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        addUserDiaglog = new javax.swing.JDialog();
        addUserDiaglogPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordLabel = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        phoneNumberLabel = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        confirmEmailOTPLabel = new javax.swing.JLabel();
        confirmEmailOTPTextField = new javax.swing.JTextField();
        addUserDiaglogButton = new javax.swing.JButton();
        cancelAddUserDiaglogButton = new javax.swing.JButton();
        sendCodeAddUserDiaglogButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        diaglogMessage = new javax.swing.JDialog();
        diaglogMessagePanel = new javax.swing.JPanel();
        diaglogMessageLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        diaglogMessageOkButton = new javax.swing.JButton();
        deleteUserConfirmDiaglog = new javax.swing.JDialog();
        deleteUserConfirmDiaglogPanel = new javax.swing.JPanel();
        deleteUserConfirmDiaglogLabel = new javax.swing.JLabel();
        confirmDeleteUser = new javax.swing.JButton();
        cancelDeleteUser = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        editUserDiaglog = new javax.swing.JDialog();
        editUserDiaglogPanel = new javax.swing.JPanel();
        editUsernameLabel = new javax.swing.JLabel();
        editUsernameTextField = new javax.swing.JTextField();
        editFirstNameLabel = new javax.swing.JLabel();
        editFirstNameTextField = new javax.swing.JTextField();
        editLastNameLabel = new javax.swing.JLabel();
        editLastNameTextField = new javax.swing.JTextField();
        editPhoneNumberLabel = new javax.swing.JLabel();
        editPhoneNumberTextField = new javax.swing.JTextField();
        editEmailLabel = new javax.swing.JLabel();
        editEmailTextField = new javax.swing.JTextField();
        editUserDiaglogButton = new javax.swing.JButton();
        cancelEditUserDiaglogButton = new javax.swing.JButton();
        editUserDiaglogLabel = new javax.swing.JLabel();
        editUserIdLabel = new javax.swing.JLabel();
        editUserIdTextField = new javax.swing.JTextField();
        viewUserDiaglog = new javax.swing.JDialog();
        viewUserDiaglogPanel = new javax.swing.JPanel();
        viewUsernameLabel = new javax.swing.JLabel();
        viewUserLastNameTextField = new javax.swing.JTextField();
        viewUserFirstNameLabel = new javax.swing.JLabel();
        viewUserLastNameLabel = new javax.swing.JLabel();
        viewUserPhoneNumberLabel = new javax.swing.JLabel();
        viewUserPhoneNumberTextField = new javax.swing.JTextField();
        viewUserEmailLabel = new javax.swing.JLabel();
        viewUserEmailTextField = new javax.swing.JTextField();
        viewUserWhenCreatedLabel = new javax.swing.JLabel();
        viewUserWhenCreatedTextField = new javax.swing.JTextField();
        viewUserLastUpdatedLabel = new javax.swing.JLabel();
        viewUserLastUpdatedTextField = new javax.swing.JTextField();
        cancelAddUserDiaglogButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        editUserDiaglogButton1 = new javax.swing.JButton();
        viewUserLastLoggedInLabel = new javax.swing.JLabel();
        viewUserLastLoggedInTextField = new javax.swing.JTextField();
        viewUserLoggedInLabel = new javax.swing.JLabel();
        viewUserLoggedInTextField = new javax.swing.JTextField();
        viewUsernameTextField = new javax.swing.JTextField();
        viewUserFirstNameTextField = new javax.swing.JTextField();
        deleteProductConfirmDiaglog = new javax.swing.JDialog();
        deleteProductConfirmDiaglogPanel = new javax.swing.JPanel();
        deleteUserConfirmDiaglogLabel1 = new javax.swing.JLabel();
        confirmDeleteUser1 = new javax.swing.JButton();
        cancelDeleteUser1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        editProductDiaglog = new javax.swing.JDialog();
        editProductDiaglogPanel = new javax.swing.JPanel();
        editProductNameLabel = new javax.swing.JLabel();
        editProductProcessorTextField = new javax.swing.JTextField();
        editProductProcessorLabel = new javax.swing.JLabel();
        editProductMemoryLabel = new javax.swing.JLabel();
        editProductStorageLabel = new javax.swing.JLabel();
        editProductStorageTextField = new javax.swing.JTextField();
        editProductDisplayLabel = new javax.swing.JLabel();
        editProductDisplayTextField = new javax.swing.JTextField();
        editProductBatteryLabel = new javax.swing.JLabel();
        editProductBatteryTextField = new javax.swing.JTextField();
        editProductCardLabel = new javax.swing.JLabel();
        editProductCardTextField = new javax.swing.JTextField();
        editProductDiaglogButton = new javax.swing.JButton();
        cancelEditProductDiaglogButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        editProductWeightLabel = new javax.swing.JLabel();
        editProductWeightTextField = new javax.swing.JTextField();
        editProductMemoryTextField = new javax.swing.JTextField();
        editProductNameTextField = new javax.swing.JTextField();
        editProductIdLabel = new javax.swing.JLabel();
        editProductIdTextField = new javax.swing.JTextField();
        viewProductDiaglog = new javax.swing.JDialog();
        viewProductDiaglogPanel = new javax.swing.JPanel();
        viewUsernameLabel1 = new javax.swing.JLabel();
        viewUserLastNameTextField1 = new javax.swing.JTextField();
        viewUserFirstNameLabel1 = new javax.swing.JLabel();
        viewUserLastNameLabel1 = new javax.swing.JLabel();
        viewUserPhoneNumberLabel1 = new javax.swing.JLabel();
        viewUserPhoneNumberTextField1 = new javax.swing.JTextField();
        viewUserEmailLabel1 = new javax.swing.JLabel();
        viewUserEmailTextField1 = new javax.swing.JTextField();
        viewUserWhenCreatedLabel1 = new javax.swing.JLabel();
        viewUserWhenCreatedTextField1 = new javax.swing.JTextField();
        viewUserLastUpdatedLabel1 = new javax.swing.JLabel();
        viewUserLastUpdatedTextField1 = new javax.swing.JTextField();
        cancelAddUserDiaglogButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        editUserDiaglogButton3 = new javax.swing.JButton();
        viewUserLastLoggedInLabel1 = new javax.swing.JLabel();
        viewUserLastLoggedInTextField1 = new javax.swing.JTextField();
        viewUserLoggedInLabel1 = new javax.swing.JLabel();
        viewUserLoggedInTextField1 = new javax.swing.JTextField();
        viewUsernameTextField1 = new javax.swing.JTextField();
        viewUserFirstNameTextField1 = new javax.swing.JTextField();
        addProductDiaglog = new javax.swing.JDialog();
        addProductDiaglogPanel = new javax.swing.JPanel();
        productNameLabel = new javax.swing.JLabel();
        productProcessorTextField = new javax.swing.JTextField();
        productProcessorLabel = new javax.swing.JLabel();
        productMemoryLabel = new javax.swing.JLabel();
        productStorageLabel = new javax.swing.JLabel();
        productStorageTextField = new javax.swing.JTextField();
        productDisplayLabel = new javax.swing.JLabel();
        productDisplayTextField = new javax.swing.JTextField();
        productBatteryLabel = new javax.swing.JLabel();
        productBatteryTextField = new javax.swing.JTextField();
        productCardLabel = new javax.swing.JLabel();
        productCardTextField = new javax.swing.JTextField();
        addProductDiaglogButton = new javax.swing.JButton();
        cancelAddProductDiaglogButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        productWeightLabel = new javax.swing.JLabel();
        productWeightTextField = new javax.swing.JTextField();
        productMemoryTextField = new javax.swing.JTextField();
        productNameTextField = new javax.swing.JTextField();
        sidebarPanel = new javax.swing.JPanel();
        loginedUsername = new javax.swing.JLabel();
        productTab = new javax.swing.JPanel();
        productLabel = new javax.swing.JLabel();
        providerTab = new javax.swing.JPanel();
        providerLabel = new javax.swing.JLabel();
        importProductTab = new javax.swing.JPanel();
        importProductLabel = new javax.swing.JLabel();
        importBillTab = new javax.swing.JPanel();
        importBillLabel = new javax.swing.JLabel();
        exportProductTab = new javax.swing.JPanel();
        exportProductLabel = new javax.swing.JLabel();
        exportBillTab = new javax.swing.JPanel();
        exportBillLabel = new javax.swing.JLabel();
        inStockTab = new javax.swing.JPanel();
        inStockLabel = new javax.swing.JLabel();
        userTab = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        statisticsTab = new javax.swing.JPanel();
        statisticsLabel = new javax.swing.JLabel();
        updateInfoTab = new javax.swing.JPanel();
        updateInfoLabel = new javax.swing.JLabel();
        logoutTab = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        productPanel = new javax.swing.JPanel();
        productsScrollPanel = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        searchProductsPanel = new javax.swing.JPanel();
        productBrandsComboBox = new javax.swing.JComboBox<>();
        searchProductsTextField1 = new javax.swing.JTextField();
        searchProductsButton1 = new javax.swing.JButton();
        productFunctionPanel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        importProductsFromExcelButton = new javax.swing.JButton();
        exportProductsToExcelButton = new javax.swing.JButton();
        editProductButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        deleteProductButton = new javax.swing.JButton();
        viewProductButton = new javax.swing.JButton();
        providerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        importProductPanel = new javax.swing.JPanel();
        searchImportProductPanel = new javax.swing.JPanel();
        searchImportProductTextField = new javax.swing.JTextField();
        searchImportProductRefreshButton = new javax.swing.JButton();
        importProductScrollPanel = new javax.swing.JScrollPane();
        importProductTable = new javax.swing.JTable();
        importProductQuantityLabel = new javax.swing.JLabel();
        importProductQuantityTextField = new javax.swing.JTextField();
        importProductAddButton = new javax.swing.JButton();
        importBillIdLabel = new javax.swing.JLabel();
        importBillIdTextField = new javax.swing.JTextField();
        providerNameLabel = new javax.swing.JLabel();
        providerNameComboBox = new javax.swing.JComboBox<>();
        importProductBillCreatorLabel = new javax.swing.JTextField();
        importProductBillCreatorTextField = new javax.swing.JLabel();
        importProductBillScrollPane = new javax.swing.JScrollPane();
        importProductBillTable = new javax.swing.JTable();
        importBillItemFromExcelButton = new javax.swing.JButton();
        editBillItemButton = new javax.swing.JButton();
        removeBillItemButton = new javax.swing.JButton();
        totalValueLabel = new javax.swing.JLabel();
        totalImportBillLabel = new javax.swing.JLabel();
        importBillProductButton = new javax.swing.JButton();
        importBillPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        exportProductPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        exportBillPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        inStockPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        usersScrollPanel = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        searchUsersPanel = new javax.swing.JPanel();
        searchUsersTextField = new javax.swing.JTextField();
        searchUsersButton = new javax.swing.JButton();
        userFunctionPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        importUsersFromExcelButton = new javax.swing.JButton();
        exportUsersToExcelButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        viewUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        statisticsPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        logoutDiaglog.setMinimumSize(new java.awt.Dimension(400, 300));
        logoutDiaglog.setSize(new java.awt.Dimension(360, 250));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THOÁT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, 354, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Bạn có chắc chắn muốn thoát ứng dụng?");
        jTextField1.setActionCommand("<Not Set>");
        jTextField1.setAutoscrolls(false);
        jTextField1.setBorder(null);
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);
        jTextField1.setFocusable(false);
        jTextField1.setScrollOffset(250);
        jTextField1.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, 340, 100));

        jButton1.setBackground(new java.awt.Color(44, 43, 196));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setText("Huỷ");
        jButton1.setBorderPainted(false);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setText("Thoát");
        jButton2.setBorderPainted(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 80, 30));

        javax.swing.GroupLayout logoutDiaglogLayout = new javax.swing.GroupLayout(logoutDiaglog.getContentPane());
        logoutDiaglog.getContentPane().setLayout(logoutDiaglogLayout);
        logoutDiaglogLayout.setHorizontalGroup(
            logoutDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logoutDiaglogLayout.setVerticalGroup(
            logoutDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addUserDiaglog.setTitle("Thêm người dùng");
        addUserDiaglog.setBackground(new java.awt.Color(255, 255, 255));
        addUserDiaglog.setMinimumSize(new java.awt.Dimension(450, 500));
        addUserDiaglog.setSize(new java.awt.Dimension(450, 500));

        addUserDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        addUserDiaglogPanel.setMinimumSize(new java.awt.Dimension(430, 450));
        addUserDiaglogPanel.setPreferredSize(new java.awt.Dimension(430, 450));
        addUserDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        usernameLabel.setText("Tên đăng nhập");
        addUserDiaglogPanel.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        usernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 200, 30));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        passwordLabel.setText("Mật khẩu");
        addUserDiaglogPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addUserDiaglogPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 200, 30));

        confirmPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmPasswordLabel.setText("Xác nhận mật khẩu");
        addUserDiaglogPanel.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        confirmPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addUserDiaglogPanel.add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 200, 30));

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        firstNameLabel.setText("Tên");
        addUserDiaglogPanel.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        firstNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(firstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 200, 30));

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lastNameLabel.setText("Họ đệm");
        addUserDiaglogPanel.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lastNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, 30));

        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneNumberLabel.setText("Số điện thoại");
        addUserDiaglogPanel.add(phoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        phoneNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTextFieldActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(phoneNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 200, 30));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailLabel.setText("Địa chỉ email");
        addUserDiaglogPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 200, 30));

        confirmEmailOTPLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmEmailOTPLabel.setText("Mã xác nhận email");
        addUserDiaglogPanel.add(confirmEmailOTPLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        confirmEmailOTPTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmEmailOTPTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmEmailOTPTextFieldActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(confirmEmailOTPTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 100, 30));

        addUserDiaglogButton.setBackground(new java.awt.Color(0, 122, 249));
        addUserDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addUserDiaglogButton.setText("Thêm mới");
        addUserDiaglogButton.setBorderPainted(false);
        addUserDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserDiaglogButtonActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(addUserDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        cancelAddUserDiaglogButton.setBackground(new java.awt.Color(212, 57, 68));
        cancelAddUserDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelAddUserDiaglogButton.setText("Huỷ bỏ");
        cancelAddUserDiaglogButton.setBorderPainted(false);
        cancelAddUserDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddUserDiaglogButtonActionPerformed(evt);
            }
        });
        addUserDiaglogPanel.add(cancelAddUserDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        sendCodeAddUserDiaglogButton.setBackground(new java.awt.Color(36, 169, 65));
        sendCodeAddUserDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        sendCodeAddUserDiaglogButton.setText("Gửi mã");
        sendCodeAddUserDiaglogButton.setBorderPainted(false);
        addUserDiaglogPanel.add(sendCodeAddUserDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 90, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 43, 196));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("THÊM NGƯỜI DÙNG");
        addUserDiaglogPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, -1));

        javax.swing.GroupLayout addUserDiaglogLayout = new javax.swing.GroupLayout(addUserDiaglog.getContentPane());
        addUserDiaglog.getContentPane().setLayout(addUserDiaglogLayout);
        addUserDiaglogLayout.setHorizontalGroup(
            addUserDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addUserDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        addUserDiaglogLayout.setVerticalGroup(
            addUserDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addUserDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        diaglogMessage.setTitle("Thông báo");
        diaglogMessage.setMinimumSize(new java.awt.Dimension(400, 250));
        diaglogMessage.setSize(new java.awt.Dimension(400, 250));

        diaglogMessagePanel.setBackground(new java.awt.Color(255, 255, 255));
        diaglogMessagePanel.setMinimumSize(new java.awt.Dimension(400, 250));
        diaglogMessagePanel.setPreferredSize(new java.awt.Dimension(400, 250));
        diaglogMessagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diaglogMessageLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        diaglogMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diaglogMessageLabel.setText("Thêm mới người dùng thành công!");
        diaglogMessagePanel.add(diaglogMessageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, 380, 65));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(212, 57, 68));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("THÔNG BÁO");
        diaglogMessagePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 34, 388, -1));

        diaglogMessageOkButton.setBackground(new java.awt.Color(44, 43, 196));
        diaglogMessageOkButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        diaglogMessageOkButton.setForeground(new java.awt.Color(255, 255, 255));
        diaglogMessageOkButton.setText("OK");
        diaglogMessageOkButton.setBorderPainted(false);
        diaglogMessageOkButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        diaglogMessageOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaglogMessageOkButtonActionPerformed(evt);
            }
        });
        diaglogMessagePanel.add(diaglogMessageOkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 82, 30));

        javax.swing.GroupLayout diaglogMessageLayout = new javax.swing.GroupLayout(diaglogMessage.getContentPane());
        diaglogMessage.getContentPane().setLayout(diaglogMessageLayout);
        diaglogMessageLayout.setHorizontalGroup(
            diaglogMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diaglogMessagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        diaglogMessageLayout.setVerticalGroup(
            diaglogMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diaglogMessagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        deleteUserConfirmDiaglog.setTitle("Xác nhận xoá");
        deleteUserConfirmDiaglog.setMinimumSize(new java.awt.Dimension(420, 230));
        deleteUserConfirmDiaglog.setResizable(false);
        deleteUserConfirmDiaglog.setSize(new java.awt.Dimension(420, 230));

        deleteUserConfirmDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        deleteUserConfirmDiaglogPanel.setMinimumSize(new java.awt.Dimension(420, 230));
        deleteUserConfirmDiaglogPanel.setPreferredSize(new java.awt.Dimension(420, 230));
        deleteUserConfirmDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteUserConfirmDiaglogLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteUserConfirmDiaglogLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteUserConfirmDiaglogLabel.setText("Bạn chắc chắn muốn xoá người dùng abcdeskskskskksd");
        deleteUserConfirmDiaglogLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteUserConfirmDiaglogPanel.add(deleteUserConfirmDiaglogLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 67, 400, 50));

        confirmDeleteUser.setBackground(new java.awt.Color(44, 43, 196));
        confirmDeleteUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        confirmDeleteUser.setText("Đồng ý");
        confirmDeleteUser.setBorderPainted(false);
        confirmDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmDeleteUserActionPerformed(evt);
            }
        });
        deleteUserConfirmDiaglogPanel.add(confirmDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, 30));

        cancelDeleteUser.setBackground(new java.awt.Color(212, 57, 68));
        cancelDeleteUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        cancelDeleteUser.setText("Huỷ bỏ");
        cancelDeleteUser.setBorderPainted(false);
        cancelDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDeleteUserActionPerformed(evt);
            }
        });
        deleteUserConfirmDiaglogPanel.add(cancelDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("XÁC NHẬN XOÁ");
        deleteUserConfirmDiaglogPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 29, 408, -1));

        javax.swing.GroupLayout deleteUserConfirmDiaglogLayout = new javax.swing.GroupLayout(deleteUserConfirmDiaglog.getContentPane());
        deleteUserConfirmDiaglog.getContentPane().setLayout(deleteUserConfirmDiaglogLayout);
        deleteUserConfirmDiaglogLayout.setHorizontalGroup(
            deleteUserConfirmDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteUserConfirmDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        deleteUserConfirmDiaglogLayout.setVerticalGroup(
            deleteUserConfirmDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteUserConfirmDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editUserDiaglog.setTitle("Thêm người dùng");
        editUserDiaglog.setBackground(new java.awt.Color(255, 255, 255));
        editUserDiaglog.setMinimumSize(new java.awt.Dimension(450, 500));
        editUserDiaglog.setSize(new java.awt.Dimension(450, 500));

        editUserDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        editUserDiaglogPanel.setMinimumSize(new java.awt.Dimension(430, 450));
        editUserDiaglogPanel.setPreferredSize(new java.awt.Dimension(430, 450));
        editUserDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUsernameLabel.setText("Tên đăng nhập");
        editUserDiaglogPanel.add(editUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        editUsernameTextField.setEditable(false);
        editUsernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUsernameTextFieldActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(editUsernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 200, 30));

        editFirstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editFirstNameLabel.setText("Tên");
        editUserDiaglogPanel.add(editFirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        editFirstNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editFirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFirstNameTextFieldActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(editFirstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 200, 30));

        editLastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editLastNameLabel.setText("Họ đệm");
        editUserDiaglogPanel.add(editLastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        editLastNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editLastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLastNameTextFieldActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(editLastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, 30));

        editPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editPhoneNumberLabel.setText("Số điện thoại");
        editUserDiaglogPanel.add(editPhoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        editPhoneNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editPhoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPhoneNumberTextFieldActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(editPhoneNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 200, 30));

        editEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editEmailLabel.setText("Địa chỉ email");
        editUserDiaglogPanel.add(editEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        editEmailTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmailTextFieldActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(editEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 200, 30));

        editUserDiaglogButton.setBackground(new java.awt.Color(0, 122, 249));
        editUserDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUserDiaglogButton.setText("Cập nhật");
        editUserDiaglogButton.setBorderPainted(false);
        editUserDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserDiaglogButtonActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(editUserDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        cancelEditUserDiaglogButton.setBackground(new java.awt.Color(212, 57, 68));
        cancelEditUserDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelEditUserDiaglogButton.setText("Huỷ bỏ");
        cancelEditUserDiaglogButton.setBorderPainted(false);
        cancelEditUserDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditUserDiaglogButtonActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(cancelEditUserDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        editUserDiaglogLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editUserDiaglogLabel.setForeground(new java.awt.Color(44, 43, 196));
        editUserDiaglogLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editUserDiaglogLabel.setText("CẬP NHẬT NGƯỜI DÙNG");
        editUserDiaglogPanel.add(editUserDiaglogLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, -1));

        editUserIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUserIdLabel.setText("Mã người dùng");
        editUserDiaglogPanel.add(editUserIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        editUserIdTextField.setEditable(false);
        editUserIdTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUserIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserIdTextFieldActionPerformed(evt);
            }
        });
        editUserDiaglogPanel.add(editUserIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 200, 30));

        javax.swing.GroupLayout editUserDiaglogLayout = new javax.swing.GroupLayout(editUserDiaglog.getContentPane());
        editUserDiaglog.getContentPane().setLayout(editUserDiaglogLayout);
        editUserDiaglogLayout.setHorizontalGroup(
            editUserDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editUserDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        editUserDiaglogLayout.setVerticalGroup(
            editUserDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editUserDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        viewUserDiaglog.setTitle("Thêm người dùng");
        viewUserDiaglog.setBackground(new java.awt.Color(255, 255, 255));
        viewUserDiaglog.setMinimumSize(new java.awt.Dimension(450, 500));
        viewUserDiaglog.setSize(new java.awt.Dimension(450, 500));

        viewUserDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewUserDiaglogPanel.setMinimumSize(new java.awt.Dimension(430, 450));
        viewUserDiaglogPanel.setPreferredSize(new java.awt.Dimension(430, 450));
        viewUserDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUsernameLabel.setText("Tên đăng nhập");
        viewUserDiaglogPanel.add(viewUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        viewUserLastNameTextField.setEditable(false);
        viewUserLastNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLastNameTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserLastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 200, 30));

        viewUserFirstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserFirstNameLabel.setText("Tên");
        viewUserDiaglogPanel.add(viewUserFirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        viewUserLastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastNameLabel.setText("Họ đệm");
        viewUserDiaglogPanel.add(viewUserLastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        viewUserPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserPhoneNumberLabel.setText("Số điện thoại");
        viewUserDiaglogPanel.add(viewUserPhoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        viewUserPhoneNumberTextField.setEditable(false);
        viewUserPhoneNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserPhoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserPhoneNumberTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserPhoneNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 200, 30));

        viewUserEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserEmailLabel.setText("Địa chỉ email");
        viewUserDiaglogPanel.add(viewUserEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        viewUserEmailTextField.setEditable(false);
        viewUserEmailTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserEmailTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, 30));

        viewUserWhenCreatedLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserWhenCreatedLabel.setText("Ngày tạo");
        viewUserDiaglogPanel.add(viewUserWhenCreatedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        viewUserWhenCreatedTextField.setEditable(false);
        viewUserWhenCreatedTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserWhenCreatedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserWhenCreatedTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserWhenCreatedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 200, 30));

        viewUserLastUpdatedLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastUpdatedLabel.setText("Cập nhật lần cuối");
        viewUserDiaglogPanel.add(viewUserLastUpdatedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        viewUserLastUpdatedTextField.setEditable(false);
        viewUserLastUpdatedTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastUpdatedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLastUpdatedTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserLastUpdatedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 200, 30));

        cancelAddUserDiaglogButton1.setBackground(new java.awt.Color(212, 57, 68));
        cancelAddUserDiaglogButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelAddUserDiaglogButton1.setText("Đóng");
        cancelAddUserDiaglogButton1.setBorderPainted(false);
        cancelAddUserDiaglogButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddUserDiaglogButton1ActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(cancelAddUserDiaglogButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(44, 43, 196));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("THÔNG TIN NGƯỜI DÙNG");
        viewUserDiaglogPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, -1));

        editUserDiaglogButton1.setBackground(new java.awt.Color(0, 122, 249));
        editUserDiaglogButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUserDiaglogButton1.setText("Cập nhật");
        editUserDiaglogButton1.setBorderPainted(false);
        editUserDiaglogButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserDiaglogButton1ActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(editUserDiaglogButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, -1));

        viewUserLastLoggedInLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastLoggedInLabel.setText("Đăng nhập lần cuối");
        viewUserDiaglogPanel.add(viewUserLastLoggedInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        viewUserLastLoggedInTextField.setEditable(false);
        viewUserLastLoggedInTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastLoggedInTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLastLoggedInTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserLastLoggedInTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 200, 30));

        viewUserLoggedInLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLoggedInLabel.setText("Số lần đăng nhập");
        viewUserDiaglogPanel.add(viewUserLoggedInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        viewUserLoggedInTextField.setEditable(false);
        viewUserLoggedInTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLoggedInTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLoggedInTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserLoggedInTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 200, 30));

        viewUsernameTextField.setEditable(false);
        viewUsernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUsernameTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUsernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 200, 30));

        viewUserFirstNameTextField.setEditable(false);
        viewUserFirstNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserFirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserFirstNameTextFieldActionPerformed(evt);
            }
        });
        viewUserDiaglogPanel.add(viewUserFirstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 200, 30));

        javax.swing.GroupLayout viewUserDiaglogLayout = new javax.swing.GroupLayout(viewUserDiaglog.getContentPane());
        viewUserDiaglog.getContentPane().setLayout(viewUserDiaglogLayout);
        viewUserDiaglogLayout.setHorizontalGroup(
            viewUserDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewUserDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        viewUserDiaglogLayout.setVerticalGroup(
            viewUserDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewUserDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        deleteProductConfirmDiaglog.setTitle("Xác nhận xoá");
        deleteProductConfirmDiaglog.setMinimumSize(new java.awt.Dimension(420, 230));
        deleteProductConfirmDiaglog.setResizable(false);
        deleteProductConfirmDiaglog.setSize(new java.awt.Dimension(420, 230));

        deleteProductConfirmDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        deleteProductConfirmDiaglogPanel.setMinimumSize(new java.awt.Dimension(420, 230));
        deleteProductConfirmDiaglogPanel.setPreferredSize(new java.awt.Dimension(420, 230));
        deleteProductConfirmDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteUserConfirmDiaglogLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteUserConfirmDiaglogLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteUserConfirmDiaglogLabel1.setText("Bạn chắc chắn muốn xoá người dùng abcdeskskskskksd");
        deleteUserConfirmDiaglogLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteProductConfirmDiaglogPanel.add(deleteUserConfirmDiaglogLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 67, 400, 50));

        confirmDeleteUser1.setBackground(new java.awt.Color(44, 43, 196));
        confirmDeleteUser1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmDeleteUser1.setForeground(new java.awt.Color(255, 255, 255));
        confirmDeleteUser1.setText("Đồng ý");
        confirmDeleteUser1.setBorderPainted(false);
        confirmDeleteUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmDeleteUser1ActionPerformed(evt);
            }
        });
        deleteProductConfirmDiaglogPanel.add(confirmDeleteUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, 30));

        cancelDeleteUser1.setBackground(new java.awt.Color(212, 57, 68));
        cancelDeleteUser1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelDeleteUser1.setForeground(new java.awt.Color(255, 255, 255));
        cancelDeleteUser1.setText("Huỷ bỏ");
        cancelDeleteUser1.setBorderPainted(false);
        cancelDeleteUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDeleteUser1ActionPerformed(evt);
            }
        });
        deleteProductConfirmDiaglogPanel.add(cancelDeleteUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("XÁC NHẬN XOÁ");
        deleteProductConfirmDiaglogPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 29, 408, -1));

        javax.swing.GroupLayout deleteProductConfirmDiaglogLayout = new javax.swing.GroupLayout(deleteProductConfirmDiaglog.getContentPane());
        deleteProductConfirmDiaglog.getContentPane().setLayout(deleteProductConfirmDiaglogLayout);
        deleteProductConfirmDiaglogLayout.setHorizontalGroup(
            deleteProductConfirmDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteProductConfirmDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        deleteProductConfirmDiaglogLayout.setVerticalGroup(
            deleteProductConfirmDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteProductConfirmDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editProductDiaglog.setTitle("Thêm người dùng");
        editProductDiaglog.setBackground(new java.awt.Color(255, 255, 255));
        editProductDiaglog.setMinimumSize(new java.awt.Dimension(450, 500));
        editProductDiaglog.setSize(new java.awt.Dimension(450, 500));

        editProductDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        editProductDiaglogPanel.setMinimumSize(new java.awt.Dimension(430, 450));
        editProductDiaglogPanel.setPreferredSize(new java.awt.Dimension(430, 450));
        editProductDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editProductNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductNameLabel.setText("Tên sản phẩm");
        editProductDiaglogPanel.add(editProductNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        editProductProcessorTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductProcessorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductProcessorTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductProcessorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 200, 30));

        editProductProcessorLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductProcessorLabel.setText("Vi xử lý");
        editProductDiaglogPanel.add(editProductProcessorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        editProductMemoryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductMemoryLabel.setText("Dung lượng RAM");
        editProductDiaglogPanel.add(editProductMemoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        editProductStorageLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductStorageLabel.setText("Dung lượng lưu trữ");
        editProductDiaglogPanel.add(editProductStorageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        editProductStorageTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductStorageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductStorageTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductStorageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 200, 30));

        editProductDisplayLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductDisplayLabel.setText("Màn hình");
        editProductDiaglogPanel.add(editProductDisplayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        editProductDisplayTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductDisplayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductDisplayTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductDisplayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 200, 30));

        editProductBatteryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductBatteryLabel.setText("Dung lượng pin");
        editProductDiaglogPanel.add(editProductBatteryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        editProductBatteryTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductBatteryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductBatteryTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductBatteryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 200, 30));

        editProductCardLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductCardLabel.setText("Card đồ hoạ");
        editProductDiaglogPanel.add(editProductCardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        editProductCardTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductCardTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductCardTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductCardTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 200, 30));

        editProductDiaglogButton.setBackground(new java.awt.Color(0, 122, 249));
        editProductDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductDiaglogButton.setText("Cập nhật");
        editProductDiaglogButton.setBorderPainted(false);
        editProductDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductDiaglogButtonActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        cancelEditProductDiaglogButton.setBackground(new java.awt.Color(212, 57, 68));
        cancelEditProductDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelEditProductDiaglogButton.setText("Huỷ bỏ");
        cancelEditProductDiaglogButton.setBorderPainted(false);
        cancelEditProductDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditProductDiaglogButtonActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(cancelEditProductDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(44, 43, 196));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CẬP NHẬT SẢN PHẨM");
        editProductDiaglogPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, -1));

        editProductWeightLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductWeightLabel.setText("Trọng lượng");
        editProductDiaglogPanel.add(editProductWeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        editProductWeightTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductWeightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductWeightTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductWeightTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 200, 30));

        editProductMemoryTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductMemoryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductMemoryTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductMemoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 200, 30));

        editProductNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductNameTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 200, 30));

        editProductIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductIdLabel.setText("Mã sản phẩm");
        editProductDiaglogPanel.add(editProductIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        editProductIdTextField.setEditable(false);
        editProductIdTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductIdTextField.setEnabled(false);
        editProductIdTextField.setFocusable(false);
        editProductIdTextField.setRequestFocusEnabled(false);
        editProductIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductIdTextFieldActionPerformed(evt);
            }
        });
        editProductDiaglogPanel.add(editProductIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 200, 30));

        javax.swing.GroupLayout editProductDiaglogLayout = new javax.swing.GroupLayout(editProductDiaglog.getContentPane());
        editProductDiaglog.getContentPane().setLayout(editProductDiaglogLayout);
        editProductDiaglogLayout.setHorizontalGroup(
            editProductDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editProductDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        editProductDiaglogLayout.setVerticalGroup(
            editProductDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editProductDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        viewProductDiaglog.setTitle("Thêm người dùng");
        viewProductDiaglog.setBackground(new java.awt.Color(255, 255, 255));
        viewProductDiaglog.setMinimumSize(new java.awt.Dimension(450, 500));
        viewProductDiaglog.setSize(new java.awt.Dimension(450, 500));

        viewProductDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewProductDiaglogPanel.setMinimumSize(new java.awt.Dimension(430, 450));
        viewProductDiaglogPanel.setPreferredSize(new java.awt.Dimension(430, 450));
        viewProductDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewUsernameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUsernameLabel1.setText("Tên đăng nhập");
        viewProductDiaglogPanel.add(viewUsernameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        viewUserLastNameTextField1.setEditable(false);
        viewUserLastNameTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastNameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLastNameTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserLastNameTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 200, 30));

        viewUserFirstNameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserFirstNameLabel1.setText("Tên");
        viewProductDiaglogPanel.add(viewUserFirstNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        viewUserLastNameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastNameLabel1.setText("Họ đệm");
        viewProductDiaglogPanel.add(viewUserLastNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        viewUserPhoneNumberLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserPhoneNumberLabel1.setText("Số điện thoại");
        viewProductDiaglogPanel.add(viewUserPhoneNumberLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        viewUserPhoneNumberTextField1.setEditable(false);
        viewUserPhoneNumberTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserPhoneNumberTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserPhoneNumberTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserPhoneNumberTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 200, 30));

        viewUserEmailLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserEmailLabel1.setText("Địa chỉ email");
        viewProductDiaglogPanel.add(viewUserEmailLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        viewUserEmailTextField1.setEditable(false);
        viewUserEmailTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserEmailTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserEmailTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserEmailTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, 30));

        viewUserWhenCreatedLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserWhenCreatedLabel1.setText("Ngày tạo");
        viewProductDiaglogPanel.add(viewUserWhenCreatedLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        viewUserWhenCreatedTextField1.setEditable(false);
        viewUserWhenCreatedTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserWhenCreatedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserWhenCreatedTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserWhenCreatedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 200, 30));

        viewUserLastUpdatedLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastUpdatedLabel1.setText("Cập nhật lần cuối");
        viewProductDiaglogPanel.add(viewUserLastUpdatedLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        viewUserLastUpdatedTextField1.setEditable(false);
        viewUserLastUpdatedTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastUpdatedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLastUpdatedTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserLastUpdatedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 200, 30));

        cancelAddUserDiaglogButton2.setBackground(new java.awt.Color(212, 57, 68));
        cancelAddUserDiaglogButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelAddUserDiaglogButton2.setText("Đóng");
        cancelAddUserDiaglogButton2.setBorderPainted(false);
        cancelAddUserDiaglogButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddUserDiaglogButton2ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(cancelAddUserDiaglogButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(44, 43, 196));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("THÔNG TIN NGƯỜI DÙNG");
        viewProductDiaglogPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, -1));

        editUserDiaglogButton3.setBackground(new java.awt.Color(0, 122, 249));
        editUserDiaglogButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUserDiaglogButton3.setText("Cập nhật");
        editUserDiaglogButton3.setBorderPainted(false);
        editUserDiaglogButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserDiaglogButton3ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(editUserDiaglogButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, -1));

        viewUserLastLoggedInLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastLoggedInLabel1.setText("Đăng nhập lần cuối");
        viewProductDiaglogPanel.add(viewUserLastLoggedInLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        viewUserLastLoggedInTextField1.setEditable(false);
        viewUserLastLoggedInTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLastLoggedInTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLastLoggedInTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserLastLoggedInTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 200, 30));

        viewUserLoggedInLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLoggedInLabel1.setText("Số lần đăng nhập");
        viewProductDiaglogPanel.add(viewUserLoggedInLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        viewUserLoggedInTextField1.setEditable(false);
        viewUserLoggedInTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserLoggedInTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserLoggedInTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserLoggedInTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 200, 30));

        viewUsernameTextField1.setEditable(false);
        viewUsernameTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUsernameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUsernameTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUsernameTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 200, 30));

        viewUserFirstNameTextField1.setEditable(false);
        viewUserFirstNameTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserFirstNameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserFirstNameTextField1ActionPerformed(evt);
            }
        });
        viewProductDiaglogPanel.add(viewUserFirstNameTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 200, 30));

        javax.swing.GroupLayout viewProductDiaglogLayout = new javax.swing.GroupLayout(viewProductDiaglog.getContentPane());
        viewProductDiaglog.getContentPane().setLayout(viewProductDiaglogLayout);
        viewProductDiaglogLayout.setHorizontalGroup(
            viewProductDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewProductDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        viewProductDiaglogLayout.setVerticalGroup(
            viewProductDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewProductDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        addProductDiaglog.setTitle("Thêm người dùng");
        addProductDiaglog.setBackground(new java.awt.Color(255, 255, 255));
        addProductDiaglog.setMinimumSize(new java.awt.Dimension(450, 500));
        addProductDiaglog.setPreferredSize(new java.awt.Dimension(450, 500));
        addProductDiaglog.setSize(new java.awt.Dimension(450, 500));

        addProductDiaglogPanel.setBackground(new java.awt.Color(255, 255, 255));
        addProductDiaglogPanel.setMinimumSize(new java.awt.Dimension(430, 450));
        addProductDiaglogPanel.setPreferredSize(new java.awt.Dimension(430, 450));
        addProductDiaglogPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productNameLabel.setText("Tên sản phẩm");
        addProductDiaglogPanel.add(productNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        productProcessorTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productProcessorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productProcessorTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productProcessorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 200, 30));

        productProcessorLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productProcessorLabel.setText("Vi xử lý");
        addProductDiaglogPanel.add(productProcessorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        productMemoryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productMemoryLabel.setText("Dung lượng RAM");
        addProductDiaglogPanel.add(productMemoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        productStorageLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productStorageLabel.setText("Dung lượng lưu trữ");
        addProductDiaglogPanel.add(productStorageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        productStorageTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productStorageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productStorageTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productStorageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 200, 30));

        productDisplayLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productDisplayLabel.setText("Màn hình");
        addProductDiaglogPanel.add(productDisplayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        productDisplayTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productDisplayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDisplayTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productDisplayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, 30));

        productBatteryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productBatteryLabel.setText("Dung lượng pin");
        addProductDiaglogPanel.add(productBatteryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        productBatteryTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productBatteryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBatteryTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productBatteryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 200, 30));

        productCardLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productCardLabel.setText("Card đồ hoạ");
        addProductDiaglogPanel.add(productCardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        productCardTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productCardTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCardTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productCardTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 200, 30));

        addProductDiaglogButton.setBackground(new java.awt.Color(0, 122, 249));
        addProductDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addProductDiaglogButton.setText("Thêm mới");
        addProductDiaglogButton.setBorderPainted(false);
        addProductDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductDiaglogButtonActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(addProductDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        cancelAddProductDiaglogButton.setBackground(new java.awt.Color(212, 57, 68));
        cancelAddProductDiaglogButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancelAddProductDiaglogButton.setText("Huỷ bỏ");
        cancelAddProductDiaglogButton.setBorderPainted(false);
        cancelAddProductDiaglogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddProductDiaglogButtonActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(cancelAddProductDiaglogButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(44, 43, 196));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("THÊM MỚI SẢN PHẨM");
        addProductDiaglogPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 440, -1));

        productWeightLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productWeightLabel.setText("Trọng lượng");
        addProductDiaglogPanel.add(productWeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        productWeightTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productWeightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productWeightTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productWeightTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 200, 30));

        productMemoryTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productMemoryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productMemoryTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productMemoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 200, 30));

        productNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTextFieldActionPerformed(evt);
            }
        });
        addProductDiaglogPanel.add(productNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 200, 30));

        javax.swing.GroupLayout addProductDiaglogLayout = new javax.swing.GroupLayout(addProductDiaglog.getContentPane());
        addProductDiaglog.getContentPane().setLayout(addProductDiaglogLayout);
        addProductDiaglogLayout.setHorizontalGroup(
            addProductDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        addProductDiaglogLayout.setVerticalGroup(
            addProductDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductDiaglogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 830));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebarPanel.setBackground(new java.awt.Color(44, 43, 196));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(256, 800));
        sidebarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginedUsername.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        loginedUsername.setForeground(new java.awt.Color(255, 255, 255));
        loginedUsername.setText("Admin");
        sidebarPanel.add(loginedUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 211, 100));

        productTab.setBackground(new java.awt.Color(44, 43, 196));
        productTab.setForeground(new java.awt.Color(255, 255, 255));
        productTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productTab.setPreferredSize(new java.awt.Dimension(256, 50));
        productTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTabMouseClicked(evt);
            }
        });

        productLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        productLabel.setForeground(new java.awt.Color(255, 255, 255));
        productLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        productLabel.setText("  SẢN PHẨM");
        productLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout productTabLayout = new javax.swing.GroupLayout(productTab);
        productTab.setLayout(productTabLayout);
        productTabLayout.setHorizontalGroup(
            productTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(productLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        productTabLayout.setVerticalGroup(
            productTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebarPanel.add(productTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 256, 50));

        providerTab.setBackground(new java.awt.Color(44, 43, 196));
        providerTab.setForeground(new java.awt.Color(255, 255, 255));
        providerTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        providerTab.setPreferredSize(new java.awt.Dimension(256, 50));
        providerTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                providerTabMouseClicked(evt);
            }
        });

        providerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        providerLabel.setForeground(new java.awt.Color(255, 255, 255));
        providerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/teamwork.png"))); // NOI18N
        providerLabel.setText("  NHÀ CUNG CẤP");
        providerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        providerLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        providerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                providerLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout providerTabLayout = new javax.swing.GroupLayout(providerTab);
        providerTab.setLayout(providerTabLayout);
        providerTabLayout.setHorizontalGroup(
            providerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(providerTabLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(providerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        providerTabLayout.setVerticalGroup(
            providerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(providerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebarPanel.add(providerTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 256, 50));

        importProductTab.setBackground(new java.awt.Color(44, 43, 196));
        importProductTab.setForeground(new java.awt.Color(255, 255, 255));
        importProductTab.setPreferredSize(new java.awt.Dimension(256, 50));
        importProductTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importProductTabMouseClicked(evt);
            }
        });

        importProductLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        importProductLabel.setForeground(new java.awt.Color(255, 255, 255));
        importProductLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import.png"))); // NOI18N
        importProductLabel.setText("  NHẬP HÀNG");
        importProductLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        importProductLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importProductLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout importProductTabLayout = new javax.swing.GroupLayout(importProductTab);
        importProductTab.setLayout(importProductTabLayout);
        importProductTabLayout.setHorizontalGroup(
            importProductTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importProductTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(importProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        importProductTabLayout.setVerticalGroup(
            importProductTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importProductTabLayout.createSequentialGroup()
                .addComponent(importProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidebarPanel.add(importProductTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 256, 50));

        importBillTab.setBackground(new java.awt.Color(44, 43, 196));
        importBillTab.setForeground(new java.awt.Color(255, 255, 255));
        importBillTab.setPreferredSize(new java.awt.Dimension(256, 50));
        importBillTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importBillTabMouseClicked(evt);
            }
        });

        importBillLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        importBillLabel.setForeground(new java.awt.Color(255, 255, 255));
        importBillLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contract.png"))); // NOI18N
        importBillLabel.setText("  PHIẾU NHẬP");
        importBillLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        importBillLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importBillLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout importBillTabLayout = new javax.swing.GroupLayout(importBillTab);
        importBillTab.setLayout(importBillTabLayout);
        importBillTabLayout.setHorizontalGroup(
            importBillTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importBillTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(importBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        importBillTabLayout.setVerticalGroup(
            importBillTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(importBillLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebarPanel.add(importBillTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 256, 50));

        exportProductTab.setBackground(new java.awt.Color(44, 43, 196));
        exportProductTab.setForeground(new java.awt.Color(255, 255, 255));
        exportProductTab.setPreferredSize(new java.awt.Dimension(256, 50));
        exportProductTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportProductTabMouseClicked(evt);
            }
        });

        exportProductLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exportProductLabel.setForeground(new java.awt.Color(255, 255, 255));
        exportProductLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/export.png"))); // NOI18N
        exportProductLabel.setText("  XUẤT HÀNG");
        exportProductLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        exportProductLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportProductLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exportProductTabLayout = new javax.swing.GroupLayout(exportProductTab);
        exportProductTab.setLayout(exportProductTabLayout);
        exportProductTabLayout.setHorizontalGroup(
            exportProductTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportProductTabLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(exportProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        exportProductTabLayout.setVerticalGroup(
            exportProductTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportProductTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exportProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebarPanel.add(exportProductTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 256, 50));

        exportBillTab.setBackground(new java.awt.Color(44, 43, 196));
        exportBillTab.setForeground(new java.awt.Color(255, 255, 255));
        exportBillTab.setPreferredSize(new java.awt.Dimension(256, 50));
        exportBillTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportBillTabMouseClicked(evt);
            }
        });

        exportBillLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exportBillLabel.setForeground(new java.awt.Color(255, 255, 255));
        exportBillLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/checklist.png"))); // NOI18N
        exportBillLabel.setText("  PHIẾU XUẤT");
        exportBillLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        exportBillLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportBillLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exportBillTabLayout = new javax.swing.GroupLayout(exportBillTab);
        exportBillTab.setLayout(exportBillTabLayout);
        exportBillTabLayout.setHorizontalGroup(
            exportBillTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportBillTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(exportBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        exportBillTabLayout.setVerticalGroup(
            exportBillTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportBillTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exportBillLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebarPanel.add(exportBillTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 256, 50));

        inStockTab.setBackground(new java.awt.Color(44, 43, 196));
        inStockTab.setForeground(new java.awt.Color(255, 255, 255));
        inStockTab.setPreferredSize(new java.awt.Dimension(256, 50));
        inStockTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inStockTabMouseClicked(evt);
            }
        });

        inStockLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inStockLabel.setForeground(new java.awt.Color(255, 255, 255));
        inStockLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/inventory.png"))); // NOI18N
        inStockLabel.setText("  TỒN KHO");
        inStockLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        inStockLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inStockLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inStockTabLayout = new javax.swing.GroupLayout(inStockTab);
        inStockTab.setLayout(inStockTabLayout);
        inStockTabLayout.setHorizontalGroup(
            inStockTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inStockTabLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(inStockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        inStockTabLayout.setVerticalGroup(
            inStockTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inStockLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebarPanel.add(inStockTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 256, 50));

        userTab.setBackground(new java.awt.Color(44, 43, 196));
        userTab.setForeground(new java.awt.Color(255, 255, 255));
        userTab.setPreferredSize(new java.awt.Dimension(256, 50));
        userTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTabMouseClicked(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        userLabel.setText("  TÀI KHOẢN");
        userLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout userTabLayout = new javax.swing.GroupLayout(userTab);
        userTab.setLayout(userTabLayout);
        userTabLayout.setHorizontalGroup(
            userTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userTabLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        userTabLayout.setVerticalGroup(
            userTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidebarPanel.add(userTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 256, 50));

        statisticsTab.setBackground(new java.awt.Color(44, 43, 196));
        statisticsTab.setForeground(new java.awt.Color(255, 255, 255));
        statisticsTab.setPreferredSize(new java.awt.Dimension(256, 50));
        statisticsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statisticsTabMouseClicked(evt);
            }
        });

        statisticsLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        statisticsLabel.setForeground(new java.awt.Color(255, 255, 255));
        statisticsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trend.png"))); // NOI18N
        statisticsLabel.setText("  THỐNG KÊ");
        statisticsLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        statisticsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statisticsLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout statisticsTabLayout = new javax.swing.GroupLayout(statisticsTab);
        statisticsTab.setLayout(statisticsTabLayout);
        statisticsTabLayout.setHorizontalGroup(
            statisticsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsTabLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(statisticsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        statisticsTabLayout.setVerticalGroup(
            statisticsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statisticsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebarPanel.add(statisticsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 256, 50));

        updateInfoTab.setBackground(new java.awt.Color(44, 43, 196));
        updateInfoTab.setForeground(new java.awt.Color(255, 255, 255));
        updateInfoTab.setPreferredSize(new java.awt.Dimension(256, 50));
        updateInfoTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateInfoTabMouseClicked(evt);
            }
        });

        updateInfoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        updateInfoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exchange.png"))); // NOI18N
        updateInfoLabel.setText("  ĐỔI THÔNG TIN");
        updateInfoLabel.setPreferredSize(new java.awt.Dimension(256, 50));
        updateInfoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateInfoLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout updateInfoTabLayout = new javax.swing.GroupLayout(updateInfoTab);
        updateInfoTab.setLayout(updateInfoTabLayout);
        updateInfoTabLayout.setHorizontalGroup(
            updateInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateInfoTabLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(updateInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        updateInfoTabLayout.setVerticalGroup(
            updateInfoTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidebarPanel.add(updateInfoTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 256, 50));

        logoutTab.setBackground(new java.awt.Color(44, 43, 196));
        logoutTab.setForeground(new java.awt.Color(255, 255, 255));
        logoutTab.setPreferredSize(new java.awt.Dimension(240, 40));
        logoutTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutTabMouseClicked(evt);
            }
        });

        logoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        logoutLabel.setText(" ĐĂNG XUẤT");
        logoutLabel.setPreferredSize(new java.awt.Dimension(240, 40));
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logoutTabLayout = new javax.swing.GroupLayout(logoutTab);
        logoutTab.setLayout(logoutTabLayout);
        logoutTabLayout.setHorizontalGroup(
            logoutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutTabLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        logoutTabLayout.setVerticalGroup(
            logoutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        sidebarPanel.add(logoutTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 256, 50));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        sidebarPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 260, -1));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        sidebarPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 260, -1));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        sidebarPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 256, -1));

        getContentPane().add(sidebarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 840));

        productPanel.setBackground(new java.awt.Color(255, 255, 255));
        productPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        productsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        productsScrollPanel.setViewportView(productsTable);

        searchProductsPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchProductsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        productBrandsComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productBrandsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productBrandsComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        searchProductsTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        searchProductsButton1.setBackground(new java.awt.Color(65, 120, 190));
        searchProductsButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchProductsButton1.setForeground(new java.awt.Color(255, 255, 255));
        searchProductsButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        searchProductsButton1.setText("Làm mới");
        searchProductsButton1.setBorderPainted(false);
        searchProductsButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout searchProductsPanelLayout = new javax.swing.GroupLayout(searchProductsPanel);
        searchProductsPanel.setLayout(searchProductsPanelLayout);
        searchProductsPanelLayout.setHorizontalGroup(
            searchProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchProductsPanelLayout.createSequentialGroup()
                .addComponent(productBrandsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchProductsTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchProductsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        searchProductsPanelLayout.setVerticalGroup(
            searchProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchProductsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productBrandsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProductsTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProductsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        productFunctionPanel.setBackground(new java.awt.Color(255, 255, 255));
        productFunctionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        productFunctionPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        importProductsFromExcelButton.setBackground(new java.awt.Color(1, 169, 84));
        importProductsFromExcelButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importProductsFromExcelButton.setForeground(new java.awt.Color(255, 255, 255));
        importProductsFromExcelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sheet.png"))); // NOI18N
        importProductsFromExcelButton.setText("Nhập Excel");
        importProductsFromExcelButton.setBorderPainted(false);
        importProductsFromExcelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        importProductsFromExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importProductsFromExcelButtonActionPerformed(evt);
            }
        });

        exportProductsToExcelButton.setBackground(new java.awt.Color(0, 155, 110));
        exportProductsToExcelButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        exportProductsToExcelButton.setForeground(new java.awt.Color(255, 255, 255));
        exportProductsToExcelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sheet.png"))); // NOI18N
        exportProductsToExcelButton.setText("Xuất Excel");
        exportProductsToExcelButton.setBorderPainted(false);
        exportProductsToExcelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportProductsToExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportProductsToExcelButtonActionPerformed(evt);
            }
        });

        editProductButton.setBackground(new java.awt.Color(255, 193, 7));
        editProductButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editProductButton.setForeground(new java.awt.Color(255, 255, 255));
        editProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_icon.png"))); // NOI18N
        editProductButton.setText("Sửa");
        editProductButton.setBorderPainted(false);
        editProductButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductButtonActionPerformed(evt);
            }
        });

        addProductButton.setBackground(new java.awt.Color(36, 169, 65));
        addProductButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addProductButton.setForeground(new java.awt.Color(255, 255, 255));
        addProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_circle_icon.png"))); // NOI18N
        addProductButton.setText("Thêm");
        addProductButton.setBorderPainted(false);
        addProductButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        deleteProductButton.setBackground(new java.awt.Color(212, 57, 68));
        deleteProductButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteProductButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove_icon.png"))); // NOI18N
        deleteProductButton.setText("Xoá");
        deleteProductButton.setBorderPainted(false);
        deleteProductButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });

        viewProductButton.setBackground(new java.awt.Color(13, 110, 253));
        viewProductButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewProductButton.setForeground(new java.awt.Color(255, 255, 255));
        viewProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/show.png"))); // NOI18N
        viewProductButton.setText("Xem");
        viewProductButton.setBorderPainted(false);
        viewProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productFunctionPanelLayout = new javax.swing.GroupLayout(productFunctionPanel);
        productFunctionPanel.setLayout(productFunctionPanelLayout);
        productFunctionPanelLayout.setHorizontalGroup(
            productFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productFunctionPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(viewProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importProductsFromExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportProductsToExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        productFunctionPanelLayout.setVerticalGroup(
            productFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productFunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, productFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(importProductsFromExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exportProductsToExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, productFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(productsScrollPanel)
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(productFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchProductsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productFunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchProductsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productsScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(productPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1170, 830));

        providerPanel.setBackground(new java.awt.Color(204, 204, 255));
        providerPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        jLabel2.setText("Provider");

        javax.swing.GroupLayout providerPanelLayout = new javax.swing.GroupLayout(providerPanel);
        providerPanel.setLayout(providerPanelLayout);
        providerPanelLayout.setHorizontalGroup(
            providerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(providerPanelLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel2)
                .addContainerGap(644, Short.MAX_VALUE))
        );
        providerPanelLayout.setVerticalGroup(
            providerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(providerPanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel2)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        getContentPane().add(providerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1140, 830));

        importProductPanel.setBackground(new java.awt.Color(255, 255, 255));
        importProductPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        searchImportProductPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchImportProductPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        searchImportProductPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        searchImportProductTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchImportProductTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchImportProductTextFieldActionPerformed(evt);
            }
        });

        searchImportProductRefreshButton.setBackground(new java.awt.Color(65, 120, 190));
        searchImportProductRefreshButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchImportProductRefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        searchImportProductRefreshButton.setText("Làm Mới");
        searchImportProductRefreshButton.setBorderPainted(false);
        searchImportProductRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchImportProductRefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchImportProductPanelLayout = new javax.swing.GroupLayout(searchImportProductPanel);
        searchImportProductPanel.setLayout(searchImportProductPanelLayout);
        searchImportProductPanelLayout.setHorizontalGroup(
            searchImportProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchImportProductPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(searchImportProductTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchImportProductRefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        searchImportProductPanelLayout.setVerticalGroup(
            searchImportProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchImportProductPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(searchImportProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchImportProductRefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchImportProductTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        importProductScrollPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        importProductTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        importProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã máy", "Tên máy", "Số lượng", "Đơn giá"
            }
        ));
        importProductScrollPanel.setViewportView(importProductTable);

        importProductQuantityLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importProductQuantityLabel.setText("Số Lượng: ");

        importProductQuantityTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importProductQuantityTextField.setText("10");
        importProductQuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importProductQuantityTextFieldActionPerformed(evt);
            }
        });

        importProductAddButton.setBackground(new java.awt.Color(0, 122, 249));
        importProductAddButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importProductAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_circle_icon.png"))); // NOI18N
        importProductAddButton.setText("THÊM");
        importProductAddButton.setBorderPainted(false);
        importProductAddButton.setMaximumSize(new java.awt.Dimension(64, 22));
        importProductAddButton.setMinimumSize(new java.awt.Dimension(64, 22));
        importProductAddButton.setPreferredSize(new java.awt.Dimension(64, 22));
        importProductAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importProductAddButtonActionPerformed(evt);
            }
        });

        importBillIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importBillIdLabel.setText("Mã phiếu nhập:");

        importBillIdTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        providerNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        providerNameLabel.setText("Nhà cung cấp:");

        providerNameComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        providerNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Công Ty TNHH Minh Nghĩa", "Công ty TNHH Hoàng Việt", "Công ty TNHH Hoàng Phúc" }));

        importProductBillCreatorLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importProductBillCreatorLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importProductBillCreatorLabelActionPerformed(evt);
            }
        });

        importProductBillCreatorTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importProductBillCreatorTextField.setText("Người tạo phiếu:");

        importProductBillTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        importProductBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
            }
        ));
        importProductBillScrollPane.setViewportView(importProductBillTable);

        importBillItemFromExcelButton.setBackground(new java.awt.Color(1, 169, 84));
        importBillItemFromExcelButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importBillItemFromExcelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sheet.png"))); // NOI18N
        importBillItemFromExcelButton.setText("Nhập excel");
        importBillItemFromExcelButton.setBorderPainted(false);
        importBillItemFromExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBillItemFromExcelButtonActionPerformed(evt);
            }
        });

        editBillItemButton.setBackground(new java.awt.Color(36, 169, 65));
        editBillItemButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editBillItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_icon.png"))); // NOI18N
        editBillItemButton.setText("Sửa số lượng");
        editBillItemButton.setBorderPainted(false);

        removeBillItemButton.setBackground(new java.awt.Color(212, 57, 68));
        removeBillItemButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        removeBillItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove_icon.png"))); // NOI18N
        removeBillItemButton.setText("Xóa sản phẩm");
        removeBillItemButton.setBorderPainted(false);

        totalValueLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        totalValueLabel.setForeground(new java.awt.Color(204, 0, 51));
        totalValueLabel.setText("50,670,000đ");

        totalImportBillLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        totalImportBillLabel.setText("Tổng tiền:");

        importBillProductButton.setBackground(new java.awt.Color(0, 155, 110));
        importBillProductButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importBillProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import_icon.png"))); // NOI18N
        importBillProductButton.setText("Nhập hàng");
        importBillProductButton.setBorderPainted(false);

        javax.swing.GroupLayout importProductPanelLayout = new javax.swing.GroupLayout(importProductPanel);
        importProductPanel.setLayout(importProductPanelLayout);
        importProductPanelLayout.setHorizontalGroup(
            importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(importProductScrollPanel)
                    .addComponent(searchImportProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(importProductPanelLayout.createSequentialGroup()
                        .addComponent(importProductQuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importProductQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(importProductAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(importProductPanelLayout.createSequentialGroup()
                        .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(importBillIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(providerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importProductBillCreatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(importBillIdTextField)
                            .addComponent(providerNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importProductBillCreatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importProductPanelLayout.createSequentialGroup()
                        .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(importProductPanelLayout.createSequentialGroup()
                                .addComponent(totalImportBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(totalValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(60, 60, 60))
                            .addGroup(importProductPanelLayout.createSequentialGroup()
                                .addComponent(importBillItemFromExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editBillItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))
                        .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeBillItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importBillProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(importProductBillScrollPane))
                .addGap(35, 35, 35))
        );
        importProductPanelLayout.setVerticalGroup(
            importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchImportProductPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importProductScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importProductAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importProductQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importProductQuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalImportBillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importProductPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importBillIdLabel)
                    .addComponent(importBillIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(providerNameLabel)
                    .addComponent(providerNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importProductBillCreatorTextField)
                    .addComponent(importProductBillCreatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importProductBillScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(importProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeBillItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBillItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importBillItemFromExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importBillProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        getContentPane().add(importProductPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1140, 830));

        importBillPanel.setBackground(new java.awt.Color(0, 255, 255));
        importBillPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        jLabel4.setText("Import Bill");

        javax.swing.GroupLayout importBillPanelLayout = new javax.swing.GroupLayout(importBillPanel);
        importBillPanel.setLayout(importBillPanelLayout);
        importBillPanelLayout.setHorizontalGroup(
            importBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importBillPanelLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel4)
                .addContainerGap(632, Short.MAX_VALUE))
        );
        importBillPanelLayout.setVerticalGroup(
            importBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importBillPanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel4)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        getContentPane().add(importBillPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1140, 830));

        exportProductPanel.setBackground(new java.awt.Color(204, 255, 255));
        exportProductPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        jLabel5.setText("Export Product");

        javax.swing.GroupLayout exportProductPanelLayout = new javax.swing.GroupLayout(exportProductPanel);
        exportProductPanel.setLayout(exportProductPanelLayout);
        exportProductPanelLayout.setHorizontalGroup(
            exportProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportProductPanelLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel5)
                .addContainerGap(610, Short.MAX_VALUE))
        );
        exportProductPanelLayout.setVerticalGroup(
            exportProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportProductPanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel5)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        getContentPane().add(exportProductPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1140, 830));

        exportBillPanel.setBackground(new java.awt.Color(204, 255, 255));
        exportBillPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        jLabel6.setText("Export Bill");

        javax.swing.GroupLayout exportBillPanelLayout = new javax.swing.GroupLayout(exportBillPanel);
        exportBillPanel.setLayout(exportBillPanelLayout);
        exportBillPanelLayout.setHorizontalGroup(
            exportBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportBillPanelLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel6)
                .addContainerGap(634, Short.MAX_VALUE))
        );
        exportBillPanelLayout.setVerticalGroup(
            exportBillPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportBillPanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel6)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        getContentPane().add(exportBillPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1140, 830));

        inStockPanel.setBackground(new java.awt.Color(204, 255, 255));
        inStockPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        jLabel7.setText("In Stock");

        javax.swing.GroupLayout inStockPanelLayout = new javax.swing.GroupLayout(inStockPanel);
        inStockPanel.setLayout(inStockPanelLayout);
        inStockPanelLayout.setHorizontalGroup(
            inStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inStockPanelLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel7)
                .addContainerGap(646, Short.MAX_VALUE))
        );
        inStockPanelLayout.setVerticalGroup(
            inStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inStockPanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel7)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        getContentPane().add(inStockPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1140, 830));

        userPanel.setBackground(new java.awt.Color(255, 255, 255));
        userPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        usersTable.setAutoCreateRowSorter(true);
        usersTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        usersScrollPanel.setViewportView(usersTable);

        searchUsersPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchUsersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        searchUsersTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchUsersTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchUsersTextFieldKeyReleased(evt);
            }
        });

        searchUsersButton.setBackground(new java.awt.Color(65, 120, 190));
        searchUsersButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchUsersButton.setForeground(new java.awt.Color(255, 255, 255));
        searchUsersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        searchUsersButton.setText("Làm mới");
        searchUsersButton.setBorderPainted(false);
        searchUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUsersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchUsersPanelLayout = new javax.swing.GroupLayout(searchUsersPanel);
        searchUsersPanel.setLayout(searchUsersPanelLayout);
        searchUsersPanelLayout.setHorizontalGroup(
            searchUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchUsersTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchUsersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        searchUsersPanelLayout.setVerticalGroup(
            searchUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchUsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchUsersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchUsersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        userFunctionPanel.setBackground(new java.awt.Color(255, 255, 255));
        userFunctionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        userFunctionPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        importUsersFromExcelButton.setBackground(new java.awt.Color(1, 169, 84));
        importUsersFromExcelButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        importUsersFromExcelButton.setForeground(new java.awt.Color(255, 255, 255));
        importUsersFromExcelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sheet.png"))); // NOI18N
        importUsersFromExcelButton.setText("Nhập Excel");
        importUsersFromExcelButton.setBorderPainted(false);
        importUsersFromExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importUsersFromExcelButtonActionPerformed(evt);
            }
        });

        exportUsersToExcelButton.setBackground(new java.awt.Color(0, 155, 110));
        exportUsersToExcelButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        exportUsersToExcelButton.setForeground(new java.awt.Color(255, 255, 255));
        exportUsersToExcelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sheet.png"))); // NOI18N
        exportUsersToExcelButton.setText("Xuất Excel");
        exportUsersToExcelButton.setBorderPainted(false);
        exportUsersToExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportUsersToExcelButtonActionPerformed(evt);
            }
        });

        editUserButton.setBackground(new java.awt.Color(255, 193, 7));
        editUserButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editUserButton.setForeground(new java.awt.Color(255, 255, 255));
        editUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_icon.png"))); // NOI18N
        editUserButton.setText("Sửa");
        editUserButton.setBorderPainted(false);
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        viewUserButton.setBackground(new java.awt.Color(13, 110, 253));
        viewUserButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewUserButton.setForeground(new java.awt.Color(255, 255, 255));
        viewUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/show.png"))); // NOI18N
        viewUserButton.setText("Xem");
        viewUserButton.setBorderPainted(false);
        viewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUserButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setBackground(new java.awt.Color(212, 57, 68));
        deleteUserButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteUserButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove_icon.png"))); // NOI18N
        deleteUserButton.setText("Xoá");
        deleteUserButton.setBorderPainted(false);
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        addUserButton.setBackground(new java.awt.Color(36, 169, 65));
        addUserButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addUserButton.setForeground(new java.awt.Color(255, 255, 255));
        addUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_circle_icon.png"))); // NOI18N
        addUserButton.setText("Thêm");
        addUserButton.setBorderPainted(false);
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userFunctionPanelLayout = new javax.swing.GroupLayout(userFunctionPanel);
        userFunctionPanel.setLayout(userFunctionPanelLayout);
        userFunctionPanelLayout.setHorizontalGroup(
            userFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userFunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importUsersFromExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportUsersToExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        userFunctionPanelLayout.setVerticalGroup(
            userFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userFunctionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, userFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(importUsersFromExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exportUsersToExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, userFunctionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(userFunctionPanelLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usersScrollPanel)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(userFunctionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchUsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userFunctionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchUsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usersScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1170, 830));

        statisticsPanel.setBackground(new java.awt.Color(204, 255, 255));
        statisticsPanel.setPreferredSize(new java.awt.Dimension(1140, 830));

        jLabel9.setText("Statistic");

        javax.swing.GroupLayout statisticsPanelLayout = new javax.swing.GroupLayout(statisticsPanel);
        statisticsPanel.setLayout(statisticsPanelLayout);
        statisticsPanelLayout.setHorizontalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsPanelLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel9)
                .addContainerGap(646, Short.MAX_VALUE))
        );
        statisticsPanelLayout.setVerticalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsPanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel9)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        getContentPane().add(statisticsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1140, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setActiveTab(String tabName) {
        Color defaultColor = new Color(44, 43, 196);
        Color activeColor = new Color(126, 142, 241);
        switch (tabName) {
            case "product" -> {
                this.productTab.setBackground(activeColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "provider" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(activeColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "import-product" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(activeColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "import-bill" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(activeColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "export-product" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(activeColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "export-bill" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(activeColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "in-stock" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(activeColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "user" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(activeColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
            case "statistics" -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(activeColor);
                break;
            }

            default -> {
                this.productTab.setBackground(defaultColor);
                this.providerTab.setBackground(defaultColor);
                this.importProductTab.setBackground(defaultColor);
                this.importBillTab.setBackground(defaultColor);
                this.exportProductTab.setBackground(defaultColor);
                this.exportBillTab.setBackground(defaultColor);
                this.inStockTab.setBackground(defaultColor);
                this.userTab.setBackground(defaultColor);
                this.statisticsTab.setBackground(defaultColor);
                break;
            }
        }
    }

    private void setDisplayedPanel(String tabName) {
        switch (tabName) {
            case "product" -> {
                this.productPanel.setVisible(true);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "provider" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(true);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "import-product" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(true);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "import-bill" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(true);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "export-product" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(true);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "export-bill" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(true);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "in-stock" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(true);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "user" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(true);
                this.statisticsPanel.setVisible(false);
                break;
            }
            case "statistics" -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(true);
                break;
            }

            default -> {
                this.productPanel.setVisible(false);
                this.providerPanel.setVisible(false);
                this.importProductPanel.setVisible(false);
                this.importBillPanel.setVisible(false);
                this.exportProductPanel.setVisible(false);
                this.exportBillPanel.setVisible(false);
                this.inStockPanel.setVisible(false);
                this.userPanel.setVisible(false);
                this.statisticsPanel.setVisible(false);
                break;
            }
        }
    }

    private void searchImportProductTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchImportProductTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchImportProductTextFieldActionPerformed

    private void searchImportProductRefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchImportProductRefreshButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchImportProductRefreshButtonActionPerformed

    private void importProductQuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importProductQuantityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importProductQuantityTextFieldActionPerformed

    private void importProductAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importProductAddButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importProductAddButtonActionPerformed

    private void importProductBillCreatorLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importProductBillCreatorLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importProductBillCreatorLabelActionPerformed

    private void importBillItemFromExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBillItemFromExcelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importBillItemFromExcelButtonActionPerformed

    private void importUsersFromExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importUsersFromExcelButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Workbook (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showDialog(this, "Chọn file");
        if (result == JFileChooser.APPROVE_OPTION) {
            File uploadedFile = fileChooser.getSelectedFile();
            ArrayList<User> users = ExcelUtil.excelToUsers(uploadedFile);
            CommonResponseDTO response = userController.addList(users);
            showDiaglogMessage(response.message());
            loadDataToTableUsers(null);
        }
        
    }//GEN-LAST:event_importUsersFromExcelButtonActionPerformed

    private void exportUsersToExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportUsersToExcelButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lựa chọn vị trí lưu file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Workbook (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File directoryToSave = fileChooser.getSelectedFile();
            CommonResponseDTO response = ExcelUtil.usersToExcel(
                    userController.getList().data(), 
                    directoryToSave.getAbsolutePath()
            );
            showDiaglogMessage(response.message());
        }
    }//GEN-LAST:event_exportUsersToExcelButtonActionPerformed

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButtonActionPerformed
        int[] rows = usersTable.getSelectedRows();
        if (rows.length == 0) {
            showDiaglogMessage(ErrorMessage.User.EMPTY_SELECTED_ROWS);
            return;
        }
        if (rows.length > 1) {
            showDiaglogMessage(ErrorMessage.User.EXCEED_SELECTED_ROWS);
            return;
        }
        
        showEditUserDiaglog(rows[0]);
    }//GEN-LAST:event_editUserButtonActionPerformed
    
    private void showEditUserDiaglog(int selectedRow) {        
        Integer id = Integer.valueOf(usersTable.getValueAt(selectedRow, ID_COL_INDEX).toString());
        String username = usersTable.getValueAt(selectedRow, USERNAME_COL_INDEX).toString();
        String firstName = usersTable.getValueAt(selectedRow, FIRSTNAME_COL_INDEX).toString();
        String lastName = usersTable.getValueAt(selectedRow, LASTNAME_COL_INDEX).toString();
        String phoneNumber = usersTable.getValueAt(selectedRow, PHONENUMBER_COL_INDEX).toString();
        String email = usersTable.getValueAt(selectedRow, EMAIL_COL_INDEX).toString();
        
        editUserIdTextField.setText(id.toString());
        editUsernameTextField.setText(username);
        editFirstNameTextField.setText(firstName);
        editLastNameTextField.setText(lastName);
        editPhoneNumberTextField.setText(phoneNumber);
        editEmailTextField.setText(email);
        
        editUserDiaglog.setVisible(true);
        editUserDiaglog.setLocationRelativeTo(this);
    }
    
    private void viewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserButtonActionPerformed
        int[] rows = usersTable.getSelectedRows();
        if (rows.length == 0) {
            showDiaglogMessage(ErrorMessage.User.EMPTY_SELECTED_ROWS);
            return;
        }
        if (rows.length > 1) {
            showDiaglogMessage(ErrorMessage.User.EXCEED_SELECTED_ROWS);
            return;
        }
        
        showViewUserDiaglog(rows[0]);
    }//GEN-LAST:event_viewUserButtonActionPerformed
    
    private void showViewUserDiaglog(int selectedRow) {
        Integer id = Integer.valueOf(usersTable.getValueAt(selectedRow, ID_COL_INDEX).toString());
        Optional<User> found = userController.findById(id);
        if (found.isEmpty()) {
            showDiaglogMessage(ErrorMessage.User.NOT_FOUND);
            return;
        }
        
        User foundUser = found.get();
        viewUsernameTextField.setText(foundUser.getUsername());
        viewUserFirstNameTextField.setText(foundUser.getFirstName());
        viewUserLastNameTextField.setText(foundUser.getLastName());
        viewUserPhoneNumberTextField.setText(foundUser.getPhoneNumber());
        viewUserEmailTextField.setText(foundUser.getEmail());
        if (foundUser.getWhenCreated() != null) viewUserWhenCreatedTextField.setText(formatter.format(foundUser.getWhenCreated()));
        if (foundUser.getLastUpdated() != null) viewUserLastUpdatedTextField.setText(formatter.format(foundUser.getLastUpdated()));
        if (foundUser.getLastLoggedIn() != null) viewUserLastLoggedInTextField.setText(formatter.format(foundUser.getLastLoggedIn()));
        if (foundUser.getLoggedIn() != null) viewUserLoggedInTextField.setText(foundUser.getLoggedIn().toString());
        
        viewUserDiaglog.setVisible(true);
        viewUserDiaglog.setLocationRelativeTo(this);
    }
    
    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        int[] rows = usersTable.getSelectedRows();
        if (rows.length == 0) {
            showDiaglogMessage(ErrorMessage.User.EMPTY_SELECTED_ROWS);
            return;
        }
        showDeleteUserConfirmDiaglog(String.format("Bạn có chắc chắn xoá %d bản ghi này?", rows.length));
        
    }//GEN-LAST:event_deleteUserButtonActionPerformed
    
    private void showDeleteUserConfirmDiaglog(String content) {
        deleteUserConfirmDiaglog.setVisible(true);
        deleteUserConfirmDiaglog.setLocationRelativeTo(this);
        deleteUserConfirmDiaglogLabel.setText(content);
    }
    
    private void importProductsFromExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importProductsFromExcelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importProductsFromExcelButtonActionPerformed

    private void exportProductsToExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportProductsToExcelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportProductsToExcelButtonActionPerformed

    private void editProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductButtonActionPerformed
        int[] rows = productsTable.getSelectedRows();
        if (rows.length == 0) {
            showDiaglogMessage(ErrorMessage.User.EMPTY_SELECTED_ROWS);
            return;
        }
        if (rows.length > 1) {
            showDiaglogMessage(ErrorMessage.User.EXCEED_SELECTED_ROWS);
            return;
        }
        
        this.showEditProductDiaglog(rows[0]);
    }//GEN-LAST:event_editProductButtonActionPerformed
    
    private void showEditProductDiaglog(int selectedRow) {
        Integer id = Integer.valueOf(productsTable.getValueAt(selectedRow, ID_COL_INDEX).toString());
        
        Optional<Product> found = productController.findById(id);
        
        if (found.isEmpty()) {
            showDiaglogMessage(ErrorMessage.Product.BLANK_INPUT);
            return;
        }
        
        Product foundProduct = found.get();
        
        editProductIdTextField.setText(foundProduct.getId().toString());
        editProductNameTextField.setText(foundProduct.getName());
        editProductProcessorTextField.setText(foundProduct.getProcessor());
        editProductMemoryTextField.setText(foundProduct.getMemory());
        editProductStorageTextField.setText(foundProduct.getStorage());
        editProductDisplayTextField.setText(foundProduct.getDisplay());
        editProductBatteryTextField.setText(foundProduct.getBattery());
        editProductCardTextField.setText(foundProduct.getCard());
        editProductWeightTextField.setText(foundProduct.getWeight());
        
        
        editProductDiaglog.setVisible(true);
        editProductDiaglog.setLocationRelativeTo(this);
    }
    
    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        showAddProductDiaglog();
    }//GEN-LAST:event_addProductButtonActionPerformed
    
    private void showAddProductDiaglog() {
        addProductDiaglog.setVisible(true);
        addProductDiaglog.setLocationRelativeTo(this);
    }
    
    private void deleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteProductButtonActionPerformed

    private void searchUsersTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchUsersTextFieldKeyReleased
        String keyword = searchUsersTextField.getText();
        loadDataToTableUsers(keyword);
    }//GEN-LAST:event_searchUsersTextFieldKeyReleased

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void phoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTextFieldActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void confirmEmailOTPTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmEmailOTPTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmEmailOTPTextFieldActionPerformed

    private void logoutTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutTabMouseClicked
        // TODO add your handling code here:
        this.logoutLabelMouseClicked(evt);
    }//GEN-LAST:event_logoutTabMouseClicked

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("");
        this.logoutDiaglog.setVisible(true);
        this.logoutDiaglog.setLocationRelativeTo(this);
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void updateInfoTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateInfoTabMouseClicked
        // TODO add your handling code here:
        this.updateInfoLabelMouseClicked(evt);
    }//GEN-LAST:event_updateInfoTabMouseClicked

    private void updateInfoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateInfoLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("");
    }//GEN-LAST:event_updateInfoLabelMouseClicked

    private void statisticsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsTabMouseClicked
        // TODO add your handling code here:
        this.statisticsLabelMouseClicked(evt);
    }//GEN-LAST:event_statisticsTabMouseClicked

    private void statisticsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("statistics");
        this.setDisplayedPanel("statistics");
    }//GEN-LAST:event_statisticsLabelMouseClicked

    private void userTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTabMouseClicked
        // TODO add your handling code here:
        this.userLabelMouseClicked(evt);
    }//GEN-LAST:event_userTabMouseClicked

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("user");
        this.setDisplayedPanel("user");
        this.loadDataToTableUsers(null);
    }//GEN-LAST:event_userLabelMouseClicked

    private void inStockTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inStockTabMouseClicked
        // TODO add your handling code here:
        this.inStockLabelMouseClicked(evt);
    }//GEN-LAST:event_inStockTabMouseClicked

    private void inStockLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inStockLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("in-stock");
        this.setDisplayedPanel("in-stock");
    }//GEN-LAST:event_inStockLabelMouseClicked

    private void exportBillTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportBillTabMouseClicked
        // TODO add your handling code here:
        this.exportBillLabelMouseClicked(evt);
    }//GEN-LAST:event_exportBillTabMouseClicked

    private void exportBillLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportBillLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("export-bill");
        this.setDisplayedPanel("export-bill");
    }//GEN-LAST:event_exportBillLabelMouseClicked

    private void exportProductTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportProductTabMouseClicked
        // TODO add your handling code here:
        this.exportProductLabelMouseClicked(evt);
    }//GEN-LAST:event_exportProductTabMouseClicked

    private void exportProductLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportProductLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("export-product");
        this.setDisplayedPanel("export-product");
    }//GEN-LAST:event_exportProductLabelMouseClicked

    private void importBillTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importBillTabMouseClicked
        // TODO add your handling code here:
        this.importBillLabelMouseClicked(evt);
    }//GEN-LAST:event_importBillTabMouseClicked

    private void importBillLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importBillLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("import-bill");
        this.setDisplayedPanel("import-bill");
    }//GEN-LAST:event_importBillLabelMouseClicked

    private void importProductTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importProductTabMouseClicked
        // TODO add your handling code here:
        this.importProductLabelMouseClicked(evt);
    }//GEN-LAST:event_importProductTabMouseClicked

    private void importProductLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importProductLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("import-product");
        this.setDisplayedPanel("import-product");
    }//GEN-LAST:event_importProductLabelMouseClicked

    private void providerTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_providerTabMouseClicked
        // TODO add your handling code here:
        this.providerLabelMouseClicked(evt);
    }//GEN-LAST:event_providerTabMouseClicked

    private void providerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_providerLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("provider");
        this.setDisplayedPanel("provider");
    }//GEN-LAST:event_providerLabelMouseClicked

    private void productTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTabMouseClicked
        // TODO add your handling code here:
        this.productLabelMouseClicked(evt);
    }//GEN-LAST:event_productTabMouseClicked

    private void productLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productLabelMouseClicked
        // TODO add your handling code here:
        this.setActiveTab("product");
        this.setDisplayedPanel("product");
    }//GEN-LAST:event_productLabelMouseClicked

    private void addUserDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserDiaglogButtonActionPerformed
        String username = usernameTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String email = emailTextField.getText();
        String otp = confirmEmailOTPTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
        if (InputValidator.anyBlankInput(
                username, firstName, lastName, phoneNumber, email, 
                otp, password, confirmPassword)
        ) {
            showDiaglogMessage(ErrorMessage.User.BLANK_INPUT);
            return;
        }    
        
        if (!password.equals(confirmPassword)) {
            showDiaglogMessage(ErrorMessage.User.MISMATCHED_PASSWORD);
            return;
        }
        
        if (userController.findByUsername(username).isPresent()) {
            showDiaglogMessage(ErrorMessage.User.DUPLICATED_USERNAME);
            return;
        }
        
        CommonResponseDTO result = userController.addOne(User
                .builder()
                .username(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .email(email)
                .build());
        if (result.success()) {
            addUserDiaglog.setVisible(false);
            showDiaglogMessage(SuccessMessage.User.ADDED);            
            loadDataToTableUsers(null);
        }
    }//GEN-LAST:event_addUserDiaglogButtonActionPerformed
    
    private void showDiaglogMessage(String message) {
        diaglogMessage.setVisible(true);
        diaglogMessage.setLocationRelativeTo(this);
        diaglogMessageLabel.setText(message);
    }
    
    private void cancelAddUserDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddUserDiaglogButtonActionPerformed
        usernameTextField.setText("");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneNumberTextField.setText("");
        emailTextField.setText("");
        confirmEmailOTPTextField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        
        addUserDiaglog.dispose();
    }//GEN-LAST:event_cancelAddUserDiaglogButtonActionPerformed

    private void confirmDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmDeleteUserActionPerformed
        deleteUserConfirmDiaglog.dispose();
        int[] rows = usersTable.getSelectedRows();
        for (int row : rows) {
            userController.deleteOne(Integer.valueOf(usersTable.getValueAt(row, ID_COL_INDEX).toString()));
        }
        loadDataToTableUsers(null);
        showDiaglogMessage(String.format("Xoá thành công %d bản ghi.", rows.length));
        
    }//GEN-LAST:event_confirmDeleteUserActionPerformed

    private void cancelDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDeleteUserActionPerformed
        deleteUserConfirmDiaglog.dispose();
    }//GEN-LAST:event_cancelDeleteUserActionPerformed

    private void diaglogMessageOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaglogMessageOkButtonActionPerformed
        diaglogMessage.dispose();
    }//GEN-LAST:event_diaglogMessageOkButtonActionPerformed

    private void editUsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editUsernameTextFieldActionPerformed

    private void editFirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFirstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFirstNameTextFieldActionPerformed

    private void editLastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editLastNameTextFieldActionPerformed

    private void editPhoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPhoneNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPhoneNumberTextFieldActionPerformed

    private void editEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEmailTextFieldActionPerformed

    private void editUserDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserDiaglogButtonActionPerformed
        Integer id = Integer.valueOf(editUserIdTextField.getText());
        String firstName = editFirstNameTextField.getText();
        String lastName = editLastNameTextField.getText();
        String email = editEmailTextField.getText();
        String phoneNumber = editPhoneNumberTextField.getText();
        
        CommonResponseDTO response = userController.updateOne(id, new UserDTO(firstName, lastName, phoneNumber, email));
        showDiaglogMessage(response.message());
        loadDataToTableUsers(null);
        editUserDiaglog.dispose();
    }//GEN-LAST:event_editUserDiaglogButtonActionPerformed

    private void cancelEditUserDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditUserDiaglogButtonActionPerformed
        // TODO add your handling code here:
        editUserDiaglog.dispose();
    }//GEN-LAST:event_cancelEditUserDiaglogButtonActionPerformed

    private void editUserIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editUserIdTextFieldActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        addUserDiaglog.setLocationRelativeTo(this);
        addUserDiaglog.setVisible(true);
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void viewUserLastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLastNameTextFieldActionPerformed

    private void viewUserPhoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserPhoneNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserPhoneNumberTextFieldActionPerformed

    private void viewUserEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserEmailTextFieldActionPerformed

    private void viewUserWhenCreatedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserWhenCreatedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserWhenCreatedTextFieldActionPerformed

    private void viewUserLastUpdatedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLastUpdatedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLastUpdatedTextFieldActionPerformed

    private void cancelAddUserDiaglogButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddUserDiaglogButton1ActionPerformed
        viewUserDiaglog.dispose();
    }//GEN-LAST:event_cancelAddUserDiaglogButton1ActionPerformed

    private void editUserDiaglogButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserDiaglogButton1ActionPerformed
        // TODO add your handling code here:
        int[] rows = usersTable.getSelectedRows();
        if (rows.length == 0) {
            showDiaglogMessage(ErrorMessage.User.EMPTY_SELECTED_ROWS);
            return;
        }
        if (rows.length > 1) {
            showDiaglogMessage(ErrorMessage.User.EXCEED_SELECTED_ROWS);
            return;
        }
        viewUserDiaglog.dispose();
        showEditUserDiaglog(rows[0]);
    }//GEN-LAST:event_editUserDiaglogButton1ActionPerformed

    private void viewUserLastLoggedInTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLastLoggedInTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLastLoggedInTextFieldActionPerformed

    private void viewUserLoggedInTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLoggedInTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLoggedInTextFieldActionPerformed

    private void viewUsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUsernameTextFieldActionPerformed

    private void viewUserFirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserFirstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserFirstNameTextFieldActionPerformed

    private void searchUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUsersButtonActionPerformed
        searchUsersTextField.setText("");
        loadDataToTableUsers(null);
    }//GEN-LAST:event_searchUsersButtonActionPerformed

    private void viewProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductButtonActionPerformed
        // TODO add your handling code here:
        System.out.println(productController.getList().data().size());
    }//GEN-LAST:event_viewProductButtonActionPerformed

    private void confirmDeleteUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmDeleteUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmDeleteUser1ActionPerformed

    private void cancelDeleteUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDeleteUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelDeleteUser1ActionPerformed

    private void viewUserLastNameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLastNameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLastNameTextField1ActionPerformed

    private void viewUserPhoneNumberTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserPhoneNumberTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserPhoneNumberTextField1ActionPerformed

    private void viewUserEmailTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserEmailTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserEmailTextField1ActionPerformed

    private void viewUserWhenCreatedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserWhenCreatedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserWhenCreatedTextField1ActionPerformed

    private void viewUserLastUpdatedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLastUpdatedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLastUpdatedTextField1ActionPerformed

    private void cancelAddUserDiaglogButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddUserDiaglogButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelAddUserDiaglogButton2ActionPerformed

    private void editUserDiaglogButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserDiaglogButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editUserDiaglogButton3ActionPerformed

    private void viewUserLastLoggedInTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLastLoggedInTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLastLoggedInTextField1ActionPerformed

    private void viewUserLoggedInTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserLoggedInTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserLoggedInTextField1ActionPerformed

    private void viewUsernameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUsernameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUsernameTextField1ActionPerformed

    private void viewUserFirstNameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUserFirstNameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUserFirstNameTextField1ActionPerformed

    private void productProcessorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productProcessorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productProcessorTextFieldActionPerformed

    private void productStorageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productStorageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productStorageTextFieldActionPerformed

    private void productDisplayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDisplayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productDisplayTextFieldActionPerformed

    private void productBatteryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBatteryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productBatteryTextFieldActionPerformed

    private void productCardTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCardTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productCardTextFieldActionPerformed

    private void addProductDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductDiaglogButtonActionPerformed
        String name = productNameTextField.getText();
        String processor = productProcessorTextField.getText();
        String ram = productMemoryTextField.getText();
        String storage = productStorageTextField.getText();
        String display = productDisplayTextField.getText();
        String battery = productBatteryTextField.getText();
        String card = productCardTextField.getText();
        String weight = productWeightTextField.getText();
        
        if (InputValidator.anyBlankInput(name, processor, ram, storage, display, battery, card, weight)) {
            showDiaglogMessage(ErrorMessage.Product.BLANK_INPUT);
            return;
        }
        
        CommonResponseDTO response = productController.addOne(
                Product.builder()
                        .name(name)
                        .processor(processor)
                        .memory(ram)
                        .storage(storage)
                        .display(display)
                        .battery(battery)
                        .card(card)
                        .weight(weight)
                        .build()
        );
        
        this.addProductDiaglog.dispose();
        showDiaglogMessage(response.message());
        loadDataToTableProducts(null);
    }//GEN-LAST:event_addProductDiaglogButtonActionPerformed

    private void cancelAddProductDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddProductDiaglogButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelAddProductDiaglogButtonActionPerformed

    private void productWeightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productWeightTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productWeightTextFieldActionPerformed

    private void productMemoryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productMemoryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productMemoryTextFieldActionPerformed

    private void productNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameTextFieldActionPerformed

    private void editProductProcessorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductProcessorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductProcessorTextFieldActionPerformed

    private void editProductStorageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductStorageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductStorageTextFieldActionPerformed

    private void editProductDisplayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductDisplayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductDisplayTextFieldActionPerformed

    private void editProductBatteryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductBatteryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductBatteryTextFieldActionPerformed

    private void editProductCardTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductCardTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductCardTextFieldActionPerformed

    private void editProductDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductDiaglogButtonActionPerformed
        Integer id = Integer.valueOf(editProductIdTextField.getText());
        String name = editProductNameTextField.getText();
        String processor = editProductProcessorTextField.getText();
        String memory = editProductMemoryTextField.getText();
        String storage = editProductStorageTextField.getText();
        String display = editProductDisplayTextField.getText();
        String battery = editProductBatteryTextField.getText();
        String card = editProductCardTextField.getText();
        String weight = editProductWeightTextField.getText();
        
        CommonResponseDTO response = productController.updateOne(
                id, 
                Product.builder()
                        .name(name)
                        .processor(processor)
                        .memory(memory)
                        .storage(storage)
                        .display(display)
                        .battery(battery)
                        .card(card)
                        .weight(weight)
                        .build()
        );
        
        this.loadDataToTableProducts(null);
        this.editProductDiaglog.dispose();
        this.showDiaglogMessage(response.message());
        
    }//GEN-LAST:event_editProductDiaglogButtonActionPerformed

    private void cancelEditProductDiaglogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditProductDiaglogButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelEditProductDiaglogButtonActionPerformed

    private void editProductWeightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductWeightTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductWeightTextFieldActionPerformed

    private void editProductMemoryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductMemoryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductMemoryTextFieldActionPerformed

    private void editProductNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductNameTextFieldActionPerformed

    private void editProductIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editProductIdTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                if (ApplicationContext.getLoginedUser() == null) {
                    Login.main(new String[]{});
                } else {
                    new Home().setVisible(true);
                }
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JDialog addProductDiaglog;
    private javax.swing.JButton addProductDiaglogButton;
    private javax.swing.JPanel addProductDiaglogPanel;
    private javax.swing.JButton addUserButton;
    private javax.swing.JDialog addUserDiaglog;
    private javax.swing.JButton addUserDiaglogButton;
    private javax.swing.JPanel addUserDiaglogPanel;
    private javax.swing.JButton cancelAddProductDiaglogButton;
    private javax.swing.JButton cancelAddUserDiaglogButton;
    private javax.swing.JButton cancelAddUserDiaglogButton1;
    private javax.swing.JButton cancelAddUserDiaglogButton2;
    private javax.swing.JButton cancelDeleteUser;
    private javax.swing.JButton cancelDeleteUser1;
    private javax.swing.JButton cancelEditProductDiaglogButton;
    private javax.swing.JButton cancelEditUserDiaglogButton;
    private javax.swing.JButton confirmDeleteUser;
    private javax.swing.JButton confirmDeleteUser1;
    private javax.swing.JLabel confirmEmailOTPLabel;
    private javax.swing.JTextField confirmEmailOTPTextField;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JButton deleteProductButton;
    private javax.swing.JDialog deleteProductConfirmDiaglog;
    private javax.swing.JPanel deleteProductConfirmDiaglogPanel;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JDialog deleteUserConfirmDiaglog;
    private javax.swing.JLabel deleteUserConfirmDiaglogLabel;
    private javax.swing.JLabel deleteUserConfirmDiaglogLabel1;
    private javax.swing.JPanel deleteUserConfirmDiaglogPanel;
    private javax.swing.JDialog diaglogMessage;
    private javax.swing.JLabel diaglogMessageLabel;
    private javax.swing.JButton diaglogMessageOkButton;
    private javax.swing.JPanel diaglogMessagePanel;
    private javax.swing.JButton editBillItemButton;
    private javax.swing.JLabel editEmailLabel;
    private javax.swing.JTextField editEmailTextField;
    private javax.swing.JLabel editFirstNameLabel;
    private javax.swing.JTextField editFirstNameTextField;
    private javax.swing.JLabel editLastNameLabel;
    private javax.swing.JTextField editLastNameTextField;
    private javax.swing.JLabel editPhoneNumberLabel;
    private javax.swing.JTextField editPhoneNumberTextField;
    private javax.swing.JLabel editProductBatteryLabel;
    private javax.swing.JTextField editProductBatteryTextField;
    private javax.swing.JButton editProductButton;
    private javax.swing.JLabel editProductCardLabel;
    private javax.swing.JTextField editProductCardTextField;
    private javax.swing.JDialog editProductDiaglog;
    private javax.swing.JButton editProductDiaglogButton;
    private javax.swing.JPanel editProductDiaglogPanel;
    private javax.swing.JLabel editProductDisplayLabel;
    private javax.swing.JTextField editProductDisplayTextField;
    private javax.swing.JLabel editProductIdLabel;
    private javax.swing.JTextField editProductIdTextField;
    private javax.swing.JLabel editProductMemoryLabel;
    private javax.swing.JTextField editProductMemoryTextField;
    private javax.swing.JLabel editProductNameLabel;
    private javax.swing.JTextField editProductNameTextField;
    private javax.swing.JLabel editProductProcessorLabel;
    private javax.swing.JTextField editProductProcessorTextField;
    private javax.swing.JLabel editProductStorageLabel;
    private javax.swing.JTextField editProductStorageTextField;
    private javax.swing.JLabel editProductWeightLabel;
    private javax.swing.JTextField editProductWeightTextField;
    private javax.swing.JButton editUserButton;
    private javax.swing.JDialog editUserDiaglog;
    private javax.swing.JButton editUserDiaglogButton;
    private javax.swing.JButton editUserDiaglogButton1;
    private javax.swing.JButton editUserDiaglogButton3;
    private javax.swing.JLabel editUserDiaglogLabel;
    private javax.swing.JPanel editUserDiaglogPanel;
    private javax.swing.JLabel editUserIdLabel;
    private javax.swing.JTextField editUserIdTextField;
    private javax.swing.JLabel editUsernameLabel;
    private javax.swing.JTextField editUsernameTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel exportBillLabel;
    private javax.swing.JPanel exportBillPanel;
    private javax.swing.JPanel exportBillTab;
    private javax.swing.JLabel exportProductLabel;
    private javax.swing.JPanel exportProductPanel;
    private javax.swing.JPanel exportProductTab;
    private javax.swing.JButton exportProductsToExcelButton;
    private javax.swing.JButton exportUsersToExcelButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel importBillIdLabel;
    private javax.swing.JTextField importBillIdTextField;
    private javax.swing.JButton importBillItemFromExcelButton;
    private javax.swing.JLabel importBillLabel;
    private javax.swing.JPanel importBillPanel;
    private javax.swing.JButton importBillProductButton;
    private javax.swing.JPanel importBillTab;
    private javax.swing.JButton importProductAddButton;
    private javax.swing.JTextField importProductBillCreatorLabel;
    private javax.swing.JLabel importProductBillCreatorTextField;
    private javax.swing.JScrollPane importProductBillScrollPane;
    private javax.swing.JTable importProductBillTable;
    private javax.swing.JLabel importProductLabel;
    private javax.swing.JPanel importProductPanel;
    private javax.swing.JLabel importProductQuantityLabel;
    private javax.swing.JTextField importProductQuantityTextField;
    private javax.swing.JScrollPane importProductScrollPanel;
    private javax.swing.JPanel importProductTab;
    private javax.swing.JTable importProductTable;
    private javax.swing.JButton importProductsFromExcelButton;
    private javax.swing.JButton importUsersFromExcelButton;
    private javax.swing.JLabel inStockLabel;
    private javax.swing.JPanel inStockPanel;
    private javax.swing.JPanel inStockTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel loginedUsername;
    private javax.swing.JDialog logoutDiaglog;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JPanel logoutTab;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JLabel productBatteryLabel;
    private javax.swing.JTextField productBatteryTextField;
    private javax.swing.JComboBox<String> productBrandsComboBox;
    private javax.swing.JLabel productCardLabel;
    private javax.swing.JTextField productCardTextField;
    private javax.swing.JLabel productDisplayLabel;
    private javax.swing.JTextField productDisplayTextField;
    private javax.swing.JPanel productFunctionPanel;
    private javax.swing.JLabel productLabel;
    private javax.swing.JLabel productMemoryLabel;
    private javax.swing.JTextField productMemoryTextField;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JPanel productPanel;
    private javax.swing.JLabel productProcessorLabel;
    private javax.swing.JTextField productProcessorTextField;
    private javax.swing.JLabel productStorageLabel;
    private javax.swing.JTextField productStorageTextField;
    private javax.swing.JPanel productTab;
    private javax.swing.JLabel productWeightLabel;
    private javax.swing.JTextField productWeightTextField;
    private javax.swing.JScrollPane productsScrollPanel;
    private javax.swing.JTable productsTable;
    private javax.swing.JLabel providerLabel;
    private javax.swing.JComboBox<String> providerNameComboBox;
    private javax.swing.JLabel providerNameLabel;
    private javax.swing.JPanel providerPanel;
    private javax.swing.JPanel providerTab;
    private javax.swing.JButton removeBillItemButton;
    private javax.swing.JPanel searchImportProductPanel;
    private javax.swing.JButton searchImportProductRefreshButton;
    private javax.swing.JTextField searchImportProductTextField;
    private javax.swing.JButton searchProductsButton1;
    private javax.swing.JPanel searchProductsPanel;
    private javax.swing.JTextField searchProductsTextField1;
    private javax.swing.JButton searchUsersButton;
    private javax.swing.JPanel searchUsersPanel;
    private javax.swing.JTextField searchUsersTextField;
    private javax.swing.JButton sendCodeAddUserDiaglogButton;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel statisticsLabel;
    private javax.swing.JPanel statisticsPanel;
    private javax.swing.JPanel statisticsTab;
    private javax.swing.JLabel totalImportBillLabel;
    private javax.swing.JLabel totalValueLabel;
    private javax.swing.JLabel updateInfoLabel;
    private javax.swing.JPanel updateInfoTab;
    private javax.swing.JPanel userFunctionPanel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel userTab;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JScrollPane usersScrollPanel;
    private javax.swing.JTable usersTable;
    private javax.swing.JButton viewProductButton;
    private javax.swing.JDialog viewProductDiaglog;
    private javax.swing.JPanel viewProductDiaglogPanel;
    private javax.swing.JButton viewUserButton;
    private javax.swing.JDialog viewUserDiaglog;
    private javax.swing.JPanel viewUserDiaglogPanel;
    private javax.swing.JLabel viewUserEmailLabel;
    private javax.swing.JLabel viewUserEmailLabel1;
    private javax.swing.JTextField viewUserEmailTextField;
    private javax.swing.JTextField viewUserEmailTextField1;
    private javax.swing.JLabel viewUserFirstNameLabel;
    private javax.swing.JLabel viewUserFirstNameLabel1;
    private javax.swing.JTextField viewUserFirstNameTextField;
    private javax.swing.JTextField viewUserFirstNameTextField1;
    private javax.swing.JLabel viewUserLastLoggedInLabel;
    private javax.swing.JLabel viewUserLastLoggedInLabel1;
    private javax.swing.JTextField viewUserLastLoggedInTextField;
    private javax.swing.JTextField viewUserLastLoggedInTextField1;
    private javax.swing.JLabel viewUserLastNameLabel;
    private javax.swing.JLabel viewUserLastNameLabel1;
    private javax.swing.JTextField viewUserLastNameTextField;
    private javax.swing.JTextField viewUserLastNameTextField1;
    private javax.swing.JLabel viewUserLastUpdatedLabel;
    private javax.swing.JLabel viewUserLastUpdatedLabel1;
    private javax.swing.JTextField viewUserLastUpdatedTextField;
    private javax.swing.JTextField viewUserLastUpdatedTextField1;
    private javax.swing.JLabel viewUserLoggedInLabel;
    private javax.swing.JLabel viewUserLoggedInLabel1;
    private javax.swing.JTextField viewUserLoggedInTextField;
    private javax.swing.JTextField viewUserLoggedInTextField1;
    private javax.swing.JLabel viewUserPhoneNumberLabel;
    private javax.swing.JLabel viewUserPhoneNumberLabel1;
    private javax.swing.JTextField viewUserPhoneNumberTextField;
    private javax.swing.JTextField viewUserPhoneNumberTextField1;
    private javax.swing.JLabel viewUserWhenCreatedLabel;
    private javax.swing.JLabel viewUserWhenCreatedLabel1;
    private javax.swing.JTextField viewUserWhenCreatedTextField;
    private javax.swing.JTextField viewUserWhenCreatedTextField1;
    private javax.swing.JLabel viewUsernameLabel;
    private javax.swing.JLabel viewUsernameLabel1;
    private javax.swing.JTextField viewUsernameTextField;
    private javax.swing.JTextField viewUsernameTextField1;
    // End of variables declaration//GEN-END:variables
}
