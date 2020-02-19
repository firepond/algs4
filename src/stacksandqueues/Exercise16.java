package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.In;

/**
 * @author firepond 
 * algs4 exercise 1.3.16
 */

public class Exercise16 {

    private static Date[] readDates(String fileName) {
		In in = new In(fileName);
		Queue<Date> queue = new Queue<>();

		while(!in.isEmpty()) {
			queue.enqueue(new Date(in.readString()));
		}

		int n = queue.size();
		Date[] dates = new Date[n];
		
		for (int i = 0; i < n; i++) {
			dates[i] = queue.dequeue();
		}

		return dates;
	}
	
	public static void main(String[] args) {
		String dateFilePath = args[0];
		Date[] dates = readDates(dateFilePath);
		
		for (Date date : dates) {
			StdOut.println(date);
		}
	}

}
