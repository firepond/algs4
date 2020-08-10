package searching.symboltables;

import edu.princeton.cs.algs4.*;

public class FrequencyCounter {

    // Do not instantiate.
    private FrequencyCounter() { }

  
    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = 1;
        ST<String, Integer> st = new ST<String, Integer>();
        In in= new In("./algs4-data/leipzig1M.txt");
        // compute frequency counts
        while (!in.isEmpty()) {
            String key = in.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }
}
