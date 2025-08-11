
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;

public class PatientEditAppoint extends JFrame implements ActionListener {

    private JPanel mainPanel, removeappointPanel;
    private JLabel allpatientLabel, patientidLabel, patientauthLabel, idLabel, patientnameLabel, doctornameLabel, nursenameLabel, appointdateLabel, paymentLabel;
    private JTextField patientidField, patientauthField, idTextField, patientnameField, doctornameField, nursenameField, paymentField;
    private JDateChooser appointdate;
    private JButton backButton, confirmButton, removeButton;
    private JTable appointTable;
    private JScrollPane appointScrollPane;
    private DefaultTableModel appointTableModel;
    private String[] columns = {"ID", "Patient Name", "Doctor Name", "Nurse Name", "Appointment Date", "Payment"};
    private String[] rows = new String[6];
    private Connection con = null;
    private Statement st = null;
    private String id, auth;

    public PatientEditAppoint() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Remove / Cancel Appointments");
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

        removeappointPanel = new JPanel();
        removeappointPanel.setBounds(40, 55, 1000, 550);
        removeappointPanel.setBackground(Color.decode("#B8EEFF"));
        removeappointPanel.setLayout(null);
        mainPanel.add(removeappointPanel);

        allpatientLabel = new JLabel();
        allpatientLabel.setText("Remove / Cancel Appointments");
        allpatientLabel.setFont(new Font("Sageo UI", 1, 24));
        allpatientLabel.setBounds(340, 0, 450, 40);
        removeappointPanel.add(allpatientLabel);

        patientidLabel = new JLabel();
        patientidLabel.setText("Enter Your Patient ID:");
        patientidLabel.setFont(new Font("Sageo UI", 1, 16));
        patientidLabel.setBounds(120, 45, 200, 20);
        removeappointPanel.add(patientidLabel);

        patientidField = new JTextField();
        patientidField.setBounds(290, 45, 100, 25);
        patientidField.setBorder(new LineBorder(Color.black, 1));
        removeappointPanel.add(patientidField);

        patientauthLabel = new JLabel();
        patientauthLabel.setText("Enter Your Patient Authcode:");
        patientauthLabel.setFont(new Font("Sageo UI", 1, 16));
        patientauthLabel.setBounds(410, 45, 250, 20);
        removeappointPanel.add(patientauthLabel);

        patientauthField = new JTextField();
        patientauthField.setBounds(640, 45, 100, 25);
        patientauthField.setBorder(new LineBorder(Color.black, 1));
        removeappointPanel.add(patientauthField);

