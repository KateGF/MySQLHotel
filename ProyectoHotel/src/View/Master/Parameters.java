/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Master;

import Controller.AmmenityController;
import Controller.ClassificationController;
import Controller.GenderController;
import Controller.LocationsController;
import Model.AmenityModel;
import Model.ClassificationModel;
import Model.GenderModel;
import Model.Location.Location;
import Model.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guzka
 */
public class Parameters extends javax.swing.JFrame {
    ArrayList<GenderModel> genders;
    
    ArrayList<AmenityModel> ammenities;
    ArrayList<ClassificationModel> classifi;
     
    
    
    /**
     * Creates new form editLocations
     */
    public Parameters() {
        initComponents();
        setLocationRelativeTo(this);
        AddCountries();
        getGender();
        getAmmenities();
        getClassifications();
    }
    String username; 
     public Parameters(String user) {
        initComponents();
        setLocationRelativeTo(this);
        AddCountries();
        getGender();
        this.username = user;
    }
    
    ArrayList<Location> countries;
    ArrayList<Location> states;
    ArrayList<Location> cantons;
    ArrayList<Location> districts;
    
    void AddCountries() {
        countries = LocationsController.getCountries();
        for (Location c : countries) {
            listCountry.add(c.getName());
        }
    }
    
    
    
