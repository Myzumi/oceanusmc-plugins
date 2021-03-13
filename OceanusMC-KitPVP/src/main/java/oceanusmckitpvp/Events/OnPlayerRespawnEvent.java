package oceanusmckitpvp.Events;

import oceanusmckitpvp.OceanusMCKitPVP;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class OnPlayerRespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
    }
}
