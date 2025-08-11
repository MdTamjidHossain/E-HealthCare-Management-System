
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public final class Loginpage extends JFrame implements ActionListener, MouseListener {  //inheritance, interface

    private JPanel mainPanel;
    private JLabel backgroundLabel, welcomeLabel, titleLabel, loginLabel, userIdLabel, passwordLabel, usertypeLabel, questionLabel;
    private JTextField userIdTextField;
    private JPasswordField passwordField;
    private JButton  clearButton, loginButton, signupButton;
    private JRadioButton adminButton, doctorButton, patientButton;
    private ButtonGroup group;
    private ImageIcon background;

    public Loginpage() {
        initComponents();
        initComponents(1100, 700);
    }

    final void initComponents() {  //final keyword
        
        this.setTitle("Loginpage");  //this keyword
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(getToolkit().getImage("C:\\Users\\Tamjid\\Desktop\\ourproject\\logo.png"));
    }
    
    final void initComponents(int x, int y){ //method overloaded//polymorphism

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, x, y);
        mainPanel.setBackground(Color.decode("#075bd7"));
        mainPanel.setLayout(null);
        this.add(mainPanel);

        welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Segoe UI", 1, 17));
        welcomeLabel.setForeground(new Color(6, 90, 215));
        welcomeLabel.setText("Welcome To");
        welcomeLabel.setBounds(820, 30, 120, 15);
        mainPanel.add(welcomeLabel);

        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Segoe UI", 1, 21));
        titleLabel.setForeground(new Color(6, 90, 215));
        titleLabel.setText("E HealthCare Management System");
        titleLabel.setBounds(700, 60, 350, 30);
        mainPanel.add(titleLabel);

        loginLabel = new JLabel();
        loginLabel.setFont(new Font("Segoe UI", 1, 24));
//      loginLabel.setForeground(new java.awt.Color(6, 90, 215));
        loginLabel.setText("Login");
        loginLabel.setBounds(850, 130, 100, 50);
        mainPanel.add(loginLabel);

        userIdLabel = new JLabel();
        userIdLabel.setFont(new Font("Segoe UI", 1, 16));
        userIdLabel.setText("Username:");
        userIdLabel.setBounds(750, 230, 90, 30);
        mainPanel.add(userIdLabel);

        userIdTextField = new JTextField();
        userIdTextField.setFont(new Font("Segoe UI", 1, 16));
        userIdTextField.setText("");
        userIdTextField.setBounds(840, 230, 170, 35);
        userIdTextField.setBorder(new LineBorder(Color.decode("#12E5DC"), 2));
        mainPanel.add(userIdTextField);

        passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("Segoe UI", 1, 16));
        passwordLabel.setText("Password:");
        passwordLabel.setBounds(750, 280, 80, 30);
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", 1, 16));
        passwordField.setText("");
        passwordField.setEchoChar('*');
        passwordField.setBounds(840, 280, 170, 35);
        passwordField.setBorder(new LineBorder(Color.decode("#12E5DC"), 2));
        mainPanel.add(passwordField);

