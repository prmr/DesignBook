/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 2nd edition by Martin P. Robillard.
 *
 * Copyright (C) 2022 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e3.chapter5;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class TestGameModel {
	
	static class StubStrategy implements PlayingStrategy {
		
		private boolean aExecuted = false;
		
		public boolean hasExecuted() { 
			return aExecuted; 
		}
		
		public Move computeNextMove(GameModelView pModelView) {
			aExecuted = true;
			return new NullMove();
		}
	}
	
	@Test
	void testTryToAutoPlay() {
		try {
			Field strategyField = GameModel.class.getDeclaredField("aPlayingStrategy");
			strategyField.setAccessible(true);
			StubStrategy strategy = new StubStrategy();
			GameModel model = GameModel.instance();
			strategyField.set(model, strategy);
			model.tryToAutoPlay();
			assertTrue(strategy.hasExecuted());
		}
		catch( ReflectiveOperationException e ) {
			fail();
		}
	}
}
