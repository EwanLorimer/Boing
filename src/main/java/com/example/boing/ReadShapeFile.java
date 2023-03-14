//package com.example.boing;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
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


public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	private static ClosedShape createOval(String[] shapeParameters) {
		int insertionTime = Integer.parseInt(shapeParameters[1]);
		int x = Integer.parseInt(shapeParameters[2]);
		int y = Integer.parseInt(shapeParameters[3]);
		int vx = Integer.parseInt(shapeParameters[4]);
		int vy = Integer.parseInt(shapeParameters[5]);
		int width = Integer.parseInt(shapeParameters[7]);
		int height = Integer.parseInt(shapeParameters[7]);
		Color colour = Color.rgb(Integer.parseInt(shapeParameters[8]),
				Integer.parseInt(shapeParameters[9]), Integer.parseInt(shapeParameters[10]));
		boolean isFilled = Boolean.parseBoolean(shapeParameters[6]);

		ClosedShape newOval = new Oval(insertionTime, x, y, vx, vy, width, height, colour, isFilled);

		return newOval;
	}
	private static ClosedShape createCircle(String[] shapeParameters) {

		int insertionTime = Integer.parseInt(shapeParameters[1]);
		int x = Integer.parseInt(shapeParameters[2]);
		int y = Integer.parseInt(shapeParameters[3]);
		int vx = Integer.parseInt(shapeParameters[4]);
		int vy = Integer.parseInt(shapeParameters[5]);
		int diameter = Integer.parseInt(shapeParameters[7]);

		Color colour = Color.rgb(Integer.parseInt(shapeParameters[8]),
				Integer.parseInt(shapeParameters[9]), Integer.parseInt(shapeParameters[10]));
		boolean isFilled = Boolean.parseBoolean(shapeParameters[6]);
		ClosedShape newCircle = new Circle(insertionTime, x, y, vx, vy, diameter, colour, isFilled);
		return newCircle;
	}

	private static ClosedShape createRect(String[] shapeParameters) {
		int insertionTime = Integer.parseInt(shapeParameters[1]);
		int x = Integer.parseInt(shapeParameters[2]);
		int y = Integer.parseInt(shapeParameters[3]);
		int vx = Integer.parseInt(shapeParameters[4]);
		int vy = Integer.parseInt(shapeParameters[5]);
		int width = Integer.parseInt(shapeParameters[7]);
		int height = Integer.parseInt(shapeParameters[7]);
		Color colour = Color.rgb(Integer.parseInt(shapeParameters[8]),
				Integer.parseInt(shapeParameters[9]), Integer.parseInt(shapeParameters[10]));
		boolean isFilled = Boolean.parseBoolean(shapeParameters[6]);

		ClosedShape newRect = new Rect(insertionTime, x, y, vx, vy, width, height, colour, isFilled);

		return newRect;
	}

	private static ClosedShape createSquare(String[] shapeParameters) {

		int insertionTime = Integer.parseInt(shapeParameters[1]);
		int x = Integer.parseInt(shapeParameters[2]);
		int y = Integer.parseInt(shapeParameters[3]);
		int vx = Integer.parseInt(shapeParameters[4]);
		int vy = Integer.parseInt(shapeParameters[5]);
		int side = Integer.parseInt(shapeParameters[7]);

		Color colour = Color.rgb(Integer.parseInt(shapeParameters[8]),
				Integer.parseInt(shapeParameters[9]), Integer.parseInt(shapeParameters[10]));
		boolean isFilled = Boolean.parseBoolean(shapeParameters[6]);
		ClosedShape newSquare = new Square(insertionTime, x, y, vx, vy, side, colour, isFilled);
		return newSquare;
	}


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
			String[] lineSplitArray = data.split(" ");
			switch (lineSplitArray[0]) {
				case "oval":
					shapeQueue.enqueue(createOval(lineSplitArray));
					break;
				case "circle":
					shapeQueue.enqueue(createCircle(lineSplitArray));
					break;
				case "rect":
					shapeQueue.enqueue(createRect(lineSplitArray));
					break;
				case "square":
					shapeQueue.enqueue(createSquare(lineSplitArray));
					break;
				default:
					System.out.println("Invalid Shape");
			}



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
			return ReadShapeFile.readLineByLine(in);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + filename);
			System.exit(0);
		}
		return ReadShapeFile.readLineByLine(in);

	}
}
