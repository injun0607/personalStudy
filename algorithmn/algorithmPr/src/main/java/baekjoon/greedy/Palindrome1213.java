package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 알파벳순으로 정렬해서
 * 처음부터 순회하면서 첫째자리와 끝자리를 채워가면서 단어를 채운다.
 * 제일 마지막이 아닌데 2로 나누어지는 단어의 개수가 없다면 회문이 아님
 */
public class Palindrome1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String wordval = br.readLine();
        char[] words = wordval.toCharArray();

        int[] alp = new int[26];
        int totalLength = 0;

        //char은 ASCII코드로 숫자로 변환이 가능하기에 숫자배열로 글자가 몇개인지 표현가능하다
        for (char word : words) {
            int idx = word - 'A';
            alp[idx]++;
            totalLength++;
        }

        //회문을 만들 문자배열
        String[] s = new String[totalLength];

        //앞 뒤의 인덱스를 맞춰줄 idx;
        int idx = 0;

        //만약 idx가 총 글자의 절반보다 작다면, 계속반복한다.
        while (idx < totalLength / 2) {

            //A부터 Z까지의 글자의 개수를 순회하는 for문
            for (int i = 0; i < alp.length; i++) {

                //ASCII코드로 어떤알파벳인지 변환
                char a = (char) ('A' + i);

                //만약 글자의 남은 개수가 2이상이면 앞, 뒤 인덱스에 각각 글자를 넣어주고
                while(alp[i] >= 2) {
                    s[idx] = String.valueOf(a);
                    s[totalLength - 1 - idx] = String.valueOf(a);
                    //idx 증가
                    idx++;
                    //앞뒤의 글자를 넣었으니 2개를 뺀다.
                    alp[i] = alp[i] - 2;
                }
            }
            //끝나면 break;
            break;
        }

        //만약 지금 idx 상태가 현재 글자수의 절반이라면
        //글자수가 짝수였으면 이미 회문완성여부 판단 가능, 홀수면 가운데 자리를 채워줘야한다.
        if (totalLength / 2 == idx) {
            //남은 글자수에서 가져온다.
            for (int i = 0; i < alp.length; i++) {
                char a = (char) ('A' + i);
                if (alp[i] > 0) {
                    s[idx] = String.valueOf(a);
                }
            }

            //회문출력
            for (String s1 : s) {
                if (s1 != null) {
                    System.out.print(s1);
                }
            }
        }else{
            //글자의 개수가 홀수인 경우가 2개이상이면 이쪽으로 빠진다
            System.out.println("I'm Sorry Hansoo");
        }



    }
    
}
