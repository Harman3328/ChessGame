import ChessPieces.Pieces;

/**
 * class that holds the board and winner/stalemate states
 */
public class Game {
    Pieces[][] board;
    boolean winnerWhite = false;
    boolean winnerBlack = false;
    boolean stalemate = false;
    double checkValue = 0;
    int numWhitePieces;
    int numBlackPieces;
    double heuristicValue = Double.POSITIVE_INFINITY;

    public Game(Pieces[][] board, int numWhitePieces, int numBlackPieces) {
        this.board = board;
        this.numWhitePieces = numWhitePieces;
        this.numBlackPieces = numBlackPieces;
    }

    public void setWinnerWhite(boolean finished) {
        winnerWhite = finished;
    }

    public void setWinnerBlack(boolean finished) {
        winnerBlack = finished;
    }

    public boolean isWinnerWhite() {
        return winnerWhite;
    }

    public boolean isWinnerBlack() {
        return winnerBlack;
    }

    public void setCheckValue(double score) {
        checkValue = score;
    }

    public double getCheckValue() {
        return checkValue;
    }

    public void setStalemate(boolean finished) {
        stalemate = finished;
    }

    public boolean isStalemate() {
        return stalemate;
    }
}
