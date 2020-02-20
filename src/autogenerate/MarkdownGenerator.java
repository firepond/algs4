package autogenerate;

import java.io.*;

public class MarkdownGenerator {

    public static void main(String[] args) {
        int todo = 4;
        for (int i = 5; i <= 7; i++) {
            File f = new File("./documents/Analysis Of Algorithms/Exercise" + i + ".md");
            try {
                FileWriter s = new FileWriter(f);
                s.append("### ALGS4 Exercise 1.4." + i);
                s.append("\n\n");
                s.flush();
                s.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}