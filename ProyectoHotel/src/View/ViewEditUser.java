/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package View;
import Controller.GenderController;
import Controller.LocationsController;
import Controller.UserController;
import Model.Location.Location;
import Model.Response;
import Model.UserModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import Model.GenderModel;

/**
 *
 * @author guzka
 */
public class ViewEditUser extends javax.swing.JFrame {

    
    ArrayList<Location> countries;
    ArrayList<Location> states;
    ArrayList<Location> cantons;
    ArrayList<Location> districts;
    ArrayList<GenderModel> genders;
    
    /**
     * Creates new form Register
     */
    public ViewEditUser() {
        initComponents();
        this.setLocationRelativeTo(this);
        AddCountries();
        loadGenders();
        

    }
    
    /**
     * Creates new form Register
     */
    public ViewEditUser(UserModel user) {
        initComponents();
        this.setLocationRelativeTo(this);
        AddCountries();
        loadGenders();
        this.userName.setText(user.getUsername());
        this.name.setText(user.getFirstName());
        this.lastName.setText(user.getLastName());
        this.jDateChooser1.setDate(user.getBirthdate());

    }
    
    
        void loadGenders() {
        genders = GenderController.getGenders();
        for (GenderModel g : genders) {
            genderBox.addItem(g.getName());
           
        }
        }
void AddCountries() {
        countries = LocationsController.getCountries();
        for (Location c : countries) {
            countryBox.addItem(c.getName());
        }
    }

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
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEditUser().setVisible(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        nationality = new javax.swing.JTextField();
        stateBox = new javax.swing.JComboBox<>();
        countryBox = new javax.swing.JComboBox<>();
        phone = new javax.swing.JTextField();
        genderBox = new javax.swing.JComboBox<>();
        cantonBox = new javax.swing.JComboBox<>();
        password = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        secondSurname = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        middle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        districtBox = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 70, 80));

        nationality.setText("Costarican");

        stateBox.setBackground(new java.awt.Color(240, 248, 255));
        stateBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateBoxActionPerformed(evt);
            }
        });

        countryBox.setBackground(new java.awt.Color(240, 248, 255));
        countryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryBoxActionPerformed(evt);
            }
        });

        phone.setText("7185-2535");

        genderBox.setBackground(new java.awt.Color(240, 248, 255));
        genderBox.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        genderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderBoxActionPerformed(evt);
            }
        });

        cantonBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantonBoxActionPerformed(evt);
            }
        });

        password.setText("1234");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        userName.setText("aallanrd");
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        id.setText("123456");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        secondSurname.setText("-");
        secondSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondSurnameActionPerformed(evt);
            }
        });

        lastName.setText("-");
        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });

        middle.setText("-");
        middle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleActionPerformed(evt);
            }
        });

        name.setText("Allan");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        register.setBackground(new java.awt.Color(240, 248, 255));
        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        districtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtBoxActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(240, 248, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 248, 255));
        jLabel20.setText("USER SIGN IN ");

        jLabel21.setBackground(new java.awt.Color(240, 248, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 248, 255));
        jLabel21.setText("DISTRICT");

        jLabel22.setBackground(new java.awt.Color(240, 248, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(240, 248, 255));
        jLabel22.setText("LASTNAME");

        jLabel23.setBackground(new java.awt.Color(240, 248, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(240, 248, 255));
        jLabel23.setText("USERNAME");

        jLabel24.setBackground(new java.awt.Color(240, 248, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(240, 248, 255));
        jLabel24.setText("GENDER");

        jLabel25.setBackground(new java.awt.Color(240, 248, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(240, 248, 255));
        jLabel25.setText("FIRSTNAME");

        jLabel26.setBackground(new java.awt.Color(240, 248, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(240, 248, 255));
        jLabel26.setText("MIDDLE NAME");

        jLabel27.setBackground(new java.awt.Color(240, 248, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(240, 248, 255));
        jLabel27.setText("SECOND SURNAME");

        jLabel28.setBackground(new java.awt.Color(240, 248, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 248, 255));
        jLabel28.setText("PASSWORD");

        jLabel29.setBackground(new java.awt.Color(240, 248, 255));
        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(240, 248, 255));
        jLabel29.setText("PHONE NUMBER");

        jLabel30.setBackground(new java.awt.Color(240, 248, 255));
        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(240, 248, 255));
        jLabel30.setText("NATIONALITY");

        jLabel31.setBackground(new java.awt.Color(240, 248, 255));
        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(240, 248, 255));
        jLabel31.setText("IDENTIFICATION CARD");

        jLabel32.setBackground(new java.awt.Color(240, 248, 255));
        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(240, 248, 255));
        jLabel32.setText("BIRTHDATE");

        jLabel33.setBackground(new java.awt.Color(240, 248, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(240, 248, 255));
        jLabel33.setText("COUNTRY");

        jLabel34.setBackground(new java.awt.Color(240, 248, 255));
        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 248, 255));
        jLabel34.setText("STATE");

        jLabel35.setBackground(new java.awt.Color(240, 248, 255));
        jLabel35.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 248, 255));
        jLabel35.setText("CANTON");

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(countryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jLabel34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel24)
                        .addGap(177, 177, 177)
                        .addComponent(jLabel29)
                        .addGap(205, 205, 205)
                        .addComponent(stateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel30)
                        .addGap(223, 223, 223)
                        .addComponent(cantonBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(districtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(147, 147, 147)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(secondSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(middle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel25))
                                .addGap(161, 161, 161)
                                .addComponent(jLabel26)))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(97, 97, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel20)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(middle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel23)
                                .addGap(5, 5, 5)
                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(countryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))))
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel24))
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(stateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cantonBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(districtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(register)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void middleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed

        String SfirstName = name.getText();
        String SlastName = lastName.getText();
        String MiddleName = middle.getText();
        String SsecondSurname = secondSurname.getText();
        String SuserName = userName.getText();
        //String Sgender = gender.getSelectedItem().toString();
//        String Sphoto = photo.getText();
        String Spassword = password.getText();
        //String SphoneNumber = phone.getText();
        //String Snationality = nationality.getText();
        String idCard = id.getText();
        //Date SbirthDate = birthdate.getDate();
        Date SbirthDate = new Date();
        //String SCountry = country.getSelectedItem().toString();
        //String SState = state.getSelectedItem().toString();
       // int SDistrict = Integer.parseInt(district.getSelectedItem().toString());

        UserModel user = new UserModel(0,"", idCard, SfirstName, SlastName, 
                SsecondSurname, MiddleName, SuserName, Spassword, SbirthDate, 
                3, 4, 1, 7, 9);

        Response response = UserController.register_user(user);
        
        JOptionPane.showMessageDialog(this, response.getMessage());
        
        
    }//GEN-LAST:event_registerActionPerformed

    private void secondSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondSurnameActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void cantonBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantonBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantonBoxActionPerformed

    private void countryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryBoxActionPerformed

    private void stateBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateBoxActionPerformed

    private void districtBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_districtBoxActionPerformed

    private void genderBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       countryBoxPress();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       statePress();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      cantonPress();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
private void nameKeyTyped(java.awt.event.KeyEvent evt) {
              if(name.getText().length() >= 20){

            evt.consume();
        }
    }

    private void lastNameKeyTyped(java.awt.event.KeyEvent evt) {
               if(lastName.getText().length() >= 25){

            evt.consume();
        }
    }

    private void userNameKeyTyped(java.awt.event.KeyEvent evt) {
               if(userName.getText().length() >=20){

            evt.consume();
        }
    }

    private void phoneKeyTyped(java.awt.event.KeyEvent evt) {
               if(phone.getText().length() >= 15){

            evt.consume();
        }
    }

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {
               if(password.getText().length() >= 128){

            evt.consume();
        }
    }

    private void secondSurnameKeyTyped(java.awt.event.KeyEvent evt) {
              if(secondSurname.getText().length() >= 25){

            evt.consume();
        }
    }

    private void middleKeyTyped(java.awt.event.KeyEvent evt) {
               if(middle.getText().length() >= 25){

            evt.consume();
        }
    }

    private void idKeyTyped(java.awt.event.KeyEvent evt) {
               if(id.getText().length() >= 4){

            evt.consume();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cantonBox;
    private javax.swing.JComboBox<String> countryBox;
    private javax.swing.JComboBox<String> districtBox;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField middle;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nationality;
    private javax.swing.JTextField password;
    private javax.swing.JTextField phone;
    private javax.swing.JButton register;
    private javax.swing.JTextField secondSurname;
    private javax.swing.JComboBox<String> stateBox;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
