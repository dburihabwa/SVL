package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

import main.Cell;
import main.ICell;
import main.IFormula;

import org.junit.Test;

public class CellTest {

	@Test
	public void testCellEmptyAtCreation() {
		ICell cell = new Cell();
		assertTrue(cell.isEmpty());
	}
	
	@Test
	public void testCellNotEmpty() {
		ICell cell = new Cell();
		Integer value = 6;
		cell.setValue(value);
		assertFalse(cell.isEmpty());
	}
	
	@Test
	public void testCellsEmptyHasNumericValue() {
		ICell cell = new Cell();
		assertEquals(ICell.VALUE.NUMERIC, cell.getValueType());
	}
	
	@Test
	public void testCellsNumericValue() {
		ICell cell = new Cell();
		Integer value = 19;
		cell.setValue(value);
		assertEquals(ICell.VALUE.NUMERIC, cell.getValueType());
		assertEquals(value, (Integer) cell.getValue());
	}
	
	@Test
	public void testCellsStringValue() {
		ICell cell = new Cell();
		String value = "text";
		cell.setValue(value);
		assertEquals(ICell.VALUE.STRING, cell.getValueType());
		assertEquals(value, (String) cell.getValue());
	}
	
	@Test
	public void testCellsFormulaValue() {
		ICell cell = new Cell();
		IFormula value = mock(IFormula.class, "formula");
		cell.setValue(value);
		assertEquals(ICell.VALUE.FORMULA, cell.getValueType());
	}
	
	@Test
	public void testCellsUpdate() {
		ICell cell = new Cell();
		ICell dependingCell = mock(ICell.class, "depending");
		cell.add(dependingCell);
		cell.notifyUpdate();
		verify(dependingCell, atLeastOnce()).update();
	}
	
	
	

}
