package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LaundryHouse2720 {
    public static void main(String[] args) throws IOException {
        int[] arr = {25, 10, 5, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> vals = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int val = Integer.parseInt(br.readLine());
            vals.add(val);
        }


        for (int i = 0; i < cnt; i++) {
            Integer val = vals.get(i);
            int[] coins = new int[4];
            for (int j = 0; j < coins.length; j++) {
                coins[j] = val / arr[j];
                val %= arr[j];
            }
            for (int coin : coins) {
                System.out.print(coin+" ");
            }
            System.out.println();
        }


    }
}
