import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("q")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("c")
	@Export("musicTrackBoolean")
	static boolean musicTrackBoolean;
	@ObfuscatedName("ei")
	@ObfuscatedGetter(
		intValue = -2012639545
	)
	static int field195;
	@ObfuscatedName("lt")
	@ObfuscatedGetter(
		intValue = 1281740027
	)
	@Export("selectedSpellWidget")
	static int selectedSpellWidget;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -213451189
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1408254649
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1062701969
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([BI)Lav;",
		garbageValue = "-2072507802"
	)
	static WorldMapSprite method325(byte[] var0) {
		return var0 == null ? new WorldMapSprite() : new WorldMapSprite(GrandExchangeOfferTotalQuantityComparator.convertJpgToSprite(var0).pixels);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
		garbageValue = "-53"
	)
	@Export("loadClassFromDescriptor")
	static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Lli;",
		garbageValue = "1591816730"
	)
	static IndexedSprite method327() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class325.SpriteBuffer_spriteWidth;
		var0.height = class325.SpriteBuffer_spriteHeight;
		var0.xOffset = class325.SpriteBuffer_xOffsets[0];
		var0.yOffset = class325.SpriteBuffer_yOffsets[0];
		var0.subWidth = UserComparator1.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class325.SpriteBuffer_spriteHeights[0];
		var0.palette = class268.SpriteBuffer_spritePalette;
		var0.pixels = class290.SpriteBuffer_pixels[0];
		Message.method1223();
		return var0;
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1037810196"
	)
	static boolean method326() {
		return Client.tapToDrop || KeyHandler.KeyHandler_pressedKeys[81];
	}
}
