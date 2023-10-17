import java.util.*;
class Solution {
     public int[] solution(int[] fees, String[] records) {
        int[] answer = {}; // 기본제공
        
        Map<String, String> map = new HashMap<>(); // 차량 번호와 들어왔던 시간/ 들어왔던 시간에 대한 번호가 있으면 빼서 나갔던 것까지 업데이트.
        Map<String, Integer> feeMap = new HashMap<>(); //차량 번호와 있었던 시간을 집어넣음 
        
        for(int i = 0; i < records.length; i++){
            feeMap.put(records[i].split(" ")[1], 0); // 레코드를 분리해서 차량번호와 0을 집어넣는다.
        }
        
        for(int i = 0; i < records.length; i++){ // 레코드의 케이스만큼 모두 처리를 해줄 것 
            String[] infos = records[i].split(" "); // 모든 케이스를 각각 분리.
            
            // 입차를 했었거나 -> 출차정보가 나올것임, 입차를 해야한다면 map에 집어넣어줘.
            if(map.containsKey(infos[1])){ // 차량 번호를 맵이 가지고 있다면?
            	// 차량이 in 한것이니 map에 들어가 있던 시간을 빼주면 그게 inTime임 
                String[] inTime = map.remove(infos[1]).split(":"); //  
                // 지금 보고있는 정보는 무조건 out에 대한 정보이니 빼주면 그게 outTime
                String[] outTime = infos[0].split(":"); 
                
                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]); //시간의 차이
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]); //분의 차이 
                
                feeMap.replace(infos[1], feeMap.get(infos[1]) + 60 * hour + minute); // 걸린 시간을 저장해야하니까 
                // 해당 차량 번호에 저장된 시간을 계산해서 합산한 값을 넣어줘 
            }else{
                map.put(infos[1], infos[0]); // 차 번호, 시간을 기록 
            }
        }
        
        // 여기까지 하고 나면 모든 차량에 대해서 in out이 있었다면 
        // 값을 다 계산해줬다.
        
        // 이제 해야할 것은 나가지 않은 차량이다. 
        // 나가지 않은 차량은 23:59분에서 빼준다. 
        
        for(String key : map.keySet()){
            String[] inTime = map.get(key).split(":");
            
            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 -Integer.parseInt(inTime[1]);
            
            feeMap.replace(key, feeMap.get(key) + 60 * hour + minute);
        }
        
        
        // 이제 시간에 대한 요금을 계산해보자.
        // 지금 현재 feeMap 엔 번호와 계산할 시간에 대해서 정리되어있다. 
        // feeMap을 ArrayList로 변환 
        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        
        // 차량번호가 낮은 순으로 저장해줘야함 answer에 
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey())?1 : -1;
        });
        
        //Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey())?-1 : 0

        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }
        
        return answer;
    }
    
}