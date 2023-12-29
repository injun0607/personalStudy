package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A 3x3행렬의 원소들과 B의 3x3 행렬의 원소중 차이가 가장 많은 부분을 뒤집는다.
 */
public class Matrix1080 {

    public static int RESULT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[][] A = new int[width][length];
        int[][] B = new int[width][length];
        //A배열 정보 생성
        for (int i = 0; i < width; i++) {
            String val = br.readLine();
            for (int j = 0; j < length; j++) {
                A[i][j] = Integer.parseInt(val.substring(j, j + 1));
            }
        }

        //B배열 정보 생성
        for (int i = 0; i < width; i++) {
            String val = br.readLine();
            for (int j = 0; j < length; j++) {
                B[i][j] = Integer.parseInt(val.substring(j, j + 1));
            }
        }

        //한번 바꿀때 3x3의 행렬을 바꾸니 상한선은 최대값 -3까지
        for (int i = 0; i <= width - 3; i++) {
            for (int j = 0; j <= length - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    //3x3의 배열을 모두 바꾸는 메소드
                    changeNum(i, j, A, B);
                }
            }
        }

        //값이 모두 같은지 확인하는 값
        boolean check = false;

        //끝까지 순회해서 값이 한개라도 다른게있다면 check 활성
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (A[i][j] != B[i][j]) {
                    check = true;
                }
            }
        }

        if (check) {
            //check활성시 값이 -1
            System.out.println(-1);
        }else{
            //아니면 최종결과 출력
            System.out.println(RESULT);
        }



    }

    //0->1 , 1->0 으로 바꿔주는 메소드
    public static void changeNum(int i, int j,int[][] A, int[][] B) {
        if (A[i][j] != B[i][j]) {
            RESULT++;
            for (int m = i; m < i + 3; m++) {
                for (int n = j; n < j + 3; n++) {
                    if (A[m][n] == 0) {
                        A[m][n] = 1;
                    }else{
                        A[m][n] = 0;
                    }
                }
            }
        }

    }


}
