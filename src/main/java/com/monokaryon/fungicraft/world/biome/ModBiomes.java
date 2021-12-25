package com.monokaryon.fungicraft.world.biome;

import com.monokaryon.fungicraft.FungiCraft;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, FungiCraft.MOD_ID);

    private static Biome makeFungiForestBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder,
                                              float depth, float scale) {

    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
