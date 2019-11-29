import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("TileItemPile")
public final class TileItemPile {
	@ObfuscatedName("i")
	public static short[][] field1537;
	@ObfuscatedName("kd")
	@ObfuscatedGetter(
		intValue = -495854777
	)
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -811612081
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1672040969
	)
	@Export("x")
	int x;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -951728925
	)
	@Export("y")
	int y;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		longValue = 4343367721480266293L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -311771117
	)
	@Export("height")
	int height;

	TileItemPile() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)[Lkc;",
		garbageValue = "-76"
	)
	static PrivateChatMode[] method2810() {
		return new PrivateChatMode[]{PrivateChatMode.field3793, PrivateChatMode.field3792, PrivateChatMode.field3794};
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1881198055"
	)
	public static void method2811() {
		FaceNormal.midiPcmStream.clear();
		class197.field2411 = 1;
		class197.musicTrackArchive = null;
	}
}
