package com.swillway.pronegif.client;
import net.minecraft.resources.ResourceLocation;
import com.swillway.pronegif.ProneGifMod;
public class GifFrames {
    private static final ResourceLocation[] FRAMES = new ResourceLocation[] {
            ResourceLocation.fromNamespaceAndPath(ProneGifMod.MOD_ID, "textures/gif/hand/frame_0.png")
    };
    public static ResourceLocation getFrame(int tick) { return FRAMES[0]; }
}
