package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Change14916 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());

        int f_quo = val / 5;
        int result = 0;
        //5로 나누어떨어지지 않는 경우
        if (val % 5 != 0) {
            //5의 몫을 최대부터 순회한다
            for (int i = f_quo; i >= 0; i--) {
                //5의 배수를 최대한 뺀다음 나머지를 2로 나눌수 있는지 확인한다.
                int tempN = val - i * 5;
                if (tempN % 2 == 0) {

                    //2로 나누어지면 i + 2로 나누어진 몫이 최소값
                    int t_quo = tempN / 2;
                    result = i + t_quo;
                    break;
                }
            }

            //5와 2로 해결 할 수 없는 경우
            if (result == 0) {
                result = -1;
            }
        }else{
            //5로 나누어 떨어지면 몫이 최소값
            result = f_quo;
        }

        System.out.println(result);


    }

}
