package main;

import java.util.ArrayList;
import java.util.List;

public class DivisionFormula implements IFormula {
	private List<ICell> cells = new ArrayList<>();

	@Override
	public void addCell(ICell cell) {
		cells.add(cell);
	}

	@Override
	public Object eval() {
		double result = 0;
		int i = 0;
		for (; i < cells.size(); i++) {
			if (cells.get(i).getValueType() == ICell.VALUE.NUMERIC) {
				result = Double.parseDouble(cells.get(i).getValue().toString());
				i++;
				break;
			}
		}

		for (; i < cells.size(); i++) {
			if (cells.get(i).getValueType() == ICell.VALUE.NUMERIC) {
				double d = Double.parseDouble(cells.get(i).getValue()
						.toString());
				//TODO exception
				if (d != 0.0)
					result /= Double.parseDouble(cells.get(i).getValue()
							.toString());
			}
		}

		return result;

	}
}
