package com.github.tony84727.archon

import com.github.tony84727.archon.commands.ArrowStormCommand
import com.github.tony84727.archon.commands.GankCommand
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent

@Mod(modid = Archon.MOD_ID, version = Archon.VERSION, acceptableRemoteVersions = "*")
class Archon {
    companion object {
        const val MOD_ID = "archon"
        const val VERSION = "0.0.0"
    }
    private val eventListener = EventListener()

    @Mod.EventHandler
    fun onPostInit(e: FMLPostInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(eventListener)
    }

    @Mod.EventHandler
    fun onServerStarting(e: FMLServerStartingEvent) {
        e.registerServerCommand(ArrowStormCommand())
        e.registerServerCommand(GankCommand())
    }

}