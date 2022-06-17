package seyed.ab2.finalproject;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class WitherCommandExecutor implements CommandExecutor {
    private Plugin plugin = FinalProject.getPlugin(FinalProject.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2){
            long initialDelay = Long.parseLong(args[0]);
            long spawnDelay = Long.parseLong(args[1]);
            new RunWitherSpawner(plugin).runTaskTimer(plugin,initialDelay,spawnDelay);
            sender.sendMessage("withers is coming .... ");
            return true;
        }
        else{
            return false;
        }
    }
}
