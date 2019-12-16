import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("pu")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;
	@ObfuscatedName("gq")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1703591311
	)
	@Export("id")
	int id;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -845014759
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -328168931
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1855488401
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 737715987
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 2134502189
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1548140981
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 880668883
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1309211807
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 293583689
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -829767875
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("o")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("v")
	@Export("x")
	double x;
	@ObfuscatedName("k")
	@Export("y")
	double y;
	@ObfuscatedName("s")
	@Export("z")
	double z;
	@ObfuscatedName("l")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("t")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("j")
	@Export("speed")
	double speed;
	@ObfuscatedName("n")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("u")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -361002303
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1134638097
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liv;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1878850511
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -321232817
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
		int var12 = ClientPacket.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = WorldMapSection0.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIIS)V",
		garbageValue = "3907"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var7 * var7 + var5 * var5);
			this.x = (double)this.sourceX + var5 * (double)this.startHeight / var9;
			this.y = var7 * (double)this.startHeight / var9 + (double)this.sourceY;
			this.z = (double)this.sourceZ;
		}

		var5 = (double)(this.cycleEnd + 1 - var4);
		this.speedX = ((double)var1 - this.x) / var5;
		this.speedY = ((double)var2 - this.y) / var5;
		this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
		if (!this.isMoving) {
			this.speedZ = -this.speed * Math.tan((double)this.slope * 0.02454369D);
		}

		this.accelerationZ = 2.0D * ((double)var3 - this.z - this.speedZ * var5) / (var5 * var5);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1141116795"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += this.speedX * (double)var1;
		this.y += this.speedY * (double)var1;
		this.z += (double)var1 * this.accelerationZ * 0.5D * (double)var1 + this.speedZ * (double)var1;
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "822221372"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = ClientPacket.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "919404016"
	)
	static final String method2129(int var0) {
		if (var0 < 100000) {
			return "<col=ffff00>" + var0 + "</col>";
		} else {
			return var0 < 10000000 ? "<col=ffffff>" + var0 / 1000 + "K" + "</col>" : "<col=00ff80>" + var0 / 1000000 + "M" + "</col>";
		}
	}
}
