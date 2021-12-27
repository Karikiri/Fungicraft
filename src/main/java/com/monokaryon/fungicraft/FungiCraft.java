package com.monokaryon.fungicraft;

import com.google.common.collect.ImmutableMap;
import com.monokaryon.fungicraft.block.ModBlocks;
import com.monokaryon.fungicraft.item.ModItems;
import com.monokaryon.fungicraft.world.biome.BiomeRegistry;
import com.monokaryon.fungicraft.world.gen.ModBiomeGenaration;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FungiCraft.MOD_ID)
public class FungiCraft
{
    public static final String MOD_ID = "fungicraft";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public FungiCraft() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        BiomeRegistry.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    .put(ModBlocks.PIXIE_PARASOL_STEM.get(),
                            ModBlocks.STRIPPED_PIXIE_PARASOL_STEM.get())
                    .put(ModBlocks.PIXIE_PARASOL_HYPHAE.get(),
                            ModBlocks.STRIPPED_PIXIE_PARASOL_HYPHAE.get()).build();

            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    .put(ModBlocks.FROSTY_BONNET_STEM.get(),
                            ModBlocks.STRIPPED_FROSTY_BONNET_STEM.get())
                    .put(ModBlocks.FROSTY_BONNET_HYPHAE.get(),
                            ModBlocks.STRIPPED_FROSTY_BONNET_HYPHAE.get()).build();

            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    .put(ModBlocks.YELLOWLEG_BONNET_STEM.get(),
                            ModBlocks.STRIPPED_YELLOWLEG_BONNET_STEM.get())
                    .put(ModBlocks.YELLOWLEG_BONNET_HYPHAE.get(),
                            ModBlocks.STRIPPED_YELLOWLEG_BONNET_HYPHAE.get()).build();

            ModBiomeGenaration.generateBiomes();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            //Mycena Renderring
            RenderTypeLookup.setRenderLayer(ModBlocks.PIXIE_PARASOL_CAP.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.PIXIE_PARASOL_STEM.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.PIXIE_PARASOL_FUNGUS.get(), RenderType.cutout());

            RenderTypeLookup.setRenderLayer(ModBlocks.FROSTY_BONNET_CAP.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.FROSTY_BONNET_STEM.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.FROSTY_BONNET_FUNGUS.get(), RenderType.cutout());

            RenderTypeLookup.setRenderLayer(ModBlocks.YELLOWLEG_BONNET_CAP.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.YELLOWLEG_BONNET_STEM.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.YELLOWLEG_BONNET_FUNGUS.get(), RenderType.cutout());
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo(FungiCraft.MOD_ID, "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
