package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.PluginUtils
import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType

object ToTheOverworld : Command() {

    override fun commandType(): CommandType = CommandType.TOTHEOVERWORLD

    override fun defaultCoolDown(): Long {
        return 600*1000
    }

    override fun behavior(playerName: String, options: String?) {
        CommandRunner.forEachPlayer {
            PluginUtils.teleportToOverworld(it)
        }
    }

}