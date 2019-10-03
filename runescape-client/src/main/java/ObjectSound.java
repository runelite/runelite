import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("pk")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("hs")
	@ObfuscatedGetter(
		intValue = -1030939799
	)
	@Export("oculusOrbFocalPointX")
	static int oculusOrbFocalPointX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1622269101
	)
	int field1059;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1770378821
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -331149697
	)
	@Export("x")
	int x;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	@Export("obj")
	ObjectDefinition obj;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 514830237
	)
	@Export("y")
	int y;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -394210361
	)
	int field1060;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1094960613
	)
	int field1061;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 287004655
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 985540703
	)
	int field1064;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -91764577
	)
	int field1070;
	@ObfuscatedName("o")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1113854033
	)
	int field1067;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ldu;"
	)
	@Export("stream2")
	RawPcmStream stream2;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-28"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectDefinition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field1061 = var2.int4 * 128;
			this.field1064 = var2.int5;
			this.field1070 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field1061 = 0;
			this.field1064 = 0;
			this.field1070 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			WorldMapLabelSize.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}
}
