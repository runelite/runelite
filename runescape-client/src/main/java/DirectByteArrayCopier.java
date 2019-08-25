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
	static final void addPendingSpawnToScene(int plane, int type, int x, int y, int id, int orientation, int var6) {
		if (x < 1 || y < 1 || x > 102 || y > 102) {
			return;
		}
		if (Client.isLowDetail && plane != class42.plane) {
			return;
		}

		long var7 = 0L;
		boolean var9 = true;
		boolean var10 = false;
		boolean var11 = false;
		if (type == 0) {
			var7 = GrandExchangeOfferWorldComparator.scene.getBoundaryObjectTag(plane, x, y);
		}

		if (type == 1) {
			var7 = GrandExchangeOfferWorldComparator.scene.getWallDecorationTag(plane, x, y);
		}

		if (type == 2) {
			var7 = GrandExchangeOfferWorldComparator.scene.getGameObjectTag(plane, x, y);
		}

		if (type == 3) {
			var7 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(plane, x, y);
		}

		int var12;
		if (0L != var7) {
			var12 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(plane, x, y, var7);
			int var14 = class43.Entity_unpackID(var7);
			int var15 = var12 & 31;
			int var16 = var12 >> 6 & 3;
			ObjectDefinition var13;
			if (type == 0) {
				GrandExchangeOfferWorldComparator.scene.removeBoundaryObject(plane, x, y);
				var13 = ViewportMouse.getObjectDefinition(var14);
				if (var13.interactType != 0) {
					Client.collisionMaps[plane].method3564(x, y, var15, var16, var13.boolean1);
				}
			}

			if (type == 1) {
				GrandExchangeOfferWorldComparator.scene.removeWallDecoration(plane, x, y);
			}

			if (type == 2) {
				GrandExchangeOfferWorldComparator.scene.removeGameObject(plane, x, y);
				var13 = ViewportMouse.getObjectDefinition(var14);
				if (x + var13.sizeX > 103 || y + var13.sizeX > 103 || x + var13.sizeY > 103 || y + var13.sizeY > 103) {
					return;
				}

				if (var13.interactType != 0) {
					Client.collisionMaps[plane].setFlagOffNonSquare(x, y, var13.sizeX, var13.sizeY, var16, var13.boolean1);
				}
			}

			if (type == 3) {
				GrandExchangeOfferWorldComparator.scene.removeFloorDecoration(plane, x, y);
				var13 = ViewportMouse.getObjectDefinition(var14);
				if (var13.interactType == 1) {
					Client.collisionMaps[plane].method3567(x, y);
				}
			}
		}

		if (id >= 0) {
			var12 = plane;
			if (plane < 3 && (Tiles.Tiles_renderFlags[1][x][y] & 2) == 2) {
				var12 = plane + 1;
			}

			ClientPacket.addPendingGameObject(plane, var12, x, y, id, orientation, var6, GrandExchangeOfferWorldComparator.scene, Client.collisionMaps[plane]);
		}

	}
}
