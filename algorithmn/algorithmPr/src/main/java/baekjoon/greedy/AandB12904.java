package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AandB12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sb = new StringBuilder(T);
        //문자열이 같아질때까지 반복
        while (sb.toString().length() > S.length()) {
            //끝이 A라면 그대로제거
            if (sb.toString().endsWith("A")) {
                sb.setLength(sb.length()-1);
            }else{
                //B라면 제거후 문자열 반전
                sb.setLength(sb.length()-1);
                sb.reverse();
            }
        }

        //종료후 같다면 출력
        if (sb.toString().equals(S)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

}
