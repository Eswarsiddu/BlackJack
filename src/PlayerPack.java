import java.lang.annotation.Inherited;
import java.util.List;

public class PlayerPack extends Pack {
    private STATE state; // TO Update it in Display, we need this variable
    private WIN_STATUS win_status;

    public PlayerPack(){
        super();
        state = STATE.PLAYING;
        win_status = WIN_STATUS.NONE;
    }

    public void setWinStatus(WIN_STATUS win_status) {
        this.win_status = win_status;
    }

    public WIN_STATUS getWinStatus() {
        return win_status;
    }

    protected void checkWinStatus(){
        if(total1>21){
            win_status = WIN_STATUS.BUST;
            state = STATE.STAYED;
            final_value = total1;
        }
        else if(total1 == 21 || total2 == 21){
            win_status = WIN_STATUS.BLACKJACK;
            state = STATE.STAYED;
            final_value = 21;
        }
        else {
                if (total2 > 21) {
                    final_value = total1;
                } else {
                    final_value = total2;
                }
            win_status = WIN_STATUS.NONE;
        }
    }

    public void playerStayed(){ // TODO: update in display
        state = STATE.STAYED;
    }

    @Override
    public void addCard(Card card){
        card.faceUp();
        super.addCard(card);
    }

    @Override
    public void resetDeck(List<Card> finished_deck){
        win_status = WIN_STATUS.NONE;
        state = STATE.PLAYING;
        super.resetDeck(finished_deck);
    }

    @Override
    public void displayPack(){ // TODO: This is only for java output
        System.out.println("Player");
        super.displayPack();
    }
}
