package autogenerate;

import java.io.*;

public class MarkdownGenerator {

    public static void main(String[] args) {
        for (int i = 22; i <= 23; i++) {
            File f = new File("./documents/Stacks and Queues/Exercise" + i + ".md");
            try {
                FileWriter s = new FileWriter(f);
                s.append("### ALGS4 Exercise 1.2." + i);
                s.append("\n\n");
                s.flush();
                s.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}