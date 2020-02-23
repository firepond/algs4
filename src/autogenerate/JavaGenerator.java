package autogenerate;

import java.io.*;

public class JavaGenerator {

    public static void main(String[] args) {

        String className = "Exercise";
        String packageName = "analysisofalgorithms";

        String packageClause = "package " + packageName + ";\n\n";
        String importClause = "import edu.princeton.cs.algs4.StdOut;\n\n";
        String classClause = "public class ";

        String main = "    public static void main(String[] args)";
        String print = "        StdOut.println(\"Exercises makes perfect\");\n";

        String part = "1.4";

        String func = "    public static void funcName(int a) {\n" + "    \n" + "    }\n";

        for (int i = 12; i <= 12; i++) {
            File f = new File("./src/" + packageName + "/" + className + i + ".java");
            String commnets = "/**\n * @author firepond \n * algs4 exercise " + part + "." + i + "\n */\n\n";

            try {
                FileWriter s = new FileWriter(f);
                s.append(packageClause);
                s.append(importClause);
                s.append(commnets);
                s.append(classClause + className + i + " {\n\n");
                s.append(main + " {\n");
                s.append(print);
                s.append("\n");
                s.append("    }\n\n");
                s.append(func);
                s.append("}\n");
                s.flush();
                s.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}