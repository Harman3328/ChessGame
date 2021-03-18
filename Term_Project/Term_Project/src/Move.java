import ChessPieces.*;

public class Move {

    /**
     * generates a list of all possible moves for current board
     * @param board
     * @return
     */
    public PermutationList[] generateAllMoves(Pieces[][] board, String colour) {
        PermutationList[] permutationLists = new PermutationList[0];
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (colour.equals("white") && board[i][j].getColour().equals("white")) {
                    switch (board[i][j].getName()) {
                        case "p":
                            int[] move = Pawn.upOne(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }

                                // for promotions
                                if (move[1]==0) {
                                    for (int k = 1; k <=4; k++) {
                                        if (index >= permutationLists.length) {
                                            permutationLists = increaseSize(permutationLists);
                                        }
                                        permutationLists[index] = new PermutationList(promotionAi(move,k));
                                        index++;
                                    }
                                } else {
                                    permutationLists[index] = new PermutationList(move);
                                    index++;
                                }
                            }
                            move = Pawn.upTwo(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.captureRight(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.captureLeft(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.enPassantRight(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.enPassantLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            break;
                        case "b":
                            int[] allMoves = Bishop.diagonallyUpRight(board, j, i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Bishop.diagonallyUpLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Bishop.diagonallyDownRight(board, j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Bishop.diagonallyDownLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            break;
                        case "r":
                            allMoves = Rook.right(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Rook.left(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Rook.up(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Rook.down(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;
                            break;
                        case "q":
                            allMoves = Queen.diagonallyDownLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.diagonallyDownRight(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.diagonallyUpLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.diagonallyUpRight(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.down(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.up(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.left(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.right(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;
                            break;
                        case "n":
                            move = Knight.oneUpTwoLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.upOneTwoRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.upTwoOneLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.upTwoOneRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.downOneTwoRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.downTwoOneLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.downTwoOneRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.oneDownTwoLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            break;
                        case "k":
                            move = King.up(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.down(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.right(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.left(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyUpRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyUpLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyDownRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyDownLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.castleRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.castleLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            break;
                    }
                } else if (colour.equals("black") && board[i][j].getColour().equals("black")) {
                    switch (board[i][j].getName()) {
                        case "P":
                            int[] move = Pawn.upOne(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                // for promotions
                                if (move[1]==7) {
                                    for (int k = 5; k <=8; k++) {
                                        if (index >= permutationLists.length) {
                                            permutationLists = increaseSize(permutationLists);
                                        }
                                        permutationLists[index] = new PermutationList(promotionAi(move,k));
                                        index++;
                                    }
                                } else {
                                    permutationLists[index] = new PermutationList(move);
                                    index++;
                                }
                            }
                            move = Pawn.upTwo(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.captureRight(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.captureLeft(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.enPassantRight(board, j, i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = Pawn.enPassantLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            break;
                        case "B":
                            int[] allMoves = Bishop.diagonallyUpRight(board, j, i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Bishop.diagonallyUpLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Bishop.diagonallyDownRight(board, j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Bishop.diagonallyDownLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            break;
                        case "R":
                            allMoves = Rook.right(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Rook.left(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Rook.up(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Rook.down(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;
                            break;
                        case "Q":
                            allMoves = Queen.diagonallyDownLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.diagonallyDownRight(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.diagonallyUpLeft(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.diagonallyUpRight(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.down(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.up(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.left(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;

                            allMoves = Queen.right(board,j,i);
                            permutationLists = generateMoves(allMoves,index,permutationLists);
                            index = permutationLists.length;
                            break;
                        case "N":
                            move = Knight.oneUpTwoLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.upOneTwoRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.upTwoOneLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.upTwoOneRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.downOneTwoRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.downTwoOneLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.downTwoOneRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }

                            move = Knight.oneDownTwoLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            break;
                        case "K":
                            move = King.up(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.down(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.right(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.left(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyUpRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyUpLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyDownRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.diagonallyDownLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.castleRight(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            move = King.castleLeft(board,j,i);
                            if (move[0] != -1 && move[1] != -1) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(move);
                                index++;
                            }
                            break;
                    }
                }
            }
        }
        return permutationLists;
    }

    /**
     * generates all moves for one piece
     * used to check if the user move is a legal move
     * @param board
     * @param colour
     * @return
     */
    public PermutationList[] allPieceMoves(Pieces[][] board, String colour, int i, int j) {
        PermutationList[] permutationLists = new PermutationList[0];
        int index = 0;

        if (colour.equals("white") && board[i][j].getColour().equals("white")) {
            switch (board[i][j].getName()) {
                case "p":
                    int[] move = Pawn.upOne(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }

                        // for promotions
                        if (move[1]==0) {
                            for (int k = 1; k <=4; k++) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(promotionAi(move,k));
                                index++;
                            }
                        } else {
                            permutationLists[index] = new PermutationList(move);
                            index++;
                        }
                    }
                    move = Pawn.upTwo(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.captureRight(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.captureLeft(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.enPassantRight(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.enPassantLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    break;
                case "b":
                    int[] allMoves = Bishop.diagonallyUpRight(board, j, i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Bishop.diagonallyUpLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Bishop.diagonallyDownRight(board, j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Bishop.diagonallyDownLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    break;
                case "r":
                    allMoves = Rook.right(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Rook.left(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Rook.up(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Rook.down(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;
                    break;
                case "q":
                    allMoves = Queen.diagonallyDownLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.diagonallyDownRight(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.diagonallyUpLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.diagonallyUpRight(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.down(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.up(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.left(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.right(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;
                    break;
                case "n":
                    move = Knight.oneUpTwoLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.upOneTwoRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.upTwoOneLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.upTwoOneRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.downOneTwoRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.downTwoOneLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.downTwoOneRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.oneDownTwoLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    break;
                case "k":
                    move = King.up(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.down(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.right(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.left(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyUpRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyUpLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyDownRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyDownLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.castleRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.castleLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    break;
            }
        } else if (colour.equals("black") && board[i][j].getColour().equals("black")) {
            switch (board[i][j].getName()) {
                case "P":
                    int[] move = Pawn.upOne(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }

                        // for promotions
                        if (move[1]==7) {
                            for (int k = 5; k <=8; k++) {
                                if (index >= permutationLists.length) {
                                    permutationLists = increaseSize(permutationLists);
                                }
                                permutationLists[index] = new PermutationList(promotionAi(move,k));
                                index++;
                            }
                        } else {
                            permutationLists[index] = new PermutationList(move);
                            index++;
                        }
                    }
                    move = Pawn.upTwo(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.captureRight(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.captureLeft(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.enPassantRight(board, j, i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = Pawn.enPassantLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    break;
                case "B":
                    int[] allMoves = Bishop.diagonallyUpRight(board, j, i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Bishop.diagonallyUpLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Bishop.diagonallyDownRight(board, j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Bishop.diagonallyDownLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    break;
                case "R":
                    allMoves = Rook.right(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Rook.left(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Rook.up(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Rook.down(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;
                    break;
                case "Q":
                    allMoves = Queen.diagonallyDownLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.diagonallyDownRight(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.diagonallyUpLeft(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.diagonallyUpRight(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.down(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.up(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.left(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;

                    allMoves = Queen.right(board,j,i);
                    permutationLists = generateMoves(allMoves,index,permutationLists);
                    index = permutationLists.length;
                    break;
                case "N":
                    move = Knight.oneUpTwoLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.upOneTwoRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.upTwoOneLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.upTwoOneRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.downOneTwoRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.downTwoOneLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.downTwoOneRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }

                    move = Knight.oneDownTwoLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    break;
                case "K":
                    move = King.up(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.down(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.right(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.left(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyUpRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyUpLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyDownRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.diagonallyDownLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.castleRight(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    move = King.castleLeft(board,j,i);
                    if (move[0] != -1 && move[1] != -1) {
                        if (index >= permutationLists.length) {
                            permutationLists = increaseSize(permutationLists);
                        }
                        permutationLists[index] = new PermutationList(move);
                        index++;
                    }
                    break;
            }
        }
        return permutationLists;
    }

    /**
     * queen, bishop, rook return a movement list containing all possible moves for one direction,
     * this method breaks down that list into individual moves
     * @param allMoves
     * @param index
     * @param permutationLists
     * @return
     */
    private PermutationList[] generateMoves(int[] allMoves, int index,
                                            PermutationList[] permutationLists) {
        int[] move;
        if (allMoves[0] != -1 && allMoves[1] != -1) {
            for (int k = 0; k < allMoves.length - 2; k+=2) {
                move = new int[4];
                if (index >= permutationLists.length) {
                    permutationLists = increaseSize(permutationLists);
                }
                move[0] = allMoves[k];
                move[1] = allMoves[k+1];
                move[2] = allMoves[allMoves.length - 2];
                move[3] = allMoves[allMoves.length - 1];
                permutationLists[index] = new PermutationList(move);
                index++;
            }
        }
        return permutationLists;
    }

    /**
     * increases the size of move list if needed
     * @return
     */
    private PermutationList[] increaseSize(PermutationList[] permutationList) {
        PermutationList[] newList = new PermutationList[permutationList.length + 1];

        for (int i = 0; i < permutationList.length; i++) {
            newList[i] = permutationList[i];
        }
        return  newList;
    }

    /**
     * makes the move
     * @param board
     */
    public Game makeMove(Game board, int[] lists) {
        Game newBoard = new Game(tempCopy(board.board),board.numWhitePieces, board.numBlackPieces);

        if (lists.length == 4) {
            if (newBoard.board[lists[1]][lists[0]].getName().equals("K")) {
                newBoard.setWinnerWhite(true);
            }
            if (newBoard.board[lists[1]][lists[0]].getName().equals("k")) {
                newBoard.setWinnerBlack(true);
            }
            Pieces temp = newBoard.board[lists[3]][lists[2]];
            newBoard.board[lists[3]][lists[2]] = new Blank("empty");
            newBoard.board[lists[1]][lists[0]] = temp;
            newBoard.board[lists[1]][lists[0]].setMoved(true);

            Pawn.setAllEnPassantFalse(newBoard.board,lists[0], lists[1]);

            // checks to see if king is in check
            if (newBoard.board[lists[1]][lists[0]].getColour().equals("black")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "k","white"));
            } else if (newBoard.board[lists[1]][lists[0]].getColour().equals("white")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "K","black"));
            }


        // move for pawn enPassant
        } else if (lists.length == 6){
            Pieces temp = newBoard.board[lists[3]][lists[2]];
            newBoard.board[lists[3]][lists[2]] = new Blank("empty");
            newBoard.board[lists[1]][lists[0]] = temp;
            newBoard.board[lists[5]][lists[4]] = new Blank("empty");
            Pawn.setAllEnPassantFalse(newBoard.board,-1, -1);

            // sees if king is in check
            if (newBoard.board[lists[1]][lists[0]].getColour().equals("black")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "k","white"));
            } else if (newBoard.board[lists[1]][lists[0]].getColour().equals("white")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "K","black"));
            }

        // move for king castle
        } else if (lists.length==8) {
            Pieces temp1 = newBoard.board[lists[1]][lists[2]];
            newBoard.board[lists[1]][lists[2]] = new Blank("empty");
            Pieces temp2 = newBoard.board[lists[1]][lists[4]];
            newBoard.board[lists[1]][lists[4]] = new Blank("empty");
            newBoard.board[lists[1]][lists[0]] = temp1;
            newBoard.board[lists[1]][lists[0]].setMoved(true);
            newBoard.board[lists[1]][lists[5]] = temp2;
            newBoard.board[lists[1]][lists[5]].setMoved(true);
            Pawn.setAllEnPassantFalse(newBoard.board,-1, -1);

            //sees if king is in check
            if (newBoard.board[lists[1]][lists[0]].getColour().equals("black")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "k","white"));
            } else if (newBoard.board[lists[1]][lists[0]].getColour().equals("white")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "K","black"));
            }
        // pawn promotion
        } else if (lists.length==7) {
            newBoard.board[lists[3]][lists[2]] = new Blank("empty");
            switch (lists[6]) {
                case 1:
                    newBoard.board[lists[1]][lists[0]] = new Bishop("white");
                    break;
                case 2:
                    newBoard.board[lists[1]][lists[0]] = new Knight("white");
                    break;
                case 3:
                    newBoard.board[lists[1]][lists[0]] = new Queen("white");
                    break;
                case 4:
                    newBoard.board[lists[1]][lists[0]] = new Rook("white");
                    break;
                case 5:
                    newBoard.board[lists[1]][lists[0]] = new Bishop("black");
                    break;
                case 6:
                    newBoard.board[lists[1]][lists[0]] = new Knight("black");
                    break;
                case 7:
                    newBoard.board[lists[1]][lists[0]] = new Queen("black");
                    break;
                case 8:
                    newBoard.board[lists[1]][lists[0]] = new Rook("black");
            }
            Pawn.setAllEnPassantFalse(newBoard.board,-1, -1);

            //sees if king is in check
            if (newBoard.board[lists[1]][lists[0]].getColour().equals("black")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "k","white"));
            } else if (newBoard.board[lists[1]][lists[0]].getColour().equals("white")) {
                newBoard.setCheckValue(Board.check(newBoard.board, "K","black"));
            }
        }

        if (newBoard.board[lists[1]][lists[0]].getColour().equals("black")) {
            PermutationList[] allMoves = generateAllMoves(newBoard.board, "white");
            if (allMoves.length==0 && newBoard.checkValue==0) {
                newBoard.setStalemate(true);
            } else if (allMoves.length==0 && newBoard.checkValue!=0) {
                newBoard.setWinnerBlack(true);
            } else if (Board.check(newBoard.board, "K","black") > 0) {
                newBoard.setWinnerWhite(true);
            }
        } else if (newBoard.board[lists[1]][lists[0]].getColour().equals("white")) {
            PermutationList[] allMoves = generateAllMoves(newBoard.board, "black");
            if (allMoves.length==0 && newBoard.checkValue==0) {
                newBoard.setStalemate(true);
            } else if (allMoves.length==0 && newBoard.checkValue!=0) {
                newBoard.setWinnerWhite(true);
            } else if (Board.check(newBoard.board, "k","white") < 0) {
                newBoard.setWinnerBlack(true);
            }
        }

        return newBoard;
    }

    /**
     * deep copies an array
     */
    public Pieces[][] tempCopy(Pieces[][] board) {
        Pieces[][] temp = new Pieces[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                temp[i][j] = deepCopy(board[i][j]);
            }
        }
        return temp;
    }

    /**
     * deep copies a piece
     * @return
     */
    public Pieces deepCopy(Pieces piece) {
        Pieces newPiece;
        switch (piece.getName()) {
            case "b":
                newPiece = new Bishop("white");
                newPiece.setMoved(piece.getMoved());
                break;
            case "k":
                newPiece = new King("white");
                newPiece.setMoved(piece.getMoved());
                break;
            case "n":
                newPiece = new Knight("white");
                newPiece.setMoved(piece.getMoved());
                break;
            case "p":
                newPiece = new Pawn("white");
                newPiece.setMoved(piece.getMoved());
                newPiece.setEnPassant(piece.getEnPassant());
                break;
            case "q":
                newPiece = new Queen("white");
                newPiece.setMoved(piece.getMoved());
                break;
            case "r":
                newPiece = new Rook("white");
                newPiece.setMoved(piece.getMoved());
                break;
            case "B":
                newPiece = new Bishop("black");
                newPiece.setMoved(piece.getMoved());
                break;
            case "K":
                newPiece = new King("black");
                newPiece.setMoved(piece.getMoved());
                break;
            case "N":
                newPiece = new Knight("black");
                newPiece.setMoved(piece.getMoved());
                break;
            case "P":
                newPiece = new Pawn("black");
                newPiece.setMoved(piece.getMoved());
                newPiece.setEnPassant(piece.getEnPassant());
                break;
            case "Q":
                newPiece = new Queen("black");
                newPiece.setMoved(piece.getMoved());
                break;
            case "R":
                newPiece = new Rook("black");
                newPiece.setMoved(piece.getMoved());
                break;
            case "-":
                newPiece = new Blank("empty");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + piece.getName());
        }
        return newPiece;
    }

    /**
     * copies the move list for pawn but adds a value at index 6 specifying what the pawn should be promoted too for ai.
     * @param moves
     * @param promotionValue
     * @return
     */
    private int[] promotionAi(int[] moves, int promotionValue) {
        int [] promotion = new int[7];
        for (int i = 0; i < moves.length; i++) {
            promotion[i] = moves[i];
        }
        promotion[4] = -1;
        promotion[5] = -1;
        promotion[6] = promotionValue;
        return promotion;
    }

    /**
     * copies the move list for pawn but adds a value at index 6 specifying what to promote too for player
     * @param moves
     * @param name
     * @param colour
     * @return
     */
    public int[] promotionPlayer(int[] moves, String name, String colour) {
        int [] promotion = new int[7];
        for (int i = 0; i < moves.length; i++) {
            promotion[i] = moves[i];
        }
        promotion[4] = -1;
        promotion[5] = -1;

        if (colour.equals("white")) {
            switch (name) {
                case "bishop":
                    promotion[6] = 1;
                    break;
                case "knight":
                    promotion[6] = 2;
                    break;
                case "queen":
                    promotion[6] = 3;
                    break;
                case "rook":
                    promotion[6] = 4;
                    break;
            }
        } else if (colour.equals("black")) {
            switch (name) {
                case "bishop":
                    promotion[6] = 5;
                    break;
                case "knight":
                    promotion[6] = 6;
                    break;
                case "queen":
                    promotion[6] = 7;
                    break;
                case "rook":
                    promotion[6] = 8;
                    break;
            }
        }
        return promotion;
    }
}

/**
 * class that holds move individual move for a piece
 */
class PermutationList {
    int[] move;
    double heuristicValue;
    public PermutationList(int[] move) {
        this.move = move;
    }
}
