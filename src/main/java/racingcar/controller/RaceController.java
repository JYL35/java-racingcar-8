package racingcar.controller;

import racingcar.service.RaceService;
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
    }
}
