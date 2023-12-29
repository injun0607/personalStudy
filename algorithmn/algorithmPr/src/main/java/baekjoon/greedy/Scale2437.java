package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Scale2437 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] values = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(values);
        //비교할 자연수
        int cur = 1;

        //주어진 숫자배열을 순회
        for (int value : values) {
            //만약 비교 대상의 자연수가 배열의 수보다 작다면 값을 찾은것
            if (cur < value) {
                break;
            }else {
                //아니라면 배열의 수를 더해주면서 덧셈으로 만들 수 있는 수를 확장한다.
                cur += value;
            }
        }

        System.out.println(cur);


    }
}
