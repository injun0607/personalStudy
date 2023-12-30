package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MakeBig2812 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int lenght = Integer.parseInt(st.nextToken());

        //제거해야할 카운트
        int N = Integer.parseInt(st.nextToken());
        String val = br.readLine();

        //숫자를 담을 deque
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < val.length(); i++) {

            //현재 순회하는 숫ㅈ자
            char v = val.charAt(i);
            int currency = Integer.parseInt(String.valueOf(v));

            //만약 배열이 비어있지않고, 제거해야할 카운트가 남아있고, deque의 마지막숫자가 현재 숫자보다 작다면
            while (!deque.isEmpty() && N > 0 && deque.getLast() < currency) {
                //제거후 카운트 -
                deque.removeLast();
                N--;
            }
            //현재 순회중인수를 넣기
            deque.add(currency);
        }

        //만약 제거해야할 카운트가 남아있으면
        while (N > 0) {
            //제거해준다.
            deque.removeLast();
            N--;
        }



        StringBuilder sb = new StringBuilder();
        for (Integer integer : deque) {
            sb.append(integer);
        }

        System.out.println(sb);


    }



}
