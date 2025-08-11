
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddAppointment extends JFrame implements ActionListener {

    private JPanel appointPanel, MainPanel;
    private JLabel Maintitle, selectpatientLabel, patientnameLabel, typeofdoctorLabel, selectdoctorLabel, doctornameLabel,
            assignnurseLabel, selectnurseLabel, nursenameLabel, appointdateLabel;
    private JTextField patientnameField, doctornameField, nursenameField;
    private JButton BackButton, SubmitButton;
    String typeofdoctor[] = {"Allergist", "Dermatologist", "Cardiologist", "Gynecologist", "Ophthalmologist", "Infectious Disease Specialist", "Gastroenterologist", "Endocrinologist"};
    private JComboBox selectpatientComboBox, typeofdoctorComboBox, selectdoctorComboBox, selectnurseComboBox;
    private JDateChooser appointmentDateChooser;
    private JRadioButton yesButton, noButton;
    private ButtonGroup group;
    private Connection con = null;
    private PreparedStatement pst = null;

    public AddAppointment() {
        initcomponents();
    }

    public void initcomponents() {
        this.setTitle("Add New Appointment");
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

        appointPanel = new JPanel();
        appointPanel.setBounds(240, 30, 600, 600);
        appointPanel.setBackground(Color.decode("#B8EEFF"));
        appointPanel.setLayout(null);
        MainPanel.add(appointPanel);

        Maintitle = new JLabel();
        Maintitle.setText("Add New Appointment");
        Maintitle.setFont(new Font("Sageo UI", 1, 24));
        Maintitle.setBounds(200, 15, 450, 40);
        appointPanel.add(Maintitle);

        selectpatientLabel = new JLabel();
        selectpatientLabel.setText("Select Patient ID :");
        selectpatientLabel.setFont(new Font("Sageo UI", 1, 16));
        selectpatientLabel.setBounds(50, 100, 200, 20);
        appointPanel.add(selectpatientLabel);

        selectpatientComboBox = new JComboBox();
        selectpatientComboBox.setBounds(250, 100, 300, 25);
        selectpatientComboBox.setFocusable(false);
        selectpatientComboBox.setBorder(new LineBorder(Color.black, 1));
        selectpatientComboBox.setFont(new Font("Sageo UI", 1, 16));
        selectpatientComboBox.setSelectedIndex(-1);
        appointPanel.add(selectpatientComboBox);

        try {
            String query = "Select id from patient";
            con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                selectpatientComboBox.setSelectedIndex(-1);
                String addId = rs.getString("id");
                selectpatientComboBox.addItem(addId);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        patientnameLabel = new JLabel();
        patientnameLabel.setText("Patient's Name :");
        patientnameLabel.setFont(new Font("Sageo UI", 1, 16));
        patientnameLabel.setBounds(50, 140, 200, 20);
        appointPanel.add(patientnameLabel);

        patientnameField = new JTextField();
        patientnameField.setFont(new Font("Segoe UI", 1, 16));
        patientnameField.setForeground(Color.black);
        patientnameField.setBounds(250, 140, 300, 25);
        patientnameField.setBorder(new LineBorder(Color.black, 1));
        patientnameField.setEnabled(false);
        appointPanel.add(patientnameField);

        selectpatientComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "Select name from patient where id=?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, selectpatientComboBox.getSelectedItem().toString());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        String addName = rs.getString("name");
                        patientnameField.setText(addName);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });

        typeofdoctorLabel = new JLabel();
        typeofdoctorLabel.setText("Type of Doctor :");
        typeofdoctorLabel.setFont(new Font("Sageo UI", 1, 16));
        typeofdoctorLabel.setBounds(50, 180, 200, 20);
        appointPanel.add(typeofdoctorLabel);

        typeofdoctorComboBox = new JComboBox(typeofdoctor);
        typeofdoctorComboBox.setBounds(250, 180, 300, 25);
        typeofdoctorComboBox.setFocusable(false);
        typeofdoctorComboBox.setBorder(new LineBorder(Color.black, 1));
        typeofdoctorComboBox.setFont(new Font("Sageo UI", 1, 16));
        typeofdoctorComboBox.setSelectedIndex(-1);
        appointPanel.add(typeofdoctorComboBox);

        selectdoctorLabel = new JLabel();
        selectdoctorLabel.setText("Select Doctor ID :");
        selectdoctorLabel.setFont(new Font("Sageo UI", 1, 16));
        selectdoctorLabel.setBounds(50, 220, 200, 20);
        appointPanel.add(selectdoctorLabel);

        selectdoctorComboBox = new JComboBox();
        selectdoctorComboBox.setBounds(250, 220, 300, 25);
        selectdoctorComboBox.setFocusable(false);
        selectdoctorComboBox.setBorder(new LineBorder(Color.black, 1));
        selectdoctorComboBox.setFont(new Font("Sageo UI", 1, 16));
        selectdoctorComboBox.setSelectedIndex(-1);
        appointPanel.add(selectdoctorComboBox);

        typeofdoctorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "Select * from doctor where specialist = ?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, typeofdoctorComboBox.getSelectedItem().toString());
                    ResultSet rs = pst.executeQuery();
                    selectdoctorComboBox.removeAllItems();
                    while (rs.next()) {
                        String addId = rs.getString("id");
                        selectdoctorComboBox.addItem(addId);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });

        doctornameLabel = new JLabel();
        doctornameLabel.setText("Doctor's Name :");
        doctornameLabel.setFont(new Font("Sageo UI", 1, 16));
        doctornameLabel.setBounds(50, 260, 200, 20);
        appointPanel.add(doctornameLabel);

        doctornameField = new JTextField();
        doctornameField.setFont(new Font("Segoe UI", 1, 16));
        doctornameField.setBounds(250, 260, 300, 25);
        doctornameField.setBorder(new LineBorder(Color.black, 1));
        doctornameField.setEnabled(false);
        appointPanel.add(doctornameField);

        selectdoctorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "Select * from doctor where id = ?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, selectdoctorComboBox.getSelectedItem().toString());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        String Name = rs.getString("name");
                        doctornameField.setText(Name);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                yesButton.setEnabled(true);
                noButton.setEnabled(true);

            }
        });

        assignnurseLabel = new JLabel();
        assignnurseLabel.setText("Assign Nurse? ");
        assignnurseLabel.setFont(new Font("Sageo UI", 1, 16));
        assignnurseLabel.setBounds(50, 300, 200, 20);
        appointPanel.add(assignnurseLabel);

        yesButton = new JRadioButton("Yes");
        yesButton.setFont(new Font("Segoe UI", 1, 16));
        yesButton.setBounds(250, 300, 100, 30);
        yesButton.setBackground(Color.decode("#B8EEFF"));
        yesButton.setFocusable(false);
        yesButton.setEnabled(false);
        appointPanel.add(yesButton);

        noButton = new JRadioButton("No");
        noButton.setFont(new Font("Segoe UI", 1, 16));
        noButton.setBounds(350, 300, 170, 30);
        noButton.setBackground(Color.decode("#B8EEFF"));
        noButton.setFocusable(false);
        noButton.setEnabled(false);
        appointPanel.add(noButton);

        group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);

        selectnurseLabel = new JLabel();
        selectnurseLabel.setText("Select Nurse ID :");
        selectnurseLabel.setFont(new Font("Sageo UI", 1, 16));
        selectnurseLabel.setBounds(50, 340, 200, 20);
        appointPanel.add(selectnurseLabel);

        selectnurseComboBox = new JComboBox();
        selectnurseComboBox.setBounds(250, 340, 300, 25);
        selectnurseComboBox.setFocusable(false);
        selectnurseComboBox.setBorder(new LineBorder(Color.black, 1));
        selectnurseComboBox.setFont(new Font("Sageo UI", 1, 16));
        selectnurseComboBox.setSelectedIndex(-1);
        appointPanel.add(selectnurseComboBox);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yesButton.isSelected()) {
                    selectnurseComboBox.setEnabled(true);
                    try {
                        String query = "Select id from nurse";
                        con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                        PreparedStatement pst = con.prepareStatement(query);
                        ResultSet rs = pst.executeQuery();
                        selectnurseComboBox.removeAllItems();
                        while (rs.next()) {
                            String addId = rs.getString("id");
                            selectnurseComboBox.addItem(addId);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (noButton.isSelected()) {
                    selectnurseComboBox.removeAllItems();
                    selectnurseComboBox.setEnabled(false);
                    nursenameField.setText("");
                }
            }
        });

        nursenameLabel = new JLabel();
        nursenameLabel.setText("Nurse's Name :");
        nursenameLabel.setFont(new Font("Sageo UI", 1, 16));
        nursenameLabel.setBounds(50, 380, 200, 20);
        appointPanel.add(nursenameLabel);

        nursenameField = new JTextField();
        nursenameField.setFont(new Font("Segoe UI", 1, 16));
        nursenameField.setBounds(250, 380, 300, 25);
        nursenameField.setBorder(new LineBorder(Color.black, 1));
        nursenameField.setEnabled(false);
        appointPanel.add(nursenameField);

        selectnurseComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "Select * from nurse where id = ?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, selectnurseComboBox.getSelectedItem().toString());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        String Name = rs.getString("name");
                        nursenameField.setText(Name);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });

        appointdateLabel = new JLabel();
        appointdateLabel.setText("Appointment Date :");
        appointdateLabel.setFont(new Font("Sageo UI", 1, 16));
        appointdateLabel.setBounds(50, 420, 200, 20);
        appointPanel.add(appointdateLabel);

        appointmentDateChooser = new JDateChooser();
        appointmentDateChooser.setDateFormatString("dd MMM, yyyy");
        appointmentDateChooser.setBounds(250, 420, 300, 25);
        appointmentDateChooser.setBorder(new LineBorder(Color.black, 1));
        appointmentDateChooser.setFont(new Font("Sageo UI", 1, 16));
        appointPanel.add(appointmentDateChooser);

        BackButton = new JButton();
        BackButton.setFont(new Font("Segoe UI", 1, 18));
        BackButton.setBounds(70, 600, 90, 30);
        BackButton.setFocusable(false);
        BackButton.setText("Back");
        BackButton.setBorder(new LineBorder(Color.black, 1));
        MainPanel.add(BackButton);

        SubmitButton = new JButton("Submit");
        SubmitButton.setFont(new Font("Segoe UI", 1, 18));
        SubmitButton.setBounds(925, 600, 90, 30);
        SubmitButton.setFocusable(false);
        SubmitButton.setBorder(new LineBorder(Color.black, 1));
        MainPanel.add(SubmitButton);

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Admindashboard dashboard = new Admindashboard();
                dashboard.setVisible(true);
            }
        });
        SubmitButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (yesButton.isSelected()) {
            if (e.getSource() == SubmitButton) {
                try {
                    String query = "INSERT INTO `appointment`( `patient_id`, `patient_name`, `typeofdoctor`, `doctor_id`, `doctor_name`, `nurse_id`, `nurse_name`, `appointment_date`, `payment`) VALUES ( ?, ?, ?, ?, ?, ?, ?,?,?)";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);

                    pst.setString(1, selectpatientComboBox.getSelectedItem().toString());
                    pst.setString(2, patientnameField.getText());
                    pst.setString(3, typeofdoctorComboBox.getSelectedItem().toString());
                    pst.setString(4, selectdoctorComboBox.getSelectedItem().toString());
                    pst.setString(5, doctornameField.getText());
                    pst.setString(6, selectnurseComboBox.getSelectedItem().toString());
                    pst.setString(7, nursenameField.getText());
                    pst.setString(8, ((JTextField) appointmentDateChooser.getDateEditor().getUiComponent()).getText());
                    pst.setString(9, "Unpaid");

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully Registered! Keep in mind, patient will have to pay face to face!");

                    con.close();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        } else if (noButton.isSelected()) {
            if (e.getSource() == SubmitButton) {
                try {
                    
                    String query = "INSERT INTO `appointment`( `patient_id`, `patient_name`, `typeofdoctor`, `doctor_id`, `doctor_name`, `nurse_id`, `nurse_name`, `appointment_date`, `payment`) VALUES ( ?, ?, ?, ?, ?, ?, ?,?,?)";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);

                    pst.setString(1, selectpatientComboBox.getSelectedItem().toString());
                    pst.setString(2, patientnameField.getText());
                    pst.setString(3, typeofdoctorComboBox.getSelectedItem().toString());
                    pst.setString(4, selectdoctorComboBox.getSelectedItem().toString());
                    pst.setString(5, doctornameField.getText());
                    pst.setString(6, "No nurse");
                    pst.setString(7, "No nurse");
                    pst.setString(8, ((JTextField) appointmentDateChooser.getDateEditor().getUiComponent()).getText());
                    pst.setString(9, "Unpaid");

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully Registered!");

                    con.close();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }

        }
    }

    public static void main(String[] args) {
        AddAppointment appoint = new AddAppointment();
        appoint.setVisible(true);

    }

}
