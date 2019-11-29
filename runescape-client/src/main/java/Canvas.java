import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ax")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("ek")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("u")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1452894334"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (GrandExchangeOfferOwnWorldComparator.World_request == null) {
				GrandExchangeOfferOwnWorldComparator.World_request = SpriteMask.urlRequester.request(new URL(WallDecoration.field1914));
			} else if (GrandExchangeOfferOwnWorldComparator.World_request.isDone()) {
				byte[] var0 = GrandExchangeOfferOwnWorldComparator.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				Skills.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = Skills.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				Clock.sortWorlds(Skills.World_worlds, 0, Skills.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
				GrandExchangeOfferOwnWorldComparator.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			GrandExchangeOfferOwnWorldComparator.World_request = null;
		}

		return false;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Ler;",
		garbageValue = "-1118777455"
	)
	@Export("getFrames")
	static Frames getFrames(int var0) {
		Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			AbstractArchive var3 = SequenceDefinition.SequenceDefinition_animationsArchive;
			AbstractArchive var4 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
			boolean var5 = true;
			int[] var6 = var3.getGroupFileIds(var0);

			for (int var7 = 0; var7 < var6.length; ++var7) {
				byte[] var8 = var3.getFile(var0, var6[var7]);
				if (var8 == null) {
					var5 = false;
				} else {
					int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
					byte[] var10 = var4.getFile(var9, 0);
					if (var10 == null) {
						var5 = false;
					}
				}
			}

			Frames var2;
			if (!var5) {
				var2 = null;
			} else {
				try {
					var2 = new Frames(var3, var4, var0, false);
				} catch (Exception var12) {
					var2 = null;
				}
			}

			if (var2 != null) {
				SequenceDefinition.SequenceDefinition_cachedFrames.put(var2, (long)var0);
			}

			return var2;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILci;ZB)I",
		garbageValue = "-7"
	)
	static int method873(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.field1090 : class188.field2352;
		if (var0 == ScriptOpcodes.CC_GETX) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETY) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETWIDTH) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHIDE) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETLAYER) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(ILhx;ZB)V",
		garbageValue = "0"
	)
	static void method871(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = Clock.getWorldMap().getMapArea(var0);
		int var4 = class215.localPlayer.plane;
		int var5 = class51.baseX * 64 + (class215.localPlayer.x >> 7);
		int var6 = VarcInt.baseY * 64 + (class215.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		Clock.getWorldMap().method6453(var3, var7, var1, var2);
	}

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-90"
	)
	static final void method872(boolean var0) {
		if (var0) {
			Client.field680 = Login.field1196 ? class160.field2008 : class160.field2005;
		} else {
			LinkedHashMap var1 = UserComparator10.clientPreferences.parameters;
			String var3 = Login.Login_username;
			int var4 = var3.length();
			int var5 = 0;

			for (int var6 = 0; var6 < var4; ++var6) {
				var5 = (var5 << 5) - var5 + var3.charAt(var6);
			}

			Client.field680 = var1.containsKey(var5) ? class160.field2009 : class160.field2006;
		}

	}
}
