package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.junit.Test;

import domain.BattleShip;
import domain.Cell;
import domain.Game;
import domain.GameImpl;
import domain.Grid;
import domain.Grid.AXIS;
import exceptions.CellOccupiedException;

public class GameTest extends TestCase {
	@Test
	public void testEndGame() {
		Grid grid = mock(Grid.class, "grid");
		Game game = new GameImpl(grid);
		BattleShip ship = mock(BattleShip.class, "ship");
		Cell cell = mock(Cell.class, "cell");
		when(ship.isAlive()).thenReturn(true);
		try {
			when(grid.placeShip(ship, cell, AXIS.HORIZONTAL)).thenReturn(true);
			game.addBattleShip(ship, cell, AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
		assertTrue(game.isOnGoing());
		when(ship.isAlive()).thenReturn(false);
		assertFalse(game.isOnGoing());
	}
}
