import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("as")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkm;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lkm;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1121640995
	)
	@Export("index")
	int index;
	@ObfuscatedName("z")
	volatile boolean field3155;
	@ObfuscatedName("al")
	boolean field3157;
	@ObfuscatedName("av")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -150911311
	)
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 196530351
	)
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1519910241
	)
	int field3152;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		signature = "(Lkm;Lkm;IZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6) {
		super(var4, var5);
		this.field3155 = false;
		this.field3157 = false;
		this.field3152 = -1;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var3;
		this.field3157 = var6;
		int var8 = this.index;
		if (AbstractRasterProvider.NetCache_reference != null) {
			AbstractRasterProvider.NetCache_reference.offset = var8 * 8 + 5;
			int var9 = AbstractRasterProvider.NetCache_reference.readInt();
			int var10 = AbstractRasterProvider.NetCache_reference.readInt();
			this.loadIndex(var9, var10);
		} else {
			ViewportMouse.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var8] = this;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2144523901"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
		PendingSpawn.method1653(this.index, var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "0"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else {
			return this.validGroups[var1] ? 100 : Huffman.method3948(this.index, var1);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "3211"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			SecureRandomFuture.method2056(var1, this.archiveDisk, this);
		} else {
			ViewportMouse.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "44"
	)
	public boolean method4258() {
		return this.field3155;
	}

	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-249697380"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3155) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var1 = Huffman.method3948(255, this.index);
			if (var1 >= 100) {
				var1 = 99;
			}

			return var1;
		}
	}

	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1381214916"
	)
	@Export("loadIndex")
	void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			SecureRandomFuture.method2056(this.index, this.masterDisk, this);
		} else {
			ViewportMouse.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "(I[BZZB)V",
		garbageValue = "-36"
	)
	@Export("write")
	void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3155) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				class294.method5328(this.index, var2, this.masterDisk);
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				class294.method5328(var1, var2, this.archiveDisk);
				this.validGroups[var1] = true;
			}

			if (var4) {
				Object[] var5 = super.groups;
				Object var7;
				if (var2 == null) {
					var7 = null;
				} else if (var2.length > 136) {
					DirectByteArrayCopier var8 = new DirectByteArrayCopier();
					var8.set(var2);
					var7 = var8;
				} else {
					var7 = var2;
				}

				var5[var1] = var7;
			}
		}

	}

	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "(Lkm;I[BZI)V",
		garbageValue = "-1554685282"
	)
	@Export("load")
	public void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3155) {
				throw new RuntimeException();
			}

			if (var3 == null) {
				ViewportMouse.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length);
			var5 = (int)Archive_crc.getValue();
			if (var5 != this.indexCrc) {
				ViewportMouse.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			Buffer var11 = new Buffer(HealthBarUpdate.decompressBytes(var3));
			int var12 = var11.readUnsignedByte();
			if (var12 != 5 && var12 != 6) {
				throw new RuntimeException(var12 + "," + this.index + "," + var2);
			}

			int var8 = 0;
			if (var12 >= 6) {
				var8 = var11.readInt();
			}

			if (var8 != this.indexVersion) {
				ViewportMouse.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
				return;
			}

			this.decodeIndex(var3);
			this.loadAllLocal();
		} else {
			if (!var4 && var2 == this.field3152) {
				this.field3155 = true;
			}

			if (var3 == null || var3.length <= 2) {
				this.validGroups[var2] = false;
				if (this.field3157 || var4) {
					ViewportMouse.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			Archive_crc.reset();
			Archive_crc.update(var3, 0, var3.length - 2);
			var5 = (int)Archive_crc.getValue();
			int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
			if (var5 != super.groupCrcs[var2] || var6 != super.groupVersions[var2]) {
				this.validGroups[var2] = false;
				if (this.field3157 || var4) {
					ViewportMouse.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

				return;
			}

			this.validGroups[var2] = true;
			if (var4) {
				Object[] var7 = super.groups;
				Object var9;
				if (var3 == null) {
					var9 = null;
				} else if (var3.length > 136) {
					DirectByteArrayCopier var10 = new DirectByteArrayCopier();
					var10.set(var3);
					var9 = var10;
				} else {
					var9 = var3;
				}

				var7[var2] = var9;
			}
		}

	}

	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-72081442"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3155 = true;
		} else {
			this.field3152 = -1;

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
						if (ArchiveDiskActionHandler.field3144 == 0) {
							ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
							ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
							ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
							ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
						}

						ArchiveDiskActionHandler.field3144 = 600;
					}

					this.field3152 = var1;
				}
			}

			if (this.field3152 == -1) {
				this.field3155 = true;
			}

		}
	}

	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "2032179519"
	)
	public boolean method4267(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "0"
	)
	public boolean method4268(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "889991726"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lgx;Llv;I)Lgb;",
		garbageValue = "1775123545"
	)
	public static PacketBufferNode method4265(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2;
		if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
			var2 = new PacketBufferNode();
		} else {
			var2 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
		}

		var2.clientPacket = var0;
		var2.clientPacketLength = var0.length;
		if (var2.clientPacketLength == -1) {
			var2.packetBuffer = new PacketBuffer(260);
		} else if (var2.clientPacketLength == -2) {
			var2.packetBuffer = new PacketBuffer(10000);
		} else if (var2.clientPacketLength <= 18) {
			var2.packetBuffer = new PacketBuffer(20);
		} else if (var2.clientPacketLength <= 98) {
			var2.packetBuffer = new PacketBuffer(100);
		} else {
			var2.packetBuffer = new PacketBuffer(260);
		}

		var2.packetBuffer.setIsaacCipher(var1);
		var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
		var2.index = 0;
		return var2;
	}

	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "35"
	)
	static final void method4269(int var0) {
		if (class162.loadInterface(var0)) {
			class225.method4122(Widget.Widget_interfaceComponents[var0], -1);
		}
	}
}
