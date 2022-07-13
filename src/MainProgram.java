import java.util.*;

public class MainProgram {
    //region Pure Java Stuff
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        MainProgram program = new MainProgram();
        program.runMain();
    }

    //endregion

    private final DealerPack dealerPack;
    private final PlayerPack playerPack;
    private final Stack<Card> deck;
    private final List<Card> finishedcards;

    public MainProgram(){
        dealerPack = new DealerPack();
        playerPack = new PlayerPack();
        deck = new Stack<>();
        finishedcards = new ArrayList<>();
        for(SYMBOL symbol : SYMBOL.values()){
            for(String number:Constants.CARDNUMBERS){
                deck.push(new Card(symbol,number));
            }
        }
        Collections.shuffle(deck);
    }

    private void displayTable(){
        dealerPack.displayPack();
        playerPack.displayPack();
        System.out.println("====================");
    }

    private void ResetTable(){
        playerPack.resetDeck(finishedcards);
        dealerPack.resetDeck(finishedcards);
        if(deck.size() <= 18){
            deck.addAll(finishedcards);
            finishedcards.clear();
        }
        Collections.shuffle(deck);
    }

    private void playDealer(){
        dealerPack.playerStayed();
        playerPack.playerStayed();
        while(dealerPack.finalvalue<17){
            dealerPack.addCard(deck.pop());
        }
        displayTable();
        if(dealerPack.finalvalue > 21){
            System.out.println("PLAYER WIN");
            return;
        }
        if(playerPack.finalvalue > dealerPack.finalvalue){
            System.out.println("PLAYER WIN");
        }
        else if(playerPack.finalvalue == dealerPack.finalvalue){
            System.out.println("PLAYER PUSH");
        }
        else{
            System.out.println("PLAYER LOSE");
        }
    }

    public void runMain(){
        while (true){
            playerPack.addCard(deck.pop());
            dealerPack.addCard(deck.pop());
            displayTable();
            playerPack.addCard(deck.pop());
            dealerPack.addCard(deck.pop());
            displayTable();
            while(true) {
                WINSTATUS playerstatus = playerPack.getWinstatus();
                if(playerstatus == WINSTATUS.BLACKJACK){
                    playDealer();
                    break;
                }
                if(playerstatus == WINSTATUS.BUST){
                    System.out.println("BUST");
                    break;
                }
                System.out.print("Hit/stay(0/1):");
                int op = in.nextInt();
                if (op == 0) {
                    playerPack.addCard(deck.pop());
                    displayTable();
                } else {
                    playDealer();
                    break;
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
        }
        // Initialise dealer, player
    }
}
