package domain;

import java.util.HashSet;
import java.util.Set;

import domain.Grid.AXIS;
import exceptions.CellOccupiedException;

public class GameImpl implements Game {
	private Grid grid;
	private Set<BattleShip> battleShips;

	public GameImpl(Grid grid) {
		this.grid = grid;
		this.battleShips = new HashSet<>();
	}

	@Override
	public boolean isOnGoing() {
		for (BattleShip ship : battleShips) {
			if (ship.isAlive()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean bomb(Cell cell) {
		return grid.getCell(cell.getX(), cell.getY()).bomb();
	}

	@Override
	public boolean addBattleShip(BattleShip ship, Cell cell, AXIS axis)
			throws CellOccupiedException {
		grid.placeShip(ship, cell, axis);
		return battleShips.add(ship);
	}

	@Override
	public String toString() {
		return grid.toString();
	}

}
