package com.swillway.pronegif.client;
import com.swillway.pronegif.net.ProneStatePayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
public class ProneGifClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {ClientPlayNetworking.registerGlobalReceiver(ProneStatePayload.TYPE, (payload, context) -> context.client().execute(() -> GifRenderer.setProne(payload.entityId(), payload.prone())));
        WorldRenderEvents.AFTER_ENTITIES.register(GifRenderer::render);
    }
}
