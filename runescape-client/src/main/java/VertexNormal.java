import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("z")
	public static short[][] field1764;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1214687281
	)
	@Export("y")
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -412976723
	)
	@Export("x")
	int x;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1667952739
	)
	@Export("z")
	int z;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 284274911
	)
	@Export("magnitude")
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		signature = "(Len;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BI)Lkx;",
		garbageValue = "-1694309156"
	)
	public static Font method3094(byte[] var0) {
		if (var0 == null) {
			return null;
		} else {
			Font var1 = new Font(var0, class335.SpriteBuffer_xOffsets, StructDefinition.SpriteBuffer_yOffsets, class335.SpriteBuffer_spriteWidths, class335.SpriteBuffer_spriteHeights, DefaultsGroup.SpriteBuffer_spritePalette, class4.SpriteBuffer_pixels);
			Ignored.method5235();
			return var1;
		}
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-399"
	)
	static final void method3093() {
		if (Client.logoutTimer > 0) {
			Huffman.logOut();
		} else {
			Client.timer.method5050();
			MouseRecorder.updateGameState(40);
			UrlRequester.field1960 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}
}
