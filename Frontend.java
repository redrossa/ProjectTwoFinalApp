import java.util.ArrayList;
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
	
	public static void main(String[] args) {
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
		System.out.println("If you want to search by All-Time NBA Points ranking, press 1.");
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
	
	public static void searchByNameMode(Backend backend) {
		name = "";  
		
		@SuppressWarnings("resource")
		Scanner user = new Scanner(System.in);  
		
		while(true) {
			
			// Introduction: 
			System.out.println("--------------------------------------------------------------"); 
			System.out.println("Search by Player Name: ");
			System.out.println("Please include a Player's whole name (i.e. \"Lebron James\", not \"James\""); 
			System.out.println("If you wish to return to search selection mode, type \"exit\" "); 
			
			try {
				name = user.nextLine();
			} catch (Exception e) {
				System.out.println("Please enter a player's whole name. Try again.");
				searchByNameMode(backend); 
			}
			
			if(name.equals("exit")) {
				searchSelectionMode(backend); 
			}
			
		}
	}
	
	public static void rankMode(Backend backend) {
		
		@SuppressWarnings("resource")
		Scanner user = new Scanner(System.in);  
		
		while(true) {
			
			// Introduction: 
			System.out.println("--------------------------------------------------------------"); 
			System.out.println("Search by Ranking: ");
			System.out.println("Please enter a Rank (integer) to see the player at that ranking. Press 0 to exit back to Search Selection");
			
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
			
			// TODO: pass selectedRank to Backend. Backend will return player(s) associated with ranking
			
		}
		
		
		
	}

}
