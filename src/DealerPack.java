public class DealerPack extends PlayerPack{
    private boolean firstcard = true;

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
        System.out.println("--------------------");
    }
}
