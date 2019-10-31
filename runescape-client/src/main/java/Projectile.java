import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -464791279
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 458201439
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -2076592615
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 623427875
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2041358603
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -10892035
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2134033129
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1813713909
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -580647449
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1691147323
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1840141045
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("p")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("h")
	@Export("x")
	double x;
	@ObfuscatedName("k")
	@Export("y")
	double y;
	@ObfuscatedName("x")
	@Export("z")
	double z;
	@ObfuscatedName("j")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("r")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("e")
	@Export("speed")
	double speed;
	@ObfuscatedName("s")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("b")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -893857759
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 915982703
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 83831929
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 324172471
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
		int var12 = MenuAction.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = PlayerType.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1390758796"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double)this.sourceX + (double)this.startHeight * var5 / var9;
			this.y = (double)this.sourceY + (double)this.startHeight * var7 / var9;
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "931373856"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += this.speedX * (double)var1;
		this.y += (double)var1 * this.speedY;
		this.z += this.accelerationZ * 0.5D * (double)var1 * (double)var1 + this.speedZ * (double)var1;
		this.speedZ += this.accelerationZ * (double)var1;
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Ldv;",
		garbageValue = "-40"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = MenuAction.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "1093152418"
	)
	public static int method2268(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if (var4 <= 127) {
				++var2;
			} else if (var4 <= 2047) {
				var2 += 2;
			} else {
				var2 += 3;
			}
		}

		return var2;
	}
}
