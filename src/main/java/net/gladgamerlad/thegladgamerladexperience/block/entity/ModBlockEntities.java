package net.gladgamerlad.thegladgamerladexperience.block.entity;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.gladgamerlad.thegladgamerladexperience.block.entity.custom.CrusherBlockEntity;
import net.gladgamerlad.thegladgamerladexperience.block.entity.custom.WasherBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, TheGladGamerLadExperience.MODID);

    public static final Supplier<BlockEntityType<CrusherBlockEntity>> CRUSHER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "crusher_block_entity",
            // The block entity type.
            () -> new BlockEntityType<>(
                    // The supplier to use for constructing the block entity instances.
                    CrusherBlockEntity::new,
                    // An optional value that, when true, only allows players with OP permissions
                    // to load NBT data (e.g. placing a block item)
                    false,
                    // A vararg of blocks that can have this block entity.
                    // This assumes the existence of the referenced blocks as DeferredBlock<Block>s.
                    ModBlocks.CRUSHER.get()
            )
    );

    public static final Supplier<BlockEntityType<WasherBlockEntity>> WASHER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "washer_block_entity",
            // The block entity type.
            () -> new BlockEntityType<>(
                    // The supplier to use for constructing the block entity instances.
                    WasherBlockEntity::new,
                    // An optional value that, when true, only allows players with OP permissions
                    // to load NBT data (e.g. placing a block item)
                    false,
                    // A vararg of blocks that can have this block entity.
                    // This assumes the existence of the referenced blocks as DeferredBlock<Block>s.
                    ModBlocks.WASHER.get()
            )
    );
}
