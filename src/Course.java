import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Course{

	String moduleId;
	String courseName;
	String courseId;
	String info;
	String moduleName;

	File courseFile = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\Course.txt");
	File temp = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\temp.txt");
	
	Scanner input = new Scanner(System.in);

	Course() {
		// Empty Constructor
	}

	Course(String courseName, String courseId, String moduleId) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.moduleId = moduleId;

	}

	void createCourse() {

		System.out.println("Enter Course Name: ");
		courseName = input.nextLine();
		System.out.println("Enter Course ID: ");
		courseId = input.nextLine();
		System.out.println("Enter Module id: ");
		moduleId = input.nextLine();

		File moduleFile = new File("C:/Users/luciffer/IdeaProjects/Course_Management_System/src/Module.txt");

		try {
			Scanner in = new Scanner(moduleFile);

			if(in.hasNextLine()){
				String id = in.next();
				moduleName = in.next().trim();

					try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(courseFile, true)))){
						out.println(courseId + " " + courseName + " " + moduleId);
					} catch(IOException e){
						System.out.println("File Not Found!");
					}

					System.out.println("New Course Created.");

			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, File Not Found!");
		}


	}


	void viewCourse() {
		System.out.println("ID \t\t\t COURSE NAME \t\t module");

		try(Scanner in = new Scanner(courseFile)){
			while(in.hasNextLine()){
				String id = in.next();
				String name = in.nextLine().trim();
				
				System.out.println(id + " \t " + name);
			}
		} catch(FileNotFoundException e){
			System.out.println("File Not Found!");
		}
	}

	void modifyCourse() {
		
		System.out.print("Enter Course ID to modify its Information: ");
		this.info = input.nextLine();
		
		try {
		Scanner in = new Scanner(courseFile);
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
		int flag = 0;
		
		while(in.hasNextLine()){
			String id = in.next();
			String name = in.nextLine();
			
			if(id.compareToIgnoreCase(info) == 0){
				
				System.out.print("Enter Course Name to modify: ");
				String textName = input.nextLine();
				
				System.out.print("Enter Course ID to modify: ");
				String textId = input.nextLine();
				
				write.println(textId + " " + textName);
				flag = 1;
				System.out.println("Course Modification completed.");
			} else{
				write.println(id + name);
			}
		}

		if (flag == 0){
			System.out.println("There is no record found.");
			}
		write.close();
		in.close();
		
		
		
		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}
		
		
		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(courseFile, false)));
			
			while(in.hasNextLine()){
				write.println(in.nextLine());
				}
			write.close();
			in.close();
			
			} catch (IOException e1) {
				System.out.println("File Not Found!");
			}


	}

	void renameCourse(){

		System.out.print("Enter Course ID to Rename its Name Information: ");
		this.info = input.nextLine();
		
		try {
		Scanner in = new Scanner(courseFile);
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
		int flag = 0;
		
		while(in.hasNextLine()){
			String id = in.next();
			String name = in.nextLine();
			
			if(id.compareToIgnoreCase(info) == 0){
				
				System.out.print("Enter Course Name to modify: ");
				String text = input.nextLine();
				write.println(id + " " + text);
				flag = 1;
				System.out.println("Name Modification completed.");
			} else{
				write.println(id + name);
			}
		}

		if (flag == 0){
			System.out.println("The course record of the entered ID isn't available.");	
			}
		write.close();
		in.close();
		
		
		
		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}
		
		
		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(courseFile, false)));
			
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