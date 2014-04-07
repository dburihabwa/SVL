package domain;

import exceptions.CellOccupiedException;

public interface Grid {
	public enum AXIS {
		VERTICAL, HORIZONTAL
	}

	Cell getCell(int x, int y);

	boolean placeShip(BattleShip ship, Cell cell, Grid.AXIS axis)throws CellOccupiedException;

}
