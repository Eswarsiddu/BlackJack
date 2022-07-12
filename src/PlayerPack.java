import java.util.ArrayList;
import java.util.List;

public class PlayerPack {
    private final String DECKNAME = "Player"; // TODO: This is just for java testing
    protected int total1,total2;
    protected final List<Card> cards = new ArrayList<>();

    protected void calculateTotal(int starting){ // TODO : Keep zero as Default Parameter
        int noofA = 0;
        int total = 0;
        for(int i=starting;i<cards.size();i++){
            total += cards.get(i).getValue();
            if(cards.get(i).getValue() == 1){
                noofA += 1;
            }
        }
        this.total1 = total;
        this.total2 = total + ((noofA > 0) ? 10 : 0);
    }

    public void addCard(Card card){
        this.cards.add(card);
        calculateTotal(0); // TODO : Remove 0, as a default parameter
    }

    public void resetDeck(){
        total1 = 0;
        total2 = 0;
        cards.clear();
    }

    public int getTotal1() {
        return total1;
    }

    public int getTotal2() {
        return total2;
    }
    public void displayPack(int starting){ // TODO : Keep zero as Default Parameter

    }
}
