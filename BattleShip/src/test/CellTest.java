package test;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import domain.BattleShip;
import domain.Cell;

public class CellTest {
	@Test
	public void testConstructor() {
		int x = 0;
		int y = 0;
		Cell cell = new Cell(x, y);
		Assert.assertFalse(cell.isHit());
		Assert.assertEquals(x, cell.getX());
		Assert.assertEquals(y, cell.getY());
	}

	@Test
	public void testSetHit() {
		int x = 0;
		int y = 0;
		Cell cell = new Cell(x, y);
		Assert.assertFalse(cell.isHit());
		BattleShip ship = mock(BattleShip.class, "ship");
		cell.setShip(ship);
		Assert.assertTrue(cell.bomb());
		Assert.assertTrue(cell.isHit());
		Assert.assertFalse(cell.bomb());
		verify(ship, times(1)).loseCell();
	}

	@Test
	public void testToChar() {
		int x = 0;
		int y = 0;
		Cell cell = new Cell(x, y);
		Assert.assertEquals(Cell.SEA, cell.toChar());
		BattleShip ship = mock(BattleShip.class, "ship");
		when(ship.isAlive()).thenReturn(true);
		cell.setShip(ship);
		Assert.assertEquals(Cell.SEA, cell.toChar());
		cell.bomb();
		Assert.assertEquals(Cell.SHIP_HIT, cell.toChar());
		when(ship.isAlive()).thenReturn(false);
		Assert.assertEquals(Cell.SHIP_DESTROYED, cell.toChar());
		Cell cell2 = new Cell(x, y);
		cell2.bomb();
		Assert.assertEquals(Cell.MISSED_SHOT, cell2.toChar());
	}

}
