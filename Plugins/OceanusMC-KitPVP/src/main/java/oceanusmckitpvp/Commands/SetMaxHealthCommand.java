package oceanusmckitpvp.Commands;

import oceanusmckitpvp.OceanusMCKitPVP;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SetMaxHealthCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof ConsoleCommandSender) || sender.getName().equals("Myzumi") || sender.getName().equals("gesalzt")) {

            if (args.length == 0) {
                System.out.println("Please give me a Player name to set the hp");
                return false;
            }
            if (args.length == 1) {
                System.out.println("Please give me a ammount of health to set the player");
                return false;
            }
            Player p = Bukkit.getServer().getPlayer(args[0]);
            if (p == null) {
                System.out.println("This player is not Online");
                return false;
            }
            double value;
            if (args[1].equals("reset")) {value = 20.00;} else  value = Double.parseDouble(args[1]);
            if (p.getLocation().getY() > 0) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(OceanusMCKitPVP.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(value);
                        p.setHealth(value * 2);
                    }
                }, 40L); //20 Tick (1 Second) delay before run() is called
            }
        }else {
            System.out.println("Someone tried to run this command inagme (NOT CONSOLE)");
        }
        return false;
    }
}
