import java.util.ArrayList;
import java.util.Scanner;

class Match{
     int score,fours,six,ball;
     float strike;
     void setMatch1(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("BALL FACED : ");
        ball=scanner.nextInt();
        System.out.print("RUNS : ");
        score=scanner.nextInt();
        System.out.print("FOURS(4'S) : ");
        fours=scanner.nextInt();
        System.out.print("SIX(6'S) : ");
        six=scanner.nextInt();
        strike=getStrike();
        System.out.println("***** DETAILS ADDED SUCCESSFULLY ******");
    }
     void showMatch(){
        System.out.println("BALL FACED  : "+ball);
        System.out.println("RUNS        : "+score);
        System.out.println("FOURS(4'S)  : "+fours);
        System.out.println("SIX(6'S)    : "+six);
        System.out.println("STRIKE RATE : "+strike);
    }
     float getStrike(){
        return (float) score /ball*100;
    }
}
class BatsMan{
    String name, batType;
    ArrayList<Match> matchDetails = new ArrayList<>();

    void setBatsMan(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n***** ENTER THE BATSMAN's DETAILS *****");
        System.out.print("NAME : ");
        this.name=scanner.nextLine();
        System.out.print("TYPE (RIGHT/LEFT): ");
        this.batType =scanner.nextLine();
        System.out.println("****** DETAILS ADDED SUCCESSFULLY ******");

    }
    void showBatsman(){
        System.out.println("NAME : "+name);
        System.out.println("TYPE : "+ batType);
        System.out.println("INNINGS : "+getInnings());
        System.out.println("TOTAL RUN : "+totalScore());
        System.out.println("AVERAGE STRIKE RATE : "+strikeRate());
    }
    void addMatch(){
        Match m = new Match();
        System.out.println("***** ENTER THE MATCH SUMMARY OF BATSMAN *****");
        m.setMatch1();
        matchDetails.add(m);
    }
    int totalScore(){
        int total=0;
        for(Match run:matchDetails){
            total+=run.score;
        }
        return total;
    }
    int totalBall(){
        int total=0;
        for(Match balls:matchDetails){
            total+=balls.ball;
        }
        return total;
    }
    float strikeRate(){
        return (float) totalScore()/totalBall()*100;
    }
    int getInnings(){
        int count=0;
        for(Match inn:matchDetails){
            count++;
        }
        return count;
    }
}

public class BatsManDetails {

    public static void main(String[] args) {
        ArrayList<BatsMan> player = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n******** MAIN MENU ********");
            System.out.println("1. ADD A NEW BATSMAN");
            System.out.println("2. ADD A NEW MATCH DETAILS");
            System.out.println("3. DISPLAY PROFILE OF A BATSMAN");
            System.out.println("4. DISPLAY PROFILE OF ALL BATSMAN");
            System.out.println("5. DISPLAY ALL MATCH HISTORY OF A BATSMAN");
            System.out.println("6. DELETE A BATSMAN");
            System.out.println("7. EXIT");
            System.out.print("ENTER YOUR CHOICE : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    BatsMan bm = new BatsMan();
                    bm.setBatsMan();
                    player.add(bm);
                }
                case 2 -> {
                    System.out.print("\nENTER THE BATSMAN NAME: ");
                    String name = scanner.nextLine();
                    int a = 0;
                    for (BatsMan i : player) {
                        if (i.name.equals(name)) {
                            i.addMatch();
                            a++;
                        }
                    }
                    if (a == 0)
                        System.out.println("\nBATSMAN IS NOT FOUND!!!");
                }
                case 3 -> {System.out.print("\nENTER THE BATSMAN NAME: ");
                    String name3 = scanner.nextLine();
                    int c = 0;
                    for (BatsMan i : player) {
                        if (i.name.equals(name3)) {
                            System.out.println("\n******* BATSMAN DETAILS *******");
                            i.showBatsman();
                        }
                        c++;
                    }
                    if (c == 0) {
                        System.out.println("\nBATSMAN NOT FOUND !!!");
                    }
                }
                case 4 -> {
                    if (player.isEmpty())
                        System.out.println("\nBATSMAN LOG IS EMPTY !!!");
                    for (BatsMan i : player) {
                        System.out.println("\n******* BATSMAN-" + (player.indexOf(i) + 1) + " *******");
                        i.showBatsman();
                    }
                }
                case 5 -> {System.out.print("\nENTER THE BATSMAN NAME: ");
                    String name2 = scanner.nextLine();
                    int b = 0;
                    for (BatsMan i : player) {
                        if (i.name.equals(name2)) {
                            for (Match j : i.matchDetails) {
                                System.out.println("\n******* MATCH-" + (i.matchDetails.indexOf(j) + 1) + " DETAILS *******");
                                j.showMatch();
                            }
                            b++;
                        }
                    }
                    if (b == 0)
                        System.out.println("\nBATSMAN IS NOT FOUND !!!");
                }
                case 6 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("\nENTER THE BATSMAN NAME: ");
                    String name4 = sc.nextLine();
                    int d = 0;
                    for (BatsMan i : player) {
                        if (i.name.equals(name4)) {
                            player.remove(i);
                            System.out.println("BATSMAN DELETED SUCCESSFULLY");
                            d++;
                            break;
                        }
                    }
                    if (d == 0) {
                        System.out.println("\nBATSMAN NOT FOUND !!!");
                    }
                }
                case 7 -> {
                    System.out.println("\nEXITING FROM BATSMAN'S DATABASE.");
                    Players.main(new String[]{});
                }
                default -> System.out.println("\nINVALID CHOICE !!! \nPLEASE TRY AGAIN. ");
            }
        }
    }
}

