import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Scanner;

public class FileReader  {
	
	String filename;
	Comparator comparator;
	DefaultMap<Character, Student> hashMap;
	
	public FileReader(String name)  {
		// Constructor for the filereader
		this.filename = name;
		hashMap = new MyHashMap<>(10,this.comparator);
		

	}
	
	public void createHeap() throws FileNotFoundException {
        //Method to read input.txt using FileInputStream and putting the student entries to the hashMap
		FileInputStream input = new FileInputStream(filename);
		Scanner sc = new Scanner(input);
		while (sc.hasNextLine()) {
			String[] data = sc.nextLine().split(",");
			Character section = data[1].charAt(0);
			String name = data[0];
			double marks = Double.parseDouble(data[2]);
			Student student = new Student(name,section,marks);
			hashMap.put(section, student);
		}
		sc.close();
		
	}
	
	public Student getMaxOfSection(char section) {
		//Method that returns a maximum scoring student's record given the section
		Student maxStudent = hashMap.get(section);
		return maxStudent;
	}
	


}
