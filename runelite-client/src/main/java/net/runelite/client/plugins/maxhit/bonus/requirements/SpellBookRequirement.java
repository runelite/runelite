package net.runelite.client.plugins.maxhit.bonus.requirements;

import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.maxhit.config.SpellConfig;

public class SpellBookRequirement implements BonusRequirement {
    private final SpellConfig.SpellBook spellBook;

    public SpellBookRequirement(SpellConfig.SpellBook spellBook) {
        this.spellBook = spellBook;
    }

    @Override
    public boolean meetsRequirements(Client client) {
        int autoCastSpellId = client.getVar(Varbits.AUTO_CAST_SPELL);
        if(autoCastSpellId == 0) {
            return false;
        }

        SpellConfig autoCastSpell = SpellConfig.findSpellById(autoCastSpellId);
        return autoCastSpell.getSpellBook() == this.spellBook;
    }
}
