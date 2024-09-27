package com.threadDemo;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClass {
	public static void main(String[] args) throws Exception, ExecutionException {
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		StudentService ss = new StudentService();
		
		Future<Student> res = es.submit(ss);
		System.out.println(res.get());
		
		es.shutdown();
		
	}
}

class StudentService implements Callable<Student>{

	public Student get() {
		return new Student("Harry Potter",99);
	}
	
	@Override
	public Student call() throws Exception {
		// TODO Auto-generated method stub
		return get();
	}
	
}

class Student{
	
	String name;
	
	int marks;
	
	public Student(String string, int i) {
		this.name = string;
		this.marks = i;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}

}