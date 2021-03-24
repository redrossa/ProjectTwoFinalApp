//Email: dornala@wisc.edu
//Team: JF Blue
//Role: Frontend Developer
//TA: Xinyi
//Lecturer: Gary Dahl
//Notes to Grader: Frontend Tests from Proj Two Proposal. This is Test2. 
//                 Test would not execute as a single Test class so I made
//                 multiple JUnit Tests (This is Test2) 



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class TestFrontEnd2 {
	/**
	 * Test that Search Selection Mode displays proper greeting
	 */
	@Test 
	public void testSearchSelectionMode() {
		
		PrintStream stdOut = System.out;
		
		try { 
			// Program runs out of Main.java
			// Main main = new Main();
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream)); 
	        String[] csv = new String[] {"nbaplayers.csv"};
	        Backend backend = new Backend(csv); 
	        Frontend.searchSelectionMode(backend);
	        
	        System.setOut(stdOut);
	        String actualWelcomeMessage = outputStream.toString();
	        
	        String realMessage = "--------------------------------------------------------------" + "\n"
	        					+ "Welcome to Search Selection Mode: " + "\n" +
	        					"If you want to search by All-Time NBA Points, press 1." +
	        					"\n" + "If you want to search by your favorite players names, press 2." +
	        					"\n" + "To quit the program, press 0."; 
	        
	        assertEquals(actualWelcomeMessage, realMessage); 
			
		}catch(Exception e) {
			fail("Selection Message Test Failed"); 
		}
	}
}
