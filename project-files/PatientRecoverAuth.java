
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PatientRecoverAuth extends JFrame implements ActionListener {

    private JPanel mainPanel, passPanel;
    private JTextField passField, idField;
    private JLabel authLabel, passLabel, idLabel;
    private JButton confirmButton, cancelButton;
    String pass, id, auth;
    private Connection con = null;
    private Statement st = null;
    private PreparedStatement pst = null;

    public PatientRecoverAuth() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Patient Recover Authcode");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(getToolkit().getImage("C:\\Users\\Tamjid\\Desktop\\ourproject\\logo.png"));
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 600, 400);
        mainPanel.setBackground(Color.decode("#00ADEF"));
        mainPanel.setLayout(null);
        mainPanel.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        this.add(mainPanel);

        passPanel = new JPanel();
        passPanel.setBounds(100, 50, 400, 300);
        passPanel.setBackground(Color.decode("#B8EEFF"));
        passPanel.setLayout(null);
        mainPanel.add(passPanel);

        authLabel = new JLabel();
        authLabel.setFont(new Font("Segoe UI", 1, 18));
        authLabel.setText("Recover Authcode");
        authLabel.setBounds(130, 8, 250, 30);
        authLabel.setForeground(Color.BLACK);
        authLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(authLabel);

        passLabel = new JLabel();
        passLabel.setFont(new Font("Segoe UI", 1, 14));
        passLabel.setText("Enter Your password: ");
        passLabel.setBounds(10, 70, 160, 30);
        passLabel.setForeground(Color.BLACK);
        passLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(passLabel);

        passField = new JTextField();
        passField.setFont(new Font("Segoe UI", 1, 14));
        passField.setBounds(180, 70, 200, 30);
        passField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(passField);
        
        
        idLabel = new JLabel();
        idLabel.setFont(new Font("Segoe UI", 1, 14));
        idLabel.setText("Enter Your patient ID: ");
        idLabel.setBounds(10, 125, 160, 30);
        idLabel.setForeground(Color.BLACK);
        idLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(idLabel);

        idField = new JTextField();
        idField.setFont(new Font("Segoe UI", 1, 14));
        idField.setBounds(180, 125, 200, 30);
        idField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(idField);


        confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Segoe UI", 1, 14));
        confirmButton.setBounds(300, 250, 80, 28);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.decode("#00ADEF"));
        confirmButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        confirmButton.setFocusable(false);
        passPanel.add(confirmButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Segoe UI", 1, 16));
        cancelButton.setBounds(20, 251, 80, 28);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.decode("#00ADEF"));
        cancelButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        cancelButton.setFocusable(false);
        passPanel.add(cancelButton);

        cancelButton.addActionListener(this);
        confirmButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                        Statement st = con.createStatement();

                        String sql = "select * from patient where binary password = '" + passField.getText() + "' and binary id='" + idField.getText() + "'";

                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            pass = rs.getString("password");
                            id = rs.getString("id");
                            auth = rs.getString("authcode");
                            
                        }
                        if(passField.getText().equals(pass)&&idField.getText().equals(id)){
                            JOptionPane.showMessageDialog(this, "Your patient authcode is : "+auth);
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(this, "Your password and patient ID didn't match!");
                        }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, e);
            }
        } else if (e.getSource() == cancelButton) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        PatientRecoverAuth pass = new PatientRecoverAuth();
        pass.setVisible(true);

    }
}
