package homeostatic.common.fluid;

import java.util.function.Consumer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;

import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.RegisterEvent;

public class ForgeFluidType {

    public static FluidType PURIFIED_WATER_TYPE;

    public static void initTypes(RegisterEvent.RegisterHelper<FluidType> registryHelper) {
        PURIFIED_WATER_TYPE = new FluidType(FluidType.Properties.create()
                .viscosity(1000)
                .lightLevel(3)
                .density(4000)
                .rarity(Rarity.UNCOMMON)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {

            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public ResourceLocation getStillTexture() {
                        return HomeostaticFluids.STILL_FLUID_TEXTURE;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return HomeostaticFluids.FLOWING_FLUID_TEXTURE;
                    }

                });
            }

        };

        registryHelper.register("purified_water_type", PURIFIED_WATER_TYPE);
    }

}
