import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("lj")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2019117197
	)
	@Export("compass")
	public int compass;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1099214959
	)
	public int field3796;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1016295027
	)
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -153404939
	)
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 382264229
	)
	public int field3799;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1961256143
	)
	public int field3800;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 185996655
	)
	public int field3803;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 875223521
	)
	public int field3802;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -979917091
	)
	public int field3805;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1753253309
	)
	public int field3804;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 519795879
	)
	public int field3795;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3796 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3799 = -1;
		this.field3800 = -1;
		this.field3803 = -1;
		this.field3802 = -1;
		this.field3805 = -1;
		this.field3804 = -1;
		this.field3795 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;I)V",
		garbageValue = "-1404571691"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3793.group);
		Buffer var3 = new Buffer(var2);

		while (true) {
			int var4 = var3.readUnsignedByte();
			if (var4 == 0) {
				return;
			}

			switch(var4) {
			case 1:
				var3.readMedium();
				break;
			case 2:
				this.compass = var3.method5593();
				this.field3796 = var3.method5593();
				this.mapScenes = var3.method5593();
				this.headIconsPk = var3.method5593();
				this.field3799 = var3.method5593();
				this.field3800 = var3.method5593();
				this.field3803 = var3.method5593();
				this.field3802 = var3.method5593();
				this.field3805 = var3.method5593();
				this.field3804 = var3.method5593();
				this.field3795 = var3.method5593();
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)Lip;",
		garbageValue = "14"
	)
	@Export("SequenceDefinition_get")
	public static SequenceDefinition SequenceDefinition_get(int var0) {
		SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SequenceDefinition.SequenceDefinition_archive.takeFile(12, var0);
			var1 = new SequenceDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "64"
	)
	static int method5955(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == ScriptOpcodes.APPEND_NUM) {
			var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == ScriptOpcodes.APPEND) {
				Message.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == ScriptOpcodes.APPEND_SIGNNUM) {
				var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3 + ItemContainer.intToString(var4, true);
				return 1;
			} else if (var0 == ScriptOpcodes.LOWERCASE) {
				var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == ScriptOpcodes.FROMDATE) {
					var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
					long var11 = 86400000L * ((long)var10 + 11745L);
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var16 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var16] + "-" + var8;
					return 1;
				} else if (var0 != ScriptOpcodes.TEXT_GENDER) {
					if (var0 == ScriptOpcodes.TOSTRING) {
						var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.COMPARE) {
						Message.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = WorldMapData_1.method712(Client.compareStrings(Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize + 1], FriendLoginUpdate.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == ScriptOpcodes.PARAHEIGHT) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							class320.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
							var13 = MouseHandler.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.PARAWIDTH) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							class320.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
							var13 = MouseHandler.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.TEXT_SWITCH) {
							Message.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ESCAPE) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == ScriptOpcodes.APPEND_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISPRINTABLE) {
							var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Skills.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHANUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ArchiveDiskAction.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHA) {
							var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = ClanChat.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISNUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class14.isDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_LENGTH) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.SUBSTRING) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							class320.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.REMOVETAGS) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							StringBuilder var17 = new StringBuilder(var3.length());
							boolean var15 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var15 = true;
								} else if (var7 == '>') {
									var15 = false;
								} else if (!var15) {
									var17.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var17.toString();
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_STRING) {
							Message.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.UPPERCASE) {
							var3 = Interpreter.Interpreter_stringStack[--Message.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					Message.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[Message.Interpreter_stringStackSize + 1];
					if (class192.localPlayer.appearance != null && class192.localPlayer.appearance.isFemale) {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}
}