    void getClassifications(){
         classifi = ClassificationController.getClassifications();
        classiBox.removeAllItems();
        for (ClassificationModel r : classifi) {
            classiBox.addItem(r.getName());
        }
        try{
         classiBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int selectedIndex = classiBox.getSelectedIndex();
                if(selectedIndex == -1){
                    
                }else{
                      ClassificationModel amm = classifi.get(selectedIndex);
                      jTextField1.setText(amm.getName()+ "");
                }
              
              
                
          
            }
        });}
        catch (Exception e ){
            
        }
    }
    
      void countryBoxPress() {
        int selectedIndex = listCountry.getSelectedIndex();
        int id = countries.get(selectedIndex).getID();
        jTextField3.setText(id + "");
        jTextField9.setText(id + "");
        countryName.setText(listCountry.getSelectedItem());
        
        states = LocationsController.getStatesByCountry(id);
        listState.removeAll();
        for (Location c : states) {
            listState.add(c.getName());
        }
        //  JOptionPane.showMessageDialog(this, countries.get(selectedIndex).getID());
    }
       void getGender(){
         
        genders = GenderController.getGenders();
        genderBox.removeAllItems();
        for (GenderModel r : genders) {
            genderBox.addItem(r.getName());
        }
        
        genderBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int selectedIndex = genderBox.getSelectedIndex();
                if(selectedIndex!=-1){
                       GenderModel gen = genders.get(selectedIndex);
                        jTextField1.setText(gen.getName()+ "");
                }
             
              
               
          
            }
        });
    
    }
    
      
        void statePress() {
        try {
            int selectedIndex = listState.getSelectedIndex();
            int id = states.get(selectedIndex).getID();
            stateName.setText(listState.getSelectedItem());
            jTextField8.setText(id + "");
            jTextField10.setText(id + "");
            cantons = LocationsController.getCantonsByState(id);
            listCantons.removeAll();
            for (Location c : cantons) {
                listCantons.add(c.getName());
            }
            //  JOptionPane.showMessageDialog(this, countries.get(selectedIndex).getID()); 
        } catch (Exception e) {

        }
    }
         void cantonPress() {
        int selectedIndex = listCantons.getSelectedIndex();
        int id = cantons.get(selectedIndex).getID();
        jTextField11.setText(id + "");
        cantonName.setText(listCantons.getSelectedItem());
        districts = LocationsController.getDistrictsByCanton(id);
        listDistricts.removeAll();
        for (Location c : districts) {
            listDistricts.add(c.getName());
        }
        //  JOptionPane.showMessageDialog(this, countries.get(selectedIndex).getID());
    }
         
        void getAmmenities() {     
        ammenities = AmmenityController.getAmenities();
        AmenityBox.removeAllItems();
        for (AmenityModel r : ammenities) {
            AmenityBox.addItem(r.getName().toString());
        }
        
        AmenityBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int selectedIndex = AmenityBox.getSelectedIndex();
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

        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        listCountry = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        countryName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        listState = new java.awt.List();
        jLabel3 = new javax.swing.JLabel();
        stateName = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        listCantons = new java.awt.List();
        jLabel5 = new javax.swing.JLabel();
        cantonName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        listDistricts = new java.awt.List();
        jLabel7 = new javax.swing.JLabel();
        districtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        listNationality = new java.awt.List();
        jLabel19 = new javax.swing.JLabel();
        NationalityName3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        NationalityID2 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        deleteGender = new javax.swing.JButton();
        insertGender = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        genderBox = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton278 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton77 = new javax.swing.JButton();
        addAmmenity = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        AmenityBox = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        txtAmmenity = new javax.swing.JTextField();
        jButton279 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        DeleteClasification = new javax.swing.JButton();
        insertClassi = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        classiBox = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        txtClassi = new javax.swing.JTextField();
        jButton280 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("Gender List: ");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Globe-26.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 70, 80));

        listCountry.setBackground(new java.awt.Color(255, 255, 225));
        listCountry.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        listCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCountryMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(50, 70, 80));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Countries");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME");

        countryName.setBackground(new java.awt.Color(255, 255, 225));
        countryName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Delete");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton9.setText("Add");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(255, 255, 225));
        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField9.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID");

        jPanel11.setBackground(new java.awt.Color(0, 15, 0));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("COUNTRY PARAMETER ");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel35))
                .addContainerGap())
        );

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Tag-26.png"))); // NOI18N

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape-Star2-26_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(listCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(countryName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))))
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30))))
        );

        jTabbedPane1.addTab("Countries", jPanel1);

        jPanel2.setBackground(new java.awt.Color(50, 70, 80));

        listState.setBackground(new java.awt.Color(255, 255, 225));
        listState.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        listState.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listStateMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAME");

        stateName.setBackground(new java.awt.Color(255, 255, 225));
        stateName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Delete");

        jTextField3.setBackground(new java.awt.Color(255, 255, 225));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField3.setEnabled(false);

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Selected ID");

        jTextField8.setBackground(new java.awt.Color(255, 255, 225));
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField8.setEnabled(false);

        jPanel8.setBackground(new java.awt.Color(0, 15, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("STATE PARAMETER ");

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("States by Country ID : ");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Tag-26.png"))); // NOI18N

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape-Star2-26_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listState, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stateName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton10))
                .addGap(39, 39, 39))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(listState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 197, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(37, 37, 37))))
        );

        jTabbedPane1.addTab("States", jPanel2);

        jPanel3.setBackground(new java.awt.Color(50, 70, 80));

        listCantons.setBackground(new java.awt.Color(255, 255, 225));
        listCantons.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        listCantons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCantonsMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NAME");

        cantonName.setBackground(new java.awt.Color(255, 255, 225));
        cantonName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("State");

        jTextField5.setBackground(new java.awt.Color(255, 255, 225));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("Delete");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cantons by State ID:");

        jTextField10.setBackground(new java.awt.Color(255, 255, 225));
        jTextField10.setEnabled(false);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton11.setText("Add");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTextField11.setBackground(new java.awt.Color(255, 255, 225));
        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField11.setEnabled(false);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Canton ID:");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Globe-26.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape-Star2-26_1.png"))); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Tag-26.png"))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(0, 15, 0));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("CANTON PARAMETER");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel25))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(listCantons, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cantonName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel23))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(4, 4, 4)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12))))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(41, 41, 41)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(listCantons, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cantonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel22))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(268, 268, 268)))))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cantons", jPanel3);

        jPanel4.setBackground(new java.awt.Color(50, 70, 80));

        listDistricts.setBackground(new java.awt.Color(255, 255, 225));
        listDistricts.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        listDistricts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDistrictsMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NAME");

        districtName.setBackground(new java.awt.Color(255, 255, 225));
        districtName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("District ID:");

        jTextField7.setBackground(new java.awt.Color(255, 255, 225));
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton8.setText("Delete");

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton12.setText("Add ");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("District List: ");

        jPanel10.setBackground(new java.awt.Color(0, 15, 0));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("DISTRICT PARAMETER ");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel29))
                .addContainerGap())
        );

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Tag-26.png"))); // NOI18N

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape-Star2-26_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(listDistricts, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(60, 60, 60)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton8)
                                .addComponent(jButton7)))
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(districtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listDistricts, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(187, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(districtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton7)
                        .addGap(57, 57, 57)
                        .addComponent(jButton8)
                        .addGap(47, 47, 47))))
        );

        jTabbedPane1.addTab("Districts", jPanel4);

        jInternalFrame2.setVisible(true);

        jPanel6.setBackground(new java.awt.Color(50, 70, 80));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nationality List: ");

        listNationality.setBackground(new java.awt.Color(255, 255, 225));
        listNationality.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        listNationality.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNationalityMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("NAME");

        NationalityName3.setBackground(new java.awt.Color(255, 255, 225));
        NationalityName3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nationality ID:");

        NationalityID2.setBackground(new java.awt.Color(255, 255, 225));
        NationalityID2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton16.setText("Edit");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton17.setText("Delete");

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton18.setText("Add ");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(0, 15, 0));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("NATIONALITY PARAMETER");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel32))
                .addContainerGap())
        );

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Tag-26.png"))); // NOI18N

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/User-Profile-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(listNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(NationalityID2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(NationalityName3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addGap(0, 156, Short.MAX_VALUE)))))
                .addGap(26, 26, 26))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel33))
                        .addGap(8, 8, 8)
                        .addComponent(NationalityName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NationalityID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton16)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(listNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jInternalFrame2.getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Nationality", jInternalFrame2);

        jPanel13.setBackground(new java.awt.Color(50, 70, 80));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteGender.setBackground(new java.awt.Color(255, 192, 203));
        deleteGender.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        deleteGender.setText("DELETE");
        deleteGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGenderActionPerformed(evt);
            }
        });
        jPanel13.add(deleteGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 227, -1, 40));

        insertGender.setBackground(new java.awt.Color(152, 251, 152));
        insertGender.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        insertGender.setText("ADD");
        insertGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertGenderActionPerformed(evt);
            }
        });
        jPanel13.add(insertGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 349, 70, 40));

        jLabel43.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(240, 248, 255));
        jLabel43.setText("SELECT :");
        jPanel13.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, 60));

        genderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderBoxActionPerformed(evt);
            }
        });
        jPanel13.add(genderBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 226, 240, 40));

        jLabel44.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(240, 248, 255));
        jLabel44.setText("ADD/ EDIT Genders");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 137, -1, 60));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel13.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 348, 240, 41));

        jButton278.setBackground(new java.awt.Color(152, 251, 152));
        jButton278.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton278.setText("RENAME");
        jButton278.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton278ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton278, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 349, 102, 40));

        jPanel16.setBackground(new java.awt.Color(0, 15, 0));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("GENDER PARAMETER ");

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49))
                .addContainerGap())
        );

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Gender", jPanel5);

        jPanel14.setBackground(new java.awt.Color(50, 70, 80));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton77.setBackground(new java.awt.Color(255, 192, 203));
        jButton77.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton77.setText("DELETE");
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton77, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, 40));

        addAmmenity.setBackground(new java.awt.Color(152, 251, 152));
        addAmmenity.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        addAmmenity.setText("ADD");
        addAmmenity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAmmenityActionPerformed(evt);
            }
        });
        jPanel14.add(addAmmenity, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 70, 40));

        jLabel45.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(240, 248, 255));
        jLabel45.setText("SELECT :");
        jPanel14.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, 60));

        AmenityBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmenityBoxActionPerformed(evt);
            }
        });
        jPanel14.add(AmenityBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 240, 40));

        jLabel46.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(240, 248, 255));
        jLabel46.setText("ADD/ EDIT AMENITIES");
        jPanel14.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, 60));

        txtAmmenity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAmmenity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmmenityActionPerformed(evt);
            }
        });
        jPanel14.add(txtAmmenity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 240, 41));

        jButton279.setBackground(new java.awt.Color(152, 251, 152));
        jButton279.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton279.setText("RENAME");
        jButton279.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton279ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton279, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 102, 40));

        jPanel15.setBackground(new java.awt.Color(0, 15, 0));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("AMENITIES PARAMETER ");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel47))
                .addContainerGap())
        );

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Ammenity", jPanel12);

        jPanel19.setBackground(new java.awt.Color(50, 70, 80));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeleteClasification.setBackground(new java.awt.Color(255, 192, 203));
        DeleteClasification.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        DeleteClasification.setText("DELETE");
        DeleteClasification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClasificationActionPerformed(evt);
            }
        });
        jPanel19.add(DeleteClasification, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, 40));

        insertClassi.setBackground(new java.awt.Color(152, 251, 152));
        insertClassi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        insertClassi.setText("ADD");
        insertClassi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertClassiActionPerformed(evt);
            }
        });
        jPanel19.add(insertClassi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 70, 40));

        jLabel51.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(240, 248, 255));
        jLabel51.setText("SELECT :");
        jPanel19.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, 60));

        classiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classiBoxActionPerformed(evt);
            }
        });
        jPanel19.add(classiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 240, 40));

        jLabel52.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(240, 248, 255));
        jLabel52.setText("ADD/ EDIT Clasifications");
        jPanel19.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, 60));

        txtClassi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel19.add(txtClassi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 240, 41));

        jButton280.setBackground(new java.awt.Color(152, 251, 152));
        jButton280.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton280.setText("RENAME");
        jButton280.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton280ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton280, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 102, 40));

        jPanel17.setBackground(new java.awt.Color(0, 15, 0));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("CLASIFICATION PARAMETER ");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/icons/Shape18-26.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel54)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53))
                .addContainerGap())
        );

        jPanel19.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Classification", jPanel18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String name = cantonName.getText();
        int idState = Integer.parseInt(jTextField10.getText());
        String addCanton = LocationsController.addCanton( name,idState, username);
        JOptionPane.showMessageDialog(this, addCanton);
        listCantons.removeAll();
        statePress();
        jTextField9.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String newName = cantonName.getText();

        int idCanton= cantons.get(listCantons.getSelectedIndex()).getID();

        String editState = LocationsController.editCanton(newName,idCanton, username);

        JOptionPane.showMessageDialog(this, editState);
        listCantons.removeAll();
        statePress();
        jTextField11.setText("");
        cantonName.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void listCantonsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantonsMouseClicked
        cantonPress();
    }//GEN-LAST:event_listCantonsMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String name = stateName.getText();
        int idCountry = Integer.parseInt(jTextField3.getText());
        String addState = LocationsController.addState( name,idCountry, username);
        JOptionPane.showMessageDialog(this, addState);
        listState.removeAll();
        countryBoxPress();
        jTextField9.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String newName = stateName.getText();

        int idState= states.get(listState.getSelectedIndex()).getID();

        String editState = LocationsController.editState(newName,idState, username);

        JOptionPane.showMessageDialog(this, editState);
        listState.removeAll();
        countryBoxPress();
        jTextField8.setText("");
        stateName.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listStateMouseClicked
        statePress();
    }//GEN-LAST:event_listStateMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String name = districtName.getText();
        int idCanton = Integer.parseInt(jTextField11.getText());
        String addDistrict = LocationsController.addDistrict(name,idCanton, username);
        JOptionPane.showMessageDialog(this, addDistrict);
        listDistricts.removeAll();
        cantonPress();
        jTextField7.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String newName = districtName.getText();

        int idDistrict= districts.get(listDistricts.getSelectedIndex()).getID();

        String editState = LocationsController.editDistrict(newName,idDistrict, username);

        JOptionPane.showMessageDialog(this, editState);
        listDistricts.removeAll();
        cantonPress();
        jTextField7.setText("");
        cantonName.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void listDistrictsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDistrictsMouseClicked
        //districtPress();
        districtName.setText(listDistricts.getSelectedItem());
        jTextField7.setText(districts.get(listDistricts.getSelectedIndex()).getID()+"");
    }//GEN-LAST:event_listDistrictsMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String name = countryName.getText();
        String addCountry = LocationsController.addCountry( name, username);
        JOptionPane.showMessageDialog(this, addCountry);
        listCountry.removeAll();
        AddCountries();
        jTextField9.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String newName = countryName.getText();

        int idCountry= countries.get(listCountry.getSelectedIndex()).getID();

        String editCountry = LocationsController.editCountry( newName,idCountry, username);

        JOptionPane.showMessageDialog(this, editCountry);
        listCountry.removeAll();
        AddCountries();
        jTextField9.setText("");
        countryName.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCountryMouseClicked
        countryBoxPress();
    }//GEN-LAST:event_listCountryMouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void listNationalityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNationalityMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listNationalityMouseClicked

    private void deleteGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGenderActionPerformed
        // TODO add your handling code here:
        //DELETE
        int idGen = genders.get( genderBox.getSelectedIndex()).getIdGender();
        Response insertGender = GenderController.deleteGender(idGen);
        JOptionPane.showMessageDialog(this, insertGender.getMessage());
        getGender();
    }//GEN-LAST:event_deleteGenderActionPerformed

    private void insertGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertGenderActionPerformed
        // AmmenityController.insertAmmenity(FRAMEBITS, WIDTH)
        String x = jTextField1.getText();
        Response insertGender = GenderController.insertGender(x);
        JOptionPane.showMessageDialog(this, insertGender.getMessage());
        getGender();
    }//GEN-LAST:event_insertGenderActionPerformed

    private void genderBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderBoxActionPerformed

    private void jButton278ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton278ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton278ActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        int selectedIndex = AmenityBox.getSelectedIndex();
        AmenityModel amm = ammenities.get(selectedIndex);
        if(selectedIndex!=-1){
            Response deleteAmenity = AmmenityController.deleteAmmenity(amm.getIdAmmenity());
            JOptionPane.showMessageDialog(this, deleteAmenity.getMessage());
            getAmmenities();
        }

    }//GEN-LAST:event_jButton77ActionPerformed

    private void addAmmenityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAmmenityActionPerformed
        // AmmenityController.insertAmmenity(FRAMEBITS, WIDTH)

        String x = txtAmmenity.getText();
        Response insertAmmenity = AmmenityController.insertAmmenity(x);
        JOptionPane.showMessageDialog(this, insertAmmenity.getMessage());
        getAmmenities();
    }//GEN-LAST:event_addAmmenityActionPerformed

    private void AmenityBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmenityBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmenityBoxActionPerformed

    private void jButton279ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton279ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton279ActionPerformed

    private void txtAmmenityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmmenityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmmenityActionPerformed

    private void DeleteClasificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClasificationActionPerformed
        int idclass = classifi.get( classiBox.getSelectedIndex()).getIdclass();
        Response insertClassification = ClassificationController.deleteClassification(idclass);
        JOptionPane.showMessageDialog(this, insertClassification.getMessage());
        getClassifications();
    }//GEN-LAST:event_DeleteClasificationActionPerformed

    private void insertClassiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertClassiActionPerformed
        String x = txtClassi.getText();
        Response insertClassification = ClassificationController.insertClassification(x);
        JOptionPane.showMessageDialog(this, insertClassification.getMessage());
        getClassifications();
    }//GEN-LAST:event_insertClassiActionPerformed

    private void classiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classiBoxActionPerformed

    }//GEN-LAST:event_classiBoxActionPerformed

    private void jButton280ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton280ActionPerformed
        String x = txtClassi.getText();

        int idclass = classifi.get( classiBox.getSelectedIndex()).getIdclass();
        Response insertClassification = ClassificationController.editClassification(idclass,x);
        JOptionPane.showMessageDialog(this, insertClassification.getMessage());
        getClassifications();
    }//GEN-LAST:event_jButton280ActionPerformed

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
            java.util.logging.Logger.getLogger(Parameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parameters.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parameters().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AmenityBox;
    private javax.swing.JButton DeleteClasification;
    private javax.swing.JTextField NationalityID2;
    private javax.swing.JTextField NationalityName3;
    private javax.swing.JButton addAmmenity;
    private javax.swing.JTextField cantonName;
    private javax.swing.JComboBox<String> classiBox;
    private javax.swing.JTextField countryName;
    private javax.swing.JButton deleteGender;
    private javax.swing.JTextField districtName;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JButton insertClassi;
    private javax.swing.JButton insertGender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton278;
    private javax.swing.JButton jButton279;
    private javax.swing.JButton jButton280;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.awt.List listCantons;
    private java.awt.List listCountry;
    private java.awt.List listDistricts;
    private java.awt.List listNationality;
    private java.awt.List listState;
    private javax.swing.JTextField stateName;
    private javax.swing.JTextField txtAmmenity;
    private javax.swing.JTextField txtClassi;
    // End of variables declaration//GEN-END:variables
}
