package FirstPhase;

import java.io.*;

public class TicTacToeFiles {

    private static final int counter = (int) (1000*Math.random());

    public static void save (TicTacToeGame ticTacToeGame){
        try {
            ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream(ticTacToeGame.getPlayerNameX()+"_"+ ticTacToeGame.getPlayerNameO()+"_"+counter+".txt"));
            o.writeObject(ticTacToeGame);
            o.close();
            System.out.println("Game has been saved in a file :  "+ ticTacToeGame.getPlayerNameX()+"_"+ ticTacToeGame.getPlayerNameO()+"_"+counter+".txt");
        } catch (FileNotFoundException e) {
            System.out.println("not saved");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static TicTacToeGame readGame(String gameName){
        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream(gameName+".txt"))) {

            TicTacToeGame ticTacToeGame = (TicTacToeGame) oi.readObject();
            oi.close();
            System.out.println("Game has loaded");
            return ticTacToeGame;
        } catch (FileNotFoundException e) {
            System.out.println("Game not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
