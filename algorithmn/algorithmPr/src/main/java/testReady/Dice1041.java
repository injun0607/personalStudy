package testReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Dice1041 {
    /*
    주사위는 위와 같이 생겼다. 주사위의 여섯 면에는 수가 쓰여 있다. 위의 전개도를 수가 밖으로 나오게 접는다.

    A, B, C, D, E, F에 쓰여 있는 수가 주어진다.

    지민이는 현재 동일한 주사위를 N3개 가지고 있다. 이 주사위를 적절히 회전시키고 쌓아서, N×N×N크기의 정육면체를 만들려고 한다.
    이 정육면체는 탁자위에 있으므로, 5개의 면만 보인다.

    N과 주사위에 쓰여 있는 수가 주어질 때, 보이는 5개의 면에 쓰여 있는 수의 합의 최솟값을 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N이 주어진다. 둘째 줄에 주사위에 쓰여 있는 수가 주어진다. 위의 그림에서 A, B, C, D, E, F에 쓰여 있는 수가 차례대로 주어진다.
    N은 1,000,000보다 작거나 같은 자연수이고, 쓰여 있는 수는 50보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 문제의 정답을 출력한다.
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        int one = Math.min(A,F);
        int two = Math.min(B,E);
        int three = Math.min(C,D);

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> dice = new ArrayList<>();
        arr.add(one);
        arr.add(two);
        arr.add(three);

        dice.add(A);
        dice.add(B);
        dice.add(C);
        dice.add(D);
        dice.add(E);
        dice.add(F);


        Collections.sort(arr);
        Collections.sort(dice);
        int third = arr.get(0) + arr.get(1) + arr.get(2);
        int second = arr.get(0) + arr.get(1);
        int first = arr.get(0);


        int ThreeDemesion = third * 4;
        int secondDemension = (((N - 2 ) * 4) + ((N-1) * 4)) * second;
        int firstDemesion = ((N-1) * (N-1) + ((N-2) * 4)) * first;



        if(N == 1){
            System.out.println(dice.get(0) + dice.get(1) + dice.get(2) + dice.get(3) + dice.get(4));
        }else if( N== 2){
            System.out.println(ThreeDemesion + secondDemension);
        }else{
            System.out.println(ThreeDemesion + secondDemension + firstDemesion);
        }








    }

}
