import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 해시맵을 만들어준다.
        // 키와 벨류로 선택할 것은 본인이 정하는 것인데 
        // 
        Map<String,Integer> map = new HashMap<>();
        for(String[] clothe : clothes){
            String type = clothe[1];
            map.put(type,map.getOrDefault(type,0)+1);
        }
        
        // 경우의 수를 계산할 때 항상 문제를 쉽게 만드는 연습을 하자
        // 독립적인 것은 곱해 즉 
        // 헤드기어에서 나올 수 있는 경우의수 
        // 아이웨어에서 나올 수 있는 경우의수 
        // 둘 다 입지 않는 경우는 없으니 -1 
        int answer = 1;
        // for(int value : map.values()){
        //     answer*= value +1;
        // }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            answer*= value +1;
        }
        
        
        return answer-1;
    }
}