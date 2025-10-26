package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarRoster;
import racingcar.domain.RaceRounds;
import racingcar.service.MoveStrategy;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private CarRoster carRoster;
    private RaceRounds raceRounds;
    private RaceService raceService;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void raceStart() {
        String carRosterInput = inputView.carRosterInput();
        carRoster = new CarRoster(carRosterInput);
        List<Car> carList = carRoster.createCars();

        String raceRoundInput = inputView.raceRoundInput();
        raceRounds = new RaceRounds(raceRoundInput);

        MoveStrategy moveStrategy = () -> Randoms.pickNumberInRange(0, 9);
        raceService = new RaceService(moveStrategy);

        startAllRound(carList);

        List<String> winners = raceService.findWinners(carList);
        outputView.printWinners(winners);
    }

    private void startAllRound(List<Car> carList) {
        outputView.printHeaderMessage();

        int totalRounds = raceRounds.getCount();
        for (int i = 0; i < totalRounds; i++) {
            raceService.startOneRound(carList);

            outputView.printOneRoundResult(carList);
        }
    }
}
