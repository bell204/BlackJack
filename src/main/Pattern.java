package main;

public enum Pattern {

	// 추가 속성을 부여한 enum //상수명: 값이라고 생각
		Spade("spade"), 
		HEART("heart"), 
		DIAMOND("diamond"), 
		CLOVER("clover");
			
		String value= null; // 추가 속성 초기화
		
		Pattern(String value){ // 추가 속성을 매개변수로 한 생성자
			this.value=value;
		};
	}
	
