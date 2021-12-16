package com.monokaryon.fungicraft.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup FUNGICRAFT_GROUP = new ItemGroup("fungicraftModTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.SEAGRASS_POWDER.get());
        }
    };
}
