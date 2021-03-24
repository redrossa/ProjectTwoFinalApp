//--== CS400 File Header Information ==--
//Name: Mayank Dornala
//Email: dornala@wisc.edu
//Team: JF Blue
//Role: Frontend Developer
//TA: Xinyi
//Lecturer: Gary Dahl
//Notes to Grader: Frontend Tests from Proj Two Proposal

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class TestFrontEnd {

	/**
	 * Tests Welcome Screen Does Welcome Screen Display Proper Greeting?
	 */
	@Test
	public void testMainMenu() {
		PrintStream stdOut = System.out;
		// InputStream stdIn = System.in; 
		
		try { 
			// Program runs out of Main.java
			// Main main = new Main();
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream)); 
	        String[] csv = new String[] {"nbaplayers.csv"};
	       
	        Main.main(csv);
	        
	        System.setOut(stdOut);
	        String actualWelcomeMessage = outputStream.toString();
	        
	        String realMessage = "Welcome to the NBA Player Catalog!" + "\n"
	        					+ "Press Enter to continue to Search Selection Mode: "; 
	        
	        assertEquals(actualWelcomeMessage, realMessage); 
			
		}catch(Exception e) {
			
		}
	}
	
	/**
	 * Tests that when User presses "Enter Key"
	 */
	@Test 
	public void testMainMenuEnter() {
		
	}

}
