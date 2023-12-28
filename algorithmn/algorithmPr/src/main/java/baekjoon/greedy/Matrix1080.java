package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A 3x3행렬의 원소들과 B의 3x3 행렬의 원소중 차이가 가장 많은 부분을 뒤집는다.
 */
public class Matrix1080 {

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

        int prev = 0;
        for (int i = 0; i < width - 3; i++) {

            for (int j = 0; j < length - 3; j++) {

                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {

                    }
                }
            }
        }



    }
}
