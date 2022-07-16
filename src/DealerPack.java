import java.util.List;

public class DealerPack extends Pack{
    private boolean first_card;

    public DealerPack(){
        super();
        first_card = true;
    }

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

    @Override
    public void resetDeck(List<Card> finished_deck){
        first_card = true;
        super.resetDeck(finished_deck);
    }

    @Override
    public void addCard(Card card){
        if(first_card){
            card.faceDown();
            first_card = false;
        }
        else{
            card.faceUp();
        }
        super.addCard(card);
    }

    public void playerStayed(){
        cards.get(0).faceUp();
        calculateTotal();
    }

    @Override
    public void displayPack(){ // TODO: This is only for java output
        System.out.println("Dealer");
        super.displayPack();
    }
}
