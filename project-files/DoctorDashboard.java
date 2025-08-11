
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
import javax.swing.border.LineBorder;

public class DoctorDashboard extends JFrame implements ActionListener {

    private JTabbedPane mainTab;
    private JLabel maintitleLabel, subtitleLabel, dashboardtitleLabel, dashboardsubtitleLabel, quickLabel, managetitleLabel, detailstitleLabel,
            settingstitleLabel;
    private JPanel mainPanel, dashboardbackPanel, dashboardPanel, appointbackPanel, appointPanel,
            settingsbackPanel, settingsPanel;
    private JButton dashboarddashboardButton, dashboardappointButton, dashboardsettingsButton,
            dashboardlogoutButton, dashboardviewappointButton, dashboardcancelappointButton, dashboardexitButton;
    private JButton appointdashboardButton, appointappointButton, appointsettingsButton,
            appointlogoutButton, appointviewappointButton, appointcancelappointButton,
            appointbackButton, appointexitButton;
    private JButton settingsdashboardButton, settingsappointButton, settingssettingsButton,
            settingslogoutButton, changeinfoButton, changepassButton, recoveridButton, 
            recoverauthButton,settingsbackButton, settingsexitButton;
    private Connection con = null;
    private Statement st = null;

    public DoctorDashboard() {
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

        dashboardappointButton = new JButton("Appointments");
        dashboardappointButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardappointButton.setBounds(340, 110, 150, 30);
        dashboardappointButton.setBackground(Color.decode("#B8EEFF"));
        dashboardappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardappointButton.setFocusable(false);
        dashboardbackPanel.add(dashboardappointButton);

        dashboardsettingsButton = new JButton("Settings");
        dashboardsettingsButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardsettingsButton.setBounds(520, 110, 120, 30);
        dashboardsettingsButton.setBackground(Color.decode("#B8EEFF"));
        dashboardsettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardsettingsButton.setFocusable(false);
        dashboardbackPanel.add(dashboardsettingsButton);

        dashboardlogoutButton = new JButton("Log out");
        dashboardlogoutButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardlogoutButton.setBounds(670, 110, 120, 30);
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
        dashboardtitleLabel.setFont(new Font("Segoe UI", 1, 20));
        dashboardtitleLabel.setForeground(Color.BLACK);
        dashboardtitleLabel.setText("Welcome to E-Healthcare Management System Doctor's Dashboard");
        dashboardtitleLabel.setBounds(100, 5, 700, 40);
        dashboardPanel.add(dashboardtitleLabel);

        quickLabel = new JLabel();
        quickLabel.setFont(new Font("Segoe UI", 1, 18));
        quickLabel.setForeground(Color.BLACK);
        quickLabel.setText("<HTML><U>Quick Links</U></HTML>");
        quickLabel.setBounds(180, 50, 300, 40);
        dashboardPanel.add(quickLabel);

        dashboardviewappointButton = new JButton();
        dashboardviewappointButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardviewappointButton.setText("View Your Appointments");
        dashboardviewappointButton.setBounds(100, 100, 250, 30);
        dashboardviewappointButton.setForeground(Color.white);
        dashboardviewappointButton.setBackground(Color.decode("#00ADEF"));
        dashboardviewappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardviewappointButton.setFocusable(false);
        dashboardPanel.add(dashboardviewappointButton);

        dashboardcancelappointButton = new JButton();
        dashboardcancelappointButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardcancelappointButton.setText("Cancel Appointments");
        dashboardcancelappointButton.setBounds(100, 160, 250, 30);
        dashboardcancelappointButton.setForeground(Color.white);
        dashboardcancelappointButton.setBackground(Color.decode("#00ADEF"));
        dashboardcancelappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardcancelappointButton.setFocusable(false);
        dashboardPanel.add(dashboardcancelappointButton);

        dashboardexitButton = new JButton("Exit");
        dashboardexitButton.setFont(new Font("Segoe UI", 1, 18));
        dashboardexitButton.setBounds(920, 618, 130, 30);
        dashboardexitButton.setBackground(Color.decode("#B8EEFF"));
        dashboardexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        dashboardexitButton.setFocusable(false);
        dashboardbackPanel.add(dashboardexitButton);

        //        *************Appointments***************
        appointbackPanel = new JPanel();
        appointbackPanel.setLayout(null);
        appointbackPanel.setBounds(0, 0, 1100, 700);
        appointbackPanel.setBackground(Color.decode("#00ADEF"));

        maintitleLabel = new JLabel();
        maintitleLabel.setFont(new Font("Segoe UI", 1, 20));
        maintitleLabel.setForeground(Color.BLACK);
        maintitleLabel.setText("E-Healthcare Management System");
        maintitleLabel.setBounds(150, 30, 400, 40);
        appointbackPanel.add(maintitleLabel);

        subtitleLabel = new JLabel();
        subtitleLabel.setFont(new Font("Segoe UI", 1, 15));
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setText("Healthcare on the go, anywhere!");
        subtitleLabel.setBounds(150, 70, 400, 40);
        appointbackPanel.add(subtitleLabel);

        appointdashboardButton = new JButton("Dashboard");
        appointdashboardButton.setFont(new Font("Segoe UI", 1, 18));
        appointdashboardButton.setBounds(190, 110, 120, 30);
        appointdashboardButton.setBackground(Color.decode("#B8EEFF"));
        appointdashboardButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointdashboardButton.setFocusable(false);
        appointbackPanel.add(appointdashboardButton);

        appointappointButton = new JButton("Appointments");
        appointappointButton.setFont(new Font("Segoe UI", 1, 18));
        appointappointButton.setBounds(340, 110, 150, 30);
        appointappointButton.setBackground(Color.decode("#B8EEFF"));
        appointappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointappointButton.setFocusable(false);
        appointbackPanel.add(appointappointButton);

        appointsettingsButton = new JButton("Settings");
        appointsettingsButton.setFont(new Font("Segoe UI", 1, 18));
        appointsettingsButton.setBounds(520, 110, 120, 30);
        appointsettingsButton.setBackground(Color.decode("#B8EEFF"));
        appointsettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointsettingsButton.setFocusable(false);
        appointbackPanel.add(appointsettingsButton);

        appointlogoutButton = new JButton("Log out");
        appointlogoutButton.setFont(new Font("Segoe UI", 1, 18));
        appointlogoutButton.setBounds(670, 110, 120, 30);
        appointlogoutButton.setBackground(Color.decode("#B8EEFF"));
        appointlogoutButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointlogoutButton.setFocusable(false);
        appointbackPanel.add(appointlogoutButton);

        appointPanel = new JPanel();
        appointPanel.setLayout(null);
        appointPanel.setBounds(130, 150, 840, 450);
        appointPanel.setBackground(Color.decode("#B8EEFF"));
        appointbackPanel.add(appointPanel);

        managetitleLabel = new JLabel();
        managetitleLabel.setFont(new Font("Segoe UI", 1, 18));
        managetitleLabel.setForeground(Color.BLACK);
        managetitleLabel.setText("Appointments");
        managetitleLabel.setBackground(Color.red);
        managetitleLabel.setBounds(0, 0, 840, 40);
        managetitleLabel.setHorizontalAlignment(JLabel.CENTER);
        appointPanel.add(managetitleLabel);

        appointviewappointButton = new JButton();
        appointviewappointButton.setFont(new Font("Segoe UI", 1, 18));
        appointviewappointButton.setText("View All Appointments");
        appointviewappointButton.setBounds(100, 80, 270, 30);
        appointviewappointButton.setForeground(Color.white);
        appointviewappointButton.setBackground(Color.decode("#00ADEF"));
        appointviewappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointviewappointButton.setFocusable(false);
        appointPanel.add(appointviewappointButton);

        appointcancelappointButton = new JButton();
        appointcancelappointButton.setFont(new Font("Segoe UI", 1, 18));
        appointcancelappointButton.setText("Cancel Appointments");
        appointcancelappointButton.setBounds(100, 140, 270, 30);
        appointcancelappointButton.setForeground(Color.white);
        appointcancelappointButton.setBackground(Color.decode("#00ADEF"));
        appointcancelappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointcancelappointButton.setFocusable(false);
        appointPanel.add(appointcancelappointButton);

        appointbackButton = new JButton("Back to Dashboard");
        appointbackButton.setFont(new Font("Segoe UI", 1, 18));
        appointbackButton.setBounds(45, 618, 170, 30);
        appointbackButton.setBackground(Color.decode("#B8EEFF"));
        appointbackButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointbackButton.setFocusable(false);
        appointbackPanel.add(appointbackButton);
        
        
        appointexitButton = new JButton("Exit");
        appointexitButton.setFont(new Font("Segoe UI", 1, 18));
        appointexitButton.setBounds(920, 618, 130, 30);
        appointexitButton.setBackground(Color.decode("#B8EEFF"));
        appointexitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        appointexitButton.setFocusable(false);
        appointbackPanel.add(appointexitButton);
        

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

        settingsappointButton = new JButton("Appointments");
        settingsappointButton.setFont(new Font("Segoe UI", 1, 18));
        settingsappointButton.setBounds(340, 110, 150, 30);
        settingsappointButton.setBackground(Color.decode("#B8EEFF"));
        settingsappointButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingsappointButton.setFocusable(false);
        settingsbackPanel.add(settingsappointButton);

        settingssettingsButton = new JButton("Settings");
        settingssettingsButton.setFont(new Font("Segoe UI", 1, 18));
        settingssettingsButton.setBounds(520, 110, 120, 30);
        settingssettingsButton.setBackground(Color.decode("#B8EEFF"));
        settingssettingsButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        settingssettingsButton.setFocusable(false);
        settingsbackPanel.add(settingssettingsButton);

        settingslogoutButton = new JButton("Log out");
        settingslogoutButton.setFont(new Font("Segoe UI", 1, 18));
        settingslogoutButton.setBounds(670, 110, 120, 30);
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
        settingstitleLabel.setBounds(0, 0, 840, 40);
        settingstitleLabel.setHorizontalAlignment(JLabel.CENTER);
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
        mainTab.add("Appointments", appointbackPanel);
        mainTab.add("Settings", settingsbackPanel);
        mainPanel.add(mainTab);

        //DashboardPanel action listeners
        dashboarddashboardButton.addActionListener(this);
        dashboardappointButton.addActionListener(this);
        dashboardsettingsButton.addActionListener(this);
        dashboardlogoutButton.addActionListener(this);
        dashboardviewappointButton.addActionListener(this);
        dashboardcancelappointButton.addActionListener(this);
        dashboardexitButton.addActionListener(this);

        //AppointPanel action listeners
        appointdashboardButton.addActionListener(this);
        appointappointButton.addActionListener(this);
        appointsettingsButton.addActionListener(this);
        appointlogoutButton.addActionListener(this);
        appointviewappointButton.addActionListener(this);
        appointcancelappointButton.addActionListener(this);
        appointbackButton.addActionListener(this);
        appointexitButton.addActionListener(this);

        //Settings Panel action listeners
        settingsdashboardButton.addActionListener(this);
        settingsappointButton.addActionListener(this);
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
        } else if (e.getSource() == dashboardappointButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == dashboardsettingsButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == dashboardlogoutButton) {
            int dashboarddecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (dashboarddecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == dashboardviewappointButton) {
            this.setVisible(false);
            new DoctorViewAppoint().setVisible(true);
        } else if (e.getSource() == dashboardcancelappointButton) {
            this.setVisible(false);
            new DoctorEditAppoint().setVisible(true);
        } else if (e.getSource() == dashboardexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        } // Appointment Action Performed
        else if (e.getSource() == appointdashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == appointappointButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == appointsettingsButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == appointlogoutButton) {
            int managedecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (managedecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == appointbackButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == appointviewappointButton) {
            this.setVisible(false);
            new DoctorViewAppoint().setVisible(true);
        } else if (e.getSource() == appointcancelappointButton) {
            this.setVisible(false);
            new DoctorEditAppoint().setVisible(true);
        }else if (e.getSource() == appointexitButton) {
            int dashboardexit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", 2);
            if (dashboardexit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }// Settings Action Performed
        else if (e.getSource() == settingsdashboardButton) {
            mainTab.setSelectedIndex(0);
        } else if (e.getSource() == settingsappointButton) {
            mainTab.setSelectedIndex(1);
        } else if (e.getSource() == settingssettingsButton) {
            mainTab.setSelectedIndex(2);
        } else if (e.getSource() == settingslogoutButton) {
            int settingsdecision = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", 2);
            if (settingsdecision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Loginpage login = new Loginpage();
                login.setVisible(true);
            }
        } else if (e.getSource() == changeinfoButton) {
            this.setVisible(false);
            new DoctorChangeInfo().setVisible(true);
        } else if (e.getSource() == changepassButton) {
            DoctorChangePass pass = new DoctorChangePass();
            pass.setVisible(true);
        } else if (e.getSource() == recoveridButton) {
            new DoctorRecoverId().setVisible(true);
        } else if (e.getSource() == recoverauthButton) {
            new DoctorRecoverAuth().setVisible(true);
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
        DoctorDashboard dashboard = new DoctorDashboard();
        dashboard.setVisible(true);

    }

}
