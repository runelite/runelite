import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive13")
	static Archive archive13;
	@ObfuscatedName("a")
	@Export("url")
	final URL url;
	@ObfuscatedName("t")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("n")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-340522486"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-14894560"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}
}
