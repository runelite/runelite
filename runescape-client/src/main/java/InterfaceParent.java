import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("pd")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("clanChat")
	static ClanChat clanChat;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1870800307
	)
	@Export("idxCount")
	public static int idxCount;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1326721365
	)
	@Export("group")
	int group;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1502247593
	)
	@Export("type")
	int type;
	@ObfuscatedName("k")
	boolean field594;

	InterfaceParent() {
		this.field594 = false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Liz;",
		garbageValue = "101"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_normal, PlayerType.PlayerType_ironman, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_playerModerator};
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		signature = "(Lbi;IIII)V",
		garbageValue = "713738223"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (ByteArrayPool.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				int var7;
				if (var0.skillLevel == 0) {
					String var5 = var0.actions[0] + var0.username + var0.actions[1];
					var7 = var0.combatLevel;
					int var8 = ByteArrayPool.localPlayer.combatLevel;
					int var9 = var8 - var7;
					String var6;
					if (var9 < -9) {
						var6 = class297.colorStartTag(16711680);
					} else if (var9 < -6) {
						var6 = class297.colorStartTag(16723968);
					} else if (var9 < -3) {
						var6 = class297.colorStartTag(16740352);
					} else if (var9 < 0) {
						var6 = class297.colorStartTag(16756736);
					} else if (var9 > 9) {
						var6 = class297.colorStartTag(65280);
					} else if (var9 > 6) {
						var6 = class297.colorStartTag(4259584);
					} else if (var9 > 3) {
						var6 = class297.colorStartTag(8453888);
					} else if (var9 > 0) {
						var6 = class297.colorStartTag(12648192);
					} else {
						var6 = class297.colorStartTag(16776960);
					}

					var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var10;
				if (Client.isItemSelected == 1) {
					IgnoreList.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class297.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((AbstractWorldMapIcon.selectedSpellFlags & 8) == 8) {
						IgnoreList.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class297.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var10 = 7; var10 >= 0; --var10) {
						if (Client.playerMenuActions[var10] != null) {
							short var11 = 0;
							if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
								if (AttackOption.AttackOption_hidden == Client.playerAttackOption) {
									continue;
								}

								if (AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && var0.combatLevel > ByteArrayPool.localPlayer.combatLevel) {
									var11 = 2000;
								}

								if (ByteArrayPool.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == ByteArrayPool.localPlayer.team) {
										var11 = 2000;
									} else {
										var11 = 0;
									}
								}
							} else if (Client.playerOptionsPriorities[var10]) {
								var11 = 2000;
							}

							boolean var12 = false;
							var7 = Client.playerMenuOpcodes[var10] + var11;
							IgnoreList.insertMenuItemNoShift(Client.playerMenuActions[var10], class297.colorStartTag(16777215) + var4, var7, var1, var2, var3);
						}
					}
				}

				for (var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
					if (Client.menuOpcodes[var10] == 23) {
						Client.menuTargets[var10] = class297.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		signature = "([Lhe;IIIZI)V",
		garbageValue = "-1930613556"
	)
	@Export("resizeInterface")
	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				WorldMapAreaData.alignWidgetSize(var6, var2, var3, var4);
				WorldMapLabelSize.alignWidgetPosition(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					MouseHandler.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}
}
