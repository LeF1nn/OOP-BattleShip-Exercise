public class Cordinate {

    private int startRow, endRow, startCol, endCol;

    public Cordinate(int startRow, int endRow, int startCol, int endCol) {
        this.startRow = startRow;
        this.endRow = endRow;
        this.startCol = startCol;
        this.endCol = endCol;
    }

    public int getStartRow() {
        return startRow;
    }
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    public int getEndRow() {
        return endRow;
    }
    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }
    public int getStartCol() {
        return startCol;
    }
    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }
    public int getEndCol() {
        return endCol;
    }
    public void setEndCol(int endCol) {
        this.endCol = endCol;
    }
    public boolean isValid(String input) {

        if (input.length() == 2) {
            return (input.charAt(0) >= 'A' && input.charAt(0) <= 'J') && (input.charAt(1) >= '0' && input.charAt(1) <= '9');
        }
        return false;

    }
}
