import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.lang.*;

public class Hangman {

    public static char[] letters;
    public static String[] gallows = {"+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public static String tryNewWord(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please type word you'd like for a password in next game");
        String userPassword = scanner.nextLine();
        return userPassword;
    }
    public static String whichPassword(){
        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option");
        System.out.println("1.Play with random password");
        System.out.println("2.Play with your password");
        String password = "";
        int choose = scanner.nextInt();
        while (shouldContinue) {
            switch (choose) {
                case 1:
                    password = randomPassword(); shouldContinue= false; break;
                case 2:
                    password = tryNewWord(); shouldContinue=false; break;
                default:
                    System.out.println("you have to type 1 or 2 to choose a option"); break;
            }
        }
        return password;
    }
    public static String randomPassword(){
        int numPassword =(int) Math.random()+1*57;
        return words[numPassword];
    }
    public static char[] placePassword(String stringPassword){
        char[] tablePassword = new char[stringPassword.length()];
        for(int i = 0; i < stringPassword.length();i++)
        {
            tablePassword =  stringPassword.toCharArray();
        }    return tablePassword;
    }
    public static int isThereALetter(char letter, char[] password , char[] passwordToFill, int guess) {
        int countLetter = 0;
        int noLetter = 0;
        for(int i=0; i < password.length;i++)
        {
            if(Objects.equals(password[i], letter))
            {
                passwordToFill[i] = letter;
                countLetter++;
            } else {
                noLetter++;
            }
        }
        if(noLetter == password.length)
        {
            System.out.println("there's no " + letter + " in a password");
            guess++;
        }else {
            System.out.println("there's " + countLetter + " of " + letter);
        }
        return guess;}
    public static char tryToGuess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your guess?");
        char letter = scanner.nextLine().charAt(0);
        return letter;
    }
    public static void printHangman(char[] passwordToFill, int guess){
        System.out.println(gallows[guess]);
        System.out.println(passwordToFill);
        System.out.println("number of guess: " + guess);
    }

    public static boolean winOrLose(char[] passwordToFill, int guess, char[] passwordTable){
        boolean stopOrNot;
        if(Arrays.equals(passwordToFill,passwordTable))
        {
            System.out.println("Congratulations you win");
            stopOrNot = false;
        }else if (guess == 6) {
            System.out.println("You're hanging already X|");
            System.out.println("Good luck next time");
            stopOrNot = false;
        }else {
            System.out.println("Take another Guess");
            stopOrNot = true;
        }
        return stopOrNot;
    }
    public static void playHangman(){
        boolean shouldContinue = true;
        int guess = 0;
        char[] passwordTable = placePassword(whichPassword());
        char[] passwordToFill = new char[passwordTable.length];
        Arrays.fill(passwordToFill, '_');
        while(shouldContinue)
        {
            printHangman(passwordToFill, guess);
            guess = isThereALetter(tryToGuess(), passwordTable, passwordToFill, guess);
            shouldContinue = winOrLose(passwordToFill,guess,passwordTable);
        }

    }
    public static void main(String[] args) {
        playHangman();
    }
}
