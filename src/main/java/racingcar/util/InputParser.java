package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class InputParser {
    private static final String SEPARATOR = ",";

    public static List<String> parseNames(String names) {
        return Arrays.stream(names.split(","))
                .map(String::strip)
                .toList();
    }

    public static int parseRoundNumber(String num) {
        try {
            return Integer.parseInt(num.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
    }
}
