package domain;

public class ConverterImpl implements Converter {
	private Grid grid;

	public ConverterImpl(Grid grid) {
		if (grid == null) {
			throw new IllegalArgumentException("grid argument cannot be null!");
		}
		this.grid = grid;
	}

	@Override
	public Cell convert(final String x, final String y)
			throws IllegalArgumentException, NumberFormatException {
		if (x == null) {
			throw new IllegalArgumentException("x argument cannot be null!");
		}
		if (y == null) {
			throw new IllegalArgumentException("y argument cannot be null!");
		}
		int i = x.charAt(0) - 'a';
		int j = Integer.parseInt(y);
		return grid.getCell(i, j);
	}

	@Override
	public String[] revert(final Cell cell) throws IllegalArgumentException {
		if (cell == null) {
			throw new IllegalArgumentException("cell argument cannot be null!");
		}
		grid.getCell(cell.getX(), cell.getY());
		String[] toReturn = new String[2];
		char i = (char) cell.getX();
		i += 'a';
		toReturn[0] = i + "";
		toReturn[1] = cell.getY() + "";
		return toReturn;
	}

}
