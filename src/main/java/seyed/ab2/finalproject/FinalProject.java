package seyed.ab2.finalproject;

import org.bukkit.plugin.java.JavaPlugin;

public final class FinalProject extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Started!");
        getServer().getPluginManager().registerEvents(new PlayerMovementListener(),this);
        getServer().getPluginCommand("mark-location").setExecutor(new TowerSpawner());
        getServer().getPluginCommand("unlimitted-wither-spawner").setExecutor(new WitherCommandExecutor());
    }
}
