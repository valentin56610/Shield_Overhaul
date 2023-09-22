package elocindev.shield_overhaul.event;

import elocindev.shield_overhaul.registry.ServerPacketRegistry;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;

public class ShieldInteraction {
    public static void bashingPacketRegistry() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.options == null) return;

            ClientPlayerEntity player = client.player;
            KeyBinding attack = client.options.attackKey;

            if (attack.isPressed())  {
                if (player.isBlocking()) {
                    if (!player.getItemCooldownManager().isCoolingDown(player.getMainHandStack().getItem())) {
                        ClientPlayNetworking.send(ServerPacketRegistry.SHIELD_BASH_PACKET, PacketByteBufs.create());
                    }
                }
            }
        });
    }
}
