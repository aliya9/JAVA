package TAFL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TAFLMatch {

    private TAFLTeam homeTeam;
    private TAFLTeam awayTeam;
    private int homeGoals;
    private int homeBehinds;
    private int awayGoals;
    private int awayBehinds;

    public TAFLMatch(TAFLTeam homeTeam, TAFLTeam awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void loadLineup(String homeLineupFile, String awayLineupFile) throws FileNotFoundException {
        homeTeam.setLineup(loadLineupFromFile(homeLineupFile, true));
        awayTeam.setLineup(loadLineupFromFile(awayLineupFile, false));
    }

    private TAFLPlayer[] loadLineupFromFile(String filename,boolean isHomeTeam) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        
        
        String teamName = scanner.nextLine().trim();
        String coachName = scanner.nextLine().trim();
        String coachFirstName = coachName.split(" ")[0];
        String coachLastName = coachName.split(" ")[1];

        if(isHomeTeam){
            this.homeTeam.setName(teamName);
            this.homeTeam.setCoach(new TAFLTeamMember(coachFirstName, coachLastName, "COACH"));
        }else{
            this.awayTeam.setName(teamName);
            this.awayTeam.setCoach(new TAFLTeamMember(coachFirstName, coachLastName, "COACH"));
        }
        
        
        TAFLPlayer[] lineup = new TAFLPlayer[22];
        int i = 0;
        int playerCount = 0;

        while(scanner.hasNextLine()){

            String line = scanner.nextLine().trim();

            
            
            if (line.isEmpty()) {
                continue;
            }
            String[] fields = line.split(",");
            String position = fields[2].trim();

            String firstName = fields[1].trim().split(" ")[0];
            String lastName = fields[1].trim().split(" ")[1];
            int number = Integer.parseInt(fields[0].trim());
            boolean isCaptain = false;
            if(fields.length >= 5){
                isCaptain = Boolean.parseBoolean(fields[4]);
            }
            lineup[i++] = new TAFLPlayer(firstName, lastName, position, number, isCaptain);
            playerCount++;
        }
        scanner.close();

        if(playerCount != 22){
            System.err.println("Error: The lineup has less than 22 players.");
            System.exit(1);
        }
        return lineup;
    }

    public void addHomeGoal() {
        homeGoals++;
    }

    public void addHomeBehind() {
        homeBehinds++;
    }

    public void addAwayGoal() {
        awayGoals++;
    }

    public void addAwayBehind() {
        awayBehinds++;
    }

    public int getHomeScore() {
        return homeGoals * 6 + homeBehinds;
    }

    public int getAwayScore() {
        return awayGoals * 6 + awayBehinds;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java AFLMatch <home lineup file> <away lineup file>");
            System.exit(1);
        }

        String homeLineupFile = args[0];
        String awayLineupFile = args[1];

        TAFLTeam homeTeam = new TAFLTeam("Home Team", new TAFLTeamMember("", "", "COACH"), new TAFLPlayer[22]);
        TAFLTeam awayTeam = new TAFLTeam("Away Team", new TAFLTeamMember("", "", "COACH"), new TAFLPlayer[22]);
        TAFLMatch match = new TAFLMatch(homeTeam, awayTeam);

        try {
            match.loadLineup(homeLineupFile, awayLineupFile);
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        System.out.println(match.getHomeTeam());
        System.out.println(match.getAwayTeam());

        int hs = 0;
        int as = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Which team scored? (h)ome/(a)way/(f)ull time: ");
            String team = scanner.next();
            if (team.equals("f")) {
                System.out.println("FULL TIME");
                System.out.println("Home score: " + match.getHomeScore());
                System.out.println("Away score: " + match.getAwayScore());
                break;
            } else if (!team.equals("h") && !team.equals("a")) {
                System.out.println("Invalid input.");
                continue;
            }
            System.out.print("Goal or behind? (g)oal/(b)ehind: ");
            String scoreType = scanner.next();
            if (!scoreType.equals("g") && !scoreType.equals("b")) {
                System.out.println("Invalid input.");
                continue;
            }
            if (team.equals("h") && scoreType.equals("g")) {
                match.addHomeGoal();
            } else if (team.equals("h") && scoreType.equals("b")) {
                match.addHomeBehind();
            } else if (team.equals("a") && scoreType.equals("g")) {
                match.addAwayGoal();
            } else if (team.equals("a") && scoreType.equals("b")) {
                match.addAwayBehind();
            }
            hs = match.getHomeScore();
            as = match.getAwayScore();
            
            System.out.println("The curent score is " + match.homeGoals + "." + match.homeBehinds + " (" + match.getHomeScore() + ") " + " to " + match.awayGoals + "." + match.awayBehinds + " (" + match.getAwayScore() + ") "  );
        

          
            
        }
        if (hs > as){
              
            System.out.println("Hometeam won!");
        }
        else if ( hs == as){
            System.out.println("Match Draw!");
        }
        else
        {
            System.out.println("Awayteam won!");
        }

    }

    public TAFLTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TAFLTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TAFLTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TAFLTeam awayTeam) {
        this.awayTeam = awayTeam;
    }
}
