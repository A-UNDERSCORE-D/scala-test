package solutions.ferricyanide.messaround

import net.minecraftforge.fml.common.event.FMLInitializationEvent

class ServerProxy extends CommonProxy {
  override def init(event: FMLInitializationEvent) {
    super.init(event)
    Messaround.logger.info("Server proxy loaded")
  }
}
