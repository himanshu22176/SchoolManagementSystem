package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.StudentController;
import Controller.TeacherController;
import Repositiry.StudentRepo;
import Repositiry.TeacherRepo;
import connPool.ConnectionPool;
import model.Student;
import model.Teacher;

public class View {
	
	
	private static StudentController s= new StudentController();
	private static TeacherController t= new TeacherController();
	
	public void startUp() {
		new InitalDBData();
		while(true) {
			System.out.println("====================================================================");
			System.out.println("\t\t\t\tWELCOME");
			System.out.println("====================================================================");
			System.out.println("\t\t\tSelect from the given choice");
			System.out.println("\t\t\t----------------------------");
			System.out.println("1. Add Student");
			System.out.println("2. Add Teacher");
			System.out.println("3. Get all Student Details");
			System.out.println("4. Get all Teacher Details");
			System.out.println("5. Get all Details");
			System.out.println("6. Delete Student");
			System.out.println("7. Delete Teacher");
			System.out.println("8. Search Student");
			System.out.println("9. Search Teacher");
			System.out.println("10. Get Student Count");
			System.out.println("11. Get Teacher Count");
			System.out.println("12. Get All Count");
			System.out.println("13. Exit");
			try {
			Scanner sc= new Scanner(System.in), ss= new Scanner(System.in);
			int choice= sc.nextInt();
			
			switch(choice) {
			case 1:{
				System.out.println("Enter ID: ");
				int id= sc.nextInt();
				System.out.println("Enter Name: ");
				String name= ss.nextLine();
				System.out.println("Enter Marks: ");
				double marks= sc.nextDouble();
				int z= s.add( id, name, marks);
				if(z==0)System.out.println("Added Successfully");
				else if(z==1)System.out.println("Duplicate ID Entered");
				else if(z==2)System.out.println("Invalid Marks");
				else System.out.println("ERROR");
				System.out.println("================================================");
			}break;
			
			case 2:{
				System.out.println("Enter ID: ");
				int id= sc.nextInt();
				System.out.println("Enter Name: ");
				String name= ss.nextLine();
				System.out.println("Enter Subject: ");
				String subject= ss.nextLine();
				int z= t.add( id, name, subject);
				if(z==0)System.out.println("Added Successfully");
				else if(z==1)System.out.println("Duplicate ID Entered");
				System.out.println("================================================");
			}break;
			
			case 3:{
				ArrayList<Student> f=s.getall();
				System.out.println("==============================================================================================================================");
				System.out.println("STUDENT DETAILS");
				System.out.println("==============================================================================================================================");
				for(Student rs : f) {
					System.out.println("||ID: "+ rs.getId()+" || Name: "+rs.getName()+" || Marks: "+rs.getMarks());
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				}
				System.out.println();
			}break;
			
			case 4:{
				ArrayList<Teacher> fg=t.getall();
				System.out.println("==============================================================================================================================");
				System.out.println("TEACHER DETAILS");
				System.out.println("==============================================================================================================================");
				for(Teacher rt : fg) {
					System.out.println("||ID: "+ rt.getId()+" || Name: "+rt.getName()+" || Subject: "+rt.getsubject());
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				}
				System.out.println();
			}break;
			
			case 5:{
				ArrayList<Student> f=s.getall();
				System.out.println("==============================================================================================================================");
				System.out.println("STUDENT DETAILS");
				System.out.println("==============================================================================================================================");
				for(Student rs : f) {
					System.out.println("||ID: "+ rs.getId()+" || Name: "+rs.getName()+" || Marks: "+rs.getMarks());
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				}
				System.out.println();
				ArrayList<Teacher> fg=t.getall();
				System.out.println("==============================================================================================================================");
				System.out.println("TEACHER DETAILS");
				System.out.println("==============================================================================================================================");
				for(Teacher rt : fg) {
					System.out.println("||ID: "+ rt.getId()+" || Name: "+rt.getName()+" || Subject: "+rt.getsubject());
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				}
				System.out.println();
			}break;
			
			case 6:{
				System.out.println("Enter ID: ");
				int id= sc.nextInt();
				System.out.println(s.delete(id)==0?"Success":"Invalid ID");
			}break;
			
			case 7:{
				System.out.println("Enter ID: ");
				int id= sc.nextInt();
				System.out.println(t.delete(id)==0?"Success":"Invalid ID");
			}break;
			
			case 8:{
				System.out.println("Enter ID: ");
				int id= sc.nextInt();
				System.out.println(s.findById(id)!=null?s.findById(id).display():"No Data Found!!");

			}break;
				
			case 9:{
				System.out.println("Enter ID: ");
				int id= sc.nextInt();
				System.out.println(t.findById(id)!=null?t.findById(id).display(): "No Data Found!!");
			}break;
			
			case 10:{
				 System.out.println("Student Count: "+s.getCount());
			}break;
			
			case 11:{
				 System.out.println("Teacher Count: "+t.getCount());
			}break;
			
			case 12:{
				int stC=s.getCount(),stT=t.getCount();
				System.out.println("Student Count: "+stC);
				System.out.println("Teacher Count: "+stT);
				System.out.println("Total Count: "+(stC+stT));
			}break;
			
			
			case 13:{
				ConnectionPool.reciveConnectionObject(StudentRepo.con);
				ConnectionPool.reciveConnectionObject(TeacherRepo.con);
				System.out.println("\t\t\t\t==================");
				System.out.println("\t\t\t\t||\tBye\t||");
				System.out.println("\t\t\t\t==================");
				System.exit(0);
			}
			default:
				System.out.println("Invalid Choice");
			}
			}
			catch (InputMismatchException e) {
				System.out.println("invalid Choice!!");
			}
		}
		
	}
	
}
