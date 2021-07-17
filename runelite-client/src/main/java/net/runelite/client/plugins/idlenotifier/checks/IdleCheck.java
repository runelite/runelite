package net.runelite.client.plugins.idlenotifier.checks;

import com.google.common.annotations.VisibleForTesting;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.Notifier;


public abstract class IdleCheck
{

    private final Notifier notifier;
    @VisibleForTesting
    @Getter(AccessLevel.PACKAGE)
    private boolean hasNotified = false;

    protected IdleCheck(Notifier notifier)
    {
        this.notifier = notifier;
    }

    protected abstract boolean internalIdleCheck();
    protected abstract String idleMessage();

    public void check()
    {
        boolean isIdle = internalIdleCheck();
        if (isIdle)
        {
            if (!hasNotified)
            {
                notifier.notify(idleMessage());
                hasNotified = true;
            }
        }
        else
        {
            hasNotified = false;
        }
    }

}
