package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Constant;
import racing.dto.GameVO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carNo() {
        Cars cars = Cars.create(0);
        RacingGame racingGame = new RacingGame(cars, 5);
        GameVO gameVO = new GameVO(0, 5);
        assertThatThrownBy(() -> racingGame.validateInput(gameVO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_chanceNo() {
        Cars cars = Cars.create(2);
        RacingGame racingGame = new RacingGame(cars, 0);
        GameVO gameVO = new GameVO(2, 0);
        assertThatThrownBy(() -> racingGame.validateInput(gameVO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ROUND_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("자동차 게임을 진행하면 자동차가 위치가 이동된다")
    void play() {
        Cars cars = Cars.create(2);

        RacingGame racingGame = new RacingGame(cars, 5);
        racingGame.play();
        assertThat(cars.getCars().get(0).getPosition() > 1);
        assertThat(cars.getCars().get(1).getPosition() > 1);
    }
}
