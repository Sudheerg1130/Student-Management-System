
import java.util.*;
import java.util.Scanner;

class Student {
	int id;
	String name;
	int marks;

	Student(int id, String name, int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
}

public class Main {
	public static void main(String[] args) {

		ArrayList<Student> lst = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		outer:
		while (true) {

			System.out.println("\n===== Student Management System =====");
			System.out.println("1. Add Students");
			System.out.println("2. Display Students");
			System.out.println("3. Search Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Update Student");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int op = sc.nextInt();
			System.out.println();

			switch (op) {

			case 1:
				System.out.print("Enter number of students to add: ");
				int n = sc.nextInt();

				while (n != 0) {

					System.out.print("Enter student ID: ");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter student name: ");
					String name = sc.nextLine();

					System.out.print("Enter student marks: ");
					int marks = sc.nextInt();

					Student obj = new Student(id, name, marks);
					lst.add(obj);

					n--;
				}

				System.out.println("Students added successfully.\n");
				break;

			case 2:
				if (lst.size() > 0) 
				{
					System.out.println("----- Student List -----");
					
					for (int i = 0; i < lst.size(); i++) 
					{
						System.out.println("ID: " + lst.get(i).id + ", Name: " + lst.get(i).name +
						                   ", Marks: " + lst.get(i).marks);
					}
					
				}
				else
				{
					System.out.println("No students found.");
				}
				break;

			case 3:
			    
				System.out.print("Enter student ID to search: ");
				int identi = sc.nextInt();
				int f = 0;

				for (int i = 0; i < lst.size(); i++)
				{
					if (identi == lst.get(i).id)
					{
						f = 1;
						System.out.println("Student Found:");
						
						System.out.println("ID: " + lst.get(i).id +
						                   ", Name: " + lst.get(i).name +
						                   ", Marks: " + lst.get(i).marks);
						break;
					}
				}

				if (f == 0) {
					System.out.println("Student not found.");
				}
				break;

			case 4:
			    
				System.out.print("Enter student ID to delete: ");
				int searchid = sc.nextInt();
				int found = 0;

				for (int i = 0; i < lst.size(); i++) {
					if (searchid == lst.get(i).id) {
						found = 1;
						lst.remove(i);
						System.out.println("Student deleted successfully.");
						break;
					}
				}

				if (found == 0) {
					System.out.println("Student ID not found.");
				}
				break;

			case 5:
				System.out.print("Enter student ID to update: ");
				int uid = sc.nextInt();
				int flag = 0;

				for (int i = 0; i < lst.size(); i++)
				{
					if (uid == lst.get(i).id) 
					{
						flag = 1;

						System.out.print("Enter new name: ");
						sc.nextLine();
						lst.get(i).name = sc.nextLine();

						System.out.print("Enter new marks: ");
						lst.get(i).marks = sc.nextInt();

						System.out.println("Student updated successfully.");
						break;
					}
				}

				if (flag == 0) {
					System.out.println("Student ID not found.");
				}
				break;

			case 6:
			    
				System.out.println("Exiting application. Thank you!");
				break outer;

			default:
			
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}