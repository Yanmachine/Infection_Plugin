package org.yanmachine.infection;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.yanmachine.infection.commands.InfectionCommands;
import org.yanmachine.infection.infectionGameUtility.InfectionTeams;

public final class Infection extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("--- Server Initiated ---");

        getCommand("infection").setExecutor(new InfectionCommands());

        InfectionTeams.setUp();

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("--- Server Terminated ---");
    }
}
