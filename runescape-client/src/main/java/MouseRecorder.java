import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("e")
	static int[] field588;
	@ObfuscatedName("u")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("f")
	@Export("lock")
	Object lock;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -499559501
	)
	@Export("index")
	int index;
	@ObfuscatedName("g")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("z")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("p")
	@Export("millis")
	long[] millis;

	MouseRecorder() {
		this.isRunning = true;
		this.lock = new Object();
		this.index = 0;
		this.xs = new int[500];
		this.ys = new int[500];
		this.millis = new long[500];
	}

	public void run() {
		while (this.isRunning) {
			synchronized(this.lock) {
				if (this.index < 500) {
					this.xs[this.index] = MouseHandler.MouseHandler_x;
					this.ys[this.index] = MouseHandler.MouseHandler_y;
					this.millis[this.index] = MouseHandler.MouseHandler_millis;
					++this.index;
				}
			}

			long var4 = 49L;

			try {
				Thread.sleep(var4);
			} catch (InterruptedException var7) {
			}

			try {
				Thread.sleep(1L);
			} catch (InterruptedException var6) {
			}
		}

	}

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "42"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}
