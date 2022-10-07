package com.originmint.nolag.mixins;

import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.World.class)
public class WorldMixin {

    @Inject(method = "checkLightFor", at = @At("HEAD"), cancellable = true)
    public void onCheckLightFor(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(lightType == EnumSkyBlock.SKY);
    }
}
