package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RaceRounds;

import java.util.List;

public class RaceService {
    private final MoveStrategy moveStrategy;

    public RaceService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void raceStart(List<Car> carList, RaceRounds raceRounds) {
        System.out.println("실행 결과");

        for (int i = 0; i < raceRounds.getCount(); i++) {

            for (Car car : carList) {
                int randomNumber = moveStrategy.getNumber();
                car.move(randomNumber);

                System.out.println(car.getName() + " : " + car.getDistanceMoved());
            }
            
            System.out.println();
        }
    }
}
