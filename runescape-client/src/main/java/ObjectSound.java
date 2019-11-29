import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -284752301
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -320634943
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 351853767
	)
	@Export("y")
	int y;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1257144143
	)
	int field1074;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -889892259
	)
	int field1071;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -919807871
	)
	int field1072;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1412550033
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 851722869
	)
	int field1075;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1188723059
	)
	int field1076;
	@ObfuscatedName("x")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1209496197
	)
	int field1078;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lil;"
	)
	@Export("obj")
	ObjectDefinition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1485735851"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1072 = var2.int4 * 128;
			this.field1075 = var2.int5;
			this.field1076 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1072 = 0;
			this.field1075 = 0;
			this.field1076 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			ClientPacket.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "-359888333"
	)
	public static byte[] method1935(byte[] var0) {
		int var1 = var0.length;
		byte[] var2 = new byte[var1];
		System.arraycopy(var0, 0, var2, 0, var1);
		return var2;
	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "7"
	)
	static final void method1936() {
		Client.field836 = Client.cycleCntr;
		WorldMapID.ClanChat_inClanChat = true;
	}
}
