import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2096452169
	)
	@Export("id")
	int id;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 693683503
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1526378075
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1758571809
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1551078339
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 520106141
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1629309513
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1697973671
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1762636667
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1172953683
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1892961843
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("u")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("x")
	@Export("x")
	double x;
	@ObfuscatedName("r")
	@Export("y")
	double y;
	@ObfuscatedName("v")
	@Export("z")
	double z;
	@ObfuscatedName("y")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("g")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("a")
	@Export("speed")
	double speed;
	@ObfuscatedName("j")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("t")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -2038512103
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1827021613
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lis;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 2144836423
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1364071235
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
		int var12 = MusicPatch.getSpotAnimationDefinition(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = GrandExchangeEvent.getSequenceDefinition(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2118689642"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double)this.sourceX + (double)this.startHeight * var5 / var9;
			this.y = (double)this.startHeight * var7 / var9 + (double)this.sourceY;
			this.z = (double)this.sourceZ;
		}

		var5 = (double)(this.cycleEnd + 1 - var4);
		this.speedX = ((double)var1 - this.x) / var5;
		this.speedY = ((double)var2 - this.y) / var5;
		this.speed = Math.sqrt(this.speedY * this.speedY + this.speedX * this.speedX);
		if (!this.isMoving) {
			this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
		}

		this.accelerationZ = 2.0D * ((double)var3 - this.z - var5 * this.speedZ) / (var5 * var5);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-4"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += (double)var1 * this.speedX;
		this.y += (double)var1 * this.speedY;
		this.z += (double)var1 * this.speedZ + 0.5D * this.accelerationZ * (double)var1 * (double)var1;
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ldm;",
		garbageValue = "759381421"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = MusicPatch.getSpotAnimationDefinition(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)Lio;",
		garbageValue = "0"
	)
	@Export("getHitSplatDefinition")
	public static HitSplatDefinition getHitSplatDefinition(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
