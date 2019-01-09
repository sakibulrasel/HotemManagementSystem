/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;


import dbconnect.DatabaseHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import login.login;
import net.proteanit.sql.DbUtils;
//import javax.swing.ButtonGroup;

/**
 *
 * @author Sameera
 */
public class Hr_Manager extends javax.swing.JFrame {

    //variable for connect database
    Connection conn=DatabaseHelper.getDBConnection();
    PreparedStatement pstatement=null;
    ResultSet Results =null;
    static String USER;            
    SimpleDateFormat sdf;
    public Hr_Manager(String username) {
        USER=username;
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);

        new Thread() {
            public void run() {
                for (;;) {
                    sdf = new SimpleDateFormat("hh:mm:ss a");
                    Date d = new Date();
                    //System.out.println(sdf.format(d));
                    Time.setText(sdf.format(d));
                    sdf = new SimpleDateFormat("dd-MMM-yyyy");

                    dates.setText(sdf.format(d));

                    sdf = new SimpleDateFormat("EEEE");
                    // Date d3 = new Date();
                    day.setText(sdf.format(d));

                    try {
                        sleep(1000);
                    } catch (Exception e) {
                    }

                }

            }
        }.start();
       
        
        
        welcomeuser.setText(USER);
        this.setLocationRelativeTo(null); //Setting to display in the center of screen
        togglePanels.setVisible(true);
        addEmployeePanel.setVisible(false);
       
        searchPanel.setVisible(false);
        payrollPanel.setVisible(false);
        leavesPanel.setVisible(false);
        
