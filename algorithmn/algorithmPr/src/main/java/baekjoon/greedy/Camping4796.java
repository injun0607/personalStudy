package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 해당 기간내에 연속된 캠핑을 했을시 나머지 일수 만큼 쉬고나서 할 수있다.
 */
public class Camping4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;
        int n = 1;
        while (true) {
            String value = br.readLine();
            if (value.equals("0 0 0")) {
                break;
            }

            st = new StringTokenizer(value, " ");
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int sum = (V / P) * L;
            if (V % P > L) {
                sum += L;
            }else{
                sum += V % P;
            }

            System.out.printf("Case %d: %d",n,sum);
            System.out.println();
            n++;

        }



    }



}
