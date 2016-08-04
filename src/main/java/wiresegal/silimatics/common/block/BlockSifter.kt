package wiresegal.silimatics.common.block

import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import wiresegal.silimatics.common.lib.LibNames
import wiresegal.zenmodelloader.common.block.base.BlockMod
import wiresegal.zenmodelloader.common.block.base.ItemModBlock

/**
 * Created by Elad on 8/4/2016.
 */
class BlockSifter : BlockMod(LibNames.SIFTER, Material.WOOD) {
    override fun onBlockActivated(worldIn: World?, pos: BlockPos?, state: IBlockState?, playerIn: EntityPlayer?, hand: EnumHand?, heldItem: ItemStack?, side: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        if(heldItem != null && heldItem.item == Item.getItemFromBlock(Blocks.SAND)) {
            heldItem.stackSize--
            if(heldItem.stackSize <= 0) playerIn?.inventory?.deleteStack(heldItem)
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ)
    }

    override fun createItemForm(): ItemBlock? {
        return ItemModBlock(this)
    }
}