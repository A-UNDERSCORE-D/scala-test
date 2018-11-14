package solutions.ferricyanide.messaround

import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemBlock}
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent



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
}
