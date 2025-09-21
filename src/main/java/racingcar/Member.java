package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Member {
    private String name;
    private int go;

    public Member(String name, int go) {
        validateName(name);
        this.name = name;
        this.go = 0;
    }

    public String getName() {
        return name;
    }

    public int getGo() {
        return go;
    }
    //랜덤 뽑기
    public void startRandom() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {  // 4 이상이면 전진
            go++;
        }
    }
    //예외처리
    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이여야 합니다.");
        }
    }
}
