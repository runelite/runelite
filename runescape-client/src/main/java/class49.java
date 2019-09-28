import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class49 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -649185671
	)
	@Export("musicTrackFileId")
	public static int musicTrackFileId;

	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IZIZB)V",
		garbageValue = "-64"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (World.World_worlds != null) {
			AbstractWorldMapData.doWorldSorting(0, World.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "([BI)Lkn;",
		garbageValue = "-1770627772"
	)
	static Font method893(byte[] var0) {
		if (var0 == null) {
			return null;
		} else {
			Font var1 = new Font(var0, class325.SpriteBuffer_xOffsets, MusicPatchPcmStream.SpriteBuffer_yOffsets, class325.SpriteBuffer_spriteWidths, RunException.SpriteBuffer_spriteHeights, class325.SpriteBuffer_spritePalette, PacketBufferNode.SpriteBuffer_pixels);
			class325.SpriteBuffer_xOffsets = null;
			MusicPatchPcmStream.SpriteBuffer_yOffsets = null;
			class325.SpriteBuffer_spriteWidths = null;
			RunException.SpriteBuffer_spriteHeights = null;
			class325.SpriteBuffer_spritePalette = null;
			PacketBufferNode.SpriteBuffer_pixels = null;
			return var1;
		}
	}
}
