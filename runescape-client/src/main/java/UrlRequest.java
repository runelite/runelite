import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;
	@ObfuscatedName("d")
	@Export("Tiles_hue")
	static int[] Tiles_hue;
	@ObfuscatedName("jr")
	@ObfuscatedGetter(
		intValue = -1130751947
	)
	@Export("Client_plane")
	static int Client_plane;
	@ObfuscatedName("f")
	@Export("url")
	final URL url;
	@ObfuscatedName("i")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("y")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "186206860"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-2113635317"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}
}
