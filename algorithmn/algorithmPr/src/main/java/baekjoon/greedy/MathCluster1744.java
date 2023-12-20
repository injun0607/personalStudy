package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 *
 */
public class MathCluster1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus_nums = new ArrayList<>();
        ArrayList<Integer> minus_nums = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                plus_nums.add(num);
            }else{
                minus_nums.add(num);
            }

        }

        Collections.sort(plus_nums, Collections.reverseOrder());
        Collections.sort(minus_nums);

        int sum = 0;
        boolean check = true;
        int plus_i = 0;
        while (plus_i < plus_nums.size()) {
            //남은개수가 두개보다 적거나 && 다음에 나오는 숫자가 1이거나 && 현재숫자가 1이면 더하기를 해준다.
            if (plus_i + 1 < plus_nums.size() && plus_nums.get(plus_i+1) > 1 && plus_nums.get(plus_i) > 1) {
                sum += plus_nums.get(plus_i) * plus_nums.get(plus_i + 1);
                plus_i += 2;

            }else{
                sum += plus_nums.get(plus_i);
                plus_i+=1;
            }
        }

        int minus_i = 0;
        while (minus_i < minus_nums.size()) {
            //음수인 경우에는 남은숫자가 한개인 경우만 생각하면 된다(두개이상일때는 무조건 곱하는게 좋음)
            if (minus_i + 1 < minus_nums.size()) {
                sum += minus_nums.get(minus_i) * minus_nums.get(minus_i + 1);
                minus_i += 2;
            }else{
                sum += minus_nums.get(minus_i);
                minus_i += 1;
            }
        }

        System.out.println(sum);

    }
}
