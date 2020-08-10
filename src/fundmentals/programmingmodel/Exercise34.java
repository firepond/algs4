package fundmentals.programmingmodel;

/**
 * @author firepond
 * algs4 exercise 1.1.34
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Exercise34 {

	public static void main(String[] args) {
		printMax("doubles.txt");

		printMin("doubles.txt");

		printMedian("doubles.txt");

		printKthSmallset("doubles.txt", 3);

		printSquareSum("doubles.txt");

		printMean("doubles.txt");

		printOverMeanPercentage("doubles.txt");

		printAscending("doubles.txt");

		printRandomly("doubles.txt");
	}

	public static void printMax(String file) {
		In in = new In(file);

		double x = in.readDouble();
		double max = x;

		while (!in.isEmpty()) {
			x = in.readDouble();
			if (x > max)
				max = x;
		}

		in.close();

		StdOut.println("max: " + max);
	}

	public static void printMin(String file) {
		In in = new In(file);

		double x = in.readDouble();
		double min = x;

		while (!in.isEmpty()) {
			x = in.readDouble();
			if (x < min)
				min = x;
		}

		in.close();

		StdOut.println("min: " + min);
	}

	public static void printKthSmallset(String file, int k) {
		In in = new In(file);

		double[] result = new double[k];

		for (int i = 0; i < k; i++) {
			result[i] = in.readDouble();
		}
		Arrays.sort(result);

		while(!in.isEmpty()) {
			double x = in.readDouble();
			result = make_new_array(result, x);
		}

		in.close();

		StdOut.println(k + "th smallest: " + result[k - 1]);

	}

	public static void printMedian(String file) {
		In in = new In(file);

		double[] numbers = in.readAllDoubles();
		in.close();

		Arrays.sort(numbers);

		double median;
		if (numbers.length % 2 == 0) {
			median = (numbers[numbers.length / 2] + numbers[numbers.length / 2 - 1]) / 2;
		} else {
			median = numbers[numbers.length / 2];
		}

		StdOut.println("median: " + median);
	}

	public static void printSquareSum(String file) {
		In in = new In(file);

		double sum = 0;
		double x;

		while (!in.isEmpty()) {
			x = in.readDouble();
			sum += x * x;
		}

		in.close();

		StdOut.println("Square sum:" + sum);
	}

	public static void printMean(String file) {
		In in = new In(file);

		double sum = 0;
		double x;
		int count = 0;

		while (!in.isEmpty()) {
			x = in.readDouble();
			sum += x;
			count++;
		}

		in.close();

		if (count == 0) {
			count++;
		}

		StdOut.println("Square sum:" + sum / count);
	}

	public static void printOverMeanPercentage(String file) {
		In in = new In(file);
		double[] numbers = in.readAllDoubles();
		in.close();

		double sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}

		double mean = sum / numbers.length;

		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > mean) {
				count++;
			}
		}

		if (numbers.length == 0) {
			StdOut.println("Percentage of numbers over mean:0");
		} else {
			StdOut.println("Percentage of numbers over mean:" + (double) count / numbers.length);
		}
	}

	public static void printAscending(String file) {
		In in = new In(file);
		double[] numbers = in.readAllDoubles();
		in.close();

		Arrays.sort(numbers);

		StdOut.print(numbers[0]);
		for (int i = 0; i < numbers.length; i++) {
			StdOut.print(", " + numbers[i]);
		}
		StdOut.println();
	}

	public static void printRandomly(String file) {
		In in = new In(file);
		double[] numbers = in.readAllDoubles();
		in.close();

		StdRandom.setSeed(1145141919);
		StdRandom.shuffle(numbers);

		StdOut.print(numbers[0]);
		for (int i = 0; i < numbers.length; i++) {
			StdOut.print(", " + numbers[i]);
		}
		StdOut.println();
	}

	public static double[] make_new_array(double[] arr, double x) {
		int len = arr.length;
		double[] arr1 = new double[len + 1];

		for (int i = 0; i < len; i++) {
			arr1[i] = arr[i];
		}
		arr1[len] = x;

		Arrays.sort(arr1);

		double[] arr2 = new double[len];
		for (int i = 0; i < len; i++) {
			arr2[i] = arr1[i];
		}

		return arr2;
	}

}
