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
		comparator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				double s1Mark = s1.marks;
				double s2Mark = s2.marks;
				int comp;
				if (s1Mark > s2Mark) {
					comp = 1;
				}
				else if (s1Mark <s2Mark) {
					comp = -1;
				}
				else {
					comp = 0;
				}
				return comp;
			}
		};
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
		if (!hashMap.containsKey(section)) {
			return null;
		}

		Student maxStudent = hashMap.get(section);
		return maxStudent;
	}
	


}
