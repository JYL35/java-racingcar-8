package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.dto.RoundResult;

public class OutputView {
    private static final String FINAL_WINNERS = "최종 우승자 : ";
    private static final String ROUND_START = "실행 결과";

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    public void printAllRoundResult(List<RoundResult> roundResults) {
        printNewLine();
        System.out.println(ROUND_START);

        for (RoundResult result : roundResults) {
            printOneRoundResult(result.statuses());
            printNewLine();
        }
    }

    public void printWinner(List<String> winners) {
        System.out.println(FINAL_WINNERS + String.join(",", winners));
    }

    private void printOneRoundResult(List<CarStatus> carStatus) {
        for (CarStatus status : carStatus) {
            String name = status.carName();
            String distance = "-".repeat(status.position());
            System.out.println(name + " : " + distance);
        }
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
