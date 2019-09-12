import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ck")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1759216915
	)
	@Export("id")
	int id;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -656126641
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 229006367
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1688926415
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -855009313
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -199015699
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 977916813
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1874398309
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 603741471
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1598395117
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1654976121
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("h")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("f")
	@Export("x")
	double x;
	@ObfuscatedName("s")
	@Export("y")
	double y;
	@ObfuscatedName("p")
	@Export("z")
	double z;
	@ObfuscatedName("e")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("i")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("q")
	@Export("speed")
	double speed;
	@ObfuscatedName("y")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("r")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -847815087
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1827260865
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liw;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 165525375
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1595170679
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
		int var12 = NetCache.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = class83.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1630557083"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var7 * var7 + var5 * var5);
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

		this.accelerationZ = 2.0D * ((double)var3 - this.z - this.speedZ * var5) / (var5 * var5);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-966935805"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += this.speedX * (double)var1;
		this.y += this.speedY * (double)var1;
		this.z += this.speedZ * (double)var1 + (double)var1 * (double)var1 * this.accelerationZ * 0.5D;
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Ldr;",
		garbageValue = "-35"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = NetCache.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
		garbageValue = "27"
	)
	@Export("loadClassFromDescriptor")
	static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
		}
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1195208829"
	)
	static void method2083() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
				GameObject.addPlayerToScene(Client.players[var1[var2]], true);
			}
		}

	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1957902455"
	)
	static boolean method2087() {
		return (Client.drawPlayerNames & 2) != 0;
	}
}
