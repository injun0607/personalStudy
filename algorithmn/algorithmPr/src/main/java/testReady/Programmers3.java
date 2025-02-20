package testReady;

import java.util.*;

public class Programmers3 {


    public static void main(String[] args) {
        int[][] points = {{3, 2},{6, 4},{4, 7},{1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {4, 2},{4, 3}};

        HashMap<Integer, ArrayList<int[]>> wayMap = new HashMap<>();
        HashMap<Integer, ArrayList<int[]>> visitedWayMap = new HashMap<>();
        List<Pair> wayLst = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        int answer = 0;
        for(int i = 0 ; i< routes.length; i++){
            int[] route =  routes[i]; //4,2
            int startPoint = route[0]; //4
            int endPoint = route[1]; //2

            int[] start =  points[startPoint - 1]; //3
            int[] end = points[endPoint - 1]; //0

            int startX = start[1]; //4
            int startY = start[0]; //1

            int endX = end[1]; // 2
            int endY = end[0]; // 3
            if(wayLst.isEmpty()){
                wayLst.add(new Pair(startX, startY,0));
            }else{
                for(Pair way : wayLst){
                    if(way.x == startX && way.y == startY){
                        way.add(0);
                    }else{
                        wayLst.add(new Pair(startX, startY, 0));
                    }
                }
            }





            if(wayMap.containsKey(0)){
                ArrayList<int[]> wayPointList = wayMap.get(0);
                for(int[] wayPoint : wayPointList){
                    if(startX == wayPoint[1] && startY == wayPoint[0]){
                        if(visitedWayMap.containsKey(0)){

                        }else{

                        }
                    }
                }
            }else{

            }


            visitedWayMap.computeIfAbsent(0,k->new ArrayList<int[]>()).add(start);



            int nextX = startX; //4
            int nextY = startY; //1
            int cnt = 1;
            //4방향 체크 필요

            while(nextX != endX || nextY != endY){

                if(nextY < endY){
                    nextY +=1;
                }else if(nextY > endY){
                    nextY -= 1;
                }else if(nextX < endX){
                    nextX += 1;
                }else{
                    //nextX> endX
                    nextX -= 1;
                }

                int[] wayPoint = {nextY, nextX};
                if(wayMap.containsKey(cnt)){
                    // 충돌 경로인지 확인
                    ArrayList<int[]> wayPointList = wayMap.get(cnt);
                    for(int[] way : wayPointList){
                        //이미 비슷한길이 있으면 체크
                        if(way[0] == wayPoint[0] && way[1] == wayPoint[1]){
                            if(visitedWayMap.containsKey(cnt)){
                                continue;
                            }else{
                                ArrayList<int[]> visitedWayList = new ArrayList<>();
                                visitedWayList.add(wayPoint);
                                visitedWayMap.put(cnt, visitedWayList);
                                answer++;
                            }
                        }
                    }
                }else{
                    ArrayList<int[]> newWayList = new ArrayList<>();
                    newWayList.add(wayPoint);
                    wayMap.put(cnt, newWayList);

                }
                cnt++;
            }
        }

        System.out.println(answer);


    }

    public static class Pair{
        int x;
        int y;

        List<Integer> wayStepList = new ArrayList<Integer>();
        public Pair(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            wayStepList.add(cnt);
        }

        public boolean add(int wayStep){
            boolean result = this.wayStepList.contains(wayStep);
            this.wayStepList.add(wayStep);
            return result;
        }

    }

}
