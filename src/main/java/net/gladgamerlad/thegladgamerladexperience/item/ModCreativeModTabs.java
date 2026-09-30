package net.gladgamerlad.thegladgamerladexperience.item;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheGladGamerLadExperience.MODID);

    public static final Supplier<CreativeModeTab> THE_GLADGAMERLAD_EXPERIENCE_TAB = CREATIVE_MODE_TABS.register("the_gladgamerlad_experience_tab", () -> CreativeModeTab.builder()
            //Set the title of the tab. Don't forget to add a translation!
            .title(Component.translatable("itemGroup." + TheGladGamerLadExperience.MODID + ".the_gladgamerlad_experience_tab"))
            //Set the icon of the tab.
            .icon(() -> new ItemStack(ModBlocks.CRUSHER.get()))
            //Add your items to the tab.
            .displayItems((params, output) -> {
                output.accept(ModItems.CRUSHED_RAW_IRON.get());
                output.accept(ModItems.CRUSHED_RAW_COPPER.get());
                output.accept(ModItems.CRUSHED_RAW_GOLD.get());
                output.accept(ModItems.TOTEM_OF_JIMOTHY.get());
                output.accept(ModItems.CRUSHED_EMERALD.get());
                output.accept(ModItems.IRON_HAMMER.get());
                output.accept(ModItems.DIAMOND_HAMMER.get());
                output.accept(ModItems.NETHERITE_HAMMER.get());

                output.accept(ModBlocks.CRUSHER.get());
                output.accept(ModBlocks.WASHER.get());
                output.accept(ModBlocks.CRUDE_IRON_ORE.get());
                output.accept(ModBlocks.CRUDE_COPPER_ORE.get());
                output.accept(ModBlocks.CRUDE_GOLD_ORE.get());
            })
            .build()
    );
}
