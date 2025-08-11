import javax.swing.JFrame;



public class Patientpage extends JFrame{
    
    public Patientpage(){
        initComponents();
    }
    
    public void initComponents(){
        this.setTitle("Patient's HomePage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}