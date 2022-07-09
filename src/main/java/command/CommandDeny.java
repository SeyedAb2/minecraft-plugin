package command;

import game.StaticGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDeny implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (StaticGame.game != null && player.equals(StaticGame.game.getPlayer2())) {
            sender.sendMessage("Challenged denied.");
            StaticGame.game.getPlayer1().sendMessage(player.getDisplayName() + " denied your challenge :(");
            return true;
        }
        else
            sender.sendMessage("You have not been challenged by anyone!");
        return false;
    }
}
