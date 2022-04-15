package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameService {

    private final BaseballGame baseballGame = new BaseballGame();

    public void start(){
        boolean cmd = true;
        while(cmd){
            // 1. 숫자 입력
            int number = Integer.parseInt(Console.readLine());
            baseballGame.setUserNumber(number);
            // 2. 숫자매칭
            baseballGame.matchingNumberAnswer();
            // 3. 종료할지 말지
            cmd = baseballGame.resultGame();
        }
    }
}
