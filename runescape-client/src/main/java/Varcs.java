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

@ObfuscatedName("cj")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("rm")
	@ObfuscatedGetter(
		intValue = -2086820043
	)
	static int field1242;
	@ObfuscatedName("t")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("g")
	@Export("map")
	Map map;
	@ObfuscatedName("l")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("u")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		longValue = -2615226300908847259L
	)
	long field1239;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = class173.archive2.getGroupFileCount(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var3 = class186.method3609(var2);
			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (class173.archive2.method4261(15)) {
			var2 = class173.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "-1109"
	)
	@Export("setInt")
	void setInt(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1810097692"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-1074130602"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "68"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-1450087250"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1157824262"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "844512682"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ZI)Lmr;",
		garbageValue = "-1276722644"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return GrandExchangeOfferUnitPriceComparator.getPreferencesFile("2", class43.field359.name, var1);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "51"
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
						var2 += stringCp1252NullTerminatedByteSize((String)var7);
					}

					++var3;
				}
			}

			Buffer var33 = new Buffer(var2);
			var33.writeByte(2);
			var33.writeShort(var3);
			Iterator var34 = this.map.entrySet().iterator();

			label187:
			while (true) {
				Entry var21;
				int var22;
				do {
					if (!var34.hasNext()) {
						var1.write(var33.array, 0, var33.offset);
						break label187;
					}

					var21 = (Entry)var34.next();
					var22 = (Integer)var21.getKey();
				} while(!this.intsPersistence[var22]);

				var33.writeShort(var22);
				Object var8 = var21.getValue();
				Class var10 = var8.getClass();
				class3[] var11 = new class3[]{class3.field10, class3.field13, class3.field7};
				class3[] var12 = var11;
				int var13 = 0;

				class3 var9;
				class3 var14;
				while (true) {
					if (var13 >= var12.length) {
						var9 = null;
						break;
					}

					var14 = var12[var13];
					if (var10 == var14.field11) {
						var9 = var14;
						break;
					}

					++var13;
				}

				var33.writeByte(var9.field12);
				Class var23 = var8.getClass();
				class3[] var15 = new class3[]{class3.field10, class3.field13, class3.field7};
				class3[] var16 = var15;
				int var17 = 0;

				while (true) {
					if (var17 >= var16.length) {
						var14 = null;
						break;
					}

					class3 var18 = var16[var17];
					if (var23 == var18.field11) {
						var14 = var18;
						break;
					}

					++var17;
				}

				if (var14 == null) {
					throw new IllegalArgumentException();
				}

				class0 var35 = var14.field8;
				var35.vmethod42(var8, var33);
			}
		} catch (Exception var31) {
		} finally {
			try {
				var1.close();
			} catch (Exception var30) {
			}

		}

		this.unwrittenChanges = false;
		this.field1239 = SoundCache.method2480();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "97"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		label215: {
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
				if (var15.array.length - var15.offset < 1) {
					return;
				}

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
								break label215;
							}

							var8 = var15.readUnsignedShort();
							var9 = var15.readUnsignedByte();
							class3[] var10 = new class3[]{class3.field10, class3.field13, class3.field7};
							class3 var11 = (class3)ServerPacket.findEnumerated(var10, var9);
							Object var12 = var11.method37(var15);
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
								break label215;
							}

							var15.readUnsignedShort();
							var15.readStringCp1252NullTerminated();
							++var8;
						}
					}
				}
			} catch (Exception var26) {
				break label215;
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1574159447"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1239 < SoundCache.method2480() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "53"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-2082115344"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)I",
		garbageValue = "0"
	)
	@Export("stringCp1252NullTerminatedByteSize")
	public static int stringCp1252NullTerminatedByteSize(String var0) {
		return var0.length() + 1;
	}
}
