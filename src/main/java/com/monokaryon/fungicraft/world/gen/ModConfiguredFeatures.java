package com.monokaryon.fungicraft.world.gen;

import com.google.common.collect.ImmutableList;
import com.monokaryon.fungicraft.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;


public class ModConfiguredFeatures {

    //Huge Mycena Configuration
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PIXIE_PARASOL =
            register("pixie_parasol", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.PIXIE_PARASOL_STEM.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.PIXIE_PARASOL_CAP.get().defaultBlockState()),
                            //radius | offset | height
                            new BlobFoliagePlacer(FeatureSpread.of(10,5), FeatureSpread.fixed(0), 3),
                            //baseHeight | heightRandA | heightRandB
                            new StraightTrunkPlacer(10, 5, 0),
                            //limit | lowerSize | upperSize
                            new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FROSTY_BONNET =
            register("frosty_bonnet", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.FROSTY_BONNET_STEM.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.FROSTY_BONNET_CAP.get().defaultBlockState()),
                            new BlobFoliagePlacer(FeatureSpread.of(5,2), FeatureSpread.fixed(0), 3),
                            new StraightTrunkPlacer(10, 2, 0),
                            new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> Yellowleg_BONNET =
            register("yellowleg_bonnet", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.YELLOWLEG_BONNET_STEM.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.YELLOWLEG_BONNET_CAP.get().defaultBlockState()),
                            new BlobFoliagePlacer(FeatureSpread.of(10,5), FeatureSpread.fixed(0), 3),
                            new StraightTrunkPlacer(45, 20, 0),
                            new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Trees Configuration
    public static final ConfiguredFeature<?, ?> HUGE_MYCENA_FUNGI =
            register("huge_mycena_fungi", Feature.RANDOM_SELECTOR.configured(
                    new MultipleRandomFeatureConfig(
                            ImmutableList.of(
                                    Yellowleg_BONNET.weighted(0.2F),
                                    FROSTY_BONNET.weighted(0.2F)),
                            PIXIE_PARASOL))
                            .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                            .decorated(Placement.COUNT_EXTRA.configured(
                                    //count | extraChance | extraCount
                                    new AtSurfaceWithExtraConfig(5, 0.3F, 1))));

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Single Trees Sample
    /*public static final ConfiguredFeature<?, ?> TREES_PIXIE_PARASOL =
            register("trees_pixie_parasol", PIXIE_PARASOL.decorated(
                    Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA
                    .configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));*/


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return (ConfiguredFeature) Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
