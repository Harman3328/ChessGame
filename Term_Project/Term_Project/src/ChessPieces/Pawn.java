package ChessPieces;

public class Pawn extends Pieces {
    String name;
    int value;
    String colour;
    boolean en_passant;
    boolean moved;

    public Pawn(String colour) {
        this.colour = colour;
        name = setName();
        value = setValue();
        en_passant = false;
    }
    /**
     * returns name of piece
     * colour false = white -> lowercase
     * colour ture = black -> uppercase
     * @return P
     */
    @Override
    public String setName() {
        if (colour.equals("black")) {
            return "P";
        } else {
            return "p";
        }
    }

    /**
     * return value of piece
     *
     * @return -10 for black, 10 for white
     */
    @Override
    public int setValue() {
        if (colour.equals("black")) {
            return -10;
        } else {
            return 10;
        }
    }

    /**
     * return value of piece
     * @return
     */
    @Override
    public int getValue() {return value;}

    /**
     * returns name of piece
     * @return
     */
    @Override
    public String getName() {return name;}

    /**
     * return true for black piece, false for white piece
     * @return
     */
    @Override
    public String getColour() {return colour;}

    /**
     * checks if en-passant is possible
     *
     * @return
     */
    @Override
    public boolean getEnPassant() {
        return en_passant;
    }

    /**
     * sets en-passant
     *
     * @param possible
     * @return
     */
    @Override
    public void setEnPassant(boolean possible) {
        en_passant = possible;
    }

    /**
     * sets moved to true is piece moved from its starting position
     *
     * @param moved1
     */
    @Override
    public void setMoved(boolean moved1) {
        moved = moved1;
    }

    /**
     * returns true is piece has moved from its starting position
     *
     * @return
     */
    @Override
    public boolean getMoved() {
        return moved;
    }

    /**
     * return new position of pawn after moving one space
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] upOne(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};
        if (board[y][x].getColour().equals("white") && (y-1>=0)) {
            if (board[y-1][x].getColour().equals("empty")) {
                move[0] = x;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y+1 < board.length)) {
            if (board[y+1][x].getColour().equals("empty")) {
                move[0] = x;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns new position of pawn after moving 2 spaces
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] upTwo(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};
        if (board[y][x].getColour().equals("white") && (y-2) >= 0) {
            if (board[y-1][x].getColour().equals("empty") && board[y-2][x].getColour().equals("empty") &&
                    !getMoved(x, y, board)) {
                move[0] = x;
                move[1] = y-2;
                move[2] = x;
                move[3] = y;
                board[y][x].setEnPassant(true);
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y+2) < board.length) {
            if (board[y+1][x].getColour().equals("empty") && board[y+2][x].getColour().equals("empty") &&
                    !getMoved(x,y, board)) {
                move[0] = x;
                move[1] = y+2;
                move[2] = x;
                move[3] = y;
                board[y][x].setEnPassant(true);
                return move;
            }
        }
        return move;
    }

    /**
     * captures a piece one space diagonally to the right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] captureRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (x+1<board.length) && (y-1>=0)) {
            if (board[y-1][x+1].getColour().equals("black")) {
                move[0] = x+1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (x+1<board.length) && (y+1< board.length)) {
            if (board[y+1][x+1].getColour().equals("white")) {
                move[0] = x+1;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * captures a piece diagonally to the left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] captureLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (x-1 >=0) && (y-1 >= 0)) {
            if (board[y-1][x-1].getColour().equals("black")) {
                move[0] = x-1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (x-1 >=0) && (y+1 < board.length)) {
            if (board[y+1][x-1].getColour().equals("white")) {
                move[0] = x-1;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * checks if pawn is in starting position
     * @param x
     * @param y
     */
    private static boolean getMoved(int x, int y, Pieces[][] board) {
        boolean b = x == 0 || x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7;
        if (board[y][x].getColour().equals("white") && (y==6) && b) {
            return false;
        } else if (board[y][x].getColour().equals("black") && (y==1) && b) {
            return false;
        }
        return true;
    }

