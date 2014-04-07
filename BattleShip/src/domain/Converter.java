package domain;

public interface Converter {
	Cell convert(char x, char y);

	char[] revert(Cell cell);
}
