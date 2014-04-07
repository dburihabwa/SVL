package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import domain.BattleShip;
import domain.Cell;
import domain.Grid;
import domain.Grid.AXIS;
import domain.GridImpl;
import exceptions.CellOccupiedException;

public class GridTest {

	@Test(expected = IllegalArgumentException.class)
	public void testWrongX() {
		int x = -1, y = 10;
		new GridImpl(x, y);
		fail("should not reach this line!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongY() {
		int x = 10, y = -1;
		new GridImpl(x, y);
		fail("should not reach this line!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetWrongX() {
		int x = 1, y = 1;
		Grid grid = new GridImpl(x, y);
		grid.getCell(x, y - 1);
		fail("should not reach this line!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetWrongY() {
		int x = 1, y = 1;
		Grid grid = new GridImpl(x, y);
		grid.getCell(x - 1, y);
		fail("should not reach this line!");
	}

	@Test
	public void testGetCell() {
		int x = 2, y = 2;
		int i = x - 1, j = y - 1;
		Grid grid = new GridImpl(x, y);
		Cell cell = grid.getCell(i, j);
		assertEquals(i, cell.getX());
		assertEquals(j, cell.getY());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetShipOutOfBoundsX() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);
		BattleShip ship = mock(BattleShip.class, "ship");
		Cell cell = mock(Cell.class, "cell");
		when(cell.getX()).thenReturn(x);
		when(cell.getY()).thenReturn(y - 1);
		try {
			grid.placeShip(ship, cell, Grid.AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetShipOutOfBoundsY() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);
		BattleShip ship = mock(BattleShip.class, "ship");
		Cell cell = mock(Cell.class, "cell");
		when(cell.getX()).thenReturn(x - 1);
		when(cell.getY()).thenReturn(y);
		try {
			grid.placeShip(ship, cell, Grid.AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetShipNull() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);
		BattleShip ship = null;
		Cell cell = mock(Cell.class, "cell");
		when(cell.getX()).thenReturn(x - 1);
		when(cell.getY()).thenReturn(y - 1);
		try {
			grid.placeShip(ship, cell, Grid.AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCellNull() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);
		BattleShip ship = mock(BattleShip.class, "ship");
		Cell cell = null;
		try {
			grid.placeShip(ship, cell, Grid.AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAxisNull() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);
		BattleShip ship = mock(BattleShip.class, "ship");
		Cell cell = mock(Cell.class, "cell");
		when(cell.getX()).thenReturn(x - 1);
		when(cell.getY()).thenReturn(y - 1);
		try {
			grid.placeShip(ship, cell, null);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = CellOccupiedException.class)
	public void testSetShipOccupiedY() throws CellOccupiedException {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);

		BattleShip ship2 = mock(BattleShip.class, "ship2");
		when(ship2.hitRemaining()).thenReturn(y - 1);
		Cell cell2 = new Cell(1, 0);
		try {
			grid.placeShip(ship2, cell2, AXIS.VERTICAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}

		BattleShip ship = mock(BattleShip.class, "ship");
		when(ship.hitRemaining()).thenReturn(y);
		Cell cell = new Cell(0, 0);
		grid.placeShip(ship, cell, AXIS.VERTICAL);
		assertEquals(null, grid.getCell(cell.getX(), cell.getY()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetShipTooLongY() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);
		BattleShip ship = mock(BattleShip.class, "ship");
		when(ship.hitRemaining()).thenReturn(y + 1);
		Cell cell = new Cell(0, 0);
		try {
			grid.placeShip(ship, cell, AXIS.VERTICAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetShipTooLongX() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);
		BattleShip ship = mock(BattleShip.class, "ship");
		when(ship.hitRemaining()).thenReturn(x + 1);
		Cell cell = new Cell(0, 0);
		try {
			grid.placeShip(ship, cell, AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = CellOccupiedException.class)
	public void testSetShipOccupiedX() throws CellOccupiedException {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);

		BattleShip ship2 = mock(BattleShip.class, "ship2");
		when(ship2.hitRemaining()).thenReturn(x - 1);
		Cell cell2 = new Cell(0, 1);
		try {
			grid.placeShip(ship2, cell2, AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}

		BattleShip ship = mock(BattleShip.class, "ship");
		when(ship.hitRemaining()).thenReturn(x);
		Cell cell = new Cell(0, 0);
		grid.placeShip(ship, cell, AXIS.HORIZONTAL);
	}

	@Test
	public void testSetShip() {
		int x = 2, y = 2;
		Grid grid = new GridImpl(x, y);

		BattleShip ship2 = mock(BattleShip.class, "ship2");
		when(ship2.hitRemaining()).thenReturn(x);
		Cell cell2 = new Cell(0, 0);
		try {
			grid.placeShip(ship2, cell2, AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}

		BattleShip ship = mock(BattleShip.class, "ship");
		when(ship.hitRemaining()).thenReturn(x);
		Cell cell = new Cell(1, 0);

		try {
			grid.placeShip(ship, cell, AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			fail(e.getMessage());
		}
		assertEquals(ship2, grid.getCell(cell2.getX(), cell2.getY()).getShip());
		assertEquals(ship2, grid.getCell(cell2.getX(), cell2.getY() + 1)
				.getShip());

		assertEquals(ship, grid.getCell(cell.getX(), cell.getY()).getShip());
		assertEquals(ship, grid.getCell(cell.getX(), cell.getY() + 1).getShip());
	}

}
