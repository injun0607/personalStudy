package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InviteMan9237 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        ArrayList<Integer> days = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cnt; i++) {
            days.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(days, Collections.reverseOrder());
        //현재 제일 많이 남은 나무의 날짜
        int result = 0;
        //지난 날짜
        int add = 1;
        for (int i = 0; i < cnt; i++) {
            //낮에 나무를 확인하고 심는다.
            //확인할 나무
            int day = days.get(i);

            //하루가 지났으니 하루를 뺸다
            result--;
            //만약 지금 나무가 제일 많이남은 나무라면 교체
            if (day > result) {
                result = day;
            }

            //나무를 다심으면 저녁이 된다.(하루가간다)
            //날짜 추가
            add++;

        }

        System.out.println(result+add);




    }

}
