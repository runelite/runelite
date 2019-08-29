import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
@Implements("GZipDecompressor")
public class GZipDecompressor {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -145342191
	)
	public static int field4007;
	@ObfuscatedName("s")
	@Export("inflater")
	Inflater inflater;

	public GZipDecompressor() {
		this(-1, 1000000, 1000000);
	}

	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1000000"
	)
	GZipDecompressor(int var1, int var2, int var3) {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lky;[BI)V",
		garbageValue = "-1662982609"
	)
	@Export("decompress")
	public void decompress(Buffer var1, byte[] var2) {
		if (var1.array[var1.offset] == 31 && var1.array[var1.offset + 1] == -117) {
			if (this.inflater == null) {
				this.inflater = new Inflater(true);
			}

			try {
				this.inflater.setInput(var1.array, var1.offset + 10, var1.array.length - (var1.offset + 8 + 10));
				this.inflater.inflate(var2);
			} catch (Exception var4) {
				this.inflater.reset();
				throw new RuntimeException("");
			}

			this.inflater.reset();
		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-2077179875"
	)
	static void method6390(boolean var0) {
		Login.Login_response1 = "";
		Login.Login_response2 = "Enter your username/email & password.";
		Login.Login_response3 = "";
		Login.loginIndex = 2;
		if (var0) {
			Login.Login_password = "";
		}

		ItemContainer.method1120();
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}
}
