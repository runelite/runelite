import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("TaskHandler")
public class TaskHandler implements Runnable {
	@ObfuscatedName("c")
	@Export("javaVendor")
	public static String javaVendor;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("current")
	Task current;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("i")
	@Export("thread")
	Thread thread;
	@ObfuscatedName("g")
	@Export("isClosed")
	boolean isClosed;

	public TaskHandler() {
		this.current = null;
		this.task = null;
		this.isClosed = false;
		javaVendor = "Unknown";
		class216.javaVersion = "1.6";

		try {
			javaVendor = System.getProperty("java.vendor");
			class216.javaVersion = System.getProperty("java.version");
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
		garbageValue = "-77"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIILjava/lang/Object;S)Lfw;",
		garbageValue = "-10894"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)Lfw;",
		garbageValue = "-260343907"
	)
	@Export("newSocketTask")
	public final Task newSocketTask(String var1, int var2) {
		return this.newTask(1, var2, 0, var1);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Runnable;II)Lfw;",
		garbageValue = "70274663"
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
		signature = "(Lmv;I)I",
		garbageValue = "1649958240"
	)
	public static final int method3540(LoginType var0) {
		if (var0 == null) {
			return 12;
		} else {
			switch(var0.field4037) {
			case 6:
				return 20;
			default:
				return 12;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILii;IIIZI)V",
		garbageValue = "869410445"
	)
	@Export("playMusicTrack")
	public static void playMusicTrack(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		class197.field2414 = 1;
		UserComparator5.musicTrackArchive = var1;
		class197.musicTrackGroupId = var2;
		class83.musicTrackFileId = var3;
		AttackOption.musicTrackVolume = var4;
		KeyHandler.musicTrackBoolean = var5;
		class197.field2412 = var0;
	}
}
