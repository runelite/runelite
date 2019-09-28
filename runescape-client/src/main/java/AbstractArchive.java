import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("AbstractArchive")
public abstract class AbstractArchive {
	@ObfuscatedName("so")
	@ObfuscatedSignature(
		signature = "Lbl;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Llr;"
	)
	@Export("gzipDecompressor")
	static GZipDecompressor gzipDecompressor;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 949229889
	)
	static int field3122;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -2001153217
	)
	@Export("groupCount")
	int groupCount;
	@ObfuscatedName("v")
	@Export("groupIds")
	int[] groupIds;
	@ObfuscatedName("u")
	@Export("groupNameHashes")
	int[] groupNameHashes;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Llk;"
	)
	@Export("groupNameHashTable")
	IntHashTable groupNameHashTable;
	@ObfuscatedName("p")
	@Export("groupCrcs")
	int[] groupCrcs;
	@ObfuscatedName("q")
	@Export("groupVersions")
	int[] groupVersions;
	@ObfuscatedName("m")
	@Export("fileCounts")
	int[] fileCounts;
	@ObfuscatedName("y")
	@Export("fileIds")
	int[][] fileIds;
	@ObfuscatedName("i")
	@Export("fileNameHashes")
	int[][] fileNameHashes;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Llk;"
	)
	@Export("fileNameHashTables")
	IntHashTable[] fileNameHashTables;
	@ObfuscatedName("b")
	@Export("groups")
	Object[] groups;
	@ObfuscatedName("o")
	@Export("files")
	Object[][] files;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 194523033
	)
	@Export("hash")
	public int hash;
	@ObfuscatedName("w")
	@Export("releaseGroups")
	boolean releaseGroups;
	@ObfuscatedName("t")
	@Export("shallowFiles")
	boolean shallowFiles;

	static {
		gzipDecompressor = new GZipDecompressor();
		field3122 = 0;
	}

	AbstractArchive(boolean var1, boolean var2) {
		this.releaseGroups = var1;
		this.shallowFiles = var2;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BS)V",
		garbageValue = "4095"
	)
	@Export("decodeIndex")
	void decodeIndex(byte[] var1) {
		this.hash = Username.method5147(var1, var1.length);
		Buffer var2 = new Buffer(MusicPatch.decompressBytes(var1));
		int var3 = var2.readUnsignedByte();
		if (var3 >= 5 && var3 <= 7) {
			if (var3 >= 6) {
				var2.readInt();
			}

			int var4 = var2.readUnsignedByte();
			if (var3 >= 7) {
				this.groupCount = var2.method5458();
			} else {
				this.groupCount = var2.readUnsignedShort();
			}

			int var5 = 0;
			int var6 = -1;
			this.groupIds = new int[this.groupCount];
			int var7;
			if (var3 >= 7) {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					this.groupIds[var7] = var5 += var2.method5458();
					if (this.groupIds[var7] > var6) {
						var6 = this.groupIds[var7];
					}
				}
			} else {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					this.groupIds[var7] = var5 += var2.readUnsignedShort();
					if (this.groupIds[var7] > var6) {
						var6 = this.groupIds[var7];
					}
				}
			}

			this.groupCrcs = new int[var6 + 1];
			this.groupVersions = new int[var6 + 1];
			this.fileCounts = new int[var6 + 1];
			this.fileIds = new int[var6 + 1][];
			this.groups = new Object[var6 + 1];
			this.files = new Object[var6 + 1][];
			if (var4 != 0) {
				this.groupNameHashes = new int[var6 + 1];

				for (var7 = 0; var7 < this.groupCount; ++var7) {
					this.groupNameHashes[this.groupIds[var7]] = var2.readInt();
				}

				this.groupNameHashTable = new IntHashTable(this.groupNameHashes);
			}

			for (var7 = 0; var7 < this.groupCount; ++var7) {
				this.groupCrcs[this.groupIds[var7]] = var2.readInt();
			}

			for (var7 = 0; var7 < this.groupCount; ++var7) {
				this.groupVersions[this.groupIds[var7]] = var2.readInt();
			}

			for (var7 = 0; var7 < this.groupCount; ++var7) {
				this.fileCounts[this.groupIds[var7]] = var2.readUnsignedShort();
			}

			int var8;
			int var9;
			int var10;
			int var11;
			int var12;
			if (var3 >= 7) {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					var8 = this.groupIds[var7];
					var9 = this.fileCounts[var8];
					var5 = 0;
					var10 = -1;
					this.fileIds[var8] = new int[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var12 = this.fileIds[var8][var11] = var5 += var2.method5458();
						if (var12 > var10) {
							var10 = var12;
						}
					}

					this.files[var8] = new Object[var10 + 1];
				}
			} else {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					var8 = this.groupIds[var7];
					var9 = this.fileCounts[var8];
					var5 = 0;
					var10 = -1;
					this.fileIds[var8] = new int[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var12 = this.fileIds[var8][var11] = var5 += var2.readUnsignedShort();
						if (var12 > var10) {
							var10 = var12;
						}
					}

					this.files[var8] = new Object[var10 + 1];
				}
			}

			if (var4 != 0) {
				this.fileNameHashes = new int[var6 + 1][];
				this.fileNameHashTables = new IntHashTable[var6 + 1];

				for (var7 = 0; var7 < this.groupCount; ++var7) {
					var8 = this.groupIds[var7];
					var9 = this.fileCounts[var8];
					this.fileNameHashes[var8] = new int[this.files[var8].length];

					for (var10 = 0; var10 < var9; ++var10) {
						this.fileNameHashes[var8][this.fileIds[var8][var10]] = var2.readInt();
					}

					this.fileNameHashTables[var8] = new IntHashTable(this.fileNameHashes[var8]);
				}
			}

		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "15"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIS)[B",
		garbageValue = "3526"
	)
	@Export("takeFile")
	public byte[] takeFile(int var1, int var2) {
		return this.takeFileEncrypted(var1, var2, (int[])null);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II[II)[B",
		garbageValue = "726476664"
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

			byte[] var5 = GrandExchangeOfferUnitPriceComparator.serialize(this.files[var1][var2], false);
			if (this.shallowFiles) {
				this.files[var1][var2] = null;
			}

			return var5;
		} else {
			return null;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1834518299"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-812316387"
	)
	public boolean method4127(int var1) {
		if (this.files.length == 1) {
			return this.tryLoadFile(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.tryLoadFile(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1731378181"
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "304263263"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2030453035"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		return this.groups[var1] != null ? 100 : 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "1500956982"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)[B",
		garbageValue = "1923776823"
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

			byte[] var4 = GrandExchangeOfferUnitPriceComparator.serialize(this.files[var1][var2], false);
			return var4;
		} else {
			return null;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IB)[B",
		garbageValue = "96"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "848617854"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IB)[I",
		garbageValue = "-61"
	)
	@Export("getGroupFileIds")
	public int[] getGroupFileIds(int var1) {
		return var1 >= 0 && var1 < this.fileIds.length ? this.fileIds[var1] : null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1937840631"
	)
	@Export("getGroupFileCount")
	public int getGroupFileCount(int var1) {
		return this.files[var1].length;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-101"
	)
	@Export("getGroupCount")
	public int getGroupCount() {
		return this.files.length;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1193777199"
	)
	@Export("clearGroups")
	public void clearGroups() {
		for (int var1 = 0; var1 < this.groups.length; ++var1) {
			this.groups[var1] = null;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1926198322"
	)
	@Export("clearFilesGroup")
	public void clearFilesGroup(int var1) {
		for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
			this.files[var1][var2] = null;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1263344370"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I[II)Z",
		garbageValue = "1408640769"
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
				byte[] var18;
				if (var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
					var18 = GrandExchangeOfferUnitPriceComparator.serialize(this.groups[var1], true);
					Buffer var8 = new Buffer(var18);
					var8.xteaDecrypt(var2, 5, var8.array.length);
				} else {
					var18 = GrandExchangeOfferUnitPriceComparator.serialize(this.groups[var1], false);
				}

				byte[] var20 = MusicPatch.decompressBytes(var18);
				if (this.releaseGroups) {
					this.groups[var1] = null;
				}

				if (var3 > 1) {
					int var9 = var20.length;
					--var9;
					int var10 = var20[var9] & 255;
					var9 -= var10 * var3 * 4;
					Buffer var11 = new Buffer(var20);
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

					byte[][] var19 = new byte[var3][];

					for (var14 = 0; var14 < var3; ++var14) {
						var19[var14] = new byte[var12[var14]];
						var12[var14] = 0;
					}

					var11.offset = var9;
					var14 = 0;

					for (var15 = 0; var15 < var10; ++var15) {
						int var16 = 0;

						for (int var17 = 0; var17 < var3; ++var17) {
							var16 += var11.readInt();
							System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
							var12[var17] += var16;
							var14 += var16;
						}
					}

					for (var15 = 0; var15 < var3; ++var15) {
						if (!this.shallowFiles) {
							var5[var4[var15]] = GrandExchangeEvents.method76(var19[var15], false);
						} else {
							var5[var4[var15]] = var19[var15];
						}
					}
				} else if (!this.shallowFiles) {
					var5[var4[0]] = GrandExchangeEvents.method76(var20, false);
				} else {
					var5[var4[0]] = var20;
				}

				return true;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-276996300"
	)
	@Export("getGroupId")
	public int getGroupId(String var1) {
		var1 = var1.toLowerCase();
		return this.groupNameHashTable.get(WorldMapData_0.hashString(var1));
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)I",
		garbageValue = "-1445606076"
	)
	@Export("getFileId")
	public int getFileId(int var1, String var2) {
		var2 = var2.toLowerCase();
		return this.fileNameHashTables[var1].get(WorldMapData_0.hashString(var2));
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;S)Z",
		garbageValue = "8717"
	)
	@Export("isValidFileName")
	public boolean isValidFileName(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(WorldMapData_0.hashString(var1));
		if (var3 < 0) {
			return false;
		} else {
			int var4 = this.fileNameHashTables[var3].get(WorldMapData_0.hashString(var2));
			return var4 >= 0;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
		garbageValue = "0"
	)
	@Export("takeFileByNames")
	public byte[] takeFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(WorldMapData_0.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(WorldMapData_0.hashString(var2));
		return this.takeFile(var3, var4);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
		garbageValue = "-68"
	)
	@Export("tryLoadFileByNames")
	public boolean tryLoadFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(WorldMapData_0.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(WorldMapData_0.hashString(var2));
		return this.tryLoadFile(var3, var4);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "1601927711"
	)
	@Export("tryLoadGroupByName")
	public boolean tryLoadGroupByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(WorldMapData_0.hashString(var1));
		return this.tryLoadGroup(var2);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-63"
	)
	@Export("loadRegionFromName")
	public void loadRegionFromName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(WorldMapData_0.hashString(var1));
		if (var2 >= 0) {
			this.loadRegionFromGroup(var2);
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-2026426136"
	)
	@Export("groupLoadPercentByName")
	public int groupLoadPercentByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(WorldMapData_0.hashString(var1));
		return this.groupLoadPercent(var2);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-715141816"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}
