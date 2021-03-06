package com.stubfx.plugin

import com.stubfx.plugin.chatreactor.ChatReactor
import com.stubfx.plugin.chatreactor.commands.CommandRunner
import com.stubfx.plugin.discord.DiscordModule
import com.stubfx.plugin.listeners.ChatListener
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin


class Main : JavaPlugin() {

    override fun onEnable() {
        DiscordModule.onEnable()
        ChatReactor.onEnable()
        // shall we start the chatReactor?
        if (ConfigManager.isChatReactorEnabled()) {
            getCommand("command")?.tabCompleter = CommandTabCompleter()
        }
        // is chat reactor enabled?
//        getCommand("clearchunk")?.tabCompleter = MaterialTabCompleter()
//        getCommand("sectionreplace")?.tabCompleter = MaterialTabCompleter()
        server.pluginManager.registerEvents(ChatListener(this), this)
//        server.pluginManager.registerEvents(EntityListener(this), this)
//        server.pluginManager.registerEvents(ProjectileListener(this), this)
        CommandRunner.setMainRef(this)
        BlockReplacer.setMainRef(this)
        PluginUtils.setMainRef(this)
    }

    fun getTicks(): Int {
        return 20
    }

    override fun onDisable() {
        ChatReactor.onDisable()
        DiscordModule.onDisable()
        ConfigManager.onDisable()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        ChatCommandExecutor.onCommand(sender, command, label, args)
        return true
    }

}