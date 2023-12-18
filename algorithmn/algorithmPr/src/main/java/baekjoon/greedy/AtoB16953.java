package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (B > A) {

            if (B % 2 == 0) {
                B /= 2;
                cnt++;
            } else if (String.valueOf(B).endsWith("1")) {
                //2로 안나눠질때 끝자리가 1인경우
                String a = String.valueOf(B).substring(0,String.valueOf(B).lastIndexOf("1"));
                B = Integer.valueOf(a);
                cnt++;
            }else{
                //도달할수없는경우다
                cnt = -1;
                break;
            }

        }

        //while 조건을 다탔는데 B!=A인경우는 실패다
        if (B != A) {
            cnt = -1;
        }else{
            cnt++;
        }

        System.out.println(cnt);



    }
}
