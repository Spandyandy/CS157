// 
//
// 
import java.util.Scanner;
import java.util.Random;
public class TicTacToe 
{
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args)
  {
    final int SIZE = 3;
    char[][] board = new char[SIZE][SIZE]; 
    int scoreU=0, scoreA =0;
    resetBoard(board); 

    System.out.println("\n\n\t\t===== WELCOME TO THE TIC-TAC-TOE GAME!! =====\n");


    System.out.println();
    System.out.print("  Rock Scissors Paper! type( r, s, or p) : ");
    char ans = sc.next().toLowerCase().charAt(0);
    while(ans != 'r'&& ans != 's'&& ans !='p'){
         System.out.print("You typed invalid Answers. \nPlease type ( r, s, or p) : ");
         ans = sc.next().toLowerCase().charAt(0);
    }
    if(ans == 'r')
    System.out.println("\tYou: Rock              Alphago: Paper ");
    else if (ans == 's')
    System.out.println("\tYou: Scissors          Alphago: Rock ");
    else if (ans == 'p')
    System.out.println("\tYou: Paper             Alphago: Scissors ");
    System.out.println("\n\tYou lost! Alphago Won! Alphago starts first!");
    System.out.println("\n\n\tYou are 'x', Alphago is 'o'   \n\n");
    System.out.print("  Ready?  type y    : " );
    sc.next();
    System.out.println();
    
    
    int turn;  
    int remainCount = SIZE * SIZE; 

    
    if (ans == 'y') {
      turn = 0;
      System.out.println("___________________________________________________________________________");
      System.out.println("                              Your Turn!");
      userPlay(board, 'x'); // user puts his/her first tic
      
    }
    else {
      turn = 1;
      System.out.println("___________________________________________________________________________");
      System.out.println("                              AI's Turn!");
      compPlay(board, 'o'); // computer puts its first tic
    }
    // Show the board, and decrement the count of remaining cells.
    showBoard(board);
    remainCount--;

    // Play the game until either one wins.
    boolean done = false;
    int winner = -1;   // 0 -- the user, 1 -- the computer, -1 -- draw

    while (!done && remainCount > 0) {
      // If there is a winner at this time, set the winner and the done flag to true.
      done = isGameWon(board, turn, 'x', 'o'); // Did the turn won?

      if (done)
        winner = turn; // the one who made the last move won the game
      else {
        // No winner yet.  Find the next turn and play.
        turn = (turn + 1 ) % 2;

        if (turn == 0){
          System.out.println("___________________________________________________________________________");
          System.out.println("                              Your Turn!");
          userPlay(board, 'x');}
        else{
          System.out.println("___________________________________________________________________________");
          System.out.println("                              AI's Turn!");
          compPlay(board, 'o');}

        // Show the board after one tic, and decrement the rem count.
        showBoard(board);
        remainCount--;
      }
    }

    // Winner is found.  Declare the winner.
    if (winner == 0)
      System.out.println("\n** YOU WON.  CONGRATULATIONS!! **");
    else if (winner == 1)
      System.out.println("\n** YOU LOST..  Maybe next time :) **");
    else
      System.out.println("\n** DRAW... **");
      System.out.println("\nWant to give up and cry? (y/n) ");
      char rep = sc.next().toLowerCase().charAt(0);
      if (rep == 'n'){
          String[] str = new String[0];
          main(str);
        }
  }

  public static void resetBoard(char[][] brd)
  {
    for (int i = 0; i < brd.length; i++)
      for (int j = 0; j < brd[0].length; j++)
        brd[i][j] = ' ';
  }

  public static void showBoard(char[][] brd)
  {
    int numRow = brd.length;
    int numCol = brd[0].length;

    System.out.println();

    // First write the column header
    System.out.print("                                 ");
    for (int i = 0; i < numCol; i++)
      System.out.print(i + "   ");
    System.out.println();

    // The write the table
    
    for (int i = 0; i < numRow; i++) {
        System.out.print("                             ");
      System.out.print(i + "  ");
      for (int j = 0; j < numCol; j++) {
        if (j != 0)
          System.out.print("|");
        System.out.print(" " + brd[i][j] + " ");
      }

      System.out.println();

      if (i != (numRow - 1)) {
        // separator line
        System.out.print("                                ");
        for (int j = 0; j < numCol; j++) {
          if (j != 0)
            System.out.print("+");
          System.out.print("---");
        }
        System.out.println();
      }
    }
    System.out.println();
  }

  public static void userPlay(char[][] brd, char usym)
  {
    System.out.print("\nEnter the x and y coordinates with space between ex) 1 2:      ");
    int colIndex = sc.nextInt();
    int rowIndex = sc.nextInt();
    while (colIndex >= brd[0].length || rowIndex >= brd.length || colIndex < 0 || rowIndex< 0){
       System.out.println("You typed the invalid value. Learn How To Count. ");
       System.out.print("Type it again: ");
       colIndex = sc.nextInt();
       rowIndex = sc.nextInt();
       }

    while (brd[rowIndex][colIndex] != ' ') {
      System.out.print("\n!! The cell is already taken.\nEnter the x and y coordinates: ");
      colIndex = sc.nextInt();
      rowIndex = sc.nextInt();
    }

    brd[rowIndex][colIndex] = usym;
  }

  public static void compPlay(char[][] brd, char csym)
  {
      if(brd[1][1] == ' '){
          brd[1][1] = 'o';
          return;
      }
      int i, j;
      for (i = 0; i < brd.length; i++) {
      for (j = 0; j < brd[0].length; j++) {
          if (brd[i][j] == ' ' && (brd[(i+1)%brd.length][j] =='o' && brd[(i+2)%brd.length][j] =='o')){
              brd[i][j] = 'o';
              return;
            }
        }
    }
    for (j = 0; j < brd[0].length; j++) {
      for (i = 0; i < brd.length; i++) {
          if (brd[i][j] == ' ' && (brd[i][(j+1)%brd.length] == 'o' && brd[i][(j+2)%brd.length] == 'o')){
            brd[i][j] = 'o';
          return;
      }
    }
   }
    for (i = 0; i < brd.length; i++) {
      for (j = 0; j < brd[0].length; j++) {
    if (brd[i][j] == ' ' && (brd[(i+1)%brd.length][j] =='x' && brd[(i+2)%brd.length][j] =='x')){
              brd[i][j] = 'o';
              return;
            }
        }
    }
    
       for (j = 0; j < brd[0].length; j++) {
      for (i = 0; i < brd.length; i++) {
       if (brd[i][j] == ' ' && (brd[i][(j+1)%brd.length] == 'x' && brd[i][(j+2)%brd.length] == 'x')){
            brd[i][j] = 'o';
          return;
      }
    }
    }
   for (i = 0; i < brd.length; i++) {
       if (brd[i][i] == ' ' && (brd[(i+1)%brd.length][(i+1)%brd.length] =='o')
                             && (brd[(i+2)%brd.length][(i+2)%brd.length] =='o')){
          brd[i][i] = 'o';
          return;}
        if (brd[i][i] == ' ' && (brd[(i+1)%brd.length][(i+1)%brd.length] =='x')
                             && (brd[(i+2)%brd.length][(i+2)%brd.length] =='x')){
          brd[i][i] = 'o';
          return;}
        }
   for (i = 0; i < brd.length; i++) {
       if (brd[i][brd.length - 1 - i] == ' ' 
         && brd[(i+1)%brd.length][(brd.length - i)%brd.length] == 'o' 
         && brd[(i+2)%brd.length][(brd.length +1 - i)%brd.length] == 'o'){
          brd[i][brd.length - 1 - i] = 'o';
          return;
        }
        if (brd[i][brd.length - 1 - i] == ' ' 
         && brd[(i+1)%brd.length][(brd.length - i)%brd.length] == 'x' 
         && brd[(i+2)%brd.length][(brd.length +1 - i)%brd.length] == 'x'){
          brd[i][brd.length - 1 - i] = 'o';
          return;
        }
      } 
      for (j = 0; j < brd[0].length; j++) {
      for (i = 0; i < brd.length; i++) {
      if (brd[i][j] == ' ' && (brd[(i+1)%brd.length][j] ==' ' || brd[(i+2)%brd.length][j] ==' ')
           && brd[i][j] == ' ' && (brd[i][(j+1)%brd.length] == ' ' || brd[i][(j+2)%brd.length] == ' ')){
              brd[i][j] = 'o';
              return;
          }
        }
    }
      for (i = 0; i < brd.length; i++) {
      for (j = 0; j < brd[0].length; j++) {
          if (brd[i][j] ==' '&& ((i==1&&(j==0||j==2))||((i==0||i==2)&&j==1))){
          brd[i][j] = 'o';
          return;
        }
        else if(brd[i][j] == ' '){
        brd[i][j] = 'o';
        return;
        }
      }
    }
  }

  public static boolean isGameWon(char[][] brd, int turn, char usym, char csym)
  {
    char sym;
    if (turn == 0)
      sym = usym;
    else
      sym = csym;

    int i, j;
    boolean win = false;

    // Check win by a row
    for (i = 0; i < brd.length && !win; i++) {
      for (j = 0; j < brd[0].length; j++) {
        if (brd[i][j] != sym)
          break;
      }
      if (j == brd[0].length)
        win = true;
    }

    // Check win by a column
    for (j = 0; j < brd[0].length && !win; j++) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][j] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // Check win by a diagonal (1)
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // Check win by a diagonal (2)
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][brd.length - 1 - i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // Finally return win
    return win;
  }
}