package Arrays_and_Strings;

public class Student {
	public String name;
	public static int ID = 0;
	public int id;
	
	public Student(String name) {
		this.name = name;
		id = ID++;
	}
	
	public int getId() {
		return id;
	}
	
	public void addData(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
}
