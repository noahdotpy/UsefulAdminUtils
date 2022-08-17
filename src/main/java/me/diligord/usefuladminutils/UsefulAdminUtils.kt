package me.diligord.usefuladminutils

import me.diligord.usefuladminutils.commands.*
import me.diligord.usefuladminutils.events.JoinEvent
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin


class UsefulAdminUtils : JavaPlugin() {

    var vanishedPlayers: ArrayList<Player> = ArrayList()

    override fun onEnable() {
        // Plugin startup logic

        val plMan = Bukkit.getPluginManager()

        plMan.registerEvents(JoinEvent(this), this)

        getCommand("god")!!.setExecutor(GodCommand())
        getCommand("feed")!!.setExecutor(FeedCommand())
        getCommand("heal")!!.setExecutor(HealCommand())
        getCommand("fly")!!.setExecutor(FlyCommand())
        getCommand("vanish")!!.setExecutor(VanishCommand(this))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}