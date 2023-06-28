import java.util.*;

public class abc 
{
    public static void main(String args[])

    {
        
        Scanner x = new Scanner(System.in);
        
        int goal_score1 = 0;
        int behind_score1 = 0;
        int current_score1 = 0;
        int goal_score1points = 0;

        int goal_score2 = 0;
        int behind_score2 = 0;
        int current_score2 = 0;
        int goal_score2points = 0;

        String team_index;

        

        while(true)
        {
            System.out.println("Which team scored? ");
            team_index = x.nextLine(); 

            if (team_index.equals("h"))
            {
                System.out.println("Goal or behind? ");
                String goal_index = x.next();
                
                if (goal_index.equals("b"))
                {
                    behind_score1 = behind_score1 + 1;

                }
                else if (goal_index.equals("g"))
                {
                    goal_score1 = goal_score1 + 1;
                    goal_score1points = goal_score1 * 6;
                }
                else
                {
                    System.out.println("Incorret input!");
                    continue;
                }

            current_score1 = behind_score1 + goal_score1points;
            }
            else if (team_index.equals("a"))
            {
                System.out.println("Goal or behind? ");
                String goal_index = x.next();
                if (goal_index.equals("b"))
                {
                    behind_score2 = behind_score2 + 1;
            
                }
                else if (goal_index.equals("g"))
                {
                    goal_score2 = goal_score2 + 1;
                    goal_score2points = goal_score2 * 6;
                }
                else
                {
                    System.out.println("Incorret input!");
                    continue;
                }

            current_score2 = behind_score2 + goal_score2points;
            }
       
            else if(team_index.equals("f"))
            {
            break;
            }
        else
        {
            System.out.println("Incorret input!");
            continue;
            
        }

        x.nextLine();

        System.out.println("The curent score is " + goal_score1 + "." + behind_score1 + " (" + current_score1 + ") " + " to " + goal_score2 + "." + behind_score2 + " (" + current_score2 + ") "  );
        }
    
    }
    
}
