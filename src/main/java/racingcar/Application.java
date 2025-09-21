package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 경주차 이름 입력
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] membersList = scanner.nextLine().split(",");
            List<Member> members = new ArrayList<>();
            for (String s : membersList) {
                if(s.length()>5){
                    throw new IllegalArgumentException("글자수 5자 이하");
                }
                members.add(new Member(s.trim(), 0));

            }

            // 시도 횟수 입력
            System.out.println("시도할 회수는 몇회인가요?");
            int tryNum = scanner.nextInt();
            if (tryNum <= 0) {
                throw new IllegalArgumentException("시도 횟수 오류");
            }

            // 경주 실행
            for (int i = 0; i < tryNum; i++) {
                for (Member m : members) {
                    m.startRandom();
                    System.out.println(m.name + " : " + "-".repeat(m.go));
                }
                System.out.println();
            }

            // 우승자 판단
            int max = -1;
            List<String> winners = new ArrayList<>();
            for (Member m : members) {
                if (m.getGo() > max) {
                    max = m.getGo();
                    winners.clear();
                    winners.add(m.name);
                } else if (m.getGo() == max) {
                    winners.add(m.name);
                }
            }

            // 최종 우승자 출력
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e; // 애플리케이션 종료
        } finally {
            scanner.close();
        }
    }
}
