import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public final class class43 {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	public static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	@Export("fontBold12")
	static Font fontBold12;
	@ObfuscatedName("hj")
	@ObfuscatedGetter(
		intValue = -340073235
	)
	@Export("cameraPitch")
	static int cameraPitch;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IB)Lix;",
		garbageValue = "-106"
	)
	@Export("StructDefinition_getStructDefinition")
	public static StructDefinition StructDefinition_getStructDefinition(int var0) {
		StructDefinition var1 = (StructDefinition)StructDefinition.StructDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = StructDefinition.StructDefinition_archive.takeFile(34, var0);
			var1 = new StructDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			StructDefinition.StructDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;ZI)[B",
		garbageValue = "1018664493"
	)
	@Export("serialize")
	public static byte[] serialize(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var6 = (byte[])((byte[])var0);
			if (var1) {
				int var4 = var6.length;
				byte[] var5 = new byte[var4];
				System.arraycopy(var6, 0, var5, 0, var4);
				return var5;
			} else {
				return var6;
			}
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1698401174"
	)
	static int method761(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1409120987"
	)
	static int method758() {
		if (Client.archiveLoaders != null && Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoaderArchive; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field895;
		} else {
			return 10000;
		}
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "16"
	)
	static final void method759() {
		Client.field629 = Client.cycleCntr;
	}
}
