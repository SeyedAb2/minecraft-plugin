package FirstPhase;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToeCli {
    TicTacToeGame ticTacToeGame;
    public String run(String cmd){
        String[] command = cmd.split(" ");
        if (Objects.equals(command[0], "/start")) {
            if(Objects.equals(command[0], command[1])){
                return ("player's name should different");
            }
            else{
                ticTacToeGame = new TicTacToeGame(command[1], command[2]);
                return (ticTacToeGame.getPlayerNameX()+ " your turn");
            }
        }
        else if (Objects.equals(command[0], "/load")) {
            ticTacToeGame = TicTacToeFiles.readGame(command[1].split("\\.")[0]);
            return "";
        }
        try {


            if (!ticTacToeGame.finishCheck()) {

                if (Objects.equals(command[0], "/put")) {
                    try {
                        ticTacToeGame.selectItem(Integer.parseInt(command[1]));
                        return "";
                    } catch (NumberFormatException i) {
                        System.out.println("please enter valid number after '/put'");
                    }

                } else if (Objects.equals(command[0], "/save")) {
                    if (command.length > 1) {
                        return "just type '/save' ";
                    }
                    ticTacToeGame.saveGame();
                    return "";
                }else if (Objects.equals(command[0], "/reload")){

                    ticTacToeGame.reloadGame();
                    System.out.println("game is reloaded ");
                }

            } else {
                return ("game is finished");
            }
            return "not a cmd";
        }catch (NullPointerException e){
            System.out.println("please start or load game");
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String cmd;
        TicTacToeCli cli = new TicTacToeCli();
        System.out.println("\n\t\t\t\t\t\t\t\t\t Welcome To XO ticTacToeGame \n");
        System.out.println("Command </start player1 player2> start a new ticTacToeGame , example : /start Ali Reza ");
        System.out.println("Command </put n> selectItem a block ticTacToeGame per term, example : /put 1 ");
        System.out.println("Command </save> save the ticTacToeGame, example : /save ");
        System.out.println("Command </load gameName> load the ticTacToeGame, example : /save Ali_Reza12534.txt ");
        while(true){
            System.out.print("command> ");
            cmd = inp.nextLine();
            if(Objects.equals(cmd, "/save")) {
                System.out.println(cli.run("/save"));
                break;
            }else {
                System.out.println(cli.run(cmd));
            }
        }
    }

}
