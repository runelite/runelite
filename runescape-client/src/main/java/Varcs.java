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

@ObfuscatedName("ch")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("f")
	@Export("musicTrackBoolean")
	public static boolean musicTrackBoolean;
	@ObfuscatedName("i")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("k")
	@Export("map")
	Map map;
	@ObfuscatedName("u")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("n")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = -3102782666800977811L
	)
	long field1243;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = HealthBarUpdate.archive2.getGroupFileCount(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var3 = FileSystem.method3447(var2);
			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (HealthBarUpdate.archive2.method4199(15)) {
			var2 = HealthBarUpdate.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1411494049"
	)
	@Export("setInt")
	void setInt(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-102"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-461145893"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "-6"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1336031066"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "-122"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "30"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ZI)Lmm;",
		garbageValue = "1411517965"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return TaskHandler.getPreferencesFile("2", WorldMapRectangle.field166.name, var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1634973674"
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

			Buffer var32 = new Buffer(var2);
			var32.writeByte(2);
			var32.writeShort(var3);
			Iterator var33 = this.map.entrySet().iterator();

			label185:
			while (true) {
				Entry var20;
				int var21;
				do {
					if (!var33.hasNext()) {
						var1.write(var32.array, 0, var32.offset);
						break label185;
					}

					var20 = (Entry)var33.next();
					var21 = (Integer)var20.getKey();
				} while(!this.intsPersistence[var21]);

				var32.writeShort(var21);
				Object var8 = var20.getValue();
				Class var10 = var8.getClass();
				class3[] var11 = class3.method44();
				int var12 = 0;

				class3 var9;
				while (true) {
					if (var12 >= var11.length) {
						var9 = null;
						break;
					}

					class3 var13 = var11[var12];
					if (var10 == var13.field29) {
						var9 = var13;
						break;
					}

					++var12;
				}

				var32.writeByte(var9.field18);
				Class var34 = var8.getClass();
				class3[] var15 = class3.method44();
				int var16 = 0;

				class3 var14;
				while (true) {
					if (var16 >= var15.length) {
						var14 = null;
						break;
					}

					class3 var17 = var15[var16];
					if (var34 == var17.field29) {
						var14 = var17;
						break;
					}

					++var16;
				}

				if (var14 == null) {
					throw new IllegalArgumentException();
				}

				class0 var22 = var14.field13;
				var22.vmethod58(var8, var32);
			}
		} catch (Exception var30) {
		} finally {
			try {
				var1.close();
			} catch (Exception var29) {
			}

		}

		this.unwrittenChanges = false;
		this.field1243 = SequenceDefinition.method4686();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-85"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		label229: {
			try {
				byte[] var2 = new byte[(int)var1.length()];

				int var4;
				for (int var3 = 0; var3 < var2.length; var3 += var4) {
					var4 = var1.read(var2, var3, var2.length - var3);
					if (var4 == -1) {
						throw new EOFException();
					}
				}

				Buffer var14 = new Buffer(var2);
				if (var14.array.length - var14.offset >= 1) {
					int var15 = var14.readUnsignedByte();
					if (var15 >= 0 && var15 <= 2) {
						int var7;
						int var8;
						int var9;
						int var16;
						if (var15 >= 2) {
							var16 = var14.readUnsignedShort();
							var7 = 0;

							while (true) {
								if (var7 >= var16) {
									break label229;
								}

								var8 = var14.readUnsignedShort();
								var9 = var14.readUnsignedByte();
								class3 var10 = (class3)FriendSystem.findEnumerated(class3.method44(), var9);
								Object var11 = var10.method43(var14);
								if (this.intsPersistence[var8]) {
									this.map.put(var8, var11);
								}

								++var7;
							}
						} else {
							var16 = var14.readUnsignedShort();

							for (var7 = 0; var7 < var16; ++var7) {
								var8 = var14.readUnsignedShort();
								var9 = var14.readInt();
								if (this.intsPersistence[var8]) {
									this.map.put(var8, var9);
								}
							}

							var7 = var14.readUnsignedShort();
							var8 = 0;

							while (true) {
								if (var8 >= var7) {
									break label229;
								}

								var14.readUnsignedShort();
								var14.readStringCp1252NullTerminated();
								++var8;
							}
						}
					}

					return;
				}
			} catch (Exception var25) {
				break label229;
			} finally {
				try {
					var1.close();
				} catch (Exception var24) {
				}

			}

			return;
		}

		this.unwrittenChanges = false;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "573629327"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1243 < SequenceDefinition.method4686() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "702857669"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}
}
