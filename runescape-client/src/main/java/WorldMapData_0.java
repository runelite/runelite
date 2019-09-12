import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("WorldMapData_0")
public class WorldMapData_0 extends AbstractWorldMapData {
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive3")
	static Archive archive3;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive9")
	static Archive archive9;

	WorldMapData_0() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-1670112809"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field263.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 4096;
			super.regionYLow = var1.readUnsignedShort() * 4096;
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			super.groupId = var1.method5623();
			super.fileId = var1.method5623();
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-1969615810"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field163 = new byte[super.planes][64][64];
		super.field159 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field253.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY) {
				for (int var5 = 0; var5 < 64; ++var5) {
					for (int var6 = 0; var6 < 64; ++var6) {
						this.readTile(var5, var6, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_0)) {
			return false;
		} else {
			WorldMapData_0 var2 = (WorldMapData_0)var1;
			return super.regionX == var2.regionX && var2.regionY == super.regionY;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1591253708"
	)
	static void method157() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.obj != null) {
				var0.set();
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IB)Lbj;",
		garbageValue = "-43"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1345116753"
	)
	static final void method160(int var0, int var1) {
		if (Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) {
			if (Client.showMouseOverText) {
				int var2 = WorldMapCacheName.getNewestMenuIdx();
				String var3;
				if (Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
					var3 = "Use" + " " + Client.selectedItemName + " " + "->";
				} else if (Client.isSpellSelected && Client.menuOptionsCount < 2) {
					var3 = Client.selectedSpellActionName + " " + Client.selectedSpellName + " " + "->";
				} else {
					var3 = class188.method3620(var2);
				}

				if (Client.menuOptionsCount > 2) {
					var3 = var3 + UserComparator7.colorStartTag(16777215) + " " + '/' + " " + (Client.menuOptionsCount - 2) + " more options";
				}

				HealthBar.fontBold12.drawRandomAlphaAndSpacing(var3, var0 + 4, var1 + 15, 16777215, 0, Client.cycle / 1000);
			}
		}
	}
}
