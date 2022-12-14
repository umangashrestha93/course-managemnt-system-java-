import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseAdmin {
       //defining the names and password
	String name = "admin";
	String surname = "admin";
	String password = "123";


	Student student = new Student();
	Instructor instructor = new Instructor();
	Course course = new Course();
	Module module = new Module();
	CourseSchedule calender = new CourseSchedule();
	
	Scanner input = new Scanner(System.in);
	
	CourseAdmin(){
		
	}

	CourseAdmin(String name, String surname, String password) {

		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	void manageCourse() {
		System.out.println("Welcome to Course Management System\n");
		System.out.println("=====================================\n");
		System.out.println("1) Press 1 to create a course");
		System.out.println("2) Press 2 to modify a course");
		System.out.println("3) Press 3 to rename a course");
		System.out.println("4) Press 4 to add module to a course");
		System.out.println("5) Press 5 to return to Main Menu");
		
		try{
		int choice = input.nextInt();
		
		if(choice == 1){
			course.createCourse();
		}
		
		else if (choice == 2){
			course.modifyCourse();
		}
		
		else if (choice == 3){
			course.renameCourse();
		}
		else if (choice == 4){

		}
		
		else if (choice == 5){
//			menu();
			return;
		}
		
		else{
			System.out.println("The input you have entered in incorrect. Please try again.");
		}
		
		} catch (InputMismatchException e){
			System.out.println("The input you have entered in incorrect. Please try again.");
			manageCourse();
		}
	}

	void viewCourse() {
		course.viewCourse();
		
	}

//	module starts
void manageModule() {
	System.out.println("Welcome to Module Management System\n");
	System.out.println("=====================================\n");
	System.out.println("1) Press 1 to create a module");
	System.out.println("2) Press 2 to modify a module");
	System.out.println("3) Press 3 to rename a module");
	System.out.println("4) Press 4 to return to Main Menu");

	try{
		int choice = input.nextInt();

		if(choice == 1){
			module.createModule();
		}

		else if (choice == 2){
			module.modifyModule();
		}

		else if (choice == 3){
			module.renameModule();
		}

		else if (choice == 4){
//			menu();
			return;
		}

		else{
			System.out.println("The input you have entered in incorrect. Please try again.");
		}

	} catch (InputMismatchException e){
		System.out.println("The input you have entered in incorrect. Please try again.");
		manageModule();
	}
}

	void viewModule() {
		module.viewModule();

	}
//module ends
	void viewInstructor() {
		instructor.viewInstructorInfo();
	}

	void manageInstructorInfo() {
		System.out.println("Welcome to Instructor Management\n");
		System.out.println("1) Press 1 to create a Instructor Info");
		System.out.println("2) Press 2 to modify a Instructor Info");
		System.out.println("3) Press 3 to rename a Instructor");
		System.out.println("4) Press 4 to return to Main Menu");
		
		try{
		int choice = input.nextInt();
		
		if(choice == 1){
			instructor.createInstructor();
		}
		
		else if (choice == 2){
			instructor.modifyInstructorInfo();
		}
		
		else if (choice == 3){
			instructor.renameInstructor();
		}
		
		else if (choice == 4){
			menu();
		}
		
		else{
			System.out.println("You entered wrong input. Please try again.");
		}
		
		} catch (InputMismatchException e){
			System.out.println("You entered wrong input. Please try again.");
			manageInstructorInfo();
		}
	}

	void manageStudent() {
		System.out.println("Welcome to Student Management System\n");
		System.out.println("====================================\n");
		System.out.println("Follow the menu to manage students\n");
		System.out.println("1) Press 1 to create a Student Info");
		System.out.println("2) Press 2 to modify a Student Info");
		System.out.println("3) Press 3 to delete a Student Info");
		System.out.println("4) Press 4 to view a Student Info");
		System.out.println("5) Press 5 to return to Main Menu");
		
		try{
		int choice = input.nextInt();
		
		if(choice == 1){
			student.createStudent();
		}
		
		else if (choice == 2){
			student.modifyStudentInfo();
		}
		
		else if (choice == 3){
			student.deleteStudentData();
		}
		
		else if (choice == 4){
			student.viewStudentData();
		}
		
		else if (choice == 5){
			menu();
		}
		
		else{
			System.out.println("You entered wrong input. Please try again.");
		}
		
		} catch (InputMismatchException e){
			System.out.println("You entered wrong input. Please try again.");
			manageStudent();
		}
	}

	void viewStudent() {
		student.viewAllStudent();
	}
	
	void viewCourseCalender(){
		calender.viewCourseCalender();
	}

	void manageCourseCalender(){
		
		System.out.println("Welcome to Schedule Management\n");
		System.out.println("1) Press 1 to create a course schedule");
		System.out.println("2) Press 2 to modify a course schedule");
		System.out.println("3) Press 3 to delete a course schedule");
		System.out.println("4) Press 4 to return to Main Menu");
		
		try{
		int choice = input.nextInt();
		
		if(choice == 1){
			calender.createCourseCalender();
		}
		
		else if (choice == 2){
			calender.modifyCourseCalender();
		}
		
		else if (choice == 3){
			calender.deleteCourseCalender();
		}
		
		else if (choice == 4){
			menu();
		}
		
		else{
			System.out.println("You entered wrong input. Please try again.");
		}
		
		} catch (InputMismatchException e){
			System.out.println("You entered wrong input. Please try again.");
			manageCourseCalender();
		}
	}

	void menu(){
		
		boolean variable = true;
		while(variable){
		System.out.println("Welcome to Main Menu!\n");
		System.out.println("Please Select a choice from the following: \n");
		System.out.println("1) Press 1 to Course Management");
		System.out.println("2) Press 2 to View a Course Info");
		System.out.println("3) Press 3 to Module Management");
		System.out.println("4) Press 4 to View a Module Info");
		System.out.println("5) Press 5 to Instructor Management");
		System.out.println("6) Press 6 to View a Instructor Info");
		System.out.println("7) Press 7 to Student Management");
		System.out.println("8) Press 8 to View a Student Info");
		System.out.println("9) Press 9 to Course Schedule Management");
		System.out.println("10) Press 10 to View Course Schedule");
		System.out.println("11) Press 0 to Sign Out");
		
		try {
		int choice = input.nextInt();
		
		if (choice == 1){
			manageCourse();
		}
		
		else if (choice == 2){
			viewCourse();
		}

		else if (choice == 3){
			manageModule();
		}

		else if (choice == 4){
			viewModule();
		}


		else if (choice == 5){
			manageInstructorInfo();
		}
		
		else if (choice == 6){
			viewInstructor();
		}
		
		else if (choice == 7){
			manageStudent();
		}
		
		else if (choice == 8){
			viewStudent();
		}
		
		else if (choice == 9){
			manageCourseCalender();
		}
		
		else if (choice == 10){
			viewCourseCalender();
		}
		
		else if (choice == 0){
			System.out.println("You are logged out from system!\n\n");
			break;
		}
		
		else {
			System.out.println("You entered wrong input. Please try again.");
		}
		
		} catch(InputMismatchException e){
			System.out.println("You entered wrong input. Please try again.");
			//menu();
			return;
		}
	}
	}
}
