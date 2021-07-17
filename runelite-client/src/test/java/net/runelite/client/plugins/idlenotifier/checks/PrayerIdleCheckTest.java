package net.runelite.client.plugins.idlenotifier.checks;

import com.google.inject.testing.fieldbinder.Bind;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.client.Notifier;
import net.runelite.client.plugins.idlenotifier.IdleNotifierConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrayerIdleCheckTest {

    @Mock
    @Bind
    private Notifier notifier;
    @Mock
    @Bind
    private Client client;
    @Mock
    @Bind
    private IdleNotifierConfig config;

    private PrayerIdleCheck underTest;

    @Before
    public void setUp() throws Exception
    {
        underTest = new PrayerIdleCheck(notifier, config, client);
        when(config.getPrayerThreshold()).thenReturn(70);
        when(config.getPrayerTimeThreshold()).thenReturn(70);
        when(client.getRealSkillLevel(eq(Skill.PRAYER))).thenReturn(99);
        when(client.getBoostedSkillLevel(eq(Skill.PRAYER))).thenReturn(99);
        // for 1:1 drain rate per second
        when(client.isPrayerActive(eq(Prayer.PIETY))).thenReturn(true);
        when(client.isPrayerActive(eq(Prayer.STEEL_SKIN))).thenReturn(true);
    }

    @Test
    public void internalIdleCheck()
    {
        //both disabled
        when(config.getPrayerThreshold()).thenReturn(0);
        when(config.getPrayerTimeThreshold()).thenReturn(0);
        assertFalse(underTest.internalIdleCheck());

        when(config.getPrayerThreshold()).thenReturn(20);
        when(client.getBoostedSkillLevel(eq(Skill.PRAYER))).thenReturn(10);
        assertTrue(underTest.internalIdleCheck());

        when(config.getPrayerThreshold()).thenReturn(0);
        when(config.getPrayerTimeThreshold()).thenReturn(20);
        assertTrue(underTest.internalIdleCheck());

        when(config.getPrayerThreshold()).thenReturn(30);
        assertTrue(underTest.internalIdleCheck());
    }

    @Test
    public void testIsLowPrayerPoints()
    {
        // disabled config
        when(config.getPrayerThreshold()).thenReturn(0);
        assertFalse(underTest.isLowPrayerPoints().test(null));
        verify(config, times(1)).getPrayerThreshold();
        clearInvocations(client, config);

        // 60/60 prayer w/ 70 threshold
        when(config.getPrayerThreshold()).thenReturn(70);
        when(client.getRealSkillLevel(eq(Skill.PRAYER))).thenReturn(60);
        assertFalse(underTest.isLowPrayerPoints().test(null));
        verify(config, times(2)).getPrayerThreshold();
        clearInvocations(client, config);

        // 99/99 prayer w/ 70 threshold
        when(client.getRealSkillLevel(eq(Skill.PRAYER))).thenReturn(99);
        when(client.getBoostedSkillLevel(eq(Skill.PRAYER))).thenReturn(99);
        assertFalse(underTest.isLowPrayerPoints().test(null));
        verify(config, times(3)).getPrayerThreshold();
        verify(client, times(1)).getRealSkillLevel(eq(Skill.PRAYER));
        verify(client, times(1)).getBoostedSkillLevel(eq(Skill.PRAYER));
        clearInvocations(client, config);

        // 69/99 prayer w/ 70 threshold
        when(config.getPrayerThreshold()).thenReturn(70);
        when(client.getRealSkillLevel(eq(Skill.PRAYER))).thenReturn(99);
        when(client.getBoostedSkillLevel(eq(Skill.PRAYER))).thenReturn(69);
        assertTrue(underTest.isLowPrayerPoints().test(null));
        verify(config, times(3)).getPrayerThreshold();
        verify(client, times(1)).getRealSkillLevel(eq(Skill.PRAYER));
        verify(client, times(1)).getBoostedSkillLevel(eq(Skill.PRAYER));
        clearInvocations(client, config);
    }

    @Test
    public void testIsLowPrayerTimeLeft()
    {
        // disabled config
        when(config.getPrayerTimeThreshold()).thenReturn(0);
        assertFalse(underTest.isLowPrayerTimeLeft().test(null));
        verify(config, times(1)).getPrayerTimeThreshold();
        clearInvocations(client, config);

        // 99/99 prayer w/ 45 second threshold
        when(config.getPrayerTimeThreshold()).thenReturn(45);
        assertFalse(underTest.isLowPrayerTimeLeft().test(null));
        verify(config, times(2)).getPrayerTimeThreshold();
        verify(client, times(1)).getBoostedSkillLevel(eq(Skill.PRAYER));
        verify(client).isPrayerActive(Prayer.PIETY);
        verify(client).isPrayerActive(Prayer.STEEL_SKIN);
        clearInvocations(client, config);

        // 40/99 prayer w/ 45 second threshold
        when(client.getBoostedSkillLevel(eq(Skill.PRAYER))).thenReturn(40);
        assertTrue(underTest.isLowPrayerTimeLeft().test(null));
        verify(config, times(2)).getPrayerTimeThreshold();
        verify(client, times(1)).getBoostedSkillLevel(eq(Skill.PRAYER));
        clearInvocations(client, config);
    }

    @Test
    public void testIdleMessage()
    {
        assertEquals("You have low prayer!", underTest.idleMessage());
    }

}