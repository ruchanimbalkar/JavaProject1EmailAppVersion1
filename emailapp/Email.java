package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity=500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "rpcompany.com";
	
	//Constructor to receive firstName and lastName
	public Email(String firstName, String lastName){
		
		this.firstName=firstName;
		this.lastName=lastName;
		//System.out.println("EMAIL CREATED " + this.firstName +" "+ this.lastName);
		
		//Call a method asking for the department - return the department
		this.department = setDepartment();
		//System.out.println("Department: "+ this.department);
		
		//Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: "+ this.password);
		
		//Combine elements to generate email
		email= firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." +companySuffix;
		//System.out.println("Your email is: "+ email);
	}
	
	//Ask for the department
	private String setDepartment(){
		
		System.out.println("Department Codes\n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none \n Enter Department Code:");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if(deptChoice==1)
			return "sales";
		else if (deptChoice==2)
			return "dev";
		else if (deptChoice==3)
			return "acct";
		else{return "";}
		
		
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
	
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity){
		this.mailBoxCapacity=capacity;
	}
	
	
	//Set the alternate password
	public void setAlternateEmail(String altEmail){
		this.alternateEmail=altEmail;
	}
	
	//Change the password
	public void changePassword(String password){
		this.password=password;
	}

	public int getMailBoxCapacity(){
		return mailBoxCapacity;
	}
	
	public String getAlternateEmail(){return alternateEmail;}
	
	public String getPassword(){return password;}
	
	public String showInfo(){
		return "\nDISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + " " +
				"\nMAILBOX CAPACITY: " + mailBoxCapacity+ "mb";
	}
}

