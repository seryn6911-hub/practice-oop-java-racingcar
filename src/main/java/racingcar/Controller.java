package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final View view;
    private final List<Member> members = new ArrayList<>();

    public Controller(View view) {
        this.view = view;
    }

    //레이스 시작
    public void startRace() {
        //  경주차 등록
        String[] names = view.getMemberNames();
        for (String name : names) {
            members.add(new Member(name.trim(),0));
        }

        // 시도 횟수
        int tryCount = view.getTryCount();

        // 경주 진행
        for (int i = 0; i < tryCount; i++) {
            for (Member m : members) {
                m.startRandom();
            }
            view.printProgress(members);
        }

        // 우승자 계산
        int max = 0;
        for (Member m : members) {
            if (m.getGo() > max) {
                max = m.getGo();
            }
        }
        List<Member> winners = new ArrayList<>();
        for (Member m : members)
            if (m.getGo() == max) {
                winners.add(m);
            }
        view.printWinners(winners);
    }
}
