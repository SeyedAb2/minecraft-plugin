package minecraft.xoplugin;

import command.*;
import listener.ListenerBlockBreak;
import listener.ListenerPutPieces;
import org.bukkit.plugin.java.JavaPlugin;

public final class minecraftPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ListenerBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new ListenerPutPieces(), this);
        getServer().getPluginCommand("challenge").setExecutor(new CommandChallenge());
        getServer().getPluginCommand("accept").setExecutor(new CommandAccept());
        getServer().getPluginCommand("deny").setExecutor(new CommandDeny());
        getServer().getPluginCommand("put").setExecutor(new CommandPut());
        getServer().getPluginCommand("load").setExecutor(new CommandLoad());
        getServer().getPluginCommand("save").setExecutor(new CommandSave());
    }
}
