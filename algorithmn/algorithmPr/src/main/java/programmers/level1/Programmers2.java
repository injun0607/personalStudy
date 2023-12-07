package programmers.level1;

/**
 * 문제 : 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다.
 * 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.
 *
 * ["방향 거리", "방향 거리" … ]
 * 예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
 *
 * 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
 * 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
 * 위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
 * 공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.
 *
 * 공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때,
 * 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */
public class Programmers2 {
    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};

        String[] park2 = {"SOO","OXX","OOO"};
        String[] routes2 = {"E 2","S 2","W 1"};

        String[] park3 = {"SXX","XXX","XXX","XXX"};
        String[] routes3 = {"E 2","S 3","W 1"};

//        int[] solution = solution(park, routes);
//        int[] solution2 = solution(park2, routes2);

        int[] solution3 = solution(park3, routes3);
        for (int i : solution3) {
            System.out.println(i);
        }

    }


        public static int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            int height = park.length;
            int width = park[0].length();
            int[][] map = new int[height][width];
            int curX = 0;
            int curY = 0;

            //맵생성
            for (int y = 0; y< height; y++) {
                char[] chars = park[y].toCharArray();
                for (int x = 0 ; x< width;x++){
                    if (chars[x] == 'X') {
                        map[y][x]=1;
                    } else if(chars[x] == 'S'){
                        curY = y;
                        curX = x;
                        map[y][x] = 0;
                    }else{
                        map[y][x] = 0;
                    }
                }
            }


            for (String route : routes) {
                String[] s = route.split(" ");
                String dir = s[0];
                boolean check = true;
                int movement = Integer.valueOf(s[1]);

                if (dir.equals("E")) {
                    int moveCur = curX + movement;

                    if (!(moveCur >= width)) {
                        for (int i = curX; i <= moveCur; i++) {
                            if (map[curY][i] == 1) {
                                check = false;
                                break;
                            }
                        }

                        if (check) {
                            curX = moveCur;
                        }

                    }

                } else if (dir.equals("W")) {
                    //x 축 마이너스
                    int moveCur = curX - movement;

                    if (!(moveCur < 0) ) {
                        for (int i = curX; i >= moveCur; i--) {
                            if (map[curY][i] == 1) {
                                check = false;
                                break;
                            }
                        }

                        if (check) {
                            curX = moveCur;
                        }

                    }

                } else if (dir.equals("N")) {
                    //y축 마이너스
                    int moveCur = curY - movement;
                    if (!(moveCur < 0)) {
                        for (int i = curY; i >= moveCur; i--) {
                            if (map[i][curX] == 1) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            curY = moveCur;
                        }

                    }
                }else{
                    //y축 플러스
                    int moveCur = curY + movement;

                    if (!(moveCur >= height)) {
                        for (int i = curY; i <= moveCur; i++) {
                            if (map[i][curX] == 1) {
                                check = false;
                                break;

                            }
                        }

                        if (check) {
                            curY = moveCur;
                        }

                    }

                }

            }


            answer[0] = curY;
            answer[1] = curX;
            return answer;
    }


}
