package TAFL;

public class TAFLPlayer extends TAFLTeamMember {

    private int number;
    private boolean isCaptain;

    public TAFLPlayer(String firstName, String lastName, String position, int number, boolean isCaptain) {
        super(firstName, lastName, position);
        setNumber(number);
        this.isCaptain = isCaptain;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        } else {
            System.out.println("Invalid number: " + number);
            System.exit(1);
        }
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public String toString() {
        String result = "[" + number + "] " + getFirstName() + " " + getLastName() + "," + getPosition();
        if (isCaptain) {
            result += " (c)";
        }
        return result;
    }

    // public static void main(String[] args) {
    //     AFLTeamMember player1 = new AFLPlayer("Tom", "Mitchell", "C", 3, true);
    //     AFLTeamMember player2 = new AFLPlayer("Dylan", "Grimes", "HB", 2, false);
    //     AFLTeamMember coach = new AFLTeamMember("Damien", "Hardwick", "COACH");

    //     System.out.println(player1);
    //     System.out.println(player2);
    //     System.out.println(coach);
    // }
}
