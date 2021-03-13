package oceanusmckitpvp.Events;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class ItemUseEvent implements Listener {

    @EventHandler
    public void OnItemUse(PlayerInteractEvent e) {
        Player p =  e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.AIR) return;
        if (!p.getInventory().getItemInMainHand().hasItemMeta()) return;
        ItemStack item = p.getInventory().getItemInMainHand();
        ItemMeta itemm = item.getItemMeta();
        if (itemm.getDisplayName().equals("§fSpawn Wolf") && item.getType().equals(Material.WOLF_SPAWN_EGG)) {
            e.setCancelled(true);
            if (!p.getGameMode().equals(GameMode.CREATIVE)) item.setAmount(item.getAmount() - 1);
            Location block = e.getClickedBlock().getLocation();
            Wolf wolf = (Wolf) p.getWorld().spawnEntity(block.add(0,1,0), EntityType.WOLF);
            wolf.setTamed(true);
            wolf.setAdult();
            wolf.setOwner(p);
            wolf.setBreed(false);
            wolf.setCustomName(ChatColor.YELLOW + p.getName() + "'s Wolf");
            wolf.setCustomNameVisible(true);
            wolf.setCanPickupItems(false);
        }
    }

}
