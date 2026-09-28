package net.gladgamerlad.thegladgamerladexperience.item;

import com.jcraft.jorbis.Block;
import net.gladgamerlad.thegladgamerladexperience.TheGladGamerLadExperience;
import net.gladgamerlad.thegladgamerladexperience.block.ModBlocks;
import net.gladgamerlad.thegladgamerladexperience.food.ModFoodProperties;
import net.gladgamerlad.thegladgamerladexperience.item.custom.HammerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheGladGamerLadExperience.MODID);

    public static final DeferredItem<Item> CRUSHED_RAW_IRON= ITEMS.registerItem(
            "crushed_raw_iron",
            Item::new,
            props -> props
    );

    public static final DeferredItem<Item> CRUSHED_RAW_COPPER= ITEMS.registerItem(
            "crushed_raw_copper",
            Item::new,
            props -> props
    );

    public static final DeferredItem<Item> CRUSHED_RAW_GOLD= ITEMS.registerItem(
            "crushed_raw_gold",
            Item::new,
            props -> props
    );

    public static final DeferredItem<Item> TOTEM_OF_JIMOTHY= ITEMS.registerItem(
            "totem_of_jimothy",
            Item::new,
            props -> props.food(ModFoodProperties.TOTEM_OF_JIMOTHY, ModFoodProperties.TOTEM_OF_JIMOTHY_EFFECT)
    );

    public static final DeferredItem<Item> CRUSHED_EMERALD= ITEMS.registerItem(
            "crushed_emerald",
            Item::new,
            props -> props
    );

    public static final DeferredItem<Item> HAMMER= ITEMS.registerItem(
            "hammer",
            HammerItem::new,
            props -> props.pickaxe(ToolMaterial.IRON, 7f, -3.4f)
    );


    public static  final  DeferredItem<BlockItem> CRUSHER = ITEMS.registerSimpleBlockItem(ModBlocks.CRUSHER);
}
