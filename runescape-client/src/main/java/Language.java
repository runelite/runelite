import java.util.Iterator;
import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gc")
@Implements("Language")
public class Language implements Enumerated {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("Language_DE")
	static final Language Language_DE;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("Language_PT")
	static final Language Language_PT;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("Language_NL")
	static final Language Language_NL;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("Language_ES_MX")
	static final Language Language_ES_MX;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "[Lgc;"
	)
	@Export("Language_valuesOrdered")
	public static final Language[] Language_valuesOrdered;
	@ObfuscatedName("y")
	final String field2364;
	@ObfuscatedName("w")
	@Export("language")
	final String language;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -936078223
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", class192.field2381, 0, "GB");
		Language_DE = new Language("DE", "de", "German", class192.field2381, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", class192.field2381, 2, "FR");
		Language_PT = new Language("PT", "pt", "Portuguese", class192.field2381, 3, "BR");
		Language_NL = new Language("NL", "nl", "Dutch", class192.field2392, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", class192.field2392, 5, "ES");
		Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class192.field2381, 6, "MX");
		Language[] var0 = method3703();
		Language_valuesOrdered = new Language[var0.length];
		Language[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			Language var3 = var1[var2];
			if (Language_valuesOrdered[var3.id] != null) {
				throw new IllegalStateException();
			}

			Language_valuesOrdered[var3.id] = var3;
		}

	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lgo;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, class192 var4, int var5, String var6) {
		this.field2364 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "786287735"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "7"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lhl;",
		garbageValue = "-673897758"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (FloorDecoration.Widget_interfaceComponents[var1] == null || FloorDecoration.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = UserComparator3.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return FloorDecoration.Widget_interfaceComponents[var1][var2];
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lgc;",
		garbageValue = "-2103702236"
	)
	static Language[] method3703() {
		return new Language[]{Language_DE, Language_ES_MX, Language_FR, Language_ES, Language_PT, Language_EN, Language_NL};
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Lin;",
		garbageValue = "-1669366533"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILci;ZS)I",
		garbageValue = "32581"
	)
	static int method3710(int var0, Script var1, boolean var2) {
		Widget var3 = getWidget(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		signature = "(Lcg;IIB)V",
		garbageValue = "24"
	)
	static final void method3705(MenuAction var0, int var1, int var2) {
		class32.menuAction(var0.param0, var0.param1, var0.opcode, var0.identifier, var0.action, var0.action, var1, var2);
	}

	@ObfuscatedName("jw")
	@ObfuscatedSignature(
		signature = "(Lhl;II)I",
		garbageValue = "1435184999"
	)
	static final int method3719(Widget var0, int var1) {
		if (var0.cs1Instructions != null && var1 < var0.cs1Instructions.length) {
			try {
				int[] var2 = var0.cs1Instructions[var1];
				int var3 = 0;
				int var4 = 0;
				byte var5 = 0;

				while (true) {
					int var6 = var2[var4++];
					int var7 = 0;
					byte var8 = 0;
					if (var6 == 0) {
						return var3;
					}

					if (var6 == 1) {
						var7 = Client.currentLevels[var2[var4++]];
					}

					if (var6 == 2) {
						var7 = Client.levels[var2[var4++]];
					}

					if (var6 == 3) {
						var7 = Client.experience[var2[var4++]];
					}

					int var9;
					Widget var10;
					int var11;
					int var12;
					if (var6 == 4) {
						var9 = var2[var4++] << 16;
						var9 += var2[var4++];
						var10 = getWidget(var9);
						var11 = var2[var4++];
						if (var11 != -1 && (!Interpreter.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
							for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
								if (var11 + 1 == var10.itemIds[var12]) {
									var7 += var10.itemQuantities[var12];
								}
							}
						}
					}

					if (var6 == 5) {
						var7 = Varps.Varps_main[var2[var4++]];
					}

					if (var6 == 6) {
						var7 = Skills.Skills_experienceTable[Client.levels[var2[var4++]] - 1];
					}

					if (var6 == 7) {
						var7 = Varps.Varps_main[var2[var4++]] * 100 / 46875;
					}

					if (var6 == 8) {
						var7 = class215.localPlayer.combatLevel;
					}

					if (var6 == 9) {
						for (var9 = 0; var9 < 25; ++var9) {
							if (Skills.Skills_enabled[var9]) {
								var7 += Client.levels[var9];
							}
						}
					}

					if (var6 == 10) {
						var9 = var2[var4++] << 16;
						var9 += var2[var4++];
						var10 = getWidget(var9);
						var11 = var2[var4++];
						if (var11 != -1 && (!Interpreter.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
							for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
								if (var11 + 1 == var10.itemIds[var12]) {
									var7 = 999999999;
									break;
								}
							}
						}
					}

					if (var6 == 11) {
						var7 = Client.runEnergy;
					}

					if (var6 == 12) {
						var7 = Client.weight;
					}

					if (var6 == 13) {
						var9 = Varps.Varps_main[var2[var4++]];
						int var13 = var2[var4++];
						var7 = (var9 & 1 << var13) != 0 ? 1 : 0;
					}

					if (var6 == 14) {
						var9 = var2[var4++];
						var7 = FileSystem.getVarbit(var9);
					}

					if (var6 == 15) {
						var8 = 1;
					}

					if (var6 == 16) {
						var8 = 2;
					}

					if (var6 == 17) {
						var8 = 3;
					}

					if (var6 == 18) {
						var7 = class51.baseX * 64 + (class215.localPlayer.x >> 7);
					}

					if (var6 == 19) {
						var7 = VarcInt.baseY * 64 + (class215.localPlayer.y >> 7);
					}

					if (var6 == 20) {
						var7 = var2[var4++];
					}

					if (var8 == 0) {
						if (var5 == 0) {
							var3 += var7;
						}

						if (var5 == 1) {
							var3 -= var7;
						}

						if (var5 == 2 && var7 != 0) {
							var3 /= var7;
						}

						if (var5 == 3) {
							var3 *= var7;
						}

						var5 = 0;
					} else {
						var5 = var8;
					}
				}
			} catch (Exception var14) {
				return -1;
			}
		} else {
			return -2;
		}
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "808353188"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

		if (InterfaceParent.clanChat != null) {
			InterfaceParent.clanChat.invalidateIgnoreds();
		}

	}
}
