package ChessPieces;

public class Knight extends Pieces {
    String name;
    int value;
    String colour;
    boolean moved;

    public Knight(String colour) {
        this.colour = colour;
        this.name = setName();
        this.value = setValue();
    }
    /**
     * returns name of piece
     * colour false = white -> lowercase
     * colour ture = black -> uppercase
     * @return N
     */
    @Override
    public String setName() {
        if (colour.equals("black")) {
            return "N";
        } else {
            return "n";
        }
    }

    /**
     * return value of piece
     *
     * @return -30 for black, 30 for white
     */
    @Override
    public int setValue() {
        if (colour.equals("black")) {
            return -30;
        } else {
            return 30;
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
        return false;
    }

    /**
     * sets en-passant
     *
     * @param possible
     * @return
     */
    @Override
    public void setEnPassant(boolean possible) {}

    /**
     * sets moved to true is piece moved from its starting position
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
     * returns a list of coordinates for the knight once it has moved one uo and two left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] oneUpTwoLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y-1>=0) && (x-2>=0)) {
            if (!board[y-1][x-2].getColour().equals("white")) {
                move[0] = x-2;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y+1< board.length) && (x-2>=0)) {
            if (!board[y+1][x-2].getColour().equals("black")) {
                move[0] = x - 2;
                move[1] = y + 1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the knight once it has moved up one and two right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] upOneTwoRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y-1>=0) && (x+2< board.length)) {
            if (!board[y-1][x+2].getColour().equals("white")) {
                move[0] = x+2;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y+1< board.length) && (x+2< board.length)) {
            if (!board[y+1][x+2].getColour().equals("black")) {
                move[0] = x + 2;
                move[1] = y + 1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the knight once it has moved up two and one left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] upTwoOneLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y-2>=0) && (x-1>=0)) {
            if (!board[y-2][x-1].getColour().equals("white")) {
                move[0] = x-1;
                move[1] = y-2;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y+2< board.length) && (x-1>=0)) {
            if (!board[y+2][x-1].getColour().equals("black")) {
                move[0] = x - 1;
                move[1] = y + 2;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the knight once it has moved up two and one right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] upTwoOneRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y-2>=0) && (x+1< board.length)) {
            if (!board[y-2][x+1].getColour().equals("white")) {
                move[0] = x+1;
                move[1] = y-2;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y+2< board.length) && (x+1< board.length)) {
            if (!board[y+2][x+1].getColour().equals("black")) {
                move[0] = x + 1;
                move[1] = y + 2;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the knight once it has moved down one and two left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] oneDownTwoLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y+1< board.length) && (x-2>=0)) {
            if (!board[y+1][x-2].getColour().equals("white")) {
                move[0] = x-2;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y-1>=0) && (x-2>=0)) {
            if (!board[y-1][x-2].getColour().equals("black")) {
                move[0] = x - 2;
                move[1] = y - 1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the knight once it has moved down one and two the the right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] downOneTwoRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y+1< board.length) && (x+2< board.length)) {
            if (!board[y+1][x+2].getColour().equals("white")) {
                move[0] = x+2;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y-1>=0) && (x+2< board.length)) {
            if (!board[y-1][x+2].getColour().equals("black")) {
                move[0] = x + 2;
                move[1] = y - 1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the knight once it has moved down two and one to the left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] downTwoOneLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y+2< board.length) && (x-1>=0)) {
            if (!board[y+2][x-1].getColour().equals("white")) {
                move[0] = x-1;
                move[1] = y+2;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y-2>=0) && (x-1>=0)) {
            if (!board[y-2][x-1].getColour().equals("black")) {
                move[0] = x - 1;
                move[1] = y - 2;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list of coordinates for the knight once it has moved down two squares and one to the right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] downTwoOneRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && (y+2< board.length) && (x+1< board.length)) {
            if (!board[y+2][x+1].getColour().equals("white")) {
                move[0] = x+1;
                move[1] = y+2;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && (y-2>=0) && (x+1< board.length)) {
            if (!board[y-2][x+1].getColour().equals("black")) {
                move[0] = x + 1;
                move[1] = y - 2;
                move[2] = x;
                move[3] = y;
                return move;
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
    public static double positionalValue(String colour, int x, int y) {
        double[][] positionValue;
        if (colour.equals("white")) {
            positionValue = new double[][]{
                    {-5.0,-4.0,-3.0,-3.0,-3.0,-3.0,-4.0,-5.0},
                    {-4.0,-2.0,0.0,0.0,0.0,0.0,-2.0,-4.0},
                    {-3.0,0.0,1.0,1.5,1.5,1.0,0.0,-3.0},
                    {-3.0,0.5,1.5,2.0,2.0,1.5,0.5,-3.0},
                    {-3.0,0.0,1.5,2.0,2.0,1.5,0.0,-3.0},
                    {-3.0,0.5,1.0,1.5,1.5,1.0,0.5,-3.0},
                    {-4.0,-2.0,0.0,0.5,0.5,0.0,-2.0,-4.0},
                    {-5.0,-4.0,-3.0,-3.0,-3.0,-3.0,-4.0,-5.0}
            };
        } else {
            positionValue = new double[][]{
                    {5.0,4.0,3.0,3.0,3.0,3.0,4.0,5.0},
                    {4.0,2.0,0.0,-0.5,-0.5,0.0,2.0,4.0},
                    {3.0,-0.5,-1.0,-1.5,-1.5,-1.0,-0.5,3.0},
                    {3.0,0.0,-1.5,-2.0,-2.0,-1.5,0.0,3.0},
                    {3.0,-0.5,-1.5,-2.0,-2.0,-1.5,-0.5,3.0},
                    {3.0,0.0,-1.0,-1.5,-1.5,-1.0,0.0,3.0},
                    {4.0,2.0,0.0,0.0,0.0,0.0,2.0,4.0},
                    {5.0,4.0,3.0,3.0,3.0,3.0,4.0,5.0}
            };
        }
        return positionValue[y][x];
    }
}
