import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public final class class291 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;Lmu;I)Ljava/lang/String;",
		garbageValue = "-1894833715"
	)
	public static String method5315(CharSequence var0, LoginType var1) {
		if (var0 == null) {
			return null;
		} else {
			int var2 = 0;

			int var3;
			boolean var4;
			char var5;
			for (var3 = var0.length(); var2 < var3; ++var2) {
				var5 = var0.charAt(var2);
				var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
				if (!var4) {
					break;
				}
			}

			while (var3 > var2) {
				var5 = var0.charAt(var3 - 1);
				var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
				if (!var4) {
					break;
				}

				--var3;
			}

			int var14 = var3 - var2;
			if (var14 >= 1) {
				byte var6;
				if (var1 == null) {
					var6 = 12;
				} else {
					switch(var1.field4057) {
					case 8:
						var6 = 20;
						break;
					default:
						var6 = 12;
					}
				}

				if (var14 <= var6) {
					StringBuilder var12 = new StringBuilder(var14);

					for (int var15 = var2; var15 < var3; ++var15) {
						char var7 = var0.charAt(var15);
						boolean var8;
						if (Character.isISOControl(var7)) {
							var8 = false;
						} else if (GrandExchangeOfferOwnWorldComparator.isAlphaNumeric(var7)) {
							var8 = true;
						} else {
							char[] var13 = class339.field4061;
							int var10 = 0;

							label118:
							while (true) {
								char var11;
								if (var10 >= var13.length) {
									var13 = class339.field4062;

									for (var10 = 0; var10 < var13.length; ++var10) {
										var11 = var13[var10];
										if (var11 == var7) {
											var8 = true;
											break label118;
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
							char var9;
							switch(var7) {
							case ' ':
							case '-':
							case '_':
							case ' ':
								var9 = '_';
								break;
							case '#':
							case '[':
							case ']':
								var9 = var7;
								break;
							case 'À':
							case 'Á':
							case 'Â':
							case 'Ã':
							case 'Ä':
							case 'à':
							case 'á':
							case 'â':
							case 'ã':
							case 'ä':
								var9 = 'a';
								break;
							case 'Ç':
							case 'ç':
								var9 = 'c';
								break;
							case 'È':
							case 'É':
							case 'Ê':
							case 'Ë':
							case 'è':
							case 'é':
							case 'ê':
							case 'ë':
								var9 = 'e';
								break;
							case 'Í':
							case 'Î':
							case 'Ï':
							case 'í':
							case 'î':
							case 'ï':
								var9 = 'i';
								break;
							case 'Ñ':
							case 'ñ':
								var9 = 'n';
								break;
							case 'Ò':
							case 'Ó':
							case 'Ô':
							case 'Õ':
							case 'Ö':
							case 'ò':
							case 'ó':
							case 'ô':
							case 'õ':
							case 'ö':
								var9 = 'o';
								break;
							case 'Ù':
							case 'Ú':
							case 'Û':
							case 'Ü':
							case 'ù':
							case 'ú':
							case 'û':
							case 'ü':
								var9 = 'u';
								break;
							case 'ß':
								var9 = 'b';
								break;
							case 'ÿ':
							case 'Ÿ':
								var9 = 'y';
								break;
							default:
								var9 = Character.toLowerCase(var7);
							}

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
}
