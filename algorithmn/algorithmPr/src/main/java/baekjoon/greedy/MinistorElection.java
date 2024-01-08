package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinistorElection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> votes = new PriorityQueue<>(Comparator.reverseOrder());

        int temp = 0;

        for (int i = 0; i < cnt; i++) {
            if (i == 0) {
                temp = Integer.parseInt(br.readLine());
            } else{
                votes.add(Integer.parseInt(br.readLine()));
            }
        }
        int result = 0;


        //기준수가 맨위의 투표수보다 클때까지 반복
        if(!votes.isEmpty()){
            while (temp <= votes.peek() ) {
                Integer top_vote = votes.poll();
                if (top_vote >= temp) {
                    top_vote -= 1;
                    temp++;
                    result++;
                    votes.add(top_vote);
                }
            }
        }

        System.out.println(result);

    }
}
