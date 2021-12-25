package com.monokaryon.fungicraft.world.biome;

import com.monokaryon.fungicraft.FungiCraft;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> FUNGI_FOREST = register("fungi_forest",
            SurfaceBuilder.SWAMP.configured(new SurfaceBuilderConfig(
                    Blocks.DIRT.defaultBlockState(),
                    Blocks.WATER.defaultBlockState(),
                    Blocks.COAL_ORE.defaultBlockState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(FungiCraft.MOD_ID, name), csb);
    }
}
