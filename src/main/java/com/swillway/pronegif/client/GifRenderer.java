package com.swillway.pronegif.client;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import java.util.HashMap;
import java.util.Map;
public class GifRenderer {
    private static final Map<Integer, Boolean> PRONE = new HashMap<>();
    public static void setProne(int entityId, boolean prone) { PRONE.put(entityId, prone); }
    public static void render(WorldRenderContext context) {
        var client = Minecraft.getInstance();
        if (client.level == null) return;
        for (var entry : PRONE.entrySet()) {
            if (!entry.getValue()) continue;
            Entity entity = client.level.getEntity(entry.getKey());
            if (entity == null) continue;
        }
    }
}
