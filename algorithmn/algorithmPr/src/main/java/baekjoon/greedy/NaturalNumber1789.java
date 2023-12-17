package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NaturalNumber1789 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        Long num = Long.parseLong(number);

        int cnt = 0;

        //해당 자연수까지 수를 빼보자
        for (long i = 1; i <= num; i++) {
            num -= i;
            cnt++;
            if (num <= i) {
                break;
            }

        }

        System.out.println(cnt);




    }
}
