package net.gladgamerlad.thegladgamerladexperience.datagen;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperienceDataGen;
import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.gladgamerlad.thegladgamerladexperience.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider{
    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "The GladGamerLad Experience Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ModBlocks.CRUSHER.get())
                .pattern("III")
                .pattern("ICI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .group("crusher")
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.TOTEM_OF_JIMOTHY.get())
                .pattern("GCG")
                .pattern(" G ")
                .pattern(" G ")
                .define('G', Items.GOLD_INGOT)
                .define('C', ModItems.CRUSHED_EMERALD)
                .unlockedBy(getHasName(ModItems.CRUSHED_EMERALD), has(ModItems.CRUSHED_EMERALD))
                .group("totem of jimothy")
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.IRON_HAMMER.get())
                .pattern("ISI")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', Items.IRON_BLOCK)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                .group("hammer")
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.DIAMOND_HAMMER.get())
                .pattern("DSD")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', Items.DIAMOND_BLOCK)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK))
                .group("hammer")
                .save(output);

        shaped(RecipeCategory.MISC, ModBlocks.WASHER.get())
                .pattern("CCC")
                .pattern("CWC")
                .pattern("CCC")
                .define('C', Items.COPPER_INGOT)
                .define('W', ItemTags.WOOL)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .group("washer")
                .save(output);

        List<ItemLike> CRUSHED_RAW_IRON_SMELTABLES = List.of(ModItems.CRUSHED_RAW_IRON, ModBlocks.CRUDE_IRON_ORE);
        List<ItemLike> CRUSHED_RAW_COPPER_SMELTABLES = List.of(ModItems.CRUSHED_RAW_COPPER, ModBlocks.CRUDE_COPPER_ORE);
        List<ItemLike> CRUSHED_RAW_GOLD_SMELTABLES = List.of(ModItems.CRUSHED_RAW_GOLD, ModBlocks.CRUDE_GOLD_ORE);

        oreSmelting(CRUSHED_RAW_IRON_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, Items.IRON_INGOT, 0.25f, 200, "crushed raw iron");
        oreSmelting(CRUSHED_RAW_COPPER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, Items.COPPER_INGOT, 0.25f, 200, "crushed raw copper");
        oreSmelting(CRUSHED_RAW_GOLD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, Items.GOLD_INGOT, 0.25f, 200, "crushed raw gold");

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        // The base ingredient.
                        Ingredient.of(ModItems.DIAMOND_HAMMER),
                        // The addition ingredient.
                        this.tag(ItemTags.NETHERITE_TOOL_MATERIALS),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item. Note that while the recipe codec accepts an item stack template here, the builder does not.
                        // If you need an item stack template output, you need to use your own builder.
                        ModItems.NETHERITE_HAMMER.get()
                )
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                // This overload of #save allows us to specify a name.
                .save(this.output, "netherite_hammer_smithing");
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, TheGladGamerLadExperience.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
