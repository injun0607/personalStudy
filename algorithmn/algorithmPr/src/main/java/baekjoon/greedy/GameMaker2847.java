package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameMaker2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
        }

        int result = 0 ;

        //배열의 마지막 인덱스 부터 확인 하기위해 마지막 인덱스에서 -1부터 시작해서 거꾸로 순회한다.
        for (int i = cnt-2; i >= 0 ; i--) {
            if (arr[i] >= arr[i + 1]) {
                //배열값을 저장할 임시값
                int temp = arr[i];
                //앞의 배열에 담겨있는 수보다 -1작아야함
                arr[i] = arr[i + 1] - 1;
                //원래 담겨있던 수랑 비교해서 result 카운트
                result += temp - arr[i];
            }
        }

        System.out.println(result);
    }
}
