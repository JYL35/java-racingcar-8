package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public class RaceService {
    private final MoveStrategy moveStrategy;

    public RaceService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void startOneRound(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = moveStrategy.getNumber();
            car.move(randomNumber);
        }
    }

    public List<String> findWinners(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);

        return carList.stream()
                .filter(car -> car.comparePosition(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
