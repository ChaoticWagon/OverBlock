package me.chaoticwagon.overblock;

import me.chaoticwagon.overblock.commands.Guns;
import me.chaoticwagon.overblock.events.GUIHandler;
import me.chaoticwagon.overblock.guns.AK47;
import me.chaoticwagon.overblock.guns.M4A1;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("guns").setExecutor(new Guns());

        getServer().getPluginManager().registerEvents(new AK47(),this);
        getServer().getPluginManager().registerEvents(new M4A1(),this);
        getServer().getPluginManager().registerEvents(new GUIHandler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
