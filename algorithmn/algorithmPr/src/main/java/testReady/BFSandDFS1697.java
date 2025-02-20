package testReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSandDFS1697 {


    /**
     * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
     * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
     * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
     *
     * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
     *
     * 출력
     * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == M) {  // 시작 위치와 목표 위치가 같으면 0 출력
            System.out.println(0);
            return;
        }

        int[] way = {-1, 1, 2};
        Queue<Check> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001]; // 0~100000까지 방문 여부 저장

        queue.add(new Check(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Check node = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nextPos;
                if (i == 2) {
                    nextPos = node.pos * way[i]; // 순간이동 처리
                } else {
                    nextPos = node.pos + way[i]; // -1 또는 +1 이동
                }

                if (nextPos < 0 || nextPos > 100000) continue; // 범위를 벗어나면 패스
                if (visited[nextPos]) continue; // 이미 방문한 곳이면 패스

                if (nextPos == M) {  // 목표 지점 도달하면 출력 후 종료
                    System.out.println(node.prev + 1);
                    return;
                }

                queue.add(new Check(nextPos, node.prev + 1));
                visited[nextPos] = true;
            }
        }


    }

    public static class Check{

        int pos;
        int prev;
        public Check(int pos , int prev){
            this.pos = pos;
            this.prev = prev;
        }

    }

}
