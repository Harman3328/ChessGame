package ChessPieces;

import java.util.LinkedList;
import java.util.Queue;

public class Bishop extends Pieces {
    String name;
    int value;
    String colour;
    boolean moved;

    public Bishop(String colour) {
        this.colour = colour;
        name = setName();
        value = setValue();
    }

    /**
     * sets name of piece
     * colour false = white -> lowercase
     * colour ture = black -> uppercase
     * @return B
     */
    @Override
    public String setName() {
        if (colour.equals("black")) {
            return "B";
        } else {
            return "b";
        }
    }

    /**
     * sets value of piece
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
     * returns a list of every possible position the bishop can goto when moving diagonally up right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyUpRight(Pieces[][] board, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        int StartingX = x;
        int startingY = y;
        int[] moves;

        if (board[y][x].getColour().equals("white")) {
            while ((x+1< board.length) && (y-1>=0)) {
                if (!board[y-1][x+1].getColour().equals("white")) {
                    queue.add(x+1);
                    queue.add(y-1);
                    x = x+1;
                    y = y-1;
                    if (board[y][x].getColour().equals("black")) break;
                } else break;
            }
        } else {
            while ((y+1< board.length) && (x+1< board.length)) {
                if (!board[y+1][x+1].getColour().equals("black")) {
                    queue.add(x+1);
                    queue.add(y+1);
                    x = x+1;
                    y = y+1;
                    if (board[y][x].getColour().equals("white")) break;
                } else break;
            }
        }

        if (queue.size() > 0) {
            moves = new int[queue.size() + 2];
            int size = queue.size();
            int index = 0;
            while (!queue.isEmpty()) {
                moves[index] = queue.remove();
                index++;
            }
            moves[size] = StartingX;
            moves[size + 1] = startingY;
        } else {
            moves = new int[2];
            moves[0] = -1;
            moves[1] = -1;
            return moves;
        }
        return moves;
    }

    /**
     * returns a list of every possible position the bishop can goto when moving diagonally up left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyUpLeft(Pieces[][] board, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        int StartingX = x;
        int startingY = y;
        int[] moves;

        if (board[y][x].getColour().equals("white")) {
            while ((x-1 >= 0) && (y-1>=0)) {
                if (!board[y-1][x-1].getColour().equals("white")) {
                    queue.add(x-1);
                    queue.add(y-1);
                    x = x-1;
                    y = y-1;
                    if (board[y][x].getColour().equals("black")) break;
                } else break;
            }
        } else {
            while ((y+1< board.length) && (x-1>=0)) {
                if (!board[y+1][x-1].getColour().equals("black")) {
                    queue.add(x-1);
                    queue.add(y+1);
                    x = x-1;
                    y = y+1;
                    if (board[y][x].getColour().equals("white")) break;
                } else break;
            }
        }

        if (queue.size() > 0) {
            moves = new int[queue.size() + 2];
            int size = queue.size();
            int index = 0;
            while (!queue.isEmpty()) {
                moves[index] = queue.remove();
                index++;
            }
            moves[size] = StartingX;
            moves[size + 1] = startingY;
        } else {
            moves = new int[2];
            moves[0] = -1;
            moves[1] = -1;
            return moves;
        }
        return moves;
    }

    /**
     * returns a list of every possible position the bishop can goto when moving diagonally down right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyDownRight(Pieces[][] board, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        int StartingX = x;
        int startingY = y;
        int[] moves;

        if (board[y][x].getColour().equals("white")) {
            while ((x+1< board.length) && (y+1 < board.length)) {
                if (!board[y+1][x+1].getColour().equals("white")) {
                    queue.add(x+1);
                    queue.add(y+1);
                    x = x+1;
                    y = y+1;
                    if (board[y][x].getColour().equals("black")) break;
                } else break;
            }
        } else {
            while ((y-1>=0) && (x+1< board.length)) {
                if (!board[y-1][x+1].getColour().equals("black")) {
                    queue.add(x+1);
                    queue.add(y-1);
                    x = x+1;
                    y = y-1;
                    if (board[y][x].getColour().equals("white")) break;
                } else break;
            }
        }

        if (queue.size() > 0) {
            moves = new int[queue.size() + 2];
            int size = queue.size();
            int index = 0;
            while (!queue.isEmpty()) {
                moves[index] = queue.remove();
                index++;
            }
            moves[size] = StartingX;
            moves[size + 1] = startingY;
        } else {
            moves = new int[2];
            moves[0] = -1;
            moves[1] = -1;
            return moves;
        }
        return moves;
    }

    /**
     * returns a list of every possible position the bishop can goto when moving diagonally down left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyDownLeft(Pieces[][] board, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        int StartingX = x;
        int startingY = y;
        int[] moves;

        if (board[y][x].getColour().equals("white")) {
            while ((x-1 >= 0) && (y+1 < board.length)) {
                if (!board[y+1][x-1].getColour().equals("white")) {
                    queue.add(x-1);
                    queue.add(y+1);
                    x = x-1;
                    y = y+1;
                    if (board[y][x].getColour().equals("black")) break;
                } else break;
            }
        } else {
            while ((y-1>=0) && (x-1>=0)) {
                if (!board[y-1][x-1].getColour().equals("black")) {
                    queue.add(x-1);
                    queue.add(y-1);
                    x = x-1;
                    y = y-1;
                    if (board[y][x].getColour().equals("white")) break;
                } else break;
            }
        }

        if (queue.size() > 0) {
            moves = new int[queue.size() + 2];
            int size = queue.size();
            int index = 0;
            while (!queue.isEmpty()) {
                moves[index] = queue.remove();
                index++;
            }
            moves[size] = StartingX;
            moves[size + 1] = startingY;
        } else {
            moves = new int[2];
            moves[0] = -1;
            moves[1] = -1;
            return moves;
        }
        return moves;
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
                    {-2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0},
                    {-1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                    {-1.0, 0.0, 0.5, 1.0, 1.0, 0.5, 0.0, -1.0},
                    {-1.0, 0.5, 0.5, 1.0, 1.0, 0.5, 0.5, -1.0},
                    {-1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, -1.0},
                    {-1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, -1.0},
                    {-1.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5, -1.0},
                    {-2.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -2.0}
            };
        } else {
            positionValue = new double[][]{
                    {2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0},
                    {1.0, -0.5, 0.0, 0.0, 0.0, 0.0, -0.5, 1.0},
                    {1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 1.0},
                    {1.0, 0.0, -1.0, -1.0, -1.0, -1.0, 0.0, 1.0},
                    {1.0, -0.5, -0.5, -1.0, -1.0, -0.5, -0.5, 1.0},
                    {1.0, 0.0, -0.5, -1.0, -1.0, -0.5, 0.0, 1.0},
                    {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                    {2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0}


            };
        }
        return positionValue[y][x];
    }
}
