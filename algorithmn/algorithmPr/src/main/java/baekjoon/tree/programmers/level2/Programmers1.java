package baekjoon.tree.programmers.level2;

import java.util.*;

/**
 * 2023 blind KAKAO
 * 카오톡에서는 이모티콘을 무제한으로 사용할 수 있는 이모티콘 플러스 서비스 가입자 수를 늘리려고 합니다.
 * 이를 위해 카카오톡에서는 이모티콘 할인 행사를 하는데, 목표는 다음과 같습니다.
 *
 * 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
 * 이모티콘 판매액을 최대한 늘리는 것.
 * 1번 목표가 우선이며, 2번 목표가 그 다음입니다.
 *
 * 이모티콘 할인 행사는 다음과 같은 방식으로 진행됩니다.
 *
 * n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매합니다.
 * 이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
 * 카카오톡 사용자들은 다음과 같은 기준을 따라 이모티콘을 사거나, 이모티콘 플러스 서비스에 가입합니다.
 *
 * 각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
 * 각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
 * 다음은 2명의 카카오톡 사용자와 2개의 이모티콘이 있을때의 예시입니다.
 */
public class Programmers1 {
    //1. 일단 구매가 먼저
    //2. 멤버중 최대 할인율일시 모두 구매/
    //3. 최소 할인율까지 내린다음 한개씩 파악
    //4. 탐색방향은 이모티콘 가입자가 제일많이, 그다음 가격
    //5. 최대할인 가격으로 먼저 탐색 그다음 할인율로 탐색 할인율 순서대로 줄여가면서 탐색
    //6. 최대할인에는 모두 넣고
    //7. 할인율 낮은거에따라 사람들 줄여가면서 넣기
    //8.

    //4. 가격조건은 두개가 있음 -> 가
    public static void main(String[] args) {

        int[][] users = {{40,2900},{23,10000},{11,5200},{5,5900},{40,3100},{27,9200},{32,6900}};
        int[] emoji = {1300, 1500, 1600, 4900};




        //할인율별로 정렬할 어레이리스트
        ArrayList<Integer> discountArr = new ArrayList<>();
        //유저 정보를 담는 맵
        HashMap<Integer, int[]> userInfoMap = new HashMap<>();

        for (int i = 0; i < users.length; i++) {
            userInfoMap.put(i, users[i]);
            discountArr.add(users[i][0]);
        }

        Collections.sort(discountArr);
        Arrays.sort(emoji);

        int maxDiscount = discountArr.get(0);
        int minDiscount = discountArr.get(discountArr.size() - 1);

        int emojiTotalPrice = Arrays.stream(emoji).sum();

        int plusUserCnt = 0;
        int tempPlusUserCnt = 0;
        int userTotalPrice = 0;
        int tempTotalPrice = 0;

        while (true) {

            //첫번째 조건 이모지 가입수가 떨어지면 바로 브레이크
            if (plusUserCnt < tempPlusUserCnt) {
                break;
            }

            //두번째 조건 이모지 가입수가 같은데 가격이 더떨어지면 브레이크
            if (plusUserCnt == tempPlusUserCnt && userTotalPrice > tempTotalPrice) {
                break;
            }






            for (int i = maxDiscount; i > minDiscount; i--) {
                for (int j = 0; j < emoji.length; j++) {
                    //이모지 가격 순회하면서, 그리디하게 가격확인
                    int tempPrice = emojiTotalPrice;
                    tempPrice -= emoji[j] * (maxDiscount / 100);




                }




                //최대할인율 부터 그리디하게 탐색
                //가장 작은 이모티콘의 가격부터 할인율을 낮추면서 확인

                for (int j = 0; j < users.length; j++) {
                    int[] userInfo = users[j];
                    //유저의 상한 할인율
                    int userDiscount = userInfo[0];
                    int maxPrice = userInfo[1];

                    //유저의 상한 할인율을 넘으면 이모티콘 구매
                    if (userDiscount <= maxDiscount) {
                        if (tempTotalPrice >= maxPrice) {
                            //임티플러스 구매
                        } else{
                            //구매 총가격 확인


                        }



                    }

                }



            }


        }



    }

}
