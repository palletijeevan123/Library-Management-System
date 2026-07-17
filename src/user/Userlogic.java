package user;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import Connect.DBConnection;
import dao.Operations;

public class Userlogic {
	public static  void main(String[] args) throws SQLException  {
		Connection c= DBConnection.getConnection();
		Operations op=new Operations();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("📚📚welcome to the Library📚📚📚");
		System.out.println("enter you credentials");
		System.out.println("enter your name");
		String name=sc.next();
		System.out.println("enter the password");
		int password=sc.nextInt();
		
		if(name.equalsIgnoreCase("Arjun")&& password==12345) {
			System.out.println("welcome to:"+name);
		}
		else {
			System.out.println("invalid credentials access denied");
		return;
		}
		
	
	while(true) {
		
		System.out.println("1.Library Management");
		System.out.println("2.Student Management");
		System.out.println("3.issued book");
		System.out.println("4.Return book");
		System.out.println("5.Issued date");
		System.out.println("6.Exit");
		System.out.println("Enter Choice: ");
		int choice=sc.nextInt();
		switch(choice) {

		case 1:

		    System.out.println("\n===== Library Management =====");

		    while(true) {
		    	
		        System.out.println("\n1. Add Book");
		        System.out.println("2. Update Book");
		        System.out.println("3. Delete Book");
		        System.out.println("4. View Books");
		        System.out.println("5. Exit");
		        System.out.print("Enter Choice : ");

		        int choice1 = sc.nextInt();

		        if(choice1 == 1) {
		        	try {
		        	
		            c = DBConnection.getConnection();

		            System.out.print("Enter Book ID : ");
		            int bid = sc.nextInt();
		            sc.nextLine();

		            System.out.print("Enter Book Title : ");
		            String title = sc.nextLine();

		            System.out.print("Enter Author Name : ");
		            String author = sc.nextLine();

		            System.out.print("Enter Available Copies : ");
		            int copies = sc.nextInt();

		            op.insert(bid, title, author, copies);

		            System.out.println("Book Added Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter numbers only for Book ID and Copies.");
		        	    sc.nextLine();   
		        	}
		        }

		        else if(choice1 == 2) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Book ID : ");
		            int bid = sc.nextInt();
		            sc.nextLine();

		            System.out.print("Enter New Title : ");
		            String title = sc.nextLine();

		            System.out.print("Enter New Author : ");
		            String author = sc.nextLine();

		            op.update(bid, title, author);

	            System.out.println("Book Updated Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter numbers only for Book ID and Copies.");
		        	    sc.nextLine();   
		        	}
		        }

		        else if(choice1 == 3) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Book ID : ");
		            int bid = sc.nextInt();

		            op.delete(bid);

		            System.out.println("Book Deleted Successfully.");

		        }
		        	catch (Exception e) {
		        	    System.out.println("Please enter numbers only for Book ID ");
		        	    sc.nextLine();   
		        	}
		        }
		        
		        else if(choice1 == 4) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.println("\n------ Book Details ------");

