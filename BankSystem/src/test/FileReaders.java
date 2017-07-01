package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * @author sangeetha
 *
 */
public class FileReaders {

	private static String FILENAME = "d:\\file.txt";

	public static void main(String[] args) {

		FileReader reader = null;
		BufferedReader bufferedReader = null;
		String contents;

		try {
			reader = new FileReader(FILENAME);
			bufferedReader = new BufferedReader(reader);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			while ((contents = bufferedReader.readLine()) != null) {
				System.out.println(contents);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

}
