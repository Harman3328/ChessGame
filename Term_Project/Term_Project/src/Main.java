import ChessPieces.*;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    ArrayList<int[]> moveHistory = new ArrayList<>();
    /**
     * runs the chess game and asks for the necessary parameters
     */
    public Main() {
        String player;
        Board b = new Board();
        Pieces[][] squares = new Pieces[8][8];
        Game board = null;

        Scanner scanner = new Scanner(System.in);
        int startGame;
        int depth;

        while (true) {
            System.out.print("White or Black: ");
            player = scanner.nextLine();
            player = player.toLowerCase();
            if (player.equals("white") || player.equals("black")) break;
            System.out.println("Try again");
        }
        while (true) {
            System.out.print("Enter search depth: ");
            if (scanner.hasNextInt()) {
                depth = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.print("Enter 1 (new Game) or 2 (initialize board): ");
                startGame = Integer.parseInt(scanner.nextLine());

                if (startGame == 1 || startGame ==2) break;

            } catch (NumberFormatException e) {
                System.out.println("try again");
            }
        }

        if (startGame == 1) {
            board = new Game(b.initialBoard(squares),16,16);
            b.printBoard(board.board);
        }
        else if (startGame == 2) {
            int numWhite = 0;
            int numBlack = 0;
            while (true) {
                System.out.print("Enter name of piece, location and colour (pawn e6 white) or done: ");
                String setUp = scanner.nextLine();
                if (setUp.equals("done")) break;
                String[] array = setUp.split(" ");
                if (array.length == 3) {
                    array[0] = array[0].toLowerCase();
                    if (checkPiece(array[0]) && checkLocation(array, 1) &&checkColour(array)) {
                        if (array[2].toLowerCase().equals("white")) numWhite++;
                        if (array[2].toLowerCase().equals("black")) numBlack++;
                        board = new Game(b.initialBoardTwo(squares, array),numWhite,numBlack);
                    } else {
                        System.out.println("Try again");
                    }
                } else {
                    System.out.println("Incorrect Parameter");
                }
            }
            if (board.board != null) {
                b.printBoard(board.board);
            }
        }
        Move move = new Move();

        outerloop:
        while (!board.isWinnerBlack() && !board.isWinnerWhite() && !board.isStalemate()) {
            if (player.equals("black")) {
                //ai's turn
                int[] bMove = bestMove(board,b,move,"white",false, depth);
                if (bMove.length == 0 && board.getCheckValue() == 0) {
                    board.setStalemate(true);
                } else if (bMove.length == 0) {
                    board.setWinnerBlack(true);
                    System.out.println("Checkmate");
                } else if (board.getCheckValue() != 0) {
                    System.out.println("Check");
                }
                if (board.isStalemate()) break;
                if (board.isWinnerBlack()) break;
                board = move.makeMove(board,bMove);

                if (board.isWinnerBlack()) {
                    System.out.println("Checkmate");
                    break;
                }

                b.printBoard(board.board);
                System.out.println(b.aiXLocation(bMove[2]) +""+ b.aiYLocation(bMove[3]) + "-" +
                        b.aiXLocation(bMove[0]) +""+ b.aiYLocation(bMove[1]));

                if (board.isWinnerWhite()) {
                    System.out.println("Checkmate");
                    break;
                }
                //player's turn
                boolean correctMove = false;
                while (!correctMove) {
                    PermutationList[] allMoves = move.generateAllMoves(board.board, "black");
                    if (allMoves.length==0 && board.checkValue == 0) {
                        board.setStalemate(true);
                        break outerloop;
                    } else if (allMoves.length == 0) {
                        board.setWinnerWhite(true);
                        System.out.println("Checkmate");
                        break outerloop;
                    } else if (isCheckmate(board,allMoves,move,"K","black")) {
                        board.setWinnerWhite(true);
                        System.out.println("Checkmate");
                        break outerloop;
                    } else if (board.getCheckValue() != 0) {
                        System.out.println("Check");
                    }
                    System.out.print("Your move, enter current location, new location (a2 a3) or exit: ");
                    String playerMove = scanner.nextLine();
                    if (playerMove.equals("exit")) break outerloop;
                    String[] array = playerMove.split(" ");
                    if (array.length == 2) {
                        if (checkLocation(array,0) && checkLocation(array,1)) {
                            int[] list = playerTurn(array,b);
                            while (board.board[list[3]][list[2]].getName().equals("P") && list[1]==7) {
                                System.out.print("Promotion! Enter Piece Name: ");
                                String pieceName = scanner.nextLine();
                                pieceName = pieceName.toLowerCase();
                                if (checkPiece(pieceName) && !pieceName.equals("king") && !pieceName.equals("pawn")) {
                                    list = move.promotionPlayer(list,pieceName,"black");
                                    break;
                                }
                            }

                            allMoves = move.allPieceMoves(board.board, "black",list[3],list[2]);
                            for (PermutationList m : allMoves) {
                                if (m.move[0]==list[0] && m.move[1]==list[1] && m.move[2]==list[2] &&
                                        m.move[3]==list[3]) {
                                    board = move.makeMove(board, playerMove(list,m.move));
                                    if (board.isWinnerWhite()) {
                                        System.out.println("Checkmate");
                                        break outerloop;
                                    }
                                    b.printBoard(board.board);
                                    if (board.isWinnerBlack()) {
                                        System.out.println("Checkmate");
                                        break outerloop;
                                    }
                                    correctMove = true;
                                    break;
                                }
                            }
                            if (!correctMove) {
                                System.out.println("Invalid Move. Try Again.");
                            }
                        } else {
                            System.out.println("Invalid Input. Try Again.");
                        }
                    } else {
                        System.out.println("Invalid Input. Try Again.");
                    }
                }
            } else {
                //player's turn
                boolean correctMove = false;
                while (!correctMove) {
                    PermutationList[] allMoves = move.generateAllMoves(board.board, "white");
                    if (allMoves.length==0 && board.checkValue == 0) {
                        board.setStalemate(true);
                        break outerloop;
                    } else if (allMoves.length == 0) {
                        board.setWinnerBlack(true);
                        System.out.println("Checkmate");
                        break outerloop;
                    } else if (isCheckmate(board,allMoves,move,"k","white")) {
                        board.setWinnerBlack(true);
                        System.out.println("Checkmate");
                        break outerloop;
                    } else if (board.getCheckValue() != 0) {
                        System.out.println("Check");
                    }
                    System.out.print("Your move, enter current location, new location (a2 a3) or exit: ");
                    String playerMove = scanner.nextLine();
                    if (playerMove.equals("exit")) break outerloop;
                    String[] array = playerMove.split(" ");
                    if (array.length == 2) {
                        if (checkLocation(array,0) && checkLocation(array,1)) {
                            int[] list = playerTurn(array,b);
                            while (board.board[list[3]][list[2]].getName().equals("p") && list[1]==0) {
                                System.out.print("Promotion! Enter Piece Name: ");
                                String pieceName = scanner.nextLine();
                                pieceName = pieceName.toLowerCase();
                                if (checkPiece(pieceName) && !pieceName.equals("king") && !pieceName.equals("pawn")) {
                                    list = move.promotionPlayer(list,pieceName,"white");
                                    break;
                                }
                            }

                            allMoves = move.allPieceMoves(board.board, "white",list[3],list[2]);
                            for (PermutationList m : allMoves) {
                                if (m.move[0]==list[0] && m.move[1]==list[1] && m.move[2]==list[2] &&
                                        m.move[3]==list[3]) {
                                    board = move.makeMove(board, playerMove(list,m.move));
                                    if (board.isWinnerBlack()) {
                                        System.out.println("Checkmate");
                                        break outerloop;
                                    }
                                    b.printBoard(board.board);
                                    if (board.isWinnerWhite()) {
                                        System.out.println("Checkmate");
                                        break outerloop;
                                    }
                                    correctMove = true;
                                    break;
                                }
                            }
                            if (!correctMove) {
                                System.out.println("Invalid Move. Try Again.");
                            }
                        } else {
                            System.out.println("Invalid Input. Try Again");
                        }
                    } else {
                        System.out.println("Invalid Input. Try Again");
                    }
                }

                //ai's turn
                int[] bMove = bestMove(board,b,move,"black",true, depth);
                if (bMove.length == 0 && board.getCheckValue() == 0) {
                    board.setStalemate(true);
                } else if (bMove.length == 0) {
                    board.setWinnerWhite(true);
                } else if (board.getCheckValue() != 0) {
                    System.out.println("Check");
                }
                if (board.isStalemate()) break;
                if (board.isWinnerWhite()) {
                    System.out.println("Checkmate");
                    break;
                }
                board = move.makeMove(board,bMove);
                if (board.isWinnerWhite()) {
                    System.out.println("Checkmate");
                    break;
                }
                b.printBoard(board.board);
                System.out.println(b.aiXLocation(bMove[2])+""+ b.aiYLocation(bMove[3]) + "-" + b.aiXLocation(bMove[0])
                        +"" + b.aiYLocation(bMove[1]));
                if (board.isWinnerBlack()) {
                    System.out.println("Checkmate");
                    break;
                }
            }
        }
        if (board.isWinnerWhite()) {
            System.out.println("White won");
        } else if (board.isWinnerBlack()) {
            System.out.println("Black won");
        } else if (board.isStalemate()) {
            System.out.println("Stalemate");
        }
    }

    /**
     * returns a list holding the array coordinates of the player's move
     * @param array
     * @param b
     * @return
     */
    private int[] playerTurn(String[] array, Board b) {
        char[] charArray = array[0].toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        int num = Character.getNumericValue(charArray[1]);
        int y1 = b.yLocation(num);
        int x1 = b.xLocation(charArray);
        charArray = array[1].toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        num = Character.getNumericValue(charArray[1]);
        int y2 = b.yLocation(num);
        int x2 = b.xLocation(charArray);
        int[] list = {x2, y2, x1, y1};
        return list;
    }

    private boolean isCheckmate(Game board, PermutationList[] allMoves, Move move, String name,
                                String colour) {
        for (PermutationList list: allMoves) {
            Game temp = move.makeMove(board, list.move);
            if (Board.check(temp.board, name,colour) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * return a list containing the legal move the player wants to make
     * @param list
     * @param move
     * @return
     */
    private int[] playerMove(int[] list, int[] move) {
        if (list.length == 7) return list;

        int remainingLength = move.length - 4;
        int[] pMove = new int[list.length + remainingLength];

        for (int i = 0; i < list.length; i++) {
            pMove[i] = list[i];
        }

        for (int i = remainingLength; i < move.length; i++) {
            pMove[i] = move[i];
        }
        return pMove;
    }

    /**
     * picks the best move for the ai
     * @param currentBoard
     * @param board
     * @param move
     * @param colour
     * @param maxPLayer
     * @param depth
     * @return
     */
    private int[] bestMove(Game currentBoard, Board board, Move move, String colour, Boolean maxPLayer, int depth) {
        double bestScore = 0;
        PermutationList[] list;
        if (colour.equals("white")) {
            bestScore = Double.NEGATIVE_INFINITY;
        } else {
            bestScore = Double.POSITIVE_INFINITY;
        }
        int[] bMove = new int[0];
        list = move.generateAllMoves(currentBoard.board, colour);
        if (colour.equals("white")) {
            if (list.length==0 && Board.check(currentBoard.board, "k","white") == 0) {
                currentBoard.setStalemate(true);
            } else if (list.length == 0) {
                currentBoard.setWinnerBlack(true);
            }
        } else {
            if (list.length==0 && Board.check(currentBoard.board, "K","black") == 0) {
                currentBoard.setStalemate(true);
            } else if (list.length == 0) {
                currentBoard.setWinnerWhite(true);
            }
        }
        for (PermutationList lists: list) {
            Game temp = new Game(move.tempCopy(currentBoard.board),currentBoard.numWhitePieces,
                    currentBoard.numBlackPieces);
            temp = move.makeMove(temp, lists.move);
            double score = minimax(temp,depth,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, maxPLayer,
                    move,board,depth);
            if (colour.equals("white")) {
                if (score > bestScore && moveHistory.size() < 6) {
                    bestScore = score;
                    bMove = lists.move;
                } else if (score > bestScore && !checkRepetition(lists.move)) {
                    bestScore = score;
                    bMove = lists.move;
                }
            } else {
                if (score < bestScore) {
                    bestScore = score;
                    bMove = lists.move;
                } else if (score < bestScore && !checkRepetition(lists.move)) {
                    bestScore = score;
                    bMove = lists.move;
                }
            }
        }
        if (moveHistory.size() == 20) {
            clearSpace();
        }
        moveHistory.add(bMove);
        return bMove;
    }

    private boolean checkRepetition(int[] lists) {
        return Arrays.equals(lists,moveHistory.get(moveHistory.size()-6)) &&
                Arrays.equals(lists,moveHistory.get(moveHistory.size()-4)) &&
                Arrays.equals(lists,moveHistory.get(moveHistory.size()-2));
    }

    /**
     * once moveHistory size equals 20, clear the first 14
     */
    private void clearSpace() {
        for (int i = 0; i < moveHistory.size()-6; i++) {
            moveHistory.remove(i);
        }
    }

    /**
     * checks to see if piece exists, if so, return true
     * @param name
     * @return
     */
    public boolean checkPiece(String name) {
        return name.equals("pawn") || name.equals("bishop") || name.equals("king") ||
                name.equals("knight") || name.equals("queen") || name.equals("rook");
    }

    /**
     * checks to see if location exists on board
     * @param array
     * @return
     */
    public boolean checkLocation(String[] array, int index) {
        char[] charArray = array[index].toCharArray();
        if (charArray.length!=2) return false;
        charArray[0] = Character.toLowerCase(charArray[0]);
        int num = Character.getNumericValue(charArray[1]);
        return (charArray[0] == 'a' || charArray[0] == 'b' || charArray[0] == 'c' ||
                charArray[0] == 'd' || charArray[0] == 'e' || charArray[0] == 'f' ||
                charArray[0] == 'g' || charArray[0] == 'h') &&
                (num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6 ||
                        num == 7 || num == 8);
    }

    /**
     * checks to see if the user entered the correct colour
     * @param array
     * @return
     */
    public boolean checkColour(String[] array) {
        return array[2].equals("white") || array[2].equals("black");
    }

    /**
     * minimax algorithm with alpha beta pruning
     * checks all possible moves to a certain depth and returns the score for the best move
     * @param currentBoard
     * @param depth
     * @param alpha
     * @param beta
     * @param maximizingPlayer
     * @param move
     * @param board
     * @return
     */
    private double minimax(Game currentBoard, int depth, double alpha, double beta,
                        boolean maximizingPlayer, Move move, Board board, int mainDepth) {

        if (depth == 0 || currentBoard.isWinnerBlack() || currentBoard.isWinnerWhite() || currentBoard.isStalemate()) {
            if (currentBoard.heuristicValue != Double.POSITIVE_INFINITY) {
                return currentBoard.heuristicValue;
            }
            return board.materialValue(currentBoard, depth, mainDepth, maximizingPlayer);
        }

        if (maximizingPlayer) {
            double maxEvaluation = Double.NEGATIVE_INFINITY;
            PermutationList[] lists = move.generateAllMoves(currentBoard.board, "white");
            lists = sort(lists,currentBoard,maximizingPlayer,move,depth,mainDepth,board);
            if (lists.length==0 && Board.check(currentBoard.board, "k","white") == 0) {
                currentBoard.setStalemate(true);
                return board.materialValue(currentBoard, depth, mainDepth, maximizingPlayer);
            } else if (lists.length == 0) {
                currentBoard.setWinnerBlack(true);
                return board.materialValue(currentBoard, depth, mainDepth, maximizingPlayer);
            }
            for (PermutationList list : lists) {
                Game temp = new Game(move.tempCopy(currentBoard.board), currentBoard.numWhitePieces,
                        currentBoard.numBlackPieces);
                temp = move.makeMove(temp, list.move);
                temp.heuristicValue = list.heuristicValue;
                double eval = minimax(temp, depth - 1, alpha, beta, false,
                        move, board,mainDepth);
                temp = new Game(move.tempCopy(currentBoard.board),currentBoard.numWhitePieces,
                        currentBoard.numBlackPieces);
                maxEvaluation = max(maxEvaluation, eval);
                alpha = max(alpha, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEvaluation;
        } else {
            double minEval = Double.POSITIVE_INFINITY;
            PermutationList[] lists = move.generateAllMoves(currentBoard.board, "black");
            lists = sort(lists,currentBoard,maximizingPlayer,move,depth,mainDepth,board);
            if (lists.length==0 && Board.check(currentBoard.board, "K","black") == 0) {
                currentBoard.setStalemate(true);
                return board.materialValue(currentBoard, depth, mainDepth, maximizingPlayer);
            } else if (lists.length == 0) {
                return board.materialValue(currentBoard, depth, mainDepth, maximizingPlayer);
            }
            for (PermutationList list : lists) {
                Game temp = new Game(move.tempCopy(currentBoard.board),currentBoard.numWhitePieces,
                        currentBoard.numBlackPieces);
                temp = move.makeMove(temp, list.move);
                temp.heuristicValue = list.heuristicValue;
                double eval = minimax(temp, depth - 1, alpha, beta,
                        true, move, board,mainDepth);
                temp = new Game(move.tempCopy(currentBoard.board), currentBoard.numWhitePieces,
                        currentBoard.numBlackPieces);
                minEval = min(minEval, eval);
                beta = min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }

    /**
     * orders the move list by the heuristic value of the indivdual moves
     * White move ordering: highest to lowest
     * Black move ordering: lowest to highest
     * @param moves
     * @param board
     * @param maximizingPlayer
     * @param move
     * @param depth
     * @param mainDepth
     * @param b
     * @return
     */
    private PermutationList[] sort(PermutationList[] moves, Game board, boolean maximizingPlayer, Move move, int depth,
                                   int mainDepth, Board b) {
        for (int i = 0; i < moves.length; i++) {
            Game temp = move.makeMove(board, moves[i].move);
            moves[i].heuristicValue = b.materialValue(temp, depth, mainDepth,maximizingPlayer);
        }
        if (maximizingPlayer) {
            Arrays.sort(moves, new Comparator<PermutationList>() {
                @Override
                public int compare(PermutationList o1, PermutationList o2) {
                    if (o1 == null || o2 == null) return 0;
                    return Double.compare(o2.heuristicValue, o1.heuristicValue);
                }
            });
        } else {
            Arrays.sort(moves, new Comparator<PermutationList>() {
                @Override
                public int compare(PermutationList o1, PermutationList o2) {
                    if (o1 == null || o2 == null) return 0;
                    return Double.compare(o1.heuristicValue, o2.heuristicValue);
                }
            });
        }
        return moves;
    }

    public static void main(String[] args) {Main main = new Main();}
}
