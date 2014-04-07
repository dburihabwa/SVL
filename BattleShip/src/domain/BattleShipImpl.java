package domain;


public class BattleShipImpl implements BattleShip {

	private int cellsRemaining;

	public BattleShipImpl(int size) {
		this.cellsRemaining = size;
	}

	@Override
	public int hitRemaining() {
		return cellsRemaining;
	}

	@Override
	public boolean isAlive() {
		return cellsRemaining > 0;
	}

//	@Override
//	public boolean addCell(Cell cell) {
//		if (cell == null) {
//			throw new IllegalArgumentException("cell argument cannot be null;");
//		}
//		if (cells.size() == cellsRemaining) {
//			return false;
//		}
//		if (cells.isEmpty()) {
//			return cells.add(cell);
//		}
//		// if (cells.size() == 1) {
//		// Cell first = cells.get(0);
//		// int diffX = (int) cell.getX() - (int) first.getX();
//		// int diffY = (int) cell.getY() - (int) first.getY();
//		// if (((diffX == -1 || diffX == 1) && diffY == 0)
//		// && ((diffY == -1 || diffY == 1) && diffX == 0)) {
//		// return cells.add(cell);
//		// }
//		// return false;
//		// }
//		//
//		// boolean verticalAxis;
//		// int varX = 0, varY;
//		//
//		// int diffX = (int) cells.get(0).getX() - (int) cells.get(1).getX();
//		// if (diffX == 0) {
//		// verticalAxis = true;
//		// } else {
//		// verticalAxis = false;
//		// }
//		//
//		// int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//		// for (Cell c : cells) {
//		// if (verticalAxis) {
//		// if (max < c.getY()) {
//		// max = c.getY();
//		// }
//		// if (c.getY() < min) {
//		// min = c.getY();
//		// }
//		// } else {
//		// if (max < c.getX()) {
//		// max = c.getX();
//		// }
//		// if (c.getX() < min) {
//		// min = c.getX();
//		// }
//		// }
//		// }
//		//
//		// if (verticalAxis) {
//		//
//		// }
//
//		return this.cells.add(cell);
//	}

	@Override
	public void loseCell() {
		if (cellsRemaining > 0)
			cellsRemaining--;
	}

}
