package com.github.tony84727.archon

import com.github.tony84727.archon.extensions.isOP
import net.minecraft.entity.projectile.EntityArrow
import net.minecraft.init.Items
import net.minecraft.item.ItemArrow
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod.EventBusSubscriber
class EventListener {
    @SubscribeEvent
    fun onPlayerRightClick(event: PlayerInteractEvent.RightClickItem) {
        if (event.world.isRemote) {
            return
        }
        if (!event.entityPlayer.isOP()) {
            return
        }
        val tag = event.itemStack.getSubCompound("archon")
        if (tag != null) {
            if (tag.getString("type") == "arrowstorm") {
                val world = event.world
                val item = Items.ARROW as ItemArrow
                for (i in 1..40) {
                    val arrow = item.createArrow(world, event.itemStack, event.entityLiving)
                    arrow.pickupStatus = EntityArrow.PickupStatus.DISALLOWED
                    arrow.shoot(event.entityLiving, event.entityLiving.rotationPitch, event.entityLiving.rotationYaw, 0F, 1000F, 0.5F)
                    world.spawnEntity(arrow)
                }
            }
        }
    }
}