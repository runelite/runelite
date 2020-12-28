/*package net.runelite.client.plugins.coxhelper;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Player;

@Getter
class Victim
{
    private final Player player;
    private final Type type;
    private int ticks;

    Victim(Player player, Type type)
    {
        this.player = player;
        this.type = type;
        this.ticks = type.getTicks();
    }

    void updateTicks()
    {
        if (this.ticks > 0)
        {
            this.ticks--;
        }
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(player.getName(), type);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Victim victim = (Victim) o;
        return Objects.equals(player.getName(), victim.player.getName()) &&
                type == victim.type;
    }

    @AllArgsConstructor
    @Getter(AccessLevel.PACKAGE)
    enum Type
    {
        BURN(41),
        ACID(23),
        TELEPORT(10);

        private final int ticks;
    }
}*/
package net.runelite.client.plugins.coxhelper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Player;

@Getter(AccessLevel.PACKAGE)
class Victim
{
    private Player player;
    private Type type;
    private int ticks;

    Victim(Player player, Type type)
    {
        this.player = player;
        this.type = type;
        this.ticks = type.getTicks();
    }

    void updateTicks()
    {
        if (ticks > 0)
        {
            ticks--;
        }
    }

    @AllArgsConstructor
    @Getter(AccessLevel.PACKAGE)
    enum Type
    {
        BURN(41),
        ACID(23),
        TELEPORT(10);

        private int ticks;
    }
}