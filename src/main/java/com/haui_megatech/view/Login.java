/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.haui_megatech.view;

import com.haui_megatech.ApplicationContext;
import com.haui_megatech.controller.AuthController;
import com.haui_megatech.dto.AuthRequestDTO;
import com.haui_megatech.dto.CommonResponseDTO;
import com.haui_megatech.repository.impl.UserRepositoryImpl;
import com.haui_megatech.service.impl.AuthServiceImpl;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author caoth
 */
public class Login extends javax.swing.JFrame {
    private final AuthController authController = new AuthController(
            new AuthServiceImpl(
                    new UserRepositoryImpl()
            )
    );
    
    
    /**
     * Creates new form Login_
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recoveryPasswordDiaglog = new javax.swing.JDialog();
        sendResetEmailPanel = new javax.swing.JPanel();
        sendRestEmailButton = new javax.swing.JButton();
        sendResetEmailLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sendResetCodePanel = new javax.swing.JPanel();
        sendResetCodeButton = new javax.swing.JButton();
        sendResetCodeLabel = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        updateNewPasswordPanel = new javax.swing.JPanel();
        updateNewPasswordButton = new javax.swing.JButton();
        updateNewPasswordLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        errorLoginDiaglog = new javax.swing.JDialog();
        errorLoginMainPanel = new javax.swing.JPanel();
        errorLoginMessage = new javax.swing.JLabel();
        errorLoginHeadingLabel = new javax.swing.JLabel();
        errorLoginOkButton = new javax.swing.JButton();
        left = new javax.swing.JPanel();
        right = new javax.swing.JPanel();
        dangNhapTittle = new javax.swing.JLabel();
        tendnlabel = new javax.swing.JLabel();
        uName = new javax.swing.JTextField();
        passlabel = new javax.swing.JLabel();
        uPass = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        forget = new javax.swing.JLabel();
        uNameError = new javax.swing.JLabel();
        uPassError = new javax.swing.JLabel();

        recoveryPasswordDiaglog.setTitle("Khôi phục mật khẩu");
        recoveryPasswordDiaglog.setBackground(new java.awt.Color(255, 255, 255));
        recoveryPasswordDiaglog.setMinimumSize(new java.awt.Dimension(700, 500));
        recoveryPasswordDiaglog.setPreferredSize(new java.awt.Dimension(700, 500));
        recoveryPasswordDiaglog.setSize(new java.awt.Dimension(700, 500));
        recoveryPasswordDiaglog.getContentPane().setLayout(null);

        sendResetEmailPanel.setBackground(new java.awt.Color(255, 255, 255));
        sendResetEmailPanel.setMinimumSize(new java.awt.Dimension(700, 500));
        sendResetEmailPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        sendResetEmailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sendRestEmailButton.setBackground(new java.awt.Color(44, 43, 196));
        sendRestEmailButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sendRestEmailButton.setForeground(new java.awt.Color(255, 255, 255));
        sendRestEmailButton.setText("Gửi mã xác nhận");
        sendRestEmailButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendRestEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendRestEmailButtonActionPerformed(evt);
            }
        });
        sendResetEmailPanel.add(sendRestEmailButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 580, 44));

        sendResetEmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sendResetEmailLabel.setText("Nhập địa chỉ email");
        sendResetEmailPanel.add(sendResetEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jPanel1.setBackground(new java.awt.Color(44, 43, 196));

        jLabel5.setBackground(new java.awt.Color(44, 43, 196));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KHÔI PHỤC MẬT KHẨU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        sendResetEmailPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 120));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        sendResetEmailPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 580, 44));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        jLabel2.setText("Quay về trang đăng nhập");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setDoubleBuffered(true);
        jLabel2.setFocusCycleRoot(true);
        sendResetEmailPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 370, 40));

        recoveryPasswordDiaglog.getContentPane().add(sendResetEmailPanel);
        sendResetEmailPanel.setBounds(0, 0, 700, 500);

        sendResetCodePanel.setBackground(new java.awt.Color(255, 255, 255));
        sendResetCodePanel.setMinimumSize(new java.awt.Dimension(700, 500));
        sendResetCodePanel.setPreferredSize(new java.awt.Dimension(700, 500));
        sendResetCodePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sendResetCodeButton.setBackground(new java.awt.Color(44, 43, 196));
        sendResetCodeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sendResetCodeButton.setForeground(new java.awt.Color(255, 255, 255));
        sendResetCodeButton.setText("Xác nhận");
        sendResetCodeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendResetCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendResetCodeButtonActionPerformed(evt);
            }
        });
        sendResetCodePanel.add(sendResetCodeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 580, 44));

        sendResetCodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sendResetCodeLabel.setText("Nhập mã xác nhận");
        sendResetCodePanel.add(sendResetCodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sendResetCodePanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 580, 44));

        jPanel3.setBackground(new java.awt.Color(44, 43, 196));

        jLabel3.setBackground(new java.awt.Color(44, 43, 196));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("KHÔI PHỤC MẬT KHẨU");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        sendResetCodePanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 120));

        recoveryPasswordDiaglog.getContentPane().add(sendResetCodePanel);
        sendResetCodePanel.setBounds(0, 0, 700, 500);

        updateNewPasswordPanel.setBackground(new java.awt.Color(255, 255, 255));
        updateNewPasswordPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        updateNewPasswordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateNewPasswordButton.setBackground(new java.awt.Color(44, 43, 196));
        updateNewPasswordButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateNewPasswordButton.setForeground(new java.awt.Color(255, 255, 255));
        updateNewPasswordButton.setText("Cập nhật mật khẩu");
        updateNewPasswordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateNewPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateNewPasswordButtonActionPerformed(evt);
            }
        });
        updateNewPasswordPanel.add(updateNewPasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 580, 44));

        updateNewPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateNewPasswordLabel.setText("Nhập mật khẩu mới");
        updateNewPasswordPanel.add(updateNewPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jPanel4.setBackground(new java.awt.Color(44, 43, 196));

        jLabel4.setBackground(new java.awt.Color(44, 43, 196));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("KHÔI PHỤC MẬT KHẨU");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        updateNewPasswordPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 120));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateNewPasswordPanel.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 580, 44));

        recoveryPasswordDiaglog.getContentPane().add(updateNewPasswordPanel);
        updateNewPasswordPanel.setBounds(0, 0, 700, 500);

        errorLoginDiaglog.setTitle("Lỗi đăng nhập");
        errorLoginDiaglog.setMinimumSize(new java.awt.Dimension(520, 300));
        errorLoginDiaglog.setPreferredSize(new java.awt.Dimension(520, 300));
        errorLoginDiaglog.setSize(new java.awt.Dimension(520, 300));
        errorLoginDiaglog.getContentPane().setLayout(null);

        errorLoginMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        errorLoginMainPanel.setMaximumSize(new java.awt.Dimension(520, 300));
        errorLoginMainPanel.setMinimumSize(new java.awt.Dimension(520, 300));
        errorLoginMainPanel.setPreferredSize(new java.awt.Dimension(520, 300));
        errorLoginMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        errorLoginMessage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        errorLoginMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLoginMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/error.24.png"))); // NOI18N
        errorLoginMessage.setText("tên đăng nhập hoặc mật khẩu không được để trôngsldjfdlfj dlfjdfdjflfjljfldjsffljflfj");
        errorLoginMessage.setDoubleBuffered(true);
        errorLoginMessage.setMaximumSize(new java.awt.Dimension(520, 70));
        errorLoginMessage.setMinimumSize(new java.awt.Dimension(400, 70));
        errorLoginMessage.setPreferredSize(new java.awt.Dimension(400, 70));
        errorLoginMainPanel.add(errorLoginMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 520, 70));

        errorLoginHeadingLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        errorLoginHeadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLoginHeadingLabel.setText("Lỗi đăng nhập");
        errorLoginMainPanel.add(errorLoginHeadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 500, -1));

        errorLoginOkButton.setBackground(new java.awt.Color(44, 43, 196));
        errorLoginOkButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorLoginOkButton.setForeground(new java.awt.Color(255, 255, 255));
        errorLoginOkButton.setText("OK");
        errorLoginOkButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        errorLoginOkButton.setPreferredSize(new java.awt.Dimension(300, 200));
        errorLoginOkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                errorLoginOkButtonMouseClicked(evt);
            }
        });
        errorLoginMainPanel.add(errorLoginOkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 150, 40));

        errorLoginDiaglog.getContentPane().add(errorLoginMainPanel);
        errorLoginMainPanel.setBounds(0, 0, 520, 300);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBounds(new java.awt.Rectangle(10, 10, 0, 0));
        setSize(new java.awt.Dimension(1384, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left.setBackground(new java.awt.Color(44, 43, 196));

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        getContentPane().add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 692, 750));

        right.setBackground(new java.awt.Color(255, 255, 255));

        dangNhapTittle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        dangNhapTittle.setForeground(new java.awt.Color(44, 43, 196));
        dangNhapTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dangNhapTittle.setText("ĐĂNG NHẬP");

        tendnlabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tendnlabel.setText("Tên đăng nhập");

        uName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        uName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uNameActionPerformed(evt);
            }
        });

        passlabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        passlabel.setText("Mật khẩu");

        uPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        loginBtn.setBackground(new java.awt.Color(44, 43, 196));
        loginBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Đăng nhập");
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });

        forget.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        forget.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forget.setText("Quên mật khẩu?");
        forget.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forget.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        forget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgetMouseClicked(evt);
            }
        });

        uNameError.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        uNameError.setForeground(new java.awt.Color(255, 0, 0));

        uPassError.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        uPassError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addComponent(dangNhapTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(uPassError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(forget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rightLayout.createSequentialGroup()
                        .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tendnlabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passlabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(dangNhapTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(tendnlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uPass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uPassError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(forget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(195, 195, 195))
        );

        getContentPane().add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 0, 692, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetMouseClicked
        // TODO add your handling code here:
        this.recoveryPasswordDiaglog.setVisible(true);
        this.recoveryPasswordDiaglog.setLocationRelativeTo(this);

        this.sendResetCodePanel.setVisible(false);
        this.sendResetEmailPanel.setVisible(true);
        this.updateNewPasswordPanel.setVisible(false);

    }//GEN-LAST:event_forgetMouseClicked

    private void sendResetCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendResetCodeButtonActionPerformed
        // TODO add your handling code here:
        this.sendResetCodePanel.setVisible(false);
        this.sendResetEmailPanel.setVisible(false);
        this.updateNewPasswordPanel.setVisible(true);
    }//GEN-LAST:event_sendResetCodeButtonActionPerformed

    private void updateNewPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNewPasswordButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_updateNewPasswordButtonActionPerformed

    private void sendRestEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendRestEmailButtonActionPerformed
        // TODO add your handling code here:
        this.sendResetCodePanel.setVisible(true);
        this.sendResetEmailPanel.setVisible(false);
        this.updateNewPasswordPanel.setVisible(false);
    }//GEN-LAST:event_sendRestEmailButtonActionPerformed

    private void uNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uNameActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        String username = uName.getText();
        String password = String.valueOf(uPass.getPassword());
        CommonResponseDTO response = authController.authenticate(
                AuthRequestDTO
                        .builder()
                        .username(username)
                        .password(password)
                        .build()
        );
        if (response.success()) {
            this.dispose();
            Home.main(new String[]{});
        } else {
            errorLoginDiaglog.setVisible(true);
            errorLoginDiaglog.setLocationRelativeTo(null);
            errorLoginMessage.setText(response.message());
        }
    }//GEN-LAST:event_loginBtnMouseClicked

    private void errorLoginOkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorLoginOkButtonMouseClicked
        // TODO add your handling code here:
        errorLoginDiaglog.dispose();
    }//GEN-LAST:event_errorLoginOkButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                new Login().setVisible(true);
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dangNhapTittle;
    private javax.swing.JDialog errorLoginDiaglog;
    private javax.swing.JLabel errorLoginHeadingLabel;
    private javax.swing.JPanel errorLoginMainPanel;
    private javax.swing.JLabel errorLoginMessage;
    private javax.swing.JButton errorLoginOkButton;
    private javax.swing.JLabel forget;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel left;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel passlabel;
    private javax.swing.JDialog recoveryPasswordDiaglog;
    private javax.swing.JPanel right;
    private javax.swing.JButton sendResetCodeButton;
    private javax.swing.JLabel sendResetCodeLabel;
    private javax.swing.JPanel sendResetCodePanel;
    private javax.swing.JLabel sendResetEmailLabel;
    private javax.swing.JPanel sendResetEmailPanel;
    private javax.swing.JButton sendRestEmailButton;
    private javax.swing.JLabel tendnlabel;
    private javax.swing.JTextField uName;
    private javax.swing.JLabel uNameError;
    private javax.swing.JPasswordField uPass;
    private javax.swing.JLabel uPassError;
    private javax.swing.JButton updateNewPasswordButton;
    private javax.swing.JLabel updateNewPasswordLabel;
    private javax.swing.JPanel updateNewPasswordPanel;
    // End of variables declaration//GEN-END:variables
}
