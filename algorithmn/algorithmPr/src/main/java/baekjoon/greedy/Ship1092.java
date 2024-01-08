package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ship1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ship_cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> ship_weights = new ArrayList<>();
        for (int i = 0; i < ship_cnt; i++) {
            ship_weights.add(Integer.parseInt(st.nextToken()));
        }

        int box_cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < box_cnt; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(ship_weights, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        if (boxes.get(0) > ship_weights.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        //박스가 없을때까지 반복
        while (!boxes.isEmpty()) {
            //옮기려는 박스 인덱스
            int box_idx = 0;
            //크레인들을 모두 순회하면서 박스 인덱스랑 확인
            for (int i = 0; i < ship_weights.size(); i++) {
                //박스인덱스가 box.size랑 같다는것은 모든 박스를 든건
                if (box_idx == boxes.size()) {
                    break;
                }
                //현재박스랑 크레인무게랑 비교해서 박스가 가볍다면 크레인으로 제거
                if (boxes.get(box_idx) <= ship_weights.get(i)) {
                    boxes.remove(box_idx);
                }else{
                    box_idx++;
                }
            }
            //크레인들을 한번순회한것은 결과값이 +1 되는것
            result++;

        }
        System.out.println(result);
    }

}
