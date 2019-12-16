import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class30 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	static final class30 field246;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lak;"
	)
	static final class30 field251;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 864715249
	)
	static int field245;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1588163073
	)
	@Export("graphicsTickTimeIdx")
	static int graphicsTickTimeIdx;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1815334447
	)
	@Export("value")
	final int value;

	static {
		field246 = new class30(0);
		field251 = new class30(1);
	}

	class30(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(ILkg;Lif;B)V",
		garbageValue = "-8"
	)
	static void method543(int var0, ArchiveDisk var1, Archive var2) {
		byte[] var3 = null;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			for (ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
				if ((long)var0 == var5.key && var1 == var5.archiveDisk && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}

		if (var3 != null) {
			var2.load(var1, var0, var3, true);
		} else {
			byte[] var4 = var1.read(var0);
			var2.load(var1, var0, var4, true);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "972731925"
	)
	public static boolean method542(int var0) {
		return (var0 >> 30 & 1) != 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Lfc;",
		garbageValue = "14"
	)
	public static Clock method540() {
		try {
			return new NanoClock();
		} catch (Throwable var1) {
			return new MilliClock();
		}
	}

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		signature = "(Lbn;IIII)V",
		garbageValue = "-1992004658"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (Message.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				int var7;
				if (var0.skillLevel == 0) {
					String var5 = var0.actions[0] + var0.username + var0.actions[1];
					var7 = var0.combatLevel;
					int var8 = Message.localPlayer.combatLevel;
					int var9 = var8 - var7;
					String var6;
					if (var9 < -9) {
						var6 = NPC.colorStartTag(16711680);
					} else if (var9 < -6) {
						var6 = NPC.colorStartTag(16723968);
					} else if (var9 < -3) {
						var6 = NPC.colorStartTag(16740352);
					} else if (var9 < 0) {
						var6 = NPC.colorStartTag(16756736);
					} else if (var9 > 9) {
						var6 = NPC.colorStartTag(65280);
					} else if (var9 > 6) {
						var6 = NPC.colorStartTag(4259584);
					} else if (var9 > 3) {
						var6 = NPC.colorStartTag(8453888);
					} else if (var9 > 0) {
						var6 = NPC.colorStartTag(12648192);
					} else {
						var6 = NPC.colorStartTag(16776960);
					}

					var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var10;
				if (Client.isItemSelected == 1) {
					class1.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + NPC.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((ReflectionCheck.selectedSpellFlags & 8) == 8) {
						class1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + NPC.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var10 = 7; var10 >= 0; --var10) {
						if (Client.playerMenuActions[var10] != null) {
							short var11 = 0;
							if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
								if (Client.playerAttackOption == AttackOption.AttackOption_hidden) {
									continue;
								}

								if (Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > Message.localPlayer.combatLevel) {
									var11 = 2000;
								}

								if (Message.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == Message.localPlayer.team) {
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
							class1.insertMenuItemNoShift(Client.playerMenuActions[var10], NPC.colorStartTag(16777215) + var4, var7, var1, var2, var3);
						}
					}
				}

				for (var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
					if (Client.menuOpcodes[var10] == 23) {
						Client.menuTargets[var10] = NPC.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}
}
