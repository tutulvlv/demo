package com.xdailiao.test;


public class TestUser extends User{
	
	public TestUser(){
		System.out.println("2");
	}
	public void p() {
		System.out.println("3");
	}
	public static void main(String[] args) {
		
	}

}
class User {
	public User(){
		System.out.println("1");
	}
	public void p() throws Exception{
		throw new Exception();
	}
}