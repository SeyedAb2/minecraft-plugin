package command;

import game.StaticGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPut implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (StaticGame.game == null) {
            sender.sendMessage("There is no game at this moment running!\n " +
                    "You can challenge your friends with \\challenge <name> command.");
            return false;
        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.equals(StaticGame.game.getPlayer1()) && StaticGame.game.isPlayer1Turn()) {
                int pos;
                if(!StaticGame.game.isFinished()){
                    try {
                            pos = Integer.parseInt(args[0]);
                            if (StaticGame.game.getPlayer1Positions().contains(pos) || StaticGame.game.getPlayer2Positions().contains(pos)) {
                                sender.sendMessage("This place is already taken! Choose another one.");
                                return false;
                            }
                            if (pos < 1 || pos > 9) {
                                sender.sendMessage("Enter a number only in range of 1 - 9.");
                                return false;
                            }
                            StaticGame.game.placePiece(pos, player);

                    } catch (NumberFormatException e) {
                        sender.sendMessage("Invalid input. Only numbers will be accepted.");
                        return false;
                    }
                    if (!StaticGame.game.winnerCheck().equals("")) {
                        StaticGame.game.getPlayer1().sendMessage(StaticGame.game.winnerCheck());
                        StaticGame.game.getPlayer2().sendMessage(StaticGame.game.winnerCheck());
                        StaticGame.game.save(StaticGame.game.getPlayer1());
                        return true;
                    }
                    StaticGame.game.setPlayer1Turn(false);
                    StaticGame.game.setPlayer2Turn(true);
                    StaticGame.game.getPlayer2().sendMessage("It's your turn. Enter a number between 1 - 9.");
                } else{
                    StaticGame.game.getPlayer1().sendMessage("game is finished!");
                    StaticGame.game.getPlayer2().sendMessage("game is finished!");
                    return true;
                }
                return true;
            }
            else if (player.equals(StaticGame.game.getPlayer2()) && StaticGame.game.isPlayer2Turn()) {
                int pos;
                if (!StaticGame.game.isFinished()){
                    try {
                        pos = Integer.parseInt(args[0]);
                        if (StaticGame.game.getPlayer1Positions().contains(pos)||StaticGame.game.getPlayer2Positions().contains(pos)) {
                            sender.sendMessage("This place is already taken! Choose another one.");
                            return false;
                        }
                        if (pos < 1 || pos > 9) {
                            sender.sendMessage("Enter a number only in range of 1 - 9.");
                            return false;
                        }
                        StaticGame.game.placePiece(pos, player);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("Invalid input. Only numbers will be accepted.");
                        return false;
                    }
                    if (!StaticGame.game.winnerCheck().equals("")) {
                        StaticGame.game.getPlayer1().sendMessage(StaticGame.game.winnerCheck());
                        StaticGame.game.getPlayer2().sendMessage(StaticGame.game.winnerCheck());
                        StaticGame.game.save(StaticGame.game.getPlayer1());
                        return true;
                    }
                    StaticGame.game.setPlayer1Turn(true);
                    StaticGame.game.setPlayer2Turn(false);
                    StaticGame.game.getPlayer1().sendMessage("It's your turn. Enter a number between 1 - 9.");
                    return true;
                } else{
                    StaticGame.game.getPlayer1().sendMessage("game is finished!");
                    StaticGame.game.getPlayer2().sendMessage("game is finished!");
                    return true;
                }
            }
            else if (!StaticGame.game.isPlayer1Turn() || !StaticGame.game.isPlayer2Turn()) {
                player.sendMessage("It's not your turn please wait!");
                return true;
            }
            else {
                player.sendMessage("Sorry there is no game for you right now :(\n" +
                        " But you can challenge a friend with \\challenge <name> command!");
                return true;
            }
        }
        return false;
    }
}

