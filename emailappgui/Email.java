package emailappgui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Email extends JFrame {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity=500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "rpcompany.com";
	private static final int WIDTH=500;
	private static final int HEIGHT=300;
	private static JTextField fName;  //holds user's first name
	private static JTextField lName;  //holds user's last name
	private static JLabel namePrompt;
	private static JLabel deptPrompt;
	private static JComboBox deptCombo;
	private static JButton submit;
	private static JLabel generatedEmail;
	private static JLabel genPassword;
	
	
	public Email(){
		
		setTitle("EMAIL ADDRESS CREATOR FRAME");
		setSize(WIDTH,HEIGHT);
		setLayout(new FlowLayout());
		createContents();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//******************************************************************************************
	 
	//Create Components and add them to the window 
	private  void createContents(){
		namePrompt = new JLabel("Enter Name: ");
		deptPrompt = new JLabel("Select Department");
		deptCombo = new JComboBox();
		deptCombo.addItem("sales");
		deptCombo.addItem("dev");
		deptCombo.addItem("acc");
		fName = new JTextField("First Name");
		lName = new JTextField("Last Name");
		submit = new JButton("Submit");
		add(namePrompt);
		add(fName);
		add(lName);
		add(deptPrompt);
		add(deptCombo);
		add(submit);
		submit.addActionListener(new Listener());

	}//end createContents
		
	//******************************************************************************************
		
	//*******************************************************************************************
		//Inner Class for Event Handling
	private class Listener implements ActionListener{
				
		public void actionPerformed(ActionEvent e){
					
					Container contentPane = getContentPane();
					String dept =deptCombo.getSelectedItem().toString();
					saveInfo(fName.getText(),lName.getText(),dept);
					String message = "Email: " + email + "\nPassword: "+ password;
					JOptionPane.showMessageDialog(null, message,"Email & Password generated successfully!",JOptionPane.INFORMATION_MESSAGE);
					showInfo();
					
				}//end actionPerformed
	}//end class ComboBoxListener
			
	//Save information from the frame
	private void saveInfo(String f, String l, String d){
		
		this.firstName=f;
		this.lastName=l;
		this.department=d;
		//Combine elements to generate email
		this.email= firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." +companySuffix;
		this.password=randomPassword(defaultPasswordLength);
	}
	
	
	//Generate a random password
	private String randomPassword(int length){
			String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
			char[] password = new char[length];
			for(int i=0;i<length;i++){
				int rand = (int) (Math.random() *passwordSet.length());
				password[i]=passwordSet.charAt(rand);
			}
			return new String(password);
		}
	
	public void showInfo(){
		String name = this.firstName + " " + this.lastName;
		String mailbox = this.mailBoxCapacity +"mb";
		String message = "Name: " + name + "\nEmail: "+ email + "\nMailbox capacity: " + mailbox;
		JOptionPane.showMessageDialog(null, message,"Employee Info",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
