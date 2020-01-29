import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Projectile")
public final class Projectile extends Entity {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 915213611
	)
	@Export("id")
	int id;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 378032649
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1585922035
	)
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1462535825
	)
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1681715111
	)
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 903870771
	)
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1250439791
	)
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1640896565
	)
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 2117578399
	)
	@Export("slope")
	int slope;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -544986491
	)
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1226806671
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("h")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("v")
	@Export("x")
	double x;
	@ObfuscatedName("n")
	@Export("y")
	double y;
	@ObfuscatedName("x")
	@Export("z")
	double z;
	@ObfuscatedName("w")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("k")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("q")
	@Export("speed")
	double speed;
	@ObfuscatedName("z")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("y")
	@Export("accelerationZ")
	double accelerationZ;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -347740869
	)
	@Export("yaw")
	int yaw;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1566997977
	)
	@Export("pitch")
	int pitch;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lip;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1565551535
	)
	@Export("frame")
	int frame;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -449479451
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
		int var12 = class65.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = GraphicsDefaults.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-8439776"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) {
			var5 = (double)(var1 - this.sourceX);
			double var7 = (double)(var2 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double)this.startHeight * var5 / var9 + (double)this.sourceX;
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

		this.accelerationZ = ((double)var3 - this.z - this.speedZ * var5) * 2.0D / (var5 * var5);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1466465553"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += (double)var1 * this.speedX;
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Ldx;",
		garbageValue = "-2133076860"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = class65.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1588389252"
	)
	public static final boolean method2160(char var0) {
		if (Character.isISOControl(var0)) {
			return false;
		} else if (ArchiveDiskAction.isAlphaNumeric(var0)) {
			return true;
		} else {
			char[] var1 = class339.field4042;

			int var2;
			char var3;
			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			var1 = class339.field4041;

			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			return false;
		}
	}

	@ObfuscatedName("ex")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2129018303"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				Username.client.method952();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field679 = 0;
				Client.field680 = 0;
				Client.timer.method5062(var0);
				if (var0 != 20) {
					UserComparator3.method3497(false);
				}
			}

			if (var0 != 20 && var0 != 40 && ClientPreferences.field1052 != null) {
				ClientPreferences.field1052.close();
				ClientPreferences.field1052 = null;
			}

			if (Client.gameState == 25) {
				Client.field695 = 0;
				Client.field791 = 0;
				Client.field884 = 1;
				Client.field700 = 0;
				Client.field733 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					ClientPacket.method3683(HealthBar.archive10, UserComparator8.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					ClientPacket.method3683(HealthBar.archive10, UserComparator8.archive8, false, 4);
				} else if (Login.field1163) {
					ScriptFrame.titleboxSprite = null;
					Login.titlebuttonSprite = null;
					class16.runesSprite = null;
					Login.leftTitleSprite = null;
					class32.rightTitleSprite = null;
					FloorDecoration.logoSprite = null;
					Login.title_muteSprite = null;
					WorldMapSprite.options_buttons_0Sprite = null;
					DirectByteArrayCopier.options_buttons_2Sprite = null;
					UserComparator6.worldSelectBackSprites = null;
					ReflectionCheck.worldSelectFlagSprites = null;
					ItemContainer.worldSelectArrows = null;
					DynamicObject.worldSelectStars = null;
					WorldMapDecorationType.field2739 = null;
					WorldMapLabelSize.loginScreenRunesAnimation.method1834();
					class197.field2414 = 1;
					UserComparator5.musicTrackArchive = null;
					class197.musicTrackGroupId = -1;
					class83.musicTrackFileId = -1;
					AttackOption.musicTrackVolume = 0;
					KeyHandler.musicTrackBoolean = false;
					class197.field2412 = 2;
					TextureProvider.method2833(true);
					Login.field1163 = false;
				}
			} else {
				ClientPacket.method3683(HealthBar.archive10, UserComparator8.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}
}
