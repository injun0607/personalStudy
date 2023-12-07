package algorithm;

/**
 * 중요한 아이디어
 * 1.한개가 될때까지 나눈다.
 * 2.한개로 나눠진것을 다시 순서대로 합친다.
 * 시간복잡도 nlogn
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] list = {3,6,7,0,1,5,11,23,44,30};
        int[] sortedList = dividedAndMerge(list);
        for (int i : sortedList) {
            System.out.println(i);
        }


    }

    public static int[] dividedAndMerge(int[] sortList) {

        //한개가 되면 나누기 멈춤
        if (sortList.length <= 1) {
            return sortList;
        }

        //절반씩 나눈다.
        int middleNum = sortList.length / 2;
        int[] frontArr = new int[middleNum];
        int frontCnt = 0;
        int[] backArr = new int[sortList.length - middleNum];
        int backCnt = 0;
        for (int i = 0; i < sortList.length; i++) {
            if (i < middleNum) {

                frontArr[frontCnt] = sortList[i];
                frontCnt++;
                continue;
            }

            backArr[backCnt] = sortList[i];
            backCnt++;


        }

        int[] frontResult = dividedAndMerge(frontArr);
        int[] backResult = dividedAndMerge(backArr);
        return merge(frontResult, backResult);

    }


    public static int[] merge(int[] frontResult, int[] backResult) {
        int[] result = new int[frontResult.length + backResult.length];
        int frontCnt = 0;
        int backCnt = 0;
        for (int i = 0; i < result.length; i++) {
            if (frontCnt >= frontResult.length ) {
                //앞쪽배열이 정렬이 먼저 됐다면 뒤쪽배열로만 정렬
                result[i] = backResult[backCnt];
                backCnt++;
            } else if (backCnt >= backResult.length) {
                //뒤쪽배열이 정렬이 먼저 됐다면 앞쪽배열로만 정렬
                result[i] = frontResult[frontCnt];
                frontCnt++;
            }else if (frontResult[frontCnt] < backResult[backCnt]) {
                //앞쪽정렬과 뒤쪽정렬의 비교해서 정렬
                result[i] = frontResult[frontCnt];
                frontCnt++;
            }else{
                result[i] = backResult[backCnt];
                backCnt++;
            }
        }

        return result;

    }

}
