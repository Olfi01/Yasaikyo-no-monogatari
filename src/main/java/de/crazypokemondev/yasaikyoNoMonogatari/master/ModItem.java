package de.crazypokemondev.yasaikyoNoMonogatari.master;

import de.crazypokemondev.yasaikyoNoMonogatari.YasaikyoNoMonogatari;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ModItem extends Item{
	public String name;
	public String oreDictName;
	
	public ModItem(String name, String oreName, CreativeTabs tab){
		this.name = name;
		setUnlocalizedName(name);
		setCreativeTab(tab);
		setTextureName(YasaikyoNoMonogatari.MODID + ":" + name);
		oreDictName = oreName;
	}
	
	public void initOreDict(){
		if (oreDictName != null) OreDictionary.registerOre(oreDictName, this);
	}
}
