import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Student {

	String stuId;
	String stuName;
	String qualification;
	String phone;
	String email;
	String address;
	String module;
	String marks;
	
	String stuData;
	
	File stuFile = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\Student.txt");
	File temp = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\temp.txt");
	
	Scanner userInput = new Scanner(System.in);
	
	Student(){
	}
	
	Student(String stuId, String stuName, String qualification, String phone, String email, String address, String module, String marks){
		this.stuId = stuId;
		this.stuName = stuName;
		this.qualification = qualification;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.module = module;
		this.marks = marks;
		
	}
	
	void viewStudentData(){

		System.out.print("Please Enter Student ID to view his/her Student Information: ");
		this.stuData = userInput.nextLine();
		
		try {
		Scanner in = new Scanner(stuFile);
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
		int flag = 0;
		
		while(in.hasNextLine()){
			String id = in.next();
			String name = in.next() + in.next().trim();
			String qual = in.next().trim();
			String phone = in.next().trim();
			String mail = in.next().trim();
			String add = in.nextLine();
			
			if(id.compareToIgnoreCase(stuData) == 0){
				
				flag = 1;
				
				System.out.println("Student ID: " + id);
				System.out.println("Student Name: " + name);
				System.out.println("Student Qualification: " + qual);
				System.out.println("Student Contact Number: " + phone);
				System.out.println("Student Email: " + mail);
				System.out.println("Student Address: " + add);

			}
		}

		if (flag == 0){
			System.out.println("There is no record with this Student ID");
			}
		write.close();
		in.close();
		
		
		
		} catch (IOException e1) {
			System.out.println("ERROR, File Not Found!");
		}
	}
	
	void deleteStudentData(){
	
		System.out.print("Please Enter Student ID to Delete his/her Information: ");
		this.stuData = userInput.nextLine();
		
		try {
		Scanner in = new Scanner(stuFile);
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
		int flag = 0;
		
		while(in.hasNextLine()){
			String id = in.next();
			String name = in.next().trim();
			String qual = in.next().trim();
			String phone = in.next().trim();
			String mail = in.next().trim();
			String add = in.nextLine();
			
			if(id.compareToIgnoreCase(stuData) == 0){
				
				flag = 1;
				System.out.println("Student Record Deleted.");
			} else{
				write.println(id + " " + name + " " + qual + " " + phone + " " + mail + " " + add );
			}
		}

		if (flag == 0){
			System.out.println("The Student record of the entered ID isn't available.");	
			}
		write.close();
		in.close();
		
		
		
		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}
		
		
		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(stuFile, false)));
			
			while(in.hasNextLine()){
				write.println(in.nextLine());
				}
			write.close();
			in.close();
			
			} catch (IOException e1) {
				System.out.println("File Not Found!");
			}

	}
	
	void modifyStudentInfo(){
		
		System.out.print("Enter Student ID to modify his/her Information: ");
		this.stuData = userInput.nextLine();
		
		try {
		Scanner in = new Scanner(stuFile);
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
		int flag = 0;
		
		while(in.hasNextLine()){
			String id = in.next();
			String name = in.next().trim();
			String qual = in.next().trim();
			String cnum = in.next().trim();
			String mail = in.next().trim();
			String add = in.nextLine();

			
			if(id.compareToIgnoreCase(stuData) == 0){
				
				System.out.print("Enter Student ID to modify: ");
				this.stuId = userInput.nextLine();
				
				System.out.print("\nEnter Student Name to modify: ");
				this.stuName = userInput.nextLine();
				
				System.out.print("\nEnter Student Qualification to modify: ");
				this.qualification = userInput.nextLine();
				
				System.out.print("\nEnter Student Phone Number to modify: ");
				this.phone = userInput.nextLine();
				
				System.out.print("\nEnter Student Email Address to modify: ");
				this.email = userInput.nextLine();
				
				System.out.print("\nEnter Student Address to modify: ");
				this.address = userInput.nextLine();

				System.out.print("\nEnter Module to Add:");
				this.module = userInput.nextLine();

				System.out.print("\nEnter students Marks:");
				this.marks = userInput.nextLine();
				
				write.println(stuId + " " + stuName + " " + qualification + " " + phone + " " + email + " " + address );
				flag = 1;
				System.out.println("Student Record Modification completed.");
			} else{
				write.println(id + " " + name + " " + qual +" " + cnum + " " + mail + " " + add);
			}
		}

		if (flag == 0){
			System.out.println("The Student record of the entered ID isn't available.");	
			}
		write.close();
		in.close();
		
		
		
		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}
		
		
		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(stuFile, false)));
			
			while(in.hasNextLine()){
				write.println(in.nextLine());
				}
			write.close();
			in.close();
			
			} catch (IOException e1) {
				System.out.println("File Not Found!");
			}

	}
	
	void createStudent(){
		
		System.out.print("Enter Student ID: ");
		this.stuId = userInput.nextLine();
		
		System.out.print("\nEnter Student Name: ");
		this.stuName = userInput.nextLine();
		
		System.out.print("\nEnter Student Qualification: ");
		this.qualification = userInput.nextLine();
		
		System.out.print("\nEnter Student Phone Number: ");
		this.phone = userInput.nextLine();
		
		System.out.print("\nEnter Student Email Address: ");
		this.email = userInput.nextLine();
		
		System.out.print("\nEnter Student Address: ");
		this.address = userInput.nextLine();
	
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(stuFile, true)))){
			out.println(stuId + " " + stuName + " " + qualification + " " + phone + " " + email + " " + address);
		} catch(IOException e){
			System.out.println("File Not Found!");
		}

		System.out.println("Student Record Created.");

	}
	
	void viewAllStudent() {
		
		try(Scanner in = new Scanner(stuFile)){
			while(in.hasNextLine()){
				String id = in.next();
				String name = in.next() + in.next().trim();
				String qual = in.next().trim();
				String cnum = in.next().trim();
				String mail = in.next().trim();
				String add = in.nextLine();
				
				System.out.println("Student ID: " + id);
				System.out.println("Student Name: " + name);
				System.out.println("Student Qualification: " + qual);
				System.out.println("Student Contact Number: " + cnum);
				System.out.println("Student Email Address: " + mail);
				System.out.println("Student Address: " + add);
				
				System.out.println("\n");
			}
		} catch(FileNotFoundException e){
			System.out.println("File Not Found!");
		}
	
	}


	void manageStudentMarks(){

		System.out.print("Enter Student ID to modify his/her Information: ");
		this.stuData = userInput.nextLine();

		try {
			Scanner in = new Scanner(stuFile);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
			int flag = 0;

			while(in.hasNextLine()){
				String id = in.next();
				String name = in.next().trim();
				String qual = in.next().trim();
				String phone = in.next().trim();
				String mail = in.next().trim();
				String add = in.nextLine();
				String mod = in.nextLine();
				String mark = in.nextLine();


				if(id.compareToIgnoreCase(stuData) == 0){

					System.out.print("Enter Student ID to modify: ");
					this.stuId = userInput.nextLine();

					System.out.print("\nEnter Module to Add:");
					this.module = userInput.nextLine();

					System.out.print("\nEnter students Marks:");
					this.marks = userInput.nextLine();

					write.println(id + " " + name + " " + qual + " " + phone + " " + mail + " " + add + " " + module + " " + marks);
					flag = 1;
					System.out.println("Student Record Modification completed.");
				} else{
					write.println(id + " " + name + " " + qual +" " + phone + " " + mail + " " + add);
				}
			}

			if (flag == 0){
				System.out.println("The Student record of the entered ID isn't available.");
			}
			write.close();
			in.close();



		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}


		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(stuFile, false)));

			while(in.hasNextLine()){
				write.println(in.nextLine());
			}
			write.close();
			in.close();

		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}

	}
}
