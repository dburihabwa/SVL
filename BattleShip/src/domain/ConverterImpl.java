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
	public Cell convert(char x, char y) {
		int i = x - 'a';
		int j = Integer.parseInt(y + "");
		return grid.getCell(i, j);
	}

	@Override
	public char[] revert(Cell cell) {
		// TODO Auto-generated method stub
		return null;
	}

}
