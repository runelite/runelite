package net.runelite.client.plugins.alfred.api.task;

import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBank;

public class BankTasks {

    public void walkToBank(boolean nearest) {
    }

    public void open(RSBank rsBank) {
        Alfred.setStatus("Opening bank");

        if (rsBank == null) {
            return;
        }

        if (rsBank.getClickbox() == null) {
            return;
        }

        if (rsBank.getClickbox().getBounds() == null) {
            return;
        }

        if (rsBank.getWorldLocation() == null) {
            return;
        }

        if (Alfred.api.banks().isOpen()) {
            return;
        }

        Alfred.api.camera().lookAt(rsBank.getWorldLocation());
        Alfred.getMouse().rightClick(rsBank.getClickbox().getBounds());

        boolean foundAction = Alfred.sleepUntil(() -> Alfred.api.menu().getMenu().hasAction("bank"), 200, 2000);
        if (!foundAction) {
            return;
        }

        Alfred.api.menu().getMenu().clickAction("bank");

        boolean openedBank = Alfred.sleepUntil(() -> Alfred.api.banks().isOpen(), 200, 1000 * 10);
        if (!openedBank) {
            return;
        }

        Alfred.setStatus("Opened bank");
    }

    public void close() {
    }

}
