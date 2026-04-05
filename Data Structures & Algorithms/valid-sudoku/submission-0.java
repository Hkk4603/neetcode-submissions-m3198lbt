class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> s = new HashSet<>(); 
        for (int i = 0; i < board.length; i++) { 
            for ( int j = 0; j < board[0].length; j++ ) {
                if (board[i][j] != '.') {
                    boolean addRow = s.add(board[i][j] + " found in row i = " + i );
                    boolean addCol = s.add(board[i][j] + " found in col j = " + j ); 
                    boolean addBox = s.add(board[i][j] + " found in box = " + (i/3) + " , " + (j/3));
                    if (!addRow || !addCol || !addBox) {
                        return false; 
                    }
                }
            }
        }

        return true; 
    }
}
