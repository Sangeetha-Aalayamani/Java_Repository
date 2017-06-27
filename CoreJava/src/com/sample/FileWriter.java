package com.sample;

import java.io.BufferedWriter;
import java.io.IOException;
/**
 * 
 * @author sangeetha
 *
 */
public class FileWriter {

	public static void main(String[] args) {

		String fileName = "d:\\test.txt";
		java.io.FileWriter out;
		BufferedWriter bw = null;
		try {
			out = new java.io.FileWriter(fileName);
			bw = new BufferedWriter(out);
			bw.write("<HTML>");
			bw.write("<BODY BGCOLOR='CYAN'>TEST");
			bw.write("</BODY>");
			bw.write("</HTML>");
			System.out.println("File written successfully");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
