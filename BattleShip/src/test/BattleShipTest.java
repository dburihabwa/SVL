package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.BattleShip;
import domain.BattleShipImpl;

public class BattleShipTest {

	@Test
	public void testConstructeur() {
		int size = 4;
		BattleShip ship = new BattleShipImpl(size);
		assertEquals(size, ship.hitRemaining());
	}

	@Test
	public void isShipAlive() {
		int size = 4;
		BattleShip ship = new BattleShipImpl(size);
		assertTrue(ship.isAlive());
	}

	@Test
	public void testLosingCells() {
		int size = 5;
		BattleShip ship = new BattleShipImpl(size);
		int count = 0;
		while (ship.hitRemaining() != 0) {
			ship.loseCell();
			count++;
		}

		assertEquals(ship.hitRemaining(), 0);
		assertEquals(size, count);
	}

}
