package TicTacToe;

import java.util.Random;
import java.util.Scanner;

class TicTacToe
{
    static char[][] board; 

    public TicTacToe()
    {
        board = new char[3][3];
        initBoard();
    }

    void initBoard()
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                board[i][j]= ' ';
            }
        }
    }

    static void dispBoard()
    {
        System.out.println("-------------");
        for(int i=0; i<board.length; i++)
        {
            System.out.print("| ");
            for(int j=0; j<board[i].length; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        System.out.println("-------------");
        }
    }

    static void placeMark(int row, int col, char mark)
    {
        if(row >= 0 && row <= 2 && col >=0 && col <= 2)
        {
            board[row][col] = mark;
        }
        else 
        {
            System.out.println("Invalid Input");
        }
    }

    boolean checkColWin()
    {
        for(int j=0; j<=2; j++)
        {
            if(board[0][j] != ' ' && board[0][j] == board[1][j] &&
               board[1][j] == board[2][j])
               {
                    return true;
               }
        }
        return false;
    }

    
    boolean checkRowWin()
    {
        for(int i=0; i<=2; i++)
        {
            if(board[i][0] != ' ' && board[i][0] == board[i][1] &&
               board[i][1] == board[i][2])
               {
                    return true;
               }
        }
        return false;
    }

    
    boolean checkDiagWin()
    {
        if((board[0][0]!= ' ' && board[0][0] == board[1][1] &&
           board[1][1] == board[2][2]) ||
         (board[0][2] != ' ' && board[0][2] == board[1][1] &&
           board[1][1] == board[2][0]))
           {
                return true;
           }
        return false;
        
    }

    boolean checkDraw() 
    {
    for (int i = 0; i <= 2; i++) {
        for (int j = 0; j <= 2; j++) {
            if (board[i][j] == ' ') {
                return false;
            }
        }
    }
    return true;
}

}


abstract class User
{
    char mark; 
    String name;

    abstract void makeMove();

    
    boolean isValidMove(int row, int col)
    {
        if(row >= 0 && row <= 2 &&
           col >= 0 && col <= 2)
           {
                if(TicTacToe.board[row][col] == ' ')
                {
                    return false;
                }
           }
           return true;
    }
}


class HumanUser extends User
{
    
    HumanUser(String name, char mark)
    {
        this.name = name; 
        this.mark = mark;
    }

    void makeMove()
    {
        Scanner s = new Scanner(System.in);

        int row; 
        int col; 

        do
        {
            System.out.println("Enter the row and col");
            row = s.nextInt();
            col = s.nextInt();
        }while (isValidMove(row, col));
        
        
        TicTacToe.placeMark(row, col, mark);
    }

}


class AIUser extends User
{
    
    AIUser(String name, char mark)
    {
        this.name = name; 
        this.mark = mark;
    }

    void makeMove()
    {
        Scanner s = new Scanner(System.in);

        int row; 
        int col; 

        do
        {
            Random r = new Random();
            row = r.nextInt(3);
            col = r.nextInt(3);
        }while (isValidMove(row, col));
        
        
        TicTacToe.placeMark(row, col, mark);
    }

}





public class LaunchGame {

    public static void main(String[] args) 
    {
        
        TicTacToe t = new TicTacToe();
        HumanUser player1 = new HumanUser("Bob", 'X');
        AIUser player2 = new AIUser("AlexBot", 'O');

        User cp;
        cp = player1; 

        while (true) 
        {
            
            System.out.println(cp.name + "'s turn.");
            cp.makeMove();

            TicTacToe.dispBoard();
            if(t.checkColWin() || t.checkRowWin() || t.checkDiagWin())
            {
                System.out.println(cp.name + " has won!");
                break;
            }
            else if(t.checkDraw())
            {
                System.out.println("Game Draw!");
            }
            else
            {
                if(cp == player1)
                {
                    cp = player2;
                }
                else 
                {
                    cp = player1;
                }
            }
        }
    }
    
}



