package com.sample;

public class EnvtVariables {

	public static void main(String[] args) {
		java.util.Properties props = System.getProperties();
		String ide, classPath = "" + props.get("java.class.path");
		System.out.println("OS: " + props.get("os.name") + " "
				+ props.get("os.version"));
		System.out.println("Java: " + props.get("java.vendor") + " "
				+ props.get("java.version"));
		
		if (classPath.contains("eclipse")) {
			ide = "eclipse";
		} else {
			ide = "Unknown";
		}
		System.out.println("IDE: " + ide);
		System.out.println("Secret code: " + Math.abs(ide.hashCode() % 10000));
	}
}
