import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Instructor {

	String insName;
	String insSurname;
	String insId;
	String insPassword;
	String phone;
	String email;
	String address;

	String info;

	Scanner input = new Scanner(System.in);

	Course course = new Course();
	Student student = new Student();
	CourseSchedule calender = new CourseSchedule();

	File insFile = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\Instructor.txt");
	File temp = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\temp.txt");

	Instructor(){
		//Empty Constructor
	}

	Instructor(String insName,String insSurname, String insId, String insPassword, String phone, String email, String address){

		this.insName = insName;
		this.insSurname = insSurname;
		this.insId = insId;
		this.insPassword = insPassword;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	void viewInstructorInfo(){

		try(Scanner in = new Scanner(insFile)){
			while(in.hasNextLine()){
				String id = in.next();
				String name = in.next().trim();
				String surname = in.next().trim();
				@SuppressWarnings("unused")
				String pass = in.next().trim();
				String cnum = in.next().trim();
				String mail = in.next().trim();
				String add = in.nextLine();

				System.out.println("Instructor ID: " + id);
				System.out.println("Instructor Name: " + name);
				System.out.println("Instructor Surname: " + surname);
				System.out.println("Instructor Phone Number: " + cnum);
				System.out.println("Instructor Email: " + mail);
				System.out.println("Instructor Address: " + add);

				System.out.println("\n");
			}
		} catch(FileNotFoundException e){
			System.out.println("Error, File Not Found!");
		}
	}

	void modifyInstructorInfo(){

		System.out.print("Enter Instructor ID to modify his/her Information: ");
		this.info = input.nextLine();

		try {
			Scanner in = new Scanner(insFile);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
			int flag = 0;

			while(in.hasNextLine()){
				String id = in.next();
				String name = in.next().trim();
				String surname =  in.next().trim();
				String pass = in.next().trim();
				String cnum = in.next().trim();
				String mail = in.next().trim();
				String add = in.nextLine();

				if(id.compareToIgnoreCase(info) == 0){

					System.out.println("Enter Instructor ID: ");
					insId = input.nextLine();

					System.out.println("Enter Instructor Name: ");
					insName = input.nextLine();

					System.out.println("Enter Instructor SurName: ");
					insSurname = input.nextLine();

					System.out.println("Enter Instructor Password: ");
					insPassword = input.nextLine();

					System.out.println("Enter Instructor Phone Number: ");
					phone = input.nextLine();

					System.out.println("Enter Instructor Email Address: ");
					email = input.nextLine();

					System.out.println("Enter Instructor Address: ");
					address = input.nextLine();

					write.println(insId + " " + insName + " " + insSurname + " " + insPassword + " " + phone + " " + email + " " + address);
					flag = 1;
					System.out.println("Instructor Record Modification completed.");
				} else{
					write.println(id + " " + name + " " + surname + " " + pass + " " + cnum + " " + mail + " " + add);
				}
			}

			if (flag == 0){
				System.out.println("The Instructor record of the entered ID isn't available.");
			}
			write.close();
			in.close();



		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}


		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(insFile, false)));

			while(in.hasNextLine()){
				write.println(in.nextLine());
			}
			write.close();
			in.close();

		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}

	}

	void renameInstructor(){
		System.out.print("Enter Instructor ID to rename his/her Information: ");
		this.info = input.nextLine();

		try {
			Scanner in = new Scanner(insFile);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
			int flag = 0;

			while(in.hasNextLine()){
				String id = in.next();
				String name = in.next().trim();
				String surname =  in.next().trim();
				String pass = in.next().trim();
				String cnum = in.next().trim();
				String mail = in.next().trim();
				String add = in.nextLine();

				if(id.compareToIgnoreCase(info) == 0){

					System.out.println("Enter Instructor Name to rename: ");
					insName = input.nextLine();

					System.out.println("Enter Instructor SurName to rename: ");
					insSurname = input.nextLine();

					write.println(id + " " + insName +  " " + insSurname + " " + pass +" " + cnum + " " + mail + " " + add);
					flag = 1;
					System.out.println("Instructor Renamed successfully.");
				} else{
					write.println(id + " " + name + " " + surname + " " + pass +" " + cnum + " " + mail + " " + add);
				}
			}

			if (flag == 0){
				System.out.println("The Instructor record of the entered ID isn't available.");
			}
			write.close();
			in.close();



		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}


		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(insFile, false)));

			while(in.hasNextLine()){
				write.println(in.nextLine());
			}
			write.close();
			in.close();

		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}

	}

	void createInstructor(){

		System.out.println("Enter Instructor ID: ");
		insId = input.nextLine();

		System.out.println("Enter Instructor Name: ");
		insName = input.nextLine();

		System.out.println("Enter Instructor SurName: ");
		insSurname = input.nextLine();

		System.out.println("Enter Instructor Password: ");
		insPassword = input.nextLine();

		System.out.println("Enter Instructor Phone Number: ");
		phone = input.nextLine();

		System.out.println("Enter Instructor Email: ");
		email = input.nextLine();

		System.out.println("Enter Instructor Address: ");
		address = input.nextLine();

		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(insFile, true)))){
			out.println(insId + " " + insName + " " + insSurname + " " + insPassword + " " + phone + " " + email + " " + address);
		} catch(IOException e){
			System.out.println("Error, File Not Found!");
		}

		System.out.println("Instructor Record Created.");

	}

	void viewCourse() {
		course.viewCourse();
	}

	void manageStudent() {
		System.out.println("Welcome to Student Management\n");
		System.out.println("=================================\n");
		System.out.println("1) Press 1 to create a Student Info");
		System.out.println("2) Press 2 to modify a Student Info");
		System.out.println("3) Press 3 to delete a Student Info");
		System.out.println("4) Press 4 to view a Student Info");
		System.out.println("5) Press 5 to view all Students Info");
		System.out.println("5) Press 6 to enter marks with module");
		System.out.println("6) Press 7 to return to Main Menu");

		try{
			int choice = input.nextInt();

			if(choice == 1){
				student.createStudent();
			}

			else if (choice == 2){
				student.modifyStudentInfo();
			}

			else if (choice == 3){
				student.viewStudentData();
			}

			else if (choice == 4){
				student.viewStudentData();
			}

			else if (choice == 5){
				student.viewAllStudent();
			}
			else if (choice == 6){
				student.manageStudentMarks();
			}

			else if (choice == 7){
				//menu();
				return;
			}

			else{
				System.out.println("You entered wrong input. Please try again.");
			}

		} catch (InputMismatchException e){
			System.out.println("You entered wrong input. Please try again.");
			manageStudent();
		}
	}

	void viewCourseCalender(){
		calender.viewCourseCalender();
	}

	void menu(){

		boolean variable = true;
		while(variable){

			System.out.println("Welcome to Main Menu!\n");
			System.out.println("=================================\n");
			System.out.println("Please Select a choice from the following: \n");
			System.out.println("1) Press 1 to View All Courses");
			System.out.println("2) Press 2 to View Instructors Info");
			System.out.println("3) Press 3 to Student Management");
			System.out.println("4) Press 4 to View Course Schedule");
			System.out.println("5) Press 5 to Sign Out");

			try {
				int choice = input.nextInt();

				if (choice == 1){
					viewCourse();
				}

				else if (choice == 2){
					viewInstructorInfo();
				}

				else if (choice == 3){
					manageStudent();
				}

				else if (choice == 4){
					viewCourseCalender();
				}

				else if (choice == 5){
					System.out.println("Signing Out!\n\n");
					return;
				}

				else {
					System.out.println("You entered wrong input. Please try again.");
				}

			} catch(InputMismatchException e){
				System.out.println("You entered wrong input. Please try again.");
				menu();
			}
		}
	}
}
