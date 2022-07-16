import java.util.ArrayList;
import java.util.List;

public abstract class Pack {
    protected int total1;
    protected int total2;
    protected int final_value;
    private boolean finished_deal;
    protected List<Card> cards;

    public Pack(){
        total1 = 0;
        total2 = 0;
        final_value = 0;
        finished_deal = false;
        cards = new ArrayList<>();
    }

    public abstract void playerStayed();

    public void finishedDeal() {
        this.finished_deal = true;
    }

    public int getFinal_value() {
        return final_value;
    }

    public void addCard(Card card){
        cards.add(card);
        calculateTotal();
    }

    protected void calculateTotal(){
        int no_of_A = 0;
        int total = 0;
        for(Card card : cards){
            if(card.isFaceDown()){
                continue;
            }
            total += card.getValue();
            if(card.getValue() == 1){
                no_of_A += 1;
            }
        }
        this.total1 = total;
        this.total2 = total + ((no_of_A > 0) ? 10 : 0);
        checkWinStatus();
    }

    protected abstract void checkWinStatus();

    public void resetDeck(List<Card> finished_deck) {
        total1 = 0;
        total2 = 0;
        finished_deal = false;
        finished_deck.addAll(cards);
        cards.clear();
    }

    public void displayPack() { // TODO: This is only for java output
        for(Card card : this.cards){
            System.out.print(card.displayCard()+", ");
        }
        if(finished_deal){
            System.out.println("Total:" + final_value);
        }
        else {
            if (total1 != total2) {
                if (total2 > 21) {
                    System.out.println("total:" + final_value);
                } else {
                    System.out.println("total:" + total1 + ", total2:" + total2);
                }
            } else {
                System.out.println("total:" + final_value);
            }
        }
        System.out.println("--------------------");
    }
}
