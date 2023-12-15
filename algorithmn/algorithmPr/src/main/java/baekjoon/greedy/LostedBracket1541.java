package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostedBracket1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        Integer startNum = 0;


        if (value.contains("-")) {
            //- 기호가 나오고 다음 -기호가 나올때까지 더하기를 실행한다.
            String[] minusSplit = value.split("-");
            for (int i = 0; i < minusSplit.length; i++) {
                String numValue = minusSplit[i];
                int plusNum = 0;

                if(numValue.contains("+")){
                    String[] split = numValue.split("\\+");
                    for (String num : split) {
                        int n = Integer.parseInt(num);
                        plusNum += n;
                    }

                }else{
                    plusNum = Integer.parseInt(numValue);
                }

                if (i == 0) {
                    //만약 처음 지점이라면 startNum을 설정해준다.
                    startNum = plusNum;
                }else{
                    startNum -= plusNum;
                }
            }

        }else{
            String[] plusSplit = value.split("\\+");
            for (String numValue : plusSplit) {
                startNum += Integer.parseInt(numValue);
            }
        }


        System.out.println(startNum);

    }
}