    /**
     * sets all pawns en-passant to false expect for the pawn that moved
     * @param board
     * @param x
     * @param y
     */
    public static void setAllEnPassantFalse(Pieces[][] board, int x, int y) {
        if (x==-1 && y==-1) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j].getName().equals("p") || board[i][j].equals("P")) {
                        board[i][j].setEnPassant(false);
                    }
                }
            }
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if ((board[i][j].getName().equals("p") || board[i][j].getName().equals("P")) && (i!=y && x!=j)) {
                        board[i][j].setEnPassant(false);
                    }
                }
            }
        }
    }

    /**
     * returns a list of coordinates for the pawn once an en-passant to the right has occurred
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] enPassantRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (x+1 < board.length) && (y-1 >= 0)) {
            if (board[y][x+1].getEnPassant() && board[y][x+1].getColour().equals("black") &&
                    board[y-1][x+1].getColour().equals("empty")) {
                move[0] = x+1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                move[4] = x+1;
                move[5] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (x+1< board.length) && (y+1< board.length)) {
            if (board[y][x+1].getEnPassant() && board[y][x+1].getColour().equals("white") &&
                    board[y+1][x+1].getColour().equals("empty")) {
                move[0] = x+1;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                move[4] = x+1;
                move[5] = y;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the pawn once an en-passant to the left has occurred
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] enPassantLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (x-1 >= 0) && (y-1 >= 0)) {
            if (board[y][x-1].getEnPassant() && board[y][x-1].getColour().equals("black") &&
                    board[y-1][x-1].getColour().equals("empty")) {
                move[0] = x-1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                move[4] = x-1;
                move[5] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (x-1>=0) && (y+1< board.length)) {
            if (board[y][x-1].getEnPassant() && board[y][x-1].getColour().equals("white") &&
                    board[y+1][x-1].getColour().equals("empty")) {
                move[0] = x-1;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                move[4] = x-1;
                move[5] = y;
            }
        }
        return move;
    }

    /**
     * creates a table specifying the value of moving to a certain square and returns that value
     * @param colour
     * @param x
     * @param y
     * @return
     */
    public static double positionalValue(String colour, int x, int y, int numPieces) {
        double[][] positionValue = new double[0][];
        if (colour.equals("white") && numPieces > 6) {
            positionValue = new double[][]{
                    {5.0,5.0,5.0,5.0,5.0,5.0,5.0,5.0},
                    {3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0},
                    {1.0,1.0,2.0,3.0,3.0,2.0,1.0,1.0},
                    {0.5,0.5,1.0,2.5,2.5,1.0,0.5,0.5},
                    {0.0,0.0,0.0,2.0,2.0,0.0,0.0,0.0},
                    {0.5,-0.5,1.5,0.0,0.0,1.5,-0.5,0.5},
                    {0.5,1.0,1.0,-2.0,-2.0,1.0,1.0,0.5},
                    {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0}
            };
        } else if (colour.equals("white") && numPieces <= 6){
            positionValue = new double[][]{
                    {9.0,9.0,9.0,9.0,9.0,9.0,9.0,9.0},
                    {6.0,6.0,6.0,6.0,6.0,6.0,6.0,6.0},
                    {2.0,2.0,2.0,3.0,3.0,2.0,2.0,2.0},
                    {1.5,1.5,1.5,2.5,2.5,1.5,1.5,1.5},
                    {1.0,1.0,1.0,2.0,2.0,1.0,1.0,1.0},
                    {0.6,0.5,1.5,0.0,0.0,1.5,0.5,0.5},
                    {0.5,1.0,1.0,-2.0,-2.0,1.0,1.0,0.5},
                    {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0}
            };
        } else if (colour.equals("black") && numPieces > 6){
            positionValue = new double[][]{
                    {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},
                    {-0.5,-1.0,-1.0,2.0,2.0,-1.0,-1.0,-0.5},
                    {-0.5,0.5,-1.5,0.0,0.0,-1.5,0.5,-0.5},
                    {0.0,0.0,0.0,-2.0,-2.0,0.0,0.0,0.0},
                    {-0.5,-0.5,-1.0,-2.5,-2.5,-1.0,-0.5,-0.5},
                    {-1.0,-1.0,-2.0,-3.0,-3.0,-2.0,-1.0,-1.0},
                    {-3.0,-3.0,-3.0,-3.0,-3.0,-3.0,-3.0,-3.0},
                    {-5.0,-5.0,-5.0,-5.0,-5.0,-5.0,-5.0,-5.0}
            };
        } else if (colour.equals("black") && numPieces <= 6) {
            positionValue = new double[][]{
                    {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                    {-0.5, -1.0, -1.0, 2.0, 2.0, -1.0, -1.0, -0.5},
                    {-0.6, -0.5, -1.5, 0.0, 0.0, -1.5, -0.5, -0.5},
                    {-1.0, -1.0, -1.0, -2.0, -2.0, -1.0, -1.0, -1.0},
                    {-1.5, -1.5, -1.5, -2.5, -2.5, -1.5, -1.5, -1.5},
                    {-2.0, -2.0, -2.0, -3.0, -3.0, -2.0, -2.0, -2.0},
                    {-6.0, -6.0, -6.0, -6.0, -6.0, -6.0, -6.0, -6.0},
                    {-9.0, -9.0, -9.0, -9.0, -9.0, -9.0, -9.0, -9.0}
            };        
        }
        return positionValue[y][x];
    }
}
