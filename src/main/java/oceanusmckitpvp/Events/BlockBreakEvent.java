package oceanusmckitpvp.Events;

import oceanusmckitpvp.OceanusMCKitPVP;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockBreak(org.bukkit.event.block.BlockBreakEvent e) {
        String prefix = "§8█ §eSystem §7» ";
        Player p = e.getPlayer();
        if (OceanusMCKitPVP.buildT.contains(p.getName()) && p.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(false);
        } else {
            p.sendMessage(prefix + "§cYou cannot break blocks here");
            e.setCancelled(true);
        }
    }

}
