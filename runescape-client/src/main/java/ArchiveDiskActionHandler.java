import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	static NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1217750145
	)
	public static int field3155;
	@ObfuscatedName("g")
	@Export("ArchiveDiskActionHandler_lock")
	public static Object ArchiveDiskActionHandler_lock;
	@ObfuscatedName("z")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3155 = 0;
		ArchiveDiskActionHandler_lock = new Object();
	}

	ArchiveDiskActionHandler() {
	}

	public void run() {
		try {
			while (true) {
				ArchiveDiskAction var1;
				synchronized(ArchiveDiskActionHandler_requestQueue) {
					var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
				}

				if (var1 != null) {
					if (var1.type == 0) {
						var1.archiveDisk.write((int)var1.key, var1.data, var1.data.length);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							var1.remove();
						}
					} else if (var1.type == 1) {
						var1.data = var1.archiveDisk.read((int)var1.key);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							ArchiveDiskActionHandler_responseQueue.addFirst(var1);
						}
					}

					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3155 <= 1) {
							field3155 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						field3155 = 600;
					}
				} else {
					long var8 = 99L;

					try {
						Thread.sleep(var8);
					} catch (InterruptedException var15) {
					}

					try {
						Thread.sleep(1L);
					} catch (InterruptedException var14) {
					}

					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3155 <= 1) {
							field3155 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						--field3155;
					}
				}
			}
		} catch (Exception var17) {
			Calendar.RunException_sendStackTrace((String)null, var17);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lgc;I)I",
		garbageValue = "-1277174237"
	)
	@Export("compareStrings")
	public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
		int var3 = var0.length();
		int var4 = var1.length();
		int var5 = 0;
		int var6 = 0;
		byte var7 = 0;
		byte var8 = 0;

		while (var5 - var7 < var3 || var6 - var8 < var4) {
			if (var5 - var7 >= var3) {
				return -1;
			}

			if (var6 - var8 >= var4) {
				return 1;
			}

			char var9;
			if (var7 != 0) {
				var9 = (char)var7;
				boolean var14 = false;
			} else {
				var9 = var0.charAt(var5++);
			}

			char var10;
			if (var8 != 0) {
				var10 = (char)var8;
				boolean var15 = false;
			} else {
				var10 = var1.charAt(var6++);
			}

			byte var11;
			if (var9 == 198) {
				var11 = 69;
			} else if (var9 == 230) {
				var11 = 101;
			} else if (var9 == 223) {
				var11 = 115;
			} else if (var9 == 338) {
				var11 = 69;
			} else if (var9 == 339) {
				var11 = 101;
			} else {
				var11 = 0;
			}

			var7 = var11;
			byte var12;
			if (var10 == 198) {
				var12 = 69;
			} else if (var10 == 230) {
				var12 = 101;
			} else if (var10 == 223) {
				var12 = 115;
			} else if (var10 == 338) {
				var12 = 69;
			} else if (var10 == 339) {
				var12 = 101;
			} else {
				var12 = 0;
			}

			var8 = var12;
			var9 = PacketWriter.standardizeChar(var9, var2);
			var10 = PacketWriter.standardizeChar(var10, var2);
			if (var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
				var9 = Character.toLowerCase(var9);
				var10 = Character.toLowerCase(var10);
				if (var9 != var10) {
					return StudioGame.lowercaseChar(var9, var2) - StudioGame.lowercaseChar(var10, var2);
				}
			}
		}

		int var16 = Math.min(var3, var4);

		int var17;
		char var20;
		for (var17 = 0; var17 < var16; ++var17) {
			if (var2 == Language.Language_FR) {
				var5 = var3 - 1 - var17;
				var6 = var4 - 1 - var17;
			} else {
				var6 = var17;
				var5 = var17;
			}

			char var18 = var0.charAt(var5);
			var20 = var1.charAt(var6);
			if (var18 != var20 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
				var18 = Character.toLowerCase(var18);
				var20 = Character.toLowerCase(var20);
				if (var20 != var18) {
					return StudioGame.lowercaseChar(var18, var2) - StudioGame.lowercaseChar(var20, var2);
				}
			}
		}

		var17 = var3 - var4;
		if (var17 != 0) {
			return var17;
		} else {
			for (int var19 = 0; var19 < var16; ++var19) {
				var20 = var0.charAt(var19);
				char var13 = var1.charAt(var19);
				if (var20 != var13) {
					return StudioGame.lowercaseChar(var20, var2) - StudioGame.lowercaseChar(var13, var2);
				}
			}

			return 0;
		}
	}
}
