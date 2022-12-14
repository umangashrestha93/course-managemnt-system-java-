import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SignIn {

	Scanner input = new Scanner(System.in);

	CourseAdmin admin = new CourseAdmin();
	Instructor instructor = new Instructor();

	SignIn(){

		checkUp();
	}

	@SuppressWarnings("unused")
	void checkUp(){

		System.out.println("* WELCOME TO COURSE MANAGEMENT SYSTEM *");
		System.out.println("=================================");
//		for(long i=0; i<100000000; i++){
//			;
//		}

		System.out.println("Press Enter to continue.");
		input.nextLine();

		String insName;
		String insSurname;
		String insPassword;


		Boolean flag = true;
		ABC:
		while (flag){

			System.out.println("Please SignIn to continue!\n");

			System.out.println("Enter Name: ");
			String name = input.nextLine();

			System.out.println("Enter Surname: ");
			String surname = input.nextLine();

			System.out.println("Enter Password: ");
			String password = input.nextLine();

			File instructorFile = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\Instructor.txt");
			try {
				Scanner in = new Scanner(instructorFile);

				while (in.hasNextLine()){
					String id = in.next();
					insName = in.next().trim();
					insSurname = in.next().trim();
					insPassword = in.next().trim();
					String cnum = in.next().trim();
					String mail = in.next().trim();
					String add = in.nextLine();

					if(insName.equalsIgnoreCase(name) && insSurname.equalsIgnoreCase(surname) && insPassword.equals(password)){
						instructor.menu();
						flag = false;

						System.out.println("PROJECT: Coures Management	System");
						System.out.println("Developed By: Umanga Shrestha");
						break ABC;
					}
				}
				in.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error, File Not Found!");
			}

			if (admin.name.equalsIgnoreCase(name) && admin.surname.equalsIgnoreCase(surname) && admin.password.equals(password)){
				admin.menu();
				flag = false;

				System.out.println("PROJECT: Coures Management	System");
				System.out.println("Developed By: Umanga Shrestha");

			}
//		else if (!admin.name.equalsIgnoreCase(name) && !admin.surname.equalsIgnoreCase(surname) && !admin.password.equals(password)){
			else{
				System.out.println("Invalid Details or Password.");
				System.out.println("Please Try Again");
			}
		}
	}
}
