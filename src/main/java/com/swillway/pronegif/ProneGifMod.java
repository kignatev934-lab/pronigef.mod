package com.swillway.pronegif;
import com.swillway.pronegif.net.ModNetworking;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ProneGifMod implements ModInitializer {
    public static final String MOD_ID = "pronegif";public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        ModNetworking.registerServer();
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (world.isClientSide() || player.isSpectator()) return InteractionResult.PASS;
            boolean newState = !ProneManager.isProne(entity);
            ProneManager.setProne(entity, newState);
            ModNetworking.sendProneState(entity, newState);
            return InteractionResult.SUCCESS;
        });
    }
}
