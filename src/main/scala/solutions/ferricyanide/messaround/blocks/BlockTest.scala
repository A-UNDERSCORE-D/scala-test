package solutions.ferricyanide.messaround.blocks

import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import solutions.ferricyanide.messaround.Messaround

object BlockTest extends BlockBase(Material.ROCK) {
  {
    this.setHardness(1)
    this.setRegistryName("test_block")
    this.setUnlocalizedName(s"${Messaround.MOD_ID}:test_block")
    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
  }
}
