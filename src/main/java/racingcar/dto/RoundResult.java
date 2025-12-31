package racingcar.dto;

import java.util.List;
import racingcar.service.domain.Car;

public record RoundResult(List<CarStatus> statuses) {

    public static RoundResult from(List<Car> carRoster) {
        List<CarStatus> statuses = carRoster.stream()
                .map(CarStatus::from)
                .toList();

        return new RoundResult(statuses);
    }
}