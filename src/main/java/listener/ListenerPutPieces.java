package listener;


import game.StaticGame;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;

public class ListenerPutPieces implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void putPieces(PlayerInteractEvent e) {
        if (StaticGame.game != null && e.getHand() == EquipmentSlot.OFF_HAND) {
            Player p = e.getPlayer();
            ArrayList<Location> locations = new ArrayList<>();

            for (int i = 2; i > -1; i--) {
                for (int j = 0; j < 3; j++) {
                    locations.add(StaticGame.game.getGameBoard()[i][j]);
                }
            }

            if (locations.contains(p.getTargetBlockExact(1000).getLocation())) {
                int pos = locations.indexOf(p.getTargetBlockExact(1000).getLocation()) + 1;
                e.getPlayer().sendMessage("put "+pos);
                p.performCommand("put " + pos);
            }
        }
    }
}