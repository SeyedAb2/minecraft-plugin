package command;

import game.StaticGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSave implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (StaticGame.game != null && StaticGame.game.isAccepted()) {
                StaticGame.game.save(player);
                return true;
            }
            else if(StaticGame.game != null && StaticGame.game.isLoaded()) {
                StaticGame.game.saveLoaded(player);
            }
            else {
                sender.sendMessage("There is no game to save!");
            }
        }
        return false;
    }
}
