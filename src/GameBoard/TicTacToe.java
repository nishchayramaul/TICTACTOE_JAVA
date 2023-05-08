package GameBoard;
import java.util.*;


public class TicTacToe {

    /*
      List for tracking the number o turns
    */
    static ArrayList<Integer> userlistpos = new ArrayList<Integer>();
    static ArrayList<Integer> cpulistpos = new ArrayList<Integer>();
    public static void main(String[] args) {

        // First We will compose the game board
        char[][] gameboard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };


        // function to print gameboard
        print(gameboard);

boolean start = true;

        while (start) {
        /*
        for continuosly running of code we will use while loop
         */


            //user input of position from 1-9 where he wants to mark X
            Scanner obj = new Scanner(System.in);
            int playerpos = obj.nextInt();
            while(userlistpos.contains(playerpos) || cpulistpos.contains(playerpos))
            {
                System.out.println("Invalid move, position already taken");
                playerpos = obj.nextInt();
            }

            System.out.println(playerpos);
            insert(playerpos, gameboard, "player");
        /*
        after inserting X we will print again the updated gameboard
         */
            print(gameboard);
        /*
        Here we can use artificial intelligence for cpu but we will be using random position by cpu
         */
            Random rand = new Random();
            int cpupos = rand.nextInt(9) + 1;
            while(userlistpos.contains(cpupos) || cpulistpos.contains(cpupos)){
                cpupos = rand.nextInt(9) + 1;
            }
            System.out.println(cpupos);
            insert(cpupos, gameboard, "cpu");
            // printing after cpu turn
            print(gameboard);
            String result = checkWinner();
                if(result.length()>1) {
                    System.out.println(result);
                    break;
                }

         

        }
    }

    public static void insert(int n, char[][] gameboard, String user) {
        /* user is to determine the symbol
        depends upon whether cpu is playing or a player
         */
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            userlistpos.add(n);
        } else if(user.equals("cpu")) {
            symbol = 'O';
            cpulistpos.add(n);
        }
        switch (n) {

            case 1: {
                gameboard[0][0] = symbol;
                break;
            }
            case 2: {
                gameboard[0][2] = symbol;
                break;
            }
            case 3: {
                gameboard[0][4] = symbol;
                break;
            }
            case 4: {
                gameboard[2][0] = symbol;
                break;
            }
            case 5: {
                gameboard[2][2] = symbol;
                break;
            }
            case 6: {
                gameboard[2][4] = symbol;
                break;
            }
            case 7: {
                gameboard[4][0] = symbol;
                break;
            }
            case 8: {
                gameboard[4][2] = symbol;
                break;
            }
            case 9: {
                gameboard[4][4] = symbol;
                break;
            }

        }
    }

    public static void print(char[][] gameboard) {
        // for each row array in gameboard we are getting access to every row in gameboard array
        for (char[] row : gameboard) {

            // for each element in row array we are getting acess by this loop
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /*
    function to determine the winner
     */

        public static String checkWinner(){

            List<Integer> firstrow = Arrays.asList(1, 2, 3);
            List<Integer> secondrow = Arrays.asList(4, 5, 6);
            List<Integer> thirdrow = Arrays.asList(7, 8, 9);
            List<Integer> firstcol = Arrays.asList(1, 4, 7);
            List<Integer> secondcol = Arrays.asList(2, 5, 8);
            List<Integer> thirdcol = Arrays.asList(3, 6, 9);
            List<Integer> cross1 = Arrays.asList(1, 5, 9);
            List<Integer> cross2 = Arrays.asList(3, 5, 7);

            List<List<Integer>> winnerlist = new ArrayList<List<Integer>>();
            winnerlist.add(firstrow);
            winnerlist.add(secondrow);
            winnerlist.add(thirdrow);
            winnerlist.add(firstcol);
            winnerlist.add(secondcol);
            winnerlist.add(thirdcol);
            winnerlist.add(cross1);
            winnerlist.add(cross2);

            for (List<Integer> l : winnerlist) {
                if (userlistpos.containsAll(l)) {

                    return "Congrats! You won";

                } else if (cpulistpos.containsAll(l)) {

                    return "Sorry, you lost";
                }
                else if (userlistpos.size() + cpulistpos.size() == 9) {

                    return "It's a tie!";
                }

            }


            return "";
        }



    }
