package oceanusmckitpvp.Events;

import oceanusmckitpvp.OceanusMCKitPVP;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockPlaceEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        String prefix = "§8█ §eSystem §7» ";
        Player p = e.getPlayer();
        if (OceanusMCKitPVP.buildT.contains(p.getName()) && p.getGameMode().equals(GameMode.CREATIVE)) {
        } else {
            e.setCancelled(true);
            p.sendMessage(prefix + "§cYou Cannot build here!");
        }
    }

}
