package studentdatabaseapp;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses="";
	private int tuitionBalance=0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	private Scanner in;
		
	
	//Constructor : prompt user to enter student's name and year
	public Student(){
		
		in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("\n1 - Freshmen \n2 - Sophomore \n3 - Junior\n4 - Senior \nEnter student grad level: ");
		this.gradeYear=in.nextInt();
		
		setStudentId();
		//System.out.println(firstName + " " + lastName + " " + gradeYear + " " +studentId);
		
		
	}
	
	//Generate an ID
	private void setStudentId(){
		id++;
		//Grade Level + id
		this.studentId= gradeYear+ "" +id;

	}
	
	
	//Enroll in courses
	public void enroll(){
		//Get inside a loop User hits Q
		do{
			
			System.out.print("Enter course to enroll (Q to Quit: ) ");
			Scanner sc = new Scanner(System.in);
			String course = sc.nextLine();
			if(!course.equals("Q")){
				courses =  courses +"\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else{break;}
		}while(1!=0);
		viewBalance();
		//System.out.println("Enrolled in : "+ courses);
		//System.out.println("Tuition Balance: "+ tuitionBalance);
		
	}
			
			
	// View Balance
			public void viewBalance(){
				System.out.println("Your Balance is: $" + tuitionBalance);
			}
			
			
	//Pay Tuition
		   public void payTutition(){
			   System.out.println("Enter your Payment :$");
			   Scanner in = new Scanner(System.in);
			   int payment = in.nextInt();
			   tuitionBalance = tuitionBalance - payment;
			   System.out.println("Thank you for your payment of $"+ payment);
			   viewBalance();
		   }
			
			
			
	//Show Status
		  public String toString(){
			  return "\nName: " + firstName + " "+lastName +
					  "\nGrade Level : "+ gradeYear+
					  "\nStudent Id : "+ studentId+
					  "\nCourses Enrolled : " + courses +
					  "\nBalance is: $" +tuitionBalance;
		  }
		   
}
