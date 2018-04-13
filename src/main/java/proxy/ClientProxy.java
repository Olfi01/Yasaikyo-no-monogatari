package proxy;

import de.crazypokemondev.yasaikyoNoMonogatari.gui.GuiQuestbook;
import net.minecraft.client.Minecraft;

public class ClientProxy extends CommonProxy{
	@Override
	public void openQuestbookGui() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiQuestbook());
	}
}
