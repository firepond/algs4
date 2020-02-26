package stacksandqueues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

import java.io.File;

/**
 * @author firepond algs4 exercise 1.3.43
 */

public class ListingFiles {
    private int directories;
    private int files;

    private static String ordinaryFilePrefix = "│   ";
    private static String lastSubFilePrefix = "    ";

    private static String ordinraySubFileStart = "├── ";
    private static String lastSubFileStart = "└── ";

    public static void tree(String filePath) {
        File file = new File(filePath);
        ListingFiles.tree(file);
    }

    public static void tree(File file) {
        ListingFiles l = new ListingFiles();
        StdOut.println(file.getName());
        if (file.isDirectory()) {
            l.directories++;
            File[] subFiles = file.listFiles();
            int length = subFiles.length - 1;
            if (length >= 0) {
                for (int i = 0; i < length; i++) {
                    l.subTree(subFiles[i], ordinaryFilePrefix);
                }
                l.subTree(subFiles[length], lastSubFilePrefix);
            }
        } else {
            l.files++;
        }
        StdOut.println();
        StdOut.println(l.directories + " directories, " + l.files + " files");
    }

    private String processPreifix(String prefix) {
        String processesPrefix = prefix;
        if (prefix.endsWith(ordinaryFilePrefix)) {
            processesPrefix = prefix.substring(0, prefix.length() - 4) + ordinraySubFileStart;
        } else {
            processesPrefix = prefix.substring(0, prefix.length() - 4) + lastSubFileStart;
        }
        return processesPrefix;
    }

    private void subTree(File file, String prefix) {
        String processedPrefix = processPreifix(prefix);
        StdOut.println(processedPrefix + file.getName());
        if (file.isDirectory()) {
            directories++;
            File[] subFiles = file.listFiles();
            int length = subFiles.length - 1;
            if (length >= 0) {
                for (int i = 0; i < length; i++) {
                    subTree(subFiles[i], prefix + ordinaryFilePrefix);
                }
                subTree(subFiles[length], prefix + lastSubFilePrefix);
            }

        } else {
            files++;
        }
    }

    public static void printByQueue(File file) {
        Queue<File> files = new Queue<File>();
        Queue<Integer> depths = new Queue<Integer>();
        files.enqueue(file);
        depths.enqueue(0);
        while (!files.isEmpty()) {
            File f = files.dequeue();
            int depth = depths.dequeue();
            StdOut.println(fileString(f, depth));
            if (f.isDirectory()) {
                for (File ff : f.listFiles()) {
                    files.enqueue(ff);
                    depths.enqueue(depth + 1);
                }
            }
        }
    }

    private static String fileString(File file, int depth) {
        String str = "";
        for (int i = 0; i < depth; i++)
            str += "     ";
        return str + "- " + file.getName();
    }

    public static void main(String[] args) {
        File file = new File(".");
        ListingFiles.tree(file);
    }

}
