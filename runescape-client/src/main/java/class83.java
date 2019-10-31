import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class83 {
	@ObfuscatedName("a")
	static final BigInteger field1144;
	@ObfuscatedName("t")
	static final BigInteger field1145;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 543275717
	)
	static int field1146;

	static {
		field1144 = new BigInteger("10001", 16);
		field1145 = new BigInteger("8ffe6122bc1531a9d3909c2cefb420d9099dcda7494cf98fcd054d7eac1f32c03cc1cff0955965d35dfb6bd322c5e9201941edfa6f26cfff45524daf4c6b09c8a121f3b0262443ca7164bbad436420e7fd23d9d2b74f228f68f961563e337b95772bf046cf05bb699549141325085c55e5d44ea15e3c7f17dd6c03d521f963f7", 16);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lhq;III)[Llx;",
		garbageValue = "676628248"
	)
	@Export("SpriteBuffer_getSpriteArray")
	public static Sprite[] SpriteBuffer_getSpriteArray(AbstractArchive var0, int var1, int var2) {
		if (!class32.method618(var0, var1, var2)) {
			return null;
		} else {
			Sprite[] var4 = new Sprite[class325.SpriteBuffer_spriteCount];

			for (int var5 = 0; var5 < class325.SpriteBuffer_spriteCount; ++var5) {
				Sprite var6 = var4[var5] = new Sprite();
				var6.width = class325.SpriteBuffer_spriteWidth;
				var6.height = class325.SpriteBuffer_spriteHeight;
				var6.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[var5];
				var6.yOffset = HealthBar.SpriteBuffer_yOffsets[var5];
				var6.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[var5];
				var6.subHeight = AttackOption.SpriteBuffer_spriteHeights[var5];
				int var7 = var6.subHeight * var6.subWidth;
				byte[] var8 = class325.SpriteBuffer_pixels[var5];
				var6.pixels = new int[var7];

				for (int var9 = 0; var9 < var7; ++var9) {
					var6.pixels[var9] = class325.SpriteBuffer_spritePalette[var8[var9] & 255];
				}
			}

			WorldMapData_1.method787();
			return var4;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "13"
	)
	@Export("Messages_getNextChatID")
	static int Messages_getNextChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1903758255"
	)
	static final void method2212(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetYs[var4] + Client.rootWidgetHeights[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field842[var4] = true;
			}
		}

	}
}
