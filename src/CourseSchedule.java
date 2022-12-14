import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CourseSchedule {

	String day;
	String startTime;
	String endTime;
	String courseId;
	String endDay;
	String tutorName;
	
	String info;
	
	File calenderFile = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\CourseSchedule.txt");
	File temp = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\temp.txt");
	
	Scanner input = new Scanner(System.in);
	
	CourseSchedule(){
		//Empty Constructor
	}
	
	CourseSchedule(String day, String startTime, String endTime, String courseId, String endDay, String tutorName){
		
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.courseId = courseId;
		this.endDay = endDay;
		this.tutorName = tutorName;
	}
	
	void viewCourseCalender(){
		System.out.println(" ID \t\t AT \t TILL \t FROM \t\t TO//AND \t  Instructor");
		
		try(Scanner in = new Scanner(calenderFile)){
			while(in.hasNextLine()){
				String id = in.next();
				String start = in.next().trim();
				String end = in.next().trim();
				String sDay = in.next().trim();
				String eDay = in.next().trim();
				String tut = in.nextLine();
				
				System.out.println(id + " \t\t  " + start + " \t " + end +" \t\t  " + sDay + " \t\t " + eDay + " \t " + tut );
			}
		} catch(FileNotFoundException e){
			System.out.println("File Not Found!");
		}

	}
	
	void modifyCourseCalender(){
		
		System.out.print("Enter Course ID to modify its Information: ");
		this.info = input.nextLine();
		
		try {
		Scanner in = new Scanner(calenderFile);
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
		int flag = 0;
		
		while(in.hasNextLine()){
			String id = in.next();
			String start = in.next().trim();
			String end = in.next().trim();
			String sDay = in.next().trim();
			String eDay = in.next().trim();
			String tut = in.nextLine();
			
			if(id.compareToIgnoreCase(info) == 0){
				
				System.out.print("Enter Course ID to modify: ");
				this.courseId = input.nextLine();
				
				System.out.print("Enter Starting Time to modify (e.g.10AM):  ");
				this.startTime = input.nextLine();
				
				System.out.print("Enter Ending Time to modify: ");
				this.endTime = input.nextLine();
				
				System.out.print("Enter Starting Day to modify: ");
				this.day = input.nextLine();
				
				System.out.print("Enter Ending Day to modify: ");
				this.endDay = input.nextLine();
				
				System.out.print("Enter Instructor name to modify: ");
				this.tutorName = input.nextLine();
				
				write.println(courseId + " " + startTime + " " + endTime + " " + day + " " + endDay + " " + tutorName);
				flag = 1;
				System.out.println("Course Schedule Modification completed.");
			} else{
				write.println(id + " " + start + " " + end +" " + sDay + " " + eDay + " " + tut);
			}
		}

		if (flag == 0){
			System.out.println("There is no record for this ID");
			}
		write.close();
		in.close();
		
		
		
		} catch (IOException e1) {
			System.out.println("File Not Found!");
		}
		
		
		try {
			Scanner in = new Scanner(temp);
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(calenderFile, false)));
			
			while(in.hasNextLine()){
				write.println(in.nextLine());
				}
			write.close();
			in.close();
			
			} catch (IOException e1) {
				System.out.println("File Not Found!");
			}

	}
	
	void deleteCourseCalender(){
		System.out.print("Enter Course ID to Delete its Information: ");
		this.info = input.nextLine();
		
		try {
		Scanner in = new Scanner(calenderFile);
		PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
		int flag = 0;
		
		while(in.hasNextLine()){
			String id = in.next();
			String start = in.next().trim();
			String end = in.next().trim();
			String sDay = in.next().trim();
			String eDay = in.next().trim();
			String tut = in.nextLine();
			
			if(id.compareToIgnoreCase(info) == 0){
				
				flag = 1;
				System.out.println("Course Calender Schedule Deleted.");
			} else{
				write.println(id + " " + start + " " + end +" " + sDay + " " + eDay + " " + tut);
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
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(calenderFile, false)));
			
			while(in.hasNextLine()){
				write.println(in.nextLine());
				}
			write.close();
			in.close();
			
			} catch (IOException e1) {
				System.out.println("File Not Found!");
			}

	}	
	
	void createCourseCalender(){
		
		System.out.print("\nEnter Course Id: ");
		this.courseId = input.nextLine();
		
		System.out.print("\nEnter Starting Time in hours: ");
		this.startTime = input.nextLine();
		
		System.out.print("\nEnter Ending Time in hours: ");
		this.endTime = input.nextLine();
		
		System.out.print("Enter Starting Day: ");
		this.day = input.nextLine();
		
		System.out.print("\nEnter Ending day: ");
		this.endDay = input.nextLine();
		
		System.out.print("\nEnter Tutor Name: ");
		this.tutorName = input.nextLine();
	
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(calenderFile, true)))){
			out.println(courseId + " " + startTime + " " + endTime + " " + day + " " + endDay + " " + tutorName);
		} catch(IOException e){
			System.out.println("File Not Found!");
		}

		System.out.println("Course Calender Created.");
	}
}

