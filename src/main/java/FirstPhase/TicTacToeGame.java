package FirstPhase;

import java.io.Serializable;

public class TicTacToeGame implements Serializable {

    private int counter = 0;
    private int[] moves = new int[9];
    private String PlayerNameO = "";
    private String PlayerNameX = "";

    TicTacToePlayer firstPlayer =new TicTacToePlayer(PlayerNameX);
    TicTacToePlayer secondPlayer =new TicTacToePlayer(PlayerNameO);

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

    public void setMoves(int[] moves) {
        this.moves = moves;
    }

    public TicTacToePlayer Winner() {
        if (moves[0] == 1 && moves[1] == 1 && moves[2] == 1) {
            return firstPlayer;
        } else if (moves[3] == 1 && moves[4] == 1 && moves[5] == 1) {
            return firstPlayer;
        } else if (moves[6] == 1 && moves[7] == 1 && moves[8] == 1) {
            return firstPlayer;
        } else if (moves[0] == 1 && moves[4] == 1 && moves[8] == 1) {
            return firstPlayer;
        } else if (moves[2] == 1 && moves[4] == 1 && moves[6] == 1) {
            return firstPlayer;
        } else if (moves[2] == 1 && moves[8] == 1 && moves[5] == 1) {
            return firstPlayer;
        } else if (moves[1] == 1 && moves[4] == 1 && moves[7] == 1) {
            return firstPlayer;
        } else if (moves[0] == 1 && moves[3] == 1 && moves[6] == 1) {
            return firstPlayer;
        } else if (moves[0] == 2 && moves[1] == 2 && moves[2] == 2) {
            return secondPlayer;
        } else if (moves[3] == 2 && moves[4] == 2 && moves[5] == 2) {
            return secondPlayer;
        } else if (moves[6] == 2 && moves[7] == 2 && moves[8] == 2) {
            return secondPlayer;
        } else if (moves[0] == 2 && moves[4] == 2 && moves[8] == 2) {
            return secondPlayer;
        } else if (moves[2] == 2 && moves[4] == 2 && moves[6] == 2) {
            return secondPlayer;
        } else if (moves[2] == 2 && moves[8] == 2 && moves[5] == 2) {
            return firstPlayer;
        } else if (moves[1] == 2 && moves[4] == 2 && moves[7] == 2) {
            return firstPlayer;
        } else if (moves[0] == 2 && moves[3] == 2 && moves[6] == 2) {
            return firstPlayer;
        }
        return null;
    }
    public void selectItem(int item) {
        if (Winner() == null) {
            if (counter <= 8) {
                if (moves[item - 1] == 0) {
                    if (counter % 2 == 0) {
                        moves[item - 1] = 1;
                        firstPlayer.selectItem(item);
                        if (Winner() != null) {
                            System.out.println("XO Game over, winner is : " + Winner().getName());
                        }
                        else {
                            System.out.println(secondPlayer.getName() + " your turn");

                        }
                    } else if(counter%2==1) {
                        moves[item - 1] = 2;
                        secondPlayer.selectItem(item);
                        if (Winner() != null) {
                            System.out.println("XO Game over, winner is : " + Winner().getName());
                        }
                        else {
                            System.out.println(firstPlayer.getName() + " your turn");

                        }
                    }
                    counter++;
                } else {
                    System.out.println("this item selected before");
                }
            } else {
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

    public void reloadGame(){
        setMoves(new int[9]);
        counter = 0;
    }
}
