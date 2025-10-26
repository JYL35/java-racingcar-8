package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String HEADER_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printHeaderMessage() {
        System.out.println(HEADER_MESSAGE);
    }

    public void printOneRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " +
                    "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);

        System.out.println(WINNER_MESSAGE + result);
    }
}
