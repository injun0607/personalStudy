package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 30인 배수를 판단하는방법은 30으로 나누는법
 * 1.일단 0이없으면 30의 배수는 될수 없다.
 * 2.0 이있다는 가정하에 마지막자리수 0의 제외하고 나머지 자리의 합이 3의 배수가 되어야한다.
 */
public class Thirty10610 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] numCnt = new int[10];
        int totalNum = 0;
        for (int i = 0; i < num.length(); i++) {
            String splitNum = num.substring(i, i + 1);
            int transNum = Integer.parseInt(splitNum);
            numCnt[transNum]++;
            totalNum += transNum;
        }

        String result = "";
        //0이 한번도 안들어왔거나 자리수의 총합이 3의 배수가 아닐때
        if (numCnt[0] == 0 || totalNum % 3 != 0  ) {
            result = "-1";
        }else{
            //가장큰수를 출력 9부터 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                while (numCnt[i] > 0) {
                    numCnt[i]--;
                    sb.append(i);
                }
            }

            result = sb.toString();

        }
        System.out.println(result);


    }


}
