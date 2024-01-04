package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Stock11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < total_cnt; i++) {
            int cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            //주식 가격들을 담을 배열
            int[] values = new int[cnt];

            for (int j = 0; j < cnt; j++) {
                values[j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            int max_val = 0;
            for (int j = values.length - 1; j >= 0; j--) {
                int val = values[j];
                if (max_val < val) {
                    max_val = val;
                } else {
                    result += max_val - val;
                }

            }

            System.out.println(result);


//            //주식 최대가격
//            int max_val = 0;
//            //주식들을 담는다
//            for (int j = 0; j < cnt; j++) {
//                int value = Integer.parseInt(st.nextToken());
//
//                values[j] = value;
//
//                if (max_val < value) {
//                    max_val = value;
//                }
//            }
//
//            //최대 가격까지 담을 만큼 배열을 만든다
//            int[] value_cnt = new int[max_val+1];
//            //주식들을 순회하면서 가격의 개수를 담는다.
//            for (int value : values) {
//                value_cnt[value]++;
//            }
//
//            //산 가격
//            long buy_price = 0;
//            //산 갯수
//            int buy_cnt = 0;
//
//            //결과값
//            long result = 0;
//
//            //주식 가격을 순회하면서 앞의 가격대에 남은 카운트 개수가 있다면
//            //비싼 가격이 남아있는 상황
//            for (int value : values) {
//                //주식을 사는지 여부
//                boolean is_buy = false;
//                //개수를 한개씩뺀다
//                value_cnt[value]--;
//                for (int j = value+1; j < value_cnt.length; j++) {
//                    //이 앞에 더 비싼주식이 있으면 산다
//
//                    if (value_cnt[j] > 0) {
//                        is_buy = true;
//                        break;
//                    }
//                }
//
//                //주식을 사야하는 상황이면 사고
//                if (is_buy) {
//                    buy_price += value;
//                    buy_cnt++;
//                }
//                else{
//                    //아니면 결과값업데이트
//                    result += buy_cnt * value - buy_price;
//                    buy_cnt = 0;
//                    buy_price = 0;
//                }
//
//            }
//
//            System.out.println(result);

        }


    }
}
