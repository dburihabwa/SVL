package domain;

public interface BattleShip {
	
	int hitRemaining();
	boolean isAlive();
	void loseCell();
}
