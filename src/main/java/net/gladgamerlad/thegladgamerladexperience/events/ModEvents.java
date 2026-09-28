package net.gladgamerlad.thegladgamerladexperience.events;

import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.entity.ModBlockEntities;
import net.gladgamerlad.thegladgamerladexperience.block.entity.custom.CrusherBlockEntity;
import net.gladgamerlad.thegladgamerladexperience.block.entity.custom.WasherBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = TheGladGamerLadExperience.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.Item.BLOCK, ModBlockEntities.CRUSHER_BLOCK_ENTITY.get(), CrusherBlockEntity::getItemHandler);
        event.registerBlockEntity(Capabilities.Item.BLOCK, ModBlockEntities.WASHER_BLOCK_ENTITY.get(), WasherBlockEntity::getItemHandler);
    }
}
