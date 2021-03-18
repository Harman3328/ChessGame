import ChessPieces.*;
public class Board {

    /**
     * creates the board for new game
     * @param board
     * @return
     */
    public Pieces[][] initialBoard(Pieces[][] board) {
        Pawn pawn;
        Knight knight;
        Bishop bishop;
        Rook rook;
        Queen queen;
        King king;
        Blank blank;

        rook = new Rook("black");
        board[0][0] = rook;
        board[0][0].setMoved(false);
        rook = new Rook("white");
        board[7][0] = rook;
        board[7][0].setMoved(false);

        knight = new Knight("black");
        board[0][1] = knight;
        board[0][1].setMoved(false);
        knight = new Knight("white");
        board[7][1] = knight;
        board[7][1].setMoved(false);

        bishop = new Bishop("black");
        board[0][2] = bishop;
        board[0][2].setMoved(false);
        bishop = new Bishop("white");
        board[7][2] = bishop;
        board[7][2].setMoved(false);

        queen = new Queen("black");
        board[0][3] = queen;
        board[0][3].setMoved(false);
        queen = new Queen("white");
        board[7][3] = queen;
        board[7][3].setMoved(false);

        king = new King("black");
        board[0][4] = king;
        board[0][4].setMoved(false);
        king = new King("white");
        board[7][4] = king;
        board[7][4].setMoved(false);

        bishop = new Bishop("black");
        board[0][5] = bishop;
        board[0][5].setMoved(false);
        bishop = new Bishop("white");
        board[7][5] = bishop;
        board[7][5].setMoved(false);

        knight = new Knight("black");
        board[0][6] = knight;
        board[0][6].setMoved(false);
        knight = new Knight("white");
        board[7][6] = knight;
        board[7][6].setMoved(false);

        rook = new Rook("black");
        board[0][7] = rook;
        board[0][7].setMoved(false);
        rook = new Rook("white");
        board[7][7] = rook;
        board[7][7].setMoved(false);

        for (int i = 0; i < board.length; i++) {
            pawn = new Pawn("black");
            board[1][i] = pawn;
            board[1][i].setMoved(false);
            pawn = new Pawn("white");
            board[6][i] = pawn;
            board[6][i].setMoved(false);
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < board.length; j++) {
                blank = new Blank("empty");
                board[i][j] = blank;
            }
        }
        return board;
    }

    /**
     * Creates a user specific board
     * @param board
     * @param array
     * @return
     */
    public Pieces[][] initialBoardTwo(Pieces[][] board, String[] array) {
        Pawn pawn;
        Knight knight;
        Bishop bishop;
        Rook rook;
        Queen queen;
        King king;
        Blank blank;
        char[] charArray = array[1].toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        int num = Character.getNumericValue(charArray[1]);
        array[0] = array[0].toLowerCase();
        array[2] = array[2].toLowerCase();

        switch (array[0]) {
            case "pawn":
                pawn = new Pawn(array[2]);
                board[yLocation(num)][xLocation(charArray)] = pawn;
                if (board[yLocation(num)][xLocation(charArray)].getColour().equals("white")) {
                    board[yLocation(num)][xLocation(charArray)].setMoved((yLocation(num)!=6) &&
                            (xLocation(charArray)!=0 || xLocation(charArray)!=1 ||
                                    xLocation(charArray)!=2 || xLocation(charArray)!=3 ||
                                    xLocation(charArray)!=4 || xLocation(charArray)!=5 ||
                                    xLocation(charArray)!=6 || xLocation(charArray)!=7));
                } else {
                    board[yLocation(num)][xLocation(charArray)].setMoved((yLocation(num)!=1) &&
                            (xLocation(charArray)!=0 || xLocation(charArray)!=1 ||
                                    xLocation(charArray)!=2 || xLocation(charArray)!=3 ||
                                    xLocation(charArray)!=4 || xLocation(charArray)!=5 ||
                                    xLocation(charArray)!=6 || xLocation(charArray)!=7));
                }
                break;
            case "bishop":
                bishop = new Bishop(array[2]);
                board[yLocation(num)][xLocation(charArray)] = bishop;
                if (board[yLocation(num)][xLocation(charArray)].getColour().equals("white")) {
                    board[yLocation(num)][xLocation(charArray)].setMoved((yLocation(num)!=7) &&
                            (xLocation(charArray)!=2 || xLocation(charArray)!=5));
                } else {
                    board[yLocation(num)][xLocation(charArray)].setMoved((yLocation(num)!=0) &&
                            (xLocation(charArray)!=2 || xLocation(charArray)!=5));
                }
                break;
            case "king":
                king = new King(array[2]);
                board[yLocation(num)][xLocation(charArray)] = king;
                if (board[yLocation(num)][xLocation(charArray)].getColour().equals("white")) {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=7 &&
                            xLocation(charArray)!=4);
                } else {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=0 &&
                            xLocation(charArray)!=4);
                }
                break;
            case "knight":
                knight = new Knight(array[2]);
                board[yLocation(num)][xLocation(charArray)] = knight;
                if (board[yLocation(num)][xLocation(charArray)].getColour().equals("white")) {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=7 &&
                            (xLocation(charArray)!=1 || xLocation(charArray)!=6));
                } else {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=0 &&
                            (xLocation(charArray)!=1 || xLocation(charArray)!=6));
                }
                break;
            case "queen":
                queen = new Queen(array[2]);
                board[yLocation(num)][xLocation(charArray)] = queen;
                if (board[yLocation(num)][xLocation(charArray)].getColour().equals("white")) {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=7 &&
                            xLocation(charArray)!=3);
                } else {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=0 &&
                            xLocation(charArray)!=3);
                }
                break;
            case "rook":
                rook = new Rook(array[2]);
                board[yLocation(num)][xLocation(charArray)] = rook;
                if (board[yLocation(num)][xLocation(charArray)].getColour().equals("white")) {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=7 &&
                            (xLocation(charArray)!=0 || xLocation(charArray)!=7));
                } else {
                    board[yLocation(num)][xLocation(charArray)].setMoved(yLocation(num)!=0 &&
                            (xLocation(charArray)!=0 || xLocation(charArray)!=7));
                }
                break;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    blank = new Blank("empty");
                    board[i][j] = blank;
                }
            }
        }
        return board;
    }

    /**
     * gets the location for x axis
     * @param charArray
     * @return
     */
    public int xLocation(char[] charArray) {
        int x;
        switch (charArray[0]) {
            case 'a':
                x= 0;
                break;
            case 'b':
                x= 1;
                break;
            case 'c':
                x= 2;
                break;
            case 'd':
                x = 3;
                break;
            case 'e':
                x = 4;
                break;
            case 'f':
                x = 5;
                break;
            case 'g':
                x = 6;
                break;
            case 'h':
                x = 7;
                break;
            default:
                x = -1;
                break;
        }
        return x;
    }

    /**
     * gets location of y axis
     * @param charArray
     * @return
     */
    public int yLocation(int num) {
        int y;
        switch (num) {
            case 1:
                y = 7;
                break;
            case 2:
                y = 6;
                break;
            case 3:
                y = 5;
                break;
            case 4:
                y = 4;
                break;
            case 5:
                y = 3;
                break;
            case 6:
                y = 2;
                break;
            case 7:
                y = 1;
                break;
            case 8:
                y = 0;
                break;
            default:
                y = -1;
                break;
        }
        return y;
    }

    /**
     * coverts ai move to board coordinate on x-axis (horizontally)
     * @param x
     * @return
     */
    public char aiXLocation(int x) {
        char xLocation;
        switch (x) {
            case 0:
                xLocation = 'a';
                break;
            case 1:
                xLocation = 'b';
                break;
            case 2:
                xLocation = 'c';
                break;
            case 3:
                xLocation = 'd';
                break;
            case 4:
                xLocation = 'e';
                break;
            case 5:
                xLocation = 'f';
                break;
            case 6:
                xLocation = 'g';
                break;
            case 7:
                xLocation = 'h';
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + x);
        }
        return xLocation;
    }

    /**
     * coverts ai move to board coordinate on y-axis (vertically)
     * @param y
     * @return
     */
    public int aiYLocation(int y) {
        int yLocation;
        switch (y) {
            case 0:
                yLocation = 8;
                break;
            case 1:
                yLocation = 7;
                break;
            case 2:
                yLocation = 6;
                break;
            case 3:
                yLocation = 5;
                break;
            case 4:
                yLocation = 4;
                break;
            case 5:
                yLocation = 3;
                break;
            case 6:
                yLocation = 2;
                break;
            case 7:
                yLocation = 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + y);
        }
        return yLocation;
    }

    /**
     * prints board
     * @param board
     */
    public void printBoard(Pieces[][] board) {
        int numLocation = board.length;
        for (int i = 0; i < board.length; i++) {
            System.out.print(numLocation +"   ");
            numLocation--;
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j].getName() + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("    ");
        System.out.print("A  B  C  D  E  F  G  H");
        System.out.println();
        System.out.println();
    }

    /**
     * calculates the total value of board
     * @param board
     * @return
     */
    public double materialValue(Game board, int depth, int mainDepth, boolean maximizingPlayer) {
        if (board.isWinnerWhite()) {
            if (depth == mainDepth) return 10000;
            return 5000;
        }
        if (board.isWinnerBlack()) {
            if (depth == mainDepth) return -10000;
            return -5000;
        }
        double value = 0;
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board.length; j++) {
                value = value + board.board[i][j].getValue();
                switch (board.board[i][j].getName()) {
                    case "p":
                        value = value + Pawn.positionalValue("white",j,i, board.numWhitePieces);
                        break;
                    case "P":
                        value = value + Pawn.positionalValue("black",j,i, board.numBlackPieces);
                        break;
                    case "b":
                        value = value + Bishop.positionalValue("white",j,i);
                        break;
                    case "B":
                        value = value + Bishop.positionalValue("black",j,i);
                        break;
                    case "k":
                        value = value + King.positionalValue("white",j,i, board.numWhitePieces);
                        break;
                    case "K":
                        value = value + King.positionalValue("black",j,i, board.numBlackPieces);
                        break;
                    case "n":
                        value = value + Knight.positionalValue("white",j,i);
                        break;
                    case "N":
                        value = value + Knight.positionalValue("black",j,i);
                        break;
                    case "q":
                        value = value + Queen.positionalValue("white",j,i);
                        break;
                    case "Q":
                        value = value + Queen.positionalValue("black",j,i);
                        break;
                    case "r":
                        value = value + Rook.positionalValue("white",j,i);
                        break;
                    case "R":
                        value = value + Rook.positionalValue("black",j,i);
                        break;
                }
            }
        }
        value = value + board.getCheckValue();

        if (board.isStalemate()) {
            if (board.isStalemate() && !maximizingPlayer) {
                if (value < 0) {
                    return 1000;
                } else {
                    return -1000;
                }
            } else if (board.isStalemate() && maximizingPlayer) {
                if (value > 0) {
                    return -1000;
                } else {
                    return 1000;
                }
            }
        }
        return value;
    }

    /**
     * checks to see if the king is in check and returns the appropriate score
     * @param board
     * @param name
     * @param colour
     * @return
     */
    public static double check(Pieces[][] board, String name, String colour) {
        int kingLocationY = -1;
        int kingLocationX = -1;
        double score = 0;
        outerloop:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getName().equals(name)) {
                    kingLocationX = j;
                    kingLocationY = i;
                    break outerloop;
                }
            }
        }
        if (kingLocationX == -1 && kingLocationY==-1) return score;


        if (colour.equals("black")) {
            score = score + King.calculateCheck(board,kingLocationX,kingLocationY,colour);
        }
         else if (colour.equals("white")) {
            score = score + King.calculateCheck(board,kingLocationX,kingLocationY,colour);
        }
        return score;
    }
}

