package cs146F20.tang.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.io.*;

class ShuffleDataTest {
	
	ShuffleData test;

	@BeforeEach
	void setUp() {
		test = new ShuffleData();
	}
	
	@Test
	void test() {
		
		test.readDataFromFile();
		test.shuffle();
		test.writeDataToFile();
		
		// compares shuffled data file and target data file to make sure it matches
		try {
			BufferedReader Out = new BufferedReader (new FileReader ("TangVanessaShuffled.txt"));
			BufferedReader In = new BufferedReader (new FileReader ("Target3.txt"));
			String expectedLine;
			while ((expectedLine = In.readLine ()) != null) {
				String actualLine = Out.readLine ();
				assertEquals (expectedLine, actualLine);
			}
			
			Out.close();
			In.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
