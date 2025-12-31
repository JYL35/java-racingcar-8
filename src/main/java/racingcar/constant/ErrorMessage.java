package racingcar.constant;

public enum ErrorMessage {

    EMPTY_VALUE("null이거나 빈값입니다."),
    NOT_A_NUMBER("숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}