/*
 * Hotel Management System for Pavana Hotel Kochchikade
 * Information Technology Project - 2016
 * Project ID   : ITP_WD_16_B1_06
 * Supervisor   : Mrs. Asanthika Imbulpitiya
 *
 * Student Name : Perera P.D.S   
 * IT Number    : IT14031380
*/

package app;

import app.employee_management.Attendance_Frame;
import app.employee_management.Employee_Details_Frame;
import app.employee_management.Employee_Management_Help_Frame;
import app.employee_management.Leave_Requirements_Frame;
import app.employee_management.Manage_Employee_Roles_Frames;
import app.employee_management.Salary_Calculation_Frame;
import app.employee_management.Shift_Management_Frame;
import app.employee_management.System_Users_Frame;
import app.event_handling.Bill_Frame;
import app.event_handling.Create_Menu_Package_Frame;
import app.event_handling.Customer_Information_Frame;
import app.event_handling.Cutlery_And_Equipment_Frame;
import app.event_handling.Event_Handling_Help_Frame;
import app.event_handling.Transfer_Income_Frame;
import app.event_handling.Venue_Booking_Frame;
import app.event_handling.View_Booking_Frame;
import app.finance_management.Decision_Helper_Frame;
import app.finance_management.Expenses_Management_Frame;
import app.finance_management.Expenses_Management_Help_Frame;
import app.finance_management.Incomes_Management_Frame;
import app.finance_management.Profit_And_Loss_Comparison_Frame;
import app.laundry_and_room_service.Finance_Frame;
import app.laundry_and_room_service.Guest_Orders_Frame;
import app.laundry_and_room_service.Hotel_Orders_Frame;
import app.laundry_and_room_service.Laundry_And_Room_Service_Help_Frame;
import app.laundry_and_room_service.Room_States__Frame;
import app.restaurant_management.All_Bill_Details_Details_Frame;
import app.restaurant_management.Dine_In_Bill_Frame;
import app.restaurant_management.Food_And_Drink_Details_Frame;
import app.restaurant_management.Restaurant_Bill_Frames;
import app.restaurant_management.Restaurant_Management_Help;
import app.restaurant_management.Restaurant_Settings_Frame;
import app.restaurant_management.Room_Guest_Orders_Frames;
import app.room_reservation.Bill_Generation_Frame;
import app.room_reservation.Guest_Details_Frame;
import app.room_reservation.Reservations_Frame;
import static app.room_reservation.Reservations_Frame.cmbRoomTypes;
import app.room_reservation.Room_Availability_Frame;
import app.room_reservation.Room_Details_Frame;
import app.room_reservation.Room_Reservation_Help_Frame;
import app.room_reservation.Transfer_Amount_Frame;
import app.room_reservation.View_Reservations_Frame;
import static app.room_reservation.View_Reservations_Frame.cmbSearchBy;
import static app.room_reservation.View_Reservations_Frame.lblNumOfRecords;
import static app.room_reservation.View_Reservations_Frame.tblReservationDeatils;
import app.stock_management.Stock_Details_Frame;
import app.stock_management.Stock_Frame_Frame;
import app.stock_management.Stock_History_Frame;
import app.stock_management.Stock_Management_Help_Frame;
import app.stock_management.Suppliers_Frame;
import app.stock_management.Taking_Stock_Frame;
import app.transport_and_tour_management.Airport_Pickup_Frame;
import app.transport_and_tour_management.Revenue_Report_Frame;
import app.transport_and_tour_management.Tour_Packages_Frame;
import app.transport_and_tour_management.Transport_Details_Frame;
import app.transport_and_tour_management.Trasport_And_Tour_Management_Help_Frame;
import app.transport_and_tour_management.Vehicle_Availability_Details_Frame;
import app.transport_and_tour_management.Vehicles_Frames;
import java.awt.Dimension;
import java.awt.Toolkit;
import model.employee_management.Employee_Details_Model;
import model.room_reservation.Reservations_Model;
import model.room_reservation.Room_Availability_Model;
import model.room_reservation.View_Reservations_Model;
import source.ImageProcessing;

public class Main extends javax.swing.JFrame {

    Statusbar loadStatusbar;
    
    //**************************************************************************
    // --Room Reservation ------------------------------------------------------
    Reservations_Frame loadReservations_Frame;
    View_Reservations_Frame loadView_Reservations_Frame;
    Bill_Generation_Frame loadBill_Generation_Frame;
    Guest_Details_Frame loadGuest_Details_Frame;
    Room_Details_Frame loadRoom_Details_Frame;
    Room_Availability_Frame loadRoom_Availability_Frame;
    Transfer_Amount_Frame loadTransfer_Amount_Frame;
    Room_Reservation_Help_Frame loadRoom_Reservation_Help_Frame;
    //--------------------------------------------------------------------------
    // --Restaurant_Management -------------------------------------------------
    Restaurant_Bill_Frames loadRestaurant_Bill_Frames;
    Dine_In_Bill_Frame loadDine_In_Bill_Frame;              // New Added
    Food_And_Drink_Details_Frame loadFood_And_Drink_Details_Frame;
    Room_Guest_Orders_Frames loadRoom_Guest_Orders_Frames;
    All_Bill_Details_Details_Frame loadAll_Bill_Details_Details_Frame;    // New Replaced 
    Restaurant_Settings_Frame loadRestaurant_Settings_Frame;        // New Added 
    Restaurant_Management_Help loadRestaurant_Management_Help;
    //--------------------------------------------------------------------------
    // --Event_Handling --------------------------------------------------------
    Venue_Booking_Frame loadVenue_Booking_Frame;
    View_Booking_Frame loadView_Booking_Frame;
    Customer_Information_Frame loadCustomer_Information_Frame;
    Cutlery_And_Equipment_Frame loadCutlery_And_Equipment_Frame;
    Bill_Frame loadBill_Frame;
    Create_Menu_Package_Frame loadCreate_Menu_Package_Frame;
    Transfer_Income_Frame loadTransfer_Income_Frame;
    Event_Handling_Help_Frame loadEvent_Handling_Help_Frame;
    //--------------------------------------------------------------------------
    // --Stock Management-------------------------------------------------------
    Stock_Frame_Frame loadStock_Frame_Frame;
    Suppliers_Frame loadSuppliers_Frame;
    Stock_Details_Frame loadStock_Details_Frame;
    Taking_Stock_Frame loadTaking_Stock_Frame;
    Stock_History_Frame loadStock_History_Frame;
    Stock_Management_Help_Frame loadStock_Management_Help_Frame;
    // -------------------------------------------------------------------------
    // --Employee_Management ---------------------------------------------------
    Employee_Details_Frame loadEmployee_Details_Frame;
    Manage_Employee_Roles_Frames loadManage_Employee_Roles_Frames;
    Shift_Management_Frame loadShift_Management_Frame;
    Attendance_Frame loadAttendance_Frame;
    Salary_Calculation_Frame loadSalary_Calculation_Frame;
    Leave_Requirements_Frame loadLeave_Requirements_Frame;
    System_Users_Frame loadSystem_Users_Frame;
    Employee_Management_Help_Frame loadEmployee_Management_Help_Frame;
    //--------------------------------------------------------------------------
    // --Finance_Management ----------------------------------------------------
    Incomes_Management_Frame loadIncomes_Management_Frame;
    Expenses_Management_Frame loadExpenses_Management_Frame;
    Profit_And_Loss_Comparison_Frame loadProfit_And_Loss_Comparison_Frame;
    Decision_Helper_Frame loadDecision_Helper_Frame;
    Expenses_Management_Help_Frame loadExpenses_Management_Help_Frame;
    //--------------------------------------------------------------------------
    // -- Transport_And_Tour_Management ----------------------------------------
    Airport_Pickup_Frame loadAirport_Pickup_Frame;
    Tour_Packages_Frame loadTour_Packages_Frame;
    Transport_Details_Frame loadTransport_Details_Frame;
    Vehicles_Frames loadVehicles_Frames;
    Vehicle_Availability_Details_Frame loadVehicle_Availability_Details_Frame;
    Revenue_Report_Frame loadRevenue_Report_Frame;
    Trasport_And_Tour_Management_Help_Frame loadTrasport_And_Tour_Management_Help_Frame;
    // -------------------------------------------------------------------------
    // -- Laundry_And_Room_Service ---------------------------------------------
    Hotel_Orders_Frame loadHotel_Orders_Frame;
    Guest_Orders_Frame loadGuest_Orders_Frame;
    Room_States__Frame loadRoom_States__Frame;
    Finance_Frame loadFinance_Frame;
    Laundry_And_Room_Service_Help_Frame loadLaundry_And_Room_Service_Help_Frame;
    //--------------------------------------------------------------------------
    //**************************************************************************

    
    // --Creating flag vars ----------------------------------------------------
    private static boolean flagRoomReservation;
    private static boolean flagRestaurantManagement;
    private static boolean flagEventHandling;
    private static boolean flagStockManagement;
    private static boolean flagEmployeeManagement;
    private static boolean flagFinanceManagement;
    private static boolean flagTransportAndTourManagement;
    private static boolean flagLaundryAndRoomService;
    private static boolean flagControlPanel;
    
    public ImageProcessing loadSockets;
    
    public ImageProcessing Socket = new ImageProcessing();
    public ImageProcessing Disk = new ImageProcessing();
    
    public Main() 
    {
        initComponents();
         
        setAppSize();
        
        setMenuOperations();
        setMainTitles();
        loadMenuIconsDef();
        //loadMenuIconsDef(true,true,true,true,true,true,true,true,false);
        
        loadSubMenuDef();
        
        loadRoomReservationFrames();
        loadRestaurantManagementFrames();
        loadEventHandlingFrames();
        loadStockManagementFrames();
        loadEmployeeManagementFrames();
        loadFinanceManagementFrames();
        loadTransportAndTourManagement();
        loadLaundryAndRoomServiceFrames();
        
        loadStatusbar();
        
       
    }
    
