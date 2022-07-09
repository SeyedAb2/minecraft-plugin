package command;

import game.StaticGame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAccept implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player2 = (Player) sender;
        if (StaticGame.game != null && player2.equals(StaticGame.game.getPlayer2())) {
            StaticGame.game.setAccepted(true);
            setDefault((Player)sender);
            Player player1 = null;
            for (Player serverPlayer : Bukkit.getServer().getOnlinePlayers()) {
                if (serverPlayer.equals(StaticGame.game.getPlayer1())) {
                    player1 = serverPlayer;
                    break;
                }
            }
            sender.sendMessage("Challenge accepted! enjoyed of game");
            int x = player1.getLocation().getBlockX();
            int y = player1.getLocation().getBlockY();
            int z = player1.getLocation().getBlockZ();
            floorBoard(player1);
            for (int i = -15; i < 5; i++) {
                for (int j = -10; j < 10; j++) {
                    new Location(player1.getWorld(), x+j, y+20, z+i).getBlock().setType(Material.WHITE_WOOL);
                }
            }

            player1.teleport(new Location(player1.getWorld(), x, y+21, z));
            player2.teleport(new Location(player1.getWorld(), x+3, y+21, z));

            StaticGame.game.setPlayer1Turn(true);
            player1.sendMessage("Challenge accepted!\n It's your turn. Enter a number between 1 - 9.");
            player2.sendMessage("Game started! Please wait, it's " + player1.getDisplayName() + "'s turn.");
            StaticGame.game.createBoard(player1);
            StaticGame.game.showTable();
            return true;
        } else
            sender.sendMessage("You have not been challenged by anyone!");
        return false;
    }
    public void setDefault(Player player){
        player.performCommand("op " + player.getName());
        player.performCommand("weather clear");
        player.performCommand("time set day");
    }
    public void floorBoard (Player player1){
        for (int i = -15; i < 5; i++) {
            int x = player1.getLocation().getBlockX();
            int y = player1.getLocation().getBlockY();
            int z = player1.getLocation().getBlockZ();
            new Location(player1.getWorld(), x + i + 5, y + 21, z - 15).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 22, z - 15).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 23, z - 15).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 21, z - 14).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 22, z - 14).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 21, z - 13).getBlock().setType(Material.WHITE_WOOL);
            //
            new Location(player1.getWorld(), x + i + 5, y + 21, z + 4).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 22, z + 4).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 23, z + 4).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 21, z + 3).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 22, z + 3).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + i + 5, y + 21, z + 2).getBlock().setType(Material.WHITE_WOOL);
            //
            new Location(player1.getWorld(), x + 9, y + 21, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + 9, y + 22, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + 9, y + 23, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + 8, y + 21, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + 8, y + 22, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x + 7, y + 21, z + i).getBlock().setType(Material.WHITE_WOOL);
            //
            new Location(player1.getWorld(), x - 11, y + 21, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x - 11, y + 22, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x - 11, y + 23, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x - 10, y + 21, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x - 10, y + 22, z + i).getBlock().setType(Material.WHITE_WOOL);
            new Location(player1.getWorld(), x - 9, y + 21, z + i).getBlock().setType(Material.WHITE_WOOL);
        }
    }
}
