package racingcar.service;

import java.util.List;
import racingcar.service.domain.Car;
import racingcar.service.domain.CarName;

public class RaceService {

    public List<Car> createCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();
    }
}
