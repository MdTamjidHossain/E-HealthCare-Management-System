
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class DoctorRegistrationForm extends JFrame implements ActionListener {

    private JPanel RegisterPanel, MainPanel;
    private JLabel Maintitle, Name, Address, MobileNo, Email, Username, Password, ConfirmPassword, Specialist, Gender;
    private JButton BackButton, SubmitButton;
    private JTextField NameField, AddressField, MobileNoField, EmailField, PasswordField, ConfirmPasswordField, UsernameField;
    private JComboBox GenderComboBox, SpecialistComboBox;
    private JDialog DialogBox;
    String gender[] = {"Male", "Female", "Others"};
    String specialist[] = {"Allergist", "Dermatologist", "Cardiologist", "Gynecologist", "Ophthalmologist", "Infectious Disease Specialist", "Gastroenterologist", "Endocrinologist"};
    private Connection con = null;
    private PreparedStatement pst = null;
    private Statement st = null;
    String getId, authId;

    public DoctorRegistrationForm() {
        initcomponents();
    }

    public void initcomponents() {
        this.setTitle("Doctor's Registration Form");
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
        Maintitle.setText("Doctor's Registration Form");
        Maintitle.setFont(new Font("Sageo UI", 1, 24));
        Maintitle.setBounds(150, 15, 450, 40);
        RegisterPanel.add(Maintitle);

        Name = new JLabel();
        Name.setText("Doctor's Name:");
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
        RegisterPanel.add(GenderComboBox);

        Specialist = new JLabel();
        Specialist.setText("Specialist:");
        Specialist.setFont(new Font("Sageo UI", 1, 16));
        Specialist.setBounds(50, 180, 200, 20);
        RegisterPanel.add(Specialist);

        SpecialistComboBox = new JComboBox(specialist);
        SpecialistComboBox.setBounds(250, 180, 300, 25);
        SpecialistComboBox.setFocusable(false);
        SpecialistComboBox.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(SpecialistComboBox);

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
        BackButton.addActionListener(this);
        BackButton.setText("Back");
        BackButton.setBorder(new LineBorder(Color.black, 1));
        MainPanel.add(BackButton);

        SubmitButton = new JButton();
        SubmitButton.setFont(new Font("Segoe UI", 1, 18));
        SubmitButton.setBounds(925, 600, 90, 30);
        SubmitButton.setFocusable(false);
        SubmitButton.addActionListener(this);
        SubmitButton.setText("Submit");
        SubmitButton.setBorder(new LineBorder(Color.black, 1));
        MainPanel.add(SubmitButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SubmitButton) {
            if ((NameField.getText().isEmpty()) || AddressField.getText().isEmpty() || MobileNoField.getText().isEmpty() || EmailField.getText().isEmpty() || UsernameField.getText().isEmpty() || PasswordField.getText().isEmpty() || ConfirmPasswordField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please complete the form");
            } else if(!(ConfirmPasswordField.getText().equals(PasswordField.getText()))){
                JOptionPane.showMessageDialog(null, "Both passwords must match!");
            }
            else {
                try {
                    String query = "INSERT INTO `doctor`( `name`, `gender`, `specialist`, `address`, `mobile`, `email`, `username`, `password`, `authcode`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);
                    
                    Random rand = new Random();
                    int i = rand.nextInt(8001) + 1000;
                    String random = String.valueOf(i);
                    

                    pst.setString(1, NameField.getText());
                    pst.setString(2, GenderComboBox.getSelectedItem().toString());
                    pst.setString(3, SpecialistComboBox.getSelectedItem().toString());
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
                        String query2 = "select * from doctor where binary name = '" + NameField.getText()
                                + "'and binary username='" + UsernameField.getText()
                                + "'";
                        ResultSet rs = st.executeQuery(query2);
                        while (rs.next()) {
                            getId = rs.getString("id");
                            authId = rs.getString("authcode");
                        }
                        JavaMailUtil.sendMail(EmailField.getText(), getId, authId);
                        con.close();
                        st.close();
                        new DoctorTwoStep().setVisible(true);

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
        DoctorRegistrationForm doctor = new DoctorRegistrationForm();
        doctor.setVisible(true);

    }

}
