import java.util.Scanner;

public class TicTackToe {
    public  static void ticAndToe(int turn, String[][] board){
        boolean shouldContinue = true;
        printBoard(board);
        while(shouldContinue)
        {
            System.out.println("turn " + turn);
            board = makeMove(board, turn);
            printBoard(board);
            if(turn>4)
            {
                shouldContinue = checkWin(board, turn);
            }
            if(turn == 9)
            {
                shouldContinue = false;
                System.out.println("theres no winner, lets play again");
            }
            turn++;
        }
    }
    public static boolean checkWin(String[][] table, int turn){
        if(table[1][1].equals(table[1][2]) && table[1][1].equals(table[1][0]) && !table[1][0].equals("_"))
        {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        } else if (table[2][1].equals(table[2][2]) && table[2][1].equals(table[2][0]) && !table[2][0].equals("_")) {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        }else if (table[0][1].equals(table[0][2]) && table[0][1].equals(table[0][0]) && !table[0][0].equals("_"))
        {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        }else if(table[1][0].equals(table[2][0]) && table[0][0].equals(table[1][0]) && !table[1][0].equals("_"))
        {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        }else if(table[1][1].equals(table[2][1]) && table[0][1].equals(table[1][1]) && !table[1][1].equals("_"))
        {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        }else if(table[1][2].equals(table[2][2]) && table[0][2].equals(table[1][2]) && !table[1][2].equals("_"))
        {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        }else if(table[1][1].equals(table[2][2]) && table[1][1].equals(table[0][0]) && !table[0][0].equals("_"))
        {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        }else if(table[1][1].equals(table[0][2]) && table[1][1].equals(table[2][0]) && !table[2][0].equals("_"))
        {
            if(turn%2 == 0)
            {
                System.out.println("X wins");return(false);
            }else {
                System.out.println("o wins");return(false);
            }
        }else
        {
            if(turn%2 == 0)
            {
                System.out.println("turn of O");return(true);
            }else {
                System.out.println("turn of X");return(true);
            }
        }

    }

    public static String [][] makeMove(String[][] table, int turn){
        Scanner scanner = new Scanner(System.in);
        System.out.println("take your move (to choose positon just pick a number usunig num keys)");
        boolean shouldContinue = true;
        int choose;
        while(shouldContinue) {
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    if (table[0][0].equals("_")) {
                        if (turn % 2 == 0) {
                            table[0][0] = "x";
                            shouldContinue = false;
                        } else {
                            table[0][0] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 2:
                    if (table[0][1].equals("_")) {
                        if (turn % 2 == 0) {
                            table[0][1] = "x";
                            shouldContinue = false;
                        } else {
                            table[0][1] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 3:
                    if (table[0][2].equals("_")) {
                        if (turn % 2 == 0) {
                            table[0][2] = "x";
                            shouldContinue = false;
                        } else {
                            table[0][2] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 4:
                    if (table[1][0].equals("_")) {
                        if (turn % 2 == 0) {
                            table[1][0] = "x";
                            shouldContinue = false;
                        } else {
                            table[1][0] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 5:
                    if (table[1][1].equals("_")) {
                        if (turn % 2 == 0) {
                            table[1][1] = "x";
                            shouldContinue = false;
                        } else {
                            table[1][1] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 6:
                    if (table[1][2].equals("_")) {
                        if (turn % 2 == 0) {
                            table[1][2] = "x";
                            shouldContinue = false;
                        } else {
                            table[1][2] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 7:
                    if (table[2][0].equals("_")) {
                        if (turn % 2 == 0) {
                            table[2][0] = "x";
                            shouldContinue = false;
                        } else {
                            table[2][0] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 8:
                    if (table[2][1].equals("_")) {
                        if (turn % 2 == 0) {
                            table[2][1] = "x";
                            shouldContinue = false;
                        } else {
                            table[2][1] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
                case 9:
                    if (table[2][2].equals("_")) {
                        if (turn % 2 == 0) {
                            table[2][2] = "x";
                            shouldContinue = false;
                        } else {
                            table[2][2] = "o";
                        } shouldContinue = false;
                    } else {
                        System.out.println("spot taken, pick another one");
                    }
                {

                }
                break;
            }
        }
        return table;
    }
    public static void printBoard(String [][] table)
    {
        String[] line = new String[3];
        for(int i = 0; i < 3;i++)
        {

            for(int j = 0; j < 3;j++)
            {

                if(table[i][j].equals("_"))
                {
                    line[j] = "_";
                }else if (table[i][j].equals("x"))
                {
                    line[j] = "x";

                }else
                {
                    line[j] = "o";

                }
            }
            System.out.println( line[0] + "  " +line[1] + "  " +line[2] );

        }
    }

    public static void main(String[] args) {
        int turn = 1;
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = "_";
            }
        }
        ticAndToe(turn, board);

    }

}
