package com.in28minutes.learingspinngframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learingspinngframework.game.GameRunner;
import com.in28minutes.learingspinngframework.game.GamingConsole;
import com.in28minutes.learingspinngframework.game.MarioGame;
import com.in28minutes.learingspinngframework.game.PacmanGame;
import com.in28minutes.learingspinngframework.game.SuperContraGame;

public class App03GamingSpringBeans {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(GamingConfiguration.class)){
			
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}
		
	
	
	}
}
