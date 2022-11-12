import java.util.Scanner;

public class RockPaperScisors {

        public static String yourChoose()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose what you want to play (anwser s - scissors, r - rock, p - paper)");
            String yourPlay = scanner.next();

            switch(yourPlay)
            {
                case "s": System.out.println("you choose scissors"); break;
                case "p": System.out.println("you choose paper"); break;
                case "r": System.out.println("you choose rock");  break;
            }


            return(yourPlay);    }
        public static String CpuChoose()
        {
            double CChoose = (Math.random()*3) +1 ;
            String CpuPlay;
            if(CChoose < 2)
            {
                CpuPlay = "scissors";
            } else if (CChoose < 3) {
                CpuPlay = "paper";

            }else {
                CpuPlay ="rock";
            }

            return(CpuPlay);
        }
        public static void whoWin(String cpuPlay, String playerPlay){
            System.out.println("enemy choose " + cpuPlay);
            if(cpuPlay == "rock")
            {
                switch(playerPlay)
                {
                    case "p": System.out.println("You win"); myPoints++; break;
                    case "s": System.out.println("You lose"); enemyPoints++; break;
                    case "r": System.out.println("You draw");  break;
                }
            } else if (cpuPlay == "paper") {
                switch (playerPlay){
                    case "s": System.out.println("You win"); myPoints++; break;
                    case "r": System.out.println("You lose"); enemyPoints++; break;
                    case "p": System.out.println("You draw");  break;
                }

            }else
            {
                switch (playerPlay){
                    case "r": System.out.println("You win"); myPoints++; break;
                    case "p": System.out.println("You lose"); enemyPoints++; break;
                    case "s": System.out.println("You draw");  break;
                }
            }
        }
        public static int myPoints;
        public static int enemyPoints;

        public static void main(String[] args) {

            System.out.println("welcome to rock paper scissors");
            myPoints = 0;
            enemyPoints = 0;
            boolean shouldContinue = true;
            int menuChoose;
            while(shouldContinue)
            {
                System.out.println("welcome to rock paper scissors");
                System.out.println("what you want to do?");
                System.out.println("1.Play");
                System.out.println("2.Check score");
                System.out.println("3.Quit");
                Scanner scanner = new Scanner(System.in);
                menuChoose = scanner.nextInt();
                switch(menuChoose) {
                    case 1:
                        whoWin(CpuChoose(), yourChoose());
                        break;
                    case 2:
                        System.out.println("you have " + myPoints + " and your enemy " + enemyPoints);
                        break;
                    case 3: shouldContinue = false;
                }
            }
        }
    }


