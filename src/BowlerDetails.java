import java.util.ArrayList;
import java.util.Scanner;

class Match1 {
     int maiden, wickets, balls,runs;// BOWLING
     float eco,over;// BOWLING
     void setMatch(){
        Scanner scanner=new Scanner(System.in);
        System.out.println(" ***** ENTER BOWLING DETAILS *****");
        System.out.print("BALLS : ");balls =scanner.nextInt();
        System.out.print("RUNS : ");runs = scanner.nextInt();
        System.out.print("MAIDENS : ");maiden =scanner.nextInt();
        System.out.print("WICKETS : ");wickets =scanner.nextInt();
        eco = getEco();
        over=getOver();
        System.out.println("***** DETAILS ADDED SUCCESSFULLY *****");
    }
     float getOver(){
        return (float) balls /6;
    }
     void showMatch(){
        System.out.println("OVERS   : "+ over);
        System.out.println("BALLS   : "+ balls);
        System.out.println("RUNS    : "+ runs);
        System.out.println("WICKETS : "+ wickets);
        System.out.println("MAIDEN  : "+ maiden);
        System.out.println("ECONOMY : "+ eco);
    }
     float getEco(){
        return (float) runs /balls ;
    }
}
class Bowler {
    String  name,bowlType;
    ArrayList<Match1> match1Details = new ArrayList<>();
    void setBowler() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n***** ENTER THE BOWLER'S DETAILS *****");
        System.out.print("NAME : ");
        name = scanner.nextLine();
        System.out.print("TYPE (FAST/SPIN): ");
        this.bowlType = scanner.nextLine();
        System.out.println("****** DETAILS ADDED SUCCESSFULLY *****");
    }
    void showBowler() {
        System.out.println("NAME    : "+name);
        System.out.println("TYPE    : " + bowlType);
        System.out.println("INNINGS : " + getInnings());
        System.out.println("WICKETS : " + totalWicket());
        System.out.println("ECONOMY : " + getEco());
    }
    void addMatch() {
        Match1 m = new Match1();
        System.out.println("***** ENTER THE MATCH DETAILS *****");
        m.setMatch();
        match1Details.add(m);
    }
    int totalWicket() {
        int total = 0;
        for (Match1 wckt : match1Details) {
            total += wckt.wickets;
        }
        return total;
    }
    int totalBall() {
        int total = 0;
        for (Match1 ball : match1Details) {
            total += ball.balls;
        }
        return total;
    }
    int totalRun() {
        int total = 0;
        for (Match1 run : match1Details) {
            total += run.runs;
        }
        return total;
    }
    float getEco() {
        return (float) totalRun() / totalBall();
    }
    int getInnings() {
        int count = 0;
        for (Match1 inn : match1Details) {
            count++;
        }
        return count;
    }
}
public class BowlerDetails {
    public static void main(String[] args) {
        ArrayList<Bowler> player = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n******** MAIN MENU ********");
            System.out.println("1. ADD A NEW BOWLER");
            System.out.println("2. ADD A NEW MATCH DETAILS");
            System.out.println("3. SEARCH PROFILE OF A BOWLER");
            System.out.println("4. DISPLAY PROFILE OF ALL BOWLERS");
            System.out.println("5. DISPLAY ALL MATCH HISTORY OF A BOWLER");
            System.out.println("6. DELETE A BOWLER");
            System.out.println("7. EXIT");
            System.out.print("\nENTER YOUR CHOICE : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Bowler bm = new Bowler();
                    bm.setBowler();
                    player.add(bm);
                }
                case 2 -> {
                    System.out.print("\nENTER THE BOWLER NAME: ");
                    String name = scanner.nextLine();
                    int a = 0;
                    for (Bowler i : player) {
                        if (i.name.equals(name)) {
                            i.addMatch();
                            a++;
                        }
                    }
                    if (a == 0)
                        System.out.println("\nBOWLER IS NOT FOUND!!!");
                }
                case 3 -> {
                    System.out.print("\nENTER THE BOWLER'S NAME: ");
                    String name3 = scanner.nextLine();
                    int c = 0;
                    for (Bowler i : player) {
                        if (i.name.equals(name3)) {
                            System.out.println("\n******* BOWLER'S DETAILS *******");
                            i.showBowler();
                        }
                        c++;
                    }
                    if (c == 0) {
                        System.out.println("\nBOWLER NOT FOUND !!!");
                    }
                }
                case 4 -> {
                    if (player.isEmpty())
                        System.out.println("\nBOWLER'S LOG IS EMPTY !!!");
                    for (Bowler i : player) {
                        System.out.println("\n******* BOWLER " + (player.indexOf(i) + 1) + " *******");
                        i.showBowler();
                    }
                }
                case 5 -> {
                    System.out.print("\nENTER THE BOWLER'S NAME: ");
                    String name2 = scanner.nextLine();
                    int b = 0;
                    for (Bowler i : player) {
                        if (i.name.equals(name2)) {
                            for (Match1 j : i.match1Details) {
                                System.out.println("\n******* MATCH " + (i.match1Details.indexOf(j) + 1) + " DETAILS *******");
                                j.showMatch();
                            }
                            b++;
                        }
                    }
                    if (b == 0)
                        System.out.println("\nBOWLER IS NOT FOUND !!!");
                }
                case 6 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("\nENTER THE BOWLER NAME: ");
                    String name4 = sc.nextLine();
                    int d = 0;
                    for (Bowler i : player) {
                        if (i.name.equals(name4)) {
                            player.remove(player.indexOf(i));
                        }
                        d++;
                    }
                    if (d == 0) {
                        System.out.println("\nBOWLER NOT FOUND !!!");
                    }
                }
                case 7 -> {
                    System.out.println("\nEXITING FROM BOWLER'S DATABASE.");
                    Players.main(new String[]{});
                }
                default -> System.out.println("\nINVALID CHOICE !!! \nPLEASE TRY AGAIN. ");
            }
        }
    }
}
