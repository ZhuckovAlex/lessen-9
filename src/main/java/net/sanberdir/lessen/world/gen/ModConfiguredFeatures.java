package net.sanberdir.lessen.world.gen;



import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.sanberdir.lessen.init.blocks.InitBlocks;

import java.util.OptionalInt;


public class ModConfiguredFeatures {


    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BROWN = register("brown",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(InitBlocks.BROWN_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(InitBlocks.BROWN_LEAVES.get().getDefaultState()),
                    new FancyFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(10, 15, 7),
                    new TwoLayerFeature(2, 2, 2,
                            OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));

        private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

}
