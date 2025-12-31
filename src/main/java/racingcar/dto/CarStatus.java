package racingcar.dto;

import racingcar.service.domain.Car;

public record CarStatus(String carName, int position) {

    public static CarStatus from(Car car) {
        return new CarStatus(car.getCarName(), car.getPosition());
    }
}
