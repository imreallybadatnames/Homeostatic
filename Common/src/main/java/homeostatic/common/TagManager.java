package homeostatic.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

import homeostatic.Homeostatic;

public final class TagManager {

    public static final class Items {

        public static final TagKey<Item> INSULATION = create("insulation");
        public static final TagKey<Item> RADIATION_PROTECTION = create("radiation_protection");
        public static final TagKey<Item> WATERPROOF = create("waterproof");
        public static final TagKey<Item> FRUITS = createForge("fruits");
        public static final TagKey<Item> INSULATED_ARMOR = create("insulated_armor");
        public static final TagKey<Item> RADIATION_PROTECTED_ARMOR = create("radiation_protected_armor");
        public static final TagKey<Item> WATERPROOF_ARMOR = create("waterproof_armor");

        private static TagKey<Item> create(String id) {
            return TagKey.create(Registries.ITEM, identifier(id));
        }

        private static TagKey<Item> createForge(String id) {
            return TagKey.create(Registries.ITEM, new ResourceLocation("forge", id));
        }

    }

    public static final class Fluids {

        public static final TagKey<Fluid> PURIFIED_WATER = create("purified_water");

        private static TagKey<Fluid> create(String id) {
            return TagKey.create(Registries.FLUID, identifier(id));
        }

    }

    public static ResourceLocation identifier(String path) {
        return Homeostatic.loc(path);
    }

}