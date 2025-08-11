
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

public class DoctorChangePass extends JFrame implements ActionListener {

    private JPanel mainPanel, passPanel;
    private JTextField doctoridField, oldpassField, newpassField, confirmpassField;
    private JLabel doctoridLabel, passLabel, oldpassLabel, newpassLabel, confirmpassLabel;
    private JButton confirmButton, cancelButton;
    String doctorid,oldpassword;
    private Connection con = null;
    private Statement st = null;

    public DoctorChangePass() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Change Password");
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
        passLabel.setText("Change Password");
        passLabel.setBounds(130, 8, 250, 30);
        passLabel.setForeground(Color.BLACK);
        passLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(passLabel);
        
        
        
        doctoridLabel = new JLabel();
        doctoridLabel.setText("Doctor ID:");
        doctoridLabel.setFont(new Font("Sageo UI", 1, 15));
        doctoridLabel.setBounds(10, 60, 200, 30);
        passPanel.add(doctoridLabel);

        doctoridField = new JTextField();
        doctoridField.setBounds(180, 60, 200, 30);
        doctoridField.setFont(new Font("Segoe UI", 1, 14));
        doctoridField.setBorder(new LineBorder(Color.black, 2));
        passPanel.add(doctoridField);
        
        

        oldpassLabel = new JLabel();
        oldpassLabel.setFont(new Font("Segoe UI", 1, 14));
        oldpassLabel.setText("Enter Old Password: ");
        oldpassLabel.setBounds(10, 100, 160, 30);
        oldpassLabel.setForeground(Color.BLACK);
        oldpassLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(oldpassLabel);

        newpassLabel = new JLabel();
        newpassLabel.setFont(new Font("Segoe UI", 1, 14));
        newpassLabel.setText("Enter New Password: ");
        newpassLabel.setBounds(10, 150, 160, 30);
        newpassLabel.setForeground(Color.BLACK);
        newpassLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(newpassLabel);

        confirmpassLabel = new JLabel();
        confirmpassLabel.setFont(new Font("Segoe UI", 1, 14));
        confirmpassLabel.setText("Confirm New Password: ");
        confirmpassLabel.setBounds(10, 200, 180, 30);
        confirmpassLabel.setForeground(Color.BLACK);
        confirmpassLabel.setBackground(Color.decode("#00ADEF"));
        passPanel.add(confirmpassLabel);

        oldpassField = new JTextField();
        oldpassField.setFont(new Font("Segoe UI", 1, 14));
        oldpassField.setBounds(180, 100, 200, 30);
        oldpassField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(oldpassField);

        newpassField = new JTextField();
        newpassField.setFont(new Font("Segoe UI", 1, 14));
        newpassField.setBounds(180, 150, 200, 30);
        newpassField.setBorder(new LineBorder(Color.BLACK, 2));
        passPanel.add(newpassField);

        confirmpassField = new JTextField();
        confirmpassField.setFont(new Font("Segoe UI", 1, 14));
        confirmpassField.setBounds(180, 200, 200, 30);
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
            } else if(doctoridField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Doctor ID is needed!");
            }
            
            else {
                if (newpassField.getText().equals(confirmpassField.getText())) {

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourproject", "root", "");

                        Statement st = con.createStatement();

                        String sql = "select * from doctor where binary password = '" + oldpassField.getText() + "'and id='" + doctoridField.getText() + "'";

                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            doctorid = rs.getString("id");
                            oldpassword = rs.getString("password");
                        }
                        if (doctoridField.getText().equals(doctorid)&&oldpassField.getText().equals(oldpassword)) {
                            try {
                                String query = "UPDATE `doctor` SET `password`=? WHERE `password`=?";
                                con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                                PreparedStatement pst = con.prepareStatement(query);
                                
                                
                                pst.setString(2, oldpassField.getText());
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
                            JOptionPane.showMessageDialog(this, "Your old password and id is not correct!");
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
        DoctorChangePass pass = new DoctorChangePass();
        pass.setVisible(true);

    }
}
