package boardgame;

public class Position {
	
	private char column;
	private int row;
	
	public Position(char column, int row) {
		this.column = column;
		this.row = row;
	}

	public int getColumn() {
		return column;
	}
	
	public void setColumn(char column) {
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	@Override
	public String toString() {
		
		return  String.format("%s%d%n", column,row);		
	}
}
