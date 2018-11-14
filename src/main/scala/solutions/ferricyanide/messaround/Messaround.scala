package solutions.ferricyanide.messaround

import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import org.apache.logging.log4j.Logger

@Mod(modid = Messaround.MOD_ID, name = Messaround.MOD_NAME, version = Messaround.MOD_VERSION, modLanguage = "scala")
object Messaround {

  final val MOD_ID = "messaround"
  final val MOD_NAME = "messaround"
  final val MOD_VERSION = "1.0"

  var logger: Logger = _

  @SidedProxy(clientSide = "solutions.ferricyanide.messaround.ClientProxy", serverSide = "solutions.ferricyanide.messaround.ServerProxy")
  var proxy: CommonProxy = _


  @Mod.EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    logger = event.getModLog
    proxy.preInit(event)
  }

  @Mod.EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    proxy.init(event)
  }
}
