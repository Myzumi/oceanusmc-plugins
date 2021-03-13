package requirethisarrow;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DebugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("oceanusmc.toggledevmode")) {
            if (!RequireTHISArrow.debug) {
                RequireTHISArrow.debug = true;
                sender.sendMessage("Enabled Debug Mode");
            }else {
                RequireTHISArrow.debug = false;
                sender.sendMessage("Disabled Debug Mode");
            }
        }
        return false;
    }
}
