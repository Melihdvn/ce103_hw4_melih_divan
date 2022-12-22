package ce103_hw4_library_app;

import java.util.Scanner;

public class Menu {

	boolean exit;

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.runMenu();
	}

	public void runMenu() {
		printHeader();
		while (!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void printHeader() {
		System.out.println("Welcome");

	}

	public void printMenu() {
		Menu b = new Menu();
		b.clearScreen();
		System.out.println("Please make a selection");
		System.out.println(" "
				+ "________________________________________________________________________________\r\n"
				+ " |                                                                              |\r\n"
				+ " | 1-Supplier Info 2-Customer Info 3-Medicine 4-Report  5-Bill 6-About  0-Exit  |\r\n"
				+ " |______________________________________________________________________________|\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                            Welcome To Medical Store                          |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |                                                                              |\r\n"
				+ " |______________________________________________________________________________|");
	}

	public int getInput() {
		Scanner kb = new Scanner(System.in);
		int choice = -1;
		while (choice < 0 || choice > 6) {
			try {
				System.out.println("Enter your choice : ");
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
			a.clearScreen();
			System.out.println(""
					+ "                               ---------------\r\n"
					+ "                                Supplier MENU\r\n"
					+ "                               ---------------\r\n"
					+ " ________________________________________________________________________________\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     1-Add New Supplier                                       |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     2-Update Supplier                                        |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     3-Search Supplier                                        |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     4-List of Existing Supplier                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     5-Main Menu                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |______________________________________________________________________________|");
			Scanner kb = new Scanner(System.in);
			System.out.println("Enter your choice : ");
			choice = Integer.parseInt(kb.nextLine());

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
		case 2:
			a.clearScreen();
			System.out.println(""
					+ "                               ---------------\r\n"
					+ "                                Customer MENU\r\n"
					+ "                               ---------------\r\n"
					+ " ________________________________________________________________________________\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     1-Add New Customer                                       |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     2-Update Customer                                        |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     3-Search Customer                                        |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     4-List of Existing Customer                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     5-Main Menu                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |______________________________________________________________________________|");
			Scanner de = new Scanner(System.in);
			System.out.println("Enter your choice : ");
			choice = Integer.parseInt(de.nextLine());

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
		case 3:
			a.clearScreen();
			System.out.println(""
					+ "                               ---------------\r\n"
					+ "                                Medicine MENU\r\n"
					+ "                               ---------------\r\n"
					+ " ________________________________________________________________________________\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     1-Purchase New Medicine                                  |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     2-Sale Medicine                                          |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     3-Stock of Medicine                                      |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     4-Search Medicine                                        |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     5-Main Menu                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |______________________________________________________________________________|");
			Scanner ds = new Scanner(System.in);
			System.out.println("Enter your choice : ");
			choice = Integer.parseInt(ds.nextLine());

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
		case 4:
			a.clearScreen();
			System.out.println(""
					+ "                               ---------------\r\n"
					+ "                                 Report MENU\r\n"
					+ "                               ---------------\r\n"
					+ " ________________________________________________________________________________\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     1-Purchase Report                                        |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     2-Sale Report                                            |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     3-Profit Report                                          |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     4-Daily Sale Report                                      |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     5-Daily Purchase Report                                  |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                     6-Main Menu                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |                                                                              |\r\n"
					+ " |______________________________________________________________________________|");
			Scanner dsd = new Scanner(System.in);
			System.out.println("Enter your choice : ");
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
			a.clearScreen();

			Scanner df = new Scanner(System.in);
			System.out.println("Enter The Bill No : ");
			choice = Integer.parseInt(df.nextLine());

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
		case 6:
			a.clearScreen();
			System.out.println(""
					+ "                            ***** MEDICAL STORE *****\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "          => This is an app for medical store management.\r\n"
					+ "\r\n"
					+ "          => In this app we can Add Medicine, Customer, Supplier Details.\r\n"
					+ "\r\n"
					+ "          => We can Modify & Delete Existing Record.\r\n"
					+ "\r\n"
					+ "          => We can also Search Medicine, Customer, Supplier Details.\r\n");
			
			System.out.println("\nFor more info, check https://github.com/Melihdvn/ce103_hw4_2022_2023_habil_kocoglu_melih_divan");

			System.out.println("Write Something And Press Enter To Exit.");
			Scanner a1 = new Scanner(System.in);
			Character kl = a1.next().charAt(0);

			break;
		}
	}
}