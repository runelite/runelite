package net.runelite.client.plugins.idlenotifier.checks;

import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.client.Notifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class IdleCheckTest
{

    @Mock
    @Bind
    private Notifier notifier;

    private final String idleMessage = "idle message";

    private IdleCheck underTest;

    @Before
    public void setUp() throws Exception
    {
        this.underTest = falseIdleCheck();
    }

    @Test
    public void idleMessage()
    {
        assertEquals("idle message", underTest.idleMessage());
    }

    @Test
    public void check()
    {
        // false check, no actions
        underTest.check();
        assertFalse(underTest.isHasNotified());

        // true check, notify and change hasNotified
        underTest = trueIdleCheck();
        underTest.check();
        assertTrue(underTest.isHasNotified());
        verify(notifier).notify(eq(idleMessage));

        //2nd check, true hasNotified, verify no notification
        underTest.check();
        assertTrue(underTest.isHasNotified());
        verifyNoMoreInteractions(notifier);
    }

    private IdleCheck falseIdleCheck()
    {
        return new IdleCheck(notifier)
        {
            @Override
            public boolean internalIdleCheck()
            {
                return false;
            }

            @Override
            public String idleMessage()
            {
                return idleMessage;
            }
        };
    }

    private IdleCheck trueIdleCheck()
    {
        return new IdleCheck(notifier)
        {
            @Override
            public boolean internalIdleCheck()
            {
                return true;
            }

            @Override
            public String idleMessage()
            {
                return idleMessage;
            }
        };
    }

}