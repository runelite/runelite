import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("UserComparator8")
public class UserComparator8 extends AbstractUserComparator {
	@ObfuscatedName("z")
	@Export("reversed")
	final boolean reversed;

	public UserComparator8(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljl;Ljl;I)I",
		garbageValue = "-2001610603"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world) {
			if (var2.world != Client.worldId) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world == Client.worldId) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/io/File;",
		garbageValue = "-1561719392"
	)
	@Export("getFile")
	public static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "11"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field754 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (class247.getWindowedMode() == 1) {
			ViewportMouse.client.setMaxCanvasSize(765, 503);
		} else {
			ViewportMouse.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			PacketBufferNode var1 = InterfaceParent.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(class247.getWindowedMode());
			var1.packetBuffer.writeShort(FloorDecoration.canvasWidth);
			var1.packetBuffer.writeShort(WallDecoration.canvasHeight);
			Client.packetWriter.addNode(var1);
		}

	}
}
