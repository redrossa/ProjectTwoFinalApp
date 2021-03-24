//--== CS400 File Header Information ==--
//Name: Mayank Dornala
//Email: dornala@wisc.edu
//Team: JF Blue
//Role: Frontend Developer
//TA: Xinyi
//Lecturer: Gary Dahl
//Notes to Grader: Frontend Tests from Proj Two Proposal. This is Test2. 
//                 Test would not execute as a single Test class so I made
//                 multiple JUnit Tests (This is Test 1)

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class TestFrontEnd1 {

	/**
	 * Tests Welcome Screen Does Welcome Screen Display Proper Greeting?
	 */
	@Test
	public void testMainMenu() {
		PrintStream stdOut = System.out;
		
		try { 
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream)); 
	        String[] csv = new String[] {"nbaplayers.csv"};
	        // Program runs out of Main
	        Main.main(csv);
	        
	        System.setOut(stdOut);
	        String actualWelcomeMessage = outputStream.toString();
	        
	        String realMessage = "Welcome to the NBA Player Catalog!" + "\n"
	        					+ "Press Enter to continue to Search Selection Mode: "; 
	        
	        assertEquals(actualWelcomeMessage, realMessage); 
	        
		}catch(Exception e) {
			fail("Welcome Message Test Failed"); 
		}
	}
	
	

}
