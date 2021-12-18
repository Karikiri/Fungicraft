package com.monokaryon.fungicraft.world.gen;

import com.monokaryon.fungicraft.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MYCENA_INTERRUPTA =
            register("mycena_interrupta", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.MYCENA_INTERRUPTA_STEM.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.MYCENA_INTERRUPTA_CAP.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                            new StraightTrunkPlacer(4, 2, 0),
                            new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return (ConfiguredFeature) Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
