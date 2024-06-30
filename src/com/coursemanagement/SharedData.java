package com.coursemanagement;

public class SharedData {
	private static String userRole;
	private static String name;
	
	
	public static void setUserRole(String selectedUserRole) {
		userRole = selectedUserRole;
	}
	public static String getUserRole() {
		return userRole;
	}
	
	public static void setName(String callname) {
		name = callname;
	}
	public static String getName() {
		return name;
	}
}
