package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UCPC15904 {
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        char[] UCPC = {'U', 'C', 'P', 'C'};
        String val = br.readLine();

        int idx = 0;
        for (int i = 0; i < val.length(); i++) {
            //UCPC를 만들었다는 뜻
            if (idx == 4) {
                break;
            }

            //해당 인덱스에 해당하는 적절한 단어가 있다면 idx++
            if (val.charAt(i) == UCPC[idx]) {
                idx++;
            }

        }

        //4보다 크다면 UCPC가 만들어졌다는 뜻
        System.out.println((idx >= 4)? "I love UCPC" : "I hate UCPC");

    }

}
