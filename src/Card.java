public class Card {
    private final int value;
    private final SYMBOL symbol;
    private final String number;

    public Card(SYMBOL symbol, String number){
        this.symbol = symbol;
        this.number = number;
        this.value = Constants.getCardValue(number);
    }

    public String displayCard(){
        return "( Symbol : "+ this.symbol + ", number : "+ this.number+" )";
    }

    public int getValue(){
        return this.value;
    }
}
