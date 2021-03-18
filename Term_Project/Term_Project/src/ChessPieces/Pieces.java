package ChessPieces;

public abstract class Pieces {

    /**
     * sets name of piece
     * colour false = white -> lowercase
     * colour ture = black -> uppercase
     * @return
     */
    public abstract String setName();

    /**
     * sets value of piece
     * @return
     */
    public abstract int setValue();

    /**
     * returns name of piece
     * @return
     */
    public abstract String getName();

    /**
     * returns value of piece
     * @return
     */
    public abstract int getValue();

    /**
     * return colour of piece
     * @return
     */
    public abstract String getColour();

    /**
     * checks if en-passant is possible
     * @return
     */
    public abstract boolean getEnPassant();

    /**
     * sets en-passant
     * @param possible
     * @return
     */
    public abstract void setEnPassant(boolean possible);

    /**
     * sets moved to true is piece moved from its starting position
     */
    public abstract void setMoved(boolean moved1);

    /**
     * returns true is piece has moved from its starting position
     * @return
     */
    public abstract boolean getMoved();
}
