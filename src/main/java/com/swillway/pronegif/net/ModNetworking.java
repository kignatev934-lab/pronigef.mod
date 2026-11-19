package com.swillway.pronegif.net;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
public class ModNetworking {
    public static void registerServer() { PayloadTypeRegistry.playS2C().register(ProneStatePayload.TYPE, ProneStatePayload.CODEC); }
    public static void sendProneState(Entity entity, boolean prone) {
        var payload = new ProneStatePayload(entity.getId(), prone);
        for (ServerPlayer p : entity.level().getServer().getPlayerList().getPlayers()) ServerPlayNetworking.send(p, payload);
    }
}
