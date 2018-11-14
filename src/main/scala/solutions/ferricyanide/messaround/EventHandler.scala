package solutions.ferricyanide.messaround

import net.minecraft.block.Block
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.item.{Item, ItemBlock}
import net.minecraft.util.math.AxisAlignedBB
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

import scala.collection.JavaConverters.asScalaBufferConverter

@Mod.EventBusSubscriber
object EventHandler {
  @SubscribeEvent
  def onBlockRegister(event: RegistryEvent.Register[Block]): Unit = {
    val registry = event.getRegistry
    for (block <- ModBlocks.blockList) {
      registry.register(block)
      Messaround.logger.info(s"Registering block $block")
    }
  }

  @SubscribeEvent
  def onItemRegister(event: RegistryEvent.Register[Item]): Unit = {
    val registry = event.getRegistry
    for (block <- ModBlocks.blockList) {
      val itemBlock = new ItemBlock(block)
      itemBlock.setRegistryName(block.getRegistryName)
      registry.register(itemBlock)
    }
  }

  @SubscribeEvent
  def onLivingHurt(event: LivingHurtEvent): Unit = {
    val attacked = event.getEntity
    val world = attacked.getEntityWorld

    if (!attacked.isInstanceOf[EntityPlayerMP]) {
      return
    }

    val area = new AxisAlignedBB(attacked.getPosition).expandXyz(64)
    val mobsInArea = world.getEntitiesWithinAABB(classOf[EntityLivingBase], area).asScala
    for (mob <- mobsInArea) {
      if (!mob.isInstanceOf[EntityPlayerMP]) {
        Messaround.logger.info(s"Throwing mob: $mob")
        mob.addVelocity(0, 20D, 0)
      }
    }
  }
}
