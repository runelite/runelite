import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("rb")
	@ObfuscatedGetter(
		intValue = 1189036032
	)
	static int field1932;
	@ObfuscatedName("s")
	@Export("url")
	final URL url;
	@ObfuscatedName("j")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("i")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "76"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)[B",
		garbageValue = "0"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;Llu;I)Ljava/lang/String;",
		garbageValue = "238475307"
	)
	public static String method3264(CharSequence var0, LoginType var1) {
		if (var0 == null) {
			return null;
		} else {
			int var2 = 0;

			int var3;
			for (var3 = var0.length(); var2 < var3 && FaceNormal.method3222(var0.charAt(var2)); ++var2) {
			}

			while (var3 > var2 && FaceNormal.method3222(var0.charAt(var3 - 1))) {
				--var3;
			}

			int var4 = var3 - var2;
			if (var4 >= 1) {
				byte var6;
				if (var1 == null) {
					var6 = 12;
				} else {
					switch(var1.field4033) {
					case 1:
						var6 = 20;
						break;
					default:
						var6 = 12;
					}
				}

				if (var4 <= var6) {
					StringBuilder var12 = new StringBuilder(var4);

					for (int var14 = var2; var14 < var3; ++var14) {
						char var7 = var0.charAt(var14);
						boolean var8;
						if (Character.isISOControl(var7)) {
							var8 = false;
						} else if (RouteStrategy.isAlphaNumeric(var7)) {
							var8 = true;
						} else {
							char[] var13 = class338.field4038;
							int var10 = 0;

							label83:
							while (true) {
								char var11;
								if (var10 >= var13.length) {
									var13 = class338.field4035;

									for (var10 = 0; var10 < var13.length; ++var10) {
										var11 = var13[var10];
										if (var7 == var11) {
											var8 = true;
											break label83;
										}
									}

									var8 = false;
									break;
								}

								var11 = var13[var10];
								if (var11 == var7) {
									var8 = true;
									break;
								}

								++var10;
							}
						}

						if (var8) {
							char var9 = StructDefinition.method4449(var7);
							if (var9 != 0) {
								var12.append(var9);
							}
						}
					}

					if (var12.length() == 0) {
						return null;
					}

					return var12.toString();
				}
			}

			return null;
		}
	}

	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1388025296"
	)
	static void method3258(String var0) {
		Clock.field2037 = var0;

		try {
			String var1 = WorldMapID.client.getParameter(Integer.toString(18));
			String var2 = WorldMapID.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				var3 = var3 + "; Expires=" + MusicPatchPcmStream.method3831(SequenceDefinition.method4686() + 94608000000L) + "; Max-Age=" + 94608000L;
			}

			class47.method796(WorldMapID.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var4) {
		}

	}
}
