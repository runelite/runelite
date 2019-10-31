import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("le")
	@ObfuscatedGetter(
		intValue = 640967809
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;
	@ObfuscatedName("a")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("t")
	@Export("lock")
	Object lock;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1581840103
	)
	@Export("index")
	int index;
	@ObfuscatedName("q")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("v")
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
		for (; this.isRunning; ClanChat.method5367(50L)) {
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lbk;I)V",
		garbageValue = "1813919369"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			boolean var1 = var0.isMembersOnly();
			if (var1 != ItemDefinition.ItemDefinition_inMembersWorld) {
				FriendSystem.method2038();
				ItemDefinition.ItemDefinition_inMembersWorld = var1;
			}
		}

		WorldMapAreaData.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		class222.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		Decimator.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		GrandExchangeOfferUnitPriceComparator.port3 = class222.port1;
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(Lbj;IIB)V",
		garbageValue = "-6"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = PlayerType.SequenceDefinition_get(var1).field3521;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field960 = 0;
			}

			if (var3 == 2) {
				var0.field960 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || PlayerType.SequenceDefinition_get(var1).field3519 >= PlayerType.SequenceDefinition_get(var0.sequence).field3519) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field960 = 0;
			var0.field983 = var0.pathLength;
		}

	}
}
