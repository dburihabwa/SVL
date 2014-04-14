package main;

public interface ICell {
	public enum VALUE {
		NUMERIC, STRING, FORMULA
	}

	public boolean isEmpty();

	public VALUE getValueType();

	public Object getValue();

	public void setValue(Object value);

	public void add(ICell cell);

	public void remove(ICell cell);

	public void notifyUpdate();
	
	public void update();
}
