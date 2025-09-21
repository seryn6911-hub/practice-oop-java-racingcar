package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Member {
    String name;
    int go;

    public Member(String name, int go) {
        this.name = name;
        this.go = go;
    }

    public String getName() {
        return name;
    }

    public int getGo() {
        return go;
    }

    // 랜덤으로 오르거나 안 오르거나
    public void startRandom() {
        int value = Randoms.pickNumberInRange(0, 9);
        if (value >= 4) {
            go++;
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }



}
