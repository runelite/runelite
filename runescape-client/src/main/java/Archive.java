import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("aw")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "Ldz;"
	)
	@Export("textureProvider")
	static TextureProvider textureProvider;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -341991117
	)
	@Export("index")
	int index;
	@ObfuscatedName("k")
	volatile boolean field3131;
	@ObfuscatedName("ac")
	boolean field3129;
	@ObfuscatedName("az")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 2033402119
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -302073813
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -630367829
	)
	int field3137;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lkg;Lkg;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3131 = false;
		this.field3129 = false;
		this.field3137 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3129 = var6;
		int var8 = this.index;
		if (AbstractWorldMapIcon.NetCache_reference != null) {
			AbstractWorldMapIcon.NetCache_reference.offset = var8 * 8 + 5;
			int var9 = AbstractWorldMapIcon.NetCache_reference.readInt();
			int var10 = AbstractWorldMapIcon.NetCache_reference.readInt();
			this.loadIndex(var9, var10);
		} else {
			WorldMapDecoration.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var8] = this;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "15"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
		int var2 = this.index;
		long var3 = (long)((var2 << 16) + var1);
		NetFileRequest var5 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var3);
		if (var5 != null) {
			NetCache.NetCache_pendingWritesQueue.addLast(var5);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2030453035"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else if (this.validGroups[var1]) {
			return 100;
		} else {
			int var3 = this.index;
			long var4 = (long)((var3 << 16) + var1);
			int var2;
			if (WorldMapEvent.NetCache_currentResponse != null && WorldMapEvent.NetCache_currentResponse.key == var4) {
				var2 = FaceNormal.NetCache_responseArchiveBuffer.offset * 99 / (FaceNormal.NetCache_responseArchiveBuffer.array.length - WorldMapEvent.NetCache_currentResponse.padding) + 1;
			} else {
				var2 = 0;
			}

			return var2;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "848617854"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			WorldMapArea.method429(var1, this.archiveDisk, this);
		} else {
			WorldMapDecoration.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2035998705"
	)
	public boolean method4235() {
		return this.field3131;
	}

	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1744835603"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3131) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var2 = this.index;
			long var3 = (long)(var2 + 16711680);
			int var1;
			if (WorldMapEvent.NetCache_currentResponse != null && WorldMapEvent.NetCache_currentResponse.key == var3) {
				var1 = FaceNormal.NetCache_responseArchiveBuffer.offset * 99 / (FaceNormal.NetCache_responseArchiveBuffer.array.length - WorldMapEvent.NetCache_currentResponse.padding) + 1;
			} else {
				var1 = 0;
			}

			int var5 = var1;
			if (var1 >= 100) {
				var5 = 99;
			}

			return var5;
		}
	}

	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "684167120"
	)
	@Export("loadIndex")
	void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			WorldMapArea.method429(this.index, this.masterDisk, this);
		} else {
			WorldMapDecoration.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "(I[BZZI)V",
		garbageValue = "1316980907"
	)
	@Export("write")
	void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3131) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				CollisionMap.method3536(this.index, var2, this.masterDisk);
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				CollisionMap.method3536(var1, var2, this.archiveDisk);
				this.validGroups[var1] = true;
			}

			if (var4) {
				super.groups[var1] = GrandExchangeEvents.method76(var2, false);
			}
		}

	}

	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "(Lkg;I[BZB)V",
		garbageValue = "1"
	)
	@Export("load")
	public void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3131) {
				throw new RuntimeException();
			}

			if (var3 == null) {
				WorldMapDecoration.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length);
			var5 = (int)Archive_crc.getValue();
			if (var5 != this.indexCrc) {
				WorldMapDecoration.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Buffer var9 = new Buffer(MusicPatch.decompressBytes(var3));
			int var7 = var9.readUnsignedByte();
			if (var7 != 5 && var7 != 6) {
				throw new RuntimeException(var7 + "," + this.index + "," + var2);
			}

			int var8 = 0;
			if (var7 >= 6) {
				var8 = var9.readInt();
			}

			if (var8 != this.indexVersion) {
				WorldMapDecoration.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			this.decodeIndex(var3);
			this.loadAllLocal();
		} else {
			if (!var4 && var2 == this.field3137) {
				this.field3131 = true;
			}

			if (var3 == null || var3.length <= 2) {
				this.validGroups[var2] = false;
				if (this.field3129 || var4) {
					WorldMapDecoration.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length - 2);
			var5 = (int)Archive_crc.getValue();
			int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
			if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
				this.validGroups[var2] = false;
				if (this.field3129 || var4) {
					WorldMapDecoration.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			this.validGroups[var2] = true;
			if (var4) {
				super.groups[var2] = GrandExchangeEvents.method76(var3, false);
			}
		}

	}

	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "8"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3131 = true;
		} else {
			this.field3137 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					ArchiveDisk var2 = this.archiveDisk;
					ArchiveDiskAction var4 = new ArchiveDiskAction();
					var4.type = 1;
					var4.key = (long)var1;
					var4.archiveDisk = var2;
					var4.archive = this;
					synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
						ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var4);
					}

					synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
						if (ArchiveDiskActionHandler.field3127 == 0) {
							UserComparator5.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
							UserComparator5.ArchiveDiskActionHandler_thread.setDaemon(true);
							UserComparator5.ArchiveDiskActionHandler_thread.start();
							UserComparator5.ArchiveDiskActionHandler_thread.setPriority(5);
						}

						ArchiveDiskActionHandler.field3127 = 600;
					}

					this.field3137 = var1;
				}
			}

			if (this.field3137 == -1) {
				this.field3131 = true;
			}

		}
	}

	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-433634856"
	)
	public boolean method4243(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "805361618"
	)
	public boolean method4244(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "727894645"
	)
	@Export("loadPercent")
	public int loadPercent() {
		int var1 = 0;
		int var2 = 0;

		int var3;
		for (var3 = 0; var3 < super.groups.length; ++var3) {
			if (super.fileCounts[var3] > 0) {
				var1 += 100;
				var2 += this.groupLoadPercent(var3);
			}
		}

		if (var1 == 0) {
			return 100;
		} else {
			var3 = var2 * 100 / var1;
			return var3;
		}
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-212508230"
	)
	static final void method4278() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsInClanChat();
		}

	}

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "26372698"
	)
	static void method4250() {
		if (StudioGame.field3086 != null) {
			Client.field905 = Client.cycle;
			StudioGame.field3086.method4300();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					StudioGame.field3086.method4301(class223.baseX * 64 + (Client.players[var0].x >> 7), class286.baseY * 64 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
