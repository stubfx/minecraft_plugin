package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType
import org.bukkit.potion.PotionEffectType


object OnTheMoon : Command() {

    override fun commandType(): CommandType = CommandType.MOONGRAVITY

    override fun behavior(playerName: String, options: String?) {
        val duration = ticks * 20
        val jump = PotionEffectType.JUMP.createEffect(duration, 50)
        val slowFalling = PotionEffectType.SLOW_FALLING.createEffect(duration, 50)
        CommandRunner.forEachPlayer {
            it.addPotionEffect(jump)
            it.addPotionEffect(slowFalling)
        }
    }

}