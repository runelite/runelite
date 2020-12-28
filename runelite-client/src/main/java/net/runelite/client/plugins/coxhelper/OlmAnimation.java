package net.runelite.client.plugins.coxhelper;

import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OlmAnimation
{
    UNKNOWN(-2),

    HEAD_RISING_1(7334),
    HEAD_RISING_2(7335),
    HEAD_MIDDLE(7336),
    HEAD_RIGHT(7337),
    HEAD_LEFT(7338),
    HEAD_MIDDLE_TO_RIGHT(7339),
    HEAD_RIGHT_TO_MIDDLE(7340),
    HEAD_MIDDLE_TO_LEFT(7341),
    HEAD_LEFT_TO_MIDDLE(7342),
    HEAD_LEFT_TO_RIGHT(7343),
    HEAD_RIGHT_TO_LEFT(7344),
    HEAD_AUTO_MIDDLE(7345),
    HEAD_AUTO_RIGHT(7346),
    HEAD_AUTO_LEFT(7347),
    HEAD_DYING(7348),

    LEFT_HAND_IDLE1(7355),
    LEFT_HAND_CRYSTALS1(7356),
    LEFT_HAND_HEAL1(7357),
    LEFT_HAND_LIGHTNING1(7358),
    LEFT_HAND_PORTALS1(7359),
    LEFT_HAND_CRIPPLING(7360),
    LEFT_HAND_CRIPPLED(7361),
    LEFT_HAND_UNCRIPPLING1(7362),
    LEFT_HAND_UNCRIPPLING2(7364),
    LEFT_HAND_IDLE2(7365),
    LEFT_HAND_CRYSTALS2(7366),
    LEFT_HAND_HEAL2(7367),
    LEFT_HAND_LIGHTNING2(7368),
    LEFT_HAND_PORTALS2(7369),
    LEFT_HAND_DYING(7370),

    HEAD_ENRAGED_AUTO_MIDDLE(7371),
    HEAD_ENRAGED_AUTO_LEFT(7372),
    HEAD_ENRAGED_AUTO_RIGHT(7373),
    HEAD_ENRAGED_MIDDLE(7374),
    HEAD_ENRAGED_LEFT(7375),
    HEAD_ENRAGED_RIGHT(7376),
    HEAD_ENRAGED_MIDDLE_TO_LEFT(7377),
    HEAD_ENRAGED_LEFT_TO_MIDDLE(7378),
    HEAD_ENRAGED_LEFT_TO_RIGHT(7379),
    HEAD_ENRAGED_RIGHT_TO_LEFT(7380),
    HEAD_ENRAGED_MIDDLE_TO_RIGHT(7381),
    HEAD_ENRAGED_RIGHT_TO_MIDDLE(7382),
    HEAD_ENRAGED_RISING_2(7383);


    private static final Map<Integer, OlmAnimation> LOOKUP = Maps.uniqueIndex(
            Arrays.asList(OlmAnimation.values()),
            OlmAnimation::getId
    );

    private final int id;

    public static OlmAnimation fromId(int id)
    {
        OlmAnimation animation = LOOKUP.get(id);
        if (animation == null)
        {
            return OlmAnimation.UNKNOWN;
        }
        return animation;
    }
}