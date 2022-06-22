package FirstPhase;

import java.io.Serializable;
import java.util.Objects;

public class TicTacToeGame implements Serializable {
    private static final int COLS = 3;
    private static final int ROWS = 3;
    private int counter = 0;
    private String[] moves = {" "," "," "," "," "," "," "," "," "," "};
    private String PlayerNameO = "";
    private String PlayerNameX = "";

    TicTacToePlayer firstPlayer =new TicTacToePlayer(PlayerNameX,"X");
    TicTacToePlayer secondPlayer =new TicTacToePlayer(PlayerNameO,"O");

    public TicTacToeGame(String PlayerNameX, String PlayerNameO) {
        this.PlayerNameX = PlayerNameX;
        this.PlayerNameO = PlayerNameO;
        firstPlayer.setName(PlayerNameX);
        secondPlayer.setName(PlayerNameO);
    }
    public String getPlayerNameX() {
        return PlayerNameX;
    }

    public String getPlayerNameO() {
        return PlayerNameO;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    public TicTacToePlayer Winner() {
        if (Objects.equals(moves[0], "X") && Objects.equals(moves[1], "X") && Objects.equals(moves[2], "X")) {
            return firstPlayer;
        } else if (Objects.equals(moves[3], "X") && Objects.equals(moves[4], "X") && Objects.equals(moves[5], "X")) {
            return firstPlayer;
        } else if (Objects.equals(moves[6], "X") && Objects.equals(moves[7], "X") && Objects.equals(moves[8], "X")) {
            return firstPlayer;
        } else if (Objects.equals(moves[0], "X") && Objects.equals(moves[4], "X") && Objects.equals(moves[8], "X")) {
            return firstPlayer;
        } else if (Objects.equals(moves[2], "X") && moves[4] == "X" && moves[6] == "X") {
            return firstPlayer;
        } else if (Objects.equals(moves[2], "X") && Objects.equals(moves[8], "X") && Objects.equals(moves[5], "X")) {
            return firstPlayer;
        } else if (Objects.equals(moves[1], "X") && Objects.equals(moves[4], "X") && Objects.equals(moves[7], "X")) {
            return firstPlayer;
        } else if (Objects.equals(moves[0], "X") && Objects.equals(moves[3], "X") && Objects.equals(moves[6], "X")) {
            return firstPlayer;
        } else if (Objects.equals(moves[0], "O") && Objects.equals(moves[1], "O") && Objects.equals(moves[2], "O")) {
            return secondPlayer;
        } else if (Objects.equals(moves[3], "O") && Objects.equals(moves[4], "O") && Objects.equals(moves[5], "O")) {
            return secondPlayer;
        } else if (Objects.equals(moves[6], "O") && Objects.equals(moves[7], "O") && Objects.equals(moves[8], "O")) {
            return secondPlayer;
        } else if (Objects.equals(moves[0], "O") && Objects.equals(moves[4], "O") && Objects.equals(moves[8], "O")) {
            return secondPlayer;
        } else if (Objects.equals(moves[2], "O") && Objects.equals(moves[4], "O") && Objects.equals(moves[6], "O")) {
            return secondPlayer;
        } else if (Objects.equals(moves[2], "O") && Objects.equals(moves[8], "O") && Objects.equals(moves[5], "O")) {
            return firstPlayer;
        } else if (Objects.equals(moves[1], "O") && Objects.equals(moves[4], "O") && Objects.equals(moves[7], "O")) {
            return firstPlayer;
        } else if (Objects.equals(moves[0], "O") && Objects.equals(moves[3], "O") && Objects.equals(moves[6], "O")) {
            return firstPlayer;
        }
        return null;
    }
    public void selectItem(int item) {
        if (Winner() == null) {
            if (counter <= 8) {
                if (Objects.equals(moves[item - 1], " ")) {
                    if (counter % 2 == 0) {
                        moves[item - 1] = firstPlayer.getSign();
                        firstPlayer.selectItem(item);
                        if (Winner() != null) {
                            gameBoard(moves);
                            System.out.print("\nXO Game over, winner is : " + Winner().getName());
                        }
                        else {
                            gameBoard(moves);
                            System.out.println("\n"+secondPlayer.getName() + " your turn");

                        }
                    } else if(counter%2==1) {
                        moves[item - 1] = secondPlayer.getSign();
                        secondPlayer.selectItem(item);
                        if (Winner() != null) {
                            gameBoard(moves);
                            System.out.print("\nXO Game over, winner is : " + Winner().getName());
                        }
                        else {
                            gameBoard(moves);
                            System.out.println("\n"+firstPlayer.getName() + " your turn");

                        }
                    }
                    counter++;
                } else {
                    System.out.println("this item selected before");
                }
            } else {
                gameBoard(moves);
                System.out.println("The Game equalised");
            }
        }
    }

    public void  saveGame(){
        TicTacToeFiles.save(this);
    }

    public boolean finishCheck(){
        return (counter>8 || Winner() != null);
    }

    public void gameBoard(String[] moves){
        String[][] moves_2D_array = new String[ROWS][COLS];
        for (int r=0;r<ROWS;r++){
            for (int c=0;c<COLS;c++){
                if (r==0 && c>=0 && c<=2){
                    moves_2D_array[r][c] = moves[c];
                }
                else if (r==1 && c>=0 && c<=2){
                    moves_2D_array[r][c] = moves[2*r+c+1];
                }
                else if (r==2 && c>=0 && c<=2) {
                    moves_2D_array[r][c] = moves[3*r+c];
                }
            }
        }
        for (int r=0;r<ROWS;r++){
            System.out.print("\t\t\t");
            for (int c=0;c<COLS;c++){
                if (c!=COLS-1){
                    System.out.print(" "+moves_2D_array[r][c]+" |");
                }
                else {
                    System.out.println(" "+moves_2D_array[r][c]+" ");
                }
            }
            if(r!=ROWS-1){
                System.out.print("\t\t\t---+---+---\n");
            }
        }
    }

    public void reloadGame(){
        setMoves(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "});
        counter = 0;
    }
}
