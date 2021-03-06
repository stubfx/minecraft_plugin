package com.stubfx.plugin.chatreactor.commands.impl

import com.stubfx.plugin.chatreactor.commands.Command
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.chatreactor.commands.CommandType
import org.bukkit.potion.PotionEffectType

object Heal : Command() {

    override fun commandType(): CommandType = CommandType.HEAL

    override fun behavior(playerName: String, options: String?) {
        CommandRunner.forEachPlayer {
            val heal = PotionEffectType.HEAL.createEffect(ticks * 20, 50)
            it.addPotionEffect(heal)
        }
    }

}