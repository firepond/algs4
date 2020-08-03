package autogenerate;

import java.io.*;

public class MarkdownGenerator {

    public static void main(String[] args) {
        for (int i = 2; i <= 10; i++) {
            File f = new File("./documents/Sorting/Exercise" + i + ".md");
            try {
                FileWriter s = new FileWriter(f);
                s.append("### ALGS4 Exercise 2.1." + i);
                s.append("\n\n");
                s.flush();
                s.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}