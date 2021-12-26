package com.monokaryon.fungicraft.world.biome;

import com.monokaryon.fungicraft.FungiCraft;
import com.monokaryon.fungicraft.world.gen.ModConfiguredFeatures;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, FungiCraft.MOD_ID);

    public static final RegistryObject<Biome> MYCENA_FOREST = BIOMES.register("mycena_forest",
            () -> makeMycenaForestBiome(() -> ModConfiguredSurfaceBuilders.MYCENA_FOREST_SURFACE, 0.5f, 0.05f));

    private static Biome makeMycenaForestBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder,
                                              float depth, float scale) {

        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);

        //Mob
        DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 7, 10));
        mobspawninfo$builder.addSpawn(EntityClassification.CREATURE,
                new MobSpawnInfo.Spawners(EntityType.FOX, 10, 0, 1));
        DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);


        //Structure
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);

        //Plants
        DefaultBiomeFeatures.addForestFlowers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addBerryBushes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultGrass(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addMountainTrees(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.TREES_PIXIE_PARASOL);
        //DefaultBiomeFeatures.addBirchTrees(biomegenerationsettings$builder);

        //testing
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.FOREST)
                .depth(depth).scale(scale).temperature(0.7F).downfall(0.8F)
                .specialEffects((new BiomeAmbience.Builder()).waterColor(6920692).waterFogColor(12237047)
                        .fogColor(12237047).skyColor(13677305).grassColorOverride(11858412)
                        .ambientParticle(new ParticleEffectAmbience(ParticleTypes.UNDERWATER, 0.003f))
                        .backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_GAME))
                        .build())
                .mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
