package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultitabScheduling1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 사용 가능한 콘센트 수
        int tabCnt = Integer.parseInt(st.nextToken());
        // 전기용품 개수
        int cnt = Integer.parseInt(st.nextToken());
        // 전기용품 사용 순서
        int[] order = new int[cnt];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cnt; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        // 현재 콘센트에 꽂혀 있는 전기용품
        Set<Integer> plugged = new HashSet<>();
        int result = 0;

        for (int i = 0; i < cnt; i++) {
            int currentAppliance = order[i];

            // 콘센트에 자리가 있거나 이미 꽂혀있는 경우
            if (plugged.size() < tabCnt || plugged.contains(currentAppliance)) {
                plugged.add(currentAppliance);
                continue;
            }

            // 교체할 전기용품 선택
            int toRemove = -1;
            int maxDistance = -1;
            //콘센트에 있는 플러그들을 순회하면서
            //가장 먼거리에 있는것을 바꾼다
            for (int pluggedAppliance : plugged) {
                //만약 뒤에 사용할일이 없다면 맥스밸류
                int distance = Integer.MAX_VALUE;
                for (int j = i + 1; j < cnt; j++) {
                    if (order[j] == pluggedAppliance) {
                        distance = j;
                        break;
                    }
                }


                if (distance > maxDistance) {
                    maxDistance = distance;
                    toRemove = pluggedAppliance;
                }
            }

            // 교체하고 현재 전기용품 꽂기
            plugged.remove(toRemove);
            plugged.add(currentAppliance);
            result++;
        }

        System.out.println(result);
    }


}
