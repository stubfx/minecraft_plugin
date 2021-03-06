package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType
import org.bukkit.entity.Bee
import org.bukkit.entity.EntityType


object Bees : Command() {

    override fun commandType(): CommandType = CommandType.BEES

    override fun defaultCoolDown(): Long {
        return 1000 * 300
    }

    override fun behavior(playerName: String, options: String?) {
        CommandRunner.forEachPlayer {
            for (i in 0..10) {
                val location = getCloseLocation(it.location, 5.0)
                val bee = location.world?.spawnEntity(location, EntityType.BEE) as Bee
                // nah, too many player names
                // bee.customName = playerName
                // bee.isCustomNameVisible = true
                bee.target = it
                bee.anger = 100000
            }
        }
    }

}