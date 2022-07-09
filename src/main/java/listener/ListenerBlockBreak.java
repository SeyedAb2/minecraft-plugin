package listener;


import game.StaticGame;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ListenerBlockBreak implements Listener {

    @EventHandler
    public void cancelBlockBreak(BlockBreakEvent e) {
        if (StaticGame.game != null && !StaticGame.game.isFinished()){
            for (Location[] row : StaticGame.game.getGameBoard()) {
                for (Location c : row) {
                    if (e.getPlayer().getTargetBlock(null, 1000).equals(c.getBlock())) {
                        e.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }
}
