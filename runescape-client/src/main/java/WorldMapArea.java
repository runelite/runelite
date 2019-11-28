import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("af")
@Implements("WorldMapArea")
public class WorldMapArea {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 122238223
	)
	@Export("id")
	int id;
	@ObfuscatedName("f")
	@Export("internalName")
	String internalName;
	@ObfuscatedName("b")
	@Export("externalName")
	String externalName;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1540917345
	)
	@Export("backGroundColor")
	int backGroundColor;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 959137413
	)
	@Export("zoom")
	int zoom;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("origin")
	Coord origin;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1713545369
	)
	@Export("regionLowX")
	int regionLowX;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1689268055
	)
	@Export("regionHighX")
	int regionHighX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1354478225
	)
	@Export("regionLowY")
	int regionLowY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1917825101
	)
	@Export("regionHighY")
	int regionHighY;
	@ObfuscatedName("k")
	@Export("isMain")
	boolean isMain;
	@ObfuscatedName("x")
	@Export("sections")
	LinkedList sections;

	public WorldMapArea() {
		this.id = -1;
		this.backGroundColor = -1;
		this.zoom = -1;
		this.origin = null;
		this.regionLowX = Integer.MAX_VALUE;
		this.regionHighX = 0;
		this.regionLowY = Integer.MAX_VALUE;
		this.regionHighY = 0;
		this.isMain = false;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkg;IS)V",
		garbageValue = "255"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.readStringCp1252NullTerminated();
		this.externalName = var1.readStringCp1252NullTerminated();
		this.origin = new Coord(var1.readInt());
		this.backGroundColor = var1.readInt();
		var1.readUnsignedByte();
		this.isMain = var1.readUnsignedByte() == 1;
		this.zoom = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.readWorldMapSection(var1));
		}

		this.setBounds();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;I)Lav;",
		garbageValue = "-1936635513"
	)
	@Export("readWorldMapSection")
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType var3 = (WorldMapSectionType)CollisionMap.findEnumerated(WorldMapSectionType.method262(), var2);
		Object var4 = null;
		switch(var3.type) {
		case 0:
			var4 = new WorldMapSection2();
			break;
		case 1:
			var4 = new WorldMapSection0();
			break;
		case 2:
			var4 = new WorldMapSection1();
			break;
		case 3:
			var4 = new class42();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var4).read(var1);
		return (WorldMapSection)var4;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-2105358172"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return true;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIS)Z",
		garbageValue = "2206"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSection)var5.next();
				} while(!var6.containsPosition(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-984592033"
	)
	@Export("position")
	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return var5.getBorderTileLengths(var1, var2, var3);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)Lhx;",
		garbageValue = "66"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSection)var3.next();
		} while(!var4.containsPosition(var1, var2));

		return var4.coord(var1, var2);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2134226031"
	)
	@Export("setBounds")
	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.expandBounds(this);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-558298236"
	)
	@Export("getId")
	public int getId() {
		return this.id;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1980333643"
	)
	@Export("getIsMain")
	public boolean getIsMain() {
		return this.isMain;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "986616320"
	)
	@Export("getInternalName")
	public String getInternalName() {
		return this.internalName;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "2135576042"
	)
	@Export("getExternalName")
	public String getExternalName() {
		return this.externalName;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "14931"
	)
	@Export("getBackGroundColor")
	int getBackGroundColor() {
		return this.backGroundColor;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2065427390"
	)
	@Export("getZoom")
	public int getZoom() {
		return this.zoom;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-253398901"
	)
	@Export("getRegionLowX")
	public int getRegionLowX() {
		return this.regionLowX;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1831938917"
	)
	@Export("getRegionHighX")
	public int getRegionHighX() {
		return this.regionHighX;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-847812540"
	)
	@Export("getRegionLowY")
	public int getRegionLowY() {
		return this.regionLowY;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-10"
	)
	@Export("getRegionHighY")
	public int getRegionHighY() {
		return this.regionHighY;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "25027619"
	)
	@Export("getOriginX")
	public int getOriginX() {
		return this.origin.x;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "234586297"
	)
	@Export("getOriginPlane")
	public int getOriginPlane() {
		return this.origin.plane;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-554027606"
	)
	@Export("getOriginY")
	public int getOriginY() {
		return this.origin.y;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Lhx;",
		garbageValue = "1357419323"
	)
	@Export("getOrigin")
	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Lbs;",
		garbageValue = "-1284252548"
	)
	static ClientPreferences method422() {
		AccessFile var0 = null;
		ClientPreferences var1 = new ClientPreferences();

		try {
			var0 = class191.getPreferencesFile("", UserComparator8.field1973.name, false);
			byte[] var2 = new byte[(int)var0.length()];

			int var4;
			for (int var3 = 0; var3 < var2.length; var3 += var4) {
				var4 = var0.read(var2, var3, var2.length - var3);
				if (var4 == -1) {
					throw new IOException();
				}
			}

			var1 = new ClientPreferences(new Buffer(var2));
		} catch (Exception var6) {
		}

		try {
			if (var0 != null) {
				var0.close();
			}
		} catch (Exception var5) {
		}

		return var1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BI)Lci;",
		garbageValue = "-1522510902"
	)
	@Export("newScript")
	static Script newScript(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.array.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.array.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intArgumentCount = var2.readUnsignedShort();
		var1.stringArgumentCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.newIterableNodeHashTable(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				IterableNodeHashTable var9 = new IterableNodeHashTable(var8 > 0 ? WorldMapID.method566(var8) : 1);
				var1.switches[var7] = var9;

				while (var8-- > 0) {
					int var10 = var2.readInt();
					int var11 = var2.readInt();
					var9.put(new IntegerNode(var11), (long)var10);
				}
			}
		}

		var2.offset = 0;
		var2.readStringCp1252NullTerminatedOrNull();
		var1.opcodes = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "-1045531754"
	)
	static int method396(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == ScriptOpcodes.APPEND_NUM) {
			var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == ScriptOpcodes.APPEND) {
				class43.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == ScriptOpcodes.APPEND_SIGNNUM) {
				var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3 + VarbitDefinition.intToString(var4, true);
				return 1;
			} else if (var0 == ScriptOpcodes.LOWERCASE) {
				var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == ScriptOpcodes.FROMDATE) {
					var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
					long var11 = 86400000L * ((long)var10 + 11745L);
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var16 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var16] + "-" + var8;
					return 1;
				} else if (var0 != ScriptOpcodes.TEXT_GENDER) {
					if (var0 == ScriptOpcodes.TOSTRING) {
						var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.COMPARE) {
						class43.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Friend.method5293(ArchiveDiskActionHandler.compareStrings(Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize + 1], VarbitDefinition.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == ScriptOpcodes.PARAHEIGHT) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
							var13 = class269.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.PARAWIDTH) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
							var13 = class269.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == ScriptOpcodes.TEXT_SWITCH) {
							class43.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ESCAPE) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == ScriptOpcodes.APPEND_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISPRINTABLE) {
							var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = FloorDecoration.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHANUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Varcs.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISALPHA) {
							var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = SequenceDefinition.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CHAR_ISNUMERIC) {
							var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = AbstractWorldMapData.isDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_LENGTH) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == ScriptOpcodes.SUBSTRING) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.REMOVETAGS) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
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

							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var17.toString();
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_CHAR) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == ScriptOpcodes.STRING_INDEXOF_STRING) {
							class43.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == ScriptOpcodes.UPPERCASE) {
							var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					class43.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize + 1];
					if (class215.localPlayer.appearance != null && class215.localPlayer.appearance.isFemale) {
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2037516367"
	)
	static final void method424() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field764[++Client.field814 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field688[++Client.field687 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2058(var7, (byte)1);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field688[++Client.field687 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2058(var7, (byte)2);
							var8 = var0.readBits(3);
							var4.method2058(var8, (byte)2);
							int var9 = var0.readBits(1);
							if (var9 == 1) {
								Client.field688[++Client.field687 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field764[++Client.field814 - 1] = var3;
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "(Lhl;I)Z",
		garbageValue = "985912778"
	)
	@Export("runCs1")
	static final boolean runCs1(Widget var0) {
		if (var0.cs1Comparisons == null) {
			return false;
		} else {
			for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
				int var2 = Language.method3719(var0, var1);
				int var3 = var0.cs1ComparisonValues[var1];
				if (var0.cs1Comparisons[var1] == 2) {
					if (var2 >= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 3) {
					if (var2 <= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 4) {
					if (var3 == var2) {
						return false;
					}
				} else if (var3 != var2) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "116"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (UserComparator3.loadInterface(var0)) {
			Widget[] var1 = FloorDecoration.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}
}
