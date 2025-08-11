import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;



public class Adminchangeinfo extends JFrame implements ActionListener{
    
    
    private JPanel mainPanel, infoPanel;
    private JTextField displaynameField, usernameField;
    private JLabel infoLabel, displaynameLabel, usernameLabel;
    private JButton confirmButton, cancelButton;
    private Connection con=null;
    private Statement st=null;
    
    public Adminchangeinfo(){
        initComponents();
    }
    
    public void initComponents(){
        this.setTitle("Change Informations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setIconImage(getToolkit().getImage("C:\\Users\\Tamjid\\Desktop\\ourproject\\logo.png"));
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        
        
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 600, 400);
        mainPanel.setBackground(Color.decode("#00ADEF"));
        mainPanel.setLayout(null);
        mainPanel.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        this.add(mainPanel);
        
        
        infoPanel = new JPanel();
        infoPanel.setBounds(100, 50, 400, 300);
        infoPanel.setBackground(Color.decode("#B8EEFF"));
        infoPanel.setLayout(null);
        mainPanel.add(infoPanel);
        
        
        infoLabel = new JLabel();
        infoLabel.setFont(new Font("Segoe UI", 1, 18));
        infoLabel.setText("Change Informations");
        infoLabel.setBounds(115, 8, 250, 30);
        infoLabel.setForeground(Color.BLACK);
        infoLabel.setBackground(Color.decode("#00ADEF"));
        infoPanel.add(infoLabel);
        
        
        displaynameLabel = new JLabel();
        displaynameLabel.setFont(new Font("Segoe UI", 1, 14));
        displaynameLabel.setText("Change Display Name: ");
        displaynameLabel.setBounds(10, 100, 160, 30);
        displaynameLabel.setForeground(Color.BLACK);
        displaynameLabel.setBackground(Color.decode("#00ADEF"));
        infoPanel.add(displaynameLabel);
        
        
        usernameLabel = new JLabel();
        usernameLabel.setFont(new Font("Segoe UI", 1, 14));
        usernameLabel.setText("Change Username: ");
        usernameLabel.setBounds(10, 160, 160, 30);
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setBackground(Color.decode("#00ADEF"));
        infoPanel.add(usernameLabel);
        
        
        displaynameField = new JTextField();
        displaynameField.setFont(new Font("Segoe UI", 1, 14));
        displaynameField.setBounds(180, 100, 200, 30);
        displaynameField.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(displaynameField);
        
        
        usernameField = new JTextField();
        usernameField.setFont(new Font("Segoe UI", 1, 14));
        usernameField.setBounds(180, 160, 200, 30);
        usernameField.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(usernameField);
        
        
        confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Segoe UI", 1, 14));
        confirmButton.setBounds(300, 250, 80, 28);
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.decode("#00ADEF"));
        confirmButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        confirmButton.setFocusable(false);
        infoPanel.add(confirmButton);
        
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Segoe UI", 1, 16));
        cancelButton.setBounds(20, 251, 80, 28);
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.decode("#00ADEF"));
        cancelButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        cancelButton.setFocusable(false);
        infoPanel.add(cancelButton);
        
        
        cancelButton.addActionListener(this);
        confirmButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== confirmButton){
            if((displaynameField.getText().isEmpty())||(usernameField.getText().isEmpty())){
                JOptionPane.showMessageDialog(this, "Display name and username can not be empty!");
            }
            else{
                try {
                    String query = "UPDATE `admin` SET `displayname`=?,`username`=?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);


                    pst.setString(1, displaynameField.getText());
                    pst.setString(2, usernameField.getText());


                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully Updated!");

                    con.close();
                    pst.close();
                    
                    
                    this.dispose();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        else if(e.getSource()== cancelButton){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        Adminchangeinfo info = new Adminchangeinfo();
        info.setVisible(true);

    }

    
}