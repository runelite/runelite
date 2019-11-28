import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("pr")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	@Export("privateChatMode")
	static PrivateChatMode privateChatMode;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 58684745
	)
	int field2449;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lcw;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	MusicPatchNode2 field2448;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -554118983
	)
	int field2445;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 964723385
	)
	int field2450;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1158780531
	)
	int field2451;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1961661549
	)
	int field2452;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1743896361
	)
	int field2465;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1656176453
	)
	int field2454;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -146534819
	)
	int field2455;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 671001671
	)
	int field2456;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1362014437
	)
	int field2457;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1068746099
	)
	int field2458;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -362402475
	)
	int field2459;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1829652009
	)
	int field2460;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1900705041
	)
	int field2461;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1048414071
	)
	int field2462;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lds;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 871159735
	)
	int field2464;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 809397821
	)
	int field2463;

	MusicPatchNode() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "786622629"
	)
	void method3893() {
		this.patch = null;
		this.rawSound = null;
		this.field2448 = null;
		this.stream = null;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lio;",
		garbageValue = "1955258484"
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
}
