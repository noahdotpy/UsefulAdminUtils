package me.diligord.usefuladminutils

import me.diligord.usefuladminutils.commands.FeedCommand
import me.diligord.usefuladminutils.commands.FlyCommand
import me.diligord.usefuladminutils.commands.GodCommand
import me.diligord.usefuladminutils.commands.HealCommand
import org.bukkit.plugin.java.JavaPlugin


class UsefulAdminUtils : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("god")!!.setExecutor(GodCommand())
        getCommand("feed")!!.setExecutor(FeedCommand())
        getCommand("heal")!!.setExecutor(HealCommand())
        getCommand("fly")!!.setExecutor(FlyCommand())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}