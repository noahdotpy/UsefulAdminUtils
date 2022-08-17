package me.diligord.usefuladminutils.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FlyCommand: CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Must be executed as player.")
            return true
        }

        if (sender.hasPermission("userfuladminutils.fly")) {
            sender.allowFlight = !sender.allowFlight

            when(sender.allowFlight) {
                true -> sender.sendMessage("${ChatColor.GREEN}Fly enabled.")
                false -> sender.sendMessage("${ChatColor.RED}Fly disabled.")
            }
        } else {
            sender.sendMessage(Bukkit.permissionMessage())
        }

        return true
    }
}