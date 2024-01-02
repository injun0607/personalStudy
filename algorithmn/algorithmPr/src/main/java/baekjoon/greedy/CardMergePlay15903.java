package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardMergePlay15903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = Integer.parseInt(st.nextToken());
        //반복해야하는 수
        int m = Integer.parseInt(st.nextToken());

        long[] nums = new long[cnt];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }

        //몇 번 반복했는지
        int m_cnt = 0;
        /**
         * 1. 작은수부터 정렬한다.
         * 2. 앞의 두자리를 더한다
         * 3. 반복한다.
         */
        while (m_cnt < m) {
            Arrays.sort(nums);
            long num_sum = nums[0] + nums[1];
            nums[0] = num_sum;
            nums[1] = num_sum;
            m_cnt++;
        }

        //결과값을 모두더한다.
        long result = Arrays.stream(nums).sum();
        System.out.println(result);


    }

}
