import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

public class MyHashMapTest {
	
	private FileReader filereader;
	private DefaultMap<Character, Student> testMap; // use this for basic tests

	@Before
	public void setUp() throws FileNotFoundException {
		filereader = new FileReader("src/input.txt");
		filereader.createHeap();
	}



	//Write testcase for checking max score of 2 sections
	@Test
	public void testMap(){
		testMap = new MyHashMap<>();
		testMap.put("A".charAt(0), new Student("Ana", "A".charAt(0), 100));
		System.out.println(testMap.get("A".charAt(0)).section);
		assertEquals(true,testMap.containsKey("A".charAt(0)));


	}

	@Test 
	public void testcase1() throws FileNotFoundException{
		setUp();
		Character section = "A".charAt(0);
		Student maxofA = filereader.getMaxOfSection(section);
		System.out.print(maxofA.name);
	}

	
}
