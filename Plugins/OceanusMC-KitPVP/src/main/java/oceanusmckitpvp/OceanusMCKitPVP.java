package oceanusmckitpvp;

import oceanusmckitpvp.Commands.BuildCommand;
import oceanusmckitpvp.Commands.SetMaxHealthCommand;
import oceanusmckitpvp.Events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class OceanusMCKitPVP extends JavaPlugin {
    public static ArrayList<String> buildT;

    private static OceanusMCKitPVP instance;

    public OceanusMCKitPVP() {
        instance = this;
    }

    public static OceanusMCKitPVP getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        this.buildT = new ArrayList<String>();
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ItemUseEvent(), this);
        pluginManager.registerEvents(new ArrowHitEvent(), this);
        pluginManager.registerEvents(new EntityHitEvent(), this);
        pluginManager.registerEvents(new BlockBreakEvent(), this);
        pluginManager.registerEvents(new BlockPlaceEvent(), this);
        pluginManager.registerEvents(new OnPlayerRespawnEvent(), this);
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("setmaxhealth").setExecutor(new SetMaxHealthCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
