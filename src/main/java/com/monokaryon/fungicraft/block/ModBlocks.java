package com.monokaryon.fungicraft.block;

import com.monokaryon.fungicraft.FungiCraft;
import com.monokaryon.fungicraft.item.ModItemGroup;
import com.monokaryon.fungicraft.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, FungiCraft.MOD_ID);

    //Soil Registry

    //Mycena Interrupta Block Registry
    public static final RegistryObject<Block> MYCENA_INTERRUPTA_STEM = registerBlock("mycena_interrupta_stem",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.from(Blocks.CRIMSON_STEM))));

    public static final RegistryObject<Block> STRIPPED_MYCENA_INTERRUPTA_STEM = registerBlock("stripped_mycena_interrupta_stem",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.from(Blocks.STRIPPED_CRIMSON_STEM))));

    public static final RegistryObject<Block> MYCENA_INTERRUPTA_HYPHAE = registerBlock("mycena_interrupta_hyphae",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.from(Blocks.CRIMSON_HYPHAE))));

    public static final RegistryObject<Block> STRIPPED_MYCENA_INTERRUPTA_HYPHAE = registerBlock("stripped_mycena_interrupta_hyphae",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.from(Blocks.STRIPPED_CRIMSON_HYPHAE))));

    public static final RegistryObject<Block> MYCENA_INTERRUPTA_PLANKS = registerBlock("mycena_interrupta_planks",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.from(Blocks.CRIMSON_PLANKS))));

    //When register a block, register an item simultaneously
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.FUNGICRAFT_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
