package racingcar.constant;

public enum ErrorMessage {

    EMPTY_VALUE("null이거나 빈값입니다."),
    OVER_LENGTH("자동차 이름이 5글자 이상입니다."),
    NAME_DUPLICATION("이름이 중복됩니다."),
    NOT_A_NUMBER("숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}