package net.magnesnasamice.HUD;

import com.mojang.blaze3d.systems.RenderSystem;
import net.magnesnasamice.Init;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;

public class NotebookScreen extends Screen {
    private static final Identifier NOTEBOOK_TEXTURE = new Identifier(Init.MOD_ID, "textures/gui/notebook_paper.png");
    public NotebookScreen() {
        super(Text.of("Notebook"));
    }

    @Override
    public Text getTitle() {
        return Text.of("Notebook");
    }

    @Override
    protected void init() {
        super.init();

        MinecraftClient.getInstance().player.sendMessage(Text.literal("opened screen"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, NOTEBOOK_TEXTURE);

        context.drawTexture(NOTEBOOK_TEXTURE, 10 ,10, 0, 0, width, height);
    }
}
