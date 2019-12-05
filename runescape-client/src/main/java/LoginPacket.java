import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("LoginPacket")
public class LoginPacket implements class181 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final LoginPacket field2324;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	static final LoginPacket field2325;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final LoginPacket field2326;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	public static final LoginPacket field2328;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	static final LoginPacket field2327;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[Lgn;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 213981161
	)
	@Export("id")
	public final int id;

	static {
		field2324 = new LoginPacket(14, 0);
		field2325 = new LoginPacket(15, 4);
		field2326 = new LoginPacket(16, -2);
		field2328 = new LoginPacket(18, -2);
		field2327 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = new LoginPacket[]{field2325, field2326, field2328, field2327, field2324};
		LoginPacket[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			LoginPacket_indexedValues[var1[var2].id] = var1[var2];
		}

	}

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(Lih;IIII)V",
		garbageValue = "2018798075"
	)
	@Export("addNpcToMenu")
	static final void addNpcToMenu(NPCDefinition var0, int var1, int var2, int var3) {
		if (Client.menuOptionsCount < 400) {
			if (var0.transforms != null) {
				var0 = var0.transform();
			}

			if (var0 != null) {
				if (var0.isInteractable) {
					if (!var0.isFollower || Client.followerIndex == var1) {
						String var4 = var0.name;
						if (var0.combatLevel != 0) {
							var4 = var4 + GrandExchangeOfferWorldComparator.method77(var0.combatLevel, class215.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
						}

						if (var0.isFollower && Client.followerOpsLowPriority) {
							WorldMapSprite.insertMenuItemNoShift("Examine", class222.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							WorldMapSprite.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class222.colorStartTag(16776960) + var4, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((Actor.selectedSpellFlags & 2) == 2) {
								WorldMapSprite.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class222.colorStartTag(16776960) + var4, 8, var1, var2, var3);
							}
						} else {
							int var5 = var0.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var6 = var0.actions;
							int var7;
							int var8;
							if (var6 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
										var8 = 0;
										if (var7 == 0) {
											var8 = var5 + 9;
										}

										if (var7 == 1) {
											var8 = var5 + 10;
										}

										if (var7 == 2) {
											var8 = var5 + 11;
										}

										if (var7 == 3) {
											var8 = var5 + 12;
										}

										if (var7 == 4) {
											var8 = var5 + 13;
										}

										WorldMapSprite.insertMenuItemNoShift(var6[var7], class222.colorStartTag(16776960) + var4, var8, var1, var2, var3);
									}
								}
							}

							if (var6 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
										short var9 = 0;
										if (Client.npcAttackOption != AttackOption.AttackOption_hidden) {
											if (Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class215.localPlayer.combatLevel) {
												var9 = 2000;
											}

											var8 = 0;
											if (var7 == 0) {
												var8 = var9 + 9;
											}

											if (var7 == 1) {
												var8 = var9 + 10;
											}

											if (var7 == 2) {
												var8 = var9 + 11;
											}

											if (var7 == 3) {
												var8 = var9 + 12;
											}

											if (var7 == 4) {
												var8 = var9 + 13;
											}

											WorldMapSprite.insertMenuItemNoShift(var6[var7], class222.colorStartTag(16776960) + var4, var8, var1, var2, var3);
										}
									}
								}
							}

							if (!var0.isFollower || !Client.followerOpsLowPriority) {
								WorldMapSprite.insertMenuItemNoShift("Examine", class222.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "(Lhl;I)Ljava/lang/String;",
		garbageValue = "646735317"
	)
	static String method3662(Widget var0) {
		if (Client.method1655(MenuAction.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
