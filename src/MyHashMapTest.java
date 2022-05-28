import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

public class MyHashMapTest {
	
	private FileReader filereader;
	private DefaultMap<Integer, Student> testMap; // use this for basic tests

	@Before
	public void setUp() throws FileNotFoundException {
		filereader = new FileReader("src/input.txt");
		filereader.createHeap();
	}


	//Write testcase for checking max score of 2 sections

	@Test 
	public void testcase1() throws FileNotFoundException{
		setUp();
		Character sectionA = "A".charAt(0);
		Student maxofA = filereader.getMaxOfSection(sectionA);
		assertEquals("James",maxofA.name);
		Character sectionB = "B".charAt(0);
		Student maxofB = filereader.getMaxOfSection(sectionB);
		assertEquals("Ria",maxofB.name);
	}

	
}
