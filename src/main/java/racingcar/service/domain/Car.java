package racingcar.service.domain;

public class Car {
    private static final int MOVING_CONDITIONS = 4;

    private CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void move(int num) {
        if (num >= MOVING_CONDITIONS) {
            position++;
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }
}
