package autogenerate;

import java.io.*;

public class MarkdownGenerator {

    public static void main(String[] args) {
        for (int i = 19; i <= 20; i++) {
            File f = new File("./src/elementarysorts/Exercise" + i + ".md");
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