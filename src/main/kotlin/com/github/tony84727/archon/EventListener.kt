package com.github.tony84727.archon

import net.minecraftforge.event.ServerChatEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod.EventBusSubscriber
class EventListener {
    companion object {
        @SubscribeEvent
        fun onChat(e: ServerChatEvent) {
        }
    }
}