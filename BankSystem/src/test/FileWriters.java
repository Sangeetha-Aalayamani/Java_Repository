package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 * 
 * @author sangeetha
 *
 */
public class FileWriters {
	
	private static String FILENAME = "d:\\file.txt";
	
	public static void main(String... args) throws IOException,
			NameNotFoundException {

		// Getting the output stream of the file writing
		File f = new File(FILENAME);
		FileOutputStream fos = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		String eName = null;
		String designation = null;
		
		try {
			
			fos = new FileOutputStream(f);
			pw = new PrintWriter(fos);
			
			// BufferedReader to take the input from the console
			br = new BufferedReader(new InputStreamReader(System.in));

			// Writing the user input to the file
			System.out.println("Enter Employee Name: ");
			eName = br.readLine();

			System.out.println("Enter Your Designation is: ");
			designation = br.readLine();
			//write to file
			pw.write("Entered Employee Name is: " + eName+"\n");
			pw.write("Entered Designation  is: " + designation);
			
			System.out.println("File writing has been done successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			pw.flush();
			fos.close();
			pw.close();
		}
	}
}