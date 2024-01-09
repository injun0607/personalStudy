package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleInput2828 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());

        int[] apples = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            apples[i] = Integer.parseInt(br.readLine());
        }


        int apple_idx = 0;
        //최소범위
        int min_range = 1;
        //최대 범위
        int max_range = min_range + M;
        int result = 0;
        while (apple_idx < apples.length) {
            //받을 사과
            int apple = apples[apple_idx];
            //사과가 범위 안에있으면 다음 사과를 받는다.
            if (min_range <= apple && apple < max_range) {
                apple_idx++;
            }else if(apple < min_range){
                //최소 범위보다 작을때는 범위를 밑으로 내려야한다.
                min_range--;
                max_range--;
                result++;
            } else if (max_range <= apple) {
                //최대 범위보다 클때는 범위를 위로 올려야 한다.
                max_range++;
                min_range++;
                result++;
            }


        }

        System.out.println(result);




    }


}
