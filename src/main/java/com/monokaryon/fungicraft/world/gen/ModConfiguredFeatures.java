package com.monokaryon.fungicraft.world.gen;

import com.monokaryon.fungicraft.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.Random;

public class ModConfiguredFeatures {

    //Mycena Tree Configuration
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PIXIE_PARASOL =
            register("pixie_parasol", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.PIXIE_PARASOL_STEM.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.PIXIE_PARASOL_CAP.get().defaultBlockState()),
                            new BlobFoliagePlacer(FeatureSpread.fixed(4), FeatureSpread.fixed(0), 3),
                            new StraightTrunkPlacer(10, 2, 0),
                            new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

    //Trees Configuration
    public static final ConfiguredFeature<?, ?> TREES_PIXIE_PARASOL =
            register("trees_pixie_parasol", PIXIE_PARASOL.decorated(
                    Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA
                    .configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return (ConfiguredFeature) Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
