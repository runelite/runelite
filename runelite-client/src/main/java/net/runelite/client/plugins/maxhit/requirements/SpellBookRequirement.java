package net.runelite.client.plugins.maxhit.requirements;

import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.maxhit.config.SpellBaseDamageConfig;

public class SpellBookRequirement implements Requirement {
    private final SpellBaseDamageConfig.SpellBook spellBook;

    public SpellBookRequirement(SpellBaseDamageConfig.SpellBook spellBook) {
        this.spellBook = spellBook;
    }

    @Override
    public boolean meetsRequirements(Client client) {
        int autoCastSpellId = client.getVar(Varbits.AUTO_CAST_SPELL);
        if(autoCastSpellId == 0) {
            return false;
        }

        SpellBaseDamageConfig autoCastSpell = SpellBaseDamageConfig.findSpellById(autoCastSpellId);
        return autoCastSpell.getSpellBook() == this.spellBook;
    }
}
