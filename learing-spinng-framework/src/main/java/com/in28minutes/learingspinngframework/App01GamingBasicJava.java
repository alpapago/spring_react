package com.in28minutes.learingspinngframework;

import com.in28minutes.learingspinngframework.game.GameRunner;
import com.in28minutes.learingspinngframework.game.MarioGame;
import com.in28minutes.learingspinngframework.game.PacmanGame;
import com.in28minutes.learingspinngframework.game.SuperContraGame;

public class App01GamingBasicJava {
	public static void main(String[] args) {
		
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacmanGame(); // 1 : Object Creation
		var gameRunner = new GameRunner(game); 
			// 2 : Object Creation + Wiring of Dependencies
			// Game is a Dependency of GameRunner : 스프링이 하게 할 수 있음.
		
			
		gameRunner.run();
	
	}
}
