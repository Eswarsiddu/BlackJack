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

    protected void checkWinStatus(){
        if(total1>21){
            winstatus = WINSTATUS.BUST;
            state = STATE.STAYED;
            finalvalue = total1;
        }
        else if(total1 == 21 || total2 == 21){
            winstatus = WINSTATUS.BLACKJACK;
            state = STATE.STAYED;
            finalvalue = total1;
        }
        else {
            if (state == STATE.STAYED) {
                if (total2 > 21) {
                    finalvalue = total1;
                    winstatus = WINSTATUS.NONE;
                } else {
                    finalvalue = total2;
                    winstatus = WINSTATUS.NONE;
                }
            }
        }
    }

    public void playerStayed(){
        state = STATE.STAYED;
        calculateTotal();
        checkWinStatus();
    }

    public void addCard(Card card){
        card.faceDown = false;
        this.cards.add(card);
        calculateTotal();
    }

    public void resetDeck(List<Card> finisheddeck){
        total1 = 0;
        total2 = 0;
        finisheddeck.addAll(cards);
        cards.clear();
        winstatus = WINSTATUS.NONE;
        state = STATE.PLAYING;
    }

    //region Getters
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

    public WINSTATUS getWinstatus() {
        return winstatus;
    }

    //endregion

    public void displayPack(){ // TODO: This is only for java output
        System.out.println("Player");
        for(Card card : this.cards){
            System.out.print(card.displayCard()+", ");
        }
        System.out.println("total:"+total1+", total2:"+total2);
        System.out.println("--------------------");
    }
}
