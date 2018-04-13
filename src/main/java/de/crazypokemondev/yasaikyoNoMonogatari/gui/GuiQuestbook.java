package de.crazypokemondev.yasaikyoNoMonogatari.gui;

import de.crazypokemondev.yasaikyoNoMonogatari.YasaikyoNoMonogatari;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiQuestbook extends GuiScreen{
	private ResourceLocation background;
	private final int backgroundImageWidth = 256;
	private final int backgroundImageHeight = 180;
	@Override
	public void initGui() {
		background = new ResourceLocation(YasaikyoNoMonogatari.MODID + 
				":textures/gui/questbook.png");
	}
	
	@Override
	public void updateScreen() {
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float p_73863_3_) {
		drawDefaultBackground();
		mc.getTextureManager().bindTexture(background);
		int offsetLeft = (width - backgroundImageWidth) / 2;
		int offsetTop = (height - backgroundImageHeight) / 2;
		drawTexturedModalRect(offsetLeft, offsetTop, 0, 0, backgroundImageWidth, backgroundImageHeight);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
}
