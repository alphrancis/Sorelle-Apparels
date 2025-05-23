
package src.java;
import javax.swing.JOptionPane;
import java.util.Properties;
import java.util.Random;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingWorker;
/**
 *
 * @author owner
 */
//Declare username and its email
public class ForgotPassword extends javax.swing.JFrame {   	
        private int resetCode;
        private String userEmail;
        private String username;

    //Center the frame
    public ForgotPassword() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    //Establish Database connection and get the email and its username
     /*private boolean UserDatabase(String admin) {
        boolean exists = false;

        String query = "SELECT Email FROM sofdes_admin WHERE Username = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sofdes", "root", "");
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, admin);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                userEmail = rs.getString("Email");
                username = txtUser.getText(); // Set the username here
                exists = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
        return exists;
    }
     
    */
    
    private boolean isUsernameExists(String username) {
    boolean exists = false;
    String query = "SELECT Email FROM sofdes_admin WHERE Username = ?";

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sofdes", "root", "");
         PreparedStatement pst = conn.prepareStatement(query)) {

        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) { 
            userEmail = rs.getString("Email"); // Retrieve email
            exists = true; // Set to true if found
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }

    return exists; 
}
    //Send the email function
    private boolean sendEmail(String emailTo, int code) {
        final String senderEmail = "azarrclothing@gmail.com";//Who sends the code
        final String senderPass = "xncw crwq bjen xnyr"; //App Password

        Properties props = new Properties(); //Simple Mail Transfer Protocol Function
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session mailSession = Session.getInstance(props, new Authenticator() { //Send OTP Function
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPass);
            }
        });

        try {
            Message msg = new MimeMessage(mailSession); //Actual OTP Message
            msg.setFrom(new InternetAddress(senderEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            msg.setSubject("Reset Code");
            msg.setText("Your reset code is: " + code);

            Transport.send(msg);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        SendCodebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        VerifyCodebtn = new javax.swing.JButton();
        txtVer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(15, 158, 153));

        jPanel1.setBackground(new java.awt.Color(15, 158, 153));

        jLabel1.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel1.setText("Enter Username");

        txtUser.setBackground(new java.awt.Color(239, 233, 224));

        SendCodebtn.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        SendCodebtn.setText("Send Code");
        SendCodebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendCodebtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel2.setText("Verify");

        VerifyCodebtn.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        VerifyCodebtn.setText("Verify Code");
        VerifyCodebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyCodebtnActionPerformed(evt);
            }
        });

        txtVer.setBackground(new java.awt.Color(239, 233, 224));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtVer, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VerifyCodebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SendCodebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendCodebtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerifyCodebtn))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Send CODE if the username entered is found in the Database
    private void SendCodebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendCodebtnActionPerformed
      String username = txtUser.getText();

    if (!isUsernameExists(username)) {
        JOptionPane.showMessageDialog(null, "User not found. Enter a registered username.");
        return;
    }

    if (userEmail == null || userEmail.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error: No email associated with username.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Generate 6-digit random code
    resetCode = 100000 + new Random().nextInt(900000);
    System.out.println("Generated Code: " + resetCode);

    
    SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
        @Override
        protected Boolean doInBackground() {
            return sendEmail(userEmail, resetCode);
        }

        @Override
        protected void done() {
            String maskedEmail = maskEmail();
            try {
                if (get()) {
                    JOptionPane.showMessageDialog(null, "Code sent to your email\n" + maskedEmail, 
                                      "Email Notification", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error sending email.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    worker.execute(); 
    }//GEN-LAST:event_SendCodebtnActionPerformed

    
    private String maskEmail(){
        
        String[] parts = userEmail.split("@");
        if (parts.length != 2){
            System.err.print("Invalid email format");
        }
        String username = parts[0];
        String domain = parts[1];
        
        int middleIndex = username.length() / 2;

        String maskedEmail = username.charAt(0) +
                            "*".repeat(middleIndex - 1) +
                            username.charAt(middleIndex) +
                            "*".repeat(username.length() - middleIndex - 1) +
                            username.charAt(username.length() - 1);

        
        return maskedEmail + "@" + domain;
        
        
    }
   

        //Verify the Code sent through email
    private void VerifyCodebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyCodebtnActionPerformed
        
        try {
            int enteredCode = Integer.parseInt(txtVer.getText());

            if (enteredCode == resetCode) {
                JOptionPane.showMessageDialog(null, "Code Verified! Proceed to Reset Password.");
                this.dispose();
                new Reset(username, userEmail).setVisible(true);
                new LogIn().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Code! Please try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric code.");
        }
    }//GEN-LAST:event_VerifyCodebtnActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SendCodebtn;
    private javax.swing.JButton VerifyCodebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVer;
    // End of variables declaration//GEN-END:variables
}
