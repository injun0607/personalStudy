package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 가장 가치가 높은걸 담으면 된다.
 * 해당무게에 담을 수 있는 가장 가치가 높은것
 * 무게는 최소 차이 나는 걸로 담으면 된다(해당무게에 제일 적절한 가방)/ 가장 가치가 높게나가는보석에 가장 가벼운 무게
 *
 */
public class JewelryRobber1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewelries = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            jewelries[i][0] = Integer.parseInt(st.nextToken());
            jewelries[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bags = new int[K];
        boolean[] bagCheck = new boolean[K];
        Arrays.fill(bagCheck,true);

        for (int i = 0; i < K; i++) {
            int bag = Integer.parseInt(br.readLine());
            bags[i] = bag;
        }
        //가벼운 무게부터 정렬
        Arrays.sort(bags);
        //가치가 높은것부터 정렬
        Arrays.sort(jewelries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int weight = jewelries[i][0];
            for (int j = 0; j < K; j++) {
                if (weight < bags[j] && bagCheck[j]) {
                    bagCheck[j] = false;
                    sum += jewelries[i][1];
                }
            }
        }


        System.out.println(sum);






    }
}
