package testReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSandDFS7076 {

    /**
     * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만,
     * 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
     * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
     * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
     *
     * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
     * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     *
     * 입력
     * 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수,
     * N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
     * 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
     * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
     *
     * 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
     *
     * 출력
     * 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약,
     * 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
     * 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
     * @param args
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] simul = new int[n][m];

        Queue<Pair> queue = new LinkedList<>();

        //그래프그리기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                simul[i][j] = num;

                if(num == 1){
                    queue.add(new Pair(j, i, 0));
                    visited[i][j] = true;
                }
            }
        }

        final int[] dx = {0,0,-1,1};
        final int[] dy = {-1,1,0,0};
        int result = 0;

        while(!queue.isEmpty()){
            Pair node = queue.poll();

            for(int k = 0 ; k<4; k++){
                int nextX = node.x + dx[k];
                int nextY = node.y + dy[k];
                int prev = node.prev;

                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n){
                    continue;
                }

                if(graph[nextY][nextX] != 0 || visited[nextY][nextX]){
                    continue;
                }

                queue.add(new Pair(nextX, nextY,prev+1));
                visited[nextY][nextX] = true;
                simul[nextY][nextX] = 1;

            }

            result = Math.max(result, node.prev);

        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(simul[i][j] == 0){
                    result = -1;
                    break;
                }
            }
        }

        System.out.println(result);


    }

    public static class Pair{

        int x;
        int y;

        int prev;

        public Pair(int x, int y, int prev){
            this.x = x;
            this.y = y;
            this.prev = prev;
        }


    }

}
