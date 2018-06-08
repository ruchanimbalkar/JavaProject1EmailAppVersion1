/***
 * 
 * @author Rucha Nimbalkar
 *  Project 2 : Student Enrollment from Udemy
 *  			(Array of Objects)
 */
package studentdatabaseapp;
import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
//		Student stu1 = new Student();
//		stu1.enroll();
//		stu1.payTutition();
//		System.out.println(stu1.toString());
//		
		// Ask how many users you want to add?
		System.out.println("Enter number of new students to enroll: ");
		Scanner in = new Scanner(System.in);
		int numOfStudents = in.nextInt();
		//Array of Objects --> Reference is created here and 
		//memory is allocated to store references for numOfStudents
		Student students[] = new Student[numOfStudents]; 
		
		
		
		//Create n number of new students
		 for(int i=0;i<numOfStudents;i++){
			 	students[i] = new Student(); //Objects are created 
				students[i].enroll();
				students[i].payTutition();
				
		 }
		 
		 for(int i=0;i<numOfStudents;i++)
			 System.out.println(students[i].toString());
	}

}
