package main;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {

	private Stack<Card> cards;
	private Card card;
	
	Pattern pattern;
	Symbol symbol;
	
	// 생성자에서 52개의 카드 준비
	 public CardDeck(){
		 this.cards= generateCard();	
		 Collections.shuffle(this.cards);
	 };
	
	 public Stack<Card> generateCard() {
		 cards = new Stack<Card>();
			for(Pattern pattern : pattern.values()){
				for(Symbol symbol : symbol.values()){
					Card card = new Card(pattern, symbol);
					cards.push(card);
				}
				
			}
			return cards;
	}
	  
	// 52개의 카드 중에 1개를 뽑는 메서드
	// 리턴타입으로 카드를 줘야 하므로 리턴타입을 카드로 바꾸기.
	 
	 public Card Pick(){
		return this.cards.pop();
				
	}
	

}
