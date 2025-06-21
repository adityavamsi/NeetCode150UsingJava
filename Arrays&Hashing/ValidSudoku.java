class Question {
    // LC - 36
    /*You are given a 9 x 9 Sudoku board board.
    A Sudoku board is valid if the following rules are followed:

        Each row must contain the digits 1-9 without duplicates.
        Each column must contain the digits 1-9 without duplicates.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
        Return true if the Sudoku board is valid, otherwise return false

        Note: A board does not need to be full or be solvable to be valid.

        Example 1:



        Input: board =
                [["1","2",".",".","3",".",".",".","."],
                ["4",".",".","5",".",".",".",".","."],
                [".","9","8",".",".",".",".",".","3"],
                ["5",".",".",".","6",".",".",".","4"],
                [".",".",".","8",".","3",".",".","5"],
                ["7",".",".",".","2",".",".",".","6"],
                [".",".",".",".",".",".","2",".","."],
                [".",".",".","4","1","9",".",".","8"],
                [".",".",".",".","8",".",".","7","9"]]

        Output: true
        Example 2:

        Input: board =
                [["1","2",".",".","3",".",".",".","."],
                ["4",".",".","5",".",".",".",".","."],
                [".","9","1",".",".",".",".",".","3"],
                ["5",".",".",".","6",".",".",".","4"],
                [".",".",".","8",".","3",".",".","5"],
                ["7",".",".",".","2",".",".",".","6"],
                [".",".",".",".",".",".","2",".","."],
                [".",".",".","4","1","9",".",".","8"],
                [".",".",".",".","8",".",".","7","9"]]

        Output: false
        Explanation: There are two 1's in the top-left 3x3 sub-box.

        Constraints:

        board.length == 9
        board[i].length == 9
        board[i][j] is a digit 1-9 or '.'.
        */
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0;i<9;i++){
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;

                char val = board[i][j];
                int boxInd = (i/3)*3+(j/3);

                if(rows[i].contains(val) || cols[j].contains(val) ||
                        boxes[boxInd].contains(val)) return false;

                rows[i].add(val);
                cols[j].add(val);
                boxes[boxInd].add(val);
            }
        }
        return true;
    }
}
