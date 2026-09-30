package net.gladgamerlad.thegladgamerladexperience.datagen;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.gladgamerlad.thegladgamerladexperience.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    // Get parameters from one of the `GatherDataEvent`s.
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TheGladGamerLadExperience.MODID);
    }

    // Add your tag entries here.
    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        // Create a TagAppender of registry objects for our tag. This could also be e.g. a vanilla or NeoForge tag.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRUSHER.get())
                .add(ModBlocks.WASHER.get())
                .add(ModBlocks.CRUDE_IRON_ORE.get())
                .add(ModBlocks.CRUDE_COPPER_ORE.get())
                .add(ModBlocks.CRUDE_GOLD_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CRUDE_IRON_ORE.get())
                .add(ModBlocks.CRUDE_COPPER_ORE.get())
                .add(ModBlocks.CRUDE_GOLD_ORE.get());
    }
}