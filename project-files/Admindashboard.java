
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Admindashboard extends JFrame implements ActionListener {

    private JTabbedPane mainTab;
    private JLabel maintitleLabel, subtitleLabel, dashboardtitleLabel, dashboardsubtitleLabel, managetitleLabel, detailstitleLabel,
            settingstitleLabel;
    private JPanel mainPanel, dashboardbackPanel, dashboardPanel, managebackPanel, managePanel, detailsbackPanel,
            detailsPanel, settingsbackPanel, settingsPanel;
    private JButton dashboarddashboardButton, dashboardmanageButton, dashboardviewButton, dashboardsettingsButton,
            dashboardlogoutButton, newdoctorButton, newpatientButton, newappointButton, newnurseButton,
            alldoctorButton, allpatientButton, allappointButton, allnurseButton, dashboardexitButton;
    private JButton managedashboardButton, managemanageButton, manageviewButton, managesettingsButton,
            managelogoutButton, editdoctorButton, editpatientButton, editappointButton, editnurseButton,
            managebackButton, manageexitButton;
    private JButton detailsdashboardButton, detailsmanageButton, detailsviewButton, detailssettingsButton,
            detailslogoutButton, detailsalldoctorButton, detailsallpatientButton, detailsallappointButton,
            detailsallnurseButton, detailsbackButton, detailsexitButton;
    private JButton settingsdashboardButton, settingsmanageButton, settingsviewButton, settingssettingsButton,
            settingslogoutButton, changeinfoButton, changepassButton, settingsbackButton, settingsexitButton;
    String displayName;
    private Connection con=null;
    private Statement st=null;

    public Admindashboard() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Doctor's HomePage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(getToolkit().getImage("C:\\Users\\Tamjid\\Desktop\\ourproject\\logo.png"));

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1100, 700);
        mainPanel.setBackground(Color.decode("#075bd7"));
        mainPanel.setLayout(null);
        this.add(mainPanel);

