import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1573146665
	)
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 500861795
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1324796191
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1787906731
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -337099317
	)
	@Export("y")
	int y;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1549979331
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 43570649
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -396532533
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = 463073903231293703L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 14602599
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lif;",
		garbageValue = "-746198187"
	)
	@Export("getParamDefinition")
	public static ParamDefinition getParamDefinition(int var0) {
		ParamDefinition var1 = (ParamDefinition)ParamDefinition.ParamDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ParamDefinition.ParamDefinition_archive.takeFile(11, var0);
			var1 = new ParamDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			ParamDefinition.ParamDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1910753346"
	)
	static final void method3255() {
		for (int var0 = 0; var0 < Client.npcCount; ++var0) {
			int var1 = Client.npcIndices[var0];
			NPC var2 = Client.npcs[var1];
			if (var2 != null) {
				class325.calculateActorPosition(var2, var2.definition.size);
			}
		}

	}
}
