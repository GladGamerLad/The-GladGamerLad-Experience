package net.gladgamerlad.thegladgamerladexperience;

import net.gladgamerlad.thegladgamerladexperience.menu.ModMenuTypes;
import net.gladgamerlad.thegladgamerladexperience.menu.custom.CrusherScreen;
import net.gladgamerlad.thegladgamerladexperience.menu.custom.WasherScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = TheGladGamerLadExperience.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = TheGladGamerLadExperience.MODID, value = Dist.CLIENT)
public class TheGladGamerLadExperienceClient {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.CRUSHER_MENU.get(), CrusherScreen::new);
        event.register(ModMenuTypes.WASHER_MENU.get(), WasherScreen::new);
    }
}
