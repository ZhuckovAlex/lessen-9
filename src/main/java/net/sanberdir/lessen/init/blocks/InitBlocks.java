package net.sanberdir.lessen.init.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.TreeInit;
import net.sanberdir.lessen.init.blocks.custom.FlameBlock;
import net.sanberdir.lessen.init.blocks.custom.FlameBlockRotate;
import net.sanberdir.lessen.init.blocks.custom.FlameLeaves;
import net.sanberdir.lessen.init.items.InitItems;
import net.sanberdir.lessen.init.items.ModItemsGroup;
import net.sanberdir.lessen.init.trees.CustomSaplingBlock;

import java.util.function.Supplier;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Lessen.MOD_ID);

    public static final RegistryObject<Block> BROWN_PLANKS = registerBlock("brown_planks",
            () -> new FlameBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE)
                    .hardnessAndResistance(2,5).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_LOG = registerBlock("brown_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROWN_WOOD = registerBlock("brown_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> STRIPPED_BROWN_LOG = registerBlock("stripped_brown_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_BROWN_WOOD = registerBlock("stripped_brown_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_LEAVES = BLOCKS.register("brown_leaves",
            () -> new FlameLeaves(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)
                    .hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).harvestTool(ToolType.HOE).notSolid()));

    public static final RegistryObject<Block> BROWN_SAPLING = BLOCKS.register("brown_sapling",
            () -> new CustomSaplingBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT), TreeInit.BROWN));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        InitItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemsGroup.MOD_BLOCKS)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
