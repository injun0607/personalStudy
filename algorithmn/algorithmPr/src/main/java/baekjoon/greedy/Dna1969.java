package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dna1969 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        String[] arr = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = br.readLine();
        }


        //각 자리의 DNA 요소들을 정리할 배열
        ArrayList<ArrayList<DNA>> cntList = new ArrayList<>();
        //각 자리를 순회
        for (int i = 0; i < length; i++) {

            //각 자리의 DNA 요소를 카운트 해줄 DNA
            DNA a = new DNA('A');
            DNA c = new DNA('C');
            DNA g = new DNA('G');
            DNA t = new DNA('T');

            //가장 많은 DNA요소를 정렬해줄 배열
            ArrayList<DNA> arrayList = new ArrayList<>();
            arrayList.add(a);
            arrayList.add(c);
            arrayList.add(g);
            arrayList.add(t);

            //각 자리수를 순회하는 i 와 DNA문자열을 순회할 j
            for (int j = 0; j < cnt; j++) {
                String val = arr[j];
                char chr = val.charAt(i);
                if (chr == 'A') {
                    a.addCnt();
                } else if (chr == 'C') {
                    c.addCnt();
                } else if (chr == 'G') {
                    g.addCnt();
                }else{
                    t.addCnt();
                }
            }

            //DNA요소들 중 카운트가 많은 순으로 내림차순
            Collections.sort(arrayList, new Comparator<DNA>() {
                @Override
                public int compare(DNA o1, DNA o2) {
                    return o2.cnt - o1.cnt;
                }
            });

            //각 자리(인덱스) 배열에 추가
            cntList.add(arrayList);
        }

        //Hamming Distance의 합
        int sum = 0;

        StringBuilder sb = new StringBuilder();
        //각 자리의 DNA요소 중 가장 많은 수를 가지고 있는 요소의 문자와
        //전체 DNA의 개수에서 - 가장 많은 수를 가지고 있는 요소의 개수
        for (ArrayList<DNA> arrayList : cntList) {
            DNA dna = arrayList.get(0);
            sb.append(dna.chr);
            sum += cnt - dna.cnt;
        }


        System.out.println(sb.toString());
        System.out.println(sum);

    }

    public static class DNA {

        char chr;
        int cnt;

        public DNA(char chr) {
            this.chr = chr;
        }

        public void addCnt() {
            this.cnt++;
        }




    }




}
