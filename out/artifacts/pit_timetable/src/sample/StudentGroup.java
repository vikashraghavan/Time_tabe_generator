package sample;

import java.util.ArrayList;

public class StudentGroup {
	public int id;
	public String name;
	public ArrayList<String> subject;
	public int nosubject;
	public int teacherid[];
	public ArrayList<Integer> hours;
	
	public StudentGroup() {


		teacherid=new int[10];
	}

	public void setHours(ArrayList<Integer> hours) {
		this.hours = hours;
	}


	public ArrayList<String> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<String> subject) {
		this.subject = subject;
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

	public int getNosubject() {
		return nosubject;
	}
	public void setNosubject(String snosubject) {
		int nosubject=Integer.parseInt(snosubject);
		this.nosubject = nosubject;
	}
	public int[] getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int[] teacherid) {
		this.teacherid = teacherid;
	}

	public ArrayList<Integer> getHours() {
		return hours;
	}
}
