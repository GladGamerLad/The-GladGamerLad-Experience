package net.gladgamerlad.thegladgamerladexperience;

import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.gladgamerlad.thegladgamerladexperience.block.entity.ModBlockEntities;
import net.gladgamerlad.thegladgamerladexperience.item.ModCreativeModTabs;
import net.gladgamerlad.thegladgamerladexperience.item.ModItems;
import net.gladgamerlad.thegladgamerladexperience.menu.ModMenuTypes;
import net.gladgamerlad.thegladgamerladexperience.recipe.ModRecipes;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TheGladGamerLadExperience.MODID)
public class TheGladGamerLadExperience {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "thegladgamerladexperience";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public TheGladGamerLadExperience(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeModTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);
        ModRecipes.SERIALIZERS.register(modEventBus);
        ModRecipes.TYPES.register(modEventBus);
    }
}
