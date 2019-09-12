import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("q")
	static String[] field3096;
	@ObfuscatedName("w")
	static String field3101;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive")
	Archive archive;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1552948799
	)
	@Export("crc")
	int crc;
	@ObfuscatedName("t")
	@Export("padding")
	byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Liz;",
		garbageValue = "1206500813"
	)
	@Export("getEnum")
	public static EnumDefinition getEnum(int var0) {
		EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = EnumDefinition.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumDefinition.EnumDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(Lby;IIIB)V",
		garbageValue = "-27"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (Varps.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				int var7;
				if (var0.skillLevel == 0) {
					String var5 = var0.actions[0] + var0.username + var0.actions[1];
					var7 = var0.combatLevel;
					int var8 = Varps.localPlayer.combatLevel;
					int var9 = var8 - var7;
					String var6;
					if (var9 < -9) {
						var6 = UserComparator7.colorStartTag(16711680);
					} else if (var9 < -6) {
						var6 = UserComparator7.colorStartTag(16723968);
					} else if (var9 < -3) {
						var6 = UserComparator7.colorStartTag(16740352);
					} else if (var9 < 0) {
						var6 = UserComparator7.colorStartTag(16756736);
					} else if (var9 > 9) {
						var6 = UserComparator7.colorStartTag(65280);
					} else if (var9 > 6) {
						var6 = UserComparator7.colorStartTag(4259584);
					} else if (var9 > 3) {
						var6 = UserComparator7.colorStartTag(8453888);
					} else if (var9 > 0) {
						var6 = UserComparator7.colorStartTag(12648192);
					} else {
						var6 = UserComparator7.colorStartTag(16776960);
					}

					var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var10;
				if (Client.isItemSelected == 1) {
					FontName.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + UserComparator7.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((BuddyRankComparator.selectedSpellFlags & 8) == 8) {
						FontName.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + UserComparator7.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var10 = 7; var10 >= 0; --var10) {
						if (Client.playerMenuActions[var10] != null) {
							short var11 = 0;
							if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
								if (Client.playerAttackOption == AttackOption.AttackOption_hidden) {
									continue;
								}

								if (Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > Varps.localPlayer.combatLevel) {
									var11 = 2000;
								}

								if (Varps.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == Varps.localPlayer.team) {
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
							FontName.insertMenuItemNoShift(Client.playerMenuActions[var10], UserComparator7.colorStartTag(16777215) + var4, var7, var1, var2, var3);
						}
					}
				}

				for (var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
					if (Client.menuOpcodes[var10] == 23) {
						Client.menuTargets[var10] = UserComparator7.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}
}
