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
        
        int answer = 1;
        for(int value : map.values()){
            answer*= value +1;
        };
        
        return answer-1;
    }
}