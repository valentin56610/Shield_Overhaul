package elocindev.shield_overhaul.networking;

import elocindev.shield_overhaul.ShieldOverhaul;
import elocindev.shield_overhaul.entity.ShieldBashEntity;
import elocindev.shield_overhaul.registry.ClientPacketRegistry;
import elocindev.shield_overhaul.registry.ServerPacketRegistry;
import elocindev.shield_overhaul.util.MathUtils;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;

public class ParryEffectC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
            for (ServerPlayerEntity target : PlayerLookup.tracking((ServerWorld)player.getWorld(), new ChunkPos((int)player.getPos().x / 16, (int)player.getPos().z / 16))) {
                ServerPlayNetworking.send(target, ClientPacketRegistry.PARRY_EFFECT_S2C_PACKET, PacketByteBufs.create().writeUuid(player.getUuid()));
            }

            /*
            Vec3d velocityVector = MathUtils.getLookingVec(player, 1.5f);
            player.addVelocity(velocityVector.x, velocityVector.y, velocityVector.z);
            player.velocityModified = true;

             */
        }
}