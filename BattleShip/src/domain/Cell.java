package domain;

public class Cell {
	private int x;
	private int y;
	private boolean hit;
	private BattleShip ship;

	public static final char SEA = '~';
	public static final char MISSED_SHOT = '@';
	public static final char SHIP_HIT = 'X';
	public static final char SHIP_DESTROYED = '#';

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isHit() {
		return hit;
	}

	public boolean bomb() {
		if (this.ship != null && !this.hit) {
			this.hit = true;
			this.ship.loseCell();
			return true;
		}
		if (!this.hit) {
			this.hit = true;
			return true;
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BattleShip getShip() {
		return ship;
	}

	public void setShip(BattleShip ship) {
		this.ship = ship;
	}

	public char toChar() {
		if (this.hit) {
			if (this.ship != null) {
				if (this.ship.isAlive()) {
					return SHIP_HIT;
				} else {
					return SHIP_DESTROYED;
				}
			}
			return MISSED_SHOT;
		}
		return SEA;
	}

}
