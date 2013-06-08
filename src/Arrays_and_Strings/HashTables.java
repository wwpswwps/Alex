package Arrays_and_Strings;

import java.util.HashMap;

public class HashTables {
	public static HashMap<Integer, Student> buildMap(Student[] students) {
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		for (Student s : students) map.put(s.getId(), s);
				return map;
	}
	
	//test
	public static void main(String[] args) {
		Student[] stu = new Student[5];
		stu[0] = new Student("Li Lei");
		stu[1] = new Student("Zhang San");
		stu[2] = new Student("Liu Xia");
		stu[3] = new Student("Wang Yu");
		stu[4] = new Student("Chen Sisi");
		
		System.out.println(buildMap(stu));
	}
	
	
}
