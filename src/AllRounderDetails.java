import java.util.ArrayList;
import java.util.Scanner;

class Match2 {
    int maiden, wickets, balls,runs;// BOWLING
    float eco,over;// BOWLING
    int score, fours, six, ball;// BATTING
    float strike;// BATTING
    void setMatch(){
        Scanner scanner=new Scanner(System.in);
        System.out.println(" ***** ENTER BATTING DETAILS *****");
        System.out.print("BALL FACED : ");
        ball=scanner.nextInt();
        System.out.print("RUNS : ");
        this.score=scanner.nextInt();
        System.out.print("FOURS(4'S) : ");
        this.fours=scanner.nextInt();
        System.out.print("SIX(6'S) : ");
        this.six=scanner.nextInt();
        this.strike=getStrike();
        System.out.println(" ***** ENTER BOWLING DETAILS *****");
        System.out.print("BALLS : ");this.balls =scanner.nextInt();
        System.out.print("RUNS : ");this.runs = scanner.nextInt();
        System.out.print("MAIDENS : ");this.maiden =scanner.nextInt();
        System.out.print("WICKETS : ");this.wickets =scanner.nextInt();
        this.eco = getEco();
        this.over=getOver();
        System.out.println("***** DETAILS ADDED SUCCESSFULLY *****");
    }
    void getMatch(){
        System.out.println("***** BATTING *****");
        System.out.println("BALL FACED : "+ball);
        System.out.println("RUNS : "+score);
        System.out.println("FOURS(4'S) : "+fours);
        System.out.println("SIX(6'S) : "+six);
        System.out.println("STRIKE RATE : "+strike);
        System.out.println("***** BOWLING *****");
        System.out.println("OVERS : "+ over);
        System.out.println("BALLS : "+ balls);
        System.out.println("RUNS : "+ runs);
        System.out.println("WICKETS : "+ wickets);
        System.out.println("MAIDEN : "+ maiden);
        System.out.println("ECONOMY : "+ eco);
    }
    float getEco() { // return the Economy of a bowler in a match
        return (float) runs /balls ;
    }
    float getStrike() { // return the strike rate of a batsman in a match
        return (float) score /ball*100;
    }
    float getOver() { // return the over count of a bowler in match
        return (float) balls /6;
    }
}
class AllRounder {
    String name,bowlType,batType;
    ArrayList<Match2> match2Details = new ArrayList<>();
    void setAllRounder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n***** ENTER THE ALL-ROUNDER'S DETAILS *****");
        System.out.print("NAME : ");
        this.name = scanner.nextLine();
        System.out.print("BATTING TYPE (RIGHT/LEFT): ");
        this.batType = scanner.nextLine();
        System.out.print("BOWLING TYPE (FAST/SPIN): ");
        this.bowlType= scanner.nextLine();
        System.out.println("****** DETAILS ADDED SUCCESSFULLY *****");

    }

    void getAllRounder() {
        System.out.println("NAME : " + name);
        System.out.println("INNINGS : " + getInnings());
        System.out.println("BATTING TYPE : " + batType);
        System.out.println("TOTAL RUN : "+totalScore());
        System.out.println("AVERAGE STRIKE RATE : "+strikeRate());
        System.out.println("BOWLING TYPE : " + bowlType);
        System.out.println("WICKETS : " + totalWicket());
        System.out.println("ECONOMY : " + getEco());
    }
    float strikeRate(){ // return the average strike rate of batsman throughout his carrier
        return (float) totalScore()/totalBall()*100;
    }
    int totalScore(){ // return the total run scored by a batsman throughout his carrier
        int total=0;
        for(Match2 run:match2Details){
            total+=run.score;
        }
        return total;
    }
    int totalBall(){// return the total balls played by batsman throughout hie carrier
        int total=0;
        for(Match2 balls:match2Details){
            total+=balls.ball;
        }
        return total;
    }
    void addMatch() {// add match count and details into the match2Details arraylist
        Match2 m = new Match2();
        m.setMatch();
        match2Details.add(m);
    }

    int totalWicket() {// return total wicket count taken by the bowler throughout its carrier
        int total = 0;
        for (Match2 wckt : match2Details) {
            total += wckt.wickets;
        }
        return total;
    }

    int totalBalls() {// return total balls bowled by the bowler
        int total = 0;
        for (Match2 ball : match2Details) {
            total += ball.balls;
        }
        return total;
    }

    int totalRun() {// return total run given by the bowler
        int total = 0;
        for (Match2 run : match2Details) {
            total += run.runs;
        }
        return total;
    }

    float getEco() {// returns the average economy of a bowler
        return (float) totalRun() / totalBalls();
    }

    int getInnings() {// count total matches played by a player
        int count = 0;
        for (Match2 inn : match2Details) {
            count++;
        }
        return count;
    }
}

