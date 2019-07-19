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

@ObfuscatedName("ca")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("es")
	@ObfuscatedGetter(
		intValue = 610571431
	)
	@Export("port3")
	static int port3;
	@ObfuscatedName("e")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("p")
	@Export("map")
	Map map;
	@ObfuscatedName("k")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("l")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		longValue = -277979548816975331L
	)
	long field1272;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = class215.archive2.getGroupFileCount(19);
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
					var4.method4401(new Buffer(var5));
				}

				VarcInt.VarcInt_cached.put(var4, (long)var2);
				var3 = var4;
			}

			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (class215.archive2.method4268(15)) {
			var2 = class215.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1875619216"
	)
	@Export("setInt")
	void setInt(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-17"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-1079389061"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1328754518"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-267938278"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1859485923"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1717605874"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ZI)Lma;",
		garbageValue = "195746057"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return WorldMapIcon_0.getPreferencesFile("2", WorldMapRegion.field248.name, var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2043030213"
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
						var2 += Huffman.stringCp1252NullTerminatedByteSize((String)var7);
					}

					++var3;
				}
			}

			Buffer var28 = new Buffer(var2);
			var28.writeByte(2);
			var28.writeShort(var3);
			Iterator var29 = this.map.entrySet().iterator();

			label147:
			while (true) {
				Entry var17;
				int var18;
				do {
					if (!var29.hasNext()) {
						var1.write(var28.array, 0, var28.offset);
						break label147;
					}

					var17 = (Entry)var29.next();
					var18 = (Integer)var17.getKey();
				} while(!this.intsPersistence[var18]);

				var28.writeShort(var18);
				Object var8 = var17.getValue();
				Class var10 = var8.getClass();
				class3[] var11 = new class3[]{class3.field9, class3.field14, class3.field7};
				class3[] var12 = var11;
				int var13 = 0;

				class3 var9;
				while (true) {
					if (var13 >= var12.length) {
						var9 = null;
						break;
					}

					class3 var14 = var12[var13];
					if (var10 == var14.field12) {
						var9 = var14;
						break;
					}

					++var13;
				}

				var28.writeByte(var9.field11);
				class3.method30(var8, var28);
			}
		} catch (Exception var26) {
		} finally {
			try {
				var1.close();
			} catch (Exception var25) {
			}

		}

		this.unwrittenChanges = false;
		this.field1272 = DirectByteArrayCopier.currentTimeMs();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-5"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		label226: {
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
									break label226;
								}

								var8 = var15.readUnsignedShort();
								var9 = var15.readUnsignedByte();
								class3[] var10 = new class3[]{class3.field9, class3.field14, class3.field7};
								class3 var11 = (class3)SoundSystem.findEnumerated(var10, var9);
								Object var12 = var11.method34(var15);
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
									break label226;
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
				break label226;
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2136969712"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1272 < DirectByteArrayCopier.currentTimeMs() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1650912685"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}
}
