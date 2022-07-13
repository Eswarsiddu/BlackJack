import java.util.ArrayList;
import java.util.List;

public class PlayerPack {
    protected int total1;
    protected int total2;

    protected int finalvalue;

    private STATE state = STATE.PLAYING;
    private WINSTATUS winstatus = WINSTATUS.NONE;
    protected final List<Card> cards = new ArrayList<>();

    protected void calculateTotal(){
        int noofA = 0;
        int total = 0;
        for(Card card : cards){
            if(card.faceDown){
                continue;
            }
            total += card.getValue();
            if(card.getValue() == 1){
                noofA += 1;
            }
        }
        this.total1 = total;
        this.total2 = total + ((noofA > 0) ? 10 : 0);
        checkWinStatus();
    }

    private void checkWinStatus(){ //TODO: Check all cases and set final value

    }

    public void addCard(Card card){
        this.cards.add(card);
        calculateTotal();
    }

    public void resetDeck(){
        total1 = 0;
        total2 = 0;
        winstatus = WINSTATUS.NONE;
        state = STATE.PLAYING;
        cards.clear();
    }

    public int getTotal1() {
        return total1;
    }

    public int getTotal2() {
        return total2;
    }

    public STATE getState() {
        return state;
    }

    public int getFinalvalue() {
        return finalvalue;
    }

    public void displayPack(){ // TODO: This is only for java output
        System.out.println("Player");
        for(Card card : this.cards){
            System.out.print(card.displayCard()+", ");
        }
        System.out.println("--------------------");
    }
}
