package main;

import java.util.ArrayList;
import java.util.List;

public class AddFormula implements IFormula {
	private List<ICell> cells = new ArrayList<>();

	@Override
	public void addCell(ICell cell) {
		cells.add(cell);
	}

	@Override
	public Object eval() {
		double result = 0;
		for (ICell c : cells) {
			if (c.getValueType() == ICell.VALUE.NUMERIC)
				result += Double.parseDouble(c.getValue().toString());
		}
		return result;

	}

}
