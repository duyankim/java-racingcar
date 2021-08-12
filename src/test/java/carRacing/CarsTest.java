package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("레이싱 우승자를 구하는 로직 테스트")
    void getWinners() {
        Car choi = new Car("choi", 1);
        Car jae = new Car("jae", 3);
        Car hong = new Car("hong", 2);

        Cars cars = new Cars(Arrays.asList(choi, jae, hong));
        List<Car> winners = cars.getWinners();

        assertThat(winners.contains(jae)).isEqualTo(true);
    }
}