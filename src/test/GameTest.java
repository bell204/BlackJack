package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import main.Card;
import main.CardDeck;
import main.Game;
import main.Rule;
import main.User;

public class GameTest {
	Game game;
	ArrayList<User> users; 
	CardDeck cardDeck;
	Stack<Card> cards;
	Scanner sc;
	User highestUser;
	
	
	@Test 
	public void UserCount_Test(){ // 2명의 플레이어 준비
		game = new Game();
		this.users= game.userCount();
		Assert.assertEquals(2, game.userCount().size());
	}
	
	
	@Test
	public void initGame_Test(){  // 카드 2장 받나 테스트
	game =new Game();
	cardDeck= new CardDeck();  
	
	game.initGame(game.userCount(), cardDeck);
	Assert.assertEquals(2, game.initGame(game.userCount(), cardDeck).size());
	}

	@Test // 승자 가져오나 테스트
	public void User_selectWinner_Test(){ 
		game = new Game(); // 객체를 불러와야 테스트 가능.
		Rule rule = new Rule();
		rule.selectWinner(game.userCount());
		Assert.assertEquals(highestUser, rule.selectWinner(game.userCount()));
	}
 
 
	
}
