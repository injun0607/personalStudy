package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NewRecruit1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] results = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] score = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                //서류시험점수
                score[j][0] = Integer.parseInt(st.nextToken());
                //면접시험점수
                score[j][1] = Integer.parseInt(st.nextToken());
            }
            //서류시험 점수순으로 정렬
            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int min = Integer.MAX_VALUE;
            int result = 0;
            //최소점수가 갱신될때마다 합격자수가 증가한다.
            for (int j = 0; j < n; j++) {
                if (score[j][1] < min) {
                    result++;
                    min = score[j][1];
                }
            }
            results[i] = result;
        }

        for (int result : results) {
            System.out.println(result);
        }


    }
//    static ArrayList<Integer> results = new ArrayList<>();
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int cnt = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < cnt; i++) {
//            int n = Integer.parseInt(br.readLine());
//            StringTokenizer st;
//            int[][] score = new int[n][2];
//            PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.doc));
//
//            //이차배열에 담기
//            for (int j = 0; j < n; j++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                int doc = Integer.parseInt(st.nextToken());
//                int interview = Integer.parseInt(st.nextToken());
//                pq.add(new Info(doc, interview));
//
//            }
//
//            //서류점수 낮은사람들이 인터뷰점수도 낮으면 탈락
//            int result = 0;
//            recursive(pq,result);
//
//
//        }
//
//        for (Integer result : results) {
//            System.out.println(result);
//        }
//    }
//
//    static class Info{
//        public int doc;
//        public int interview;
//
//        public Info(int doc, int interview) {
//            this.doc = doc;
//            this.interview = interview;
//        }
//
//    }
//
//    public static void recursive(PriorityQueue<Info> pq,int result) {
//        if (pq.isEmpty()) {
//            results.add(result);
//            return;
//        }
//
//        Info comparingInfo = pq.poll();
//        int comparingInterview = comparingInfo.interview;
//        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.doc));
//        //끝까지 순회를 했다면 해당 사람은 합격자이므로 ++
//        while (!pq.isEmpty()) {
//            Info comparedInfo = pq.poll();
//            if (comparedInfo.interview < comparingInterview) {
//                priorityQueue.add(comparedInfo);
//            }
//        }
//        result++;
//        recursive(priorityQueue, result);
//    }


}
