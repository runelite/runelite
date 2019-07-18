import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = -2050629733
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;
	@ObfuscatedName("q")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("w")
	@Export("lock")
	Object lock;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -944219323
	)
	@Export("index")
	int index;
	@ObfuscatedName("p")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("k")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("l")
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
		for (; this.isRunning; EnumDefinition.method4550(50L)) {
			synchronized(this.lock) {
				if (this.index < 500) {
					this.xs[this.index] = MouseHandler.MouseHandler_x;
					this.ys[this.index] = MouseHandler.MouseHandler_y;
					this.millis[this.index] = MouseHandler.MouseHandler_millis;
					++this.index;
				}
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "5"
	)
	@Export("WorldMapElement_clearCached")
	public static void WorldMapElement_clearCached() {
		WorldMapElement.WorldMapElement_cachedSprites.clear();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "234130562"
	)
	static final void method1138() {
		Object var10000 = null;
		String var0 = "Your friend list is full. Max of 200 for free users, and 400 for members";
		ScriptEvent.addGameMessage(30, "", var0);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1823729833"
	)
	static void method1137(int var0) {
		Login.loginIndex = 12;
		Login.field1182 = var0;
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1953240154"
	)
	static final void method1141() {
		for (int var0 = 0; var0 < Client.npcCount; ++var0) {
			int var1 = Client.npcIndices[var0];
			NPC var2 = Client.npcs[var1];
			if (var2 != null) {
				StructDefinition.calculateActorPosition(var2, var2.definition.size);
			}
		}

	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "(Lbd;IIB)V",
		garbageValue = "-124"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = GrandExchangeEvent.getSequenceDefinition(var1).field3529;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field985 = 0;
			}

			if (var3 == 2) {
				var0.field985 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || GrandExchangeEvent.getSequenceDefinition(var1).field3533 >= GrandExchangeEvent.getSequenceDefinition(var0.sequence).field3533) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field985 = 0;
			var0.field1008 = var0.pathLength;
		}

	}
}
