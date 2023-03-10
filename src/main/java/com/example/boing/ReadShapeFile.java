package com.example.boing;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */


	private static Queue<ClosedShape> readLineByLine(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue
		while (in.hasNextLine()) {
			String data = in.nextLine();
			System.out.println(data);

		}
		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.

		File inputFile = new File(filename);
	    //you may want a Scanner here?
		Scanner in = null;
		try {
			in = new Scanner(inputFile);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + filename);
			System.exit(0);
		}
		in.close();
	    return ReadShapeFile.readLineByLine(in);
	    
	}
}
