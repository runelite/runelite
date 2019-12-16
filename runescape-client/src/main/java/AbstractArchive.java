import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hz")
@Implements("AbstractArchive")
public abstract class AbstractArchive {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("gzipDecompressor")
	static GZipDecompressor gzipDecompressor;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 433676401
	)
	static int field3118;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1190752161
	)
	@Export("groupCount")
	int groupCount;
	@ObfuscatedName("y")
	@Export("groupIds")
	int[] groupIds;
	@ObfuscatedName("w")
	@Export("groupNameHashes")
	int[] groupNameHashes;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("groupNameHashTable")
	IntHashTable groupNameHashTable;
	@ObfuscatedName("b")
	@Export("groupCrcs")
	int[] groupCrcs;
	@ObfuscatedName("e")
	@Export("groupVersions")
	int[] groupVersions;
	@ObfuscatedName("x")
	@Export("fileCounts")
	int[] fileCounts;
	@ObfuscatedName("a")
	@Export("fileIds")
	int[][] fileIds;
	@ObfuscatedName("d")
	@Export("fileNameHashes")
	int[][] fileNameHashes;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Llq;"
	)
	@Export("fileNameHashTables")
	IntHashTable[] fileNameHashTables;
	@ObfuscatedName("o")
	@Export("groups")
	Object[] groups;
	@ObfuscatedName("v")
	@Export("files")
	Object[][] files;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1303272215
	)
	@Export("hash")
	public int hash;
	@ObfuscatedName("l")
	@Export("releaseGroups")
	boolean releaseGroups;
	@ObfuscatedName("t")
	@Export("shallowFiles")
	boolean shallowFiles;

	static {
		gzipDecompressor = new GZipDecompressor();
		field3118 = 0;
	}

	AbstractArchive(boolean var1, boolean var2) {
		this.releaseGroups = var1;
		this.shallowFiles = var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "105045873"
	)
	@Export("decodeIndex")
	void decodeIndex(byte[] var1) {
		int var3 = var1.length;
		int var2 = Timer.method5033(var1, 0, var3);
		this.hash = var2;
		Buffer var4 = new Buffer(Skills.decompressBytes(var1));
		int var5 = var4.readUnsignedByte();
		if (var5 >= 5 && var5 <= 7) {
			if (var5 >= 6) {
				var4.readInt();
			}

			int var6 = var4.readUnsignedByte();
			if (var5 >= 7) {
				this.groupCount = var4.method5559();
			} else {
				this.groupCount = var4.readUnsignedShort();
			}

			int var7 = 0;
			int var8 = -1;
			this.groupIds = new int[this.groupCount];
			int var9;
			if (var5 >= 7) {
				for (var9 = 0; var9 < this.groupCount; ++var9) {
					this.groupIds[var9] = var7 += var4.method5559();
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
						var14 = this.fileIds[var10][var13] = var7 += var4.method5559();
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "236985177"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)[B",
		garbageValue = "-429733349"
	)
	@Export("takeFile")
	public byte[] takeFile(int var1, int var2) {
		return this.takeFileEncrypted(var1, var2, (int[])null);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II[IB)[B",
		garbageValue = "1"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "25"
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "120"
	)
	public boolean method4157(int var1) {
		if (this.files.length == 1) {
			return this.tryLoadFile(0, var1);
		} else if (this.files[var1].length == 1) {
			return this.tryLoadFile(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "5"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1599628318"
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "6161"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		return this.groups[var1] != null ? 100 : 0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IS)[B",
		garbageValue = "19233"
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
		garbageValue = "-1676912636"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "1222234626"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1606315041"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)[I",
		garbageValue = "1353626049"
	)
	@Export("getGroupFileIds")
	public int[] getGroupFileIds(int var1) {
		return var1 >= 0 && var1 < this.fileIds.length ? this.fileIds[var1] : null;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-34"
	)
	@Export("getGroupFileCount")
	public int getGroupFileCount(int var1) {
		return this.files[var1].length;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "24456"
	)
	@Export("getGroupCount")
	public int getGroupCount() {
		return this.files.length;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
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
		garbageValue = "-667248353"
	)
	@Export("clearFilesGroup")
	public void clearFilesGroup(int var1) {
		for (int var2 = 0; var2 < this.files[var1].length; ++var2) {
			this.files[var1][var2] = null;
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1078168043"
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I[II)Z",
		garbageValue = "-518851469"
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
				byte[] var21;
				if (var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
					var21 = class268.serialize(this.groups[var1], true);
					Buffer var26 = new Buffer(var21);
					var26.xteaDecrypt(var2, 5, var26.array.length);
				} else {
					Object var9 = this.groups[var1];
					if (var9 == null) {
						var8 = null;
					} else if (var9 instanceof byte[]) {
						byte[] var23 = (byte[])((byte[])var9);
						var8 = var23;
					} else {
						if (!(var9 instanceof AbstractByteArrayCopier)) {
							throw new IllegalArgumentException();
						}

						AbstractByteArrayCopier var29 = (AbstractByteArrayCopier)var9;
						var8 = var29.get();
					}

					var21 = var8;
				}

				var8 = Skills.decompressBytes(var21);
				if (this.releaseGroups) {
					this.groups[var1] = null;
				}

				int var10;
				if (var3 > 1) {
					int var22 = var8.length;
					--var22;
					var10 = var8[var22] & 255;
					var22 -= var3 * var10 * 4;
					Buffer var11 = new Buffer(var8);
					int[] var12 = new int[var3];
					var11.offset = var22;

					int var14;
					int var15;
					for (int var13 = 0; var13 < var10; ++var13) {
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
					for (var15 = 0; var15 < var10; ++var15) {
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
					var10 = var4[0];
					Object var27;
					if (var8 == null) {
						var27 = null;
					} else if (var8.length > 136) {
						DirectByteArrayCopier var28 = new DirectByteArrayCopier();
						var28.set(var8);
						var27 = var28;
					} else {
						var27 = var8;
					}

					var5[var10] = var27;
				} else {
					var5[var4[0]] = var8;
				}

				return true;
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-201265341"
	)
	@Export("getGroupId")
	public int getGroupId(String var1) {
		var1 = var1.toLowerCase();
		return this.groupNameHashTable.get(class81.hashString(var1));
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)I",
		garbageValue = "-531189072"
	)
	@Export("getFileId")
	public int getFileId(int var1, String var2) {
		var2 = var2.toLowerCase();
		return this.fileNameHashTables[var1].get(class81.hashString(var2));
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)Z",
		garbageValue = "-614905429"
	)
	@Export("isValidFileName")
	public boolean isValidFileName(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(class81.hashString(var1));
		if (var3 < 0) {
			return false;
		} else {
			int var4 = this.fileNameHashTables[var3].get(class81.hashString(var2));
			return var4 >= 0;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;I)[B",
		garbageValue = "-1446365619"
	)
	@Export("takeFileByNames")
	public byte[] takeFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(class81.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(class81.hashString(var2));
		return this.takeFile(var3, var4);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;B)Z",
		garbageValue = "-92"
	)
	@Export("tryLoadFileByNames")
	public boolean tryLoadFileByNames(String var1, String var2) {
		var1 = var1.toLowerCase();
		var2 = var2.toLowerCase();
		int var3 = this.groupNameHashTable.get(class81.hashString(var1));
		int var4 = this.fileNameHashTables[var3].get(class81.hashString(var2));
		return this.tryLoadFile(var3, var4);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "1377272883"
	)
	@Export("tryLoadGroupByName")
	public boolean tryLoadGroupByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(class81.hashString(var1));
		return this.tryLoadGroup(var2);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)V",
		garbageValue = "1980"
	)
	@Export("loadRegionFromName")
	public void loadRegionFromName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(class81.hashString(var1));
		if (var2 >= 0) {
			this.loadRegionFromGroup(var2);
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)I",
		garbageValue = "27201"
	)
	@Export("groupLoadPercentByName")
	public int groupLoadPercentByName(String var1) {
		var1 = var1.toLowerCase();
		int var2 = this.groupNameHashTable.get(class81.hashString(var1));
		return this.groupLoadPercent(var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(BI)C",
		garbageValue = "1023580311"
	)
	public static char method4124(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class287.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1255135753"
	)
	static int method4166(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == ScriptOpcodes.MES) {
			var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
			class83.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == ScriptOpcodes.ANIM) {
			class188.Interpreter_intStackSize -= 2;
			BuddyRankComparator.performPlayerAnimation(Message.localPlayer, Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field1078) {
				Interpreter.field1077 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
				var10 = 0;
				if (SecureRandomFuture.isNumber(var3)) {
					var10 = ArchiveDiskActionHandler.parseInt(var3);
				}

				PacketBufferNode var12 = class2.getPacketBufferNode(ClientPacket.field2192, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					var14 = class2.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					var14 = class2.getPacketBufferNode(ClientPacket.field2188, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var15 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
						WorldMapArea.method364(var15, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						class188.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
						Widget var13 = Tile.getWidget(var9);
						GrandExchangeOfferNameComparator.clickWidget(var13, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						class188.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? UserComparator7.field1946 : class197.field2398;
						GrandExchangeOfferNameComparator.clickWidget(var11, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						NetFileRequest.mouseCam = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Interpreter.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						Interpreter.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						FriendSystem.savePreferences();
						return 1;
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var3 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						class13.openURL(var3, var4, false);
						return 1;
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var15 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var14 = class2.getPacketBufferNode(ClientPacket.field2178, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var15);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var15 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						class65.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[class65.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = class2.getPacketBufferNode(ClientPacket.field2218, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + ViewportMouse.stringCp1252NullTerminatedByteSize(var7) + ViewportMouse.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							var6.packetBuffer.method5696(var15);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						class295.setTapToDrop(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = class42.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETOCULUSORBSPEED) {
						class188.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						class188.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--class188.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = AttackOption.canvasHeight;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--class188.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						class188.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field790 = 3;
						Client.field791 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field790 = 2;
						Client.field791 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field790 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field790 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field790 = 3;
						Client.field791 = var2 ? UserComparator7.field1946.id : class197.field2398.id;
						return 1;
					} else {
						boolean var8;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Interpreter.clientPreferences.hideUsername = var8;
							FriendSystem.savePreferences();
							return 1;
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Interpreter.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								Interpreter.clientPreferences.rememberedUsername = "";
								FriendSystem.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == ScriptOpcodes.SETTITLEMUSICENABLED) {
							var8 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
							if (var8 == Interpreter.clientPreferences.titleMusicDisabled) {
								Interpreter.clientPreferences.titleMusicDisabled = !var8;
								FriendSystem.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETTITLEMUSICENABLED) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Interpreter.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = class48.method861();
							return 1;
						} else if (var0 == 3155) {
							--class65.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							class188.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--class188.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--class188.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--class65.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--class188.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--class188.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							class188.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							class188.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							class188.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--class188.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--class188.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--class188.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--class65.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--class65.Interpreter_stringStackSize;
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("em")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	static final void method4222() {
		Scene.Scene_isLowDetail = false;
		Client.isLowDetail = false;
	}
}
