package studentdatabaseapp;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		Student stu1 = new Student();
		// Ask how many users you want to add?
		stu1.enroll();
		stu1.payTutition();
		System.out.println(stu1.toString());
		
		//Create n number of new students

	}

}
