package oceanusmckitpvp.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;

import java.util.List;

public class ClearDogsCommand implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {
        List<Entity> entities = sender.getServer().getWorld("world").getEntities();
        for (Entity entity : entities){
            if (entity instanceof Wolf){
                if (((Tameable) entity).isTamed()){
                    if (((Tameable) entity).getOwner().getName().equals(args[0])){
                        Wolf w = (Wolf) entity;
                        w.remove();
                    }
                }
            }
        }
        return false;
    }
}
