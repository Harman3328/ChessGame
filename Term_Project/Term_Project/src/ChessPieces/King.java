package ChessPieces;


public class King extends Pieces {
    String name;
    int value;
    String colour;
    boolean moved;

    public King(String colour) {
        this.colour = colour;
        name = setName();
        value = setValue();
        moved = false;
    }
    /**
     * returns name of piece
     * colour false = white -> lowercase
     * colour ture = black -> uppercase
     * @return K
     */
    @Override
    public String setName() {
        if (colour.equals("black")) {
            return "K";
        } else {
            return "k";
        }
    }

    /**
     * return value of piece
     *
     * @return -900 for black, 900 for white
     */
    @Override
    public int setValue() {
        if (colour.equals("black")) {
            return -900;
        } else {
            return 900;
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
     * returns a list holding the coordinates for king once it moves up
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] up(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && y-1>=0) {
            if (!board[y-1][x].getColour().equals("white") &&
                    calculateCheck(board,x,y-1,"white")==0) {
                move[0] = x;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && y+1 < board.length) {
            if (!board[y+1][x].getColour().equals("black") &&
                    calculateCheck(board,x,y+1,"black")==0) {
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
     * returns a list holding the coordinates for king once it moves down
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] down(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && y+1< board.length) {
            if (!board[y+1][x].getColour().equals("white") &&
                    calculateCheck(board,x,y+1,"white")==0) {
                move[0] = x;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && y-1>=0) {
            if (!board[y-1][x].getColour().equals("black") &&
                    calculateCheck(board,x,y-1,"black")==0) {
                move[0] = x;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list holding the coordinates for king once it moves right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] right(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && x+1< board.length) {
            if (!board[y][x+1].getColour().equals("white")&&
                    calculateCheck(board, x+1,y,"white")==0) {
                move[0] = x+1;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && x+1 < board.length) {
            if (!board[y][x+1].getColour().equals("black")&&
                    calculateCheck(board,x+1,y,"black")==0) {
                move[0] = x+1;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list holding the coordinates for king once it moves left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] left(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && x-1>=0) {
            if (!board[y][x-1].getColour().equals("white")&&
                    calculateCheck(board,x-1,y,"white")==0) {
                move[0] = x-1;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && x-1>=0) {
            if (!board[y][x-1].getColour().equals("black")&&
                    calculateCheck(board,x-1,y,"black")==0) {
                move[0] = x-1;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list holding the coordinates for king once it moves diagonally up right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyUpRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && x+1< board.length && y-1>=0) {
            if (!board[y-1][x+1].getColour().equals("white")&&
                    calculateCheck(board,x+1,y-1, "white")==0) {
                move[0] = x+1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && x+1 < board.length && y+1< board.length) {
            if (!board[y+1][x+1].getColour().equals("black")&&
                    calculateCheck(board,x+1,y+1, "black")==0) {
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
     * returns a list holding the coordinates for king once it moves diagonally up left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyUpLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && x-1>=0 && y-1>=0) {
            if (!board[y-1][x-1].getColour().equals("white")&&
                    calculateCheck(board,x-1,y-1, "white")==0) {
                move[0] = x-1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && x-1 >= 0 && y+1< board.length) {
            if (!board[y+1][x-1].getColour().equals("black")&&
                    calculateCheck(board,x-1,y+1, "black")==0) {
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
     * returns a list holding the coordinates for king once it moves diagonally down right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyDownRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && x+1< board.length && y+1< board.length) {
            if (!board[y+1][x+1].getColour().equals("white")&&
                    calculateCheck(board,x+1,y+1, "white")==0) {
                move[0] = x+1;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && x+1 < board.length && y-1>=0) {
            if (!board[y-1][x+1].getColour().equals("black")&&
                    calculateCheck(board,x+1,y-1, "black")==0) {
                move[0] = x+1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list holding the coordinates for king once it moves diagonally down left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] diagonallyDownLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && x-1>=0 && y+1< board.length) {
            if (!board[y+1][x-1].getColour().equals("white")&&
                    calculateCheck(board,x-1,y+1, "white")==0) {
                move[0] = x-1;
                move[1] = y+1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && x-1>=0 && y-1>=0) {
            if (!board[y-1][x-1].getColour().equals("black")&&
                    calculateCheck(board,x-1,y-1, "black")==0) {
                move[0] = x-1;
                move[1] = y-1;
                move[2] = x;
                move[3] = y;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list holding the coordinates for king once it has castled right
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] castleRight(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1,-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && !board[y][x].getMoved() &&
                x+3< board.length) {
            if (board[y][x+1].getColour().equals("empty") && board[y][x+2].getColour().equals("empty") &&
                    board[y][x+3].getName().equals("r") && !board[y][x + 3].getMoved() &&
                    calculateCheck(board,x,y,"white")==0 &&
                    calculateCheck(board,x+1,y,"white")==0) {
                move[0] = x+2;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                move[4] = x+3;
                move[5] = x+1;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && !board[y][x].getMoved() &&
                x+3< board.length) {
            if (board[y][x+1].getColour().equals("empty") && board[y][x+2].getColour().equals("empty") &&
                    board[y][x+3].getName().equals("R") && !board[y][x + 3].getMoved() &&
                    calculateCheck(board,x,y,"black")==0 &&
                    calculateCheck(board,x+1,y,"black")==0) {
                move[0] = x+2;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                move[4] = x+3;
                move[5] = x+1;
                return move;
            }
        }
        return move;
    }

    /**
     * returns a list holding the coordinates for king once it has castled left
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int[] castleLeft(Pieces[][] board, int x, int y) {
        int[] move = {-1,-1,-1,-1,-1,-1,-1,-1};

        if (board[y][x].getColour().equals("white") && !board[y][x].getMoved() && x-4 >=0) {
            if (board[y][x-1].getColour().equals("empty") &&
                    board[y][x-2].getColour().equals("empty") &&
                    board[y][x-3].getColour().equals("empty") &&
                    board[y][x-4].getName().equals("r") && !board[y][x - 4].getMoved() &&
                    calculateCheck(board,x,y,"white")==0 &&
                    calculateCheck(board,x-1, y,"white")==0) {
                move[0] = x-2;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                move[4] = x-4;
                move[5] = x-1;
                return move;
            }
        } else if (board[y][x].getColour().equals("black") && !board[y][x].getMoved() && x-4>=0) {
            if (board[y][x-1].getColour().equals("empty")
                    && board[y][x-2].getColour().equals("empty") &&
                    board[y][x-3].getColour().equals("empty") &&
                    board[y][x-4].getName().equals("R") && !board[y][x - 4].getMoved() &&
                    calculateCheck(board,x,y,"black")==0 &&
                    calculateCheck(board,x-1,y,"black")==0) {
                move[0] = x-2;
                move[1] = y;
                move[2] = x;
                move[3] = y;
                move[4] = x-4;
                move[5] = x-1;
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
    public static double positionalValue(String colour, int x, int y, int numPieces) {
        double[][] positionValue = new double[0][];
        if (colour.equals("white") && numPieces > 5) {
            positionValue = new double[][]{
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {-2.0, -3.0, -3.0, -4.0, -4.0, -3.0, -3.0, -2.0},
                    {-1.0, -2.0, -2.0, -2.0, -2.0, -2.0, -2.0, -1.0},
                    {2.0, 2.0, 0.0, 0.0, 0.0, 0.0, 2.0, 2.0},
                    {2.0, 3.0, 1.0, 0.0, 0.0, 1.0, 3.0, 2.0}
            };
        } else if (colour.equals("white") && numPieces <=5) {
            positionValue = new double[][]{
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0},
                    {2.0, 3.0, 3.0, 4.0, 4.0, 3.0, 3.0, 2.0},
                    {1.0, 2.5, 2.5, 3.0, 3.0, 2.5, 2.5, 1.0},
                    {2.0, 2.0, 1.5, 1.0, 1.0, 1.5, 2.0, 2.0},
                    {2.0, 2.0, 1.0, 0.0, 0.0, 1.0, 2.0, 2.0}
            };
        }else if (colour.equals("black") && numPieces > 5){
            positionValue = new double[][]{
                    {-2.0, -3.0, -1.0, 0.0, 0.0, -1.0, -3.0, -2.0},
                    {-2.0, -2.0, 0.0, 0.0, 0.0, 0.0, -2.0, -2.0},
                    {1.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 1.0},
                    {2.0, 3.0, 3.0, 4.0, 4.0, 3.0, 3.0, 2.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0}
            };
        } else if (colour.equals("black") && numPieces<=5) {
            positionValue = new double[][]{
                    {-2.0, -2.0, -1.0, 0.0, 0.0, -1.0, -2.0, -2.0},
                    {-2.0, -2.0, -1.5, -1.0, -1.0, -1.5, -2.0, -2.0},
                    {-1.0, -2.5, -2.5, -3.0, -3.0, -2.5, -2.5, -1.0},
                    {-2.0, -3.0, -3.0, -4.0, -4.0, -3.0, -3.0, -2.0},
                    {-3.0, -4.0, -4.0, -5.0, -5.0, -4.0, -4.0, -3.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0},
                    {3.0, 4.0, 4.0, 5.0, 5.0, 4.0, 4.0, 3.0}
            };
        }
        return positionValue[y][x];
    }

    /**
     * checks to see if a pawn has a check
     * @param board
     * @param kingLocationX
     * @param kingLocationY
     * @param colour
     * @return
     */
    public static double checkForPawn(Pieces[][] board, int kingLocationX, int kingLocationY,String colour) {
        double score = 0;
        if (colour.equals("black")) {
            if (kingLocationX-1>=0 && kingLocationY+1< board.length) {
                if (board[kingLocationY + 1][kingLocationX - 1].getName().equals("p")) score += 10;
            }
            if (kingLocationX+1< board.length && kingLocationY+1< board.length) {
                if (board[kingLocationY+1][kingLocationX+1].getName().equals("p")) score+=10;
            }
        } else if (colour.equals("white")) {
            if (kingLocationX-1>=0 && kingLocationY-1>=0) {
                if (board[kingLocationY - 1][kingLocationX - 1].getName().equals("P")) score -= 10;
            }
            if (kingLocationX+1< board.length && kingLocationY-1>=0) {
                if (board[kingLocationY-1][kingLocationX+1].getName().equals("P")) score-=10;
            }
        }
        return score;
    }

    /**
     * checks to see if a king has a check
     * @param board
     * @param kingLocationX
     * @param kingLocationY
     * @param colour
     * @return
     */
    public static double checkForKing(Pieces[][] board, int kingLocationX, int kingLocationY,String colour) {
        double score = 0;
        if (colour.equals("black")) {
            if (kingLocationX+1<board.length) {
                // checks to the right
                if (board[kingLocationY][kingLocationX+1].getName().equals("k")) score+=10;
            }
            // check left
            if (kingLocationX-1>=0) {
                if (board[kingLocationY][kingLocationX-1].getName().equals("k")) score+=10;
            }
            // check up
            if (kingLocationY-1>=0) {
                if (board[kingLocationY-1][kingLocationX].getName().equals("k")) score+=10;
            }
            //check down
            if (kingLocationY+1< board.length) {
                if (board[kingLocationY+1][kingLocationX].getName().equals("k")) score+=10;
            }
            //check right-up
            if (kingLocationX+1< board.length && kingLocationY-1>=0) {
                if (board[kingLocationY-1][kingLocationX+1].getName().equals("k")) score+=10;
            }
            //check left-up
            if (kingLocationX-1>=0 && kingLocationY-1>=0) {
                if (board[kingLocationY-1][kingLocationX-1].getName().equals("k")) score+=10;
            }
            //check right-down
            if (kingLocationX+1< board.length && kingLocationY+1< board.length) {
                if (board[kingLocationY+1][kingLocationX+1].getName().equals("k")) score+=10;
            }
            //check left-down
            if (kingLocationX-1>=0 && kingLocationY+1< board.length) {
                if (board[kingLocationY+1][kingLocationX-1].getName().equals("k"))score+=10;
            }
        } else if (colour.equals("white")) {
            if (kingLocationX+1<board.length) {
                // checks to the right
                if (board[kingLocationY][kingLocationX+1].getName().equals("K")) score-=10;
            }
            // check left
            if (kingLocationX-1>=0) {
                if (board[kingLocationY][kingLocationX-1].getName().equals("K")) score-=10;
            }
            // check up
            if (kingLocationY-1>=0) {
                if (board[kingLocationY-1][kingLocationX].getName().equals("K")) score-=10;
            }
            //check down
            if (kingLocationY+1< board.length) {
                if (board[kingLocationY+1][kingLocationX].getName().equals("K")) score-=10;
            }
            //check right-up
            if (kingLocationX+1< board.length && kingLocationY-1>=0) {
                if (board[kingLocationY-1][kingLocationX+1].getName().equals("K")) score-=10;
            }
            //check left-up
            if (kingLocationX-1>=0 && kingLocationY-1>=0) {
                if (board[kingLocationY-1][kingLocationX-1].getName().equals("K")) score-=10;
            }
            //check right-down
            if (kingLocationX+1< board.length && kingLocationY+1< board.length) {
                if (board[kingLocationY+1][kingLocationX+1].getName().equals("K")) score-=10;
            }
            //check left-down
            if (kingLocationX-1>=0 && kingLocationY+1< board.length) {
                if (board[kingLocationY+1][kingLocationX-1].getName().equals("K"))score-=10;
            }
        }
        return score;
    }

    /**
     * checks to see if a knight can take the king
     * @param board
     * @param kingLocationx
     * @param kingLocationY
     * @return
     */
    public static double checkForKnight(Pieces[][] board, int kingLocationx, int kingLocationY, String colour) {
        double score = 0;

        // checks two left one down
        if (kingLocationx-2>=0 && kingLocationY+1< board.length) {
            if (colour.equals("black")) {
                if (board[kingLocationY+1][kingLocationx-2].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY+1][kingLocationx-2].getName().equals("N")) {
                    score-=10;
                }
            }
        }

        //check one left two down
        if (kingLocationx-1>=0 && kingLocationY+2< board.length) {
            if (colour.equals("black")) {
                if (board[kingLocationY+2][kingLocationx-1].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY+2][kingLocationx-1].getName().equals("N")) {
                    score-=10;
                }
            }
        }

        //check two left one up
        if (kingLocationx-2>=0 && kingLocationY-1>=0) {
            if (colour.equals("black")) {
                if (board[kingLocationY-1][kingLocationx-2].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY-1][kingLocationx-2].getName().equals("N")) {
                    score-=10;
                }
            }
        }

        //check one left two up
        if (kingLocationx-1>=0 && kingLocationY-2>=0) {
            if (colour.equals("black")) {
                if (board[kingLocationY-2][kingLocationx-1].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY-2][kingLocationx-1].getName().equals("N")) {
                    score-=10;
                }
            }
        }

        //check two right one up
        if (kingLocationx+2< board.length && kingLocationY+1< board.length) {
            if (colour.equals("black")) {
                if (board[kingLocationY+1][kingLocationx+2].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY+1][kingLocationx+2].getName().equals("N")) {
                    score-=10;
                }
            }
        }

        //check one right two down
        if (kingLocationx+1< board.length && kingLocationY+2< board.length) {
            if (colour.equals("black")) {
                if (board[kingLocationY+2][kingLocationx+1].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY+2][kingLocationx+1].getName().equals("N")) {
                    score-=10;
                }
            }
        }

        //check two right one up
        if (kingLocationx+2< board.length && kingLocationY-1>=0) {
            if (colour.equals("black")) {
                if (board[kingLocationY-1][kingLocationx+2].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY-1][kingLocationx+2].getName().equals("N")) {
                    score-=10;
                }
            }
        }

        //check one right two up
        if (kingLocationx+1< board.length && kingLocationY-2>=0) {
            if (colour.equals("black")) {
                if (board[kingLocationY-2][kingLocationx+1].getName().equals("n")) {
                    score+=10;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY-2][kingLocationx+1].getName().equals("N")) {
                    score-=10;
                }
            }
        }
        return score;
    }

    /**
     * checks horizontal for rook and queen
     * @param board
     * @param kingLocationX
     * @param kingLocationY
     * @param colour colour of the king being examied
     * @return
     */
    public static double checkHorizontalVerticle(Pieces[][] board, int kingLocationX, int kingLocationY, String colour) {
        int movementX = 1;
        int movmentY = 1;
        double score = 0;

        //check right
        while (kingLocationX+movementX < board.length) {
            if (board[kingLocationY][kingLocationX+movementX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("p")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("b")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("n")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("k")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("q") ||
                        board[kingLocationY][kingLocationX+movementX].getName().equals("r")) {
                    score+=10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("P")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("B")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("N")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("K")) break;
                if (board[kingLocationY][kingLocationX+movementX].getName().equals("Q") ||
                        board[kingLocationY][kingLocationX+movementX].getName().equals("R")) {
                    score-=10;
                    break;
                }
            }
            movementX++;
        }

        // check left
        movementX = 1;
        while (kingLocationX-movementX >= 0) {
            if (board[kingLocationY][kingLocationX-movementX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("p")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("b")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("n")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("k")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("q") ||
                        board[kingLocationY][kingLocationX-movementX].getName().equals("r")) {
                    score+=10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("P")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("B")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("N")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("K")) break;
                if (board[kingLocationY][kingLocationX-movementX].getName().equals("Q") ||
                        board[kingLocationY][kingLocationX-movementX].getName().equals("R")) {
                    score-=10;
                    break;
                }
            }
            movementX++;
        }

        // check up
        movementX = 1;
        while (kingLocationY-movmentY >= 0) {
            if (board[kingLocationY-movmentY][kingLocationX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("p")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("b")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("n")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("k")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("q") ||
                        board[kingLocationY-movmentY][kingLocationX].getName().equals("r")) {
                    score+=10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("P")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("B")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("N")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("K")) break;
                if (board[kingLocationY-movmentY][kingLocationX].getName().equals("Q") ||
                        board[kingLocationY-movmentY][kingLocationX].getName().equals("R")) {
                    score-=10;
                    break;
                }
            }
            movmentY++;
        }

        // check down
        movmentY = 1;
        while (kingLocationY+movmentY < board.length) {
            if (board[kingLocationY+movmentY][kingLocationX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("p")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("b")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("n")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("k")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("q") ||
                        board[kingLocationY+movmentY][kingLocationX].getName().equals("r")) {
                    score+=10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("P")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("B")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("N")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("K")) break;
                if (board[kingLocationY+movmentY][kingLocationX].getName().equals("Q") ||
                        board[kingLocationY+movmentY][kingLocationX].getName().equals("R")) {
                    score-=10;
                    break;
                }
            }
            movmentY++;
        }
        return score;
    }

    /**
     * checks disgonals for queen or bishop and returns the appropriate score
     * @param board
     * @param kingLocationX
     * @param kingLocationY
     * @param colour colour of king that is being examined
     * @return
     */
    public static double checkDiagonal(Pieces[][] board, int kingLocationX, int kingLocationY, String colour) {
        int movementX = 1;
        int movementY = 1;
        double score = 0;

        // checks right up
        while(kingLocationX+movementX< board.length && kingLocationY-movementY>=0) {
            if (board[kingLocationY-movementY][kingLocationX+movementX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("p")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("r")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("n")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("k")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("q") ||
                        board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("b")) {
                    score+=10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("P")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("R")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("N")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("K")) break;
                if (board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("Q") ||
                        board[kingLocationY-movementY][kingLocationX+movementX].getName().equals("B")) {
                    score-=10;
                    break;
                }
            }
            movementX++;
            movementY++;
        }

        // checks left up
        movementX = 1;
        movementY = 1;
        while (kingLocationX-movementX>=0 && kingLocationY-movementY>=0) {
            if (board[kingLocationY-movementY][kingLocationX-movementX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("p")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("r")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("n")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("k")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("q") ||
                        board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("b")) {
                    score+=10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("P")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("R")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("N")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("K")) break;
                if (board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("Q") ||
                        board[kingLocationY-movementY][kingLocationX-movementX].getName().equals("B")) {
                    score-=10;
                    break;
                }
            }
            movementX++;
            movementY++;
        }

        // checks down right
        movementX = 1;
        movementY = 1;
        while(kingLocationX+movementX< board.length && kingLocationY+movementY< board.length) {
            if (board[kingLocationY + movementY][kingLocationX + movementX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("p")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("r")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("n")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("k")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("q") ||
                        board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("b")) {
                    score += 10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("P")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("R")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("N")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("K")) break;
                if (board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("Q") ||
                        board[kingLocationY + movementY][kingLocationX + movementX].getName().equals("B")) {
                    score -= 10;
                    break;
                }
            }
            movementX++;
            movementY++;
        }

        // checks down left
        movementX = 1;
        movementY = 1;
        while (kingLocationX-movementX>=0 && kingLocationY+movementY< board.length) {
            if (board[kingLocationY + movementY][kingLocationX - movementX].getColour().equals(colour)) break;
            if (colour.equals("black")) {
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("p")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("r")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("n")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("k")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("q") ||
                        board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("b")) {
                    score += 10;
                    break;
                }
            } else if (colour.equals("white")) {
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("P")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("R")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("N")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("K")) break;
                if (board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("Q") ||
                        board[kingLocationY + movementY][kingLocationX - movementX].getName().equals("B")) {
                    score -= 10;
                    break;
                }
            }
            movementX++;
            movementY++;
        }
        return score;
    }

    /**
     * returns the total score of check
     * @param board
     * @param kingLocationX
     * @param kingLocationY
     * @param colour
     * @return
     */
    public static double calculateCheck(Pieces[][] board, int kingLocationX, int kingLocationY, String colour) {
        return checkDiagonal(board,kingLocationX,kingLocationY,colour) +
                checkHorizontalVerticle(board,kingLocationX,kingLocationY,colour) +
                checkForKnight(board,kingLocationX,kingLocationY,colour) +
                checkForPawn(board,kingLocationX,kingLocationY,colour) +
                checkForKing(board,kingLocationX,kingLocationY,colour);
    }
}
