package racingcar.domain;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이거나 비어있을 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이상일 수 없습니다.");
        }
    }
}
