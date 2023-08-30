class Solution {
    public int solution(String name) {
      int count = 0;
		
		int move = name.length();  
		int index;
		/*
		커서 위치가 바뀌게 되는 경우는 총 세 가지이다.
		1. 처음부터 쭉 오른쪽으로 가는 경우
		    가장 일반적인 경우로 name.length() - 1로 해당한다.
		2. 오른쪽으로 갔다 다시 리턴하여 왼쪽으로 가는 경우
		    ex) BBAAAAAYYY 의 경우, BB까지 갔다가 다시 돌아가 YYY를 완성해준다.
		3. 왼쪽으로 갔다 다시 리턴하여 오른쪽으로 가는 경우
		    ex) CCCAAAAAAY 의 경우, 처음부터 왼쪽으로 움직여 Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
		*/
		
		for(int i= 0; i< name.length(); i++) {
			char ch = name.charAt(i);
			if(ch != 'A') count += Math.min(ch-'A', 'Z' - ch+1);
			
			index = i+1;
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move, i * 2 + (name.length() - index));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
            move = Math.min(move, i + (name.length() - index) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
			
		}
		
		
		// 일단 받아서 char 어레이로 만들고 
		// 각각에 접근해서 만약 < 인 케이스 > 인 케이스 
		
		
		return count+move;
    }
}