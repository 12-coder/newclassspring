package net.javaguides.springboot.database;
public class IdNotFoundException extends Exception{
	String s;
	public IdNotFoundException(String s){
		this.s=s;
	}
	public String getMessage() {
		return s;
	}
}
