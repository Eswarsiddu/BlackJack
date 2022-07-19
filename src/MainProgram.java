import java.util.*;

public class MainProgram {
    //region Pure Java Stuff
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        MainProgram program = new MainProgram();
        program.runMain();
    }

    //endregion

    private final DealerPack dealer_pack;
    private final PlayerPack player_pack;
    private final Stack<Card> deck;
    private final List<Card> finished_cards;
    private boolean deal_end = false;

    public MainProgram(){
        // START
        dealer_pack = new DealerPack();
        player_pack = new PlayerPack();
        deck = new Stack<>();
        finished_cards = new ArrayList<>();
        for(SYMBOL symbol : SYMBOL.values()){
            for(String number:Constants.CARD_NUMBERS){
                deck.push(new Card(symbol,number));
            }
        }
        Collections.shuffle(deck);
    }

    private void displayTable(){
        dealer_pack.displayPack();
        player_pack.displayPack();
        System.out.println("====================");
    }

    private void ResetTable(){
        player_pack.resetDeck(finished_cards);
        dealer_pack.resetDeck(finished_cards);
        deal_end = false;
        if(deck.size() <= 18){
            deck.addAll(finished_cards);
            finished_cards.clear();
            Collections.shuffle(deck);
        }
    }

    private void playDealer(){
        dealer_pack.playerStayed();
        player_pack.playerStayed();
        while(dealer_pack.getFinal_value()<17){
            dealerAddCard();
        }

        if(dealer_pack.getFinal_value() > 21 || player_pack.getFinal_value() > dealer_pack.getFinal_value()){
            player_pack.setWinStatus(WIN_STATUS.WIN);
        }
        else if(player_pack.getFinal_value() == dealer_pack.getFinal_value()){
            player_pack.setWinStatus(WIN_STATUS.PUSH);
        }
        else{
            player_pack.setWinStatus(WIN_STATUS.LOSE);
        }
        dealEnd();
    }

    private void dealerAddCard(){
        dealer_pack.addCard(deck.pop());
        displayTable(); // UPDATE Graphics
    }

    private void playerAddCard(){
        player_pack.addCard(deck.pop());
        displayTable(); // UPDATE Graphics
    }

    private void playerHit(){
        playerAddCard();
        checkWinStatus();
    }

    private void playerStay(){
        playDealer();
    }

    private void dealEnd(){
        deal_end = true;
        dealer_pack.finishedDeal();
        player_pack.finishedDeal();
        displayTable();
        switch (player_pack.getWinStatus()){
            case WIN:
                System.out.println("WIN"); break;
            case BLACKJACK:
                System.out.println("BLACKJACK"); break;
            case BUST:
                System.out.println("BUST");break;
            case PUSH:
                System.out.println("PUSH");break;
            case LOSE:
                System.out.println("LOSE");break;
        }
    }

    private void checkWinStatus(){
        WIN_STATUS player_status = player_pack.getWinStatus();
        if(player_status == WIN_STATUS.BLACKJACK || player_status == WIN_STATUS.BUST){
            dealEnd();
        }
    }

    public void runMain(){
        while (true){
            playerAddCard();
            dealerAddCard();

            playerAddCard();
            dealerAddCard();

            checkWinStatus();

            //region Pure Java Input
            while(!deal_end) {
                System.out.print("Hit/stay(0/1):");
                int op = in.nextInt();
                if (op == 0) {
                    playerHit();
                } else {
                    playerStay();
                }
            }
            System.out.println("======GAME OVER=======");
            System.out.println("PLAY Again/Quit(0/1)");
            int o = in.nextInt();
            if(o == 1){
                System.out.println("Game quit");
                break;
            }
            ResetTable();
            //endregion
        }
    }
}
