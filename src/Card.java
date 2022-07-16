public class Card {
    private final int value;
    private final SYMBOL symbol;
    private final String number;

    public boolean isFaceDown() {
        return face_down;
    }

    private boolean face_down;

    public Card(SYMBOL symbol, String number){
        this.symbol = symbol;
        this.number = number;
        this.value = Constants.getCardValue(number);
        this.face_down = true;
    }

    public String displayCard(){
        if(face_down){
            return "( Symbol : *, number : * )";
        }
        else {
            return "( Symbol : " + this.symbol + ", number : " + this.number + " )";
        }
    }

    public void faceDown(){
        this.face_down = true;
    }

    public void faceUp(){
        this.face_down = false;
    }

    public int getValue(){
        return this.value;
    }
}
