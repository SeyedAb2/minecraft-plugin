package seyed.ab2.finalproject;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TowerSpawner implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            Location origin = p.getLocation().add(2,0,0);
            for (int i=0;i<50;i++){
                origin.getBlock().setType(Material.STONE);
                origin.add(0,1,0);
            }
            p.sendMessage("market!");
            return true;
        }
        else{
            System.out.println("Your TicTacToePlayer failed!");
            return false;
        }
    }
}
