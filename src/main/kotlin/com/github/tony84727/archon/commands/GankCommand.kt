package com.github.tony84727.archon.commands

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.monster.EntityZombie
import net.minecraft.server.MinecraftServer

class GankCommand : CommandBase() {
    override fun getName(): String {
        return "gank"
    }

    override fun execute(server: MinecraftServer, sender: ICommandSender, args: Array<String>) {
        if (sender.entityWorld.isRemote) {
            return
        }
        for (i in 1..100) {
            val zombie = EntityZombie(sender.entityWorld);
            zombie.setPosition(sender.position.x.toDouble(), sender.position.y.toDouble(), sender.position.z.toDouble())
            sender.entityWorld.spawnEntity(zombie)
        }
    }

    override fun getUsage(sender: ICommandSender): String {
        return "實驗性指令，只有作者知道"
    }
}