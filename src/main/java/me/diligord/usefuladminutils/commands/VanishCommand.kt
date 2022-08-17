package me.diligord.usefuladminutils.commands

import me.diligord.usefuladminutils.UsefulAdminUtils
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class VanishCommand(private val plugin: UsefulAdminUtils, private var vanishedPlayers: ArrayList<Player> = ArrayList()): CommandExecutor{


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Must be run as player.")
            return true
        }

        val onlinePlayers = Bukkit.getOnlinePlayers()

        if (vanishedPlayers.contains(sender)) {
            vanishedPlayers.remove(sender)
            sender.sendMessage("Vanish disabled.")
            for (player in onlinePlayers) {
                player.showPlayer(plugin, sender)
            }
        } else {
            vanishedPlayers.add(sender)
            sender.sendMessage("Vanish enabled.")
            for (player in onlinePlayers) {
                player.hidePlayer(plugin, sender)
            }
        }

        return true
    }

}