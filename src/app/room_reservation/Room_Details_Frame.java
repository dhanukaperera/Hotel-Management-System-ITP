
package app.room_reservation;

import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.room_reservation.Room_Details_Model;

public class Room_Details_Frame extends javax.swing.JPanel 
{   
    public Room_Details_Model obj = new Room_Details_Model();
    
    final String columnList = "Room No,Date Modified,Room Type,Bed Type,Max Guests,Service Stautus,Description";
    final String roomTypesColList= "Room Type,Date Modified,Rate (LKR)";
    
    public Room_Details_Frame() 
    {
        initComponents();
       
        
        obj.loadListFromDB("Room Type", "room_types", cmbRoomType);
        obj.tableLoad(tblRoomDeatils,"rooms",columnList,lblLastUpdate,lblRowCountRoomDeatils,cmbSearchBy1);
        
      
        
        obj.tableLoad(tblRoomTypes, "room_types", roomTypesColList, lblLastUpdate1, lblRowCountRoomTypes);
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnPrint1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        pnlTable = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRoomDeatils = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cmbSearchBy1 = new javax.swing.JComboBox<>();
        lblSearchBy = new javax.swing.JLabel();
        cmbOderBy = new javax.swing.JComboBox<>();
        cmbDisplayOnly = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JLabel();
        lblLastUpdate = new javax.swing.JLabel();
        lblRowCountRoomDeatils = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        pnlTable1 = new javax.swing.JPanel();
        lblLastUpdate1 = new javax.swing.JLabel();
        lblRowCountRoomTypes = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRoomTypes = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtAddRoomType = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtRateForADay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDeleteRoomType = new javax.swing.JLabel();
        btnUpdateRoomType = new javax.swing.JLabel();
        btnAddRoomType = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtRoomNo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmbRoomType = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cmbBedType = new javax.swing.JComboBox<>();
        cmbMaxGuests = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmbServiceStatus = new javax.swing.JComboBox<>();
        txtDescription = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(221, 221, 221));

