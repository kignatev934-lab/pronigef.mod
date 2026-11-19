package com.swillway.pronegif.net;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import com.swillway.pronegif.ProneGifMod;
public record ProneStatePayload(int entityId, boolean prone) implements CustomPacketPayload {
    public static final Type<ProneStatePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ProneGifMod.MOD_ID, "prone_state"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ProneStatePayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ProneStatePayload::entityId, ByteBufCodecs.BOOL, ProneStatePayload::prone, ProneStatePayload::new);
    @Override public Type<? extends CustomPacketPayload> type() { return TYPE; }
}
