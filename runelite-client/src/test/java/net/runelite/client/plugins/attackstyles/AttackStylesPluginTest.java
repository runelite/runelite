/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.attackstyles;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.ParamID;
import net.runelite.api.Skill;
import net.runelite.api.StructComposition;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.Notification;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AttackStylesPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ClientThread clientThread;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	AttackStylesConfig attackConfig;

	@Mock
	@Bind
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	Notifier notifier;

	@Inject
	AttackStylesPlugin attackPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		doAnswer(a ->
		{
			final Runnable r = a.getArgument(0);
			r.run();
			return null;
		}).when(clientThread).invokeLater(any(Runnable.class));

		final int TYPE_ENUM_ID = 1;
		final int[] STYLE_STRUCT_IDS = {2, 3, 4, 5};
		final String[] STYLE_NAME = {"Accurate", "Aggressive", "Controlled", "Defensive"};
		EnumComposition stylesEnum = mock(EnumComposition.class);
		when(stylesEnum.getIntValue(4)).thenReturn(TYPE_ENUM_ID);

		EnumComposition typeEnum = mock(EnumComposition.class);
		when(typeEnum.getIntVals()).thenReturn(STYLE_STRUCT_IDS);

		EnumComposition empty = mock(EnumComposition.class);
		when(empty.getIntVals()).thenReturn(new int[0]);

		when(client.getEnum(EnumID.WEAPON_STYLES)).thenReturn(stylesEnum);
		when(client.getEnum(TYPE_ENUM_ID)).thenReturn(typeEnum);
		when(client.getEnum(0)).thenReturn(empty);

		int i = 0;
		for (int styleStructId : STYLE_STRUCT_IDS)
		{
			StructComposition s = mock(StructComposition.class);
			when(s.getStringValue(ParamID.ATTACK_STYLE_NAME)).thenReturn(STYLE_NAME[i++]);

			when(client.getStructComposition(styleStructId)).thenReturn(s);
		}

		when(attackConfig.warningNotification()).thenReturn(Notification.OFF);
	}

	/*
	 * Verify that red text is displayed when attacking with a style that gains experience
	 * in one of the unwanted skills.
	 */
	@Test
	public void testWarning()
	{
		ConfigChanged warnForAttackEvent = new ConfigChanged();
		warnForAttackEvent.setGroup("attackIndicator");
		warnForAttackEvent.setKey("warnForAttack");
		warnForAttackEvent.setNewValue("true");
		attackPlugin.onConfigChanged(warnForAttackEvent);

		// Verify there is a warned skill
		Set<Skill> warnedSkills = attackPlugin.getWarnedSkills();
		assertTrue(warnedSkills.contains(Skill.ATTACK));

		// Setup attack in style that gives attack xp
		when(client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE)).thenReturn(4);
		when(client.getVarpValue(VarPlayer.ATTACK_STYLE)).thenReturn(AttackStyle.ACCURATE.ordinal());

		// verify that earning xp in a warned skill will display red text on the widget
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayer.ATTACK_STYLE);
		attackPlugin.onVarbitChanged(varbitChanged);

		assertTrue(attackPlugin.isWarnedSkillSelected());

		attackPlugin.onGameTick(new GameTick());
		verify(notifier).notify(any(Notification.class), eq("Attack style changed to Accurate!"));

		// Switch to attack style that doesn't give attack xp
		when(client.getVarpValue(VarPlayer.ATTACK_STYLE)).thenReturn(AttackStyle.AGGRESSIVE.ordinal());

		// Verify the widget will now display white text
		attackPlugin.onVarbitChanged(varbitChanged);
		warnedSkills = attackPlugin.getWarnedSkills();
		assertTrue(warnedSkills.contains(Skill.ATTACK));
		assertFalse(attackPlugin.isWarnedSkillSelected());
	}

	/*
	 * Verify that attack style widgets are hidden when filtered with the AttackStylesPlugin.
	 */
	@Test
	public void testHiddenWidget()
	{
		ConfigChanged warnForAttackEvent = new ConfigChanged();
		warnForAttackEvent.setGroup("attackIndicator");
		warnForAttackEvent.setKey("warnForAttack");
		warnForAttackEvent.setNewValue("true");
		lenient().when(attackConfig.warnForAttack()).thenReturn(true);
		attackPlugin.onConfigChanged(warnForAttackEvent);

		// Set up mock widgets for atk and str attack styles
		Widget atkWidget = mock(Widget.class);
		Widget strWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.COMBAT_STYLE_ONE)).thenReturn(atkWidget);
		when(client.getWidget(ComponentID.COMBAT_STYLE_TWO)).thenReturn(strWidget);
		// Set widgets to return their hidden value in widgetsToHide when isHidden() is called
		when(atkWidget.isHidden()).thenAnswer(x -> isAtkHidden());
		when(strWidget.isHidden()).thenAnswer(x -> isStrHidden());

		// equip type_4 weapon type on player
		when(client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE)).thenReturn(4);
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.EQUIPPED_WEAPON_TYPE);
		attackPlugin.onVarbitChanged(varbitChanged);

		// Verify there is a warned skill
		Set<Skill> warnedSkills = attackPlugin.getWarnedSkills();
		assertTrue(warnedSkills.contains(Skill.ATTACK));

		// Enable hiding widgets
		ConfigChanged hideWidgetEvent = new ConfigChanged();
		hideWidgetEvent.setGroup("attackIndicator");
		hideWidgetEvent.setKey("removeWarnedStyles");
		hideWidgetEvent.setNewValue("true");
		when(attackConfig.removeWarnedStyles()).thenReturn(true);
		attackPlugin.onConfigChanged(hideWidgetEvent);

		// verify that the accurate attack style widget is hidden
		assertTrue(atkWidget.isHidden());

		// add another warned skill
		ConfigChanged warnForStrengthEvent = new ConfigChanged();
		warnForStrengthEvent.setGroup("attackIndicator");
		warnForStrengthEvent.setKey("warnForStrength");
		warnForStrengthEvent.setNewValue("true");
		lenient().when(attackConfig.warnForStrength()).thenReturn(true);
		attackPlugin.onConfigChanged(warnForStrengthEvent);

		// verify that the aggressive attack style widget is now hidden
		assertTrue(strWidget.isHidden());

		// disable hiding attack style widgets
		hideWidgetEvent.setGroup("attackIndicator");
		hideWidgetEvent.setKey("removeWarnedStyles");
		hideWidgetEvent.setNewValue("false");
		when(attackConfig.removeWarnedStyles()).thenReturn(false);
		attackPlugin.onConfigChanged(hideWidgetEvent);

		// verify that the aggressive and accurate attack style widgets are no longer hidden
		assertFalse(attackPlugin.getHiddenWidgets().get(4,
			ComponentID.COMBAT_STYLE_ONE));
		assertFalse(attackPlugin.getHiddenWidgets().get(4,
			ComponentID.COMBAT_STYLE_THREE));
	}

	private boolean isAtkHidden()
	{
		if (attackPlugin.getHiddenWidgets().size() == 0)
		{
			return false;
		}
		return attackPlugin.getHiddenWidgets().get(4, ComponentID.COMBAT_STYLE_ONE);
	}

	private boolean isStrHidden()
	{
		if (attackPlugin.getHiddenWidgets().size() == 0)
		{
			return false;
		}
		return attackPlugin.getHiddenWidgets().get(4, ComponentID.COMBAT_STYLE_TWO);
	}
}