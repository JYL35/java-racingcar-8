package racingcar.domain;

public class Car {
    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getName() {
        return carName.getName();
    }

    public String getDistanceMoved() {
        return "-".repeat(position);
    }

    public void move(int randomNumber) {
        if(randomNumber >= 4) {
            this.position++;
        }
    }
}