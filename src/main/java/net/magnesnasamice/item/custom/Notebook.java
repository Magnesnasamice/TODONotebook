package net.magnesnasamice.item.custom;

import net.magnesnasamice.HUD.NotebookScreen;
import net.magnesnasamice.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Notebook extends Item {

    public Notebook(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            ItemStack stack = player.getStackInHand(hand);
            NbtCompound nbt = stack.getOrCreateNbt();
            boolean written = nbt.getInt("CustomModelData") == 1;

            if (written) {
                player.sendMessage(Text.literal("byl napisany"));
            } else {
                nbt.putInt("CustomModelData", 1);
                stack.setCustomName(Text.translatable("item.todonote.notebook_used"));

                player.sendMessage(Text.literal("napisano"));
            }

            //MinecraftClient.getInstance().setScreen(new NotebookScreen());
//            player.getItemCooldownManager().set(this, 60); // 60
            world.playSound(
                    null,
                    player.getBlockPos(),
                    ModSounds.NOTEBOOK_OPEN,
                    SoundCategory.PLAYERS,
                    1f, 1f
            );
        }
        return super.use(world, player, hand);
    }
}
