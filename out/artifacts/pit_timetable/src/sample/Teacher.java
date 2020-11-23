package sample;

import java.util.ArrayList;

public class Teacher {
	int id;
	String name;
	ArrayList<String> subject;
	ArrayList<String> cn;
	ArrayList<String> subc;


	public ArrayList<String> getSubc() {
		return subc;
	}

	public void setSubc(ArrayList<String> subc) {
		this.subc = subc;
	}

	int assigned;
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

	public ArrayList<String> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<String> subject) {
		this.subject = subject;
	}

	public ArrayList<String> getCn() {
		return cn;
	}

	public void setCn(ArrayList<String> cn) {
		this.cn = cn;
	}
}
