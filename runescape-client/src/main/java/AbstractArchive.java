import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("AbstractArchive")
public abstract class AbstractArchive {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("gzipDecompressor")
	static GZipDecompressor gzipDecompressor;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1542762901
	)
	static int field3148;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 836955159
	)
	@Export("groupCount")
	int groupCount;
	@ObfuscatedName("o")
	@Export("groupIds")
	int[] groupIds;
	@ObfuscatedName("e")
	@Export("groupNameHashes")
	int[] groupNameHashes;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llk;"
	)
	@Export("groupNameHashTable")
	IntHashTable groupNameHashTable;
	@ObfuscatedName("g")
	@Export("groupCrcs")
	int[] groupCrcs;
	@ObfuscatedName("d")
	@Export("groupVersions")
	int[] groupVersions;
	@ObfuscatedName("l")
	@Export("fileCounts")
	int[] fileCounts;
	@ObfuscatedName("j")
	@Export("fileIds")
	int[][] fileIds;
	@ObfuscatedName("m")
	@Export("fileNameHashes")
	int[][] fileNameHashes;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Llk;"
	)
	@Export("fileNameHashTables")
	IntHashTable[] fileNameHashTables;
	@ObfuscatedName("h")
	@Export("groups")
	Object[] groups;
	@ObfuscatedName("v")
	@Export("files")
	Object[][] files;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 648103117
	)
	@Export("hash")
	public int hash;
	@ObfuscatedName("w")
	@Export("releaseGroups")
	boolean releaseGroups;
	@ObfuscatedName("k")
	@Export("shallowFiles")
	boolean shallowFiles;

	static {
		gzipDecompressor = new GZipDecompressor();
		field3148 = 0;
	}

	AbstractArchive(boolean var1, boolean var2) {
		this.releaseGroups = var1;
		this.shallowFiles = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "324274119"
	)
	@Export("decodeIndex")
	void decodeIndex(byte[] var1) {
		this.hash = Timer.method5068(var1, var1.length);
		Buffer var2 = new Buffer(class2.decompressBytes(var1));
		int var3 = var2.readUnsignedByte();
		if (var3 >= 5 && var3 <= 7) {
			if (var3 >= 6) {
				var2.readInt();
			}

			int var4 = var2.readUnsignedByte();
			if (var3 >= 7) {
				this.groupCount = var2.method5592();
			} else {
				this.groupCount = var2.readUnsignedShort();
			}

			int var5 = 0;
			int var6 = -1;
			this.groupIds = new int[this.groupCount];
			int var7;
			if (var3 >= 7) {
				for (var7 = 0; var7 < this.groupCount; ++var7) {
					this.groupIds[var7] = var5 += var2.method5592();
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
						var12 = this.fileIds[var8][var11] = var5 += var2.method5592();
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1758408707"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIS)[B",
		garbageValue = "-10226"
	)
	@Export("takeFile")
	public byte[] takeFile(int var1, int var2) {
		return this.takeFileEncrypted(var1, var2, (int[])null);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II[IS)[B",
		garbageValue = "-26073"
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

			Object var5 = this.files[var1][var2];
			byte[] var7;
			if (var5 == null) {
				var7 = null;
			} else if (var5 instanceof byte[]) {
				byte[] var6 = (byte[])((byte[])var5);
				var7 = var6;
			} else {
				if (!(var5 instanceof AbstractByteArrayCopier)) {
					throw new IllegalArgumentException();
				}

				AbstractByteArrayCopier var8 = (AbstractByteArrayCopier)var5;
				var7 = var8.get();
			}

			if (this.shallowFiles) {
				this.files[var1][var2] = null;
			}

			return var7;
		} else {
			return null;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "2"
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-56"
	)
	public boolean method4224(int var1) {
		if (this.files.length == 1) {
			return this.tryLoadFile(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.tryLoadFile(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1747453394"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "8"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "27"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		return this.groups[var1] != null ? 100 : 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "-1122703928"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)[B",
		garbageValue = "11"
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

			Object var4 = this.files[var1][var2];
			byte[] var6;
			if (var4 == null) {
				var6 = null;
			} else if (var4 instanceof byte[]) {
				byte[] var5 = (byte[])((byte[])var4);
				var6 = var5;
			} else {
				if (!(var4 instanceof AbstractByteArrayCopier)) {
					throw new IllegalArgumentException();
				}

				AbstractByteArrayCopier var7 = (AbstractByteArrayCopier)var4;
				var6 = var7.get();
			}

			return var6;
		} else {
			return null;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IB)[B",
		garbageValue = "20"
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
		signature = "(II)V",
		garbageValue = "1179679189"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "1870169263"
	)
	@Export("getGroupFileIds")
	public int[] getGroupFileIds(int var1) {
		return var1 >= 0 && var1 < this.fileIds.length ? this.fileIds[var1] : null;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "83"
	)
	@Export("getGroupFileCount")
	public int getGroupFileCount(int var1) {
		return this.files[var1].length;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2083361836"
	)
	@Export("getGroupCount")
	public int getGroupCount() {
		return this.files.length;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2144159595"
	)
	@Export("clearGroups")
	public void clearGroups() {
		for (int var1 = 0; var1 < this.groups.length; ++var1) {
			this.groups[var1] = null;
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1860298470"
	)
	@Export("clearFilesGroup")
	public void clearFilesGroup(int var1) {
		for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
			this.files[var1][var2] = null;
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2052832906"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I[IB)Z",
		garbageValue = "-1"
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
				byte[] var8;
				Object var9;
				byte[] var10;
				byte[] var21;
				AbstractByteArrayCopier var26;
				if (var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
					var9 = this.groups[var1];
					if (var9 == null) {
						var8 = null;
					} else if (var9 instanceof byte[]) {
						var10 = (byte[])((byte[])var9);
						var8 = WorldMapSectionType.method250(var10);
					} else {
						if (!(var9 instanceof AbstractByteArrayCopier)) {
							throw new IllegalArgumentException();
						}

						var26 = (AbstractByteArrayCopier)var9;
						var8 = var26.get();
					}

					var21 = var8;
					Buffer var27 = new Buffer(var8);
					var27.xteaDecrypt(var2, 5, var27.array.length);
				} else {
					var9 = this.groups[var1];
					if (var9 == null) {
						var8 = null;
					} else if (var9 instanceof byte[]) {
						var10 = (byte[])((byte[])var9);
						var8 = var10;
					} else {
						if (!(var9 instanceof AbstractByteArrayCopier)) {
							throw new IllegalArgumentException();
						}

						var26 = (AbstractByteArrayCopier)var9;
						var8 = var26.get();
					}

					var21 = var8;
				}

				var8 = class2.decompressBytes(var21);
				if (this.releaseGroups) {
					this.groups[var1] = null;
				}

				int var23;
				if (var3 > 1) {
					int var22 = var8.length;
					--var22;
					var23 = var8[var22] & 255;
					var22 -= var23 * var3 * 4;
					Buffer var11 = new Buffer(var8);
					int[] var12 = new int[var3];
					var11.offset = var22;

					int var14;
					int var15;
					for (int var13 = 0; var13 < var23; ++var13) {
						var14 = 0;

						for (var15 = 0; var15 < var3; ++var15) {
							var14 += var11.readInt();
							var12[var15] += var14;
						}
					}

					byte[][] var24 = new byte[var3][];

					for (var14 = 0; var14 < var3; ++var14) {
						var24[var14] = new byte[var12[var14]];
						var12[var14] = 0;
					}

					var11.offset = var22;
					var14 = 0;

					int var17;
					for (var15 = 0; var15 < var23; ++var15) {
						int var16 = 0;

						for (var17 = 0; var17 < var3; ++var17) {
							var16 += var11.readInt();
							System.arraycopy(var8, var14, var24[var17], var12[var17], var16);
							var12[var17] += var16;
							var14 += var16;
						}
					}

					for (var15 = 0; var15 < var3; ++var15) {
						if (!this.shallowFiles) {
							var17 = var4[var15];
							byte[] var19 = var24[var15];
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
							var5[var4[var15]] = var24[var15];
						}
					}
				} else if (!this.shallowFiles) {
					var23 = var4[0];
					Object var28;
					if (var8 == null) {
						var28 = null;
					} else if (var8.length > 136) {
						DirectByteArrayCopier var29 = new DirectByteArrayCopier();
						var29.set(var8);
						var28 = var29;
					} else {
						var28 = var8;
					}

					var5[var23] = var28;
				} else {
					var5[var4[0]] = var8;
				}

				return true;
			}
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-674594159"
	)
	@Export("getGroupId")
	public int getGroupId(String var1) {
		var1 = var1.toLowerCase();
		return this.groupNameHashTable.get(GameShell.hashString(var1));
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)I",
		garbageValue = "-1938235992"
	)
	@Export("getFileId")
	public int getFileId(int var1, String var2) {
		var2 = var2.toLowerCase();
		return this.fileNameHashTables[var1].get(GameShell.hashString(var2));
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
		garbageValue = "1887226326"
	)
	@Export("isValidFileName")
	public boolean isValidFileName(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(GameShell.hashString(var1));
		if (var3 < 0) {
			return false;
		} else {
			int var4 = this.fileNameHashTables[var3].get(GameShell.hashString(var2));
			return var4 >= 0;
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;B)[B",
		garbageValue = "-87"
	)
	@Export("takeFileByNames")
	public byte[] takeFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(GameShell.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(GameShell.hashString(var2));
		return this.takeFile(var3, var4);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
		garbageValue = "1903495537"
	)
	@Export("tryLoadFileByNames")
	public boolean tryLoadFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(GameShell.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(GameShell.hashString(var2));
		return this.tryLoadFile(var3, var4);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "-1357995676"
	)
	@Export("tryLoadGroupByName")
	public boolean tryLoadGroupByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(GameShell.hashString(var1));
		return this.tryLoadGroup(var2);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "994130396"
	)
	@Export("loadRegionFromName")
	public void loadRegionFromName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(GameShell.hashString(var1));
		if (var2 >= 0) {
			this.loadRegionFromGroup(var2);
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "1917128614"
	)
	@Export("groupLoadPercentByName")
	public int groupLoadPercentByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(GameShell.hashString(var1));
		return this.groupLoadPercent(var2);
	}
}
