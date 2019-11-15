import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1227010727
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -286465655
	)
	@Export("x")
	int x;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1852994176
	)
	@Export("y")
	int y;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 451765888
	)
	int field1060;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1453778816
	)
	int field1053;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -186868357
	)
	int field1052;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1676549815
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 180162911
	)
	int field1057;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -648009507
	)
	int field1058;
	@ObfuscatedName("p")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 423706127
	)
	int field1054;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lix;"
	)
	@Export("obj")
	ObjectDefinition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-23"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1052 = var2.int4 * 128;
			this.field1057 = var2.int5;
			this.field1058 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1052 = 0;
			this.field1057 = 0;
			this.field1058 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			FloorUnderlayDefinition.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lhi;IIII)V",
		garbageValue = "1790951666"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field2628 == null) {
			throw new RuntimeException();
		} else {
			var0.field2628[var1] = var2;
			var0.field2626[var1] = var3;
		}
	}
}
