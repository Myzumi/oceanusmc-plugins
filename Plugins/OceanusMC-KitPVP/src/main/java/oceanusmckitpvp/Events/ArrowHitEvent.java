package oceanusmckitpvp.Events;

import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHitEvent implements Listener {

    @EventHandler
    public void ArrowHitEvent(ProjectileHitEvent e) {
        if (e.getHitEntity() == null) {
            if (e.getHitBlock() != null) {
                if (e.getEntity() instanceof Arrow) {
                    e.getEntity().remove();
                    e.getHitBlock().getWorld().spawnParticle(Particle.SMOKE_NORMAL, e.getHitBlock().getX(), e.getHitBlock().getY() + 1, e.getHitBlock().getZ(), 30);
                 //   e.getHitBlock().getWorld().playSound(e.getHitBlock().getLocation().add(0,1,0), Sound.ITEM_FIRECHARGE_USE,100, 0);
                }
            }
        }else if (e.getEntity().getShooter() instanceof Player && e.getEntity() instanceof Arrow) {
            Player shooter = (Player) e.getEntity().getShooter();
            if (shooter.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§3Switching Bow")) {
                if (e.getHitEntity() instanceof Player) {
                    Player hitter = (Player) e.getHitEntity();
                    if (hitter.getGameMode().equals(GameMode.CREATIVE)) return;
                    if (hitter.isBlocking()) return;
                    Location hitent = e.getHitEntity().getLocation();
                    Location p = shooter.getLocation();
                    shooter.teleport(hitent);
                    e.getHitEntity().teleport(p);
                }
            }
        }
    }

}
