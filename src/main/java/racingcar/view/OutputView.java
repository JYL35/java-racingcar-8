package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.dto.RoundResult;

public class OutputView {

    public void printAllRoundResult(List<RoundResult> roundResults) {
        for (RoundResult result : roundResults) {
            printOneRoundResult(result.statuses());
            printNewLine();
        }
    }

    private void printOneRoundResult(List<CarStatus> carStatus) {
        for (CarStatus status : carStatus) {
            String name = status.carName();
            String distance = "-".repeat(status.position());
            System.out.println(name + " : " + distance);
        }
    }

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
