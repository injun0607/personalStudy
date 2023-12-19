package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser1439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String value = br.readLine();
        int[] result = new int[2];

        //처음 나오는 숫자
        String pre_val = value.substring(0,1);

        //처음 나오는 숫자를 체크
        if (pre_val.equals("0")) {
            result[0]++;
        }else{
            result[1]++;
        }

        //끝까지 순회하면서 바뀌는 시기 바뀌는 숫자 카운트 체크
        for (int i = 1; i < value.length(); i++) {
            String checkVal = value.substring(i, i + 1);
            if (!pre_val.equals(checkVal)) {
                int tNum = Integer.parseInt(checkVal);
                result[tNum]++;
                pre_val = checkVal;
            }
        }

        //숫자가 적은 것을 출력
        if (result[0] > result[1]) {
            System.out.println(result[1]);
        }else{
            System.out.println(result[0]);
        }

    }

}
