package me.diligord.usefuladminutils.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GodCommand: CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Must be executed as player.")
            return true
        }

        if (sender.hasPermission("userfuladminutils.god")) {
            sender.isInvulnerable = !sender.isInvulnerable

            when(sender.isInvulnerable) {
                true -> sender.sendMessage("${ChatColor.GREEN}God mode enabled.")
                false -> sender.sendMessage("${ChatColor.RED}God mode disabled.")
            }
        } else {
            sender.sendMessage(Bukkit.permissionMessage())
        }

        return true
    }
}