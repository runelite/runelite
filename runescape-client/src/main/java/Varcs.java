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

@ObfuscatedName("cz")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("n")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("q")
	@Export("map")
	Map map;
	@ObfuscatedName("v")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("l")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = 4894374485782924843L
	)
	long field1246;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = AbstractWorldMapIcon.archive2.getGroupFileCount(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var3 = Decimator.method2694(var2);
			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (AbstractWorldMapIcon.archive2.method4436(15)) {
			var2 = AbstractWorldMapIcon.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "878961648"
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
		signature = "(II)I",
		garbageValue = "1218722234"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-1237376058"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1479997522"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)V",
		garbageValue = "64"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1714600398"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "526123607"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ZB)Lmh;",
		garbageValue = "1"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return CollisionMap.getPreferencesFile("2", MouseHandler.field458.name, var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2015022450"
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
						var2 += UserComparator6.stringCp1252NullTerminatedByteSize((String)var7);
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
					var23.writeByte(var9.field14);
					class3.method52(var8, var23);
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
		this.field1246 = PlayerAppearance.currentTimeMillis();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "37"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		label225: {
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
								break label225;
							}

							var8 = var15.readUnsignedShort();
							var9 = var15.readUnsignedByte();
							class3[] var10 = new class3[]{class3.field13, class3.field18, class3.field17};
							class3 var11 = (class3)WorldMapIcon_1.findEnumerated(var10, var9);
							Object var12 = var11.method55(var15);
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
								break label225;
							}

							var15.readUnsignedShort();
							var15.readStringCp1252NullTerminated();
							++var8;
						}
					}
				}
			} catch (Exception var26) {
				break label225;
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-53918442"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1246 < PlayerAppearance.currentTimeMillis() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "4"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Liu;",
		garbageValue = "-1999284157"
	)
	@Export("VarpDefinition_get")
	public static VarpDefinition VarpDefinition_get(int var0) {
		VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
