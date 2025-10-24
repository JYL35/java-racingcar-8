package racingcar.domain;

public class RaceRounds {
    private final int count;

    public RaceRounds(String count) {
        validateNotNullAndBlank(count);
        int parsedCount = parseToInt(count);
        validatePositive(parsedCount);

        this.count = parsedCount;
    }

    public int getCount() {
        return count;
    }

    private void validateNotNullAndBlank(String count) {
        if (count == null || count.isBlank()) {
            throw new IllegalArgumentException("라운드 수는 공백이거나 비어있을 수 없습니다.");
        }
    }

    private int parseToInt(String count) {
        try {
            return Integer.parseInt(count);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 수는 정수여야 합니다.");
        }
    }

    private void validatePositive(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("라운드 수는 1미만 일 수 없습니다.");
        }
    }
}
