/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Admin;

import Controller.HotelController;
import Controller.LocationsController;
import Model.HotelModel;
import Model.Location.Location;
import Model.Response;
import Model.UserModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class AdminCreateHotel extends javax.swing.JFrame {

    
     /**
     * Creates new form createHotel
     */
    public AdminCreateHotel() {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(2);
        AddCountries();
    }
    
   UserModel user;
    
    /**
     * Creates new form createHotel
     */
    public AdminCreateHotel(UserModel user) {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(2);
        AddCountries();
        this.user = user;
    }
    
    ArrayList<Location> countries;
    ArrayList<Location> states;
    ArrayList<Location> cantons;
    ArrayList<Location> districts;
    
    void AddCountries(){
     countries = LocationsController.getCountries();
        for (Location c : countries) {
            countryBox.addItem(c.getName());
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
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        countryBox = new javax.swing.JComboBox();
        stateBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        districtBox = new javax.swing.JComboBox();
        cantonBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        reserva = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        reserva1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        roomw = new javax.swing.JLabel();
        discountText = new javax.swing.JTextField();
        roomw1 = new javax.swing.JLabel();
        classText = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Country");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, -1));

        jPanel4.add(countryBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, -1));

        stateBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stateBoxMousePressed(evt);
            }
        });
        jPanel4.add(stateBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("State");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, -1));

        jPanel4.add(districtBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 140, -1));

        cantonBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cantonBoxMousePressed(evt);
            }
        });
        jPanel4.add(cantonBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 140, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Canton");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("District");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, -1));

        jButton12.setText("OK");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jButton13.setText("OK");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jButton14.setText("OK");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        jButton15.setText("OK");
        jPanel4.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        reserva.setBackground(new java.awt.Color(65, 65, 65));
        reserva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reserva.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reserva.setText("Name");
        reserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservaMouseClicked(evt);
            }
        });
        jPanel4.add(reserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 30));
        jPanel4.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 190, 30));

        reserva1.setBackground(new java.awt.Color(65, 65, 65));
        reserva1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reserva1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reserva1.setText("Register Date");
        reserva1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reserva1MouseClicked(evt);
            }
        });
        jPanel4.add(reserva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 100, 30));
        jPanel4.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 140, -1));

        roomw.setBackground(new java.awt.Color(0, 0, 0));
        roomw.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        roomw.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomw.setText("Discount");
        roomw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomwMouseClicked(evt);
            }
        });
        jPanel4.add(roomw, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 98, 31));
        jPanel4.add(discountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 142, -1));

        roomw1.setBackground(new java.awt.Color(0, 0, 0));
        roomw1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        roomw1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomw1.setText("Clasification");
        roomw1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomw1MouseClicked(evt);
            }
        });
        jPanel4.add(roomw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 98, 31));
        jPanel4.add(classText, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 142, -1));

        jButton11.setText("OK");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 70, 50));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(50, 70, 80));
        jLabel10.setText("CREATE HOTEL");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 213, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomwMouseClicked

    }//GEN-LAST:event_roomwMouseClicked

    private void reserva1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserva1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_reserva1MouseClicked

    private void reservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservaMouseClicked

    }//GEN-LAST:event_reservaMouseClicked
 void cantonPress() {
        int selectedIndex = cantonBox.getSelectedIndex();
        int id = cantons.get(selectedIndex).getID();
        districts = LocationsController.getDistrictsByCanton(id);
        districtBox.removeAllItems();
        for (Location c : districts) {
            districtBox.addItem(c.getName());
        }
        //  JOptionPane.showMessageDialog(this, countries.get(selectedIndex).getID());
    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        cantonPress();
    }//GEN-LAST:event_jButton14ActionPerformed
 void statePress() {
        try {
            int selectedIndex = stateBox.getSelectedIndex();
            int id = states.get(selectedIndex).getID();
            cantons = LocationsController.getCantonsByState(id);
            cantonBox.removeAllItems();
            for (Location c : cantons) {
                cantonBox.addItem(c.getName());
            }
            //  JOptionPane.showMessageDialog(this, countries.get(selectedIndex).getID()); 
        } catch (Exception e) {

        }
    }
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        statePress();
    }//GEN-LAST:event_jButton13ActionPerformed
 void countryBoxPress() {
        int selectedIndex = countryBox.getSelectedIndex();
        int id = countries.get(selectedIndex).getID();
        states = LocationsController.getStatesByCountry(id);
        stateBox.removeAllItems();
        for (Location c : states) {
            stateBox.addItem(c.getName());
        }
        //  JOptionPane.showMessageDialog(this, countries.get(selectedIndex).getID());
    }
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        countryBoxPress();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void cantonBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantonBoxMousePressed

    }//GEN-LAST:event_cantonBoxMousePressed

    private void stateBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stateBoxMousePressed

    }//GEN-LAST:event_stateBoxMousePressed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String name = nameText.getText();
        Date registerDate = jDateChooser1.getDate();
        int district = districts.get(districtBox.getSelectedIndex()).getID();
        int discount = Integer.parseInt(classText.getText());
        int classi = Integer.parseInt(discountText.getText());
        
        HotelModel hotel = new HotelModel(0, name, registerDate, discount, classi, district);
        
        Response insertHotel = HotelController.insertHotel(hotel,user);
        JOptionPane.showMessageDialog(this, insertHotel.getMessage());
        this.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void roomw1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomw1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_roomw1MouseClicked

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
            java.util.logging.Logger.getLogger(AdminCreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminCreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminCreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminCreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminCreateHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cantonBox;
    private javax.swing.JTextField classText;
    private javax.swing.JComboBox countryBox;
    private javax.swing.JTextField discountText;
    private javax.swing.JComboBox districtBox;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel reserva;
    private javax.swing.JLabel reserva1;
    private javax.swing.JLabel roomw;
    private javax.swing.JLabel roomw1;
    private javax.swing.JComboBox stateBox;
    // End of variables declaration//GEN-END:variables
}