package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


class BaseballGameTest extends NsTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    void setUserNumberTest(){
        int number1 = 1234;
        int number2 = 112;

        Assertions.assertThatThrownBy(() ->{
            baseballGame.setUserNumber(number1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("%d",4);

        Assertions.assertThatThrownBy(() ->{
            baseballGame.setUserNumber(number2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("%d",1);

    }

    @Test
    void matchingNumberAnswerTest(){

        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "125", "513", "156", "789", "589","135","2");
                    assertThat(output()).contains("낫싱", "2스트라이크", "3볼",
                            "1볼 1스트라이크", "낫싱", "1볼", "3스트라이크", "게임 종료");
                },
                1,3,5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}