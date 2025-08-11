
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class PatientChangeInfo extends JFrame implements ActionListener {

    private JPanel RegisterPanel, MainPanel;
    private JLabel Maintitle, patientidLabel, patientauthLabel, Name, Gender, DateofBirth, Address, MobileNo, Email, Username;
    private JButton BackButton, SubmitButton, confirmButton;
    JDateChooser date;
    private JTextField patientidField, patientauthField, NameField, AddressField, MobileNoField, EmailField, UsernameField;
    private JComboBox GenderComboBox;
    String gender[] = {"Male", "Female", "Others"};
    private Connection con = null;
    private PreparedStatement pst = null;
    private Statement st = null;
    String id, auth, name, gendertab, dateofbirth, address, mobile, email, username;

    public PatientChangeInfo() {
        initcomponents();
    }

    public void initcomponents() {
        this.setTitle("Add Doctor");
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
        Maintitle.setText("Change Your Informations");
        Maintitle.setFont(new Font("Sageo UI", 1, 24));
        Maintitle.setBounds(0, 0, 600, 40);
        Maintitle.setHorizontalAlignment(JLabel.CENTER);
        RegisterPanel.add(Maintitle);

        patientidLabel = new JLabel();
        patientidLabel.setText("Patient ID:");
        patientidLabel.setFont(new Font("Sageo UI", 1, 16));
        patientidLabel.setBounds(20, 60, 200, 20);
        RegisterPanel.add(patientidLabel);

        patientidField = new JTextField();
        patientidField.setBounds(110, 60, 100, 25);
        patientidField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(patientidField);

        patientauthLabel = new JLabel();
        patientauthLabel.setText("Patient Authcode:");
        patientauthLabel.setFont(new Font("Sageo UI", 1, 16));
        patientauthLabel.setBounds(220, 60, 250, 20);
        RegisterPanel.add(patientauthLabel);

        patientauthField = new JTextField();
        patientauthField.setBounds(360, 60, 100, 25);
        patientauthField.setBorder(new LineBorder(Color.black, 1));
        RegisterPanel.add(patientauthField);

        confirmButton = new JButton("Submit");
        confirmButton.setFont(new Font("Segoe UI", 1, 14));
        confirmButton.setBounds(480, 60, 100, 25);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.decode("#00ADEF"));
        confirmButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        confirmButton.setFocusable(false);
        RegisterPanel.add(confirmButton);

        Name = new JLabel();
        Name.setText("Your Name:");
        Name.setFont(new Font("Sageo UI", 1, 16));
        Name.setBounds(50, 100, 200, 20);
        RegisterPanel.add(Name);

        NameField = new JTextField();
        NameField.setBounds(250, 100, 300, 25);
        NameField.setBorder(new LineBorder(Color.black, 1));
        NameField.setEditable(false);
        RegisterPanel.add(NameField);

        Gender = new JLabel();
        Gender.setText("Gender:");
        Gender.setFont(new Font("Sageo UI", 1, 16));
        Gender.setBounds(50, 140, 200, 20);
        RegisterPanel.add(Gender);

        GenderComboBox = new JComboBox(gender);
        GenderComboBox.setBounds(250, 140, 300, 25);
        GenderComboBox.setFocusable(false);
        GenderComboBox.setBorder(new LineBorder(Color.black, 1));
        GenderComboBox.setSelectedIndex(-1);
        GenderComboBox.setEnabled(false);
        RegisterPanel.add(GenderComboBox);

        DateofBirth = new JLabel();
        DateofBirth.setText("Date Of Birth:");
        DateofBirth.setFont(new Font("Sageo UI", 1, 16));
        DateofBirth.setBounds(50, 180, 200, 20);
        RegisterPanel.add(DateofBirth);


        date = new JDateChooser();
        date.setDateFormatString("dd MMM, yyyy");
        date.setBounds(250, 180, 300, 25);
        date.setBorder(new LineBorder(Color.black, 1));
        date.setEnabled(false);
        RegisterPanel.add(date);

        Address = new JLabel();
        Address.setText("Address:");
        Address.setFont(new Font("Sageo UI", 1, 16));
        Address.setBounds(50, 220, 200, 20);
        RegisterPanel.add(Address);

        AddressField = new JTextField();
        AddressField.setBounds(250, 220, 300, 25);
        AddressField.setBorder(new LineBorder(Color.black, 1));
        AddressField.setEditable(false);
        RegisterPanel.add(AddressField);

        MobileNo = new JLabel();
        MobileNo.setText("Mobile Number:");
        MobileNo.setFont(new Font("Sageo UI", 1, 16));
        MobileNo.setBounds(50, 260, 200, 20);
        RegisterPanel.add(MobileNo);

        MobileNoField = new JTextField();
        MobileNoField.setBounds(250, 260, 300, 25);
        MobileNoField.setBorder(new LineBorder(Color.black, 1));
        MobileNoField.setEditable(false);
        RegisterPanel.add(MobileNoField);

        Email = new JLabel();
        Email.setText("Email ID:");
        Email.setFont(new Font("Sageo UI", 1, 16));
        Email.setBounds(50, 300, 200, 20);
        RegisterPanel.add(Email);

        EmailField = new JTextField();
        EmailField.setBounds(250, 300, 300, 25);
        EmailField.setBorder(new LineBorder(Color.black, 1));
        EmailField.setEditable(false);
        RegisterPanel.add(EmailField);

        Username = new JLabel();
        Username.setText("Username:");
        Username.setFont(new Font("Sageo UI", 1, 16));
        Username.setBounds(50, 340, 200, 20);
        RegisterPanel.add(Username);

        UsernameField = new JTextField();
        UsernameField.setBounds(250, 340, 300, 25);
        UsernameField.setBorder(new LineBorder(Color.black, 1));
        UsernameField.setEditable(false);
        RegisterPanel.add(UsernameField);

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
        SubmitButton.setText("Submit");
        SubmitButton.setBorder(new LineBorder(Color.black, 1));
        MainPanel.add(SubmitButton);

        SubmitButton.addActionListener(this);
        confirmButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirmButton) {
            confirmButton.setEnabled(false);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                Statement st = con.createStatement();

                String sql = "select * from patient where id = '" + patientidField.getText() + "' and authcode='" + patientauthField.getText() + "'";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    id = rs.getString("id");
                    auth = rs.getString("authcode");
                    name = rs.getString("name");
                    gendertab = rs.getString("gender");
                    dateofbirth = rs.getString("dob");
                    address = rs.getString("address");
                    mobile = rs.getString("mobile");
                    email = rs.getString("email");
                    username = rs.getString("username");

                }
                if (patientidField.getText().equals(id) && patientauthField.getText().equals(auth)) {

                    NameField.setText(name);
                    NameField.setEditable(true);
                    GenderComboBox.setSelectedItem(gendertab);
                    GenderComboBox.setEnabled(true);
                    Date newdate = new SimpleDateFormat("dd MMM, yyyy").parse(dateofbirth);
                    date.setEnabled(true);
                    date.setDate(newdate);
                    AddressField.setText(address);
                    AddressField.setEditable(true);
                    MobileNoField.setText(mobile);
                    MobileNoField.setEditable(true);
                    EmailField.setText(email);
                    EmailField.setEditable(true);
                    UsernameField.setText(username);
                    UsernameField.setEditable(true);

                } else {
                    JOptionPane.showMessageDialog(this, "Your patient ID and authcode didn't match!");
                    confirmButton.setEnabled(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }

        } else if (e.getSource() == SubmitButton) {
            if (NameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid name!");
            } else if (GenderComboBox.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Please select a valid gender!");
            }  else if (Address.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid address!");
            } else if (MobileNo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid mobile number!");
            } else if (Email.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
            } else if (UsernameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid username!");
            } else {
                try {
                    String query = "UPDATE `patient` SET `name`=?, `gender`=?,`dob`=?,`address`=?,`mobile`=?,`email`=?, `username`=? WHERE `id`=?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);

                    pst.setString(8, patientidField.getText());
                    pst.setString(1, NameField.getText());
                    pst.setString(2, GenderComboBox.getSelectedItem().toString());
                    pst.setString(3, ((JTextField) date.getDateEditor().getUiComponent()).getText());
                    pst.setString(4, AddressField.getText());
                    pst.setString(5, MobileNoField.getText());
                    pst.setString(6, EmailField.getText());
                    pst.setString(7, UsernameField.getText());

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully Changed!");

                    con.close();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (e.getSource() == BackButton) {
            this.setVisible(false);
            new Patientdashboard().setVisible(true);
        }
    }

    public static void main(String[] args) {
        PatientChangeInfo info = new PatientChangeInfo();
        info.setVisible(true);

    }

}
