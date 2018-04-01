package test;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import main.Card;
import main.CardDeck;
import main.Pattern;
import main.Symbol;

public class CardDeckTest {

	private Stack<Card> cards;
	CardDeck cardDeck;

	@Test
	public void CardDeck_생성자_Test(){
		// 카드덱에서 카드 52개를 가지고 있는지 테스트
		cardDeck = new CardDeck();
		cards=cardDeck.generateCard();
		
		// 예상값, 실제값
		Assert.assertEquals(52, cards.size());
	}
	
}
