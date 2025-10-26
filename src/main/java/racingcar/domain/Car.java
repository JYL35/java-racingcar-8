package racingcar.domain;

public class Car {
    private final static int MOVE_CONDITIONS = 4;

    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if(randomNumber >= MOVE_CONDITIONS) {
            this.position++;
        }
    }

    public boolean comparePosition(int compareNumber) {
        return compareNumber == position;
    }
}