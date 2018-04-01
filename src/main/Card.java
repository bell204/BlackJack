package main;

public class Card {
	Pattern pattern; // 패턴, 심볼 Enum 클래스 주입
	Symbol symbol;
	
	// 52개의 카드는 패턴과 심볼을 가지고 있음.
	public Card(Pattern pattern, Symbol symbol){ 
		this.pattern = pattern;
		this.symbol= symbol;
	}

	@Override
	public String toString() {
		return "[pattern=" + pattern + ", symbol=" + symbol + "]";
	}
  

 
 
	
}
