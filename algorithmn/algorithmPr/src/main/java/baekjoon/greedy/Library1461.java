package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Library1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int books_cnt = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        ArrayList<Integer> mi_books = new ArrayList<>();
        ArrayList<Integer> pl_books = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        //최대값(편도로 이동할거리)
        int max_abs = 0;
        for (int i = 0; i < books_cnt; i++) {
            int book = Integer.parseInt(st.nextToken());


            if (Math.abs(book) > Math.abs(max_abs)) {
                max_abs = book;
            }

            if (book < 0) {
                mi_books.add(book);
            }else{
                pl_books.add(book);
            }
        }

        //절대값 높은순으로 정렬
        Collections.sort(mi_books);
        Collections.sort(pl_books,Collections.reverseOrder());


        //결과값
        int result = 0;
        //순회중 가장 절대값이 높은값
        int temp = 0;
        //책 카운트
        int temp_cnt = 0;

        //음수 순회
        for (int i = 0; i < mi_books.size(); i++) {
            temp_cnt++;
            Integer book = mi_books.get(i);

            if (Math.abs(temp) < Math.abs(book)) {
                temp = book;
            }

            //책을 다 놓았으면 결과에 더한다. 만약 편도거리일때는 한번
            if (temp_cnt == cnt && temp == max_abs) {
                result += Math.abs(temp);
                temp_cnt = 0;
                temp = 0;
            }else if(temp_cnt == cnt ){
                //왕복거리일때는 두번
                result += Math.abs(temp) * 2;
                temp_cnt = 0;
                temp = 0;
            }
        }

        //음수부분 남은것 초기화
        if (temp != 0) {
            if (temp == max_abs) {
                result += Math.abs(temp);
            }else{
                result += Math.abs(temp) * 2;
            }
            temp_cnt = 0;
            temp = 0;
        }

        //양수부분 순회
        for (int i = 0; i < pl_books.size(); i++) {
            temp_cnt++;
            Integer book = pl_books.get(i);

            if (Math.abs(temp) < Math.abs(book)) {
                temp = book;
            }

            //책을 다 놓았으면 결과에 더한다. 만약 편도거리일때는 한번
            if (temp_cnt == cnt && temp == max_abs) {
                result += Math.abs(temp);
                temp_cnt = 0;
                temp = 0;
            }else if(temp_cnt == cnt ){
                //왕복일때는 두번
                result += Math.abs(temp) * 2;
                temp_cnt = 0;
                temp = 0;
            }

        }

        //양수부분 남은것처리
        if (temp != 0) {
            if (temp == max_abs) {
                result += Math.abs(temp);
            }else{
                result += Math.abs(temp) * 2;
            }
        }

        System.out.println(result);








    }

}
