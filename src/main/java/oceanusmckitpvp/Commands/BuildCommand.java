package oceanusmckitpvp.Commands;

import oceanusmckitpvp.OceanusMCKitPVP;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        String prefix = "§8█ §eSystem §7» ";
        String playerName = p.getName();
        if (args.length == 0) {
            if (p.hasPermission("oceanusmc.build") || p.isOp()) {
                if (OceanusMCKitPVP.buildT.contains(playerName)) {
                    OceanusMCKitPVP.buildT.remove(playerName);
                    p.sendMessage(prefix + "§cYou cannot Build anymore");
                } else {
                    OceanusMCKitPVP.buildT.add(playerName);
                    p.sendMessage(prefix + "§aYou can now Build");
                }
            }
        }else {
            if (sender.hasPermission("oceanusmc.build.other") || p.isOp()) {
                if (args.length == 2 && args[0].contentEquals("on")) {
                    p.sendMessage(prefix + "The Player: " + (args[1]) + " Can now Build.");
                    OceanusMCKitPVP.buildT.add(args[1]);
                } else if (args.length == 2 && args[0].contains("off")) {
                    p.sendMessage(prefix + "The Player: " + (args[1]) + " Cannot Build anymore.");
                }}
        }

        return false;
    }
}
