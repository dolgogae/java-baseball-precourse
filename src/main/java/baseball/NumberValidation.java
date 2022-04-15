package baseball;

import java.util.List;

public class NumberValidation {

    public boolean[] visited = new boolean[11];

    public void checkNumberLength(List<Integer> number){
        if(number.size() != 3){
            throw new IllegalArgumentException("숫자의 길이가 맞지 않습니다. 현재: "+number.size()+", 정상: 3");
        }
    }

    public void checkOtherNumber(List<Integer> number){
        for(int i=0; i<11; i++){
            visited[i] = false;
        }

        for (Integer num : number) {
            isExist(num);
            visited[num] = true;
        }
    }

    private void isExist(int a){
        if(visited[a]){
            throw new IllegalArgumentException("같은 숫자 "+a+"가 발견됐습니다.");
        }
    }
}
