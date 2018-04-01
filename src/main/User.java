package main;

import java.util.Stack;

public interface User {

	String getName();
	Stack<Card> receiveCard(Card card); // 플레이어와 딜러가 카드를 받습니다.
	void checkCard(); 	// 받은 카드를 게임운영자는 확인할 수 있습니다.
	void takeTurn();    // 한명이 턴을 받습니다.
	void giveUpTurn();  // 한명이 턴을 포기합니다.
	void setTurn(boolean b); // 턴 저장
	boolean doTurn();
	Stack<Card> openCards();   // 승자를 가리기 위해 보유한 카드를 오픈합니다.
	
}
