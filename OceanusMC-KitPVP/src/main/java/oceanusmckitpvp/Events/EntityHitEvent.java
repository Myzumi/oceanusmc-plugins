package oceanusmckitpvp.Events;

import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityHitEvent implements Listener {

    @EventHandler
    public void EntityHitEvent(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Snowball) {
            e.setDamage(0.5);
        }


    }

}
