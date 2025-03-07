package homeostatic.integrations;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;

import homeostatic.Homeostatic;
import homeostatic.common.fluid.HomeostaticFluids;
import homeostatic.common.item.HomeostaticItems;
import homeostatic.platform.Services;
import homeostatic.util.WaterHelper;

public class WaterFilterRecipeMaker {

    public static List<CraftingRecipe> getFilterCraftingRecipes(String plugin) {
        List<CraftingRecipe> recipes = new ArrayList<>();
        Ingredient ingredient = Ingredient.of(HomeostaticItems.WATER_FILTER);
        ItemStack leatherFlaskBase = new ItemStack(HomeostaticItems.LEATHER_FLASK);
        ItemStack leatherFlask = WaterHelper.getFilledItem(
            leatherFlaskBase,
            HomeostaticFluids.PURIFIED_WATER,
            (int) Services.PLATFORM.getFluidCapacity(leatherFlaskBase)
        );
        String group = plugin + ".flask.filter";

        Ingredient baseFlaskIngredient = Ingredient.of(leatherFlaskBase.getItem());
        NonNullList<Ingredient> recipeInputs = NonNullList.of(Ingredient.EMPTY, baseFlaskIngredient, ingredient);

        recipes.add(new ShapelessRecipe(
            new ResourceLocation(Homeostatic.MODID, group + ".purified_leather_flask"),
            group,
            CraftingBookCategory.MISC,
            leatherFlask,
            recipeInputs
        ));

        return recipes;
    }

}
