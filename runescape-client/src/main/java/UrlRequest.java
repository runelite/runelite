import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive19")
	static Archive archive19;
	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("compass")
	static Sprite compass;
	@ObfuscatedName("c")
	@Export("url")
	final URL url;
	@ObfuscatedName("x")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("t")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "18901995"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-1475340215"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1057408025"
	)
	static void method3276(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}
}