//        showpassButton = new JButton();
//        showpassButton.setBounds(940, 320, 40, 40);
//        ImageIcon icon = new ImageIcon("C:\\Users\\Tamjid\\Desktop\\project\\showpass.png");
//        Image img = icon.getImage();
//        Image imgscale = img.getScaledInstance(showpassButton.getWidth(), showpassButton.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(imgscale);
//        showpassButton.setIcon(scaledIcon);
//
//        mainPanel.add(showpassButton);

        usertypeLabel = new JLabel();
        usertypeLabel.setFont(new Font("Segoe UI", 1, 16));
        usertypeLabel.setText("User Type:");
        usertypeLabel.setBounds(750, 330, 80, 30);
        mainPanel.add(usertypeLabel);

        adminButton = new JRadioButton("Admin");
        adminButton.setFont(new Font("Segoe UI", 1, 16));
        adminButton.setBounds(840, 330, 170, 30);
        adminButton.setBackground(Color.white);
        adminButton.setFocusable(false);
        mainPanel.add(adminButton);

        doctorButton = new JRadioButton("Doctor");
        doctorButton.setFont(new Font("Segoe UI", 1, 16));
        doctorButton.setBounds(840, 370, 170, 30);
        doctorButton.setBackground(Color.white);
        doctorButton.setFocusable(false);
        mainPanel.add(doctorButton);

        patientButton = new JRadioButton("Patient");
        patientButton.setFont(new Font("Segoe UI", 1, 16));
        patientButton.setBounds(840, 410, 170, 30);
        patientButton.setBackground(Color.white);
        patientButton.setFocusable(false);
        mainPanel.add(patientButton);

        group = new ButtonGroup();
        group.add(adminButton);
        group.add(doctorButton);
        group.add(patientButton);

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Segoe UI", 1, 18));
        clearButton.setBounds(770, 480, 90, 30);
        clearButton.setBackground(Color.decode("#37f9f8"));
        clearButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        clearButton.setFocusable(false);
        mainPanel.add(clearButton);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", 1, 18));
        loginButton.setBounds(890, 480, 90, 30);
        loginButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        loginButton.setBackground(Color.decode("#37f9f8"));
        loginButton.setFocusable(false);
        mainPanel.add(loginButton);

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Segoe UI", 1, 16));
        questionLabel.setText("Don't Have An Account?");
        questionLabel.setBounds(780, 520, 350, 40);
        mainPanel.add(questionLabel);

        signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Segoe UI", 1, 13));
        signupButton.setBounds(830, 570, 85, 25);
        signupButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        signupButton.setBackground(Color.decode("#37f9f8"));
        signupButton.setFocusable(false);
        mainPanel.add(signupButton);

        background = new ImageIcon("C:\\Users\\Tamjid\\Desktop\\ourproject\\background.png");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1086, 666);
        mainPanel.add(backgroundLabel);

        clearButton.addActionListener(this);
        clearButton.addMouseListener(this);
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        signupButton.addActionListener(this);
        signupButton.addMouseListener(this);

    }

    Connection con = null;
    Statement st = null;

    @Override
    public void actionPerformed(ActionEvent e) {  //interface method overriding //polymorphism

        String userName = userIdTextField.getText();
        String password = passwordField.getText();

        if (e.getSource() == clearButton) {
            userIdTextField.setText("");
            passwordField.setText("");
            group.clearSelection();
        } else if (e.getSource() == loginButton) {
            if (adminButton.isSelected()) {
                try {    //exception handling
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");
                    Statement st = con.createStatement();
                    String sql = "select * from admin where BINARY username='" + userName + "'and BINARY password = '" + password + "'";
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {
                        dispose();
                        Admindashboard dashboard = new Admindashboard();
                        dashboard.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is wrong");
                    }
                    con.close();
                    st.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else if (doctorButton.isSelected()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");
                    Statement st = con.createStatement();
                    String sql = "select * from doctor where BINARY username='" + userName + "'and BINARY password = '" + password + "'";
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {
                        dispose();
                        DoctorDashboard dashboard = new DoctorDashboard();
                        dashboard.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is wrong");
                    }
                    con.close();
                    st.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else if (patientButton.isSelected()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");
                    Statement st = con.createStatement();
                    String sql = "select * from patient where BINARY username='" + userName + "'and BINARY password = '" + password + "'";
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {
                        dispose();
                        Patientdashboard dashboard = new Patientdashboard();
                        dashboard.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is wrong");
                    }
                    con.close();
                    st.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }

            } else if ((userIdTextField.getText().isEmpty()) || (passwordField.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Please enter both username and password.");

            } else {
                JOptionPane.showMessageDialog(null, "Please select user type.");
            }

        } else if (e.getSource() == signupButton) {
            this.setVisible(false);
            Signupselect signupselect = new Signupselect();
            signupselect.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == loginButton) {
            loginButton.setBackground(Color.decode("#00ADEF"));
            loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == clearButton) {
            clearButton.setBackground(Color.decode("#00ADEF"));
            clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == signupButton) {
            signupButton.setBackground(Color.decode("#00ADEF"));
            signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == loginButton) {
            loginButton.setBackground(Color.decode("#37f9f8"));
        } else if (e.getSource() == clearButton) {
            clearButton.setBackground(Color.decode("#37f9f8"));
        } else if (e.getSource() == signupButton) {
            signupButton.setBackground(Color.decode("#37f9f8"));
        }
    }

    public static void main(String[] args) {
        Loginpage login = new Loginpage();
        login.setVisible(true);

    }
}
