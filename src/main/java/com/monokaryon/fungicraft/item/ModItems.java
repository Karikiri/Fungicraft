package com.monokaryon.fungicraft.item;

import com.monokaryon.fungicraft.FungiCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FungiCraft.MOD_ID);

    public static final RegistryObject<Item> SEAGRASS_POWDER = ITEMS.register("seagrass_powder",
            () -> new Item(new Item.Properties().tab(ModItemGroup.FUNGICRAFT_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
