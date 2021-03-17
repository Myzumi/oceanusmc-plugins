package oceanusmckitpvp.Events;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.List;

public class OnPlayerRespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        List<Entity> entities = e.getPlayer().getWorld().getEntities();
        for (Entity entity : entities){
            if (entity instanceof Wolf){
                if (((Tameable) entity).isTamed()){
                    if (((Tameable) entity).getOwner().getName().equals(e.getPlayer().getName())){
                        Wolf w = (Wolf) entity;
                        w.remove();
                    }
                }
            }
        }
    }
}
