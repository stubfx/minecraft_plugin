package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType
import org.bukkit.attribute.Attribute

object Superman : Command() {

    override fun commandType(): CommandType = CommandType.SUPERMAN

    override fun behavior(playerName: String, options: String?) {
        CommandRunner.forEachPlayer {
            it.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = 200.0
        }
        // let's fix it.
        Heal.forceRun(isSilent = true)
    }

}