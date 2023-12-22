package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuitarLine1049 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int[][] guitarLines = new int[cnt][2];
        int[] sixValue = new int[cnt];
        int[] oneValue = new int[cnt];


        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sixth = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            sixValue[i] = sixth;
            oneValue[i] = one;
        }

        Arrays.sort(sixValue);
        Arrays.sort(oneValue);


        int sum = 0;
        int quo = num / 6;
        int red = num % 6;

        //여섯개 묶음의 최소합이 개별 보다 작은 경우
        if (quo * sixValue[0] < oneValue[0] * quo * 6) {
            sum += quo * sixValue[0];
        }else{
            //개별이 큰경우
            sum += oneValue[0] * quo * 6;
        }
        
        
        //개별이 더작은 경우
        if (sixValue[0] > red * oneValue[0]) {
            sum += red * oneValue[0];
        }else{
            //여섯개 묶음 더 작은 경우
            sum += sixValue[0];
        }


        System.out.println(sum);

    }
}
