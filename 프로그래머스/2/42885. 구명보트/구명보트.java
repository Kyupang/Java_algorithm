import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
         
        for (int i = people.length - 1; i >= 0; i--) {
            if (index > i)
                break;
            
            if (people[i] + people[index] <= limit) {
                index++;
            }
            answer++;
        }
        // 정렬 후 limit > max 값을 집어넣고 
        // max 값을 가진 인덱스의 값을 0으로 바꿔줌 
        // limit = limit - max 한다음에 
        // limit > max 값을 집어넣고 
        // 반복 후 없으면 limit는 다시 limit 값으로 초기화
        return answer;
    }
}