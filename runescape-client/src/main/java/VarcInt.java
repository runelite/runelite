import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("VarcInt")
public class VarcInt extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("VarcInt_archive")
	public static AbstractArchive VarcInt_archive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("VarcInt_cached")
	static EvictingDualNodeHashTable VarcInt_cached;
	@ObfuscatedName("i")
	@Export("persist")
	public boolean persist;

	static {
		VarcInt_cached = new EvictingDualNodeHashTable(64);
	}

	VarcInt() {
		this.persist = false;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-1564347413"
	)
	void method4314(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4315(var1, var2);
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "-1760139411"
	)
	void method4315(Buffer var1, int var2) {
		if (var2 == 2) {
			this.persist = true;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Lis;",
		garbageValue = "-1763982471"
	)
	@Export("getParamDefinition")
	public static ParamDefinition getParamDefinition(int var0) {
		ParamDefinition var1 = (ParamDefinition)ParamDefinition.ParamDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class339.ParamDefinition_archive.takeFile(11, var0);
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
