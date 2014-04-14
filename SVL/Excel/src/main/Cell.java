package main;

import java.util.HashSet;
import java.util.Set;

public class Cell implements ICell {
	private Object value;
	private Set<ICell> cells = new HashSet<>();

	@Override
	public boolean isEmpty() {
		return value == null;
	}

	@Override
	public VALUE getValueType() {
		if (value == null) {
			return VALUE.NUMERIC;
		}
		if ((value instanceof String)) {
			return VALUE.STRING;
		}
		if ((value instanceof IFormula)) {
			return VALUE.FORMULA;
		}
		try {
			Double.parseDouble(value.toString());
			return VALUE.NUMERIC;
		} catch (NumberFormatException e) {
			return VALUE.STRING;
		}
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public void add(ICell cell) {
		if (cell == null) {
			throw new IllegalArgumentException("cell argument cannot be null!");
		}
		cells.add(cell);
	}

	@Override
	public void remove(ICell cell) {
		if (cell == null) {
			throw new IllegalArgumentException("cell argument cannot be null!");
		}
		cells.remove(cell);
	}

	@Override
	public void notifyUpdate() {
		for (ICell cell : cells) {
			cell.update();
		}
	}

	@Override
	public void update() {
		if (getValueType() == VALUE.FORMULA) {
			IFormula formula = (IFormula) value;
			formula.eval();
		}
	}

}
