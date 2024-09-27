package CaseStudy1;

abstract public class A implements Tasks{

	@Override
	public int percent(int marks, int total) {
		int per;
		per = (marks*100)/total;
		return per;
	}


}
