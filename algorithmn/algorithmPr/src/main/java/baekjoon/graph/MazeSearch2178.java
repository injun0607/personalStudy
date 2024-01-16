package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearch2178 {

    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        //미로 상태
        int[][] maze = new int[y][x];
        //시작점부터 미로들의 거리
        int[][] maze_short = new int[y][x];

        Queue<Pair> queue = new LinkedList<>();

        //상하좌우 이동할때 생기는 차이
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        //데이터입력
        for (int i = 0; i < y; i++) {
            String val = br.readLine();
            for (int j = 0; j < val.length(); j++) {
                int num = Integer.parseInt(val.substring(j, j + 1));
                maze[i][j] = (num == 1) ? 1 : 0;
                maze_short[i][j] = INF;
            }
        }

        queue.add(new Pair(0, 0));
        maze_short[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nx = pair.pair_x + dx[i];
                int ny = pair.pair_y + dy[i];

                //범위내 아웃
                if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    continue;
                }

                //갈수없는곳이거나 방문한 곳이면
                if (maze[ny][nx] == 0 || maze_short[ny][nx] != INF) {
                    continue;
                }


                //모두 통과했다면
                queue.add(new Pair(nx, ny));
                maze_short[ny][nx] = maze_short[pair.pair_y][pair.pair_x] + 1;

            }


        }


        System.out.println(maze_short[y-1][x-1]);



    }

    public static class Pair{
        int pair_x;
        int pair_y;

        public Pair(int pair_x, int pair_y) {
            this.pair_x = pair_x;
            this.pair_y = pair_y;
        }



    }

}