		            op.fetch();
		        	}
		        	catch(Exception e) {
		        	    e.printStackTrace();
		        	}

		        }

		        else if(choice1 == 5) {
		        	try {
		            System.out.println("Returning to Main Menu...");
		            break;
		        	}
		        	catch(Exception e) {
		        	    e.printStackTrace();
		        	}

		        }

		        else {

		            System.out.println("Invalid Choice.");

		        }
		    	}
		    	

		    

		    break;
		    
		case 2:

		    System.out.println("\n===== Student Management =====");

		    while(true) {

		        System.out.println("\n1. Add Student");
		        System.out.println("2. Update Student");
		        System.out.println("3. Delete Student");
		        System.out.println("4. View Students");
		        System.out.println("5. Back");
		        System.out.print("Enter Choice : ");

		        int choice2 = sc.nextInt();

		        if(choice2 == 1) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Student ID : ");
		            int sid = sc.nextInt();
		            sc.nextLine();

		            System.out.print("Enter Student Name : ");
		            String sname = sc.nextLine();

		            System.out.print("Enter Phone Number : ");
		            String phone = sc.nextLine();

		            op.sInsert(sid, sname, phone);

		            System.out.println("Student Added Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter only numbers for Book ID: ");
		        	    sc.nextLine();   
		        	}
		        }

		        else if(choice2 == 2) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Student ID : ");
		            int sid = sc.nextInt();
		            sc.nextLine();

		            System.out.print("Enter New Phone Number : ");
		            String phone = sc.nextLine();

		            op.sUpdate(sid, phone);

		            System.out.println("Student Updated Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter only numbers for Book ID: ");
		        	    sc.nextLine();   
		        	}
		        }
		        else if(choice2 == 3) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Student ID : ");
		            int sid = sc.nextInt();

		            op.sDelete(sid);

		           System.out.println("Student Deleted Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter only numbers for Book ID: ");
		        	    sc.nextLine();   
		        	}
		        }

		        else if(choice2 == 4) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.println("\n------ Student Details ------");

		            op.sFetch();
		        	}
		        	catch(Exception e) {
		        	    e.printStackTrace();
		        	}

		        }

		        else if(choice2 == 5) {
		        	try {
		            System.out.println("Returning to Main Menu...");
		            break;
		        	}
		        	catch(Exception e) {
		        		System.out.println("Exception handle!");
		        	}
		        }

		        else {

		            System.out.println("Invalid Choice.");

		        }

		    }

		    break;
		    
		case 3:

		    System.out.println("\n===== Issue Book =====");

		    while(true) {
		    	LocalDate localDate;
		        System.out.println("\n1. Add Issue Book");
		        System.out.println("2. Update Issue Date");
		        System.out.println("3. Delete Issue Book");
		        System.out.println("4. View Issue Books");
		        System.out.println("5. Back");
		        System.out.print("Enter Choice : ");

		        int choice3 = sc.nextInt();

		        if(choice3 == 1) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Issue ID : ");
		            int isid = sc.nextInt();

		            System.out.print("Enter Book ID : ");
		            int bid = sc.nextInt();

		            System.out.print("Enter Student ID : ");
		            int sid = sc.nextInt();

		            System.out.print("Enter Issue Date (YYYY-MM-DD) : ");
		            String isdate = sc.next();

		            System.out.print("Enter Return Date (YYYY-MM-DD) : ");
		            String redate = sc.next();
		           //localDate =LocalDate.parse(redate);

		            op.isuInsert(isid, bid, sid, isdate, redate);

		            System.out.println("Issue Book Added Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter valid credentials: ");
		        	    sc.nextLine();   
		        	}
		        	catch (Exception e) {
		                System.out.println("Invalid date format.");
		            }
		        }

		        else if(choice3 == 2) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Issue ID : ");
		            int isid = sc.nextInt();

		            System.out.print("Enter New Issue Date (YYYY-MM-DD) : ");
		            String newDate = sc.next();

		            op.isUpdate(isid, newDate);

		            System.out.println("Issue Date Updated Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter valid credentials: ");
		        	    sc.nextLine();   
		        	}
		        	catch (Exception e) {
		                System.out.println("Invalid date format.");
		            }
		        }

		        else if(choice3 == 3) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter  Issue Date (YYYY-MM-DD): ");
		            String isdate = sc.next();

		            op.isDelete(isdate);   
		            System.out.println("Issue Record Deleted Successfully.");
		        	}
		        	catch (Exception e) {
		                System.out.println("Invalid date format.");
		            }
		        }

		        else if(choice3 == 4) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.println("\n------ Issued Books ------");

		            op.isbookFetch();

		        }
		        	catch(Exception e) {
		        	    e.printStackTrace();
		        	}
		        }

		        else if(choice3 == 5) {
		        	try {
		        
		            System.out.println("Returning to Main Menu...");
		            break;
		        	}
		        	catch(Exception e) {
		        	    e.printStackTrace();
		        	}

		        }

		        else {

		            System.out.println("Invalid Choice.");

		        }

		    }
		

		    break;
		case 4:

		    System.out.println("\n===== Return Book =====");

		    while (true) {

		        System.out.println("\n1. Add Return Book");
		        System.out.println("2. Update Return Date");
		        System.out.println("3. Delete Return Record");
		        System.out.println("4. View Return Books");
		        System.out.println("5. Back");
		        System.out.print("Enter Choice : ");

		        int choice4 = sc.nextInt();

		        if (choice4 == 1) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Issue ID : ");
		            int isid = sc.nextInt();

		            System.out.print("Enter Book ID : ");
		            int bid = sc.nextInt();

		            System.out.print("Enter Student ID : ");
		            int sid = sc.nextInt();

		            System.out.print("Enter Issue Date (YYYY-MM-DD) : ");
		            String isdate = sc.next();

		            System.out.print("Enter Return Date (YYYY-MM-DD) : ");
		            String redate = sc.next();

		            op.reuInsert(isid, bid, sid, isdate, redate);

		            System.out.println("Return Book Record Added Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter valid credentials: ");
		        	    sc.nextLine();   
		        	}
		        	catch (Exception e) {
		                System.out.println("Invalid date format.");
		            }
		        }

		        else if (choice4 == 2) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Issue ID : ");
		            int isid = sc.nextInt();

		            System.out.print("Enter New Return Date (YYYY-MM-DD) : ");
		            String redate = sc.next();

		            op.reUpdate(isid, redate);

		            System.out.println("Return Date Updated Successfully.");

		        }
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter valid credentials: ");
		        	    sc.nextLine();   
		        	}
		        	catch (Exception e) {
		                System.out.println("Invalid date format.");
		            }
		        }

		        else if (choice4 == 3) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.print("Enter Return Date (YYYY-MM-DD) : ");
		            String redate = sc.next();
						op.reDelete(redate);
		            System.out.println("Return date Record Deleted Successfully.");
		        	}
		        	catch (Exception e) {
		                System.out.println("Invalid date format.");
		            }
		        }

		        else if (choice4 == 4) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.println("\n------ Return Book Details ------");
						op.rebookFetch();
					}
		        	catch(Exception e) {
		        	    e.printStackTrace();
		        	}

		        }

		        else if (choice4 == 5) {
		        	try {
		            System.out.println("Returning to Main Menu...");
		            break;
		        	}
		        	catch(Exception e) {
		        	    e.printStackTrace();
		        	}

		        }

		        else {

		            System.out.println("Invalid Choice. Please Try Again.");

		        }

		    }
		

		    break;
		case 5:

		    System.out.println("\n===== Issued Date =====");

		    while (true) {
		    	try {
		        System.out.println("\n1. View Issued Dates");
		        System.out.println("2. Back");
		        System.out.print("Enter Choice : ");

		        int choice5 = sc.nextInt();

		        if (choice5 == 1) {
		        	try {
		            c = DBConnection.getConnection();

		            System.out.println("\n------ Issued Book Details ------");
						op.issuedateFetch();												
		        	}
		        	catch (InputMismatchException e) {
		        	    System.out.println("Please enter valid credentials: ");
		        	    sc.nextLine();   
		        	}
		        	catch (Exception e) {
		                System.out.println("Invalid format.");
		            }
		        }

		        else if (choice5 == 2) {
		        	try {
		            System.out.println("Returning to Main Menu...");
		            break;
		        	}
		        	catch(NumberFormatException e) {
		        	    System.out.println("Invalid choice. Enter a number.");
		        	}

		        }

		        else {

		            System.out.println("Invalid Choice.");
		        }
		    	}
		        
		    	
		        catch(NumberFormatException e) {
	        	    System.out.println("Invalid choice. Enter a number.");
	        	}
		    	
		}

		    break;
		case 6:
			try {
		    System.out.println("\n================================");
		    System.out.println(" Thank You For Visiting");
		    System.out.println(" Library Management System");
		    System.out.println("================================");

		    sc.close();
		    return;
			}
			catch(Exception e) {
        	    e.printStackTrace();
        	}
		
		default:

		    System.out.println("Invalid Choice...Please Try Again.");
		    
		}
	
	}
	}
}

	
	

	
	

