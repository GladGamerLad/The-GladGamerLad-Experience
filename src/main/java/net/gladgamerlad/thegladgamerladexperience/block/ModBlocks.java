package net.gladgamerlad.thegladgamerladexperience.block;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.entity.custom.CrusherEntitiyBlock;
import net.gladgamerlad.thegladgamerladexperience.block.entity.custom.WasherEntityBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TheGladGamerLadExperience.MODID);

    public static final DeferredBlock<Block> CRUSHER = BLOCKS.register(
            "crusher",
            registryName -> new CrusherEntitiyBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(1.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> WASHER = BLOCKS.register(
            "washer",
            registryName -> new WasherEntityBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(1.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> CRUDE_IRON_ORE = BLOCKS.register(
            "crude_iron_ore",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(1.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> CRUDE_COPPER_ORE = BLOCKS.register(
            "crude_copper_ore",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(1.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> CRUDE_GOLD_ORE = BLOCKS.register(
            "crude_gold_ore",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(1.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
            ));
}
