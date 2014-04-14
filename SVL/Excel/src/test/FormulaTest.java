package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import main.AddFormula;
import main.Cell;
import main.DivisionFormula;
import main.ICell;
import main.IFormula;
import main.MultiplyFormula;
import main.SubstractFormula;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class FormulaTest {
	@Test
	public void testFormulaAddCell() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new AddFormula();
		formula.addCell(cell);
		formula.addCell(cell2);
		assertEquals(6.0,(double)formula.eval(),0.01);
		
	}
	
	@Test
	public void testFormulaAddCommutative() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new AddFormula();
		formula.addCell(cell2);
		formula.addCell(cell);
		assertEquals(6.0,(double)formula.eval(),0.01);
		
	}
	
	@Test
	public void testFormulaSubstractCell() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new SubstractFormula();
		formula.addCell(cell);
		formula.addCell(cell2);
		assertEquals(2.0,(double)formula.eval(),0.01);
		
	}
	
	@Test
	public void testFormulaSubstractNotComutative() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new SubstractFormula();
		formula.addCell(cell2);
		formula.addCell(cell);
		assertEquals(-2.0,(double)formula.eval(),0.01);
		
	}
	
	@Test
	public void testFormulaMultiplyCell() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new MultiplyFormula();
		formula.addCell(cell);
		formula.addCell(cell2);
		assertEquals(8.0,(double)formula.eval(),0.01);
		
	}
	
	@Test
	public void testFormulaMultiplyCommutativeCell() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new MultiplyFormula();
		formula.addCell(cell2);
		formula.addCell(cell);
		assertEquals(8.0,(double)formula.eval(),0.01);
		
	}
	
	@Test
	public void testFormulaDivisionCell() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new DivisionFormula();
		formula.addCell(cell);
		formula.addCell(cell2);
		assertEquals(2.0,(double)formula.eval(),0.01);
		
	}
	
	@Test
	public void testFormulaDivisionNotCommutativeCell() {
		ICell cell = mock(ICell.class,"cell1");
		when(cell.getValue()).thenReturn(4);
		when(cell.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		ICell cell2 = mock(ICell.class,"cell2");
		when(cell2.getValue()).thenReturn(2);
		when(cell2.getValueType()).thenReturn(ICell.VALUE.NUMERIC);
		
		IFormula formula = new DivisionFormula();
		formula.addCell(cell2);
		formula.addCell(cell);
		assertEquals(0.5,(double)formula.eval(),0.01);
	}
	
	
	
	
}
