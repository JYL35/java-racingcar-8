package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_NUMBER = "시도할 회수는 몇회인가요?";

    public String inputCarName() {
        return userInput(INPUT_CAR_NAME);
    }

    public String inputRoundNumber() {
        return userInput(INPUT_ROUND_NUMBER);
    }

    private String userInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
