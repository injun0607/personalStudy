package testReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ConferenceRoom1931 {

    /**
     * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
     * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
     * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
     * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
     *
     * 입력
     * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
     * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
     * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
     *
     * 출력
     * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        List<CustomDate> arr = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new CustomDate(start, end));
        }

        Collections.sort(arr,(a,b) -> {
            if (a.endTime == b.endTime) {
                return Integer.compare(a.startTime, b.startTime);
            }
            return Integer.compare(a.endTime, b.endTime);
        });

        int result = 1;
        int end = arr.get(0).endTime;

        for (int i = 1; i < arr.size(); i++) {
            if(end <= arr.get(i).startTime){
                end = arr.get(i).endTime;
                result++;
            }
        }

        System.out.println(result);

    }

    public static class CustomDate{
        int startTime;
        int endTime;

        public CustomDate(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

}
