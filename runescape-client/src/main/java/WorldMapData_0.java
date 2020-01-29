import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("w")
@Implements("WorldMapData_0")
public class WorldMapData_0 extends AbstractWorldMapData {
	@ObfuscatedName("sk")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "Lei;"
	)
	@Export("urlRequester")
	static UrlRequester urlRequester;
	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("crossSprites")
	static Sprite[] crossSprites;

	WorldMapData_0() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "-109"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field277.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 4096;
			super.regionYLow = var1.readUnsignedShort() * 64;
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			super.groupId = var1.method5593();
			super.fileId = var1.method5593();
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;S)V",
		garbageValue = "-30591"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field188 = new byte[super.planes][64][64];
		super.field175 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field270.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY) {
				for (int var5 = 0; var5 < 64; ++var5) {
					for (int var6 = 0; var6 < 64; ++var6) {
						this.readTile(var5, var6, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_0)) {
			return false;
		} else {
			WorldMapData_0 var2 = (WorldMapData_0)var1;
			return var2.regionX == super.regionX && var2.regionY == super.regionY;
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILii;Ljava/lang/String;Ljava/lang/String;IZI)V",
		garbageValue = "-1022524213"
	)
	public static void method189(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		int var6 = var1.getGroupId(var2);
		int var7 = var1.getFileId(var6, var3);
		TaskHandler.playMusicTrack(var0, var1, var6, var7, var4, var5);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	public static void method181() {
		SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1614694262"
	)
	static final boolean method187(int var0, int var1) {
		ObjectDefinition var2 = Occluder.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method4675(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-1897390403"
	)
	static int method175(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		if (var0 == ScriptOpcodes.CC_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = class83.method2108(WorldMapIcon_0.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.CC_GETOP) {
			if (var0 == ScriptOpcodes.CC_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}
