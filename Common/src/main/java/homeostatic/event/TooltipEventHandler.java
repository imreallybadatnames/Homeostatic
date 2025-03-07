package homeostatic.event;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import homeostatic.common.TagManager;

public class TooltipEventHandler {

    public static void onItemToolTip(ItemStack itemStack, List<Component> toolTip) {
        if (itemStack.getItem() instanceof ArmorItem) {
            CompoundTag tags = itemStack.getTag();

            if ((tags != null && tags.contains("insulation")) || itemStack.is(TagManager.Items.INSULATED_ARMOR)) {
                toolTip.add((Component.translatable("tooltip.insulation")).withStyle(ChatFormatting.GRAY));
            }

            if ((tags != null && tags.contains("waterproof")) || itemStack.is(TagManager.Items.WATERPROOF_ARMOR)) {
                toolTip.add((Component.translatable("tooltip.waterproof")).withStyle(ChatFormatting.DARK_AQUA));
            }

            if ((tags != null && tags.contains("radiation_protection")) || itemStack.is(TagManager.Items.RADIATION_PROTECTED_ARMOR)) {
                toolTip.add((Component.translatable("tooltip.radiation_protection")).withStyle(ChatFormatting.GREEN));
            }

            if (tags != null && tags.contains("thermometer")) {
                toolTip.add((Component.translatable("tooltip.thermometer")).withStyle(ChatFormatting.GOLD));
            }
        }
    }

}