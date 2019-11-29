import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -305289079
	)
	@Export("id")
	int id;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1537056881
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -337393941
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2147267957
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -428397397
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -590668105
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -849991729
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -2024894323
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 565117017
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1041468425
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2008070407
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("x")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("o")
	@Export("x")
	double x;
	@ObfuscatedName("e")
	@Export("y")
	double y;
	@ObfuscatedName("n")
	@Export("z")
	double z;
	@ObfuscatedName("r")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("c")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("a")
	@Export("speed")
	double speed;
	@ObfuscatedName("d")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("s")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1946189475
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2107591311
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1753493809
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 339364237
	)
	@Export("frameCycle")
	int frameCycle;

	Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
		this.isMoving = false;
		this.frame = 0;
		this.frameCycle = 0;
		this.id = var1;
		this.plane = var2;
		this.sourceX = var3;
		this.sourceY = var4;
		this.sourceZ = var5;
		this.cycleStart = var6;
		this.cycleEnd = var7;
		this.slope = var8;
		this.startHeight = var9;
		this.targetIndex = var10;
		this.endHeight = var11;
		this.isMoving = false;
		int var12 = WorldMapRegion.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = GrandExchangeOfferAgeComparator.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1065266514"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = var5 * (double)this.startHeight / var9 + (double)this.sourceX;
			this.y = (double)this.sourceY + var7 * (double)this.startHeight / var9;
			this.z = (double)this.sourceZ;
		}

		var5 = (double)(this.cycleEnd + 1 - var4);
		this.speedX = ((double)var1 - this.x) / var5;
		this.speedY = ((double)var2 - this.y) / var5;
		this.speed = Math.sqrt(this.speedY * this.speedY + this.speedX * this.speedX);
		if (!this.isMoving) {
			this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
		}

		this.accelerationZ = ((double)var3 - this.z - var5 * this.speedZ) * 2.0D / (var5 * var5);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-67"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += (double)var1 * this.speedX;
		this.y += this.speedY * (double)var1;
		this.z += (double)var1 * this.accelerationZ * 0.5D * (double)var1 + (double)var1 * this.speedZ;
		this.speedZ += (double)var1 * this.accelerationZ;
		this.yaw = (int)(Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
		this.pitch = (int)(Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
		if (this.sequenceDefinition != null) {
			this.frameCycle += var1;

			while (true) {
				do {
					do {
						if (this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) {
							return;
						}

						this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
						++this.frame;
					} while(this.frame < this.sequenceDefinition.frameIds.length);

					this.frame -= this.sequenceDefinition.frameCount;
				} while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

				this.frame = 0;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Ldf;",
		garbageValue = "-174129419"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = WorldMapRegion.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-118702125"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (UserComparator9.garbageCollector == null || !UserComparator9.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						UserComparator9.garbageCollector = var2;
						GameShell.garbageCollectorLastCheckTimeMs = -1L;
						GameShell.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (UserComparator9.garbageCollector != null) {
			long var9 = TaskHandler.currentTimeMillis();
			long var3 = UserComparator9.garbageCollector.getCollectionTime();
			if (GameShell.garbageCollectorLastCollectionTime != -1L) {
				long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameShell.garbageCollectorLastCheckTimeMs;
				if (var7 != 0L) {
					var0 = (int)(100L * var5 / var7);
				}
			}

			GameShell.garbageCollectorLastCollectionTime = var3;
			GameShell.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1897306098"
	)
	static final void method2137() {
		if (Client.logoutTimer > 0) {
			class40.logOut();
		} else {
			Client.timer.method5072();
			class81.updateGameState(40);
			PcmPlayer.field1413 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}
}