        btnUpdate.setBackground(new java.awt.Color(241, 196, 15));
        btnUpdate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setFocusable(false);
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setOpaque(true);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(52, 152, 219));
        btnPrint.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");
        btnPrint.setBorder(null);
        btnPrint.setBorderPainted(false);
        btnPrint.setContentAreaFilled(false);
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setOpaque(true);
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
        });

        btnPrint1.setBackground(new java.awt.Color(149, 165, 166));
        btnPrint1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnPrint1.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint1.setText("Clear");
        btnPrint1.setBorder(null);
        btnPrint1.setBorderPainted(false);
        btnPrint1.setContentAreaFilled(false);
        btnPrint1.setFocusable(false);
        btnPrint1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint1.setOpaque(true);
        btnPrint1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrint1MouseClicked(evt);
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
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTable.setBackground(new java.awt.Color(51, 51, 51));
        pnlTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        tblRoomDeatils.setBackground(new java.awt.Color(52, 73, 94));
        tblRoomDeatils.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRoomDeatils.setForeground(new java.awt.Color(255, 255, 255));
        tblRoomDeatils.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblRoomDeatils.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblRoomDeatils.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomDeatilsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRoomDeatils);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        txtSearch.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setText("Search...");
        txtSearch.setOpaque(false);
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cmbSearchBy1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbSearchBy1.setBorder(null);
        cmbSearchBy1.setFocusable(false);
        cmbSearchBy1.setOpaque(false);

        lblSearchBy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSearchBy.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchBy.setText("Search By");

        cmbOderBy.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbOderBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order by A-Z", "Order by Z-A" }));
        cmbOderBy.setBorder(null);
        cmbOderBy.setFocusable(false);
        cmbOderBy.setOpaque(false);
        cmbOderBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOderByActionPerformed(evt);
            }
        });

        cmbDisplayOnly.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbDisplayOnly.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Records", "This Year Records", "This Month Records", "This Week Records", "Today Records" }));
        cmbDisplayOnly.setBorder(null);
        cmbDisplayOnly.setFocusable(false);
        cmbDisplayOnly.setOpaque(false);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/nextSearchButton.png"))); // NOI18N

        lblLastUpdate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLastUpdate.setForeground(new java.awt.Color(255, 255, 255));
        lblLastUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Refresh-16.png"))); // NOI18N
        lblLastUpdate.setText("Last Updated 2016-08-11");
        lblLastUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLastUpdateMouseClicked(evt);
            }
        });

        lblRowCountRoomDeatils.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblRowCountRoomDeatils.setForeground(new java.awt.Color(255, 255, 255));
        lblRowCountRoomDeatils.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRowCountRoomDeatils.setText("0 Records");

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Display Only");
        jCheckBox1.setBorder(null);
        jCheckBox1.setFocusable(false);
        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Unchecked Checkbox Filled-16.png"))); // NOI18N
        jCheckBox1.setOpaque(false);
        jCheckBox1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Checked Checkbox 2-16.png"))); // NOI18N

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Order By : ");
        jCheckBox2.setBorder(null);
        jCheckBox2.setFocusable(false);
        jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Unchecked Checkbox Filled-16.png"))); // NOI18N
        jCheckBox2.setOpaque(false);
        jCheckBox2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Checked Checkbox 2-16.png"))); // NOI18N

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblSearchBy)
                        .addGap(5, 5, 5)
                        .addComponent(cmbSearchBy1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDisplayOnly, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblLastUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRowCountRoomDeatils, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSearchBy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSearchBy))
                    .addComponent(btnSearch)
                    .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbOderBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbDisplayOnly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)
                        .addComponent(jCheckBox2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastUpdate)
                    .addComponent(lblRowCountRoomDeatils)))
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel8.setMinimumSize(new java.awt.Dimension(622, 233));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        pnlTable1.setBackground(new java.awt.Color(51, 51, 51));
        pnlTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        lblLastUpdate1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLastUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        lblLastUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/Refresh-16.png"))); // NOI18N
        lblLastUpdate1.setText("Last Updated 2016-08-11");
        lblLastUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLastUpdate1MouseClicked(evt);
            }
        });

        lblRowCountRoomTypes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblRowCountRoomTypes.setForeground(new java.awt.Color(255, 255, 255));
        lblRowCountRoomTypes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRowCountRoomTypes.setText("0 Records");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        tblRoomTypes.setBackground(new java.awt.Color(52, 73, 94));
        tblRoomTypes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRoomTypes.setForeground(new java.awt.Color(255, 255, 255));
        tblRoomTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Room Type", "Rate"
            }
        ));
        tblRoomTypes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomTypesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRoomTypes);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTable1Layout = new javax.swing.GroupLayout(pnlTable1);
        pnlTable1.setLayout(pnlTable1Layout);
        pnlTable1Layout.setHorizontalGroup(
            pnlTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTable1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblLastUpdate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(lblRowCountRoomTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlTable1Layout.setVerticalGroup(
            pnlTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTable1Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(pnlTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastUpdate1)
                    .addComponent(lblRowCountRoomTypes)))
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Room Type");

        txtAddRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Rate for a Day");

        txtRateForADay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddRoomType, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRateForADay)))
                .addGap(18, 18, 18)
                .addComponent(pnlTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRateForADay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Create Room Types");

        btnDeleteRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnDeleteRoomType.setForeground(new java.awt.Color(231, 76, 60));
        btnDeleteRoomType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDeleteRoomType.setText("Delete");
        btnDeleteRoomType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 57, 43)));
        btnDeleteRoomType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteRoomTypeMouseClicked(evt);
            }
        });

        btnUpdateRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnUpdateRoomType.setForeground(new java.awt.Color(241, 196, 15));
        btnUpdateRoomType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUpdateRoomType.setText("Update");
        btnUpdateRoomType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 156, 18)));
        btnUpdateRoomType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateRoomTypeMouseClicked(evt);
            }
        });

        btnAddRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAddRoomType.setForeground(new java.awt.Color(46, 204, 113));
        btnAddRoomType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddRoomType.setText("Add");
        btnAddRoomType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 204, 113)));
        btnAddRoomType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddRoomTypeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnUpdateRoomType)
                    .addComponent(btnAddRoomType)
                    .addComponent(btnDeleteRoomType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel10.setMinimumSize(new java.awt.Dimension(364, 233));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Room No");

        txtRoomNo.setEditable(false);
        txtRoomNo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Room Type");

        cmbRoomType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Bed Type");

        cmbBedType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBedType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 X Single Bed", "2 X Single Bed", "1 X Double Bed", "2 X Doulbe Bed" }));

        cmbMaxGuests.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbMaxGuests.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Max Guests");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Service Status");

        cmbServiceStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbServiceStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Avaible", "Not Avaible" }));

        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Description ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbBedType, 0, 238, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMaxGuests, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRoomNo))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRoomType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbServiceStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescription)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbBedType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbMaxGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbServiceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Room Details ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel8});

    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void lblLastUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLastUpdateMouseClicked
        txtSearch.setText("Search...");
        obj.tableLoad(tblRoomDeatils,"rooms",columnList,lblLastUpdate,lblRowCountRoomDeatils,cmbSearchBy1);
    }//GEN-LAST:event_lblLastUpdateMouseClicked

    private void btnAddRoomTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRoomTypeMouseClicked
