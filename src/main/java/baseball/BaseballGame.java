package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private int strike;
    private int ball;

    private final NumberValidation numberValidation = new NumberValidation();

    private final List<Integer> answerNumber = new ArrayList<>();
    private final List<Integer> userNumber = new ArrayList<>();
    private final Set<Integer> answerNumberSet = new HashSet<>();

    public BaseballGame(){
        makeAnswerNumber();
    }

    private void numberToList(int number, List<Integer> list){
        int i = 10;
        list.clear();
        while(number > 0){
            list.add(0, number%i);
            number /= i;
        }
    }

    private void makeAnswerNumber(){
        answerNumber.clear();
        for(int i=0; i<3; i++) {
            answerNumber.add(Randoms.pickNumberInRange(100, 1000));
        }

        for(int i=0; i<3; i++){
            answerNumberSet.add(answerNumber.get(i));
        }
    }

    public void setUserNumber(int number){
        numberToList(number, userNumber);

        numberValidation.checkNumberLength(userNumber);
        numberValidation.checkOtherNumber(userNumber);
    }

    public void matchingNumberAnswer(){
        strike = 0;
        ball = 0;
        for(int i=0; i<userNumber.size(); i++){
            isStrikeOrBall(answerNumber.get(i), userNumber.get(i));
        }
        printResult();
    }
    private void isStrikeOrBall(Integer answer, Integer user){
        if(isStrike(answer, user)){
            strike++;
        } else if(isBall(user)){
            ball++;
        }
    }

    private Boolean isStrike(Integer answer, Integer user){
        return Objects.equals(answer, user);
    }

    private Boolean isBall(Integer user){
        return answerNumberSet.contains(user);
    }

    private void printResult() {
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if(strike == 0){
            System.out.println(ball+"볼");
        } else if(ball == 0){
            System.out.println(strike+"스트라이크");
        } else if(ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }


    public boolean resultGame() {
        boolean ret = true;
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            ret = Integer.parseInt(Console.readLine()) != 2;
        }
        if(ret && strike==3)
            makeAnswerNumber();
        return ret;
    }

}
