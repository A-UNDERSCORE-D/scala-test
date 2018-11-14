package solutions.ferricyanide.messaround

import net.minecraftforge.fml.common.event.FMLInitializationEvent

class ClientProxy extends CommonProxy() {
  override def init(event: FMLInitializationEvent): Unit = {
    super.init(event)
    Messaround.logger.info("Client proxy loaded.")
  }
}
