package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType
import org.bukkit.Material

object Paint : Command() {

    override fun commandType(): CommandType = CommandType.PAINT

    override fun behavior(playerName: String, options: String?) {
        val wool: Material = listOf(
            Material.WHITE_WOOL,
            Material.BLUE_WOOL,
            Material.RED_WOOL,
            Material.CYAN_WOOL,
            Material.GRAY_WOOL,
        ).random()
        CommandRunner.startRecurrentTask {
            CommandRunner.forEachPlayer {
                it.getTargetBlockExact(100)?.type = wool
            }
        }
    }

}