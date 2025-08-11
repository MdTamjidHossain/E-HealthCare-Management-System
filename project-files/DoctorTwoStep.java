
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

public class DoctorTwoStep extends JFrame implements ActionListener {

    private JPanel mainPanel, passPanel;
    private JTextField idField, authField;
    private JLabel passLabel, idLabel, authLabel;
    private JButton confirmButton, cancelButton;
    String id, auth;
    private Connection con = null;
    private Statement st = null;
    private PreparedStatement pst = null;

    public DoctorTwoStep() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Change Informations");
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

        passLabel = new JLabel();
        passLabel.setFont(new Font("Segoe UI", 1, 18));
        passLabel.setText("Verify ID");
        passLabel.setBounds(130, 8, 250, 30);
        passLabel.setForeground(Color.BLACK);
        passLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(passLabel);

        idLabel = new JLabel();
        idLabel.setFont(new Font("Segoe UI", 1, 14));
        idLabel.setText("Enter Your ID: ");
        idLabel.setBounds(10, 70, 160, 30);
        idLabel.setForeground(Color.BLACK);
        idLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(idLabel);

        idField = new JTextField();
        idField.setFont(new Font("Segoe UI", 1, 14));
        idField.setBounds(180, 70, 200, 30);
        idField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(idField);

        authLabel = new JLabel();
        authLabel.setFont(new Font("Segoe UI", 1, 14));
        authLabel.setText("Enter Your Auth code: ");
        authLabel.setBounds(10, 125, 160, 30);
        authLabel.setForeground(Color.BLACK);
        authLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(authLabel);

        authField = new JTextField();
        authField.setFont(new Font("Segoe UI", 1, 14));
        authField.setBounds(180, 125, 200, 30);
        authField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(authField);

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

                String sql = "select * from doctor where binary id = '" + idField.getText() + "' and binary authcode='" + authField.getText() + "'";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    id = rs.getString("id");
                    auth = rs.getString("authcode");

                }
                if (idField.getText().equals(id) || authField.getText().equals(auth)) {
                    try {
                        String query = "UPDATE `doctor` SET `status`=? WHERE `id`=? AND `authcode`=?";
                        con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                        PreparedStatement pst = con.prepareStatement(query);

                        pst.setString(3, authField.getText());
                        pst.setString(2, idField.getText());
                        pst.setString(1, "verified");

                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Verified Successfully! Please login using your information now.");

                        con.close();
                        pst.close();

                        this.dispose();
                        new Loginpage().setVisible(true);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Your ID and auth code didn't match!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, e);
            }
        } else if (e.getSource() == cancelButton) {
            int decision = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel? You will have to register again!", "Cancel Registration Confirmation", 2);
            if (decision == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                new Loginpage().setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        DoctorTwoStep pass = new DoctorTwoStep();
        pass.setVisible(true);

    }
}
