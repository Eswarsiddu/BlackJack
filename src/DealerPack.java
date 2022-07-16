import java.util.List;

public class DealerPack extends Pack{
    private boolean first_card = true;

    protected void checkWinStatus() {
        if (total1 > 21) {
            final_value = total1;
        } else if (total1 == 21 || total2 == 21) {
            final_value = 21;
        }
        else{
            if(total2>21){
                final_value = total1;
            }
            else{
                final_value = total2;
            }
        }
    }

    public void resetDeck(List<Card> finished_deck){
        first_card = true;
        super.resetDeck(finished_deck);
    }

    public void addCard(Card card){
        if(first_card){
            card.faceDown = true;
            first_card = false;
        }
        else{
            card.faceDown = false;
        }
        super.addCard(card);
    }

    public void playerStayed(){
        cards.get(0).faceDown = false;
        calculateTotal();
    }

    public void displayPack(){ // TODO: This is only for java output
        System.out.println("Dealer");
        super.displayPack();
    }
}
