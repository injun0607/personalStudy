package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 중요 아이디어:
 * 매번 최소의 값으로 더해주어야한다.
 * ex)1 2 2 2 같은 경우 -> 1+2 2+2 -> 3 + 4 -> 7 = 14
 */
public class CardSort1715 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int cnt = Integer.parseInt(br.readLine());
//        long[] cards = new long[cnt];
//        long[] cardSum = new long[cnt + 1];
//        for (int i = 0; i < cnt; i++) {
//            cards[i] = Integer.parseInt(br.readLine());
//        }
//
//        //정렬후
//        Arrays.sort(cards);
//        //누적합으로 해결
//        for (int i = 0; i < cards.length; i++) {
//            cardSum[i + 1] = cards[i] + cardSum[i];
//        }
//
//
//        if (cnt == 1) {
//            System.out.println(0);
//        } else if (cnt == 2) {
//            System.out.println(cardSum[cnt]);
//        } else {
//            System.out.println(cardSum[cnt - 1] + cardSum[cnt]);
//        }
//
//
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue();
        long sum = 0;
        for (int i = 0; i < cnt; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        while (pq.size() != 1) {
            Long a = pq.poll();
            Long b = pq.poll();

            long tempSum = a + b;
            sum += tempSum;
            pq.add(tempSum);
        }
        System.out.println(sum);


    }

}
