package testReady;

public class Programmers4 {
    public static void main(String[] args) {
        int[] diffs = {1, 99999, 100000, 99995};
        int[] times = {9999, 9001, 9999, 9001};
        long limit = 3456789012L;
        System.out.println(Solution.solution(diffs, times, limit));

    }


    static class Solution {
        public static int solution(int[] diffs, int[] times, long limit) {
            int answer = 0;
            //각 레벨마다 누적합을 구해서 (diffs의 순서대로) 사용하기
            //이진탐색으로 진행하면 될까?

            for (int level = 1; level < 100001; level++) {
                Long[] addLst = new Long[diffs.length + 1];
                Long passedTime = 0L;
                //문제들 돌면서 확인할것
                for (int j = 0; j < diffs.length; j++) {
                    int diff = diffs[j];
                    int time = times[j];
                    addLst[j + 1] = (long) time;

                    if (level < diff) {
                        int multiple = diff - level;
                        passedTime += (addLst[j]+ addLst[j+1]) * multiple + time;
                    } else {
                        passedTime += time;
                    }

                    if (passedTime > limit) {
                        break;
                    }
                }

                if (passedTime <= limit) {
                    answer = level;
                    break;
                }
            }
            return answer;
        }

    }
}