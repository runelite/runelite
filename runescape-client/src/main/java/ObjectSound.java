import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1413400591
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1795590701
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -877292205
	)
	@Export("x")
	int x;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1466364365
	)
	int field1110;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -878503687
	)
	int field1100;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2082519321
	)
	int field1106;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1984124175
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -240636841
	)
	int field1104;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -901475347
	)
	int field1105;
	@ObfuscatedName("p")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1043802301
	)
	int field1107;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("obj")
	ObjectDefinition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "29"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1106 = var2.int4 * 128;
			this.field1104 = var2.int5;
			this.field1105 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1106 = 0;
			this.field1104 = 0;
			this.field1105 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			Tiles.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1791981608"
	)
	@Export("Messages_getNextChatID")
	static int Messages_getNextChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}
}