    public final void setMenuOperations()
    {
        flagRoomReservation = true;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;
        
    }
    
    public final void loadMenuIconsDef()
    {
        Disk.loadMenuImage(btnRoomReservation, "room_reservation_act");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");
        
        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");
        
        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");
        
    }
    
    public final void loadMenuIconsDef(boolean op1,boolean op2,boolean op3,boolean op4,boolean op5,boolean op6,boolean op7,boolean op8,boolean op9)
    {
        if(op1 ==  true)
        {
            Disk.loadMenuImage(btnRoomReservation, "room_reservation_act");
        }
        else
        {
            btnRoomReservation.setVisible(false);
        }
        
        if(op2 ==  true)
        {
            Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        }
        else
        {
            btnRestaurantManagement.setVisible(false);
        }
        
        if(op3 ==  true)
        {
            Disk.loadMenuImage(btnEventHandling, "event_handling_def");
        }
        else
        {
            btnEventHandling.setVisible(false);
        }
        
         if(op4 ==  true)
        {
            Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        }
        else
        {
            btnStockManagement.setVisible(false);
        }
         
        if(op5 ==  true)
        {
            Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        }
        else
        {
            btnEmployeeManagement.setVisible(false);
        }
        
        if(op6 ==  true)
        {
            Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");
        }
        else
        {
            btnFinanceManagement.setVisible(false);
        }
        
        if(op7 ==  true)
        {
            Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        }
        else
        {
            btnTransportAandTourManagement.setVisible(false);
        }
        
        if(op8 ==  true)
        {
            Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        }
        else
        {
            btnLaundryAndRoomService.setVisible(false);
        }
        
        if(op9 ==  true)
        {
            Disk.loadMenuImage(btnControlPanel, "control_panel_def");
        }
        else
        {
            btnControlPanel.setVisible(false);
        }
    }
    
    private void loadStatusbar()
    {
        loadStatusbar = new Statusbar();
        loadStatusbar.setLocation(0,0);
        loadStatusbar.setSize(appStatusbar.getWidth(), appStatusbar.getHeight());
        appStatusbar.add(loadStatusbar);
        loadStatusbar.setVisible(true);
    }
    
    private void setAppSize()
    {
        // --Setting Screen Full Screen ----------------------------------------
        this.setExtendedState(Main.MAXIMIZED_BOTH | this.getExtendedState());
        // --Getting Screen Sizes ----------------------------------------------
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        
        // --Setting statrusbar panel to current screen size -------------------
        appStatusbar.setSize((int)width, 20);
        app.setSize((int)width-46, (int)height-150);
      
        
        if(width == 1024)
        {
            lblUserName.setVisible(false);
            lblAccountType.setVisible(false);
        }
        else
        {
            lblUserName.setText("User Name  ");
            lblAccountType.setText("Account Type   ");
        }
    }
     
    /* BEGIN --->>>  L O A D   F R A M E S  <<<--- ****************************/
    //**************************************************************************
    private void loadRoomReservationFrames()
    {
    // --Room Reservation ------------------------------------------------------
        loadReservations_Frame = new Reservations_Frame ();
        loadReservations_Frame.setLocation(0,0);
        loadReservations_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadReservations_Frame);        
        loadReservations_Frame.setVisible(true);
        
