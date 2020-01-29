import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("UserComparator3")
public class UserComparator3 extends AbstractUserComparator {
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator3(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lje;Lje;I)I",
		garbageValue = "-1179985017"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.world != var1.world) {
			return this.reversed ? var1.world - var2.world : var2.world - var1.world;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/io/File;",
		garbageValue = "1177059768"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "184774945"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-49"
	)
	static int method3499(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field1097 - 7.0D) * 256.0D);
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-62"
	)
	static final void method3497(boolean var0) {
		if (var0) {
			Client.field682 = Login.field1185 ? class160.field1996 : class160.field1995;
		} else {
			LinkedHashMap var1 = WorldMapSection2.clientPreferences.parameters;
			String var3 = Login.Login_username;
			int var4 = var3.length();
			int var5 = 0;

			for (int var6 = 0; var6 < var4; ++var6) {
				var5 = (var5 << 5) - var5 + var3.charAt(var6);
			}

			Client.field682 = var1.containsKey(var5) ? class160.field1994 : class160.field1993;
		}

	}

	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "762095007"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (class43.pcmPlayer1 != null) {
			class43.pcmPlayer1.run();
		}

		if (WorldMapLabelSize.pcmPlayer0 != null) {
			WorldMapLabelSize.pcmPlayer0.run();
		}

	}
}
