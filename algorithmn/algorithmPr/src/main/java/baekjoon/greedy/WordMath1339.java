package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제일 length가 큰 문자열에 제일 큰 수를 배정해야한다.
 *
 */
public class WordMath1339 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int cnt = Integer.parseInt(br.readLine());
//        String[] words = new String[cnt];
//
//        for (int i = 0; i < cnt; i++) {
//            String word = br.readLine();
//            words[i] = word;
//        }
//
//        //글자의 length순으로 정렬
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
//
//
//        HashMap<Integer, HashSet<String>> wordValues = new HashMap<>();
//        //글자수의 밸류에따라 담을 해쉬맵
//        for (String word : words) {
//            int key = word.length();
//            //단어들을 순회하면서
//            HashMap<String, Boolean> checkAlp = new HashMap<>();
//            for (int i = 0; i <word.length(); i++) {
//
//                String alp = word.substring(i, i + 1);
//                //같은 알파벳 방지
//                if (checkAlp.get(alp) == null) {
//                    wordValues.computeIfAbsent(key, v -> new HashSet<>()).add(alp);
//                    checkAlp.put(alp, true);
//                }
//
//                key--;
//
//            }
//        }
//
//        int num = 9;
//        int maxKey = words[0].length();
//
//        HashMap<String, Integer> numValue = new HashMap<>();
//        for (int i = maxKey; i > 0; i--) {
//            HashSet<String> strArr = wordValues.get(i);
//            if (strArr != null) {
//                for (String s : strArr) {
//                    if (numValue.get(s) == null) {
//                        numValue.put(s, num);
//                        num--;
//                    }
//                }
//            }
//
//        }
//
//        int sum = 0;
//        for (String word : words) {
//            String result = "";
//            for (int i = 0; i < word.length(); i++) {
//                String str = word.substring(i, i + 1);
//                Integer integer = numValue.get(str);
//                result += integer;
//            }
//
//            sum += Integer.parseInt(result);
//        }
//
//
//        System.out.println(sum);
//
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        HashMap<String, Integer> wordValue = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            String word = br.readLine();
            //가중치의 최대값을 정해줄 length
            int length = word.length();
            int pow = length-1;
            for (int j = 0; j < length; j++) {

                int val = (int) Math.pow(10, pow);
                String alp = word.substring(j, j + 1);
                //해쉬맵에 해당 알파벳이 처음이라면 값세팅
                if (wordValue.get(alp) == null) {
                    wordValue.put(alp, val);
                }else{
                    //알파벳이 이미 있다면 해당 가중치만큼 곱해준다
                    wordValue.put(alp, wordValue.get(alp) + val);
                }
                //for문을 순회할때마다 가중치가 1씩 낮아진다.
                pow--;
            }

        }

        //가중치를 정렬할 배열
        ArrayList<Integer> numValues = new ArrayList<>();

        //해쉬맵을 순회하면서 배열에 담아준다
        for (String s : wordValue.keySet()) {
            Integer numValue = wordValue.get(s);
            numValues.add(numValue);
        }

        //제일 큰 값으로 정렬
        Collections.sort(numValues,Collections.reverseOrder());
        int num = 9;
        int sum = 0;
        for (Integer numValue : numValues) {
            //정렬된수부터 9,8,7..곱해준다.
            sum += numValue * num;
            num--;
        }

        System.out.println(sum);




    }
}
