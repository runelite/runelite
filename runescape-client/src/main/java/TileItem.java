import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("st")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1727946021
	)
	public static int field1223;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1488876063
	)
	@Export("id")
	int id;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1667884647
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Ldh;",
		garbageValue = "-62237472"
	)
	@Export("getModel")
	protected final Model getModel() {
		return Occluder.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "160391262"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1159842254"
	)
	static int method2129(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return WorldMapSection2.method342(var0, var1, var2);
		} else if (var0 < 1100) {
			return Login.method2115(var0, var1, var2);
		} else if (var0 < 1200) {
			return class81.method2062(var0, var1, var2);
		} else if (var0 < 1300) {
			return FriendLoginUpdate.method5193(var0, var1, var2);
		} else if (var0 < 1400) {
			return class40.method797(var0, var1, var2);
		} else if (var0 < 1500) {
			return Tiles.method1110(var0, var1, var2);
		} else if (var0 < 1600) {
			return FontName.method5271(var0, var1, var2);
		} else if (var0 < 1700) {
			return UserComparator6.method3407(var0, var1, var2);
		} else if (var0 < 1800) {
			return VarpDefinition.method4347(var0, var1, var2);
		} else if (var0 < 1900) {
			return World.method1815(var0, var1, var2);
		} else if (var0 < 2000) {
			return ClientPacket.method3579(var0, var1, var2);
		} else if (var0 < 2100) {
			return Login.method2115(var0, var1, var2);
		} else if (var0 < 2200) {
			return class81.method2062(var0, var1, var2);
		} else if (var0 < 2300) {
			return FriendLoginUpdate.method5193(var0, var1, var2);
		} else if (var0 < 2400) {
			return class40.method797(var0, var1, var2);
		} else if (var0 < 2500) {
			return Tiles.method1110(var0, var1, var2);
		} else if (var0 < 2600) {
			return class51.method921(var0, var1, var2);
		} else if (var0 < 2700) {
			return Client.method1750(var0, var1, var2);
		} else if (var0 < 2800) {
			return UserComparator6.method3411(var0, var1, var2);
		} else if (var0 < 2900) {
			return WorldMapRegion.method506(var0, var1, var2);
		} else if (var0 < 3000) {
			return ClientPacket.method3579(var0, var1, var2);
		} else if (var0 < 3200) {
			return Messages.method2211(var0, var1, var2);
		} else if (var0 < 3300) {
			return ReflectionCheck.method2271(var0, var1, var2);
		} else if (var0 < 3400) {
			return ServerPacket.method3577(var0, var1, var2);
		} else if (var0 < 3500) {
			return PacketBuffer.method5423(var0, var1, var2);
		} else if (var0 < 3700) {
			return Buddy.method5111(var0, var1, var2);
		} else if (var0 < 4000) {
			return AbstractWorldMapData.method289(var0, var1, var2);
		} else if (var0 < 4100) {
			return WorldMapAreaData.method716(var0, var1, var2);
		} else if (var0 < 4200) {
			return WorldMapData_0.method177(var0, var1, var2);
		} else if (var0 < 4300) {
			return class222.method4090(var0, var1, var2);
		} else if (var0 < 5100) {
			return Tiles.method1156(var0, var1, var2);
		} else if (var0 < 5400) {
			return Canvas.method889(var0, var1, var2);
		} else if (var0 < 5600) {
			return WorldMapData_1.method749(var0, var1, var2);
		} else if (var0 < 5700) {
			return class222.method4089(var0, var1, var2);
		} else if (var0 < 6300) {
			return Entity.method3216(var0, var1, var2);
		} else if (var0 < 6600) {
			return class219.method4080(var0, var1, var2);
		} else {
			return var0 < 6700 ? UserComparator6.method3402(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "-1"
	)
	@Export("isCharPrintable")
	public static boolean isCharPrintable(char var0) {
		if (var0 >= ' ' && var0 <= '~') {
			return true;
		} else if (var0 >= 160 && var0 <= 255) {
			return true;
		} else {
			return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
		}
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "(Lho;IIZI)V",
		garbageValue = "97221829"
	)
	@Export("alignWidgetSize")
	static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.field2655 * var0.height / var0.field2629;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.field2629 * var0.width / var0.field2655;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.addFirst(var6);
		}

	}
}
