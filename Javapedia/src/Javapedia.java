import java.util.Scanner;
import java.util.Arrays;
public class Javapedia {

    public static String[][] howManyCharacter()
    {
        Scanner scanner = new Scanner(System.in);
        int howMany = scanner.nextInt();
        String[][] javapedia = new String[howMany][3];
        return(javapedia);
    }
    public static String[][] newData(String[][] table)

    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < table.length; i++) {
            if(i==0)
            {
                System.out.println("please fill the informations to register character");
            }else {
                System.out.println("please fill informations about next character");
            }
            System.out.println("name: ");
            table[i][0] = scanner.next();
            System.out.println("date of birth: ");
            table[i][1] = scanner.next();
            System.out.println("occupation: ");
            table[i][2] = scanner.next();
        }
        return(table);
    }
    public static void readTable (String[][] table)
    {
        for(int i = 0; i< table.length;i++)
        {
            System.out.println("");
            for (int j = 0; j < 3;j++)
            {
                switch(j)
                {
                    case 0: System.out.println("name: " + table[i][j]); break;
                    case 1: System.out.println("date of birth: " + table[i][j]);break;
                    case 2: System.out.println("occupation: " + table[i][j]);break;
                }
            }
        }
    }
    public static void serchByName(String[][] table)
    {System.out.println("Would you like to serch some character by name? (anwser y/n)");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        System.out.println(choose);
        if(choose.equals("y"))
        {
            System.out.println("what name would you like to serch for?");
            String name = scanner.nextLine();
            for(int i = 0; i< table.length;i++)
            { if (name.equals(table[i][0]))
            {
                for (int j = 0; j < 3;j++)
                {
                    switch(j)
                    {
                        case 0: System.out.println("name: " + table[i][j]); break;
                        case 1: System.out.println("date of birth: " + table[i][j]);break;
                        case 2: System.out.println("occupation: " + table[i][j]);break;
                    }
                }break;
            }else if (i == table.length-1) {
                System.out.println("name not found");
            }

            }
        }

    }

    public static void main(String[] args) {

        System.out.println("how many historical character you want to register?");
        String[][] javapedia = newData(howManyCharacter());
        readTable(javapedia);
        serchByName(javapedia);

    }
}
