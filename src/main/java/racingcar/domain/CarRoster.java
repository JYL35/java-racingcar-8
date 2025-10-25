package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarRoster {
    private final List<String> carRoster;

    public CarRoster(String carRosterInput) {
        List<String> extractedNames = extractCarName(carRosterInput);

        validateLeastOne(extractedNames);
        validateNotDuplicate(extractedNames);

        this.carRoster = extractedNames;
    }

    private List<String> extractCarName(String carNameInput) {
        return Arrays.stream(carNameInput.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();
    }

    private void validateLeastOne(List<String> extractedNames) {
        if (extractedNames.size() <= 1) {
            throw new IllegalArgumentException("자동차는 1대 이하일 수 없습니다.");
        }
    }

    private void validateNotDuplicate(List<String> extractedNames) {
        List<String> removeDuplicateList = extractedNames.stream()
                                            .distinct().toList();

        if (extractedNames.size() != removeDuplicateList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
