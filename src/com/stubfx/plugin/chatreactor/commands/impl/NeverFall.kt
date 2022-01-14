package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.Main
import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType
import org.bukkit.Material

class NeverFall(main: Main) : Command(main) {

    override fun commandName(): CommandType = CommandType.NEVERFALL

    override fun behavior(playerName: String, options: String?) {
        CommandRunner.startRecurrentTask {
            forEachPlayer {
                it.location.subtract(0.0, 1.0, 0.0).block.type = Material.ORANGE_WOOL
            }
        }
    }

}