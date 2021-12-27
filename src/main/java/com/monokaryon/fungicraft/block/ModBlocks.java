package com.monokaryon.fungicraft.block;

import com.monokaryon.fungicraft.FungiCraft;
import com.monokaryon.fungicraft.world.tree.HugeFrostyBonnet;
import com.monokaryon.fungicraft.world.tree.HugePixieParasol;
import com.monokaryon.fungicraft.item.ModItemGroup;
import com.monokaryon.fungicraft.item.ModItems;
import com.monokaryon.fungicraft.world.tree.HugeYellowlegBonnet;
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
                    () -> new Block((AbstractBlock.Properties.of(Material.WOOD).strength(2f).randomTicks()
                            .sound(SoundType.NETHER_WART).noOcclusion().jumpFactor(2f).lightLevel(BlockState -> 15))));

    public static final RegistryObject<Block> PIXIE_PARASOL_FUNGUS =
            registerBlock("pixie_parasol_fungus",
                    () -> new SaplingBlock(new HugePixieParasol(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));

    //Mycena Adscendens
    public static final RegistryObject<Block> FROSTY_BONNET_STEM =
            registerBlock("frosty_bonnet_stem",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_LOG))));

    public static final RegistryObject<Block> STRIPPED_FROSTY_BONNET_STEM =
            registerBlock("stripped_frosty_bonnet_stem",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG))));

    public static final RegistryObject<Block> FROSTY_BONNET_HYPHAE =
            registerBlock("frosty_bonnet_hyphae",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_WOOD))));

    public static final RegistryObject<Block> STRIPPED_FROSTY_BONNET_HYPHAE =
            registerBlock("stripped_frosty_bonnet_hyphae",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD))));

    public static final RegistryObject<Block> FROSTY_BONNET_PLANKS =
            registerBlock("frosty_bonnet_planks",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_PLANKS))));

    public static final RegistryObject<Block> FROSTY_BONNET_CAP =
            registerBlock("frosty_bonnet_cap",
                    () -> new Block((AbstractBlock.Properties.of(Material.WOOD).strength(2f).randomTicks()
                            .sound(SoundType.NETHER_WART).noOcclusion().jumpFactor(2f).lightLevel(BlockState -> 15))));

    public static final RegistryObject<Block> FROSTY_BONNET_FUNGUS =
            registerBlock("frosty_bonnet_fungus",
                    () -> new SaplingBlock(new HugeFrostyBonnet(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));

    //Mycena Epipterygia
    public static final RegistryObject<Block> YELLOWLEG_BONNET_STEM =
            registerBlock("yellowleg_bonnet_stem",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_LOG))));

    public static final RegistryObject<Block> STRIPPED_YELLOWLEG_BONNET_STEM =
            registerBlock("stripped_yellowleg_bonnet_stem",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG))));

    public static final RegistryObject<Block> YELLOWLEG_BONNET_HYPHAE =
            registerBlock("yellowleg_bonnet_hyphae",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_WOOD))));

    public static final RegistryObject<Block> STRIPPED_YELLOWLEG_BONNET_HYPHAE =
            registerBlock("stripped_yellowleg_bonnet_hyphae",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD))));

    public static final RegistryObject<Block> YELLOWLEG_BONNET_PLANKS =
            registerBlock("yellowleg_bonnet_planks",
                    () -> new RotatedPillarBlock((AbstractBlock.Properties.copy(Blocks.OAK_PLANKS))));

    public static final RegistryObject<Block> YELLOWLEG_BONNET_CAP =
            registerBlock("yellowleg_bonnet_cap",
                    () -> new Block((AbstractBlock.Properties.of(Material.WOOD).strength(2f).randomTicks()
                            .sound(SoundType.NETHER_WART).noOcclusion().jumpFactor(2f).lightLevel(BlockState -> 15))));

    public static final RegistryObject<Block> YELLOWLEG_BONNET_FUNGUS =
            registerBlock("frosty_bonnet_fungus",
                    () -> new SaplingBlock(new HugeYellowlegBonnet(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));

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
