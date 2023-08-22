import models.Game;
import models.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static Game turnament;
    static final String TEAMS_FILE = "src/main/java/teams.txt";
    static final String PLAYS_FILE = "src/main/java/plays.txt";

    public static void main(String[] args) {
        String[][] teamArray;
        try {
            teamArray = getData();
            turnament = new Game(new Team(teamArray[0][0],teamArray[0][1],teamArray[0][2],
                    new String[]{teamArray[0][3],teamArray[0][4],teamArray[0][5]}), new Team(new Team(teamArray[1][0],teamArray[1][1],teamArray[1][2],
                    new String[]{teamArray[1][3],teamArray[1][4],teamArray[1][5]})));
            startGame();
            printResult();
        } catch (FileNotFoundException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }


    }
    public static void startGame() throws FileNotFoundException, InterruptedException {
        File file = new File(PLAYS_FILE);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            wait(3);
            System.out.println(turnament.simulate(scanner.nextLine()+"\n"));
        }
        }
    public static void printResult(){
        String result = turnament.getTeam("GRYFFINDOR") + "\nscore: "  + turnament.getScore(turnament.getTeam("GRYFFINDOR")) + "\n\n\n"
                + turnament.getTeam("SLYTHERIN") + "\nscore: " +  turnament.getScore(turnament.getTeam("SLYTHERIN")) + "\n\n\n";
        if(turnament.getScore(turnament.getTeam("SLYTHERIN")) > turnament.getScore(turnament.getTeam("GRYFFINDOR")))
        {
           System.out.println(result + turnament.getTeam("SLYTHERIN").getHouse() + " WINS!!!");
        } else if (turnament.getScore(turnament.getTeam("SLYTHERIN")) < turnament.getScore(turnament.getTeam("GRYFFINDOR"))) {
            System.out.println(result + turnament.getTeam("GRYFFINDOR").getHouse() + " WINS!!!");
        }else {
            System.out.println(result + " ITS A TIE!!!!");
        }
    }
    public static String[][] getData() throws FileNotFoundException{
        File file = new File(TEAMS_FILE);
        Scanner scanner = new Scanner(file);
        String[] lines = {scanner.nextLine(),scanner.nextLine()};
        return new String[][]{lines[0].split(","), lines[1].split(",")};
    }
    public static void wait(int seconds) throws InterruptedException {
        TimeUnit time = TimeUnit.SECONDS;
        time.sleep(seconds);
    }
}
