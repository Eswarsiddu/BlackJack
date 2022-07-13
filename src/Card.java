public class Card {
    private final int value;
    private final SYMBOL symbol;
    private final String number;

    public boolean faceDown = true;

    public Card(SYMBOL symbol, String number){
        this.symbol = symbol;
        this.number = number;
        this.value = Constants.getCardValue(number);
    }

    public String displayCard(){
        if(faceDown){
            return "( Symbol : *, number : * )";
        }
        else {
            return "( Symbol : " + this.symbol + ", number : " + this.number + " )";
        }
    }

    public int getValue(){
        return this.value;
    }
}
