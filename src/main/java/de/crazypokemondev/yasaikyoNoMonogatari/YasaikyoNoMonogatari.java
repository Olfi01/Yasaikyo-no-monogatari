package de.crazypokemondev.yasaikyoNoMonogatari;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.crazypokemondev.yasaikyoNoMonogatari.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import proxy.CommonProxy;

@Mod(modid = YasaikyoNoMonogatari.MODID, version = YasaikyoNoMonogatari.VERSION, 
	name = YasaikyoNoMonogatari.MODNAME)
public class YasaikyoNoMonogatari {
	public static final String MODID = "yasaikyonomonogatari";
	public static final String VERSION = "0.0.1";
	public static final String MODNAME = "Yasaikyo no Monogatari";
	
	@Instance
	public static YasaikyoNoMonogatari instance = new YasaikyoNoMonogatari();
	
	public static CreativeTabs customModTab = new CreativeTabs("tabYasaikyoNoMonogatari"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ModItems.QuestBook;
		}
		
		@Override
		public String getTabLabel() {
			return MODNAME;
		};
	};
	
	@SidedProxy(serverSide = "proxy.CommonProxy", 
			clientSide = "proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println(MODNAME + " preInit");
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		System.out.println(MODNAME + " Init");
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		System.out.println(MODNAME + " postInit");
		proxy.postInit();
	}
}
