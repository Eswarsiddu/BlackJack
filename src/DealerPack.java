import java.util.List;

public class DealerPack extends PlayerPack{
    private boolean firstcard = true;

    protected void checkWinStatus() {
        if (total1 > 21) {
            finalvalue = total1;
        } else if (total1 == 21 || total2 == 21) {
            finalvalue = total1;
        }
        else{
            if(total2>21){
                finalvalue = total1;
            }
            else{
                finalvalue = total2;
            }
        }
    }

    public void resetDeck(List<Card> finisheddeck){
        total1 = 0;
        total2 = 0;
        finisheddeck.addAll(cards);
        cards.clear();
        firstcard = true;
    }

    public void addCard(Card card){
        if(firstcard){
            card.faceDown = true;
            firstcard = false;
        }
        else{
            card.faceDown = false;
        }
        cards.add(card);
        calculateTotal();
    }

    public void playerStayed(){
        cards.get(0).faceDown = false;
        calculateTotal();
    }

    public void displayPack(){ // TODO: This is only for java output
        System.out.println("Dealer");
        for(Card card : this.cards){
            System.out.print(card.displayCard()+", ");
        }
        System.out.println("total:"+total1+", total2:"+total2);
        System.out.println("--------------------");
    }
}
