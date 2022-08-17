package me.diligord.usefuladminutils.events

import me.diligord.usefuladminutils.UsefulAdminUtils
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinEvent(private val plugin: UsefulAdminUtils): Listener {

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val vanishedPlayers = plugin.vanishedPlayers
        for (vanishedPlayer in vanishedPlayers) {
            e.player.hidePlayer(plugin, vanishedPlayer)
        }

        return
    }

}
