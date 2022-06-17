package seyed.ab2.finalproject;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class RunWitherSpawner extends BukkitRunnable {
    private final Plugin plugin;

    public RunWitherSpawner(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        String name = plugin.getConfig().getString("worldname");
        World w = plugin.getServer().getWorld(name);
        w.spawnEntity(w.getSpawnLocation(), EntityType.WITHER);
    }
}
