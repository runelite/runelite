import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("TaskHandler")
public class TaskHandler implements Runnable {
	@ObfuscatedName("c")
	@Export("javaVendor")
	public static String javaVendor;
	@ObfuscatedName("x")
	@Export("javaVersion")
	public static String javaVersion;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lfc;"
	)
	@Export("current")
	Task current;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lfc;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("l")
	@Export("thread")
	Thread thread;
	@ObfuscatedName("u")
	@Export("isClosed")
	boolean isClosed;

	public TaskHandler() {
		this.current = null;
		this.task = null;
		this.isClosed = false;
		javaVendor = "Unknown";
		javaVersion = "1.6";

		try {
			javaVendor = System.getProperty("java.vendor");
			javaVersion = System.getProperty("java.version");
		} catch (Exception var2) {
		}

		this.isClosed = false;
		this.thread = new Thread(this);
		this.thread.setPriority(10);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-72"
	)
	@Export("close")
	public final void close() {
		synchronized(this) {
			this.isClosed = true;
			this.notifyAll();
		}

		try {
			this.thread.join();
		} catch (InterruptedException var3) {
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIILjava/lang/Object;I)Lfc;",
		garbageValue = "-1315009014"
	)
	@Export("newTask")
	final Task newTask(int var1, int var2, int var3, Object var4) {
		Task var5 = new Task();
		var5.type = var1;
		var5.intArgument = var2;
		var5.objectArgument = var4;
		synchronized(this) {
			if (this.task != null) {
				this.task.next = var5;
				this.task = var5;
			} else {
				this.task = this.current = var5;
			}

			this.notify();
			return var5;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IS)Lfc;",
		garbageValue = "-16284"
	)
	@Export("newSocketTask")
	public final Task newSocketTask(String var1, int var2) {
		return this.newTask(1, var2, 0, var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Runnable;II)Lfc;",
		garbageValue = "-1670540626"
	)
	@Export("newThreadTask")
	public final Task newThreadTask(Runnable var1, int var2) {
		return this.newTask(2, var2, 0, var1);
	}

	public final void run() {
		while (true) {
			Task var1;
			synchronized(this) {
				while (true) {
					if (this.isClosed) {
						return;
					}

					if (this.current != null) {
						var1 = this.current;
						this.current = this.current.next;
						if (this.current == null) {
							this.task = null;
						}
						break;
					}

					try {
						this.wait();
					} catch (InterruptedException var8) {
					}
				}
			}

			try {
				int var5 = var1.type;
				if (var5 == 1) {
					var1.result = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
				} else if (var5 == 2) {
					Thread var3 = new Thread((Runnable)var1.objectArgument);
					var3.setDaemon(true);
					var3.start();
					var3.setPriority(var1.intArgument);
					var1.result = var3;
				} else if (var5 == 4) {
					var1.result = new DataInputStream(((URL)var1.objectArgument).openStream());
				}

				var1.status = 1;
			} catch (ThreadDeath var6) {
				throw var6;
			} catch (Throwable var7) {
				var1.status = 2;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lll;I)I",
		garbageValue = "-428557907"
	)
	public static final int method3464(LoginType var0) {
		if (var0 == null) {
			return 12;
		} else {
			switch(var0.field4033) {
			case 7:
				return 20;
			default:
				return 12;
			}
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1906197616"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (UserComparator3.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!ArchiveDiskActionHandler.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = ArchiveDiskActionHandler.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				UserComparator3.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (class289.Widget_interfaceComponents[var0] == null) {
					class289.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (class289.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = ArchiveDiskActionHandler.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							class289.Widget_interfaceComponents[var0][var2] = new Widget();
							class289.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								class289.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								class289.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				UserComparator3.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "([BI)[B",
		garbageValue = "1618033265"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 < 0 || AbstractArchive.field3120 != 0 && var3 > AbstractArchive.field3120) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.readBytes(var4, 0, var3);
			return var4;
		} else {
			int var6 = var1.readInt();
			if (var6 >= 0 && (AbstractArchive.field3120 == 0 || var6 <= AbstractArchive.field3120)) {
				byte[] var5 = new byte[var6];
				if (var2 == 1) {
					BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
				} else {
					AbstractArchive.gzipDecompressor.decompress(var1, var5);
				}

				return var5;
			} else {
				throw new RuntimeException();
			}
		}
	}
}
