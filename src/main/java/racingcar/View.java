package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    // 경주차 이름 입력
    public String[] getMemberNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> lst = List.of(scanner.nextLine().split(","));

        for (String s : lst) {
            String trimmed = s.trim();

            if (trimmed.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 공백");
            }

            if (trimmed.length() > 5) {
                throw new IllegalArgumentException("이름 오류");
            }
        }

        String[] result = new String[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            result[i] = lst.get(i).trim();
        }
        return result;
    }

    // 시도 회수 결정
    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = scanner.nextInt();
        if (tryNum <= 0) {
            throw new IllegalArgumentException("시도 횟수는 이상");
        }
        return tryNum;
    }

    // 경주차 간거 표시
    public void printProgress(List<Member> members) {
        for (Member m : members) {
            System.out.println(m.getName() + " : " + "-".repeat(m.getGo()));
        }
        System.out.println();
    }

    // 우승자 발표
    public void printWinners(List<Member> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Member winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}