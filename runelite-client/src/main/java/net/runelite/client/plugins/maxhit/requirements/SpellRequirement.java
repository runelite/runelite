package net.runelite.client.plugins.maxhit.requirements;

import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.maxhit.config.SpellBaseDamageConfig;

public class SpellRequirement implements Requirement {
    private final SpellBaseDamageConfig spellBaseDamageConfig;

    public SpellRequirement(SpellBaseDamageConfig spellBaseDamageConfig) {
        this.spellBaseDamageConfig = spellBaseDamageConfig;
    }

    @Override
    public boolean meetsRequirements(Client client) {
        int autoCastSpellId = client.getVar(Varbits.AUTO_CAST_SPELL);
        if(autoCastSpellId == 0) {
            return false;
        }

        return autoCastSpellId == this.spellBaseDamageConfig.getSpellID();
    }
}
