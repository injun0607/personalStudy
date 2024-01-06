package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CupHolder {
    public static void main(String[] args) throws IOException {

        //양끝에는 한개씩 있고
        //LL은 두명 S는 한명
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String chairs = br.readLine();
        //두명 좌석의 표시를 A로 변환
        chairs = chairs.replace("LL", "A");
        //컵홀더의 총개수
        int holder_cnt = (chairs.length()) - 1 + 2;
        //A좌석의 개수
        int a_cnt = 0;
        //B좌석의 개수
        int s_cnt = 0;
        for (int i = 0; i < chairs.length(); i++) {
            char chr = chairs.charAt(i);
            if (chr == 'A') {
                a_cnt++;
            }else{
                s_cnt++;
            }
        }

        //앉은 사람수
        int result = a_cnt * 2 + s_cnt;
        if (result > holder_cnt) {
            //사람수가 컵홀더 수보다 많다면 컵홀더수
            System.out.println(holder_cnt);
        }else{
            //사람수가 적다면 사람
            System.out.println(result);
        }

    }
}
