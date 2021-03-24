//Email: dornala@wisc.edu
//Team: JF Blue
//Role: Frontend Developer
//TA: Xinyi
//Lecturer: Gary Dahl
//Notes to Grader: Frontend Tests from Proj Two Proposal. This is Test2. 
//                 Test would not execute as a single Test class so I made
//                 multiple JUnit Tests (This is Test3) 



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class TestFrontEnd3 {
	
	/**
	 * Test that Rank Mode displays proper greeting
	 */
	@Test 
	public void testRankMode() {
		
		PrintStream stdOut = System.out;
		
		try { 
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream)); 
	        String[] csv = new String[] {"nbaplayers.csv"};
	        Backend backend = new Backend(csv); 
	        Frontend.rankMode(backend);
	        
	        System.setOut(stdOut);
	        String actualWelcomeMessage = outputStream.toString();
	        
	        String realMessage = "--------------------------------------------------------------" + "\n"
	        					+ "Search by All Time Points: " + "\n" +
	        					"Please enter a Points Value. Press 0 to exit back to Search Selection" +
	        					"\n" + "For Example, to see Kareem Abdul-Jabbar, enter 38387 as that is "
	        							+ "the number of points he scored in his career."; 
	        
	        assertEquals(actualWelcomeMessage, realMessage); 
			
		}catch(Exception e) {
			fail("Selection Message Test Failed"); 
		}
	}
}

