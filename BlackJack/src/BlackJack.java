import java.lang.Math;
import java.util.Scanner;
public class BlackJack {

    public static int pickACard(){
        double card = (Math.random()*13)+1;
        return (int) card;
    }
    public static int blackJackPlayer(int playerScore){
        boolean shouldContinue = true;
        int card;
        card = pickACard();
        System.out.println("your card is " + card);
        playerScore = playerScore + card;
        return playerScore;

    }
    public static int blackJackDealer(int dealerScore){
        boolean shouldContinue = true;
        int card;
        card = pickACard();
        dealerScore = dealerScore + card;
        return dealerScore;
    }
    public static int hitOrCheckPlayer(int playerScore){
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        while(shouldContinue) {
            playerScore = blackJackPlayer(playerScore);
            System.out.println("now your score is " + playerScore);
            if(playerScore < 21)
            {
                System.out.println("you like to hit or check)anwser h/c");
                String hitOrCheckChoose = scanner.next();
                switch (hitOrCheckChoose) {
                    case "h":
                        System.out.println("lets check new card!");
                        break;
                    case "c":
                        System.out.println("your score is " + playerScore);
                        shouldContinue = false;
                        break;
                } }else { break;

            }

        }

        return playerScore;
    }
    public static int hitOrCheckDealer(int dealerScore){

        while(dealerScore <= 17) {
            dealerScore = blackJackDealer(dealerScore);
        }
        return(dealerScore);
    }
    public static void blackJack(){
        int playerScore=0;
        int dealerScore=0;
        playerScore = hitOrCheckPlayer(playerScore);
        dealerScore = hitOrCheckDealer(dealerScore);
        System.out.println("dealer score is : " + dealerScore);
        if(playerScore == 21 && dealerScore!= 21 || (dealerScore > 21 && playerScore <= 21))
        {
            System.out.println("player win");
        } else if((playerScore> 21 && dealerScore<= 21) || (dealerScore == 21 && playerScore != 21)) {
            System.out.println("dealer win");
        }else if((playerScore == dealerScore) || (dealerScore > 21 && playerScore > 21)) {
            System.out.println(("its draw"));
        } else if ( playerScore > dealerScore) {
            System.out.println("player wins");
        }else {
            System.out.println("dealer wins");
        }
    }
    public static void main(String[] args) {
        blackJack();
    }

}