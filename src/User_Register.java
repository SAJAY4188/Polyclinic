
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class User_Register extends JFrame implements ActionListener {

	Connection con;
	JTextField t1, t2, t3;
	JButton b;
	Random rn = new Random();
	int Id;
	
	public User_Register() {
		t1 = new JTextField("UserName", 10);
		t2 = new JTextField("Password", 10);
		t3 = new JTextField("Re-type Password", 10);
		b =  new JButton("Register");
		
		add(t1);
		add(t2);
		add(t3);
		add(b);
		
		b.addActionListener(this);
		
		setLayout(new FlowLayout());
		setSize(300, 300);
		setVisible(true);
		this.setTitle("Polyclinic");
		setDefaultCloseOperation(3);
	}
	public static void main(String[] args) {

		new User_Register();

	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String uname = t1.getText();
		String pass = t2.getText();
		String repass = t3.getText();
		
		if(!ae.getActionCommand().isEmpty()) {
		
			Id = 100+rn.nextInt();
		}
		
	      if(pass.equals(repass)) {
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
			     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/polyclinic", "root", "root@123");
				}catch(Exception e) {
					e.getMessage();
				}
			
			String sql = "insert into useraccount values(?,?,?)";
			try{
				PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, Id);
			pst.setString(2, uname);
			pst.setString(3, pass);
			pst.executeUpdate();
			}catch(Exception e) {
				e.getMessage();
			}
			
		}
	}
	
	

}
