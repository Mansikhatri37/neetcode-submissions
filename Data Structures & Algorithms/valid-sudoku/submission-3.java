class Solution {
    public boolean isValidSudoku(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        
        for(int row = 0 ; row < n ; row++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0 ; j < m ; j++){
                if(board[row][j] == '.')continue;
                if(seen.contains(board[row][j])){
                    return false;
                }
                seen.add(board[row][j]);
            }
        }

        for(int col = 0 ; col < n ; col++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0 ; j < m ; j++){
                if(board[j][col] == '.')continue;
                if(seen.contains(board[j][col])){
                    return false;
                }
                seen.add(board[j][col]);
            }
        }

        for(int square = 0 ; square < 9 ; square++){
            HashSet<Character> seen = new HashSet<>();
            for(int i = 0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){

                    int row = (square/3)*3 + i ;
                    int col = (square%3)*3 + j ;

                    if(board[row][col] == '.')continue;

                    if(seen.contains(board[row][col])){
                        return false;
                    }

                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
