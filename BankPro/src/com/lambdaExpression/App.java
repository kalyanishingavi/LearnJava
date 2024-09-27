package com.lambdaExpression;
interface IPL{
	String getTrophyDetails(String team);
}

public class App {
	public static void main(String[] args) {
		Implementation get = new Implementation();
		System.out.println(get.display(i->i.equals("csk")?"4 tropies" : 
			i.equals("kkr")? "2 tropies" : "No team found"));
		
	}

}

class Implementation{
	
	public String display(IPL ipl) {
		return ipl.getTrophyDetails("csk");
		
	}
}