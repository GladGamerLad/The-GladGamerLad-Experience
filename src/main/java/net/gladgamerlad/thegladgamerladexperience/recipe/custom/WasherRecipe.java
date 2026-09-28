package net.gladgamerlad.thegladgamerladexperience.recipe.custom;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.gladgamerlad.thegladgamerladexperience.recipe.ModRecipes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record WasherRecipe(Ingredient inputItem,
                           ItemStackTemplate output) implements Recipe<WasherRecipeInput> {
    public static final MapCodec<WasherRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(WasherRecipe::inputItem),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(WasherRecipe::output)
            ).apply(instance, WasherRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, WasherRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC,
                    WasherRecipe::inputItem,

                    ItemStackTemplate.STREAM_CODEC,
                    WasherRecipe::output,

                    WasherRecipe::new);


    @Override
    public boolean matches(WasherRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(WasherRecipeInput input) {
        return output.create().copy();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "Washing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<WasherRecipeInput>> getSerializer() {
        return ModRecipes.WASHER_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<WasherRecipeInput>> getType() {
        return ModRecipes.WASHER_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }
}