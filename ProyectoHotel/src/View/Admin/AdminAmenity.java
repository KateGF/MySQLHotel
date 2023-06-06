/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Admin;

import Controller.AmmenityController;
import Model.AmenityModel;
import Model.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class AdminAmenity extends javax.swing.JFrame {

    ArrayList<AmenityModel> ammenities;
    /**
     * Creates new form addAmenity
     */
    public AdminAmenity() {
        initComponents();
         this.setLocationRelativeTo(this);
         getAmmenities();
    }
         
    void getAmmenities() {     
        ammenities = AmmenityController.getAmenities();
        jComboBox2.removeAllItems();
        for (AmenityModel r : ammenities) {
            jComboBox2.addItem(r.getName().toString());
        }
        
        jComboBox2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int selectedIndex = jComboBox2.getSelectedIndex();
                if(selectedIndex!=-1){
                    AmenityModel amm = ammenities.get(selectedIndex);
              
                    jTextField1.setText(amm.getName()+ ""); 
                }
               
          
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jButton77 = new javax.swing.JButton();
        jButton277 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton278 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel13.setBackground(new java.awt.Color(50, 70, 80));

        jButton77.setBackground(new java.awt.Color(255, 192, 203));
        jButton77.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton77.setText("DELETE");
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });

        jButton277.setBackground(new java.awt.Color(152, 251, 152));
        jButton277.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton277.setText("ADD");
        jButton277.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton277ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(240, 248, 255));
        jLabel25.setText("SELECT :");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(240, 248, 255));
        jLabel26.setText("ADD/ EDIT AMENITIES");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton278.setBackground(new java.awt.Color(152, 251, 152));
        jButton278.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton278.setText("RENAME");
        jButton278.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton278ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel26))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox2, 0, 240, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton77)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jButton277, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton278, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton277, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton278, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        getContentPane().add(jPanel13, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
           int selectedIndex = jComboBox2.getSelectedIndex();
            AmenityModel amm = ammenities.get(selectedIndex);
                if(selectedIndex!=-1){
                     Response deleteAmenity = AmmenityController.deleteAmmenity(amm.getIdAmmenity());
                     JOptionPane.showMessageDialog(this, deleteAmenity.getMessage());
                     getAmmenities();
                }
      
    }//GEN-LAST:event_jButton77ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton277ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton277ActionPerformed
       // AmmenityController.insertAmmenity(FRAMEBITS, WIDTH)
       
        String x = jTextField1.getText();
        Response insertAmmenity = AmmenityController.insertAmmenity(x);
        JOptionPane.showMessageDialog(this, insertAmmenity.getMessage());
        getAmmenities();
    }//GEN-LAST:event_jButton277ActionPerformed

    private void jButton278ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton278ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton278ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAmenity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAmenity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAmenity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAmenity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAmenity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton277;
    private javax.swing.JButton jButton278;
    private javax.swing.JButton jButton77;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
