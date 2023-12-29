package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Polyomino1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String val = br.readLine();
        StringBuilder sb = new StringBuilder();

        //변환못한게 있는지 확인
        boolean check = true;
        //X가 몇개나왔는지 확인할 카운트
        int cnt = 0;

        //val을 순회하면서 확인
        for (int i = 0; i < val.length(); i++) {
            String s = val.substring(i, i + 1);
            //만약 "."일 경우 cnt를 확인해서 변환을 시도한다.
            if (s.equals(".")) {
                if (cnt > 0) {
                    int quo = cnt / 4;
                    //cnt가 4로 나눠질경우 몫만큼만 "AAAA"를 반복하면 된다
                    if (cnt % 4 == 0) {
                        for (int j = 0; j < quo; j++) {
                            sb.append("AAAA");
                        }
                    } else if (cnt % 2 == 0) {
                        //cnt가 2로 나눠질 경우 4의 몫만큼만 "AAAA"를 반복
                        for (int j = 0; j < quo; j++) {
                            sb.append("AAAA");
                        }
                        //마지막엔 무조건 "BB"가 나온다
                        sb.append("BB");
                    } else {
                        //cnt가 4,2로 나눠지지 않는 경우 변환불가
                        check = false;
                        break;
                    }
                }

                //변환작업을 수행했다면 cnt 초기화
                cnt = 0;
                //"."를 append
                sb.append(".");
            }else {
                //"."이 아니라면 cnt++;
                cnt++;
            }
        }


        //마지막 cnt 확인후 변환
        if (cnt > 0) {
            int quo = cnt / 4;
            if (cnt % 4 == 0) {
                for (int j = 0; j < quo; j++) {
                    sb.append("AAAA");
                }
            } else if (cnt % 2 == 0) {
                for (int j = 0; j < quo; j++) {
                    sb.append("AAAA");
                }
                sb.append("BB");
            } else {
                check = false;
            }
        }

        if (check) {
            System.out.println(sb);
        }else {
            System.out.println(-1);

        }


    }


}
