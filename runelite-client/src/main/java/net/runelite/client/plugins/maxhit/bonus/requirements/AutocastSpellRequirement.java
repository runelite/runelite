package net.runelite.client.plugins.maxhit.bonus.requirements;

import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.maxhit.config.SpellConfig;

import java.util.ArrayList;

public class AutocastSpellRequirement implements BonusRequirement {
    private ArrayList<SpellConfig> autocastSpells;

    public AutocastSpellRequirement(ArrayList<SpellConfig> autocastSpells) {
        this.autocastSpells = autocastSpells;
    }

    @Override
    public boolean meetsRequirements(Client client) {
        int autoCastSpellId = client.getVar(Varbits.AUTO_CAST_SPELL);
        if(autoCastSpellId == 0) {
            return false;
        }

        return this.autocastSpells.stream().anyMatch(spell -> spell.getSpellID() == autoCastSpellId);
    }
}
