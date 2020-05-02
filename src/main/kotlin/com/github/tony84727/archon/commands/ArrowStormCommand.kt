package com.github.tony84727.archon.commands

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.server.MinecraftServer

class ArrowStormCommand: CommandBase() {
    override fun getName(): String {
        return "arrowstorm"
    }

    override fun execute(server: MinecraftServer, sender: ICommandSender, args: Array<String>) {
        if (sender !is EntityPlayer) {
            return
        }
        val stack = ItemStack(Items.ARROW, 1)
        val tag = stack.getOrCreateSubCompound("archon")
        tag.setString("type", "arrowstorm")
        sender.inventory.add(1, stack)
    }

    override fun getUsage(sender: ICommandSender): String {
        return "實驗性指令，只有作者知道"
    }
}