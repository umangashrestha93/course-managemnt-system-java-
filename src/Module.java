import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Module {

    String moduleName;
    String moduleId;
    String info;

    File file = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\Module.txt");
    File temp = new File("C:\\Users\\umang shrestha\\OneDrive\\Desktop\\Course_Management_System\\src\\temp.txt");

    Scanner input = new Scanner(System.in);

    Module() {
        // Empty Constructor
    }

    Module(String moduleName, String moduleId) {
        this.moduleName = moduleName;
        this.moduleId = moduleId;
    }




    void createModule() {

        System.out.println("Enter Module Name: ");
        moduleName = input.nextLine();
        System.out.println("Enter Module ID: ");
        moduleId = input.nextLine();

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))){
            out.println(moduleId + " " + moduleName);
        } catch(IOException e){
            System.out.println("Error, File Not Found!");
        }

        System.out.println("New Module Created.");
    }

    void viewModule() {
        System.out.println("ID \t\t MODULE NAME");

        try(Scanner in = new Scanner(file)){
            while(in.hasNextLine()){
                String id = in.next();
                String name = in.nextLine().trim();

                System.out.println(id + " \t " + name);
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }

    void modifyModule() {

        System.out.print("Enter Module ID to modify its Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(file);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    System.out.print("Enter Module Name to modify: ");
                    String textName = input.nextLine();

                    System.out.print("Enter Module ID to modify: ");
                    String textId = input.nextLine();

                    write.println(textId + " " + textName);
                    flag = 1;
                    System.out.println("Module Modification completed.");
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
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));

            while(in.hasNextLine()){
                write.println(in.nextLine());
            }
            write.close();
            in.close();

        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }


    }

    void renameModule(){

        System.out.print("Enter Module ID to Rename its Name Information: ");
        this.info = input.nextLine();

        try {
            Scanner in = new Scanner(file);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(temp, false)));
            int flag = 0;

            while(in.hasNextLine()){
                String id = in.next();
                String name = in.nextLine();

                if(id.compareToIgnoreCase(info) == 0){

                    System.out.print("Enter Module Name to modify: ");
                    String text = input.nextLine();
                    write.println(id + " " + text);
                    flag = 1;
                    System.out.println("Name Modification completed.");
                } else{
                    write.println(id + name);
                }
            }

            if (flag == 0){
                System.out.println("The MODULE record of the entered ID isn't available.");
            }
            write.close();
            in.close();



        } catch (IOException e1) {
            System.out.println("File Not Found!");
        }


        try {
            Scanner in = new Scanner(temp);
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));

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
