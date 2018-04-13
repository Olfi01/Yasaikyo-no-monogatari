package de.crazypokemondev.yasaikyoNoMonogatari.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import de.crazypokemondev.yasaikyoNoMonogatari.YasaikyoNoMonogatari;
import de.crazypokemondev.yasaikyoNoMonogatari.master.ModItem;

@ObjectHolder(YasaikyoNoMonogatari.MODID)
public class ModItems {
	@ObjectHolder("questbook")
	public static ModItem QuestBook;
	
	public static void preInit(){
		System.out.println("[" + YasaikyoNoMonogatari.MODNAME + "] Loading items");
		register(new ItemQuestbook("questbook", null, YasaikyoNoMonogatari.customModTab));
	}
	
	private static void register(ModItem item){
		GameRegistry.registerItem(item, item.name);
		System.out.println("Registered " + item.name);
		item.initOreDict();
	}
}
