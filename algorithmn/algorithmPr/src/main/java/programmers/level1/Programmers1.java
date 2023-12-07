package programmers.level1;

import java.util.*;

/**
 * 2022 KAKAO BLIND RECRUITMENT
 *문제 :  신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.
 *
 * 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 * 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 * 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 * k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 * 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 * 다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.
 * 예시
 * 유저 ID	유저가 신고한 ID	설명
 * "muzi"	"frodo"	"muzi"가 "frodo"를 신고했습니다.
 * "apeach"	"frodo"	"apeach"가 "frodo"를 신고했습니다.
 * "frodo"	"neo"	"frodo"가 "neo"를 신고했습니다.
 * "muzi"	"neo"	"muzi"가 "neo"를 신고했습니다.
 * "apeach"	"muzi"	"apeach"가 "muzi"를 신고했습니다.
 */
public class Programmers1 {

    //신고 중복x
    //1. 신고한 사람이 누굴 신고했는지 확인
    //2.
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        int m = 3;
        int[] solution = solution(id_list2, report2, m);
        for (int i : solution) {
            System.out.print(i + " ");
        }


    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportMap = new HashMap<>();

        for (String id : id_list) {
            reportMap.computeIfAbsent(id, v -> new HashSet<>());
        }

        //신고자들 모두 확인 중복제거
        for (String c : report) {
            String[] reportContent = c.split(" ");
            String main = reportContent[0];
            String sub = reportContent[1];

            reportMap.get(main).add(sub);
        }

        Map<String, Integer> resultMap = new HashMap<>();
        //이름별 신고합 수
        Collection<Set<String>> values = reportMap.values();
        for (Set<String> value : values) {
            for (String name : value) {
                if (resultMap.containsKey(name)) {
                    resultMap.put(name, resultMap.get(name) + 1);
                }else{
                    resultMap.put(name, 1);
                }
            }
        }


        //해당이름이 초과한이름인지 확인
        ArrayList<String> reportedNameList = new ArrayList();
        Set<String> reportedNames = resultMap.keySet();
        for (String reportedName : reportedNames) {
            if (resultMap.get(reportedName) >= k) {
                reportedNameList.add(reportedName);
            }
        }


        for (int i = 0 ; i< id_list.length;i++) {
            for (String reportedName : reportedNameList) {
                if(reportMap.get(id_list[i]).contains(reportedName)){
                    answer[i] += 1;
                }
            }

        }

        return answer;
    }

}