        reportsPanel.setVisible(false);
        
        
//        addEmployeejTabbedPane1.setEnabledAt(0, true);
//        addEmployeejTabbedPane1.setEnabledAt(1, false);
//        
//        employeeEditjButton.setEnabled(false);
//        employeeDeletejButton2.setEnabled(false);
//        editEmplyoeejTabbedPane1.setEnabledAt(1, false);
//        leavesEmployeeNextjButton2.setEnabled(false);
//        emplyeeLeavesjserachTabbedPane1.setEnabledAt(1, false);
//        emplyeeLeavesjserachTabbedPane1.setEnabledAt(2,false);
        
//        searchEmployeeTableLoad();
//        wageTableLoad();
//        leaveTableLoad();
//        salaryTableLoad();
        
        
        
    }
    public void searchEmployeeTableLoad()
    {
        try {
            String Sql="select employee_id AS 'Employee ID', CONCAT(employee_fname, ' ', employee_lname)AS 'FullName',employee_nic AS 'NIC',employee_telephone AS 'Telephone',employee_address AS 'Address',employee_sex AS 'Gender',employee_DOB AS 'Date of Birth',employee_designation AS 'Designation',employee_type AS 'Type OF Employee',employee_hourly_rate AS 'Hourly Rate',employee_basic_salary AS 'Basic Salary',employee_department AS 'Department' from hr_employee";
            pstatement = conn.prepareStatement(Sql);
            Results=pstatement.executeQuery();
            searchjTable6.setModel(DbUtils.resultSetToTableModel(Results));
            TableColumn col=searchjTable6.getColumnModel().getColumn(0);
            col.setMinWidth(90);
            TableColumn col1=searchjTable6.getColumnModel().getColumn(1);
            col1.setMinWidth(130);
            TableColumn col2=searchjTable6.getColumnModel().getColumn(2);
            col2.setMinWidth(90);
            TableColumn col3=searchjTable6.getColumnModel().getColumn(3);
            col3.setMinWidth(90);
            TableColumn col4=searchjTable6.getColumnModel().getColumn(4);
            col4.setMinWidth(130);
            TableColumn col5=searchjTable6.getColumnModel().getColumn(5);
            col5.setMinWidth(90);
            TableColumn col6=searchjTable6.getColumnModel().getColumn(6);
            col6.setMinWidth(90);
            TableColumn col7=searchjTable6.getColumnModel().getColumn(7);
            col7.setMinWidth(130);
            TableColumn col8=searchjTable6.getColumnModel().getColumn(8);
            col8.setMinWidth(90);
            TableColumn col9=searchjTable6.getColumnModel().getColumn(9);
            col9.setMinWidth(90);
            TableColumn col10=searchjTable6.getColumnModel().getColumn(10);
            col10.setMinWidth(90);
            TableColumn col11=searchjTable6.getColumnModel().getColumn(11);
            col11.setMinWidth(90);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
            
        }
        
        
    }
     public void salaryTableLoad()
    {
        try {
            String Sql="select E.employee_id AS 'Employee ID', CONCAT(E.employee_fname, ' ', E.employee_lname)AS 'FullName',E.employee_basic_salary AS 'Basic Salary' from hr_employee E WHERE E.employee_type='Permanent'";
            pstatement = conn.prepareStatement(Sql);
            Results=pstatement.executeQuery();
           salaryEmplyeejTable3.setModel(DbUtils.resultSetToTableModel(Results));
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
            
        }
      
    }
   
    public void wageTableLoad()
    {
        try {
            String Sql="select E.employee_id AS 'Employee ID', CONCAT(E.employee_fname, ' ', E.employee_lname)AS 'FullName',E.employee_hourly_rate AS 'Hourly Rate'from hr_employee E WHERE E.employee_type='Part Time'";
            pstatement = conn.prepareStatement(Sql);
            Results=pstatement.executeQuery();
            wageEmplyeejTable4.setModel(DbUtils.resultSetToTableModel(Results));
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
            
        }
     
    }
    
    public void leaveTableLoad()
    {
        try {
            String Sql="select E.employee_id as 'Employee ID', CONCAT(E.employee_fname, ' ', E.employee_lname)AS 'FullName'from hr_employee E ";
            pstatement = conn.prepareStatement(Sql);
            Results=pstatement.executeQuery();
            leavesEmplyeejTable4.setModel(DbUtils.resultSetToTableModel(Results));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    
    }
       
    //Add Employee varibles
    String etype="";
    String eFname="";
    String eLname="";
    String eNic="";
    String eAdd="";
    String eSex="";
    String edob="";
    
    
    
    String edesignation="";
    
    
    
    String eDOCYear="";
    String eDOCMonth="";
    String eDOCDay="";
    
    String eTep="";
    String eDepatment="";
    String eBasicSalry="";
    String eHourlyRate="";
    
    String searchFname="";
    String searchLname="";
        
    //Update Veriable
    
    String upadteFName="";
    String updateAddress="";
    String updateNIC="";
    String UpdateTep="";
    String updateBOD="";
    String updateTypeOfEmployee="";
    String updateDOJ="";
    String updateDOC="";
    String updateHourlyRate="";
    String updateBasicSalary="";
    String updateDesignation="";
    String updateDepartment="";
    String updateGender="";
    String empID="";
    String fName ="";   
    String Lname ="";
    
    //Salary Veriable
    
    String salaryFullName="";
    String salaryEmpId="";
    String salaryBasicSalary="";
    String basicSalary="";
    String otherPay="";
    String deduc="";
    String Total="";
    String getEmpID="";
    
    //Wage Veriable
    String wageFullNAme="";
    String wageEmpId="";
    String wageHourlyRate="";
    String wageWorkedHours="";
    String wagededuc="";
    String wageOtherpay="";
    String wageTotal="";
    String getWageEmpID="";
    
    //Leaving Application
    String leavesEmpID="";
    String leavesFullName="";
    String leavesStartDate="";
    String leavesEndDate="";
    String leavesReson="";
    String leavesType="";
    
    
   
    
    //function for panel shifting
    public void panelshift(String buttonName){
        switch (buttonName) {
            case "ADD":
                addEmployeePanel.setVisible(true);
               
                searchPanel.setVisible(false);
                payrollPanel.setVisible(false);
                leavesPanel.setVisible(false);
                
                reportsPanel.setVisible(false);
                
                break;
            case "SEARCH":
                addEmployeePanel.setVisible(false);
                
                searchPanel.setVisible(true);
                payrollPanel.setVisible(false);
                leavesPanel.setVisible(false);
              
                reportsPanel.setVisible(false);
                
                break;
            case "PAYROLL":
                addEmployeePanel.setVisible(false);
               
                searchPanel.setVisible(false);
                payrollPanel.setVisible(true);
                leavesPanel.setVisible(false);
               
                reportsPanel.setVisible(false);
                
                break;
            case "LEAVES":
                addEmployeePanel.setVisible(false);
          
                searchPanel.setVisible(false);
                payrollPanel.setVisible(false);
                leavesPanel.setVisible(true);
                
                reportsPanel.setVisible(false);
               
                break;
            case "REPORTS":
                addEmployeePanel.setVisible(false);
              
                searchPanel.setVisible(false);
                payrollPanel.setVisible(false);
                leavesPanel.setVisible(false);
                
                reportsPanel.setVisible(true);
                
                break;
            case "USER LOGS":
                addEmployeePanel.setVisible(false);
                
                searchPanel.setVisible(false);
                payrollPanel.setVisible(false);
                leavesPanel.setVisible(false);
               
                reportsPanel.setVisible(false);
               
                break;
            case "SETTINGS":
                addEmployeePanel.setVisible(false);
                
                searchPanel.setVisible(false);
                payrollPanel.setVisible(false);
                leavesPanel.setVisible(false);
               
                reportsPanel.setVisible(false);
                
                break;
            default:
                break;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addEmployeeSexbuttonGroup = new javax.swing.ButtonGroup();
        jDesktopPaneFinance = new javax.swing.JDesktopPane();
        HRManagerPanel = new javax.swing.JPanel();
        mainButtonPanel = new javax.swing.JPanel();
        buttonAddEmployee = new javax.swing.JButton();
        buttonSearch = new javax.swing.JButton();
        buttonPayroll = new javax.swing.JButton();
        buttonAssests = new javax.swing.JButton();
        buttonReports = new javax.swing.JButton();
        togglePanels = new javax.swing.JPanel();
        addEmployeePanel = new javax.swing.JPanel();
        addEmployeejTabbedPane1 = new javax.swing.JTabbedPane();
        personalDetailsjPanel1 = new javax.swing.JPanel();
        employeeIdjLabel1 = new javax.swing.JLabel();
        typeOfEmplyoeejLabel1 = new javax.swing.JLabel();
        typeOfEmployeejComboBox1 = new javax.swing.JComboBox<>();
        designationjLabel1 = new javax.swing.JLabel();
        adEemployeeDesignationjTextField2 = new javax.swing.JTextField();
        employeeFirstNamejLabel1 = new javax.swing.JLabel();
        employeefirstnamejTextField1 = new javax.swing.JTextField();
        emplyoeeLastNamejLabel2 = new javax.swing.JLabel();
        employeeLNamejTextField2 = new javax.swing.JTextField();
        employeeDobjLabel3 = new javax.swing.JLabel();
        employeeNICjLabel7 = new javax.swing.JLabel();
        employeeNicjTextField2 = new javax.swing.JTextField();
        employeeAddressjLabel7 = new javax.swing.JLabel();
        employeeAddjTextField2 = new javax.swing.JTextField();
        employeeSexjLabel4 = new javax.swing.JLabel();
        employeeTpjLabel5 = new javax.swing.JLabel();
        employeeTpjTextField3 = new javax.swing.JTextField();
        AddEmployeeNextjButton1 = new javax.swing.JButton();
        addEmployeeSexMalejRadioButton1 = new javax.swing.JRadioButton();
        addEmployeeSexFemalejRadioButton2 = new javax.swing.JRadioButton();
        datePickerPanal = new javax.swing.JPanel();
        addEmployeeDOBjDateChooser1 = new com.toedter.calendar.JDateChooser();
        txteid = new javax.swing.JTextField();
        jobDetailsjPanel1 = new javax.swing.JPanel();
        DepartmentjLabel1 = new javax.swing.JLabel();
        depatrmentjComboBox1 = new javax.swing.JComboBox<>();
        besicSalaryjLabel2 = new javax.swing.JLabel();
        hourlyRatejTextField2 = new javax.swing.JTextField();
        hourlyrateDayjLabel3 = new javax.swing.JLabel();
        addEmployeeBackjButton = new javax.swing.JButton();
        addEmployeeAddjButton1 = new javax.swing.JButton();
        basicSalaryjTextField2 = new javax.swing.JTextField();
        searchPanel = new javax.swing.JPanel();
        editEmplyoeejTabbedPane1 = new javax.swing.JTabbedPane();
        searchEmployeejPanel2 = new javax.swing.JPanel();
        employeeSearchFirstNamejTextField1 = new javax.swing.JTextField();
        employeeSearchjButton1 = new javax.swing.JButton();
        serachEmployeeFnamejLabel = new javax.swing.JLabel();
        employeeEditjButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchjTable6 = new javax.swing.JTable();
        employeeDeletejButton2 = new javax.swing.JButton();
        editEmployeejPanel1 = new javax.swing.JPanel();
        editDesignationjLabel2 = new javax.swing.JLabel();
        editEmployeeIdjTextField4 = new javax.swing.JTextField();
        editTypeOfEmployeejComboBox2 = new javax.swing.JComboBox<>();
        editTypeOfEmplyoeejLabel2 = new javax.swing.JLabel();
        editEmployeeFirstNamejLabel2 = new javax.swing.JLabel();
        editEmployeefirstnamejTextField2 = new javax.swing.JTextField();
        editEmployeeNicjTextField3 = new javax.swing.JTextField();
        editEmployeeNICjLabel8 = new javax.swing.JLabel();
        editEmployeeAddjTextField3 = new javax.swing.JTextField();
        editEmployeeAddressjLabel8 = new javax.swing.JLabel();
        editEmployeeTpjTextField4 = new javax.swing.JTextField();
        editEmployeeTpjLabel6 = new javax.swing.JLabel();
        saveEmployeejButton1 = new javax.swing.JButton();
        editBesicSalaryjLabel5 = new javax.swing.JLabel();
        editBasicSalaryjTextField6 = new javax.swing.JTextField();
        editHourlyrateDayjLabel4 = new javax.swing.JLabel();
        editHourlyRatejTextField3 = new javax.swing.JTextField();
        editDepartmentjLabel4 = new javax.swing.JLabel();
        editDepatrmentjComboBox2 = new javax.swing.JComboBox<>();
        editEmployeeBackjButton1 = new javax.swing.JButton();
        payrollPanel = new javax.swing.JPanel();
        parrolljTabbedPane1 = new javax.swing.JTabbedPane();
        salaryjPanel1 = new javax.swing.JPanel();
        salaryjPanel = new javax.swing.JPanel();
        besicSalaryjLabel5 = new javax.swing.JLabel();
        basicSalaryjTextField6 = new javax.swing.JTextField();
        salaryOtherPayjLabel7 = new javax.swing.JLabel();
        salaryOtherpayjTextField7 = new javax.swing.JTextField();
        salarydeductionyjLabel8 = new javax.swing.JLabel();
        salaryDeductionjTextField10 = new javax.swing.JTextField();
        salaryTotalEarningjTextField8 = new javax.swing.JTextField();
        salarydeductionyjLabel9 = new javax.swing.JLabel();
        salaryCalculatejButton = new javax.swing.JButton();
        SalaryIdjLabel4 = new javax.swing.JLabel();
        salarySavejButton1 = new javax.swing.JButton();
        salaryEmployeeIdjTextField1 = new javax.swing.JTextField();
        salarEyemployeeIdjLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        salaryEmplyeejTable3 = new javax.swing.JTable();
        wagejPanel2 = new javax.swing.JPanel();
        salaryjPanel2 = new javax.swing.JPanel();
        wageHourlyRatejLabel5 = new javax.swing.JLabel();
        wageHourlyRatejTextField6 = new javax.swing.JTextField();
        wageOtherPayjLabel7 = new javax.swing.JLabel();
        wageOtherpayjTextField7 = new javax.swing.JTextField();
        wageOtherPayjLabel8 = new javax.swing.JLabel();
        wageOtherpayjTextField8 = new javax.swing.JTextField();
        wagedeductionyjLabel8 = new javax.swing.JLabel();
        wageDeductionjTextField10 = new javax.swing.JTextField();
        wageSavejButton = new javax.swing.JButton();
        wageTotalEarningjTextField8 = new javax.swing.JTextField();
        wagedeductionyjLabel9 = new javax.swing.JLabel();
        wageIdjLabel4 = new javax.swing.JLabel();
        salarEyemployeeIdjLabel6 = new javax.swing.JLabel();
        wageEmployeeIdjTextField2 = new javax.swing.JTextField();
        wageCalculatejButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        wageEmplyeejTable4 = new javax.swing.JTable();
        leavesPanel = new javax.swing.JPanel();
        leavesjPanel1 = new javax.swing.JPanel();
        emplyeeLeavesjserachTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        leavesEmloyeeFirstNamejLabel2 = new javax.swing.JLabel();
        leavesEmployeefirstnamejTextField2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        leavesEmplyeejTable4 = new javax.swing.JTable();
        leaveEmployeeSearchjButton = new javax.swing.JButton();
        leavesEmployeeNextjButton2 = new javax.swing.JButton();
        leaveAplicationjPanel1 = new javax.swing.JPanel();
        leavesEmloyeeFirstNamejLabel3 = new javax.swing.JLabel();
        leavesEmloyeeFirstNamejLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        leavesEmloyeeFirstNamejLabel5 = new javax.swing.JLabel();
        leavesEmloyeeFirstNamejLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        saveEmployeejButton2 = new javax.swing.JButton();
        datePickerPanal1 = new javax.swing.JPanel();
        leaveApplicationFromDateDateChooser1 = new com.toedter.calendar.JDateChooser();
        datePickerPanal2 = new javax.swing.JPanel();
        leaveApplicationEndDateDateChooser1 = new com.toedter.calendar.JDateChooser();
        leavesEmployeeIDjTextField1 = new javax.swing.JTextField();
        leavesEmloyeeFirstNamejLabel7 = new javax.swing.JLabel();
        leaveEmployeeBackjButton1 = new javax.swing.JButton();
        reportsPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        welcomeuser = new javax.swing.JLabel();
        welcomeuser1 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        dates = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        buttonLogOut = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Glen Hotel Management System");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(1020, 700));

        jDesktopPaneFinance.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPaneFinance.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPaneFinance.setPreferredSize(new java.awt.Dimension(1024, 690));

        HRManagerPanel.setBackground(new java.awt.Color(255, 255, 255));
        HRManagerPanel.setPreferredSize(new java.awt.Dimension(1024, 690));
        HRManagerPanel.setLayout(null);

        mainButtonPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainButtonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        mainButtonPanel.setPreferredSize(new java.awt.Dimension(187, 552));

        buttonAddEmployee.setBackground(new java.awt.Color(51, 153, 255));
        buttonAddEmployee.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        buttonAddEmployee.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddEmployee.setText("ADD");
        buttonAddEmployee.setAlignmentY(1.5F);
        buttonAddEmployee.setBorder(null);
        buttonAddEmployee.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonAddEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAddEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAddEmployeeMouseExited(evt);
            }
        });
        buttonAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEmployeeActionPerformed(evt);
            }
        });

        buttonSearch.setBackground(new java.awt.Color(51, 153, 255));
        buttonSearch.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        buttonSearch.setForeground(new java.awt.Color(255, 255, 255));
        buttonSearch.setText("SEARCH");
        buttonSearch.setAlignmentX(1.0F);
        buttonSearch.setAlignmentY(1.0F);
        buttonSearch.setBorder(null);
        buttonSearch.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonSearch.setName(""); // NOI18N
        buttonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonSearchMouseExited(evt);
            }
        });
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        buttonPayroll.setBackground(new java.awt.Color(51, 153, 255));
        buttonPayroll.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        buttonPayroll.setForeground(new java.awt.Color(255, 255, 255));
        buttonPayroll.setText("PAYROLL");
        buttonPayroll.setBorder(null);
        buttonPayroll.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonPayroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonPayrollMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonPayrollMouseExited(evt);
            }
        });
        buttonPayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPayrollActionPerformed(evt);
            }
        });

        buttonAssests.setBackground(new java.awt.Color(51, 153, 255));
        buttonAssests.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        buttonAssests.setForeground(new java.awt.Color(255, 255, 255));
        buttonAssests.setText("LEAVES");
        buttonAssests.setAlignmentY(1.5F);
        buttonAssests.setBorder(null);
        buttonAssests.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonAssests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAssestsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAssestsMouseExited(evt);
            }
        });
        buttonAssests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAssestsActionPerformed(evt);
            }
        });

        buttonReports.setBackground(new java.awt.Color(51, 153, 255));
        buttonReports.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        buttonReports.setForeground(new java.awt.Color(255, 255, 255));
        buttonReports.setText("REPORTS");
        buttonReports.setAlignmentY(1.5F);
        buttonReports.setBorder(null);
        buttonReports.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonReportsMouseExited(evt);
            }
        });
        buttonReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainButtonPanelLayout = new javax.swing.GroupLayout(mainButtonPanel);
        mainButtonPanel.setLayout(mainButtonPanelLayout);
        mainButtonPanelLayout.setHorizontalGroup(
            mainButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPayroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAssests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonReports, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainButtonPanelLayout.setVerticalGroup(
            mainButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAssests, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonReports, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        HRManagerPanel.add(mainButtonPanel);
        mainButtonPanel.setBounds(0, 135, 187, 552);

        togglePanels.setBackground(new java.awt.Color(255, 255, 255));
        togglePanels.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        togglePanels.setPreferredSize(new java.awt.Dimension(832, 552));

        addEmployeePanel.setBackground(new java.awt.Color(255, 255, 255));
        addEmployeePanel.setPreferredSize(new java.awt.Dimension(830, 550));

        addEmployeejTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        addEmployeejTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addEmployeejTabbedPane1.setPreferredSize(new java.awt.Dimension(828, 555));

        personalDetailsjPanel1.setBackground(new java.awt.Color(255, 255, 255));
        personalDetailsjPanel1.setPreferredSize(new java.awt.Dimension(823, 517));

        employeeIdjLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeIdjLabel1.setText("Employee ID");

        typeOfEmplyoeejLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typeOfEmplyoeejLabel1.setText("Type Of Employee");

        typeOfEmployeejComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typeOfEmployeejComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select the type", "Permanent Employee", "Part Time Employee" }));
        typeOfEmployeejComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        designationjLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        designationjLabel1.setText("Designation");

        adEemployeeDesignationjTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adEemployeeDesignationjTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adEemployeeDesignationjTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        employeeFirstNamejLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeFirstNamejLabel1.setText("First Name");

        employeefirstnamejTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeefirstnamejTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        employeefirstnamejTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        employeefirstnamejTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeefirstnamejTextField1ActionPerformed(evt);
            }
        });

        emplyoeeLastNamejLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emplyoeeLastNamejLabel2.setText("Last Name");

        employeeLNamejTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeLNamejTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        employeeLNamejTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        employeeDobjLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeDobjLabel3.setText("DOB");

        employeeNICjLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeNICjLabel7.setText("NIC Number");

        employeeNicjTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeNicjTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        employeeNicjTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        employeeAddressjLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeAddressjLabel7.setText("Address");

        employeeAddjTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeAddjTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        employeeAddjTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        employeeSexjLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeSexjLabel4.setText("Gender");

        employeeTpjLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeTpjLabel5.setText("Telephone");

        employeeTpjTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeTpjTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        employeeTpjTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        AddEmployeeNextjButton1.setBackground(new java.awt.Color(204, 204, 204));
        AddEmployeeNextjButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddEmployeeNextjButton1.setText("NEXT");
        AddEmployeeNextjButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        AddEmployeeNextjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmployeeNextjButton1ActionPerformed(evt);
            }
        });

        addEmployeeSexMalejRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        addEmployeeSexbuttonGroup.add(addEmployeeSexMalejRadioButton1);
        addEmployeeSexMalejRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addEmployeeSexMalejRadioButton1.setText("Male");

        addEmployeeSexFemalejRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        addEmployeeSexbuttonGroup.add(addEmployeeSexFemalejRadioButton2);
        addEmployeeSexFemalejRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addEmployeeSexFemalejRadioButton2.setText("Female");

        datePickerPanal.setBackground(new java.awt.Color(255, 255, 255));

        addEmployeeDOBjDateChooser1.setBackground(new java.awt.Color(204, 204, 204));
        addEmployeeDOBjDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout datePickerPanalLayout = new javax.swing.GroupLayout(datePickerPanal);
        datePickerPanal.setLayout(datePickerPanalLayout);
        datePickerPanalLayout.setHorizontalGroup(
            datePickerPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePickerPanalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEmployeeDOBjDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        datePickerPanalLayout.setVerticalGroup(
            datePickerPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datePickerPanalLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(addEmployeeDOBjDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout personalDetailsjPanel1Layout = new javax.swing.GroupLayout(personalDetailsjPanel1);
        personalDetailsjPanel1.setLayout(personalDetailsjPanel1Layout);
        personalDetailsjPanel1Layout.setHorizontalGroup(
            personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(emplyoeeLastNamejLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(employeeLNamejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(typeOfEmplyoeejLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(typeOfEmployeejComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(employeeNICjLabel7)
                        .addGap(42, 42, 42)
                        .addComponent(employeeNicjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(employeeDobjLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(datePickerPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(employeeTpjLabel5)
                        .addGap(54, 54, 54)
                        .addComponent(employeeTpjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(624, 624, 624)
                        .addComponent(AddEmployeeNextjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                                .addComponent(employeeSexjLabel4)
                                .addGap(94, 94, 94)
                                .addComponent(addEmployeeSexMalejRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addEmployeeSexFemalejRadioButton2))
                            .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                                .addComponent(employeeAddressjLabel7)
                                .addGap(69, 69, 69)
                                .addComponent(employeeAddjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeFirstNamejLabel1)
                            .addComponent(employeeIdjLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeefirstnamejTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txteid))
                        .addGap(61, 61, 61)
                        .addComponent(designationjLabel1)
                        .addGap(98, 98, 98)
                        .addComponent(adEemployeeDesignationjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        personalDetailsjPanel1Layout.setVerticalGroup(
            personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIdjLabel1)
                    .addComponent(txteid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeFirstNamejLabel1)
                    .addComponent(employeefirstnamejTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(designationjLabel1))
                    .addComponent(adEemployeeDesignationjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(emplyoeeLastNamejLabel2))
                    .addComponent(employeeLNamejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(typeOfEmplyoeejLabel1))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(typeOfEmployeejComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(employeeNICjLabel7))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(employeeNicjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalDetailsjPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(employeeDobjLabel3))
                    .addComponent(datePickerPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeTpjLabel5)
                    .addComponent(employeeTpjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeAddressjLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeAddjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeSexjLabel4)
                    .addGroup(personalDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addEmployeeSexMalejRadioButton1)
                        .addComponent(addEmployeeSexFemalejRadioButton2)))
                .addGap(30, 30, 30)
                .addComponent(AddEmployeeNextjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        addEmployeejTabbedPane1.addTab("PERSONAL DETAILS", personalDetailsjPanel1);

        jobDetailsjPanel1.setBackground(new java.awt.Color(255, 255, 255));

        DepartmentjLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DepartmentjLabel1.setText("Department");

        depatrmentjComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        depatrmentjComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select the Department", "HR Department", "Room Mangement Department", "Event Management Department", "Transport Department" }));
        depatrmentjComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        besicSalaryjLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        besicSalaryjLabel2.setText("Basic Salary");

        hourlyRatejTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hourlyRatejTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hourlyRatejTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        hourlyRatejTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourlyRatejTextField2ActionPerformed(evt);
            }
        });

        hourlyrateDayjLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hourlyrateDayjLabel3.setText("Hourly Rate");

        addEmployeeBackjButton.setBackground(new java.awt.Color(204, 204, 204));
        addEmployeeBackjButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addEmployeeBackjButton.setText("BACK");
        addEmployeeBackjButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        addEmployeeBackjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeBackjButtonActionPerformed(evt);
            }
        });

        addEmployeeAddjButton1.setBackground(new java.awt.Color(204, 204, 204));
        addEmployeeAddjButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addEmployeeAddjButton1.setText("ADD");
        addEmployeeAddjButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        addEmployeeAddjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeAddjButton1ActionPerformed(evt);
            }
        });

        basicSalaryjTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        basicSalaryjTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        basicSalaryjTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        basicSalaryjTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicSalaryjTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jobDetailsjPanel1Layout = new javax.swing.GroupLayout(jobDetailsjPanel1);
        jobDetailsjPanel1.setLayout(jobDetailsjPanel1Layout);
        jobDetailsjPanel1Layout.setHorizontalGroup(
            jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jobDetailsjPanel1Layout.createSequentialGroup()
                .addContainerGap(432, Short.MAX_VALUE)
                .addComponent(addEmployeeBackjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
            .addGroup(jobDetailsjPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hourlyrateDayjLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepartmentjLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(besicSalaryjLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jobDetailsjPanel1Layout.createSequentialGroup()
                        .addComponent(hourlyRatejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jobDetailsjPanel1Layout.createSequentialGroup()
                        .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(depatrmentjComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(basicSalaryjTextField2))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jobDetailsjPanel1Layout.createSequentialGroup()
                    .addContainerGap(627, Short.MAX_VALUE)
                    .addComponent(addEmployeeAddjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)))
        );
        jobDetailsjPanel1Layout.setVerticalGroup(
            jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jobDetailsjPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hourlyrateDayjLabel3)
                    .addComponent(hourlyRatejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepartmentjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depatrmentjComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(besicSalaryjLabel2)
                    .addComponent(basicSalaryjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(addEmployeeBackjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jobDetailsjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jobDetailsjPanel1Layout.createSequentialGroup()
                    .addContainerGap(448, Short.MAX_VALUE)
                    .addComponent(addEmployeeAddjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)))
        );

        addEmployeejTabbedPane1.addTab("JOB DETAILS", jobDetailsjPanel1);

        javax.swing.GroupLayout addEmployeePanelLayout = new javax.swing.GroupLayout(addEmployeePanel);
        addEmployeePanel.setLayout(addEmployeePanelLayout);
        addEmployeePanelLayout.setHorizontalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addEmployeejTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        addEmployeePanelLayout.setVerticalGroup(
            addEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addEmployeejTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setPreferredSize(new java.awt.Dimension(830, 550));

        editEmplyoeejTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        searchEmployeejPanel2.setBackground(new java.awt.Color(255, 255, 255));
        searchEmployeejPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        employeeSearchFirstNamejTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        employeeSearchFirstNamejTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        employeeSearchFirstNamejTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSearchFirstNamejTextField1ActionPerformed(evt);
            }
        });

        employeeSearchjButton1.setBackground(new java.awt.Color(204, 204, 204));
        employeeSearchjButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeSearchjButton1.setText("Search");
        employeeSearchjButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        employeeSearchjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSearchjButton1ActionPerformed(evt);
            }
        });

        serachEmployeeFnamejLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        serachEmployeeFnamejLabel.setText("Employee ID");

        employeeEditjButton.setBackground(new java.awt.Color(204, 204, 204));
        employeeEditjButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeEditjButton.setText("Edit");
        employeeEditjButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        employeeEditjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeEditjButtonActionPerformed(evt);
            }
        });

        searchjTable6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        searchjTable6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchjTable6.setForeground(new java.awt.Color(35, 86, 222));
        searchjTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Full Name", "NIC", "Telephone", "Address", "Gender", "BOD", "Designation", "Type OF Employee", "Hourlyrate", "Basic Salary", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        searchjTable6.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        searchjTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchjTable6MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(searchjTable6);
        if (searchjTable6.getColumnModel().getColumnCount() > 0) {
            searchjTable6.getColumnModel().getColumn(0).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(0).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(0).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(1).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(1).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(1).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(2).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(2).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(2).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(3).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(3).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(3).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(4).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(4).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(5).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(5).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(5).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(6).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(6).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(6).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(7).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(7).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(7).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(8).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(8).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(8).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(9).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(9).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(9).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(10).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(10).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(10).setMaxWidth(100);
            searchjTable6.getColumnModel().getColumn(11).setMinWidth(100);
            searchjTable6.getColumnModel().getColumn(11).setPreferredWidth(100);
            searchjTable6.getColumnModel().getColumn(11).setMaxWidth(100);
        }

        employeeDeletejButton2.setBackground(new java.awt.Color(204, 204, 204));
        employeeDeletejButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeDeletejButton2.setText("Delete");
        employeeDeletejButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        employeeDeletejButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeDeletejButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchEmployeejPanel2Layout = new javax.swing.GroupLayout(searchEmployeejPanel2);
        searchEmployeejPanel2.setLayout(searchEmployeejPanel2Layout);
        searchEmployeejPanel2Layout.setHorizontalGroup(
            searchEmployeejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchEmployeejPanel2Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(searchEmployeejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchEmployeejPanel2Layout.createSequentialGroup()
                        .addComponent(serachEmployeeFnamejLabel)
                        .addGap(48, 48, 48)
                        .addComponent(employeeSearchFirstNamejTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(employeeSearchjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchEmployeejPanel2Layout.createSequentialGroup()
                        .addComponent(employeeDeletejButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employeeEditjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
            .addGroup(searchEmployeejPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        searchEmployeejPanel2Layout.setVerticalGroup(
            searchEmployeejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchEmployeejPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(searchEmployeejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchEmployeejPanel2Layout.createSequentialGroup()
                        .addComponent(serachEmployeeFnamejLabel)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchEmployeejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(employeeSearchFirstNamejTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeeSearchjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(searchEmployeejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeDeletejButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeEditjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        editEmplyoeejTabbedPane1.addTab("SEARCH EMPLOYEE", searchEmployeejPanel2);

        editEmployeejPanel1.setBackground(new java.awt.Color(255, 255, 255));

        editDesignationjLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editDesignationjLabel2.setText("Designation");

        editEmployeeIdjTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editEmployeeIdjTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editEmployeeIdjTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        editTypeOfEmployeejComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editTypeOfEmployeejComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select the type", "Permanent Employee", "Part Time Employee" }));
        editTypeOfEmployeejComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        editTypeOfEmplyoeejLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editTypeOfEmplyoeejLabel2.setText("Type Of Employee");

        editEmployeeFirstNamejLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editEmployeeFirstNamejLabel2.setText("Full Name");

        editEmployeefirstnamejTextField2.setEditable(false);
        editEmployeefirstnamejTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editEmployeefirstnamejTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editEmployeefirstnamejTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        editEmployeefirstnamejTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeefirstnamejTextField2ActionPerformed(evt);
            }
        });

        editEmployeeNicjTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editEmployeeNicjTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editEmployeeNicjTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        editEmployeeNICjLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editEmployeeNICjLabel8.setText("NIC Number");

        editEmployeeAddjTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editEmployeeAddjTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editEmployeeAddjTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        editEmployeeAddressjLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editEmployeeAddressjLabel8.setText("Address");

        editEmployeeTpjTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editEmployeeTpjTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editEmployeeTpjTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        editEmployeeTpjLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editEmployeeTpjLabel6.setText("Telephone");

        saveEmployeejButton1.setBackground(new java.awt.Color(204, 204, 204));
        saveEmployeejButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveEmployeejButton1.setText("SAVE");
        saveEmployeejButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        saveEmployeejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmployeejButton1ActionPerformed(evt);
            }
        });

        editBesicSalaryjLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editBesicSalaryjLabel5.setText("Basic Salary");

        editBasicSalaryjTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBasicSalaryjTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editBasicSalaryjTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        editBasicSalaryjTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBasicSalaryjTextField6ActionPerformed(evt);
            }
        });

        editHourlyrateDayjLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editHourlyrateDayjLabel4.setText("Hourly Rate");

        editHourlyRatejTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editHourlyRatejTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        editHourlyRatejTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        editDepartmentjLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editDepartmentjLabel4.setText("Department");

        editDepatrmentjComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editDepatrmentjComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select the Department", "HR Department", "Finance Department", "Stock Mangement Department", "Room Mangement Department", "Event Management Department", "Transport Department", "Restaurant" }));
        editDepatrmentjComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        editEmployeeBackjButton1.setBackground(new java.awt.Color(204, 204, 204));
        editEmployeeBackjButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editEmployeeBackjButton1.setText("BACK");
        editEmployeeBackjButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        editEmployeeBackjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeeBackjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editEmployeejPanel1Layout = new javax.swing.GroupLayout(editEmployeejPanel1);
        editEmployeejPanel1.setLayout(editEmployeejPanel1Layout);
        editEmployeejPanel1Layout.setHorizontalGroup(
            editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEmployeejPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editEmployeejPanel1Layout.createSequentialGroup()
                            .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(editEmployeeNICjLabel8)
                                .addComponent(editEmployeeAddressjLabel8)
                                .addComponent(editDesignationjLabel2)
                                .addComponent(editTypeOfEmplyoeejLabel2)
                                .addComponent(editEmployeeTpjLabel6))
                            .addGap(35, 35, 35))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEmployeejPanel1Layout.createSequentialGroup()
                            .addComponent(editDepartmentjLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)))
                    .addGroup(editEmployeejPanel1Layout.createSequentialGroup()
                        .addComponent(editEmployeeFirstNamejLabel2)
                        .addGap(90, 90, 90)))
                .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editEmployeeAddjTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editEmployeeNicjTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editEmployeeIdjTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTypeOfEmployeejComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editEmployeeTpjTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editEmployeejPanel1Layout.createSequentialGroup()
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editEmployeefirstnamejTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editDepatrmentjComboBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(66, 66, 66)
                .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEmployeejPanel1Layout.createSequentialGroup()
                        .addComponent(editEmployeeBackjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(saveEmployeejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editEmployeejPanel1Layout.createSequentialGroup()
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editBesicSalaryjLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editHourlyrateDayjLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editBasicSalaryjTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(editHourlyRatejTextField3))))
                .addGap(21, 21, 21))
        );
        editEmployeejPanel1Layout.setVerticalGroup(
            editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmployeejPanel1Layout.createSequentialGroup()
                .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEmployeejPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(editBasicSalaryjTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editBesicSalaryjLabel5)
                                .addComponent(editEmployeefirstnamejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(editEmployeeFirstNamejLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editEmployeeNicjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editEmployeeNICjLabel8)
                            .addComponent(editHourlyrateDayjLabel4)
                            .addComponent(editHourlyRatejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editEmployeeAddjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editEmployeeAddressjLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editDesignationjLabel2)
                            .addComponent(editEmployeeIdjTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editTypeOfEmplyoeejLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editTypeOfEmployeejComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editEmployeeTpjTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editEmployeeTpjLabel6))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(editEmployeejPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editDepatrmentjComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editDepartmentjLabel4))))
                .addGap(44, 44, 44)
                .addGroup(editEmployeejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveEmployeejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEmployeeBackjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        editEmplyoeejTabbedPane1.addTab("EDIT EMPLOYEE", editEmployeejPanel1);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editEmplyoeejTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addComponent(editEmplyoeejTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        payrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        payrollPanel.setPreferredSize(new java.awt.Dimension(830, 550));

        parrolljTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        salaryjPanel1.setBackground(new java.awt.Color(255, 255, 255));
        salaryjPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salaryjPanel1.setPreferredSize(new java.awt.Dimension(825, 524));

        besicSalaryjLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        besicSalaryjLabel5.setText("Basic Salary");

        basicSalaryjTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        basicSalaryjTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        basicSalaryjTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        basicSalaryjTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicSalaryjTextField6ActionPerformed(evt);
            }
        });

        salaryOtherPayjLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salaryOtherPayjLabel7.setText("Other pay");

        salaryOtherpayjTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salaryOtherpayjTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryOtherpayjTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        salaryOtherpayjTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryOtherpayjTextField7ActionPerformed(evt);
            }
        });

        salarydeductionyjLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salarydeductionyjLabel8.setText("Deduction");

        salaryDeductionjTextField10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salaryDeductionjTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryDeductionjTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        salaryDeductionjTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryDeductionjTextField10ActionPerformed(evt);
            }
        });

        salaryTotalEarningjTextField8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        salaryTotalEarningjTextField8.setForeground(new java.awt.Color(204, 204, 255));
        salaryTotalEarningjTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryTotalEarningjTextField8.setPreferredSize(new java.awt.Dimension(19, 16));
        salaryTotalEarningjTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTotalEarningjTextField8ActionPerformed(evt);
            }
        });

        salarydeductionyjLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salarydeductionyjLabel9.setText("Total");

        salaryCalculatejButton.setBackground(new java.awt.Color(204, 204, 204));
        salaryCalculatejButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salaryCalculatejButton.setText("Calculate");
        salaryCalculatejButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        salaryCalculatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryCalculatejButtonActionPerformed(evt);
            }
        });

        SalaryIdjLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SalaryIdjLabel4.setText("Salary ID");

        salarySavejButton1.setBackground(new java.awt.Color(204, 204, 204));
        salarySavejButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salarySavejButton1.setText("Save");
        salarySavejButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        salarySavejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarySavejButton1ActionPerformed(evt);
            }
        });

        salaryEmployeeIdjTextField1.setBackground(new java.awt.Color(218, 218, 218));

        salarEyemployeeIdjLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salarEyemployeeIdjLabel5.setText("Employee ID");

        javax.swing.GroupLayout salaryjPanelLayout = new javax.swing.GroupLayout(salaryjPanel);
        salaryjPanel.setLayout(salaryjPanelLayout);
        salaryjPanelLayout.setHorizontalGroup(
            salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryjPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salaryjPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(SalaryIdjLabel4)
                        .addGap(55, 55, 55)
                        .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salaryjPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(salarEyemployeeIdjLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(salaryEmployeeIdjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(salaryjPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(salaryDeductionjTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salaryTotalEarningjTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salaryOtherpayjTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(basicSalaryjTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))))
                    .addGroup(salaryjPanelLayout.createSequentialGroup()
                        .addComponent(salarydeductionyjLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(salaryjPanelLayout.createSequentialGroup()
                        .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salaryjPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(besicSalaryjLabel5)
                                    .addComponent(salaryOtherPayjLabel7)))
                            .addComponent(salarydeductionyjLabel8))
                        .addContainerGap())))
            .addGroup(salaryjPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(salaryCalculatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salarySavejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        salaryjPanelLayout.setVerticalGroup(
            salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalaryIdjLabel4)
                    .addComponent(salaryEmployeeIdjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salarEyemployeeIdjLabel5))
                .addGap(58, 58, 58)
                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(besicSalaryjLabel5)
                    .addComponent(basicSalaryjTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryOtherPayjLabel7)
                    .addComponent(salaryOtherpayjTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarydeductionyjLabel8)
                    .addComponent(salaryDeductionjTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryTotalEarningjTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salarydeductionyjLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(salaryjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryCalculatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salarySavejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        salaryEmplyeejTable3.setForeground(new java.awt.Color(51, 51, 255));
        salaryEmplyeejTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee ID", "Full Name", "Basic Salary"
            }
        ));
        salaryEmplyeejTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salaryEmplyeejTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(salaryEmplyeejTable3);
        if (salaryEmplyeejTable3.getColumnModel().getColumnCount() > 0) {
            salaryEmplyeejTable3.getColumnModel().getColumn(0).setPreferredWidth(100);
            salaryEmplyeejTable3.getColumnModel().getColumn(1).setPreferredWidth(100);
            salaryEmplyeejTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        javax.swing.GroupLayout salaryjPanel1Layout = new javax.swing.GroupLayout(salaryjPanel1);
        salaryjPanel1.setLayout(salaryjPanel1Layout);
        salaryjPanel1Layout.setHorizontalGroup(
            salaryjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryjPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salaryjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        salaryjPanel1Layout.setVerticalGroup(
            salaryjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salaryjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(salaryjPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 158, Short.MAX_VALUE))
        );

        parrolljTabbedPane1.addTab("Salary", salaryjPanel1);

        wagejPanel2.setBackground(new java.awt.Color(255, 255, 255));
        wagejPanel2.setPreferredSize(new java.awt.Dimension(825, 524));

        wageHourlyRatejLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wageHourlyRatejLabel5.setText("Hourly Rate");

        wageHourlyRatejTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wageHourlyRatejTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        wageHourlyRatejTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wageHourlyRatejTextField6ActionPerformed(evt);
            }
        });

        wageOtherPayjLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wageOtherPayjLabel7.setText("Worked Hours");

        wageOtherpayjTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wageOtherpayjTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        wageOtherpayjTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wageOtherpayjTextField7ActionPerformed(evt);
            }
        });

        wageOtherPayjLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wageOtherPayjLabel8.setText("Other pay");

        wageOtherpayjTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wageOtherpayjTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        wageOtherpayjTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wageOtherpayjTextField8ActionPerformed(evt);
            }
        });

        wagedeductionyjLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wagedeductionyjLabel8.setText("Deduction");

        wageDeductionjTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wageDeductionjTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        wageDeductionjTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wageDeductionjTextField10ActionPerformed(evt);
            }
        });

        wageSavejButton.setBackground(new java.awt.Color(204, 204, 204));
        wageSavejButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wageSavejButton.setText("SAVE");
        wageSavejButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        wageSavejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wageSavejButtonActionPerformed(evt);
            }
        });

        wageTotalEarningjTextField8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        wageTotalEarningjTextField8.setForeground(new java.awt.Color(204, 204, 255));
        wageTotalEarningjTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wageTotalEarningjTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wageTotalEarningjTextField8ActionPerformed(evt);
            }
        });

        wagedeductionyjLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wagedeductionyjLabel9.setText("Total");

        wageIdjLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wageIdjLabel4.setText("Wage  ID");

        salarEyemployeeIdjLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salarEyemployeeIdjLabel6.setText("Employee ID");

        wageEmployeeIdjTextField2.setBackground(new java.awt.Color(218, 218, 218));

        wageCalculatejButton1.setBackground(new java.awt.Color(204, 204, 204));
        wageCalculatejButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wageCalculatejButton1.setText("Calculate");
        wageCalculatejButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        wageCalculatejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wageCalculatejButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salaryjPanel2Layout = new javax.swing.GroupLayout(salaryjPanel2);
        salaryjPanel2.setLayout(salaryjPanel2Layout);
        salaryjPanel2Layout.setHorizontalGroup(
            salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryjPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(salaryjPanel2Layout.createSequentialGroup()
                        .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(salaryjPanel2Layout.createSequentialGroup()
                                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wageHourlyRatejLabel5)
                                    .addComponent(wageOtherPayjLabel7))
                                .addGap(42, 42, 42)
                                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wageOtherpayjTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wageHourlyRatejTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryjPanel2Layout.createSequentialGroup()
                                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wageOtherPayjLabel8)
                                    .addComponent(wagedeductionyjLabel8))
                                .addGap(68, 68, 68)
                                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wageDeductionjTextField10)
                                    .addComponent(wageOtherpayjTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(salaryjPanel2Layout.createSequentialGroup()
                        .addComponent(wagedeductionyjLabel9)
                        .addGap(101, 101, 101)
                        .addComponent(wageTotalEarningjTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))))
            .addGroup(salaryjPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salaryjPanel2Layout.createSequentialGroup()
                        .addComponent(wageIdjLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salarEyemployeeIdjLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(wageEmployeeIdjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salaryjPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(wageCalculatejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(wageSavejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        salaryjPanel2Layout.setVerticalGroup(
            salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryjPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wageIdjLabel4)
                    .addComponent(wageEmployeeIdjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salarEyemployeeIdjLabel6))
                .addGap(44, 44, 44)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wageHourlyRatejLabel5)
                    .addComponent(wageHourlyRatejTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wageOtherPayjLabel7)
                    .addComponent(wageOtherpayjTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wageOtherPayjLabel8)
                    .addComponent(wageOtherpayjTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wagedeductionyjLabel8)
                    .addComponent(wageDeductionjTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wagedeductionyjLabel9)
                    .addComponent(wageTotalEarningjTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(salaryjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wageSavejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wageCalculatejButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        wageEmplyeejTable4.setForeground(new java.awt.Color(51, 51, 255));
        wageEmplyeejTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee ID", "Full Name", "Hourly Rate"
            }
        ));
        wageEmplyeejTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wageEmplyeejTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(wageEmplyeejTable4);

        javax.swing.GroupLayout wagejPanel2Layout = new javax.swing.GroupLayout(wagejPanel2);
        wagejPanel2.setLayout(wagejPanel2Layout);
        wagejPanel2Layout.setHorizontalGroup(
            wagejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wagejPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(salaryjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        wagejPanel2Layout.setVerticalGroup(
            wagejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wagejPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wagejPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salaryjPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        parrolljTabbedPane1.addTab("Wage", wagejPanel2);

        javax.swing.GroupLayout payrollPanelLayout = new javax.swing.GroupLayout(payrollPanel);
        payrollPanel.setLayout(payrollPanelLayout);
        payrollPanelLayout.setHorizontalGroup(
            payrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parrolljTabbedPane1)
        );
        payrollPanelLayout.setVerticalGroup(
            payrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parrolljTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        leavesPanel.setBackground(new java.awt.Color(255, 255, 255));
        leavesPanel.setPreferredSize(new java.awt.Dimension(830, 550));

        emplyeeLeavesjserachTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        leavesEmloyeeFirstNamejLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmloyeeFirstNamejLabel2.setText("Employee ID");

        leavesEmployeefirstnamejTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmployeefirstnamejTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        leavesEmployeefirstnamejTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        leavesEmployeefirstnamejTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leavesEmployeefirstnamejTextField2ActionPerformed(evt);
            }
        });

        leavesEmplyeejTable4.setForeground(new java.awt.Color(51, 51, 255));
        leavesEmplyeejTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
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
                "Employee ID", "Full Name"
            }
        ));
        leavesEmplyeejTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leavesEmplyeejTable4MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(leavesEmplyeejTable4);
        if (leavesEmplyeejTable4.getColumnModel().getColumnCount() > 0) {
            leavesEmplyeejTable4.getColumnModel().getColumn(0).setMinWidth(200);
            leavesEmplyeejTable4.getColumnModel().getColumn(0).setPreferredWidth(200);
            leavesEmplyeejTable4.getColumnModel().getColumn(0).setMaxWidth(200);
            leavesEmplyeejTable4.getColumnModel().getColumn(1).setMinWidth(200);
            leavesEmplyeejTable4.getColumnModel().getColumn(1).setPreferredWidth(200);
            leavesEmplyeejTable4.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        leaveEmployeeSearchjButton.setBackground(new java.awt.Color(204, 204, 204));
        leaveEmployeeSearchjButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leaveEmployeeSearchjButton.setText("Search");
        leaveEmployeeSearchjButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        leaveEmployeeSearchjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveEmployeeSearchjButtonActionPerformed(evt);
            }
        });

        leavesEmployeeNextjButton2.setBackground(new java.awt.Color(204, 204, 204));
        leavesEmployeeNextjButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmployeeNextjButton2.setText("NEXT");
        leavesEmployeeNextjButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        leavesEmployeeNextjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leavesEmployeeNextjButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(leavesEmloyeeFirstNamejLabel2)
                .addGap(50, 50, 50)
                .addComponent(leavesEmployeefirstnamejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(leaveEmployeeSearchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(leavesEmployeeNextjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(leavesEmployeeNextjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(leavesEmloyeeFirstNamejLabel2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(leavesEmployeefirstnamejTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(leaveEmployeeSearchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGap(23, 23, 23))
        );

        emplyeeLeavesjserachTabbedPane1.addTab("Serach Employee", jPanel1);

        leaveAplicationjPanel1.setBackground(new java.awt.Color(255, 255, 255));
        leaveAplicationjPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        leaveAplicationjPanel1.setName("Leave application"); // NOI18N

        leavesEmloyeeFirstNamejLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmloyeeFirstNamejLabel3.setText("From Date");

        leavesEmloyeeFirstNamejLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmloyeeFirstNamejLabel4.setText("End Date");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        leavesEmloyeeFirstNamejLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmloyeeFirstNamejLabel5.setText("Reson Type");

        leavesEmloyeeFirstNamejLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmloyeeFirstNamejLabel6.setText("Reson");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select the type", "Full day", "Half day", "1st half", "2nd half" }));

        saveEmployeejButton2.setBackground(new java.awt.Color(204, 204, 204));
        saveEmployeejButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveEmployeejButton2.setText("SAVE");
        saveEmployeejButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        saveEmployeejButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmployeejButton2ActionPerformed(evt);
            }
        });

        datePickerPanal1.setBackground(new java.awt.Color(255, 255, 255));

        leaveApplicationFromDateDateChooser1.setBackground(new java.awt.Color(204, 204, 204));
        leaveApplicationFromDateDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout datePickerPanal1Layout = new javax.swing.GroupLayout(datePickerPanal1);
        datePickerPanal1.setLayout(datePickerPanal1Layout);
        datePickerPanal1Layout.setHorizontalGroup(
            datePickerPanal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePickerPanal1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leaveApplicationFromDateDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datePickerPanal1Layout.setVerticalGroup(
            datePickerPanal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePickerPanal1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leaveApplicationFromDateDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datePickerPanal2.setBackground(new java.awt.Color(255, 255, 255));

        leaveApplicationEndDateDateChooser1.setBackground(new java.awt.Color(204, 204, 204));
        leaveApplicationEndDateDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout datePickerPanal2Layout = new javax.swing.GroupLayout(datePickerPanal2);
        datePickerPanal2.setLayout(datePickerPanal2Layout);
        datePickerPanal2Layout.setHorizontalGroup(
            datePickerPanal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePickerPanal2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leaveApplicationEndDateDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        datePickerPanal2Layout.setVerticalGroup(
            datePickerPanal2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datePickerPanal2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(leaveApplicationEndDateDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        leavesEmloyeeFirstNamejLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavesEmloyeeFirstNamejLabel7.setText("Employee ID");

        leaveEmployeeBackjButton1.setBackground(new java.awt.Color(204, 204, 204));
        leaveEmployeeBackjButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leaveEmployeeBackjButton1.setText("BACK");
        leaveEmployeeBackjButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        leaveEmployeeBackjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveEmployeeBackjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leaveAplicationjPanel1Layout = new javax.swing.GroupLayout(leaveAplicationjPanel1);
        leaveAplicationjPanel1.setLayout(leaveAplicationjPanel1Layout);
        leaveAplicationjPanel1Layout.setHorizontalGroup(
            leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                        .addComponent(leavesEmloyeeFirstNamejLabel5)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                        .addComponent(leavesEmloyeeFirstNamejLabel3)
                        .addGap(50, 50, 50)
                        .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                                .addComponent(datePickerPanal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(leavesEmloyeeFirstNamejLabel4)
                                .addGap(34, 34, 34)
                                .addComponent(datePickerPanal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
                            .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(224, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leaveAplicationjPanel1Layout.createSequentialGroup()
                .addContainerGap(490, Short.MAX_VALUE)
                .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leaveAplicationjPanel1Layout.createSequentialGroup()
                        .addComponent(leaveEmployeeBackjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveEmployeejButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leaveAplicationjPanel1Layout.createSequentialGroup()
                        .addComponent(leavesEmloyeeFirstNamejLabel7)
                        .addGap(76, 76, 76)
                        .addComponent(leavesEmployeeIDjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(leavesEmloyeeFirstNamejLabel6)
                    .addContainerGap(724, Short.MAX_VALUE)))
        );
        leaveAplicationjPanel1Layout.setVerticalGroup(
            leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leavesEmployeeIDjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leavesEmloyeeFirstNamejLabel7))
                        .addGap(119, 119, 119)
                        .addComponent(datePickerPanal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leavesEmloyeeFirstNamejLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(leavesEmloyeeFirstNamejLabel3)
                                    .addComponent(leavesEmloyeeFirstNamejLabel4)))
                            .addGroup(leaveAplicationjPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(datePickerPanal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(86, 86, 86)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveEmployeejButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaveEmployeeBackjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(leaveAplicationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leaveAplicationjPanel1Layout.createSequentialGroup()
                    .addContainerGap(294, Short.MAX_VALUE)
                    .addComponent(leavesEmloyeeFirstNamejLabel6)
                    .addGap(208, 208, 208)))
        );

        emplyeeLeavesjserachTabbedPane1.addTab("Leave application", leaveAplicationjPanel1);

        javax.swing.GroupLayout leavesjPanel1Layout = new javax.swing.GroupLayout(leavesjPanel1);
        leavesjPanel1.setLayout(leavesjPanel1Layout);
        leavesjPanel1Layout.setHorizontalGroup(
            leavesjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emplyeeLeavesjserachTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        leavesjPanel1Layout.setVerticalGroup(
            leavesjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emplyeeLeavesjserachTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout leavesPanelLayout = new javax.swing.GroupLayout(leavesPanel);
        leavesPanel.setLayout(leavesPanelLayout);
        leavesPanelLayout.setHorizontalGroup(
            leavesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leavesjPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leavesPanelLayout.setVerticalGroup(
            leavesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leavesjPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        reportsPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportsPanel.setPreferredSize(new java.awt.Dimension(830, 550));

        javax.swing.GroupLayout reportsPanelLayout = new javax.swing.GroupLayout(reportsPanel);
        reportsPanel.setLayout(reportsPanelLayout);
        reportsPanelLayout.setHorizontalGroup(
            reportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        reportsPanelLayout.setVerticalGroup(
            reportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout togglePanelsLayout = new javax.swing.GroupLayout(togglePanels);
        togglePanels.setLayout(togglePanelsLayout);
        togglePanelsLayout.setHorizontalGroup(
            togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(togglePanelsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(togglePanelsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(leavesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reportsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(payrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        togglePanelsLayout.setVerticalGroup(
            togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(togglePanelsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(togglePanelsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(leavesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reportsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(payrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        HRManagerPanel.add(togglePanels);
        togglePanels.setBounds(192, 135, 832, 552);

        headerPanel.setBackground(new java.awt.Color(0, 51, 51));
        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));
        headerPanel.setLayout(null);

        welcomeuser.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        welcomeuser.setForeground(new java.awt.Color(240, 240, 240));
        welcomeuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeuser.setText("Name");
        headerPanel.add(welcomeuser);
        welcomeuser.setBounds(420, 60, 170, 20);

        welcomeuser1.setFont(new java.awt.Font("Monotype Corsiva", 3, 36)); // NOI18N
        welcomeuser1.setForeground(new java.awt.Color(240, 240, 240));
        welcomeuser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeuser1.setText("WELCOME ");
        headerPanel.add(welcomeuser1);
        welcomeuser1.setBounds(370, 10, 270, 30);

        Time.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        Time.setForeground(new java.awt.Color(240, 240, 240));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setText("Time");
        headerPanel.add(Time);
        Time.setBounds(190, 90, 170, 30);

        dates.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        dates.setForeground(new java.awt.Color(240, 240, 240));
        dates.setText("date");
        headerPanel.add(dates);
        dates.setBounds(640, 90, 210, 30);

        day.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        day.setForeground(new java.awt.Color(240, 240, 240));
        day.setText("Day");
        headerPanel.add(day);
        day.setBounds(450, 90, 140, 30);

        buttonLogOut.setBackground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(51, 153, 255));
        buttonLogOut.setText("Log Out");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });
        headerPanel.add(buttonLogOut);
        buttonLogOut.setBounds(887, 80, 100, 33);

        HRManagerPanel.add(headerPanel);
        headerPanel.setBounds(0, 0, 1020, 130);

        jDesktopPaneFinance.add(HRManagerPanel);
        HRManagerPanel.setBounds(0, 0, 1024, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneFinance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneFinance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReportsActionPerformed
        // TODO add your handling code here:  
//      searchEmployeeTableLoad();
//      salaryTableLoad();
//      wageTableLoad();
//      leaveTableLoad();
        panelshift(buttonReports.getText());
    }//GEN-LAST:event_buttonReportsActionPerformed

    private void buttonAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmployeeActionPerformed
        // TODO add your handling code here:
          
//      searchEmployeeTableLoad();
//      salaryTableLoad();
//      wageTableLoad();
//      leaveTableLoad();
        panelshift(buttonAddEmployee.getText());
    }//GEN-LAST:event_buttonAddEmployeeActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // TODO add your handling code here:
        panelshift(buttonSearch.getText());
          
//      searchEmployeeTableLoad();
//      salaryTableLoad();
//      wageTableLoad();
//      leaveTableLoad();
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonPayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPayrollActionPerformed
        // TODO add your handling code here:
          
//      searchEmployeeTableLoad();
//      salaryTableLoad();
//      wageTableLoad();
//      leaveTableLoad();
        panelshift(buttonPayroll.getText());
    }//GEN-LAST:event_buttonPayrollActionPerformed

    private void buttonAssestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAssestsActionPerformed
        // TODO add your handling code here:  
//      searchEmployeeTableLoad();
//      salaryTableLoad();
//      wageTableLoad();
//      leaveTableLoad();
        panelshift(buttonAssests.getText());
    }//GEN-LAST:event_buttonAssestsActionPerformed

    private void buttonAddEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddEmployeeMouseEntered
        // TODO add your handling code here: 
        buttonAddEmployee.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonAddEmployeeMouseEntered

    private void buttonAddEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddEmployeeMouseExited
        // TODO add your handling code here:
        buttonAddEmployee.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_buttonAddEmployeeMouseExited

    private void buttonSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseEntered
        // TODO add your handling code here:
        buttonSearch.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonSearchMouseEntered

    private void buttonSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseExited
        // TODO add your handling code here:
        buttonSearch.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_buttonSearchMouseExited

    private void buttonPayrollMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPayrollMouseEntered
        // TODO add your handling code here:
        buttonPayroll.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonPayrollMouseEntered

    private void buttonPayrollMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPayrollMouseExited
        // TODO add your handling code here:
        buttonPayroll.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_buttonPayrollMouseExited

    private void buttonAssestsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAssestsMouseEntered
        // TODO add your handling code here:
        buttonAssests.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonAssestsMouseEntered

    private void buttonAssestsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAssestsMouseExited
        // TODO add your handling code here:
        buttonAssests.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_buttonAssestsMouseExited

    private void buttonReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReportsMouseEntered
        // TODO add your handling code here:
        buttonReports.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonReportsMouseEntered

    private void buttonReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReportsMouseExited
        // TODO add your handling code here:
        buttonReports.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_buttonReportsMouseExited

    private void employeeSearchjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSearchjButton1ActionPerformed
        
        
            searchFname =employeeSearchFirstNamejTextField1.getText();
               
                
       if(  searchFname.isEmpty())
           employeeSearchFirstNamejTextField1.setBackground(new Color(255, 150, 150));
       else
           employeeSearchFirstNamejTextField1.setBackground(new Color(255, 255, 255));
       
       if(  searchFname.isEmpty())
           JOptionPane.showMessageDialog(personalDetailsjPanel1, "Please fill search field to continue.", "Form Incomplete!", 0);
       
       
            
         else{ 
               
            try {
                               
                
                String Sql="select employee_id AS 'Employee ID', CONCAT(employee_fname, ' ', employee_lname)AS 'FullName',employee_nic AS 'NIC',employee_telephone AS 'Telephone',employee_address AS 'Address',employee_sex AS 'Gender',employee_DOB AS 'Date of Birth',employee_designation AS 'Designation',employee_type AS 'Type OF Employee',employee_hourly_rate AS 'Hourly Rate',employee_basic_salary AS 'Basic Salary',employee_department AS 'Department' from hr_employee where employee_id = '"+ searchFname +"'";
                pstatement = conn.prepareStatement(Sql);
                Results=pstatement.executeQuery();
                searchjTable6.setModel(DbUtils.resultSetToTableModel(Results));

            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,e);

            }
           
          
        }   
    }//GEN-LAST:event_employeeSearchjButton1ActionPerformed

    private void employeeEditjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeEditjButtonActionPerformed
        // TODO add your handling code here:
        int x= JOptionPane.showConfirmDialog(null,"Do you want to edit details ?");
        
        if(x == 0){
        editEmplyoeejTabbedPane1.setEnabledAt(0,false);
        editEmplyoeejTabbedPane1.setSelectedIndex(1);
        editEmplyoeejTabbedPane1.setEnabledAt(1, true);
        
       
        
        editEmployeefirstnamejTextField2.setText(upadteFName);
        editEmployeeNicjTextField3.setText(updateNIC);
        editEmployeeAddjTextField3.setText(updateAddress);
        editEmployeeIdjTextField4.setText(updateDesignation);
        editTypeOfEmployeejComboBox2.setSelectedItem(updateTypeOfEmployee);
        editEmployeeTpjTextField4.setText( UpdateTep);
        editDepatrmentjComboBox2.setSelectedItem(updateDepartment);
        editBasicSalaryjTextField6.setText(updateBasicSalary);
        editHourlyRatejTextField3.setText(updateHourlyRate);
        }
        
        
            
    }//GEN-LAST:event_employeeEditjButtonActionPerformed

    private void editEmployeefirstnamejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeefirstnamejTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEmployeefirstnamejTextField2ActionPerformed

    private void saveEmployeejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEmployeejButton1ActionPerformed
            
           upadteFName=editEmployeefirstnamejTextField2.getText();
           updateNIC=editEmployeeNicjTextField3.getText();
           updateAddress=editEmployeeAddjTextField3.getText();
           updateDesignation=editEmployeeIdjTextField4.getText();
           updateDepartment=editDepatrmentjComboBox2.getSelectedItem().toString();
           updateTypeOfEmployee=editTypeOfEmployeejComboBox2.getSelectedItem().toString();
           UpdateTep=editEmployeeTpjTextField4.getText();
           updateBasicSalary=editBasicSalaryjTextField6.getText();
           updateHourlyRate=editHourlyRatejTextField3.getText();
           
           
                            try {

                                String sql="UPDATE hr_employee SET employee_nic='"+updateNIC+"',employee_address='"+updateAddress+"',employee_designation='"+updateDesignation+"',employee_type='"+updateTypeOfEmployee+"',employee_telephone='"+UpdateTep+"',employee_department='"+updateDepartment+"',employee_basic_salary='"+ updateBasicSalary+"',employee_hourly_rate='"+updateHourlyRate+"' WHERE employee_id='"+empID+"'";
                                pstatement=conn.prepareStatement(sql);
                                pstatement.execute();
                                JOptionPane.showMessageDialog(null,"Database Update Succesfully!! ");

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,e);

                        }
             
             
           editEmployeefirstnamejTextField2.setText("");
           editEmployeeNicjTextField3.setText("");
           editEmployeeAddjTextField3.setText("");
           editEmployeeIdjTextField4.setText("");
           editDepatrmentjComboBox2.setSelectedItem("Select the Department");
           editTypeOfEmployeejComboBox2.setSelectedItem("Select the type");
           editEmployeeTpjTextField4.setText("");
           editBasicSalaryjTextField6.setText("");
           editHourlyRatejTextField3.setText("");
        
             
        
        
    }//GEN-LAST:event_saveEmployeejButton1ActionPerformed

    private void hourlyRatejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourlyRatejTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourlyRatejTextField2ActionPerformed

    private void employeefirstnamejTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeefirstnamejTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeefirstnamejTextField1ActionPerformed

    private void editBasicSalaryjTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBasicSalaryjTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBasicSalaryjTextField6ActionPerformed

    private void employeeSearchFirstNamejTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSearchFirstNamejTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeSearchFirstNamejTextField1ActionPerformed

    private void AddEmployeeNextjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmployeeNextjButton1ActionPerformed
        // get values and assing into veriables
        
        eFname=employeefirstnamejTextField1.getText();
        eLname=employeeLNamejTextField2.getText();
        eNic=employeeNicjTextField2.getText();
        eTep=employeeTpjTextField3.getText();
        eAdd=employeeAddjTextField2.getText();
        
        
        
        
       if(addEmployeeSexMalejRadioButton1.isSelected()){
            eSex=addEmployeeSexMalejRadioButton1.getText();
           }
        if(addEmployeeSexFemalejRadioButton2.isSelected())
        {
            eSex=addEmployeeSexFemalejRadioButton2.getText();
        
        }
        edesignation=adEemployeeDesignationjTextField2.getText();
        
        etype = typeOfEmployeejComboBox1.getSelectedItem().toString();
        
        if(typeOfEmployeejComboBox1.getSelectedItem()=="Permanent Employee")
        {
            
            hourlyrateDayjLabel3.setVisible(false);
            hourlyRatejTextField2.setVisible(false);
            
             besicSalaryjLabel2.setVisible(true);
             basicSalaryjTextField2.setVisible(true);
             DepartmentjLabel1.setVisible(true);
             depatrmentjComboBox1.setVisible(true);
        }
        
         if(typeOfEmployeejComboBox1.getSelectedItem()=="Part Time Employee")
         {
             hourlyRatejTextField2.setVisible(true);
             hourlyrateDayjLabel3.setVisible(true);
             
             besicSalaryjLabel2.setVisible(false);
             basicSalaryjTextField2.setVisible(false);
             DepartmentjLabel1.setVisible(false);
             depatrmentjComboBox1.setVisible(false);
             
         
         }
        
          
         
        
        if(eFname.isEmpty())
            employeefirstnamejTextField1.setBackground(new Color(255, 150, 150));
        else
            employeefirstnamejTextField1.setBackground(new Color(255, 255, 255));
               
        if(eLname.isEmpty())
            employeeLNamejTextField2.setBackground(new Color(255, 150, 150));
        else
            employeeLNamejTextField2.setBackground(new Color(255, 255, 255));
        if(eNic.isEmpty())
            employeeNicjTextField2.setBackground(new Color(255, 150, 150));
        else
            employeeNicjTextField2.setBackground(new Color(255, 255, 255));
        if(eAdd.isEmpty())
            employeeAddjTextField2.setBackground(new Color(255, 150, 150));
        else
            employeeAddjTextField2.setBackground(new Color(255, 255, 255));
         
        if( eTep.isEmpty())
            
            employeeTpjTextField3.setBackground(new Color(255, 150, 150));
        else
        
             employeeTpjTextField3.setBackground(new Color(255, 255, 255));
        
        if(edesignation.isEmpty())
            
            adEemployeeDesignationjTextField2.setBackground(new Color(255, 150, 150));
        else
            
            adEemployeeDesignationjTextField2.setBackground(new Color(255, 255, 255));
        
        if(edob.isEmpty())
            addEmployeeDOBjDateChooser1.setBackground(new Color(255, 150, 150));
        
        else
            addEmployeeDOBjDateChooser1.setBackground(new Color(255, 255, 255));
        
        if(typeOfEmployeejComboBox1.getSelectedItem()=="Select the type")
        
            typeOfEmployeejComboBox1.setBackground(new Color(255, 150, 150));
        
       
        
        
        
        else{
      
       
        addEmployeejTabbedPane1.setEnabledAt(0,false);
        addEmployeejTabbedPane1.setSelectedIndex(1);
        addEmployeejTabbedPane1.setEnabledAt(1, true);
      
        }
    }//GEN-LAST:event_AddEmployeeNextjButton1ActionPerformed
        
 
    
    
    
    
    
    private void addEmployeeBackjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeBackjButtonActionPerformed
        // TODO add your handling code here:
        addEmployeejTabbedPane1.setEnabledAt(1,false);
        addEmployeejTabbedPane1.setSelectedIndex(0);
        addEmployeejTabbedPane1.setEnabledAt(0, true);
    }//GEN-LAST:event_addEmployeeBackjButtonActionPerformed

    private void addEmployeeAddjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeAddjButton1ActionPerformed
        // TODO add your handling code here:
        eDepatment=depatrmentjComboBox1.getSelectedItem().toString();
        eBasicSalry=basicSalaryjTextField2.getText();
        eHourlyRate=hourlyRatejTextField2.getText();
         
        
        
            
        
                try {

                        String sql="INSERT INTO hr_employee (employee_fname,employee_lname,employee_nic,employee_telephone,employee_address,employee_sex,employee_DOB,employee_designation,employee_type,employee_hourly_rate,employee_basic_salary,employee_department) VALUES ('"+eFname+"','"+eLname+"','"+eNic+"','"+eTep+"','"+eAdd+"','"+eSex+"','"+edob+"','"+edesignation+"','"+etype+"','"+eHourlyRate+"','"+eBasicSalry+"','"+eDepatment+"')";
                        pstatement=conn.prepareStatement(sql);
                        pstatement.execute();
                        JOptionPane.showMessageDialog(null,"Succesfully Added to database");
                        //rest the values
                        employeefirstnamejTextField1.setText("");
                        employeeLNamejTextField2.setText("");
                        employeeNicjTextField2.setText("");
                        employeeTpjTextField3.setText("");
                        employeeAddjTextField2.setText("");
                        addEmployeeSexbuttonGroup.clearSelection();
                        adEemployeeDesignationjTextField2.setText("");
                        typeOfEmployeejComboBox1.setSelectedItem("Select the type");
                        hourlyRatejTextField2.setText("");
                        depatrmentjComboBox1.setSelectedItem("Select the Department");
                        basicSalaryjTextField2.setText("");
                        addEmployeeDOBjDateChooser1.setDate(null);
                        salaryTableLoad();
                        
                        

                        
                    }

                catch (Exception e) {
                        e.printStackTrace();
                    }
        

                    searchEmployeeTableLoad();
                    salaryTableLoad();
                    wageTableLoad();

        
    }//GEN-LAST:event_addEmployeeAddjButton1ActionPerformed

    private void searchjTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchjTable6MouseClicked
        // TODO add your handling code here:
        try {
             int row =searchjTable6.getSelectedRow();
                       
        empID=searchjTable6.getValueAt(row, 0).toString();
        upadteFName = searchjTable6.getValueAt(row,1).toString();//Can edit
        updateNIC = searchjTable6.getValueAt(row,2).toString();//Can edit
        UpdateTep= searchjTable6.getValueAt(row,3).toString();//Can edit
        updateAddress=searchjTable6.getValueAt(row,4).toString();//can edit
        updateGender=searchjTable6.getValueAt(row,5).toString();
        updateBOD=searchjTable6.getValueAt(row,6).toString();        
        updateDesignation=searchjTable6.getValueAt(row,7).toString();//can edit       
        updateTypeOfEmployee=searchjTable6.getValueAt(row,8).toString();//can edit
        updateHourlyRate=searchjTable6.getValueAt(row,9).toString();//can edit
        updateBasicSalary=searchjTable6.getValueAt(row,10).toString();//can edit
        updateDepartment=searchjTable6.getValueAt(row,11).toString();// can edit
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
         employeeEditjButton.setEnabled(true);
         employeeDeletejButton2.setEnabled(true);
         employeeSearchFirstNamejTextField1.setBackground(new Color(255, 255, 255));
  
        
    }//GEN-LAST:event_searchjTable6MouseClicked

    private void basicSalaryjTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicSalaryjTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basicSalaryjTextField6ActionPerformed

    private void salaryOtherpayjTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryOtherpayjTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryOtherpayjTextField7ActionPerformed

    private void salaryDeductionjTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryDeductionjTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryDeductionjTextField10ActionPerformed

    private void salaryTotalEarningjTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTotalEarningjTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTotalEarningjTextField8ActionPerformed

    private void salaryCalculatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryCalculatejButtonActionPerformed
        // TODO add your handling code here:
        basicSalary=basicSalaryjTextField6.getText();
        otherPay=salaryOtherpayjTextField7.getText();
        deduc=salaryDeductionjTextField10.getText();
        
        if(otherPay.isEmpty())
            salaryOtherpayjTextField7.setBackground(new Color(255, 150, 150));
        else
            salaryOtherpayjTextField7.setBackground(new Color(255,255,255));
        
        if(deduc.isEmpty())
            salaryDeductionjTextField10.setBackground(new Color(250,150,150));
        else
            salaryDeductionjTextField10.setBackground(new Color(250,250,250));
        
        if(otherPay.isEmpty()||deduc.isEmpty())
             JOptionPane.showMessageDialog(salaryjPanel1, "Please fill all the fields to continue.", "Form Incomplete!", 0);
            
        
        
        else{
        double basicSal=Double.parseDouble(basicSalary);
        double otherPayment=Double.parseDouble(otherPay);
        double deduction=Double.parseDouble(deduc);
        
        double total=((basicSal+otherPayment)-deduction);
        
        String Total=Double.toString(total);
        salaryTotalEarningjTextField8.setText(Total);
        }
        
    }//GEN-LAST:event_salaryCalculatejButtonActionPerformed

    private void wageHourlyRatejTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wageHourlyRatejTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wageHourlyRatejTextField6ActionPerformed

    private void wageOtherpayjTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wageOtherpayjTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wageOtherpayjTextField7ActionPerformed

    private void wageOtherpayjTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wageOtherpayjTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wageOtherpayjTextField8ActionPerformed

    private void wageDeductionjTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wageDeductionjTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wageDeductionjTextField10ActionPerformed

    private void wageSavejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wageSavejButtonActionPerformed
        // TODO add your handling code here:
        
     wageWorkedHours=wageOtherpayjTextField7.getText();
     wagededuc=wageDeductionjTextField10.getText();
     wageOtherpay=wageOtherpayjTextField8.getText();
     wageTotal=wageTotalEarningjTextField8.getText();
     getWageEmpID=wageEmployeeIdjTextField2.getText();
              
    try {
            
            String sql="INSERT INTO hr_wage (wage_hours_worked, wage_deduction, wage_total, wage_other_pay, wage_status, wage_emp_id) VALUES ('"+wageWorkedHours+"','"+wagededuc+"','"+wageTotal+"','"+wageOtherpay+"','calculate','"+getWageEmpID+"')";
            pstatement=conn.prepareStatement(sql);
            pstatement.execute();
            JOptionPane.showMessageDialog(null,"Succesfully Added to database");
            wageTableLoad();
            
            
                    
        }
    
    catch (Exception e) {
            JOptionPane.showMessageDialog(wagejPanel2, "Salary already calculated", "Error", JOptionPane.ERROR_MESSAGE);
        }
 
        
        
    }//GEN-LAST:event_wageSavejButtonActionPerformed

    private void wageTotalEarningjTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wageTotalEarningjTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wageTotalEarningjTextField8ActionPerformed

    private void editEmployeeBackjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeBackjButton1ActionPerformed
        // TODO add your handling code here:
        editEmplyoeejTabbedPane1.setEnabledAt(1,false);
        editEmplyoeejTabbedPane1.setSelectedIndex(0);
        editEmplyoeejTabbedPane1.setEnabledAt(0, true);
        
        
        employeeDeletejButton2.setEnabled(false);
        employeeEditjButton.setEnabled(false);
        searchEmployeeTableLoad();
        
        
    }//GEN-LAST:event_editEmployeeBackjButton1ActionPerformed

    private void employeeDeletejButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeDeletejButton2ActionPerformed
        // TODO add your handling code here:
        
         int x= JOptionPane.showConfirmDialog(null,"Do you want to delete details ?");
        
        if(x == 0){
            
            try {
                String sql="DELETE FROM hr_employee where employee_id='"+empID+"'";
                pstatement=conn.prepareStatement(sql);
                pstatement.execute();
                JOptionPane.showMessageDialog(null,"Succesfully deleted from database");
                
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
            searchEmployeeTableLoad();
        
        employeeSearchFirstNamejTextField1.setText("");
        employeeDeletejButton2.setEnabled(false);
        employeeEditjButton.setEnabled(false);
        
        
        }   
    }//GEN-LAST:event_employeeDeletejButton2ActionPerformed

    private void salarySavejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarySavejButton1ActionPerformed
        // TODO add your handling code here:
     basicSalary=basicSalaryjTextField6.getText();
     otherPay=salaryOtherpayjTextField7.getText();
     deduc=salaryDeductionjTextField10.getText();
     Total=salaryTotalEarningjTextField8.getText();
     getEmpID=salaryEmployeeIdjTextField1.getText();
              
    try {
            
            String sql="INSERT INTO hr_salary (salary_other_pay,salary_deduction,salary_emp_id,salary_total,salary_status) VALUES ('"+otherPay+"','"+deduc+"','"+getEmpID+"','"+Total+"','Calculate')";
            pstatement=conn.prepareStatement(sql);
            pstatement.execute();
            JOptionPane.showMessageDialog(null,"Succesfully Added to database");
             
            
        }
    
    catch (Exception e) {
             JOptionPane.showMessageDialog(salaryjPanel1, "Salary already calculated", "Error", JOptionPane.ERROR_MESSAGE);
        }
     basicSalaryjTextField6.setText("");
     salaryOtherpayjTextField7.setText("");
     salaryDeductionjTextField10.setText("");
     salaryTotalEarningjTextField8.setText("");
     salaryEmployeeIdjTextField1.setText("");
     salaryTableLoad();
     

        
        
        
    }//GEN-LAST:event_salarySavejButton1ActionPerformed

    private void salaryEmplyeejTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salaryEmplyeejTable3MouseClicked
        // TODO add your handling code here:
        
        int row =salaryEmplyeejTable3.getSelectedRow();
             
        salaryEmpId=salaryEmplyeejTable3.getValueAt(row, 0).toString();
        salaryFullName = salaryEmplyeejTable3.getValueAt(row,1).toString();
        salaryBasicSalary=salaryEmplyeejTable3.getValueAt(row,2).toString();
        
        basicSalaryjTextField6.setText(salaryBasicSalary);
        salaryEmployeeIdjTextField1.setText(salaryEmpId);
        
    }//GEN-LAST:event_salaryEmplyeejTable3MouseClicked

    private void wageEmplyeejTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wageEmplyeejTable4MouseClicked
        // TODO add your handling code here:
         int row =wageEmplyeejTable4.getSelectedRow();
         
        wageEmpId=wageEmplyeejTable4.getValueAt(row, 0).toString();
        wageFullNAme = wageEmplyeejTable4.getValueAt(row,1).toString();
        wageHourlyRate=wageEmplyeejTable4.getValueAt(row,2).toString();
        
        wageHourlyRatejTextField6.setText(wageHourlyRate);
        wageEmployeeIdjTextField2.setText(wageEmpId);
        
        
    }//GEN-LAST:event_wageEmplyeejTable4MouseClicked

    private void wageCalculatejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wageCalculatejButton1ActionPerformed
        // TODO add your handling code here:
        
     wageHourlyRate=wageHourlyRatejTextField6.getText();
     wagededuc=wageDeductionjTextField10.getText();
     wageOtherpay=wageOtherpayjTextField8.getText();
     wageWorkedHours=wageOtherpayjTextField7.getText();
     
     if(wageWorkedHours.isEmpty())
         wageOtherpayjTextField7.setBackground(new Color(255, 150, 150));
     else
         wageOtherpayjTextField7.setBackground(new Color(255,255,255));
     
     if(wagededuc.isEmpty())
         wageDeductionjTextField10.setBackground(new Color(255, 150, 150));
     else
         wageDeductionjTextField10.setBackground(new Color(255, 255, 255));
     if(wageOtherpay.isEmpty())
         wageOtherpayjTextField8.setBackground(new Color(255, 150, 150));
     else
        wageOtherpayjTextField8.setBackground(new Color(255, 255, 255));
     
     if(wageWorkedHours.isEmpty()||wagededuc.isEmpty()||wageOtherpay.isEmpty())
         JOptionPane.showMessageDialog(wagejPanel2, "Please fill all the fields to continue.", "Form Incomplete!", 0);
     
     
     else{
         
         
        int workedHours= Integer.parseInt(wageWorkedHours);
        double hourlyrate=Double.parseDouble(wageHourlyRate);
        double otherPayment=Double.parseDouble(wageOtherpay);
        double deduction=Double.parseDouble(wagededuc);
        
        double total=(((hourlyrate*workedHours)+otherPayment)-deduction);
        
        String Total=Double.toString(total);
        wageTotalEarningjTextField8.setText(Total);
        
     }
        
    }//GEN-LAST:event_wageCalculatejButton1ActionPerformed

    private void basicSalaryjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicSalaryjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basicSalaryjTextField2ActionPerformed

    private void leavesEmployeefirstnamejTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavesEmployeefirstnamejTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leavesEmployeefirstnamejTextField2ActionPerformed

    private void saveEmployeejButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEmployeejButton2ActionPerformed
        // TODO add your handling code here:
        
        leavesEmpID=leavesEmployeeIDjTextField1.getText();
        leavesReson=jComboBox1.getSelectedItem().toString();
        
        
        boolean hasParseError1;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            leavesStartDate = dateFormat.format(leaveApplicationFromDateDateChooser1.getDate());
            hasParseError1=false;
        
        } catch (Exception e) {
           
           hasParseError1=true;
           
        }
        
        boolean hasParseError2;
         try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            leavesEndDate = dateFormat.format(leaveApplicationEndDateDateChooser1.getDate());
            hasParseError2=false;
        
        } catch (Exception e) {
           
           hasParseError2=true;
           
        }
        
         leavesReson=jTextArea1.getText();
        
                 
         if(jComboBox1.getSelectedItem()=="Select the type")
             jComboBox1.setBackground(new Color(255, 150, 150));
         else
             jComboBox1.setBackground(new Color(255, 255, 255));
         
         if(leavesReson.isEmpty())
            jTextArea1.setBackground(new Color(255, 150, 150));
         else
             jTextArea1.setBackground(new Color(255, 255, 255));
         
         if(hasParseError1==true)
             datePickerPanal1.setBackground(new Color(255, 150, 150));
         else
              datePickerPanal1.setBackground(new Color(255, 255, 255));
         
         if(hasParseError2==true)
             datePickerPanal2.setBackground(new Color(255, 150, 150));
         else
              datePickerPanal2.setBackground(new Color(255, 255, 255));
         
         if(jComboBox1.getSelectedItem()=="Select the type"||leavesReson.isEmpty()||hasParseError1==true||hasParseError2==true)
            JOptionPane.showMessageDialog(leaveAplicationjPanel1, "Please fill all the fields to continue.", "Form Incomplete!", 0);
             
        
         
       else
         {
             try {
                 
                 String sql="INSERT INTO hr_leaves (leaves_from_date,leaves_end_date,leaves_resson,leaves_status,leaves_employee_id) VALUES ('"+leavesStartDate+"','"+leavesEndDate+"','"+leavesReson+"','Pending','"+leavesEmpID+"')";
                 pstatement=conn.prepareStatement(sql);
                 pstatement.execute();
                 JOptionPane.showMessageDialog(null,"Succesfully Added to database");
                 
                 leavesEmployeeIDjTextField1.setText("");
                 jComboBox1.setSelectedItem("Select the type");
                 leaveApplicationFromDateDateChooser1.setDate(null);
                 leaveApplicationEndDateDateChooser1.setDate(null);
                 jTextArea1.setText("");
                 
                 
                
                 
                 
                 
                 
             } catch (Exception e) {
                  JOptionPane.showMessageDialog(null,e);
             }
        
         
         }

    }//GEN-LAST:event_saveEmployeejButton2ActionPerformed

    private void leavesEmplyeejTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leavesEmplyeejTable4MouseClicked
        // TODO add your handling code here:
         int row =leavesEmplyeejTable4.getSelectedRow();
             
        leavesEmpID=searchjTable6.getValueAt(row, 0).toString();
        leavesFullName = searchjTable6.getValueAt(row,1).toString();
        
        leavesEmployeeNextjButton2.setEnabled(true);
        
        
        
        
    }//GEN-LAST:event_leavesEmplyeejTable4MouseClicked

    private void leaveEmployeeSearchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveEmployeeSearchjButtonActionPerformed
        // TODO add your handling code here:
      leavesFullName=leavesEmployeefirstnamejTextField2.getText();
      
      if(leavesFullName.isEmpty())
          leavesEmployeefirstnamejTextField2.setBackground(new Color(255, 150, 150));
      else
           leavesEmployeefirstnamejTextField2.setBackground(new Color(255, 255, 255));
          
     
      
          try {
              String Sql="select employee_id AS 'Employee ID', CONCAT(employee_fname, ' ', employee_lname)AS 'FullName'From hr_employee where employee_id = '"+ leavesFullName +"'";
              pstatement = conn.prepareStatement(Sql);
              Results=pstatement.executeQuery();
              leavesEmplyeejTable4.setModel(DbUtils.resultSetToTableModel(Results));
          } catch (Exception e) {
              e.printStackTrace();
          }
           
      
      
        
        
        
    }//GEN-LAST:event_leaveEmployeeSearchjButtonActionPerformed

    private void leavesEmployeeNextjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavesEmployeeNextjButton2ActionPerformed
        // TODO add your handling code here:
        emplyeeLeavesjserachTabbedPane1.setEnabledAt(0,false);
        emplyeeLeavesjserachTabbedPane1.setSelectedIndex(1);
        emplyeeLeavesjserachTabbedPane1.setEnabledAt(1, true);
        
        leavesEmployeeIDjTextField1.setText(leavesEmpID);
        
        
    }//GEN-LAST:event_leavesEmployeeNextjButton2ActionPerformed

    private void leaveEmployeeBackjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveEmployeeBackjButton1ActionPerformed
        // TODO add your handling code here:
        emplyeeLeavesjserachTabbedPane1.setEnabledAt(1,false);
        emplyeeLeavesjserachTabbedPane1.setSelectedIndex(0);
        emplyeeLeavesjserachTabbedPane1.setEnabledAt(0, true);
        
        
    }//GEN-LAST:event_leaveEmployeeBackjButton1ActionPerformed

    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        int result=JOptionPane.showConfirmDialog(rootPane, "Do You Want to LogOut");
        if(result==0){

            login login=new login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_buttonLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(Hr_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hr_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hr_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hr_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hr_Manager(USER).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton AddEmployeeNextjButton1;
    javax.swing.JLabel DepartmentjLabel1;
    javax.swing.JPanel HRManagerPanel;
    javax.swing.JLabel SalaryIdjLabel4;
    javax.swing.JLabel Time;
    javax.swing.JTextField adEemployeeDesignationjTextField2;
    javax.swing.JButton addEmployeeAddjButton1;
    javax.swing.JButton addEmployeeBackjButton;
    com.toedter.calendar.JDateChooser addEmployeeDOBjDateChooser1;
    javax.swing.JPanel addEmployeePanel;
    javax.swing.JRadioButton addEmployeeSexFemalejRadioButton2;
    javax.swing.JRadioButton addEmployeeSexMalejRadioButton1;
    javax.swing.ButtonGroup addEmployeeSexbuttonGroup;
    javax.swing.JTabbedPane addEmployeejTabbedPane1;
    javax.swing.JTextField basicSalaryjTextField2;
    javax.swing.JTextField basicSalaryjTextField6;
    javax.swing.JLabel besicSalaryjLabel2;
    javax.swing.JLabel besicSalaryjLabel5;
    javax.swing.JButton buttonAddEmployee;
    javax.swing.JButton buttonAssests;
    javax.swing.JButton buttonLogOut;
    javax.swing.JButton buttonPayroll;
    javax.swing.JButton buttonReports;
    javax.swing.JButton buttonSearch;
    javax.swing.JPanel datePickerPanal;
    javax.swing.JPanel datePickerPanal1;
    javax.swing.JPanel datePickerPanal2;
    javax.swing.JLabel dates;
    javax.swing.JLabel day;
    javax.swing.JComboBox<String> depatrmentjComboBox1;
    javax.swing.JLabel designationjLabel1;
    javax.swing.JTextField editBasicSalaryjTextField6;
    javax.swing.JLabel editBesicSalaryjLabel5;
    javax.swing.JLabel editDepartmentjLabel4;
    javax.swing.JComboBox<String> editDepatrmentjComboBox2;
    javax.swing.JLabel editDesignationjLabel2;
    javax.swing.JTextField editEmployeeAddjTextField3;
    javax.swing.JLabel editEmployeeAddressjLabel8;
    javax.swing.JButton editEmployeeBackjButton1;
    javax.swing.JLabel editEmployeeFirstNamejLabel2;
    javax.swing.JTextField editEmployeeIdjTextField4;
    javax.swing.JLabel editEmployeeNICjLabel8;
    javax.swing.JTextField editEmployeeNicjTextField3;
    javax.swing.JLabel editEmployeeTpjLabel6;
    javax.swing.JTextField editEmployeeTpjTextField4;
    javax.swing.JTextField editEmployeefirstnamejTextField2;
    javax.swing.JPanel editEmployeejPanel1;
    javax.swing.JTabbedPane editEmplyoeejTabbedPane1;
    javax.swing.JTextField editHourlyRatejTextField3;
    javax.swing.JLabel editHourlyrateDayjLabel4;
    javax.swing.JComboBox<String> editTypeOfEmployeejComboBox2;
    javax.swing.JLabel editTypeOfEmplyoeejLabel2;
    javax.swing.JTextField employeeAddjTextField2;
    javax.swing.JLabel employeeAddressjLabel7;
    javax.swing.JButton employeeDeletejButton2;
    javax.swing.JLabel employeeDobjLabel3;
    javax.swing.JButton employeeEditjButton;
    javax.swing.JLabel employeeFirstNamejLabel1;
    javax.swing.JLabel employeeIdjLabel1;
    javax.swing.JTextField employeeLNamejTextField2;
    javax.swing.JLabel employeeNICjLabel7;
    javax.swing.JTextField employeeNicjTextField2;
    javax.swing.JTextField employeeSearchFirstNamejTextField1;
    javax.swing.JButton employeeSearchjButton1;
    javax.swing.JLabel employeeSexjLabel4;
    javax.swing.JLabel employeeTpjLabel5;
    javax.swing.JTextField employeeTpjTextField3;
    javax.swing.JTextField employeefirstnamejTextField1;
    javax.swing.JTabbedPane emplyeeLeavesjserachTabbedPane1;
    javax.swing.JLabel emplyoeeLastNamejLabel2;
    javax.swing.JPanel headerPanel;
    javax.swing.JTextField hourlyRatejTextField2;
    javax.swing.JLabel hourlyrateDayjLabel3;
    javax.swing.JComboBox<String> jComboBox1;
    javax.swing.JDesktopPane jDesktopPaneFinance;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JScrollPane jScrollPane5;
    javax.swing.JScrollPane jScrollPane6;
    javax.swing.JTable jTable1;
    javax.swing.JTextArea jTextArea1;
    javax.swing.JPanel jobDetailsjPanel1;
    javax.swing.JPanel leaveAplicationjPanel1;
    com.toedter.calendar.JDateChooser leaveApplicationEndDateDateChooser1;
    com.toedter.calendar.JDateChooser leaveApplicationFromDateDateChooser1;
    javax.swing.JButton leaveEmployeeBackjButton1;
    javax.swing.JButton leaveEmployeeSearchjButton;
    javax.swing.JLabel leavesEmloyeeFirstNamejLabel2;
    javax.swing.JLabel leavesEmloyeeFirstNamejLabel3;
    javax.swing.JLabel leavesEmloyeeFirstNamejLabel4;
    javax.swing.JLabel leavesEmloyeeFirstNamejLabel5;
    javax.swing.JLabel leavesEmloyeeFirstNamejLabel6;
    javax.swing.JLabel leavesEmloyeeFirstNamejLabel7;
    javax.swing.JTextField leavesEmployeeIDjTextField1;
    javax.swing.JButton leavesEmployeeNextjButton2;
    javax.swing.JTextField leavesEmployeefirstnamejTextField2;
    javax.swing.JTable leavesEmplyeejTable4;
    javax.swing.JPanel leavesPanel;
    javax.swing.JPanel leavesjPanel1;
    javax.swing.JPanel mainButtonPanel;
    javax.swing.JTabbedPane parrolljTabbedPane1;
    javax.swing.JPanel payrollPanel;
    javax.swing.JPanel personalDetailsjPanel1;
    javax.swing.JPanel reportsPanel;
    javax.swing.JLabel salarEyemployeeIdjLabel5;
    javax.swing.JLabel salarEyemployeeIdjLabel6;
    javax.swing.JButton salaryCalculatejButton;
    javax.swing.JTextField salaryDeductionjTextField10;
    javax.swing.JTextField salaryEmployeeIdjTextField1;
    javax.swing.JTable salaryEmplyeejTable3;
    javax.swing.JLabel salaryOtherPayjLabel7;
    javax.swing.JTextField salaryOtherpayjTextField7;
    javax.swing.JButton salarySavejButton1;
    javax.swing.JTextField salaryTotalEarningjTextField8;
    javax.swing.JLabel salarydeductionyjLabel8;
    javax.swing.JLabel salarydeductionyjLabel9;
    javax.swing.JPanel salaryjPanel;
    javax.swing.JPanel salaryjPanel1;
    javax.swing.JPanel salaryjPanel2;
    javax.swing.JButton saveEmployeejButton1;
    javax.swing.JButton saveEmployeejButton2;
    javax.swing.JPanel searchEmployeejPanel2;
    javax.swing.JPanel searchPanel;
    javax.swing.JTable searchjTable6;
    javax.swing.JLabel serachEmployeeFnamejLabel;
    javax.swing.JPanel togglePanels;
    javax.swing.JTextField txteid;
    javax.swing.JComboBox<String> typeOfEmployeejComboBox1;
    javax.swing.JLabel typeOfEmplyoeejLabel1;
    javax.swing.JButton wageCalculatejButton1;
    javax.swing.JTextField wageDeductionjTextField10;
    javax.swing.JTextField wageEmployeeIdjTextField2;
    javax.swing.JTable wageEmplyeejTable4;
    javax.swing.JLabel wageHourlyRatejLabel5;
    javax.swing.JTextField wageHourlyRatejTextField6;
    javax.swing.JLabel wageIdjLabel4;
    javax.swing.JLabel wageOtherPayjLabel7;
    javax.swing.JLabel wageOtherPayjLabel8;
    javax.swing.JTextField wageOtherpayjTextField7;
    javax.swing.JTextField wageOtherpayjTextField8;
    javax.swing.JButton wageSavejButton;
    javax.swing.JTextField wageTotalEarningjTextField8;
    javax.swing.JLabel wagedeductionyjLabel8;
    javax.swing.JLabel wagedeductionyjLabel9;
    javax.swing.JPanel wagejPanel2;
    javax.swing.JLabel welcomeuser;
    javax.swing.JLabel welcomeuser1;
    // End of variables declaration//GEN-END:variables
}