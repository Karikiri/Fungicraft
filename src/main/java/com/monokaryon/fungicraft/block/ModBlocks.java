package com.monokaryon.fungicraft.block;

import com.monokaryon.fungicraft.FungiCraft;
import com.monokaryon.fungicraft.world.tree.PixieParasolTree;
import com.monokaryon.fungicraft.item.ModItemGroup;
import com.monokaryon.fungicraft.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
    public static final RegistryObject<Block> PIXIE_PARASOL_STEM =
            registerBlock("pixie_parasol_stem",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_LOG))));

    public static final RegistryObject<Block> STRIPPED_PIXIE_PARASOL_STEM =
            registerBlock("stripped_pixie_parasol_stem",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG))));

    public static final RegistryObject<Block> PIXIE_PARASOL_HYPHAE =
            registerBlock("pixie_parasol_hyphae",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_WOOD))));

    public static final RegistryObject<Block> STRIPPED_PIXIE_PARASOL_HYPHAE =
            registerBlock("stripped_pixie_parasol_hyphae",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD))));

    public static final RegistryObject<Block> PIXIE_PARASOL_PLANKS =
            registerBlock("pixie_parasol_planks",
            () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_PLANKS))));

    public static final RegistryObject<Block> PIXIE_PARASOL_CAP =
            registerBlock("pixie_parasol_cap",
            () -> new Block((AbstractBlock.Properties.of(Material.WOOD).strength(2f)
                    .randomTicks().sound(SoundType.NETHER_WART).noOcclusion())));

    public static final RegistryObject<Block> PIXIE_PARASOL_SAPLING =
            registerBlock("pixie_parasol_sapling",
            () -> new SaplingBlock(new PixieParasolTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));

    //When register a block, register an item simultaneously
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.FUNGICRAFT_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
