package domain;

public interface Converter {
	Cell convert(String x, String y) throws IllegalArgumentException,
			NumberFormatException;

	String[] revert(Cell cell) throws IllegalArgumentException;
}
