
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class Patientdashboard extends JFrame implements ActionListener {

    private JTabbedPane mainTab;
    private JLabel maintitleLabel, subtitleLabel, dashboardtitleLabel, appointmenttitleLabel, viewdoctorstitleLabel,
            settingstitleLabel;
    private JPanel mainPanel, dashboardbackPanel, dashboardPanel, appointmentbackPanel, appointmentPanel, viewdoctorsbackPanel,
            viewdoctorsPanel, settingsbackPanel, settingsPanel;
    private JButton dashboarddashboardButton, dashboardappointmentButton, dashboardviewButton, dashboardsettingsButton,
            dashboardlogoutButton, myappointButton, bappointmentButton, vdoctorsButton, dashboardexitButton;

    private JButton appointmentdashboardButton, appointmentappointmentButton, appointmentviewButton, appointmentsettingsButton,
            appointmentlogoutButton, myappointmentButton, bookappointmentButton, cancelappointmentButton,
            appointmentbackButton, appointmentexitButton;
    private JButton viewdoctorsdashboardButton, viewdoctorsappointmentButton, viewdoctorsviewButton, viewdoctorssettingsButton,
            viewdoctorslogoutButton, vadoctorsviewButton, viewdoctorssbackButton, viewexitButton;
    private JButton settingsdashboardButton, settingsappointmentButton, settingsviewButton, settingssettingsButton,
            settingslogoutButton, changeinfoButton, changepassButton, recoveridButton, recoverauthButton, settingsbackButton, settingsexitButton;

    public Patientdashboard() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Patient's HomePage");
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

        dashboardappointmentButton = new JButton("Appointments");
        dashboardappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardappointmentButton.setBounds(330, 110, 140, 30);
        dashboardappointmentButton.setBackground(Color.decode("#B8EEFF"));
        dashboardappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardappointmentButton.setFocusable(false);
        dashboardbackPanel.add(dashboardappointmentButton);

        dashboardviewButton = new JButton("View Doctors");
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

        dashboardtitleLabel = new JLabel();
        dashboardtitleLabel.setFont(new Font("Segoe UI", 1, 18));
        dashboardtitleLabel.setForeground(Color.BLACK);
        dashboardtitleLabel.setText("Welcome to E-Healthcare Management System Patient Dashboard");
        dashboardtitleLabel.setBackground(Color.red);
        dashboardtitleLabel.setBounds(140, 10, 700, 40);
        dashboardPanel.add(dashboardtitleLabel);

        dashboardtitleLabel = new JLabel();
        dashboardtitleLabel.setFont(new Font("Segoe UI", 1, 18));
        dashboardtitleLabel.setForeground(Color.BLACK);
        dashboardtitleLabel.setText("<HTML><U>Quick Links</U></HTML>");
        dashboardtitleLabel.setBackground(Color.red);
        dashboardtitleLabel.setBounds(180, 50, 250, 30);
        dashboardPanel.add(dashboardtitleLabel);

        myappointButton = new JButton();
        myappointButton.setFont(new Font("Segoe UI", 1, 18));
        myappointButton.setText("My Appointments");
        myappointButton.setBounds(100, 90, 250, 30);
        myappointButton.setForeground(Color.white);
        myappointButton.setBackground(Color.decode("#00ADEF"));
        myappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        myappointButton.setFocusable(false);
        dashboardPanel.add(myappointButton);

        bappointmentButton = new JButton();
        bappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        bappointmentButton.setText("Book an Appointment");
        bappointmentButton.setBounds(100, 130, 250, 30);
        bappointmentButton.setForeground(Color.white);
        bappointmentButton.setBackground(Color.decode("#00ADEF"));
        bappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        bappointmentButton.setFocusable(false);
        dashboardPanel.add(bappointmentButton);

        vdoctorsButton = new JButton();
        vdoctorsButton.setFont(new Font("Segoe UI", 1, 18));
        vdoctorsButton.setText("View Doctors");
        vdoctorsButton.setBounds(100, 170, 250, 30);
        vdoctorsButton.setForeground(Color.white);
        vdoctorsButton.setBackground(Color.decode("#00ADEF"));
        vdoctorsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        vdoctorsButton.setFocusable(false);
        dashboardPanel.add(vdoctorsButton);

        dashboardexitButton = new JButton("Exit");
        dashboardexitButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardexitButton.setBounds(920, 618, 130, 30);
        dashboardexitButton.setBackground(Color.decode("#B8EEFF"));
        dashboardexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardexitButton.setFocusable(false);
        dashboardbackPanel.add(dashboardexitButton);

        //        *************Appointments***************
        appointmentbackPanel = new JPanel();
        appointmentbackPanel.setLayout(null);
        appointmentbackPanel.setBounds(0, 0, 1100, 700);
        appointmentbackPanel.setBackground(Color.decode("#00ADEF"));

        maintitleLabel = new JLabel();
        maintitleLabel.setFont(new Font("Segoe UI", 1, 20));
        maintitleLabel.setForeground(Color.BLACK);
        maintitleLabel.setText("E-Healthcare Management System");
        maintitleLabel.setBounds(150, 30, 400, 40);
        appointmentbackPanel.add(maintitleLabel);

        subtitleLabel = new JLabel();
        subtitleLabel.setFont(new Font("Segoe UI", 1, 15));
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setText("Healthcare on the go, anywhere!");
        subtitleLabel.setBounds(150, 70, 400, 40);
        appointmentbackPanel.add(subtitleLabel);

        appointmentdashboardButton = new JButton("Dashboard");
        appointmentdashboardButton.setFont(new Font("Segoe UI", 1, 18));
        appointmentdashboardButton.setBounds(190, 110, 120, 30);
        appointmentdashboardButton.setBackground(Color.decode("#B8EEFF"));
        appointmentdashboardButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointmentdashboardButton.setFocusable(false);
        appointmentbackPanel.add(appointmentdashboardButton);

        appointmentappointmentButton = new JButton("Appointments");
        appointmentappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        appointmentappointmentButton.setBounds(330, 110, 140, 30);
        appointmentappointmentButton.setBackground(Color.decode("#B8EEFF"));
        appointmentappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointmentappointmentButton.setFocusable(false);
        appointmentbackPanel.add(appointmentappointmentButton);

        appointmentviewButton = new JButton("View Doctors");
        appointmentviewButton.setFont(new Font("Segoe UI", 1, 18));
        appointmentviewButton.setBounds(490, 110, 120, 30);
        appointmentviewButton.setBackground(Color.decode("#B8EEFF"));
        appointmentviewButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointmentviewButton.setFocusable(false);
        appointmentbackPanel.add(appointmentviewButton);

        appointmentsettingsButton = new JButton("Settings");
        appointmentsettingsButton.setFont(new Font("Segoe UI", 1, 18));
        appointmentsettingsButton.setBounds(640, 110, 120, 30);
        appointmentsettingsButton.setBackground(Color.decode("#B8EEFF"));
        appointmentsettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointmentsettingsButton.setFocusable(false);
        appointmentbackPanel.add(appointmentsettingsButton);

        appointmentlogoutButton = new JButton("Log out");
        appointmentlogoutButton.setFont(new Font("Segoe UI", 1, 18));
        appointmentlogoutButton.setBounds(790, 110, 120, 30);
        appointmentlogoutButton.setBackground(Color.decode("#B8EEFF"));
        appointmentlogoutButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointmentlogoutButton.setFocusable(false);
        appointmentbackPanel.add(appointmentlogoutButton);

        appointmentPanel = new JPanel();
        appointmentPanel.setLayout(null);
        appointmentPanel.setBounds(130, 150, 840, 450);
        appointmentPanel.setBackground(Color.decode("#B8EEFF"));
        appointmentbackPanel.add(appointmentPanel);

        appointmenttitleLabel = new JLabel();
        appointmenttitleLabel.setFont(new Font("Segoe UI", 1, 18));
        appointmenttitleLabel.setForeground(Color.BLACK);
        appointmenttitleLabel.setText("Appointments");
        appointmenttitleLabel.setBackground(Color.red);
        appointmenttitleLabel.setBounds(400, 10, 700, 40);
        appointmentPanel.add(appointmenttitleLabel);

        myappointmentButton = new JButton();
        myappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        myappointmentButton.setText("My Appointments");
        myappointmentButton.setBounds(100, 80, 270, 30);
        myappointmentButton.setForeground(Color.white);
        myappointmentButton.setBackground(Color.decode("#00ADEF"));
        myappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        myappointmentButton.setFocusable(false);
        appointmentPanel.add(myappointmentButton);

        bookappointmentButton = new JButton();
        bookappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        bookappointmentButton.setText("Book an Appointment");
        bookappointmentButton.setBounds(100, 140, 270, 30);
        bookappointmentButton.setForeground(Color.white);
        bookappointmentButton.setBackground(Color.decode("#00ADEF"));
        bookappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        bookappointmentButton.setFocusable(false);
        appointmentPanel.add(bookappointmentButton);

        cancelappointmentButton = new JButton();
        cancelappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        cancelappointmentButton.setText("Cancel an Appointment");
        cancelappointmentButton.setBounds(100, 200, 270, 30);
        cancelappointmentButton.setForeground(Color.white);
        cancelappointmentButton.setBackground(Color.decode("#00ADEF"));
        cancelappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        cancelappointmentButton.setFocusable(false);
        appointmentPanel.add(cancelappointmentButton);

        appointmentbackButton = new JButton("Back to Dashboard");
        appointmentbackButton.setFont(new Font("Segoe UI", 1, 18));
        appointmentbackButton.setBounds(45, 618, 170, 30);
        appointmentbackButton.setBackground(Color.decode("#B8EEFF"));
        appointmentbackButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointmentbackButton.setFocusable(false);
        appointmentbackPanel.add(appointmentbackButton);
        
        
        appointmentexitButton = new JButton("Exit");
        appointmentexitButton.setFont(new Font("Segoe UI", 1, 18));
        appointmentexitButton.setBounds(920, 618, 130, 30);
        appointmentexitButton.setBackground(Color.decode("#B8EEFF"));
        appointmentexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointmentexitButton.setFocusable(false);
        appointmentbackPanel.add(appointmentexitButton);
        

        //        *************View Doctors***************
        viewdoctorsbackPanel = new JPanel();
        viewdoctorsbackPanel.setLayout(null);
        viewdoctorsbackPanel.setBounds(0, 0, 1100, 700);
        viewdoctorsbackPanel.setBackground(Color.decode("#00ADEF"));

        maintitleLabel = new JLabel();
        maintitleLabel.setFont(new Font("Segoe UI", 1, 20));
        maintitleLabel.setForeground(Color.BLACK);
        maintitleLabel.setText("E-Healthcare Management System");
        maintitleLabel.setBounds(150, 30, 400, 40);
        viewdoctorsbackPanel.add(maintitleLabel);

        subtitleLabel = new JLabel();
        subtitleLabel.setFont(new Font("Segoe UI", 1, 15));
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setText("Healthcare on the go, anywhere!");
        subtitleLabel.setBounds(150, 70, 400, 40);
        viewdoctorsbackPanel.add(subtitleLabel);

        viewdoctorsdashboardButton = new JButton("Dashboard");
        viewdoctorsdashboardButton.setFont(new Font("Segoe UI", 1, 18));
        viewdoctorsdashboardButton.setBounds(190, 110, 120, 30);
        viewdoctorsdashboardButton.setBackground(Color.decode("#B8EEFF"));
        viewdoctorsdashboardButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        viewdoctorsdashboardButton.setFocusable(false);
        viewdoctorsbackPanel.add(viewdoctorsdashboardButton);

        viewdoctorsappointmentButton = new JButton("Appointments");
        viewdoctorsappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        viewdoctorsappointmentButton.setBounds(330, 110, 140, 30);
        viewdoctorsappointmentButton.setBackground(Color.decode("#B8EEFF"));
        viewdoctorsappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        viewdoctorsappointmentButton.setFocusable(false);
        viewdoctorsbackPanel.add(viewdoctorsappointmentButton);

        viewdoctorsviewButton = new JButton("View Doctors");
        viewdoctorsviewButton.setFont(new Font("Segoe UI", 1, 18));
        viewdoctorsviewButton.setBounds(490, 110, 120, 30);
        viewdoctorsviewButton.setBackground(Color.decode("#B8EEFF"));
        viewdoctorsviewButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        viewdoctorsviewButton.setFocusable(false);
        viewdoctorsbackPanel.add(viewdoctorsviewButton);

        viewdoctorssettingsButton = new JButton("Settings");
        viewdoctorssettingsButton.setFont(new Font("Segoe UI", 1, 18));
        viewdoctorssettingsButton.setBounds(640, 110, 120, 30);
        viewdoctorssettingsButton.setBackground(Color.decode("#B8EEFF"));
        viewdoctorssettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        viewdoctorssettingsButton.setFocusable(false);
        viewdoctorsbackPanel.add(viewdoctorssettingsButton);

        viewdoctorslogoutButton = new JButton("Log out");
        viewdoctorslogoutButton.setFont(new Font("Segoe UI", 1, 18));
        viewdoctorslogoutButton.setBounds(790, 110, 120, 30);
        viewdoctorslogoutButton.setBackground(Color.decode("#B8EEFF"));
        viewdoctorslogoutButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        viewdoctorslogoutButton.setFocusable(false);
        viewdoctorsbackPanel.add(viewdoctorslogoutButton);

        viewdoctorsPanel = new JPanel();
        viewdoctorsPanel.setLayout(null);
        viewdoctorsPanel.setBounds(130, 150, 840, 450);
        viewdoctorsPanel.setBackground(Color.decode("#B8EEFF"));
        viewdoctorsbackPanel.add(viewdoctorsPanel);

        viewdoctorstitleLabel = new JLabel();
        viewdoctorstitleLabel.setFont(new Font("Segoe UI", 1, 18));
        viewdoctorstitleLabel.setForeground(Color.BLACK);
        viewdoctorstitleLabel.setText("View All Doctors");
        viewdoctorstitleLabel.setBackground(Color.red);
        viewdoctorstitleLabel.setBounds(400, 10, 700, 40);
        viewdoctorsPanel.add(viewdoctorstitleLabel);

        vadoctorsviewButton = new JButton();
        vadoctorsviewButton.setFont(new Font("Segoe UI", 1, 18));
        vadoctorsviewButton.setText("View All Doctors");
        vadoctorsviewButton.setBounds(100, 80, 270, 30);
        vadoctorsviewButton.setForeground(Color.white);
        vadoctorsviewButton.setBackground(Color.decode("#00ADEF"));
        vadoctorsviewButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        vadoctorsviewButton.setFocusable(false);
        viewdoctorsPanel.add(vadoctorsviewButton);

        viewdoctorssbackButton = new JButton("Back to Dashboard");
        viewdoctorssbackButton.setFont(new Font("Segoe UI", 1, 18));
        viewdoctorssbackButton.setBounds(45, 618, 170, 30);
        viewdoctorssbackButton.setBackground(Color.decode("#B8EEFF"));
        viewdoctorssbackButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        viewdoctorssbackButton.setFocusable(false);
        viewdoctorsbackPanel.add(viewdoctorssbackButton);
        
        
        viewexitButton = new JButton("Exit");
        viewexitButton.setFont(new Font("Segoe UI", 1, 18));
        viewexitButton.setBounds(920, 618, 130, 30);
        viewexitButton.setBackground(Color.decode("#B8EEFF"));
        viewexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        viewexitButton.setFocusable(false);
        viewdoctorsbackPanel.add(viewexitButton);
        

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

        settingsappointmentButton = new JButton("Appointments");
        settingsappointmentButton.setFont(new Font("Segoe UI", 1, 18));
        settingsappointmentButton.setBounds(330, 110, 140, 30);
        settingsappointmentButton.setBackground(Color.decode("#B8EEFF"));
        settingsappointmentButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingsappointmentButton.setFocusable(false);
        settingsbackPanel.add(settingsappointmentButton);

        settingsviewButton = new JButton("View Doctors");
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
        
        
        recoveridButton = new JButton();
        recoveridButton.setFont(new Font("Segoe UI", 1, 18));
        recoveridButton.setText("Recover Your ID");
        recoveridButton.setBounds(100, 200, 250, 30);
        recoveridButton.setForeground(Color.white);
        recoveridButton.setBackground(Color.decode("#00ADEF"));
        recoveridButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        recoveridButton.setFocusable(false);
        settingsPanel.add(recoveridButton);
        
        
        recoverauthButton = new JButton();
        recoverauthButton.setFont(new Font("Segoe UI", 1, 18));
        recoverauthButton.setText("Recover Your Authcode");
        recoverauthButton.setBounds(100, 260, 250, 30);
        recoverauthButton.setForeground(Color.white);
        recoverauthButton.setBackground(Color.decode("#00ADEF"));
        recoverauthButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        recoverauthButton.setFocusable(false);
        settingsPanel.add(recoverauthButton);
        

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
        mainTab.add("Appointment", appointmentbackPanel);
        mainTab.add("View Doctors", viewdoctorsbackPanel);
        mainTab.add("Settings", settingsbackPanel);
        mainPanel.add(mainTab);

        //DashboardPanel action listeners
        dashboarddashboardButton.addActionListener(this);
        dashboardappointmentButton.addActionListener(this);
        dashboardviewButton.addActionListener(this);
        dashboardsettingsButton.addActionListener(this);
        dashboardlogoutButton.addActionListener(this);
        myappointButton.addActionListener(this);
        bappointmentButton.addActionListener(this);
        vdoctorsButton.addActionListener(this);
        dashboardexitButton.addActionListener(this);

        //AppointmentPanel action listeners
        appointmentdashboardButton.addActionListener(this);
        appointmentappointmentButton.addActionListener(this);
        appointmentviewButton.addActionListener(this);
        appointmentsettingsButton.addActionListener(this);
        appointmentlogoutButton.addActionListener(this);
        myappointmentButton.addActionListener(this);
        bookappointmentButton.addActionListener(this);
        cancelappointmentButton.addActionListener(this);
        // editnurseButton.addActionListener(this);
        appointmentbackButton.addActionListener(this);
        appointmentexitButton.addActionListener(this);

        //View Doctors Panel action listeners
        viewdoctorsdashboardButton.addActionListener(this);
        viewdoctorsappointmentButton.addActionListener(this);
        viewdoctorsviewButton.addActionListener(this);
        viewdoctorssettingsButton.addActionListener(this);
        viewdoctorslogoutButton.addActionListener(this);
        vadoctorsviewButton.addActionListener(this);
        viewdoctorssbackButton.addActionListener(this);
        viewexitButton.addActionListener(this);

        //Settings Panel action listeners
        settingsdashboardButton.addActionListener(this);
        settingsappointmentButton.addActionListener(this);
        settingsviewButton.addActionListener(this);
        settingssettingsButton.addActionListener(this);
        settingslogoutButton.addActionListener(this);
        changeinfoButton.addActionListener(this);
        changepassButton.addActionListener(this);
        recoveridButton.addActionListener(this);
        recoverauthButton.addActionListener(this);
        settingsbackButton.addActionListener(this);
        settingsexitButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Dashboard Action Performed
        if (e.getSource() == dashboarddashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == dashboardappointmentButton) {
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
        } else if (e.getSource() == bappointmentButton) {
            this.setVisible(false);
            new PatientBookAppoint().setVisible(true);
        } else if (e.getSource() == myappointButton) {
            this.setVisible(false);
            new PatientViewAppoint().setVisible(true);
        } else if (e.getSource() == vdoctorsButton) {
            this.setVisible(false);
            new PatientViewDoctor().setVisible(true);
            
        }else if (e.getSource() == dashboardexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        } // Appointment Action Performed
        else if (e.getSource() == appointmentdashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == appointmentappointmentButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == appointmentviewButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == appointmentsettingsButton) {
            mainTab.setSelectedIndex(3);
        } else if (e.getSource() == appointmentlogoutButton) {
            int managedecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (managedecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == appointmentbackButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == myappointmentButton) {
            this.dispose();
            new PatientViewAppoint().setVisible(true);
        }else if (e.getSource() == bookappointmentButton) {
            this.dispose();
            new PatientBookAppoint().setVisible(true);
        } else if (e.getSource() == cancelappointmentButton) {
            this.dispose();
            new PatientEditAppoint().setVisible(true);
        }else if (e.getSource() == appointmentexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }// View Doctors Action Performed }
        else if (e.getSource() == viewdoctorsdashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == viewdoctorsappointmentButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == viewdoctorsviewButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == viewdoctorssettingsButton) {
            mainTab.setSelectedIndex(3);
        } else if (e.getSource() == viewdoctorslogoutButton) {
            int detailsdecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (detailsdecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }

        } else if (e.getSource() == vadoctorsviewButton) {
            this.setVisible(false);
            new PatientViewDoctor().setVisible(true);

        } else if (e.getSource() == viewdoctorssbackButton) {
            mainTab.setSelectedIndex(0);
        }else if (e.getSource() == viewexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }// Settings Action Performed
        else if (e.getSource() == settingsdashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == settingsappointmentButton) {
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
            this.setVisible(false);
            new PatientChangeInfo().setVisible(true);
        } else if (e.getSource() == changepassButton) {
            new PatientChangePass().setVisible(true);
        } else if (e.getSource() == recoveridButton) {
            new PatientRecoverId().setVisible(true);
        } else if (e.getSource() == recoverauthButton) {
            new PatientRecoverAuth().setVisible(true);
        } else if (e.getSource() == settingsbackButton) {
            mainTab.setSelectedIndex(0);
        }else if (e.getSource() == settingsexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Patientdashboard dashboard = new Patientdashboard();
        dashboard.setVisible(true);

    }

}
