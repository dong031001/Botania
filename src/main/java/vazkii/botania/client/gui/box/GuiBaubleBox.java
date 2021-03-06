/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [25/11/2015, 19:59:11 (GMT)]
 */
package vazkii.botania.client.gui.box;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import vazkii.botania.client.lib.LibResources;

public class GuiBaubleBox extends ContainerScreen<ContainerBaubleBox> {

	private static final ResourceLocation texture = new ResourceLocation(LibResources.GUI_BAUBLE_BOX);

	public GuiBaubleBox(ContainerBaubleBox container, PlayerInventory player, ITextComponent title) {
		super(container, player, title);
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		blit(guiLeft, guiTop, 0, 0, xSize, ySize);

		for(int i1 = 0; i1 < 7; ++i1) {
			Slot slot = container.inventorySlots.get(i1);
			if(slot.getHasStack() && slot.getSlotStackLimit() == 1)
				blit(guiLeft+slot.xPos, guiTop+slot.yPos, 200, 0, 16, 16);
		}
	}

}