//        //String cols ="Date Modified,Room Type,Bed Type,Max Guests,Service Stautus,Description)";
//        String cols ="Date Modified,Room Type,Bed Type,Max Guests,Service Stautus,Description";//Description
//        String vals = obj.sendValues();
//        obj.newAdd("rooms",cols,vals);
//         obj.tableLoad(tblRoomDeatils,"rooms",columnList,lblLastUpdate,lblRowCountRoomDeatils,cmbSearchBy1);
        int msg = JOptionPane.showConfirmDialog(null, "Do you really want to ADD this record?");
        if(msg == 0)
        {
            String roomTypeVals = obj.sendRoomTypesValues();
            obj.newAdd("room_types",roomTypesColList,roomTypeVals);
            obj.tableLoad(tblRoomTypes, "room_types", roomTypesColList, lblLastUpdate1, lblRowCountRoomTypes);
        }
    }//GEN-LAST:event_btnAddRoomTypeMouseClicked

    private void cmbOderByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOderByActionPerformed
       obj.orderBy(tblRoomDeatils,"rooms",columnList,lblLastUpdate,lblRowCountRoomDeatils,cmbSearchBy1,cmbOderBy);
    }//GEN-LAST:event_cmbOderByActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
       
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        obj.search(tblRoomDeatils,"rooms",columnList,lblLastUpdate,lblRowCountRoomDeatils,cmbSearchBy1,txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnUpdateRoomTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateRoomTypeMouseClicked
        int msg = JOptionPane.showConfirmDialog(null, "Do you really want to UPDATE this record?");
        if(msg == 0)
        {
            String roomTypeVals = obj.sendRoomTypesValues();
            obj.newUpdate("room_types",roomTypesColList,roomTypeVals,"Room Type",obj.getRoomTypePrimaryKey());
            obj.tableLoad(tblRoomTypes, "room_types", roomTypesColList, lblLastUpdate1, lblRowCountRoomTypes);
        }
        
    }//GEN-LAST:event_btnUpdateRoomTypeMouseClicked

    private void btnDeleteRoomTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteRoomTypeMouseClicked
     obj.report();
     /*
    int msg = JOptionPane.showConfirmDialog(null, "Do you really want to DELETE this record?");
    if(msg == 0)
    {
         obj.newDelete("room_types", "Room Type", obj.getRoomTypePrimaryKey(), tblRoomTypes);
       obj.tableLoad(tblRoomTypes, "room_types", roomTypesColList, lblLastUpdate1, lblRowCountRoomTypes);
    }*/
     //
    }//GEN-LAST:event_btnDeleteRoomTypeMouseClicked

    private void tblRoomDeatilsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomDeatilsMouseClicked
        obj.setRoomTypes();
    }//GEN-LAST:event_tblRoomDeatilsMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        int msg = JOptionPane.showConfirmDialog(null, "Do you really want to UPDATE this record?");
        if(msg == 0)
        {
            String tbCols = "Date Modified,Room Type,Bed Type,Max Guests,Service Stautus,Description";
            obj.newUpdate("rooms",tbCols,obj.sendValues(),"Room No",obj.getPrimaryKey());
            obj.tableLoad(tblRoomDeatils,"rooms",columnList,lblLastUpdate,lblRowCountRoomDeatils,cmbSearchBy1);
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void tblRoomTypesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomTypesMouseClicked
        obj.setRoomTypesDeatils();
    }//GEN-LAST:event_tblRoomTypesMouseClicked

    private void lblLastUpdate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLastUpdate1MouseClicked
         obj.tableLoad(tblRoomTypes, "room_types", roomTypesColList, lblLastUpdate1, lblRowCountRoomTypes);
    }//GEN-LAST:event_lblLastUpdate1MouseClicked

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        MessageFormat header = new MessageFormat("Room Deatils - Report");
        MessageFormat footer = new MessageFormat("");
        try 
        {
            tblRoomDeatils.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } 
        catch (Exception e) 
        {
            
        }
       
     
    }//GEN-LAST:event_btnPrintMouseClicked

    private void btnPrint1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrint1MouseClicked
       JOptionPane.showMessageDialog(null,"Room rates can't be Empty!","Error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnPrint1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
      obj.loadListFromDB("Room Type", "room_types", cmbRoomType);
        obj.tableLoad(tblRoomDeatils,"rooms",columnList,lblLastUpdate,lblRowCountRoomDeatils,cmbSearchBy1);
        
      
        
        obj.tableLoad(tblRoomTypes, "room_types", roomTypesColList, lblLastUpdate1, lblRowCountRoomTypes);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddRoomType;
    private javax.swing.JLabel btnDeleteRoomType;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnPrint1;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel btnUpdateRoomType;
    public static javax.swing.JComboBox<String> cmbBedType;
    public static javax.swing.JComboBox<String> cmbDisplayOnly;
    public static javax.swing.JComboBox<String> cmbMaxGuests;
    public static javax.swing.JComboBox<String> cmbOderBy;
    public static javax.swing.JComboBox<String> cmbRoomType;
    public static javax.swing.JComboBox<String> cmbSearchBy1;
    public static javax.swing.JComboBox<String> cmbServiceStatus;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel lblLastUpdate;
    public javax.swing.JLabel lblLastUpdate1;
    public static javax.swing.JLabel lblRowCountRoomDeatils;
    public static javax.swing.JLabel lblRowCountRoomTypes;
    private javax.swing.JLabel lblSearchBy;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTable1;
    public static javax.swing.JTable tblRoomDeatils;
    public static javax.swing.JTable tblRoomTypes;
    public static javax.swing.JTextField txtAddRoomType;
    public static javax.swing.JTextField txtDescription;
    public static javax.swing.JTextField txtRateForADay;
    public static javax.swing.JTextField txtRoomNo;
    public static javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables


}


