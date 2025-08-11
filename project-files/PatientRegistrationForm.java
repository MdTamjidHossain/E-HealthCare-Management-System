
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class PatientRegistrationForm extends JFrame implements ActionListener {

    private JPanel RegisterPanel, MainPanel;
    private JLabel Maintitle, Name, Address, MobileNo, Email, Username, Password, ConfirmPassword, DateofBirth, Gender;
    private JButton BackButton, SubmitButton;
    private JTextField NameField, AddressField, MobileNoField, EmailField, PasswordField, ConfirmPasswordField, UsernameField, DateField;
    private JComboBox GenderComboBox;
    private JDateChooser date;
    String gender[] = {"Male", "Female", "Others"};
    private Connection con = null;
    private PreparedStatement pst = null;
    private Statement st = null;
    String getId, authId;

    public PatientRegistrationForm() {
        initcomponents();
    }

    public void initcomponents() {
        this.setTitle("Patient Registration Form");
        this.setSize(1100, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(getToolkit().getImage("C:\\Users\\Tamjid\\Desktop\\ourproject\\logo.png"));

        MainPanel = new JPanel();
        MainPanel.setBounds(0, 0, 1100, 700);
        MainPanel.setBackground(Color.decode("#00ADEF"));
        MainPanel.setLayout(null);
        this.add(MainPanel);

        RegisterPanel = new JPanel();
        RegisterPanel.setBounds(240, 30, 600, 600);
        RegisterPanel.setBackground(Color.decode("#B8EEFF"));
        RegisterPanel.setLayout(null);
        MainPanel.add(RegisterPanel);

        Maintitle = new JLabel();
        Maintitle.setText("Patient Registration Form");
        Maintitle.setFont(new Font("Sageo UI", 1, 24));
        Maintitle.setBounds(170, 15, 450, 40);
        RegisterPanel.add(Maintitle);

        Name = new JLabel();
        Name.setText("Patient's Name:");
        Name.setFont(new Font("Sageo UI", 1, 16));
        Name.setBounds(50, 100, 200, 20);
        RegisterPanel.add(Name);

        NameField = new JTextField();
        NameField.setBounds(250, 100, 300, 25);
        NameField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(NameField);

        Gender = new JLabel();
        Gender.setText("Select Gender:");
        Gender.setFont(new Font("Sageo UI", 1, 16));
        Gender.setBounds(50, 140, 200, 20);
        RegisterPanel.add(Gender);

        GenderComboBox = new JComboBox(gender);
        GenderComboBox.setBounds(250, 140, 300, 25);
        GenderComboBox.setFocusable(false);
        GenderComboBox.setBorder(new LineBorder(Color.black, 1));
        GenderComboBox.setSelectedIndex(-1);
        RegisterPanel.add(GenderComboBox);

        DateofBirth = new JLabel();
        DateofBirth.setText("Date Of Birth:");
        DateofBirth.setFont(new Font("Sageo UI", 1, 16));
        DateofBirth.setBounds(50, 180, 200, 20);
        RegisterPanel.add(DateofBirth);

//    DateField = new JTextField();
//    DateField.setBounds(250,180,300,25);
//    DateField.setBorder(new LineBorder(Color.black,1));
//    RegisterPanel.add(DateField);
        date = new JDateChooser();
        date.setDateFormatString("dd MMM, yyyy");
        date.setBounds(250, 180, 300, 25);
        date.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(date);

        Address = new JLabel();
        Address.setText("Address:");
        Address.setFont(new Font("Sageo UI", 1, 16));
        Address.setBounds(50, 220, 200, 20);
        RegisterPanel.add(Address);

        AddressField = new JTextField();
        AddressField.setBounds(250, 220, 300, 25);
        AddressField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(AddressField);

        MobileNo = new JLabel();
        MobileNo.setText("Mobile Number:");
        MobileNo.setFont(new Font("Sageo UI", 1, 16));
        MobileNo.setBounds(50, 260, 200, 20);
        RegisterPanel.add(MobileNo);

        MobileNoField = new JTextField();
        MobileNoField.setBounds(250, 260, 300, 25);
        MobileNoField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(MobileNoField);

        Email = new JLabel();
        Email.setText("Email ID:");
        Email.setFont(new Font("Sageo UI", 1, 16));
        Email.setBounds(50, 300, 200, 20);
        RegisterPanel.add(Email);

        EmailField = new JTextField();
        EmailField.setBounds(250, 300, 300, 25);
        EmailField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(EmailField);

        Username = new JLabel();
        Username.setText("Username:");
        Username.setFont(new Font("Sageo UI", 1, 16));
        Username.setBounds(50, 340, 200, 20);
        RegisterPanel.add(Username);

        UsernameField = new JTextField();
        UsernameField.setBounds(250, 340, 300, 25);
        UsernameField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(UsernameField);

        Password = new JLabel();
        Password.setText("Password:");
        Password.setFont(new Font("Sageo UI", 1, 16));
        Password.setBounds(50, 380, 200, 20);
        RegisterPanel.add(Password);

        PasswordField = new JTextField();
        PasswordField.setBounds(250, 380, 300, 25);
        PasswordField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(PasswordField);

        ConfirmPassword = new JLabel();
        ConfirmPassword.setText("Confirm Password:");
        ConfirmPassword.setFont(new Font("Sageo UI", 1, 16));
        ConfirmPassword.setBounds(50, 420, 200, 20);
        RegisterPanel.add(ConfirmPassword);

        ConfirmPasswordField = new JTextField();
        ConfirmPasswordField.setBounds(250, 420, 300, 25);
        ConfirmPasswordField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(ConfirmPasswordField);

        BackButton = new JButton();
        BackButton.setFont(new Font("Segoe UI", 1, 18));
        BackButton.setBounds(70, 600, 90, 30);
        BackButton.setFocusable(false);
        BackButton.setText("Back");
        BackButton.addActionListener(this);
        BackButton.setBorder(new LineBorder(Color.black, 1));
        MainPanel.add(BackButton);

        SubmitButton = new JButton();
        SubmitButton.setFont(new Font("Segoe UI", 1, 18));
        SubmitButton.setBounds(925, 600, 90, 30);
        SubmitButton.setFocusable(false);
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(this);
        SubmitButton.setBorder(new LineBorder(Color.black, 1));
        MainPanel.add(SubmitButton);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SubmitButton) {
            if (NameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid name!");
            } else if (GenderComboBox.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Please enter a valid gender!");
            } else if (((JTextField) date.getDateEditor().getUiComponent()).getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid date of birth!");
            } else if (Address.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid address!");
            } else if (MobileNo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid mobile number!");
            } else if (Email.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
            } else if (UsernameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid username!");
            } else if (Password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid password!");
            } else if (ConfirmPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please confirm your password!");
            } else if(!(ConfirmPasswordField.getText().equals(PasswordField.getText()))){
                JOptionPane.showMessageDialog(null, "Both passwords must match!");
            }
            else {
                try {
                    String query1 = "INSERT INTO `patient`( `name`, `gender`, `dob`, `address`, `mobile`, `email`, `username`, `password`,`authcode`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query1);

                    Random rand = new Random();
                    int i = rand.nextInt(8001) + 1000;
                    String random = String.valueOf(i);

                    pst.setString(1, NameField.getText());
                    pst.setString(2, GenderComboBox.getSelectedItem().toString());
                    pst.setString(3, ((JTextField) date.getDateEditor().getUiComponent()).getText());
                    pst.setString(4, AddressField.getText());
                    pst.setString(5, MobileNoField.getText());
                    pst.setString(6, EmailField.getText());
                    pst.setString(7, UsernameField.getText());
                    pst.setString(8, PasswordField.getText());
                    pst.setString(9, random);
                    pst.setString(10, "unverified");

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully registered, check your email for verification!");

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                        Statement st = con.createStatement();
                        String query2 = "select * from patient where binary name = '" + NameField.getText()
                                + "' and dob='" + ((JTextField) date.getDateEditor().getUiComponent()).getText() + "' and binary username='" + UsernameField.getText()
                                + "'";
                        ResultSet rs = st.executeQuery(query2);
                        while (rs.next()) {
                            getId = rs.getString("id");
                            authId = rs.getString("authcode");
                        }
                        JavaMailUtil.sendMail(EmailField.getText(), getId, authId);
                        con.close();
                        st.close();
                        new PatientTwoStep().setVisible(true);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }

                    con.close();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }
                this.dispose();
            }
        } else if (e.getSource() == BackButton) {
            int decision = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back? Your progress will be lost!", "Back Confirmation", 2);
            if (decision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                Signupselect select = new Signupselect();
                select.setVisible(true);
            }

        }
    }

    public static void main(String[] args) {
        PatientRegistrationForm patient1 = new PatientRegistrationForm();
        patient1.setVisible(true);

    }

}
