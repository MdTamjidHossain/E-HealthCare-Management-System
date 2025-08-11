
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Signupselect extends JFrame implements ActionListener, MouseListener {

    private JPanel mainPanel, selectPanel;
    private JLabel selectLabel;
    private JRadioButton doctorButton, patientButton;
    private ButtonGroup group;
    private JButton nextButton, backButton;

    public Signupselect() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Sign Up Selection Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(getToolkit().getImage("C:\\Users\\Tamjid\\Desktop\\ourproject\\logo.png"));

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1100, 700);
        mainPanel.setBackground(Color.decode("#00ADEF"));
        mainPanel.setLayout(null);
        this.add(mainPanel);

        selectPanel = new JPanel();
        selectPanel.setBounds(240, 130, 600, 400);
        selectPanel.setBackground(Color.decode("#B8EEFF"));
        selectPanel.setLayout(null);
        mainPanel.add(selectPanel);

        selectLabel = new JLabel();
        selectLabel.setFont(new Font("Segoe UI", 1, 20));
        selectLabel.setText("Please Select the account type:");
        selectLabel.setBounds(160, 60, 500, 30);
        selectPanel.add(selectLabel);

        doctorButton = new JRadioButton("Doctor");
        doctorButton.setFont(new Font("Segoe UI", 1, 16));
        doctorButton.setBounds(260, 130, 170, 30);
        doctorButton.setBackground(Color.decode("#B8EEFF"));
        doctorButton.setFocusable(false);
        selectPanel.add(doctorButton);

        patientButton = new JRadioButton("Patient");
        patientButton.setFont(new Font("Segoe UI", 1, 16));
        patientButton.setBounds(260, 190, 170, 30);
        patientButton.setBackground(Color.decode("#B8EEFF"));
        patientButton.setFocusable(false);
        selectPanel.add(patientButton);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Segoe UI", 1, 17));
        nextButton.setBounds(440, 320, 90, 30);
        nextButton.setBackground(Color.decode("#00ADEF"));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBorder(new LineBorder(Color.black, 2));
        nextButton.setHorizontalAlignment(SwingConstants.CENTER);
        nextButton.setFocusable(false);
        selectPanel.add(nextButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Segoe UI", 1, 17));
        backButton.setBounds(80, 320, 90, 30);
        backButton.setBackground(Color.decode("#00ADEF"));
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(new LineBorder(Color.black, 2));
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setFocusable(false);
        selectPanel.add(backButton);

        group = new ButtonGroup();
        group.add(doctorButton);
        group.add(patientButton);

        nextButton.addActionListener(this);
        nextButton.addMouseListener(this);
        backButton.addActionListener(this);
        backButton.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (doctorButton.isSelected()) {
                this.setVisible(false);
                DoctorRegistrationForm doctor = new DoctorRegistrationForm();
                doctor.setVisible(true);
            } else if (patientButton.isSelected()) {
                this.setVisible(false);
                PatientRegistrationForm patient = new PatientRegistrationForm();
                patient.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please select the account type to proceed!");
            }
        } else if (e.getSource() == backButton) {
            this.setVisible(false);
            Loginpage login = new Loginpage();
            login.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Signupselect signupselect = new Signupselect();
        signupselect.setVisible(true);

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

        if (e.getSource() == nextButton) {
            nextButton.setBackground(Color.decode("#16e8dd"));
            nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (e.getSource() == backButton) {
            backButton.setBackground(Color.decode("#16e8dd"));
            backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == nextButton) {
            nextButton.setBackground(Color.decode("#00ADEF"));
        } else if (e.getSource() == backButton) {
            backButton.setBackground(Color.decode("#00ADEF"));
        }
    }

}
