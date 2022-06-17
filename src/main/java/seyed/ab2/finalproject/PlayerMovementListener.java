package seyed.ab2.finalproject;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
//import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerMovementListener implements Listener {
//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent event){
//        Player p = event.getPlayer();
//        Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
//        if(b.getType() == Material.GRASS_BLOCK){
//            World w = p.getWorld();
//            w.createExplosion(p.getLocation(),1);
//        }
//    }
    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event){
        LivingEntity entity = event.getEntity();
        if(entity instanceof Monster){
            entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            if (entity.getType() == EntityType.SKELETON){
                ItemStack bow = new ItemStack(Material.BOW);
                bow.addEnchantment(Enchantment.ARROW_DAMAGE,100000);
                entity.getEquipment().setItemInMainHand(bow);
            }
        }
    }
}
