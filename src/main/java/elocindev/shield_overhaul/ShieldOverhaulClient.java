package elocindev.shield_overhaul;

import elocindev.shield_overhaul.entity.ShieldBashEntity;
import elocindev.shield_overhaul.event.ShieldInteraction;
import elocindev.shield_overhaul.registry.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class ShieldOverhaulClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        
        ShieldInteraction.bashingPacketRegistry();
    }
}
