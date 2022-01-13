package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.Main
import com.stubfx.plugin.chatreactor.commands.Command
import org.bukkit.Material

class Paint(main: Main, playerName: String) : Command(main, playerName) {

    override fun name(): String {
        return "paint"
    }

    override fun behavior() {
        val wool: Material = listOf(
            Material.WHITE_WOOL,
            Material.BLUE_WOOL,
            Material.RED_WOOL,
            Material.CYAN_WOOL,
            Material.GRAY_WOOL,
        ).random()
        startRecurrentTask {
            forEachPlayer {
                it.getTargetBlockExact(100)?.type = wool
            }
        }
    }

}