        confirmButton = new JButton("Submit");
        confirmButton.setFont(new Font("Segoe UI", 1, 14));
        confirmButton.setBounds(770, 45, 100, 25);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.decode("#00ADEF"));
        confirmButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        confirmButton.setFocusable(false);
        removeappointPanel.add(confirmButton);

        idLabel = new JLabel();
        idLabel.setText("ID :");
        idLabel.setFont(new Font("Sageo UI", 1, 14));
        idLabel.setBounds(10, 100, 80, 30);
        removeappointPanel.add(idLabel);

        idTextField = new JTextField();
        idTextField.setText("");
        idTextField.setFont(new Font("Sageo UI", 0, 14));
        idTextField.setBounds(120, 100, 250, 30);
        idTextField.setEditable(false);
        removeappointPanel.add(idTextField);

        patientnameLabel = new JLabel();
        patientnameLabel.setText("Patient Name :");
        patientnameLabel.setFont(new Font("Sageo UI", 1, 14));
        patientnameLabel.setBounds(10, 150, 120, 30);
        removeappointPanel.add(patientnameLabel);

        patientnameField = new JTextField();
        patientnameField.setText("");
        patientnameField.setFont(new Font("Sageo UI", 0, 14));
        patientnameField.setBounds(120, 150, 250, 30);
        patientnameField.setEditable(false);
        removeappointPanel.add(patientnameField);

        doctornameLabel = new JLabel();
        doctornameLabel.setText("Doctor Name :");
        doctornameLabel.setFont(new Font("Sageo UI", 1, 14));
        doctornameLabel.setBounds(10, 200, 120, 30);
        removeappointPanel.add(doctornameLabel);

        doctornameField = new JTextField();
        doctornameField.setText("");
        doctornameField.setFont(new Font("Sageo UI", 0, 14));
        doctornameField.setBounds(120, 200, 250, 30);
        doctornameField.setEditable(false);
        removeappointPanel.add(doctornameField);

        nursenameLabel = new JLabel();
        nursenameLabel.setText("Nurse Name :");
        nursenameLabel.setFont(new Font("Sageo UI", 1, 14));
        nursenameLabel.setBounds(10, 250, 120, 30);
        removeappointPanel.add(nursenameLabel);

        nursenameField = new JTextField();
        nursenameField.setText("");
        nursenameField.setFont(new Font("Sageo UI", 0, 14));
        nursenameField.setBounds(120, 250, 250, 30);
        nursenameField.setEditable(false);
        removeappointPanel.add(nursenameField);

        appointdateLabel = new JLabel();
        appointdateLabel.setText("Appointment Date :");
        appointdateLabel.setFont(new Font("Sageo UI", 1, 14));
        appointdateLabel.setBounds(10, 300, 140, 30);
        removeappointPanel.add(appointdateLabel);

        appointdate = new JDateChooser();
        appointdate.setDateFormatString("dd MMM, yyyy");
        appointdate.setBounds(160, 300, 210, 30);
        appointdate.setEnabled(false);
        removeappointPanel.add(appointdate);

        paymentLabel = new JLabel();
        paymentLabel.setText("Payment :");
        paymentLabel.setFont(new Font("Sageo UI", 1, 14));
        paymentLabel.setBounds(10, 350, 120, 30);
        removeappointPanel.add(paymentLabel);

        paymentField = new JTextField();
        paymentField.setText("");
        paymentField.setFont(new Font("Sageo UI", 0, 14));
        paymentField.setBounds(120, 350, 250, 30);
        paymentField.setEditable(false);
        removeappointPanel.add(paymentField);

        removeButton = new JButton("Cancel Appointment");
        removeButton.setFont(new Font("Segoe UI", 1, 14));
        removeButton.setBounds(120, 422, 150, 30);
        removeButton.setBorder(new LineBorder(new Color(6, 90, 215), 1));
        removeButton.setBackground(Color.decode("#37f9f8"));
        removeButton.setFocusable(false);
        removeButton.setEnabled(false);
        removeappointPanel.add(removeButton);

        appointTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        appointTableModel = new DefaultTableModel();
        appointTableModel.setColumnIdentifiers(columns);

        appointTable.setModel(appointTableModel);
        appointTable.setFont(new Font("Sageo UI", 0, 14));
        appointTable.setBackground(Color.decode("#FFFFFF"));
        appointTable.setRowHeight(35);
        appointTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        appointTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        appointTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        appointTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        appointTable.getColumnModel().getColumn(4).setPreferredWidth(60);
        appointTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        appointTable.getTableHeader().setResizingAllowed(false);
        appointTable.getTableHeader().setReorderingAllowed(false);

        appointScrollPane = new JScrollPane(appointTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        appointScrollPane.setBounds(380, 80, 600, 450);
        removeappointPanel.add(appointScrollPane);

        backButton = new JButton();
        backButton.setFont(new Font("Segoe UI", 1, 18));
        backButton.setBounds(15, 615, 90, 30);
        backButton.setFocusable(false);
        backButton.setText("Back");
        backButton.setBorder(new LineBorder(Color.black, 1));
        mainPanel.add(backButton);

        backButton.addActionListener(this);
        confirmButton.addActionListener(this);
        removeButton.addActionListener(this);

        appointTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int numberOfRow = appointTable.getSelectedRow();
                String idTable = appointTableModel.getValueAt(numberOfRow, 0).toString();
                idTextField.setText(idTable);

                String patientnameTable = appointTableModel.getValueAt(numberOfRow, 1).toString();
                patientnameField.setText(patientnameTable);

                String doctornameTable = appointTableModel.getValueAt(numberOfRow, 2).toString();
                doctornameField.setText(doctornameTable);

                String MobileTable = appointTableModel.getValueAt(numberOfRow, 3).toString();
                nursenameField.setText(MobileTable);

                try {
                    String appointdateTable = appointTableModel.getValueAt(numberOfRow, 4).toString();
                    Date date = new SimpleDateFormat("dd MMM, yyyy").parse(appointdateTable);
                    appointdate.setDate(date);

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                }

                String paymentTable = appointTableModel.getValueAt(numberOfRow, 5).toString();
                paymentField.setText(paymentTable);

            }
        });

    }

    @Override
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

                }
                if (patientidField.getText().equals(id) && patientauthField.getText().equals(auth)) {

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                        Statement st2 = con.createStatement();

                        String query = "select * from appointment where patient_id='" + patientidField.getText() + "'";

                        ResultSet rs2 = st2.executeQuery(query);

                        while (rs2.next()) {
                            rows[0] = String.valueOf(rs2.getInt("id"));
                            rows[1] = rs2.getString("patient_name");
                            rows[2] = rs2.getString("doctor_name");
                            rows[3] = rs2.getString("nurse_name");
                            rows[4] = rs2.getString("appointment_date");
                            rows[5] = rs2.getString("payment");
                            appointTableModel.addRow(rows);
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
                    JOptionPane.showMessageDialog(this, "Your patient ID and authcode didn't match!");
                    confirmButton.setEnabled(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            removeButton.setEnabled(true);
        } else if (e.getSource() == backButton) {
            this.setVisible(false);
            new Patientdashboard().setVisible(true);
        } else if (e.getSource() == removeButton) {
            int decision = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this appointment? You will be refunded if you have paid.", "Cancel Confirmation", 2);
            if (decision == JOptionPane.OK_OPTION) {
                int numberOfRow = appointTable.getSelectedRow();
                if (numberOfRow >= 0) {
                    try {
                        String query = "DELETE FROM `appointment` WHERE id=?";
                        con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, idTextField.getText());
                        pst.executeUpdate();
                        appointTableModel.removeRow(numberOfRow);
                        JOptionPane.showMessageDialog(null, "Canceled Successfully!");
                        removeButton.setEnabled(false);
                        appointTable.getSelectionModel().clearSelection();
                        idTextField.setText("");
                        patientnameField.setText("");
                        doctornameField.setText("");
                        nursenameField.setText("");
                        appointdate.setCalendar(null);
                        paymentField.setText("");

                        con.close();
                        pst.close();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        PatientEditAppoint appoint = new PatientEditAppoint();
        appoint.setVisible(true);

    }

}
