package testReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준문제 1260번
 <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고,
 단지에 번호를 붙이려 한다.
 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고,
 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 */
public class BFSandDFS2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int INF = Integer.MAX_VALUE;

        final  int[] dx = {0, 0, -1, 1};
        final  int[] dy = {-1, 1, 0, 0};

        int[][] graph = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        List<Integer> resultList = new ArrayList<>();




        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                //그래프 그리기
                int num = line.charAt(j) - '0';
                graph[i][j] = num;
                visited[i][j] = false;
            }
        }

        Queue<Pair> queue;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] == 1 && !visited[i][j]){
                    //여기가 startNode
                    int cnt = 1;
                    queue = new LinkedList<>();
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;

                    while(!queue.isEmpty()){
                        Pair poll = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextX = poll.x + dx[k];
                            int nextY = poll.y + dy[k];

                            //범위 벗어난경우
                            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n){
                                continue;
                            }

                            //방문한곳이거나 못가는경우
                            if(graph[nextX][nextY] == 0 || visited[nextX][nextY]){
                                continue;
                            }

                            queue.add(new Pair(nextX, nextY));
                            visited[nextX][nextY] = true;
                            cnt++;
                        }
                    }
                    resultList.add(cnt);
                }

            }

        }

        Collections.sort(resultList);

        System.out.println(resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }

    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
