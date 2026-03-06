package com.bernardo.dbi.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Classe base para todos os Dragon Blocks.
 * Permite faces independentes com renderização customizável.
 */
public class DragonBlockBase extends Block {

    // Se true, o bloco dará drop mesmo quando quebrado com a mão
    protected boolean allowHandDrops = false;

    public DragonBlockBase() {
        // Propriedades padrão para os dragon blocks
        super(Properties.of()
            .strength(2.0f, 10.0f)  // Dureza e resistência à explosão
            .requiresCorrectToolForDrops()
        );
    }

    /**
     * Configura se o bloco deve dropar quando quebrado com a mão.
     * @param allow true para dropar mesmo sem ferramenta
     * @return this (encadeável)
     */
    public DragonBlockBase setAllowHandDrops(boolean allow) {
        this.allowHandDrops = allow;
        return this;
    }

    /**
     * Verifica se o bloco deve dar drop quando quebrado com a mão.
     */
    public boolean allowHandDrops() {
        return this.allowHandDrops;
    }

    /**
     * Retorna ENTITY para permitir renderização customizada via renderer.
     */
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    /**
     * Permite que o bloco seja renderizado com faces transparentes/customizadas.
     * Retorna false para que o Minecraft use o renderer customizado.
     */
    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    /**
     * Define que o bloco é opaco para fins de renderização.
     */
    @Override
    public float getShadeBrightness(BlockState state, net.minecraft.world.level.BlockGetter level, net.minecraft.core.BlockPos pos) {
        return 1.0f;
    }

    /**
     * Garante que todos os Dragon Blocks soltem a si mesmos ao serem quebrados,
     * ignorando tabelas de loot padrão (por exemplo, grama virando dirt).
     */
    @Override
    public java.util.List<net.minecraft.world.item.ItemStack> getDrops(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
        // retorno simples contendo um itemstack deste bloco
        return java.util.Collections.singletonList(new net.minecraft.world.item.ItemStack(this));
    }
}
