package algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] sortList = {3, 12, 5, 4, 22, 0, 1, 43};
        int[] ints = bubbleSort(sortList);
        for (int anInt : ints) {
            //
            System.out.println(anInt);
        }

    }

    public static int[] bubbleSort(int[] sortList) {
        for (int i = 0; i < sortList.length; i++) {

            for (int j = 0 ; j < sortList.length-1-i; j++) {
                //맨처음 부터 순회를 한다. i번 실행 됐다는 뜻은 i번 정렬이 완료됐다는 뜻이다.
                if (sortList[j] > sortList[j+1]) {
                    int temp = sortList[j+1];
                    sortList[j+1] = sortList[j];
                    sortList[j] = temp;
                }
            }
        }

        return sortList;

    }
}
