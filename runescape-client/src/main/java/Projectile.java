import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -704302089
	)
	@Export("id")
	int id;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 373161727
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2017111693
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1525037115
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1560824427
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 396414685
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 655131925
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -673682431
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1319621727
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1718323581
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -216257617
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("b")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("o")
	@Export("x")
	double x;
	@ObfuscatedName("a")
	@Export("y")
	double y;
	@ObfuscatedName("e")
	@Export("z")
	double z;
	@ObfuscatedName("w")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("t")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("g")
	@Export("speed")
	double speed;
	@ObfuscatedName("x")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("h")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 797140937
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1677081341
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lix;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1931929967
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1977187681
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
		int var12 = InterfaceParent.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1126340593"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var7 * var7 + var5 * var5);
			this.x = (double)this.startHeight * var5 / var9 + (double)this.sourceX;
			this.y = (double)this.startHeight * var7 / var9 + (double)this.sourceY;
			this.z = (double)this.sourceZ;
		}

		var5 = (double)(this.cycleEnd + 1 - var4);
		this.speedX = ((double)var1 - this.x) / var5;
		this.speedY = ((double)var2 - this.y) / var5;
		this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
		if (!this.isMoving) {
			this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
		}

		this.accelerationZ = 2.0D * ((double)var3 - this.z - var5 * this.speedZ) / (var5 * var5);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "-22789"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += this.speedX * (double)var1;
		this.y += this.speedY * (double)var1;
		this.z += (double)var1 * (double)var1 * 0.5D * this.accelerationZ + (double)var1 * this.speedZ;
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Ldh;",
		garbageValue = "-62237472"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = InterfaceParent.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "106"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(Lho;I)Z",
		garbageValue = "-1182032943"
	)
	@Export("runCs1")
	static final boolean runCs1(Widget var0) {
		if (var0.cs1Comparisons == null) {
			return false;
		} else {
			for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
				int var2 = class216.method4015(var0, var1);
				int var3 = var0.cs1ComparisonValues[var1];
				if (var0.cs1Comparisons[var1] == 2) {
					if (var2 >= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 3) {
					if (var2 <= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 4) {
					if (var2 == var3) {
						return false;
					}
				} else if (var3 != var2) {
					return false;
				}
			}

			return true;
		}
	}
}
