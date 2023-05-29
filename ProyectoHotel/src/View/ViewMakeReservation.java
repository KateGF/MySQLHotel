package View;

import Controller.AmmenityController;
import Controller.PaymentController;
import Controller.ReservationController;
import Controller.RoomController;
import Model.AmenityModel;
import Model.HotelModel;
import Model.PaymentMethod;
import Model.ReservationXRoomModel;
import Model.Review;
import Model.RoomModel;
import Model.UserModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author josep
 */
public class ViewMakeReservation extends javax.swing.JFrame {

    /**
     * Creates new form Reservacion
     */
    public ViewMakeReservation() {
        initComponents();
        setLocationRelativeTo(this);
    }

    UserModel user;
    HotelModel hotel;
    RoomModel room;
    ReservationXRoomModel reservationxroom;
    
    ArrayList<RoomModel> rooms;
    ArrayList<PaymentMethod> payments;
    MainWindowHotel windowHotel;
    
    public ViewMakeReservation(UserModel user, HotelModel hotel,MainWindowHotel windowHotel) {
        initComponents();
        setLocationRelativeTo(this);
        this.user = user;
        this.hotel = hotel;
        this.windowHotel = windowHotel;
        getRooms();
        getPayments();
        
        jComboBox2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                room = rooms.get(jComboBox2.getSelectedIndex()-1);
                list1.removeAll();
                ArrayList<AmenityModel> amenitiesByRoom = AmmenityController.getAmenitiesByRoom(room.getIdRoom());
                for (AmenityModel r : amenitiesByRoom) {
                    list1.addItem(r.getName());
                }
                Price.setText(room.getRecommendedPrice()+ "");
            }
        });
    }

    void getRooms() {
        rooms = RoomController.getRooms(this.hotel.getIdHotel());
        for (RoomModel r : rooms) {
            jComboBox2.addItem(r.getName());
        }
    }
    
    void getPayments() {
        payments = PaymentController.getPayments();
        for (PaymentMethod p : payments) {
            jComboBox3.addItem(p.getNamePaymentMethod());
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
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jdcFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        list1 = new java.awt.List();
        jLabel12 = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 70, 80));
        jPanel1.setForeground(new java.awt.Color(240, 248, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(240, 248, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 248, 255));
        jLabel5.setText("NUMBER OF PEOPLE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 152, -1));

        jComboBox1.setBackground(new java.awt.Color(240, 248, 255));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 159, -1));

        jButton1.setText("PAY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 120, 50));

        jLabel4.setBackground(new java.awt.Color(240, 248, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 248, 255));
        jLabel4.setText("CHECK OUT");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        jLabel3.setBackground(new java.awt.Color(240, 248, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 248, 255));
        jLabel3.setText("CHECK IN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 60, -1));

        jLabel2.setBackground(new java.awt.Color(240, 248, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 248, 255));
        jLabel2.setText("GENERAL INFORMATION");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jLabel1.setBackground(new java.awt.Color(240, 248, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 248, 255));
        jLabel1.setText("Recommended Price");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jLabel7.setBackground(new java.awt.Color(240, 248, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 248, 255));
        jLabel7.setText("RESERVATION ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 155, 21));
        jPanel1.add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 120, -1));
        jPanel1.add(jdcFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 110, -1));

        jLabel11.setBackground(new java.awt.Color(240, 248, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 248, 255));
        jLabel11.setText("Room Ammenities");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        list1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.add(list1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 170));

        jLabel12.setBackground(new java.awt.Color(240, 248, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 248, 255));
        jLabel12.setText("Rooms");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel1.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 110, 40));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Room" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 110, -1));

        jLabel8.setBackground(new java.awt.Color(240, 248, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 248, 255));
        jLabel8.setText("TYPE OF ROOM");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        jComboBox3.setBackground(new java.awt.Color(240, 248, 255));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 159, -1));

        jLabel9.setBackground(new java.awt.Color(240, 248, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 248, 255));
        jLabel9.setText("Payment");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //CHECKIN
        // Obtiene la fecha seleccionada en el componente JDateChooser
        Date mFecha = jdcFecha.getDate();

        // Almacena la fecha en una variable de tipo java.util.Date
        Date fecha = new Date(mFecha.getTime());

        // Realiza alguna operación con la variable fecha...
        //CHECK OUT
        // Obtiene la fecha seleccionada en el componente JDateChooser
        Date mFecha2 = jdcFecha2.getDate();

        // Almacena la fecha en una variable de tipo java.util.Date
        Date fecha2 = new Date(mFecha2.getTime());

        // Realiza alguna operación con la variable fecha...
        PaymentMethod payment = payments.get(jComboBox3.getSelectedIndex());
        // ReservationController.insertReservation(hotel, room,user,payment.getIdPayment());
        int parseDouble = Integer.parseInt( room.getRecommendedPrice()+"");
        reservationxroom = new ReservationXRoomModel(parseDouble,
                fecha, fecha2, 0, room.getIdRoom(), 1);
        
         ReservationController.insertReservation(hotel, reservationxroom,user,1);
         this.dispose();
         windowHotel.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Price;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private com.toedter.calendar.JDateChooser jdcFecha2;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}
