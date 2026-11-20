class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char curr = board[r][c];
                if (curr == '.') {
                    continue;
                }

                String rowKey = curr + "in row " + r;
                String colKey = curr + "in col " + c;
                String boxKey = curr + "in box " + (r / 3) + " - " + (c / 3);

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
