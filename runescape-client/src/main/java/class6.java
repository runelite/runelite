import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class6 implements class11 {
	@ObfuscatedName("x")
	final MessageDigest field27;

	@ObfuscatedSignature(
		signature = "(Ls;)V"
	)
	class6(class10 var1) {
		this.field27 = this.method87();
	}

	@ObfuscatedName("x")
	boolean method83(int var1, String var2, long var3) {
		byte[] var5 = this.method91(var2, var3);
		return method97(var5) >= var1;
	}

	@ObfuscatedName("d")
	byte[] method91(String var1, long var2) {
		StringBuilder var4 = new StringBuilder();
		var4.append(var1).append(Long.toHexString(var2));
		this.field27.reset();

		try {
			this.field27.update(var4.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException var6) {
			var6.printStackTrace();
		}

		return this.field27.digest();
	}

	@ObfuscatedName("w")
	MessageDigest method87() {
		try {
			return MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException var2) {
			var2.printStackTrace();
			return null;
		}
	}

	@ObfuscatedName("m")
	static int method97(byte[] var0) {
		int var1 = 0;
		byte[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			byte var4 = var2[var3];
			int var5 = method85(var4);
			var1 += var5;
			if (var5 != 8) {
				break;
			}
		}

		return var1;
	}

	@ObfuscatedName("k")
	static int method85(byte var0) {
		int var1 = 0;
		if (var0 == 0) {
			var1 = 8;
		} else {
			for (int var2 = var0 & 255; (var2 & 128) == 0; var2 <<= 1) {
				++var1;
			}
		}

		return var1;
	}
}
