import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -951459675
	)
	@Export("id")
	int id;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 240131071
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1747500459
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -190757363
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 120274297
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -545031319
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1504161017
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1869679465
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -905404739
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 703869729
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1300497163
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("c")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("r")
	@Export("x")
	double x;
	@ObfuscatedName("y")
	@Export("y")
	double y;
	@ObfuscatedName("p")
	@Export("z")
	double z;
	@ObfuscatedName("b")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("g")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("e")
	@Export("speed")
	double speed;
	@ObfuscatedName("z")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("a")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1352900335
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1525474155
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 2057925261
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1570641545
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
		int var12 = HealthBarUpdate.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = Widget.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-976791033"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double)this.sourceX + (double)this.startHeight * var5 / var9;
			this.y = var7 * (double)this.startHeight / var9 + (double)this.sourceY;
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "172847015"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += this.speedX * (double)var1;
		this.y += (double)var1 * this.speedY;
		this.z += (double)var1 * this.speedZ + (double)var1 * (double)var1 * this.accelerationZ * 0.5D;
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldo;",
		garbageValue = "-419920513"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = HealthBarUpdate.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1666857335"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (WorldMapDecoration.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!Widget.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = Widget.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				WorldMapDecoration.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (Widget.Widget_interfaceComponents[var0] == null) {
					Widget.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (Widget.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = Widget.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							Widget.Widget_interfaceComponents[var0][var2] = new Widget();
							Widget.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								Widget.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								Widget.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				WorldMapDecoration.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILhz;IIIZI)V",
		garbageValue = "771359751"
	)
	public static void method2040(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		class197.field2378 = 1;
		WorldMapDecoration.musicTrackArchive = var1;
		class197.musicTrackGroupId = var2;
		class197.musicTrackFileId = var3;
		WorldMapSprite.field222 = var4;
		Varcs.musicTrackBoolean = var5;
		class16.field98 = var0;
	}
}
