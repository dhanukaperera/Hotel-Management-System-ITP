
package app.room_reservation;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.room_reservation.Reservations_Model;
import source.ImageProcessing;
import source.Validation;

public class Reservations_Frame extends javax.swing.JPanel 
{

    ImageProcessing changebtnImage = new ImageProcessing();
   
    Reservations_Model obj = new Reservations_Model();
    Validation val = new Validation();
    
    static boolean r01 = true;
    static boolean r02 = true;
    static boolean r03 = true;
    static boolean r04 = true;
    static boolean r05 = true;
    
    static boolean r06 = true;
    static boolean r07 = true;
    static boolean r08 = true;
    static boolean r09 = true;
    static boolean r10 = true;
    
    static boolean r11 = true;
    static boolean r12 = true;
    static boolean r13 = true;
    static boolean r14 = true;
    static boolean r15 = true;
    
   
    
    public Reservations_Frame() 
    {
        initComponents();
        
        obj.SetRoomTiiles();
        obj.defaultCountry();
        obj.setCurrentDate();
        obj.loadListFromDB("Room Type", "room_types", cmbRoomTypes);
        cmbRoomTypes.addItem("All");
        
        obj.hidePnlRoomTypes();
        
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NICS = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        buttonGroup15 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jdcCheckOutDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cmbNumOfNights = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblLeavingDate = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbNumOfAdults = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbNumOfChildren = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        lblTotalGuest = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblRoomNo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbRoomTypes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        pnlMealType_01 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMealType_01 = new javax.swing.JLabel();
        pnlMealType_02 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblMealType_02 = new javax.swing.JLabel();
        pnlMealType_03 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblMealType_03 = new javax.swing.JLabel();
        pnlMealType_04 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lblMealType_04 = new javax.swing.JLabel();
        pnlMealType_05 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        lblMealType_05 = new javax.swing.JLabel();
        pnlMealType_06 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        lblMealType_06 = new javax.swing.JLabel();
        pnlMealType_07 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        lblMealType_07 = new javax.swing.JLabel();
        pnlMealType_08 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        lblMealType_08 = new javax.swing.JLabel();
        pnlMealType_09 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        lblMealType_09 = new javax.swing.JLabel();
        pnlMealType_10 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        lblMealType_10 = new javax.swing.JLabel();
        pnlMealType_11 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        lblMealType_11 = new javax.swing.JLabel();
        pnlMealType_12 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        lblMealType_12 = new javax.swing.JLabel();
        pnlMealType_13 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        lblMealType_13 = new javax.swing.JLabel();
        pnlMealType_14 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        lblMealType_14 = new javax.swing.JLabel();
        pnlMealType_15 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        lblMealType_15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        pnlRoom_01 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblRoomRate_01 = new javax.swing.JLabel();
        lblRoomType_01 = new javax.swing.JLabel();
        lblMaxGuestCount_01 = new javax.swing.JLabel();
        rb_A_01 = new javax.swing.JRadioButton();
        rb_B_01 = new javax.swing.JRadioButton();
        rb_D_01 = new javax.swing.JRadioButton();
        rb_C_01 = new javax.swing.JRadioButton();
        lblBedType_01 = new javax.swing.JLabel();
        pnlRoom_02 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblRoomRate_02 = new javax.swing.JLabel();
        lblRoomType_02 = new javax.swing.JLabel();
        lblMaxGuestCount_02 = new javax.swing.JLabel();
        rb_A_02 = new javax.swing.JRadioButton();
        rb_B_02 = new javax.swing.JRadioButton();
        rb_D_02 = new javax.swing.JRadioButton();
        rb_C_02 = new javax.swing.JRadioButton();
        lblBedType_02 = new javax.swing.JLabel();
        pnlRoom_03 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        lblRoomRate_03 = new javax.swing.JLabel();
        lblRoomType_03 = new javax.swing.JLabel();
        lblMaxGuestCount_03 = new javax.swing.JLabel();
        rb_A_03 = new javax.swing.JRadioButton();
        rb_B_03 = new javax.swing.JRadioButton();
        rb_D_03 = new javax.swing.JRadioButton();
        rb_C_03 = new javax.swing.JRadioButton();
        lblBedType_03 = new javax.swing.JLabel();
        pnlRoom_04 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lblRoomRate_04 = new javax.swing.JLabel();
        lblRoomType_04 = new javax.swing.JLabel();
        lblMaxGuestCount_04 = new javax.swing.JLabel();
        rb_A_04 = new javax.swing.JRadioButton();
        rb_B_04 = new javax.swing.JRadioButton();
        rb_D_04 = new javax.swing.JRadioButton();
        rb_C_04 = new javax.swing.JRadioButton();
        lblBedType_04 = new javax.swing.JLabel();
        pnlRoom_05 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        lblRoomRate_05 = new javax.swing.JLabel();
        lblRoomType_05 = new javax.swing.JLabel();
        lblMaxGuestCount_05 = new javax.swing.JLabel();
        rb_A_05 = new javax.swing.JRadioButton();
        rb_B_05 = new javax.swing.JRadioButton();
        rb_D_05 = new javax.swing.JRadioButton();
        rb_C_05 = new javax.swing.JRadioButton();
        lblBedType_05 = new javax.swing.JLabel();
        pnlRoom_06 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        lblRoomRate_06 = new javax.swing.JLabel();
        lblRoomType_06 = new javax.swing.JLabel();
        lblMaxGuestCount_06 = new javax.swing.JLabel();
        rb_A_06 = new javax.swing.JRadioButton();
        rb_B_06 = new javax.swing.JRadioButton();
        rb_D_06 = new javax.swing.JRadioButton();
        rb_C_06 = new javax.swing.JRadioButton();
        lblBedType_06 = new javax.swing.JLabel();
        pnlRoom_07 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        lblRoomRate_07 = new javax.swing.JLabel();
        lblRoomType_07 = new javax.swing.JLabel();
        lblMaxGuestCount_07 = new javax.swing.JLabel();
        rb_A_07 = new javax.swing.JRadioButton();
        rb_B_07 = new javax.swing.JRadioButton();
        rb_D_07 = new javax.swing.JRadioButton();
        rb_C_07 = new javax.swing.JRadioButton();
        lblBedType_07 = new javax.swing.JLabel();
        pnlRoom_08 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        lblRoomRate_08 = new javax.swing.JLabel();
        lblRoomType_08 = new javax.swing.JLabel();
        lblMaxGuestCount_08 = new javax.swing.JLabel();
        rb_A_08 = new javax.swing.JRadioButton();
        rb_B_08 = new javax.swing.JRadioButton();
        rb_D_08 = new javax.swing.JRadioButton();
        rb_C_08 = new javax.swing.JRadioButton();
        lblBedType_08 = new javax.swing.JLabel();
        pnlRoom_09 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        lblRoomRate_09 = new javax.swing.JLabel();
        lblRoomType_09 = new javax.swing.JLabel();
        lblMaxGuestCount_09 = new javax.swing.JLabel();
        rb_A_09 = new javax.swing.JRadioButton();
        rb_B_09 = new javax.swing.JRadioButton();
        rb_D_09 = new javax.swing.JRadioButton();
        rb_C_09 = new javax.swing.JRadioButton();
        lblBedType_09 = new javax.swing.JLabel();
        pnlRoom_10 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        lblRoomRate_10 = new javax.swing.JLabel();
        lblRoomType_10 = new javax.swing.JLabel();
        lblMaxGuestCount_10 = new javax.swing.JLabel();
        rb_A_10 = new javax.swing.JRadioButton();
        rb_B_10 = new javax.swing.JRadioButton();
        rb_D_10 = new javax.swing.JRadioButton();
        rb_C_10 = new javax.swing.JRadioButton();
        lblBedType_10 = new javax.swing.JLabel();
        pnlRoom_11 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        lblRoomRate_11 = new javax.swing.JLabel();
        lblRoomType_11 = new javax.swing.JLabel();
        lblMaxGuestCount_11 = new javax.swing.JLabel();
        rb_A_11 = new javax.swing.JRadioButton();
        rb_B_11 = new javax.swing.JRadioButton();
        rb_D_11 = new javax.swing.JRadioButton();
        rb_C_11 = new javax.swing.JRadioButton();
        lblBedType_11 = new javax.swing.JLabel();
        pnlRoom_12 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        lblRoomRate_12 = new javax.swing.JLabel();
        lblRoomType_12 = new javax.swing.JLabel();
        lblMaxGuestCount_12 = new javax.swing.JLabel();
        rb_A_12 = new javax.swing.JRadioButton();
        rb_B_12 = new javax.swing.JRadioButton();
        rb_D_12 = new javax.swing.JRadioButton();
        rb_C_12 = new javax.swing.JRadioButton();
        lblBedType_12 = new javax.swing.JLabel();
        pnlRoom_13 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        lblRoomRate_13 = new javax.swing.JLabel();
        lblRoomType_13 = new javax.swing.JLabel();
        lblMaxGuestCount_13 = new javax.swing.JLabel();
        rb_A_13 = new javax.swing.JRadioButton();
        rb_B_13 = new javax.swing.JRadioButton();
        rb_D_13 = new javax.swing.JRadioButton();
        rb_C_13 = new javax.swing.JRadioButton();
        lblBedType_13 = new javax.swing.JLabel();
        pnlRoom_14 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        lblRoomRate_14 = new javax.swing.JLabel();
        lblRoomType_14 = new javax.swing.JLabel();
        lblMaxGuestCount_14 = new javax.swing.JLabel();
        rb_A_14 = new javax.swing.JRadioButton();
        rb_B_14 = new javax.swing.JRadioButton();
        rb_D_14 = new javax.swing.JRadioButton();
        rb_C_14 = new javax.swing.JRadioButton();
        lblBedType_14 = new javax.swing.JLabel();
        pnlRoom_15 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        lblRoomRate_15 = new javax.swing.JLabel();
        lblRoomType_15 = new javax.swing.JLabel();
        lblMaxGuestCount_15 = new javax.swing.JLabel();
        rb_A_15 = new javax.swing.JRadioButton();
        rb_B_15 = new javax.swing.JRadioButton();
        rb_D_15 = new javax.swing.JRadioButton();
        rb_C_15 = new javax.swing.JRadioButton();
        lblBedType_15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        txtNicPass = new javax.swing.JTextField();
        cmbTitel = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtZip = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox<>();
        txtAge = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));

        jButton1.setBackground(new java.awt.Color(149, 165, 166));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setOpaque(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(46, 204, 113));
        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Make Reservation");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(26, 188, 156));
        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Check Available Rooms");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(155, 89, 182));
        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Refresh");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setOpaque(true);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel8.setMinimumSize(new java.awt.Dimension(250, 405));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Arrival Day");

        jdcCheckOutDate.setDateFormatString("yyyy-MM-dd");
        jdcCheckOutDate.setFocusable(false);
        jdcCheckOutDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jdcCheckOutDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdcCheckOutDateMouseClicked(evt);
            }
        });
        jdcCheckOutDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcCheckOutDatePropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Number Of Nights");

        cmbNumOfNights.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbNumOfNights.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        cmbNumOfNights.setFocusable(false);
        cmbNumOfNights.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbNumOfNightsMouseClicked(evt);
            }
        });
        cmbNumOfNights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNumOfNightsActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Leaving Day");

        lblLeavingDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLeavingDate.setText(" ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Number Of Adults");

        cmbNumOfAdults.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbNumOfAdults.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", " " }));
        cmbNumOfAdults.setFocusable(false);
        cmbNumOfAdults.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbNumOfAdultsPropertyChange(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Number Of Children");

        cmbNumOfChildren.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbNumOfChildren.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", " " }));
        cmbNumOfChildren.setFocusable(false);
        cmbNumOfChildren.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbNumOfChildrenPropertyChange(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Total Guest");

        lblTotalGuest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalGuest.setText("0");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Total Rooms");

        lblRoomNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomNo.setText("0");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Room Type");

        cmbRoomTypes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbRoomTypes.setFocusable(false);
        cmbRoomTypes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbRoomTypesMouseClicked(evt);
            }
        });
        cmbRoomTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoomTypesActionPerformed(evt);
            }
        });
        cmbRoomTypes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbRoomTypesPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRoomNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcCheckOutDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(cmbNumOfNights, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLeavingDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbNumOfAdults, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbNumOfChildren, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbRoomTypes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbRoomTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbNumOfNights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblLeavingDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblRoomNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbNumOfAdults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(cmbNumOfChildren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(lblTotalGuest))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reservation Deatils");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlMealType_01.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Room No 01 - ");

        lblMealType_01.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_01.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_01Layout = new javax.swing.GroupLayout(pnlMealType_01);
        pnlMealType_01.setLayout(pnlMealType_01Layout);
        pnlMealType_01Layout.setHorizontalGroup(
            pnlMealType_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_01Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_01Layout.setVerticalGroup(
            pnlMealType_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(lblMealType_01))
        );

        pnlMealType_02.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Room No 02 - ");

        lblMealType_02.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_02.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_02Layout = new javax.swing.GroupLayout(pnlMealType_02);
        pnlMealType_02.setLayout(pnlMealType_02Layout);
        pnlMealType_02Layout.setHorizontalGroup(
            pnlMealType_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_02Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_02Layout.setVerticalGroup(
            pnlMealType_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel16)
                .addComponent(lblMealType_02))
        );

        pnlMealType_03.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Room No 03 - ");

        lblMealType_03.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_03.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_03Layout = new javax.swing.GroupLayout(pnlMealType_03);
        pnlMealType_03.setLayout(pnlMealType_03Layout);
        pnlMealType_03Layout.setHorizontalGroup(
            pnlMealType_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_03Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_03Layout.setVerticalGroup(
            pnlMealType_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel23)
                .addComponent(lblMealType_03))
        );

        pnlMealType_04.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setText("Room No 04 - ");

        lblMealType_04.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_04.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_04Layout = new javax.swing.GroupLayout(pnlMealType_04);
        pnlMealType_04.setLayout(pnlMealType_04Layout);
        pnlMealType_04Layout.setHorizontalGroup(
            pnlMealType_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_04Layout.createSequentialGroup()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_04Layout.setVerticalGroup(
            pnlMealType_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel33)
                .addComponent(lblMealType_04))
        );

        pnlMealType_05.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setText("Room No 05 - ");

        lblMealType_05.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_05.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_05Layout = new javax.swing.GroupLayout(pnlMealType_05);
        pnlMealType_05.setLayout(pnlMealType_05Layout);
        pnlMealType_05Layout.setHorizontalGroup(
            pnlMealType_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_05Layout.createSequentialGroup()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_05Layout.setVerticalGroup(
            pnlMealType_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel38)
                .addComponent(lblMealType_05))
        );

        pnlMealType_06.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setText("Room No 06 - ");

        lblMealType_06.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_06.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_06Layout = new javax.swing.GroupLayout(pnlMealType_06);
        pnlMealType_06.setLayout(pnlMealType_06Layout);
        pnlMealType_06Layout.setHorizontalGroup(
            pnlMealType_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_06Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_06Layout.setVerticalGroup(
            pnlMealType_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel36)
                .addComponent(lblMealType_06))
        );

        pnlMealType_07.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel44.setText("Room No 07 - ");

        lblMealType_07.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_07.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_07Layout = new javax.swing.GroupLayout(pnlMealType_07);
        pnlMealType_07.setLayout(pnlMealType_07Layout);
        pnlMealType_07Layout.setHorizontalGroup(
            pnlMealType_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_07Layout.createSequentialGroup()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_07Layout.setVerticalGroup(
            pnlMealType_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel44)
                .addComponent(lblMealType_07))
        );

        pnlMealType_08.setBackground(new java.awt.Color(255, 255, 255));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel46.setText("Room No 08 - ");

        lblMealType_08.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_08.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_08Layout = new javax.swing.GroupLayout(pnlMealType_08);
        pnlMealType_08.setLayout(pnlMealType_08Layout);
        pnlMealType_08Layout.setHorizontalGroup(
            pnlMealType_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_08Layout.createSequentialGroup()
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_08Layout.setVerticalGroup(
            pnlMealType_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel46)
                .addComponent(lblMealType_08))
        );

        pnlMealType_09.setBackground(new java.awt.Color(255, 255, 255));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel49.setText("Room No 09 - ");

        lblMealType_09.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_09.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_09Layout = new javax.swing.GroupLayout(pnlMealType_09);
        pnlMealType_09.setLayout(pnlMealType_09Layout);
        pnlMealType_09Layout.setHorizontalGroup(
            pnlMealType_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_09Layout.createSequentialGroup()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_09Layout.setVerticalGroup(
            pnlMealType_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel49)
                .addComponent(lblMealType_09))
        );

        pnlMealType_10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setText("Room No 10 - ");

        lblMealType_10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_10.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_10Layout = new javax.swing.GroupLayout(pnlMealType_10);
        pnlMealType_10.setLayout(pnlMealType_10Layout);
        pnlMealType_10Layout.setHorizontalGroup(
            pnlMealType_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_10Layout.createSequentialGroup()
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_10Layout.setVerticalGroup(
            pnlMealType_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel52)
                .addComponent(lblMealType_10))
        );

        pnlMealType_11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel54.setText("Room No 11 - ");

        lblMealType_11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_11.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_11Layout = new javax.swing.GroupLayout(pnlMealType_11);
        pnlMealType_11.setLayout(pnlMealType_11Layout);
        pnlMealType_11Layout.setHorizontalGroup(
            pnlMealType_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_11Layout.createSequentialGroup()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_11Layout.setVerticalGroup(
            pnlMealType_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel54)
                .addComponent(lblMealType_11))
        );

        pnlMealType_12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel57.setText("Room No 12 - ");

        lblMealType_12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_12.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_12Layout = new javax.swing.GroupLayout(pnlMealType_12);
        pnlMealType_12.setLayout(pnlMealType_12Layout);
        pnlMealType_12Layout.setHorizontalGroup(
            pnlMealType_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_12Layout.createSequentialGroup()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_12Layout.setVerticalGroup(
            pnlMealType_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel57)
                .addComponent(lblMealType_12))
        );

        pnlMealType_13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel60.setText("Room No 13 - ");

        lblMealType_13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_13.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_13Layout = new javax.swing.GroupLayout(pnlMealType_13);
        pnlMealType_13.setLayout(pnlMealType_13Layout);
        pnlMealType_13Layout.setHorizontalGroup(
            pnlMealType_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_13Layout.createSequentialGroup()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_13Layout.setVerticalGroup(
            pnlMealType_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel60)
                .addComponent(lblMealType_13))
        );

        pnlMealType_14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel62.setText("Room No 14 - ");

        lblMealType_14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_14.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_14Layout = new javax.swing.GroupLayout(pnlMealType_14);
        pnlMealType_14.setLayout(pnlMealType_14Layout);
        pnlMealType_14Layout.setHorizontalGroup(
            pnlMealType_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_14Layout.createSequentialGroup()
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMealType_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMealType_14Layout.setVerticalGroup(
            pnlMealType_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel62)
                .addComponent(lblMealType_14))
        );

        pnlMealType_15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel65.setText("Room No 15 - ");

        lblMealType_15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMealType_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/salad.png"))); // NOI18N
        lblMealType_15.setText("Meal Type");

        javax.swing.GroupLayout pnlMealType_15Layout = new javax.swing.GroupLayout(pnlMealType_15);
        pnlMealType_15.setLayout(pnlMealType_15Layout);
        pnlMealType_15Layout.setHorizontalGroup(
            pnlMealType_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_15Layout.createSequentialGroup()
                .addComponent(jLabel65)
                .addGap(3, 3, 3)
                .addComponent(lblMealType_15, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMealType_15Layout.setVerticalGroup(
            pnlMealType_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMealType_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel65)
                .addComponent(lblMealType_15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMealType_03, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_04, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMealType_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMealType_01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlMealType_05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMealType_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Selected Rooms");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setMinimumSize(new java.awt.Dimension(398, 0));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        pnlRoom_01.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_01MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel1.setText("Room No 01");

        lblRoomRate_01.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_01.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_01.setText(" LKR 8900.00 /=");

        lblRoomType_01.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_01.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_01.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_01.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_01.setText("Max Guest Count : 04");

        rb_A_01.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup1.add(rb_A_01);
        rb_A_01.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_01.setSelected(true);
        rb_A_01.setText("Room Only");
        rb_A_01.setEnabled(false);
        rb_A_01.setFocusPainted(false);
        rb_A_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_A_01MouseClicked(evt);
            }
        });
        rb_A_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_01ActionPerformed(evt);
            }
        });

        rb_B_01.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup1.add(rb_B_01);
        rb_B_01.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_01.setText("B & B");
        rb_B_01.setEnabled(false);
        rb_B_01.setFocusPainted(false);
        rb_B_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_01ActionPerformed(evt);
            }
        });

        rb_D_01.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup1.add(rb_D_01);
        rb_D_01.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_01.setText("Full Board");
        rb_D_01.setEnabled(false);
        rb_D_01.setFocusPainted(false);
        rb_D_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_01ActionPerformed(evt);
            }
        });

        rb_C_01.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup1.add(rb_C_01);
        rb_C_01.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_01.setText("Half Board ");
        rb_C_01.setEnabled(false);
        rb_C_01.setFocusPainted(false);
        rb_C_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_01ActionPerformed(evt);
            }
        });

        lblBedType_01.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_01.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_01Layout = new javax.swing.GroupLayout(pnlRoom_01);
        pnlRoom_01.setLayout(pnlRoom_01Layout);
        pnlRoom_01Layout.setHorizontalGroup(
            pnlRoom_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_01Layout.createSequentialGroup()
                .addComponent(rb_A_01, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_01, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_01, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_01, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRoom_01Layout.createSequentialGroup()
                        .addGroup(pnlRoom_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_01)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblBedType_01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRoom_01Layout.setVerticalGroup(
            pnlRoom_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_01Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_01)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_01))
                    .addGroup(pnlRoom_01Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_01, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_01)
                    .addComponent(rb_B_01)
                    .addComponent(rb_C_01)
                    .addComponent(rb_D_01)))
        );

        pnlRoom_02.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_02MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel31.setText("Room No 02");

        lblRoomRate_02.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_02.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_02.setText(" LKR 8900.00 /=");

        lblRoomType_02.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_02.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_02.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_02.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_02.setText("Max Guest Count : 04");

        rb_A_02.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup2.add(rb_A_02);
        rb_A_02.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_02.setSelected(true);
        rb_A_02.setText("Room Only");
        rb_A_02.setEnabled(false);
        rb_A_02.setFocusPainted(false);
        rb_A_02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_02ActionPerformed(evt);
            }
        });

        rb_B_02.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup2.add(rb_B_02);
        rb_B_02.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_02.setText("B & B");
        rb_B_02.setEnabled(false);
        rb_B_02.setFocusPainted(false);
        rb_B_02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_02ActionPerformed(evt);
            }
        });

        rb_D_02.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup2.add(rb_D_02);
        rb_D_02.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_02.setText("Full Board");
        rb_D_02.setEnabled(false);
        rb_D_02.setFocusPainted(false);
        rb_D_02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_02ActionPerformed(evt);
            }
        });

        rb_C_02.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup2.add(rb_C_02);
        rb_C_02.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_02.setText("Half Board ");
        rb_C_02.setEnabled(false);
        rb_C_02.setFocusPainted(false);
        rb_C_02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_02ActionPerformed(evt);
            }
        });

        lblBedType_02.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_02.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_02Layout = new javax.swing.GroupLayout(pnlRoom_02);
        pnlRoom_02.setLayout(pnlRoom_02Layout);
        pnlRoom_02Layout.setHorizontalGroup(
            pnlRoom_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_02Layout.createSequentialGroup()
                .addComponent(rb_A_02, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_02, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_02, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_02, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRoom_02Layout.createSequentialGroup()
                        .addGroup(pnlRoom_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_02)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblBedType_02, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRoom_02Layout.setVerticalGroup(
            pnlRoom_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_02Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_02)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_02))
                    .addGroup(pnlRoom_02Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_02, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_02)
                    .addComponent(rb_B_02)
                    .addComponent(rb_C_02)
                    .addComponent(rb_D_02)))
        );

        pnlRoom_03.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_03MouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel39.setText("Room No 03");

        lblRoomRate_03.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_03.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_03.setText(" LKR 8900.00 /=");

        lblRoomType_03.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_03.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_03.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_03.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_03.setText("Max Guest Count : 04");

        rb_A_03.setBackground(new java.awt.Color(189, 195, 199));
        rb_A_03.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_03.setSelected(true);
        rb_A_03.setText("Room Only");
        rb_A_03.setEnabled(false);
        rb_A_03.setFocusPainted(false);
        rb_A_03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_03ActionPerformed(evt);
            }
        });

        rb_B_03.setBackground(new java.awt.Color(189, 195, 199));
        rb_B_03.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_03.setText("B & B");
        rb_B_03.setEnabled(false);
        rb_B_03.setFocusPainted(false);
        rb_B_03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_03ActionPerformed(evt);
            }
        });

        rb_D_03.setBackground(new java.awt.Color(189, 195, 199));
        rb_D_03.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_03.setText("Full Board");
        rb_D_03.setEnabled(false);
        rb_D_03.setFocusPainted(false);
        rb_D_03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_03ActionPerformed(evt);
            }
        });

        rb_C_03.setBackground(new java.awt.Color(189, 195, 199));
        rb_C_03.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_03.setText("Half Board ");
        rb_C_03.setEnabled(false);
        rb_C_03.setFocusPainted(false);
        rb_C_03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_03ActionPerformed(evt);
            }
        });

        lblBedType_03.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_03.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_03Layout = new javax.swing.GroupLayout(pnlRoom_03);
        pnlRoom_03.setLayout(pnlRoom_03Layout);
        pnlRoom_03Layout.setHorizontalGroup(
            pnlRoom_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_03Layout.createSequentialGroup()
                .addComponent(rb_A_03, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_03, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_03, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_03, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRoom_03Layout.createSequentialGroup()
                        .addGroup(pnlRoom_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_03)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblBedType_03, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRoom_03Layout.setVerticalGroup(
            pnlRoom_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_03Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_03)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_03))
                    .addGroup(pnlRoom_03Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_03, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_03)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_03)
                    .addComponent(rb_B_03)
                    .addComponent(rb_C_03)
                    .addComponent(rb_D_03)))
        );

        pnlRoom_04.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_04MouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel35.setText("Room No 04");

        lblRoomRate_04.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_04.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_04.setText(" LKR 8900.00 /=");

        lblRoomType_04.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_04.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_04.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_04.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_04.setText("Max Guest Count : 04");

        rb_A_04.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup4.add(rb_A_04);
        rb_A_04.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_04.setSelected(true);
        rb_A_04.setText("Room Only");
        rb_A_04.setEnabled(false);
        rb_A_04.setFocusPainted(false);
        rb_A_04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_04ActionPerformed(evt);
            }
        });

        rb_B_04.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup4.add(rb_B_04);
        rb_B_04.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_04.setText("B & B");
        rb_B_04.setEnabled(false);
        rb_B_04.setFocusPainted(false);
        rb_B_04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_04ActionPerformed(evt);
            }
        });

        rb_D_04.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup4.add(rb_D_04);
        rb_D_04.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_04.setText("Full Board");
        rb_D_04.setEnabled(false);
        rb_D_04.setFocusPainted(false);
        rb_D_04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_04ActionPerformed(evt);
            }
        });

        rb_C_04.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup4.add(rb_C_04);
        rb_C_04.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_04.setText("Half Board ");
        rb_C_04.setEnabled(false);
        rb_C_04.setFocusPainted(false);
        rb_C_04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_04ActionPerformed(evt);
            }
        });

        lblBedType_04.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_04.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_04Layout = new javax.swing.GroupLayout(pnlRoom_04);
        pnlRoom_04.setLayout(pnlRoom_04Layout);
        pnlRoom_04Layout.setHorizontalGroup(
            pnlRoom_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_04Layout.createSequentialGroup()
                .addComponent(rb_A_04, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_04, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_04, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_04, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_04Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRoom_04Layout.createSequentialGroup()
                        .addGroup(pnlRoom_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_04)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblBedType_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRoom_04Layout.setVerticalGroup(
            pnlRoom_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_04Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_04Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_04)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_04))
                    .addGroup(pnlRoom_04Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_04, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_04)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_04)
                    .addComponent(rb_B_04)
                    .addComponent(rb_C_04)
                    .addComponent(rb_D_04)))
        );

        pnlRoom_05.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_05MouseClicked(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel43.setText("Room No 05");

        lblRoomRate_05.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_05.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_05.setText(" LKR 8900.00 /=");

        lblRoomType_05.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_05.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_05.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_05.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_05.setText("Max Guest Count : 04");

        rb_A_05.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup5.add(rb_A_05);
        rb_A_05.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_05.setSelected(true);
        rb_A_05.setText("Room Only");
        rb_A_05.setEnabled(false);
        rb_A_05.setFocusPainted(false);
        rb_A_05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_A_05MouseClicked(evt);
            }
        });

        rb_B_05.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup5.add(rb_B_05);
        rb_B_05.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_05.setText("B & B");
        rb_B_05.setEnabled(false);
        rb_B_05.setFocusPainted(false);
        rb_B_05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_05ActionPerformed(evt);
            }
        });

        rb_D_05.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup5.add(rb_D_05);
        rb_D_05.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_05.setText("Full Board");
        rb_D_05.setEnabled(false);
        rb_D_05.setFocusPainted(false);
        rb_D_05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_05ActionPerformed(evt);
            }
        });

        rb_C_05.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup5.add(rb_C_05);
        rb_C_05.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_05.setText("Half Board ");
        rb_C_05.setEnabled(false);
        rb_C_05.setFocusPainted(false);
        rb_C_05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_05ActionPerformed(evt);
            }
        });

        lblBedType_05.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_05.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_05Layout = new javax.swing.GroupLayout(pnlRoom_05);
        pnlRoom_05.setLayout(pnlRoom_05Layout);
        pnlRoom_05Layout.setHorizontalGroup(
            pnlRoom_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_05Layout.createSequentialGroup()
                .addComponent(rb_A_05, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_05, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_05, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_05, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_05Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRoom_05Layout.createSequentialGroup()
                        .addGroup(pnlRoom_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_05)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblBedType_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRoom_05Layout.setVerticalGroup(
            pnlRoom_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_05Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_05Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_05)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_05))
                    .addGroup(pnlRoom_05Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_05, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_05)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_05)
                    .addComponent(rb_B_05)
                    .addComponent(rb_C_05)
                    .addComponent(rb_D_05)))
        );

        pnlRoom_06.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_06MouseClicked(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel47.setText("Room No 06");

        lblRoomRate_06.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_06.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_06.setText(" LKR 8900.00 /=");

        lblRoomType_06.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_06.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_06.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_06.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_06.setText("Max Guest Count : 04");

        rb_A_06.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup6.add(rb_A_06);
        rb_A_06.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_06.setSelected(true);
        rb_A_06.setText("Room Only");
        rb_A_06.setEnabled(false);
        rb_A_06.setFocusPainted(false);
        rb_A_06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_06ActionPerformed(evt);
            }
        });

        rb_B_06.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup6.add(rb_B_06);
        rb_B_06.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_06.setText("B & B");
        rb_B_06.setEnabled(false);
        rb_B_06.setFocusPainted(false);
        rb_B_06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_06ActionPerformed(evt);
            }
        });

        rb_D_06.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup6.add(rb_D_06);
        rb_D_06.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_06.setText("Full Board");
        rb_D_06.setEnabled(false);
        rb_D_06.setFocusPainted(false);
        rb_D_06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_06ActionPerformed(evt);
            }
        });

        rb_C_06.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup6.add(rb_C_06);
        rb_C_06.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_06.setText("Half Board ");
        rb_C_06.setEnabled(false);
        rb_C_06.setFocusPainted(false);
        rb_C_06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_06ActionPerformed(evt);
            }
        });

        lblBedType_06.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_06.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_06Layout = new javax.swing.GroupLayout(pnlRoom_06);
        pnlRoom_06.setLayout(pnlRoom_06Layout);
        pnlRoom_06Layout.setHorizontalGroup(
            pnlRoom_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_06Layout.createSequentialGroup()
                .addComponent(rb_A_06, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_06, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_06, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_06, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_06Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRoom_06Layout.createSequentialGroup()
                        .addGroup(pnlRoom_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_06)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblBedType_06, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRoom_06Layout.setVerticalGroup(
            pnlRoom_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_06Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_06Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_06)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_06))
                    .addGroup(pnlRoom_06Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_06, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_06)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_06)
                    .addComponent(rb_B_06)
                    .addComponent(rb_C_06)
                    .addComponent(rb_D_06)))
        );

        pnlRoom_07.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_07MouseClicked(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel51.setText("Room No 07");

        lblRoomRate_07.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_07.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_07.setText(" LKR 8900.00 /=");

        lblRoomType_07.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_07.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_07.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_07.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_07.setText("Max Guest Count : 04");

        rb_A_07.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup7.add(rb_A_07);
        rb_A_07.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_07.setSelected(true);
        rb_A_07.setText("Room Only");
        rb_A_07.setEnabled(false);
        rb_A_07.setFocusPainted(false);
        rb_A_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_07ActionPerformed(evt);
            }
        });

        rb_B_07.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup7.add(rb_B_07);
        rb_B_07.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_07.setText("B & B");
        rb_B_07.setEnabled(false);
        rb_B_07.setFocusPainted(false);
        rb_B_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_07ActionPerformed(evt);
            }
        });

        rb_D_07.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup7.add(rb_D_07);
        rb_D_07.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_07.setText("Full Board");
        rb_D_07.setEnabled(false);
        rb_D_07.setFocusPainted(false);
        rb_D_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_07ActionPerformed(evt);
            }
        });

        rb_C_07.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup7.add(rb_C_07);
        rb_C_07.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_07.setText("Half Board ");
        rb_C_07.setEnabled(false);
        rb_C_07.setFocusPainted(false);
        rb_C_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_07ActionPerformed(evt);
            }
        });

        lblBedType_07.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_07.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_07Layout = new javax.swing.GroupLayout(pnlRoom_07);
        pnlRoom_07.setLayout(pnlRoom_07Layout);
        pnlRoom_07Layout.setHorizontalGroup(
            pnlRoom_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_07Layout.createSequentialGroup()
                .addComponent(rb_A_07, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_07, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_07, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_07, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_07Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_07Layout.createSequentialGroup()
                        .addGroup(pnlRoom_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_07)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_07Layout.setVerticalGroup(
            pnlRoom_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_07Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_07Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_07)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_07))
                    .addGroup(pnlRoom_07Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_07, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_07)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_07Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_07)
                    .addComponent(rb_B_07)
                    .addComponent(rb_C_07)
                    .addComponent(rb_D_07)))
        );

        pnlRoom_08.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_08MouseClicked(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel55.setText("Room No 08");

        lblRoomRate_08.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_08.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_08.setText(" LKR 8900.00 /=");

        lblRoomType_08.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_08.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_08.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_08.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_08.setText("Max Guest Count : 04");

        rb_A_08.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup8.add(rb_A_08);
        rb_A_08.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_08.setSelected(true);
        rb_A_08.setText("Room Only");
        rb_A_08.setEnabled(false);
        rb_A_08.setFocusPainted(false);
        rb_A_08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_A_08MouseClicked(evt);
            }
        });

        rb_B_08.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup8.add(rb_B_08);
        rb_B_08.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_08.setText("B & B");
        rb_B_08.setEnabled(false);
        rb_B_08.setFocusPainted(false);
        rb_B_08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_08ActionPerformed(evt);
            }
        });

        rb_D_08.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup8.add(rb_D_08);
        rb_D_08.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_08.setText("Full Board");
        rb_D_08.setEnabled(false);
        rb_D_08.setFocusPainted(false);
        rb_D_08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_08ActionPerformed(evt);
            }
        });

        rb_C_08.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup8.add(rb_C_08);
        rb_C_08.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_08.setText("Half Board ");
        rb_C_08.setEnabled(false);
        rb_C_08.setFocusPainted(false);
        rb_C_08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_08ActionPerformed(evt);
            }
        });

        lblBedType_08.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_08.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_08Layout = new javax.swing.GroupLayout(pnlRoom_08);
        pnlRoom_08.setLayout(pnlRoom_08Layout);
        pnlRoom_08Layout.setHorizontalGroup(
            pnlRoom_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_08Layout.createSequentialGroup()
                .addComponent(rb_A_08, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_08, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_08, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_08, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_08Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_08Layout.createSequentialGroup()
                        .addGroup(pnlRoom_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_08)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_08Layout.setVerticalGroup(
            pnlRoom_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_08Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_08Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_08)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_08))
                    .addGroup(pnlRoom_08Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_08, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_08)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_08Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_08)
                    .addComponent(rb_B_08)
                    .addComponent(rb_C_08)
                    .addComponent(rb_D_08)))
        );

        pnlRoom_09.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_09.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_09MouseClicked(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel59.setText("Room No 09");

        lblRoomRate_09.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_09.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_09.setText(" LKR 8900.00 /=");

        lblRoomType_09.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_09.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_09.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_09.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_09.setText("Max Guest Count : 04");

        rb_A_09.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup9.add(rb_A_09);
        rb_A_09.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_09.setSelected(true);
        rb_A_09.setText("Room Only");
        rb_A_09.setEnabled(false);
        rb_A_09.setFocusPainted(false);
        rb_A_09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_09.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_A_09MouseClicked(evt);
            }
        });

        rb_B_09.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup9.add(rb_B_09);
        rb_B_09.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_09.setText("B & B");
        rb_B_09.setEnabled(false);
        rb_B_09.setFocusPainted(false);
        rb_B_09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_09ActionPerformed(evt);
            }
        });

        rb_D_09.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup9.add(rb_D_09);
        rb_D_09.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_09.setText("Full Board");
        rb_D_09.setEnabled(false);
        rb_D_09.setFocusPainted(false);
        rb_D_09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_09ActionPerformed(evt);
            }
        });

        rb_C_09.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup9.add(rb_C_09);
        rb_C_09.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_09.setText("Half Board ");
        rb_C_09.setEnabled(false);
        rb_C_09.setFocusPainted(false);
        rb_C_09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_09ActionPerformed(evt);
            }
        });

        lblBedType_09.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_09.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_09Layout = new javax.swing.GroupLayout(pnlRoom_09);
        pnlRoom_09.setLayout(pnlRoom_09Layout);
        pnlRoom_09Layout.setHorizontalGroup(
            pnlRoom_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_09Layout.createSequentialGroup()
                .addComponent(rb_A_09, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_09, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_09, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_09, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_09Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_09Layout.createSequentialGroup()
                        .addGroup(pnlRoom_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_09)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_09Layout.setVerticalGroup(
            pnlRoom_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_09Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_09Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_09)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_09))
                    .addGroup(pnlRoom_09Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_09, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_09)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_09Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_09)
                    .addComponent(rb_B_09)
                    .addComponent(rb_C_09)
                    .addComponent(rb_D_09)))
        );

        pnlRoom_10.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_10MouseClicked(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel63.setText("Room No 10");

        lblRoomRate_10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_10.setText(" LKR 8900.00 /=");

        lblRoomType_10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_10.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_10.setText("Max Guest Count : 04");

        rb_A_10.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup10.add(rb_A_10);
        rb_A_10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_10.setSelected(true);
        rb_A_10.setText("Room Only");
        rb_A_10.setEnabled(false);
        rb_A_10.setFocusPainted(false);
        rb_A_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_10ActionPerformed(evt);
            }
        });

        rb_B_10.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup10.add(rb_B_10);
        rb_B_10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_10.setText("B & B");
        rb_B_10.setEnabled(false);
        rb_B_10.setFocusPainted(false);
        rb_B_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_10ActionPerformed(evt);
            }
        });

        rb_D_10.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup10.add(rb_D_10);
        rb_D_10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_10.setText("Full Board");
        rb_D_10.setEnabled(false);
        rb_D_10.setFocusPainted(false);
        rb_D_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_10ActionPerformed(evt);
            }
        });

        rb_C_10.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup10.add(rb_C_10);
        rb_C_10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_10.setText("Half Board ");
        rb_C_10.setEnabled(false);
        rb_C_10.setFocusPainted(false);
        rb_C_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_10ActionPerformed(evt);
            }
        });

        lblBedType_10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_10.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_10Layout = new javax.swing.GroupLayout(pnlRoom_10);
        pnlRoom_10.setLayout(pnlRoom_10Layout);
        pnlRoom_10Layout.setHorizontalGroup(
            pnlRoom_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_10Layout.createSequentialGroup()
                .addComponent(rb_A_10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_10Layout.createSequentialGroup()
                        .addGroup(pnlRoom_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_10)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_10Layout.setVerticalGroup(
            pnlRoom_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_10Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_10))
                    .addGroup(pnlRoom_10Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_10)
                    .addComponent(rb_B_10)
                    .addComponent(rb_C_10)
                    .addComponent(rb_D_10)))
        );

        pnlRoom_11.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_11MouseClicked(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel67.setText("Room No 11");

        lblRoomRate_11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_11.setText(" LKR 8900.00 /=");

        lblRoomType_11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_11.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_11.setText("Max Guest Count : 04");

        rb_A_11.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup11.add(rb_A_11);
        rb_A_11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_11.setSelected(true);
        rb_A_11.setText("Room Only");
        rb_A_11.setEnabled(false);
        rb_A_11.setFocusPainted(false);
        rb_A_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_11ActionPerformed(evt);
            }
        });

        rb_B_11.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup11.add(rb_B_11);
        rb_B_11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_11.setText("B & B");
        rb_B_11.setEnabled(false);
        rb_B_11.setFocusPainted(false);
        rb_B_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_11ActionPerformed(evt);
            }
        });

        rb_D_11.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup11.add(rb_D_11);
        rb_D_11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_11.setText("Full Board");
        rb_D_11.setEnabled(false);
        rb_D_11.setFocusPainted(false);
        rb_D_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_11ActionPerformed(evt);
            }
        });

        rb_C_11.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup11.add(rb_C_11);
        rb_C_11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_11.setText("Half Board ");
        rb_C_11.setEnabled(false);
        rb_C_11.setFocusPainted(false);
        rb_C_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_11ActionPerformed(evt);
            }
        });

        lblBedType_11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_11.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_11Layout = new javax.swing.GroupLayout(pnlRoom_11);
        pnlRoom_11.setLayout(pnlRoom_11Layout);
        pnlRoom_11Layout.setHorizontalGroup(
            pnlRoom_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_11Layout.createSequentialGroup()
                .addComponent(rb_A_11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_11Layout.createSequentialGroup()
                        .addGroup(pnlRoom_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_11)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_11Layout.setVerticalGroup(
            pnlRoom_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_11Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_11))
                    .addGroup(pnlRoom_11Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_11)
                    .addComponent(rb_B_11)
                    .addComponent(rb_C_11)
                    .addComponent(rb_D_11)))
        );

        pnlRoom_12.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_12MouseClicked(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel71.setText("Room No 12");

        lblRoomRate_12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_12.setText(" LKR 8900.00 /=");

        lblRoomType_12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_12.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_12.setText("Max Guest Count : 04");

        rb_A_12.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup12.add(rb_A_12);
        rb_A_12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_12.setSelected(true);
        rb_A_12.setText("Room Only");
        rb_A_12.setEnabled(false);
        rb_A_12.setFocusPainted(false);
        rb_A_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_A_12MouseClicked(evt);
            }
        });

        rb_B_12.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup12.add(rb_B_12);
        rb_B_12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_12.setText("B & B");
        rb_B_12.setEnabled(false);
        rb_B_12.setFocusPainted(false);
        rb_B_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_12ActionPerformed(evt);
            }
        });

        rb_D_12.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup12.add(rb_D_12);
        rb_D_12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_12.setText("Full Board");
        rb_D_12.setEnabled(false);
        rb_D_12.setFocusPainted(false);
        rb_D_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_12ActionPerformed(evt);
            }
        });

        rb_C_12.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup12.add(rb_C_12);
        rb_C_12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_12.setText("Half Board ");
        rb_C_12.setEnabled(false);
        rb_C_12.setFocusPainted(false);
        rb_C_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_12ActionPerformed(evt);
            }
        });

        lblBedType_12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_12.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_12Layout = new javax.swing.GroupLayout(pnlRoom_12);
        pnlRoom_12.setLayout(pnlRoom_12Layout);
        pnlRoom_12Layout.setHorizontalGroup(
            pnlRoom_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_12Layout.createSequentialGroup()
                .addComponent(rb_A_12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_12Layout.createSequentialGroup()
                        .addGroup(pnlRoom_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_12)
                            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_12Layout.setVerticalGroup(
            pnlRoom_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_12Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_12))
                    .addGroup(pnlRoom_12Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_12)
                    .addComponent(rb_B_12)
                    .addComponent(rb_C_12)
                    .addComponent(rb_D_12)))
        );

        pnlRoom_13.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_13MouseClicked(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel75.setText("Room No 13");

        lblRoomRate_13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_13.setText(" LKR 8900.00 /=");

        lblRoomType_13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_13.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_13.setText("Max Guest Count : 04");

        rb_A_13.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup13.add(rb_A_13);
        rb_A_13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_13.setSelected(true);
        rb_A_13.setText("Room Only");
        rb_A_13.setEnabled(false);
        rb_A_13.setFocusPainted(false);
        rb_A_13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_13ActionPerformed(evt);
            }
        });

        rb_B_13.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup13.add(rb_B_13);
        rb_B_13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_13.setText("B & B");
        rb_B_13.setEnabled(false);
        rb_B_13.setFocusPainted(false);
        rb_B_13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_13ActionPerformed(evt);
            }
        });

        rb_D_13.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup13.add(rb_D_13);
        rb_D_13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_13.setText("Full Board");
        rb_D_13.setEnabled(false);
        rb_D_13.setFocusPainted(false);
        rb_D_13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_13ActionPerformed(evt);
            }
        });

        rb_C_13.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup13.add(rb_C_13);
        rb_C_13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_13.setText("Half Board ");
        rb_C_13.setEnabled(false);
        rb_C_13.setFocusPainted(false);
        rb_C_13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_13ActionPerformed(evt);
            }
        });

        lblBedType_13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_13.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_13Layout = new javax.swing.GroupLayout(pnlRoom_13);
        pnlRoom_13.setLayout(pnlRoom_13Layout);
        pnlRoom_13Layout.setHorizontalGroup(
            pnlRoom_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_13Layout.createSequentialGroup()
                .addComponent(rb_A_13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_13Layout.createSequentialGroup()
                        .addGroup(pnlRoom_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_13)
                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_13Layout.setVerticalGroup(
            pnlRoom_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_13Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_13))
                    .addGroup(pnlRoom_13Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_13)
                    .addComponent(rb_B_13)
                    .addComponent(rb_C_13)
                    .addComponent(rb_D_13)))
        );

        pnlRoom_14.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_14MouseClicked(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel79.setText("Room No 14");

        lblRoomRate_14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_14.setText(" LKR 8900.00 /=");

        lblRoomType_14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_14.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_14.setText("Max Guest Count : 04");

        rb_A_14.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup14.add(rb_A_14);
        rb_A_14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_14.setSelected(true);
        rb_A_14.setText("Room Only");
        rb_A_14.setEnabled(false);
        rb_A_14.setFocusPainted(false);
        rb_A_14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_14ActionPerformed(evt);
            }
        });

        rb_B_14.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup14.add(rb_B_14);
        rb_B_14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_14.setText("B & B");
        rb_B_14.setEnabled(false);
        rb_B_14.setFocusPainted(false);
        rb_B_14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_14ActionPerformed(evt);
            }
        });

        rb_D_14.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup14.add(rb_D_14);
        rb_D_14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_14.setText("Full Board");
        rb_D_14.setEnabled(false);
        rb_D_14.setFocusPainted(false);
        rb_D_14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_14ActionPerformed(evt);
            }
        });

        rb_C_14.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup14.add(rb_C_14);
        rb_C_14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_14.setText("Half Board ");
        rb_C_14.setEnabled(false);
        rb_C_14.setFocusPainted(false);
        rb_C_14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_14ActionPerformed(evt);
            }
        });

        lblBedType_14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_14.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_14Layout = new javax.swing.GroupLayout(pnlRoom_14);
        pnlRoom_14.setLayout(pnlRoom_14Layout);
        pnlRoom_14Layout.setHorizontalGroup(
            pnlRoom_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_14Layout.createSequentialGroup()
                .addComponent(rb_A_14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_14Layout.createSequentialGroup()
                        .addGroup(pnlRoom_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_14)
                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_14Layout.setVerticalGroup(
            pnlRoom_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_14Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_14))
                    .addGroup(pnlRoom_14Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_14)
                    .addComponent(rb_B_14)
                    .addComponent(rb_C_14)
                    .addComponent(rb_D_14)))
        );

        pnlRoom_15.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom_15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRoom_15MouseClicked(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Door Opened Filled-24.png"))); // NOI18N
        jLabel83.setText("Room No 15");

        lblRoomRate_15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblRoomRate_15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomRate_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Price Tag-24.png"))); // NOI18N
        lblRoomRate_15.setText(" LKR 8900.00 /=");

        lblRoomType_15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRoomType_15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoomType_15.setText("<html>\n<u>\nRoom Type\n</u>\n</html>");

        lblMaxGuestCount_15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaxGuestCount_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Conference Call Filled-16.png"))); // NOI18N
        lblMaxGuestCount_15.setText("Max Guest Count : 04");

        rb_A_15.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup15.add(rb_A_15);
        rb_A_15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_A_15.setSelected(true);
        rb_A_15.setText("Room Only");
        rb_A_15.setEnabled(false);
        rb_A_15.setFocusPainted(false);
        rb_A_15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_A_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_A_15ActionPerformed(evt);
            }
        });

        rb_B_15.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup15.add(rb_B_15);
        rb_B_15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_B_15.setText("B & B");
        rb_B_15.setEnabled(false);
        rb_B_15.setFocusPainted(false);
        rb_B_15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_B_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_B_15ActionPerformed(evt);
            }
        });

        rb_D_15.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup15.add(rb_D_15);
        rb_D_15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_D_15.setText("Full Board");
        rb_D_15.setEnabled(false);
        rb_D_15.setFocusPainted(false);
        rb_D_15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_D_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_D_15ActionPerformed(evt);
            }
        });

        rb_C_15.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup15.add(rb_C_15);
        rb_C_15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rb_C_15.setText("Half Board ");
        rb_C_15.setEnabled(false);
        rb_C_15.setFocusPainted(false);
        rb_C_15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rb_C_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_C_15ActionPerformed(evt);
            }
        });

        lblBedType_15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBedType_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Bedroom Filled-16.png"))); // NOI18N
        lblBedType_15.setText("Bed Types : ");

        javax.swing.GroupLayout pnlRoom_15Layout = new javax.swing.GroupLayout(pnlRoom_15);
        pnlRoom_15.setLayout(pnlRoom_15Layout);
        pnlRoom_15Layout.setHorizontalGroup(
            pnlRoom_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_15Layout.createSequentialGroup()
                .addComponent(rb_A_15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_B_15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_C_15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_D_15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlRoom_15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBedType_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRoom_15Layout.createSequentialGroup()
                        .addGroup(pnlRoom_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRoomType_15)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRoom_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomRate_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaxGuestCount_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRoom_15Layout.setVerticalGroup(
            pnlRoom_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoom_15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoom_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRoom_15Layout.createSequentialGroup()
                        .addComponent(lblRoomRate_15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaxGuestCount_15))
                    .addGroup(pnlRoom_15Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoomType_15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBedType_15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlRoom_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_A_15)
                    .addComponent(rb_B_15)
                    .addComponent(rb_C_15)
                    .addComponent(rb_D_15)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRoom_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoom_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(pnlRoom_01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoom_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Avaible Rooms");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Titel");

        NICS.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton5.setText("NIC (12 Digit)");
        jRadioButton5.setContentAreaFilled(false);

        NICS.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton6.setSelected(true);
        jRadioButton6.setText("Passport");
        jRadioButton6.setContentAreaFilled(false);

        NICS.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton7.setText("NIC (9 Digit)");
        jRadioButton7.setContentAreaFilled(false);

        txtNicPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cmbTitel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTitel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr", "Ms", "Mrs" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("First Name");

        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Last Name");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Age");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Gender");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Contact No");

        txtContactNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Check");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });

        txtZip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Postal/Zip Code");

        txtCity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("City");

        txtState.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("State/Province");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Country");

        cmbCountry.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas, The", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei ", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cabo Verde", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Curacao", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor (see Timor-Leste)", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia, The", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Holy See", "Honduras", "Hong Kong", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "Norway", "Oman", "Pakistan", "Palau", "Palestinian Territories", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa ", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain ", "Sri Lanka", "Sudan", "Suriname", "Swaziland ", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand ", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe", "Hungary" }));

        txtAge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAge.setText("0");

        cmbGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTitel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactNo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtZip))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCity))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtState))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jRadioButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(txtNicPass, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton5))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNicPass)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24))
                        .addComponent(cmbGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Guest Details");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 804, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
       
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseExited

    private void cmbNumOfNightsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbNumOfNightsMouseClicked
      
    }//GEN-LAST:event_cmbNumOfNightsMouseClicked

    private void cmbNumOfNightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNumOfNightsActionPerformed
        obj.addCheckOutDate();
    }//GEN-LAST:event_cmbNumOfNightsActionPerformed
    
    public static void SwitchColors(boolean flag, JPanel roomNo)
    {
        flag = r01;
        if(flag == true)
        {
            flag = false;
            roomNo.setBackground(new Color(46, 204, 113));
        }
        else 
        {
            flag =  true;
            roomNo.setBackground(new Color(255, 255, 255));
        }
    }
    
    
    
    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
       //System.out.println(obj.getRoomReservationId());
      // if(obj.isPast(jdcCheckOutDate.getDate().toString()))
       //{
           obj.makeReservation();
      // }
             
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
      
    }//GEN-LAST:event_jButton4MouseClicked

    private void jdcCheckOutDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcCheckOutDateMouseClicked
      
    }//GEN-LAST:event_jdcCheckOutDateMouseClicked

    private void jdcCheckOutDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcCheckOutDatePropertyChange
       obj.addCheckOutDate();
    }//GEN-LAST:event_jdcCheckOutDatePropertyChange

    private void cmbRoomTypesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbRoomTypesMouseClicked
       
    }//GEN-LAST:event_cmbRoomTypesMouseClicked

    private void cmbRoomTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoomTypesActionPerformed
       
    }//GEN-LAST:event_cmbRoomTypesActionPerformed

    private void pnlRoom_01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_01MouseClicked
        obj.setPnlRoomNo01();
    }//GEN-LAST:event_pnlRoom_01MouseClicked

    private void pnlRoom_02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_02MouseClicked
       obj.setPnlRoomNo02();
    }//GEN-LAST:event_pnlRoom_02MouseClicked

    private void pnlRoom_03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_03MouseClicked
        obj.setPnlRoomNo03();
    }//GEN-LAST:event_pnlRoom_03MouseClicked

    private void pnlRoom_04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_04MouseClicked
        obj.setPnlRoomNo04();
    }//GEN-LAST:event_pnlRoom_04MouseClicked

    private void pnlRoom_05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_05MouseClicked
       obj.setPnlRoomNo05();
    }//GEN-LAST:event_pnlRoom_05MouseClicked

    private void pnlRoom_06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_06MouseClicked
        obj.setPnlRoomNo06();
    }//GEN-LAST:event_pnlRoom_06MouseClicked

    private void pnlRoom_07MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_07MouseClicked
        obj.setPnlRoomNo07();
    }//GEN-LAST:event_pnlRoom_07MouseClicked

    private void pnlRoom_08MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_08MouseClicked
        obj.setPnlRoomNo08();
    }//GEN-LAST:event_pnlRoom_08MouseClicked

    private void pnlRoom_09MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_09MouseClicked
         obj.setPnlRoomNo09();
    }//GEN-LAST:event_pnlRoom_09MouseClicked

    private void pnlRoom_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_10MouseClicked
        obj.setPnlRoomNo10();
    }//GEN-LAST:event_pnlRoom_10MouseClicked

    private void pnlRoom_11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_11MouseClicked
        obj.setPnlRoomNo11();
    }//GEN-LAST:event_pnlRoom_11MouseClicked

    private void pnlRoom_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_12MouseClicked
         obj.setPnlRoomNo12();
    }//GEN-LAST:event_pnlRoom_12MouseClicked

    private void pnlRoom_13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_13MouseClicked
         obj.setPnlRoomNo13();
    }//GEN-LAST:event_pnlRoom_13MouseClicked

    private void pnlRoom_14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_14MouseClicked
         obj.setPnlRoomNo14();
    }//GEN-LAST:event_pnlRoom_14MouseClicked

    private void pnlRoom_15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoom_15MouseClicked
         obj.setPnlRoomNo15();
    }//GEN-LAST:event_pnlRoom_15MouseClicked

    private void cmbRoomTypesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbRoomTypesPropertyChange
         obj.getMatchingRoomNumbers();
    }//GEN-LAST:event_cmbRoomTypesPropertyChange

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //obj.print();
        //obj.getRoomList();
       // obj.getmealType();
       // obj.getArrivelDay();
        //obj.getValuesForRoomReervation();
       // obj.getValuesForGuestDeatils();
       JOptionPane.showMessageDialog(null,"Check in date can't be a past date!","Error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1MouseClicked

    private void rb_A_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_01ActionPerformed
        obj.setMealTypes(rb_A_01,rb_B_01,rb_C_01,rb_D_01,lblMealType_01);
    }//GEN-LAST:event_rb_A_01ActionPerformed

    private void rb_A_01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_A_01MouseClicked
        
    }//GEN-LAST:event_rb_A_01MouseClicked

    private void rb_B_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_01ActionPerformed
        obj.setMealTypes(rb_A_01,rb_B_01,rb_C_01,rb_D_01,lblMealType_01);
    }//GEN-LAST:event_rb_B_01ActionPerformed

    private void rb_C_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_01ActionPerformed
        obj.setMealTypes(rb_A_01,rb_B_01,rb_C_01,rb_D_01,lblMealType_01);
    }//GEN-LAST:event_rb_C_01ActionPerformed

    private void rb_D_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_01ActionPerformed
       obj.setMealTypes(rb_A_01,rb_B_01,rb_C_01,rb_D_01,lblMealType_01);
    }//GEN-LAST:event_rb_D_01ActionPerformed

    private void rb_A_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_02ActionPerformed
        obj.setMealTypes(rb_A_02,rb_B_02,rb_C_02,rb_D_02,lblMealType_02);
    }//GEN-LAST:event_rb_A_02ActionPerformed

    private void rb_B_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_02ActionPerformed
        obj.setMealTypes(rb_A_02, rb_B_02, rb_C_02, rb_D_02, lblMealType_02);      
    }//GEN-LAST:event_rb_B_02ActionPerformed

    private void rb_C_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_02ActionPerformed
        obj.setMealTypes(rb_A_02, rb_B_02, rb_C_02, rb_D_02, lblMealType_02);        
    }//GEN-LAST:event_rb_C_02ActionPerformed

    private void rb_D_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_02ActionPerformed
        obj.setMealTypes(rb_A_02, rb_B_02, rb_C_02, rb_D_02, lblMealType_02);        
    }//GEN-LAST:event_rb_D_02ActionPerformed

    private void rb_A_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_03ActionPerformed
        obj.setMealTypes(rb_A_03,rb_B_03,rb_C_03,rb_D_03,lblMealType_03);
    }//GEN-LAST:event_rb_A_03ActionPerformed

    private void rb_B_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_03ActionPerformed
        obj.setMealTypes(rb_A_03,rb_B_03,rb_C_03,rb_D_03,lblMealType_03);
    }//GEN-LAST:event_rb_B_03ActionPerformed

    private void rb_C_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_03ActionPerformed
        obj.setMealTypes(rb_A_03,rb_B_03,rb_C_03,rb_D_03,lblMealType_03);
    }//GEN-LAST:event_rb_C_03ActionPerformed

    private void rb_D_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_03ActionPerformed
        obj.setMealTypes(rb_A_03,rb_B_03,rb_C_03,rb_D_03,lblMealType_03);
    }//GEN-LAST:event_rb_D_03ActionPerformed

    private void rb_A_04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_04ActionPerformed
         obj.setMealTypes(rb_A_04,rb_B_04,rb_C_04,rb_D_04,lblMealType_04);
    }//GEN-LAST:event_rb_A_04ActionPerformed

    private void rb_B_04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_04ActionPerformed
         obj.setMealTypes(rb_A_04,rb_B_04,rb_C_04,rb_D_04,lblMealType_04);
    }//GEN-LAST:event_rb_B_04ActionPerformed

    private void rb_C_04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_04ActionPerformed
         obj.setMealTypes(rb_A_04,rb_B_04,rb_C_04,rb_D_04,lblMealType_04);
    }//GEN-LAST:event_rb_C_04ActionPerformed

    private void rb_D_04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_04ActionPerformed
        obj.setMealTypes(rb_A_04,rb_B_04,rb_C_04,rb_D_04,lblMealType_04);
    }//GEN-LAST:event_rb_D_04ActionPerformed

    private void rb_A_05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_A_05MouseClicked
         obj.setMealTypes(rb_A_05,rb_B_05,rb_C_05,rb_D_05,lblMealType_05);
    }//GEN-LAST:event_rb_A_05MouseClicked

    private void rb_B_05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_05ActionPerformed
        obj.setMealTypes(rb_A_05,rb_B_05,rb_C_05,rb_D_05,lblMealType_05);
    }//GEN-LAST:event_rb_B_05ActionPerformed

    private void rb_C_05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_05ActionPerformed
        obj.setMealTypes(rb_A_05,rb_B_05,rb_C_05,rb_D_05,lblMealType_05);
    }//GEN-LAST:event_rb_C_05ActionPerformed

    private void rb_D_05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_05ActionPerformed
       obj.setMealTypes(rb_A_05,rb_B_05,rb_C_05,rb_D_05,lblMealType_05);
    }//GEN-LAST:event_rb_D_05ActionPerformed

    private void rb_A_06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_06ActionPerformed
        obj.setMealTypes(rb_A_06,rb_B_06,rb_C_06,rb_D_06,lblMealType_06);
    }//GEN-LAST:event_rb_A_06ActionPerformed

    private void rb_B_06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_06ActionPerformed
        obj.setMealTypes(rb_A_06,rb_B_06,rb_C_06,rb_D_06,lblMealType_06);
    }//GEN-LAST:event_rb_B_06ActionPerformed

    private void rb_C_06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_06ActionPerformed
         obj.setMealTypes(rb_A_06,rb_B_06,rb_C_06,rb_D_06,lblMealType_06);
    }//GEN-LAST:event_rb_C_06ActionPerformed

    private void rb_D_06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_06ActionPerformed
        obj.setMealTypes(rb_A_06,rb_B_06,rb_C_06,rb_D_06,lblMealType_06);
    }//GEN-LAST:event_rb_D_06ActionPerformed

    private void rb_A_07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_07ActionPerformed
         obj.setMealTypes(rb_A_07,rb_B_07,rb_C_07,rb_D_07,lblMealType_07);
    }//GEN-LAST:event_rb_A_07ActionPerformed

    private void rb_B_07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_07ActionPerformed
       obj.setMealTypes(rb_A_07,rb_B_07,rb_C_07,rb_D_07,lblMealType_07);
    }//GEN-LAST:event_rb_B_07ActionPerformed

    private void rb_C_07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_07ActionPerformed
       obj.setMealTypes(rb_A_07,rb_B_07,rb_C_07,rb_D_07,lblMealType_07);
    }//GEN-LAST:event_rb_C_07ActionPerformed

    private void rb_D_07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_07ActionPerformed
        obj.setMealTypes(rb_A_07,rb_B_07,rb_C_07,rb_D_07,lblMealType_07);
    }//GEN-LAST:event_rb_D_07ActionPerformed

    private void rb_A_08MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_A_08MouseClicked
       obj.setMealTypes(rb_A_08,rb_B_08,rb_C_08,rb_D_08,lblMealType_08);
    }//GEN-LAST:event_rb_A_08MouseClicked

    private void rb_B_08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_08ActionPerformed
       obj.setMealTypes(rb_A_08,rb_B_08,rb_C_08,rb_D_08,lblMealType_08);
    }//GEN-LAST:event_rb_B_08ActionPerformed

    private void rb_C_08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_08ActionPerformed
       obj.setMealTypes(rb_A_08,rb_B_08,rb_C_08,rb_D_08,lblMealType_08);
    }//GEN-LAST:event_rb_C_08ActionPerformed

    private void rb_D_08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_08ActionPerformed
       obj.setMealTypes(rb_A_08,rb_B_08,rb_C_08,rb_D_08,lblMealType_08);
    }//GEN-LAST:event_rb_D_08ActionPerformed

    private void rb_A_09MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_A_09MouseClicked
       obj.setMealTypes(rb_A_09,rb_B_09,rb_C_09,rb_D_09,lblMealType_09);
    }//GEN-LAST:event_rb_A_09MouseClicked

    private void rb_B_09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_09ActionPerformed
       obj.setMealTypes(rb_A_09,rb_B_09,rb_C_09,rb_D_09,lblMealType_09);
    }//GEN-LAST:event_rb_B_09ActionPerformed

    private void rb_C_09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_09ActionPerformed
       obj.setMealTypes(rb_A_09,rb_B_09,rb_C_09,rb_D_09,lblMealType_09);
    }//GEN-LAST:event_rb_C_09ActionPerformed

    private void rb_D_09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_09ActionPerformed
        obj.setMealTypes(rb_A_09,rb_B_09,rb_C_09,rb_D_09,lblMealType_09);
    }//GEN-LAST:event_rb_D_09ActionPerformed

    private void rb_A_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_10ActionPerformed
        obj.setMealTypes(rb_A_10,rb_B_10,rb_C_10,rb_D_10,lblMealType_10);
    }//GEN-LAST:event_rb_A_10ActionPerformed

    private void rb_B_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_10ActionPerformed
         obj.setMealTypes(rb_A_10,rb_B_10,rb_C_10,rb_D_10,lblMealType_10);
    }//GEN-LAST:event_rb_B_10ActionPerformed

    private void rb_C_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_10ActionPerformed
        obj.setMealTypes(rb_A_10,rb_B_10,rb_C_10,rb_D_10,lblMealType_10);
    }//GEN-LAST:event_rb_C_10ActionPerformed

    private void rb_D_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_10ActionPerformed
        obj.setMealTypes(rb_A_10,rb_B_10,rb_C_10,rb_D_10,lblMealType_10);
    }//GEN-LAST:event_rb_D_10ActionPerformed

    private void rb_A_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_11ActionPerformed
        obj.setMealTypes(rb_A_11,rb_B_11,rb_C_11,rb_D_11,lblMealType_11);
    }//GEN-LAST:event_rb_A_11ActionPerformed

    private void rb_B_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_11ActionPerformed
         obj.setMealTypes(rb_A_11,rb_B_11,rb_C_11,rb_D_11,lblMealType_11);
    }//GEN-LAST:event_rb_B_11ActionPerformed

    private void rb_C_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_11ActionPerformed
         obj.setMealTypes(rb_A_11,rb_B_11,rb_C_11,rb_D_11,lblMealType_11);
    }//GEN-LAST:event_rb_C_11ActionPerformed

    private void rb_D_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_11ActionPerformed
         obj.setMealTypes(rb_A_11,rb_B_11,rb_C_11,rb_D_11,lblMealType_11);
    }//GEN-LAST:event_rb_D_11ActionPerformed

    private void rb_A_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_A_12MouseClicked
        obj.setMealTypes(rb_A_12,rb_B_12,rb_C_12,rb_D_12,lblMealType_12);
    }//GEN-LAST:event_rb_A_12MouseClicked

    private void rb_B_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_12ActionPerformed
        obj.setMealTypes(rb_A_12,rb_B_12,rb_C_12,rb_D_12,lblMealType_12);
    }//GEN-LAST:event_rb_B_12ActionPerformed

    private void rb_C_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_12ActionPerformed
       obj.setMealTypes(rb_A_12,rb_B_12,rb_C_12,rb_D_12,lblMealType_12);
    }//GEN-LAST:event_rb_C_12ActionPerformed

    private void rb_D_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_12ActionPerformed
       obj.setMealTypes(rb_A_12,rb_B_12,rb_C_12,rb_D_12,lblMealType_12);
    }//GEN-LAST:event_rb_D_12ActionPerformed

    private void rb_A_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_13ActionPerformed
       obj.setMealTypes(rb_A_13,rb_B_13,rb_C_13,rb_D_13,lblMealType_13);
    }//GEN-LAST:event_rb_A_13ActionPerformed

    private void rb_B_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_13ActionPerformed
         obj.setMealTypes(rb_A_13,rb_B_13,rb_C_13,rb_D_13,lblMealType_13);
    }//GEN-LAST:event_rb_B_13ActionPerformed

    private void rb_C_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_13ActionPerformed
        obj.setMealTypes(rb_A_13,rb_B_13,rb_C_13,rb_D_13,lblMealType_13);
    }//GEN-LAST:event_rb_C_13ActionPerformed

    private void rb_D_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_13ActionPerformed
        obj.setMealTypes(rb_A_13,rb_B_13,rb_C_13,rb_D_13,lblMealType_13);
    }//GEN-LAST:event_rb_D_13ActionPerformed

    private void rb_A_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_14ActionPerformed
        obj.setMealTypes(rb_A_14,rb_B_14,rb_C_14,rb_D_14,lblMealType_14);
    }//GEN-LAST:event_rb_A_14ActionPerformed

    private void rb_B_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_14ActionPerformed
       obj.setMealTypes(rb_A_14,rb_B_14,rb_C_14,rb_D_14,lblMealType_14);
    }//GEN-LAST:event_rb_B_14ActionPerformed

    private void rb_C_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_14ActionPerformed
       obj.setMealTypes(rb_A_14,rb_B_14,rb_C_14,rb_D_14,lblMealType_14);
    }//GEN-LAST:event_rb_C_14ActionPerformed

    private void rb_D_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_14ActionPerformed
        obj.setMealTypes(rb_A_14,rb_B_14,rb_C_14,rb_D_14,lblMealType_14);
    }//GEN-LAST:event_rb_D_14ActionPerformed

    private void rb_A_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_A_15ActionPerformed
       obj.setMealTypes(rb_A_15,rb_B_15,rb_C_15,rb_D_15,lblMealType_15);
    }//GEN-LAST:event_rb_A_15ActionPerformed

    private void rb_B_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_B_15ActionPerformed
       obj.setMealTypes(rb_A_15,rb_B_15,rb_C_15,rb_D_15,lblMealType_15);
    }//GEN-LAST:event_rb_B_15ActionPerformed

    private void rb_C_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_C_15ActionPerformed
       obj.setMealTypes(rb_A_15,rb_B_15,rb_C_15,rb_D_15,lblMealType_15);
    }//GEN-LAST:event_rb_C_15ActionPerformed

    private void rb_D_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_D_15ActionPerformed
        obj.setMealTypes(rb_A_15,rb_B_15,rb_C_15,rb_D_15,lblMealType_15);
    }//GEN-LAST:event_rb_D_15ActionPerformed

    private void cmbNumOfAdultsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbNumOfAdultsPropertyChange
       int a = Integer.parseInt(cmbNumOfAdults.getSelectedItem().toString());
         int b = Integer.parseInt(cmbNumOfChildren.getSelectedItem().toString());
         int c = a+b;
         lblTotalGuest.setText(Integer.toString(c));
    }//GEN-LAST:event_cmbNumOfAdultsPropertyChange

    private void cmbNumOfChildrenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbNumOfChildrenPropertyChange
        int a = Integer.parseInt(cmbNumOfAdults.getSelectedItem().toString());
         int b = Integer.parseInt(cmbNumOfChildren.getSelectedItem().toString());
         int c = a+b;
         lblTotalGuest.setText(Integer.toString(c));
    }//GEN-LAST:event_cmbNumOfChildrenPropertyChange

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
       obj.SetRoomTiiles();
        obj.defaultCountry();
        obj.setCurrentDate();
        obj.loadListFromDB("Room Type", "room_types", cmbRoomTypes);
        cmbRoomTypes.addItem("All");
        
        obj.hidePnlRoomTypes();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseExited
    
    private void clear()
    {
      /*  txtFirstName.setText("");
        txtLastName.setText("");
        txtContactNo.setText("");
        txtAddress.setText("");
        txtEmail.setText("");*/
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup NICS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup15;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    public static javax.swing.JComboBox<String> cmbCountry;
    public static javax.swing.JComboBox<String> cmbGender;
    public static javax.swing.JComboBox<String> cmbNumOfAdults;
    public static javax.swing.JComboBox<String> cmbNumOfChildren;
    public static javax.swing.JComboBox<String> cmbNumOfNights;
    public static javax.swing.JComboBox<String> cmbRoomTypes;
    public static javax.swing.JComboBox<String> cmbTitel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static com.toedter.calendar.JDateChooser jdcCheckOutDate;
    public static javax.swing.JLabel lblBedType_01;
    public static javax.swing.JLabel lblBedType_02;
    public static javax.swing.JLabel lblBedType_03;
    public static javax.swing.JLabel lblBedType_04;
    public static javax.swing.JLabel lblBedType_05;
    public static javax.swing.JLabel lblBedType_06;
    public static javax.swing.JLabel lblBedType_07;
    public static javax.swing.JLabel lblBedType_08;
    public static javax.swing.JLabel lblBedType_09;
    public static javax.swing.JLabel lblBedType_10;
    public static javax.swing.JLabel lblBedType_11;
    public static javax.swing.JLabel lblBedType_12;
    public static javax.swing.JLabel lblBedType_13;
    public static javax.swing.JLabel lblBedType_14;
    public static javax.swing.JLabel lblBedType_15;
    public static javax.swing.JLabel lblLeavingDate;
    public static javax.swing.JLabel lblMaxGuestCount_01;
    public static javax.swing.JLabel lblMaxGuestCount_02;
    public static javax.swing.JLabel lblMaxGuestCount_03;
    public static javax.swing.JLabel lblMaxGuestCount_04;
    public static javax.swing.JLabel lblMaxGuestCount_05;
    public static javax.swing.JLabel lblMaxGuestCount_06;
    public static javax.swing.JLabel lblMaxGuestCount_07;
    public static javax.swing.JLabel lblMaxGuestCount_08;
    public static javax.swing.JLabel lblMaxGuestCount_09;
    public static javax.swing.JLabel lblMaxGuestCount_10;
    public static javax.swing.JLabel lblMaxGuestCount_11;
    public static javax.swing.JLabel lblMaxGuestCount_12;
    public static javax.swing.JLabel lblMaxGuestCount_13;
    public static javax.swing.JLabel lblMaxGuestCount_14;
    public static javax.swing.JLabel lblMaxGuestCount_15;
    public static javax.swing.JLabel lblMealType_01;
    public static javax.swing.JLabel lblMealType_02;
    public static javax.swing.JLabel lblMealType_03;
    public static javax.swing.JLabel lblMealType_04;
    public static javax.swing.JLabel lblMealType_05;
    public static javax.swing.JLabel lblMealType_06;
    public static javax.swing.JLabel lblMealType_07;
    public static javax.swing.JLabel lblMealType_08;
    public static javax.swing.JLabel lblMealType_09;
    public static javax.swing.JLabel lblMealType_10;
    public static javax.swing.JLabel lblMealType_11;
    public static javax.swing.JLabel lblMealType_12;
    public static javax.swing.JLabel lblMealType_13;
    public static javax.swing.JLabel lblMealType_14;
    public static javax.swing.JLabel lblMealType_15;
    public static javax.swing.JLabel lblRoomNo;
    public static javax.swing.JLabel lblRoomRate_01;
    public static javax.swing.JLabel lblRoomRate_02;
    public static javax.swing.JLabel lblRoomRate_03;
    public static javax.swing.JLabel lblRoomRate_04;
    public static javax.swing.JLabel lblRoomRate_05;
    public static javax.swing.JLabel lblRoomRate_06;
    public static javax.swing.JLabel lblRoomRate_07;
    public static javax.swing.JLabel lblRoomRate_08;
    public static javax.swing.JLabel lblRoomRate_09;
    public static javax.swing.JLabel lblRoomRate_10;
    public static javax.swing.JLabel lblRoomRate_11;
    public static javax.swing.JLabel lblRoomRate_12;
    public static javax.swing.JLabel lblRoomRate_13;
    public static javax.swing.JLabel lblRoomRate_14;
    public static javax.swing.JLabel lblRoomRate_15;
    public static javax.swing.JLabel lblRoomType_01;
    public static javax.swing.JLabel lblRoomType_02;
    public static javax.swing.JLabel lblRoomType_03;
    public static javax.swing.JLabel lblRoomType_04;
    public static javax.swing.JLabel lblRoomType_05;
    public static javax.swing.JLabel lblRoomType_06;
    public static javax.swing.JLabel lblRoomType_07;
    public static javax.swing.JLabel lblRoomType_08;
    public static javax.swing.JLabel lblRoomType_09;
    public static javax.swing.JLabel lblRoomType_10;
    public static javax.swing.JLabel lblRoomType_11;
    public static javax.swing.JLabel lblRoomType_12;
    public static javax.swing.JLabel lblRoomType_13;
    public static javax.swing.JLabel lblRoomType_14;
    public static javax.swing.JLabel lblRoomType_15;
    private javax.swing.JLabel lblTotalGuest;
    public static javax.swing.JPanel pnlMealType_01;
    public static javax.swing.JPanel pnlMealType_02;
    public static javax.swing.JPanel pnlMealType_03;
    public static javax.swing.JPanel pnlMealType_04;
    public static javax.swing.JPanel pnlMealType_05;
    public static javax.swing.JPanel pnlMealType_06;
    public static javax.swing.JPanel pnlMealType_07;
    public static javax.swing.JPanel pnlMealType_08;
    public static javax.swing.JPanel pnlMealType_09;
    public static javax.swing.JPanel pnlMealType_10;
    public static javax.swing.JPanel pnlMealType_11;
    public static javax.swing.JPanel pnlMealType_12;
    public static javax.swing.JPanel pnlMealType_13;
    public static javax.swing.JPanel pnlMealType_14;
    public static javax.swing.JPanel pnlMealType_15;
    public static javax.swing.JPanel pnlRoom_01;
    public static javax.swing.JPanel pnlRoom_02;
    public static javax.swing.JPanel pnlRoom_03;
    public static javax.swing.JPanel pnlRoom_04;
    public static javax.swing.JPanel pnlRoom_05;
    public static javax.swing.JPanel pnlRoom_06;
    public static javax.swing.JPanel pnlRoom_07;
    public static javax.swing.JPanel pnlRoom_08;
    public static javax.swing.JPanel pnlRoom_09;
    public static javax.swing.JPanel pnlRoom_10;
    public static javax.swing.JPanel pnlRoom_11;
    public static javax.swing.JPanel pnlRoom_12;
    public static javax.swing.JPanel pnlRoom_13;
    public static javax.swing.JPanel pnlRoom_14;
    public static javax.swing.JPanel pnlRoom_15;
    public static javax.swing.JRadioButton rb_A_01;
    public static javax.swing.JRadioButton rb_A_02;
    public static javax.swing.JRadioButton rb_A_03;
    public static javax.swing.JRadioButton rb_A_04;
    public static javax.swing.JRadioButton rb_A_05;
    public static javax.swing.JRadioButton rb_A_06;
    public static javax.swing.JRadioButton rb_A_07;
    public static javax.swing.JRadioButton rb_A_08;
    public static javax.swing.JRadioButton rb_A_09;
    public static javax.swing.JRadioButton rb_A_10;
    public static javax.swing.JRadioButton rb_A_11;
    public static javax.swing.JRadioButton rb_A_12;
    public static javax.swing.JRadioButton rb_A_13;
    public static javax.swing.JRadioButton rb_A_14;
    public static javax.swing.JRadioButton rb_A_15;
    public static javax.swing.JRadioButton rb_B_01;
    public static javax.swing.JRadioButton rb_B_02;
    public static javax.swing.JRadioButton rb_B_03;
    public static javax.swing.JRadioButton rb_B_04;
    public static javax.swing.JRadioButton rb_B_05;
    public static javax.swing.JRadioButton rb_B_06;
    public static javax.swing.JRadioButton rb_B_07;
    public static javax.swing.JRadioButton rb_B_08;
    public static javax.swing.JRadioButton rb_B_09;
    public static javax.swing.JRadioButton rb_B_10;
    public static javax.swing.JRadioButton rb_B_11;
    public static javax.swing.JRadioButton rb_B_12;
    public static javax.swing.JRadioButton rb_B_13;
    public static javax.swing.JRadioButton rb_B_14;
    public static javax.swing.JRadioButton rb_B_15;
    public static javax.swing.JRadioButton rb_C_01;
    public static javax.swing.JRadioButton rb_C_02;
    public static javax.swing.JRadioButton rb_C_03;
    public static javax.swing.JRadioButton rb_C_04;
    public static javax.swing.JRadioButton rb_C_05;
    public static javax.swing.JRadioButton rb_C_06;
    public static javax.swing.JRadioButton rb_C_07;
    public static javax.swing.JRadioButton rb_C_08;
    public static javax.swing.JRadioButton rb_C_09;
    public static javax.swing.JRadioButton rb_C_10;
    public static javax.swing.JRadioButton rb_C_11;
    public static javax.swing.JRadioButton rb_C_12;
    public static javax.swing.JRadioButton rb_C_13;
    public static javax.swing.JRadioButton rb_C_14;
    public static javax.swing.JRadioButton rb_C_15;
    public static javax.swing.JRadioButton rb_D_01;
    public static javax.swing.JRadioButton rb_D_02;
    public static javax.swing.JRadioButton rb_D_03;
    public static javax.swing.JRadioButton rb_D_04;
    public static javax.swing.JRadioButton rb_D_05;
    public static javax.swing.JRadioButton rb_D_06;
    public static javax.swing.JRadioButton rb_D_07;
    public static javax.swing.JRadioButton rb_D_08;
    public static javax.swing.JRadioButton rb_D_09;
    public static javax.swing.JRadioButton rb_D_10;
    public static javax.swing.JRadioButton rb_D_11;
    public static javax.swing.JRadioButton rb_D_12;
    public static javax.swing.JRadioButton rb_D_13;
    public static javax.swing.JRadioButton rb_D_14;
    public static javax.swing.JRadioButton rb_D_15;
    public static javax.swing.JTextField txtAge;
    public static javax.swing.JTextField txtCity;
    public static javax.swing.JTextField txtContactNo;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtFirstName;
    public static javax.swing.JTextField txtLastName;
    public static javax.swing.JTextField txtNicPass;
    public static javax.swing.JTextField txtState;
    public static javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
}
