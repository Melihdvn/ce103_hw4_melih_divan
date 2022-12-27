package ce103_hw4_library_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ce103_hw4_library_lib.Customer;
import ce103_hw4_library_lib.FileUtility;
import ce103_hw4_library_lib.Medicine;
import ce103_hw4_library_lib.Supplier;
import ce103_hw4_library_lib.bill;


public class Menu {

	boolean exit;
	
	/*This method attempts to clear the console screen by calling the "cmd" command with the "/c" and "cls" arguments.
	 *  This will only work on systems that have the Windows command prompt, and it may not work on all systems.*/
	public void clearScreen() 
    {
        try 
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }catch (Exception e) {
            e.printStackTrace();
        } 
    }
	/* This method prompts the user to press the Enter key by printing a message on
	 * the console and then waiting for the user to press Enter.
	 * It does this by reading from the System.in stream, which is a standard
	 * input stream that reads from the keyboard. */
	 public void pressEnterToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	 
	 static int i;
	 /* This method moves the console cursor to the specified column and row position by
	  * printing an ANSI escape code to the console.*/
	 private static void gotoxy(int collumn, int row)
	 {
	     System.out.print("\033[" + row + ";" + collumn + "H");
	 }
	 /* This method prints the current date and time to the console at a specific position.
	  * It does this by using the LocalDateTime class to get the current date and time,
	  * formatting it using a DateTimeFormatter, and then printing it to the console using the gotoxy() method.*/
	 private static void t() 
	 {
		 
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		        String formattedDate = now.format(formatter);

		        gotoxy(55,46);
		        System.out.println("Date: " + formattedDate.split(" ")[0]);
 		    	gotoxy(55,48);
		        System.out.println("Time: " + formattedDate.split(" ")[1]);
		    
	 }
	 /*This method prints a box with a solid border to the console.
	  *  It does this by printing ASCII characters to the console 
	  *  at specific positions to create the appearance of a box.*/
	 public static void box1() 
	 {
			gotoxy(1,3);
	    	System.out.print("\u2554"); //top left corner
			for(i=1;i<79;i++)
			{
				gotoxy(1+i,3);
				System.out.print("\u2550"); //horizontal
			}
			gotoxy(80,3);
			System.out.print("\u2557"); //top right corner
			
			gotoxy(1,3);
			for(i=4;i<10;i++)
			{
				gotoxy(1,i);
				System.out.print("\u2551"); //vertical
			}
			gotoxy(1,9);
			for(i=4;i<8;i++)
			{
				gotoxy(80,i);
				System.out.print("\u2551");
			}
	    }
	 	/* This method prints a larger box with a solid border to the console.
	 	 * It is similar to the box1() method, but it uses different ASCII 
	 	 * characters and positions to create a larger box.*/
	    public static void main_box() 
	    {
	    	gotoxy(1,6);
	    	System.out.print("\u2554");
	    	for(i=1;i<79;i++)
	    	{
	    		gotoxy(1+i,6);
	    		System.out.print("\u2550");
	    	}

	    	gotoxy(80,6);
	    	System.out.print("\u2557");
	    	gotoxy(1,6);
	    	for(i=5;i<35;i++)
	    	{
	    		gotoxy(1,2+i);
	    		System.out.print("\u2551");
	    	}
	    	gotoxy(1,37);
	    	System.out.print("\u255A");
	    	for(i=1;i<79;i++)
	    	{
	    		gotoxy(1+i,37);
	    		System.out.print("\u2550");
	    	}
	    	gotoxy(80,37);
	    	System.out.print("\u255D");
	    	gotoxy(80,6);
	    	for(i=5;i<35;i++)
	    	{
	    		gotoxy(80,2+i);
	    		System.out.print("\u2551");
	    	}
	    }
		/* This method prints a box with a dashed border to the console.
		 * It does this by printing ASCII characters to the console at 
		 * specific positions to create the appearance of a box with a dashed border.*/
	    public static void medicinebox() {
		  int i;
		    gotoxy(1,6);
		    System.out.print("\u2554");
		   for(i=1;i<79;i++)
		    {
		        gotoxy(1+i,6);
		        System.out.print("\u2550");
		    }
		
		    gotoxy(80,6);
		    System.out.print("\u2557");
		    gotoxy(1,6);
		    for(i=5;i<35;i++)
		    {
		        gotoxy(48,2+i);
		        System.out.print("\u2551");
		    }
		    gotoxy(1,37);
		    System.out.print("\u255A");
		    for(i=1;i<79;i++)
		    {
		        gotoxy(1+i,37);
		        System.out.print("\u2550");
		    }
		    gotoxy(80,37);
		    System.out.print("\u255D");
		    gotoxy(80,6);
		    for(i=5;i<35;i++)
		    {
		        gotoxy(80,2+i);
		        System.out.print("\u2551");
		        
		    }
		    gotoxy(60,6);
		    for(i=5;i<35;i++)
		    {
		        gotoxy(1,2+i);
		        System.out.print("\u2551");
		    }
		}
	/* The displayMainMenu() method displays the main menu of the system
	 * with various options such as "Supplier Info", "Customer Info",
	 * "Medicine", "Report", "Bill", "About", and "Exit".*/    
	public void displayMainMenu()
	{		

		clearScreen();
		gotoxy(3,5);

		System.out.print("Supplier Info");
		gotoxy(19,5);

		System.out.print("Customer Info");
		gotoxy(36,5);

		System.out.print("Medicine");
		gotoxy(48,5);
		
		System.out.print("Report");
		gotoxy(57,5);

		System.out.print("Bill");
		gotoxy(64,5);
		
		System.out.print("About");
		gotoxy(72,5);
		
		System.out.print("Exit");
		t();   //this function display date & time
		box1();
		main_box();
		gotoxy(30,10);
		System.out.print("Welcome To Medical Store ");
	}
	
	//displays supplier screen
	public void displaySupplier() {
		// Clear screen
		System.out.print("\033[H\033[2J");
		System.out.flush();
		// Menu
		gotoxy(34, 3);
		System.out.print("----------------");
		gotoxy(35, 4);
		System.out.print("Supplier MENU");
		gotoxy(34, 5);
		System.out.print("----------------");
		gotoxy(26, 11);
		System.out.print("Add New Supplier");
		gotoxy(26, 15);
		System.out.print("Update Supplier");
		gotoxy(26, 19);
		System.out.print("Search Supplier");
		gotoxy(26, 23);
		System.out.print("List of Existing Supplier");
		gotoxy(26, 27);
		System.out.print("Main Menu");
		main_box();

	}
    //function for adding supplier
	public void addSupplier()
	
	{
		clearScreen();
		main_box();
		gotoxy(30, 8);
		System.out.println("SUPPLIER ENTRY ");
		gotoxy(8, 13);
		System.out.println("SUPPLIER ID : ");
		gotoxy(39, 13);
		System.out.println("SUPPLIER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");
		
	    Scanner scanIn = new Scanner(System.in);
	
		gotoxy(22, 13);
		int id = Integer.parseInt(scanIn.nextLine());
		gotoxy(55, 13);
		String title = scanIn.nextLine();
		gotoxy(22, 18);
		String city = scanIn.nextLine();
		gotoxy(55, 18);
		String contactno = scanIn.nextLine();
		gotoxy(22, 23);
		String emailid = scanIn.nextLine();
	
		Supplier supplier = new Supplier();
		supplier.setId(id);
		supplier.setName(title);
		supplier.setCity(city);
		supplier.setPhone(contactno);
		supplier.setEmail(emailid);
	
		clearScreen();
		gotoxy(20, 30);
		System.out.println("Save");
		gotoxy(28, 30);
		System.out.println("Cancel");
		gotoxy(18, 36);
		System.out.println("Press First charecter for the operation : ");
		gotoxy(1, 31);
		String a = System.console().readLine();
		switch (a) {
		case "s":
			byte[] aBytes = Supplier.supplierToByteArrayBlock(supplier); {
			try {
				FileUtility.appendBlock(aBytes, "supplier.dat");
			} catch (IOException e) {
	
				e.printStackTrace();
			}
		}
			break;
	
		case "c":
			clearScreen();
			System.out.println("it didnt save");
			System.out.println("Write Something And Press Enter To Exit");
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
			displaySupplier();
			break;
		}
	
	}
	//function for editing supplier
	public void editSupplier() {
		clearScreen();
		main_box();
		int suppliernumber;
	
		Scanner scanIn = new Scanner(System.in);
		System.out.println("Please enter the supplier that do you want to edit: ");
		suppliernumber = Integer.parseInt(scanIn.nextLine());
		Supplier supp = new Supplier();
	
		gotoxy(30, 8);
		System.out.println("SUPPLIER ENTRY ");
		gotoxy(8, 13);
		System.out.println("SUPPLIER ID : ");
		gotoxy(39, 13);
		System.out.println("SUPPLIER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");
	
		gotoxy(22, 13);
		int id = Integer.parseInt(scanIn.nextLine());
		gotoxy(55, 13);
		String title = scanIn.nextLine();
		gotoxy(22, 18);
		String city = scanIn.nextLine();
		gotoxy(55, 18);
		String contactno = scanIn.nextLine();
		gotoxy(22, 23);
		String emailid = scanIn.nextLine();
	
		supp.setId(id);
		supp.setName(title);
		supp.setCity(city);
		supp.setPhone(contactno);
		supp.setEmail(emailid);
	
		try {
			byte[] supplierBytes = Supplier.supplierToByteArrayBlock(supp);
			FileUtility.updateBlock(supplierBytes, suppliernumber, Supplier.SUPPLIER_DATA_BLOCK_SIZE, "supplier.dat");
			displaySupplier();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
    //function for searching supplier
	public void searchSupplier() throws IOException {
		int p = 1;
		String fileName = "supplier.dat";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		String datlength = br.readLine();
		br.close();
		int b = datlength.length();
		clearScreen();
		int i = 14;
	
		System.out.println("Id Search for Supplier");
		System.out.println("Name Search for Supplier");
		String a = System.console().readLine();
		switch (a) {
		case "i":
			gotoxy(13, 8);
			System.out.println("Enter id to be searched:");
			int sid = Integer.parseInt(System.console().readLine());
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			clearScreen();
			do {
	
				String path = System.getProperty("user.dir");
				File file = new File(path + File.separator + fileName);
				byte[] WrittenBytes = FileUtility.readBlock(p, Supplier.SUPPLIER_DATA_BLOCK_SIZE, fileName);
				Supplier WrittenObject = Supplier.byteArrayBlockToSupplier(WrittenBytes);
	
				if (WrittenObject != null && sid == WrittenObject.getId()) {
	
					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");
	
					gotoxy(4, i);
					System.out.println(WrittenObject.getId());
					gotoxy(9, i);
					System.out.println(WrittenObject.getName());
					gotoxy(29, i);
					System.out.println(WrittenObject.getCity());
					gotoxy(41, i);
					System.out.println(WrittenObject.getPhone());
					gotoxy(54, i);
					System.out.println(WrittenObject.getEmail());
	
					i++;
				}
	
				p++;
			} while (p < (((b) / (Supplier.SUPPLIER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
			break;
	
		case "n":
	
			gotoxy(13, 8);
			System.out.println("Enter name to be searched:");
			String sname = System.console().readLine();
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			do {
	
				String path = System.getProperty("user.dir");
				File file = new File(path + File.separator + fileName);
				byte[] WrittenBytes = FileUtility.readBlock(p, Supplier.SUPPLIER_DATA_BLOCK_SIZE, fileName);
				Supplier WrittenObject = Supplier.byteArrayBlockToSupplier(WrittenBytes);
	
				int index = WrittenObject.getName().indexOf(sname);
	
				if (WrittenObject != null && index != -1) {
	
					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");
	
					gotoxy(4, i);
					System.out.println(WrittenObject.getId());
					gotoxy(9, i);
					System.out.println(WrittenObject.getName());
					gotoxy(29, i);
					System.out.println(WrittenObject.getCity());
					gotoxy(41, i);
					System.out.println(WrittenObject.getPhone());
					gotoxy(54, i);
					System.out.println(WrittenObject.getEmail());
	
					i++;
				} else {
					gotoxy(4, 12);
					System.out.print("Searched supplier couldn't found.");
				}
				p++;
			} while (p < (((b) / (Supplier.SUPPLIER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner a11 = new Scanner(System.in);
			Character kl1 = a11.next().charAt(0);
	
			break;
		}
	
	}
	//function for listing supplier
	public void listSupplier() throws IOException {
		Supplier j = new Supplier();
		int p = 1;
		String fileName = "supplier.dat";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		String datlength = br.readLine();
		br.close();
		int b = datlength.length();
		clearScreen();
		int i = 14;
		do {

			String path = System.getProperty("user.dir");
			File file = new File(path + File.separator + fileName);
			byte[] WrittenBytes = FileUtility.readBlock(p, Supplier.SUPPLIER_DATA_BLOCK_SIZE, fileName);
			Supplier WrittenObject = Supplier.byteArrayBlockToSupplier(WrittenBytes);

			if (WrittenObject != null) {

				gotoxy(4, 12);
				System.out.print("ID");
				gotoxy(9, 12);
				System.out.println("Name");
				gotoxy(29, 12);
				System.out.println("City");
				gotoxy(41, 12);
				System.out.println("Contact No");
				gotoxy(54, 12);
				System.out.println("Email Id");

				gotoxy(4, i);
				System.out.println(WrittenObject.getId());
				gotoxy(9, i);
				System.out.println(WrittenObject.getName());
				gotoxy(29, i);
				System.out.println(WrittenObject.getCity());
				gotoxy(41, i);
				System.out.println(WrittenObject.getPhone());
				gotoxy(54, i);
				System.out.println(WrittenObject.getEmail());

				i++;
			}
			p++;
		} while (p < (((b) / (Supplier.SUPPLIER_DATA_BLOCK_SIZE)) + 1));
		main_box();
		Scanner a1 = new Scanner(System.in);
		Character kl = a1.next().charAt(0);
	}
	//function for displaying customer menu
	public void displayCustomer() {
		clearScreen();
		gotoxy(34, 3);
		System.out.print("----------------");
		gotoxy(35, 4);
		System.out.print("Customer MENU");
		gotoxy(34, 5);
		System.out.print("----------------");
		gotoxy(26, 11);
		System.out.print("Add New Customer");
		gotoxy(26, 15);
		System.out.print("Update Customer");
		gotoxy(26, 19);
		System.out.print("Search Customer");
		gotoxy(26, 23);
		System.out.print("List of Existing Customer");
		gotoxy(26, 27);
		System.out.print("Main Menu");
		main_box();
	
	}
	//function for adding customer
	public void addCustomer() {
	
		clearScreen();
		main_box();
		gotoxy(30, 8);
		System.out.println("CUSTOMER ENTRY ");
		gotoxy(8, 13);
		System.out.println("CUSTOMER ID : ");
		gotoxy(39, 13);
		System.out.println("CUSTOMER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");
		
	    Scanner scanIn = new Scanner(System.in);
	
		gotoxy(22, 13);
		int id = Integer.parseInt(scanIn.nextLine());
		gotoxy(55, 13);
		String title = scanIn.nextLine();
		gotoxy(22, 18);
		String city = scanIn.nextLine();
		gotoxy(55, 18);
		String contactno = scanIn.nextLine();
		gotoxy(22, 23);
		String emailid = scanIn.nextLine();
	
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(title);
		customer.setCity(city);
		customer.setPhone(contactno);
		customer.setEmail(emailid);
	
		clearScreen();
		gotoxy(20, 30);
		System.out.println("Save");
		gotoxy(28, 30);
		System.out.println("Cancel");
		gotoxy(18, 36);
		System.out.println("Press First charecter for the operation : ");
		gotoxy(1, 31);
		String a = System.console().readLine();
		switch (a) {
		case "s":
	
			byte[] aBytes = Customer.customerToByteArrayBlock(customer); {
			try {
				FileUtility.appendBlock(aBytes, "customer.dat");
			} catch (IOException e) {
	
				e.printStackTrace();
			}
		}
			break;
		case "c":
			clearScreen();
			System.out.println("it didnt save");
			System.out.println("Write Something And Press Enter To Exit");
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
			displaySupplier();
			break;
		}
	
	}
	//function for editing customer
	public void editCustomer() {
	
		int customernumber;
		clearScreen();
		System.out.println("Please enter number of the customer which do you want to edit: ");
		
	    Scanner scanIn = new Scanner(System.in);

		customernumber = Integer.parseInt(scanIn.nextLine());
		Customer cust = new Customer();
	
		gotoxy(30, 8);
		System.out.println("CUSTOMER ENTRY ");
		gotoxy(8, 13);
		System.out.println("CUSTOMER ID : ");
		gotoxy(39, 13);
		System.out.println("CUSTOMER NAME : ");
		gotoxy(8, 18);
		System.out.println("CITY        : ");
		gotoxy(39, 18);
		System.out.println("CONTACT NO.   : ");
		gotoxy(8, 23);
		System.out.println("EMAIL ID    : ");
	
		gotoxy(22, 13);
		int id = Integer.parseInt(scanIn.nextLine());
		gotoxy(55, 13);
		String title = scanIn.nextLine();
		gotoxy(22, 18);
		String city = scanIn.nextLine();
		gotoxy(55, 18);
		String contactno = scanIn.nextLine();
		gotoxy(22, 23);
		String emailid = scanIn.nextLine();
	
		cust.setId(id);
		cust.setName(title);
		cust.setCity(city);
		cust.setPhone(contactno);
		cust.setEmail(emailid);
	
		byte[] customerBytes = Customer.customerToByteArrayBlock(cust);
		try {
			FileUtility.updateBlock(customerBytes, customernumber, Customer.CUSTOMER_DATA_BLOCK_SIZE, "customer.dat");
			displayCustomer();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	//function for searching customer
	public void searchCustomer() throws IOException {
		int p = 1;
		String fileName = "customer.dat";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		String datlength = br.readLine();
		br.close();
		int b = datlength.length();
		clearScreen();
		int i = 14;
	
		System.out.println("Id Search for Customer");
		System.out.println("Name Search for Customer");
		String a = System.console().readLine();
		switch (a) {
		case "i":
			gotoxy(13, 8);
			System.out.println("Enter id to be searched:");
			int sid = Integer.parseInt(System.console().readLine());
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			clearScreen();
			do {
	
				String path = System.getProperty("user.dir");
				File file = new File(path + File.separator + fileName);
				byte[] WrittenBytes = FileUtility.readBlock(p, Customer.CUSTOMER_DATA_BLOCK_SIZE, fileName);
				Customer WrittenObject = Customer.byteArrayBlockToCustomer(WrittenBytes);
	
				if (WrittenObject != null && sid == WrittenObject.getId()) {
	
					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");
	
					gotoxy(4, i);
					System.out.println(WrittenObject.getId());
					gotoxy(9, i);
					System.out.println(WrittenObject.getName());
					gotoxy(29, i);
					System.out.println(WrittenObject.getCity());
					gotoxy(41, i);
					System.out.println(WrittenObject.getPhone());
					gotoxy(54, i);
					System.out.println(WrittenObject.getEmail());
	
					i++;
				}
	
				p++;
			} while (p < (((b) / (Customer.CUSTOMER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
			break;
	
		case "n":
	
			gotoxy(13, 8);
			System.out.println("Enter name to be searched:");
			String sname = System.console().readLine();
			gotoxy(20, 35);
			System.out.println("Press Any key to Return Back Menu ....");
			do {
	
				String path = System.getProperty("user.dir");
				File file = new File(path + File.separator + fileName);
				byte[] WrittenBytes = FileUtility.readBlock(p, Customer.CUSTOMER_DATA_BLOCK_SIZE, fileName);
				Customer WrittenObject = Customer.byteArrayBlockToCustomer(WrittenBytes);
	
				int index = WrittenObject.getName().indexOf(sname);
	
				if (WrittenObject != null && index > 0) {
	
					gotoxy(4, 12);
					System.out.print("ID");
					gotoxy(9, 12);
					System.out.println("Name");
					gotoxy(29, 12);
					System.out.println("City");
					gotoxy(41, 12);
					System.out.println("Contact No");
					gotoxy(54, 12);
					System.out.println("Email Id");
	
					gotoxy(4, i);
					System.out.println(WrittenObject.getId());
					gotoxy(9, i);
					System.out.println(WrittenObject.getName());
					gotoxy(29, i);
					System.out.println(WrittenObject.getCity());
					gotoxy(41, i);
					System.out.println(WrittenObject.getPhone());
					gotoxy(54, i);
					System.out.println(WrittenObject.getEmail());
	
					i++;
				} else {
					gotoxy(4, 12);
					System.out.print("Searched customer couldn't found.");
				}
				p++;
			} while (p < (((b) / (Customer.CUSTOMER_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner a11 = new Scanner(System.in);
			Character kl1 = a11.next().charAt(0);
	
			break;
		}
	
	}
	//function for listing customers to screen
	public void listCustomer() throws IOException {
		Customer j = new Customer();
		int p = 1;
		String fileName = "customer.dat";
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fileReader);
		String datlength = br.readLine();
		br.close();
		int b = datlength.length();
		clearScreen();
		int i = 14;
		do {

			String path = System.getProperty("user.dir");
			File file = new File(path + File.separator + fileName);
			byte[] WrittenBytes = FileUtility.readBlock(p, Customer.CUSTOMER_DATA_BLOCK_SIZE, fileName);
			Customer WrittenObject = Customer.byteArrayBlockToCustomer(WrittenBytes);

			if (WrittenObject != null) {

				gotoxy(4, 12);
				System.out.print("ID");
				gotoxy(9, 12);
				System.out.println("Name");
				gotoxy(29, 12);
				System.out.println("City");
				gotoxy(41, 12);
				System.out.println("Contact No");
				gotoxy(54, 12);
				System.out.println("Email Id");

				gotoxy(4, i);
				System.out.println(WrittenObject.getId());
				gotoxy(9, i);
				System.out.println(WrittenObject.getName());
				gotoxy(29, i);
				System.out.println(WrittenObject.getCity());
				gotoxy(41, i);
				System.out.println(WrittenObject.getPhone());
				gotoxy(54, i);
				System.out.println(WrittenObject.getEmail());

				i++;
			}
			p++;
		} while (p < (((b) / (Customer.CUSTOMER_DATA_BLOCK_SIZE)) + 1));
		main_box();
		Scanner a1 = new Scanner(System.in);
		Character kl = a1.next().charAt(0);
	}
	//function for displaying medicine menu
	public void displayMedicine() {
		// Clear screen
		clearScreen();
		// Menu
		gotoxy(34, 3);
		System.out.print("----------------");
		gotoxy(35, 4);
		System.out.print("Medicine MENU");
		gotoxy(34, 5);
		System.out.print("----------------");
		gotoxy(26, 15);
		System.out.print("Purchase New Medicine");
		gotoxy(26, 19);
		System.out.print("Sale Medicine");
		gotoxy(26, 23);
		System.out.print("Stock of Medicine");
		gotoxy(26, 27);
		System.out.print("Search Medicine");
		gotoxy(26, 31);
		System.out.print("Main Menu");
		main_box();

	}
	//function for purchasing medicine
	public void purchaseMedicine() {
		clearScreen();
		main_box();
	
		gotoxy(7, 11);
		System.out.println("MEDICINE ID    : ");
		gotoxy(40, 11);
		System.out.println("MEDICINE NAME  : ");
		gotoxy(7, 14);
		System.out.println("ENTER RACK NO  : ");
		gotoxy(40, 14);
		System.out.println("CABNIT NO      : ");
		gotoxy(7, 18);
		System.out.println("COMPANY NAME   : ");
		gotoxy(40, 18);
		System.out.println("SUPPLIER NAME  : ");
		gotoxy(7, 21);
		System.out.println("UNIT COST   Rs.:  ");
		gotoxy(40, 21);
		System.out.println("SALE COST   Rs.: ");
		gotoxy(7, 24);
		System.out.println("QUANTITY       :  ");
		gotoxy(7, 27);
		System.out.println("MFG.DATE(dd-mm-yyyy): ");
		gotoxy(7, 29);
		System.out.println("EXP.DATE(dd-mm-yyyy): ");
	
		Scanner scanIn = new Scanner(System.in);
		gotoxy(26, 11);
		int id = Integer.parseInt(scanIn.nextLine());
		gotoxy(60, 11);
		String name = scanIn.nextLine();
		gotoxy(26, 14);
		String rackno = scanIn.nextLine();
		gotoxy(60, 14);
		String cabnitno = scanIn.nextLine();
		gotoxy(26, 18);
		String companyname = scanIn.nextLine();
		gotoxy(60, 18);
		String suppliername = scanIn.nextLine();
		gotoxy(26, 21);
		String unitcost = scanIn.nextLine();
		gotoxy(60, 21);
		String salecost = scanIn.nextLine();
		gotoxy(26, 24);
		String quantity = scanIn.nextLine();
		gotoxy(30, 27);
		String mfgdate = scanIn.nextLine();
		gotoxy(30, 29);
		String expdate = scanIn.nextLine();
		
		
				Medicine medicine = new Medicine();
					
			medicine.setId(id);
			medicine.setName(name);
			medicine.setRack(rackno);
			medicine.setCabinet(cabnitno);
			medicine.setCompanyName(companyname);
			medicine.setSupplierName(suppliername);
			medicine.setUnitCost(unitcost);
			medicine.setSaleCost(salecost);
			medicine.setQuantity(quantity);
			medicine.setManDate(mfgdate);
			medicine.setExpDate(expdate);
				
		int quantityint = Integer.parseInt(medicine.getQuantity());
		int saleint = Integer.parseInt(medicine.getSaleCost());
		int unitint = Integer.parseInt(medicine.getUnitCost());
	
		int totalSaleCost = quantityint * saleint;
		int totalUnitCost = quantityint * unitint;
	
		gotoxy(7, 31);
		System.out.println("Total Sale Cost : " + totalSaleCost);
		gotoxy(40, 31);
		System.out.println("Total Unit Cost : " + totalUnitCost);
	

	
		gotoxy(20, 33);
		System.out.println("Save");
		gotoxy(28, 33);
		System.out.println("Cancel");
		gotoxy(18, 36);
		System.out.println("Press First charecter for the operation : ");
		gotoxy(1, 31);
		String a = System.console().readLine();
		switch (a) {
		case "s":
	
			byte[] aBytes = Medicine.medicineToByteArrayBlock(medicine); {
			try {
				FileUtility.appendBlock(aBytes, "medicine.dat");
			} catch (IOException e) {
	
				e.printStackTrace();
			}
		}
			break;
		case "c":
			clearScreen();
			System.out.println("it didnt save");
			System.out.println("Write Something And Press Enter To Exit");
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
			displaySupplier();
			break;
		}
	}
	//function for selling medicine
	public void saleMedicine() throws IOException {
		Medicine f = new Medicine();
		clearScreen();
		int p2 = 1;
		String file2Name = "medicine.dat";
		byte[] bookWrittenBytes2 = FileUtility.readBlock(p2, Medicine.MEDICINE_DATA_BLOCK_SIZE, file2Name);
		Medicine bookWrittenObject2 = Medicine.byteArrayBlockToMedicine(bookWrittenBytes2);
		
		String medname = bookWrittenObject2.getName();
		String medcab = bookWrittenObject2.getCabinet();
		String medcomp = bookWrittenObject2.getCompanyName();
		String medexp = bookWrittenObject2.getExpDate();
		String medmfg = bookWrittenObject2.getManDate();
		String medrack = bookWrittenObject2.getRack();	
		String medsale = bookWrittenObject2.getSaleCost();
		String medsupp = bookWrittenObject2.getSupplierName();
		String medunit = bookWrittenObject2.getUnitCost();
		int medid = bookWrittenObject2.getId();


		int p = 1;
		String fileName = "medicine.dat";
		bill bill = new bill();
		
		FileReader fileReader = new FileReader(fileName);
		BufferedReader br2 = new BufferedReader(fileReader);
		String datlength = br2.readLine();
		
		int b = datlength.length();
		int i = 14;
	    medicinebox();
		gotoxy(7, 11);
		System.out.println("Enter Medicine Id To Be Sold : ");
		gotoxy(40, 11);
		
	    Scanner scanIn = new Scanner(System.in);

		int sid = Integer.parseInt(scanIn.nextLine());
		clearScreen();
		
		byte[] bookWrittenBytes = FileUtility.readBlock(p, Medicine.MEDICINE_DATA_BLOCK_SIZE, fileName);
		Medicine bookWrittenObject = Medicine.byteArrayBlockToMedicine(bookWrittenBytes);
		
		do {
			if (bookWrittenObject != null && sid == bookWrittenObject.getId()) {
				gotoxy(7, i);
				System.out.println("Medicine Name     : " + bookWrittenObject.getName());
				gotoxy(7, i + 1);
				System.out.println("Quantity In Stock : " + bookWrittenObject.getQuantity());
				gotoxy(7, i + 2);
				System.out.println("Sales Price       : " + bookWrittenObject.getSaleCost());
				

				i++;
			}
			p++;
		} while (p < (((b) / (Medicine.MEDICINE_DATA_BLOCK_SIZE)) + 1));
		medicinebox();
        int newquantity = Integer.parseInt(bookWrittenObject.getQuantity());
		String medicinename = bookWrittenObject.getName();
		String rate = bookWrittenObject.getSaleCost();
		gotoxy(7, 18);
		System.out.println("Enter Bill Number     : ");
		gotoxy(31, 18);
		int billnumber = Integer.parseInt(scanIn.nextLine());
		gotoxy(7, 21);
		System.out.println("Enter Customer Name   : ");
		gotoxy(31, 21);
		String custname = scanIn.nextLine();
		gotoxy(7, 24);
		System.out.println("Quantity Want To Sale : ");
		gotoxy(31, 24);
		String quantity = scanIn.nextLine();
		
		
		
		int newquantity1 = Integer.parseInt(quantity);
		int	lastquantity = newquantity - newquantity1 ;
		String lastquantity1 = String.valueOf(lastquantity);
		
		clearScreen();
		main_box();
		gotoxy(7,18);
		System.out.println("Price Paid By Customer : " + custname);
		gotoxy(7,21);
		System.out.println("Quantity Sold          : " + quantity);
		
		Scanner a11 = new Scanner(System.in);
		Character kl1 = a11.next().charAt(0);
		
		f.setCabinet(medcab);
		f.setCompanyName(medcomp);
		f.setExpDate(medexp);
		f.setId(medid);
		f.setName(medname);
		f.setManDate(medmfg);
		f.setRack(medrack);
		f.setSaleCost(medsale);
		f.setSupplierName(medsupp);
		f.setUnitCost(medunit);
     	f.setQuantity(lastquantity1);
     	byte[] aBytes = Medicine.medicineToByteArrayBlock(f); {
			FileUtility.updateBlock(aBytes,sid,Medicine.MEDICINE_DATA_BLOCK_SIZE, "medicine.dat");
		}
     	
		bill.setbillno(billnumber);
		bill.setcustomername(custname);
		bill.setmedicinename(medicinename);
		bill.setquantity(quantity);
		bill.setrate(rate);
		
		byte[] aBytes1 = ce103_hw4_library_lib.bill.billToByteArrayBlock(bill); {
			try {
				FileUtility.appendBlock(aBytes1, "bill.dat");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		clearScreen();
		gotoxy(20, 20);
		System.out.println("Succesfully Updated");
		main_box();
		Scanner a111 = new Scanner(System.in);
		Character kl11 = a111.next().charAt(0);
		
		br2.close();
		displayMedicine();
	
	
	}
	//function for displaying medicine list
	 public void stockmedicine() throws IOException {
	        clearScreen();
	    	gotoxy(9,10);
			System.out.println("ID.   MEDICINE NAME.    QTY     Supplier Name     Exp.Date");
			gotoxy(9,12);
			System.out.println("===========================================================\n");
		
			int p22 = 1;
			String file2Name2 = "medicine.dat";
			FileReader file22Reader = new FileReader(file2Name2);
			BufferedReader br = new BufferedReader(file22Reader);
			String dat22length = br.readLine();
			br.close();
			int b22 = dat22length.length();
			int i22 = 14;
			do {
				byte[] bookWrittenBytes11 = FileUtility.readBlock(p22, Medicine.MEDICINE_DATA_BLOCK_SIZE, file2Name2);
				Medicine bookWrittenObject11 = Medicine.byteArrayBlockToMedicine(bookWrittenBytes11);

				if (bookWrittenObject11 != null) {

					gotoxy(9, i22);
					System.out.println(bookWrittenObject11.getId());
					gotoxy(15, i22);
					System.out.println(bookWrittenObject11.getName());
					gotoxy(33, i22);
					System.out.println(bookWrittenObject11.getQuantity());
					gotoxy(41, i22);
					System.out.println(bookWrittenObject11.getSupplierName());
					gotoxy(59, i22);
					System.out.println(bookWrittenObject11.getExpDate());
		
					i22++;
				}
				p22++;
			} while (p22 < (((b22) / (Medicine.MEDICINE_DATA_BLOCK_SIZE)) + 1));
			main_box();
		
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
	    }
	 
	//function for search medicine 
	public void searchmedicine() throws IOException
	{
		int pp = 1;
		String ffileName = "medicine.dat";
		FileReader ffileReader = new FileReader(ffileName);
		BufferedReader br = new BufferedReader(ffileReader);
		String dattlength = br.readLine();
		br.close();
		int bb = dattlength.length();
		clearScreen();
		int ii = 14;

		
			gotoxy(13, 8);
			System.out.println("Enter id to be searched:");
			int sid = Integer.parseInt(System.console().readLine());
	
			clearScreen();
		    	gotoxy(9,10);
				System.out.println("ID.   MEDICINE NAME.    QTY     Supplier Name     Exp.Date");
				gotoxy(9,12);
				System.out.println("===========================================================\n");
			do {

				byte[] bookWrittenBytes = FileUtility.readBlock(pp, Medicine.MEDICINE_DATA_BLOCK_SIZE, ffileName);
				Medicine bookWrittenObject = Medicine.byteArrayBlockToMedicine(bookWrittenBytes);

				if (bookWrittenObject != null && sid == bookWrittenObject.getId()) {

					gotoxy(9, ii);
					System.out.println(bookWrittenObject.getId());
					gotoxy(15, ii);
					System.out.println(bookWrittenObject.getName());
					gotoxy(33, ii);
					System.out.println(bookWrittenObject.getQuantity());
					gotoxy(41, ii);
					System.out.println(bookWrittenObject.getSupplierName());
					gotoxy(59, ii);
					System.out.println(bookWrittenObject.getExpDate());
					ii++;
				}

				pp++;
			} while (pp < (((bb) / (Medicine.MEDICINE_DATA_BLOCK_SIZE)) + 1));
			main_box();
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);
	}
	
	//function for displaying report menu
	public void displayReport() {
		// Clear screen
		clearScreen();
		// Menu
		gotoxy(34, 3);
		System.out.print("----------------");
		gotoxy(35, 4);
		System.out.print("Report MENU");
		gotoxy(34, 5);
		System.out.print("----------------");
		gotoxy(26, 12);
		System.out.print("Purchase Report");
		gotoxy(26, 16);
		System.out.print("Sale Report");
		gotoxy(26, 20);
		System.out.print("Profit Report");
		gotoxy(26, 24);
		System.out.print("Daily Sale Report");
		gotoxy(26, 28);
		System.out.print("Daily Purchase Report");
		gotoxy(26, 32);
		System.out.print("Main Menu");
		main_box();

	}
	//function for displaying bills
	public void displayBill() throws IOException {
		
		clearScreen();
		int p2 = 1;
		String file2Name = "medicine.dat";
		byte[] bookWrittenBytes2 = null;
		try {
			bookWrittenBytes2 = FileUtility.readBlock(p2, Medicine.MEDICINE_DATA_BLOCK_SIZE, file2Name);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Medicine bookWrittenObject2 = Medicine.byteArrayBlockToMedicine(bookWrittenBytes2);

		String medquan = bookWrittenObject2.getQuantity();
		String medsale = bookWrittenObject2.getSaleCost();
		int medquannew = Integer.parseInt(medquan);
		int medsalenew = Integer.parseInt(medsale);

		int pp = 1;
		String ffileName = "bill.dat";
		FileReader ffileReader = null;
		try {
			ffileReader = new FileReader(ffileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(ffileReader);
		String dattlength = br.readLine();
		br.close();
		int bb = dattlength.length();
		clearScreen();
		int ii = 17;

		gotoxy(13, 8);
		System.out.println("Enter bill no to be searched:");
		gotoxy(42, 8);
		int sid = Integer.parseInt(System.console().readLine());
        main_box();
		clearScreen();
	
		gotoxy(9, 14);
		System.out.println("Sr.No  ID.   MEDICINE NAME.    QTY     Rate     Total");
		gotoxy(9, 15);
		System.out.println("=====================================================\n");

		do {

			byte[] bookWrittenBytes = FileUtility.readBlock(pp, bill.BOOK_DATA_BLOCK_SIZE, ffileName);
			bill bookWrittenObject = bill.byteArrayBlockToBill(bookWrittenBytes);
            int billnobro =  bookWrittenObject.getbillno();
           gotoxy(9,7);
 		   System.out.println("Bill No: ");
 		   gotoxy(18,7);
 		   System.out.println(bookWrittenObject.getbillno());
 		   gotoxy(9,9);
 		   System.out.println("Customer Name: ");
 		   gotoxy(24,9);
 		   System.out.println(bookWrittenObject.getcustomername());
 		   
			if (bookWrittenObject != null && sid == billnobro) {

				gotoxy(9, ii);
				System.out.println(pp);
				gotoxy(16, ii);
				System.out.println(bookWrittenObject.getid());
				gotoxy(22, ii);
				System.out.println(bookWrittenObject.getmedicinename());
				gotoxy(40, ii);
				System.out.println(bookWrittenObject.getquantity());
				gotoxy(48, ii);
				System.out.println(bookWrittenObject.getrate());
				int total = medsalenew * medquannew;
				gotoxy(57, ii);
				System.out.println(total);
				ii++;
			}

			pp++;
		} while (pp < (((bb) / (bill.BOOK_DATA_BLOCK_SIZE)) + 1));
		main_box();

		Scanner b1 = new Scanner(System.in);
		Character cl = b1.next().charAt(0);

	}
	
	
	//function for displaying about menu
	public void displayAbout()
	{
		clearScreen();
		gotoxy(28,4);
		System.out.println("***** MEDICAL STORE *****");
		gotoxy(10,8);
		System.out.println("=> In this app we can Add Medicine, Customer, Supplier Details.");
		gotoxy(10,10);
		System.out.println("=> We can Modify & Delete Existing Record.");
		gotoxy(10,12);
		System.out.println("=> We can also Search Medicine, Customer, Supplier Details.");
		gotoxy(10,14);
		System.out.println("=> For more info, check https://github.com/Melihdvn/ce103_hw4_2022_2023_habil_kocoglu_melih_divan\n");
		pressEnterToContinue();

	}


	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.runMenu();
	}
	//function for running menu
	public void runMenu() {
		while (!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}
	//function for printing menu
	public void printMenu() {
		Menu b = new Menu();
		b.clearScreen();
		displayMainMenu();
	}
	//function for getting input
	public int getInput() {
		Scanner kb = new Scanner(System.in);
		int choice = -1;
		while (choice < 0 || choice > 6) {
			try {
				gotoxy(10,40);
				System.out.print("Press First Character for further Menu");
				choice = Integer.parseInt(kb.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("invalid");
			}
		}
		return choice;
	}

	public void performAction(int choice) {
		Menu a = new Menu();

		switch (choice) {
		case 0:
			exit = true;
			a.clearScreen();
			System.out.println("Exiting app...");
			break;

		case 1:
			displaySupplier();
			Scanner kb = new Scanner(System.in);
			choice = Integer.parseInt(kb.nextLine());

			switch (choice) { //supplier menu choices
			case 1:
				addSupplier();
				break;
			case 2:
				editSupplier();
				break;
			case 3:
				try {
					searchSupplier();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					listSupplier();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				displayMainMenu();
				break;

			}
			break;
		case 2:
			a.clearScreen();
			Scanner kz = new Scanner(System.in);
			displayCustomer();
			choice = Integer.parseInt(kz.nextLine());

			switch (choice) {
			case 1:
				addCustomer();
				break;
			case 2:
				editCustomer();
				break;
			case 3:
				try {
					searchCustomer();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					listCustomer();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				displayMainMenu();
				break;

			}
			break;
		case 3:
			a.clearScreen();
			Scanner kd = new Scanner(System.in);
			displayMedicine();
			choice = Integer.parseInt(kd.nextLine());

			switch (choice) {
			case 1:
				purchaseMedicine();
				break;
			case 2:
				try {
					saleMedicine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					stockmedicine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					searchmedicine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				displayMainMenu();
				break;

			}
			break;
		case 4:
			clearScreen();
			displayReport();
			Scanner dsd = new Scanner(System.in);
			choice = Integer.parseInt(dsd.nextLine());

			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

			}

			break;
		case 5:
			try {
				displayBill();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 6:
			displayAbout();
			break;
		}
	}
}