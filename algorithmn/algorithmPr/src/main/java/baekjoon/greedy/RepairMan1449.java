package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 다음 수리지점이 현재 지점에서 테이프로 연결이 가능하다면
 */

public class RepairMan1449 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        ArrayList<Integer> fixPoints = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cnt; i++) {
            fixPoints.add(Integer.parseInt(st.nextToken()));
        }


        //수리지점을 내림차순 정렬
        Collections.sort(fixPoints, Collections.reverseOrder());

        int pre_fixPoint = fixPoints.get(0);
        int result = 1;

        for (int i = 1; i < cnt; i++) {
            int fixPoint = fixPoints.get(i);
            int val = pre_fixPoint - fixPoint;

            //만약 테이프의 길이보다 길거나 같다면 테이프를 한개 추가해야한다.
            if (val >= length) {
                pre_fixPoint = fixPoint;
                result++;
            }

        }

        System.out.println(result);



    }
}
