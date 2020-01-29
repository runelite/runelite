import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("o")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("e")
	@Export("map")
	Map map;
	@ObfuscatedName("i")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("g")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		longValue = -8646841017490334521L
	)
	long field1249;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = GrandExchangeOfferWorldComparator.archive2.getGroupFileCount(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var4 = (VarcInt)VarcInt.VarcInt_cached.get((long)var2);
			VarcInt var3;
			if (var4 != null) {
				var3 = var4;
			} else {
				byte[] var5 = VarcInt.VarcInt_archive.takeFile(19, var2);
				var4 = new VarcInt();
				if (var5 != null) {
					var4.method4478(new Buffer(var5));
				}

				VarcInt.VarcInt_cached.put(var4, (long)var2);
				var3 = var4;
			}

			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (GrandExchangeOfferWorldComparator.archive2.method4348(15)) {
			var2 = GrandExchangeOfferWorldComparator.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1547810829"
	)
	@Export("setInt")
	void setInt(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-66"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1774400510"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "104"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)V",
		garbageValue = "-92"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1676642086"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1665078788"
	)
	@Export("clearTransient")
	void clearTransient() {
		int var1;
		for (var1 = 0; var1 < this.intsPersistence.length; ++var1) {
			if (!this.intsPersistence[var1]) {
				this.map.remove(var1);
			}
		}

		for (var1 = 0; var1 < this.strings.length; ++var1) {
			this.strings[var1] = null;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ZI)Lmx;",
		garbageValue = "-6839896"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return WorldMapRectangle.getPreferencesFile("2", class14.field102.name, var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2046783551"
	)
	@Export("write")
	void write() {
		AccessFile var1 = this.getPreferencesFile(true);

		try {
			int var2 = 3;
			int var3 = 0;
			Iterator var4 = this.map.entrySet().iterator();

			while (var4.hasNext()) {
				Entry var5 = (Entry)var4.next();
				int var6 = (Integer)var5.getKey();
				if (this.intsPersistence[var6]) {
					Object var7 = var5.getValue();
					var2 += 3;
					if (var7 instanceof Integer) {
						var2 += 4;
					} else if (var7 instanceof String) {
						var2 += Buddy.stringCp1252NullTerminatedByteSize((String)var7);
					}

					++var3;
				}
			}

			Buffer var23 = new Buffer(var2);
			var23.writeByte(2);
			var23.writeShort(var3);
			Iterator var24 = this.map.entrySet().iterator();

			while (var24.hasNext()) {
				Entry var12 = (Entry)var24.next();
				int var13 = (Integer)var12.getKey();
				if (this.intsPersistence[var13]) {
					var23.writeShort(var13);
					Object var8 = var12.getValue();
					class3 var9 = class3.method51(var8.getClass());
					var23.writeByte(var9.field18);
					class3.method35(var8, var23);
				}
			}

			var1.write(var23.array, 0, var23.offset);
		} catch (Exception var21) {
		} finally {
			try {
				var1.close();
			} catch (Exception var20) {
			}

		}

		this.unwrittenChanges = false;
		this.field1249 = WorldMapIcon_0.currentTimeMillis();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1384592680"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		label231: {
			try {
				byte[] var2 = new byte[(int)var1.length()];

				int var4;
				for (int var3 = 0; var3 < var2.length; var3 += var4) {
					var4 = var1.read(var2, var3, var2.length - var3);
					if (var4 == -1) {
						throw new EOFException();
					}
				}

				Buffer var15 = new Buffer(var2);
				if (var15.array.length - var15.offset >= 1) {
					int var16 = var15.readUnsignedByte();
					if (var16 >= 0 && var16 <= 2) {
						int var7;
						int var8;
						int var9;
						int var17;
						if (var16 >= 2) {
							var17 = var15.readUnsignedShort();
							var7 = 0;

							while (true) {
								if (var7 >= var17) {
									break label231;
								}

								var8 = var15.readUnsignedShort();
								var9 = var15.readUnsignedByte();
								class3[] var10 = new class3[]{class3.field15, class3.field22, class3.field16};
								class3 var11 = (class3)WorldMapSection0.findEnumerated(var10, var9);
								Object var12 = var11.method38(var15);
								if (this.intsPersistence[var8]) {
									this.map.put(var8, var12);
								}

								++var7;
							}
						} else {
							var17 = var15.readUnsignedShort();

							for (var7 = 0; var7 < var17; ++var7) {
								var8 = var15.readUnsignedShort();
								var9 = var15.readInt();
								if (this.intsPersistence[var8]) {
									this.map.put(var8, var9);
								}
							}

							var7 = var15.readUnsignedShort();
							var8 = 0;

							while (true) {
								if (var8 >= var7) {
									break label231;
								}

								var15.readUnsignedShort();
								var15.readStringCp1252NullTerminated();
								++var8;
							}
						}
					}

					return;
				}
			} catch (Exception var26) {
				break label231;
			} finally {
				try {
					var1.close();
				} catch (Exception var25) {
				}

			}

			return;
		}

		this.unwrittenChanges = false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2106283374"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1249 < WorldMapIcon_0.currentTimeMillis() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "129228614"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;I)Z",
		garbageValue = "-141032975"
	)
	public static boolean method2212(AbstractArchive var0, AbstractArchive var1) {
		WorldMapElement.WorldMapElement_archive = var1;
		if (!var0.isFullyLoaded()) {
			return false;
		} else {
			class218.WorldMapElement_count = var0.getGroupFileCount(35);
			WorldMapElement.WorldMapElement_cached = new WorldMapElement[class218.WorldMapElement_count];

			for (int var2 = 0; var2 < class218.WorldMapElement_count; ++var2) {
				byte[] var3 = var0.takeFile(35, var2);
				WorldMapElement.WorldMapElement_cached[var2] = new WorldMapElement(var2);
				if (var3 != null) {
					WorldMapElement.WorldMapElement_cached[var2].decode(new Buffer(var3));
					WorldMapElement.WorldMapElement_cached[var2].method4449();
				}
			}

			return true;
		}
	}
}
