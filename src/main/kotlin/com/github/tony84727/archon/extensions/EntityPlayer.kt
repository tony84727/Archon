package com.github.tony84727.archon.extensions

import net.minecraft.entity.player.EntityPlayer

fun EntityPlayer.isOP(): Boolean {
    val server = this.server ?: return false
    return server.playerList.oppedPlayerNames.contains(name)
}