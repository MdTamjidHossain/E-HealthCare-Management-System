
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

public class EditNurse extends JFrame implements ActionListener {

    private JPanel mainPanel, allpatientPanel;
    private JLabel allpatientLabel, idLabel, nameLabel, dobLabel, addressLabel, mobileLabel, emailLabel;
    private JTextField idTextField, nameTextField, addressTextField, mobileTextField, emailTextField;
    private JDateChooser dob;
    private JButton backButton, updateButton, removeButton, clearButton, clearAllButton;
    private JTable patientTable;
    private JScrollPane patientScrollPane;
    private DefaultTableModel patientTableModel;
    private String[] columns = {"ID", "Name", "Date Of Birth", "Adress", "Mobile Number", "Email"};
    private String[] rows = new String[6];
    private Connection con = null;
    private Statement st = null;

    public EditNurse() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Update / Remove Nurses");
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
        allpatientPanel.setBounds(40, 55, 1000, 550);
        allpatientPanel.setBackground(Color.decode("#B8EEFF"));
        allpatientPanel.setLayout(null);
        mainPanel.add(allpatientPanel);

        allpatientLabel = new JLabel();
        allpatientLabel.setText("Update / Remove Nurses");
        allpatientLabel.setFont(new Font("Sageo UI", 1, 24));
        allpatientLabel.setBounds(340, 15, 450, 40);
        allpatientPanel.add(allpatientLabel);

        idLabel = new JLabel();
        idLabel.setText("ID :");
        idLabel.setFont(new Font("Sageo UI", 1, 14));
        idLabel.setBounds(10, 100, 80, 30);
        allpatientPanel.add(idLabel);

        idTextField = new JTextField();
        idTextField.setText("");
        idTextField.setFont(new Font("Sageo UI", 0, 14));
        idTextField.setBounds(110, 100, 260, 30);
        idTextField.setEditable(false);
        allpatientPanel.add(idTextField);

        nameLabel = new JLabel();
        nameLabel.setText("Name :");
        nameLabel.setFont(new Font("Sageo UI", 1, 14));
        nameLabel.setBounds(10, 150, 80, 30);
        allpatientPanel.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setText("");
        nameTextField.setFont(new Font("Sageo UI", 0, 14));
        nameTextField.setBounds(110, 150, 260, 30);
        allpatientPanel.add(nameTextField);

        dobLabel = new JLabel();
        dobLabel.setText("Date of Birth :");
        dobLabel.setFont(new Font("Sageo UI", 1, 14));
        dobLabel.setBounds(10, 200, 100, 30);
        allpatientPanel.add(dobLabel);

        dob = new JDateChooser();
        dob.setDateFormatString("dd MMM, yyyy");
        dob.setBounds(110, 200, 260, 30);
        allpatientPanel.add(dob);

        addressLabel = new JLabel();
        addressLabel.setText("Address :");
        addressLabel.setFont(new Font("Sageo UI", 1, 14));
        addressLabel.setBounds(10, 250, 80, 30);
        allpatientPanel.add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setText("");
        addressTextField.setFont(new Font("Sageo UI", 0, 14));
        addressTextField.setBounds(110, 250, 260, 30);
        allpatientPanel.add(addressTextField);

        mobileLabel = new JLabel();
        mobileLabel.setText("Mobile :");
        mobileLabel.setFont(new Font("Sageo UI", 1, 14));
        mobileLabel.setBounds(10, 300, 80, 30);
        allpatientPanel.add(mobileLabel);

        mobileTextField = new JTextField();
        mobileTextField.setText("");
        mobileTextField.setFont(new Font("Sageo UI", 0, 14));
        mobileTextField.setBounds(110, 300, 260, 30);
        allpatientPanel.add(mobileTextField);

        emailLabel = new JLabel();
        emailLabel.setText("Email :");
        emailLabel.setFont(new Font("Sageo UI", 1, 14));
        emailLabel.setBounds(10, 350, 80, 30);
        allpatientPanel.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setText("");
        emailTextField.setFont(new Font("Sageo UI", 0, 14));
        emailTextField.setBounds(110, 350, 260, 30);
        allpatientPanel.add(emailTextField);

        removeButton = new JButton("Remove");
        removeButton.setFont(new Font("Segoe UI", 1, 14));
        removeButton.setBounds(70, 422, 90, 30);
        removeButton.setBorder(new LineBorder(new Color(6, 90, 215), 1));
        removeButton.setBackground(Color.decode("#37f9f8"));
        removeButton.setFocusable(false);
        allpatientPanel.add(removeButton);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Segoe UI", 1, 14));
        updateButton.setBounds(210, 422, 90, 30);
        updateButton.setBorder(new LineBorder(new Color(6, 90, 215), 1));
        updateButton.setBackground(Color.decode("#37f9f8"));
        updateButton.setFocusable(false);
        allpatientPanel.add(updateButton);

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Segoe UI", 1, 14));
        clearButton.setBounds(70, 470, 90, 30);
        clearButton.setBorder(new LineBorder(new Color(6, 90, 215), 1));
        clearButton.setBackground(Color.decode("#37f9f8"));
        clearButton.setFocusable(false);
        allpatientPanel.add(clearButton);

        clearAllButton = new JButton("Clear All");
        clearAllButton.setFont(new Font("Segoe UI", 1, 14));
        clearAllButton.setBounds(210, 470, 90, 30);
        clearAllButton.setBorder(new LineBorder(new Color(6, 90, 215), 1));
        clearAllButton.setBackground(Color.decode("#37f9f8"));
        clearAllButton.setFocusable(false);
        allpatientPanel.add(clearAllButton);

        patientTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        patientTableModel = new DefaultTableModel();
        patientTableModel.setColumnIdentifiers(columns);

        patientTable.setModel(patientTableModel);
        patientTable.setFont(new Font("Sageo UI", 0, 14));
        patientTable.setBackground(Color.decode("#FFFFFF"));
        patientTable.setRowHeight(35);
        patientTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        patientTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        patientTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        patientTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        patientTable.getColumnModel().getColumn(4).setPreferredWidth(60);
        patientTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        patientTable.getTableHeader().setResizingAllowed(false);
        patientTable.getTableHeader().setReorderingAllowed(false);


        patientScrollPane = new JScrollPane(patientTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        patientScrollPane.setBounds(380, 80, 600, 450);
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

            String sql = "select * from nurse";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                rows[0] = String.valueOf(rs.getInt("id"));
                rows[1] = rs.getString("name");
                rows[2] = rs.getString("dob");
                rows[3] = rs.getString("address");
                rows[4] = rs.getString("mobile");
                rows[5] = rs.getString("email");
                patientTableModel.addRow(rows);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        backButton.addActionListener(this);
        removeButton.addActionListener(this);
        updateButton.addActionListener(this);
        clearButton.addActionListener(this);
        clearAllButton.addActionListener(this);

        patientTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int numberOfRow = patientTable.getSelectedRow();
                String idTable = patientTableModel.getValueAt(numberOfRow, 0).toString();
                idTextField.setText(idTable);

                String NameTable = patientTableModel.getValueAt(numberOfRow, 1).toString();
                nameTextField.setText(NameTable);

                try {
                    String dobTable = patientTableModel.getValueAt(numberOfRow, 2).toString();
                    Date date = new SimpleDateFormat("dd MMM, yyyy").parse(dobTable);
                    dob.setDate(date);

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                }

                String AddressTable = patientTableModel.getValueAt(numberOfRow, 3).toString();
                addressTextField.setText(AddressTable);

                String MobileTable = patientTableModel.getValueAt(numberOfRow, 4).toString();
                mobileTextField.setText(MobileTable);

                String EmailTable = patientTableModel.getValueAt(numberOfRow, 5).toString();
                emailTextField.setText(EmailTable);

            }
        });

    }

    public static void main(String[] args) {
        EditNurse nurse = new EditNurse();
        nurse.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.setVisible(false);
            new Admindashboard().setVisible(true);
        } else if (e.getSource() == removeButton) {
            int numberOfRow = patientTable.getSelectedRow();
            if (numberOfRow >= 0) {
                try {
                    String query = "DELETE FROM `nurse` WHERE id=?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, idTextField.getText());
                    pst.executeUpdate();
                    patientTableModel.removeRow(numberOfRow);
                    JOptionPane.showMessageDialog(null, "Deleted Successfully!");
                    patientTable.getSelectionModel().clearSelection();
                    idTextField.setText("");
                    nameTextField.setText("");
                    dob.setCalendar(null);
                    addressTextField.setText("");
                    mobileTextField.setText("");
                    emailTextField.setText("");

                    con.close();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } else if (e.getSource() == clearButton) {
            if (nameTextField.hasFocus()) {
                nameTextField.setText("");
            } else if (dob.getDateEditor().getUiComponent().hasFocus()) {
                dob.setCalendar(null);
            } else if (addressTextField.hasFocus()) {
                addressTextField.setText("");
            } else if (mobileTextField.hasFocus()) {
                mobileTextField.setText("");
            } else if (emailTextField.hasFocus()) {
                emailTextField.setText("");
            }
        } else if (e.getSource() == clearAllButton) {
            patientTable.getSelectionModel().clearSelection();
            idTextField.setText("");
            nameTextField.setText("");
            dob.setCalendar(null);
            addressTextField.setText("");
            mobileTextField.setText("");
            emailTextField.setText("");
        } else if (e.getSource() == updateButton) {
            int numberOfRow = patientTable.getSelectedRow();
            if (numberOfRow >= 0) {
                
                String nameTable = nameTextField.getText();
                String dobTable = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
                String addressTable = addressTextField.getText();
                String mobileTable = mobileTextField.getText();
                String emailTable = emailTextField.getText();
                
                
                patientTableModel.setValueAt(nameTable, numberOfRow, 1);
                patientTableModel.setValueAt(dobTable, numberOfRow, 2);
                patientTableModel.setValueAt(addressTable, numberOfRow, 3);
                patientTableModel.setValueAt(mobileTable, numberOfRow, 4);
                patientTableModel.setValueAt(emailTable, numberOfRow, 5);
                
                try {
                    String query = "UPDATE `nurse` SET `name`=?,`dob`=?,`address`=?,`mobile`=?,`email`=? WHERE `id`=?";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/ourproject", "root", "");
                    PreparedStatement pst = con.prepareStatement(query);

                    pst.setString(6, idTextField.getText());
                    pst.setString(1, nameTextField.getText());
                    pst.setString(2, ((JTextField) dob.getDateEditor().getUiComponent()).getText());
                    pst.setString(3, addressTextField.getText());
                    pst.setString(4, mobileTextField.getText());
                    pst.setString(5, emailTextField.getText());

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully Updated!");

                    con.close();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }

    }
}
