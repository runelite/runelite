import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("Username")
public class Username implements Comparable {
	@ObfuscatedName("f")
	@Export("name")
	String name;
	@ObfuscatedName("i")
	@Export("cleanName")
	String cleanName;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lll;)V"
	)
	public Username(String var1, LoginType var2) {
		this.name = var1;
		String var4;
		if (var1 == null) {
			var4 = null;
		} else {
			label164: {
				int var5 = 0;

				int var6;
				boolean var7;
				char var8;
				for (var6 = var1.length(); var5 < var6; ++var5) {
					var8 = var1.charAt(var5);
					var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
					if (!var7) {
						break;
					}
				}

				while (var6 > var5) {
					var8 = var1.charAt(var6 - 1);
					var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
					if (!var7) {
						break;
					}

					--var6;
				}

				int var17 = var6 - var5;
				if (var17 >= 1) {
					byte var9;
					if (var2 == null) {
						var9 = 12;
					} else {
						switch(var2.field4029) {
						case 4:
							var9 = 20;
							break;
						default:
							var9 = 12;
						}
					}

					if (var17 <= var9) {
						StringBuilder var15 = new StringBuilder(var17);

						for (int var18 = var5; var18 < var6; ++var18) {
							char var10 = var1.charAt(var18);
							boolean var11;
							if (Character.isISOControl(var10)) {
								var11 = false;
							} else if (class191.isAlphaNumeric(var10)) {
								var11 = true;
							} else {
								char[] var16 = class338.field4037;
								int var13 = 0;

								label117:
								while (true) {
									char var14;
									if (var13 >= var16.length) {
										var16 = class338.field4035;

										for (var13 = 0; var13 < var16.length; ++var13) {
											var14 = var16[var13];
											if (var14 == var10) {
												var11 = true;
												break label117;
											}
										}

										var11 = false;
										break;
									}

									var14 = var16[var13];
									if (var10 == var14) {
										var11 = true;
										break;
									}

									++var13;
								}
							}

							if (var11) {
								char var12;
								switch(var10) {
								case ' ':
								case '-':
								case '_':
								case ' ':
									var12 = '_';
									break;
								case '#':
								case '[':
								case ']':
									var12 = var10;
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
									var12 = 'a';
									break;
								case 'Ç':
								case 'ç':
									var12 = 'c';
									break;
								case 'È':
								case 'É':
								case 'Ê':
								case 'Ë':
								case 'è':
								case 'é':
								case 'ê':
								case 'ë':
									var12 = 'e';
									break;
								case 'Í':
								case 'Î':
								case 'Ï':
								case 'í':
								case 'î':
								case 'ï':
									var12 = 'i';
									break;
								case 'Ñ':
								case 'ñ':
									var12 = 'n';
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
									var12 = 'o';
									break;
								case 'Ù':
								case 'Ú':
								case 'Û':
								case 'Ü':
								case 'ù':
								case 'ú':
								case 'û':
								case 'ü':
									var12 = 'u';
									break;
								case 'ß':
									var12 = 'b';
									break;
								case 'ÿ':
								case 'Ÿ':
									var12 = 'y';
									break;
								default:
									var12 = Character.toLowerCase(var10);
								}

								if (var12 != 0) {
									var15.append(var12);
								}
							}
						}

						if (var15.length() == 0) {
							var4 = null;
						} else {
							var4 = var15.toString();
						}
						break label164;
					}
				}

				var4 = null;
			}
		}

		this.cleanName = var4;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-2024242176"
	)
	@Export("getName")
	public String getName() {
		return this.name;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-190673782"
	)
	@Export("hasCleanName")
	public boolean hasCleanName() {
		return this.cleanName != null;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljc;I)I",
		garbageValue = "-2128174200"
	)
	@Export("compareToTyped")
	public int compareToTyped(Username var1) {
		if (this.cleanName == null) {
			return var1.cleanName == null ? 0 : 1;
		} else {
			return var1.cleanName == null ? -1 : this.cleanName.compareTo(var1.cleanName);
		}
	}

	public boolean equals(Object var1) {
		if (var1 instanceof Username) {
			Username var2 = (Username)var1;
			if (this.cleanName == null) {
				return var2.cleanName == null;
			} else if (var2.cleanName == null) {
				return false;
			} else {
				return this.hashCode() != var2.hashCode() ? false : this.cleanName.equals(var2.cleanName);
			}
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.cleanName == null ? 0 : this.cleanName.hashCode();
	}

	public String toString() {
		return this.getName();
	}

	public int compareTo(Object var1) {
		return this.compareToTyped((Username)var1);
	}
}
