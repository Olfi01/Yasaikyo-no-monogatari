package de.crazypokemondev.yasaikyoNoMonogatari.items;

import java.util.List;
import java.util.UUID;

import de.crazypokemondev.yasaikyoNoMonogatari.lang.Strings;
import de.crazypokemondev.yasaikyoNoMonogatari.master.ModItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemQuestbook extends ModItem{

	public ItemQuestbook(String name, String oreName, CreativeTabs tab) {
		super(name, oreName, tab);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		NBTTagCompound nbt;
		if (stack.hasTagCompound()){
			nbt = stack.getTagCompound();
		}
		else{
			nbt = new NBTTagCompound();
		}
		UUID playerId = player.getUniqueID();
		if (nbt.hasKey("boundUUID")){
			if (playerId.toString() != nbt.getString("boundUUID")){
				//Quest book is bound to another player than the one who used it
				world.playSound(player.posX, player.posY, player.posZ, 
						"yasaikyonomonogatari:random.poof", 1, 0, false);
				return stack;
			}
		}
		else{
			//bind questbook to the player who used it
			nbt.setString("boundUUID", playerId.toString());
		}
		nbt.setString("boundPlayerName", player.getDisplayName());
		//open book here
		stack.setTagCompound(nbt);
		return stack;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lores, boolean b) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("boundPlayerName")){
			lores.add(I18n.format(Strings.BOUND_LORE, 
					EnumChatFormatting.GRAY + 
					stack.getTagCompound().getString("boundPlayerName")));
		}
		else lores.add(I18n.format(Strings.UNBOUND_LORE));
	}
}
