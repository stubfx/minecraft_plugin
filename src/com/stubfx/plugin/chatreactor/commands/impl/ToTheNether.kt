package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.PluginUtils
import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType

object ToTheNether : Command() {

    override fun commandType(): CommandType = CommandType.TOTHENETHER

    override fun defaultCoolDown(): Long {
        return 600*1000
    }

    override fun behavior(playerName: String, options: String?) {
        CommandRunner.forEachPlayer {
            PluginUtils.teleportToNether(it)
        }
    }

}