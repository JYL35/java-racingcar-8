package racingcar.controller;

import java.util.List;
import racingcar.dto.RoundResult;
import racingcar.service.RaceService;
import racingcar.util.InputParser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            setUpCar(inputView.inputCarName());

            List<RoundResult> roundResults = startAllRound(inputView.inputRoundNumber());

            outputView.printAllRoundResult(roundResults);
        } catch (RuntimeException e) {
            outputView.printError(e);
        }
    }

    private void setUpCar(String inputNames) {
        List<String> carNames = InputParser.parseNames(inputNames);
        Validator.validateNames(carNames);
        raceService.createCars(carNames);
    }

    private List<RoundResult> startAllRound(String inputRoundNum) {
        Validator.validateRoundNumber(inputRoundNum);
        int roundNumber = InputParser.parseRoundNumber(inputRoundNum);
        return raceService.raceStart(roundNumber);
    }
}
