package requirethisarrow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import requirethisarrow.Events.BowShootEvent;

public final class RequireTHISArrow extends JavaPlugin {

    public static Boolean debug = false;

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BowShootEvent(), this);
        getCommand("rqtad").setExecutor(new DebugCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
