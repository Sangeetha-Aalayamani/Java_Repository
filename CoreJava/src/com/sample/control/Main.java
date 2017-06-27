package com.sample.control;
/**
 * 
 * @author sangeetha
 *
 */
public class Main {

	void main() {
		System.out.println("test");
	}
	final public static void main(String... args) {
		System.out.println("Test");
		Main m = new Main();
		m.main();
	}
	
}
