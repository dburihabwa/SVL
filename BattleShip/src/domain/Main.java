package domain;

import java.util.Scanner;

import domain.Grid.AXIS;
import exceptions.CellOccupiedException;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grid grid = new GridImpl(10, 12);
		Game game = new GameImpl(grid);

		BattleShip porteAvions = new BattleShipImpl(5);
		BattleShip croiseur = new BattleShipImpl(4);
		BattleShip contreTorpilleur = new BattleShipImpl(3);
		BattleShip sousMarin = new BattleShipImpl(3);
		BattleShip torpilleur = new BattleShipImpl(2);
		try {
			game.addBattleShip(porteAvions, grid.getCell(0, 0), AXIS.HORIZONTAL);
			game.addBattleShip(croiseur, grid.getCell(1, 0), AXIS.HORIZONTAL);
			game.addBattleShip(contreTorpilleur, grid.getCell(2, 0),
					AXIS.HORIZONTAL);
			game.addBattleShip(sousMarin, grid.getCell(3, 0), AXIS.HORIZONTAL);
			game.addBattleShip(torpilleur, grid.getCell(4, 0), AXIS.HORIZONTAL);
		} catch (CellOccupiedException e) {
			e.printStackTrace();
		}
		Converter converter = new ConverterImpl(grid);

		while (game.isOnGoing()) {
			System.out.println(game);
			System.out.println("Entrez une case!");
			System.out.print("> ");
			String input = scanner.nextLine().trim();
			if (input.isEmpty()) {
				continue;
			}
			String[] tokens = input.split("\\W+");
			Cell cell = null;
			if (tokens.length != 2) {
				System.err
						.println("You need to provide the coordinates (x and y) of the cell you want to bomb!");
				continue;
			}
			try {
				cell = converter.convert(tokens[0], tokens[1]);
			} catch (NumberFormatException e) {
				System.err
						.println("Could not interpret the y parameter (needs to be a number)");
				continue;
			} catch (IllegalArgumentException e) {

				System.err.println(e.getMessage());
				continue;
			}
			boolean success = game.bomb(cell);
			if (success) {
				System.out.println("bim!");
			} else {
				System.out.println("plouf!");
			}
		}
		System.out.println(game);
		System.out.println("Great success!");
	}
}
