package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.junit.Test;

import domain.Cell;
import domain.Converter;
import domain.ConverterImpl;
import domain.Grid;

public class ConverterTest extends TestCase {

	@Test
	public void testConvert() {
		Grid grid = mock(Grid.class, "grid");
		Cell cell = mock(Cell.class, "cell");
		when(grid.getCell(0, 0)).thenReturn(cell);
		Converter converter = new ConverterImpl(grid);
		assertEquals(cell, converter.convert("a", "0"));
	}

	@Test
	public void testRevert() {
		Grid grid = mock(Grid.class, "grid");
		Cell cell = mock(Cell.class, "cell");
		when(grid.getCell(0, 0)).thenReturn(cell);
		when(cell.getX()).thenReturn(1);
		when(cell.getY()).thenReturn(0);
		Converter converter = new ConverterImpl(grid);
		String[] coordinates = converter.revert(cell);
		assertEquals("b", coordinates[0]);
		assertEquals("0", coordinates[1]);
	}
}
