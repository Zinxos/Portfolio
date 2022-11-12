import java.lang.Math;

public class DiceRoll {
    public static int diceRoll(){
        double roll = (Math.random() * 6)+1;
        return (int)roll;
    }
    public static void rollUntilDouble() {
        boolean shouldContinue = true;
        int roll1;
        int roll2;
        while (shouldContinue) {
            roll1 = diceRoll();
            roll2 = diceRoll();
            System.out.println("your roll : " + roll1);
            System.out.println("enemy roll : " + roll2);
            if (roll1 == roll2) {
                System.out.println("lucky hit!");
                shouldContinue = false;
            } else {
                System.out.println("no double, lets try again");
            }
        }
    }
    public static void main(String[] args) {
        rollUntilDouble();

    }

}