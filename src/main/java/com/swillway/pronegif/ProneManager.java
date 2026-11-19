package com.swillway.pronegif;
import net.minecraft.world.entity.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class ProneManager {
    private static final Map<UUID, Boolean> PRONE = new HashMap<>();
    public static boolean isProne(Entity entity) { return PRONE.getOrDefault(entity.getUUID(), false); }
    public static void setProne(Entity entity, boolean value) { PRONE.put(entity.getUUID(), value); }
}
