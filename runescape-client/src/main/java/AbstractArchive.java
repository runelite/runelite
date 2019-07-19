import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hp")
@Implements("AbstractArchive")
public abstract class AbstractArchive {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	@Export("gzipDecompressor")
	static GZipDecompressor gzipDecompressor;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 420916507
	)
	static int field3143;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1329598587
	)
	@Export("groupCount")
	int groupCount;
	@ObfuscatedName("e")
	@Export("groupIds")
	int[] groupIds;
	@ObfuscatedName("p")
	@Export("groupNameHashes")
	int[] groupNameHashes;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llj;"
	)
	@Export("groupNameHashTable")
	IntHashTable groupNameHashTable;
	@ObfuscatedName("l")
	@Export("groupCrcs")
	int[] groupCrcs;
	@ObfuscatedName("b")
	@Export("groupVersions")
	int[] groupVersions;
	@ObfuscatedName("i")
	@Export("fileCounts")
	int[] fileCounts;
	@ObfuscatedName("c")
	@Export("fileIds")
	int[][] fileIds;
	@ObfuscatedName("f")
	@Export("fileNameHashes")
	int[][] fileNameHashes;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Llj;"
	)
	@Export("fileNameHashTables")
	IntHashTable[] fileNameHashTables;
	@ObfuscatedName("u")
	@Export("groups")
	Object[] groups;
	@ObfuscatedName("x")
	@Export("files")
	Object[][] files;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2113214337
	)
	@Export("hash")
	public int hash;
	@ObfuscatedName("y")
	@Export("releaseGroups")
	boolean releaseGroups;
	@ObfuscatedName("g")
	@Export("shallowFiles")
	boolean shallowFiles;

	static {
		gzipDecompressor = new GZipDecompressor();
		field3143 = 0;
	}

	AbstractArchive(boolean var1, boolean var2) {
		this.releaseGroups = var1;
		this.shallowFiles = var2;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "1973415514"
	)
	@Export("decodeIndex")
	void decodeIndex(byte[] var1) {
		int var3 = var1.length;
		int var2 = class2.method18(var1, 0, var3);
		this.hash = var2;
		Buffer var4 = new Buffer(HealthBarUpdate.decompressBytes(var1));
		int var5 = var4.readUnsignedByte();
		if (var5 >= 5 && var5 <= 7) {
			if (var5 >= 6) {
				var4.readInt();
			}

			int var6 = var4.readUnsignedByte();
			if (var5 >= 7) {
				this.groupCount = var4.method5685();
			} else {
				this.groupCount = var4.readUnsignedShort();
			}

			int var7 = 0;
			int var8 = -1;
			this.groupIds = new int[this.groupCount];
			int var9;
			if (var5 >= 7) {
				for (var9 = 0; var9 < this.groupCount; ++var9) {
					this.groupIds[var9] = var7 += var4.method5685();
					if (this.groupIds[var9] > var8) {
						var8 = this.groupIds[var9];
					}
				}
			} else {
				for (var9 = 0; var9 < this.groupCount; ++var9) {
					this.groupIds[var9] = var7 += var4.readUnsignedShort();
					if (this.groupIds[var9] > var8) {
						var8 = this.groupIds[var9];
					}
				}
			}

			this.groupCrcs = new int[var8 + 1];
			this.groupVersions = new int[var8 + 1];
			this.fileCounts = new int[var8 + 1];
			this.fileIds = new int[var8 + 1][];
			this.groups = new Object[var8 + 1];
			this.files = new Object[var8 + 1][];
			if (var6 != 0) {
				this.groupNameHashes = new int[var8 + 1];

				for (var9 = 0; var9 < this.groupCount; ++var9) {
					this.groupNameHashes[this.groupIds[var9]] = var4.readInt();
				}

				this.groupNameHashTable = new IntHashTable(this.groupNameHashes);
			}

			for (var9 = 0; var9 < this.groupCount; ++var9) {
				this.groupCrcs[this.groupIds[var9]] = var4.readInt();
			}

			for (var9 = 0; var9 < this.groupCount; ++var9) {
				this.groupVersions[this.groupIds[var9]] = var4.readInt();
			}

			for (var9 = 0; var9 < this.groupCount; ++var9) {
				this.fileCounts[this.groupIds[var9]] = var4.readUnsignedShort();
			}

			int var10;
			int var11;
			int var12;
			int var13;
			int var14;
			if (var5 >= 7) {
				for (var9 = 0; var9 < this.groupCount; ++var9) {
					var10 = this.groupIds[var9];
					var11 = this.fileCounts[var10];
					var7 = 0;
					var12 = -1;
					this.fileIds[var10] = new int[var11];

					for (var13 = 0; var13 < var11; ++var13) {
						var14 = this.fileIds[var10][var13] = var7 += var4.method5685();
						if (var14 > var12) {
							var12 = var14;
						}
					}

					this.files[var10] = new Object[var12 + 1];
				}
			} else {
				for (var9 = 0; var9 < this.groupCount; ++var9) {
					var10 = this.groupIds[var9];
					var11 = this.fileCounts[var10];
					var7 = 0;
					var12 = -1;
					this.fileIds[var10] = new int[var11];

					for (var13 = 0; var13 < var11; ++var13) {
						var14 = this.fileIds[var10][var13] = var7 += var4.readUnsignedShort();
						if (var14 > var12) {
							var12 = var14;
						}
					}

					this.files[var10] = new Object[var12 + 1];
				}
			}

			if (var6 != 0) {
				this.fileNameHashes = new int[var8 + 1][];
				this.fileNameHashTables = new IntHashTable[var8 + 1];

				for (var9 = 0; var9 < this.groupCount; ++var9) {
					var10 = this.groupIds[var9];
					var11 = this.fileCounts[var10];
					this.fileNameHashes[var10] = new int[this.files[var10].length];

					for (var12 = 0; var12 < var11; ++var12) {
						this.fileNameHashes[var10][this.fileIds[var10][var12]] = var4.readInt();
					}

					this.fileNameHashTables[var10] = new IntHashTable(this.fileNameHashes[var10]);
				}
			}

		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2144523901"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)[B",
		garbageValue = "-1152099404"
	)
	@Export("takeFile")
	public byte[] takeFile(int var1, int var2) {
		return this.takeFileEncrypted(var1, var2, (int[])null);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II[II)[B",
		garbageValue = "-2126995235"
	)
	@Export("takeFileEncrypted")
	public byte[] takeFileEncrypted(int var1, int var2, int[] var3) {
		if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
			if (this.files[var1][var2] == null) {
				boolean var4 = this.buildFiles(var1, var3);
				if (!var4) {
					this.loadGroup(var1);
					var4 = this.buildFiles(var1, var3);
					if (!var4) {
						return null;
					}
				}
			}

			byte[] var5 = ArchiveDisk.byteArrayFromObject(this.files[var1][var2], false);
			if (this.shallowFiles) {
				this.files[var1][var2] = null;
			}

			return var5;
		} else {
			return null;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-416813220"
	)
	@Export("tryLoadFile")
	public boolean tryLoadFile(int var1, int var2) {
		if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
			if (this.files[var1][var2] != null) {
				return true;
			} else if (this.groups[var1] != null) {
				return true;
			} else {
				this.loadGroup(var1);
				return this.groups[var1] != null;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1060538444"
	)
	public boolean method4147(int var1) {
		if (this.files.length == 1) {
			return this.tryLoadFile(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.tryLoadFile(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-43766791"
	)
	@Export("tryLoadGroup")
	public boolean tryLoadGroup(int var1) {
		if (this.groups[var1] != null) {
			return true;
		} else {
			this.loadGroup(var1);
			return this.groups[var1] != null;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "741322871"
	)
	@Export("isFullyLoaded")
	public boolean isFullyLoaded() {
		boolean var1 = true;

		for (int var2 = 0; var2 < this.groupIds.length; ++var2) {
			int var3 = this.groupIds[var2];
			if (this.groups[var3] == null) {
				this.loadGroup(var3);
				if (this.groups[var3] == null) {
					var1 = false;
				}
			}
		}

		return var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "0"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		return this.groups[var1] != null ? 100 : 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "1034279223"
	)
	@Export("takeFileFlat")
	public byte[] takeFileFlat(int var1) {
		if (this.files.length == 1) {
			return this.takeFile(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.takeFile(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)[B",
		garbageValue = "-377229485"
	)
	@Export("getFile")
	public byte[] getFile(int var1, int var2) {
		if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
			if (this.files[var1][var2] == null) {
				boolean var3 = this.buildFiles(var1, (int[])null);
				if (!var3) {
					this.loadGroup(var1);
					var3 = this.buildFiles(var1, (int[])null);
					if (!var3) {
						return null;
					}
				}
			}

			byte[] var4 = ArchiveDisk.byteArrayFromObject(this.files[var1][var2], false);
			return var4;
		} else {
			return null;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "-1915975799"
	)
	@Export("getFileFlat")
	public byte[] getFileFlat(int var1) {
		if (this.files.length == 1) {
			return this.getFile(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.getFile(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "3211"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "1269467416"
	)
	@Export("getGroupFileIds")
	public int[] getGroupFileIds(int var1) {
		return var1 >= 0 && var1 < this.fileIds.length ? this.fileIds[var1] : null;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1116420622"
	)
	@Export("getGroupFileCount")
	public int getGroupFileCount(int var1) {
		return this.files[var1].length;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-953283657"
	)
	@Export("getGroupCount")
	public int getGroupCount() {
		return this.files.length;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1731367566"
	)
	@Export("clearGroups")
	public void clearGroups() {
		for (int var1 = 0; var1 < this.groups.length; ++var1) {
			this.groups[var1] = null;
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "513084306"
	)
	@Export("clearFilesGroup")
	public void clearFilesGroup(int var1) {
		for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
			this.files[var1][var2] = null;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1559971076"
	)
	@Export("clearFiles")
	public void clearFiles() {
		for (int var1 = 0; var1 < this.files.length; ++var1) {
			if (this.files[var1] != null) {
				for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
					this.files[var1][var2] = null;
				}
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I[II)Z",
		garbageValue = "-1546414650"
	)
	@Export("buildFiles")
	boolean buildFiles(int var1, int[] var2) {
		if (this.groups[var1] == null) {
			return false;
		} else {
			int var3 = this.fileCounts[var1];
			int[] var4 = this.fileIds[var1];
			Object[] var5 = this.files[var1];
			boolean var6 = true;

			for (int var7 = 0; var7 < var3; ++var7) {
				if (var5[var4[var7]] == null) {
					var6 = false;
					break;
				}
			}

			if (var6) {
				return true;
			} else {
				byte[] var21;
				if (var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
					var21 = ArchiveDisk.byteArrayFromObject(this.groups[var1], false);
				} else {
					var21 = ArchiveDisk.byteArrayFromObject(this.groups[var1], true);
					Buffer var8 = new Buffer(var21);
					var8.xteaDecrypt(var2, 5, var8.array.length);
				}

				byte[] var25 = HealthBarUpdate.decompressBytes(var21);
				if (this.releaseGroups) {
					this.groups[var1] = null;
				}

				int var10;
				if (var3 > 1) {
					int var9 = var25.length;
					--var9;
					var10 = var25[var9] & 255;
					var9 -= var10 * var3 * 4;
					Buffer var11 = new Buffer(var25);
					int[] var12 = new int[var3];
					var11.offset = var9;

					int var14;
					int var15;
					for (int var13 = 0; var13 < var10; ++var13) {
						var14 = 0;

						for (var15 = 0; var15 < var3; ++var15) {
							var14 += var11.readInt();
							var12[var15] += var14;
						}
					}

					byte[][] var23 = new byte[var3][];

					for (var14 = 0; var14 < var3; ++var14) {
						var23[var14] = new byte[var12[var14]];
						var12[var14] = 0;
					}

					var11.offset = var9;
					var14 = 0;

					int var17;
					for (var15 = 0; var15 < var10; ++var15) {
						int var16 = 0;

						for (var17 = 0; var17 < var3; ++var17) {
							var16 += var11.readInt();
							System.arraycopy(var25, var14, var23[var17], var12[var17], var16);
							var12[var17] += var16;
							var14 += var16;
						}
					}

					for (var15 = 0; var15 < var3; ++var15) {
						if (!this.shallowFiles) {
							var17 = var4[var15];
							byte[] var19 = var23[var15];
							Object var18;
							if (var19 == null) {
								var18 = null;
							} else if (var19.length > 136) {
								DirectByteArrayCopier var20 = new DirectByteArrayCopier();
								var20.set(var19);
								var18 = var20;
							} else {
								var18 = var19;
							}

							var5[var17] = var18;
						} else {
							var5[var4[var15]] = var23[var15];
						}
					}
				} else if (!this.shallowFiles) {
					var10 = var4[0];
					Object var26;
					if (var25 == null) {
						var26 = null;
					} else if (var25.length > 136) {
						DirectByteArrayCopier var27 = new DirectByteArrayCopier();
						var27.set(var25);
						var26 = var27;
					} else {
						var26 = var25;
					}

					var5[var10] = var26;
				} else {
					var5[var4[0]] = var25;
				}

				return true;
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "1993215311"
	)
	@Export("getGroupId")
	public int getGroupId(String var1) {
		var1 = var1.toLowerCase();
		return this.groupNameHashTable.get(GrandExchangeOfferAgeComparator.hashString(var1));
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)I",
		garbageValue = "35"
	)
	@Export("getFileId")
	public int getFileId(int var1, String var2) {
		var2 = var2.toLowerCase();
		return this.fileNameHashTables[var1].get(GrandExchangeOfferAgeComparator.hashString(var2));
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
		garbageValue = "14"
	)
	@Export("isValidFileName")
	public boolean isValidFileName(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(GrandExchangeOfferAgeComparator.hashString(var1));
		if (var3 < 0) {
			return false;
		} else {
			int var4 = this.fileNameHashTables[var3].get(GrandExchangeOfferAgeComparator.hashString(var2));
			return var4 >= 0;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
		garbageValue = "-722893265"
	)
	@Export("takeFileByNames")
	public byte[] takeFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(GrandExchangeOfferAgeComparator.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(GrandExchangeOfferAgeComparator.hashString(var2));
		return this.takeFile(var3, var4);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
		garbageValue = "-1918711245"
	)
	@Export("tryLoadFileByNames")
	public boolean tryLoadFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(GrandExchangeOfferAgeComparator.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(GrandExchangeOfferAgeComparator.hashString(var2));
		return this.tryLoadFile(var3, var4);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "-928538356"
	)
	@Export("tryLoadGroupByName")
	public boolean tryLoadGroupByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(GrandExchangeOfferAgeComparator.hashString(var1));
		return this.tryLoadGroup(var2);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "62"
	)
	@Export("loadRegionFromName")
	public void loadRegionFromName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(GrandExchangeOfferAgeComparator.hashString(var1));
		if (var2 >= 0) {
			this.loadRegionFromGroup(var2);
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)I",
		garbageValue = "-19"
	)
	@Export("groupLoadPercentByName")
	public int groupLoadPercentByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(GrandExchangeOfferAgeComparator.hashString(var1));
		return this.groupLoadPercent(var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)[Lct;",
		garbageValue = "-27"
	)
	static AttackOption[] method4141() {
		return new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable};
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-74440934"
	)
	static int method4172(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.SOUND_SYNTH) {
			HealthBarUpdate.Interpreter_intStackSize -= 3;
			class81.queueSoundEffect(Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize], Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_SONG) {
			GrandExchangeOfferTotalQuantityComparator.method93(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_JINGLE) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			WorldMapLabelSize.method188(Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize], Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]);
			return 1;
		} else {
			return 2;
		}
	}
}
