package command;

import game.Game;
import game.StaticGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandChallenge implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("please enter player name ");
            return false;
        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getDisplayName().equals(args[0])) {
                sender.sendMessage("You cannot play with yourself");
                return false;
            }
            else{
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    if (p.getDisplayName().equals(args[0])) {
                        p.sendMessage("Player : " + player.getDisplayName() + " challenged you! Do you want play ?" +
                                " (/accept or /deny)");
                        StaticGame.game = new Game(player, p);
                        sender.sendMessage("Challenge request send. Waiting for respond...");
                        return true;
                    }
                }
                return true;
            }
        }
        sender.sendMessage("Player not found!!!!");
        return false;
    }
}
