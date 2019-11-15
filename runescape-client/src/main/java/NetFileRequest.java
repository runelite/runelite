import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive4")
	static Archive archive4;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive")
	public Archive archive;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 925703943
	)
	@Export("crc")
	public int crc;
	@ObfuscatedName("n")
	@Export("padding")
	public byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lii;",
		garbageValue = "-2050258581"
	)
	public static HitSplatDefinition method4298(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
