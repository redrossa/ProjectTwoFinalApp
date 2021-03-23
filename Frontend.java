import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
//--== CS400 File Header Information ==--
//Name: Mayank Dornala
//Email: dornala@wisc.edu
//Team: JF Blue
//Role: Frontend Developer
//TA: Xinyi
//Lecturer: Gary Dahl
//Notes to Grader: <optional extra notes>
public class Frontend {

	private static int selectedRank = 0; 
	private static String name = ""; 
	
	public void main(String[] args) throws IOException {

		Backend back = new Backend(args); 
		// Introduction:
		System.out.println("Welcome to the NBA Player Catalog!");
		System.out.println("Press Enter to continue to Search Selection Mode: "); 
		// press enter to continue:
		try {        
			System.in.read();
		} catch(Exception e){	
			System.out.println("Please press Enter to contine");
			main(args); 
		}
		searchSelectionMode(back); 
	}
	
	/**
	 * This acts as a Main Menu, where you can select to search by ranking or by player name
	 * @param backend
	 */
	public static void searchSelectionMode(Backend backend) { // Main Menu
		
		@SuppressWarnings("resource")
		Scanner user = new Scanner(System.in);  
		// Search Selection Mode Introduction: 
		System.out.println("--------------------------------------------------------------"); 
		System.out.println("Welcome to Search Selection Mode: ");
		System.out.println("If you want to search by All-Time NBA Points, press 1.");
		System.out.println("If you want to search by your favorite players names, press 2.");
		
		int whichMode = 0;
		try {
			whichMode = user.nextInt();
		} catch (InputMismatchException  e) {
			System.out.println("Invalid Input Type. Please enter either 1 or 2.");
			searchSelectionMode(backend); 
		}
		
		if(whichMode == 1) {
			rankMode(backend); 
		} else if(whichMode == 2) {
			searchByNameMode(backend); 
		} else {
			System.out.println("Invalid Input. Please enter 1 or 2.");
			searchSelectionMode(backend); 
		}
	}
	
	/**
	 * Search By Name: allows user to enter a player's whole name with proper capitalization
	 * and spacing. This will then retrieve that player's info from the Backend and 
	 * display it to the user. 
	 * @param backend
	 */
	public static void searchByNameMode(Backend backend) {
		name = "";  
		
		@SuppressWarnings("resource")
		Scanner user = new Scanner(System.in);  
		
		while(true) {
			
			// Introduction: 
			System.out.println("--------------------------------------------------------------"); 
			System.out.println("Search by Player Name: ");
			System.out.println("Please include a Player's whole name (i.e. \"Lebron James\", not \"James\")"); 
			System.out.println("If you wish to return to search selection mode, type \"exit\" "); 
			
			try {
				name = user.nextLine();
			} catch (Exception e) {
				System.out.println("Please enter a player's whole name. Try again.");
				searchByNameMode(backend); 
			}
			
			if(name.toLowerCase().equals("exit")) {
				searchSelectionMode(backend); 
			}
			
			Player target = (Player) backend.searchByPlayerName(name);
			// if target doesn't exist: restart name mode. 
			if(target == null) {
				System.out.println("Please enter valid player name with proper spacing.");
				searchByNameMode(backend); 
			}
			
			String targetStatLine = backend.getStatLine(target.getPoints());
			System.out.println("Name: " + target.getName());
			System.out.println("Stat Line: ");
			System.out.println(targetStatLine); 
					              
		}
	}
	
	/**
	 * Search by total Points: Allows user to enter a points value (integer) and will retrieve first player found in
	 * RB Tree with that points value. This method will display that player's stat line to the user.
	 * @param backend
	 */
	public static void rankMode(Backend backend) {
		
		@SuppressWarnings("resource")
		Scanner user = new Scanner(System.in);  
		
		while(true) {
			
			// Introduction: 
			System.out.println("--------------------------------------------------------------"); 
			System.out.println("Search by AllTimePoints: ");
			System.out.println("Please enter a Points Value to see the player with that number of points. Press 0 to exit back to Search Selection");
			System.out.println("To see Kareem Abdul-Jabbar, enter 38387 as that is the number of points he scored in his career."); 
			
			try {
				selectedRank = user.nextInt();
			} catch (InputMismatchException e) { // invalid input type
				System.out.println("Must enter an Integer Rank. Please try again.");
				rankMode(backend);  
			} 
			
			if(selectedRank < 0) { // invalid input
				System.out.println("Rank cannot be negative or 0. Please try again.");
				rankMode(backend); 
			}
			
			if(selectedRank == 0) { // quit out of ranking mode
				System.out.println("Back to Search Selection Mode");
				searchSelectionMode(backend); 
			}
			
			// search for player name
			name = backend.getPlayerName(selectedRank); 
			// retrieve player object from backend
			Player target = (Player) backend.searchByPlayerName(name);
			
			// Display Player Object Stat Line: 
			System.out.println("Name: " + target.getName());
			System.out.println("Stat Line: ");
			String string = backend.getStatLine(selectedRank);
			System.out.println(string); 
		}	
	}

}
