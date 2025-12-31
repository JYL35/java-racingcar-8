package racingcar.util;

import java.util.List;
import racingcar.constant.ErrorMessage;

public class Validator {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    public static void validateNames(List<String> names) {
        for (String name : names) {
            validateEmpty(name);
            validateLength(name);
        }
        validateDuplicate(names, names.size());
    }

    public static void validateRoundNumber(String roundNumber) {
        validateEmpty(roundNumber);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
    }

    private static void validateLength(String input) {
        if (input.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OVER_LENGTH.getMessage());
        }
    }

    private static void validateDuplicate(List<String> names, int size) {
        int namesLength = names.stream()
                .distinct()
                .toList()
                .size();
        if (namesLength != size) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATION.getMessage());
        }
    }
}
