package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Difference5with6_2864 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        String a = st.nextToken();

        String b = st.nextToken();

        String max_a = a.replace("5", "6");
        String max_b = b.replace("5", "6");


        String min_a = a.replace("6", "5");
        String min_b = b.replace("6", "5");


        int max = Integer.parseInt(max_a) + Integer.parseInt(max_b);
        int min = Integer.parseInt(min_a) + Integer.parseInt(min_b);

        System.out.print(min + " " + max);



    }


}
