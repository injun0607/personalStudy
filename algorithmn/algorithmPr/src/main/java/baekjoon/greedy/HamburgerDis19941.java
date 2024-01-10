package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HamburgerDis19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] table = br.readLine().toCharArray();
        //햄버거를 먹었는지 체크여부
        boolean[] check = new boolean[cnt];

        for (int i = 0; i < cnt; i++) {
            if (table[i] == 'H') {
                check[i] = true;
            }else{
                check[i] = false;
            }
        }

        int result = 0;

        for (int i = 0; i < cnt; i++) {
            int chr = table[i];
            //현재  사람이라면
            if (chr == 'P') {
                //제일 왼쪽 최대거리
                int min = i - K;
                //제일 오른쪽 최대거리
                int max = i + K;

                //햄버거 먹었는지 여부
                boolean is_eat = false;
                //공통적으로 먹으면 햄버거 먹은여부 체크
                //왼쪽 최대거리가 테이블 범위라면 해당 위치부터 순회
                if (min >= 0) {
                    for (int j = min; j < i; j++) {
                        if (check[j]) {
                            result++;
                            check[j] = false;
                            is_eat = true;
                            break;
                        }
                    }
                }else{
                    //왼쪽 최대거리가 테이블 범위밖이라면 0부터 시작
                    for (int j = 0; j < i; j++) {
                        if (check[j]) {
                            result++;
                            check[j] = false;
                            break;
                        }
                    }
                }

                //먹은경우는 순회할 필요X
                if (!is_eat) {
                    //오른쪽 최대거리가 테이블 범위내라면 최대거리까지 순회
                    if (max < cnt) {
                        for (int j = i+1; j <= max; j++) {
                            if (check[j]) {
                                result++;
                                check[j] = false;
                                break;
                            }
                        }
                    }else{
                        //오른쪽 최대거리가 테이블 범위밖이라면 테이블 오른쪽 끝까지 순회
                        for (int j = i+1; j < cnt; j++) {
                            if (check[j]) {
                                result++;
                                check[j] = false;
                                break;
                            }
                        }
                    }
                }

            }
        }




        System.out.println(result);




    }
}
