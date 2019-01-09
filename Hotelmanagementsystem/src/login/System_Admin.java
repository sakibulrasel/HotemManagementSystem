package login;

import dbconnect.DatabaseHelper;
import event.EventManager;
import hr.Hr_Manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import room.RoomManager;


public class System_Admin extends javax.swing.JFrame {
    //variable for connect database
    Connection conn=DatabaseHelper.getDBConnection();
    PreparedStatement pstatement=null;
    ResultSet Results =null;
    
    
    static String USER;
    SimpleDateFormat sdf;
   
    public System_Admin(String username) {
        
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
        togglePanels.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDesktopPaneFinance = new javax.swing.JDesktopPane();
        financeManagerPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        welcomeuser = new javax.swing.JLabel();
        welcomeuser1 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        dates = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        togglePanels = new javax.swing.JPanel();
        buttonIncome1 = new javax.swing.JButton();
        buttonIncome3 = new javax.swing.JButton();
        buttonIncome4 = new javax.swing.JButton();
        buttonIncome7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

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
        setTitle("Hotel Management System");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(1020, 700));

        jDesktopPaneFinance.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPaneFinance.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPaneFinance.setPreferredSize(new java.awt.Dimension(1024, 690));
        jDesktopPaneFinance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        financeManagerPanel.setBackground(new java.awt.Color(255, 255, 255));
        financeManagerPanel.setPreferredSize(new java.awt.Dimension(1024, 690));
        financeManagerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        financeManagerPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 130));

        togglePanels.setBackground(new java.awt.Color(255, 255, 255));
        togglePanels.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 135, 235), 2));
        togglePanels.setPreferredSize(new java.awt.Dimension(832, 552));

        buttonIncome1.setBackground(new java.awt.Color(0, 51, 51));
        buttonIncome1.setFont(new java.awt.Font("Monotype Corsiva", 3, 20)); // NOI18N
        buttonIncome1.setForeground(new java.awt.Color(240, 240, 240));
        buttonIncome1.setText("      EVENT MANAGEMENT");
        buttonIncome1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonIncome1.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonIncome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonIncome1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonIncome1MouseExited(evt);
            }
        });
        buttonIncome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncome1ActionPerformed(evt);
            }
        });

        buttonIncome3.setBackground(new java.awt.Color(0, 51, 51));
        buttonIncome3.setFont(new java.awt.Font("Monotype Corsiva", 3, 20)); // NOI18N
        buttonIncome3.setForeground(new java.awt.Color(240, 240, 240));
        buttonIncome3.setText("        HR MANAGEMENT");
        buttonIncome3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonIncome3.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonIncome3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonIncome3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonIncome3MouseExited(evt);
            }
        });
        buttonIncome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncome3ActionPerformed(evt);
            }
        });

        buttonIncome4.setBackground(new java.awt.Color(0, 51, 51));
        buttonIncome4.setFont(new java.awt.Font("Monotype Corsiva", 3, 20)); // NOI18N
        buttonIncome4.setForeground(new java.awt.Color(240, 240, 240));
        buttonIncome4.setText("       ROOM MANAGEMENT");
        buttonIncome4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonIncome4.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonIncome4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonIncome4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonIncome4MouseExited(evt);
            }
        });
        buttonIncome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncome4ActionPerformed(evt);
            }
        });

        buttonIncome7.setBackground(new java.awt.Color(0, 51, 51));
        buttonIncome7.setFont(new java.awt.Font("Monotype Corsiva", 3, 20)); // NOI18N
        buttonIncome7.setForeground(new java.awt.Color(240, 240, 240));
        buttonIncome7.setText("         SYSTEM SETTINGS");
        buttonIncome7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonIncome7.setMargin(new java.awt.Insets(2, 4, 2, 0));
        buttonIncome7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonIncome7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonIncome7MouseExited(evt);
            }
        });
        buttonIncome7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncome7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout togglePanelsLayout = new javax.swing.GroupLayout(togglePanels);
        togglePanels.setLayout(togglePanelsLayout);
        togglePanelsLayout.setHorizontalGroup(
            togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(togglePanelsLayout.createSequentialGroup()
                .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(togglePanelsLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(buttonIncome1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(buttonIncome4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(togglePanelsLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(buttonIncome3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonIncome7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        togglePanelsLayout.setVerticalGroup(
            togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(togglePanelsLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIncome1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonIncome4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(togglePanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIncome7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonIncome3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        financeManagerPanel.add(togglePanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 135, 820, 450));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        financeManagerPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 190, 440));

        jDesktopPaneFinance.add(financeManagerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

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
                .addComponent(jDesktopPaneFinance, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIncome1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome1MouseEntered
        buttonIncome1.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonIncome1MouseEntered

    private void buttonIncome1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome1MouseExited
         buttonIncome1.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_buttonIncome1MouseExited

    private void buttonIncome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncome1ActionPerformed
        EventManager em = new EventManager(USER);
        em.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonIncome1ActionPerformed

    private void buttonIncome3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome3MouseEntered
        buttonIncome3.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonIncome3MouseEntered

    private void buttonIncome3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome3MouseExited
        buttonIncome3.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_buttonIncome3MouseExited

    private void buttonIncome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncome3ActionPerformed
       Hr_Manager hm=new Hr_Manager(USER);
       hm.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_buttonIncome3ActionPerformed

    private void buttonIncome4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome4MouseEntered
        buttonIncome4.setBackground(new Color(35,171,69));
    }//GEN-LAST:event_buttonIncome4MouseEntered

    private void buttonIncome4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome4MouseExited
        buttonIncome4.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_buttonIncome4MouseExited

    private void buttonIncome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncome4ActionPerformed
        RoomManager rm=new RoomManager(USER);
        rm.setVisible(true);
    }//GEN-LAST:event_buttonIncome4ActionPerformed

    private void buttonIncome7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome7MouseEntered
        buttonIncome7.setBackground(new Color(35,171,69));

    }//GEN-LAST:event_buttonIncome7MouseEntered

    private void buttonIncome7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIncome7MouseExited
        buttonIncome7.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_buttonIncome7MouseExited

    private void buttonIncome7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncome7ActionPerformed
        SystemPanel sp = new SystemPanel(USER);
        sp.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_buttonIncome7ActionPerformed
    public void clock(){
        Thread clock = new Thread(){
            public void run(){
                try{
                    for(;;){
                    Calendar cal=new GregorianCalendar();
                    Time.setText(cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
                    dates.setText(cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE));
                    sleep(1000);
                    }
                }catch(Exception e){ 
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new System_Admin(USER).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel Time;
    javax.swing.JButton buttonIncome1;
    javax.swing.JButton buttonIncome3;
    javax.swing.JButton buttonIncome4;
    javax.swing.JButton buttonIncome7;
    javax.swing.JLabel dates;
    javax.swing.JLabel day;
    javax.swing.JPanel financeManagerPanel;
    javax.swing.JPanel headerPanel;
    javax.swing.JDesktopPane jDesktopPaneFinance;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable jTable1;
    javax.swing.JPanel togglePanels;
    javax.swing.JLabel welcomeuser;
    javax.swing.JLabel welcomeuser1;
    // End of variables declaration//GEN-END:variables
}