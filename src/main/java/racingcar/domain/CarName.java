package racingcar.domain;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateNotNullAndBlank(name);
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNotNullAndBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("라운드 수는 공백이거나 비어있을 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이상일 수 없습니다.");
        }
    }
}
