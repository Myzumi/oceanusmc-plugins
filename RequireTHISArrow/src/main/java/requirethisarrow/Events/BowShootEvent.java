package requirethisarrow.Events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.meta.ItemMeta;
import requirethisarrow.RequireTHISArrow;

import java.util.List;

public class BowShootEvent implements Listener {


    @EventHandler
    public void OnBowShoot(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getBow() == null) return;
            if (e.getBow().getItemMeta() == null) return;
            ItemMeta Bow = e.getBow().getItemMeta();
            List<String> Lore = Bow.getLore();
            if (RequireTHISArrow.debug) {
                System.out.println(Lore.toString());
                System.out.println(Lore.toString().contains("§cRequires"));
            }
            if (Lore == null) return;
            if (Lore.toString().contains("§cRequires")) {
                String Requirement = Lore.toString().substring(Lore.toString().indexOf("§cRequires: ") + 12, Lore.toString().length() - 1);
                if (Requirement.contains(",")) {
                    Requirement = Requirement.substring(0, Requirement.indexOf(","));
                }
                if (RequireTHISArrow.debug) System.out.println(Requirement);
                ItemMeta arrow = e.getConsumable().getItemMeta();
                String display = arrow.getDisplayName();
                if (display.equals(Requirement)) {
                    e.setCancelled(false);
                }else {
                    e.setCancelled(true);
                    p.sendMessage("It seems like your using the wrong Arrow...");
                }

                }
        }
    }

}
