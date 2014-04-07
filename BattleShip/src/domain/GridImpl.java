package domain;

import exceptions.CellOccupiedException;

public class GridImpl implements Grid {
	private int x;
	private int y;
	private Cell[][] cells;

	public GridImpl(int x, int y) {
		if (x <= 0) {
			throw new IllegalArgumentException("x cannot be <= 0");
		}
		if (y <= 0) {
			throw new IllegalArgumentException("y cannot be <= 0");
		}
		this.x = x;
		this.y = y;
		cells = new Cell[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				cells[i][j] = new Cell((char) i, (char) j);
			}
		}
	}

	@Override
	public Cell getCell(int i, int j) {
		if (i < 0 || this.x <= i) {
			throw new IllegalArgumentException("x out of bounds");
		}
		if (j < 0 || this.y <= j) {
			throw new IllegalArgumentException("y out of bounds");
		}
		return this.cells[i][j];
	}

	@Override
	public boolean placeShip(BattleShip ship, Cell cell, Grid.AXIS axis)
			throws CellOccupiedException {
		if (ship == null) {
			throw new IllegalArgumentException("ship cannot be null!");
		}
		if (cell == null) {
			throw new IllegalArgumentException("cell cannot be null!");
		}
		if (axis == null) {
			throw new IllegalArgumentException("axis cannot be null!");
		}

		if (cell.getX() < 0 || this.x <= cell.getX()) {
			throw new IllegalArgumentException("cell is out of bounds!");
		}
		if (cell.getY() < 0 || this.y <= cell.getY()) {
			throw new IllegalArgumentException("cell is out of bounds!");
		}
		int size = ship.hitRemaining();
		if (axis == Grid.AXIS.HORIZONTAL) {
			if ((cell.getY() + size) > this.y)
				throw new IllegalArgumentException(
						"Ship too long on the vertical axis");
			int i = cell.getY();
			try {
				for (; i < cell.getY() + size; i++) {
					Cell c = cells[cell.getX()][i];
					if (c.getShip() != null)
						throw new CellOccupiedException("Cell (" + cell.getX()
								+ ", " + i + ") is already occupied");
					c.setShip(ship);
				}
			} catch (CellOccupiedException e) {
				for (; i >= cell.getY(); i--) {
					Cell c = cells[cell.getX()][i];
					c.setShip(null);
				}
				throw e;
			}
		} else {
			if ((cell.getX() + size) > this.x)
				throw new IllegalArgumentException(
						"Ship too long on the horizontal axis");
			int i = cell.getX();
			try {
				for (; i < cell.getX() + size; i++) {
					Cell c = cells[i][cell.getY()];
					if (c.getShip() != null)
						throw new CellOccupiedException("Cell (" + i + ", "
								+ cell.getY() + ") is already occupied");
					c.setShip(ship);
				}
			} catch (CellOccupiedException e) {
				for (; i >= cell.getX(); i--) {
					Cell c = cells[i][cell.getY()];
					c.setShip(null);
				}
				throw e;
			}
		}

		return false;
	}
}
