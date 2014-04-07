package domain;

import domain.Grid.AXIS;
import exceptions.CellOccupiedException;

public interface Game {
	boolean isOnGoing();

	boolean addBattleShip(BattleShip ship, Cell cell, AXIS axis)
			throws CellOccupiedException;

	boolean bomb(Cell cell);
}
