
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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PatientBookAppoint extends JFrame implements ActionListener {

    private JPanel appointPanel, MainPanel;
    private JLabel Maintitle, selectpatientLabel, patientnameLabel, typeofdoctorLabel, selectdoctorLabel, doctornameLabel,
            assignnurseLabel, selectnurseLabel, nursenameLabel, appointdateLabel, timeLabel, paynowLabel,
            amountLabel, cardnoLabel, cvvLabel;
    private JTextField patientnameField, doctornameField, nursenameField, amountField, cardnoField, cvvField;
    private JButton BackButton, SubmitButton;
    String typeofdoctor[] = {"Allergist", "Dermatologist", "Cardiologist", "Gynecologist", "Ophthalmologist", "Infectious Disease Specialist", "Gastroenterologist", "Endocrinologist"};
    String times[] = {"10 Minutes", "15 Minutes", "30 Minutes", "1 Hour"};
    private JComboBox selectpatientComboBox, typeofdoctorComboBox, selectdoctorComboBox, selectnurseComboBox, timeComboBox;
    private JDateChooser appointmentDateChooser;
    private JRadioButton yesButton, noButton, payyesButton, paynoButton;
    private ButtonGroup group, paygroup;
    private Connection con = null;
    private PreparedStatement pst = null;

    public PatientBookAppoint() {
        initcomponents();
    }

    public void initcomponents() {
        this.setTitle("Book an Appointment");
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
        Maintitle.setText("Book an Appointment");
        Maintitle.setFont(new Font("Sageo UI", 1, 24));
        Maintitle.setBounds(200, 0, 450, 40);
        appointPanel.add(Maintitle);

        selectpatientLabel = new JLabel();
        selectpatientLabel.setText("Select Your Patient ID :");
        selectpatientLabel.setFont(new Font("Sageo UI", 1, 16));
        selectpatientLabel.setBounds(50, 50, 200, 20);
        appointPanel.add(selectpatientLabel);

        selectpatientComboBox = new JComboBox();
        selectpatientComboBox.setBounds(250, 50, 300, 25);
        selectpatientComboBox.setFocusable(false);
        selectpatientComboBox.setFont(new Font("Segoe UI", 1, 16));
        selectpatientComboBox.setBorder(new LineBorder(Color.black, 1));
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
        patientnameLabel.setText("Your Name :");
        patientnameLabel.setFont(new Font("Sageo UI", 1, 16));
        patientnameLabel.setBounds(50, 90, 200, 20);
        appointPanel.add(patientnameLabel);

        patientnameField = new JTextField();
        patientnameField.setFont(new Font("Segoe UI", 1, 16));
        patientnameField.setForeground(Color.black);
        patientnameField.setBounds(250, 90, 300, 25);
        patientnameField.setBorder(new LineBorder(Color.black, 1));
        patientnameField.setEditable(false);
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
        typeofdoctorLabel.setBounds(50, 130, 200, 20);
        appointPanel.add(typeofdoctorLabel);

        typeofdoctorComboBox = new JComboBox(typeofdoctor);
        typeofdoctorComboBox.setBounds(250, 130, 300, 25);
        typeofdoctorComboBox.setFocusable(false);
        typeofdoctorComboBox.setFont(new Font("Segoe UI", 1, 16));
        typeofdoctorComboBox.setBorder(new LineBorder(Color.black, 1));
        typeofdoctorComboBox.setSelectedIndex(-1);
        appointPanel.add(typeofdoctorComboBox);

        selectdoctorLabel = new JLabel();
        selectdoctorLabel.setText("Select Doctor ID :");
        selectdoctorLabel.setFont(new Font("Sageo UI", 1, 16));
        selectdoctorLabel.setBounds(50, 170, 200, 20);
        appointPanel.add(selectdoctorLabel);

        selectdoctorComboBox = new JComboBox();
        selectdoctorComboBox.setBounds(250, 170, 300, 25);
        selectdoctorComboBox.setFocusable(false);
        selectdoctorComboBox.setFont(new Font("Segoe UI", 1, 16));
        selectdoctorComboBox.setBorder(new LineBorder(Color.black, 1));
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
        doctornameLabel.setBounds(50, 210, 200, 20);
        appointPanel.add(doctornameLabel);

        doctornameField = new JTextField();
        doctornameField.setFont(new Font("Segoe UI", 1, 16));
        doctornameField.setBounds(250, 210, 300, 25);
        doctornameField.setBorder(new LineBorder(Color.black, 1));
        doctornameField.setEditable(false);
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

            }
        });

        assignnurseLabel = new JLabel();
        assignnurseLabel.setText("Do you need a nurse? ");
        assignnurseLabel.setFont(new Font("Sageo UI", 1, 16));
        assignnurseLabel.setBounds(50, 250, 200, 20);
        appointPanel.add(assignnurseLabel);

        yesButton = new JRadioButton("Yes");
        yesButton.setFont(new Font("Segoe UI", 1, 16));
        yesButton.setBounds(250, 250, 100, 30);
        yesButton.setBackground(Color.decode("#B8EEFF"));
        yesButton.setFocusable(false);
        appointPanel.add(yesButton);

        noButton = new JRadioButton("No");
        noButton.setFont(new Font("Segoe UI", 1, 16));
        noButton.setBounds(350, 250, 170, 30);
        noButton.setBackground(Color.decode("#B8EEFF"));
        noButton.setFocusable(false);
        appointPanel.add(noButton);

        group = new ButtonGroup();
        group.add(yesButton);
        group.add(noButton);

        selectnurseLabel = new JLabel();
        selectnurseLabel.setText("Select Nurse ID :");
        selectnurseLabel.setFont(new Font("Sageo UI", 1, 16));
        selectnurseLabel.setBounds(50, 290, 200, 20);
        appointPanel.add(selectnurseLabel);

        selectnurseComboBox = new JComboBox();
        selectnurseComboBox.setBounds(250, 290, 300, 25);
        selectnurseComboBox.setFocusable(false);
        selectnurseComboBox.setFont(new Font("Segoe UI", 1, 16));
        selectnurseComboBox.setBorder(new LineBorder(Color.black, 1));
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
                }
            }
        });

        nursenameLabel = new JLabel();
        nursenameLabel.setText("Nurse's Name :");
        nursenameLabel.setFont(new Font("Sageo UI", 1, 16));
        nursenameLabel.setBounds(50, 330, 200, 20);
        appointPanel.add(nursenameLabel);

        nursenameField = new JTextField();
        nursenameField.setFont(new Font("Segoe UI", 1, 16));
        nursenameField.setBounds(250, 330, 300, 25);
        nursenameField.setBorder(new LineBorder(Color.black, 1));
        nursenameField.setEditable(false);
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
        appointdateLabel.setBounds(50, 370, 200, 20);
        appointPanel.add(appointdateLabel);

        appointmentDateChooser = new JDateChooser();
        appointmentDateChooser.setDateFormatString("dd MMM, yyyy");
        appointmentDateChooser.setBounds(250, 370, 300, 25);
        appointmentDateChooser.setFont(new Font("Segoe UI", 1, 16));
        appointmentDateChooser.setBorder(new LineBorder(Color.black, 1));
        appointPanel.add(appointmentDateChooser);

        timeLabel = new JLabel();
        timeLabel.setText("Appointment Duration :");
        timeLabel.setFont(new Font("Sageo UI", 1, 16));
        timeLabel.setBounds(50, 410, 200, 20);
        appointPanel.add(timeLabel);

        timeComboBox = new JComboBox(times);
        timeComboBox.setBounds(250, 410, 300, 25);
        timeComboBox.setFocusable(false);
        timeComboBox.setBorder(new LineBorder(Color.black, 1));
        timeComboBox.setFont(new Font("Segoe UI", 1, 16));
        timeComboBox.setSelectedIndex(-1);
        appointPanel.add(timeComboBox);

        timeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeComboBox.getSelectedItem().equals("10 Minutes")) {
                    amountField.setText("200 TK");
                } else if (timeComboBox.getSelectedItem().equals("15 Minutes")) {
                    amountField.setText("300 TK");
                } else if (timeComboBox.getSelectedItem().equals("30 Minutes")) {
                    amountField.setText("500 TK");
                } else if (timeComboBox.getSelectedItem().equals("1 Hour")) {
                    amountField.setText("800 TK");
                }
            }
        });

        amountLabel = new JLabel();
        amountLabel.setText("Payment Amount :");
        amountLabel.setFont(new Font("Sageo UI", 1, 16));
        amountLabel.setBounds(50, 450, 200, 20);
        appointPanel.add(amountLabel);

        amountField = new JTextField();
        amountField.setFont(new Font("Segoe UI", 1, 16));
        amountField.setBounds(250, 450, 300, 25);
        amountField.setBorder(new LineBorder(Color.black, 1));
        amountField.setEditable(false);
        appointPanel.add(amountField);

        paynowLabel = new JLabel();
        paynowLabel.setText("Pay Now?");
        paynowLabel.setFont(new Font("Sageo UI", 1, 16));
        paynowLabel.setBounds(50, 490, 200, 20);
        appointPanel.add(paynowLabel);

        payyesButton = new JRadioButton("Yes");
        payyesButton.setFont(new Font("Segoe UI", 1, 16));
        payyesButton.setBounds(250, 490, 100, 30);
        payyesButton.setBackground(Color.decode("#B8EEFF"));
        payyesButton.setFocusable(false);
        appointPanel.add(payyesButton);

        payyesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (payyesButton.isSelected()) {
                    cardnoField.setEditable(true);
                    cvvField.setEditable(true);
                }
            }
        });

        paynoButton = new JRadioButton("No");
        paynoButton.setFont(new Font("Segoe UI", 1, 16));
        paynoButton.setBounds(350, 490, 170, 30);
        paynoButton.setBackground(Color.decode("#B8EEFF"));
        paynoButton.setFocusable(false);
        appointPanel.add(paynoButton);

        paynoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paynoButton.isSelected()) {
                    cardnoField.setEditable(false);
                    cvvField.setEditable(false);
                }
            }
        });

        paygroup = new ButtonGroup();
        paygroup.add(payyesButton);
        paygroup.add(paynoButton);

        cardnoLabel = new JLabel();
        cardnoLabel.setText("Card Number:");
        cardnoLabel.setFont(new Font("Sageo UI", 1, 16));
        cardnoLabel.setBounds(50, 530, 200, 20);
        appointPanel.add(cardnoLabel);

        cardnoField = new JTextField();
        cardnoField.setFont(new Font("Segoe UI", 1, 16));
        cardnoField.setBounds(250, 530, 300, 25);
        cardnoField.setBorder(new LineBorder(Color.black, 1));
        cardnoField.setEditable(false);
        appointPanel.add(cardnoField);

        cvvLabel = new JLabel();
        cvvLabel.setText("CVV/CVC:");
        cvvLabel.setFont(new Font("Sageo UI", 1, 16));
        cvvLabel.setBounds(50, 570, 200, 20);
        appointPanel.add(cvvLabel);

        cvvField = new JTextField();
        cvvField.setFont(new Font("Segoe UI", 1, 16));
        cvvField.setBounds(250, 570, 300, 25);
        cvvField.setBorder(new LineBorder(Color.black, 1));
        cvvField.setEditable(false);
        appointPanel.add(cvvField);

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
                new Patientdashboard().setVisible(true);
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

                    if (payyesButton.isSelected()) {
                        if (cardnoField.getText().isEmpty() && cvvField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Card Number and CVV/CVC can not be empty!");
                        } else {
                            pst.setString(9, "Paid");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Successfully paid and booked the appointment!");
                            con.close();
                            pst.close();
                        }
                    } else if (paynoButton.isSelected()) {
                        pst.setString(9, "Unpaid");
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Successfully booked the appointment! You need to pay face to face!");
                        con.close();
                        pst.close();
                    }

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

                    if (payyesButton.isSelected()) {
                        if (cardnoField.getText().isEmpty() && cvvField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Card Number and CVV/CVC can not be empty!");
                        } else {
                            pst.setString(9, "Paid");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Successfully paid and booked the appointment!");
                            con.close();
                            pst.close();
                        }
                    } else if (paynoButton.isSelected()) {
                        pst.setString(9, "Unpaid");
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Successfully booked the appointment! You need to pay face to face!");
                        con.close();
                        pst.close();
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }

        }
    }

    public static void main(String[] args) {
        PatientBookAppoint appoint = new PatientBookAppoint();
        appoint.setVisible(true);

    }

}
