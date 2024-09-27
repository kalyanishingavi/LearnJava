package com.finalkeyword;

public class Finalvar {
	public static void main(String[] args) {
		New R = new N();
		R.display();
	}
}

class New{	
	// if class is final then line 18 CF
	final int val =10 ; 
	// val =14                   // CF
	void display() {		    // if display method is final then line 19 CF
		System.out.println(val);
	}
}

class N extends New{
	void display() {
		System.out.println("display N");
	}
}