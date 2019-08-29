import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class51 {
	@ObfuscatedName("s")
	@Export("applet")
	static Applet applet;
	@ObfuscatedName("j")
	static String field404;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive7")
	static Archive archive7;

	static {
		applet = null;
		field404 = "";
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)Ljava/lang/String;",
		garbageValue = "700500119"
	)
	public static String method845(Buffer var0) {
		String var1;
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > 32767) {
				var2 = 32767;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class210.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = ViewportMouse.decodeStringCp1252(var3, 0, var2);
			var1 = var4;
		} catch (Exception var6) {
			var1 = "Cabbage";
		}

		return var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1490418351"
	)
	public static void method846() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "949644202"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (Projectile.loadInterface(var0)) {
				Widget[] var1 = Widget.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						WorldMapIcon_1.runScript(var4, 5000000);
					}
				}

			}
		}
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(Lbd;IIII)V",
		garbageValue = "-500711697"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (WorldMapIcon_1.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				if (var0.skillLevel == 0) {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + class225.method4037(var0.combatLevel, WorldMapIcon_1.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var5;
				if (Client.isItemSelected == 1) {
					WorldMapData_0.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class16.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((WorldMapSectionType.selectedSpellFlags & 8) == 8) {
						WorldMapData_0.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class16.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var5 = 7; var5 >= 0; --var5) {
						if (Client.playerMenuActions[var5] != null) {
							short var6 = 0;
							if (Client.playerMenuActions[var5].equalsIgnoreCase("Attack")) {
								if (AttackOption.AttackOption_hidden == Client.playerAttackOption) {
									continue;
								}

								if (Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && var0.combatLevel > WorldMapIcon_1.localPlayer.combatLevel) {
									var6 = 2000;
								}

								if (WorldMapIcon_1.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == WorldMapIcon_1.localPlayer.team) {
										var6 = 2000;
									} else {
										var6 = 0;
									}
								}
							} else if (Client.playerOptionsPriorities[var5]) {
								var6 = 2000;
							}

							boolean var7 = false;
							int var8 = Client.playerMenuOpcodes[var5] + var6;
							WorldMapData_0.insertMenuItemNoShift(Client.playerMenuActions[var5], class16.colorStartTag(16777215) + var4, var8, var1, var2, var3);
						}
					}
				}

				for (var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
					if (Client.menuOpcodes[var5] == 23) {
						Client.menuTargets[var5] = class16.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}
}
