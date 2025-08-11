
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


public class AllAppointment extends JFrame implements ActionListener{

    private JPanel mainPanel, allpatientPanel;
    private JLabel allpatientLabel;
    private JButton backButton;
    private JTable patientTable;
    private JScrollPane patientScrollPane;
    private DefaultTableModel patientTableModel;
    private String[] columns = {"ID", "Patient Name", "Doctor Name", "Nurse Name", "Appointment Date", "Payment"};
    private String[] rows = new String[6];
    private Connection con=null;
    private Statement st=null;

    public AllAppointment() {
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
        allpatientLabel.setText("View All Appointments");
        allpatientLabel.setFont(new Font("Sageo UI", 1, 24));
        allpatientLabel.setBounds(340, 15, 450, 40);
        allpatientPanel.add(allpatientLabel);
        
        
        patientTable = new JTable();
        
        patientTableModel = new DefaultTableModel();
        patientTableModel.setColumnIdentifiers(columns);
        
        patientTable.setModel(patientTableModel);
        patientTable.setFont(new Font("Sageo UI", 0, 14));
        patientTable.setBackground(Color.decode("#FFFFFF"));
        patientTable.setRowHeight(50);
        
        
        patientScrollPane = new JScrollPane(patientTable);
        patientScrollPane.setBounds(30, 70, 790, 450);
        allpatientPanel.add(patientScrollPane);
        

        backButton = new JButton();
        backButton.setFont(new Font("Segoe UI", 1, 18));
        backButton.setBounds(15, 615, 90, 30);
        backButton.setFocusable(false);
        backButton.setText("Back");
        backButton.setBorder(new LineBorder(Color.black, 1));
        mainPanel.add(backButton);
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                    Statement st = con.createStatement();

                    String sql = "select * from appointment";

                    ResultSet rs = st.executeQuery(sql);
                    
                    while(rs.next()){
                        rows[0] = String.valueOf(rs.getInt("id"));
                        rows[1] = rs.getString("patient_name");
                        rows[2] = rs.getString("doctor_name");
                        rows[3] = rs.getString("nurse_name");
                        rows[4] = rs.getString("appointment_date");
                        rows[5] = rs.getString("payment");
                        patientTableModel.addRow(rows);
                    }
                    
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        backButton.addActionListener(this);
        
    }

    public static void main(String[] args) {
        AllAppointment appoint = new AllAppointment();
        appoint.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            this.setVisible(false);
            new Admindashboard().setVisible(true);
        }
    }
}