//        *************Dashboard***************
        dashboardbackPanel = new JPanel();
        dashboardbackPanel.setLayout(null);
        dashboardbackPanel.setBounds(0, 0, 1100, 700);
        dashboardbackPanel.setBackground(Color.decode("#00ADEF"));

        maintitleLabel = new JLabel();
        maintitleLabel.setFont(new Font("Segoe UI", 1, 20));
        maintitleLabel.setForeground(Color.BLACK);
        maintitleLabel.setText("E-Healthcare Management System");
        maintitleLabel.setBounds(150, 30, 400, 40);
        dashboardbackPanel.add(maintitleLabel);

        subtitleLabel = new JLabel();
        subtitleLabel.setFont(new Font("Segoe UI", 1, 15));
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setText("Healthcare on the go, anywhere!");
        subtitleLabel.setBounds(150, 70, 400, 40);
        dashboardbackPanel.add(subtitleLabel);

        dashboarddashboardButton = new JButton("Dashboard");
        dashboarddashboardButton.setFont(new Font("Segoe UI", 1, 18));
        dashboarddashboardButton.setBounds(190, 110, 120, 30);
        dashboarddashboardButton.setBackground(Color.decode("#B8EEFF"));
        dashboarddashboardButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboarddashboardButton.setFocusable(false);
        dashboardbackPanel.add(dashboarddashboardButton);

        dashboardmanageButton = new JButton("Manage");
        dashboardmanageButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardmanageButton.setBounds(340, 110, 120, 30);
        dashboardmanageButton.setBackground(Color.decode("#B8EEFF"));
        dashboardmanageButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardmanageButton.setFocusable(false);
        dashboardbackPanel.add(dashboardmanageButton);

        dashboardviewButton = new JButton("View Details");
        dashboardviewButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardviewButton.setBounds(490, 110, 120, 30);
        dashboardviewButton.setBackground(Color.decode("#B8EEFF"));
        dashboardviewButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardviewButton.setFocusable(false);
        dashboardbackPanel.add(dashboardviewButton);

        dashboardsettingsButton = new JButton("Settings");
        dashboardsettingsButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardsettingsButton.setBounds(640, 110, 120, 30);
        dashboardsettingsButton.setBackground(Color.decode("#B8EEFF"));
        dashboardsettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardsettingsButton.setFocusable(false);
        dashboardbackPanel.add(dashboardsettingsButton);

        dashboardlogoutButton = new JButton("Log out");
        dashboardlogoutButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardlogoutButton.setBounds(790, 110, 120, 30);
        dashboardlogoutButton.setBackground(Color.decode("#B8EEFF"));
        dashboardlogoutButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardlogoutButton.setFocusable(false);
        dashboardbackPanel.add(dashboardlogoutButton);

        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);
        dashboardPanel.setBounds(130, 150, 840, 450);
        dashboardPanel.setBackground(Color.decode("#B8EEFF"));
        dashboardbackPanel.add(dashboardPanel);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

            Statement st = con.createStatement();

            String sql = "select * from admin";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                displayName = rs.getString("displayname");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        
        
        

        dashboardtitleLabel = new JLabel();
        dashboardtitleLabel.setFont(new Font("Segoe UI", 1, 18));
        dashboardtitleLabel.setForeground(Color.BLACK);
        dashboardtitleLabel.setText("Welcome "+displayName+" !");
        dashboardtitleLabel.setBackground(Color.red);
        dashboardtitleLabel.setBounds(0, 0, 840, 40);
        dashboardtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        dashboardPanel.add(dashboardtitleLabel);
        
        
        dashboardsubtitleLabel= new JLabel();
        dashboardsubtitleLabel.setFont(new Font("Segoe UI", 1, 20));
        dashboardsubtitleLabel.setForeground(Color.BLACK);
        dashboardsubtitleLabel.setText("E-Healthcare Management System Admin Dashboard");
        dashboardsubtitleLabel.setBackground(Color.red);
        dashboardsubtitleLabel.setBounds(0, 30, 840, 40);
        dashboardsubtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        dashboardPanel.add(dashboardsubtitleLabel);
        
        
        

        newdoctorButton = new JButton();
        newdoctorButton.setFont(new Font("Segoe UI", 1, 18));
        newdoctorButton.setText("Add New Doctor");
        newdoctorButton.setBounds(100, 80, 250, 30);
        newdoctorButton.setForeground(Color.white);
        newdoctorButton.setBackground(Color.decode("#00ADEF"));
        newdoctorButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        newdoctorButton.setFocusable(false);
        dashboardPanel.add(newdoctorButton);

        newpatientButton = new JButton();
        newpatientButton.setFont(new Font("Segoe UI", 1, 18));
        newpatientButton.setText("Add New Patient");
        newpatientButton.setBounds(100, 120, 250, 30);
        newpatientButton.setForeground(Color.white);
        newpatientButton.setBackground(Color.decode("#00ADEF"));
        newpatientButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        newpatientButton.setFocusable(false);
        dashboardPanel.add(newpatientButton);

        newappointButton = new JButton();
        newappointButton.setFont(new Font("Segoe UI", 1, 18));
        newappointButton.setText("Add New Appointment");
        newappointButton.setBounds(100, 160, 250, 30);
        newappointButton.setForeground(Color.white);
        newappointButton.setBackground(Color.decode("#00ADEF"));
        newappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        newappointButton.setFocusable(false);
        dashboardPanel.add(newappointButton);

        newnurseButton = new JButton();
        newnurseButton.setFont(new Font("Segoe UI", 1, 18));
        newnurseButton.setText("Add New Nurse");
        newnurseButton.setBounds(100, 200, 250, 30);
        newnurseButton.setForeground(Color.white);
        newnurseButton.setBackground(Color.decode("#00ADEF"));
        newnurseButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        newnurseButton.setFocusable(false);
        dashboardPanel.add(newnurseButton);

        alldoctorButton = new JButton();
        alldoctorButton.setFont(new Font("Segoe UI", 1, 18));
        alldoctorButton.setText("All Doctors");
        alldoctorButton.setBounds(100, 240, 250, 30);
        alldoctorButton.setForeground(Color.white);
        alldoctorButton.setBackground(Color.decode("#00ADEF"));
        alldoctorButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        alldoctorButton.setFocusable(false);
        dashboardPanel.add(alldoctorButton);

        allpatientButton = new JButton();
        allpatientButton.setFont(new Font("Segoe UI", 1, 18));
        allpatientButton.setText("All Patients");
        allpatientButton.setBounds(100, 280, 250, 30);
        allpatientButton.setForeground(Color.white);
        allpatientButton.setBackground(Color.decode("#00ADEF"));
        allpatientButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        allpatientButton.setFocusable(false);
        dashboardPanel.add(allpatientButton);

        allappointButton = new JButton();
        allappointButton.setFont(new Font("Segoe UI", 1, 18));
        allappointButton.setText("All Appointments");
        allappointButton.setBounds(100, 320, 250, 30);
        allappointButton.setForeground(Color.white);
        allappointButton.setBackground(Color.decode("#00ADEF"));
        allappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        allappointButton.setFocusable(false);
        dashboardPanel.add(allappointButton);

        allnurseButton = new JButton();
        allnurseButton.setFont(new Font("Segoe UI", 1, 18));
        allnurseButton.setText("All Nurse");
        allnurseButton.setBounds(100, 360, 250, 30);
        allnurseButton.setForeground(Color.white);
        allnurseButton.setBackground(Color.decode("#00ADEF"));
        allnurseButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        allnurseButton.setFocusable(false);
        dashboardPanel.add(allnurseButton);
        
        
        dashboardexitButton = new JButton("Exit");
        dashboardexitButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardexitButton.setBounds(920, 618, 130, 30);
        dashboardexitButton.setBackground(Color.decode("#B8EEFF"));
        dashboardexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardexitButton.setFocusable(false);
        dashboardbackPanel.add(dashboardexitButton);

        //        *************Manage***************
        managebackPanel = new JPanel();
        managebackPanel.setLayout(null);
        managebackPanel.setBounds(0, 0, 1100, 700);
        managebackPanel.setBackground(Color.decode("#00ADEF"));

        maintitleLabel = new JLabel();
        maintitleLabel.setFont(new Font("Segoe UI", 1, 20));
        maintitleLabel.setForeground(Color.BLACK);
        maintitleLabel.setText("E-Healthcare Management System");
        maintitleLabel.setBounds(150, 30, 400, 40);
        managebackPanel.add(maintitleLabel);

        subtitleLabel = new JLabel();
        subtitleLabel.setFont(new Font("Segoe UI", 1, 15));
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setText("Healthcare on the go, anywhere!");
        subtitleLabel.setBounds(150, 70, 400, 40);
        managebackPanel.add(subtitleLabel);

        managedashboardButton = new JButton("Dashboard");
        managedashboardButton.setFont(new Font("Segoe UI", 1, 18));
        managedashboardButton.setBounds(190, 110, 120, 30);
        managedashboardButton.setBackground(Color.decode("#B8EEFF"));
        managedashboardButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        managedashboardButton.setFocusable(false);
        managebackPanel.add(managedashboardButton);

        managemanageButton = new JButton("Manage");
        managemanageButton.setFont(new Font("Segoe UI", 1, 18));
        managemanageButton.setBounds(340, 110, 120, 30);
        managemanageButton.setBackground(Color.decode("#B8EEFF"));
        managemanageButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        managemanageButton.setFocusable(false);
        managebackPanel.add(managemanageButton);

        manageviewButton = new JButton("View Details");
        manageviewButton.setFont(new Font("Segoe UI", 1, 18));
        manageviewButton.setBounds(490, 110, 120, 30);
        manageviewButton.setBackground(Color.decode("#B8EEFF"));
        manageviewButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        manageviewButton.setFocusable(false);
        managebackPanel.add(manageviewButton);

        managesettingsButton = new JButton("Settings");
        managesettingsButton.setFont(new Font("Segoe UI", 1, 18));
        managesettingsButton.setBounds(640, 110, 120, 30);
        managesettingsButton.setBackground(Color.decode("#B8EEFF"));
        managesettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        managesettingsButton.setFocusable(false);
        managebackPanel.add(managesettingsButton);

        managelogoutButton = new JButton("Log out");
        managelogoutButton.setFont(new Font("Segoe UI", 1, 18));
        managelogoutButton.setBounds(790, 110, 120, 30);
        managelogoutButton.setBackground(Color.decode("#B8EEFF"));
        managelogoutButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        managelogoutButton.setFocusable(false);
        managebackPanel.add(managelogoutButton);

        managePanel = new JPanel();
        managePanel.setLayout(null);
        managePanel.setBounds(130, 150, 840, 450);
        managePanel.setBackground(Color.decode("#B8EEFF"));
        managebackPanel.add(managePanel);

        managetitleLabel = new JLabel();
        managetitleLabel.setFont(new Font("Segoe UI", 1, 18));
        managetitleLabel.setForeground(Color.BLACK);
        managetitleLabel.setText("Manage");
        managetitleLabel.setBackground(Color.red);
        managetitleLabel.setBounds(400, 10, 700, 40);
        managePanel.add(managetitleLabel);

        editdoctorButton = new JButton();
        editdoctorButton.setFont(new Font("Segoe UI", 1, 18));
        editdoctorButton.setText("Update/Remove Doctor");
        editdoctorButton.setBounds(100, 80, 270, 30);
        editdoctorButton.setForeground(Color.white);
        editdoctorButton.setBackground(Color.decode("#00ADEF"));
        editdoctorButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        editdoctorButton.setFocusable(false);
        managePanel.add(editdoctorButton);

        editpatientButton = new JButton();
        editpatientButton.setFont(new Font("Segoe UI", 1, 18));
        editpatientButton.setText("Update/Remove Patient");
        editpatientButton.setBounds(100, 140, 270, 30);
        editpatientButton.setForeground(Color.white);
        editpatientButton.setBackground(Color.decode("#00ADEF"));
        editpatientButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        editpatientButton.setFocusable(false);
        managePanel.add(editpatientButton);

        editappointButton = new JButton();
        editappointButton.setFont(new Font("Segoe UI", 1, 18));
        editappointButton.setText("Remove/Cancel Appointment");
        editappointButton.setBounds(100, 200, 270, 30);
        editappointButton.setForeground(Color.white);
        editappointButton.setBackground(Color.decode("#00ADEF"));
        editappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        editappointButton.setFocusable(false);
        managePanel.add(editappointButton);

        editnurseButton = new JButton();
        editnurseButton.setFont(new Font("Segoe UI", 1, 18));
        editnurseButton.setText("Update/Remove Nurse");
        editnurseButton.setBounds(100, 260, 270, 30);
        editnurseButton.setForeground(Color.white);
        editnurseButton.setBackground(Color.decode("#00ADEF"));
        editnurseButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        editnurseButton.setFocusable(false);
        managePanel.add(editnurseButton);

        managebackButton = new JButton("Back to Dashboard");
        managebackButton.setFont(new Font("Segoe UI", 1, 18));
        managebackButton.setBounds(45, 618, 170, 30);
        managebackButton.setBackground(Color.decode("#B8EEFF"));
        managebackButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        managebackButton.setFocusable(false);
        managebackPanel.add(managebackButton);
        
        manageexitButton = new JButton("Exit");
        manageexitButton.setFont(new Font("Segoe UI", 1, 18));
        manageexitButton.setBounds(920, 618, 130, 30);
        manageexitButton.setBackground(Color.decode("#B8EEFF"));
        manageexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        manageexitButton.setFocusable(false);
        managebackPanel.add(manageexitButton);
        

        //        *************View Details***************
        detailsbackPanel = new JPanel();
        detailsbackPanel.setLayout(null);
        detailsbackPanel.setBounds(0, 0, 1100, 700);
        detailsbackPanel.setBackground(Color.decode("#00ADEF"));

        maintitleLabel = new JLabel();
        maintitleLabel.setFont(new Font("Segoe UI", 1, 20));
        maintitleLabel.setForeground(Color.BLACK);
        maintitleLabel.setText("E-Healthcare Management System");
        maintitleLabel.setBounds(150, 30, 400, 40);
        detailsbackPanel.add(maintitleLabel);

        subtitleLabel = new JLabel();
        subtitleLabel.setFont(new Font("Segoe UI", 1, 15));
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setText("Healthcare on the go, anywhere!");
        subtitleLabel.setBounds(150, 70, 400, 40);
        detailsbackPanel.add(subtitleLabel);

        detailsdashboardButton = new JButton("Dashboard");
        detailsdashboardButton.setFont(new Font("Segoe UI", 1, 18));
        detailsdashboardButton.setBounds(190, 110, 120, 30);
        detailsdashboardButton.setBackground(Color.decode("#B8EEFF"));
        detailsdashboardButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsdashboardButton.setFocusable(false);
        detailsbackPanel.add(detailsdashboardButton);

        detailsmanageButton = new JButton("Manage");
        detailsmanageButton.setFont(new Font("Segoe UI", 1, 18));
        detailsmanageButton.setBounds(340, 110, 120, 30);
        detailsmanageButton.setBackground(Color.decode("#B8EEFF"));
        detailsmanageButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsmanageButton.setFocusable(false);
        detailsbackPanel.add(detailsmanageButton);

        detailsviewButton = new JButton("View Details");
        detailsviewButton.setFont(new Font("Segoe UI", 1, 18));
        detailsviewButton.setBounds(490, 110, 120, 30);
        detailsviewButton.setBackground(Color.decode("#B8EEFF"));
        detailsviewButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsviewButton.setFocusable(false);
        detailsbackPanel.add(detailsviewButton);

        detailssettingsButton = new JButton("Settings");
        detailssettingsButton.setFont(new Font("Segoe UI", 1, 18));
        detailssettingsButton.setBounds(640, 110, 120, 30);
        detailssettingsButton.setBackground(Color.decode("#B8EEFF"));
        detailssettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailssettingsButton.setFocusable(false);
        detailsbackPanel.add(detailssettingsButton);

        detailslogoutButton = new JButton("Log out");
        detailslogoutButton.setFont(new Font("Segoe UI", 1, 18));
        detailslogoutButton.setBounds(790, 110, 120, 30);
        detailslogoutButton.setBackground(Color.decode("#B8EEFF"));
        detailslogoutButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailslogoutButton.setFocusable(false);
        detailsbackPanel.add(detailslogoutButton);

        detailsPanel = new JPanel();
        detailsPanel.setLayout(null);
        detailsPanel.setBounds(130, 150, 840, 450);
        detailsPanel.setBackground(Color.decode("#B8EEFF"));
        detailsbackPanel.add(detailsPanel);

        detailstitleLabel = new JLabel();
        detailstitleLabel.setFont(new Font("Segoe UI", 1, 18));
        detailstitleLabel.setForeground(Color.BLACK);
        detailstitleLabel.setText("View Details");
        detailstitleLabel.setBackground(Color.red);
        detailstitleLabel.setBounds(400, 10, 700, 40);
        detailsPanel.add(detailstitleLabel);

        detailsalldoctorButton = new JButton();
        detailsalldoctorButton.setFont(new Font("Segoe UI", 1, 18));
        detailsalldoctorButton.setText("View All Doctors");
        detailsalldoctorButton.setBounds(100, 80, 250, 30);
        detailsalldoctorButton.setForeground(Color.white);
        detailsalldoctorButton.setBackground(Color.decode("#00ADEF"));
        detailsalldoctorButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsalldoctorButton.setFocusable(false);
        detailsPanel.add(detailsalldoctorButton);

        detailsallpatientButton = new JButton();
        detailsallpatientButton.setFont(new Font("Segoe UI", 1, 18));
        detailsallpatientButton.setText("View All Patients");
        detailsallpatientButton.setBounds(100, 140, 250, 30);
        detailsallpatientButton.setForeground(Color.white);
        detailsallpatientButton.setBackground(Color.decode("#00ADEF"));
        detailsallpatientButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsallpatientButton.setFocusable(false);
        detailsPanel.add(detailsallpatientButton);

        detailsallappointButton = new JButton();
        detailsallappointButton.setFont(new Font("Segoe UI", 1, 18));
        detailsallappointButton.setText("View All Appointments");
        detailsallappointButton.setBounds(100, 200, 250, 30);
        detailsallappointButton.setForeground(Color.white);
        detailsallappointButton.setBackground(Color.decode("#00ADEF"));
        detailsallappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsallappointButton.setFocusable(false);
        detailsPanel.add(detailsallappointButton);

        detailsallnurseButton = new JButton();
        detailsallnurseButton.setFont(new Font("Segoe UI", 1, 18));
        detailsallnurseButton.setText("View All Nurses");
        detailsallnurseButton.setBounds(100, 260, 250, 30);
        detailsallnurseButton.setForeground(Color.white);
        detailsallnurseButton.setBackground(Color.decode("#00ADEF"));
        detailsallnurseButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsallnurseButton.setFocusable(false);
        detailsPanel.add(detailsallnurseButton);

        detailsbackButton = new JButton("Back to Dashboard");
        detailsbackButton.setFont(new Font("Segoe UI", 1, 18));
        detailsbackButton.setBounds(45, 618, 170, 30);
        detailsbackButton.setBackground(Color.decode("#B8EEFF"));
        detailsbackButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsbackButton.setFocusable(false);
        detailsbackPanel.add(detailsbackButton);
        
        
        detailsexitButton = new JButton("Exit");
        detailsexitButton.setFont(new Font("Segoe UI", 1, 18));
        detailsexitButton.setBounds(920, 618, 130, 30);
        detailsexitButton.setBackground(Color.decode("#B8EEFF"));
        detailsexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        detailsexitButton.setFocusable(false);
        detailsbackPanel.add(detailsexitButton);
        

        //        *************Settings***************
        settingsbackPanel = new JPanel();
        settingsbackPanel.setLayout(null);
        settingsbackPanel.setBounds(0, 0, 1100, 700);
        settingsbackPanel.setBackground(Color.decode("#00ADEF"));

        maintitleLabel = new JLabel();
        maintitleLabel.setFont(new Font("Segoe UI", 1, 20));
        maintitleLabel.setForeground(Color.BLACK);
        maintitleLabel.setText("E-Healthcare Management System");
        maintitleLabel.setBounds(150, 30, 400, 40);
        settingsbackPanel.add(maintitleLabel);

        subtitleLabel = new JLabel();
        subtitleLabel.setFont(new Font("Segoe UI", 1, 15));
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setText("Healthcare on the go, anywhere!");
        subtitleLabel.setBounds(150, 70, 400, 40);
        settingsbackPanel.add(subtitleLabel);

        settingsdashboardButton = new JButton("Dashboard");
        settingsdashboardButton.setFont(new Font("Segoe UI", 1, 18));
        settingsdashboardButton.setBounds(190, 110, 120, 30);
        settingsdashboardButton.setBackground(Color.decode("#B8EEFF"));
        settingsdashboardButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingsdashboardButton.setFocusable(false);
        settingsbackPanel.add(settingsdashboardButton);

        settingsmanageButton = new JButton("Manage");
        settingsmanageButton.setFont(new Font("Segoe UI", 1, 18));
        settingsmanageButton.setBounds(340, 110, 120, 30);
        settingsmanageButton.setBackground(Color.decode("#B8EEFF"));
        settingsmanageButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingsmanageButton.setFocusable(false);
        settingsbackPanel.add(settingsmanageButton);

        settingsviewButton = new JButton("View Details");
        settingsviewButton.setFont(new Font("Segoe UI", 1, 18));
        settingsviewButton.setBounds(490, 110, 120, 30);
        settingsviewButton.setBackground(Color.decode("#B8EEFF"));
        settingsviewButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingsviewButton.setFocusable(false);
        settingsbackPanel.add(settingsviewButton);

        settingssettingsButton = new JButton("Settings");
        settingssettingsButton.setFont(new Font("Segoe UI", 1, 18));
        settingssettingsButton.setBounds(640, 110, 120, 30);
        settingssettingsButton.setBackground(Color.decode("#B8EEFF"));
        settingssettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingssettingsButton.setFocusable(false);
        settingsbackPanel.add(settingssettingsButton);

        settingslogoutButton = new JButton("Log out");
        settingslogoutButton.setFont(new Font("Segoe UI", 1, 18));
        settingslogoutButton.setBounds(790, 110, 120, 30);
        settingslogoutButton.setBackground(Color.decode("#B8EEFF"));
        settingslogoutButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingslogoutButton.setFocusable(false);
        settingsbackPanel.add(settingslogoutButton);

        settingsPanel = new JPanel();
        settingsPanel.setLayout(null);
        settingsPanel.setBounds(130, 150, 840, 450);
        settingsPanel.setBackground(Color.decode("#B8EEFF"));
        settingsbackPanel.add(settingsPanel);

        settingstitleLabel = new JLabel();
        settingstitleLabel.setFont(new Font("Segoe UI", 1, 18));
        settingstitleLabel.setForeground(Color.BLACK);
        settingstitleLabel.setText("Settings");
        settingstitleLabel.setBackground(Color.red);
        settingstitleLabel.setBounds(400, 10, 700, 40);
        settingsPanel.add(settingstitleLabel);

        changeinfoButton = new JButton();
        changeinfoButton.setFont(new Font("Segoe UI", 1, 18));
        changeinfoButton.setText("Change Informations");
        changeinfoButton.setBounds(100, 80, 250, 30);
        changeinfoButton.setForeground(Color.white);
        changeinfoButton.setBackground(Color.decode("#00ADEF"));
        changeinfoButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        changeinfoButton.setFocusable(false);
        settingsPanel.add(changeinfoButton);

        changepassButton = new JButton();
        changepassButton.setFont(new Font("Segoe UI", 1, 18));
        changepassButton.setText("Change Password");
        changepassButton.setBounds(100, 140, 250, 30);
        changepassButton.setForeground(Color.white);
        changepassButton.setBackground(Color.decode("#00ADEF"));
        changepassButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        changepassButton.setFocusable(false);
        settingsPanel.add(changepassButton);

        settingsbackButton = new JButton("Back to Dashboard");
        settingsbackButton.setFont(new Font("Segoe UI", 1, 18));
        settingsbackButton.setBounds(45, 618, 170, 30);
        settingsbackButton.setBackground(Color.decode("#B8EEFF"));
        settingsbackButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingsbackButton.setFocusable(false);
        settingsbackPanel.add(settingsbackButton);
        
        
        settingsexitButton = new JButton("Exit");
        settingsexitButton.setFont(new Font("Segoe UI", 1, 18));
        settingsexitButton.setBounds(920, 618, 130, 30);
        settingsexitButton.setBackground(Color.decode("#B8EEFF"));
        settingsexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingsexitButton.setFocusable(false);
        settingsbackPanel.add(settingsexitButton);
        

        //end of all panel codes
        mainTab = new JTabbedPane(JTabbedPane.LEFT);
        mainTab.setBounds(-100, -10, 1200, 700);
        mainTab.add("Dashboard", dashboardbackPanel);
        mainTab.add("Manage", managebackPanel);
        mainTab.add("View Details", detailsbackPanel);
        mainTab.add("Settings", settingsbackPanel);
        mainPanel.add(mainTab);

        //DashboardPanel action listeners
        dashboarddashboardButton.addActionListener(this);
        dashboardmanageButton.addActionListener(this);
        dashboardviewButton.addActionListener(this);
        dashboardsettingsButton.addActionListener(this);
        dashboardlogoutButton.addActionListener(this);
        newdoctorButton.addActionListener(this);
        newpatientButton.addActionListener(this);
        newappointButton.addActionListener(this);
        newnurseButton.addActionListener(this);
        alldoctorButton.addActionListener(this);
        allpatientButton.addActionListener(this);
        allappointButton.addActionListener(this);
        allnurseButton.addActionListener(this);
        dashboardexitButton.addActionListener(this);

        //ManagePanel action listeners
        managedashboardButton.addActionListener(this);
        managemanageButton.addActionListener(this);
        manageviewButton.addActionListener(this);
        managesettingsButton.addActionListener(this);
        managelogoutButton.addActionListener(this);
        editdoctorButton.addActionListener(this);
        editpatientButton.addActionListener(this);
        editappointButton.addActionListener(this);
        editnurseButton.addActionListener(this);
        managebackButton.addActionListener(this);
        manageexitButton.addActionListener(this);

        //View Details Panel action listeners
        detailsdashboardButton.addActionListener(this);
        detailsmanageButton.addActionListener(this);
        detailsviewButton.addActionListener(this);
        detailssettingsButton.addActionListener(this);
        detailslogoutButton.addActionListener(this);
        detailsalldoctorButton.addActionListener(this);
        detailsallpatientButton.addActionListener(this);
        detailsallappointButton.addActionListener(this);
        detailsallnurseButton.addActionListener(this);
        detailsbackButton.addActionListener(this);
        detailsexitButton.addActionListener(this);

        //Settings Panel action listeners
        settingsdashboardButton.addActionListener(this);
        settingsmanageButton.addActionListener(this);
        settingsviewButton.addActionListener(this);
        settingssettingsButton.addActionListener(this);
        settingslogoutButton.addActionListener(this);
        changeinfoButton.addActionListener(this);
        changepassButton.addActionListener(this);
        settingsbackButton.addActionListener(this);
        settingsexitButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Dashboard Action Performed
        if (e.getSource() == dashboarddashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == dashboardmanageButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == dashboardviewButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == dashboardsettingsButton) {
            mainTab.setSelectedIndex(3);
        } else if (e.getSource() == dashboardlogoutButton) {
            int dashboarddecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (dashboarddecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == newpatientButton) {
            this.setVisible(false);
            AddPatient patient = new AddPatient();
            patient.setVisible(true);
        } else if (e.getSource() == newappointButton) {
            this.setVisible(false);
            new AddAppointment().setVisible(true);
        }else if (e.getSource() == newdoctorButton) {
            this.setVisible(false);
            AddDoctor doctor = new AddDoctor();
            doctor.setVisible(true);
        } else if (e.getSource() == newnurseButton) {
            this.setVisible(false);
            AddNurse nurse = new AddNurse();
            nurse.setVisible(true);
        }else if (e.getSource() == allpatientButton) {
            this.setVisible(false);
            new Allpatient().setVisible(true);
        }else if (e.getSource() == alldoctorButton) {
            this.setVisible(false);
            new AllDoctor().setVisible(true);
        }else if (e.getSource() == allappointButton) {
            this.setVisible(false);
            new AllAppointment().setVisible(true);
        }else if (e.getSource() == allnurseButton) {
            this.setVisible(false);
            new AllNurse().setVisible(true);
        }else if (e.getSource() == dashboardexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        } // Manage Action Performed
        else if (e.getSource() == managedashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == managemanageButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == manageviewButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == managesettingsButton) {
            mainTab.setSelectedIndex(3);
        } else if (e.getSource() == managelogoutButton) {
            int managedecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (managedecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == managebackButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == editdoctorButton) {
            this.setVisible(false);
            new EditDoctor().setVisible(true);
        }else if (e.getSource() == editpatientButton) {
            this.setVisible(false);
            new EditPatient().setVisible(true);
        }else if (e.getSource() == editappointButton) {
            this.setVisible(false);
            new EditAppointment().setVisible(true);
        }else if (e.getSource() == editnurseButton) {
            this.setVisible(false);
            new EditNurse().setVisible(true);
        }else if (e.getSource() == manageexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }// View Details Action Performed
        else if (e.getSource() == detailsdashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == detailsmanageButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == detailsviewButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == detailssettingsButton) {
            mainTab.setSelectedIndex(3);
        } else if (e.getSource() == detailslogoutButton) {
            int detailsdecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (detailsdecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == detailsbackButton) {
            mainTab.setSelectedIndex(0);
        }else if (e.getSource() == detailsalldoctorButton) {
            this.setVisible(false);
            new AllDoctor().setVisible(true);
        }else if (e.getSource() == detailsallpatientButton) {
            this.setVisible(false);
            new Allpatient().setVisible(true);
        }else if (e.getSource() == detailsallappointButton) {
            this.setVisible(false);
            new AllAppointment().setVisible(true);
        }else if (e.getSource() == detailsallnurseButton) {
            this.setVisible(false);
            new AllNurse().setVisible(true);
        }else if (e.getSource() == detailsexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }// Settings Action Performed
        else if (e.getSource() == settingsdashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == settingsmanageButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == settingsviewButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == settingssettingsButton) {
            mainTab.setSelectedIndex(3);
        } else if (e.getSource() == settingslogoutButton) {
            int settingsdecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (settingsdecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == changeinfoButton) {
            Adminchangeinfo info = new Adminchangeinfo();
            info.setVisible(true);
        } else if (e.getSource() == changepassButton) {
            Adminchangepass pass = new Adminchangepass();
            pass.setVisible(true);
        }
        else if (e.getSource() == settingsbackButton) {
            mainTab.setSelectedIndex(0);
        }else if (e.getSource() == settingsexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Admindashboard dashboard = new Admindashboard();
        dashboard.setVisible(true);

    }

}
