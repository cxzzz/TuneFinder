package ie.dit;

import javax.swing.JFrame;
import java.util.*;


public class Main
{
	void matrixMultiplication()
	{
		Matrix a = new Matrix(4, 5);
		a.identity();
		a.setElement(2, 3, 7);
		a.setElement(3, 1, 2);
		a.setElement(3, 0, 4);

		Matrix b = new Matrix(4, 4);
		b.identity();
		b.setElement(2, 3, 1);
		b.setElement(3, 1, 9);
		b.setElement(3, 0, -7);

		//a.mult(b); // Add b to a. This is like a+= b;

		Matrix c = null;
		// Add b to a, without changing a. Instead create a new matrix and return it
		// This is like c = a + b

		try
		{
			c = Matrix.add(a, b); // How to call a static method
		}
		catch(MatrixException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		finally
		{
			System.out.println("This always happens");
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

	public void editDistance()
	{
		String sa = "BegLiz";
		String sb = "Sassi";
		System.out.println("Edit distance between: " + sa + " and: " + sb + " is " + EditDistance.minimumEditDistance(sa, sb));

		sa = "Games Fleadh";
		sb = "Imagine Cup";
		System.out.println("Edit distance between: " + sa + " and: " + sb + " is " + EditDistance.minimumEditDistance(sa, sb));

		sa = "AAB";
		sb = "ABC";
		System.out.println("Edit distance between: " + sa + " and: " + sb + " is " + EditDistance.minimumEditDistance(sa, sb));



	}

	public void dictionary()
	{

		Dictionary d = new Dictionary();
		// init new scanner
		Scanner in = new Scanner(System.in);
		// user's input string
		String input = "";
		// while user doesn't type quit
		while (!input.equals("quit")) {
			// prompt word from user
			System.out.println("Enter a word or quit: ");
			// user enters word into String input
			input = in.next();
			// if it wasn't the word "quit"
			if (!input.equals("quit")) {
				// see if exist in dictionary
				if (d.findClosest(input).equals(input)) {
					System.out.println("Correct Match");
				} else {
					// if not exist, find closest 10 matches
					String[] result = d.findClosest(input, d.words.size());
					// print out the 10 matches
					for (String s : result) {
						System.out.println(s);
					}
				}
			}
		}
		in.close();
	}
	public void strings()
	{
		String s = "I love Star Trek";

		System.out.println(s.length());
		System.out.println(s.contains("love"));
		System.out.println(s.contains("hate"));
		System.out.println(s.startsWith("I love"));
		System.out.println(s.endsWith("cats"));
		System.out.println(s.equals("Hello"));

		String ss = s.substring(7);

		System.out.println(ss);
		// Incorrect way to compare strings
		if (ss == "Star Trek")
		{
			System.out.println("Same");
		}
		else
		{
			System.out.println("Different");
		}
		// Correct way to compare strings
		if (ss.equalsIgnoreCase("Star Trek"))
		{
			System.out.println("Same");
		}
		else
		{
			System.out.println("Different");
		}

		String star = ss.substring(0, 5);
		System.out.println(star.toUpperCase());

	}

	public void transform()
	{
		try
		{
			Vector v = new Vector(5, 10);
			Matrix trans = Matrix.translation(2, -11);

			System.out.println(trans.transform(v));

			Matrix scale = Matrix.scaling(2, 3);

			System.out.println(scale.transform(v));

			Matrix combined = Matrix.mult(scale, trans);

			System.out.println(combined.transform(v));
		}
		catch(MatrixException e)
		{
			e.printStackTrace();
		}
		finally
		{

		}
	}

	public void tuneFinder()
	{
		JFrame tf  = new TuneFinder();

		tf.setVisible(true);
		tf.setSize(1000, 500);

	}
	public void tuneFinder1()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new TuneFinder1());
	}

	public static void main(String args[])
	{
		Main main = new Main();
		//main.matrixMultiplication();
		main.editDistance();
		//main.strings();
		//main.dictionary();
		//main.transform();
		//main.matrixMultiplication();
		// main.tuneFinder1();
	}
}
