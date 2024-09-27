package com.main.studentService;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.main.Student;

public class StudentService {
	public List<Student> sortByAge(List<Student> s) {
		Collections.sort(s, new A());
		return s;
	}

	

class A implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getAge() - s2.getAge();
	}
	
}

public Map<String, Integer> GroupByCity(List<Student> list) {
		Map<String,Integer> map = new HashMap<>();
		for(Student s : list) {
			if(!map.containsKey(s.getCity())) {
				map.put(s.getCity(), 1);
			}
			else {
				int temp = map.get(s.getCity()) + 1;
				map.put(s.getCity(), temp);
			}
		}
		return map;
	}
}