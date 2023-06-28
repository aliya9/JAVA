package TAFL;

public class TAFLTeam {

    private String name;
    private TAFLTeamMember coach;
    private TAFLPlayer[] lineup = new TAFLPlayer[22];

    public TAFLTeam(String name, TAFLTeamMember coach, TAFLPlayer[] lineup) {
        this.name = name;
        this.coach = coach;
        this.lineup = lineup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TAFLTeamMember getCoach() {
        return coach;
    }

    public void setCoach(TAFLTeamMember coach) {
        this.coach = coach;
    }

    public TAFLPlayer[] getLineup() {
        return lineup;
    }

    public void setLineup(TAFLPlayer[] lineup) {
        this.lineup = lineup;
    }

    public String toString() {
        return "";
        
        
    }
}
