package solutions.ferricyanide.messaround

import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}

class CommonProxy {
  def preInit(event: FMLPreInitializationEvent): Unit = {
    Messaround.logger.info("PREINIT from scala")
  }

  def init(event: FMLInitializationEvent): Unit = {
    Messaround.logger.info("INIT from scala")
  }

  def postInit(event: FMLInitializationEvent): Unit = {
    Messaround.logger.info("POSTINIT from scala")
  }
}
