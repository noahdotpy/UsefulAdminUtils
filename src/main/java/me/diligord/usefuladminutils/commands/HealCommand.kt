package me.diligord.usefuladminutils.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Must be executed as player.")
            return true
        }

        if (sender.hasPermission("usefuladminutils.heal")) {
            sender.health = 20.0
        } else {
            sender.sendMessage(Bukkit.permissionMessage())
        }

        return true
    }
}