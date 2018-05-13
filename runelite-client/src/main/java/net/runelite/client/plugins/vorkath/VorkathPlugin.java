package net.runelite.client.plugins.vorkath;

import java.time.temporal.ChronoUnit;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Query;
import net.runelite.api.queries.NPCQuery;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
        name = "Vorkath"
)
public class VorkathPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private QueryRunner queryRunner;

    @Inject
    private VorkathOverlay overlay;

    private VorkathAttack attack;

    int vorkathAttackCounter = 7;
    String vorkathNextSpecial = "Unknown";
    private boolean vorkathHasAttacked = false;

    @Override
    public Overlay getOverlay()
    {
        return overlay;
    }

    @Schedule(
        period = 600,
        unit = ChronoUnit.MILLIS
    )

    public void update()
    {
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }

        NPC vorkath = findVorkath();
        if (vorkath != null)
        {
            if ((vorkath.getAnimation() == VorkathAttack.REGULAR.getAnimation() || vorkath.getAnimation() == VorkathAttack.TOSS.getAnimation()) && vorkathAttackCounter > 0 && !vorkathHasAttacked)
            {
                attack = VorkathAttack.REGULAR;
                vorkathAttackCounter--;
                vorkathHasAttacked = true;
            }
            else if (vorkath.getAnimation() == VorkathAttack.TOSS.getAnimation() && !vorkathHasAttacked)
            {
                attack = VorkathAttack.TOSS;
                vorkathAttackCounter = 7;
                vorkathNextSpecial = "Poison";
                vorkathHasAttacked = true;
            }
            else if (vorkath.getAnimation() == VorkathAttack.POISON.getAnimation())
            {
                attack = VorkathAttack.POISON;
                vorkathAttackCounter = 7;
                vorkathNextSpecial = "Ice";
            }
            else if (vorkath.getAnimation() == VorkathAttack.DEATH.getAnimation())
            {
                attack = VorkathAttack.DEATH;
                vorkathAttackCounter = 7;
                vorkathNextSpecial = "Unknown";
            }
            else
            {
                vorkathHasAttacked = false;
            }
        }
        else
        {
            attack = null;
        }
    }

    NPC findVorkath()
    {
        Query query = new NPCQuery().idEquals(8061);
        NPC[] result = queryRunner.runQuery(query);
        return result.length >= 1 ? result[0] : null;
    }

    VorkathAttack getAttack()
    {
        return attack;
    }

}