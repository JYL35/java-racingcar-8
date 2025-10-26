package racingcar.view;

import java.util.List;

public class OutputView {

    public void printAllRoundResult(String allRoundResult) {
        System.out.println("실행 결과\n" + allRoundResult);
    }

    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);

        System.out.println("최종 우승자 : " + result);
    }
}
