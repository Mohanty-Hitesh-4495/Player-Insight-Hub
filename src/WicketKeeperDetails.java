import java.util.ArrayList;
import java.util.Scanner;

class Match3 {
    int stump,Catch,wicket;
    void setMatch(){
        Scanner scanner=new Scanner(System.in);
        System.out.println(" ***** ENTER WICKET-KEEPER DETAILS *****");
        System.out.println("STUMPING : ");
        stump= scanner.nextInt();
        System.out.println("CATCH : ");
        Catch= scanner.nextInt();
        setWicket();
        System.out.println("***** DETAILS ADDED SUCCESSFULLY *****");
    }
    void getMatch(){
        System.out.println("WICKETS : "+wicket);
        System.out.println("STUMPING : "+stump);
        System.out.println("CATCH : "+Catch);
    }
    void setWicket(){
        wicket=Catch+stump;
    }
}
class WicketKeeper {
    String  name;
    ArrayList<Match3> match3Details = new ArrayList<>();
    void setKeeper() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n***** ENTER THE WICKET-KEEPER DETAILS *****");
        System.out.print("NAME : ");
        name = scanner.nextLine();
        System.out.println("****** DETAILS ADDED SUCCESSFULLY *****");
    }
    void getKeeper() {
        System.out.println("NAME : "+name);
        System.out.println("INNINGS : " + getInnings());
        System.out.println("WICKETS : " + totalWicket());
        System.out.println("STUMPING : "+getStump());
        System.out.println("CATCH : "+getCatch());
    }
    void addMatch() {
        Match3 m = new Match3();
        System.out.println("***** ENTER THE MATCH DETAILS *****");
        m.setMatch();
        match3Details.add(m);
    }
    int totalWicket() {
        int total = 0;
        for (Match3 wckt : match3Details) {
            total += wckt.wicket;
        }
        return total;
    }
    int getInnings() {
        int count = 0;
        for (Match3 inn : match3Details) {
            count++;
        }
        return count;
    }
    int getStump(){
        int count=0;
        for(Match3 stp: match3Details){
            count+= stp.stump;
        }
        return count;
    }
    int getCatch(){
        int count=0;
        for (Match3 cth: match3Details){
            count+= cth.Catch;
        }
        return count;
    }
}
public class WicketKeeperDetails {
    public static void main(String[] args) {
        ArrayList<WicketKeeper> player = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n******** MAIN MENU ********");
            System.out.println("1. ADD A NEW WICKET-KEEPER");
            System.out.println("2. ADD A NEW MATCH DETAILS");
            System.out.println("3. SEARCH PROFILE OF A WICKET-KEEPER");
            System.out.println("4. DISPLAY PROFILE OF ALL WICKET-KEEPERS");
            System.out.println("5. DISPLAY ALL MATCH HISTORY OF A WICKET-KEEPER");
            System.out.println("6. DELETE A WICKET-KEEPER");
            System.out.println("7. EXIT");
            System.out.print("\nENTER YOUR CHOICE : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    WicketKeeper bm = new WicketKeeper();
                    bm.setKeeper();
                    player.add(bm);
                }
                case 2 -> {
                    System.out.print("\nENTER THE ALL-ROUNDER'S NAME: ");
                    String name = scanner.nextLine();
                    int a = 0;
                    for (WicketKeeper i : player) {
                        if (i.name.equals(name)) {
                            i.addMatch();
                            a++;
                        }
                    }
                    if (a == 0)
                        System.out.println("\nWICKET-KEEPER IS NOT FOUND!!!");
                }
                case 3 -> {
                    if (player.isEmpty())
                        System.out.println("\nWICKET-KEEPER LOG IS EMPTY !!!");
                    for (WicketKeeper i : player) {
                        System.out.println("\n******* WICKET-KEEPER " + (player.indexOf(i) + 1) + "*******");
                        i.getKeeper();
                    }
                }
                case 4 -> {
                    System.out.print("\nENTER THE WICKET-KEEPER'S NAME: ");
                    String name2 = scanner.nextLine();
                    int b = 0;
                    for (WicketKeeper i : player) {
                        if (i.name.equals(name2)) {
                            for (Match3 j : i.match3Details) {
                                System.out.println("\n******* MATCH " + (i.match3Details.indexOf(j) + 1) + " DETAILS *******");
                                j.getMatch();
                            }
                            b++;
                        }
                    }
                    if (b == 0)
                        System.out.println("\nWICKET-KEEPER IS NOT FOUND !!!");
                }
                case 5 -> {
                    System.out.print("\nENTER THE WICKET-KEEPER'S NAME: ");
                    String name3 = scanner.nextLine();
                    int c = 0;
                    for (WicketKeeper i : player) {
                        if (i.name.equals(name3)) {
                            System.out.println("\n******* WICKET-KEEPER'S DETAILS *******");
                            i.getKeeper();
                        }
                        c++;
                    }
                    if (c == 0) {
                        System.out.println("\nWICKET-KEEPER NOT FOUND !!!");
                    }
                }
                case 6 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("\nENTER THE WICKET-KEEPER'S NAME: ");
                    String name4 = sc.nextLine();
                    int d = 0;
                    for (WicketKeeper i : player) {
                        if (i.name.equals(name4)) {
                            player.remove(player.indexOf(i));
                        }
                        d++;
                    }
                    if (d == 0) {
                        System.out.println("\nWICKET-KEEPER NOT FOUND !!!");
                    }
                }
                case 7 -> {
                    System.out.println("\nEXITING FROM WICKET-KEEPER'S DATABASE.");
                    Players.main(new String[]{});
                }
                default -> System.out.println("\nINVALID CHOICE !!! \nPLEASE TRY AGAIN. ");
            }
        }
    }
}