public class AllRounderDetails {
    public static void main(String[] args) {
        ArrayList<AllRounder> player = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n******** MAIN MENU ********");
            System.out.println("1. ADD A NEW ALL-ROUNDER");
            System.out.println("2. ADD A NEW MATCH DETAILS");
            System.out.println("3. SEARCH PROFILE OF A ALL-ROUNDER");
            System.out.println("4. DISPLAY PROFILE OF ALL ALL-ROUNDER");
            System.out.println("5. DISPLAY ALL MATCH HISTORY OF A ALL-ROUNDER");
            System.out.println("6. DELETE A ALL-ROUNDER");
            System.out.println("7. EXIT");
            System.out.print("\nENTER YOUR CHOICE : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    AllRounder bm = new AllRounder();
                    bm.setAllRounder();
                    player.add(bm);
                }
                case 2 -> {
                    System.out.print("\nENTER THE ALL-ROUNDER'S NAME: ");
                    String name = scanner.nextLine();
                    int a = 0;
                    for (AllRounder i : player) {
                        if (i.name.equals(name)) {
                            i.addMatch();
                            a++;
                        }
                    }
                    if (a == 0)
                        System.out.println("\nALL-ROUNDER IS NOT FOUND!!!");
                }
                case 3 -> {
                    System.out.print("\nENTER THE ALL-ROUNDER'S NAME: ");
                    String name3 = scanner.nextLine();
                    int c = 0;
                    for (AllRounder i : player) {
                        if (i.name.equals(name3)) {
                            System.out.println("\n******* ALL-ROUNDER'S DETAILS *******");
                            i.getAllRounder();
                        }
                        c++;
                    }
                    if (c == 0) {
                        System.out.println("\nALL-ROUNDER NOT FOUND !!!");
                    }
                }
                case 4 -> {
                    if (player.isEmpty())
                        System.out.println("\nALL-ROUNDER LOG IS EMPTY !!!");
                    for (AllRounder i : player) {
                        System.out.println("\n******* ALL-ROUNDER-" + (player.indexOf(i) + 1) + " *******");
                        i.getAllRounder();
                    }
                }
                case 5 -> {
                    System.out.print("\nENTER THE ALL-ROUNDER'S NAME: ");
                    String name2 = scanner.nextLine();
                    int b = 0;
                    for (AllRounder i : player) {
                        if (i.name.equals(name2)) {
                            for (Match2 j : i.match2Details) {
                                System.out.println("\n******* MATCH-" + (i.match2Details.indexOf(j) + 1) + " DETAILS *******");
                                j.getMatch();
                            }
                            b++;
                        }
                    }
                    if (b == 0)
                        System.out.println("\nALL-ROUNDER IS NOT FOUND !!!");
                }
                case 6 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("\nENTER THE ALL-ROUNDER'S NAME: ");
                    String name4 = sc.nextLine();
                    int d = 0;
                    for (AllRounder i : player) {
                        if (i.name.equals(name4)) {
                            player.remove(player.indexOf(i));
                        }
                        d++;
                    }
                    if (d == 0) {
                        System.out.println("\nALL-ROUNDER NOT FOUND !!!");
                    }
                }
                case 7 -> {
                    System.out.println("\nEXITING FROM ALL-ROUNDER'S DATABASE.");
                    Players.main(new String[]{});
                }
                default -> System.out.println("\nINVALID CHOICE !!! \nPLEASE TRY AGAIN. ");
            }
        }
    }
}
