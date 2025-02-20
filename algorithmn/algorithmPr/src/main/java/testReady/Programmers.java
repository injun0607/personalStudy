package testReady;

public class Programmers {


    public static void main(String[] args) {


        int answer = 0;

        int[] schedules = {700, 800, 900};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}
                ,{800, 801, 805, 800, 759, 810, 809}
                ,{1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;


        for (int i = 0; i < schedules.length; i++) {
            int startTime = schedules[i];
            int[] timelog = timelogs[i];

            int curDay = startday;

            for (int j = 0; j < 7; j++) {
                //주말지났으면 월요일
                if(curDay > 7){
                    curDay = 1;
                }
                //해당날짜출근시간
                int time = timelog[j];

                //10분넘었고 토,일요일 아닐때
                if(time > startTime + 10 && curDay != 6 && curDay != 7){
                    break;
                }

                if(j == 6){
                    answer++;
                }
                curDay++;
            }

        }

        System.out.println(answer);

    }

    public static class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;


            for (int i = 0; i < schedules.length; i++) {
                int startTime = schedules[i];
                int[] timelog = timelogs[i];

                int curDay = startday;


                for (int j = 0; j < 7; j++) {

                    //주말지났으면 월요일
                    if(curDay > 7){
                        curDay = 1;
                    }
                    //해당날짜출근시간
                    int time = timelog[j];

                    //10분넘었고 토,일요일 아닐때(지각한상황)
                    int limitTime = startTime + 10;
                    if(limitTime % 100 > 59){
                        limitTime += 41;
                    }
                    if(time > limitTime && curDay != 6 && curDay != 7){
                        break;
                    }

                    if(j == 6){
                        answer++;
                    }

                    curDay++;
                }

            }

            return answer;
        }
    }
}
