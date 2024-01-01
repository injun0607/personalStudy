package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreadHouse3109 {

    public static final int BLOCK = 1;
    public static final int GO = 0;

    //결과값
    public static int result = 0;

    //해당 루프에서 결과값을 찾았는지 여부
    public static boolean fin = false;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        //지도
        int[][] map = new int[height][width];

        for (int i = 0; i < height; i++) {
            String val = br.readLine();
            for (int j = 0; j < width; j++) {
                String check_val = String.valueOf(val.charAt(j));
                if (check_val.equals(".")) {
                    map[i][j] = GO;
                } else{
                    map[i][j] = BLOCK;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            //시작위치는 항상 map[i][0] 에서시작
            //fin은 루프시작시 초기화
            fin = false;
            recursive(i,0,map,width);
        }

        System.out.println(result);

    }

    public static void recursive(int y, int x, int[][] map, int width){

        //도달지점이 목적지를 벗어났다면 리턴
        if (y >= map.length || y < 0) {
            return;
        }

        //도달지점을 찾은 경로라면 return;
        if(fin == true){
            return;
        }

        //현재 지점이 막혀있는 곳이라면 return;
        if (map[y][x] == BLOCK) {
            return;
        }

        //방문표시
        map[y][x] = 1;

        //도달지점이면 retrun
        if(x == width-1){
            //해당루프 결과값  찾음 fin 업데이트 및 결과값 업데이트
            fin = true;
            result +=1;
            return;
        }





        //다음칸으로 갈 수 있는 곳을 (y-1)(x+1) (y)(x+1) (y+1)(x+1) 을 탐색한다.
        recursive(y-1, x+1, map, width);
        recursive(y, x + 1, map, width);
        recursive(y+1,x+1,map,width);

    }
}
