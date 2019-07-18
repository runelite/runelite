import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("DirectByteArrayCopier")
public class DirectByteArrayCopier extends AbstractByteArrayCopier {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("gh")
	@Export("regions")
	static int[] regions;
	@ObfuscatedName("q")
	@Export("directBuffer")
	ByteBuffer directBuffer;

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "1071129091"
	)
	@Export("get")
	byte[] get() {
		byte[] var1 = new byte[this.directBuffer.capacity()];
		this.directBuffer.position(0);
		this.directBuffer.get(var1);
		return var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "594076777"
	)
	@Export("set")
	public void set(byte[] var1) {
		this.directBuffer = ByteBuffer.allocateDirect(var1.length);
		this.directBuffer.position(0);
		this.directBuffer.put(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "-960689616"
	)
	@Export("currentTimeMs")
	public static final synchronized long currentTimeMs() {
		long var0 = System.currentTimeMillis();
		if (var0 < DevicePcmPlayerProvider.field416) {
			class2.field4 += DevicePcmPlayerProvider.field416 - var0;
		}

		DevicePcmPlayerProvider.field416 = var0;
		return class2.field4 + var0;
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "1456819139"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != class42.plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = GrandExchangeOfferWorldComparator.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = GrandExchangeOfferWorldComparator.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = GrandExchangeOfferWorldComparator.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (0L != var7) {
				var12 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(var0, var2, var3, var7);
				int var14 = class43.method770(var7);
				int var15 = var12 & 31;
				int var16 = var12 >> 6 & 3;
				ObjectDefinition var13;
				if (var1 == 0) {
					GrandExchangeOfferWorldComparator.scene.removeBoundaryObject(var0, var2, var3);
					var13 = ViewportMouse.getObjectDefinition(var14);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3564(var2, var3, var15, var16, var13.boolean1);
					}
				}

				if (var1 == 1) {
					GrandExchangeOfferWorldComparator.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					GrandExchangeOfferWorldComparator.scene.method3154(var0, var2, var3);
					var13 = ViewportMouse.getObjectDefinition(var14);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3565(var2, var3, var13.sizeX, var13.sizeY, var16, var13.boolean1);
					}
				}

				if (var1 == 3) {
					GrandExchangeOfferWorldComparator.scene.removeFloorDecoration(var0, var2, var3);
					var13 = ViewportMouse.getObjectDefinition(var14);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method3567(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				ClientPacket.method3611(var0, var12, var2, var3, var4, var5, var6, GrandExchangeOfferWorldComparator.scene, Client.collisionMaps[var0]);
			}
		}

	}
}
