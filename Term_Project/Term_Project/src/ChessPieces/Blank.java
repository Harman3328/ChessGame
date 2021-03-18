package ChessPieces;

public class Blank extends Pieces {
    String name;
    int value;
    String colour;

    public Blank(String colour) {
        this.colour = colour;
        this.name = setName();
        this.value = setValue();
    }
    /**
     * returns name of piece
     *
     * @return -
     */
    @Override
    public String setName() {
        return "-";
    }

    /**
     * return value of piece
     *
     * @return 0
     */
    @Override
    public int setValue() {
        return 0;
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
     * return colour
     * @return
     */
    @Override
    public String getColour(){return colour;}

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
     *
     */
    @Override
    public void setMoved(boolean moved1) {
    }

    /**
     * returns true is piece has moved from its starting position
     *
     * @return
     */
    @Override
    public boolean getMoved() {
        return false;
    }
}
