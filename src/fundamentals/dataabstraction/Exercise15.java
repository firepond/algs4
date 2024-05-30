package fundamentals.dataabstraction;

/**
 * @author firepond
 * algs4 exercise 1.2.15
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Exercise15 {

	public static void main(String[] args) {
		String filePath = "./algs4-data/tinyW.txt";

		int[] ints = readAllInts(filePath);

		for (int i : ints) {
			StdOut.println(i);
		}
	}

	public static int[] readAllInts(String fileName) {
		In in = new In(fileName);
		String input = in.readAll();

		String[] words = input.split("\\s+");

		int[] intList = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			intList[i] = Integer.parseInt(words[i]);
		}

		return intList;
	}
}
