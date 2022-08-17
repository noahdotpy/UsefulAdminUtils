package me.diligord.usefuladminutils.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FeedCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Must be executed as player.")
            return true
        }

        if (sender.hasPermission("usefuladminutils.feed")) {
            sender.foodLevel = 20
            sender.sendMessage("${ChatColor.GREEN}You have been fed to the max!")
        } else {
            sender.sendMessage(Bukkit.permissionMessage())
        }

        return true
    }
}