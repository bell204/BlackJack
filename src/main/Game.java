package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game {
	Stack<Card> cards;
	ArrayList<User> users;
	CardDeck cardDeck;
	Scanner sc;
	User user;
	
	public void play() {
		users = userCount(); // 2명의 플레이어 준비 (ㅇ)
		cardDeck = new CardDeck(); // 52개의 카드를 가진 카드덱 준비 (ㅇ)
		sc = new Scanner(System.in);

		System.out.println("---BlackJack Start---");

		this.cards = initGame(users, cardDeck);	// 2개씩 카드 받았나(ㅇ) 
		this.cards = playGame(sc, users, cardDeck); // 턴 주고 받나(플레이어, 딜러에서 체크)
	
		
		Rule rule = new Rule();  // 승자 가져오나 테스트(ㅇ)
		this.user =rule.selectWinner(users);  
		System.out.println("승자는\n"+this.user.getName()+"입니다");  

	}

	public ArrayList<User> userCount() {
		ArrayList<User> user = new ArrayList<User>();
		user.add(new Dealer());
		user.add(new Player());

		return user;
	}

	
	public Stack<Card> initGame(ArrayList<User> users, CardDeck cardDeck) {
		this.cards = new Stack<Card>();
		
		for (int i = 0; i < 2; i++) {
			for (User user : users) {
				System.out.println(user.getName() + "님 차례입니다");
				Card card = cardDeck.Pick();
				this.cards = user.receiveCard(card);
			}
		}
		return this.cards;
	}

	
	public Stack<Card> playGame(Scanner sc, ArrayList<User> users, CardDeck cardDeck) {
		while (true) { 			// 일단 기본적으로 플레이어 딜러 한번씩만 하고 돌아옴.
			this.cards = OnePairTurn(sc, users, cardDeck, cards);

			if (AllUserGiveUpTurn(users)) {	
				break;
			}
		}
		return this.cards;
	}

	// 입력 값 때문에 테스트 못함. (방법 찾아보기)
	private Stack<Card> OnePairTurn(Scanner sc, ArrayList<User> users, CardDeck cardDeck, Stack<Card> cards) {
		for (User user : users) {
			System.out.println(user.getName() + "님 차례입니다");
			System.out.println("카드를 뽑아주세요. 안 뽑는다면 0번을 눌러주세요");
			int num = sc.nextInt();

			if (num == 0) { // 나가서 다시 for문 처음으로 돌아가고 상대 차례
				user.giveUpTurn(); // false를 저장하고 상대에게 턴 넘김.

			} else if (num != 0) { // 카드 뽑음.
				Card card = cardDeck.Pick();
				cards = user.receiveCard(card);
				user.takeTurn(); // true를 저장
			}
		}
		return cards;
	}
	
	private boolean AllUserGiveUpTurn(ArrayList<User> users) {
		for (User user : users) {
			if (user.doTurn()) { // 저장된 turn을 리턴하는데 한명이라도 true라면
				return false;
			}
		}

		return true;
	}

 

}
