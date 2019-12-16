import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1656698135
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1779559040
	)
	@Export("x")
	int x;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -718591763
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 787274277
	)
	int field1064;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1137525137
	)
	int field1052;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 245525821
	)
	int field1053;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1263233623
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ldg;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -938588117
	)
	int field1060;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1891052931
	)
	int field1061;
	@ObfuscatedName("o")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 2003220669
	)
	int field1055;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ldg;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lig;"
	)
	@Export("obj")
	ObjectDefinition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "448933263"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1053 = var2.int4 * 128;
			this.field1060 = var2.int5;
			this.field1061 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1053 = 0;
			this.field1060 = 0;
			this.field1061 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			Tiles.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}
}
