class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rows = new HashSet<>();
        Set<String> cols = new HashSet<>();
        Set<String> squares = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char curr = board[row][col];
                if (curr == '.') {
                    continue;
                }

                String rowKey = row + " row " + curr;
                String colKey = col + " col " + curr;
                String sqKey = row / 3 + " row : " + col / 3 + " col " + curr;

                if (!rows.add(rowKey) || !cols.add(colKey) || !squares.add(sqKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
