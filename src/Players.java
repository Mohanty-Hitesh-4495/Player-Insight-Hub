import java.util.Scanner;

public class Players {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("\n******* PLAYERS MENU ********");
            System.out.println("1. BATSMAN'S DETAILS");
            System.out.println("2. BOWLER'S DETAILS");
            System.out.println("3. ALL ROUNDER'S DETAILS");
            System.out.println("4. WICKETKEEPER'S DETAILS");
            System.out.println("5. EXIT");
            System.out.print("\nENTER YOUR CHOICE: ");
            int choice =sc.nextInt();
            switch (choice) {
                case 1 -> { BatsManDetails.main(new String[]{});}
                case 2 -> { BowlerDetails.main(new String[]{});}
                case 3 -> { AllRounderDetails.main(new String[]{});}
                case 4 -> { WicketKeeperDetails.main(new String[]{});}
                case 5 -> { System.out.println("\nEXITING FROM PLAYER'S DATABASE.");
                    System.exit(0);
                }
                default -> System.out.println("\nINVALID CHOICE !!! \nPLEASE TRY AGAIN. ");
            }
        }
    }
}
