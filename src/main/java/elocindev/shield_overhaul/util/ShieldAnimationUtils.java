package elocindev.shield_overhaul.util;

import dev.kosmx.playerAnim.api.firstPerson.FirstPersonMode;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.modifier.SpeedModifier;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import elocindev.shield_overhaul.ShieldOverhaul;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class ShieldAnimationUtils {
    private static SpeedModifier PARRY_SPEED = new SpeedModifier(2.0f);
    private static SpeedModifier BASH_SPEED = new SpeedModifier(2.2f);

    public static void playShieldAnimation(PlayerEntity user, String animation) {
        if (user != null) {
            var animationContainer = ((IShieldAnimatedPlayer)user).shield_overhaul_getModAnimation();
            KeyframeAnimation anim = PlayerAnimationRegistry.getAnimation(new Identifier(ShieldOverhaul.MODID, animation));
            var builder = anim.mutableCopy();
            anim = builder.build();
            animationContainer.addModifierLast(animation.contains("bash") ? BASH_SPEED : PARRY_SPEED);
            animationContainer.setAnimation(new KeyframeAnimationPlayer(anim).setFirstPersonMode(FirstPersonMode.THIRD_PERSON_MODEL));
        }
    }
}
