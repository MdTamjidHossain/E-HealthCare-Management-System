
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

public class Adminchangepass extends JFrame implements ActionListener {

    private JPanel mainPanel, passPanel;
    private JTextField oldpassField, newpassField, confirmpassField;
    private JLabel passLabel, oldpassLabel, newpassLabel, confirmpassLabel;
    private JButton confirmButton, cancelButton;
    String oldpassword;
    private Connection con = null;
    private Statement st = null;

    public Adminchangepass() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Change Informations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        passLabel.setText("Change Password");
        passLabel.setBounds(130, 8, 250, 30);
        passLabel.setForeground(Color.BLACK);
        passLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(passLabel);

        oldpassLabel = new JLabel();
        oldpassLabel.setFont(new Font("Segoe UI", 1, 14));
        oldpassLabel.setText("Enter Old Password: ");
        oldpassLabel.setBounds(10, 70, 160, 30);
        oldpassLabel.setForeground(Color.BLACK);
        oldpassLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(oldpassLabel);

        newpassLabel = new JLabel();
        newpassLabel.setFont(new Font("Segoe UI", 1, 14));
        newpassLabel.setText("Enter New Password: ");
        newpassLabel.setBounds(10, 130, 160, 30);
        newpassLabel.setForeground(Color.BLACK);
        newpassLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(newpassLabel);

        confirmpassLabel = new JLabel();
        confirmpassLabel.setFont(new Font("Segoe UI", 1, 14));
        confirmpassLabel.setText("Confirm New Password: ");
        confirmpassLabel.setBounds(10, 190, 160, 30);
        confirmpassLabel.setForeground(Color.BLACK);
        confirmpassLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(confirmpassLabel);

        oldpassField = new JTextField();
        oldpassField.setFont(new Font("Segoe UI", 1, 14));
        oldpassField.setBounds(180, 70, 200, 30);
        oldpassField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(oldpassField);

        newpassField = new JTextField();
        newpassField.setFont(new Font("Segoe UI", 1, 14));
        newpassField.setBounds(180, 130, 200, 30);
        newpassField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(newpassField);

        confirmpassField = new JTextField();
        confirmpassField.setFont(new Font("Segoe UI", 1, 14));
        confirmpassField.setBounds(180, 190, 200, 30);
        confirmpassField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(confirmpassField);

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
            if ((newpassField.getText().isEmpty()) || (confirmpassField.getText().isEmpty())) {
                JOptionPane.showMessageDialog(this, "New password can not be empty!");
            } else {
                if (newpassField.getText().equals(confirmpassField.getText())) {

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                        Statement st = con.createStatement();

                        String sql = "select * from admin";

                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            oldpassword = rs.getString("password");
                        }
                        if (oldpassField.getText().equals(oldpassword)) {
                            try {
                                String query = "UPDATE `admin` SET `password`=?";
                                con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                                PreparedStatement pst = con.prepareStatement(query);

                                pst.setString(1, confirmpassField.getText());

                                pst.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Successfully Updated!");

                                con.close();
                                pst.close();

                                this.dispose();

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, e);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Your old password is not correct!");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Your passwords must match!");
                }
            }
        } else if (e.getSource() == cancelButton) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Adminchangepass pass = new Adminchangepass();
        pass.setVisible(true);

    }
}
