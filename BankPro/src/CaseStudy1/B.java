package CaseStudy1;

public class B extends A{

	public String grade(int percent) {
		
		return percent>=75?"A+":percent>=60?"A":percent>=40?"B":"C";
	}

}
