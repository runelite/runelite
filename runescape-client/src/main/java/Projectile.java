import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("sj")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("friendSystem")
	public static FriendSystem friendSystem;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -101649187
	)
	@Export("id")
	int id;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1827872967
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1361221531
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1265488669
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1417484877
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1177641065
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1536269421
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1563239709
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1004662519
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 491202369
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 219402729
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("p")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("n")
	@Export("x")
	double x;
	@ObfuscatedName("u")
	@Export("y")
	double y;
	@ObfuscatedName("h")
	@Export("z")
	double z;
	@ObfuscatedName("g")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("i")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("a")
	@Export("speed")
	double speed;
	@ObfuscatedName("b")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("l")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -858077797
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1652545155
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -299919777
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1622544383
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
		int var12 = MouseHandler.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = SpotAnimationDefinition.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-251648925"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double)this.sourceX + var5 * (double)this.startHeight / var9;
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

		this.accelerationZ = ((double)var3 - this.z - var5 * this.speedZ) * 2.0D / (var5 * var5);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1296799789"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;",
		garbageValue = "480835067"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = MouseHandler.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "29577048"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitDefinition var2 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var1;
		if (var2 != null) {
			var1 = var2;
		} else {
			byte[] var7 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var2 = new VarbitDefinition();
			if (var7 != null) {
				var2.decode(new Buffer(var7));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var2, (long)var0);
			var1 = var2;
		}

		int var3 = var1.baseVar;
		int var4 = var1.startBit;
		int var5 = var1.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		return Varps.Varps_main[var3] >> var4 & var6;
	}
}
