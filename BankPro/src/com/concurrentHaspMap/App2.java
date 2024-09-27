package com.concurrentHaspMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class App2 {
	
	public static void main(String[] args) {
		
		Student s1 = new Student(1,"harry",86,"Mumbai");
		Student s2 = new Student(2,"ron",70,"pune");
		Student s3 = new Student(3,"hermoine",94,"Mumbai");
		Student s4 = new Student(4,"draco",84,"pune");
		Student s5 = new Student(5,"snape",91,"Mumbai");
		Student s6 = new Student(6,"neville",72,"pune");
		Student s7 = new Student(7,"dumbledor",98,"Mumbai");
		
		List<Student> list = new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7));
		
		ConcurrentHashMap<String,List<Student>> map = new ConcurrentHashMap<>(); 
		ConcurrentHashMap<String,Long> resultMap = new ConcurrentHashMap<>(); 
		
		List<String> listCity = list.stream().map(s->s.getCity()).distinct().collect(Collectors.toList());
		System.out.println(listCity);
		listCity.forEach(c->{
			map.compute(c, (k,v)-> list.stream().filter(s->s.getCity().equals(c)).collect(Collectors.toList()));
		});
		System.out.println(map);
		
//		listCity.forEach(c->{
//			resultMap.compute(c, (k,v)->list.stream().filter(s->s.getCity().equals(c).count()));
//		});
	}

}


class Student{
	private int id;
	private String name;
	private int age;
	private String city;
	
	public Student(int id, String name, int age, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	
	
}