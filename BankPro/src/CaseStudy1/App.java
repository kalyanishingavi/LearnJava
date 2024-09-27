package CaseStudy1;

public class App {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name = "Gaurav";
		s1.mark_secured = 150;
		
		int percent;
		
		B b = new B();
		percent = b.percent(s1.mark_secured, 200);
		System.out.println("Percentage = "+ percent);
		
		System.out.println("Grade = "+b.grade(percent));
		
	}
	
}