        loadView_Reservations_Frame = new View_Reservations_Frame  ();
        loadView_Reservations_Frame.setLocation(0,0);
        loadView_Reservations_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadView_Reservations_Frame);        
        loadView_Reservations_Frame.setVisible(false);
        
        loadBill_Generation_Frame = new Bill_Generation_Frame  ();
        loadBill_Generation_Frame.setLocation(0,0);
        loadBill_Generation_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadBill_Generation_Frame);        
        loadBill_Generation_Frame.setVisible(false);
        
        loadGuest_Details_Frame = new Guest_Details_Frame   ();
        loadGuest_Details_Frame.setLocation(0,0);
        loadGuest_Details_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadGuest_Details_Frame);        
        loadGuest_Details_Frame.setVisible(false);
        
        loadRoom_Details_Frame = new Room_Details_Frame   ();
        loadRoom_Details_Frame.setLocation(0,0);
        loadRoom_Details_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadRoom_Details_Frame);        
        loadRoom_Details_Frame.setVisible(false);
        
        loadRoom_Availability_Frame = new Room_Availability_Frame();
        loadRoom_Availability_Frame.setLocation(0,0);
        loadRoom_Availability_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadRoom_Availability_Frame);        
        loadRoom_Availability_Frame.setVisible(false);
        
        loadTransfer_Amount_Frame = new Transfer_Amount_Frame();
        loadTransfer_Amount_Frame.setLocation(0,0);
        loadTransfer_Amount_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadTransfer_Amount_Frame);        
        loadTransfer_Amount_Frame.setVisible(false);
        
        loadRoom_Reservation_Help_Frame = new Room_Reservation_Help_Frame ();
        loadRoom_Reservation_Help_Frame.setLocation(0,0);
        loadRoom_Reservation_Help_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadRoom_Reservation_Help_Frame);        
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void loadRestaurantManagementFrames()
    {
        loadRestaurant_Bill_Frames = new Restaurant_Bill_Frames  ();
        loadRestaurant_Bill_Frames.setLocation(0,0);
        loadRestaurant_Bill_Frames.setSize(app.getWidth(), app.getHeight());
        app.add(loadRestaurant_Bill_Frames);        
        loadRestaurant_Bill_Frames.setVisible(false);
        
        loadDine_In_Bill_Frame = new Dine_In_Bill_Frame  ();
        loadDine_In_Bill_Frame.setLocation(0,0);
        loadDine_In_Bill_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadDine_In_Bill_Frame);        
        loadDine_In_Bill_Frame.setVisible(false);
        
        loadFood_And_Drink_Details_Frame = new Food_And_Drink_Details_Frame   ();
        loadFood_And_Drink_Details_Frame.setLocation(0,0);
        loadFood_And_Drink_Details_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadFood_And_Drink_Details_Frame);        
        loadFood_And_Drink_Details_Frame.setVisible(false);
        
        loadRoom_Guest_Orders_Frames = new Room_Guest_Orders_Frames   ();
        loadRoom_Guest_Orders_Frames.setLocation(0,0);
        loadRoom_Guest_Orders_Frames.setSize(app.getWidth(), app.getHeight());
        app.add(loadRoom_Guest_Orders_Frames);        
        loadRoom_Guest_Orders_Frames.setVisible(false);
       
        loadAll_Bill_Details_Details_Frame = new All_Bill_Details_Details_Frame   ();
        loadAll_Bill_Details_Details_Frame.setLocation(0,0);
        loadAll_Bill_Details_Details_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadAll_Bill_Details_Details_Frame);        
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        
        loadRestaurant_Settings_Frame = new Restaurant_Settings_Frame   ();
        loadRestaurant_Settings_Frame.setLocation(0,0);
        loadRestaurant_Settings_Frame.setSize(app.getWidth(), app.getHeight());
        app.add(loadRestaurant_Settings_Frame);        
        loadRestaurant_Settings_Frame.setVisible(false);
        
        loadRestaurant_Management_Help  = new Restaurant_Management_Help   ();
        loadRestaurant_Management_Help .setLocation(0,0);
        loadRestaurant_Management_Help .setSize(app.getWidth(), app.getHeight());
        app.add(loadRestaurant_Management_Help );        
        loadRestaurant_Management_Help .setVisible(false);
        
    }
    
    private void loadEventHandlingFrames()
    {
        loadVenue_Booking_Frame  = new Venue_Booking_Frame    ();
        loadVenue_Booking_Frame .setLocation(0,0);
        loadVenue_Booking_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadVenue_Booking_Frame );        
        loadVenue_Booking_Frame .setVisible(false);
        
        loadView_Booking_Frame  = new View_Booking_Frame    ();
        loadView_Booking_Frame .setLocation(0,0);
        loadView_Booking_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadView_Booking_Frame );        
        loadView_Booking_Frame .setVisible(false);
        
        loadCustomer_Information_Frame  = new Customer_Information_Frame    ();
        loadCustomer_Information_Frame .setLocation(0,0);
        loadCustomer_Information_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadCustomer_Information_Frame );        
        loadCustomer_Information_Frame .setVisible(false);
        
        loadCutlery_And_Equipment_Frame  = new Cutlery_And_Equipment_Frame    ();
        loadCutlery_And_Equipment_Frame .setLocation(0,0);
        loadCutlery_And_Equipment_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadCutlery_And_Equipment_Frame );        
        loadCutlery_And_Equipment_Frame .setVisible(false);
        
        loadBill_Frame  = new Bill_Frame    ();
        loadBill_Frame .setLocation(0,0);
        loadBill_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadBill_Frame );        
        loadBill_Frame .setVisible(false);
        
        loadCreate_Menu_Package_Frame  = new Create_Menu_Package_Frame    ();
        loadCreate_Menu_Package_Frame .setLocation(0,0);
        loadCreate_Menu_Package_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadCreate_Menu_Package_Frame );        
        loadCreate_Menu_Package_Frame .setVisible(false);
        
        loadTransfer_Income_Frame  = new Transfer_Income_Frame    ();
        loadTransfer_Income_Frame .setLocation(0,0);
        loadTransfer_Income_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadTransfer_Income_Frame );        
            loadTransfer_Income_Frame .setVisible(false);
        
        loadEvent_Handling_Help_Frame  = new Event_Handling_Help_Frame    ();
        loadEvent_Handling_Help_Frame .setLocation(0,0);
        loadEvent_Handling_Help_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadEvent_Handling_Help_Frame );        
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void loadStockManagementFrames()
    {
        loadStock_Frame_Frame  = new Stock_Frame_Frame     ();
        loadStock_Frame_Frame .setLocation(0,0);
        loadStock_Frame_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadStock_Frame_Frame );        
        loadStock_Frame_Frame .setVisible(false);
        
        loadSuppliers_Frame  = new Suppliers_Frame     ();
        loadSuppliers_Frame .setLocation(0,0);
        loadSuppliers_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadSuppliers_Frame );        
        loadSuppliers_Frame .setVisible(false);
        
        loadStock_Details_Frame  = new Stock_Details_Frame     ();
        loadStock_Details_Frame .setLocation(0,0);
        loadStock_Details_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadStock_Details_Frame );        
        loadStock_Details_Frame .setVisible(false);
        
        loadTaking_Stock_Frame  = new Taking_Stock_Frame     ();
        loadTaking_Stock_Frame .setLocation(0,0);
        loadTaking_Stock_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadTaking_Stock_Frame );        
        loadTaking_Stock_Frame .setVisible(false);
        
        loadStock_History_Frame  = new Stock_History_Frame     ();
        loadStock_History_Frame .setLocation(0,0);
        loadStock_History_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadStock_History_Frame );        
        loadStock_History_Frame .setVisible(false);
        
        loadStock_Management_Help_Frame  = new Stock_Management_Help_Frame     ();
        loadStock_Management_Help_Frame .setLocation(0,0);
        loadStock_Management_Help_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadStock_Management_Help_Frame );        
        loadStock_Management_Help_Frame .setVisible(false);
    }
    
    private void loadEmployeeManagementFrames()
    {
        loadEmployee_Details_Frame  = new Employee_Details_Frame      ();
        loadEmployee_Details_Frame .setLocation(0,0);
        loadEmployee_Details_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadEmployee_Details_Frame );        
        loadEmployee_Details_Frame .setVisible(false);
        
        loadManage_Employee_Roles_Frames  = new Manage_Employee_Roles_Frames      ();
        loadManage_Employee_Roles_Frames .setLocation(0,0);
        loadManage_Employee_Roles_Frames .setSize(app.getWidth(), app.getHeight());
        app.add(loadManage_Employee_Roles_Frames );        
        loadManage_Employee_Roles_Frames .setVisible(false);
        
        loadShift_Management_Frame  = new Shift_Management_Frame      ();
        loadShift_Management_Frame .setLocation(0,0);
        loadShift_Management_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadShift_Management_Frame );        
        loadShift_Management_Frame .setVisible(false);
        
        loadAttendance_Frame  = new Attendance_Frame      ();
        loadAttendance_Frame .setLocation(0,0);
        loadAttendance_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadAttendance_Frame );        
        loadAttendance_Frame .setVisible(false);
        
        loadSalary_Calculation_Frame  = new Salary_Calculation_Frame      ();
        loadSalary_Calculation_Frame .setLocation(0,0);
        loadSalary_Calculation_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadSalary_Calculation_Frame );        
        loadSalary_Calculation_Frame .setVisible(false);
        
        loadLeave_Requirements_Frame  = new Leave_Requirements_Frame      ();
        loadLeave_Requirements_Frame .setLocation(0,0);
        loadLeave_Requirements_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadLeave_Requirements_Frame );        
        loadLeave_Requirements_Frame .setVisible(false);
        
        loadSystem_Users_Frame  = new System_Users_Frame      ();
        loadSystem_Users_Frame .setLocation(0,0);
        loadSystem_Users_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadSystem_Users_Frame );        
        loadSystem_Users_Frame .setVisible(false);
        
        loadEmployee_Management_Help_Frame  = new Employee_Management_Help_Frame      ();
        loadEmployee_Management_Help_Frame .setLocation(0,0);
        loadEmployee_Management_Help_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadEmployee_Management_Help_Frame );        
        loadEmployee_Management_Help_Frame .setVisible(false);
        
    }
    
    private void loadFinanceManagementFrames()
    {
        loadIncomes_Management_Frame  = new Incomes_Management_Frame       ();
        loadIncomes_Management_Frame .setLocation(0,0);
        loadIncomes_Management_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadIncomes_Management_Frame );        
        loadIncomes_Management_Frame .setVisible(false);
        
        loadExpenses_Management_Frame  = new Expenses_Management_Frame       ();
        loadExpenses_Management_Frame .setLocation(0,0);
        loadExpenses_Management_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadExpenses_Management_Frame );        
        loadExpenses_Management_Frame .setVisible(false);
        
        loadProfit_And_Loss_Comparison_Frame  = new Profit_And_Loss_Comparison_Frame       ();
        loadProfit_And_Loss_Comparison_Frame .setLocation(0,0);
        loadProfit_And_Loss_Comparison_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadProfit_And_Loss_Comparison_Frame );        
        loadProfit_And_Loss_Comparison_Frame .setVisible(false);
        
        loadDecision_Helper_Frame  = new Decision_Helper_Frame       ();
        loadDecision_Helper_Frame .setLocation(0,0);
        loadDecision_Helper_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadDecision_Helper_Frame );        
        loadDecision_Helper_Frame .setVisible(false);
        
        loadExpenses_Management_Help_Frame  = new Expenses_Management_Help_Frame       ();
        loadExpenses_Management_Help_Frame .setLocation(0,0);
        loadExpenses_Management_Help_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadExpenses_Management_Help_Frame );        
        loadExpenses_Management_Help_Frame .setVisible(false);
    }
    
    private void loadTransportAndTourManagement()
    {
        loadAirport_Pickup_Frame  = new Airport_Pickup_Frame        ();
        loadAirport_Pickup_Frame .setLocation(0,0);
        loadAirport_Pickup_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadAirport_Pickup_Frame );        
        loadAirport_Pickup_Frame .setVisible(false);
        
        loadTour_Packages_Frame  = new Tour_Packages_Frame        ();
        loadTour_Packages_Frame .setLocation(0,0);
        loadTour_Packages_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadTour_Packages_Frame );        
        loadTour_Packages_Frame .setVisible(false);
        
        loadTransport_Details_Frame  = new Transport_Details_Frame        ();
        loadTransport_Details_Frame .setLocation(0,0);
        loadTransport_Details_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadTransport_Details_Frame );        
        loadTransport_Details_Frame .setVisible(false);
        
        loadVehicles_Frames   = new Vehicles_Frames        ();
        loadVehicles_Frames.setLocation(0,0);
        loadVehicles_Frames.setSize(app.getWidth(), app.getHeight());
        app.add(loadVehicles_Frames  );        
        loadVehicles_Frames.setVisible(false);
        
        loadVehicle_Availability_Details_Frame  = new Vehicle_Availability_Details_Frame        ();
        loadVehicle_Availability_Details_Frame .setLocation(0,0);
        loadVehicle_Availability_Details_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadVehicle_Availability_Details_Frame );        
        loadVehicle_Availability_Details_Frame .setVisible(false);
        
        loadRevenue_Report_Frame  = new Revenue_Report_Frame        ();
        loadRevenue_Report_Frame .setLocation(0,0);
        loadRevenue_Report_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadRevenue_Report_Frame );        
        loadRevenue_Report_Frame .setVisible(false);
        
        loadTrasport_And_Tour_Management_Help_Frame  = new Trasport_And_Tour_Management_Help_Frame        ();
        loadTrasport_And_Tour_Management_Help_Frame .setLocation(0,0);
        loadTrasport_And_Tour_Management_Help_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadTrasport_And_Tour_Management_Help_Frame );        
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void loadLaundryAndRoomServiceFrames()
    {
        loadHotel_Orders_Frame  = new Hotel_Orders_Frame         ();
        loadHotel_Orders_Frame .setLocation(0,0);
        loadHotel_Orders_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadHotel_Orders_Frame );        
        loadHotel_Orders_Frame .setVisible(false);
        
        loadGuest_Orders_Frame  = new Guest_Orders_Frame         ();
        loadGuest_Orders_Frame .setLocation(0,0);
        loadGuest_Orders_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadGuest_Orders_Frame );        
        loadGuest_Orders_Frame .setVisible(false);
        
        loadRoom_States__Frame  = new Room_States__Frame         ();
        loadRoom_States__Frame .setLocation(0,0);
        loadRoom_States__Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadRoom_States__Frame );        
        loadRoom_States__Frame .setVisible(false);
        
        loadFinance_Frame  = new Finance_Frame         ();
        loadFinance_Frame .setLocation(0,0);
        loadFinance_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadFinance_Frame );        
        loadFinance_Frame .setVisible(false);
        
        loadLaundry_And_Room_Service_Help_Frame  = new Laundry_And_Room_Service_Help_Frame         ();
        loadLaundry_And_Room_Service_Help_Frame .setLocation(0,0);
        loadLaundry_And_Room_Service_Help_Frame .setSize(app.getWidth(), app.getHeight());
        app.add(loadLaundry_And_Room_Service_Help_Frame );        
        loadLaundry_And_Room_Service_Help_Frame .setVisible(false);
    }
    
    /****  E N D -- LOAD FRAMES ***********************************************/
    //#########################################################################
    
    /*-------------------------------------------------------------------------*/
    
     /* BEGIN --->>>  C L O S E   F R A M E S  <<<--- **....*******************/
    //**************************************************************************
    private void closeRoomReservationFrames()
    {
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void closeResturentManagementFames()
    {
        loadRestaurant_Bill_Frames.setVisible(false);
        loadDine_In_Bill_Frame.setVisible(false);
        loadFood_And_Drink_Details_Frame.setVisible(false);
        loadRoom_Guest_Orders_Frames.setVisible(false);
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        loadRestaurant_Settings_Frame.setVisible(false);
        loadRestaurant_Management_Help .setVisible(false);
    }
    
    private void closeEventHandlingFrames()
    {
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void closeStockManagementFrames()
    {
        loadStock_Frame_Frame .setVisible(false);
        loadSuppliers_Frame .setVisible(false);
        loadStock_Details_Frame .setVisible(false);
        loadTaking_Stock_Frame .setVisible(false);
        loadStock_History_Frame .setVisible(false);
        loadStock_Management_Help_Frame .setVisible(false);    
    }
    
    private void closeEmployeeManagementFrames()
    {
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void closeFinanceHandlingFrames()
    {
        loadIncomes_Management_Frame .setVisible(false);
        loadExpenses_Management_Frame .setVisible(false);
        loadProfit_And_Loss_Comparison_Frame .setVisible(false);
        loadDecision_Helper_Frame .setVisible(false);
        loadExpenses_Management_Help_Frame .setVisible(false);
    }
    
    private void closeTrasportAndTourManagementFrames()
    {
        loadAirport_Pickup_Frame .setVisible(false);
        loadTour_Packages_Frame .setVisible(false);
        loadTransport_Details_Frame .setVisible(false);
        loadVehicles_Frames.setVisible(false);
        loadVehicle_Availability_Details_Frame .setVisible(false);
        loadRevenue_Report_Frame .setVisible(false);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void closeLoundryAndRoomServiceFrames()
    {
        loadHotel_Orders_Frame .setVisible(false);
        loadGuest_Orders_Frame .setVisible(false);
        loadRoom_States__Frame .setVisible(false);
        loadFinance_Frame .setVisible(false);
        loadLaundry_And_Room_Service_Help_Frame .setVisible(false);
    }
    
    private void closeAllFrames()
    {
        closeRoomReservationFrames();
        closeResturentManagementFames();
        closeEventHandlingFrames();
        closeStockManagementFrames();
        closeEmployeeManagementFrames();
        closeFinanceHandlingFrames();
        closeTrasportAndTourManagementFrames();
        closeLoundryAndRoomServiceFrames();
    }
     /****  E N D -- CLOSE FRAMES ***********************************************/
    //#########################################################################
    
    /**************************************************************************/
    
    /* BEGIN --->>>  O P E N N I N G   F R A M E S  <<<--- *********************/
    //**************************************************************************
    // --Room Reservation ------------------------------------------------------
    
    private void open_RS_ReservationsFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : Reservations");
                
        loadReservations_Frame.setVisible(true);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void open_RS_ViewReservationsFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : View Reservations");
        
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(true);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    private void open_RS_Bill_GenerationFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : Bill Generation");
        
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(true);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void open_RS_GuestDetailsFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : Guest Details");
        
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(true);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void open_RS_RoomDetailsFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : Room Details");
        
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(true);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void open_RS_RoomAvailabilityFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : Room Availability");
        
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(true);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void open_RS_TransferAmountFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : Transfer Amount");
        
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(true);
        loadRoom_Reservation_Help_Frame.setVisible(false);
    }
    
    private void open_RS_RoomReservationHelpFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Room Reservation : Help");
        
        loadReservations_Frame.setVisible(false);
        loadView_Reservations_Frame.setVisible(false);
        loadBill_Generation_Frame.setVisible(false);
        loadGuest_Details_Frame.setVisible(false);
        loadRoom_Details_Frame.setVisible(false);
        loadRoom_Availability_Frame.setVisible(false);
        loadTransfer_Amount_Frame.setVisible(false);
        loadRoom_Reservation_Help_Frame.setVisible(true);
    }
    
    //--------------------------------------------------------------------------
    // --Restaurant_Management -------------------------------------------------
    private void open_RM_RestaurantBillFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Restaurant Management : Restaurant Bill");
        
        loadRestaurant_Bill_Frames.setVisible(true);
        loadDine_In_Bill_Frame.setVisible(false);
        loadFood_And_Drink_Details_Frame.setVisible(false);
        loadRoom_Guest_Orders_Frames.setVisible(false);
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        loadRestaurant_Settings_Frame.setVisible(false);
        loadRestaurant_Management_Help .setVisible(false);
        
    }
    
     private void open_RM_Dine_In_Bill_Frame()
     {
        closeAllFrames();
         
        lblTitle.setText("Restaurant Management : Dine in Bills");
        loadRestaurant_Bill_Frames.setVisible(false);
        loadDine_In_Bill_Frame.setVisible(true);
        loadFood_And_Drink_Details_Frame.setVisible(false);
        loadRoom_Guest_Orders_Frames.setVisible(false);
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        loadRestaurant_Settings_Frame.setVisible(false);
        loadRestaurant_Management_Help .setVisible(false);
     }
    
    private void open_RM_FoodAndDrinkFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Restaurant Management : Food And Drink");
        
        loadRestaurant_Bill_Frames.setVisible(false);
        loadDine_In_Bill_Frame.setVisible(false);
        loadFood_And_Drink_Details_Frame.setVisible(true);
        loadRoom_Guest_Orders_Frames.setVisible(false);
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        loadRestaurant_Settings_Frame.setVisible(false);
        loadRestaurant_Management_Help .setVisible(false);
    }
    
    private void open_RM_RoomGuestOrdersFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Restaurant Management : Room Guest Orders");
        
        loadRestaurant_Bill_Frames.setVisible(false);
        loadDine_In_Bill_Frame.setVisible(false);
        loadFood_And_Drink_Details_Frame.setVisible(false);
        loadRoom_Guest_Orders_Frames.setVisible(true);
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        loadRestaurant_Settings_Frame.setVisible(false);
        loadRestaurant_Management_Help .setVisible(false);
    }
    
    private void open_RM_All_Bill_Details_Details_Frame()
    {
        closeAllFrames();
        
        lblTitle.setText("Restaurant Management : All Bill Details");
        
        loadRestaurant_Bill_Frames.setVisible(false);
        loadDine_In_Bill_Frame.setVisible(false);
        loadFood_And_Drink_Details_Frame.setVisible(false);
        loadRoom_Guest_Orders_Frames.setVisible(false);
        loadAll_Bill_Details_Details_Frame.setVisible(true);
        loadRestaurant_Settings_Frame.setVisible(false);
        loadRestaurant_Management_Help .setVisible(false);
    }
    
    private void open_RM_Restaurant_Settings_Frame()
    {
        closeAllFrames();
        
        lblTitle.setText("Restaurant Management : Restaurant Settings");
        
        loadRestaurant_Bill_Frames.setVisible(false);
        loadDine_In_Bill_Frame.setVisible(false);
        loadFood_And_Drink_Details_Frame.setVisible(false);
        loadRoom_Guest_Orders_Frames.setVisible(false);
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        loadRestaurant_Settings_Frame.setVisible(true);
        loadRestaurant_Management_Help .setVisible(false);
    }
    
    private void open_RM_RestaurantManagementHelp()
    {
        closeAllFrames();
        
        lblTitle.setText("Restaurant Management : Reports");
        
        loadRestaurant_Bill_Frames.setVisible(false);
        loadDine_In_Bill_Frame.setVisible(false);
        loadFood_And_Drink_Details_Frame.setVisible(false);
        loadRoom_Guest_Orders_Frames.setVisible(false);
        loadAll_Bill_Details_Details_Frame.setVisible(false);
        loadRestaurant_Settings_Frame.setVisible(false);
        loadRestaurant_Management_Help .setVisible(true);
    }
    //--------------------------------------------------------------------------
    // --Event_Handling --------------------------------------------------------
    private void open_EH_VenueBookingFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : Venue Booking");
        
        loadVenue_Booking_Frame .setVisible(true);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void open_EH_ViewBookingFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : View Booking");
        
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(true);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void open_EH_CustomerInformationFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : Customer Information");
        
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(true);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void open_EH_CutleryAndEquipmentFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : Cutlery And Equipment");
        
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(true);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void open_EH_BillFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : Billing");
        
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(true);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void open_EH_CreateMenuPackage()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : Create Menu Package");
                
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(true);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
    
    private void open_EH_TransferIncomeFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : Transfer Income");
        
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(true);
        loadEvent_Handling_Help_Frame .setVisible(false);
    }
   
    private void open_EH_EventHandlingHelpFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Event Handling : Help");
        
        loadVenue_Booking_Frame .setVisible(false);
        loadView_Booking_Frame .setVisible(false);
        loadCustomer_Information_Frame .setVisible(false);
        loadCutlery_And_Equipment_Frame .setVisible(false);
        loadBill_Frame .setVisible(false);
        loadCreate_Menu_Package_Frame .setVisible(false);
        loadTransfer_Income_Frame .setVisible(false);
        loadEvent_Handling_Help_Frame .setVisible(true);
    }
    //--------------------------------------------------------------------------
    // --Stock Management-------------------------------------------------------
    private void open_STM_StockFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Stock Management : Stock");
        
        loadStock_Frame_Frame .setVisible(true);
        loadSuppliers_Frame .setVisible(false);
        loadStock_Details_Frame .setVisible(false);
        loadTaking_Stock_Frame .setVisible(false);
        loadStock_History_Frame .setVisible(false);
        loadStock_Management_Help_Frame .setVisible(false);    
    }
    
    private void open_STM_SuppliersFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Stock Management : Suppliers");
        
        loadStock_Frame_Frame .setVisible(false);
        loadSuppliers_Frame .setVisible(true);
        loadStock_Details_Frame .setVisible(false);
        loadTaking_Stock_Frame .setVisible(false);
        loadStock_History_Frame .setVisible(false);
        loadStock_Management_Help_Frame .setVisible(false);    
    }
    
    private void open_STM_StockDetails()
    {
        closeAllFrames();
        
        lblTitle.setText("Stock Management : Stock Details");
        
        loadStock_Frame_Frame .setVisible(false);
        loadSuppliers_Frame .setVisible(false);
        loadStock_Details_Frame .setVisible(true);
        loadTaking_Stock_Frame .setVisible(false);
        loadStock_History_Frame .setVisible(false);
        loadStock_Management_Help_Frame .setVisible(false);   
    }
    
    private void open_STM_TakingStockFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Stock Management : Retrieving Stock");
        
        loadStock_Frame_Frame .setVisible(false);
        loadSuppliers_Frame .setVisible(false);
        loadStock_Details_Frame .setVisible(false);
        loadTaking_Stock_Frame .setVisible(true);
        loadStock_History_Frame .setVisible(false);
        loadStock_Management_Help_Frame .setVisible(false);   
    }
    
    private void open_STM_StockHistoryFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Stock Management : Stock History");
        
        loadStock_Frame_Frame .setVisible(false);
        loadSuppliers_Frame .setVisible(false);
        loadStock_Details_Frame .setVisible(false);
        loadTaking_Stock_Frame .setVisible(false);
        loadStock_History_Frame .setVisible(true);
        loadStock_Management_Help_Frame .setVisible(false);   
    }
    
    private void open_STM_StockManagementHelp()
    {
        closeAllFrames();
        
        lblTitle.setText("Stock Management : Help");
        
        loadStock_Frame_Frame .setVisible(false);
        loadSuppliers_Frame .setVisible(false);
        loadStock_Details_Frame .setVisible(false);
        loadTaking_Stock_Frame .setVisible(false);
        loadStock_History_Frame .setVisible(false);
        loadStock_Management_Help_Frame .setVisible(true);   
    }
    // -------------------------------------------------------------------------
    // --Employee_Management ---------------------------------------------------
    private void open_EM_EmployeeDetailsFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Employee Management : Employee Details");
         
        loadEmployee_Details_Frame .setVisible(true);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void open_EM_ManageEmployeeRoles()
    {
        closeAllFrames();
         
        lblTitle.setText("Employee Management : Manage Employee Roles");
        
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(true);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void open_EM_ShiftManagementFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Employee Management : Shift Management");
        
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(true);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void open_EM_AttendanceFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Employee Management : Attendance");
        
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(true);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void open_EM_SalaryCalculationFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Employee Management : Salary Calculation");
        
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(true);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void open_EM_LeaveRequirementsFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Employee Management : Leave Requirements");
         
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(true);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void open_EM_SystemUsersFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Employee Management : System Users");
        
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(true);
        loadEmployee_Management_Help_Frame .setVisible(false);
    }
    
    private void open_EM_EmployeeManagementHelpFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Employee Management : Help");
         
        loadEmployee_Details_Frame .setVisible(false);
        loadManage_Employee_Roles_Frames .setVisible(false);
        loadShift_Management_Frame .setVisible(false);
        loadAttendance_Frame .setVisible(false);
        loadSalary_Calculation_Frame .setVisible(false);
        loadLeave_Requirements_Frame .setVisible(false);
        loadSystem_Users_Frame .setVisible(false);
        loadEmployee_Management_Help_Frame .setVisible(true);
    }
    //--------------------------------------------------------------------------
    // --Finance_Management ----------------------------------------------------
    private void open_FM_IncomesManagementFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Finance Management : Incomes Management");
        
        loadIncomes_Management_Frame .setVisible(true);
        loadExpenses_Management_Frame .setVisible(false);
        loadProfit_And_Loss_Comparison_Frame .setVisible(false);
        loadDecision_Helper_Frame .setVisible(false);
        loadExpenses_Management_Help_Frame .setVisible(false);
    }
    
    private void open_FM_ExpensesManagementFrame ()
    {
        closeAllFrames();
        
        lblTitle.setText("Finance Management : Expenses Management");
         
        loadIncomes_Management_Frame .setVisible(false);
        loadExpenses_Management_Frame .setVisible(true);
        loadProfit_And_Loss_Comparison_Frame .setVisible(false);
        loadDecision_Helper_Frame .setVisible(false);
        loadExpenses_Management_Help_Frame .setVisible(false);
    }
    
    private void open_FM_ProfitAndLossComparisonFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Finance Management : Profit And Loss Comparison");
        
        loadIncomes_Management_Frame .setVisible(false);
        loadExpenses_Management_Frame .setVisible(false);
        loadProfit_And_Loss_Comparison_Frame .setVisible(true);
        loadDecision_Helper_Frame .setVisible(false);
        loadExpenses_Management_Help_Frame .setVisible(false);
    }
    
    private void open_FM_DecisionHelperFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Finance Management : Decision Helper");
        
        loadIncomes_Management_Frame .setVisible(false);
        loadExpenses_Management_Frame .setVisible(false);
        loadProfit_And_Loss_Comparison_Frame .setVisible(false);
        loadDecision_Helper_Frame .setVisible(true);
        loadExpenses_Management_Help_Frame .setVisible(false);
    }
    
    private void open_FM_ExpensesManagementHelp()
    {
        closeAllFrames();
        
        lblTitle.setText("Finance Management : Help");
        
        loadIncomes_Management_Frame .setVisible(false);
        loadExpenses_Management_Frame .setVisible(false);
        loadProfit_And_Loss_Comparison_Frame .setVisible(false);
        loadDecision_Helper_Frame .setVisible(false);
        loadExpenses_Management_Help_Frame .setVisible(true);
    }
    //--------------------------------------------------------------------------
    // -- Transport_And_Tour_Management ----------------------------------------
    private void open_TATM_AirportPickupFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Transport and Tour Management : Airport Pickups");
        
        loadAirport_Pickup_Frame .setVisible(true);
        loadTour_Packages_Frame .setVisible(false);
        loadTransport_Details_Frame .setVisible(false);
        loadVehicles_Frames.setVisible(false);
        loadVehicle_Availability_Details_Frame .setVisible(false);
        loadRevenue_Report_Frame .setVisible(false);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void open_TATM_TourPackagesFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Transport and Tour Management : Tour Packages");
        
        loadAirport_Pickup_Frame .setVisible(false);
        loadTour_Packages_Frame .setVisible(true);
        loadTransport_Details_Frame .setVisible(false);
        loadVehicles_Frames.setVisible(false);
        loadVehicle_Availability_Details_Frame .setVisible(false);
        loadRevenue_Report_Frame .setVisible(false);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void open_TATM_TransportDetailsFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Transport and Tour Management : Transport Details");
         
        loadAirport_Pickup_Frame .setVisible(false);
        loadTour_Packages_Frame .setVisible(false);
        loadTransport_Details_Frame .setVisible(true);
        loadVehicles_Frames.setVisible(false);
        loadVehicle_Availability_Details_Frame .setVisible(false);
        loadRevenue_Report_Frame .setVisible(false);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void open_TATM_Vehicles_Frame()
    {
        closeAllFrames();
        
        lblTitle.setText("Transport and Tour Management : Vehicles");
        
        loadAirport_Pickup_Frame .setVisible(false);
        loadTour_Packages_Frame .setVisible(false);
        loadTransport_Details_Frame .setVisible(false);
        loadVehicles_Frames.setVisible(true);
        loadVehicle_Availability_Details_Frame .setVisible(false);
        loadRevenue_Report_Frame .setVisible(false);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void open_TATM_VehicleAvailabilityDetail()
    {
        closeAllFrames();
        
        lblTitle.setText("Transport and Tour Management : Vehicle Availability");
         
        loadAirport_Pickup_Frame .setVisible(false);
        loadTour_Packages_Frame .setVisible(false);
        loadTransport_Details_Frame .setVisible(false);
        loadVehicles_Frames.setVisible(false);
        loadVehicle_Availability_Details_Frame .setVisible(true);
        loadRevenue_Report_Frame .setVisible(false);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void open_TATM_RevenueReportFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Transport and Tour Management : Revenue Reports");
        
        loadAirport_Pickup_Frame .setVisible(false);
        loadTour_Packages_Frame .setVisible(false);
        loadTransport_Details_Frame .setVisible(false);
        loadVehicles_Frames.setVisible(false);
        loadVehicle_Availability_Details_Frame .setVisible(false);
        loadRevenue_Report_Frame .setVisible(true);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(false);
    }
    
    private void open_TATM_TrasportAndTourManagementHelpFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Transport and Tour Management : Help");
        
        loadAirport_Pickup_Frame .setVisible(false);
        loadTour_Packages_Frame .setVisible(false);
        loadTransport_Details_Frame .setVisible(false);
        loadVehicles_Frames.setVisible(false);
        loadVehicle_Availability_Details_Frame .setVisible(false);
        loadRevenue_Report_Frame .setVisible(false);
        loadTrasport_And_Tour_Management_Help_Frame .setVisible(true);
    }
    // -------------------------------------------------------------------------
    // -- Laundry_And_Room_Service ---------------------------------------------
    private void open_LARM_HotelOrdersFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Laundry and Room Service : Hotel Orders");
        
        loadHotel_Orders_Frame .setVisible(true);
        loadGuest_Orders_Frame .setVisible(false);
        loadRoom_States__Frame .setVisible(false);
        loadFinance_Frame .setVisible(false);
        loadLaundry_And_Room_Service_Help_Frame .setVisible(false);
    }
    
    private void open_LARM_GuestOrdersFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Laundry and Room Service : Guest Orders");
        
        loadHotel_Orders_Frame .setVisible(false);
        loadGuest_Orders_Frame .setVisible(true);
        loadRoom_States__Frame .setVisible(false);
        loadFinance_Frame .setVisible(false);
        loadLaundry_And_Room_Service_Help_Frame .setVisible(false);
    }
    
    private void open_LARM_RoomStatesFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Laundry and Room Service : Room States");
        
        loadHotel_Orders_Frame .setVisible(false);
        loadGuest_Orders_Frame .setVisible(false);
        loadRoom_States__Frame .setVisible(true);
        loadFinance_Frame .setVisible(false);
        loadLaundry_And_Room_Service_Help_Frame .setVisible(false);
    }
    
    private void open_LARM_FinanceFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Laundry and Room Service : Finance");
        
        loadHotel_Orders_Frame .setVisible(false);
        loadGuest_Orders_Frame .setVisible(false);
        loadRoom_States__Frame .setVisible(false);
        loadFinance_Frame .setVisible(true);
        loadLaundry_And_Room_Service_Help_Frame .setVisible(false);
    }
    
    private void open_LARM_LaundryAndRoomServiceHelpFrame()
    {
        closeAllFrames();
        
        lblTitle.setText("Laundry and Room Service : Help");
        
        loadHotel_Orders_Frame .setVisible(false);
        loadGuest_Orders_Frame .setVisible(false);
        loadRoom_States__Frame .setVisible(false);
        loadFinance_Frame .setVisible(false);
        loadLaundry_And_Room_Service_Help_Frame .setVisible(true);
    }
    //--------------------------------------------------------------------------
   
    /****  E N D -- OPEN FRAMES ***********************************************/
    //#########################################################################
   private void setMainTitles()
   {
       if(flagRoomReservation == true)
        {
           lblTitle.setText("Room Reservation : Reservations");
        }
        else if(flagRestaurantManagement == true)
        {
           lblTitle.setText("Restaurant Management : Restaurant Bill");
        }
        else if(flagEventHandling == true)
        {
           lblTitle.setText("Event Handling : Venue Booking");
        }
        else if(flagStockManagement == true)
        {
           lblTitle.setText("Stock Management : Stock");
        }
        else if(flagEmployeeManagement == true)
        {
           lblTitle.setText("Employee Management : Employee Details");
        }
        else if(flagFinanceManagement == true)
        {
           lblTitle.setText("Finance Management : Incomes Management");
        }
        else if(flagTransportAndTourManagement == true)
        {
          lblTitle.setText("Transport and Tour Management : Airport Pickups");
        }
        else if(flagLaundryAndRoomService == true)
        {
          lblTitle.setText("Laundry and Room Service : Hotel Orders");
        }
        else if (flagControlPanel ==  true)
        {
           lblTitle.setText("Control Panel");
        }
   }
    
    private void setSockets()
    {
        if(flagRoomReservation == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(true);
           btnSocket07.setVisible(true);
           btnSocket08.setVisible(true);
           
        }
        else if(flagRestaurantManagement == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(true);
           btnSocket07.setVisible(true);
           btnSocket08.setVisible(false);
           
        }
        else if(flagEventHandling == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(true);
           btnSocket07.setVisible(true);
           btnSocket08.setVisible(true);
        }
        else if(flagStockManagement == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(true);
           btnSocket07.setVisible(false);
           btnSocket08.setVisible(false);
        }
        else if(flagEmployeeManagement == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(true);
           btnSocket07.setVisible(true);
           btnSocket08.setVisible(true);
        }
        else if(flagFinanceManagement == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(false);
           btnSocket07.setVisible(false);
           btnSocket08.setVisible(false);
        }
        else if(flagTransportAndTourManagement == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(true);
           btnSocket07.setVisible(true);
           btnSocket08.setVisible(false);
        }
        else if(flagLaundryAndRoomService == true)
        {
           btnSocket01.setVisible(true);
           btnSocket02.setVisible(true);
           btnSocket03.setVisible(true);
           btnSocket04.setVisible(true);
           
           btnSocket05.setVisible(true);
           btnSocket06.setVisible(false);
           btnSocket07.setVisible(false);
           btnSocket08.setVisible(false);
        }
        else if (flagControlPanel ==  true)
        {
           
        }
    }
    
    private void loadSubMenuDef()
    {
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_act");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           setSockets();
        }
        else if(flagRestaurantManagement == true)
        {
           Socket.loadImage(btnSocket01, "bill_genaration_act");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           setSockets();
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_act");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           setSockets();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_act");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_def");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           setSockets();
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_act");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           setSockets();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_act");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           setSockets();
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_act");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
           Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
           Socket.loadImage(btnSocket06, "revenue_report_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           setSockets();
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_act");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           setSockets();
        }
        else if (flagControlPanel ==  true)
        {
           Socket.loadImage(btnSocket01, "_blank_socket");
           Socket.loadImage(btnSocket02, "_blank_socket");
           Socket.loadImage(btnSocket03, "_blank_socket");
           Socket.loadImage(btnSocket04, "_blank_socket");
           
           Socket.loadImage(btnSocket05, "_blank_socket");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           setSockets();
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

        pnlMainMenu = new javax.swing.JPanel();
        btnRoomReservation = new javax.swing.JLabel();
        btnRestaurantManagement = new javax.swing.JLabel();
        btnEventHandling = new javax.swing.JLabel();
        btnStockManagement = new javax.swing.JLabel();
        btnEmployeeManagement = new javax.swing.JLabel();
        btnFinanceManagement = new javax.swing.JLabel();
        btnTransportAandTourManagement = new javax.swing.JLabel();
        btnLaundryAndRoomService = new javax.swing.JLabel();
        btnControlPanel = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnMinmize = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblAccountType = new javax.swing.JLabel();
        pnlSideMenu = new javax.swing.JPanel();
        lblSideMenuTop = new javax.swing.JLabel();
        btnSocket01 = new javax.swing.JLabel();
        btnSocket03 = new javax.swing.JLabel();
        btnSocket02 = new javax.swing.JLabel();
        btnSocket07 = new javax.swing.JLabel();
        btnSocket06 = new javax.swing.JLabel();
        btnSocket05 = new javax.swing.JLabel();
        btnSocket04 = new javax.swing.JLabel();
        btnSocket08 = new javax.swing.JLabel();
        appStatusbar = new javax.swing.JPanel();
        app = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlMainMenu.setBackground(new java.awt.Color(32, 32, 47));

        btnRoomReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/room_reservation_def.png"))); // NOI18N
        btnRoomReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRoomReservationMouseClicked(evt);
            }
        });

        btnRestaurantManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/restaurant_management_def.png"))); // NOI18N
        btnRestaurantManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestaurantManagementMouseClicked(evt);
            }
        });

        btnEventHandling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/event_handling_def.png"))); // NOI18N
        btnEventHandling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEventHandlingMouseClicked(evt);
            }
        });

        btnStockManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/stock_management_def.png"))); // NOI18N
        btnStockManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStockManagementMouseClicked(evt);
            }
        });

        btnEmployeeManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/employee_management_def.png"))); // NOI18N
        btnEmployeeManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeManagementMouseClicked(evt);
            }
        });

        btnFinanceManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/finance_management_def.png"))); // NOI18N
        btnFinanceManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinanceManagementMouseClicked(evt);
            }
        });

        btnTransportAandTourManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/transport_and_tour_management_def.png"))); // NOI18N
        btnTransportAandTourManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransportAandTourManagementMouseClicked(evt);
            }
        });

        btnLaundryAndRoomService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/laundry_and_room_service_def.png"))); // NOI18N
        btnLaundryAndRoomService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaundryAndRoomServiceMouseClicked(evt);
            }
        });

        btnControlPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainmenu/control_panel_def.png"))); // NOI18N
        btnControlPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnControlPanelMouseClicked(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/close_def.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        btnMinmize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/minimize_def.png"))); // NOI18N
        btnMinmize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinmizeMouseClicked(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Myriad Web Pro", 0, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/logout_def.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Title");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/pavana_logo.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/other/user_male.png"))); // NOI18N

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setText("U");

        lblAccountType.setForeground(new java.awt.Color(255, 255, 255));
        lblAccountType.setText("Ac Type");

        javax.swing.GroupLayout pnlMainMenuLayout = new javax.swing.GroupLayout(pnlMainMenu);
        pnlMainMenu.setLayout(pnlMainMenuLayout);
        pnlMainMenuLayout.setHorizontalGroup(
            pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainMenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainMenuLayout.createSequentialGroup()
                        .addComponent(btnRoomReservation)
                        .addGap(0, 0, 0)
                        .addComponent(btnRestaurantManagement))
                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblLogo)
                        .addGap(98, 98, 98)))
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                        .addComponent(btnEventHandling)
                        .addGap(0, 0, 0)
                        .addComponent(btnStockManagement)
                        .addGap(0, 0, 0)
                        .addComponent(btnEmployeeManagement)
                        .addGap(0, 0, 0)
                        .addComponent(btnFinanceManagement)
                        .addGap(0, 0, 0)
                        .addComponent(btnTransportAandTourManagement)
                        .addGap(0, 0, 0)
                        .addComponent(btnLaundryAndRoomService)
                        .addGap(0, 0, 0)
                        .addComponent(btnControlPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUserName)
                            .addComponent(lblAccountType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMinmize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        pnlMainMenuLayout.setVerticalGroup(
            pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainMenuLayout.createSequentialGroup()
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                        .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLogout)
                                    .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnClose)
                                        .addComponent(btnMinmize))))
                            .addGroup(pnlMainMenuLayout.createSequentialGroup()
                                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblLogo))
                                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)))
                        .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainMenuLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(pnlMainMenuLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblUserName)
                                .addGap(2, 2, 2)
                                .addComponent(lblAccountType))))
                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRestaurantManagement)
                            .addComponent(btnRoomReservation)
                            .addComponent(btnEventHandling)
                            .addComponent(btnStockManagement)
                            .addComponent(btnEmployeeManagement)
                            .addComponent(btnFinanceManagement)
                            .addComponent(btnTransportAandTourManagement)
                            .addComponent(btnLaundryAndRoomService)
                            .addComponent(btnControlPanel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSideMenu.setBackground(new java.awt.Color(51, 51, 51));

        lblSideMenuTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_topBlack.png"))); // NOI18N

        btnSocket01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket01MouseClicked(evt);
            }
        });

        btnSocket03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket03MouseClicked(evt);
            }
        });

        btnSocket02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket02MouseClicked(evt);
            }
        });

        btnSocket07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket07MouseClicked(evt);
            }
        });

        btnSocket06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket06MouseClicked(evt);
            }
        });

        btnSocket05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket05MouseClicked(evt);
            }
        });

        btnSocket04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket04MouseClicked(evt);
            }
        });

        btnSocket08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submenu/_blank_socket.png"))); // NOI18N
        btnSocket08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSocket08MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSideMenuLayout = new javax.swing.GroupLayout(pnlSideMenu);
        pnlSideMenu.setLayout(pnlSideMenuLayout);
        pnlSideMenuLayout.setHorizontalGroup(
            pnlSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSideMenuTop)
            .addComponent(btnSocket01)
            .addComponent(btnSocket02)
            .addComponent(btnSocket03)
            .addComponent(btnSocket04)
            .addComponent(btnSocket05)
            .addComponent(btnSocket06)
            .addComponent(btnSocket07)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSideMenuLayout.createSequentialGroup()
                .addComponent(btnSocket08)
                .addContainerGap())
        );
        pnlSideMenuLayout.setVerticalGroup(
            pnlSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSideMenuLayout.createSequentialGroup()
                .addComponent(lblSideMenuTop)
                .addGap(0, 0, 0)
                .addComponent(btnSocket01)
                .addGap(0, 0, 0)
                .addComponent(btnSocket02)
                .addGap(0, 0, 0)
                .addComponent(btnSocket03)
                .addGap(0, 0, 0)
                .addComponent(btnSocket04)
                .addGap(0, 0, 0)
                .addComponent(btnSocket05)
                .addGap(0, 0, 0)
                .addComponent(btnSocket06)
                .addGap(0, 0, 0)
                .addComponent(btnSocket07)
                .addGap(0, 0, 0)
                .addComponent(btnSocket08)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        appStatusbar.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout appStatusbarLayout = new javax.swing.GroupLayout(appStatusbar);
        appStatusbar.setLayout(appStatusbarLayout);
        appStatusbarLayout.setHorizontalGroup(
            appStatusbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        appStatusbarLayout.setVerticalGroup(
            appStatusbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        app.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout appLayout = new javax.swing.GroupLayout(app);
        app.setLayout(appLayout);
        appLayout.setHorizontalGroup(
            appLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        appLayout.setVerticalGroup(
            appLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appStatusbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(app, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(app, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(appStatusbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSocket01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket01MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_act");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_RS_ReservationsFrame();
           
            Reservations_Model obj = new Reservations_Model();
            obj.SetRoomTiiles();
        obj.defaultCountry();
        obj.setCurrentDate();
        obj.loadListFromDB("Room Type", "room_types", cmbRoomTypes);
        cmbRoomTypes.addItem("All");
        
        obj.hidePnlRoomTypes();
           
        }
        else if(flagRestaurantManagement == true)
        {
           Socket.loadImage(btnSocket01, "bill_genaration_act");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_RM_RestaurantBillFrame();
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_act");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_EH_VenueBookingFrame();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_act");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_def");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_STM_StockFrame();
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_act");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           open_EM_EmployeeDetailsFrame();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_act");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
           
           open_FM_IncomesManagementFrame();
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_act");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
           Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
           Socket.loadImage(btnSocket06, "revenue_report_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_TATM_AirportPickupFrame();
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_act");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_LARM_HotelOrdersFrame();
        }
    }//GEN-LAST:event_btnSocket01MouseClicked

    private void btnSocket02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket02MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_def");
           Socket.loadImage(btnSocket02, "view_reservations_act");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_RS_ViewReservationsFrame();
           
            View_Reservations_Model  obj = new View_Reservations_Model ();
            // obj.tableLoad(tblReservationDeatils, "room_reservations", ColList, lblLastUpdate, lblNumOfRecords, cmbSearchBy);
           
        }
        else if(flagRestaurantManagement == true)
        {
            Socket.loadImage(btnSocket01, "bill_genaration_def");
           Socket.loadImage(btnSocket02, "dine_in_bills_act");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_RM_Dine_In_Bill_Frame();
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_def");
           Socket.loadImage(btnSocket02, "view_bookings_act");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_EH_ViewBookingFrame();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_def");
           Socket.loadImage(btnSocket02, "suppliers_act");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_def");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_STM_SuppliersFrame();
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_def");
           Socket.loadImage(btnSocket02, "manage_roles_act");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           open_EM_ManageEmployeeRoles();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_def");
           Socket.loadImage(btnSocket02, "expences_act");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
           
           open_FM_ExpensesManagementFrame();
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_def");
           Socket.loadImage(btnSocket02, "tour_packages_act");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
          Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
          Socket.loadImage(btnSocket06, "revenue_report_def");
          Socket.loadImage(btnSocket07, "help_def");
          Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_TATM_TourPackagesFrame();
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_def");
           Socket.loadImage(btnSocket02, "guest_orders_act");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_LARM_GuestOrdersFrame();
        }
    }//GEN-LAST:event_btnSocket02MouseClicked

    private void btnSocket03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket03MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_def");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_act");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_RS_GuestDetailsFrame();
        }
        else if(flagRestaurantManagement == true)
        {
           Socket.loadImage(btnSocket01, "bill_genaration_def");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_act");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_RM_FoodAndDrinkFrame();
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_def");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_act");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_EH_CustomerInformationFrame();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_def");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_act");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_def");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_STM_StockDetails();
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_def");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_act");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           open_EM_ShiftManagementFrame();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_def");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_act");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
           
           open_FM_ProfitAndLossComparisonFrame();
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_def");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_act");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
           Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
           Socket.loadImage(btnSocket06, "revenue_report_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_TATM_TransportDetailsFrame();
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_def");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_act");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_LARM_RoomStatesFrame();
        }
    }//GEN-LAST:event_btnSocket03MouseClicked

    private void btnSocket04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket04MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_def");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_act");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_RS_Bill_GenerationFrame();
        }
        else if(flagRestaurantManagement == true)
        {
           Socket.loadImage(btnSocket01, "bill_genaration_def");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_act");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_RM_RoomGuestOrdersFrame();
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_def");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_act");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_EH_CutleryAndEquipmentFrame();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_def");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_act");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_def");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_STM_TakingStockFrame();
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_def");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_act");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           open_EM_AttendanceFrame();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_def");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_act");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
           
           open_FM_DecisionHelperFrame();
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_def");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_act");
           
           Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
           Socket.loadImage(btnSocket06, "revenue_report_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_TATM_Vehicles_Frame();
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_def");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_act");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_LARM_FinanceFrame();
        }
    }//GEN-LAST:event_btnSocket04MouseClicked

    private void btnSocket05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket05MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_def");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_act");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_RS_RoomDetailsFrame();
        }
        else if(flagRestaurantManagement == true)
        {
           Socket.loadImage(btnSocket01, "bill_genaration_def");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_act");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_RM_All_Bill_Details_Details_Frame();
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_def");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_act");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_EH_BillFrame();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_def");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_act");
           Socket.loadImage(btnSocket06, "help_def");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_STM_StockHistoryFrame();
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_def");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_act");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           open_EM_SalaryCalculationFrame();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_def");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_act");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
           
           open_FM_ExpensesManagementHelp();
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_def");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
          Socket.loadImage(btnSocket05, "vehicle_availability_check_act");
          Socket.loadImage(btnSocket06, "revenue_report_def");
          Socket.loadImage(btnSocket07, "help_def");
          Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_TATM_VehicleAvailabilityDetail();
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_def");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_act");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_LARM_LaundryAndRoomServiceHelpFrame();
        }
    }//GEN-LAST:event_btnSocket05MouseClicked

    private void btnSocket06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket06MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_def");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_act");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_RS_RoomAvailabilityFrame();
           
           //Room_Availability_Frame n = new Room_Availability_Frame();
           //Rooma = new Room_Availability_Model(); 
           Room_Availability_Model a = new Room_Availability_Model(); 
           
            a.restColors();
            a.colorCheckedIn();
            a.loadPendingRooms();
            a.clearlbls();
           
           
        }
        else if(flagRestaurantManagement == true)
        {
            Socket.loadImage(btnSocket01, "bill_genaration_def");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_act");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_RM_Restaurant_Settings_Frame();
          
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_def");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_act");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_EH_CreateMenuPackage();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_def");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_act");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_STM_StockManagementHelp();
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_def");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_act");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           open_EM_LeaveRequirementsFrame();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_def");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_act");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
           
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_def");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
           Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
           Socket.loadImage(btnSocket06, "revenue_report_act");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
            open_TATM_RevenueReportFrame();
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_def");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
        }
    }//GEN-LAST:event_btnSocket06MouseClicked

    private void btnSocket07MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket07MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_def");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_act");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_RS_TransferAmountFrame();
        }
        else if(flagRestaurantManagement == true)
        {
           Socket.loadImage(btnSocket01, "bill_genaration_def");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_act");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
           open_RM_RestaurantManagementHelp();
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_def");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_act");
           Socket.loadImage(btnSocket08, "help_def");
           
           open_EH_TransferIncomeFrame();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_def");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_act");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_def");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_act");
           Socket.loadImage(btnSocket08, "help_def"); 
           
           open_EM_SystemUsersFrame();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_def");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_act");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
       
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_def");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
          Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
          Socket.loadImage(btnSocket06, "revenue_report_def");
          Socket.loadImage(btnSocket07, "help_act");
          Socket.loadImage(btnSocket08, "_blank_socket");
          
          open_TATM_TrasportAndTourManagementHelpFrame();
          
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_def");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
          
        }
    }//GEN-LAST:event_btnSocket07MouseClicked

    private void btnSocket08MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSocket08MouseClicked
        if(flagRoomReservation == true)
        {
           Socket.loadImage(btnSocket01, "reservations_def");
           Socket.loadImage(btnSocket02, "view_reservations_def");
           Socket.loadImage(btnSocket03, "guest_deatils_def");
           Socket.loadImage(btnSocket04, "bill_genaration_def");
           
           Socket.loadImage(btnSocket05, "roomt_deatils_def");
           Socket.loadImage(btnSocket06, "room_availability_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_act");
           
           open_RS_RoomReservationHelpFrame();
        }
        else if(flagRestaurantManagement == true)
        {
           Socket.loadImage(btnSocket01, "bill_genaration_def");
           Socket.loadImage(btnSocket02, "dine_in_bills_def");
           Socket.loadImage(btnSocket03, "food_and_drink_deatils_def");
           Socket.loadImage(btnSocket04, "Room_guset_orders_def");
           
           Socket.loadImage(btnSocket05, "trasfer_incomes_def");
           Socket.loadImage(btnSocket06, "resturent_setting_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
        }
        else if(flagEventHandling == true)
        {
           Socket.loadImage(btnSocket01, "venue_booking_def");
           Socket.loadImage(btnSocket02, "view_bookings_def");
           Socket.loadImage(btnSocket03, "coustomer_deatils_def");
           Socket.loadImage(btnSocket04, "cutlery_def");
           
           Socket.loadImage(btnSocket05, "bill_genaration_def");
           Socket.loadImage(btnSocket06, "create_menu_packages_def");
           Socket.loadImage(btnSocket07, "trasfer_incomes_def");
           Socket.loadImage(btnSocket08, "help_act");
           
           open_EH_EventHandlingHelpFrame();
        }
        else if(flagStockManagement == true)
        {
           Socket.loadImage(btnSocket01, "stock_def");
           Socket.loadImage(btnSocket02, "suppliers_def");
           Socket.loadImage(btnSocket03, "stock_details_def");
           Socket.loadImage(btnSocket04, "taking_stock_def");
           
           Socket.loadImage(btnSocket05, "stock_history_def");
           Socket.loadImage(btnSocket06, "help_act");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
        }
        else if(flagEmployeeManagement == true)
        {
           Socket.loadImage(btnSocket01, "employee_deatils_def");
           Socket.loadImage(btnSocket02, "manage_roles_def");
           Socket.loadImage(btnSocket03, "shift_management_def");
           Socket.loadImage(btnSocket04, "attendence_def");
           
           Socket.loadImage(btnSocket05, "salary_calculation_def");
           Socket.loadImage(btnSocket06, "leave_management_def");
           Socket.loadImage(btnSocket07, "system_users_def");
           Socket.loadImage(btnSocket08, "help_act"); 
           
           open_EM_EmployeeManagementHelpFrame();
        }
        else if(flagFinanceManagement == true)
        {
           Socket.loadImage(btnSocket01, "incomes_def");
           Socket.loadImage(btnSocket02, "expences_def");
           Socket.loadImage(btnSocket03, "profit_and_loss_comparison_def");
           Socket.loadImage(btnSocket04, "desition_helper_def");
           
           Socket.loadImage(btnSocket05, "help_act");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket"); 
           
        }
        else if(flagTransportAndTourManagement == true)
        {
           Socket.loadImage(btnSocket01, "airport_pickups_def");
           Socket.loadImage(btnSocket02, "tour_packages_def");
           Socket.loadImage(btnSocket03, "transport_details_def");
           Socket.loadImage(btnSocket04, "vechicals_def");
           
           Socket.loadImage(btnSocket05, "vehicle_availability_check_def");
           Socket.loadImage(btnSocket06, "revenue_report_def");
           Socket.loadImage(btnSocket07, "help_def");
           Socket.loadImage(btnSocket08, "_blank_socket");
           
        }
        else if(flagLaundryAndRoomService == true)
        {
           Socket.loadImage(btnSocket01, "hotel_orders_def");
           Socket.loadImage(btnSocket02, "guest_orders_def");
           Socket.loadImage(btnSocket03, "room_states_def");
           Socket.loadImage(btnSocket04, "finance_def");
           
           Socket.loadImage(btnSocket05, "help_def");
           Socket.loadImage(btnSocket06, "_blank_socket");
           Socket.loadImage(btnSocket07, "_blank_socket");
           Socket.loadImage(btnSocket08, "_blank_socket");
        }
    }//GEN-LAST:event_btnSocket08MouseClicked

    private void btnMinmizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinmizeMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnMinmizeMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnControlPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnControlPanelMouseClicked
        flagRoomReservation = false;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = true;

        setMainTitles();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_act");

        loadSubMenuDef();

        closeAllFrames();
    }//GEN-LAST:event_btnControlPanelMouseClicked

    private void btnLaundryAndRoomServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaundryAndRoomServiceMouseClicked
        flagRoomReservation =  false;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = true;
        flagControlPanel = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_act");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_LARM_HotelOrdersFrame();
    }//GEN-LAST:event_btnLaundryAndRoomServiceMouseClicked

    private void btnTransportAandTourManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransportAandTourManagementMouseClicked
        flagRoomReservation =  false;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = true;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_act");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_TATM_AirportPickupFrame();
    }//GEN-LAST:event_btnTransportAandTourManagementMouseClicked

    private void btnFinanceManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinanceManagementMouseClicked
        flagRoomReservation =  false;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = true;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_act");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_FM_IncomesManagementFrame();
    }//GEN-LAST:event_btnFinanceManagementMouseClicked

    private void btnEmployeeManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeManagementMouseClicked
           Employee_Details_Model loadData = new Employee_Details_Model();
        loadData.LoadCategories();
        
        flagRoomReservation =  false;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = true;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_act");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_EM_EmployeeDetailsFrame();
    }//GEN-LAST:event_btnEmployeeManagementMouseClicked

    private void btnStockManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockManagementMouseClicked
        flagRoomReservation =  false;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = true;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_act");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_STM_StockFrame();
    }//GEN-LAST:event_btnStockManagementMouseClicked

    private void btnEventHandlingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEventHandlingMouseClicked
        flagRoomReservation = false;
        flagRestaurantManagement = false;
        flagEventHandling = true;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_act");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_EH_VenueBookingFrame();
    }//GEN-LAST:event_btnEventHandlingMouseClicked

    private void btnRestaurantManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestaurantManagementMouseClicked
        flagRoomReservation =  false;
        flagRestaurantManagement = true;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_def");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_act");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_RM_RestaurantBillFrame();
    }//GEN-LAST:event_btnRestaurantManagementMouseClicked

    private void btnRoomReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRoomReservationMouseClicked
        flagRoomReservation = true;
        flagRestaurantManagement = false;
        flagEventHandling = false;
        flagStockManagement = false;
        flagEmployeeManagement = false;
        flagFinanceManagement = false;
        flagTransportAndTourManagement = false;
        flagLaundryAndRoomService = false;
        flagControlPanel = false;

        setMainTitles();

        loadSubMenuDef();

        Disk.loadMenuImage(btnRoomReservation, "room_reservation_act");
        Disk.loadMenuImage(btnRestaurantManagement, "restaurant_management_def");
        Disk.loadMenuImage(btnEventHandling, "event_handling_def");

        Disk.loadMenuImage(btnStockManagement, "stock_management_def");
        Disk.loadMenuImage(btnEmployeeManagement,"employee_management_def");
        Disk.loadMenuImage(btnFinanceManagement, "finance_management_def");

        Disk.loadMenuImage(btnTransportAandTourManagement, "transport_and_tour_management_def");
        Disk.loadMenuImage(btnLaundryAndRoomService, "laundry_and_room_service_def");
        Disk.loadMenuImage(btnControlPanel, "control_panel_def");

        open_RS_ReservationsFrame();
    }//GEN-LAST:event_btnRoomReservationMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel app;
    private javax.swing.JPanel appStatusbar;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnControlPanel;
    private javax.swing.JLabel btnEmployeeManagement;
    private javax.swing.JLabel btnEventHandling;
    private javax.swing.JLabel btnFinanceManagement;
    private javax.swing.JLabel btnLaundryAndRoomService;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnMinmize;
    private javax.swing.JLabel btnRestaurantManagement;
    private javax.swing.JLabel btnRoomReservation;
    private javax.swing.JLabel btnSocket01;
    private javax.swing.JLabel btnSocket02;
    private javax.swing.JLabel btnSocket03;
    private javax.swing.JLabel btnSocket04;
    private javax.swing.JLabel btnSocket05;
    private javax.swing.JLabel btnSocket06;
    private javax.swing.JLabel btnSocket07;
    private javax.swing.JLabel btnSocket08;
    private javax.swing.JLabel btnStockManagement;
    private javax.swing.JLabel btnTransportAandTourManagement;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel lblAccountType;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSideMenuTop;
    private javax.swing.JLabel lblTitle;
    public static javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlMainMenu;
    private javax.swing.JPanel pnlSideMenu;
    // End of variables declaration//GEN-END:variables
}
