public class DealerPack extends PlayerPack{
    private boolean playerstayed = false;

    public void addCard(Card card){
        if(playerstayed){
            super.addCard(card);
        }
        else{
            cards.add(card);
            calculateTotal(1);
        }
    }

    public void playerStayed(){
        playerstayed = true;
    }

}
