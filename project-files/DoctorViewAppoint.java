
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DoctorViewAppoint extends JFrame implements ActionListener {

    private JPanel mainPanel, allpatientPanel;
    private JLabel allpatientLabel, doctoridLabel, doctorauthLabel;
    private JTextField doctoridField, doctorauthField;
    private JButton backButton, confirmButton;
    private JTable patientTable;
    private JScrollPane patientScrollPane;
    private DefaultTableModel patientTableModel;
    private String[] columns = {"ID", "Patient Name", "Doctor Name", "Nurse Name", "Appointment Date", "Payment"};
    private String[] rows = new String[6];
    private Connection con = null;
    private Statement st = null;
    String id, auth;

    public DoctorViewAppoint() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("View All Appointments");
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

        allpatientPanel = new JPanel();
        allpatientPanel.setBounds(120, 55, 850, 550);
        allpatientPanel.setBackground(Color.decode("#B8EEFF"));
        allpatientPanel.setLayout(null);
        mainPanel.add(allpatientPanel);

        allpatientLabel = new JLabel();
        allpatientLabel.setText("View Your Appointments");
        allpatientLabel.setFont(new Font("Sageo UI", 1, 24));
        allpatientLabel.setBounds(0, 0, 840, 40);
        allpatientLabel.setHorizontalAlignment(JLabel.CENTER);
        allpatientPanel.add(allpatientLabel);

        doctoridLabel = new JLabel();
        doctoridLabel.setText("Enter Your Doctor ID:");
        doctoridLabel.setFont(new Font("Sageo UI", 1, 16));
        doctoridLabel.setBounds(50, 80, 200, 20);
        allpatientPanel.add(doctoridLabel);

        doctoridField = new JTextField();
        doctoridField.setBounds(220, 80, 100, 25);
        doctoridField.setBorder(new LineBorder(Color.black, 1));
        allpatientPanel.add(doctoridField);

        doctorauthLabel = new JLabel();
        doctorauthLabel.setText("Enter Your Doctor Authcode:");
        doctorauthLabel.setFont(new Font("Sageo UI", 1, 16));
        doctorauthLabel.setBounds(340, 80, 250, 20);
        allpatientPanel.add(doctorauthLabel);

        doctorauthField = new JTextField();
        doctorauthField.setBounds(570, 80, 100, 25);
        doctorauthField.setBorder(new LineBorder(Color.black, 1));
        allpatientPanel.add(doctorauthField);

        confirmButton = new JButton("Submit");
        confirmButton.setFont(new Font("Segoe UI", 1, 14));
        confirmButton.setBounds(700, 80, 100, 25);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.decode("#00ADEF"));
        confirmButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        confirmButton.setFocusable(false);
        allpatientPanel.add(confirmButton);

        patientTable = new JTable();

        patientTableModel = new DefaultTableModel();
        patientTableModel.setColumnIdentifiers(columns);

        patientTable.setModel(patientTableModel);
        patientTable.setFont(new Font("Sageo UI", 0, 14));
        patientTable.setBackground(Color.decode("#FFFFFF"));
        patientTable.setRowHeight(50);

        patientScrollPane = new JScrollPane(patientTable);
        patientScrollPane.setBounds(30, 120, 790, 400);
        allpatientPanel.add(patientScrollPane);

        backButton = new JButton();
        backButton.setFont(new Font("Segoe UI", 1, 18));
        backButton.setBounds(15, 615, 90, 30);
        backButton.setFocusable(false);
        backButton.setText("Back");
        backButton.setBorder(new LineBorder(Color.black, 1));
        mainPanel.add(backButton);

        backButton.addActionListener(this);
        confirmButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.setVisible(false);
            new DoctorDashboard().setVisible(true);
        } else if (e.getSource() == confirmButton) {
            confirmButton.setEnabled(false);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                Statement st = con.createStatement();

                String sql = "select * from doctor where id = '" + doctoridField.getText() + "' and authcode='" + doctorauthField.getText() + "'";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    id = rs.getString("id");
                    auth = rs.getString("authcode");

                }
                if (doctoridField.getText().equals(id) && doctorauthField.getText().equals(auth)) {

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                        Statement st2 = con.createStatement();

                        String query = "select * from appointment where doctor_id='" + doctoridField.getText() + "'";

                        ResultSet rs2 = st2.executeQuery(query);

                        while (rs2.next()) {
                            rows[0] = String.valueOf(rs2.getInt("id"));
                            rows[1] = rs2.getString("patient_name");
                            rows[2] = rs2.getString("doctor_name");
                            rows[3] = rs2.getString("nurse_name");
                            rows[4] = rs2.getString("appointment_date");
                            rows[5] = rs2.getString("payment");
                            patientTableModel.addRow(rows);
                        }
                        rs2.close();
                        st2.close();
                        con.close();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    rs.close();
                    st.close();
                    con.close();
                } else {
                    JOptionPane.showMessageDialog(this, "Your doctor ID and authcode didn't match!");
                    confirmButton.setEnabled(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }

        }
    }

    public static void main(String[] args) {
        DoctorViewAppoint appoint = new DoctorViewAppoint();
        appoint.setVisible(true);

    }

}
